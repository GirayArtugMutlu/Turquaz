/*
 * Created on Mar 19, 2005
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.inventory.bl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.dal.TurqInventoryTransactionType;
import com.turquaz.engine.dal.TurqInventoryUnit;
import com.turquaz.engine.dal.TurqInventoryWarehous;

/**
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class InvBLSaveTransaction
{
	public static void saveOtherInventoryTransaction(TurqInventoryCard invCard, TurqInventoryUnit invUnit, TurqInventoryWarehous warehous, String docNo, Date transDate, String definition,BigDecimal amountIn, BigDecimal amountOut)throws Exception
	{
		Calendar cal = Calendar.getInstance();
		TurqInventoryTransaction invTrans = new TurqInventoryTransaction();
		
		TurqInventoryTransactionType transType = new TurqInventoryTransactionType();
		transType.setId(new Integer(EngBLCommon.INV_TRANS_OTHER));
		
		invTrans.setTurqInventoryTransactionType(transType);
		invTrans.setTurqInventoryCard(invCard);
		invTrans.setTurqInventoryWarehous(warehous);
		invTrans.setTurqInventoryUnit(invUnit);

		TurqEngineSequence seq = EngBLCommon.saveEngineSequence(EngBLCommon.MODULE_INVENTORY);
		invTrans.setTurqEngineSequence(seq);
		invTrans.setTransactionsDate(transDate);
		invTrans.setDefinition(definition);
		invTrans.setDocumentNo(docNo);
		invTrans.setAmountIn(amountIn);
		invTrans.setAmountOut(amountOut);
		
		invTrans.setTotalPrice(new BigDecimal(0));
		invTrans.setTotalPriceInForeignCurrency(new BigDecimal(0));
		
		invTrans.setDiscountAmount(new BigDecimal(0));
		invTrans.setDiscountAmountInForeignCurrency(new BigDecimal(0));
		
		invTrans.setDiscountRate(new BigDecimal(0));
		invTrans.setCumilativePrice(new BigDecimal(0));
		invTrans.setCumilativePriceInForeignCurrency(new BigDecimal(0));
		invTrans.setUnitPrice(new BigDecimal(0));
		invTrans.setUnitPriceInForeignCurrency(new BigDecimal(0));
		invTrans.setVatRate(new BigDecimal(0));
		invTrans.setVatAmount(new BigDecimal(0));
		invTrans.setVatAmountInForeignCurrency(new BigDecimal(0));
		invTrans.setVatSpecialUnitPrice(new BigDecimal(0));
		invTrans.setVatSpecialUnitPriceInForeignCurrency(new BigDecimal(0));
		invTrans.setVatSpecialRate(new BigDecimal(0));
		invTrans.setVatSpecialAmount(new BigDecimal(0));
		invTrans.setVatSpecialAmountInForeignCurrency(new BigDecimal(0));
		invTrans.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
		invTrans.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
		invTrans.setLastModified(cal.getTime());
		invTrans.setCreationDate(cal.getTime());	
		
		EngDALCommon.saveObject(invTrans);
	}
	
	private static void registerInventoryTransaction(TurqInventoryTransaction invTrans,
			Integer engSeqId, int type, Date transDate, String definition,
			String docNo, TurqCurrencyExchangeRate exchangeRate) throws Exception
	{
		Calendar cal = Calendar.getInstance();
		TurqEngineSequence engSequence=new TurqEngineSequence();
		engSequence.setId(engSeqId);
		invTrans.setTurqEngineSequence(engSequence);
		invTrans.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
		invTrans.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
		invTrans.setLastModified(cal.getTime());
		invTrans.setCreationDate(cal.getTime());
		invTrans.setTransactionsDate(transDate);
		invTrans.setDefinition(definition);
		invTrans.setDocumentNo(docNo);
		
		BigDecimal unitPriceInBase=invTrans.getUnitPriceInForeignCurrency().multiply(exchangeRate.getExchangeRatio()).setScale(4,EngBLCommon.ROUNDING_METHOD);
		invTrans.setUnitPrice(unitPriceInBase);
		BigDecimal totalPriceInBase;
		BigDecimal amount;
		if (type == EngBLCommon.COMMON_BUY_INT)
		{
			invTrans.setAmountOut(new BigDecimal(0));
			amount=invTrans.getAmountIn();
			totalPriceInBase=unitPriceInBase.multiply(invTrans.getAmountIn()).setScale(2,EngBLCommon.ROUNDING_METHOD);		
		}
		else
		{
			invTrans.setAmountIn(new BigDecimal(0));
			amount=invTrans.getAmountOut();
			totalPriceInBase=unitPriceInBase.multiply(invTrans.getAmountOut()).setScale(2,EngBLCommon.ROUNDING_METHOD);
		}
		invTrans.setTotalPrice(totalPriceInBase);
		BigDecimal discountAmount=totalPriceInBase.multiply(invTrans.getDiscountRate()).divide(new BigDecimal(100),2,EngBLCommon.ROUNDING_METHOD);
		invTrans.setDiscountAmount(discountAmount);
		BigDecimal totalPriceAfterDiscount=totalPriceInBase.subtract(discountAmount);
		if (invTrans.getTurqInventoryCard().isSpecVatForEach())
		{
			BigDecimal vatSpecialUnitPriceInBase=invTrans.getVatSpecialUnitPriceInForeignCurrency().multiply(exchangeRate.getExchangeRatio()).setScale(2,EngBLCommon.ROUNDING_METHOD);
			invTrans.setVatSpecialUnitPrice(vatSpecialUnitPriceInBase);
			invTrans.setVatSpecialAmount(vatSpecialUnitPriceInBase.multiply(amount).setScale(2,EngBLCommon.ROUNDING_METHOD));				
		}
		else
		{
			invTrans.setVatSpecialUnitPrice(new BigDecimal(0));
			BigDecimal vatSpecialAmount=totalPriceAfterDiscount.multiply(invTrans.getVatSpecialRate()).divide(new BigDecimal(100),2,EngBLCommon.ROUNDING_METHOD);
			invTrans.setVatSpecialAmount(vatSpecialAmount);
		}	
		BigDecimal vatAmount=totalPriceAfterDiscount.multiply(invTrans.getVatRate()).divide(new BigDecimal(100),2,EngBLCommon.ROUNDING_METHOD);
		invTrans.setVatAmount(vatAmount);
		BigDecimal cumilativePrice=totalPriceAfterDiscount.add(vatAmount).add(invTrans.getVatSpecialAmount());
		invTrans.setCumilativePrice(cumilativePrice);
		invTrans.setTurqCurrencyExchangeRate(exchangeRate);
		EngDALCommon.saveObject(invTrans);
	}	
	
	public static void saveInventoryTransactions(List invTransactions,
			Integer engSeqId, int type, Date transDate, String definition,
			String docNo, TurqCurrencyExchangeRate exchangeRate) throws Exception
	{
		for(int k=0; k<invTransactions.size(); k++)
		{
			TurqInventoryTransaction invTrans=(TurqInventoryTransaction)invTransactions.get(k);
			registerInventoryTransaction(invTrans,engSeqId,type,transDate,definition,docNo,exchangeRate);
		}
	}
}
