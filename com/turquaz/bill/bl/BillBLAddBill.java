package com.turquaz.bill.bl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.turquaz.accounting.bl.AccBLTransactionAdd;
import com.turquaz.accounting.dal.AccDALAccountAdd;
import com.turquaz.bill.dal.BillDALAddBill;
import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;

import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqBillConsignmentCommon;
import com.turquaz.engine.dal.TurqBillGroup;
import com.turquaz.engine.dal.TurqBillInGroup;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqInventoryTransaction;

import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.ui.component.DatePicker;

public class BillBLAddBill {
	BillDALAddBill dalBill = new BillDALAddBill();

	AccBLTransactionAdd blAcc = new AccBLTransactionAdd();

	Calendar cal = Calendar.getInstance();

	public BillBLAddBill() {

	}

	public TurqBill saveBill(String docNo, String definition,
			boolean isPrinted, Date billsDate, TurqConsignment cons, int type,
			boolean isOpen, Object currentAccount, Date dueDate)
			throws Exception {
		try {
			TurqBill bill = new TurqBill();
			bill.setBillsDate(billsDate);
			bill.setBillsDefinition(definition);
			bill.setBillsPrinted(isPrinted);
			bill.setBillsType(type);

			bill.setCreatedBy(System.getProperty("user"));
			bill.setUpdatedBy(System.getProperty("user"));
			bill.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			bill.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			bill.setIsOpen(isOpen);
			bill.setDueDate(dueDate);

			TurqBillConsignmentCommon common = cons
					.getTurqBillConsignmentCommon();
			common.setBillDocumentNo(docNo);

			bill.setTurqBillConsignmentCommon(common);

			TurqEngineSequence seqDocId = cons.getTurqEngineSequence();
			/*
			 * TODO Incelenmesi gerek TurqModule module = new TurqModule();
			 * module.setModulesId(new Integer(7));
			 * seqDocId.setTurqModule(module);
			 * 
			 * dalBill.save(seqDocId);
			 */
			bill.setTurqEngineSequence(seqDocId);

			dalBill.save(bill);

			saveCurrentTransaction(bill);
			saveAccountingTransaction(bill, currentAccount);

			return bill;

		} catch (Exception ex) {
			throw ex;
		}
	}

	public void saveCurrentTransaction(TurqBill bill) throws Exception {
		try {

			TurqBillConsignmentCommon common = bill
					.getTurqBillConsignmentCommon();
			CurBLCurrentTransactionAdd curBLTrans = new CurBLCurrentTransactionAdd();

			String curTransDef = DatePicker.formatter.format(bill
					.getBillsDate())
					+ " " + common.getBillDocumentNo() + " Ref. Fatura";

			//Al?? Faturas?
			if (bill.getBillsType() == 0) {
//	          TODO current trans exRate
				curBLTrans.saveCurrentTransaction(common.getTurqCurrentCard(),
						bill.getBillsDate(), common.getBillDocumentNo(), true,
						common.getTotalAmount(), common.getDiscountAmount(), 1,
						bill.getTurqEngineSequence().getId(),
						curTransDef,EngBLCommon.getBaseCurrencyExchangeRate());

				//Kapal? Fatura
				if (!bill.isIsOpen()) {
//		          TODO current trans exRate
					curBLTrans
							.saveCurrentTransaction(
									common.getTurqCurrentCard(), bill
											.getBillsDate(), common
											.getBillDocumentNo(), false, common
											.getTotalAmount(), common
											.getDiscountAmount(), 4, bill
											.getTurqEngineSequence()
											.getId(),
									curTransDef,EngBLCommon.getBaseCurrencyExchangeRate());
				}

			}

			//Sat?? Faturas?
			else if (bill.getBillsType() == 1) {
//	          TODO current trans exRate
				curBLTrans.saveCurrentTransaction(common.getTurqCurrentCard(),
						bill.getBillsDate(), common.getBillDocumentNo(), false,
						common.getTotalAmount(), common.getDiscountAmount(), 1,
						bill.getTurqEngineSequence().getId(),
						curTransDef,EngBLCommon.getBaseCurrencyExchangeRate());

				//Kapal? Fatura
				if (!bill.isIsOpen()) {
//		          TODO current trans exRate
					curBLTrans.saveCurrentTransaction(common
							.getTurqCurrentCard(), bill.getBillsDate(), common
							.getBillDocumentNo(), true,
							common.getTotalAmount(),
							common.getDiscountAmount(), 4, bill
									.getTurqEngineSequence()
									.getId(), curTransDef,EngBLCommon.getBaseCurrencyExchangeRate());
				}
			}

		} catch (Exception ex) {
			throw ex;
		}

	}

