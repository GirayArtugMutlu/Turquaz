
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
package com.turquaz.bank.ui;

import java.util.Iterator;

import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.layout.GridData;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.bank.Messages;
import com.turquaz.engine.dal.TurqBanksTransaction;
import com.turquaz.engine.dal.TurqBanksTransactionBill;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentTransaction;
import com.turquaz.engine.ui.EngUICommon;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;


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
public class BankUIMoneyTransferOutUpdate extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private ToolItem toolUpdate;
	private BankUIMoneyTransferOut compMoneyTransferIn;
	private ToolItem toolCancel;
	private ToolItem toolDelete;
	private ToolBar toolBar1;
	private TurqBanksTransactionBill transBill;
	boolean isUpdated = false;

	public BankUIMoneyTransferOutUpdate(Shell parent, int style,TurqBanksTransactionBill transBill) {
		super(parent, style);
		this.transBill = transBill;
	}

	public boolean open() {
		try {
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

                {
                    //Register as a resource user - SWTResourceManager will
                    //handle the obtaining and disposing of resources
                    SWTResourceManager.registerResourceUser(dialogShell);
                }


			dialogShell.setLayout(new GridLayout());
			dialogShell.layout();
			dialogShell.pack();
			dialogShell.setSize(548, 642);
            {
                toolBar1 = new ToolBar(dialogShell, SWT.NONE);
                GridData toolBar1LData = new GridData();
                toolBar1LData.grabExcessHorizontalSpace = true;
                toolBar1LData.horizontalAlignment = GridData.FILL;
                toolBar1.setLayoutData(toolBar1LData);
                {
                    toolUpdate = new ToolItem(toolBar1, SWT.NONE);
                    toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif")); //$NON-NLS-1$
                    toolUpdate.setText(Messages.getString("BankUIMoneyTransferOutUpdate.1")); //$NON-NLS-1$
                }
                {
                    toolDelete = new ToolItem(toolBar1, SWT.NONE);
                    toolDelete.setText(Messages.getString("BankUIMoneyTransferOutUpdate.2")); //$NON-NLS-1$
                    toolDelete.setImage(SWTResourceManager.getImage("icons/delete_edit.gif")); //$NON-NLS-1$
                }
                {
                    toolCancel = new ToolItem(toolBar1, SWT.NONE);
                    toolCancel.setText(Messages.getString("BankUIMoneyTransferOutUpdate.4")); //$NON-NLS-1$
                    toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg")); //$NON-NLS-1$
                }
            }
            {
                compMoneyTransferIn = new BankUIMoneyTransferOut(dialogShell, SWT.NONE);
                GridData compMoneyTransferInLData = new GridData();
                compMoneyTransferInLData.grabExcessHorizontalSpace = true;
                compMoneyTransferInLData.horizontalAlignment = GridData.FILL;
                compMoneyTransferInLData.verticalAlignment = GridData.FILL;
                compMoneyTransferInLData.grabExcessVerticalSpace = true;
                compMoneyTransferIn.setLayoutData(compMoneyTransferInLData);
            }
			dialogShell.open();
			postInitGUI();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
			return isUpdated;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public void postInitGUI(){
	    
	   EngUICommon.centreWindow(dialogShell);
	    
	   compMoneyTransferIn.getTxtDocNo().setText(transBill.getTransactionBillNo());
	   compMoneyTransferIn.getTxtDefinition().setText(transBill.getTransactionBillDefinition());
	   compMoneyTransferIn.getTxtBankCard().setText(transBill.getTurqBanksCard().getBankCode());
	   compMoneyTransferIn.getDatePick().setDate(transBill.getTransactionBillDate());
	  
	   Iterator it = transBill.getTurqBanksTransactions().iterator();
	   
	   if(it.hasNext())
	   {
	       TurqBanksTransaction bankTrans = (TurqBanksTransaction)it.next();
	      
	       compMoneyTransferIn.getCurAmount().setText(bankTrans.getCreditAmount());
	       if(bankTrans.getCreditAmount().compareTo(bankTrans.getDeptAmount())<1)
	       {
	           compMoneyTransferIn.getCurAmount().setText(bankTrans.getDeptAmount());          
	           
	       }
	       
	       Iterator it2 = transBill.getTurqEngineSequence().getTurqCurrentTransactions().iterator();
	       
	       if(it2.hasNext())
	       {
	           TurqCurrentTransaction curTrans = (TurqCurrentTransaction)it2.next();
	           TurqCurrentCard curCard = curTrans.getTurqCurrentCard();
	           compMoneyTransferIn.getCurrentPicker().setText(curCard.getCardsName()+" {"+curCard.getCardsCurrentCode()+"}");
	                    
	           
	       }
	       
	       
	       
	       
	   }
	   
	    
	    
	}
	
}
