
package com.turquaz.consignment.bl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import com.turquaz.consignment.dal.ConDALAddConsignment;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqCompany;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqConsignmentGroup;
import com.turquaz.engine.dal.TurqConsignmentsInGroup;
import com.turquaz.engine.dal.TurqCurrentCard;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ConBLAddConsignment {
	ConDALAddConsignment dalConsignment = new ConDALAddConsignment();
	Calendar cal = Calendar.getInstance();
	public ConBLAddConsignment(){
		
	}
	public Integer saveConsignment(String docNo, String definition, boolean isPrinted, Date consignmentDate,
								   TurqCurrentCard curCard, int discountRate,BigDecimal discountAmount,
								   TurqBill bill, String billDocNo, BigDecimal vatAmount,BigDecimal specialVatAmount,
								   BigDecimal totalAmount,int type)throws Exception {
		try{
		
			
			TurqConsignment consignment = new TurqConsignment();
			consignment.setCondignmentsDiscountRate(discountRate);
			consignment.setConsignmentsBillDocumentNo(billDocNo);
			consignment.setConsignmentsCharges(new BigDecimal(0));
			consignment.setConsignmentsDate(consignmentDate);
			consignment.setConsignmentsDefinition(definition);
			consignment.setConsignmentsDiscountAmount(discountAmount);
			consignment.setConsignmentsDocumentNo(docNo);
			consignment.setConsignmentsPrinted(isPrinted);
			consignment.setConsignmentsTotalAmount(totalAmount);
			consignment.setConsignmentsType(type);
			consignment.setConsignmentsVatAmount(vatAmount);
			consignment.setConsignmentsSpecialVatAmount(specialVatAmount);
			consignment.setTurqBill(bill);
			consignment.setTurqCurrentCard(curCard);
					
			TurqCompany company = new TurqCompany();	
			company.setCompaniesId(Integer.valueOf(System.getProperty("company")));
			consignment.setTurqCompany(company);
			consignment.setCreatedBy(System.getProperty("user"));
			consignment.setUpdatedBy(System.getProperty("user"));
			consignment.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			consignment.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			
			dalConsignment.save(consignment);
			
			return consignment.getConsignmentsId();
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	
	public void registerGroup(TurqConsignmentGroup grp, Integer conId)throws Exception{
	try{
		TurqConsignmentsInGroup cardGroup = new TurqConsignmentsInGroup();
		TurqConsignmentGroup group = (TurqConsignmentGroup) grp;
		TurqConsignment card =new TurqConsignment();
		card.setConsignmentsId(conId);
		cardGroup.setTurqConsignment(card);
		cardGroup.setTurqConsignmentGroup(group);

		cardGroup.setCreatedBy(System.getProperty("user"));
		cardGroup.setUpdatedBy(System.getProperty("user"));
		cardGroup.setLastModified(new java.sql.Date(cal.getTime().getTime()));
		cardGroup.setCreationDate(new java.sql.Date(cal.getTime().getTime()));

		dalConsignment.save(cardGroup);
	
	}
	catch(Exception ex){
		throw ex;
	}
		
	}

}
