
package com.turquaz.inventory.ui;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.graphics.Color;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.engine.bl.EngBLInventoryCards;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryCardUnit;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.dal.TurqInventoryUnit;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.TableRowList;
import com.turquaz.inventory.bl.InvBLCardSearch;

public class InvUITransactionTableRow implements ITableRow {

    TurqInventoryTransaction invTrans = new TurqInventoryTransaction();
    TableRowList rowList;
    int row_index=0;
    int transType = 0;
    Integer unit_index = new Integer(-1);
    String unit_text = "";
    String units [];
    TurqInventoryCardUnit cardUnits[];
    TurqInventoryUnit base_unit;
    InvBLCardSearch blCardSearch= new InvBLCardSearch();
    TableViewer tableViewer ;
    int transAmount = 0;
    /*
     * type 0 = Buy 
     * type 1 = Sell
     */
    
    public InvUITransactionTableRow(TableRowList rowList, int type, TableViewer viewer){
        this.tableViewer = viewer;
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
     * 10 - �tv %
     * 11 - �tv Tutari      //cant Modify
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
				{
			      result = transAmount+"";
			      break;
				}
			    
			case 3 :  //Unit
			    result =unit_text;
			    break;
			    
			case 4 :  //Amount in Base Unit
			    if(transType==0){
				    result = invTrans.getTransactionsAmountIn()+"";
				    }
				    else{
				        result = invTrans.getTransactionsTotalAmountOut()+"";
				    }
					break;
				
			case 5 :  //Base Unit
			    if(invTrans.getTurqInventoryCard()==null){
			        result="";
			    }
			    else{
			       
			       result = base_unit.getUnitsName();
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

    
    
    public void fillUnits(TurqInventoryCard invCard){
        List unit_list = new ArrayList();            
        Set set = invCard.getTurqInventoryCardUnits();
        Iterator it = set.iterator();
        while(it.hasNext()){
            TurqInventoryCardUnit cardUnit = (TurqInventoryCardUnit)it.next();
            unit_list.add(cardUnit);
            if(cardUnit.getCardUnitsFactor()==1){
                base_unit = cardUnit.getTurqInventoryUnit(); 
            }
        }
        
        unit_index=new Integer(0);
        unit_text = base_unit.getUnitsName();
        
        cardUnits = new TurqInventoryCardUnit[unit_list.size()];
        units = new String[unit_list.size()];
            
        unit_list.toArray(cardUnits);
        
        for(int i=0;i<unit_list.size();i++){
            units[i] = cardUnits[i].getTurqInventoryUnit().getUnitsName();
        }
        
    }
       
    
    public Object getValue(int column_index) {
     Object result = "";
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
			     
			     result = transAmount+"";
				break;
			    
			case 3 :  //Unit
			    result =unit_index;
			    break;
			    
			case 4 :  //amount in base units
			    if(transType==0){
				    result = invTrans.getTransactionsAmountIn()+"";
				    }
				    else{
				        result = invTrans.getTransactionsTotalAmountOut()+"";
				    }
				break;
				
			case 5 :  //Base Unit
			    if(invTrans.getTurqInventoryCard()==null){
			        result="";
			    }
			    else{
			       result = base_unit.getUnitsName();
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
					    blCardSearch.initializeInventoryCard(invCard);
					    fillUnits(invCard);
					    updateComboBoxEditor();
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
			 	transAmount = Integer.parseInt(formatted);
			 				 	
			 	if(transType==0){
				    invTrans.setTransactionsAmountIn(transAmount*cardUnits[unit_index.intValue()].getCardUnitsFactor());
				}
				else{
				    invTrans.setTransactionsTotalAmountOut(transAmount*cardUnits[unit_index.intValue()].getCardUnitsFactor());
				 }
				break;
			    
			case 3 :  //Unit
			    unit_index = (Integer)value;
			    if(unit_index.intValue()!=-1){
			        unit_text = units[unit_index.intValue()];
			    }
			    else
			        unit_text = "";
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
			 	invTrans.setTransactionsUnitPrice(new BigDecimal(formatted));
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
    
    public String[] getUnits(){
        return units;
        
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
	public void updateComboBoxEditor(){
	    try{
	       
	       
	       ComboBoxCellEditor editor =(ComboBoxCellEditor) tableViewer.getCellEditors()[3];
	       
	       if(getUnits()!=null){ 
	       editor.setItems(getUnits());
	       }
	       
	       else {
	       editor.setItems(new String[]{});
	           
	       }
	       
	    }
	    catch(Exception ex){
	        ex.printStackTrace();
	    }
	}
    

}
