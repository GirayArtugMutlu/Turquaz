
package com.turquaz.inventory.dal;

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
import java.util.List;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;


import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqViewInventoryAmountTotal;

import com.turquaz.engine.dal.TurqInventoryGroup;



public class InvDALCardSearch {

	public InvDALCardSearch()
	{
			
	}
	
	public List searchInventoryCards(String cardName, String cardCode, TurqInventoryGroup invGroup)throws Exception{
		try{
			
				Session session = EngDALSessionFactory.openSession();
				
				String query = "Select invView, invCard from TurqViewInventoryAmountTotal as invView," +
						" TurqInventoryCard as invCard" +						
						" where invCard.inventoryCardsId = invView.inventoryCardsId and " +
						" lower(invCard.cardName) like '"+cardName.toLowerCase()+"%' and invCard.cardInventoryCode like '"+cardCode+"%' ";
							
							   	
				if(invGroup!=null){
					
					query +="and :invGroup in (Select myGroup.turqInventoryGroup From invCard.turqCardGroups as myGroup)" ;
					
				}
				   
				Query q = session.createQuery(query); 
				if(invGroup!=null){
					q.setParameter("invGroup",invGroup);
				}
			
				List list = q.list();
			
			    session.close();
			
				return list;	
				
			}
			catch(Exception ex){
				throw ex;
			}
					
	}
	public void initializeInventoryCard(TurqInventoryCard invCard )throws Exception{
	    try{
	        Session session = EngDALSessionFactory.openSession();
	        Transaction tx = session.beginTransaction();
	        
	        session.refresh(invCard);
	        Hibernate.initialize(invCard.getTurqInventoryCardGroups());
			Hibernate.initialize(invCard.getTurqInventoryPrices());
			Hibernate.initialize(invCard.getTurqInventoryCardUnits());
	        
	        
	        tx.commit();
	        session.flush();
	        session.close();
	        
	    }
	    catch(Exception ex){
	        throw ex;
	    }
	}
	
	public TurqViewInventoryAmountTotal getView (TurqInventoryCard invCard)throws Exception
	{
		
		try{
			
				Session session = EngDALSessionFactory.openSession();
				
				String query = "Select invView from TurqViewInventoryAmountTotal as invView"+
						" where  invView.inventoryCardsId ="+invCard.getInventoryCardsId();					
					
				   
				Query q = session.createQuery(query); 

			
				List list = q.list();			
			    session.close();			
				return (TurqViewInventoryAmountTotal)list.get(0);
				
			}
			catch(Exception ex){
				throw ex;
			}
	}
	

}
