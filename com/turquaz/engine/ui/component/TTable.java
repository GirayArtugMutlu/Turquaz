/*
 * Created on 05.Aðu.2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
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
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
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
