
package com.turquaz.consignment.bl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import com.turquaz.consignment.dal.ConDALAddConsignment;
import com.turquaz.engine.dal.TurqBillConsignmentCommon;
import com.turquaz.engine.dal.TurqCompany;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqConsignmentGroup;
import com.turquaz.engine.dal.TurqConsignmentsInGroup;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.dal.TurqModule;

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
	public TurqConsignment saveConsignment(String docNo, String definition, boolean isPrinted, Date consignmentDate,
								   TurqCurrentCard curCard, int discountRate,BigDecimal discountAmount,
								   String billDocNo, BigDecimal vatAmount,BigDecimal specialVatAmount,
								   BigDecimal totalAmount,int type)throws Exception {
		try{
		
			
			TurqConsignment consignment = new TurqConsignment();
			
			consignment.setConsignmentsDate(consignmentDate);
			consignment.setConsignmentsDefinition(definition);
			consignment.setConsignmentsDocumentNo(docNo);
			consignment.setConsignmentsPrinted(isPrinted);
			consignment.setConsignmentsType(type);
					
			TurqCompany company = new TurqCompany();	
			company.setCompaniesId(Integer.valueOf(System.getProperty("company"))); //$NON-NLS-1$
			consignment.setTurqCompany(company);
			consignment.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			consignment.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			consignment.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			consignment.setCreationDate(new java.sql.Date(cal.getTime().getTime()));

            TurqEngineSequence seq = new TurqEngineSequence();
            TurqModule module = new TurqModule();
            module.setModulesId(new Integer(6));
            seq.setTurqModule(module);
            dalConsignment.save(seq);
            
            consignment.setTurqEngineSequence(seq);
			
			
			
			TurqBillConsignmentCommon common = new TurqBillConsignmentCommon();
			
			common.setBillDocumentNo(billDocNo);
			common.setCharges(new BigDecimal(0));
			common.setTotalAmount(totalAmount);
			common.setDiscountAmount(discountAmount);
			common.setVatAmount(vatAmount);
			common.setSpecialVatAmount(specialVatAmount);
			common.setDiscountRate(discountRate);
			common.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			common.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			common.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			common.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			common.setTurqCurrentCard(curCard);
			
			dalConsignment.save(common);
			
			consignment.setTurqBillConsignmentCommon(common);
			
			dalConsignment.save(consignment);
			
			return consignment;
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public void saveConsignmentRow(TurqInventoryTransaction invTrans, Integer consID,int consType,int discountRate)throws Exception{
		try{
			TurqConsignment cons = dalConsignment.loadConsignment(consID);
			
			invTrans.setTransactionsDiscount(new BigDecimal(discountRate));
			invTrans.setTurqEngineSequence(cons.getTurqEngineSequence());
			invTrans.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			invTrans.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			invTrans.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			invTrans.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			
			invTrans.setTransactionsDiscountAmount(invTrans.getTransactionsCumilativePrice().multiply(new BigDecimal(discountRate)).divide(new BigDecimal(100),2));
			
			//Al??
			// total amount in ve total amount ayni girilmisti
			// bir tanesi sifir yapmak gerek
			if(consType==0){
		     	invTrans.setTransactionsTotalAmountOut(0);
			}
		    //	Sat??
			else {
			invTrans.setTransactionsAmountIn(0);
			}
			dalConsignment.save(invTrans);
			
			
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

		cardGroup.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
		cardGroup.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
		cardGroup.setLastModified(new java.sql.Date(cal.getTime().getTime()));
		cardGroup.setCreationDate(new java.sql.Date(cal.getTime().getTime()));

		dalConsignment.save(cardGroup);
	
	}
	catch(Exception ex){
		throw ex;
	}
		
	}

}
