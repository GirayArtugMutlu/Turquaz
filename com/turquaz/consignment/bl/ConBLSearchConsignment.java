
package com.turquaz.consignment.bl;
/************************************************************************/
/* TURQUAZ: Higly Modular Accounting/ERP Program                        */
/* ============================================                         */
/* Copyright (c) 2004 by Turquaz Software Development Group			    */
/*																		*/
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or    */
/* (at your option) any later version.       							*/
/* 																		*/
/* This program is distributed in the hope that it will be useful,		*/
/* but WITHOUT ANY WARRANTY; without even the implied warranty of		*/
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the		*/
/* GNU General Public License for more details.         				*/
/************************************************************************/

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.turquaz.consignment.dal.ConDALSearchConsignment;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;


public class ConBLSearchConsignment {
	Calendar cal = Calendar.getInstance();
   
	public ConBLSearchConsignment(){
   	
   
	}
	
	
	public static List searchConsignment(TurqCurrentCard card,Date startDate,Date endDate, int type,String docNo)throws Exception{
		try{
			
			return ConDALSearchConsignment.searchConsignments(card,startDate,endDate,type,docNo);
			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	
	
	public static List chooseConsignment(TurqCurrentCard card,Date startDate,Date endDate, int type)throws Exception{
		try{
			
			return ConDALSearchConsignment.chooseConsignments(card,startDate,endDate,type);
			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	
	
	public static TurqConsignment getConsignmentByConsId(Integer consId) throws Exception
	{
		try {
			
			return ConDALSearchConsignment.getConsignmentByConsId(consId);

		} 
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	
	
}
