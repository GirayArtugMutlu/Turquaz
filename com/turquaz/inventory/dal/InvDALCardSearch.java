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
