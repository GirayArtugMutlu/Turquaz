/*
 * Created on Oct 11, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.inventory.dal;

import java.util.List;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryCardGroup;
import com.turquaz.engine.dal.TurqInventoryGroup;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class InvDALCardSearch {

	public InvDALCardSearch()
	{
			
	}
	
	public List searchInventoryCards(String cardName, String cardCode, TurqInventoryGroup invGroup)throws Exception{
		try{
			
				Session session = EngDALSessionFactory.openSession();
				
				String query = "Select invCard from TurqInventoryCard as invCard " +
								"left join invCard.turqInventoryCardGroups as cardGroup " +
							   "where invCard.turqCompany.companiesId ="+System.getProperty("company")+" " +
							   "and invCard.cardName like '"+cardName+"%' and invCard.cardInventoryCode like '"+cardCode+"%' ";
							
							   	
				if(invGroup!=null){
					
					query +="and cardGroup.turqInventoryGroup = :invGroup" ;
					
				}
				   

				Query q = session.createQuery(query); 
				if(invGroup!=null){
					q.setParameter("invGroup",invGroup);
				}
				
				List list = q.list();
				
				for (int i =0;i<list.size();i++){
					
				TurqInventoryCard invCard = (TurqInventoryCard)list.get(i);
				Hibernate.initialize(invCard.getTurqInventoryCardGroups());
				Hibernate.initialize(invCard.getTurqInventoryCardUnits());
				Hibernate.initialize(invCard.getTurqInventoryPrices());
				
				}
				
				
				
			    session.close();
			
				return list;	
				
			}
			catch(Exception ex){
				throw ex;
			}
					
	}
	
	

}
