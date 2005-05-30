package com.turquaz.consignment.bl;

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
/** ********************************************************************* */
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import com.turquaz.consignment.ConsKeys;
import com.turquaz.consignment.dal.ConDALSearchConsignment;
import com.turquaz.current.CurKeys;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqViewInvPriceTotal;

public class ConBLSearchConsignment
{
	public static List searchConsignment(HashMap argMap) throws Exception
	{
		try
		{
			TurqCurrentCard curCard=(TurqCurrentCard)argMap.get(CurKeys.CUR_CARD);
			Date startDate=(Date)argMap.get(EngKeys.DATE_START);
			Date endDate=(Date)argMap.get(EngKeys.DATE_END);
			Integer type=(Integer)argMap.get(EngKeys.TYPE);
			String docNo=(String)argMap.get(EngKeys.DOCUMENT_NO);			
			return ConDALSearchConsignment.searchConsignments(curCard, startDate, endDate, type.intValue(), docNo);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static TurqViewInvPriceTotal getViewInvTotal(Integer engSeqId) throws Exception
	{
		try
		{
			return ConDALSearchConsignment.getViewInvTotal(engSeqId);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List chooseConsignment(HashMap argMap) throws Exception
	{
		try
		{
			TurqCurrentCard curCard=(TurqCurrentCard)argMap.get(CurKeys.CUR_CARD);
			Date startDate=(Date)argMap.get(EngKeys.DATE_START);
			Date endDate=(Date)argMap.get(EngKeys.DATE_END);	
			return ConDALSearchConsignment.chooseConsignments(curCard, startDate, endDate);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static List getConsignmentInfo(TurqConsignment cons) throws Exception
	{
		try
		{
			return ConDALSearchConsignment.getConsignmentInfo(cons);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqConsignment getConsignmentByConsId(Integer consId) throws Exception
	{
		try
		{
			return ConDALSearchConsignment.getConsignmentByConsId(consId);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static TurqConsignment getConsignmentByConsId(HashMap argMap) throws Exception
	{
		try
		{
			Integer consId=(Integer)argMap.get(ConsKeys.CONS_ID);
			return ConDALSearchConsignment.getConsignmentByConsId(consId);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
}