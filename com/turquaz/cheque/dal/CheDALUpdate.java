
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

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Session;

import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqChequeRoll;

public class CheDALUpdate {
    public static void initializeChequeRoll(TurqChequeRoll chequeRoll)throws Exception {
        try{
            
            Session session = EngDALSessionFactory.openSession();
            
            session.refresh(chequeRoll);
            Hibernate.initialize(chequeRoll.getTurqChequeChequeInRolls());
            Hibernate.initialize(chequeRoll.getTurqEngineSequence().getTurqCurrentTransactions());
            Hibernate.initialize(chequeRoll.getTurqEngineSequence().getTurqBanksTransactionBills());
            
            session.close();
            
            
        }
        catch(Exception ex){
            throw ex;
        }
    }
}