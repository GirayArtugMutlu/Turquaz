
package com.turquaz.cheque.dal;

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
