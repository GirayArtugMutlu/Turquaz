package com.turquaz.current.ui;

/************************************************************************/
/* TURQUAZ: Higly Modular Accounting/ERP Program                        */
/* ============================================                         */
/* Copyright (c) 2004 by Turquaz Software Development Group			    */
/*																		*/
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or    */
/* (at your option) any later version.       							*/
/* 																		*/
/* This program is distributed in the hope that it will be useful,		*/
/* but WITHOUT ANY WARRANTY; without even the implied warranty of		*/
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the		*/
/* GNU General Public License for more details.         				*/
/************************************************************************/
/**
 * @author  Onsel Armagan
 * @version  $Id$
 */
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import com.turquaz.accounting.ui.comp.AccountPickerLeaf;
import com.turquaz.current.CurKeys;
import com.turquaz.current.Messages;
import com.turquaz.current.bl.CurBLCurrentCardAdd;
import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.current.bl.CurBLCurrentCardUpdate;
import com.turquaz.current.ui.CurUICurrentCardAdd;
import org.eclipse.swt.layout.GridData;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLHibernateComparer;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.dal.TurqCurrentAccountingAccount;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentCardsGroup;
import com.turquaz.engine.dal.TurqCurrentCardsPhone;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import com.turquaz.engine.dal.TurqCurrentContact;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.cloudgarden.resource.SWTResourceManager;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class CurUICurrentCardUpdate extends org.eclipse.swt.widgets.Dialog
{
	private CurUICurrentCardAdd compCurCardAdd;
	private TableColumn tableColumnBalanceDept;
	private TableColumn tableColumnBalanceCredit;
	private TableColumn tableColumnTotalDept;
	private TableColumn tableColumnTotalCredit;
	private TableColumn tableColumnTransactionType;
	private Table tableCurrentBalances;
	private Composite composite1;
	private CTabItem cTabItem2;
	private CTabItem cTabItem1;
	private CTabFolder cTabFolder1;
	private Shell dialogShell;
	private TurqCurrentCard currentCard;
	private ToolItem toolCancel;
	private ToolItem toolDelete;
	private ToolItem toolUpdate;
	private ToolBar toolBarTop;
	private TurqCurrentContact curContact = null;
	private boolean updated = false;

	public CurUICurrentCardUpdate(Shell parent, int style, TurqCurrentCard curCard)
	{
		super(parent, style);
		currentCard = curCard;
	}

	/**
	 * Opens the Dialog Shell. Auto-generated code - any changes you make will disappear.
	 */
	public boolean open()
	{
		try
		{
			preInitGUI();
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL | SWT.RESIZE | SWT.MAX);
			{
				//Register as a resource user - SWTResourceManager will
				//handle the obtaining and disposing of resources
				SWTResourceManager.registerResourceUser(dialogShell);
			}
			dialogShell.setText(Messages.getString("CurUICurrentCardUpdate.1")); //$NON-NLS-1$
			{
				toolBarTop = new ToolBar(dialogShell, SWT.NONE);
				GridData toolBarTopLData = new GridData();
				toolBarTopLData.horizontalAlignment = GridData.FILL;
				toolBarTopLData.grabExcessHorizontalSpace = true;
				toolBarTop.setLayoutData(toolBarTopLData);
				{
					toolUpdate = new ToolItem(toolBarTop, SWT.NONE);
					toolUpdate.setEnabled(true);
					toolUpdate.setText(Messages.getString("CurUICurrentCardUpdate.0")); //$NON-NLS-1$
					toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif")); //$NON-NLS-1$
					toolUpdate.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							toolUpdateWidgetSelected(evt);
						}
					});
				}
				{
					toolDelete = new ToolItem(toolBarTop, SWT.NONE);
					toolDelete.setEnabled(true);
					toolDelete.setText(Messages.getString("CurUICurrentCardUpdate.16")); //$NON-NLS-1$
					toolDelete.setImage(SWTResourceManager.getImage("icons/Delete16.gif")); //$NON-NLS-1$
					toolDelete.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							toolDeleteWidgetSelected(evt);
						}
					});
				}
				{
					toolCancel = new ToolItem(toolBarTop, SWT.NONE);
					toolCancel.setText(Messages.getString("CurUICurrentCardUpdate.19")); //$NON-NLS-1$
					toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg")); //$NON-NLS-1$
					toolCancel.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							dialogShell.close();
						}
					});
				}
			}
			cTabFolder1 = new CTabFolder(dialogShell, SWT.NULL);
			cTabItem1 = new CTabItem(cTabFolder1, SWT.NULL);
			compCurCardAdd = new CurUICurrentCardAdd(cTabFolder1, SWT.NULL);
			cTabItem2 = new CTabItem(cTabFolder1, SWT.NULL);
			tableCurrentBalances = new Table(cTabFolder1, SWT.NULL);
			tableColumnTransactionType = new TableColumn(tableCurrentBalances, SWT.NULL);
			tableColumnTotalCredit = new TableColumn(tableCurrentBalances, SWT.NULL);
			tableColumnTotalDept = new TableColumn(tableCurrentBalances, SWT.NULL);
			tableColumnBalanceCredit = new TableColumn(tableCurrentBalances, SWT.NULL);
			tableColumnBalanceDept = new TableColumn(tableCurrentBalances, SWT.NULL);
			dialogShell.setSize(736, 509);
			GridData cTabFolder1LData = new GridData();
			cTabFolder1LData.verticalAlignment = GridData.FILL;
			cTabFolder1LData.horizontalAlignment = GridData.FILL;
			cTabFolder1LData.widthHint = -1;
			cTabFolder1LData.heightHint = -1;
			cTabFolder1LData.horizontalIndent = 0;
			cTabFolder1LData.horizontalSpan = 1;
			cTabFolder1LData.verticalSpan = 1;
			cTabFolder1LData.grabExcessHorizontalSpace = true;
			cTabFolder1LData.grabExcessVerticalSpace = true;
			cTabFolder1.setLayoutData(cTabFolder1LData);
			cTabFolder1.setSize(new org.eclipse.swt.graphics.Point(678, 381));
			cTabItem1.setControl(compCurCardAdd);
			cTabItem1.setText(Messages.getString("CurUICurrentCardUpdate.2")); //$NON-NLS-1$
			compCurCardAdd.setSize(new org.eclipse.swt.graphics.Point(586, 374));
			compCurCardAdd.setEnabled(true);
			compCurCardAdd.layout();
			cTabItem2.setControl(tableCurrentBalances);
			cTabItem2.setText(Messages.getString("CurUICurrentCardUpdate.3")); //$NON-NLS-1$
			tableCurrentBalances.setHeaderVisible(true);
			tableCurrentBalances.setLinesVisible(true);
			tableCurrentBalances.setSize(new org.eclipse.swt.graphics.Point(662, 365));
			tableColumnTransactionType.setText(Messages.getString("CurUICurrentCardUpdate.4")); //$NON-NLS-1$
			tableColumnTransactionType.setWidth(100);
			tableColumnTotalCredit.setText(Messages.getString("CurUICurrentCardUpdate.5")); //$NON-NLS-1$
			tableColumnTotalCredit.setWidth(100);
			tableColumnTotalDept.setText(Messages.getString("CurUICurrentCardUpdate.6")); //$NON-NLS-1$
			tableColumnTotalDept.setWidth(127);
			tableColumnBalanceCredit.setText(Messages.getString("CurUICurrentCardUpdate.7")); //$NON-NLS-1$
			tableColumnBalanceCredit.setWidth(137);
			tableColumnBalanceDept.setText(Messages.getString("CurUICurrentCardUpdate.8")); //$NON-NLS-1$
			tableColumnBalanceDept.setWidth(133);
			cTabFolder1.setSelection(0);
			GridLayout dialogShellLayout = new GridLayout(1, true);
			dialogShell.setLayout(dialogShellLayout);
			dialogShellLayout.marginWidth = 5;
			dialogShellLayout.marginHeight = 5;
			dialogShellLayout.numColumns = 1;
			dialogShellLayout.makeColumnsEqualWidth = true;
			dialogShellLayout.horizontalSpacing = 5;
			dialogShellLayout.verticalSpacing = 5;
			dialogShell.layout();
			postInitGUI();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed())
			{
				if (!display.readAndDispatch())
					display.sleep();
			}
			return updated;
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getParent());
			return true;
		}
	}

	/** Add your pre-init code in here */
	public void preInitGUI()
	{
	}

	/** Add your post-init code in here */
	public void postInitGUI()
	{
		try
		{
			EngUICommon.centreWindow(dialogShell);
			toolUpdate.setEnabled(false);
			toolDelete.setEnabled(false);
			if (EngBLPermissions.getPermission(compCurCardAdd.getClass().getName()) == 2)
			{
				toolUpdate.setEnabled(true);
			}
			else if (EngBLPermissions.getPermission(compCurCardAdd.getClass().getName()) == 3)
			{
				toolDelete.setEnabled(true);
				toolUpdate.setEnabled(true);
			}
			compCurCardAdd.getTxtCurrentCode().setText(currentCard.getCardsCurrentCode());
			compCurCardAdd.getTxtCurrentName().setText(currentCard.getCardsName());
			compCurCardAdd.getTxtCardDefinition().setText(currentCard.getCardsDefinition());
			compCurCardAdd.getTxtTaxDepartmant().setText(currentCard.getCardsTaxDepartment());
			compCurCardAdd.getNumTextDiscountRate().setBigDecimalValue(currentCard.getCardsDiscountRate());
			compCurCardAdd.getDecTxtRiskLimit().setText(currentCard.getCardsRiskLimit());
			compCurCardAdd.getTxtTaxNumber().setText(currentCard.getCardsTaxNumber());
			compCurCardAdd.getDecTxtCreditLimit().setText(currentCard.getCardsCreditLimit());
			compCurCardAdd.getDecTxtDiscountAmount().setText(currentCard.getCardsDiscountPayment());
			compCurCardAdd.getTxtCardAddress().setText(currentCard.getCardsAddress());
			compCurCardAdd.getNumDueDays().setText(currentCard.getDaysToValue());
			/** ********************************************************* */
			Iterator it = currentCard.getTurqCurrentContacts().iterator();
			if (it.hasNext())
			{
				TurqCurrentContact curContact = (TurqCurrentContact) it.next();
				compCurCardAdd.getTxtContactWebSite().setText(curContact.getContactsWebSite());
				compCurCardAdd.getTxtContactName().setText(curContact.getContactsName());
				compCurCardAdd.getTxtContactAddress().setText(curContact.getContactAddress());
				compCurCardAdd.getTxtContactEmail().setText(curContact.getContactsEmail());
				compCurCardAdd.getTxtFaxNumber().setText(curContact.getContactsFaxNumber());
				compCurCardAdd.getTxtContactPhone().setText(curContact.getContactsPhone1());
				compCurCardAdd.getTxtContactPhone2().setText(curContact.getContactsPhone2());
			}
			/** ************************************************ */
			
			List phoneList = new ArrayList(currentCard.getTurqCurrentCardsPhones()); 
			EngBLHibernateComparer comp = new EngBLHibernateComparer();
			Collections.sort(phoneList,comp);
			it = phoneList.iterator();
			int phones = 0;
			while (it.hasNext())
			{
				TurqCurrentCardsPhone currentPhone = (TurqCurrentCardsPhone) it.next();
				if (phones == 0)
				{
					phones++;
					compCurCardAdd.getNumTxtNumber().setText(currentPhone.getPhonesNumber());
					compCurCardAdd.getNumTxtCityCode().setText(currentPhone.getPhonesCityCode());
					compCurCardAdd.getNumtxtCountryCode().setText(currentPhone.getPhonesCountryCode());
				}
				else if (phones == 1)
				{
					compCurCardAdd.getNumTxtNumber2().setText(currentPhone.getPhonesNumber());
					compCurCardAdd.getNumTxtCityCode2().setText(currentPhone.getPhonesCityCode());
					compCurCardAdd.getNumTxtCountryCode2().setText(currentPhone.getPhonesCountryCode());
					break;
				}
			}
			it = currentCard.getTurqCurrentAccountingAccounts().iterator();
			Map fieldMap = compCurCardAdd.getAccountingFields();
			while (it.hasNext())
			{
				TurqCurrentAccountingAccount curAccount = (TurqCurrentAccountingAccount) it.next();
				Integer type = (Integer) curAccount.getTurqCurrentAccountingType().getId();
				AccountPickerLeaf picker = (AccountPickerLeaf) fieldMap.get(type);
				picker.setData(curAccount.getTurqAccountingAccount());
			}
			it = currentCard.getTurqCurrentCardsGroups().iterator();
			while (it.hasNext())
			{
				TurqCurrentCardsGroup currentCardGroup = (TurqCurrentCardsGroup) it.next();
				compCurCardAdd.getCompRegisterGroup().RegisterGroup(currentCardGroup.getTurqCurrentGroup());
			}
			fillCurrentGroups();
			fillCurrentBalances();
			compCurCardAdd.getBtnUpdateGroups().setEnabled(false);
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}

	public void fillCurrentGroups()
	{
		Iterator it = currentCard.getTurqCurrentCardsGroups().iterator();
		while (it.hasNext())
		{
			TurqCurrentCardsGroup cardsGroup = (TurqCurrentCardsGroup) it.next();
			compCurCardAdd.getCompRegisterGroup().RegisterGroup(cardsGroup.getTurqCurrentGroup());
		}
	}

	public void fillCurrentBalances() throws Exception
	{
		try
		{
			TableItem item;
			String type[] = new String[5];
			type[0] = Messages.getString("CurUICurrentCardUpdate.10"); //$NON-NLS-1$
			type[1] = Messages.getString("CurUICurrentCardUpdate.11"); //$NON-NLS-1$
			type[2] = Messages.getString("CurUICurrentCardUpdate.12"); //$NON-NLS-1$
			type[3] = Messages.getString("CurUICurrentCardUpdate.13"); //$NON-NLS-1$
			type[4] = Messages.getString("CurUICurrentCardUpdate.14"); //$NON-NLS-1$
			BigDecimal totalCredit = new BigDecimal(0);
			BigDecimal totalDept = new BigDecimal(0);
			for (int i = 1; i < 6; i++)
			{
				
				HashMap argMap = new HashMap();
				argMap.put(EngKeys.CURRENT_CARD,currentCard);
				argMap.put(EngKeys.TYPE,new Integer(i));
				
				List balanceList = (List)EngTXCommon.doSelectTX(CurBLCurrentCardUpdate.class.getName(),"getCurrentTransactionBalances",argMap);
				
				Object sums[] =(Object[]) balanceList.get(0);
				
				item = new TableItem(tableCurrentBalances, SWT.NULL);
				BigDecimal credit;
				BigDecimal debt;
				if (sums[0] != null)
				{
					credit = (BigDecimal) sums[1];
					debt = (BigDecimal) sums[0];
					totalCredit = totalCredit.add(credit);
					totalDept = totalDept.add(debt);
					if (credit.compareTo(debt) == 1)
					{
						item.setText(new String[]{type[i - 1], credit.toString(), debt.toString(), credit.subtract(debt).toString(),
								"0"}); //$NON-NLS-1$
					}
					else
					{
						item.setText(new String[]{type[i - 1], credit.toString(), debt.toString(),
								"0", debt.subtract(credit).toString()}); //$NON-NLS-1$
					}
				}
				else
				{
					item.setText(new String[]{type[i - 1], "0", "0", "0", "0"}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				}
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	/** Auto-generated main method */
	/** Auto-generated event handler method */
	protected void toolDeleteWidgetSelected(SelectionEvent evt)
	{
		try
		{
			MessageBox msg = new MessageBox(this.getParent(), SWT.NULL);
			MessageBox msg2 = new MessageBox(this.getParent(), SWT.OK | SWT.CANCEL);
			
			HashMap argMap = new HashMap();
			argMap.put(EngKeys.CURRENT_CARD,currentCard);
			
			List curCardTrans = (List)EngTXCommon.doSelectTX(CurBLCurrentCardSearch.class.getName(),"getTransactions",argMap);
			
			
			
			if (curCardTrans.size() > 0)
			{
				msg.setMessage(Messages.getString("CurUICurrentCardUpdate.15")); //$NON-NLS-1$
				msg.open();
				return;
			}
			msg2.setMessage(Messages.getString("CurUICurrentCardUpdate.21")); //$NON-NLS-1$
			int result = msg2.open();
			if (result == SWT.OK)
			{
				updated = true;
				argMap = new HashMap();
				argMap.put(EngKeys.CURRENT_CARD,currentCard);
				EngTXCommon.doTransactionTX(CurBLCurrentCardUpdate.class.getName(),"deleteCurrentCard",argMap);
				msg.setMessage(Messages.getString("CurUICurrentCardUpdate.22")); //$NON-NLS-1$
				msg.open();
				this.dialogShell.close();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}

	public boolean verifyFields() throws Exception
	{
		try
		{
			
			HashMap argMap = new HashMap();
			argMap.put(CurKeys.CUR_CURRENT_CODE,compCurCardAdd.getTxtCurrentCode().getText().trim());
			
			Boolean isCurrentCodePresent = (Boolean) EngTXCommon.doSelectTX(CurBLCurrentCardAdd.class.getName(),"isCurrentCodePresent",argMap);
			
			
			
			MessageBox msg = new MessageBox(this.getParent(), SWT.NULL);
			if (!compCurCardAdd.verifyFields(false))
			{
				return false;
			}
			else if ((!currentCard.getCardsCurrentCode().equals(compCurCardAdd.getTxtCurrentCode().getText().trim()))
					&& isCurrentCodePresent.booleanValue())
			{
				msg.setMessage(Messages.getString("CurUICurrentCardUpdate.23")); //$NON-NLS-1$
				msg.open();
				return false;
			}
			return true;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	/** Auto-generated event handler method */
	protected void toolUpdateWidgetSelected(SelectionEvent evt)
	{
		MessageBox msg = new MessageBox(this.getParent(), SWT.NULL);
		try
		{
			if (verifyFields())
			{
				updated = true;
				HashMap argMap = new HashMap();
				argMap.put(CurKeys.CUR_CURRENT_CODE,compCurCardAdd.getTxtCurrentCode().getText().trim());
				argMap.put(CurKeys.CUR_CURRENT_NAME,compCurCardAdd.getTxtCurrentName().getText().trim());
				argMap.put(EngKeys.DEFINITION,compCurCardAdd.getTxtCardDefinition().getText().trim());
				argMap.put(CurKeys.CUR_ADDRESS,compCurCardAdd.getTxtCardAddress().getText().trim());
				argMap.put(CurKeys.CUR_DISCOUNT_RATE,compCurCardAdd.getNumTextDiscountRate().getBigDecimalValue());
				argMap.put(CurKeys.CUR_DISCOUNT_PAYMENT,compCurCardAdd.getDecTxtDiscountAmount().getBigDecimalValue());
				argMap.put(CurKeys.CUR_CREDIT_LIMIT, compCurCardAdd.getDecTxtCreditLimit().getBigDecimalValue());
				argMap.put(CurKeys.CUR_RISK_LIMIT,compCurCardAdd.getDecTxtRiskLimit().getBigDecimalValue());
				argMap.put(CurKeys.CUR_TAX_DEPARTMENT,compCurCardAdd.getTxtTaxDepartmant().getText().trim());
				argMap.put(CurKeys.CUR_TAX_NUMBER,compCurCardAdd.getTxtTaxNumber().getText().trim());
				argMap.put(CurKeys.CUR_DAYS_TO_VALUE,new Integer(compCurCardAdd.getNumDueDays().getIntValue()));
				argMap.put(CurKeys.CUR_ACCOUNTING_LIST,compCurCardAdd.createAccountingMap());
				argMap.put(CurKeys.CUR_PHONE_LIST,compCurCardAdd.getPhoneList());
				argMap.put(CurKeys.CUR_CONTACT_INFO,compCurCardAdd.getContactInfo());
				argMap.put(CurKeys.CUR_GROUP_LIST,compCurCardAdd.getGroupList());
				argMap.put(EngKeys.CURRENT_CARD,currentCard);
				
				EngTXCommon.doTransactionTX(CurBLCurrentCardUpdate.class.getName(),"updateCurrentCard",argMap);
				msg.setMessage(Messages.getString("CurUICurrentCardUpdate.26")); //$NON-NLS-1$
				msg.open();
				this.dialogShell.close();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}
}