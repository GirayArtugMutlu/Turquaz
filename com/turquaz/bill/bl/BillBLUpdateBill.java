package com.turquaz.bill.bl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import com.turquaz.bill.dal.BillDALUpdateBill;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqBillConsignmentCommon;
import com.turquaz.engine.dal.TurqCurrentCard;

/**
 * @author onsel
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class BillBLUpdateBill {
	private Calendar cal = Calendar.getInstance();

	private BillDALUpdateBill dalBill = new BillDALUpdateBill();

	public BillBLUpdateBill() {

	}

	public void updateBill(TurqBill bill,String docNo, String definition, boolean isPrinted,
			Date billDate, TurqCurrentCard curCard, int discountRate,
			BigDecimal discountAmount,
			BigDecimal vatAmount, BigDecimal specialVatAmount,
			BigDecimal totalAmount, int type) throws Exception {
		try {
			
		
			bill.setBillsDate(billDate);
			bill.setBillsDefinition(definition);
		
			bill.setBillsPrinted(isPrinted);
		
			bill.setBillsType(type);

			
			bill.setUpdatedBy(System.getProperty("user"));
			bill.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			
			TurqBillConsignmentCommon common =bill.getTurqBillConsignmentCommon();
			
			common.setDiscountAmount(new BigDecimal(discountRate));
			common.setCharges(new BigDecimal(0));
			common.setDiscountAmount(discountAmount);
			common.setBillDocumentNo(docNo);
			common.setTotalAmount(totalAmount);
			common.setVatAmount(vatAmount);
			common.setSpecialVatAmount(specialVatAmount);
			common.setTurqCurrentCard(curCard);

	    	common.setUpdatedBy(System.getProperty("user"));
		    common.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			
		   
			dalBill.updateObject(common);

			dalBill.updateBill(bill);

		} catch (Exception ex) {
			throw ex;
		}
	}

	public void deleteObject(Object obj) throws Exception {
		try {

			dalBill.deleteObject(obj);

		} catch (Exception ex) {
			throw ex;

		}
	}

}