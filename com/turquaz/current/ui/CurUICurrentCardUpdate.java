package com.turquaz.current.ui;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Set;

import net.sf.hibernate.Hibernate;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;

import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;

import com.turquaz.current.bl.CurBLCurrentCardUpdate;
import com.turquaz.current.ui.CurUICurrentCardAdd;
import org.eclipse.swt.layout.GridData;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentCardsGroup;
import com.turquaz.engine.dal.TurqCurrentCardsPhone;
import com.turquaz.engine.dal.TurqCurrentGroup;

import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import com.turquaz.engine.dal.TurqCurrentContact;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class CurUICurrentCardUpdate extends org.eclipse.swt.widgets.Dialog {
	private TableColumn tableColumnBalanceDept;
	private TableColumn tableColumnBalanceCredit;
	private TableColumn tableColumnTotalDept;
	private TableColumn tableColumnTotalCredit;
	private TableColumn tableColumnTransactionType;
	private Table tableCurrentBalances;
	private Composite composite1;
	private CTabItem cTabItem2;
	private CurUICurrentCardAdd compCurCardAdd;
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
			composite1 = new Composite(cTabFolder1,SWT.NULL);
			tableCurrentBalances = new Table(composite1,SWT.NULL);
			tableColumnTransactionType = new TableColumn(tableCurrentBalances,SWT.NULL);
			tableColumnTotalCredit = new TableColumn(tableCurrentBalances,SWT.NULL);
			tableColumnTotalDept = new TableColumn(tableCurrentBalances,SWT.NULL);
			tableColumnBalanceCredit = new TableColumn(tableCurrentBalances,SWT.NULL);
			tableColumnBalanceDept = new TableColumn(tableCurrentBalances,SWT.NULL);
	
			dialogShell.setSize(new org.eclipse.swt.graphics.Point(713,497));
	
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
			cTabFolder1.setSize(new org.eclipse.swt.graphics.Point(699,439));
	
			cTabItem1.setControl(compCurCardAdd);
			cTabItem1.setText("Card Information");
	
			compCurCardAdd.setSize(new org.eclipse.swt.graphics.Point(699,422));
			compCurCardAdd.setEnabled(true);
			compCurCardAdd.layout();
	
			cTabItem2.setControl(composite1);
			cTabItem2.setText("Card Balances");
	
			composite1.setSize(new org.eclipse.swt.graphics.Point(699,422));
	
			GridData tableCurrentBalancesLData = new GridData();
			tableCurrentBalancesLData.verticalAlignment = GridData.BEGINNING;
			tableCurrentBalancesLData.horizontalAlignment = GridData.FILL;
			tableCurrentBalancesLData.widthHint = -1;
			tableCurrentBalancesLData.heightHint = 198;
			tableCurrentBalancesLData.horizontalIndent = 0;
			tableCurrentBalancesLData.horizontalSpan = 2;
			tableCurrentBalancesLData.verticalSpan = 1;
			tableCurrentBalancesLData.grabExcessHorizontalSpace = true;
			tableCurrentBalancesLData.grabExcessVerticalSpace = false;
			tableCurrentBalances.setLayoutData(tableCurrentBalancesLData);
			tableCurrentBalances.setHeaderVisible(true);
			tableCurrentBalances.setLinesVisible(true);
			tableCurrentBalances.setSize(new org.eclipse.swt.graphics.Point(673,198));
	
			tableColumnTransactionType.setText("Transaction Type");
			tableColumnTransactionType.setWidth(134);
	
			tableColumnTotalCredit.setText("Credit");
			tableColumnTotalCredit.setWidth(132);
	
			tableColumnTotalDept.setText("Dept");
			tableColumnTotalDept.setWidth(109);
	
			tableColumnBalanceCredit.setText("Balance Credit");
			tableColumnBalanceCredit.setWidth(137);
	
			tableColumnBalanceDept.setText("Balance Dept");
			tableColumnBalanceDept.setWidth(131);
			GridLayout composite1Layout = new GridLayout(2, true);
			composite1.setLayout(composite1Layout);
			composite1Layout.marginWidth = 5;
			composite1Layout.marginHeight = 5;
			composite1Layout.numColumns = 2;
			composite1Layout.makeColumnsEqualWidth = false;
			composite1Layout.horizontalSpacing = 5;
			composite1Layout.verticalSpacing = 5;
			composite1.layout();
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
			Rectangle bounds = dialogShell.computeTrim(0, 0, 713,497);
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
			
			//Hibernate.initialize(currentCard.getTurqCurrentContacts());
			Iterator it=currentCard.getTurqCurrentContacts().iterator();
			Integer currentCardId=currentCard.getCurrentCardsId();
			
			while(it.hasNext()){
				TurqCurrentContact currentContact=(TurqCurrentContact)it.next();				
				if (currentContact.getTurqCurrentCard().getCurrentCardsId()==currentCardId)
				{
					compCurCardAdd.getTxtContactPhone().setText(currentContact.getContactsPhone1());
					compCurCardAdd.getTxtContactPhone2().setText(currentContact.getContactsPhone2());
					curContact=currentContact;
					break;
				}			
			}		
			if (curContact != null){
				compCurCardAdd.getTxtContactWebSite().setText(curContact.getContactsWebSite());
				compCurCardAdd.getTxtContactName().setText(curContact.getContactsName());
				compCurCardAdd.getTxtContactAddress().setText(curContact.getContactAddress());
				compCurCardAdd.getTxtContactEmail().setText(curContact.getContactsEmail());
				compCurCardAdd.getTxtFaxNumber().setText(curContact.getContactsFaxNumber());
				compCurCardAdd.getTxtContactPhone().setText(curContact.getContactsPhone1());
				compCurCardAdd.getTxtContactPhone2().setText(curContact.getContactsPhone2());
			}
			
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
	       
	       
	        fillCurrentBalances();
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			MessageBox msg=new MessageBox(this.getParent(),SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
			
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
		//TODO add your handler code here
		try{
			if (curContact!=null){
				currentUpdate.deleteObject(curContact);
			}
			Iterator it=currentCard.getTurqCurrentCardsGroups().iterator();
			while(it.hasNext()){
				TurqCurrentCardsGroup currentGroup=(TurqCurrentCardsGroup)it.next();
				currentUpdate.deleteObject(currentGroup);
			}
			currentUpdate.deleteObject(currentCard);
			this.dialogShell.close();
			
		
		}
		catch(Exception ex){
			ex.printStackTrace();
			MessageBox msg=new MessageBox(this.getParent(),SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
		}
	}
}
