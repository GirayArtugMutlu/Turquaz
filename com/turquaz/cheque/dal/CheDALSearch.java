
package com.turquaz.cheque.dal;

import java.util.List;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqChequeTransactionType;

public class CheDALSearch {

    public static List searchChequeRoll(String rollNo, String startDate, String endDate, TurqChequeTransactionType type)throws Exception {
        try{
            
            Session session = EngDALSessionFactory.openSession();

			String query = "";					
					

			

			Query q = session.createQuery(query);

			q.setParameter("startDate", startDate); //$NON-NLS-1$
			q.setParameter("endDate", endDate); //$NON-NLS-1$

		

			List list = q.list();
			session.close();
			return list;
            
        }
        catch(Exception ex){
            throw ex;
        }
    }
}
