
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

package com.turquaz.engine.ui.component;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;
import java.util.*;
import de.kupzog.ktable.*;
import java.sql.*;

/**
 * @author onsel
 *
 * @version $Id$
 */
public class TTable extends KTable{
	
	public TTable(Composite parent, int style){
		super(parent,style);
		this.setRowSelectionMode(true);
	    this.setModel(new TTableModel());
	   
	}
	public void setHeaderColumn(String header[]){
    TTableModel model = (TTableModel)this.getModel();
    model.setColumnCount(header.length);
    for(int i=0;i<header.length;i++){
    	model.setContentAt(i,0,header[i]);  		
    }
    this.setModel(model);
	
	}
	
	public void fillRandom(){
		TTableModel model = (TTableModel)this.getModel();
		int rowCount =5;
		int columnCount = 5;
		for(int i=0;i<5;i++){
			for (int j =0;j<5;j++){
				
				model.setContentAt(i,j,(i*j)+"");
			}
		}
		model.setRowCount(rowCount);
		model.setColumnCount(columnCount);
		this.setModel(model);
	}
    public void fillTable(ResultSet rs, String header[]){
    try{
    this.setHeaderColumn(header);
	TTableModel model = (TTableModel)this.getModel();
	 int rowCount =1;
	 int columnCount = header.length;
	 while(rs.next()){	
	    
	    
		for(int i=1;i<=columnCount;i++){
			model.setContentAt(i-1,rowCount,rs.getString(i));  		
		}
		
		rowCount++;
	 }	
	 rs.close();
	 model.setRowCount(rowCount);
	
	 this.setModel(model);
	
    }
    catch(Exception ex){
    	ex.printStackTrace();
    }
    }
			
	
	
	
    
}
