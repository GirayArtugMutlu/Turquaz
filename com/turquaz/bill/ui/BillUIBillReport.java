package com.turquaz.bill.ui;

import java.math.BigDecimal;
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



import com.turquaz.engine.ui.component.CurrencyText;
import com.turquaz.current.ui.comp.CurrentCodePicker;
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
public class BillUIBillReport extends org.eclipse.swt.widgets.Composite implements SearchComposite{
	private BillBLSearchBill blSearch = new BillBLSearchBill();
	private Calendar cal=Calendar.getInstance();
	private Composite composite1;
	private CurrentCodePicker txtCurCardEnd;
	private TableColumn tableColumnSpecialVatAmount;
	private TableColumn tableColumnVatAmount;
	private TableColumn tableColumnCumulativePrice;
	private TableColumn tableColumnCurrentName;
	private TableColumn tableColumnDocNo;
	private TableColumn tableColumnConsignmentDate;
	private Table tableBills;
	private CCombo comboBillType;
	private CLabel lblType;
	private Text txtDocNoEnd;
	private CLabel lblDocNoEnd;
	private Text txtDocNoStart;
	private CLabel lblDocNo;
	private CurrencyText txtMaxInvoiceTotal;
	private CLabel lblMaxInvoiceTotal;
	private CurrencyText txtMinInvoiceTotal;
	private CLabel lblMinInvoiceTotal;
	private DatePicker dateDueDateEnd;
	private CLabel lblDueDateEnd;
	private DatePicker dateDueDateStart;
	private CLabel lblDueDateStart;
	private DatePicker dateEndDate;
	private CLabel lblEndDate;
	private DatePicker dateStartDate;
	private CLabel lblStartDate;
	private CLabel lblCurCardEnd;
	private CurrentCodePicker txtCurCardStart;
	private CLabel lblCurrentCard;

