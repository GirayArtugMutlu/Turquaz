package com.turquaz.current.ui;

import java.math.BigDecimal;
import java.util.Iterator;


import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;

import org.eclipse.swt.widgets.Composite;

import com.turquaz.current.bl.CurBLCurrentCardAdd;
import com.turquaz.current.bl.CurBLCurrentCardUpdate;
import com.turquaz.current.ui.CurUICurrentCardAdd;
import org.eclipse.swt.layout.GridData;

import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentCardsGroup;
import com.turquaz.engine.dal.TurqCurrentCardsPhone;


import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.CoolBar;

import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.turquaz.engine.dal.TurqCurrentContact;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class CurUICurrentCardUpdate extends org.eclipse.swt.widgets.Dialog {
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
	private ToolItem toolDelete;
	private ToolItem toolUpdate;
	private ToolBar toolBar1;
	private CoolItem coolItem1;
	private CoolBar coolBar1;
	private Shell dialogShell;
	private TurqCurrentCard currentCard;
	private CurBLCurrentCardUpdate currentUpdate=new CurBLCurrentCardUpdate();
	private CurBLCurrentCardAdd currentAdd=new CurBLCurrentCardAdd();
	private TurqCurrentContact curContact=null;

	public CurUICurrentCardUpdate(Shell parent, int style, TurqCurrentCard curCard) {
		super(parent, style);
		currentCard=curCard;
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
			cTabFolder1 = new CTabFolder(dialogShell,SWT.NULL);
			cTabItem1 = new CTabItem(cTabFolder1,SWT.NULL);
			compCurCardAdd = new CurUICurrentCardAdd(cTabFolder1,SWT.NULL);
			cTabItem2 = new CTabItem(cTabFolder1,SWT.NULL);
			tableCurrentBalances = new Table(cTabFolder1,SWT.NULL);
			tableColumnTransactionType = new TableColumn(tableCurrentBalances,SWT.NULL);
			tableColumnTotalCredit = new TableColumn(tableCurrentBalances,SWT.NULL);
			tableColumnTotalDept = new TableColumn(tableCurrentBalances,SWT.NULL);
			tableColumnBalanceCredit = new TableColumn(tableCurrentBalances,SWT.NULL);
			tableColumnBalanceDept = new TableColumn(tableCurrentBalances,SWT.NULL);
	
			dialogShell.setSize(new org.eclipse.swt.graphics.Point(692,441));
	
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
			final org.eclipse.swt.graphics.Image toolUpdateimage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass().getClassLoader().getResourceAsStream("icons/save_edit.gif"));
			toolUpdate.setImage(toolUpdateimage);
	
			toolDelete.setText("Delete");
			final org.eclipse.swt.graphics.Image toolDeleteimage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass().getClassLoader().getResourceAsStream("icons/delete_edit.gif"));
			toolDelete.setImage(toolDeleteimage);
			toolDelete.addSelectionListener( new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					toolDeleteWidgetSelected(evt);
				}
			});
	
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
			cTabFolder1.setSize(new org.eclipse.swt.graphics.Point(678,366));
	
			cTabItem1.setControl(compCurCardAdd);
			cTabItem1.setText("Current Card Info");
	
			compCurCardAdd.setSize(new org.eclipse.swt.graphics.Point(586,374));
			compCurCardAdd.setEnabled(true);
			compCurCardAdd.layout();
	
			cTabItem2.setControl(tableCurrentBalances);
			cTabItem2.setText("Current Card Balances");
	
			tableCurrentBalances.setHeaderVisible(true);
			tableCurrentBalances.setLinesVisible(true);
			tableCurrentBalances.setSize(new org.eclipse.swt.graphics.Point(662,350));
	
			tableColumnTransactionType.setText("Transaction Type");
			tableColumnTransactionType.setWidth(100);
	
			tableColumnTotalCredit.setText("Total Credit");
			tableColumnTotalCredit.setWidth(100);
	
			tableColumnTotalDept.setText("Total Dept");
			tableColumnTotalDept.setWidth(127);
	
			tableColumnBalanceCredit.setText("Balance Credit");
			tableColumnBalanceCredit.setWidth(137);
	
			tableColumnBalanceDept.setText("Balance Dept");
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
			dialogShell.addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					toolUpdateimage.dispose();
					toolDeleteimage.dispose();
				}
			});
			Rectangle bounds = dialogShell.computeTrim(0, 0, 692,441);
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
		try{
			compCurCardAdd.getTxtCurrentCode().setText(currentCard.getCardsCurrentCode());
			compCurCardAdd.getTxtCurrentName().setText(currentCard.getCardsName());
			compCurCardAdd.getTxtCardDefinition().setText(currentCard.getCardsDefinition());
			compCurCardAdd.getTxtTaxDepartmant().setText(currentCard.getCardsTaxDepartment());
			compCurCardAdd.getNumTextDiscountRate().setText((currentCard.getCardsDiscountRate().intValue()));
			compCurCardAdd.getDecTxtRiskLimit().setText(currentCard.getCardsRiskLimit().toString());
			compCurCardAdd.getTxtTaxNumber().setText(currentCard.getCardsTaxNumber());
			compCurCardAdd.getDecTxtCreditLimit().setText(currentCard.getCardsCreditLimit().toString());
			compCurCardAdd.getDecTxtDiscountAmount().setText(currentCard.getCardsDiscountPayment().toString());
			compCurCardAdd.getTxtCardAddress().setText(currentCard.getCardsAddress());
			
			
			
			/************************************************************/
			Iterator it=currentCard.getTurqCurrentContacts().iterator();
		
			
			if(it.hasNext()){
				System.out.println("Filling Contact Information");
				TurqCurrentContact curContact=(TurqCurrentContact)it.next();				
				compCurCardAdd.getTxtContactWebSite().setText(curContact.getContactsWebSite());
				compCurCardAdd.getTxtContactName().setText(curContact.getContactsName());
				compCurCardAdd.getTxtContactAddress().setText(curContact.getContactAddress());
				compCurCardAdd.getTxtContactEmail().setText(curContact.getContactsEmail());
				compCurCardAdd.getTxtFaxNumber().setText(curContact.getContactsFaxNumber());
				compCurCardAdd.getTxtContactPhone().setText(curContact.getContactsPhone1());
				compCurCardAdd.getTxtContactPhone2().setText(curContact.getContactsPhone2());
			}
			
			
			/***************************************************/
			it=currentCard.getTurqCurrentCardsPhones().iterator();
			int phones=0;
			while(it.hasNext()){
			TurqCurrentCardsPhone currentPhone=(TurqCurrentCardsPhone)it.next();
				if (phones==0){
					phones++;
					compCurCardAdd.getNumTxtNumber().setText(currentPhone.getPhonesNumber());
					compCurCardAdd.getNumTxtCityCode().setText(currentPhone.getPhonesCityCode());
					compCurCardAdd.getNumtxtCountryCode().setText(currentPhone.getPhonesCountryCode());
					
				}
				else if (phones==1){
					compCurCardAdd.getNumTxtNumber2().setText(currentPhone.getPhonesNumber());
					compCurCardAdd.getNumTxtCityCode2().setText(currentPhone.getPhonesCityCode());
					compCurCardAdd.getNumTxtCountryCode2().setText(currentPhone.getPhonesCountryCode());
					break;
				}
			}
			
			compCurCardAdd.getAccPickerCustomer().setData(currentCard.getTurqAccountingAccountByAccountingCodeIdCustomer());
			compCurCardAdd.getAccPickerSupplierAccCode().setData(currentCard.getTurqAccountingAccountByAccountingCodeIdSupplier());
	        
	        it=currentCard.getTurqCurrentCardsGroups().iterator();
	        while(it.hasNext()){
	        	TurqCurrentCardsGroup currentCardGroup=(TurqCurrentCardsGroup) it.next();
	        	compCurCardAdd.getCompRegisterGroup().RegisterGroup(currentCardGroup.getTurqCurrentGroup());
	        }
			

	        
	        
	        fillCurrentGroups();     
	        fillCurrentBalances();
	     

			
		}
		catch(Exception ex){
			ex.printStackTrace();
			MessageBox msg=new MessageBox(this.getParent(),SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
			
		}
		
		
	}
	
	public void fillCurrentGroups(){
	Iterator it=currentCard.getTurqCurrentCardsGroups().iterator();
	while(it.hasNext()){
	
	TurqCurrentCardsGroup cardsGroup = (TurqCurrentCardsGroup)it.next();	
    compCurCardAdd.getCompRegisterGroup().RegisterGroup(cardsGroup.getTurqCurrentGroup());
	
	}
	
	
	
	
	}
	
	
	public void fillCurrentBalances()throws Exception{
	try{
	
	TableItem item;
	String type[] = new String[5];
	type[0]="Bill"; 
	type[1]="Cheque";
	type[2]="TradeBill";
	type[3]="Cash";
	type[4]="Bank Note";
	
	BigDecimal totalCredit = new BigDecimal(0);
	BigDecimal totalDept = new BigDecimal(0);
	
	
	for(int i=1;i<6;i++){
	
	Object sums[]=(Object [])currentUpdate.getCurrentTransactionBalances(currentCard,i).get(0);
    
    item = new TableItem(tableCurrentBalances,SWT.NULL);
    BigDecimal credit;
    BigDecimal debt;
    
	if(sums[0]!=null){
	  
	System.out.println(sums[1].toString());	
		
	  credit =(BigDecimal)sums[1];
	  debt = (BigDecimal)sums[0];
	  totalCredit = totalCredit.add(credit);
	  totalDept = totalDept.add(debt);
	  
	  if(credit.compareTo(debt)==1){
	   	
	  item.setText(new String[]{type[i-1],credit.toString(),debt.toString(),credit.subtract(debt).toString(),"0"});
	  	
	  }
	  else {
	  	item.setText(new String[]{type[i-1],credit.toString(),debt.toString(),"0",debt.subtract(credit).toString()});
	  	
	  }
	  
	  
	  
	
	}
	else {
		
		item.setText(new String[]{type[i-1],"0","0","0","0"});	
	}
	
	}
		
	}
	catch(Exception ex){
	
	throw ex;
	
	}
	
	
	}

	/** Auto-generated main method */

	/** Auto-generated event handler method */
	protected void toolDeleteWidgetSelected(SelectionEvent evt){
		MessageBox msg = new MessageBox(this.getParent(),SWT.NULL);
		MessageBox msg2 = new MessageBox(this.getParent(),SWT.OK|SWT.CANCEL);
		try{
		 msg2.setMessage("Really delete Current Card?");
	    int result = msg2.open();
	    
	    if(result==SWT.OK){	 
			
			deleteRelations();
			
			currentUpdate.deleteObject(currentCard);
			
			 msg.setMessage("Succesfully Deleted!");
			 msg.open();
			
			this.dialogShell.close();
		 }
		
		
		}
		catch(Exception ex){
			ex.printStackTrace();
			msg.setMessage(ex.getMessage());
			msg.open();
		}
	}
	
	//Delete card Phones
	//Delete Contacts
	//Delete registered group relations
	public void deleteRelations()throws Exception{
	try{
	
	 Iterator it=currentCard.getTurqCurrentCardsGroups().iterator();
	 while(it.hasNext()){
				TurqCurrentCardsGroup currentGroup=(TurqCurrentCardsGroup)it.next();
				currentUpdate.deleteObject(currentGroup);
			}
			 it=currentCard.getTurqCurrentCardsPhones().iterator();
			while(it.hasNext()){
				
				currentUpdate.deleteObject(it.next());
			}
	
			it=currentCard.getTurqCurrentContacts().iterator();
			while(it.hasNext()){
				
				currentUpdate.deleteObject(it.next());
			}
	}
	catch(Exception ex ){
	throw ex;
	}
	
	}
    
	public boolean verifyFields()throws Exception{
		try{
			MessageBox msg = new MessageBox(this.getParent(),SWT.NULL);
		if(!compCurCardAdd.verifyFields()){
			return false;
		}
		else if((!currentCard.getCardsCurrentCode().equals(compCurCardAdd.getTxtCurrentCode().getText().trim()))
				&&currentAdd.isCurrentCodePresent(compCurCardAdd.getTxtCurrentCode().getText().trim())){
			
			msg.setMessage("Current Code already exist!Please Specify Another");
			msg.open();
			return false;
		}
		else if(compCurCardAdd.getAccPickerCustomer().getData()==null){
			msg.setMessage("Please Select Customer Account");
			msg.open();
			return false;
		}
		else if(compCurCardAdd.getAccPickerSupplierAccCode().getData()==null){
			msg.setMessage("Please Select Supplier Account");
			msg.open();
			return false;
		}
		return true;
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	/** Auto-generated event handler method */
	protected void toolUpdateWidgetSelected(SelectionEvent evt){
		MessageBox msg = new MessageBox(this.getParent(),SWT.NULL);
		try{
			
		if(verifyFields()){	
		
		currentUpdate.updateCurrentCard(compCurCardAdd.getTxtCurrentCode().getText().trim(),
				compCurCardAdd.getTxtCurrentName().getText().trim(),
				compCurCardAdd.getTxtCardDefinition().getText().trim(),
				compCurCardAdd.getTxtCardAddress().getText().trim(),
				new BigDecimal(compCurCardAdd.getNumTextDiscountRate().getIntValue()),
				compCurCardAdd.getDecTxtDiscountAmount().getBigDecimalValue(),
				compCurCardAdd.getDecTxtCreditLimit().getBigDecimalValue(),
				compCurCardAdd.getDecTxtRiskLimit().getBigDecimalValue(),
				compCurCardAdd.getTxtTaxDepartmant().getText().trim(),
				compCurCardAdd.getTxtTaxNumber().getText().trim(),
				(TurqAccountingAccount)compCurCardAdd.getAccPickerCustomer().getData(),
				(TurqAccountingAccount)compCurCardAdd.getAccPickerSupplierAccCode().getData(),
				currentCard);	
				
		deleteRelations();
		compCurCardAdd.saveContact(currentCard.getCurrentCardsId());
		compCurCardAdd.savePhones(currentCard.getCurrentCardsId());
		compCurCardAdd.saveGroups(currentCard.getCurrentCardsId());
		
		 msg.setMessage("Succesfully Updated!");
		 msg.open();
			
		this.dialogShell.close();
		}
		}
		catch(Exception ex){

			try{
			ex.printStackTrace();
			System.out.println(currentCard.getCardsCurrentCode());
			System.out.println(compCurCardAdd.getTxtCurrentCode().getText().trim());
		
			    msg.setMessage(ex.getMessage());
			    msg.open();
			
			}
			catch(Exception ex1){
			ex1.printStackTrace();
			}
			}
			
				
		
		}
}
		
		
		
	

