package com.turquaz.cheque.ui;

import java.util.Iterator;

import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.cheque.bl.CheBLUpdateChequeRoll;
import com.turquaz.engine.dal.TurqChequeCheque;
import com.turquaz.engine.dal.TurqChequeChequeInRoll;
import com.turquaz.engine.dal.TurqChequeRoll;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;

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
public class CheUIChequeInPayrollUpdate extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private ToolItem toolUpdate;
	private CheUIChequeInPayroll compChequeRoll;
	private ToolItem toolCancel;
	private ToolItem toolDelete;
	private ToolBar toolBar1;

	boolean isUpdated = false;
	TurqChequeRoll chequeRoll = null;

	public CheUIChequeInPayrollUpdate(Shell parent, int style, TurqChequeRoll chequeRoll) {
		super(parent, style);
		this.chequeRoll = chequeRoll;
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
			dialogShell.setSize(757, 612);
            {
                toolBar1 = new ToolBar(dialogShell, SWT.NONE);
                GridData toolBar1LData = new GridData();
                toolBar1LData.horizontalAlignment = GridData.FILL;
                toolBar1LData.grabExcessHorizontalSpace = true;
                toolBar1.setLayoutData(toolBar1LData);
                {
                    toolUpdate = new ToolItem(toolBar1, SWT.NONE);
                    toolUpdate.setText("Güncelle");
                    toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif"));
                }
                {
                    toolDelete = new ToolItem(toolBar1, SWT.NONE);
                    toolDelete.setText("Sil");
                    toolDelete.setImage(SWTResourceManager.getImage("icons/delete_edit.gif"));
                }
                {
                    toolCancel = new ToolItem(toolBar1, SWT.NONE);
                    toolCancel.setText("?ptal");
                    toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg"));
                    toolCancel.addSelectionListener(new SelectionAdapter() {
                        public void widgetSelected(SelectionEvent evt) {
                          
                            dialogShell.close();
                            
                        }
                    });
                }
            }
            {
                compChequeRoll = new CheUIChequeInPayroll(dialogShell, SWT.NONE);
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
	    try{
	        EngUICommon.centreWindow(dialogShell);
	        TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
	        CheBLUpdateChequeRoll.initializeChequeRoll(chequeRoll);
	        compChequeRoll.getTxtRollNo().setText(chequeRoll.getChequeRollNo());
	        compChequeRoll.getDatePicker1().setDate(chequeRoll.getChequeRollsDate());
	        compChequeRoll.getCurrentPicker().setText(chequeRoll.getTurqCurrentCard().getCardsName()+" {"+chequeRoll.getTurqCurrentCard().getCardsCurrentCode()+"}");
	        
	        TableItem item;
	        
	        Iterator it = chequeRoll.getTurqChequeChequeInRolls().iterator();
	        
	        while(it.hasNext()){
	            
	        TurqChequeChequeInRoll chequeInRoll = (TurqChequeChequeInRoll)it.next();
	        TurqChequeCheque cheque = chequeInRoll.getTurqChequeCheque();
	        
	        item = new TableItem(compChequeRoll.getTableCheques(),SWT.NULL);
            item.setData(cheque);            
            item.setText(new String[]{
            cheque.getChequesPortfolioNo(),
            DatePicker.formatter.format(cheque.getChequesDueDate()),
            cheque.getChequesPaymentPlace(),
            cheque.getChequesDebtor(),
            cf.format(cheque.getChequesAmount())            
            });
            
	        
	        
	        
	        
	        
	        
	        }
	        
	        
	        
	      
	        
	        
	    }
	    catch(Exception ex) {
	        ex.printStackTrace();
	    }
	    
	}
	
}