	public BillUIBillReport(org.eclipse.swt.widgets.Composite parent, int style) {
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
				composite1LData.heightHint = 161;
				composite1LData.grabExcessHorizontalSpace = true;
				composite1LData.horizontalAlignment = GridData.FILL;
				composite1.setLayoutData(composite1LData);
				composite1.setLayout(composite1Layout);
				{
					lblCurrentCard = new CLabel(composite1, SWT.NONE);
					lblCurrentCard.setText(Messages.getString("BillUIBillReport.12")); //$NON-NLS-1$
				}
				{
					txtCurCardStart = new CurrentCodePicker(composite1, SWT.NONE);
					GridData txtCurCardLData = new GridData();
					GridData txtCurCardStartLData = new GridData();
					txtCurCardStartLData.widthHint = 156;
					txtCurCardStartLData.heightHint = 17;
					txtCurCardStart.setLayoutData(txtCurCardStartLData);
				}
				{
					lblCurCardEnd = new CLabel(composite1, SWT.NONE);
					lblCurCardEnd.setText(Messages
						.getString("BillUIBillReport.0")); //$NON-NLS-1$
				}
				{
					txtCurCardEnd = new CurrentCodePicker(composite1, SWT.NONE);
					GridData txtCurCardEndLData = new GridData();
					txtCurCardEndLData.widthHint = 156;
					txtCurCardEndLData.heightHint = 17;
					txtCurCardEnd.setLayoutData(txtCurCardEndLData);
				}
				{
					lblStartDate = new CLabel(composite1, SWT.NONE);
					lblStartDate.setText(com.turquaz.bill.Messages
						.getString("BillUIBillSearch.1")); //$NON-NLS-1$
				}
				{
					dateStartDate = new DatePicker(composite1, SWT.NONE);
					GridData dateStartDateLData = new GridData();
					GridData dateStartDateLData1 = new GridData();
					dateStartDateLData1.widthHint = 156;
					dateStartDateLData1.heightHint = 22;
					dateStartDate.setLayoutData(dateStartDateLData1);

				}
				{
					lblEndDate = new CLabel(composite1, SWT.NONE);
					lblEndDate.setText(com.turquaz.bill.Messages
						.getString("BillUIBillSearch.2")); //$NON-NLS-1$
				}
				{
					dateEndDate = new DatePicker(composite1, SWT.NONE);
					GridData dateEndDateLData = new GridData();
					dateEndDateLData.widthHint = 156;
					dateEndDateLData.heightHint = 22;
					dateEndDate.setLayoutData(dateEndDateLData);
				}
				{
					lblDueDateStart = new CLabel(composite1, SWT.NONE);
					lblDueDateStart.setText(Messages
						.getString("BillUIBillReport.1")); //$NON-NLS-1$
				}
				{
					dateDueDateStart = new DatePicker(composite1, SWT.NONE);
					GridData dateDueDateStartLData = new GridData();
					dateDueDateStartLData.widthHint = 156;
					dateDueDateStartLData.heightHint = 20;
					dateDueDateStart.setLayoutData(dateDueDateStartLData);
				}
				{
					lblDueDateEnd = new CLabel(composite1, SWT.NONE);
					lblDueDateEnd.setText(Messages
						.getString("BillUIBillReport.2")); //$NON-NLS-1$
				}
				{
					dateDueDateEnd = new DatePicker(composite1, SWT.NONE);
					GridData dateDueDateEndLData = new GridData();
					dateDueDateEndLData.widthHint = 156;
					dateDueDateEndLData.heightHint = 22;
					dateDueDateEnd.setLayoutData(dateDueDateEndLData);
				}
				{
					lblMinInvoiceTotal = new CLabel(composite1, SWT.NONE);
					lblMinInvoiceTotal.setText(Messages
						.getString("BillUIBillReport.3")); //$NON-NLS-1$
				}
				{
					txtMinInvoiceTotal = new CurrencyText(composite1, SWT.NONE);
					GridData txtMinInvoiceTotalLData = new GridData();
					txtMinInvoiceTotalLData.widthHint = 150;
					txtMinInvoiceTotalLData.heightHint = 17;
					txtMinInvoiceTotal.setLayoutData(txtMinInvoiceTotalLData);
				}
				{
					lblMaxInvoiceTotal = new CLabel(composite1, SWT.NONE);
					lblMaxInvoiceTotal.setText(Messages
						.getString("BillUIBillReport.4")); //$NON-NLS-1$
				}
				{
					txtMaxInvoiceTotal = new CurrencyText(composite1, SWT.NONE);
					GridData txtMaxInvoiceTotalLData = new GridData();
					txtMaxInvoiceTotalLData.widthHint = 150;
					txtMaxInvoiceTotalLData.heightHint = 17;
					txtMaxInvoiceTotal.setLayoutData(txtMaxInvoiceTotalLData);
				}
				{
					lblDocNo = new CLabel(composite1, SWT.NONE);
					lblDocNo.setText(Messages.getString("BillUIBillReport.5")); //$NON-NLS-1$
				}
				{
					txtDocNoStart = new Text(composite1, SWT.NONE);
					GridData txtDocNoLData = new GridData();
					GridData txtDocNoStartLData = new GridData();
					txtDocNoStartLData.widthHint = 150;
					txtDocNoStartLData.heightHint = 17;
					txtDocNoStart.setLayoutData(txtDocNoStartLData);
				}
				{
					lblDocNoEnd = new CLabel(composite1, SWT.NONE);
					lblDocNoEnd.setText(Messages
						.getString("BillUIBillReport.6")); //$NON-NLS-1$
				}
				{
					txtDocNoEnd = new Text(composite1, SWT.NONE);
					GridData txtDocNoEndLData = new GridData();
					txtDocNoEndLData.widthHint = 150;
					txtDocNoEndLData.heightHint = 17;
					txtDocNoEnd.setLayoutData(txtDocNoEndLData);
				}
				{
					lblType = new CLabel(composite1, SWT.NONE);
					lblType.setText(com.turquaz.bill.Messages
						.getString("BillUIBillSearch.3")); //$NON-NLS-1$
				}
				{
					comboBillType = new CCombo(composite1, SWT.NONE);
					GridData comboConsignmentTypeLData = new GridData();
					comboBillType.setText(Messages.getString("BillUIBillReport.11")); //$NON-NLS-1$
					comboConsignmentTypeLData.widthHint = 130;
					comboConsignmentTypeLData.heightHint = 14;
					comboBillType.setLayoutData(comboConsignmentTypeLData);
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
					tableColumnConsignmentDate
						.setText(com.turquaz.bill.Messages
							.getString("BillUIBillSearch.5")); //$NON-NLS-1$
					tableColumnConsignmentDate.setWidth(104);
					tableColumnConsignmentDate.addListener(
						SWT.Selection,
						new Listener() {
							public void handleEvent(Event e) {
								TableSorter.sortTable(
									tableBills,
									tableColumnConsignmentDate);
							}
						});
				}
				{
					tableColumnDocNo = new TableColumn(tableBills, SWT.NONE);
					tableColumnDocNo.setText(Messages
						.getString("BillUIBillReport.7")); //$NON-NLS-1$
					tableColumnDocNo.setWidth(74);
				}
				{
					tableColumnCurrentName = new TableColumn(
						tableBills,
						SWT.NONE);
					tableColumnCurrentName.setText(com.turquaz.bill.Messages
						.getString("BillUIBillSearch.6")); //$NON-NLS-1$
					tableColumnCurrentName.setWidth(150);
					tableColumnCurrentName.addListener(
						SWT.Selection,
						new Listener() {
							public void handleEvent(Event e) {
								TableSorter.sortTable(
									tableBills,
									tableColumnCurrentName);
							}
						});
				}
				{
					tableColumnCumulativePrice = new TableColumn(
						tableBills,
						SWT.RIGHT);
					tableColumnCumulativePrice
						.setText(com.turquaz.bill.Messages
							.getString("BillUIBillSearch.7")); //$NON-NLS-1$
					tableColumnCumulativePrice.setWidth(100);
					tableColumnCumulativePrice.addListener(
						SWT.Selection,
						new Listener() {
							public void handleEvent(Event e) {
								TableSorter.sortTable(
									tableBills,
									tableColumnCumulativePrice);
							}
						});
				}
				{
					tableColumnVatAmount = new TableColumn(
						tableBills,
						SWT.RIGHT);
					tableColumnVatAmount.setText(com.turquaz.bill.Messages
						.getString("BillUIBillSearch.8")); //$NON-NLS-1$
					tableColumnVatAmount.setWidth(100);
					tableColumnVatAmount.addListener(
						SWT.Selection,
						new Listener() {
							public void handleEvent(Event e) {
								TableSorter.sortTable(
									tableBills,
									tableColumnVatAmount);
							}
						});
				}
				{
					tableColumnSpecialVatAmount = new TableColumn(
						tableBills,
						SWT.RIGHT);
					tableColumnSpecialVatAmount
						.setText(com.turquaz.bill.Messages
							.getString("BillUIBillSearch.9")); //$NON-NLS-1$
					tableColumnSpecialVatAmount.setWidth(100);
					tableColumnSpecialVatAmount.addListener(
						SWT.Selection,
						new Listener() {
							public void handleEvent(Event e) {
								TableSorter.sortTable(
									tableBills,
									tableColumnSpecialVatAmount);
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
		comboBillType.add(Messages.getString("BillUIBillReport.8")); //$NON-NLS-1$
		comboBillType.setText(Messages.getString("BillUIBillReport.9")); //$NON-NLS-1$
		//dateStartDate.setDate(new Date(cal.getTime().getYear(),0,1));
		cal.set(cal.get(Calendar.YEAR),0,1);
		dateStartDate.setDate(cal.getTime());

		cal.set(cal.get(Calendar.YEAR),0,1);
		dateDueDateStart.setDate(cal.getTime());
		
		cal.add(Calendar.YEAR,1);
		cal.add(Calendar.DATE,-1);
		
		dateDueDateEnd.setDate(cal.getTime());
		
		
	
	}
	
	
	public void currentCardChoose(){
		Object data = new CurUICurrentCardSearchDialog(this.getShell(),SWT.NULL).open();
	    if(data!=null){
	   
		TurqCurrentCard curCard = (TurqCurrentCard)data;
	    txtCurCardStart.setText(curCard.getCardsCurrentCode()+" - "+curCard.getCardsName());  //$NON-NLS-1$
		txtCurCardStart.setData(curCard);
		
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
		int type=2;
		if(comboBillType.getText().equals(com.turquaz.bill.Messages.getString("BillUIBillSearch.13")))  //$NON-NLS-1$
		{
			type =1;
		}
		else if (comboBillType.getText().equals(Messages.getString("BillUIBillReport.10"))) //$NON-NLS-1$
		{
			type=0;
		}
			
		List list = blSearch.searchBillAdvanced(
				(TurqCurrentCard)txtCurCardStart.getData(),
				(TurqCurrentCard)txtCurCardEnd.getData(),
				dateStartDate.getDate(),dateEndDate.getDate(),
				dateDueDateStart.getDate(),dateDueDateEnd.getDate(),
				txtMinInvoiceTotal.getBigDecimalValue(),txtMaxInvoiceTotal.getBigDecimalValue(),
				txtDocNoStart.getText(),txtDocNoEnd.getText(),type);
		        								
		TurqBill bill;
		TableItem item;
		TurkishCurrencyFormat cf=new TurkishCurrencyFormat();
		BigDecimal total=new BigDecimal(0);
		BigDecimal VAT=new BigDecimal(0);
		BigDecimal SpecialVAT=new BigDecimal(0);
		
		for(int i=0;i<list.size();i++){
			
			bill = (TurqBill)list.get(i);
			item = new TableItem(tableBills,SWT.NULL);
			item.setData(bill);
			BigDecimal transTotal=bill.getTurqBillConsignmentCommon().getTotalAmount();
			BigDecimal transVAT=bill.getTurqBillConsignmentCommon().getVatAmount();
			BigDecimal transSpecialVAT=bill.getTurqBillConsignmentCommon().getSpecialVatAmount();
			total=total.add(transTotal);
			VAT=VAT.add(transVAT);
			SpecialVAT=SpecialVAT.add(transSpecialVAT);
			item.setText(new String[]{DatePicker.formatter.format(bill.getBillsDate()),
			        			bill.getTurqBillConsignmentCommon().getBillDocumentNo(),
									bill.getTurqBillConsignmentCommon().getTurqCurrentCard().getCardsName(),
									cf.format(transTotal),
									cf.format(transVAT),
									cf.format(transSpecialVAT)});
			
		}
		
		item=new TableItem(tableBills,SWT.NULL);
		item=new TableItem(tableBills,SWT.NULL);
		item.setText(new String[]{"","",Messages.getString("BillUIBillReport.14"),cf.format(total),cf.format(VAT),cf.format(SpecialVAT)}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			
			
			
			
			
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void tableMouseDoubleClick()
	{
		TableItem items[] = tableBills.getSelection();
		if(items.length>0)
		{
			TurqBill bill = (TurqBill)items[0].getData();
			if (bill!=null)
			{
				initializeBill(bill);
				boolean updated=new BillUIBillUpdateDialog(this.getShell(),SWT.NULL,bill).open();
				if (updated)
					search();    		   
			}
		}
	}
	public void printTable(){
	    EngBLUtils.printTable(tableBills,Messages.getString("BillUIBillSearch.16")); //$NON-NLS-1$
	    
	}
	
	
	
	
	
	
	
	
	
	
	

}
