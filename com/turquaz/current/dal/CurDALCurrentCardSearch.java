/*
 * Created on 22.Eki.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.current.dal;

import java.util.List;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentGroup;
import com.turquaz.engine.dal.TurqInventoryCard;

/**
 * @author Ceday
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CurDALCurrentCardSearch {
	
	public CurDALCurrentCardSearch(){
		
	}
	
	public List searchCurrentCards(String currentCode, String currentName,
									TurqCurrentGroup cardGroup)
	throws Exception{
		try{
			Session session = EngDALSessionFactory.openSession();
		
			String query = "Select currentCard from TurqCurrentCard as currentCard left join" +
					" currentCard.turqCurrentCardsGroups as gr where" +
					" currentCard.cardsCurrentCode like '"+currentCode+"%' and" +
					" currentCard.cardsName like '"+currentName+"%' and" +
					" currentCard.turqCompany.companiesId ="+System.getProperty("company");

		
			if (cardGroup!=null){
				query +=" and currentCard.turqCurrentGroup = :cardGroup";
			}		
			Query q = session.createQuery(query); 	
			if (cardGroup!=null){
				q.setParameter("cardGroup",cardGroup);
			}
			List list = q.list();
			
			for (int i =0;i<list.size();i++){				
				TurqCurrentCard curCard= (TurqCurrentCard)list.get(i);
				Hibernate.initialize(curCard.getTurqCurrentCardsGroups());
				Hibernate.initialize(curCard.getTurqCurrentContacts());			
			}
			
			session.close();
			return list;
		}
		catch(Exception ex){
			throw ex;
		}
	}

}
