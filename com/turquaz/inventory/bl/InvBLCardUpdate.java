/*
 * Created on Oct 12, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.inventory.bl;

import java.util.Calendar;

import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCompany;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.inventory.dal.InvDALCardSearch;
import com.turquaz.inventory.dal.InvDALCardUpdate;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class InvBLCardUpdate {
	private InvDALCardUpdate cardUpdate = new InvDALCardUpdate();

	Calendar cal = Calendar.getInstance();
   
	public InvBLCardUpdate(){
		
	}
	public void updateInvCard(String invCode, String invSpecialCode,
			String cardName, String cardDefinition, int minAmount,
			int maxAmount, int cardVat, int discount, int accountIdBuy,
			int accountIdSell,TurqInventoryCard card) throws Exception{
		try {

		
			TurqAccountingAccount accountBuy = new TurqAccountingAccount();
			TurqAccountingAccount accountSell = new TurqAccountingAccount();
			accountBuy.setAccountingAccountsId(new Integer(accountIdBuy));
			accountSell.setAccountingAccountsId(new Integer(accountIdSell));

			card.setCardDefinition(cardDefinition);
			card.setCardDiscount(discount);
			card.setCardInventoryCode(invCode);
			card.setCardMaximumAmount(maxAmount);
			card.setCardMinimumAmount(minAmount);
			card.setCardName(cardName);
			card.setCardSpecialCode(invSpecialCode);
			card.setCardVat(cardVat);
		
			card.setUpdatedBy(System.getProperty("user"));
			card.setUpdateDate(new java.sql.Date(cal.getTime().getTime()));
		
			card.setTurqAccountingAccountByAccountingAccountsIdBuy(accountBuy);
			card.setTurqAccountingAccountByAccountingAccountsIdSell(accountSell);
		

			cardUpdate.updateObject(card);


		} catch (Exception ex) {
			throw ex;
		}
	}
	
	

}
