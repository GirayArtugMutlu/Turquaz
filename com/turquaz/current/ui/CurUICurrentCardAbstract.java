package com.turquaz.current.ui;
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



import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;


import org.eclipse.swt.layout.GridData;

import com.turquaz.current.ui.comp.CurrentPicker;
import com.turquaz.current.Messages;
import com.turquaz.current.bl.CurBLSearchTransaction;
import com.turquaz.engine.dal.EngDALConnection;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;

import org.eclipse.swt.custom.CLabel;

import com.turquaz.engine.ui.component.DatePicker;
import com.jasperassistant.designer.viewer.ViewerComposite;
public class CurUICurrentCardAbstract extends org.eclipse.swt.widgets.Composite implements SearchComposite{
	private Composite compSearch;
	private CurrentPicker txtCurrentCard2;
	private CLabel lblCurCard2;
	private CLabel lblCurrentCard;
	private CurrentPicker txtCurrentCard;
	private DatePicker datePickerEndDate;
	private ViewerComposite viewer;
	private CLabel lblEndDate;
	private DatePicker datePickerStartDate;
	private CLabel lblStartDate;
	private CurBLSearchTransaction BLsearch=new CurBLSearchTransaction();
	private TurqCurrentCard currentCard=null;
	private TurqCurrentCard currentCard2=null;
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
		CurUICurrentCardAbstract inst = new CurUICurrentCardAbstract(shell, SWT.NULL);
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

