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

 * @author Onsel Armagan
 * @version $Id$
 */


import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqInventoryAccountingAccount;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryCardGroup;
import com.turquaz.engine.dal.TurqInventoryCardUnit;
import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.dal.TurqInventoryPrice;
import com.turquaz.engine.dal.TurqInventoryUnit;
import com.turquaz.inventory.dal.InvDALCardAdd;


public class InvBLCardAdd {

    private InvDALCardAdd cardAdd;

    private InvBLCardSearch cardSearch = new InvBLCardSearch();

    private static Calendar cal = Calendar.getInstance();

    public InvBLCardAdd() {

        cardAdd = new InvDALCardAdd();

    }

    public void registerGroup(TurqInventoryCard card, Object grp) throws Exception {
        try {

            TurqInventoryCardGroup cardGroup = new TurqInventoryCardGroup();
            TurqInventoryGroup group = (TurqInventoryGroup) grp;
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

    public void registerUnits(TurqInventoryCard card, Object unitObj, BigDecimal factor)
            throws Exception {

        TurqInventoryCardUnit cardUnit = new TurqInventoryCardUnit();
        TurqInventoryUnit unit = (TurqInventoryUnit) unitObj;
        cardUnit.setCardUnitsFactor(factor);
        cardUnit.setTurqInventoryCard(card);
        cardUnit.setTurqInventoryUnit(unit);
        cardUnit.setCreatedBy(System.getProperty("user"));
        cardUnit.setUpdatedBy(System.getProperty("user"));
        cardUnit.setLastModified(new java.sql.Date(cal.getTime().getTime()));
        cardUnit.setCreationDate(new java.sql.Date(cal.getTime().getTime()));

        cardAdd.saveOrUpdateCardUnit(cardUnit);

    }

    public void saveInvPrices(TurqInventoryCard card, boolean price_type,
            String currency_abrev, String amount) throws Exception {
        try {

            TurqInventoryPrice invPrice = new TurqInventoryPrice();
            TurqCurrency currency = cardAdd.getCurrency(currency_abrev);
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
    
    public static void saveInvAccount(TurqInventoryAccountingAccount invAcc,TurqInventoryCard card) throws Exception {
        try {

        	invAcc.setTurqInventoryCard(card);
        	invAcc.setCreatedBy(System.getProperty("user"));
        	invAcc.setUpdatedBy(System.getProperty("user"));
        	invAcc.setLastModified(new java.sql.Date(cal.getTime().getTime()));
        	invAcc.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
            InvDALCardAdd.saveInvAccount(invAcc);

        } catch (Exception ex) {

            throw ex;
        }

    }

    public void saveOrUpdateObject(Object obj) throws Exception {
        try {

            cardAdd.saveOrUpdateObject(obj);

        } catch (Exception ex) {
            throw ex;
        }

    }

    public void saveUnit(String unitName) throws Exception {
        try {
            TurqInventoryUnit invUnit = new TurqInventoryUnit();
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

    public void saveInvGroup(String groupName, String groupDescription,
            TurqInventoryGroup parent) throws Exception {
        try {
            if (parent == null) {
                parent = new TurqInventoryGroup();
                parent.setId(new Integer(-1));

            }
            TurqInventoryGroup invGroup = new TurqInventoryGroup();
            invGroup.setGroupsName(groupName);
            invGroup.setGroupsDescription(groupDescription);
            invGroup.setTurqInventoryGroup(parent);

            invGroup.setCreatedBy(System.getProperty("user"));
            invGroup.setUpdatedBy(System.getProperty("user"));
            invGroup
                    .setLastModified(new java.sql.Date(cal.getTime().getTime()));
            invGroup
                    .setCreationDate(new java.sql.Date(cal.getTime().getTime()));

            cardAdd.saveOrUpdateObject(invGroup);

        } catch (Exception ex) {
            throw ex;
        }

    }

    public void updateInvGroup(String groupName, String groupDescription,
            TurqInventoryGroup invGroup) throws Exception {
        try {

            invGroup.setGroupsName(groupName);
            invGroup.setGroupsDescription(groupDescription);

            invGroup.setUpdatedBy(System.getProperty("user"));
            invGroup
                    .setLastModified(new java.sql.Date(cal.getTime().getTime()));

            cardAdd.saveOrUpdateInventoryGroup(invGroup);

        } catch (Exception ex) {
            throw ex;
        }

    }

    public TurqInventoryCard saveInvCard(String invCode, String cardName,
            String cardDefinition, int minAmount, int maxAmount, int cardVat,
            int discount, int cardSpecialVat,
            BigDecimal cardSpecialVatEach, boolean isSpecAmount)
            throws Exception {

        try {

            TurqInventoryCard card = new TurqInventoryCard();
            card.setCardDefinition(cardDefinition);
            card.setCardDiscount(discount);
            card.setCardInventoryCode(invCode);
            card.setCardMaximumAmount(maxAmount);
            card.setCardMinimumAmount(minAmount);
            card.setCardName(cardName);
            card.setCardVat(cardVat);
            card.setCardSpecialVat(cardSpecialVat);
            card.setCardSpecialVatEach(cardSpecialVatEach);
            card.setCreatedBy(System.getProperty("user"));
            card.setUpdatedBy(System.getProperty("user"));
            card.setUpdateDate(new java.sql.Date(cal.getTime().getTime()));
            card.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
            card.setSpecVatForEach(isSpecAmount);
            InvDALCardAdd.saveOrUpdateInvCard(card);

            return card;

        } catch (Exception ex) {
            throw ex;
        }

    }

    public void deleteObject(Object obj) throws Exception {
        try {

            cardAdd.deleteObject(obj);

        } catch (Exception ex) {
            throw ex;
        }
    }

    public static List getInventoryGroups() throws Exception {

        try {

            return InvDALCardAdd.getInventoryGroups();

        } catch (Exception ex) {
            throw ex;
        }

    }

    public static List getParentInventoryGroups() throws Exception {

        try {

            return InvDALCardAdd.getParentInventoryGroups();

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

    public List searchInventoryCards(TurqInventoryGroup invGroup,
            String invName, String invCode) {
        try {
            String query = "from TurqInventoryCard as invCard";
            return null;

        } catch (Exception ex) {

            return null;
        }

    }

}