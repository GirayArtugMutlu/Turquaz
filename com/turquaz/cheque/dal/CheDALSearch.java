
package com.turquaz.cheque.dal;
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
* @author  Onsel
* @version  $Id$
*/

import java.util.Date;
import java.util.List;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqChequeTransactionType;
import com.turquaz.engine.dal.TurqViewChequeStatus;

public class CheDALSearch {

    public static List searchChequeRoll(String rollNo, Date startDate,Date endDate, TurqChequeTransactionType type)throws Exception {
        try{
            
            Session session = EngDALSessionFactory.openSession();

			String query = "select chequeRoll from TurqChequeRoll as chequeRoll " +
					"where chequeRoll.chequeRollsDate >= :startDate and chequeRoll.chequeRollsDate <=:endDate " +
					"and chequeRoll.chequeRollNo like '"+rollNo+"%'" ;
					
			if(type!=null){
			    
			    query += " and chequeRoll.turqChequeTransactionType = :type ";
			    
			}
			
			query += " order by chequeRoll.chequeRollsDate ";
		
			Query q = session.createQuery(query);

			q.setParameter("startDate", startDate); //$NON-NLS-1$
			q.setParameter("endDate", endDate); //$NON-NLS-1$
			
			if(type!=null){
			    
			    q.setParameter("type",type);
			    
			}

			List list = q.list();
			session.close();
			return list;
            
        }
        catch(Exception ex){
            throw ex;
        }
    }
    public static List getTransactionTypes()throws Exception {
        try{
            Session session = EngDALSessionFactory.openSession(); 
            Query q = session.createQuery("select transType from TurqChequeTransactionType as transType");
            List list = q.list();
			session.close();
			return list;
            
        }
        catch(Exception ex){
            throw ex;
        }
    }
    
    //Portfoydeki ceklerin listesini getir.
    public static List getChequesInPortfolio()throws Exception{
        try{
            
            Session session = EngDALSessionFactory.openSession(); 
            TurqViewChequeStatus chequeStatus = null;
   
            
            String query = "Select cheque, currentCard.cardsName from TurqChequeCheque as cheque, TurqViewChequeStatus as chequeStatus, TurqCurrentCard currentCard " +
            		"where cheque.chequeChequesId = chequeStatus.chequeChequesId " +
            		" and currentCard.currentCardsId =  chequeStatus.currentCardsId " +
            		" and chequeStatus.chequeTransactionTypesId ="+EngBLCommon.CHEQUE_TRANS_IN;
            
            
            
            
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
