
package com.turquaz.consignment.bl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import com.turquaz.consignment.dal.ConDALUpdateConsignment;
import com.turquaz.engine.dal.TurqBillConsignmentCommon;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;

/**
 * @author Huseyin Ergun
 * @version 
 * 
 */
public class ConBLUpdateConsignment {
	private Calendar cal = Calendar.getInstance();
	private ConDALUpdateConsignment dalCons = new ConDALUpdateConsignment();
	
	public ConBLUpdateConsignment(){
		
	}

	public void updateConsignment(TurqConsignment consignment,
			   String docNo, String definition, Date consignmentDate,
			   TurqCurrentCard curCard, int discountRate,BigDecimal discountAmount,
			   String billDocNo, BigDecimal vatAmount,BigDecimal specialVatAmount,
			   BigDecimal totalAmount,int type)throws Exception{
		try{
		
	
		consignment.setConsignmentsDate(consignmentDate);
		consignment.setConsignmentsDefinition(definition);
		
	
		consignment.setConsignmentsType(type);
				
		consignment.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
		consignment.setLastModified(new java.sql.Date(cal.getTime().getTime()));
		
		TurqBillConsignmentCommon common = consignment.getTurqBillConsignmentCommon();
		
		common.setBillDocumentNo(billDocNo);
		common.setCharges(new BigDecimal(0));
		common.setTotalAmount(totalAmount);
		common.setDiscountAmount(discountAmount);
		common.setVatAmount(vatAmount);
		common.setSpecialVatAmount(specialVatAmount);
		common.setDiscountRate(discountRate);
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
	
	public void deleteObject(Object obj)throws Exception{
	try{
		
		dalCons.deleteObject(obj);
	
	}
	catch(Exception ex){
			throw ex;
	
	}
	}
	
	
	
	

}
