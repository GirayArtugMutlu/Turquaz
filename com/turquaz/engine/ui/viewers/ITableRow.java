
package com.turquaz.engine.ui.viewers;
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

import org.eclipse.swt.graphics.Color;

public interface ITableRow {
    
    //Get column Text
    public String getColumnText(int column_index);
    
    //Get column Value
    public Object getValue(int column_index);
    
    public void modify(int column_index, Object value);
    
    // Get Row Color
    public Color getColor();
    
    //is column editable
    public boolean canModify(int column_index);
    
    //rows unique number !!important in equals function
    public void setRowIndex(int index);
    
    //get rows unique number
    public int getRowIndex();
    
    //if all required fields are filled properly
    public boolean okToSave();
    
    //To save the row We need the db object
    public Object getDBObject();
    
    //After fetching from db we need to fill this part
    public void setDBObject(Object obj);
    
    public boolean equals(Object obj);
    
 }
