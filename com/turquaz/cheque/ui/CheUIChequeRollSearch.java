package com.turquaz.cheque.ui;
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
* @author  Onsel
* @version  $Id$
*/

import java.util.List;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.custom.CCombo;

import com.turquaz.cheque.Messages;
import com.turquaz.cheque.bl.CheBLSearchChequeRoll;
import com.turquaz.engine.dal.TurqChequeRoll;
import com.turquaz.engine.dal.TurqChequeTransactionType;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SearchComposite;

import org.eclipse.swt.widgets.Text;
import com.cloudgarden.resource.SWTResourceManager;
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
public class CheUIChequeRollSearch extends org.eclipse.swt.widgets.Composite implements SearchComposite{

    {
        //Register as a resource user - SWTResourceManager will
        //handle the obtaining and disposing of resources
        SWTResourceManager.registerResourceUser(this);
    }

	private Composite compSearchPanel;
	private Table tableChequeRolls;
	private TableColumn tableColumnDate;
	private CLabel lblEndDate;
	private CLabel lblType;
	private CCombo comboRollType;
	private DatePicker dateEndDate;
	private DatePicker dateStartDate;
	private CLabel lblStartDate;
	private Text txtRollNo;
	private CLabel lblRollNo;
	private TableColumn tableColumnOwner;
	private TableColumn tableColumnType;
	private TableColumn tableColumnRolNo;

	

