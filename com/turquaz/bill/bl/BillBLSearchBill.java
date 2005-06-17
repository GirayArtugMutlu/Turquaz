package com.turquaz.bill.bl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.turquaz.admin.AdmKeys;
import com.turquaz.bill.BillKeys;
import com.turquaz.bill.dal.BillDALSearchBill;
import com.turquaz.bill.dal.BillDALUpdateBill;
import com.turquaz.common.HashBag;
import com.turquaz.current.CurKeys;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqViewBillTransTotal;

public class BillBLSearchBill
{
	public static HashBag searchBill(HashMap argMap) throws Exception
	{
		
			Integer curCardId = (Integer)argMap.get(CurKeys.CUR_CARD_ID);
			TurqCurrentCard curCard=null;
			
			String docNo=(String)argMap.get(EngKeys.DOCUMENT_NO);
			Date startDate=(Date)argMap.get(EngKeys.DATE_START);
			Date endDate=(Date)argMap.get(EngKeys.DATE_END);
			Integer type=(Integer)argMap.get(EngKeys.TYPE);			
			
			List list = BillDALSearchBill.searchBill(curCardId, docNo, startDate, endDate, type.intValue());
	
			HashBag billBag = new HashBag();
			billBag.put(BillKeys.BILLS,new HashMap());
			
			Iterator it = list.iterator();
			int i=0;
			while(it.hasNext())
			{
				Object[] billInfo =(Object[])it.next();
				
				billBag.put(BillKeys.BILLS,i,BillKeys.BILL_ID,billInfo[0]);
				billBag.put(BillKeys.BILLS,i,BillKeys.BILL_DATE,billInfo[1]);
				billBag.put(BillKeys.BILLS,i,BillKeys.BILL_DOC_NO,billInfo[2]);
				billBag.put(BillKeys.BILLS,i,CurKeys.CUR_CURRENT_CODE,billInfo[3]);
				billBag.put(BillKeys.BILLS,i,CurKeys.CUR_CURRENT_NAME,billInfo[4]);
				billBag.put(BillKeys.BILLS,i,BillKeys.BILL_TOTAL_AMOUNT,billInfo[5]);
				billBag.put(BillKeys.BILLS,i,BillKeys.BILL_TOTAL_VAT,billInfo[6]);
				billBag.put(BillKeys.BILLS,i,BillKeys.BILL_SPECIAL_VAT,billInfo[7]);
				billBag.put(BillKeys.BILLS,i,AdmKeys.ADM_CURRENCY_ABBR,billInfo[8]);
				billBag.put(BillKeys.BILLS,i,BillKeys.BILL_DISCOUNT_AMOUNT,billInfo[9]);
				
				
				i++;
				
			}			
			
		return billBag;
	}
	
	public static List getBillInfo(TurqBill bill) throws Exception
	{
		
			return BillDALSearchBill.getBillInfo(bill);
		
		
	}

	public static TurqBill initializeBillById(HashMap argMap) throws Exception
	{
		
			Integer billId=(Integer)argMap.get(BillKeys.BILL_ID);
			return BillDALSearchBill.initializeBillById(billId);
		
	}
	
	public static TurqViewBillTransTotal getBillView(Integer billId) throws Exception
	{
		
			return BillDALSearchBill.getBillView(billId);
		
		
	}

	public static HashBag searchBillAdvanced(HashMap argMap)
			throws Exception
	{
		
			Integer curCardStartId	= (Integer)argMap.get(EngKeys.CURRENT_CARD_START);
			Integer curCardEndId = (Integer)argMap.get(EngKeys.CURRENT_CARD_END);
			
			TurqCurrentCard curCardStart=null;
			TurqCurrentCard curCardEnd=null; 
			
			if(curCardStartId!=null)
			{
				 curCardStart =(TurqCurrentCard)EngDALSessionFactory.getSession().load(TurqCurrentCard.class,curCardStartId);
				
				
			}
			if(curCardEndId!=null)
			{
				curCardEnd =(TurqCurrentCard)EngDALSessionFactory.getSession().load(TurqCurrentCard.class,curCardEndId);
			}
			

			
			
			
			Date startDate=(Date)argMap.get(EngKeys.DATE_START);
			Date endDate=(Date)argMap.get(EngKeys.DATE_END);
			Date dueDateStart=(Date)argMap.get(EngKeys.DUE_DATE_START);
			Date dueDateEnd=(Date)argMap.get(EngKeys.DUE_DATE_END);
			BigDecimal minValue=(BigDecimal)argMap.get(EngKeys.MIN_VALUE);
			BigDecimal maxValue=(BigDecimal)argMap.get(EngKeys.MAX_VALUE);
			String docNoStart=(String)argMap.get(EngKeys.DOCUMENT_NO_START);
			String docNoEnd=(String)argMap.get(EngKeys.DOCUMENT_NO_END);
			Integer type=(Integer)argMap.get(EngKeys.TYPE);
			
			
			
			
			List list= BillDALSearchBill.searchBillAdvanced(curCardStart, curCardEnd, startDate, endDate, dueDateStart, dueDateEnd,
					minValue, maxValue, docNoStart, docNoEnd, type.intValue());
			
			HashBag billBag = new HashBag();
			billBag.put(BillKeys.BILLS,new HashMap());
			
			Iterator it = list.iterator();
			int i=0;
			while(it.hasNext())
			{
				Object[] billInfo =(Object[])it.next();
				
				billBag.put(BillKeys.BILLS,i,BillKeys.BILL_ID,billInfo[0]);
				billBag.put(BillKeys.BILLS,i,BillKeys.BILL_DATE,billInfo[1]);
				billBag.put(BillKeys.BILLS,i,BillKeys.BILL_DOC_NO,billInfo[2]);
				billBag.put(BillKeys.BILLS,i,CurKeys.CUR_CURRENT_CODE,billInfo[3]);
				billBag.put(BillKeys.BILLS,i,CurKeys.CUR_CURRENT_NAME,billInfo[4]);
				billBag.put(BillKeys.BILLS,i,BillKeys.BILL_TOTAL_AMOUNT,billInfo[5]);
				billBag.put(BillKeys.BILLS,i,BillKeys.BILL_TOTAL_VAT,billInfo[6]);
				billBag.put(BillKeys.BILLS,i,BillKeys.BILL_SPECIAL_VAT,billInfo[7]);
				billBag.put(BillKeys.BILLS,i,AdmKeys.ADM_CURRENCY_ABBR,billInfo[8]);
				
				
				i++;
				
			}
			return billBag;
	
	}

	public static HashBag canUpdateBill(HashMap argMap) throws Exception
	{
		
			Integer billId=(Integer)argMap.get(BillKeys.BILL_ID);
			HashBag result =new HashBag();
			result.put(BillKeys.BILL_CAN_UPDATE,BillDALUpdateBill.canUpdateBill(billId));
			return result;
		
	}
}