	public CurUICurrentCardAbstract(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setSize(880, 283);
			{
				compSearch = new Composite(this, SWT.NONE);
				GridLayout compSearchLayout = new GridLayout();
				GridData compSearchLData = new GridData();
				compSearchLData.grabExcessHorizontalSpace = true;
				compSearchLData.horizontalAlignment = GridData.FILL;
				compSearchLData.heightHint = 72;
				compSearch.setLayoutData(compSearchLData);
				compSearchLayout.numColumns = 4;
				compSearch.setLayout(compSearchLayout);
				{
					lblCurrentCard = new CLabel(compSearch, SWT.NONE);
					lblCurrentCard.setText(Messages.getString("CurUICurrentCardAbstract.0")); //$NON-NLS-1$
					GridData lblCurrentCardLData = new GridData();
					lblCurrentCardLData.widthHint = 120;
					lblCurrentCardLData.heightHint = 18;
					lblCurrentCard.setLayoutData(lblCurrentCardLData);
				}
				{
					txtCurrentCard = new CurrentPicker(compSearch, SWT.NONE);
					GridData txtCurrentCardLData = new GridData();
					txtCurrentCardLData.widthHint = 237;
					txtCurrentCardLData.heightHint = 15;
					txtCurrentCard.setLayoutData(txtCurrentCardLData);
					
				}
				{
					lblCurCard2 = new CLabel(compSearch, SWT.NONE);
					lblCurCard2.setText(Messages.getString("CurUICurrentCardAbstract.3")); //$NON-NLS-1$
				}
				{
					txtCurrentCard2 = new CurrentPicker(compSearch, SWT.NONE);
					GridData txtCurrentCard2LData = new GridData();
					txtCurrentCard2.setSize(237, 15);
					txtCurrentCard2LData.widthHint = 237;
					txtCurrentCard2LData.heightHint = 15;
					txtCurrentCard2.setLayoutData(txtCurrentCard2LData);
				}
				{
					lblStartDate = new CLabel(compSearch, SWT.NONE);
					lblStartDate.setText(Messages.getString("CurUICurrentCardAbstract.1")); //$NON-NLS-1$
					GridData lblStartDateLData = new GridData();
					lblStartDateLData.widthHint = 96;
					lblStartDateLData.heightHint = 18;
					lblStartDate.setLayoutData(lblStartDateLData);
				}
				{
					datePickerStartDate = new DatePicker(compSearch, SWT.NONE);
					GridData datePickerStartDateLData = new GridData();
					datePickerStartDateLData.widthHint = 103;
					datePickerStartDateLData.heightHint = 23;
					datePickerStartDate.setLayoutData(datePickerStartDateLData);
				}
				{
					lblEndDate = new CLabel(compSearch, SWT.NONE);
					lblEndDate.setText(Messages.getString("CurUICurrentCardAbstract.2")); //$NON-NLS-1$
					GridData lblEndDateLData = new GridData();
					lblEndDateLData.widthHint = 77;
					lblEndDateLData.heightHint = 20;
					lblEndDate.setLayoutData(lblEndDateLData);
				}
				{
					datePickerEndDate = new DatePicker(compSearch, SWT.NONE);
					GridData datePickerEndDateLData = new GridData();
					datePickerEndDateLData.widthHint = 103;
					datePickerEndDateLData.heightHint = 24;
					datePickerEndDate.setLayoutData(datePickerEndDateLData);
				}
				}
				{
					viewer = new ViewerComposite(this, SWT.NONE);
					GridData viewerLData = new GridData();
					viewerLData.grabExcessHorizontalSpace = true;
					viewerLData.horizontalAlignment = GridData.FILL;
					viewerLData.grabExcessVerticalSpace = true;
					viewerLData.verticalAlignment = GridData.FILL;
					viewer.setLayoutData(viewerLData);
				}

			postInitGui();
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void postInitGui(){
	    
		datePickerStartDate.setDate(new Date(cal.getTime().getYear(),0,1));

	}
	
	public void exportToExcel()
	{
		
	}
	
	public void delete()
	{
		
	}
	
	public void search()
	{
		try
		{
			MessageBox msg=new MessageBox(this.getShell(),SWT.NULL);
			currentCard=null;
			currentCard2=null;
			if (txtCurrentCard.getData()== null && txtCurrentCard2.getData()== null)
			{
		    	msg.setMessage(Messages.getString("CurUICurrentCardAbstract.4")); //$NON-NLS-1$
		    	msg.open();
		    	txtCurrentCard.setFocus();
		    	return ; 
			}
			else if (txtCurrentCard.getData()==null)
			{
				currentCard=(TurqCurrentCard)txtCurrentCard2.getData();
				currentCard2=null;
			}
			else if (txtCurrentCard2.getData()==null)
			{
				currentCard=(TurqCurrentCard)txtCurrentCard.getData();
				currentCard2=null;
			}
			else
			{
				currentCard=(TurqCurrentCard)txtCurrentCard.getData();
				currentCard2=(TurqCurrentCard)txtCurrentCard2.getData();
			}			
			Map parameters = new HashMap();		
			SimpleDateFormat dformat=new SimpleDateFormat("yyyy-MM-dd");  //$NON-NLS-1$
			String sqlparam="Select trans.transactions_date, trans.transactions_document_no," + //$NON-NLS-1$
			" trans.current_transactions_id as transId, " + //$NON-NLS-1$
			" transtype.transaction_type_name, trans.transactions_definition," + //$NON-NLS-1$
			" trans.transactions_total_dept, trans.transactions_total_credit," + //$NON-NLS-1$
			" curCard.cards_current_code, curCard.cards_name" + //$NON-NLS-1$
			" from turq_current_transactions trans, turq_current_transaction_types transtype," + //$NON-NLS-1$
			" turq_current_cards curCard" + //$NON-NLS-1$
			" where trans.current_transaction_types_id=transtype.current_transaction_types_id" + //$NON-NLS-1$
			" and trans.current_cards_id=curCard.current_cards_id"+ //$NON-NLS-1$
			" and trans.transactions_date >="+"'"+dformat.format(datePickerStartDate.getDate())+"'"+ //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			" and trans.transactions_date <="+"'"+dformat.format(datePickerEndDate.getDate())+"'"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			if (currentCard2==null)
			{
				sqlparam +=
					" and curCard.current_cards_id="+currentCard.getCurrentCardsId().intValue(); //$NON-NLS-1$
			}
			else
			{
				sqlparam+=
					" and curCard.cards_current_code >= "+"'"+currentCard.getCardsCurrentCode()+"'"+ //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					" and curCard.cards_current_code <= "+"'"+currentCard2.getCardsCurrentCode()+"'";				 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			}
			sqlparam += " order by curCard.cards_current_code"; //$NON-NLS-1$
			//System.out.println(sqlparam);
			SimpleDateFormat dformat2=new SimpleDateFormat("dd/MM/yyyy");  //$NON-NLS-1$
			parameters.put("sqlparam",sqlparam);  //$NON-NLS-1$
			parameters.put("startDate",dformat2.format(datePickerStartDate.getDate()));  //$NON-NLS-1$
			parameters.put("endDate",dformat2.format(datePickerEndDate.getDate())); 			  //$NON-NLS-1$
			parameters.put("dformat",dformat2);  //$NON-NLS-1$
			parameters.put("currentCard1",currentCard.getCardsCurrentCode()); //$NON-NLS-1$
			parameters.put("currentCard2",(currentCard2==null)? "" : currentCard2.getCardsCurrentCode());  //$NON-NLS-1$ //$NON-NLS-2$
			parameters.put("formatter", new TurkishCurrencyFormat());  //$NON-NLS-1$
			
			List balances = BLsearch.getCurrentBalances(currentCard,currentCard2,datePickerStartDate.getDate());
			HashMap balanceList=new HashMap();
			for (int k=0; k < balances.size(); k++)
			{
				Object[] balanceArr=(Object[])balances.get(k);
				balanceList.put((String)balanceArr[0],((BigDecimal)balanceArr[2]).subtract(((BigDecimal)balanceArr[1])));
			}
			parameters.put("balanceList",balanceList); //$NON-NLS-1$
			//parameters.put("balances",balances);
			EngDALConnection db=new EngDALConnection();
			db.connect();
		
			JasperReport jasperReport =(JasperReport)JRLoader.loadObject("reports/current/CurrentCardAbstract.jasper");   //$NON-NLS-1$
	    	final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,db.getCon());	
			
			viewer.getReportViewer().setDocument(jasperPrint);	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			MessageBox msg=new MessageBox(this.getShell(),SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		try
		{
			MessageBox msg=new MessageBox(this.getShell(),SWT.NULL);
			if (txtCurrentCard.getData()==null)
			{
				msg.setMessage(Messages.getString("CurUICurrentCardAbstract.3")); //$NON-NLS-1$
				msg.open();
				return;			
			}
			
			

			TurkishCurrencyFormat cf=new TurkishCurrencyFormat();
			
			currentCard=(TurqCurrentCard)txtCurrentCard.getData();
			tableCurrentTransactions.removeAll();
			Date startDate=datePickerStartDate.getDate();
			Date endDate=datePickerEndDate.getDate();
		
			
			
			List balances = BLsearch.getCurrentBalances(currentCard,startDate);
			
			TableItem item;
			
			BigDecimal balance = new BigDecimal(0);
			BigDecimal totalDept = new BigDecimal(0);
			BigDecimal totalCredit = new BigDecimal(0);
			BigDecimal balanceCredit = new BigDecimal(0);
			BigDecimal balanceDept = new BigDecimal(0);
			
			if(balances.size()>0){
			    item = new TableItem(tableCurrentTransactions,SWT.NULL);
			    
			    if(((Object[])balances.get(0))[0]!=null){
			        
			        totalDept =(BigDecimal)((Object[])balances.get(0))[0];
			        balance = balance.subtract(totalDept);
			    }
			    
			    if(((Object[])balances.get(0))[1]!=null){
			        
			        totalCredit =(BigDecimal)((Object[])balances.get(0))[1];
			        balance = balance.add(totalCredit);
			    }
			         		
			    item.setText(new String[]{
			                    "", //$NON-NLS-1$
			                    "", //$NON-NLS-1$
			                    "", //$NON-NLS-1$
			                    Messages.getString("CurUICurrentCardAbstract.11"), //$NON-NLS-1$
			                    cf.format(totalDept),
			                    cf.format(totalCredit),
			                    (balance.compareTo(new BigDecimal(0))<0) ? cf.format(balance.multiply(new BigDecimal(-1))) : "", //$NON-NLS-1$
			                    (balance.compareTo(new BigDecimal(0))>0) ? cf.format(balance): ""  //$NON-NLS-1$
			    });
			    
			    
			    
			}
			else{
			    item = new TableItem(tableCurrentTransactions,SWT.NULL);
			    item.setText(new String[]{
	                    "", //$NON-NLS-1$
	                    "", //$NON-NLS-1$
	                    "", //$NON-NLS-1$
	                    "", //$NON-NLS-1$
	                    "0,00", //$NON-NLS-1$
	                    "0,00", //$NON-NLS-1$
	                    "0,00", //$NON-NLS-1$
	                    "0,00" //$NON-NLS-1$
	                    });
			}
			
						
			List results =BLsearch.getCurrentTransactions(currentCard, startDate, endDate);
		
			TurqCurrentTransaction transaction;
			
			for(int i=0;i<results.size();i++)
			{
			    transaction = (TurqCurrentTransaction)results.get(i);
			    
			    balance = balance.subtract(transaction.getTransactionsTotalDept());
				balance = balance.add(transaction.getTransactionsTotalCredit());
				item = new TableItem(tableCurrentTransactions,SWT.NULL);
				item.setData(transaction);
				item.setText(new String[]{DatePicker.formatter.format(transaction.getTransactionsDate()),
		        				  transaction.getTurqCurrentTransactionType().getTransactionTypeName(),
								  transaction.getTransactionsDocumentNo(),
								  transaction.getTransactionsDefinition(),
								  cf.format(transaction.getTransactionsTotalDept()),
								  cf.format(transaction.getTransactionsTotalCredit()),
								  (balance.compareTo(new BigDecimal(0))<0) ? cf.format(balance.multiply(new BigDecimal(-1))) : "", //$NON-NLS-1$
						          (balance.compareTo(new BigDecimal(0))>0) ? cf.format(balance): ""  //$NON-NLS-1$
						  
									});
			}
			
		
		}
		
		catch(Exception ex)
		{
		   
		    
			MessageBox msg=new MessageBox(this.getShell(),SWT.NULL);
			ex.printStackTrace();
			msg.setMessage(ex.getMessage());
			msg.open();
			
		}
		*/
		
	}
	
	public void printTable()
	{

	}

}