	public CheUIChequeRollSearch(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setBackground(SWTResourceManager.getColor(255, 255, 255));
			this.setSize(663, 336);
            {
                compSearchPanel = new Composite(this, SWT.NONE);
                GridLayout compSearchPanelLayout = new GridLayout();
                GridData compSearchPanelLData = new GridData();
                compSearchPanelLData.grabExcessHorizontalSpace = true;
                compSearchPanelLData.horizontalAlignment = GridData.FILL;
                compSearchPanelLData.heightHint = 121;
                compSearchPanel.setLayoutData(compSearchPanelLData);
                compSearchPanelLayout.numColumns = 2;
                compSearchPanel.setLayout(compSearchPanelLayout);
                {
                    lblRollNo = new CLabel(compSearchPanel, SWT.NONE);
                    lblRollNo.setText(Messages.getString("CheUIChequeRollSearch.0")); //$NON-NLS-1$
                }
                {
                    txtRollNo = new Text(compSearchPanel, SWT.NONE);
                    GridData txtRollNoLData = new GridData();
                    txtRollNoLData.widthHint = 110;
                    txtRollNoLData.heightHint = 15;
                    txtRollNo.setLayoutData(txtRollNoLData);
                }
                {
                    lblStartDate = new CLabel(compSearchPanel, SWT.NONE);
                    lblStartDate.setText(Messages.getString("CheUIChequeRollSearch.1")); //$NON-NLS-1$
                }
                {
                    dateStartDate = new DatePicker(compSearchPanel, SWT.NONE);
                    GridData datePicker1LData = new GridData();
                    datePicker1LData.widthHint = 116;
                    datePicker1LData.heightHint = 22;
                    dateStartDate.setLayoutData(datePicker1LData);
                }
                {
                    lblEndDate = new CLabel(compSearchPanel, SWT.NONE);
                    lblEndDate.setText(Messages.getString("CheUIChequeRollSearch.2")); //$NON-NLS-1$
                }
                {
                    dateEndDate = new DatePicker(compSearchPanel, SWT.NONE);
                    GridData dateEndDateLData = new GridData();
                    dateEndDateLData.widthHint = 115;
                    dateEndDateLData.heightHint = 20;
                    dateEndDate.setLayoutData(dateEndDateLData);
                }
                {
                    lblType = new CLabel(compSearchPanel, SWT.NONE);
                    lblType.setText(Messages.getString("CheUIChequeRollSearch.3")); //$NON-NLS-1$
                }
                {
                    comboRollType = new CCombo(compSearchPanel, SWT.NONE);
                    GridData comboRollTypeLData = new GridData();
                    comboRollType.setText(Messages.getString("CheUIChequeRollSearch.4")); //$NON-NLS-1$
                    comboRollTypeLData.widthHint = 92;
                    comboRollTypeLData.heightHint = 14;
                    comboRollType.setLayoutData(comboRollTypeLData);
                }
            }
            {
                tableChequeRolls = new Table(this, SWT.FULL_SELECTION);
                GridData tableChequeRollsLData = new GridData();
                tableChequeRolls.addMouseListener(new MouseAdapter() {
                    public void mouseDoubleClick(MouseEvent evt) {
                      tableMouseDoubleClick();
                    }
                });
                tableChequeRolls.setLinesVisible(true);
                tableChequeRolls.setHeaderVisible(true);
                tableChequeRollsLData.grabExcessHorizontalSpace = true;
                tableChequeRollsLData.horizontalAlignment = GridData.FILL;
                tableChequeRollsLData.grabExcessVerticalSpace = true;
                tableChequeRollsLData.verticalAlignment = GridData.FILL;
                tableChequeRolls.setLayoutData(tableChequeRollsLData);
                {
                    tableColumnDate = new TableColumn(
                        tableChequeRolls,
                        SWT.NONE);
                    tableColumnDate.setText(Messages.getString("CheUIChequeRollSearch.5")); //$NON-NLS-1$
                    tableColumnDate.setWidth(76);
                }
                {
                    tableColumnRolNo = new TableColumn(
                        tableChequeRolls,
                        SWT.NONE);
                    tableColumnRolNo.setText(Messages.getString("CheUIChequeRollSearch.6")); //$NON-NLS-1$
                    tableColumnRolNo.setWidth(88);
                }
                {
                    tableColumnType = new TableColumn(tableChequeRolls, SWT.NONE);
                    tableColumnType.setText(Messages.getString("CheUIChequeRollSearch.7")); //$NON-NLS-1$
                    tableColumnType.setWidth(75);
                }
                {
                    tableColumnOwner = new TableColumn(tableChequeRolls, SWT.NONE);
                    tableColumnOwner.setText(Messages.getString("CheUIChequeRollSearch.8")); //$NON-NLS-1$
                    tableColumnOwner.setWidth(102);
                }
            }
            postInitGUI();
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void postInitGUI(){
	    try
	    {
	        comboRollType.add(Messages.getString("CheUIChequeRollSearch.9")); //$NON-NLS-1$
	        List ls = CheBLSearchChequeRoll.getTransactionTypes();
	        for(int i= 0;i< ls.size();i++)
	        {
	            TurqChequeTransactionType type = (TurqChequeTransactionType)ls.get(i);
	            comboRollType.add(type.getTransactionTypsName());
	            comboRollType.setData(type.getTransactionTypsName(),type);       
	            
	            
	            
	            
	            
	        }
	        
	        
	        
	    }
	    catch(Exception ex){
	        
	        ex.printStackTrace();
	        EngUICommon.showMessageBox(getShell(),ex.getMessage().toString(),SWT.ICON_ERROR);
	    }
	    
	    
	}

	public void tableMouseDoubleClick(){
	    TableItem selection[] = tableChequeRolls.getSelection();
	    if(selection.length>0){
	    
	    
	    boolean isUpdated = new CheUIChequeInPayrollUpdate(getShell(),SWT.NULL,(TurqChequeRoll)selection[0].getData()).open();
	   if(isUpdated)
	   {
	       search();
	   }
	    
	    }
	    
	}
    public void delete() {
        // TODO Auto-generated method stub

    }
    public void exportToExcel() {
        // TODO Auto-generated method stub

    }
    public void printTable() {
        // TODO Auto-generated method stub

    }
    public void search() {
      try
      {
         tableChequeRolls.removeAll();
        List ls = CheBLSearchChequeRoll.searchChequeRoll(txtRollNo.getText().trim(),dateStartDate.getDate(),dateEndDate.getDate(),(TurqChequeTransactionType)comboRollType.getData(comboRollType.getText().trim()));
         TableItem item ;
         TurqChequeRoll roll;
         String owner =""; //$NON-NLS-1$
         for(int i=0;i<ls.size();i++){
         
             roll = (TurqChequeRoll)ls.get(i);
             item = new TableItem(tableChequeRolls,SWT.NULL);
             item.setData(roll);
             
             if(roll.getTurqCurrentCard().getCurrentCardsId().intValue()!=-1){
             owner = roll.getTurqCurrentCard().getCardsName();
                 
             }
             else if(roll.getTurqBanksCard().getBanksCardsId().intValue()!=-1){
                 owner = roll.getTurqBanksCard().getBankCode();
             }
             
             item.setText(new String[]{
                             DatePicker.formatter.format(roll.getChequeRollsDate()),
                             roll.getChequeRollNo(),
                             roll.getTurqChequeTransactionType().getTransactionTypsName(),
                             owner
                           });
             
             
         }
         
         
      }
      catch(Exception ex)
      {
          ex.printStackTrace();
          EngUICommon.showMessageBox(getShell(),ex.getMessage(),SWT.ICON_ERROR);
      }

    }
}
