package com.turquaz.admin.bl;

import java.util.Calendar;
import java.util.HashMap;
import com.turquaz.admin.AdmKeys;
import com.turquaz.admin.dal.AdmDALCompanyInfo;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqCompany;

public class AdmBLCompanyInfo
{
	public static TurqCompany getCompany() throws Exception
	{
		try
		{
			return AdmDALCompanyInfo.getCompany();
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
			TurqCompany company=(TurqCompany)argMap.get(AdmKeys.ADM_COMPANY);
			String name=(String)argMap.get(AdmKeys.ADM_COMPANY_NAME);
			String address=(String)argMap.get(AdmKeys.ADM_COMPANY_ADDRESS);
			String phone=(String)argMap.get(AdmKeys.ADM_COMPANY_PHONE);
			String fax=(String)argMap.get(AdmKeys.ADM_COMPANY_FAX);
			
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