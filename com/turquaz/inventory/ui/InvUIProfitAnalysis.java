package com.turquaz.inventory.ui;

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

/**
* @author  Onsel Armagan
* @version  $Id$
*/


import java.math.BigDecimal;
import java.util.List;

import org.eclipse.swt.layout.GridLayout;

import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqViewInventoryAmountTotal;
import com.turquaz.engine.dal.TurqViewInventoryTotal;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.TurquazDecimalFormat;
import com.turquaz.inventory.Messages;
import com.turquaz.inventory.bl.InvBLProfitAnalysis;


import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.layout.GridData;
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
public class InvUIProfitAnalysis extends org.eclipse.swt.widgets.Composite implements SearchComposite{

    public InvBLProfitAnalysis blProfit = new InvBLProfitAnalysis(); 
    private Table tableInvTotals;
    private TableColumn tableColumnTotalAmountOut;
    private TableColumn tableColumnProfit;
    private TableColumn tableColumnPriceOut;
    private TableColumn tableColumnCostOut;
    private TableColumn tableColumnTotalAmount;
    private TableColumn tableColumnAvgPrice;
    private TableColumn tableColumnInvCard;

	public InvUIProfitAnalysis(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.horizontalSpacing = 0;
			thisLayout.marginWidth = 0;
			thisLayout.marginHeight = 0;
			thisLayout.verticalSpacing = 0;
			this.setSize(586, 211);
			{
				tableInvTotals = new Table(this, SWT.NONE);
				GridData tableInvTotalsLData = new GridData();
				tableInvTotals.setLinesVisible(true);
				tableInvTotals.setHeaderVisible(true);
				tableInvTotalsLData.grabExcessHorizontalSpace = true;
				tableInvTotalsLData.grabExcessVerticalSpace = true;
				tableInvTotalsLData.horizontalAlignment = GridData.FILL;
				tableInvTotalsLData.verticalAlignment = GridData.FILL;
				tableInvTotals.setLayoutData(tableInvTotalsLData);
				{
					tableColumnInvCard = new TableColumn(
						tableInvTotals,
						SWT.NONE);
					tableColumnInvCard.setText(Messages.getString("InvUIProfitAnalysis.0")); //$NON-NLS-1$
					tableColumnInvCard.setWidth(100);
				}
				{
					tableColumnTotalAmount = new TableColumn(
						tableInvTotals,
						SWT.NONE);
					tableColumnTotalAmount.setText(Messages.getString("InvUIProfitAnalysis.1")); //$NON-NLS-1$
					tableColumnTotalAmount.setWidth(73);
				}
				{
					tableColumnAvgPrice = new TableColumn(tableInvTotals, SWT.RIGHT);
					tableColumnAvgPrice.setText(Messages.getString("InvUIProfitAnalysis.2")); //$NON-NLS-1$
					tableColumnAvgPrice.setWidth(97);
				}
				{
					tableColumnTotalAmountOut = new TableColumn(tableInvTotals, SWT.NONE);
					tableColumnTotalAmountOut.setText(Messages.getString("InvUIProfitAnalysis.3")); //$NON-NLS-1$
					tableColumnTotalAmountOut.setWidth(77);
				}
				{
					tableColumnCostOut = new TableColumn(tableInvTotals, SWT.RIGHT);
					tableColumnCostOut.setText(Messages.getString("InvUIProfitAnalysis.4")); //$NON-NLS-1$
					tableColumnCostOut.setWidth(82);
				}
				{
					tableColumnPriceOut = new TableColumn(tableInvTotals, SWT.RIGHT);
					tableColumnPriceOut.setText(Messages.getString("InvUIProfitAnalysis.5")); //$NON-NLS-1$
					tableColumnPriceOut.setWidth(75);
				}
				{
					tableColumnProfit = new TableColumn(tableInvTotals, SWT.RIGHT);
					tableColumnProfit.setText(Messages.getString("InvUIProfitAnalysis.6")); //$NON-NLS-1$
					tableColumnProfit.setWidth(75);
				}
			}
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void search(){
	    try{
	    	tableInvTotals.removeAll();
	        List ls = blProfit.getTransactionTotals(0,null,null,null);
	       
	        TableItem item ; 
	        TurqInventoryCard invCard;
	        TurqViewInventoryTotal totals;
	        BigDecimal amountNow ;
	        BigDecimal avgPrice ;
	        BigDecimal amountOut ;
	        BigDecimal totalCost;
	        BigDecimal totalPrice;
	        BigDecimal totalProfit;
	        TurquazDecimalFormat df = new TurquazDecimalFormat();
	        
	        for(int i = 0; i<ls.size();i++){
	        	 amountNow = new BigDecimal(0);
	        	 avgPrice = new BigDecimal(0);
	        	 amountOut = new BigDecimal(0); 
	        	 totalCost = new BigDecimal(0); 
	        	 totalPrice = new BigDecimal(0); 
	        	 totalProfit = new BigDecimal(0);
	        	 
	        	 
	        	Object[] result = (Object[])ls.get(i);
	        	invCard =(TurqInventoryCard)result[0];
	        	totals = (TurqViewInventoryTotal)result[1];
	        	
	        	if(totals.getTotalAmountIn()!=null&&totals.getTotalAmountOut()!=null)
	        	{
	        	amountNow = totals.getTotalAmountIn().subtract(totals.getTotalAmountOut());
	        	}
	        	else{
	        		if(totals.getTotalAmountIn()!=null)
	        		{
	        		 amountNow = totals.getTotalAmountIn();
	        			
	        		}
	        		else if(totals.getTotalAmountOut()!=null);
	        		{
	        			amountNow = totals.getTotalAmountOut().multiply(new BigDecimal(-1));
	        		}
	        	}
	        	
	        	if(totals.getTotalAmountIn()!=null){
	        	avgPrice = totals.getTotalPriceIn().divide(totals.getTotalAmountIn(),2,BigDecimal.ROUND_HALF_UP);
	        	}
	        	
	        	if(totals.getTotalAmountOut()!=null){
	        		amountOut = totals.getTotalAmountOut();
	        	}
	        	totalCost = avgPrice.multiply(amountOut);
	        	totalPrice = totals.getTotalPriceOut();
	        	totalProfit = totalPrice.subtract(totalCost);
	        
	        	item = new TableItem(tableInvTotals,SWT.NULL);
	         	item.setData(invCard);
	        	
	        	item.setText(new String[]{	        			    
	        			 invCard.getCardInventoryCode(),
						 amountNow.toString(),
						 df.format(avgPrice),
						 amountOut.toString(),
						 df.format(totalCost),
						 df.format(totalPrice),
						 df.format(totalProfit)
						});
	        	}
	        	
	                      
	            
	        
	        
	        
	        
	        
	    }
	    catch(Exception ex){
	        
	        ex.printStackTrace();
	    
	    }
	    
	    
	}
	public void delete(){
	    
	}
	

    public void exportToExcel() {
    	EngBLUtils.Export2Excel(tableInvTotals);

    }
    public void printTable() {
       
    	 EngBLUtils.printTable(tableInvTotals,Messages.getString("InvUIProfitAnalysis.7"));  //$NON-NLS-1$
 	    
    }
}
