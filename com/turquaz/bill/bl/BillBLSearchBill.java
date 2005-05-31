package com.turquaz.bill.bl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import com.turquaz.bill.BillKeys;
import com.turquaz.bill.dal.BillDALSearchBill;
import com.turquaz.bill.dal.BillDALUpdateBill;
import com.turquaz.current.CurKeys;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqViewBillTransTotal;

public class BillBLSearchBill
{
	public static List searchBill(HashMap argMap) throws Exception
	{
		try
		{
			Integer curCardId = (Integer)argMap.get(CurKeys.CUR_CARD_ID);
			TurqCurrentCard curCard=null;
			if(curCardId!=null)
			{
				curCard=(TurqCurrentCard)EngDALSessionFactory.getSession().load(TurqCurrentCard.class,curCardId);
			};
			String docNo=(String)argMap.get(EngKeys.DOCUMENT_NO);
			Date startDate=(Date)argMap.get(EngKeys.DATE_START);
			Date endDate=(Date)argMap.get(EngKeys.DATE_END);
			Integer type=(Integer)argMap.get(EngKeys.TYPE);
			
			return BillDALSearchBill.searchBill(curCard, docNo, startDate, endDate, type.intValue());
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static List getBillInfo(TurqBill bill) throws Exception
	{
		try
		{
			return BillDALSearchBill.getBillInfo(bill);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqBill initializeBillById(HashMap argMap) throws Exception
	{
		try
		{
			Integer billId=(Integer)argMap.get(BillKeys.BILL_ID);
			return BillDALSearchBill.initializeBillById(billId);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static TurqViewBillTransTotal getBillView(Integer billId) throws Exception
	{
		try
		{
			return BillDALSearchBill.getBillView(billId);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List searchBillAdvanced(HashMap argMap)
			throws Exception
	{
		try
		{
			TurqCurrentCard curCardStart=(TurqCurrentCard)argMap.get(EngKeys.CURRENT_CARD_START);
			TurqCurrentCard curCardEnd=(TurqCurrentCard)argMap.get(EngKeys.CURRENT_CARD_END);
			Date startDate=(Date)argMap.get(EngKeys.DATE_START);
			Date endDate=(Date)argMap.get(EngKeys.DATE_END);
			Date dueDateStart=(Date)argMap.get(EngKeys.DUE_DATE_START);
			Date dueDateEnd=(Date)argMap.get(EngKeys.DUE_DATE_END);
			BigDecimal minValue=(BigDecimal)argMap.get(EngKeys.MIN_VALUE);
			BigDecimal maxValue=(BigDecimal)argMap.get(EngKeys.MAX_VALUE);
			String docNoStart=(String)argMap.get(EngKeys.DOCUMENT_NO_START);
			String docNoEnd=(String)argMap.get(EngKeys.DOCUMENT_NO_END);
			Integer type=(Integer)argMap.get(EngKeys.TYPE);
			
			return BillDALSearchBill.searchBillAdvanced(curCardStart, curCardEnd, startDate, endDate, dueDateStart, dueDateEnd,
					minValue, maxValue, docNoStart, docNoEnd, type.intValue());
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static Boolean canUpdateBill(HashMap argMap) throws Exception
	{
		try
		{
			Integer billId=(Integer)argMap.get(BillKeys.BILL_ID);
			return BillDALUpdateBill.canUpdateBill(billId);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}