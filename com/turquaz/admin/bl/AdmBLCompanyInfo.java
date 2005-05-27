package com.turquaz.admin.bl;

import java.util.Calendar;
import java.util.HashMap;
import com.turquaz.admin.AdmKeys;
import com.turquaz.admin.dal.AdmDALCompanyInfo;
import com.turquaz.common.HashBag;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqCompany;

public class AdmBLCompanyInfo
{
	public static HashBag getCompany() throws Exception
	{
		try
		{
            TurqCompany company=AdmDALCompanyInfo.getCompany();
            HashBag retBag=new HashBag();
            
            retBag.put(AdmKeys.ADM_COMPANY_NAME,company.getCompanyName());
            retBag.put(AdmKeys.ADM_COMPANY_ADDRESS,company.getCompanyAddress());
            retBag.put(AdmKeys.ADM_COMPANY_FAX,company.getCompanyFax());
            retBag.put(AdmKeys.ADM_COMPANY_PHONE,company.getCompanyTelephone());
            retBag.put(AdmKeys.ADM_COMPANY_ID,company.getId());
            
            return retBag;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void updateCompany(HashMap argMap) throws Exception
	{
		try
		{
			Integer companyId=(Integer)argMap.get(AdmKeys.ADM_COMPANY_ID);
			String name=(String)argMap.get(AdmKeys.ADM_COMPANY_NAME);
			String address=(String)argMap.get(AdmKeys.ADM_COMPANY_ADDRESS);
			String phone=(String)argMap.get(AdmKeys.ADM_COMPANY_PHONE);
			String fax=(String)argMap.get(AdmKeys.ADM_COMPANY_FAX);
			
            TurqCompany company=(TurqCompany)EngDALSessionFactory.getSession().load(TurqCompany.class,companyId);
			Calendar cal = Calendar.getInstance();
			company.setCompanyAddress(address);
			company.setCompanyName(name);
			company.setCompanyFax(fax);
			company.setCompanyTelephone(phone);
			company.setUpdateDate(cal.getTime());
			company.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			EngDALCommon.updateObject(company);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}