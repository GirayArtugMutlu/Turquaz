package com.turquaz.consignment.ui;
/************************************************************************/
/* TURQUAZ: Higly Modular Accounting/ERP Program                        */
/* ============================================                         */
/* Copyright (c) 2004 by Turquaz Software Development Group			    */
/*																		*/
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or    */
/* (at your option) any later version.       							*/
/* 																		*/
/* This program is distributed in the hope that it will be useful,		*/
/* but WITHOUT ANY WARRANTY; without even the implied warranty of		*/
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the		*/
/* GNU General Public License for more details.         				*/
/************************************************************************/
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;

import com.turquaz.consignment.Messages;
import com.turquaz.consignment.bl.ConBLSearchConsignment;
import com.turquaz.consignment.bl.ConBLUpdateConsignment;
import com.turquaz.current.ui.CurUICurrentCardSearchDialog;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.TableSorter;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;

import com.turquaz.current.ui.comp.CurrentPicker;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.graphics.Rectangle;
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
public class ConUIConsignmentSearch extends org.eclipse.swt.widgets.Composite implements
SearchComposite{
	private Composite composite1;
	private Table tableConsignments;
	private TableColumn tableColumnCurrentName;
	private TableColumn tableColumnVatAmount;
	private CurrentPicker txtCurCard;
	private CCombo comboConsignmentType;
	private CLabel lblType;
	private CLabel lblEndDate;
	private DatePicker dateEndDate;
	private DatePicker dateStartDate;
	private CLabel lblStartDate;
	private CLabel lblCurrentCard;
	private TableColumn tableColumnSpecialVatAmount;
	private TableColumn tableColumnCumulativePrice;
	private TableColumn tableColumnConsignmentDate;
	private ConBLSearchConsignment blSearch = new ConBLSearchConsignment();
	private Calendar cal=Calendar.getInstance();

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void main(String[] args) {
		showGUI();
	}
		
	/**
	* Auto-generated method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void showGUI() {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		ConUIConsignmentSearch inst = new ConUIConsignmentSearch(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if(size.x == 0 && size.y == 0) {
			inst.pack();
			shell.pack();
		} else {
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			int MENU_HEIGHT = 22;
			if (shell.getMenuBar() != null)
				shellBounds.height -= MENU_HEIGHT;
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public ConUIConsignmentSearch(org.eclipse.swt.widgets.Composite parent, int style) {
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
				composite1Layout.horizontalSpacing = 0;
				GridData composite1LData = new GridData();
				composite1LData.heightHint = 88;
				composite1LData.grabExcessHorizontalSpace = true;
				composite1LData.horizontalAlignment = GridData.FILL;
				composite1.setLayoutData(composite1LData);
				composite1.setLayout(composite1Layout);
				{
					lblCurrentCard = new CLabel(composite1, SWT.NONE);
					lblCurrentCard.setText(Messages.getString("ConUIConsignmentSearch.0")); //$NON-NLS-1$
					GridData lblCurrentCardLData = new GridData();
					lblCurrentCardLData.widthHint = 109;
					lblCurrentCardLData.heightHint = 18;
					lblCurrentCard.setLayoutData(lblCurrentCardLData);
				}
				{
					txtCurCard = new CurrentPicker(composite1, SWT.NONE);
					GridData txtCurCardLData = new GridData();
					txtCurCardLData.widthHint = 186;
					txtCurCardLData.heightHint = 20;
					txtCurCard.setLayoutData(txtCurCardLData);
					
				}
				{
					lblType = new CLabel(composite1, SWT.NONE);
					lblType.setText(Messages
						.getString("ConUIConsignmentSearch.3")); //$NON-NLS-1$
					GridData lblTypeLData = new GridData();
					lblTypeLData.widthHint = 74;
					lblTypeLData.heightHint = 21;
					lblType.setLayoutData(lblTypeLData);
				}
				{
					comboConsignmentType = new CCombo(composite1, SWT.NONE);
					GridData comboConsignmentTypeLData = new GridData();
					comboConsignmentType.setText(Messages
						.getString("ConUIConsignmentSearch.4")); //$NON-NLS-1$
					comboConsignmentTypeLData.widthHint = 73;
					comboConsignmentTypeLData.heightHint = 18;
					comboConsignmentType
						.setLayoutData(comboConsignmentTypeLData);
				}
				{
					lblStartDate = new CLabel(composite1, SWT.NONE);
					lblStartDate.setText(Messages.getString("ConUIConsignmentSearch.1")); //$NON-NLS-1$
					GridData lblStartDateLData = new GridData();
					lblStartDateLData.widthHint = 109;
					lblStartDateLData.heightHint = 17;
					lblStartDate.setLayoutData(lblStartDateLData);
				}
				{
					dateStartDate = new DatePicker(composite1, SWT.NONE);
					GridData dateStartDateLData = new GridData();
					dateStartDateLData.widthHint = 141;
					dateStartDateLData.heightHint = 31;
					dateStartDate.setLayoutData(dateStartDateLData);
				}
				{
					lblEndDate = new CLabel(composite1, SWT.NONE);
					lblEndDate.setText(Messages.getString("ConUIConsignmentSearch.2")); //$NON-NLS-1$
					GridData lblEndDateLData = new GridData();
					lblEndDateLData.widthHint = 105;
					lblEndDateLData.heightHint = 19;
					lblEndDate.setLayoutData(lblEndDateLData);
				}
				{
					dateEndDate = new DatePicker(composite1, SWT.NONE);
					GridData dateEndDateLData = new GridData();
					dateEndDateLData.widthHint = 143;
					dateEndDateLData.heightHint = 31;
					dateEndDate.setLayoutData(dateEndDateLData);
				}
			}
			{
				tableConsignments = new Table(this, SWT.FULL_SELECTION);
				GridData tableConsignmentsLData = new GridData();
				tableConsignments.addMouseListener(new MouseAdapter() {
					public void mouseDoubleClick(MouseEvent evt) {
						tableMouseDoubleClick();
					}
				});
				tableConsignments.setHeaderVisible(true);
				tableConsignments.setLinesVisible(true);
				tableConsignmentsLData.grabExcessHorizontalSpace = true;
				tableConsignmentsLData.horizontalAlignment = GridData.FILL;
				tableConsignmentsLData.verticalAlignment = GridData.FILL;
				tableConsignmentsLData.grabExcessVerticalSpace = true;
				tableConsignments.setLayoutData(tableConsignmentsLData);
				{
					tableColumnConsignmentDate = new TableColumn(
						tableConsignments,
						SWT.NONE);
					tableColumnConsignmentDate.setText(Messages.getString("ConUIConsignmentSearch.5")); //$NON-NLS-1$
					tableColumnConsignmentDate.setWidth(104);
					tableColumnConsignmentDate.addListener(SWT.Selection, new Listener() {
					    public void handleEvent(Event e) {
					    	TableSorter.sortTable(tableConsignments,tableColumnConsignmentDate);        
					    }
					});
				}
				{
					tableColumnCurrentName = new TableColumn(
						tableConsignments,
						SWT.NONE);
					tableColumnCurrentName.setText(Messages.getString("ConUIConsignmentSearch.6")); //$NON-NLS-1$
					tableColumnCurrentName.setWidth(150);
					tableColumnCurrentName.addListener(SWT.Selection, new Listener() {
					    public void handleEvent(Event e) {
					    	TableSorter.sortTable(tableConsignments,tableColumnCurrentName);        
					    }
					});
				}
				{
					tableColumnCumulativePrice = new TableColumn(
						tableConsignments,
						SWT.RIGHT);
					tableColumnCumulativePrice.setText(Messages.getString("ConUIConsignmentSearch.7")); //$NON-NLS-1$
					tableColumnCumulativePrice.setWidth(100);
					tableColumnCumulativePrice.addListener(SWT.Selection, new Listener() {
					    public void handleEvent(Event e) {
					    	TableSorter.sortTable(tableConsignments,tableColumnCumulativePrice);        
					    }
					});
				}
				{
					tableColumnVatAmount = new TableColumn(
						tableConsignments,
						SWT.RIGHT);
					tableColumnVatAmount.setText(Messages.getString("ConUIConsignmentSearch.8")); //$NON-NLS-1$
					tableColumnVatAmount.setWidth(100);
					tableColumnVatAmount.addListener(SWT.Selection, new Listener() {
					    public void handleEvent(Event e) {
					    	TableSorter.sortTable(tableConsignments,tableColumnVatAmount);        
					    }
					});
				}
				{
					tableColumnSpecialVatAmount = new TableColumn(
						tableConsignments,
						SWT.RIGHT);
					tableColumnSpecialVatAmount.setText(Messages.getString("ConUIConsignmentSearch.9")); //$NON-NLS-1$
					tableColumnSpecialVatAmount.setWidth(100);
					tableColumnSpecialVatAmount.addListener(SWT.Selection, new Listener() {
					    public void handleEvent(Event e) {
					    	TableSorter.sortTable(tableConsignments,tableColumnSpecialVatAmount);        
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
		comboConsignmentType.add(Messages.getString("ConUIConsignmentSearch.10")); //$NON-NLS-1$
		comboConsignmentType.add(Messages.getString("ConUIConsignmentSearch.11")); //$NON-NLS-1$
		//dateStartDate.setDate(new Date(cal.getTime().getYear(),0,1));
		cal.set(cal.get(Calendar.YEAR),0,1);
		dateStartDate.setDate(cal.getTime());
		
	
	}
	
	
	public void currentCardChoose(){
		Object data = new CurUICurrentCardSearchDialog(this.getShell(),SWT.NULL).open();
	    if(data!=null){
	    
		TurqCurrentCard curCard = (TurqCurrentCard)data;
	    txtCurCard.setText(curCard.getCardsCurrentCode()+" - "+curCard.getCardsName()); //$NON-NLS-1$
		txtCurCard.setData(curCard);
		
	    }
		
	}
	
	
	public void save(){
		
	}
	public void search(){
		
		try{
			
		tableConsignments.removeAll();	
		int type=0;
		if(comboConsignmentType.getText().equals(Messages.getString("ConUIConsignmentSearch.12"))) //$NON-NLS-1$
		{
			type =1;
		}
			
		List list = blSearch.searchConsignment((TurqCurrentCard)txtCurCard.getData(),
												dateStartDate.getDate(),
												dateEndDate.getDate(),type);
		TurqConsignment cons;
		TableItem item;
		TurkishCurrencyFormat cf=new TurkishCurrencyFormat();
		for(int i=0;i<list.size();i++){
			
			cons = (TurqConsignment)list.get(i);
			item = new TableItem(tableConsignments,SWT.NULL);
			item.setData(cons);
			item.setText(new String[]{DatePicker.formatter.format(cons.getConsignmentsDate()),
									cons.getTurqBillConsignmentCommon().getTurqCurrentCard().getCardsName(),
									cf.format(cons.getTurqBillConsignmentCommon().getTotalAmount()),
									cf.format(cons.getTurqBillConsignmentCommon().getVatAmount()),
									cf.format(cons.getTurqBillConsignmentCommon().getSpecialVatAmount())});
			
		}
			
			
			
			
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		
		
	}
	public void newForm(){
		
	}
	public void delete(){
	    
	    ConBLUpdateConsignment blUpdate = new ConBLUpdateConsignment();
	   
	    TableItem items[] = tableConsignments.getSelection();
		if(items.length>0){
		    TurqConsignment cons = (TurqConsignment)items[0].getData();
			MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
			try{
			    //first fill cons then delete..
			  ConBLUpdateConsignment.initiliazeConsignment(cons); 
		    if(cons.getTurqBillConsignmentCommon().getTurqBills().isEmpty()){
		    
				MessageBox msg2 = new MessageBox(this.getShell(),SWT.CANCEL|SWT.OK);
				msg2.setMessage(Messages.getString("ConUIConsignmentUpdateDialog.9")); //$NON-NLS-1$
		
					if(msg2.open()==SWT.OK){
						
					  
					 
					    
						//delete Consignment Group
						Iterator it = cons.getTurqConsignmentsInGroups().iterator();
						while(it.hasNext()){
							blUpdate.deleteObject(it.next());
												
						}
						
//						delete Inventory Transaction
						it = cons.getTurqEngineSequence().getTurqInventoryTransactions().iterator();
						while(it.hasNext()){
							blUpdate.deleteObject(it.next());
												
						}						
						
						Object o = cons.getTurqBillConsignmentCommon();
						
							blUpdate.deleteObject(cons);
							blUpdate.deleteObject(o);
						
						msg.setMessage(Messages.getString("ConUIConsignmentUpdateDialog.10")); //$NON-NLS-1$
						msg.open();
						search();
						
						
						//delete consignment 
						
					}
					
					
					
				
		        
		        
		    }
		    else{
		       msg = new MessageBox(this.getShell(),SWT.ICON_INFORMATION);
		       msg.setMessage(Messages.getString("ConUIConsignmentSearch.13")); //$NON-NLS-1$
		       msg.open();
		    }
			}
			catch(Exception ex){
				
				ex.printStackTrace();
				msg.setMessage(ex.getMessage());
				msg.open();
			}
		}  
	    
	    
	    
		
	}
	
	public void exportToExcel(){
		
		EngBLUtils.Export2Excel(tableConsignments);
		
	}
	ConBLUpdateConsignment blUpdate = new ConBLUpdateConsignment();
	public void tableMouseDoubleClick(){
		TableItem items[] = tableConsignments.getSelection();
		if(items.length>0){
		    TurqConsignment cons = (TurqConsignment)items[0].getData();
		  
		
		        boolean updated=new ConUIConsignmentUpdateDialog(this.getShell(),SWT.NULL,cons).open();
		        if (updated)
		        	search();
		  
		}
	}
	public void printTable(){
	    EngBLUtils.printTable(tableConsignments,Messages.getString("ConUIConsignmentSearch.14")); //$NON-NLS-1$
	    
	}
}
