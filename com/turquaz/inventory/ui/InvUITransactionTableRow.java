
package com.turquaz.inventory.ui;

import org.eclipse.swt.graphics.Color;

import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.TableRowList;

public class InvUITransactionTableRow implements ITableRow {

    TurqInventoryTransaction invTrans = new TurqInventoryTransaction();
    TableRowList rowList;
    int row_index=0;
    int transType = 0;
    /*
     * type 0 = Buy 
     * type 1 = Sell
     */
    
    public InvUITransactionTableRow(TableRowList rowList, int type){
        this.rowList = rowList;
        this.transType = type;
        invTrans.setTransactionsAmountIn(0);
        invTrans.setTransactionsTotalAmountOut(0);
        
        
        
    }
    
    
    
    
    
  
    public String getColumnText(int column_index) {
   
        return null;
    }

 
    public Object getValue(int column_index) {
      
        return null;
    }

   
    public void modify(int column_index, Object value) {
        
    }

   
    public Color getColor() {
        
        return null;
    }

 
    public boolean canModify(int column_index) {
   
        return false;
    }

   
    public void setRowIndex(int index) {
       

    }

    
    public int getRowIndex() {
      
        return 0;
    }

  
    public boolean okToSave() {
       
        return false;
    }

   
    public Object getDBObject() {
     
        return null;
    }

 
    public void setDBObject(Object obj) {
       

    }

}
