
package com.turquaz.admin.dal;

import java.util.List;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqCompany;

public class AdmDALCompanyInfo {

    public void updateObject(Object obj) throws Exception {
		try {

			Session session = EngDALSessionFactory.openSession();
			Transaction tx = session.beginTransaction();

			session.update(obj);
			session.flush();
			tx.commit();
			session.close();

		} catch (Exception ex) {

			throw ex;

		}
	}
    public TurqCompany getCompany()throws Exception {
        try{
            
            Session session = EngDALSessionFactory.openSession();
            String query = "from TurqCompany as company";
            Query q = session.createQuery(query);
            List lst = q.list();
           
            if(lst.size()>0){
                return (TurqCompany)lst.get(0);
            }
            
            return null;
            
            
            
            
            
            
        }
        catch(Exception ex){
            throw ex;
            
        }
    }
    
    
}
