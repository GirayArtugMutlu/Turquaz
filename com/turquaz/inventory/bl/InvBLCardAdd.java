/*
 * Created on Sep 27, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.inventory.bl;
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

/**
* @author  Onsel Armagan
* @version  $Id$
*/


import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;


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
	public void saveUnit(String unitName)throws Exception {
		try {
			TurqInventoryUnit invUnit = new TurqInventoryUnit();
			TurqCompany company = new TurqCompany();	
			company.setCompaniesId(Integer.valueOf(System.getProperty("company")));
			invUnit.setTurqCompany(company);
			invUnit.setUnitsName(unitName);
			//invGroup.setGroupsDescription(groupDescription);
			
			invUnit.setCreatedBy(System.getProperty("user"));
			invUnit.setUpdatedBy(System.getProperty("user"));
			invUnit.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			invUnit.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			
			cardAdd.saveOrUpdateObject(invUnit);	
			
			
			

		} catch (Exception ex) {
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
			int maxAmount, int cardVat, int discount,TurqAccountingAccount accountBuy,
			TurqAccountingAccount accountSell,int cardSpecialVat, BigDecimal cardSpecialVatEach) throws Exception {

		try {

			TurqCompany company = new TurqCompany();
			company.setCompaniesId(Integer.valueOf(System
					.getProperty("company")));			

			TurqInventoryCard card = new TurqInventoryCard();
			card.setCardDefinition(cardDefinition);
			card.setCardDiscount(discount);
			card.setCardInventoryCode(invCode);
			card.setCardMaximumAmount(maxAmount);
			card.setCardMinimumAmount(minAmount);
			card.setCardName(cardName);
			card.setCardSpecialCode(invSpecialCode);
			card.setCardVat(cardVat);
			card.setCardSpecialVat(cardSpecialVat);
			card.setCardSpecialVatEach(cardSpecialVatEach);			
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
	public List searchInventoryCards(TurqInventoryGroup invGroup, String invName, String invCode){
		try{
			String query ="from TurqInventoryCard as invCard";
			return null;
			
		}
		catch(Exception ex){
			
			return null;
		}		
		
	}



}