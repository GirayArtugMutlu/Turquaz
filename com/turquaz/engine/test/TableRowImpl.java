
package com.turquaz.engine.test;

import java.math.BigDecimal;

import org.eclipse.swt.graphics.Color;

import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.TableRowList;

public class TableRowImpl implements ITableRow {
    public String account_code ="";
    public String account_name ="";
    public String debt_amount ="0";
    public String credit_amount = "0";
    
    TableRowList rowList;
    public TableRowImpl(TableRowList rowList){
        super();
        this.rowList = rowList;        
    }

    public Color getColor() {
        // TODO Auto-generated method stub
        return null;
    }
    public boolean canModify(int column_index){
      
        if(column_index==1){
            return false;
        }
        return true;
    }
    
    
    
    public String getColumnText(int column_index) {

        String result = null;
		switch (column_index) {
			case 0 : //Hesap Kodu
				result = account_code;
				break;
			case 1 : // DESCRIPTION_COLUMN 
				result = account_name;
				break;
			case 2 : // OWNER_COLUMN 
				result = debt_amount.toString();
			    
				break;
			case 3 : // PERCENT_COLUMN 
				result = credit_amount.toString();
				break;
			default :
				result = "";
		}
        
        return result;
        
        
    }
    public Object getValue(int column_index) {
        Object result = null;
		switch (column_index) {
			case 0 : //Hesap Kodu
				result = account_code;
				break;
			case 1 : // DESCRIPTION_COLUMN 
				result = account_name;
				break;
			case 2 : // OWNER_COLUMN 
				result = debt_amount;
			    
				break;
			case 3 : // PERCENT_COLUMN 
				result = credit_amount;
				break;
			default :
				result = "";
		}
        
        return result;
    }
    public void modify(int column_index, Object value) {
      
        switch (column_index) {
		case 0 : //Hesap Kodu
			account_code = value.toString().trim();
			break;
		case 1 : // DESCRIPTION_COLUMN 
			account_name = value.toString().trim();
			break;
		case 2 : // OWNER_COLUMN 
			debt_amount = value.toString();
		    
			break;
		case 3 : // PERCENT_COLUMN 
			credit_amount = value.toString();
			break;
	}
        rowList.taskChanged(this);
    }
}
