/*
 * Created on Feb 28, 2005
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.admin.dal;

import java.util.List;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import com.turquaz.engine.dal.EngDALSessionFactory;

/**
 * This code was generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial
 * use. If Jigloo is being used commercially (ie, by a corporation,
 * company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details.
 * Use of Jigloo implies acceptance of these licensing terms.
 * *************************************
 * A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED
 * for this machine, so Jigloo or this code cannot be used legally
 * for any corporate or commercial purpose.
 * *************************************
 */
/**
 * @author Cem 
 */
public class AdmDALCurrencyExchangeRateAdd
{
	public static List getCurrencyExchangeRates() throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select exchangeRate.id," + " exchangeRate.exhangeRatesDate,"
					+ " exchangeRate.turqCurrencyByExchangeCurrencyId.currenciesAbbreviation," + " exchangeRate.exchangeRatio"
					+ " from TurqCurrencyExchangeRate as exchangeRate" + " order by exchangeRate.exhangeRatesDate";
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