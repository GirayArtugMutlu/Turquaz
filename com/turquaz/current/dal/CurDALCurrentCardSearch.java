/*
 * Created on 22.Eki.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
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
import java.util.List;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentGroup;



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
		
			String query = "Select currentView, currentCard from TurqViewCurrentAmountTotal as currentView," +
					" TurqCurrentCard as currentCard left join fetch" +
					" currentCard.turqCurrentCardsGroups as gr where" +
					" currentCard.currentCardsId=currentView.currentCardsId" +
					" and currentCard.cardsCurrentCode like '"+currentCode+"%'"+
					" and currentCard.cardsName like '"+currentName+"%'"+
					" and currentCard.currentCardsId <> -1";
			if (cardGroup!=null){
				query +=" and :cardGroup in (Select gr.turqCurrentGroup from gr)";
				//query +=" and gr.turqCurrentGroup = :cardGroup)";//left join fetch" +
			}		
			Query q = session.createQuery(query); 	
			if (cardGroup!=null){
				q.setParameter("cardGroup",cardGroup);
			}
			List list = q.list();
			
			for (int i =0;i<list.size();i++){				
				TurqCurrentCard curCard= (TurqCurrentCard)((Object[])list.get(i))[1];
				//Hibernate.initialize(curCard.getTurqCurrentCardsGroups());
				Hibernate.initialize(curCard.getTurqCurrentContacts());		
				Hibernate.initialize(curCard.getTurqCurrentCardsPhones());

			}
			
			session.close();
			return list;
		}
		catch(Exception ex){
			throw ex;
		}
	}

}
