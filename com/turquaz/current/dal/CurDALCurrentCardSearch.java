
package com.turquaz.current.dal;
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
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCurrentAccountingAccount;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentGroup;
import com.turquaz.engine.dal.TurqViewCurrentAmountTotal;



/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* *************************************
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED
* for this machine, so Jigloo or this code cannot be used legally
* for any corporate or commercial purpose.
* *************************************
*/

public class CurDALCurrentCardSearch {
	
	public CurDALCurrentCardSearch(){
		
	}
	
	public static List searchCurrentCards(String currentCode, String currentName,
									TurqCurrentGroup cardGroup)
	throws Exception{
		try{
			Session session = EngDALSessionFactory.openSession();
		
			String query = "Select currentView, currentCard.cardsCurrentCode," +
					" currentCard.cardsName, currentCard.id" +
					" from TurqViewCurrentAmountTotal as currentView," +
					" TurqCurrentCard as currentCard";
			if (cardGroup != null )
			{
				query +=" left join  currentCard.turqCurrentCardsGroups as gr ";
			}
			query+=" where currentCard.id=currentView.currentCardsId" +
					" and currentCard.cardsCurrentCode like '"+currentCode+"%'"+
					" and currentCard.cardsName like '"+currentName+"%'"+
					" and currentCard.id <> -1";
			if (cardGroup!=null){
				//query +=" and :cardGroup in (Select gr.turqCurrentGroup from gr)";
				query +=" and gr.turqCurrentGroup = :cardGroup";//left join fetch" +
			}		
			query += " order by currentCard.cardsCurrentCode";
			Query q = session.createQuery(query); 	
			if (cardGroup!=null){
				q.setParameter("cardGroup",cardGroup);
			}
			q.setMaxResults(1000);
			List list = q.list();
			
		/*	for (int i =0;i<list.size();i++){				
				TurqCurrentCard curCard= (TurqCurrentCard)((Object[])list.get(i))[1];
				//Hibernate.initialize(curCard.getTurqCurrentCardsGroups());
				Hibernate.initialize(curCard.getTurqCurrentContacts());		
				Hibernate.initialize(curCard.getTurqCurrentCardsPhones());

			}
		*/	
			session.close();
			return list;
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public static TurqViewCurrentAmountTotal getCurrentCardView (TurqCurrentCard currentCard)
	throws Exception	
	{
		try{
			Session session = EngDALSessionFactory.openSession();
		
			String query = "Select currentView from TurqViewCurrentAmountTotal as currentView," +
					" where currentView.currentCardsId="+currentCard.getId();
	
			Query q = session.createQuery(query); 	
			List list = q.list();			
			session.close();
			return ((TurqViewCurrentAmountTotal)list.get(0));
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	
	public static List getTransactions(TurqCurrentCard curCard) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.openSession();
			
			String query = "Select bankTrans from TurqCurrentTransaction as bankTrans" +
					" where bankTrans.turqCurrentCard.id="+curCard.getId()+
					" and bankTrans.turqCurrentTransactionType.id <>"+EngBLCommon.CURRENT_TRANS_INITIAL;

			Query q = session.createQuery(query); 	
			List list = q.list();
			session.close();
			return list;
			
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
	
	public static List getCurrentCards()throws Exception{
	    try{
	        
	        Session session = EngDALSessionFactory.openSession();
	        String query = "Select curCard.cardsCurrentCode, curCard.cardsName from TurqCurrentCard as curCard " +
	        		" where curCard.id <> -1" ;
		 
	        Query q = session.createQuery(query);
	        
	        List list = q.list();
	        session.close();
	        
	        return list;
	        
	    }
	    catch(Exception ex){
	        throw ex;
	    }
	    
	
	}
	public static List getCurrentCardsAndAccountingAccounts()throws Exception{
		  try{
	        
	        Session session = EngDALSessionFactory.openSession();
	        String query = "Select curCard.id, curCard.accounting_code_id from turq_current_cards curCard " +
	        		" where curCard.id <> -1" ;
		 
	        Statement stmt = session.connection().createStatement();
	       ResultSet rs = stmt.executeQuery(query);
	        List list =new ArrayList();
	       while(rs.next())
	       {
	       	Object []result = new Object[2];
	       	result[0] =rs.getString(1);
	       	result[1] = rs.getString(2);
	       	list.add(result);
	       	
	       }
	        
	        session.close();
	        
	        return list;
	        
	    }
	    catch(Exception ex){
	        throw ex;
	    }
	}
	public static TurqCurrentCard getCurrentCard(String cardCode)throws Exception{
	    try{
	        
	        Session session = EngDALSessionFactory.openSession();
	        String query = "Select curCard from TurqCurrentCard as curCard " +
	        		" where curCard.cardsCurrentCode=:cardCode";
	        
		 
	        Query q = session.createQuery(query);
	        q.setParameter("cardCode",cardCode.trim());
	        List list = q.list();
	        
	        session.close();
	        
	        if(list.size()>0){
	            
	           return (TurqCurrentCard)list.get(0);
	            
	        }
	       else{
	           return null;
	       }
	        
	    }
	    catch(Exception ex){
	        throw ex;
	    }
	    
	
	}
	public static TurqCurrentCard initializeCurrentCard(Integer curCardId)throws Exception {
		try{
			  Session session = EngDALSessionFactory.openSession();
			 TurqCurrentCard curCard =(TurqCurrentCard) session.load(TurqCurrentCard.class,curCardId);
			  Hibernate.initialize(curCard.getTurqCurrentCardsPhones());
			  Hibernate.initialize(curCard.getTurqCurrentContacts());
			  Hibernate.initialize(curCard.getTurqCurrentCardsGroups());
			  Hibernate.initialize(curCard.getTurqCurrentAccountingAccounts());
			
			  session.close();
			  return curCard;
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public static TurqAccountingAccount getCurrentAccountingAccount(TurqCurrentCard curCard, Integer type)throws Exception{
		try{
			
			Session session = EngDALSessionFactory.openSession();
			session.refresh(curCard);
			Iterator it = curCard.getTurqCurrentAccountingAccounts().iterator();
			while(it.hasNext())
			{
				TurqCurrentAccountingAccount curAccount = (TurqCurrentAccountingAccount)it.next();
				
				if(curAccount.getTurqCurrentAccountingType().getId().intValue()==type.intValue())
				{
					return curAccount.getTurqAccountingAccount();
				}
				
			}
			
			return null;
			
			
		}
		catch(Exception ex){
			throw ex;
		}
	}

	public static List getTurqCurrentGroups() throws Exception {
		try{
			
			Session session = EngDALSessionFactory.openSession();
		
			String query = "from TurqCurrentGroup as gr ";	
			Query q = session.createQuery(query); 
			List list = q.list();
		
			session.close();
			return list;	
			
		}
		catch(Exception ex){
			throw ex;
		}
	}

}
