/*
 * Created on 22.Eki.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.current.bl;

import java.math.BigDecimal;
import java.util.Calendar;

import com.turquaz.current.dal.CurDALCurrentCardUpdate;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCompany;
import com.turquaz.engine.dal.TurqCurrentCard;

/**
 * @author Ceday
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CurBLCurrentCardUpdate {
	
	private CurDALCurrentCardUpdate currentUpdate=new CurDALCurrentCardUpdate();	
	private Calendar cal=Calendar.getInstance();
	
	public CurBLCurrentCardUpdate(){
		
	}
	
	public void updateCurrentCard(String currentCode, String cardName, String cardDefinition,
			String cardAddress, BigDecimal cardDiscountRate,
			BigDecimal cardDiscountPayment,	BigDecimal cardCreditLimit,
			BigDecimal cardRiskLimit, String cardTaxDepartment,
			String cardTaxNumber, TurqAccountingAccount accCodeIdCustomer,
			TurqAccountingAccount accCodeIdSupplier, TurqCurrentCard currentCard) throws Exception {
		try{
			currentCard.setCardsCurrentCode(currentCode);
			currentCard.setCardsName(cardName);
			currentCard.setCardsDefinition(cardDefinition);
			currentCard.setCardsAddress(cardAddress);
			currentCard.setCardsDiscountRate(cardDiscountRate);
			currentCard.setCardsDiscountPayment(cardDiscountPayment);
			currentCard.setCardsCreditLimit(cardCreditLimit);
			currentCard.setCardsRiskLimit(cardRiskLimit);
			currentCard.setCardsTaxDepartment(cardTaxDepartment);
			currentCard.setCardsTaxNumber(cardTaxNumber);
			currentCard.setTurqAccountingAccountByAccountingCodeIdCustomer(accCodeIdCustomer);
			currentCard.setTurqAccountingAccountByAccountingCodeIdSupplier(accCodeIdSupplier);

			TurqCompany company = new TurqCompany();
			company.setCompaniesId(Integer.valueOf(System.getProperty("company")));
			currentCard.setUpdatedBy(System.getProperty("user"));
			currentCard.setLastModified(new java.sql.Date(cal.getTime().getTime()));

			currentCard.setTurqCompany(company);
			currentUpdate.updateObject(currentCard);	
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public void deleteObject(Object obj){
	}
}
