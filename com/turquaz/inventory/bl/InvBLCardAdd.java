/*
 * Created on Sep 27, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.inventory.bl;

import java.util.Calendar;
import java.util.List;


import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCompany;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.inventory.dal.InvDALCardAdd;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class InvBLCardAdd {
	
	private InvDALCardAdd cardAdd;
	
	Calendar cal = Calendar.getInstance();
	public InvBLCardAdd(){
	
		cardAdd = new InvDALCardAdd();
		
	}
	
	public int saveInvCard(String invCode, String invSpecialCode,
							String cardName, String cardDefinition,
							int minAmount, int maxAmount, int cardVat,
							int discount,int accountIdBuy,int accountIdSell 
							)throws Exception{
		 
	    try{
	    	TurqCompany company = new TurqCompany();
			company.setCompaniesId(Integer.valueOf(System.getProperty("company")));
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
			card.setUpdateDate(new java.sql.Date( cal.getTime().getTime()));
			card.setCreationDate(new java.sql.Date( cal.getTime().getTime()));
	    	card.setTurqAccountingAccountByAccountingAccountsIdBuy(accountBuy);
	    	card.setTurqAccountingAccountByAccountingAccountsIdSell(accountSell);
	       	card.setTurqCompany(company);
	       	
	        cardAdd.saveOrUpdateInvCard(card);
	      	
	        return card.getInventoryCardsId().intValue();
		 	
		 
		 }
		 catch(Exception ex){
		 	throw ex;
		 }
			
			
		}
	public List getInventoryGroups()throws Exception{
	
		try{
			
			return cardAdd.getInventoryGroups();
			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	public List getInventoryUnits()throws Exception{
		
			try{
				
				return cardAdd.getInventoryUnits();
				
			}
			catch(Exception ex){
				throw ex;
			}
			
		}
	public List getCurrencies()throws Exception{
		try{
			
			return cardAdd.getCurrencies();
			
		}
		catch(Exception ex){
			throw ex;
		}
		
		
	}

}
