package com.turquaz.engine.test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.ResultSet;

import com.turquaz.engine.dal.EngDALConnection;

public class DatabaseTransfer {

	public static void main(String[] args) {
		//	EngDALConnection conn1 = new
		// EngDALConnection("Postgresql","turquaz","","kulup.sabanciuniv.edu","turquaz_turkish_20041206");
		EngDALConnection conn2 = new EngDALConnection("Postgresql", "postgres",
				"", "kulup.sabanciuniv.edu", "turquaz");

		ResultSet first;
		try {

			conn2.connect();
			FileInputStream fstream = new FileInputStream("database/turquaz.script");
			// Convert our input stream to a
			// DataInputStream
			DataInputStream in = new DataInputStream(fstream);

			BufferedReader d = new BufferedReader(new InputStreamReader(in));
			String sql = "";
			String data;
			// Continue to read lines while
			// there are still some left to read

			// below parses the accounting plan and inserts to the database
			int counter = 15;
			while (in.available() != 0) {
			    try{
			      data = d.readLine();
			      if(data.startsWith("INSERT"))
			      conn2.execQuery(data);   
			    }
			    catch(Exception ex)
			    {
			        ex.printStackTrace();
			    }
			    
			    

			/*	data = d.readLine();
				System.out.println(data);
				String rest = "";
				int a = data.indexOf(",");
				String code = data.substring(0, a);
				code = code.trim();
				rest = data.substring(a + 1);

				a = rest.indexOf(",");
				String def = rest.substring(0, a);
				def = def.trim();
				rest = rest.substring(a + 1);

				a = rest.indexOf(",");
				String unit = rest.substring(0, a);
				unit = unit.trim();
				rest = rest.substring(a + 1);
				
				a = rest.indexOf(",");
				String vat = rest.substring(0, a);
				vat = vat.trim();
				rest = rest.substring(a + 1);
				
				String group = rest.trim();
			
				counter++;
				
				if (code =="" || def == "" || group == "")
				{
				
				System.out.println(code);
				System.out.println(def);
				System.out.println(group);
				}
				*/
				

					try {
						/*
						String query = "Select accounting_accounts_id from turq_accounting_accounts where account_code = '"
								+ accCode + "'";
						ResultSet parent = conn2.getResultSet(query);

						parent.next();
						String s_in = parent.getString(1);
						String address = address1 +"\n" + address2 + "\n" + address3;
						
						
						if (counter == 18)
						{*/
							
						//} 
/*
						query = "Select accounting_accounts_id from turq_accounting_accounts where account_code = '"
								+ outAcc + "'";
						parent = conn2.getResultSet(query);

						parent.next();
						String s_out = parent.getString(1);
						
						
						*/
						// kodu,ismi, aciklama, barkod, alis muh kodu, kdv orani, satis muhasebe kodu
						// indirim orani, asgari miktar, azami miktar, 
						/* String insert = "insert into g0_g0_g1_g0_t0 values( "
							+ counter
							+",'ayhan','2005/01/03/11/46/34',5, 'admin','None','"
							+code + "','"+def + "','','" 
							+ address
							+"','','','','turkey','"
							+vergi_daire 
							+"','"
							+vergi_no 
							+"',null,'item','','','','','',''" // adý adresi
							+",'','','','','','','ALICILAR',null,'tr_lira',null,'tr_lira',57,'None','None');";
						System.out.println(insert);
						
						counter ++;
						if (counter != 15)
						{
						//conn2.execQuery(insert);
						}
/*
						String insert = "insert into turq_current_cards values("
								+ counter
								+ ","
								+ "'"
								+ code
								+ "','"
								+ def
								+ "','','"+address+"',0,0,"
								+ credit
								+ ","
								+ risc
								+ ",'"
								+vergi_daire
								+"','"
								+vergi_no
								+"',"
								+s_in
								+ ",'admin','2004-12-05','admin','2004-12-05');";
								
							//conn2.execQuery(insert);
						/*
						String insertCard = "";
						if (unit.equals("AD") ) {
							 insertCard = "insert into turq_inventory_card_units values ("
								+counter
								+","
								+counter
								+",1,1,'admin','2004-12-05','admin','2004-12-05');";

						}
						else if (unit.equals("KG"))
								{
									
							 insertCard = "insert into turq_inventory_card_units values ("
								+counter
								+","
								+counter
								+",1,2,'admin','2004-12-05','admin','2004-12-05');";
								}
						else if (unit.equals("MT"))
						{
							 insertCard = "insert into turq_inventory_card_units values ("
								+counter
								+","
								+counter
								+",1,3,'admin','2004-12-05','admin','2004-12-05');";
						}
						else if (unit.equals("TK"))
						{
							 insertCard = "insert into turq_inventory_card_units values ("
								+counter
								+","
								+counter
								+",1,4,'admin','2004-12-05','admin','2004-12-05');";
						}
						else 
						{
							System.out.println(code);
						}*/
						
						//System.out.println(insert);
						//System.out.println(insertCard);
						//conn2.execQuery(insert);
						//conn2.execQuery(insertCard);

					} catch (Exception ex) {
						
						//System.out.println(code);
					//System.out.println(accCode);
						ex.printStackTrace();
					}
				
				/*
				 * System.out.println(inAcc); System.out.println(outAcc);
				 * 
				 *  // below for accounting accounts /* int a =
				 * data.indexOf(";"); String acc = data.substring(0, a); String
				 * definition = data.substring(a + 1); definition =
				 * definition.trim(); acc = acc.trim();
				 * 
				 * String firstAcc = acc; String secondAcc = ""; String thirdAcc =
				 * ""; String fourthAcc = "";
				 * 
				 * a = acc.indexOf(" "); if (a > 0) { firstAcc =
				 * acc.substring(0, a); acc = acc.substring(a); acc =
				 * acc.trim(); secondAcc = acc; }
				 * 
				 * a = acc.indexOf(" "); if (a > 0) { secondAcc =
				 * acc.substring(0, a); acc = acc.substring(a); acc =
				 * acc.trim(); thirdAcc = acc; }
				 * 
				 * a = acc.indexOf(" "); if (a > 0) { thirdAcc =
				 * acc.substring(0, a); acc = acc.substring(a); acc =
				 * acc.trim(); fourthAcc = acc; }
				 * 
				 * a = acc.indexOf(" "); if (a > 0) { fourthAcc =
				 * acc.substring(0, a); acc = acc.substring(a); acc =
				 * acc.trim(); } String query = ""; String s_parent = ""; String
				 * s_top = "";
				 * 
				 * 
				 * if (fourthAcc != "" ) {
				 * 
				 * 
				 * 
				 * query = "Select accounting_accounts_id from
				 * turq_accounting_accounts where account_code =
				 * '"+firstAcc+"'"; ResultSet parent =
				 * conn2.getResultSet(query);
				 * 
				 * parent.next(); s_parent = parent.getString(1);
				 * 
				 * query = "Select accounting_accounts_id from
				 * turq_accounting_accounts where account_code = '"+firstAcc+"
				 * "+secondAcc+" "+thirdAcc+"'"; parent =
				 * conn2.getResultSet(query);
				 * 
				 * parent.next(); s_top = parent.getString(1);
				 * 
				 * 
				 * String insert = "insert into turq_accounting_accounts
				 * values("+ counter+","+"'"+definition+"','"+firstAcc+"
				 * "+secondAcc+" "+thirdAcc+" "+fourthAcc+"',"+s_top+
				 * ","+s_parent+",'admin','2004-12-05','admin','2004-12-05');" ;
				 * counter ++; System.out.println(insert);
				 * 
				 * conn2.execQuery(insert);
				 *  } /* else if (thirdAcc != "") { String id = firstAcc +" "+
				 * secondAcc+" "+thirdAcc; query = "Select
				 * accounting_accounts_id from turq_accounting_accounts where
				 * account_code = '"+id+"'"; first = conn2.getResultSet(query);
				 * while(first.next()) { System.out.println(first.getString(1)); } }
				 * 
				 * 
				 * if (firstAcc != "") { String id = firstAcc ; query = "Select
				 * accounting_accounts_id from turq_accounting_accounts where
				 * account_code = '"+id+"'"; first = conn2.getResultSet(query);
				 * while(first.next()) { System.out.println(first.getString(1)); } }
				 * 
				 * System.out.println(firstAcc); System.out.println(secondAcc);
				 * System.out.println(thirdAcc); System.out.println(fourthAcc);
				 * System.out.println(definition);
				 */

			}

			/*
			 * 
			 * String query1 = "select * from turq_accounting_accounts order by
			 * accounting_accounts_id"; first = conn1.getResultSet(query1);
			 * first.next(); while(first.next()) { String query2 = "insert into
			 * turq_accounting_accounts values ("+first.getString(1)+", '"+
			 * first.getString(3) +" ','"+ first.getString(4) +"',"+
			 * first.getString(5)+ " ,"+first.getString(10) +",
			 * 'admin','2004-12-05' ,'admin', '2004-12-05' " + ")";
			 * System.out.println(query2);
			 * 
			 * conn2.execQuery(query2); }
			 *  
			 */
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}