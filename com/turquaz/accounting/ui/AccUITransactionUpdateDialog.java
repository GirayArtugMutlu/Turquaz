package com.turquaz.accounting.ui;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Rectangle;

import com.turquaz.accounting.bl.AccBLTransactionUpdate;
import com.turquaz.accounting.ui.AccUITransactionAdd;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;


import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.SWT;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class AccUITransactionUpdateDialog extends org.eclipse.swt.widgets.Dialog {
	private AccUITransactionAdd compTransactionAdd;
	private ToolItem tooDelete;
	private ToolItem toolUpdate;
	private ToolBar toolBar1;
	private CoolItem coolItem1;
	private CoolBar coolBar1;
	private Shell dialogShell;
	private AccBLTransactionUpdate blTransUpdate = new AccBLTransactionUpdate();

    private TurqAccountingTransaction accTrans;
	public AccUITransactionUpdateDialog(Shell parent, int style,TurqAccountingTransaction trans) {
		super(parent, style);
	    this.accTrans =trans;
	}

	/**
	* Opens the Dialog Shell.
	* Auto-generated code - any changes you make will disappear.
	*/
	public void open(){
		try {
			preInitGUI();
	
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
			dialogShell.setText(getText());
			coolBar1 = new CoolBar(dialogShell,SWT.NULL);
			coolItem1 = new CoolItem(coolBar1,SWT.NULL);
			toolBar1 = new ToolBar(coolBar1,SWT.NULL);
			toolUpdate = new ToolItem(toolBar1,SWT.NULL);
			tooDelete = new ToolItem(toolBar1,SWT.NULL);
			compTransactionAdd = new AccUITransactionAdd(dialogShell,SWT.NULL);
	
			dialogShell.setSize(new org.eclipse.swt.graphics.Point(577,427));
	
			GridData coolBar1LData = new GridData();
			coolBar1LData.verticalAlignment = GridData.CENTER;
			coolBar1LData.horizontalAlignment = GridData.FILL;
			coolBar1LData.widthHint = -1;
			coolBar1LData.heightHint = -1;
			coolBar1LData.horizontalIndent = 0;
			coolBar1LData.horizontalSpan = 1;
			coolBar1LData.verticalSpan = 1;
			coolBar1LData.grabExcessHorizontalSpace = false;
			coolBar1LData.grabExcessVerticalSpace = false;
			coolBar1.setLayoutData(coolBar1LData);
	
			coolItem1.setControl(toolBar1);
			coolItem1.setSize(new org.eclipse.swt.graphics.Point(88,38));
			coolItem1.setPreferredSize(new org.eclipse.swt.graphics.Point(88,38));
			coolItem1.setMinimumSize(new org.eclipse.swt.graphics.Point(88,38));
	
	
			toolUpdate.setText("Update");
			final org.eclipse.swt.graphics.Image toolUpdateimage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass().getClassLoader().getResourceAsStream("icons/save_edit.gif"));
			toolUpdate.setImage(toolUpdateimage);
			toolUpdate.addSelectionListener( new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					toolUpdateWidgetSelected(evt);
				}
			});
	
			tooDelete.setText("Delete");
			final org.eclipse.swt.graphics.Image tooDeleteimage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass().getClassLoader().getResourceAsStream("icons/delete_edit.gif"));
			tooDelete.setImage(tooDeleteimage);
			tooDelete.addSelectionListener( new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					tooDeleteWidgetSelected(evt);
				}
			});
	
			GridData compTransactionAddLData = new GridData();
			compTransactionAddLData.verticalAlignment = GridData.FILL;
			compTransactionAddLData.horizontalAlignment = GridData.FILL;
			compTransactionAddLData.widthHint = -1;
			compTransactionAddLData.heightHint = -1;
			compTransactionAddLData.horizontalIndent = 0;
			compTransactionAddLData.horizontalSpan = 1;
			compTransactionAddLData.verticalSpan = 1;
			compTransactionAddLData.grabExcessHorizontalSpace = true;
			compTransactionAddLData.grabExcessVerticalSpace = true;
			compTransactionAdd.setLayoutData(compTransactionAddLData);
			compTransactionAdd.setSize(new org.eclipse.swt.graphics.Point(567,374));
			compTransactionAdd.layout();
			GridLayout dialogShellLayout = new GridLayout(1, true);
			dialogShell.setLayout(dialogShellLayout);
			dialogShellLayout.marginWidth = 5;
			dialogShellLayout.marginHeight = 5;
			dialogShellLayout.numColumns = 1;
			dialogShellLayout.makeColumnsEqualWidth = true;
			dialogShellLayout.horizontalSpacing = 5;
			dialogShellLayout.verticalSpacing = 5;
			dialogShell.layout();
			dialogShell.addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					toolUpdateimage.dispose();
					tooDeleteimage.dispose();
				}
			});
			Rectangle bounds = dialogShell.computeTrim(0, 0, 577,427);
			dialogShell.setSize(bounds.width, bounds.height);
			postInitGUI();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
