package com.turquaz.accounting.ui;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.turquaz.accounting.bl.AccBLAccountUpdate;
import com.turquaz.accounting.ui.AccUIAddAccounts;
import com.turquaz.engine.dal.TurqAccountingAccount;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.SWT;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class AccUIAccountUpdate extends org.eclipse.swt.widgets.Dialog {
	private Text txtBalance;
	private Text txtTotalCredit;
	private Text txtTotalDept;
	private CLabel lblBalance;
	private CLabel lblTotalCredit;
	private CLabel lblTotalDept;
	private Group groupAccountBalance;
	private ToolItem toolDelete;
	private ToolItem toolUpdate;
	private ToolBar toolBar1;
	private CoolItem coolItem1;
	private CoolBar coolBar1;
	private AccUIAddAccounts compAccountCard;
	private Shell dialogShell;
	private TurqAccountingAccount account;
 
    AccBLAccountUpdate blAccount = new AccBLAccountUpdate();
	public AccUIAccountUpdate(Shell parent, int style, TurqAccountingAccount acc) {
		super(parent, style);
		account = acc;
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
			toolDelete = new ToolItem(toolBar1,SWT.NULL);
			compAccountCard = new AccUIAddAccounts(dialogShell,SWT.NULL);
			groupAccountBalance = new Group(dialogShell,SWT.NULL);
			lblTotalDept = new CLabel(groupAccountBalance,SWT.NULL);
			txtTotalDept = new Text(groupAccountBalance,SWT.NULL);
			lblTotalCredit = new CLabel(groupAccountBalance,SWT.NULL);
			txtTotalCredit = new Text(groupAccountBalance,SWT.NULL);
			lblBalance = new CLabel(groupAccountBalance,SWT.NULL);
			txtBalance = new Text(groupAccountBalance,SWT.NULL);
	
			dialogShell.setSize(new org.eclipse.swt.graphics.Point(487,301));
	
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
			coolItem1.setPreferredSize(new org.eclipse.swt.graphics.Point(88,38));
			coolItem1.setMinimumSize(new org.eclipse.swt.graphics.Point(88,38));
	
	
			toolUpdate.setText("Update");
			toolUpdate.setToolTipText("Update");
			toolUpdate.addSelectionListener( new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					toolUpdateWidgetSelected(evt);
				}
			});
	
			toolDelete.setText("Delete");
			toolDelete.setToolTipText("Delete");
			final org.eclipse.swt.graphics.Image toolDeleteimage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass().getClassLoader().getResourceAsStream("icons/delete_edit.gif"));
			toolDelete.setImage(toolDeleteimage);
			toolDelete.addSelectionListener( new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					toolDeleteWidgetSelected(evt);
				}
			});
	
			GridData compAccountCardLData = new GridData();
			compAccountCardLData.verticalAlignment = GridData.CENTER;
			compAccountCardLData.horizontalAlignment = GridData.BEGINNING;
			compAccountCardLData.widthHint = 452;
			compAccountCardLData.heightHint = 116;
			compAccountCardLData.horizontalIndent = 0;
			compAccountCardLData.horizontalSpan = 1;
			compAccountCardLData.verticalSpan = 1;
			compAccountCardLData.grabExcessHorizontalSpace = false;
			compAccountCardLData.grabExcessVerticalSpace = false;
			compAccountCard.setLayoutData(compAccountCardLData);
			compAccountCard.setSize(new org.eclipse.swt.graphics.Point(452,116));
			compAccountCard.layout();
	
			GridData groupAccountBalanceLData = new GridData();
			groupAccountBalanceLData.verticalAlignment = GridData.FILL;
			groupAccountBalanceLData.horizontalAlignment = GridData.FILL;
			groupAccountBalanceLData.widthHint = -1;
			groupAccountBalanceLData.heightHint = -1;
			groupAccountBalanceLData.horizontalIndent = 0;
			groupAccountBalanceLData.horizontalSpan = 1;
			groupAccountBalanceLData.verticalSpan = 1;
			groupAccountBalanceLData.grabExcessHorizontalSpace = true;
			groupAccountBalanceLData.grabExcessVerticalSpace = true;
			groupAccountBalance.setLayoutData(groupAccountBalanceLData);
			groupAccountBalance.setText("Balances");
			groupAccountBalance.setSize(new org.eclipse.swt.graphics.Point(471,111));
	
			GridData lblTotalDeptLData = new GridData();
			lblTotalDeptLData.widthHint = 84;
			lblTotalDeptLData.heightHint = 19;
			lblTotalDept.setLayoutData(lblTotalDeptLData);
			lblTotalDept.setText("Total Dept");
			lblTotalDept.setSize(new org.eclipse.swt.graphics.Point(84,19));
	
			GridData txtTotalDeptLData = new GridData();
			txtTotalDeptLData.widthHint = 198;
			txtTotalDeptLData.heightHint = 17;
			txtTotalDept.setLayoutData(txtTotalDeptLData);
			txtTotalDept.setEditable(false);
			txtTotalDept.setSize(new org.eclipse.swt.graphics.Point(198,17));
			final Color txtTotalDeptbackground = new Color(Display.getDefault(),255,255,255);
			txtTotalDept.setBackground(txtTotalDeptbackground);
	
			lblTotalCredit.setText("Total Credit");
	
			GridData txtTotalCreditLData = new GridData();
			txtTotalCreditLData.widthHint = 197;
			txtTotalCreditLData.heightHint = 16;
			txtTotalCredit.setLayoutData(txtTotalCreditLData);
			txtTotalCredit.setEditable(false);
			txtTotalCredit.setSize(new org.eclipse.swt.graphics.Point(197,16));
			txtTotalCredit.setBackground(txtTotalDeptbackground);
	
			GridData lblBalanceLData = new GridData();
			lblBalanceLData.widthHint = 59;
			lblBalanceLData.heightHint = 18;
			lblBalance.setLayoutData(lblBalanceLData);
			lblBalance.setText("Balance");
			lblBalance.setSize(new org.eclipse.swt.graphics.Point(59,18));
	
			GridData txtBalanceLData = new GridData();
			txtBalanceLData.widthHint = 196;
			txtBalanceLData.heightHint = 16;
			txtBalance.setLayoutData(txtBalanceLData);
			txtBalance.setEditable(false);
			txtBalance.setSize(new org.eclipse.swt.graphics.Point(196,16));
			txtBalance.setBackground(txtTotalDeptbackground);
			GridLayout groupAccountBalanceLayout = new GridLayout(2, true);
			groupAccountBalance.setLayout(groupAccountBalanceLayout);
			groupAccountBalanceLayout.marginWidth = 5;
			groupAccountBalanceLayout.marginHeight = 5;
			groupAccountBalanceLayout.numColumns = 2;
			groupAccountBalanceLayout.makeColumnsEqualWidth = false;
			groupAccountBalanceLayout.horizontalSpacing = 5;
			groupAccountBalanceLayout.verticalSpacing = 5;
			groupAccountBalance.layout();
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
					toolDeleteimage.dispose();
					txtTotalDeptbackground.dispose();
				}
			});
			Rectangle bounds = dialogShell.computeTrim(0, 0, 487,301);
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
	/** Add your pre-init code in here 	*/
	public void preInitGUI(){
	}

	/** Add your post-init code in here 	*/
	public void postInitGUI(){
    
	compAccountCard.getTxtAccAccountCode().setText(account.getAccountCode());
    compAccountCard.getTxtAccAcountName().setText(account.getAccountName());
    compAccountCard.getTxtParentAccount().setText(account.getTurqAccountingAccount().getAccountCode());
    compAccountCard.getTxtParentAccount().setData(account.getTurqAccountingAccount().getAccountingAccountsId());
	
    fillBalances();
    
	Point parentLocation =this.getParent().getLocation();
	Point parentSize = this.getParent().getSize();	
    Point dialogSize = dialogShell.getSize();
     
    int location_X = (parentLocation.x + parentSize.x)/2 - (dialogSize.x/2);
    int location_Y = (parentLocation.y + parentSize.y)/2 - (dialogSize.y/2);
    
    dialogShell.setLocation(location_X,location_Y);
	
	
	
	}
	
	public void fillBalances(){
	
		
	
	
	
	}
	

	/** Auto-generated event handler method */
	protected void toolUpdateWidgetSelected(SelectionEvent evt){
		try{
		MessageBox msg = new MessageBox(this.getParent(),SWT.NULL);
		
		if(compAccountCard.verifyFields()){
		blAccount.updateAccount(account,compAccountCard.getTxtAccAcountName().getText().trim(),
								compAccountCard.getTxtAccAccountCode().getText().trim(),
								compAccountCard.getTxtParentAccount());
		msg.setMessage("Updated Succesfully!");
		msg.open();		
		this.dialogShell.close();
		
		}
		
		
		}
		catch(Exception ex){
		ex.printStackTrace();
		}
	}

	/** Auto-generated event handler method */
	protected void toolDeleteWidgetSelected(SelectionEvent evt){
		MessageBox msg = new MessageBox(this.getParent(),SWT.NULL);
		MessageBox msg2 = new MessageBox(this.getParent(),SWT.OK|SWT.CANCEL);
		try{
		 msg2.setMessage("Really delete inventory group?");
	    int result = msg2.open();
	    
	    if(result==SWT.OK){	 
	   	blAccount.deleteAccount(account);
		msg.setMessage("Deleted Succesfully!");
		msg.open();		
		this.dialogShell.close();
		this.dialogShell.dispose();	 
	    }
				
		}
		catch(Exception ex){
		ex.printStackTrace();
		
		}
		
		
		
	}
}
