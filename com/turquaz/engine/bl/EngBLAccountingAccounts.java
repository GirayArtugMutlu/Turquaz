/*
 * Created on Oct 28, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.bl;

import java.util.HashMap;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EngBLAccountingAccounts {
	public HashMap accountMap;

	
	static EngBLAccountingAccounts _instance;
	
	public EngBLAccountingAccounts(){
		fillAccountMap();
	}
	
	public void fillAccountMap(){
		accountMap.clear();
	
	}
	

}
