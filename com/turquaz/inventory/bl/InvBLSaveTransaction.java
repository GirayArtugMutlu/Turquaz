/*
 * Created on Mar 19, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.inventory.bl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.dal.TurqInventoryTransactionType;
import com.turquaz.engine.dal.TurqInventoryUnit;
import com.turquaz.engine.dal.TurqInventoryWarehous;
import com.turquaz.engine.dal.TurqModule;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class InvBLSaveTransaction
{
	public void saveOtherInventoryTransaction(TurqInventoryCard invCard, TurqInventoryUnit invUnit, TurqInventoryWarehous warehous, String docNo, Date transDate, String definition,BigDecimal amountIn, BigDecimal amountOut)throws Exception
	{
		Calendar cal = Calendar.getInstance();
		TurqInventoryTransaction invTrans = new TurqInventoryTransaction();
		
		TurqInventoryTransactionType transType = new TurqInventoryTransactionType();
		transType.setId(new Integer(EngBLCommon.INV_TRANS_OTHER));
		
		invTrans.setTurqInventoryTransactionType(transType);
		invTrans.setTurqInventoryCard(invCard);
		invTrans.setTurqInventoryWarehous(warehous);
		invTrans.setTurqInventoryUnit(invUnit);

		TurqEngineSequence seq = new TurqEngineSequence();
		TurqModule module = new TurqModule();
		module.setId(new Integer(EngBLCommon.MODULE_INVENTORY));
		seq.setTurqModule(module);
		EngDALCommon.saveObject(seq);
		
		invTrans.setTurqEngineSequence(seq);
		invTrans.setTransactionsDate(transDate);
		invTrans.setDefinition(definition);
		invTrans.setDocumentNo(docNo);
		invTrans.setTransactionsAmountIn(amountIn);
		invTrans.setTransactionsTotalAmountOut(amountOut);
		
		invTrans.setTransactionsTotalPrice(new BigDecimal(0));
		invTrans.setTransactionsDiscountAmount(new BigDecimal(0));
		invTrans.setTransactionsDiscount(new BigDecimal(0));
		invTrans.setTransactionsCumilativePrice(new BigDecimal(0));
		invTrans.setTransactionsUnitPrice(new BigDecimal(0));
		invTrans.setTransactionsVat(0);
		invTrans.setTransactionsVatAmount(new BigDecimal(0));
		invTrans.setTransactionsVatSpecial(new BigDecimal(0));
		invTrans.setTransactionsVatSpecialAmount(new BigDecimal(0));
		invTrans.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
		invTrans.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
		invTrans.setLastModified(new java.sql.Date(cal.getTime().getTime()));
		invTrans.setCreationDate(new java.sql.Date(cal.getTime().getTime()));	
		
		EngDALCommon.saveObject(invTrans);
	}
	
	
}
