package com.turquaz.current.bl;

import java.util.HashMap;
import java.util.Iterator;
import com.turquaz.accounting.dal.AccDALTransactionSearch;
import com.turquaz.current.CurKeys;
import com.turquaz.current.dal.CurDALCurrentCardUpdate;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqCurrentTransaction;
import com.turquaz.engine.dal.TurqEngineSequence;

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
public class CurBLTransactionUpdate
{
	public static void updateTrans(HashMap argMap) throws Exception
	{
		
		Object trans = argMap.get(CurKeys.CUR_TRANSACTION);
		
			EngDALCommon.updateObject(trans);
	
			
	}

	public static void deleteCurTrans(HashMap argMap) throws Exception
	{
		TurqCurrentTransaction curTrans = (TurqCurrentTransaction)argMap.get(CurKeys.CUR_TRANSACTION);
		Iterator it = curTrans.getTurqEngineSequence().getTurqAccountingTransactions().iterator();
		while (it.hasNext())
		{
			TurqAccountingTransaction accTrans = (TurqAccountingTransaction) it.next();
			AccDALTransactionSearch.deleteTransaction(accTrans);
		}
		EngDALCommon.deleteObject(curTrans);
		
	}
	public static void deleteTransfer(HashMap argMap)throws Exception
	 {
		
	  TurqEngineSequence seq	= (TurqEngineSequence)argMap.get(EngKeys.ENG_SEQ);
	  Iterator it = seq.getTurqCurrentTransactions().iterator();
	  while(it.hasNext())
	  {
	   EngDALCommon.deleteObject(it.next());
	  }
	  
	  
	 }

	public static void initCurTrans(HashMap argMap) throws Exception
	{
		
		TurqCurrentTransaction curTrans = (TurqCurrentTransaction)argMap.get(CurKeys.CUR_TRANSACTION);
		CurDALCurrentCardUpdate.initCurrentTrans(curTrans);
		
	}
}