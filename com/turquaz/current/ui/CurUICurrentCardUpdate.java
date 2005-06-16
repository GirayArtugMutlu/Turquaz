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
import com.turquaz.admin.AdmKeys;
import com.turquaz.common.HashBag;
import com.turquaz.current.CurKeys;
import com.turquaz.current.bl.CurBLCurrentCardAdd;
import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.current.bl.CurBLCurrentCardUpdate;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.current.ui.CurUICurrentCardAdd;
import org.eclipse.swt.layout.GridData;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCurrentCards;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.dal.TurqCurrentTransactionType;

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
import com.turquaz.engine.lang.CurLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
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
	private ToolItem toolCancel;
	private ToolItem toolDelete;
	private ToolItem toolUpdate;
	private ToolBar toolBarTop;
	private TurqCurrentContact curContact = null;
	private boolean updated = false;
	private Integer curCardId =null;
	private String currentCode ="";

	public CurUICurrentCardUpdate(Shell parent, int style, Integer currentCardId)
	{
		super(parent, style);
		curCardId = currentCardId;
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
			dialogShell.setText(CurLangKeys.TITLE_CUR_CARD_UPDATE); //$NON-NLS-1$
			{
				toolBarTop = new ToolBar(dialogShell, SWT.NONE);
				GridData toolBarTopLData = new GridData();
				toolBarTopLData.horizontalAlignment = GridData.FILL;
				toolBarTopLData.grabExcessHorizontalSpace = true;
				toolBarTop.setLayoutData(toolBarTopLData);
				{
					toolUpdate = new ToolItem(toolBarTop, SWT.NONE);
					toolUpdate.setEnabled(true);
					toolUpdate.setText(EngLangCommonKeys.STR_UPDATE); //$NON-NLS-1$
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
					toolDelete.setText(EngLangCommonKeys.STR_DELETE); //$NON-NLS-1$
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
					toolCancel.setText(EngLangCommonKeys.STR_CANCEL); //$NON-NLS-1$
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
			cTabItem1.setText(CurLangKeys.STR_CUR_CARD_INFO); //$NON-NLS-1$
			compCurCardAdd.setSize(new org.eclipse.swt.graphics.Point(586, 374));
			compCurCardAdd.setEnabled(true);
			compCurCardAdd.layout();
			cTabItem2.setControl(tableCurrentBalances);
			cTabItem2.setText(CurLangKeys.STR_CUR_CARD_BALANCES); //$NON-NLS-1$
			tableCurrentBalances.setHeaderVisible(true);
			tableCurrentBalances.setLinesVisible(true);
			tableCurrentBalances.setSize(new org.eclipse.swt.graphics.Point(662, 365));
			tableColumnTransactionType.setText(CurLangKeys.STR_TRANSACTION_GROUP); //$NON-NLS-1$
			tableColumnTransactionType.setWidth(100);
			tableColumnTotalCredit.setText(EngLangCommonKeys.STR_TOTAL_CREDIT); //$NON-NLS-1$
			tableColumnTotalCredit.setWidth(100);
			tableColumnTotalDept.setText(EngLangCommonKeys.STR_TOTAL_DEPT); //$NON-NLS-1$
			tableColumnTotalDept.setWidth(127);
			tableColumnBalanceCredit.setText(EngLangCommonKeys.STR_BALANCE_CREDIT); //$NON-NLS-1$
			tableColumnBalanceCredit.setWidth(137);
			tableColumnBalanceDept.setText(EngLangCommonKeys.STR_BALANCE_DEPT); //$NON-NLS-1$
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
			
			HashMap argMap = new HashMap();
			argMap.put(CurKeys.CUR_CARD_ID,curCardId);
			HashBag cardInfo = (HashBag)EngTXCommon.doTransactionTX(CurBLCurrentCardUpdate.class.getName(),"getCurrentcardInfo",argMap);
			
			currentCode = cardInfo.get(CurKeys.CUR_CURRENT_CODE).toString();
			compCurCardAdd.getTxtCurrentCode().setText(cardInfo.get(CurKeys.CUR_CURRENT_CODE).toString());
			compCurCardAdd.getTxtCurrentName().setText(cardInfo.get(CurKeys.CUR_CURRENT_NAME).toString());
			compCurCardAdd.getTxtCardDefinition().setText(cardInfo.get(EngKeys.DEFINITION).toString());
			compCurCardAdd.getTxtTaxDepartmant().setText(cardInfo.get(CurKeys.CUR_TAX_DEPARTMENT).toString());
			compCurCardAdd.getNumTextDiscountRate().setBigDecimalValue((BigDecimal)cardInfo.get(CurKeys.CUR_DISCOUNT_RATE));
			compCurCardAdd.getDecTxtRiskLimit().setText((BigDecimal)cardInfo.get(CurKeys.CUR_RISK_LIMIT));
			compCurCardAdd.getTxtTaxNumber().setText(cardInfo.get(CurKeys.CUR_TAX_NUMBER).toString());
			compCurCardAdd.getDecTxtCreditLimit().setText((BigDecimal)cardInfo.get(CurKeys.CUR_RISK_LIMIT));
			compCurCardAdd.getDecTxtDiscountAmount().setText((BigDecimal)cardInfo.get(CurKeys.CUR_DISCOUNT_PAYMENT));
			compCurCardAdd.getTxtCardAddress().setText(cardInfo.get(CurKeys.CUR_ADDRESS).toString());
			compCurCardAdd.getNumDueDays().setText(((Integer)cardInfo.get(CurKeys.CUR_DAYS_TO_VALUE)).intValue());
			/** ********************************************************* */
		
			compCurCardAdd.getTxtContactWebSite().setText(cardInfo.get(CurKeys.CUR_CONTACT_WEBSITE).toString());
			compCurCardAdd.getTxtContactName().setText(cardInfo.get(CurKeys.CUR_CONTACT_NAME).toString());
			compCurCardAdd.getTxtContactAddress().setText(cardInfo.get(CurKeys.CUR_CONTACT_ADDRESS).toString());
			compCurCardAdd.getTxtContactEmail().setText(cardInfo.get(CurKeys.CUR_CONTACT_EMAIL).toString());
			compCurCardAdd.getTxtFaxNumber().setText(cardInfo.get(CurKeys.CUR_CONTACT_FAX_NUMBER).toString());
			compCurCardAdd.getTxtContactPhone().setText(cardInfo.get(CurKeys.CUR_CONTACT_PHONE1).toString());
			compCurCardAdd.getTxtContactPhone2().setText(cardInfo.get(CurKeys.CUR_CONTACT_PHONE2).toString());
			
			/** ************************************************ */
			
			compCurCardAdd.getNumTxtNumber().setText(Integer.parseInt(cardInfo.get(CurKeys.CUR_PHONE_NUMBER1).toString()));
			compCurCardAdd.getNumTxtCityCode().setText(Integer.parseInt(cardInfo.get(CurKeys.CUR_PHONE_CITY_CODE1).toString()));
			compCurCardAdd.getNumtxtCountryCode().setText(Integer.parseInt(cardInfo.get(CurKeys.CUR_PHONE_COUNTRY_CODE1).toString()));
			compCurCardAdd.getNumTxtNumber2().setText(Integer.parseInt(cardInfo.get(CurKeys.CUR_PHONE_NUMBER2).toString()));
			compCurCardAdd.getNumTxtCityCode2().setText(Integer.parseInt(cardInfo.get(CurKeys.CUR_PHONE_CITY_CODE2).toString()));
			compCurCardAdd.getNumTxtCountryCode2().setText(Integer.parseInt(cardInfo.get(CurKeys.CUR_PHONE_COUNTRY_CODE2).toString()));
			
					
			HashMap accountMap = (HashMap)cardInfo.get(CurKeys.CUR_ACCOUNTING_LIST);
			Iterator it = accountMap.keySet().iterator();
			
			Map fieldMap = compCurCardAdd.getAccountingFields();
			while (it.hasNext())
			{
				
				Integer type = (Integer) it.next();
				AccountPickerLeaf picker = (AccountPickerLeaf) fieldMap.get(type);
				picker.setText(accountMap.get(type).toString());
			}
			HashMap groupMap = (HashMap)cardInfo.get(AdmKeys.ADM_GROUPS);
			for(int i=0;i<groupMap.size();i++)
			{
				
				compCurCardAdd.getCompRegisterGroup().RegisterGroup((Integer)groupMap.get(new Integer(i)));
			}
			
			fillCurrentBalances();
			compCurCardAdd.getBtnUpdateGroups().setEnabled(false);
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}

	

	public void fillCurrentBalances() throws Exception
	{
		try
		{
			TableItem item;
			
            List list =(List)EngTXCommon.doSelectTX(CurBLCurrentTransactionAdd.class.getName(),"getCurrentTransactionTypes",null);
            
            BigDecimal totalCredit = new BigDecimal(0);
			BigDecimal totalDept = new BigDecimal(0);
            Iterator it = list.iterator();
			while(it.hasNext())
			{
				TurqCurrentTransactionType transType = (TurqCurrentTransactionType)it.next();
				HashMap argMap = new HashMap();
				argMap.put(CurKeys.CUR_CARD_ID,curCardId);
				argMap.put(EngKeys.TYPE,transType.getId());
				
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
						item.setText(new String[]{transType.getTransactionTypeName(), credit.toString(), debt.toString(), credit.subtract(debt).toString(),
								"0"}); //$NON-NLS-1$
					}
					else
					{
						item.setText(new String[]{transType.getTransactionTypeName(), credit.toString(), debt.toString(),
								"0", debt.subtract(credit).toString()}); //$NON-NLS-1$
					}
				}
				else
				{
					item.setText(new String[]{transType.getTransactionTypeName(), "0", "0", "0", "0"}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
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
			argMap.put(CurKeys.CUR_CARD_ID,curCardId);
			
			List curCardTrans = (List)EngTXCommon.doSelectTX(CurBLCurrentCardSearch.class.getName(),"getTransactions",argMap);
			
			
			
			if (curCardTrans.size() > 0)
			{
				msg.setMessage(CurLangKeys.MSG_CUR_CARD_HAS_TRANSACTIONS); //$NON-NLS-1$
				msg.open();
				return;
			}
			msg2.setMessage(EngLangCommonKeys.MSG_DELETE_REALLY); //$NON-NLS-1$
			int result = msg2.open();
			if (result == SWT.OK)
			{
				updated = true;
				argMap = new HashMap();
				argMap.put(CurKeys.CUR_CARD_ID,curCardId);
				EngTXCommon.doTransactionTX(CurBLCurrentCardUpdate.class.getName(),"deleteCurrentCard",argMap);
				EngBLCurrentCards.RefreshContentAsistantMap();
				msg.setMessage(EngLangCommonKeys.MSG_DELETED_SUCCESS); //$NON-NLS-1$
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
        
     try{
			
			HashMap argMap = new HashMap();
			argMap.put(CurKeys.CUR_CURRENT_CODE,compCurCardAdd.getTxtCurrentCode().getText().trim());
			
			Boolean isCurrentCodePresent = (Boolean) EngTXCommon.doSelectTX(CurBLCurrentCardAdd.class.getName(),"isCurrentCodePresent",argMap);
			
			
			
			MessageBox msg = new MessageBox(this.getParent(), SWT.NULL);
			if (!compCurCardAdd.verifyFields(false))
			{
				return false;
			}
			else if ((!currentCode.equals(compCurCardAdd.getTxtCurrentCode().getText().trim()))
					&& isCurrentCodePresent.booleanValue())
			{
				msg.setMessage(CurLangKeys.MSG_CURRENT_CODE_ALREADY_EXIST); //$NON-NLS-1$
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
				argMap.put(CurKeys.CUR_CARD_ID,curCardId);
				
				EngTXCommon.doTransactionTX(CurBLCurrentCardUpdate.class.getName(),"updateCurrentCard",argMap);
				EngBLCurrentCards.RefreshContentAsistantMap();
				msg.setMessage(EngLangCommonKeys.MSG_UPDATED_SUCCESS); //$NON-NLS-1$
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