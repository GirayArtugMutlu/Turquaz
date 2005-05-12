/*
 * Created on 06.Nis.2005
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.bl;

import java.lang.reflect.Method;
import java.sql.Statement;
import net.sf.hibernate.Session;
import com.turquaz.engine.EngConfiguration;
import com.turquaz.engine.backup.EngBackUp;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqSetting;

/**
 * @author Cem
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EngBLVersionValidate
{
	public static Boolean checkVersion() throws Exception
	{
		TurqSetting setting=EngBLCommon.getTurqSetting();
		if (setting.getDatabaseVersion().equals(EngBLCommon.DATABASE_VERSION))				
			return new Boolean(true);
		else 
			return new Boolean(false);
	}	
	
	public static Boolean validateVersion()throws Exception
	{
		try
		{
			EngBackUp.backUp("update");
			updateVersion();
			return new Boolean(true);
		}
		catch(Exception ex)
		{
            EngBLLogger.log(EngBLVersionValidate.class,ex);
			return new Boolean(false);
		}
	}
	
	public static void updateVersion() throws Exception
	{
		TurqSetting setting = EngBLCommon.getTurqSetting();
		String DBVersion=setting.getDatabaseVersion();
		if (!DBVersion.equals(EngBLCommon.DATABASE_VERSION))
		{
			DBVersion=DBVersion.replaceAll("\\.","");
			String dbType;
			if (EngConfiguration.getString("dbType").startsWith("Turquaz"))
			{
				dbType="HSQLDB";
			}
			else
			{
				dbType="PG";
			}
			String methodName=dbType+"updateVersion"+DBVersion;
			Class[] classList=new Class[]{TurqSetting.class};
			Object[] argList=new Object[]{setting};
			Method method=EngBLVersionValidate.class.getMethod(methodName,classList);
			method.invoke(null,argList);
			updateVersion();
		}
	}
	
	public static void HSQLDBupdateVersion070(TurqSetting setting)throws Exception
	{
		Session session = EngDALSessionFactory.getSession();
		Statement stmt = session.connection().createStatement();
		String query=	"INSERT INTO turq_module_components VALUES (90, 4, 'com.turquaz.current.ui.CurUICurCardDeptList', 'Cari Borclu Listesi', 'admin', '2005-04-05', 'admin', '2004-04-05');"+
						"INSERT INTO turq_module_components VALUES (91, 4, 'com.turquaz.current.ui.CurUICurCardCreditList', 'Cari Alacakli Listesi', 'admin', '2005-04-05', 'admin', '2005-04-05');";
		stmt.execute(query);
		setting.setDatabaseVersion("0.7.1");
		EngDALCommon.updateObject(setting);	
	
	}
	
	public static void PGupdateVersion070(TurqSetting setting)throws Exception
	{
		Session session = EngDALSessionFactory.getSession();
		Statement stmt = session.connection().createStatement();
		String query=	"INSERT INTO turq_module_components VALUES (90, 4, 'com.turquaz.current.ui.CurUICurCardDeptList', 'Cari Borclu Listesi', 'admin', '2005-04-05', 'admin', '2004-04-05');"+
						"INSERT INTO turq_module_components VALUES (91, 4, 'com.turquaz.current.ui.CurUICurCardCreditList', 'Cari Alacakli Listesi', 'admin', '2005-04-05', 'admin', '2005-04-05');";
		stmt.execute(query);
		setting.setDatabaseVersion("0.7.1");
		EngDALCommon.updateObject(setting);	
	
	}
	public static void HSQLDBupdateVersion071(TurqSetting setting)throws Exception
	{
		Session session = EngDALSessionFactory.getSession();
		Statement stmt = session.connection().createStatement();
		String query="INSERT INTO TURQ_CURRENT_TRANSACTION_TYPES VALUES(8,'Virman','admin','2004-10-18','admin','2004-10-18')";
		stmt.execute(query);
		query="INSERT INTO turq_module_components VALUES (92, 4, 'com.turquaz.current.ui.CurUICurrentTransfer', 'Cari Virman', 'cem', '2005-02-28', 'cem', '2005-02-28')";
		stmt.execute(query);
		setting.setDatabaseVersion("0.7.2");
		EngDALCommon.updateObject(setting);	
	
	}
	
	public static void PGupdateVersion071(TurqSetting setting)throws Exception
	{
		Session session = EngDALSessionFactory.getSession();
		Statement stmt = session.connection().createStatement();
		String query="INSERT INTO turq_module_components VALUES (92, 4, 'com.turquaz.current.ui.CurUICurrentTransfer', 'Cari Virman', 'cem', '2005-02-28', 'cem', '2005-02-28')";
		stmt.execute(query);
		setting.setDatabaseVersion("0.7.2");
		EngDALCommon.updateObject(setting);	
	}
	public static void HSQLDBupdateVersion072(TurqSetting setting)throws Exception
	{
		Session session = EngDALSessionFactory.getSession();
		Statement stmt = session.connection().createStatement();
		String query="INSERT INTO turq_cash_transaction_types VALUES (6, 'Acilis', 'admin', '2004-12-12', 'admin', '2004-12-12');"+
					 "INSERT INTO turq_module_components VALUES (93, 8, 'com.turquaz.cash.ui.CashUIInitialTransactions', 'Kasa Acilis', 'cem', '2005-02-28', 'cem', '2005-02-28');"+
					 "INSERT INTO turq_module_components VALUES (94, 6, 'com.turquaz.consignment.ui.ConUIAddBuyConsignment', 'Alis Irsaliyesi Ekle', 'onsel', '2004-10-18', 'onsel', '2004-10-18');"+
					 "INSERT INTO turq_module_components VALUES (95, 6, 'com.turquaz.consignment.ui.ConUIAddSellConsignment', 'Satis Irsaliyesi Ekle', 'onsel', '2004-10-18', 'onsel', '2004-10-18');";
		stmt.execute(query);		
		setting.setDatabaseVersion("0.7.3");
		EngDALCommon.updateObject(setting);		
	}
	
	public static void PGupdateVersion072(TurqSetting setting)throws Exception
	{
		Session session = EngDALSessionFactory.getSession();
		Statement stmt = session.connection().createStatement();
		String query="INSERT INTO turq_cash_transaction_types VALUES (6, 'Acilis', 'admin', '2004-12-12', 'admin', '2004-12-12');"+
					 "INSERT INTO turq_module_components VALUES (93, 8, 'com.turquaz.cash.ui.CashUIInitialTransactions', 'Kasa Acilis', 'cem', '2005-02-28', 'cem', '2005-02-28');"+
					 "INSERT INTO turq_module_components VALUES (94, 6, 'com.turquaz.consignment.ui.ConUIAddBuyConsignment', 'Alis Irsaliyesi Ekle', 'onsel', '2004-10-18', 'onsel', '2004-10-18');"+
					 "INSERT INTO turq_module_components VALUES (95, 6, 'com.turquaz.consignment.ui.ConUIAddSellConsignment', 'Satis Irsaliyesi Ekle', 'onsel', '2004-10-18', 'onsel', '2004-10-18');";
		stmt.execute(query);		
		setting.setDatabaseVersion("0.7.3");
		EngDALCommon.updateObject(setting);	
	
	}
	public static void HSQLDBupdateVersion073(TurqSetting setting)throws Exception
	{
		Session session = EngDALSessionFactory.getSession();
		Statement stmt = session.connection().createStatement();
		String query= "INSERT INTO turq_module_components VALUES (96, 9, 'com.turquaz.cheque.ui.CheUIOwnChequeCollect', 'Firma Ceki Tahsili', 'onsel', '2004-10-18', 'onsel', '2004-10-18');"+
			  "INSERT INTO turq_cheque_transaction_types VALUES (8, 'Firma Ceki Tahsili', 3, 'admin', '2005-01-01', 'admin', '2005-01-01');"+
			  "INSERT INTO turq_banks_transaction_types VALUES (9, 'Cek Odemesi', 'admin', '2005-01-01', 'admin', '2005-01-01');" +
			  "INSERT INTO turq_module_components VALUES (97, 0, 'com.turquaz.inventory.ui.InvUIInitialTransacions', 'Stok Acilis Degerleri', 'onsel', '2004-10-18', 'onsel', '2004-10-18');";
		stmt.execute(query);		
		setting.setDatabaseVersion("0.7.4");
		EngDALCommon.updateObject(setting);		
	}
	
	public static void PGupdateVersion073(TurqSetting setting)throws Exception
	{
		Session session = EngDALSessionFactory.getSession();
		Statement stmt = session.connection().createStatement();
		String query= "INSERT INTO turq_module_components VALUES (96, 9, 'com.turquaz.cheque.ui.CheUIOwnChequeCollect', 'Firma Ceki Tahsili', 'onsel', '2004-10-18', 'onsel', '2004-10-18');"+
			  "INSERT INTO turq_cheque_transaction_types VALUES (8, 'Firma Ceki Tahsili', 3, 'admin', '2005-01-01', 'admin', '2005-01-01');"+
			  "INSERT INTO turq_banks_transaction_types VALUES (9, 'Cek Odemesi', 'admin', '2005-01-01', 'admin', '2005-01-01');" +
			  "INSERT INTO turq_module_components VALUES (97, 0, 'com.turquaz.inventory.ui.InvUIInitialTransacions', 'Stok Acilis Degerleri', 'onsel', '2004-10-18', 'onsel', '2004-10-18');";
		stmt.execute(query);
		setting.setDatabaseVersion("0.7.4");
		EngDALCommon.updateObject(setting);	
	
	}
    public static void HSQLDBupdateVersion074(TurqSetting setting)throws Exception
    {
        Session session = EngDALSessionFactory.getSession();
        Statement stmt = session.connection().createStatement();
        String query= "INSERT INTO turq_inventory_accounting_types VALUES (8, 'Return Buy', 'Alistan Iade Muhasebe Hesabi');"+
            "INSERT INTO turq_inventory_accounting_types VALUES (9, 'Return Sell', 'Satistan Iade Muhasebe Hesabi');" +
            "INSERT INTO turq_inventory_accounting_types VALUES (11, 'Return Sell VAT', 'Satistan Iade KDV Hesabi');" +
            "INSERT INTO turq_inventory_accounting_types VALUES (10, 'Return Buy VAT', 'Alistan Iade KDV Hesabi');" +
            "INSERT INTO turq_inventory_accounting_types VALUES (12, 'Return Buy Special VAT', 'Alistan Iade OTV Hesabi');" +
            "INSERT INTO turq_inventory_accounting_types VALUES (13, 'Return Sell Special VAT', 'Satistan Iade OTV Hesabi');" +
            "INSERT INTO turq_inventory_accounting_types VALUES (14, 'Return Buy Discount', 'Alistan Iade Indirim Hesabi');" +
            "INSERT INTO turq_inventory_accounting_types VALUES (15, 'Return Sell Discount', 'Satistan Iade Indirim Hesabi');" +
            "INSERT INTO turq_current_transaction_types VALUES (9, 'Coklu Borc', 'admin', '2004-10-18', 'admin', '2004-10-18');"+
            "INSERT INTO turq_current_transaction_types VALUES (10, 'Coklu Alacak', 'admin', '2004-10-18', 'admin', '2004-10-18');"+
            "INSERT INTO turq_module_components VALUES (98, 4, 'com.turquaz.current.ui.CurUICurCardBalanceReport', 'Cari Kart Mizani', 'admin', '2005-04-27', 'admin', '2005-04-27');"+
            "INSERT INTO turq_module_components VALUES (99, 4, 'com.turquaz.current.ui.CurUIMultipleCreditVoucher', 'Coklu Alacak Fisi', 'onsel', '2004-10-18', 'onsel', '2004-10-18');"+
            "INSERT INTO turq_module_components VALUES (100, 4, 'com.turquaz.current.ui.CurUIMultipleDeptVoucher', 'Coklu Borc Fisi', 'onsel', '2004-10-18', 'onsel', '2004-10-18');";
        stmt.execute(query);        
        setting.setDatabaseVersion("0.7.5");
        EngDALCommon.updateObject(setting);     
    }
    
    public static void PGupdateVersion074(TurqSetting setting)throws Exception
    {
        Session session = EngDALSessionFactory.getSession();
        Statement stmt = session.connection().createStatement();
        String query= "INSERT INTO turq_inventory_accounting_types VALUES (8, 'Return Buy', 'Alistan Iade Muhasebe Hesabi');"+
            "INSERT INTO turq_inventory_accounting_types VALUES (9, 'Return Sell', 'Satistan Iade Muhasebe Hesabi');" +
            "INSERT INTO turq_inventory_accounting_types VALUES (11, 'Return Sell VAT', 'Satistan Iade KDV Hesabi');" +
            "INSERT INTO turq_inventory_accounting_types VALUES (10, 'Return Buy VAT', 'Alistan Iade KDV Hesabi');" +
            "INSERT INTO turq_inventory_accounting_types VALUES (12, 'Return Buy Special VAT', 'Alistan Iade OTV Hesabi');" +
            "INSERT INTO turq_inventory_accounting_types VALUES (13, 'Return Sell Special VAT', 'Satistan Iade OTV Hesabi');" +
            "INSERT INTO turq_inventory_accounting_types VALUES (14, 'Return Buy Discount', 'Alistan Iade Indirim Hesabi');" +
            "INSERT INTO turq_inventory_accounting_types VALUES (15, 'Return Sell Discount', 'Satistan Iade Indirim Hesabi');" +
            "INSERT INTO turq_current_transaction_types VALUES (9, 'Coklu Borc', 'admin', '2004-10-18', 'admin', '2004-10-18');"+
            "INSERT INTO turq_current_transaction_types VALUES (10, 'Coklu Alacak', 'admin', '2004-10-18', 'admin', '2004-10-18');"+
            "INSERT INTO turq_module_components VALUES (98, 4, 'com.turquaz.current.ui.CurUICurCardBalanceReport', 'Cari Kart Mizani', 'admin', '2005-04-27', 'admin', '2005-04-27');"+
            "INSERT INTO turq_module_components VALUES (99, 4, 'com.turquaz.current.ui.CurUIMultipleCreditVoucher', 'Coklu Alacak Fisi', 'onsel', '2004-10-18', 'onsel', '2004-10-18');"+
            "INSERT INTO turq_module_components VALUES (100, 4, 'com.turquaz.current.ui.CurUIMultipleDeptVoucher', 'Coklu Borc Fisi', 'onsel', '2004-10-18', 'onsel', '2004-10-18');";
        stmt.execute(query);        
        setting.setDatabaseVersion("0.7.5");
        EngDALCommon.updateObject(setting);     
    }
    
    public static void HSQLDBupdateVersion075(TurqSetting setting)throws Exception
    {
        Session session = EngDALSessionFactory.getSession();
        Statement stmt = session.connection().createStatement();
   /*     String query="delete from turq_inventory_transactions where" +
        	" (turq_inventory_transactions.engine_sequences_id not in" +
        	" (Select cons.engine_sequences_id from turq_consignments cons)) " +
        	"  and (turq_inventory_transactions.engine_sequences_id not in" +
        	" (Select billInEngine.engine_sequences_id from turq_bill_in_engine_sequences billInEngine))";
     */
        String query = "INSERT INTO turq_module_components VALUES (101, 7, 'com.turquaz.bill.ui.BillUIAddReturnBuyBill', 'Alistan Iade Faturasi', 'onsel', '2004-10-18', 'onsel', '2004-10-18');"+
                       "INSERT INTO turq_module_components VALUES (102, 7, 'com.turquaz.bill.ui.BillUIAddReturnSellBill', 'Satistan Iade Faturasi', 'onsel', '2004-10-18', 'onsel', '2004-10-18');";
        stmt.execute(query);        
        setting.setDatabaseVersion("0.7.6");
        EngDALCommon.updateObject(setting);     
    }
    
    public static void PGupdateVersion075(TurqSetting setting)throws Exception
    {
        Session session = EngDALSessionFactory.getSession();
        Statement stmt = session.connection().createStatement();
      /*  String query="delete from turq_inventory_transactions where" +
			" (turq_inventory_transactions.engine_sequences_id not in" +
			" (Select cons.engine_sequences_id from turq_consignments cons)) " +
			" and (turq_inventory_transactions.engine_sequences_id not in" +
			" (Select billInEngine.engine_sequences_id from turq_bill_in_engine_sequences billInEngine))";
       */
        String query = "INSERT INTO turq_module_components VALUES (101, 7, 'com.turquaz.bill.ui.BillUIAddReturnBuyBill', 'Alistan Iade Faturasi', 'onsel', '2004-10-18', 'onsel', '2004-10-18');"+
        "INSERT INTO turq_module_components VALUES (102, 7, 'com.turquaz.bill.ui.BillUIAddReturnSellBill', 'Satistan Iade Faturasi', 'onsel', '2004-10-18', 'onsel', '2004-10-18');";
        stmt.execute(query);        
        setting.setDatabaseVersion("0.7.6");
        EngDALCommon.updateObject(setting);     
    }
}
