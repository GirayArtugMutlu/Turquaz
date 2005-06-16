package com.turquaz.engine.bl;

import java.util.HashMap;
import java.util.Map;

import com.turquaz.common.HashBag;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.EngModulePrefs;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;

public class EngBLClient {

	public static Integer baseCurrencyId;
	
	public static Map getChequeStatusMapWithStringKey()
	{
		Map map = new HashMap();
		map.put(EngLangCommonKeys.CHEQUE_STATUS_PORTFOY_STRING, EngBLCommon.CHEQUE_STATUS_PORTFOY);
		map.put(EngLangCommonKeys.CHEQUE_STATUS_CURRENT_STRING, EngBLCommon.CHEQUE_STATUS_CURRENT);
		map.put(EngLangCommonKeys.CHEQUE_STATUS_COLLECTED_STRING, EngBLCommon.CHEQUE_STATUS_COLLECTED);
		map.put(EngLangCommonKeys.CHEQUE_STATUS_RETURN_TO_CURRENT_STRING, EngBLCommon.CHEQUE_STATUS_RETURN_TO_CURRENT);
		map.put(EngLangCommonKeys.CHEQUE_STATUS_IN_BANK_STRING, EngBLCommon.CHEQUE_STATUS_IN_BANK);
		map.put(EngLangCommonKeys.CHEQUE_STATUS_BOUNCED_STRING, EngBLCommon.CHEQUE_STATUS_BOUNCED);
		return map;
	}

	public static Map getChequeTransMapWithStringKey()
	{
		Map map = new HashMap();
		map.put(EngLangCommonKeys.CHEQUE_TRANS_IN_STRING, EngBLCommon.CHEQUE_TRANS_IN);
		map.put(EngLangCommonKeys.CHEQUE_TRANS_OUT_CURRENT_STRING, EngBLCommon.CHEQUE_TRANS_OUT_CURRENT);
		map.put(EngLangCommonKeys.CHEQUE_TRANS_OUT_BANK_STRING, EngBLCommon.CHEQUE_TRANS_OUT_BANK);
		map.put(EngLangCommonKeys.CHEQUE_TRANS_COLLECT_FROM_BANK_STRING, EngBLCommon.CHEQUE_TRANS_COLLECT_FROM_BANK);
		map.put(EngLangCommonKeys.CHEQUE_TRANS_COLLECT_FROM_CURRENT_STRING, EngBLCommon.CHEQUE_TRANS_COLLECT_FROM_CURRENT);
		map.put(EngLangCommonKeys.CHEQUE_TRANS_RETURN_FROM_BANK_TO_PORTFOY_STRING, EngBLCommon.CHEQUE_TRANS_RETURN_FROM_BANK_TO_PORTFOY);
		map.put(EngLangCommonKeys.CHEQUE_TRANS_RETURN_TO_CURRENT_STRING, EngBLCommon.CHEQUE_TRANS_RETURN_TO_CURRENT);
		map.put(EngLangCommonKeys.CHEQUE_TRANS_COLLECT_OF_OWN_CHEQUE_STRING,EngBLCommon.CHEQUE_TRANS_COLLECT_OF_OWN_CHEQUE);
		return map;
	}

	public static Map getChequeTransMapWithIntegerKey()
	{
		Map map = new HashMap();
		map.put(EngBLCommon.CHEQUE_TRANS_IN, EngLangCommonKeys.CHEQUE_TRANS_IN_STRING);
		map.put(EngBLCommon.CHEQUE_TRANS_OUT_CURRENT, EngLangCommonKeys.CHEQUE_TRANS_OUT_CURRENT_STRING);
		map.put(EngBLCommon.CHEQUE_TRANS_OUT_BANK, EngLangCommonKeys.CHEQUE_TRANS_OUT_BANK_STRING);
		map.put(EngBLCommon.CHEQUE_TRANS_COLLECT_FROM_BANK, EngLangCommonKeys.CHEQUE_TRANS_COLLECT_FROM_BANK_STRING);
		map.put(EngBLCommon.CHEQUE_TRANS_COLLECT_FROM_CURRENT, EngLangCommonKeys.CHEQUE_TRANS_COLLECT_FROM_CURRENT_STRING);
		map.put(EngBLCommon.CHEQUE_TRANS_RETURN_FROM_BANK_TO_PORTFOY, EngLangCommonKeys.CHEQUE_TRANS_RETURN_FROM_BANK_TO_PORTFOY_STRING);
		map.put(EngBLCommon.CHEQUE_TRANS_RETURN_TO_CURRENT, EngLangCommonKeys.CHEQUE_TRANS_RETURN_TO_CURRENT_STRING);
		map.put(EngBLCommon.CHEQUE_TRANS_COLLECT_OF_OWN_CHEQUE,EngLangCommonKeys.CHEQUE_TRANS_COLLECT_OF_OWN_CHEQUE_STRING);
		return map;
	}

	
	public static Integer getBaseCurrencyId()
	{
		try
		{
			if (baseCurrencyId == null)
			{
				HashBag bag = (HashBag)EngTXCommon.doSelectTX(EngBLServer.class.getName(),"getBaseCurrency",null); //$NON-NLS-1$
				baseCurrencyId = (Integer)bag.get(EngKeys.CURRENCY_ID);
			
			}
				return baseCurrencyId;
		}
		catch (Exception ex)
		{
	        EngBLLogger.log(EngBLCommon.class,ex);
			return null;
		}
	}

	

	public static Integer getBillCheckStatus()
	{
		String checkBill=EngModulePrefs.getProperty(EngBLCommon.BILL_CONFIG,EngBLCommon.BILL_CONFIG_CHECK_BILL_NO);
		if (checkBill != null)
		{
			boolean check=new Boolean(checkBill).booleanValue();
			if (check)
			{
				boolean checkBuy=false;
				boolean checkSell=false;
				String checkBuyBill=EngModulePrefs.getProperty(EngBLCommon.BILL_CONFIG,EngBLCommon.BILL_CONFIG_CHECK_BUY_BILL);
				if (checkBuyBill != null)
				{
					checkBuy=new Boolean(checkBuyBill).booleanValue();
				}		
				String checkSellBill=EngModulePrefs.getProperty(EngBLCommon.BILL_CONFIG,EngBLCommon.BILL_CONFIG_CHECK_SELL_BILL);
				if (checkSellBill != null)
				{
					checkSell=new Boolean(checkSellBill).booleanValue();
				}
				int result=0;
				if (checkBuy)
				{
					result |= EngBLCommon.CHECK_BUY_BILL;
				}
				if (checkSell)
				{
					result |= EngBLCommon.CHECK_SELL_BILL;
				}
				return new Integer(result);
			}	
		}
		return new Integer(0);	
	}

}
