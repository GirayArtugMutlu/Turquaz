/*
 * Created on Sep 27, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.inventory.bl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import net.sf.hibernate.Session;
import net.sf.hibernate.type.BigDecimalType;

import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCompany;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryCardGroup;
import com.turquaz.engine.dal.TurqInventoryCardUnit;
import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.dal.TurqInventoryPrice;
import com.turquaz.engine.dal.TurqInventoryUnit;
import com.turquaz.inventory.dal.InvDALCardAdd;

/**
 * @author onsel
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class InvBLCardAdd {

	private InvDALCardAdd cardAdd;

	Calendar cal = Calendar.getInstance();

	public InvBLCardAdd() {

		cardAdd = new InvDALCardAdd();

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

			cardAdd.saveOrUpdateCardGroup(cardGroup);

		} catch (Exception ex) {
			throw ex;
		}

	}

	public void registerUnits(Integer cardId, Object unitObj, int factor)
			throws Exception {

		TurqInventoryCardUnit cardUnit = new TurqInventoryCardUnit();
		TurqInventoryUnit unit = (TurqInventoryUnit) unitObj;
		TurqInventoryCard card = new TurqInventoryCard();
		card.setInventoryCardsId(cardId);
		cardUnit.setCardUnitsFactor(factor);
		cardUnit.setTurqInventoryCard(card);
		cardUnit.setTurqInventoryUnit(unit);
		cardUnit.setCreatedBy(System.getProperty("user"));
		cardUnit.setUpdatedBy(System.getProperty("user"));
		cardUnit.setLastModified(new java.sql.Date(cal.getTime().getTime()));
		cardUnit.setCreationDate(new java.sql.Date(cal.getTime().getTime()));

		cardAdd.saveOrUpdateCardUnit(cardUnit);

	}

	public void saveInvPrices(Integer cardId, boolean price_type,
			String currency_abrev, String amount) throws Exception {
		try {

			TurqInventoryPrice invPrice = new TurqInventoryPrice();
			TurqCurrency currency = cardAdd.getCurrency(currency_abrev);
			TurqInventoryCard card = new TurqInventoryCard();
			card.setInventoryCardsId(cardId);
			invPrice.setPricesType(price_type);
			invPrice.setPricesAmount(new BigDecimal(amount));
			invPrice.setTurqInventoryCard(card);
			invPrice.setTurqCurrency(currency);
			invPrice.setCreatedBy(System.getProperty("user"));
			invPrice.setUpdatedBy(System.getProperty("user"));
			invPrice
					.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			invPrice
					.setCreationDate(new java.sql.Date(cal.getTime().getTime()));

			cardAdd.saveInvPrice(invPrice);

		} catch (Exception ex) {

			throw ex;
		}

	}

	public void saveOrUpdateObject(Object obj)throws Exception{
		try{
			
		cardAdd.saveOrUpdateObject(obj);	
			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	public void saveInvGroup(String groupName, String groupDescription)
			throws Exception {
		try {
			TurqInventoryGroup invGroup = new TurqInventoryGroup();
			TurqCompany company = new TurqCompany();	
			company.setCompaniesId(Integer.valueOf(System.getProperty("company")));
			invGroup.setTurqCompany(company);
			invGroup.setGroupsName(groupName);
			invGroup.setGroupsDescription(groupDescription);
			
			invGroup.setCreatedBy(System.getProperty("user"));
			invGroup.setUpdatedBy(System.getProperty("user"));
			invGroup.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			invGroup.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			
			cardAdd.saveOrUpdateInventoryGroup(invGroup);
			
			
			
			

		} catch (Exception ex) {
			throw ex;
		}

	}

	public Integer saveInvCard(String invCode, String invSpecialCode,
			String cardName, String cardDefinition, int minAmount,
			int maxAmount, int cardVat, int discount, int accountIdBuy,
			int accountIdSell) throws Exception {

		try {

			TurqCompany company = new TurqCompany();
			company.setCompaniesId(Integer.valueOf(System
					.getProperty("company")));
			TurqAccountingAccount accountBuy = new TurqAccountingAccount();
			TurqAccountingAccount accountSell = new TurqAccountingAccount();
			accountBuy.setAccountingAccountsId(new Integer(accountIdBuy));
			accountSell.setAccountingAccountsId(new Integer(accountIdSell));

			TurqInventoryCard card = new TurqInventoryCard();
			card.setCardDefinition(cardDefinition);
			card.setCardDiscount(discount);
			card.setCardInventoryCode(invCode);
			card.setCardMaximumAmount(maxAmount);
			card.setCardMinimumAmount(minAmount);
			card.setCardName(cardName);
			card.setCardSpecialCode(invSpecialCode);
			card.setCardVat(cardVat);
			card.setCreatedBy(System.getProperty("user"));
			card.setUpdatedBy(System.getProperty("user"));
			card.setUpdateDate(new java.sql.Date(cal.getTime().getTime()));
			card.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			card.setTurqAccountingAccountByAccountingAccountsIdBuy(accountBuy);
			card.setTurqAccountingAccountByAccountingAccountsIdSell(accountSell);
			card.setTurqCompany(company);

			cardAdd.saveOrUpdateInvCard(card);

			return card.getInventoryCardsId();

		} catch (Exception ex) {
			throw ex;
		}

	}
	
	public void deleteObject(Object obj)throws Exception{
		try{
			
		cardAdd.deleteObject(obj);	
			
			
		}
		catch(Exception ex){
			throw ex;
		}
	}

	public List getInventoryGroups() throws Exception {

		try {

			return cardAdd.getInventoryGroups();

		} catch (Exception ex) {
			throw ex;
		}

	}

	public List getInventoryUnits() throws Exception {

		try {

			return cardAdd.getInventoryUnits();

		} catch (Exception ex) {
			throw ex;
		}

	}

	public List getCurrencies() throws Exception {
		try {

			return cardAdd.getCurrencies();

		} catch (Exception ex) {
			throw ex;
		}

	}

}