
package com.turquaz.bill.bl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.turquaz.bill.dal.BillDALSearchBill;
import com.turquaz.bill.dal.BillDALUpdateBill;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqCurrentCard;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BillBLSearchBill {
	Calendar cal = Calendar.getInstance();
	BillDALSearchBill dalSearch = new BillDALSearchBill();
	BillDALUpdateBill dalUpdate = new BillDALUpdateBill();
   
	public BillBLSearchBill(){
   	
   
	}
	public List searchBill(TurqCurrentCard card,Date startDate,Date endDate, int type)throws Exception{
		try{
			
			return dalSearch.searchBill(card,startDate,endDate,type);
			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	public boolean canUpdateBill(TurqBill bill)throws Exception{
	    try{
	        
	        return dalUpdate.canUpdateBill(bill);
	    }
	    catch(Exception ex){
	        throw ex;
	    }
	}
	
	

}
