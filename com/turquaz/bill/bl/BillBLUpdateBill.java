package com.turquaz.bill.bl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import com.turquaz.bill.dal.BillDALUpdateBill;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqConsignment;
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

	public void updateBill(String docNo, String definition, boolean isPrinted,
			Date billDate, TurqCurrentCard curCard, int discountRate,
			BigDecimal discountAmount, TurqConsignment cons,
			BigDecimal vatAmount, BigDecimal specialVatAmount,
			BigDecimal totalAmount, int type) throws Exception {
		try {
			TurqBill bill = new TurqBill();
			bill.setBillsDiscountRate(discountRate);
			bill.setBillsCharges(new BigDecimal(0));
			bill.setBillsDate(billDate);
			bill.setBillsDefinition(definition);
			bill.setBillsDiscountAmount(discountAmount);
			bill.setBillDocumentNo(docNo);
			bill.setBillsPrinted(isPrinted);
			bill.setBillsTotalAmount(totalAmount);
			bill.setBillsType(type);
			bill.setBillsVatAmount(vatAmount);
			bill.setBillsSpecialVatAmount(specialVatAmount);
			bill.setTurqConsignment(cons);
			bill.setTurqCurrentCard(curCard);

			
			bill.setUpdatedBy(System.getProperty("user"));
			bill.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			

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