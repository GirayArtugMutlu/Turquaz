package com.turquaz.accounting.ui;

import java.util.List;


import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.custom.TableTreeItem;
import org.eclipse.swt.SWT;

import com.turquaz.accounting.bl.AccBLAccountAdd;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import com.turquaz.engine.dal.TurqAccountingAccount;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class AccUIAccountingPlan extends org.eclipse.swt.widgets.Composite {

	private TableTree tableTreeAccountingPlan;
	private AccBLAccountAdd blAccount = new AccBLAccountAdd();
	public AccUIAccountingPlan(Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	/**
	* Initializes the GUI.
	* Auto-generated code - any changes you make will disappear.
	*/
	public void initGUI(){
		try {
			preInitGUI();
	
			tableTreeAccountingPlan = new TableTree(this,SWT.FULL_SELECTION);
	
			this.setSize(new org.eclipse.swt.graphics.Point(468,276));
			final Color AccUIAccountingPlanbackground = new Color(Display.getDefault(),128,128,255);
			this.setBackground(AccUIAccountingPlanbackground);
	
			GridData tableTreeAccountingPlanLData = new GridData();
			tableTreeAccountingPlanLData.verticalAlignment = GridData.FILL;
			tableTreeAccountingPlanLData.horizontalAlignment = GridData.FILL;
			tableTreeAccountingPlanLData.widthHint = -1;
			tableTreeAccountingPlanLData.heightHint = -1;
			tableTreeAccountingPlanLData.horizontalIndent = 0;
			tableTreeAccountingPlanLData.horizontalSpan = 1;
			tableTreeAccountingPlanLData.verticalSpan = 1;
			tableTreeAccountingPlanLData.grabExcessHorizontalSpace = true;
			tableTreeAccountingPlanLData.grabExcessVerticalSpace = true;
			tableTreeAccountingPlan.setLayoutData(tableTreeAccountingPlanLData);
			tableTreeAccountingPlan.setSize(new org.eclipse.swt.graphics.Point(442,250));
			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = true;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 5;
			this.layout();
			addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					AccUIAccountingPlanbackground.dispose();
				}
			});
	
			postInitGUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
/** Add your pre-init code in here 	*/
	public void preInitGUI(){
	}

	/** Add your post-init code in here 	*/
	public void postInitGUI(){
	tableTreeAccountingPlan.getTable().addMouseListener( new MouseAdapter() {
				public void mouseDoubleClick(MouseEvent evt) {
					tableTreeAccountingPlanMouseDoubleClick(evt);
				}
			});
	
	
	tableTreeAccountingPlan.getTable().setLinesVisible(true);
	tableTreeAccountingPlan.getTable().setHeaderVisible(true);

   TableColumn col = new TableColumn(tableTreeAccountingPlan.getTable(),SWT.LEFT);
   col.setText("Account Code");
   col.setWidth(200);
   col = new TableColumn(tableTreeAccountingPlan.getTable(),SWT.LEFT);
   col.setText("Account Name");
   col.setWidth(200);
   
	fillTree(-1,"");
	}
	
			
/**
*
**/	
public void fillTree(int parent, String codeCrit){
	try{
	tableTreeAccountingPlan.removeAll();	
	TableTreeItem item;
	List mainBranches = blAccount.getAccount(parent, codeCrit);
	TurqAccountingAccount account;
	for(int i =0; i< mainBranches.size();i++){
	
	account = (TurqAccountingAccount)mainBranches.get(i);
	item = new TableTreeItem(tableTreeAccountingPlan,SWT.NULL);
	item.setText(0,account.getAccountCode());
	item.setText(1,account.getAccountName());
	item.setData(account);	
	fillBranch(item,account.getAccountingAccountsId().intValue(),"");
	
	}
	
	}
	catch(Exception ex){
		ex.printStackTrace();
	}
		
	
	
	}
	
	/**
	**
	**/
	public void fillBranch(TableTreeItem parentItem, int parent_id, String codeCriteria){
		try{
			
		
			TableTreeItem item;
			List mainBranches = blAccount.getAccount(parent_id, codeCriteria);
			TurqAccountingAccount account;
			for(int i =0; i< mainBranches.size();i++){
			
			account = (TurqAccountingAccount)mainBranches.get(i);
			item = new TableTreeItem(parentItem,SWT.NULL);
			item.setText(0,account.getAccountCode());
			item.setText(1,account.getAccountName());
			item.setData(account);
			fillBranch(item,account.getAccountingAccountsId().intValue(),"");
		
			
		}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	/** Auto-generated event handler method */
	protected void tableTreeAccountingPlanMouseDoubleClick(MouseEvent evt){
		TableTreeItem items[] = tableTreeAccountingPlan.getSelection();
		
		if(items.length>0){
		TurqAccountingAccount account =(TurqAccountingAccount)items[0].getData();
	
		// it's not an main account
		// main accounts cannot be edited
		if(account.getTurqAccountingAccount().getAccountingAccountsId().intValue()!=-1){
		
		new AccUIAccountUpdate(this.getShell(),SWT.NULL,account).open();
		fillTree(-1,"");	
		}
				
		}
		
		
		
	}
}