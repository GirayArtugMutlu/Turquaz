
package com.turquaz.admin.bl;

import java.util.Calendar;

import com.turquaz.admin.dal.AdmDALCompanyInfo;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqCompany;


public class AdmBLCompanyInfo {
AdmDALCompanyInfo dalAdmin = new AdmDALCompanyInfo();
Calendar cal = Calendar.getInstance();
    public TurqCompany getCompany()throws Exception{
        try
        {
            return dalAdmin.getCompany();
        }
        catch(Exception ex){
            throw ex;
        }
        
    }
    public void updateCompany(TurqCompany company, String name, String adres, String phone, String fax)throws Exception{
        try{
            company.setCompanyAddress(adres);
            company.setCompanyName(name);
            company.setCompanyFax(fax);
            company.setCompanyTelephone(phone);
            

			company.setUpdateDate(cal.getTime());
			company.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			
           EngDALCommon.updateObject(company);
            
            
            
            
        }
        catch(Exception ex){
           throw ex;
        }
        
    }
    
}

