
package com.turquaz.cheque.dal;

import java.util.Date;
import java.util.List;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqChequeTransactionType;

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
}
