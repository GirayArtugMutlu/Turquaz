
package com.turquaz.inventory.ui;

import java.math.BigDecimal;

import org.eclipse.swt.graphics.Color;

import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.engine.bl.EngBLInventoryCards;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.TableRowList;

public class InvUITransactionTableRow implements ITableRow {

    TurqInventoryTransaction invTrans = new TurqInventoryTransaction();
    TableRowList rowList;
    int row_index=0;
    int transType = 0;
    String unit_name ="";
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
     * 4 - Temel Birim Miktar? //cant modify
     * 5 - Tamel Birimi        //cant modify  
     * 6 - Birim Fiyat?
     * 7 - Toplam Tutar    //cant modify
     * 8 - Kdv %     
     * 9 - Kdv Tutari      //cantModify
     * 10 - Ötv %
     * 11 - Ötv Tutari      //cant Modify
     * 12 - Sat?r Toplam?  //cant Modify
     */
     
  
    public String getColumnText(int column_index) {
        String result = "";
		switch (column_index) {
		
			case 0 : // inventory code 
			    if(invTrans.getTurqInventoryCard()==null){
			        result="";
			    }
			    else{
			        result =invTrans.getTurqInventoryCard().getCardInventoryCode();
			    }
			    
			 break;
				
			case 1 : //inventory name
			    if(invTrans.getTurqInventoryCard()==null){
			        result="";
			    }
			    else{
			        result =invTrans.getTurqInventoryCard().getCardName();
			    }
			    break;
			    
			case 2 :  //Amount
			    if(transType==0){
			    result = invTrans.getTransactionsAmountIn()+"";
			    }
			    else{
			        result = invTrans.getTransactionsTotalAmountOut()+"";
			    }
				break;
			    
			case 3 :  //Unit
			    result =unit_name;
			    break;
			    
			case 4 :  //Unit Price
			    result = invTrans.getTransactionsUnitPrice().toString();
				break;
				
			case 5 :  //Base Unit
			    if(invTrans.getTurqInventoryCard()==null){
			        result="";
			    }
			    else{
			       result = getBaseUnit(invTrans.getTurqInventoryCard());
			    }
			    break;
			    
			case 6 :  //Unit Price
			    result = invTrans.getTransactionsUnitPrice().toString();
				break;
				
			case 7 : // total Price
			    result = invTrans.getTransactionsTotalPrice().toString();
				break;
			
			case 8 : // VAT percent		
			    result = invTrans.getTransactionsVat()+"";
				break;
				
			case 9 : // VAT total 
			    result = invTrans.getTransactionsVatAmount().toString();
				break;
				
			case 10 : // Special VAT percent 
			    result = invTrans.getTransactionsVatSpecial().toString();
				break;
				
			case 11 : // Specail VAT Total 
			    result = invTrans.getTransactionsVatAmount().toString();
				break;
				
			case 12 : //Cumulative Price
			    result = invTrans.getTransactionsCumilativePrice().toString();
			    break;
				
			default :
				result = "";
		}
        
        return result;
        
        
    }

    public String getBaseUnit(TurqInventoryCard invCard){
        try{
            
            return "base_unit";
                  
        }
        catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    
    
    public Object getValue(int column_index) {
        String result = "";
        switch (column_index) {
		
			case 0 : // inventory code 
			    if(invTrans.getTurqInventoryCard()==null){
			        result="";
			    }
			    else{
			        result =invTrans.getTurqInventoryCard().getCardInventoryCode();
			    }
			    
			 break;
				
			case 1 : //inventory name
			    if(invTrans.getTurqInventoryCard()==null){
			        result="";
			    }
			    else{
			        result =invTrans.getTurqInventoryCard().getCardName();
			    }
			    break;
			    
			case 2 :  //Amount
			    if(transType==0){
			    result = invTrans.getTransactionsAmountIn()+"";
			    }
			    else{
			        result = invTrans.getTransactionsTotalAmountOut()+"";
			    }
				break;
			    
			case 3 :  //Unit
			    result =unit_name;
			    break;
			    
			case 4 :  //Unit Price
			    result = invTrans.getTransactionsUnitPrice().toString();
				break;
				
			case 5 :  //Base Unit
			    if(invTrans.getTurqInventoryCard()==null){
			        result="";
			    }
			    else{
			       result = getBaseUnit(invTrans.getTurqInventoryCard());
			    }
			    break;
			    
			case 6 :  //Unit Price
			    result = invTrans.getTransactionsUnitPrice().toString();
				break;
				
			case 7 : // total Price
			    result = invTrans.getTransactionsTotalPrice().toString();
				break;
			
			case 8 : // VAT percent		
			    result = invTrans.getTransactionsVat()+"";
				break;
				
			case 9 : // VAT total 
			    result = invTrans.getTransactionsVatAmount().toString();
				break;
				
			case 10 : // Special VAT percent 
			    result = invTrans.getTransactionsVatSpecial().toString();
				break;
				
			case 11 : // Specail VAT Total 
			    result = invTrans.getTransactionsVatAmount().toString();
				break;
				
			case 12 : //Cumulative Price
			    result = invTrans.getTransactionsCumilativePrice().toString();
			    break;
				
			default :
				result = "";
		}
        
        
        return result;
        
    }

   
    public void modify(int column_index, Object value) {
      String formatted ="";
		switch (column_index) {
		
			case 0 : // inventory code 
			    try{
					 TurqInventoryCard invCard= EngBLInventoryCards.getCard(value.toString().trim());
					 if(invCard!=null){
					    invTrans.setTurqInventoryCard(invCard);		  
					 }	
					}
					catch(Exception ex){
					    ex.printStackTrace();
					}
			 break;
				
			case 1 : //inventory name
			    
			    break;
			    
			case 2 :  //Amount
			    formatted = value.toString(); 	
			 	if(formatted.equals("")){
			 	    formatted="0";
			 	}
			 	if(transType==0){
				    invTrans.setTransactionsAmountIn(Long.parseLong(formatted));
				}
				else{
				    invTrans.setTransactionsTotalAmountOut(Long.parseLong(formatted));
				 }
				break;
			    
			case 3 :  //Unit
			    unit_name = value.toString();
			    break;
			  
			case 4 :  //Base Unit Amount
				break;
				
			case 5 :  //Base Unit
			    break;
			    
			case 6 :  //Unit Price
			    formatted = value.toString(); 	
			 	formatted = formatted.replaceAll("\\.","");
			 	formatted = formatted.replaceAll(",",".");
			 	if(formatted.equals("")){
			 	    formatted="0";
			 	}
				break;
				
			case 7 : // total Price 
				break;
			
			case 8 : // VAT percent		
			    formatted = value.toString(); 	
			 	
			    if(formatted.equals("")){
			 	    formatted="0";
			 	}
			 	
			    invTrans.setTransactionsVat(Integer.parseInt(formatted));
			    
				break;
				
			case 9 : // VAT total 
				break;
				
			case 10 : // Special VAT percent 
			    formatted = value.toString(); 	
			 	
			    if(formatted.equals("")){
			 	    formatted="0";
			 	}
			 	
			    invTrans.setTransactionsVatSpecial(new BigDecimal(formatted));
			    
				break;
				
			case 11 : // Specail VAT Total 
				break;
				
			case 12 : //Cumulative Price
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
    
        if(column_index==1 ||column_index==4 || column_index==5 || column_index == 7 || column_index==9
                ||column_index==11||column_index==12)
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
