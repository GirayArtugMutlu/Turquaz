package com.turquaz.current.ui;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;


import org.eclipse.swt.widgets.ToolBar;

import com.turquaz.common.HashBag;
import com.turquaz.current.CurKeys;
import com.turquaz.current.bl.CurBLTransactionUpdate;
import com.turquaz.current.ui.CurUICurrentTransfer;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* *************************************
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED
* for this machine, so Jigloo or this code cannot be used legally
* for any corporate or commercial purpose.
* *************************************
*/
public class CurUICurrentTransferUpdate extends org.eclipse.swt.widgets.Dialog {

	


	private Shell dialogShell;
	private ToolItem toolItem1;
	private CurUICurrentTransfer compCurTransfer;
	private ToolItem toolCancel;
	private ToolItem toolDelete;
	private ToolBar toolBar;
	boolean isUpdated =false;

	Integer currentTransId = null;
	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/
	
	public CurUICurrentTransferUpdate(Shell parent, int style,Integer curTransId) {
		super(parent, style);
		this.currentTransId = curTransId;
	}

	public boolean open() {
		try {
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
			dialogShell.setSize(552, 489);
			{
				toolBar = new ToolBar(dialogShell, SWT.NONE);
				GridData toolBarLData = new GridData();
				toolBarLData.horizontalAlignment = GridData.FILL;
				toolBarLData.grabExcessHorizontalSpace = true;
				toolBar.setLayoutData(toolBarLData);
				{
					toolItem1 = new ToolItem(toolBar, SWT.NONE);
					toolItem1.setText("Güncelle");
					toolItem1.setImage(SWTResourceManager.getImage("icons/save_edit.gif"));
					toolItem1.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent evt) {
						
							update();
						}
					});
				}
				{
					toolDelete = new ToolItem(toolBar, SWT.NONE);
					toolDelete.setText("Sil");
					toolDelete.setImage(SWTResourceManager.getImage("icons/delete_edit.gif"));
					toolDelete.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent evt) {
						
							delete();
						}
					});
				}
				{
					toolCancel = new ToolItem(toolBar, SWT.NONE);
					toolCancel.setText(EngLangCommonKeys.STR_CANCEL);
					toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg"));
					toolCancel.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent evt) {
						dialogShell.close();
						}
					});
				}
			}
			{
				compCurTransfer = new CurUICurrentTransfer(
					dialogShell,
					SWT.NONE);
				GridData compCurTransferLData = new GridData();
				compCurTransferLData.grabExcessHorizontalSpace = true;
				compCurTransferLData.horizontalAlignment = GridData.FILL;
				compCurTransferLData.verticalAlignment = GridData.FILL;
				compCurTransferLData.grabExcessVerticalSpace = true;
				compCurTransfer.setLayoutData(compCurTransferLData);
			}
			postInitGUI();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
			return isUpdated;
		} catch (Exception e) {
            EngBLLogger.log(this.getClass(),e,getParent());
		return false; 
		}
	}
	
	public void postInitGUI()
	{
		EngUICommon.centreWindow(dialogShell);
		try{
			
		
		HashMap argMap = new HashMap();
		argMap.put(CurKeys.CUR_TRANSACTION_ID,currentTransId);
	    HashBag transInfo = (HashBag)EngTXCommon.doSelectTX(CurBLTransactionUpdate.class.getName(),"getTransferBetweenAccountsInfo",argMap);
			   
		 	compCurTransfer.getTxtDefinition().setText(transInfo.get(EngKeys.DEFINITION).toString());
		 	compCurTransfer.getTxtDocumentNo().setText(transInfo.get(EngKeys.DOCUMENT_NO).toString());
            compCurTransfer.getDatePicker().setDate((Date)transInfo.get(EngKeys.DATE));
         
           
            	compCurTransfer.getCurrentCreditPicker().setText(transInfo.get(CurKeys.CUR_CARD_CREDIT).toString());
           
            	compCurTransfer.getCurrentDebitPicker().setText(transInfo.get(CurKeys.CUR_CARD_DEPT).toString());
            	compCurTransfer.getCurrentAmount().setText((BigDecimal)transInfo.get(EngKeys.TOTAL_AMOUNT));
             	
		  
		 
		}
		catch(Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
		
		
		
	}
	
	public void update()
	{
		try{
		if(compCurTransfer.verifyFields())
		{
			HashMap argMap = new HashMap();
			argMap.put(CurKeys.CUR_TRANSACTION_ID,currentTransId);
			EngTXCommon.doTransactionTX(CurBLTransactionUpdate.class.getName(),"deleteTransfer",argMap);
			compCurTransfer.saveTrans();
			isUpdated=true;
			dialogShell.close();
			
			
		}
		}
		catch(Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
		
	}
	
	
	public void delete(){
		
		try{
			if(EngUICommon.okToDelete(getParent()))
			{
			HashMap argMap = new HashMap();
			argMap.put(CurKeys.CUR_TRANSACTION_ID,currentTransId);
			EngTXCommon.doTransactionTX(CurBLTransactionUpdate.class.getName(),"deleteTransfer",argMap);
			
			isUpdated=true;
			dialogShell.close();
			}
			
		}
		catch(Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
		
	}
	
}
