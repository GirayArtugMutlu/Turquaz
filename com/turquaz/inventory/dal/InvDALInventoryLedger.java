
package com.turquaz.inventory.dal;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.turquaz.engine.dal.EngDALSessionFactory;

import net.sf.hibernate.Session;

public class InvDALInventoryLedger {
    public InvDALInventoryLedger(){
        
        
    }
    
    public List getInventoryLedger(Date date)throws Exception{
    
        try{
            SimpleDateFormat frmt = new SimpleDateFormat("yyyy-MM-dd");
            String date_str = frmt.format(date);
           Session session = EngDALSessionFactory.openSession(); 
           
           Statement stmt = session.connection().createStatement();
           
           String query ="SELECT trans.card_inventory_code,trans.card_name, transin.totalamountin AS total_amount_in, transin.totalpricein AS total_price_in, transout.totalamountout AS total_amount_out " +
           		" FROM turq_inventory_cards trans " +
           		" LEFT JOIN ( SELECT turq_inventory_transactions.inventory_cards_id, sum(turq_inventory_transactions.transactions_total_price) AS totalpricein, sum(turq_inventory_transactions.transactions_amount_in) AS totalamountin " +
           		" FROM turq_inventory_transactions " +
           		" WHERE turq_inventory_transactions.transactions_amount_in <> 0 and turq_inventory_transactions.transactions_date <= '"+date_str+"' " +
           		" GROUP BY turq_inventory_transactions.inventory_cards_id) transin ON trans.inventory_cards_id = transin.inventory_cards_id " +
           		" LEFT JOIN ( SELECT turq_inventory_transactions.inventory_cards_id, sum(turq_inventory_transactions.transactions_total_price) AS totalpriceout, sum(turq_inventory_transactions.transactions_total_amount_out) AS totalamountout " +
           		" FROM turq_inventory_transactions " +
           		" WHERE turq_inventory_transactions.transactions_total_amount_out <> 0 and turq_inventory_transactions.transactions_date <=  '"+date_str+"' "  +
           		" GROUP BY turq_inventory_transactions.inventory_cards_id) transout ON trans.inventory_cards_id = transout.inventory_cards_id " ;
           
          ResultSet rs = stmt.executeQuery(query);
          Object [] result;
          List ls = new ArrayList();
          
          while(rs.next()){
              result = new Object[5];
              result[0] = rs.getObject(1);
              result[1] = rs.getObject(2);
              result[2] = rs.getObject(3);
              result[3] = rs.getObject(4);
              result[4] = rs.getObject(5);
               ls.add(result);             
          }
          session.close();
          
          return ls; 
        
        }
        catch(Exception ex){
            throw ex;
        }
        
    }

}