package com.turquaz.inventory.dal;

import java.util.Date;
import java.util.List;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqInventoryCard;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

public class InvDALProfitAnalysis
{
	public static List getInventoryTotalsAccordingToAvarage(TurqInventoryCard invCard, Date startDate, Date endDate) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "select invCard.cardInventoryCode,invCard.cardName, invTotal.totalAmountIn,"
					+ " invTotal.totalAmountOut, invTotal.totalPriceIn, invTotal.totalPriceOut from TurqInventoryCard as invCard, TurqViewInventoryTotal as invTotal"
					+ " where invCard.id = invTotal.inventoryCardsId" + " order by invCard.cardInventoryCode";
			Query q = session.createQuery(query);
			List list = q.list();
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}