/*
 * Created on 16.Eki.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.bl;

/************************************************************************/
/* TURQUAZ: Higly Modular Accounting/ERP Program                        */
/* ============================================                         */
/* Copyright (c) 2004 by Turquaz Software Development Group			    */
/*																		*/
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or    */
/* (at your option) any later version.       							*/
/* 																		*/
/* This program is distributed in the hope that it will be useful,		*/
/* but WITHOUT ANY WARRANTY; without even the implied warranty of		*/
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the		*/
/* GNU General Public License for more details.         				*/
/************************************************************************/

/**
* @author  Onsel Armagan
* @version  $Id$
*/
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
	private EngDALCommon engDALCom=new EngDALCommon();
	
	public List getCurrencies() throws Exception {
		try {

			return engDALCom.getCurrencies();

		} catch (Exception ex) {
			throw ex;
		}

	}
	
	public List getTurqCurrentGroups() throws Exception {
		try{
			return engDALCom.getTurqCurrentGroups();			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public boolean checkUserPass(String user, String pass)throws Exception{
		try{
			
			return engDALCom.checkUserPass(user,pass);
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public List getInventoryWarehouses()throws Exception{
		try{
			
			return engDALCom.getInventoryWarehouses();
		}
		catch(Exception ex){
			throw ex;
		}
	}

}
