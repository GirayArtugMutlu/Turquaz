
package com.turquaz.inventory.dal;

import java.util.Date;
import java.util.List;

import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqInventoryCard;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

public class InvDALProfitAnalysis {
 
    public InvDALProfitAnalysis(){
        
    }
    public List getInventoryTotalsAccordingToAvarage(TurqInventoryCard invCard, Date startDate, Date endDate)throws Exception {
        try{
           
            Session session = EngDALSessionFactory.openSession();
            String query = "select avg(invTrans.transactionsUnitPrice * invTrans.transactionsAmountIn) from TurqInventoryTransaction as invTrans" +
            		" where invTrans.transactionsAmountIn <> 0 group by invTrans.turqInventoryCard";
            
            
            Query q = session.createQuery(query);
          //  q.setParameter("startDate",startDate);
          //  q.setParameter("endDate",endDate);
           
            List list=q.list(); 
            return list;
            
        }
        catch(Exception ex){
            throw ex;
        }
        
        
        
    }
    
    
    
}
