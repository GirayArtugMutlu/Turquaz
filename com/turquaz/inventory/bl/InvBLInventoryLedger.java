package com.turquaz.inventory.bl;

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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import com.turquaz.engine.EngKeys;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.dal.InvDALInventoryLedger;

/**
 * @author onsel
 * @version Id: $$
 */
public class InvBLInventoryLedger
{
	public static List getInventoryLedger(HashMap argMap) throws Exception
	{
		try
		{	
			Date date=(Date)argMap.get(EngKeys.DATE);
			String invCode=(String)argMap.get(InvKeys.INV_CARD_CODE);
			return InvDALInventoryLedger.getInventoryLedger(date, invCode);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}