
package com.turquaz.consignment.bl;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.turquaz.consignment.dal.ConDALSearchConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
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
	
	
}
