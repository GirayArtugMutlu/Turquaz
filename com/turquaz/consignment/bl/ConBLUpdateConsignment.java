
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
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import com.turquaz.consignment.dal.ConDALUpdateConsignment;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqBillConsignmentCommon;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.dal.TurqCurrentCard;

/**
 * @author Huseyin Ergun
 * @version 
 * 
 */
public class ConBLUpdateConsignment {
	private Calendar cal = Calendar.getInstance();
	private static ConDALUpdateConsignment dalCons = new ConDALUpdateConsignment();
	
	public ConBLUpdateConsignment(){
		
	}

	public void updateConsignment(TurqConsignment consignment,
			   String docNo, String definition, Date consignmentDate,
			   TurqCurrentCard curCard,BigDecimal discountAmount,
			   String billDocNo, BigDecimal vatAmount,BigDecimal specialVatAmount,
			   BigDecimal totalAmount,int type,TurqCurrencyExchangeRate exRate)throws Exception{
		try{
		
		consignment.setConsignmentsDate(consignmentDate);
		consignment.setConsignmentsDefinition(definition);	
		consignment.setConsignmentsType(type);
		
		consignment.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
		consignment.setLastModified(new java.sql.Date(cal.getTime().getTime()));
		
		TurqBillConsignmentCommon common = consignment.getTurqBillConsignmentCommon();
		
		common.setBillDocumentNo(billDocNo);
		common.setCharges(new BigDecimal(0));
		common.setChargesInForeignCurrency(new BigDecimal(0));
		
		
		common.setTotalAmount(totalAmount.multiply(exRate.getExchangeRatio()).setScale(2,EngBLCommon.ROUNDING_METHOD));
		common.setTotalAmountInForeignCurrency(totalAmount);
		
		common.setDiscountAmount(discountAmount.multiply(exRate.getExchangeRatio()).setScale(2,EngBLCommon.ROUNDING_METHOD));
		common.setDiscountAmountInForeignCurrency(discountAmount);
		
		
		common.setVatAmount(vatAmount.multiply(exRate.getExchangeRatio()).setScale(2,EngBLCommon.ROUNDING_METHOD));
	    common.setVatAmountInForeignCurrency(vatAmount);
		
		common.setSpecialVatAmount(specialVatAmount.multiply(exRate.getExchangeRatio()).setScale(2,EngBLCommon.ROUNDING_METHOD));
		common.setSpecialVatAmountInForeignCurrency(specialVatAmount);
		common.setDiscountRate(0);
		common.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
		common.setLastModified(new java.sql.Date(cal.getTime().getTime()));
		common.setTurqCurrentCard(curCard);
		common.setConsignmentDocumentNo(docNo);
	  
		dalCons.update(common);
		
		dalCons.updateConsignment(consignment);
		
		
		}
		catch(Exception ex){
			throw ex;
		}
	
	
	}
	public void deleteConsignment(TurqConsignment consignment)throws Exception{
	    try{
	        
//	      delete Consignment Group
	        initiliazeConsignment(consignment);
			Iterator it = consignment.getTurqConsignmentsInGroups().iterator();
			while(it.hasNext()){
				deleteObject(it.next());
									
			}
			
//			delete Inventory Transaction
			it = consignment.getTurqEngineSequence().getTurqInventoryTransactions().iterator();
			while(it.hasNext()){
				deleteObject(it.next());
									
			}
			
			Object o = consignment.getTurqBillConsignmentCommon();
		
			deleteObject(consignment);
			deleteObject(o);
			
	        
	        
	    }
	    catch(Exception ex)
	    {
	        throw ex;
	    }
	}
	
	public void deleteObject(Object obj)throws Exception{
	try{
		
		dalCons.deleteObject(obj);
	
	}
	catch(Exception ex){
			throw ex;
	
	}
	}
	public static void initiliazeConsignment(TurqConsignment cons)throws Exception{
		try{
		 
		    dalCons.initiliazeConsignment(cons);
		    
		}
		catch(Exception ex){
		    throw ex;
		}
	}
	
	
	

}
