
package com.turquaz.consignment.bl;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.turquaz.consignment.dal.ConDALSearchConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;


public class ConBLSearchConsignment {
	Calendar cal = Calendar.getInstance();
	ConDALSearchConsignment dalSearch = new ConDALSearchConsignment();
   
	public ConBLSearchConsignment(){
   	
   
	}
	public List searchConsignment(TurqCurrentCard card,Date startDate,Date endDate, int type)throws Exception{
		try{
			
			return dalSearch.searchConsignments(card,startDate,endDate,type);
			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	public List chooseConsignment(TurqCurrentCard card,Date startDate,Date endDate, int type)throws Exception{
		try{
			
			return dalSearch.chooseConsignments(card,startDate,endDate,type);
			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	
	
	
}
