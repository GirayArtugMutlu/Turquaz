/*
 * Created on 20.Eki.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.current.bl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import com.turquaz.current.dal.CurDALCurrentCardAdd;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCompany;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentGroup;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryCardGroup;
import com.turquaz.engine.dal.TurqInventoryGroup;

/**
 * @author Ceday
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CurBLCurrentCardAdd {
	
	public CurBLCurrentCardAdd(){
	}
	
	private Calendar cal=Calendar.getInstance();
	private CurDALCurrentCardAdd currentAdd=new CurDALCurrentCardAdd();
	
	public void saveCurrentCard(String currentCode, String cardName, String cardDefinition,
								String cardAddress, BigDecimal cardDiscountRate,
								BigDecimal cardDiscountPayment,	BigDecimal cardCreditLimit,
								BigDecimal cardRiskLimit, String cardTaxDepartment,
								String cardTaxNumber, TurqAccountingAccount accCodeIdCustomer,
								TurqAccountingAccount accCodeIdSupplier) throws Exception {
		try{
		
			TurqCurrentCard currentCard=new TurqCurrentCard();
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
		
			currentCard.setCreatedBy(System.getProperty("user"));
			currentCard.setUpdatedBy(System.getProperty("user"));
			currentCard.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			currentCard.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
		
			currentCard.setTurqCompany(company);
			currentAdd.saveObject(currentCard);	
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
public void registerGroup(Integer cardId, Object grp) throws Exception {
		try {

			TurqInventoryCardGroup cardGroup = new TurqInventoryCardGroup();
			TurqInventoryGroup group = (TurqInventoryGroup) grp;
			TurqInventoryCard card = new TurqInventoryCard();
			card.setInventoryCardsId(cardId);
			cardGroup.setTurqInventoryCard(card);
			cardGroup.setTurqInventoryGroup(group);

			cardGroup.setCreatedBy(System.getProperty("user"));
			cardGroup.setUpdatedBy(System.getProperty("user"));
			cardGroup
					.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			cardGroup
					.setCreationDate(new java.sql.Date(cal.getTime().getTime()));

			currentAdd.saveObject(cardGroup);

		} catch (Exception ex) {
			throw ex;
		}

	}	
public List getCurrentGroups() throws Exception {

	try {

		return currentAdd.getCurrentGroups();

	} catch (Exception ex) {
		throw ex;
	}

}

public void deleteObject(Object obj)throws Exception{
	try{
		
	currentAdd.deleteObject(obj);	
		
		
	}
	catch(Exception ex){
		throw ex;
	}
}

public void saveCurGroup(String groupName, String groupDescription)
throws Exception {
try {
	
TurqCurrentGroup curGroup = new TurqCurrentGroup();
TurqCompany company = new TurqCompany();	
company.setCompaniesId(Integer.valueOf(System.getProperty("company")));
curGroup.setTurqCompany(company);
curGroup.setGroupsName(groupName);
curGroup.setGroupsDescription(groupDescription);

curGroup.setCreatedBy(System.getProperty("user"));
curGroup.setUpdatedBy(System.getProperty("user"));
curGroup.setLastModified(new java.sql.Date(cal.getTime().getTime()));
curGroup.setCreationDate(new java.sql.Date(cal.getTime().getTime()));

currentAdd.saveObject(curGroup);





} catch (Exception ex) {
throw ex;
}

}
public void updateObject(Object obj)throws Exception{
	try{
		
	currentAdd.updateObject(obj);	
		
	}
	catch(Exception ex){
		throw ex;
	}
	
}	
	

}
