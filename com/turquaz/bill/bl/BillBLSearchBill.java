
package com.turquaz.bill.bl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.turquaz.bill.dal.BillDALSearchBill;
import com.turquaz.bill.dal.BillDALUpdateBill;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqCurrentCard;

public class BillBLSearchBill {
	Calendar cal = Calendar.getInstance();
	BillDALSearchBill dalSearch = new BillDALSearchBill();
	BillDALUpdateBill dalUpdate = new BillDALUpdateBill();
   
	public BillBLSearchBill(){
   	
   
	}
	public List searchBill(TurqCurrentCard card,String docNo,Date startDate,Date endDate, int type)throws Exception{
		try{
			
			return dalSearch.searchBill(card,docNo,startDate,endDate,type);
			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	
	
	public static TurqBill getBillByBillId(Integer billId) throws Exception
	{
		try {

			return BillDALSearchBill.getBillByBillId(billId);

		} 
		catch (Exception ex) 
		{
			throw ex;
		}
	}
	
	
	public List searchBillAdvanced(TurqCurrentCard curCardStart,
			TurqCurrentCard curCardEnd, Date startDate, Date endDate,
			Date dueDateStart, Date dueDateEnd, BigDecimal minValue,
			BigDecimal maxValue, String docNoStart, String docNoEnd,
			int type)throws Exception{
		try{
			
			return dalSearch.searchBillAdvanced(curCardStart,curCardEnd,startDate,
					endDate,dueDateStart,dueDateEnd,minValue,maxValue,docNoStart,docNoEnd,type);
			
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
	public void initializeBill(TurqBill bill) throws Exception{
	    try{
	        
	        dalSearch.initializeBill(bill);
	    }
	    catch(Exception ex){
	        throw ex;
	    }
	}
	
	

}
