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
 * @author onsel
 * @version $Id$
 */
package com.turquaz.inventory.bl;

import java.math.BigDecimal;
import java.util.HashMap;
import net.sf.hibernate.Session;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.inventory.InvKeys;

public class InvBLUpdateTransaction
{
	public static void updateInitialTransaction(HashMap argMap) throws Exception
	{
		HashMap transMap=(HashMap)argMap.get(InvKeys.INV_TRANS);
		Integer transId=(Integer)transMap.get(InvKeys.INV_TRANS_ID);
		
		Session session=EngDALSessionFactory.getSession();
		TurqInventoryTransaction invTrans=(TurqInventoryTransaction)session.load(TurqInventoryTransaction.class,transId);

		BigDecimal amountIn=(BigDecimal)transMap.get(InvKeys.INV_AMOUNT_IN);
		BigDecimal totalPriceInFC=(BigDecimal)transMap.get(InvKeys.INV_TOTAL_PRICE_IN_FOREIGN_CURRENCY);
		
		invTrans.setAmountIn(amountIn);
		invTrans.setTotalPriceInForeignCurrency(totalPriceInFC);
		EngDALCommon.updateObject(invTrans);		
	}
}