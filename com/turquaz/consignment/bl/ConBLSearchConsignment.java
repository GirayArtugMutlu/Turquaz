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

import com.turquaz.common.HashBag;
import com.turquaz.consignment.ConsKeys;
import com.turquaz.consignment.dal.ConDALSearchConsignment;
import com.turquaz.current.CurKeys;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqViewInvPriceTotal;

public class ConBLSearchConsignment
{
	public static HashBag searchConsignment(HashMap argMap) throws Exception
	{
		try
		{
			Integer curCardId = (Integer)argMap.get(CurKeys.CUR_CARD_ID);
			TurqCurrentCard curCard=null;
			if(curCardId!=null)
			{
				curCard=(TurqCurrentCard)EngDALSessionFactory.getSession().load(TurqCurrentCard.class,curCardId);
			};
			
			Date startDate=(Date)argMap.get(EngKeys.DATE_START);
			Date endDate=(Date)argMap.get(EngKeys.DATE_END);
			Integer type=(Integer)argMap.get(EngKeys.TYPE);
			String docNo=(String)argMap.get(EngKeys.DOCUMENT_NO);			
		
			List list= ConDALSearchConsignment.searchConsignments(curCard, startDate, endDate, type.intValue(), docNo);
		    HashBag returnBag = new HashBag();
			returnBag.put(ConsKeys.CONS,new HashMap());
			
			for(int i=0;i<list.size();i++)
			{
				Object[]data = (Object[])list.get(i);
				returnBag.put(ConsKeys.CONS,i,ConsKeys.CONS_ID,data[0]);
				returnBag.put(ConsKeys.CONS,i,ConsKeys.CONS_DATE,data[1]);
				returnBag.put(ConsKeys.CONS,i,CurKeys.CUR_CURRENT_CODE,data[2]);
				returnBag.put(ConsKeys.CONS,i,CurKeys.CUR_CURRENT_NAME,data[3]);
				returnBag.put(ConsKeys.CONS,i,ConsKeys.CONS_DOC_NO,data[4]);
				returnBag.put(ConsKeys.CONS,i,ConsKeys.CONS_TOTAL_AMOUNT,data[5]);
				returnBag.put(ConsKeys.CONS,i,ConsKeys.CONS_VAT_AMOUNT,data[6]);
				returnBag.put(ConsKeys.CONS,i,ConsKeys.CONS_SPEC_VAT_AMOUNT,data[7]);			
			}
			return returnBag;
			
		
		
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

	public static HashBag chooseConsignment(HashMap argMap) throws Exception
	{
		try
		{
			Integer curCardId = (Integer)argMap.get(CurKeys.CUR_CARD_ID);
			TurqCurrentCard curCard=null;
			if(curCardId!=null)
			{
				curCard=(TurqCurrentCard)EngDALSessionFactory.getSession().load(TurqCurrentCard.class,curCardId);
			};
			Date startDate=(Date)argMap.get(EngKeys.DATE_START);
			Date endDate=(Date)argMap.get(EngKeys.DATE_END);	
			List list = ConDALSearchConsignment.chooseConsignments(curCard, startDate, endDate);
			 HashBag returnBag = new HashBag();
				returnBag.put(ConsKeys.CONS,new HashMap());
				
				for(int i=0;i<list.size();i++)
				{
					Object[]data = (Object[])list.get(i);
					returnBag.put(ConsKeys.CONS,i,ConsKeys.CONS_ID,data[0]);
					returnBag.put(ConsKeys.CONS,i,ConsKeys.CONS_DATE,data[1]);
					returnBag.put(ConsKeys.CONS,i,CurKeys.CUR_CURRENT_CODE,data[2]);
					returnBag.put(ConsKeys.CONS,i,CurKeys.CUR_CURRENT_NAME,data[3]);
					returnBag.put(ConsKeys.CONS,i,ConsKeys.CONS_DOC_NO,data[4]);
					returnBag.put(ConsKeys.CONS,i,ConsKeys.CONS_TOTAL_AMOUNT,data[5]);
					returnBag.put(ConsKeys.CONS,i,ConsKeys.CONS_VAT_AMOUNT,data[6]);
					returnBag.put(ConsKeys.CONS,i,ConsKeys.CONS_SPEC_VAT_AMOUNT,data[7]);
					returnBag.put(ConsKeys.CONS,i,ConsKeys.CONS_TYPE,data[8]);
				}
				return returnBag;
				
		
		
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