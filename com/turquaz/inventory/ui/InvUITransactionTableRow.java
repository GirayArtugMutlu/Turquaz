
package com.turquaz.inventory.ui;

import java.math.BigDecimal;

import org.eclipse.swt.graphics.Color;

import com.cloudgarden.resource.SWTResourceManager;
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
        invTrans.setTransactionsUnitPrice(new BigDecimal(0));
        invTrans.setTransactionsTotalPrice(new BigDecimal(0));
        invTrans.setTransactionsVat(0);
        invTrans.setTransactionsVatAmount(new BigDecimal(0));
        invTrans.setTransactionsVatSpecial(new BigDecimal(0));
        invTrans.setTransactionsVatSpecialAmount(new BigDecimal(0));
        invTrans.setTransactionsVatSpecialEach(new BigDecimal(0));
        invTrans.setTransactionsCumilativePrice(new BigDecimal(0));       
    }
    
    /**
     * 0 - Stok Kodu
     * 1 - Stok Cinsi      //cant modify
     * 2 - Miktar
     * 3 - Birim
     * 4 - Birim Fiyat?
     * 5 - Toplam Tutar    //cant modify
     * 6 - Kdv %     
     * 7 - Kdv Tutari      //cantModify
     * 8 - Ötv %
     * 9 - Ötv Tutari      //cant Modify
     * 10 - Sat?r Toplam?  //cant Modify
     */
     
  
    public String getColumnText(int column_index) {
        String result = "";
		switch (column_index) {
		
			case 0 : // inventory code 
			 break;
				
			case 1 : //inventory name
			    
			    break;
			    
			case 2 :  //Amount
				break;
			    
			case 3 :  //Unit
			    break;
			    
			case 4 :  //Unit Price
				break;
				
			case 5 : // total Price 
				break;
			
			case 6 : // VAT percent			    
				break;
				
			case 7 : // VAT total 
				break;
				
			case 8 : // Special VAT percent 
				break;
				
			case 9 : // Specail VAT Total 
				break;
				
			case 10 : //Cumulative Price
			    break;
				
			default :
				result = "";
		}
        
        return result;
        
        
    }

 
    public Object getValue(int column_index) {
        String result = "";
		switch (column_index) {
		
			case 0 : // inventory code 
			 break;
				
			case 1 : //inventory name
			    
			    break;
			    
			case 2 :  //Amount
				break;
			    
			case 3 :  //Unit
			    break;
			    
			case 4 :  //Unit Price
				break;
				
			case 5 : // total Price 
				break;
			
			case 6 : // VAT percent			    
				break;
				
			case 7 : // VAT total 
				break;
				
			case 8 : // Special VAT percent 
				break;
				
			case 9 : // Specail VAT Total 
				break;
				
			case 10 : //Cumulative Price
			    break;
				
			default :
				result = "";
		}
        
        return result;
        
    }

   
    public void modify(int column_index, Object value) {
      
		switch (column_index) {
		
			case 0 : // inventory code 
			 break;
				
			case 1 : //inventory name
			    
			    break;
			    
			case 2 :  //Amount
				break;
			    
			case 3 :  //Unit
			    break;
			    
			case 4 :  //Unit Price
				break;
				
			case 5 : // total Price 
				break;
			
			case 6 : // VAT percent			    
				break;
				
			case 7 : // VAT total 
				break;
				
			case 8 : // Special VAT percent 
				break;
				
			case 9 : // Specail VAT Total 
				break;
				
			case 10 : //Cumulative Price
			    break;
				
			default :
				
		}
       
        
        
    }

   
    public Color getColor() {
       if(okToSave()){
           return SWTResourceManager.getColor(255,198,198);
       }
       
       else{
           return SWTResourceManager.getColor(198,255,198);
       }
    }

 
    public boolean canModify(int column_index) {
    
        if(column_index==1 ||column_index==5 || column_index==7 || column_index == 9 || column_index==10)
    	{
        	return false;
    	}
    	return true;
    }

   
    public void setRowIndex(int index) {
       row_index = index;

    }

    
    public int getRowIndex() {
      
        return row_index;
    }

  
    public boolean okToSave() {
    
    if(invTrans.getTurqInventoryCard()!=null){
        return false;   
    }
    else{
        return true;
    }
        
        
    }

   
    public Object getDBObject() {
     
     return invTrans;
    }

 
    public void setDBObject(Object obj) {
      if(obj instanceof TurqInventoryTransaction)
      {
          invTrans = (TurqInventoryTransaction)obj;
      }

    }

}
