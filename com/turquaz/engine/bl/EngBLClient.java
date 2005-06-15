package com.turquaz.engine.bl;

import java.util.HashMap;
import java.util.Map;

import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;

public class EngBLClient {

	private static TurqCurrency baseCurrency = null;
	private static TurqCurrencyExchangeRate baseCurrencyExchangeRate = null;

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

	public static TurqCurrency getBaseCurrency()
	{
		try
		{
			if (baseCurrency == null)
			{
				baseCurrency = (TurqCurrency)EngTXCommon.doSelectTX(EngDALCommon.class.getName(),"getBaseCurrency",null); //$NON-NLS-1$
			}
				return baseCurrency;
		}
		catch (Exception ex)
		{
	        EngBLLogger.log(EngBLCommon.class,ex);
			return null;
		}
	}

	public static Integer getBaseCurrencyId()
	{
		try
		{
			if (baseCurrency == null)
			{
				baseCurrency = (TurqCurrency)EngTXCommon.doSelectTX(EngDALCommon.class.getName(),"getBaseCurrency",null); //$NON-NLS-1$
			}
				return baseCurrency.getId();
		}
		catch (Exception ex)
		{
	        EngBLLogger.log(EngBLCommon.class,ex);
			return null;
		}
	}

	public static TurqCurrencyExchangeRate getBaseCurrencyExchangeRate() 
	{
		
			if (baseCurrencyExchangeRate == null){
				try
				{
					baseCurrencyExchangeRate = (TurqCurrencyExchangeRate)EngTXCommon.doSelectTX(EngDALCommon.class.getName(),"getBaseCurrencyExchangeRate",null); //$NON-NLS-1$
				}
				catch (Exception ex)
				{
	                EngBLLogger.log(EngBLCommon.class,ex);
				}
			}
					return baseCurrencyExchangeRate;
		
	}

}
