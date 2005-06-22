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
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import com.turquaz.common.HashBag;
import com.turquaz.engine.EngKeys;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.dal.InvDALInventoryLedger;

/**
 * @author onsel
 * @version Id: $$
 */
public class InvBLInventoryLedger
{
	public static HashBag getInventoryLedger(HashMap argMap) throws Exception
	{
		try
		{	
			Date date=(Date)argMap.get(EngKeys.DATE);
			String invCode=(String)argMap.get(InvKeys.INV_CARD_CODE);
			List cards=InvDALInventoryLedger.getInventoryLedger(date, invCode);
			
			HashBag ledgerBag=new HashBag();
			ledgerBag.put(InvKeys.INV_CARDS,new HashMap());
			
			for(int k=0; k<cards.size(); k++)
			{
				Object[] cardInfo=(Object[])cards.get(k);
				String invCardCode=(String)cardInfo[0];
				String invCardName=(String)cardInfo[1];
				BigDecimal amountIn=(BigDecimal)cardInfo[2];
				BigDecimal priceIn=(BigDecimal)cardInfo[3];
				BigDecimal amountOut=(BigDecimal)cardInfo[4];
				
				ledgerBag.put(InvKeys.INV_CARDS,k,InvKeys.INV_CARD_CODE,invCardCode);
				ledgerBag.put(InvKeys.INV_CARDS,k,InvKeys.INV_CARD_NAME,invCardName);
				ledgerBag.put(InvKeys.INV_CARDS,k,InvKeys.INV_AMOUNT_IN,amountIn);
				ledgerBag.put(InvKeys.INV_CARDS,k,InvKeys.INV_PRICE_IN,priceIn);
				ledgerBag.put(InvKeys.INV_CARDS,k,InvKeys.INV_AMOUNT_OUT,amountOut);
				
				
			}
			
			return ledgerBag;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}