	public void saveAccountingTransaction(TurqBill bill, Object currentAccount)
			throws Exception {
		try {

			TurqBillConsignmentCommon common = bill
					.getTurqBillConsignmentCommon();
			String billDefinition = "FT "
					+ bill.getTurqBillConsignmentCommon().getBillDocumentNo()
					+ " "
					+ bill.getTurqBillConsignmentCommon().getTurqCurrentCard()
							.getCardsName();

			
			TurqAccountingAccount curAccount = CurBLCurrentCardSearch.getCurrentAccountingAccount(bill
					.getTurqBillConsignmentCommon().getTurqCurrentCard(),EngBLCommon.CURRENT_ACC_TYPE_GENERAL);
			
			
			Map VATList = new HashMap();
			Map ROWList = new HashMap();
			
			//Al?? Faturas?
			if (bill.getBillsType() == 0) {

				/**
				 * 1- Stok muhasebe kayitlarini gir. 2- Kdv muhasebe kayitlari
				 * 3- Cari Hesap kay?d? 4- ?skonto..
				 */

				AccBLTransactionAdd blAcc = new AccBLTransactionAdd();

				Integer transID = blAcc.saveAccTransaction(bill.getBillsDate(),
						common.getBillDocumentNo(), 2, 7,
						bill.getTurqEngineSequence().getId(),
						billDefinition);

				TurqAccountingTransactionColumn transRow = null;
				TurqInventoryTransaction invTrans = null;

				/**
				 * 1- stoklarin muhasebe kay?tlarini yap
				 */
				Iterator it = getInventoryTransactions(bill).iterator();

				while (it.hasNext()) {

					invTrans = (TurqInventoryTransaction) it.next();
					
					BigDecimal transRowAmount =(BigDecimal) ROWList.get(invTrans
									.getTurqInventoryCard()
									.getTurqAccountingAccountByAccountingAccountsIdBuy().getId());
					
					if(transRowAmount==null)
					{
						
						transRowAmount = new BigDecimal(0);
						
					}
					transRowAmount = transRowAmount.add(invTrans.getTransactionsTotalPrice());
					
					ROWList.put(invTrans
							.getTurqInventoryCard()
							.getTurqAccountingAccountByAccountingAccountsIdBuy().getId(),transRowAmount);
					
					

					/**
					 * 2-Kdv hesabini gir
					 */
					if (invTrans.getTransactionsVatAmount().compareTo(
							new BigDecimal(0)) == 1) {

						BigDecimal vatAmount = (BigDecimal) VATList
								.get(invTrans
										.getTurqInventoryCard()
										.getTurqAccountingAccountByAccountingAccountsIdVat().getId());

						if (vatAmount == null) {
							vatAmount = new BigDecimal(0);
						}

						vatAmount = vatAmount.add(invTrans
								.getTransactionsVatAmount());
						VATList
								.put(
										invTrans
												.getTurqInventoryCard()
												.getTurqAccountingAccountByAccountingAccountsIdVat().getId(),
										vatAmount);

					}

					/**
					 * OTV Hesabini gir.
					 */
					if (invTrans.getTransactionsVatSpecialAmount().compareTo(
							new BigDecimal(0)) == 1) {
						transRow = new TurqAccountingTransactionColumn();

						transRow
								.setTurqAccountingAccount(invTrans
										.getTurqInventoryCard()
										.getTurqAccountingAccountByAccountingAccountsIdSpecialVat());

						transRow.setCreditAmount(new BigDecimal(0));
						transRow.setDeptAmount(invTrans
								.getTransactionsVatSpecialAmount());

						//				 set Transaction Row Definition
						transRow.setTransactionDefinition("Fat."
								+ bill.getTurqBillConsignmentCommon()
										.getBillDocumentNo()
								+ " "
								+ DatePicker.formatter.format(bill
										.getBillsDate()));
						transRow.setCreatedBy(System.getProperty("user"));
						transRow.setUpdatedBy(System.getProperty("user"));
						transRow.setLastModified(new java.sql.Date(cal
								.getTime().getTime()));
						transRow.setCreationDate(new java.sql.Date(cal
								.getTime().getTime()));
//						TODO acc trans column exRate
						blAcc.saveAccTransactionRow(transRow, transID,
								EngBLCommon.getBaseCurrencyExchangeRate());
					}

				}
				
				/***
				 * 1-Stok Muhasebe kay?tlar?
				 * 
				 */
				
				Iterator rowIt = ROWList.keySet().iterator();
				while(rowIt.hasNext())
				{
					transRow = new TurqAccountingTransactionColumn();
					
								Integer rowId = (Integer)rowIt.next();
								TurqAccountingAccount account = new TurqAccountingAccount();
								account.setId(rowId);
								transRow
										.setTurqAccountingAccount(account);

								transRow.setCreditAmount(new BigDecimal(0));

								//mal bedeli
								transRow
										.setDeptAmount((BigDecimal)ROWList.get(rowId));

								// set Transaction Row Definition
								transRow.setTransactionDefinition(billDefinition);

								transRow.setCreatedBy(System.getProperty("user"));
								transRow.setUpdatedBy(System.getProperty("user"));
								transRow.setLastModified(new java.sql.Date(cal.getTime()
										.getTime()));
								transRow.setCreationDate(new java.sql.Date(cal.getTime()
										.getTime()));
//								TODO acc trans column exRate
								blAcc.saveAccTransactionRow(transRow, transID, EngBLCommon
										.getBaseCurrencyExchangeRate());
				}
				
				
				/**
				 * 
				 * 2-KDV
				 *  
				 */
				Iterator vatIt = VATList.keySet().iterator();
				while (vatIt.hasNext()) {

					transRow = new TurqAccountingTransactionColumn();

					Integer accountId = (Integer)vatIt.next();
					TurqAccountingAccount account = new TurqAccountingAccount();
					account.setId(accountId);
					transRow.setTurqAccountingAccount(account);

					transRow.setCreditAmount(new BigDecimal(0));
					transRow.setDeptAmount((BigDecimal) VATList.get(accountId));

					//					 set Transaction Row Definition
					transRow.setTransactionDefinition("Fat."
							+ bill.getTurqBillConsignmentCommon()
									.getBillDocumentNo() + " "
							+ DatePicker.formatter.format(bill.getBillsDate()));

					transRow.setCreatedBy(System.getProperty("user"));
					transRow.setUpdatedBy(System.getProperty("user"));
					transRow.setLastModified(new java.sql.Date(cal.getTime()
							.getTime()));
					transRow.setCreationDate(new java.sql.Date(cal.getTime()
							.getTime()));
//					TODO acc trans column exRate
					blAcc.saveAccTransactionRow(transRow, transID, EngBLCommon
							.getBaseCurrencyExchangeRate());

				}

				/**
				 * 3-Cari Kayd?n? Yap
				 * 
				 *  
				 */

				
				transRow = new TurqAccountingTransactionColumn();

				
				transRow.setTurqAccountingAccount(curAccount);

				transRow.setCreditAmount(common.getTotalAmount());
				transRow.setDeptAmount(new BigDecimal(0));

				//			 set Transaction Row Definition
				transRow.setTransactionDefinition(billDefinition);

				transRow.setCreatedBy(System.getProperty("user"));
				transRow.setUpdatedBy(System.getProperty("user"));
				transRow.setLastModified(new java.sql.Date(cal.getTime()
						.getTime()));
				transRow.setCreationDate(new java.sql.Date(cal.getTime()
						.getTime()));
//				TODO acc trans column exRate
				blAcc.saveAccTransactionRow(transRow, transID, EngBLCommon
						.getBaseCurrencyExchangeRate());

				/**
				 * 4- iskontoyu save et
				 */

				transRow = new TurqAccountingTransactionColumn();

				transRow.setTurqAccountingAccount(AccDALAccountAdd
						.getAccount("649"));

				transRow.setCreditAmount(common.getDiscountAmount());
				transRow.setDeptAmount(new BigDecimal(0));

				//			 set Transaction Row Definition
				transRow.setTransactionDefinition(billDefinition);

				transRow.setCreatedBy(System.getProperty("user"));
				transRow.setUpdatedBy(System.getProperty("user"));
				transRow.setLastModified(new java.sql.Date(cal.getTime()
						.getTime()));
				transRow.setCreationDate(new java.sql.Date(cal.getTime()
						.getTime()));
//				TODO acc trans column exRate
				blAcc.saveAccTransactionRow(transRow, transID, EngBLCommon
						.getBaseCurrencyExchangeRate());

				//Kapal? Fatura
				/**
				 * 1 -Cari Muhasebe hareketi isle 2- Kasa Muhasebe hareketi isle
				 */
				if (!bill.isIsOpen()) {
					transID = blAcc.saveAccTransaction(bill.getBillsDate(),
							common.getBillDocumentNo(), 1, 7, bill
									.getTurqEngineSequence()
									.getId(), billDefinition);

					/**
					 * 1-Cari Muhasebe Satiri
					 */

					transRow = new TurqAccountingTransactionColumn();

					transRow.setTurqAccountingAccount(curAccount);

					transRow.setCreditAmount(new BigDecimal(0));
					transRow.setDeptAmount(invTrans
							.getTransactionsCumilativePrice());

					//				 set Transaction Row Definition
					transRow.setTransactionDefinition(billDefinition);

					transRow.setCreatedBy(System.getProperty("user"));
					transRow.setUpdatedBy(System.getProperty("user"));
					transRow.setLastModified(new java.sql.Date(cal.getTime()
							.getTime()));
					transRow.setCreationDate(new java.sql.Date(cal.getTime()
							.getTime()));
//					TODO acc trans column exRate
					blAcc.saveAccTransactionRow(transRow, transID, EngBLCommon
							.getBaseCurrencyExchangeRate());

					/**
					 * 2- Kasa Muhasebe Hareketi
					 */
					transRow = new TurqAccountingTransactionColumn();

					transRow
							.setTurqAccountingAccount((TurqAccountingAccount) currentAccount);

					transRow.setCreditAmount(invTrans
							.getTransactionsCumilativePrice());
					transRow.setDeptAmount(new BigDecimal(0));

					//					 set Transaction Row Definition
					transRow.setTransactionDefinition(billDefinition);

					transRow.setCreatedBy(System.getProperty("user"));
					transRow.setUpdatedBy(System.getProperty("user"));
					transRow.setLastModified(new java.sql.Date(cal.getTime()
							.getTime()));
					transRow.setCreationDate(new java.sql.Date(cal.getTime()
							.getTime()));
//					TODO acc trans column exRate
					blAcc.saveAccTransactionRow(transRow, transID, EngBLCommon
							.getBaseCurrencyExchangeRate());

				}
			}

			//Sat?? Faturas?
			else if (bill.getBillsType() == 1) {

				/**
				 * 1- Stok muhasebe kayitlarini gir. 2- Kdv muhasebe kayitlari
				 * 3- Ötv muhasebe kayitlari 4- Cari Hesap kay?d? 5- iskonto
				 * kaydi
				 */

				AccBLTransactionAdd blAcc = new AccBLTransactionAdd();

				Integer transID = blAcc.saveAccTransaction(bill.getBillsDate(),
						common.getBillDocumentNo(), 2, 7,
						bill.getTurqEngineSequence().getId(),
						"FT "
								+ bill.getTurqBillConsignmentCommon()
										.getBillDocumentNo()
								+ " "
								+ bill.getTurqBillConsignmentCommon()
										.getTurqCurrentCard().getCardsName());

				TurqAccountingTransactionColumn transRow = null;
				TurqInventoryTransaction invTrans = null;

				/**
				 * 1- stoklarin muhasebe kay?tlarini yap
				 */
				Iterator it = getInventoryTransactions(bill).iterator();

				while (it.hasNext()) {

					invTrans = (TurqInventoryTransaction) it.next();
					
					BigDecimal transRowAmount =(BigDecimal) ROWList.get(invTrans
							.getTurqInventoryCard()
							.getTurqAccountingAccountByAccountingAccountsIdSell().getId());
			
			if(transRowAmount==null)
			{
				
				transRowAmount = new BigDecimal(0);
				
			}
			transRowAmount = transRowAmount.add(invTrans.getTransactionsTotalPrice());
			
			ROWList.put(invTrans
					.getTurqInventoryCard()
					.getTurqAccountingAccountByAccountingAccountsIdSell().getId(),transRowAmount);
			
					
					/**
					 * 2-Kdv hesabini gir
					 */
					if (invTrans.getTransactionsVatAmount().compareTo(
							new BigDecimal(0)) == 1) {
						BigDecimal vatAmount = (BigDecimal) VATList
								.get(invTrans
										.getTurqInventoryCard()
										.getTurqAccountingAccountByAccountingAccountsIdVatSell().getId());

						if (vatAmount == null) {
							vatAmount = new BigDecimal(0);
						}

						vatAmount = vatAmount.add(invTrans
								.getTransactionsVatAmount());
						VATList
								.put(
										invTrans
												.getTurqInventoryCard()
												.getTurqAccountingAccountByAccountingAccountsIdVatSell().getId(),
										vatAmount);

					}

					/**
					 * 3- Ötv hesabini gir
					 */
					if (invTrans.getTransactionsVatSpecialAmount().compareTo(
							new BigDecimal(0)) == 1) {
						transRow = new TurqAccountingTransactionColumn();

						//360 olarak degistir
						transRow
								.setTurqAccountingAccount(invTrans
										.getTurqInventoryCard()
										.getTurqAccountingAccountByAccountingAccountsIdSpecialVatSell());

						transRow.setCreditAmount(invTrans
								.getTransactionsVatSpecialAmount());
						transRow.setDeptAmount(new BigDecimal(0));

						//				 set Transaction Row Definition
						transRow.setTransactionDefinition("FT "
								+ bill.getTurqBillConsignmentCommon()
										.getBillDocumentNo()
								+ " "
								+ bill.getTurqBillConsignmentCommon()
										.getTurqCurrentCard().getCardsName());

						transRow.setCreatedBy(System.getProperty("user"));
						transRow.setUpdatedBy(System.getProperty("user"));
						transRow.setLastModified(new java.sql.Date(cal
								.getTime().getTime()));
						transRow.setCreationDate(new java.sql.Date(cal
								.getTime().getTime()));
//						TODO acc trans column exRate
						blAcc.saveAccTransactionRow(transRow, transID,
								EngBLCommon.getBaseCurrencyExchangeRate());
					}
				}
				/***
				 * 1-Stok Muhasebe kay?tlar?
				 * 
				 */
				
				Iterator rowIt = ROWList.keySet().iterator();
				while(rowIt.hasNext())
				{
					transRow = new TurqAccountingTransactionColumn();
					
								Integer rowId = (Integer)rowIt.next();
								TurqAccountingAccount account = new TurqAccountingAccount();
								account.setId(rowId);
								transRow
										.setTurqAccountingAccount(account);

								transRow.setCreditAmount((BigDecimal)ROWList.get(rowId));
								transRow.setDeptAmount(new BigDecimal(0));

								//			 set Transaction Row Definition
								transRow.setTransactionDefinition("FT "
										+ bill.getTurqBillConsignmentCommon()
												.getBillDocumentNo()
										+ " "
										+ bill.getTurqBillConsignmentCommon()
												.getTurqCurrentCard().getCardsName());

								transRow.setCreatedBy(System.getProperty("user"));
								transRow.setUpdatedBy(System.getProperty("user"));
								transRow.setLastModified(new java.sql.Date(cal.getTime()
										.getTime()));
								transRow.setCreationDate(new java.sql.Date(cal.getTime()
										.getTime()));
//								TODO acc trans column exRate
								blAcc.saveAccTransactionRow(transRow, transID, EngBLCommon
										.getBaseCurrencyExchangeRate());
				}

				/**
				 * 
				 * 2-KDV
				 *  
				 */
				Iterator vatIt = VATList.keySet().iterator();
				while (vatIt.hasNext()) {
                     
					Integer accountId = (Integer)vatIt.next();
					TurqAccountingAccount account = new TurqAccountingAccount();
					account.setId(accountId);
					transRow.setTurqAccountingAccount(account);
					
					transRow.setCreditAmount((BigDecimal) VATList.get(accountId));
					transRow.setDeptAmount(new BigDecimal(0));

					//					 set Transaction Row Definition
					transRow.setTransactionDefinition("Fat."
							+ bill.getTurqBillConsignmentCommon()
									.getBillDocumentNo() + " "
							+ DatePicker.formatter.format(bill.getBillsDate()));

					transRow.setCreatedBy(System.getProperty("user"));
					transRow.setUpdatedBy(System.getProperty("user"));
					transRow.setLastModified(new java.sql.Date(cal.getTime()
							.getTime()));
					transRow.setCreationDate(new java.sql.Date(cal.getTime()
							.getTime()));
//					TODO acc trans column exRate
					blAcc.saveAccTransactionRow(transRow, transID, EngBLCommon
							.getBaseCurrencyExchangeRate());

				}

				/**
				 * 4- Cari Kayd?n? Yap
				 * 
				 *  
				 */
				transRow = new TurqAccountingTransactionColumn();

				transRow.setTurqAccountingAccount(curAccount);

				transRow.setCreditAmount(new BigDecimal(0));
				transRow.setDeptAmount(common.getTotalAmount());

				//			 set Transaction Row Definition
				transRow.setTransactionDefinition("FT "
						+ bill.getTurqBillConsignmentCommon()
								.getBillDocumentNo()
						+ " "
						+ bill.getTurqBillConsignmentCommon()
								.getTurqCurrentCard().getCardsName());

				transRow.setCreatedBy(System.getProperty("user"));
				transRow.setUpdatedBy(System.getProperty("user"));
				transRow.setLastModified(new java.sql.Date(cal.getTime()
						.getTime()));
				transRow.setCreationDate(new java.sql.Date(cal.getTime()
						.getTime()));
//				TODO acc trans column exRate
				blAcc.saveAccTransactionRow(transRow, transID, EngBLCommon
						.getBaseCurrencyExchangeRate());

				/**
				 * 5- iskonto Kayd?
				 */
				transRow = new TurqAccountingTransactionColumn();

				transRow.setTurqAccountingAccount(AccDALAccountAdd
						.getAccount("611"));

				transRow.setCreditAmount(new BigDecimal(0));
				transRow.setDeptAmount(common.getDiscountAmount());

				//			 set Transaction Row Definition
				transRow.setTransactionDefinition("FT "
						+ bill.getTurqBillConsignmentCommon()
								.getBillDocumentNo()
						+ " "
						+ bill.getTurqBillConsignmentCommon()
								.getTurqCurrentCard().getCardsName());

				transRow.setCreatedBy(System.getProperty("user"));
				transRow.setUpdatedBy(System.getProperty("user"));
				transRow.setLastModified(new java.sql.Date(cal.getTime()
						.getTime()));
				transRow.setCreationDate(new java.sql.Date(cal.getTime()
						.getTime()));
//				TODO acc trans column exRate
				blAcc.saveAccTransactionRow(transRow, transID, EngBLCommon
						.getBaseCurrencyExchangeRate());

				//Kapal? Fatura
				/**
				 * 1 -Cari Muhasebe hareketi isle 2- Kasa Muhasebe hareketi isle
				 */
				if (!bill.isIsOpen()) {
					transID = blAcc.saveAccTransaction(bill.getBillsDate(),
							common.getBillDocumentNo(), 0, 7, bill
									.getTurqEngineSequence()
									.getId(), billDefinition);

					/**
					 * 1-Cari Muhasebe Satiri
					 */

					transRow = new TurqAccountingTransactionColumn();

					transRow.setTurqAccountingAccount(curAccount);

					transRow.setCreditAmount(invTrans
							.getTransactionsCumilativePrice());
					transRow.setDeptAmount(new BigDecimal(0));

					//				 set Transaction Row Definition
					transRow.setTransactionDefinition(billDefinition);

					transRow.setCreatedBy(System.getProperty("user"));
					transRow.setUpdatedBy(System.getProperty("user"));
					transRow.setLastModified(new java.sql.Date(cal.getTime()
							.getTime()));
					transRow.setCreationDate(new java.sql.Date(cal.getTime()
							.getTime()));
//					TODO acc trans column exRate
					blAcc.saveAccTransactionRow(transRow, transID, EngBLCommon
							.getBaseCurrencyExchangeRate());

					/**
					 * 2- Kasa Muhasebe Hareketi
					 */
					transRow = new TurqAccountingTransactionColumn();

					transRow
							.setTurqAccountingAccount((TurqAccountingAccount) currentAccount);

					transRow.setCreditAmount(new BigDecimal(0));
					transRow.setDeptAmount(invTrans
							.getTransactionsCumilativePrice());

					//					 set Transaction Row Definition
					transRow.setTransactionDefinition(billDefinition);

					transRow.setCreatedBy(System.getProperty("user"));
					transRow.setUpdatedBy(System.getProperty("user"));
					transRow.setLastModified(new java.sql.Date(cal.getTime()
							.getTime()));
					transRow.setCreationDate(new java.sql.Date(cal.getTime()
							.getTime()));
//					TODO acc trans column exRate
					blAcc.saveAccTransactionRow(transRow, transID, EngBLCommon
							.getBaseCurrencyExchangeRate());

				}

			}

		} catch (Exception ex) {
			throw ex;
		}

	}

	public void registerGroup(TurqBillGroup grp, Integer conId)
			throws Exception {
		try {
			TurqBillInGroup cardGroup = new TurqBillInGroup();
			TurqBill card = new TurqBill();
			card.setId(conId);
			cardGroup.setTurqBill(card);
			cardGroup.setTurqBillGroup(grp);

			cardGroup.setCreatedBy(System.getProperty("user"));
			cardGroup.setUpdatedBy(System.getProperty("user"));
			cardGroup
					.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			cardGroup
					.setCreationDate(new java.sql.Date(cal.getTime().getTime()));

			dalBill.save(cardGroup);

		} catch (Exception ex) {
			throw ex;
		}

	}

	public Set getInventoryTransactions(TurqBill bill) throws Exception {
		try {

			return dalBill.getInvTransactions(bill);

		} catch (Exception ex) {
			throw ex;
		}
	}

}