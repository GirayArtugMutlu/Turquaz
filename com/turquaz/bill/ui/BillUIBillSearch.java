package com.turquaz.bill.ui;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;


import org.eclipse.swt.widgets.TableItem;

import org.eclipse.swt.widgets.Composite;

import com.turquaz.bill.Messages;
import com.turquaz.bill.bl.BillBLSearchBill;
import com.turquaz.bill.bl.BillBLUpdateBill;
import com.turquaz.current.ui.CurUICurrentCardSearchDialog;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.TableSorter;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.current.ui.comp.CurrentPicker;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;

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
public class BillUIBillSearch extends org.eclipse.swt.widgets.Composite implements SearchComposite{
	private Composite composite1;
	private Table tableBills;
	private TableColumn tableColumnCurrentName;
	private TableColumn tableColumnVatAmount;
	private CurrentPicker txtCurCard;
	private TableColumn tableColumnDocNo;
	private Text txtDocNo;
	private CLabel lblDocNo;
	private CCombo comboBillType;
	private CLabel lblType;
	private CLabel lblEndDate;
	private DatePicker dateEndDate;
	private DatePicker dateStartDate;
	private CLabel lblStartDate;
	private CLabel lblCurrentCard;
	private TableColumn tableColumnSpecialVatAmount;
	private TableColumn tableColumnCumulativePrice;
	private TableColumn tableColumnConsignmentDate;
	private BillBLSearchBill blSearch = new BillBLSearchBill();
	private Calendar cal=Calendar.getInstance();

	
	public BillUIBillSearch(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setSize(591, 344);
			{
				composite1 = new Composite(this, SWT.NONE);
				GridLayout composite1Layout = new GridLayout();
				composite1Layout.numColumns = 4;
				GridData composite1LData = new GridData();
				composite1LData.heightHint = 96;
				composite1LData.grabExcessHorizontalSpace = true;
				composite1LData.horizontalAlignment = GridData.FILL;
				composite1.setLayoutData(composite1LData);
				composite1.setLayout(composite1Layout);
                {
                    lblDocNo = new CLabel(composite1, SWT.NONE);
                    lblDocNo.setText("Belge No");
                }
                {
                    txtDocNo = new Text(composite1, SWT.NONE);
                    GridData txtDocNoLData = new GridData();
                    txtDocNoLData.horizontalSpan = 3;
                    txtDocNoLData.widthHint = 115;
                    txtDocNoLData.heightHint = 15;
                    txtDocNo.setLayoutData(txtDocNoLData);
                }
				{
					lblCurrentCard = new CLabel(composite1, SWT.NONE);
					lblCurrentCard.setText(com.turquaz.bill.Messages.getString("BillUIBillSearch.0"));  //$NON-NLS-1$
					GridData lblCurrentCardLData = new GridData();
					lblCurrentCardLData.widthHint = 109;
					lblCurrentCardLData.heightHint = 18;
					lblCurrentCard.setLayoutData(lblCurrentCardLData);
				}
				{
					txtCurCard = new CurrentPicker(composite1, SWT.NONE);
					GridData txtCurCardLData = new GridData();
					
					txtCurCardLData.widthHint = 160;
					txtCurCardLData.heightHint = 20;
					txtCurCard.setLayoutData(txtCurCardLData);
				}
				{
					lblType = new CLabel(composite1, SWT.NONE);
					lblType.setText(com.turquaz.bill.Messages
						.getString("BillUIBillSearch.3")); //$NON-NLS-1$
					GridData lblTypeLData = new GridData();
					lblTypeLData.widthHint = 74;
					lblTypeLData.heightHint = 21;
					lblType.setLayoutData(lblTypeLData);
				}
				{
					comboBillType = new CCombo(composite1, SWT.NONE);
					GridData comboConsignmentTypeLData = new GridData();
					comboBillType.setText(com.turquaz.bill.Messages
						.getString("BillUIBillSearch.4")); //$NON-NLS-1$
					comboConsignmentTypeLData.widthHint = 72;
					comboConsignmentTypeLData.heightHint = 16;
					comboBillType.setLayoutData(comboConsignmentTypeLData);
				}
				{
					lblStartDate = new CLabel(composite1, SWT.NONE);
					lblStartDate.setText(com.turquaz.bill.Messages.getString("BillUIBillSearch.1"));  //$NON-NLS-1$
					GridData lblStartDateLData = new GridData();
					lblStartDateLData.widthHint = 109;
					lblStartDateLData.heightHint = 17;
					lblStartDate.setLayoutData(lblStartDateLData);
				}
				{
					dateStartDate = new DatePicker(composite1, SWT.NONE);
					GridData dateStartDateLData = new GridData();
					dateStartDateLData.widthHint = 141;
					dateStartDateLData.heightHint = 22;
					dateStartDate.setLayoutData(dateStartDateLData);
				}
				{
					lblEndDate = new CLabel(composite1, SWT.NONE);
					lblEndDate.setText(com.turquaz.bill.Messages.getString("BillUIBillSearch.2"));  //$NON-NLS-1$
					GridData lblEndDateLData = new GridData();
					lblEndDateLData.widthHint = 105;
					lblEndDateLData.heightHint = 19;
					lblEndDate.setLayoutData(lblEndDateLData);
				}
				{
					dateEndDate = new DatePicker(composite1, SWT.NONE);
					GridData dateEndDateLData = new GridData();
					dateEndDateLData.widthHint = 140;
					dateEndDateLData.heightHint = 22;
					dateEndDate.setLayoutData(dateEndDateLData);
				}
			}
			{
				tableBills = new Table(this, SWT.FULL_SELECTION);
				GridData tableConsignmentsLData = new GridData();
				tableBills.addMouseListener(new MouseAdapter() {
					public void mouseDoubleClick(MouseEvent evt) {
						tableMouseDoubleClick();
					}
				});
				tableBills.setHeaderVisible(true);
				tableBills.setLinesVisible(true);
				tableConsignmentsLData.grabExcessHorizontalSpace = true;
				tableConsignmentsLData.horizontalAlignment = GridData.FILL;
				tableConsignmentsLData.verticalAlignment = GridData.FILL;
				tableConsignmentsLData.grabExcessVerticalSpace = true;
				tableBills.setLayoutData(tableConsignmentsLData);
				{
					tableColumnConsignmentDate = new TableColumn(
						tableBills,
						SWT.NONE);
					tableColumnConsignmentDate.setText(com.turquaz.bill.Messages.getString("BillUIBillSearch.5"));  //$NON-NLS-1$
					tableColumnConsignmentDate.setWidth(104);
					tableColumnConsignmentDate.addListener(SWT.Selection, new Listener() {
					    public void handleEvent(Event e) {
					    	TableSorter.sortTable(tableBills,tableColumnConsignmentDate);        
					    }
					});
				}
                {
                    tableColumnDocNo = new TableColumn(tableBills, SWT.NONE);
                    tableColumnDocNo.setText("Belge No");
                    tableColumnDocNo.setWidth(74);
                }
				{
					tableColumnCurrentName = new TableColumn(
						tableBills,
						SWT.NONE);
					tableColumnCurrentName.setText(com.turquaz.bill.Messages.getString("BillUIBillSearch.6"));  //$NON-NLS-1$
					tableColumnCurrentName.setWidth(150);
					tableColumnCurrentName.addListener(SWT.Selection, new Listener() {
					    public void handleEvent(Event e) {
					    	TableSorter.sortTable(tableBills,tableColumnCurrentName);        
					    }
					});
				}
				{
					tableColumnCumulativePrice = new TableColumn(
						tableBills,
						SWT.RIGHT);
					tableColumnCumulativePrice.setText(com.turquaz.bill.Messages.getString("BillUIBillSearch.7"));  //$NON-NLS-1$
					tableColumnCumulativePrice.setWidth(100);
					tableColumnCumulativePrice.addListener(SWT.Selection, new Listener() {
					    public void handleEvent(Event e) {
					    	TableSorter.sortTable(tableBills,tableColumnCumulativePrice);        
					    }
					});
				}
				{
					tableColumnVatAmount = new TableColumn(
						tableBills,
						SWT.RIGHT);
					tableColumnVatAmount.setText(com.turquaz.bill.Messages.getString("BillUIBillSearch.8"));  //$NON-NLS-1$
					tableColumnVatAmount.setWidth(100);
					tableColumnVatAmount.addListener(SWT.Selection, new Listener() {
					    public void handleEvent(Event e) {
					    	TableSorter.sortTable(tableBills,tableColumnVatAmount);        
					    }
					});
				}
				{
					tableColumnSpecialVatAmount = new TableColumn(
						tableBills,
						SWT.RIGHT);
					tableColumnSpecialVatAmount.setText(com.turquaz.bill.Messages.getString("BillUIBillSearch.9"));  //$NON-NLS-1$
					tableColumnSpecialVatAmount.setWidth(100);
					tableColumnSpecialVatAmount.addListener(SWT.Selection, new Listener() {
					    public void handleEvent(Event e) {
					    	TableSorter.sortTable(tableBills,tableColumnSpecialVatAmount);        
					    }
					});
				}
			}
			postInitGui();
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void postInitGui(){
		comboBillType.add(com.turquaz.bill.Messages.getString("BillUIBillSearch.10"));  //$NON-NLS-1$
		comboBillType.add(com.turquaz.bill.Messages.getString("BillUIBillSearch.11"));  //$NON-NLS-1$
		//dateStartDate.setDate(new Date(cal.getTime().getYear(),0,1));
		cal.set(cal.get(Calendar.YEAR),0,1);
		dateStartDate.setDate(cal.getTime());

	
	}
	
	
	public void currentCardChoose(){
		Object data = new CurUICurrentCardSearchDialog(this.getShell(),SWT.NULL).open();
	    if(data!=null){
	   
		TurqCurrentCard curCard = (TurqCurrentCard)data;
	    txtCurCard.setText(curCard.getCardsCurrentCode()+" - "+curCard.getCardsName());  //$NON-NLS-1$
		txtCurCard.setData(curCard);
		
	    }
		
	}
	
	
	public void save(){
		
	}
	
	public void initializeBill(TurqBill bill){
	    try{
	        
	        blSearch.initializeBill(bill);
	    }
	    catch(Exception ex){
	        ex.printStackTrace();
	    }
	}
	public void search(){
		
		try{
			
		tableBills.removeAll();	
		int type=0;
		if(comboBillType.getText().equals(com.turquaz.bill.Messages.getString("BillUIBillSearch.13")))  //$NON-NLS-1$
		{
			type =1;
		}
			
		List list = blSearch.searchBill((TurqCurrentCard)txtCurCard.getData(),
		        								txtDocNo.getText().trim(),
												dateStartDate.getDate(),
												dateEndDate.getDate(),type);
		TurqBill bill;
		TableItem item;
		TurkishCurrencyFormat cf=new TurkishCurrencyFormat();
		for(int i=0;i<list.size();i++){
			
			bill = (TurqBill)list.get(i);
			item = new TableItem(tableBills,SWT.NULL);
			item.setData(bill);
			item.setText(new String[]{DatePicker.formatter.format(bill.getBillsDate()),
			        			bill.getTurqBillConsignmentCommon().getBillDocumentNo(),
									bill.getTurqBillConsignmentCommon().getTurqCurrentCard().getCardsName(),
									cf.format(bill.getTurqBillConsignmentCommon().getTotalAmount()),
									cf.format(bill.getTurqBillConsignmentCommon().getVatAmount()),
									cf.format(bill.getTurqBillConsignmentCommon().getSpecialVatAmount())});
			
		}
			
			
			
			
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		
		
	}
	public void newForm(){
		
	}
	public void delete(){
	    
	MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
	BillBLUpdateBill blUpdateBill = new BillBLUpdateBill();
	    try{
	        TableItem items[] = tableBills.getSelection();
	        if(items.length>0){
	           
	           TurqBill bill = (TurqBill)items[0].getData();
	         
	           if(blSearch.canUpdateBill(bill)){
	               //delete Consignment Group
	               MessageBox msg2 = new MessageBox(this.getShell(), SWT.OK | SWT.CANCEL);
	               msg2.setMessage(Messages.getString("BillUIBillSearch.12")); //$NON-NLS-1$
	               if(msg2.open()==SWT.OK){
					initializeBill(bill);
	                Iterator it = bill.getTurqBillInGroups().iterator();
					while(it.hasNext()){
					    
						blUpdateBill.deleteObject(it.next());
					    				
					}
					
					blUpdateBill.deleteAccountingTransactions(bill);
					blUpdateBill.deleteCurrentTransactions(bill);
				
					blUpdateBill.deleteObject(bill); 
					msg.setMessage(Messages.getString("BillUIBillSearch.14")); //$NON-NLS-1$
	                msg.open();
	                search();
	               }
	               
	               
	           
	           }
	           else{
	               MessageBox msg3 = new MessageBox(this.getShell(),SWT.ICON_WARNING);
	               msg3.setMessage(Messages.getString("BillUIBillSearch.15")); //$NON-NLS-1$
	               msg3.open();
	               return;
	           }
	            
	            
	            
	        }
	        
	        
	        
	    }
	    catch(Exception ex){
	        
	        ex.printStackTrace();
	    }
	    
	    
		
	}
	
	public void exportToExcel(){
		
		EngBLUtils.Export2Excel(tableBills);
		
	}
	
	public void tableMouseDoubleClick(){
		TableItem items[] = tableBills.getSelection();
		if(items.length>0){
		TurqBill bill = (TurqBill)items[0].getData();
		initializeBill(bill);
		boolean updated=new BillUIBillUpdateDialog(this.getShell(),SWT.NULL,bill).open();
		if (updated)
			search();
		    
		    
		    
		   
		}
	}
	public void printTable(){
	    EngBLUtils.printTable(tableBills,Messages.getString("BillUIBillSearch.16")); //$NON-NLS-1$
	    
	}

}
