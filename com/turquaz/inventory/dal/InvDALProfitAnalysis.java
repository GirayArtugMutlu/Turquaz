
package com.turquaz.inventory.dal;

import java.util.Date;
import java.util.List;

import com.turquaz.engine.dal.EngDALSessionFactory;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

public class InvDALProfitAnalysis {
 
    public InvDALProfitAnalysis(){
        
    }
    public List getInventoryTotalsAccordingToAvarage(Date startDate, Date endDate)throws Exception {
        try{
           
            Session session = EngDALSessionFactory.openSession();
            String query = "select avg(invTrans.) ";
            
            
            Query q = session.createQuery(query);
            q.setParameter("startDate",startDate);
            q.setParameter("endDate",endDate);
           
            List list=q.list(); 
            return list;
            
        }
        catch(Exception ex){
            throw ex;
        }
        
        
        
    }
    
    
    
}
