package com.turquaz.admin.bl;

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
 * @author Onsel Armagan
 * @version $Id$
 */
import java.util.Iterator;
import java.util.List;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqUser;

public class AdmBLUsers
{
	public static List getUsers() throws Exception
	{
		try
		{
			return EngDALCommon.getUsers();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static void deleteUser(TurqUser user)throws Exception
	{
		deleteUserGroups(user);
		deleteUserPermissions(user);
		EngBLCommon.delete(user);
	}
	
	public static void deleteUserPermissions(TurqUser user)throws Exception
	{
		Iterator it=user.getTurqUserPermissions().iterator();
		while (it.hasNext())
		{
			EngBLCommon.delete(it.next());
		}
	}
	
	public static void deleteUserGroups(TurqUser user)throws Exception
	{
		Iterator it=user.getTurqUserGroups().iterator();
		while (it.hasNext())
		{
			EngBLCommon.delete(it.next());
		}
	}
}