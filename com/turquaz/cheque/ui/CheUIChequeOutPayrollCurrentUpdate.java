package com.turquaz.cheque.ui;

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
 * @author  Onsel
 * @version  $Id$
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.cheque.CheKeys;
import com.turquaz.cheque.bl.CheBLUpdateChequeRoll;
import com.turquaz.common.HashBag;
import com.turquaz.current.CurKeys;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.lang.CheLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class CheUIChequeOutPayrollCurrentUpdate extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private ToolItem toolUpdate;
	private CheUIChequeOutPayrollCurrent compChequeRoll;
	private ToolItem toolCancel;
	private ToolItem toolDelete;
	private ToolBar toolBar1;
	boolean isUpdated = false;
	Integer chequeRollId = null;

	public CheUIChequeOutPayrollCurrentUpdate(Shell parent, int style, Integer chequeRoll)
	{
		super(parent, style);
		this.chequeRollId = chequeRoll;
	}

	public boolean open()
	{
		try
		{
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL | SWT.RESIZE | SWT.MAX);
			{
				//Register as a resource user - SWTResourceManager will
				//handle the obtaining and disposing of resources
				SWTResourceManager.registerResourceUser(dialogShell);
			}
			dialogShell.setLayout(new GridLayout());
			dialogShell.layout();
			dialogShell.pack();
			dialogShell.setSize(757, 612);
			{
				toolBar1 = new ToolBar(dialogShell, SWT.NONE);
				GridData toolBar1LData = new GridData();
				toolBar1LData.horizontalAlignment = GridData.FILL;
				toolBar1LData.grabExcessHorizontalSpace = true;
				toolBar1.setLayoutData(toolBar1LData);
				{
					toolUpdate = new ToolItem(toolBar1, SWT.NONE);
					toolUpdate.setText(EngLangCommonKeys.STR_UPDATE); //$NON-NLS-1$
					toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif")); //$NON-NLS-1$
					toolUpdate.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							update();
						}
					});
				}
				{
					toolDelete = new ToolItem(toolBar1, SWT.NONE);
					toolDelete.setText(EngLangCommonKeys.STR_DELETE); //$NON-NLS-1$
					toolDelete.setImage(SWTResourceManager.getImage("icons/delete_edit.gif")); //$NON-NLS-1$
					toolDelete.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							delete();
						}
					});
				}
				{
					toolCancel = new ToolItem(toolBar1, SWT.NONE);
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
			{
				compChequeRoll = new CheUIChequeOutPayrollCurrent(dialogShell, SWT.NONE);
				GridData compChequeRollLData = new GridData();
				compChequeRollLData.grabExcessHorizontalSpace = true;
				compChequeRollLData.horizontalAlignment = GridData.FILL;
				compChequeRollLData.grabExcessVerticalSpace = true;
				compChequeRollLData.verticalAlignment = GridData.FILL;
				compChequeRoll.setLayoutData(compChequeRollLData);
			}
			postInitGUI();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed())
			{
				if (!display.readAndDispatch())
					display.sleep();
			}
			return isUpdated;
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getParent());
			return false;
		}
	}

	public void postInitGUI()
	{
		try
		{
			EngUICommon.centreWindow(dialogShell);
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			

			HashMap argMap = new HashMap();
			argMap.put(CheKeys.CHE_CHEQUE_ROLL_ID,chequeRollId);
			HashBag infoBag = (HashBag)EngTXCommon.doSelectTX(CheBLUpdateChequeRoll.class.getName(),"getChequeRollInfo",argMap);
			
			

			compChequeRoll.getTxtRollNo().setText((String)infoBag.get(EngKeys.DOCUMENT_NO));
			compChequeRoll.getDatePicker1().setDate((Date)infoBag.get(EngKeys.DATE));
			
			compChequeRoll.getCurrentPicker().setText((String)infoBag.get(CurKeys.CUR_CURRENT_NAME)
					+ " {" + (String)infoBag.get(CurKeys.CUR_CURRENT_CODE) + "}"); //$NON-NLS-1$ //$NON-NLS-2$

			compChequeRoll.getToolItemAddCustomer().setEnabled(false);
			compChequeRoll.getToolItemDelete().setEnabled(false);
			compChequeRoll.getToolItemUpdate().setEnabled(false);
			compChequeRoll.getToolItemAddOwn().setEnabled(false);
			TableItem item;
			HashMap chequeList =(HashMap)infoBag.get(CheKeys.CHE_CHEQUE_LIST);
			
		
			for(int i=0;i<chequeList.size();i++)
			{
				
				HashMap chequeInfo = (HashMap)chequeList.get(new Integer(i));
				
				item = new TableItem(compChequeRoll.getTableCheques(), SWT.NULL);
				item.setData(chequeInfo);
				item.setText(new String[]{chequeInfo.get(CheKeys.CHE_PORTFOLIO_NO).toString(), DatePicker.formatter.format(chequeInfo.get(EngKeys.DATE)),
						chequeInfo.get(CheKeys.CHE_PAYMENT_PLACE).toString(), chequeInfo.get(CheKeys.CHE_DEBTOR).toString(), cf.format(chequeInfo.get(EngKeys.TOTAL_AMOUNT))});
			}
			compChequeRoll.calculateTotal();
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}

	public void delete()
	{
		try
		{
			if (EngUICommon.okToDelete(getParent()))
			{
				if (compChequeRoll.getTableCheques().getItemCount() > 0)
				{
					EngUICommon.showMessageBox(getParent(),CheLangKeys.MSG_CANNOT_DELETE_ROLLS_WITH_CHEQUE, SWT.ICON_WARNING); //$NON-NLS-1$
					return;
				}
				HashMap argMap = new HashMap();
				argMap.put(CheKeys.CHE_CHEQUE_ROLL_ID,chequeRollId);
				EngTXCommon.doTransactionTX(CheBLUpdateChequeRoll.class.getName(),"deleteChequeRollIn",argMap);
				
				EngUICommon.showMessageBox(getParent(), EngLangCommonKeys.MSG_DELETED_SUCCESS, SWT.ICON_INFORMATION); //$NON-NLS-1$
				isUpdated = true;
				dialogShell.close();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}

	public void update()
	{
		try
		{
			if (compChequeRoll.verifyFields())
			{
				List chequeList = new ArrayList();
				int count = compChequeRoll.getTableCheques().getItemCount();
				for (int i = 0; i < count; i++)
				{
					chequeList.add(compChequeRoll.getTableCheques().getItem(i).getData());
				}
				//		          TODO cheq trans exRate
			    HashMap argMap = new HashMap();
			    argMap.put(CheKeys.CHE_CHEQUE_ROLL_ID,chequeRollId);
			    argMap.put(CurKeys.CUR_CARD_ID,compChequeRoll.getCurrentPicker().getCardId());
			    argMap.put(EngKeys.DOCUMENT_NO,compChequeRoll.getTxtRollNo().getText().trim());
			    argMap.put(EngKeys.DATE,compChequeRoll.getDatePicker1().getDate());
			    argMap.put(CheKeys.CHE_CHEQUE_LIST,chequeList);
			    argMap.put(EngKeys.TYPE,EngBLCommon.CHEQUE_TRANS_OUT_CURRENT);
			    argMap.put(CheKeys.CHE_SUM_TRANS,new Boolean(compChequeRoll.getBtnSumTotals().getSelection()));
			    argMap.put(EngKeys.CURRENCY_ID,EngBLCommon.getBaseCurrencyId());
			    
				EngTXCommon.doTransactionTX(CheBLUpdateChequeRoll.class.getName(),"updateChequeRollIn",argMap );
						
				EngUICommon.showMessageBox(getParent(), EngLangCommonKeys.MSG_UPDATED_SUCCESS, SWT.ICON_INFORMATION); //$NON-NLS-1$
				isUpdated = true;
				dialogShell.close();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}
}