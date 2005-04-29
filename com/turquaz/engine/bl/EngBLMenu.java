
package com.turquaz.engine.bl;

import java.util.List;

import com.turquaz.engine.dal.EngDalMenuFactory;

public class EngBLMenu {

	
	public static List getAllMenu ()
	{
		List list = null;
		try {
		 list = EngDalMenuFactory.getAllMenu();
		
	}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return list;
	}
	
	
}
