/*
 * Created on Sep 27, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.inventory.bl;

import java.util.List;

import com.turquaz.inventory.dal.InvDALCardAdd;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class InvBLCardAdd {
	
	private InvDALCardAdd cardAdd;
	public InvBLCardAdd(){
	
		cardAdd = new InvDALCardAdd();
		
	}
	public List getInventoryGroups()throws Exception{
	
		try{
			
			return cardAdd.getInventoryGroups();
			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
	public List getInventoryUnits()throws Exception{
		
			try{
				
				return cardAdd.getInventoryUnits();
				
			}
			catch(Exception ex){
				throw ex;
			}
			
		}
	public List getCurrencies()throws Exception{
		try{
			
			return cardAdd.getCurrencies();
			
		}
		catch(Exception ex){
			throw ex;
		}
		
		
	}

}
