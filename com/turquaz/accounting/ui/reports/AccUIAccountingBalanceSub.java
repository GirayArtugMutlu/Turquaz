/*
 * Created on 25.Kas.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.accounting.ui.reports;

import java.util.HashMap;
import java.util.List;



import com.turquaz.accounting.dal.AccDALAccountingBalanceSub;



/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* *************************************
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED
* for this machine, so Jigloo or this code cannot be used legally
* for any corporate or commercial purpose.
* *************************************
*/
/**
 * @author Ceday
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AccUIAccountingBalanceSub {
	
	public AccUIAccountingBalanceSub()
	{
		
	}
	
	public static void PrepareHashMap() throws Exception
	{
		AccDALAccountingBalanceSub balance=new AccDALAccountingBalanceSub();
		//List transList=balance.getTransactionColumns();
		List accList=balance.getAccounts();
		HashMap accounts=new HashMap();
		for(int k=0; k<accList.size(); k++)
		{
			/*TurqAccountingAccount acc=(TurqAccountingAccount)accList.get(k);
			acc.get
			accounts.put();*/
		}
		
		
		
	}

}