public void showDialog(TurqAccountingTransaction accTrans){
	
	
	
	
	

	}
	/** Add your pre-init code in here 	*/
	public void preInitGUI(){
	}

	/** Add your post-init code in here 	*/
	public void postInitGUI(){
	compTransactionAdd.getTxtDocumentNo().setText(accTrans.getTransactionDocumentNo());
	Date date = new Date(accTrans.getTransactionsDate().getTime());
	compTransactionAdd.getDateTransactionDate().setDate(date);
	fillTable();
	compTransactionAdd.calculateTotalDeptAndCredit();
		
	
	}
	public void fillTable(){
	Set transactionRows = accTrans.getTurqAccountingTransactionColumns();
	
	Iterator it = transactionRows.iterator();
	TurqAccountingTransactionColumn transRow;
	TableItem item;
	while(it.hasNext()){
	transRow =(TurqAccountingTransactionColumn)it.next();
	
	item = new TableItem(compTransactionAdd.getTableTransactionColumns(),SWT.NULL);
	item.setData(transRow);
	item.setText(new String[]{transRow.getTurqAccountingAccount().getAccountCode(),
				transRow.getTurqAccountingAccount().getAccountName(),
				transRow.getCreditAmount().toString(),
				transRow.getDeptAmount().toString()});
	
	
	}
	}
	

	/** Auto-generated event handler method */
	protected void toolUpdateWidgetSelected(SelectionEvent evt){
		MessageBox msg = new MessageBox(this.getParent(),SWT.NULL);
		
		try{
		 
		 blTransUpdate.updateTransaction(accTrans,compTransactionAdd.getTxtDocumentNo().getText().trim(),
										compTransactionAdd.getDateTransactionDate().getData());
		 updateTransactionRows();
		 msg.setMessage("Succesfully Updated");
		 msg.open();
			
		}
		catch(Exception ex){
		ex.printStackTrace();
		msg.setMessage("An error occured!");
		 msg.open();
		}
		
		
		
	}
  public void updateTransactionRows()throws Exception {
   try{
  
   if(compTransactionAdd.verifyFields()){
    deleteTransactionRows();
    
    compTransactionAdd.saveTransactionRows(accTrans.getAccountingTransactionsId());
    }
    }
    catch(Exception ex){
       throw ex;
    }
  
  }	
	
    public void deleteTransactionRows()throws Exception{
    try{
     Set transactionRows = accTrans.getTurqAccountingTransactionColumns();
     Iterator it = transactionRows.iterator();
     TurqAccountingTransactionColumn transRow;
     while(it.hasNext()){

     	blTransUpdate.delete(it.next());
	
	}
    
     
    
    
    }
    catch(Exception ex){
    throw ex;
    
    }
    
    
    }
    
    
	/** Auto-generated event handler method */
	protected void tooDeleteWidgetSelected(SelectionEvent evt){
		MessageBox msg = new MessageBox(this.getParent(),SWT.NULL);
		MessageBox msg2 = new MessageBox(this.getParent(),SWT.YES|SWT.NO);
		msg2.setMessage("Really delete?");
		int answer = msg2.open();
		if(answer ==SWT.YES){
		try{
		
		deleteTransactionRows();
		blTransUpdate.delete(accTrans);
		msg.setMessage("Succesfully Deleted!");
		msg.open();	
		this.dialogShell.dispose();	
		
		}
		catch(Exception ex){
		ex.printStackTrace();
		msg.setMessage("An error occured!");
		msg.open();	
		
		}
		}
	}
}
