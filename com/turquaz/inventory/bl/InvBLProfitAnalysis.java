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
/**
 * @author Onsel Armagan
 * @version $Id$
 */
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import com.turquaz.common.HashBag;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.dal.InvDALProfitAnalysis;

public class InvBLProfitAnalysis
{
	/**
	 * @param type
	 *             0 - Ortalama deger
	 * @return
	 */
	public static HashBag getTransactionTotals() throws Exception
	{
		try
		{
			List totals=InvDALProfitAnalysis.getInventoryTotalsAccordingToAvarage();
			HashBag totalBag=new HashBag();
			totalBag.put(InvKeys.INV_CARDS, new HashMap());
			
			for(int k=0; k<totals.size(); k++)
			{
				Object[] invCardInfo=(Object[]) totals.get(k);
				String invCode=(String)invCardInfo[0];
				String invName=(String)invCardInfo[1];
				BigDecimal amountIn=(BigDecimal)invCardInfo[2];
				BigDecimal amountOut=(BigDecimal)invCardInfo[3];
				BigDecimal priceIn=(BigDecimal)invCardInfo[4];
				BigDecimal priceOut=(BigDecimal)invCardInfo[5];
				
				totalBag.put(InvKeys.INV_CARDS,k,InvKeys.INV_CARD_CODE,invCode);
				totalBag.put(InvKeys.INV_CARDS,k,InvKeys.INV_CARD_NAME,invName);
				totalBag.put(InvKeys.INV_CARDS,k,InvKeys.INV_AMOUNT_IN,amountIn);
				totalBag.put(InvKeys.INV_CARDS,k,InvKeys.INV_AMOUNT_OUT,amountOut);
				totalBag.put(InvKeys.INV_CARDS,k,InvKeys.INV_PRICE_IN,priceIn);
				totalBag.put(InvKeys.INV_CARDS,k,InvKeys.INV_PRICE_OUT,priceOut);
				
			}
			
			return totalBag;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}