/*
 * Created on 16.Eki.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.bl;

import java.util.List;

import com.turquaz.engine.dal.EngDALCommon;

/**
 * @author Ceday
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EngBLCommon {
	public EngBLCommon()
	{
		
	}
	private EngDALCommon cardAdd=new EngDALCommon();
	
	public List getCurrencies() throws Exception {
		try {

			return cardAdd.getCurrencies();

		} catch (Exception ex) {
			throw ex;
		}

	}

}