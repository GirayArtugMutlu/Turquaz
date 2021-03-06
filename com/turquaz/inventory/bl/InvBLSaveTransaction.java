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
import java.util.HashMap;
import java.util.List;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLServer;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.dal.TurqInventoryTransactionType;
import com.turquaz.engine.dal.TurqInventoryUnit;
import com.turquaz.engine.dal.TurqInventoryWarehous;
import com.turquaz.inventory.InvKeys;

/**
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class InvBLSaveTransaction
{
	public static void saveOtherInventoryTransaction(HashMap argMap) throws Exception
	{
		Integer invCardId=(Integer)argMap.get(InvKeys.INV_CARD_ID);
		Integer invUnitId=(Integer)argMap.get(InvKeys.INV_UNIT_ID);
		Integer warehouseId=(Integer)argMap.get(InvKeys.INV_WAREHOUSE_ID);
		String docNo=(String)argMap.get(EngKeys.DOCUMENT_NO);
		Date transDate=(Date)argMap.get(EngKeys.TRANS_DATE);
		String definition=(String)argMap.get(EngKeys.DEFINITION);
		BigDecimal amountIn=(BigDecimal)argMap.get(EngKeys.AMOUNT_IN);
		BigDecimal amountOut=(BigDecimal)argMap.get(EngKeys.AMOUNT_OUT);
		
		
		Calendar cal = Calendar.getInstance();
		TurqInventoryTransaction invTrans = new TurqInventoryTransaction();
		
		TurqInventoryTransactionType transType = new TurqInventoryTransactionType();
		transType.setId(new Integer(EngBLCommon.INV_TRANS_OTHER));
		invTrans.setTurqInventoryTransactionType(transType);
		
		TurqInventoryCard invCard=new TurqInventoryCard();
		invCard.setId(invCardId);
		invTrans.setTurqInventoryCard(invCard);
		
		
		TurqInventoryWarehous warehous=new TurqInventoryWarehous();
		warehous.setId(warehouseId);
		invTrans.setTurqInventoryWarehous(warehous);
		
		TurqInventoryUnit invUnit=new TurqInventoryUnit();
		invUnit.setId(invUnitId);
		invTrans.setTurqInventoryUnit(invUnit);
		
		TurqEngineSequence seq = EngBLServer.saveEngineSequence(EngBLCommon.MODULE_INVENTORY);
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
		invTrans.setCreatedBy(System.getProperty("user"));
		invTrans.setUpdatedBy(System.getProperty("user")); 
		invTrans.setLastModified(cal.getTime());
		invTrans.setCreationDate(cal.getTime());
		invTrans.setTurqCurrencyExchangeRate(EngDALCommon.getBaseCurrencyExchangeRate());
		TurqCurrentCard curCard = new TurqCurrentCard();
		curCard.setId(new Integer(-1));
		invTrans.setTurqCurrentCard(curCard);
		EngDALCommon.saveObject(invTrans);
	}

	private static void registerInventoryTransaction(TurqInventoryTransaction invTrans, Integer engSeqId, int type, Date transDate,
			String definition, String docNo, TurqCurrencyExchangeRate exchangeRate, TurqCurrentCard curCard) throws Exception
	{
		Calendar cal = Calendar.getInstance();
		TurqEngineSequence engSequence = new TurqEngineSequence();
		engSequence.setId(engSeqId);
		invTrans.setTurqEngineSequence(engSequence);
		invTrans.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
		invTrans.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
		invTrans.setLastModified(cal.getTime());
		invTrans.setCreationDate(cal.getTime());
		invTrans.setTransactionsDate(transDate);
		invTrans.setDefinition(definition);
		invTrans.setDocumentNo(docNo);
		invTrans.setTurqCurrentCard(curCard);
		BigDecimal unitPriceInBase = invTrans.getUnitPriceInForeignCurrency().multiply(exchangeRate.getExchangeRatio()).setScale(4,
				EngBLCommon.ROUNDING_METHOD);
		invTrans.setUnitPrice(unitPriceInBase);
		BigDecimal totalPriceInBase;
		BigDecimal amount;
		if (type == EngBLCommon.COMMON_BUY_INT ||type == EngBLCommon.COMMON_RETURN_SELL_INT )
		{
			invTrans.setAmountOut(new BigDecimal(0));
			amount = invTrans.getAmountIn();
			totalPriceInBase = unitPriceInBase.multiply(invTrans.getAmountIn()).setScale(2, EngBLCommon.ROUNDING_METHOD);
		}
		else
		{
			invTrans.setAmountIn(new BigDecimal(0));
			amount = invTrans.getAmountOut();
			totalPriceInBase = unitPriceInBase.multiply(invTrans.getAmountOut()).setScale(2, EngBLCommon.ROUNDING_METHOD);
		}
		invTrans.setTotalPrice(totalPriceInBase);
		BigDecimal discountAmount = totalPriceInBase.multiply(invTrans.getDiscountRate()).divide(new BigDecimal(100), 2,
				EngBLCommon.ROUNDING_METHOD);
		invTrans.setDiscountAmount(discountAmount);
		BigDecimal totalPriceAfterDiscount = totalPriceInBase.subtract(discountAmount);
        BigDecimal vatSpecialAmount = new BigDecimal(0);
        if (invTrans.getTurqInventoryCard().isSpecVatForEach())
		{
			BigDecimal vatSpecialUnitPriceInBase = invTrans.getVatSpecialUnitPriceInForeignCurrency().multiply(
					exchangeRate.getExchangeRatio()).setScale(2, EngBLCommon.ROUNDING_METHOD);
			invTrans.setVatSpecialUnitPrice(vatSpecialUnitPriceInBase);
            vatSpecialAmount = vatSpecialUnitPriceInBase.multiply(amount).setScale(2, EngBLCommon.ROUNDING_METHOD);
            invTrans.setVatSpecialAmount(vatSpecialAmount);
		}
		else
		{
			invTrans.setVatSpecialUnitPrice(new BigDecimal(0));
			vatSpecialAmount = totalPriceAfterDiscount.multiply(invTrans.getVatSpecialRate()).divide(new BigDecimal(100), 2,
					EngBLCommon.ROUNDING_METHOD);
			invTrans.setVatSpecialAmount(vatSpecialAmount);
		}
		BigDecimal vatAmount = totalPriceAfterDiscount.add(vatSpecialAmount).multiply(invTrans.getVatRate()).divide(new BigDecimal(100), 2,
				EngBLCommon.ROUNDING_METHOD);
		invTrans.setVatAmount(vatAmount);
		BigDecimal cumilativePrice = totalPriceAfterDiscount.add(vatAmount).add(invTrans.getVatSpecialAmount());
		invTrans.setCumilativePrice(cumilativePrice);
		invTrans.setTurqCurrencyExchangeRate(exchangeRate);
		EngDALCommon.saveObject(invTrans);
	}

	public static void saveInventoryTransactions(List invTransactions, Integer engSeqId, int type, Date transDate, String definition,
			String docNo, TurqCurrencyExchangeRate exchangeRate, TurqCurrentCard curCard) throws Exception
	{
		for (int k = 0; k < invTransactions.size(); k++)
		{
			HashMap invTransInfo = (HashMap) invTransactions.get(k);
			
			TurqInventoryTransaction invTrans = new TurqInventoryTransaction();
			invTrans.setAmountIn((BigDecimal)invTransInfo.get(InvKeys.INV_AMOUNT_IN));
			invTrans.setAmountOut((BigDecimal)invTransInfo.get(InvKeys.INV_AMOUNT_OUT));
			invTrans.setUnitPriceInForeignCurrency((BigDecimal)invTransInfo.get(InvKeys.INV_UNIT_PRICE_IN_FOREIGN_CURRENCY));
			invTrans.setTotalPriceInForeignCurrency((BigDecimal)invTransInfo.get(InvKeys.INV_TOTAL_PRICE_IN_FOREIGN_CURRENCY));
			invTrans.setVatRate((BigDecimal)invTransInfo.get(InvKeys.INV_VAT_RATE));
			invTrans.setVatAmountInForeignCurrency((BigDecimal)invTransInfo.get(InvKeys.INV_VAT_AMOUNT_IN_FOREIGN_CURRENCY));
			invTrans.setVatSpecialRate((BigDecimal)invTransInfo.get(InvKeys.INV_VAT_SPECIAL_RATE));
			invTrans.setVatSpecialAmountInForeignCurrency((BigDecimal)invTransInfo.get(InvKeys.INV_VAT_SPECIAL_AMOUNT_IN_FOREIGN_CURRENCY));
			invTrans.setVatSpecialUnitPriceInForeignCurrency((BigDecimal)invTransInfo.get(InvKeys.INV_VAT_SPECIAL_UNIT_PRICE_IN_FOREIGN_CURRENCY));
			invTrans.setCumilativePriceInForeignCurrency((BigDecimal)invTransInfo.get(InvKeys.INV_CUMILATIVE_PRICE_IN_FOREIGN_CURRENCY));
			invTrans.setDiscountRate((BigDecimal)invTransInfo.get(InvKeys.INV_DISCOUNT_RATE));
			invTrans.setDiscountAmountInForeignCurrency((BigDecimal)invTransInfo.get(InvKeys.INV_DISCOUNT_AMOUNT_IN_FOREIGN_CURRENCY));
			
			Integer transTypeId =(Integer)invTransInfo.get(InvKeys.INV_TRANS_TYPE_ID);
			TurqInventoryTransactionType transType =new TurqInventoryTransactionType();
			transType.setId(transTypeId);
			invTrans.setTurqInventoryTransactionType(transType);
			
			Integer whId =(Integer)invTransInfo.get(InvKeys.INV_WAREHOUSE_ID);
			TurqInventoryWarehous warehouse =new TurqInventoryWarehous();
			warehouse.setId(whId);			
			invTrans.setTurqInventoryWarehous(warehouse);
			
			HashMap invCardMap = (HashMap)invTransInfo.get(InvKeys.INV_CARD);
			Integer invCardId = (Integer)invCardMap.get(InvKeys.INV_CARD_ID);
			
			TurqInventoryCard invCard = (TurqInventoryCard)EngDALSessionFactory.getSession().load(TurqInventoryCard.class,invCardId);
		   invTrans.setTurqInventoryCard(invCard);
			
			
			
			registerInventoryTransaction(invTrans, engSeqId, type, transDate, definition, docNo, exchangeRate, curCard);
		}
	}
}