
package com.turquaz.current.ui;

import java.math.BigDecimal;

import org.eclipse.swt.graphics.Color;

import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.engine.dal.TurqCurrentTransaction;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.viewers.ITableRow;

public class CurUIInitialTransTableRow implements ITableRow {
    
   TurqCurrentTransaction curTrans = new TurqCurrentTransaction(); 

   TurkishCurrencyFormat cf=new TurkishCurrencyFormat();

    
   public boolean canModify(int column_index) {
      if(column_index ==1){
          return false;
      }
        return true;
   }
    
    public Color getColor() {
        if(okToSave()){
            return SWTResourceManager.getColor(198,255,198);
        }
        
        else{
            return SWTResourceManager.getColor(255,198,198);
        }
    }
    
    public String getColumnText(int column_index) {
        String result = "";
        switch (column_index) {
		
			case 0 : // inventory code 
			    if(okToSave()){
			      
			        result = curTrans.getTurqCurrentCard().getCardsName()+" {"+curTrans.getTurqCurrentCard().getCardsCurrentCode()+"}";
			        
			    }
			    else{
			        result="";
			    }
			    
			    
			 break;
				
			case 1 : 
			    result = cf.format(curTrans.getTransactionsTotalDept());
			    
			    break;
			    
			case 2 : 
			    result = cf.format(curTrans.getTransactionsTotalCredit());
			    
			    break;
			    
			 
			default :
        }
        return result;
			    
			    
        
        
        
        
    }
    public Object getDBObject() {
       
        return curTrans;
        
    }
    public int getRowIndex() {
        
        return 0;
    }
    
    
    public Object getValue(int column_index) {
        Object result = "";
        switch (column_index) {
		
			case 0 : // inventory code 
			    if(okToSave()){
			      
			        result = curTrans.getTurqCurrentCard().getCardsName()+" {"+curTrans.getTurqCurrentCard().getCardsCurrentCode()+"}";
			        
			    }
			    else{
			        result="";
			    }
			    
			    
			 break;
				
			case 1 : 
			    result = cf.format(curTrans.getTransactionsTotalDept());
			    
			    break;
			    
			case 2 : 
			    result = cf.format(curTrans.getTransactionsTotalCredit());
			    
			    break;
			    
			 
			default :
        }
        return result;
        
    }
    
    public void modify(int column_index, Object value) {
       String formatted = "";
        
        switch (column_index) {
		
			case 0 : // inventory code 
			   
			    
			 break;
				
			case 1 : 
			    formatted = value.toString(); 	
			 	formatted = formatted.replaceAll("\\.","");
			 	formatted = formatted.replaceAll(",",".");
			 	if(formatted.equals("")){
			 	    formatted="0";
			 	}
			 	curTrans.setTransactionsTotalDept(new BigDecimal(formatted));
			 	
				break;
			   
			    
			case 2 : 
			    formatted = value.toString(); 	
			 	formatted = formatted.replaceAll("\\.","");
			 	formatted = formatted.replaceAll(",",".");
			 	if(formatted.equals("")){
			 	    formatted="0";
			 	}
			 	curTrans.setTransactionsTotalCredit(new BigDecimal(formatted));
			 	
				break;
			 
			    
			 
			default :
        }
      
        
        
        
        
        
        
        
    }
    
    
    public boolean okToSave() {
        if(curTrans.getTurqCurrentCard()==null){
            return false; 
        }
       return true;
    }
    public void setDBObject(Object obj) {
      
        if(obj instanceof TurqInventoryTransaction)
        {
            curTrans = (TurqCurrentTransaction)obj;
           
         
            
        }
        

    }
    public void setRowIndex(int index) {
       

    }
}
