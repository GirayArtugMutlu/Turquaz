package com.turquaz.cash.ui;

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
import java.util.HashMap;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.accounting.AccKeys;
import com.turquaz.cash.CashKeys;
import com.turquaz.cash.bl.CashBLCashCardSearch;
import com.turquaz.cash.bl.CashBLCashCardUpdate;
import com.turquaz.common.HashBag;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.lang.CashLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;


/**
 * @author onsel
 * @version $Id$
 */
public class CashUICashCardUpdate extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private CoolItem coolItem1;
	private ToolItem toolUpdate;
	private CashUICashCardAdd compCashCard;
	private ToolItem toolCancel;
	private ToolItem toolDelete;
	private ToolBar toolBar1;
	private CoolBar coolBar1;
    private String cardName;
    private Integer cardId;
    
	public CashUICashCardUpdate(Shell parent, int style, String cardName)
	{
		super(parent, style);
		this.cardName = cardName;
	}

	public void open()
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
			dialogShell.setText(CashLangKeys.TITLE_CASH_CARD_UPDATE);
			dialogShell.setSize(563, 228);
			{
				coolBar1 = new CoolBar(dialogShell, SWT.NONE);
				GridData coolBar1LData = new GridData();
				coolBar1LData.heightHint = 40;
				coolBar1LData.grabExcessHorizontalSpace = true;
				coolBar1LData.horizontalAlignment = GridData.FILL;
				coolBar1.setLayoutData(coolBar1LData);
				{
					coolItem1 = new CoolItem(coolBar1, SWT.NONE);
					coolItem1.setPreferredSize(new org.eclipse.swt.graphics.Point(45, 41));
					coolItem1.setMinimumSize(new org.eclipse.swt.graphics.Point(45, 41));
					coolItem1.setSize(45, 41);
					{
						toolBar1 = new ToolBar(coolBar1, SWT.NONE);
						coolItem1.setControl(toolBar1);
						{
							toolUpdate = new ToolItem(toolBar1, SWT.NONE);
							toolUpdate.setText(EngLangCommonKeys.STR_UPDATE);
							toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif")); //$NON-NLS-1$
							toolUpdate.addSelectionListener(new SelectionAdapter()
							{
								public void widgetSelected(SelectionEvent evt)
								{
									toolUpdateSelected();
								}
							});
						}
						{
							toolDelete = new ToolItem(toolBar1, SWT.NONE);
							toolDelete.setText(EngLangCommonKeys.STR_DELETE);
							toolDelete.setImage(SWTResourceManager.getImage("icons/delete_edit.gif")); //$NON-NLS-1$
							toolDelete.addSelectionListener(new SelectionAdapter()
							{
								public void widgetSelected(SelectionEvent evt)
								{
									toolDeleteSelected();
								}
							});
						}
						{
							toolCancel = new ToolItem(toolBar1, SWT.NONE);
							toolCancel.setText(EngLangCommonKeys.STR_CANCEL);
							toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg")); //$NON-NLS-1$
							toolCancel.addSelectionListener(new SelectionAdapter()
							{
								public void widgetSelected(SelectionEvent evt)
								{
									toolCancelSelected();
								}
							});
						}
					}
				}
			}
			{
				compCashCard = new CashUICashCardAdd(dialogShell, SWT.NONE);
				GridData compCashCardLData = new GridData();
				compCashCardLData.widthHint = 521;
				compCashCardLData.heightHint = 126;
				compCashCard.setLayoutData(compCashCardLData);
			}
			postInitGUI();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed())
			{
				if (!display.readAndDispatch())
					display.sleep();
			}
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getParent());
		}
	}

	public void postInitGUI()
	{
        try {
        HashMap argMap = new HashMap();
        argMap.put(CashKeys.CASH_CARD_NAME,cardName);
        
        HashBag result  =(HashBag)EngTXCommon.doSelectTX(CashBLCashCardSearch.class.getName(),"searchCashCard",argMap);         
        HashMap cards = (HashMap)result.get(CashKeys.CASH_CARDS);
        
        HashMap cardInfo = (HashMap) cards.get(new Integer(0));
        
        cardId = (Integer)cardInfo.get(CashKeys.CASH_CARD_ID);
            
		compCashCard.getTxtCardCode().setText(cardInfo.get(CashKeys.CASH_CARD_NAME).toString());
		compCashCard.getTxtDefinition().setText(cardInfo.get(EngKeys.DEFINITION).toString());
		compCashCard.getAccountPicker().setData(cardInfo.get(AccKeys.ACC_ACCOUNT_CODE_ID));
        compCashCard.getAccountPicker().setText(cardInfo.get(AccKeys.ACC_ACCOUNT_CODE).toString());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
	}

	public void toolDeleteSelected()
	{
		try
		{
			boolean okToDelete=EngUICommon.okToDelete(getParent());
			if (okToDelete)
			{
				//TODO check there exist transaction with this cash card
				HashMap argMap = new HashMap();
				argMap.put(CashKeys.CASH_CARD_ID, cardId);
				EngTXCommon.doTransactionTX(CashBLCashCardUpdate.class.getName(), "deleteCashCard", argMap);
				EngUICommon.showUpdatedSuccesfullyMessage(getParent());
				dialogShell.close();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());	
			
		}
	}

	public void toolCancelSelected()
	{
		dialogShell.close();
	}

	public void toolUpdateSelected()
	{
		try
		{
			if (compCashCard.verifyFields())
			{				
				HashMap argMap = new HashMap();
				argMap.put(CashKeys.CASH_CARD_ID,cardId);
				argMap.put(CashKeys.CASH_CARD_NAME,compCashCard.getTxtCardCode().getText().trim());
				argMap.put(EngKeys.DEFINITION,compCashCard.getTxtDefinition().getText().trim());
				argMap.put(AccKeys.ACC_ACCOUNT_ID,compCashCard.getAccountPicker().getId());				
				
				EngTXCommon.doTransactionTX(CashBLCashCardUpdate.class.getName(),"updateCashCard",argMap);
				EngUICommon.showUpdatedSuccesfullyMessage(getParent());
				dialogShell.close();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}
}