/*
 * Created on Oct 11, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.inventory.bl;

import java.util.Calendar;
import java.util.List;

import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.inventory.dal.InvDALCardAdd;
import com.turquaz.inventory.dal.InvDALCardSearch;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class InvBLCardSearch {
	private InvDALCardSearch cardSearch;

	Calendar cal = Calendar.getInstance();

	public InvBLCardSearch() {

		cardSearch = new InvDALCardSearch();

	}
	public List searchCards(String cardName, String cardCode, TurqInventoryGroup group)throws Exception{
		try{
		
			return cardSearch.searchInventoryCards(cardName,cardCode,group);
		}
		
		catch(Exception ex){
			throw ex;
		}
	}
	
	
	
	

}
