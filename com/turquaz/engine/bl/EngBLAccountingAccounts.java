/*
 * Created on Oct 28, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.bl;


import java.util.List;


import com.turquaz.accounting.bl.AccBLAccountAdd;


/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EngBLAccountingAccounts {
	public List accountList;

	
	static EngBLAccountingAccounts _instance;
	
	private AccBLAccountAdd blAccount = new AccBLAccountAdd();
	
	public EngBLAccountingAccounts()throws Exception{
		try{
		fillAccountList();
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public void fillAccountList()throws Exception{
		try{
		 accountList = blAccount.getAllAccounts();
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public static synchronized List getAccounts() throws Exception{
		try{
		if (_instance == null) {
              
			_instance = new EngBLAccountingAccounts();

		}

		return _instance.accountList;
		}
		catch(Exception ex){
			throw ex;
		}

	}
	


}
