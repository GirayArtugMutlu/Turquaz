
package com.turquaz.bank.bl;

import java.util.Date;
import java.util.List;

import com.turquaz.bank.dal.BankDALCommon;
import com.turquaz.engine.dal.TurqBanksCard;

public class BankBLTransactionSearch {
    public static List searchtransaction(TurqBanksCard bankCard, String docNo, Date startDate, Date endDate)throws Exception{
        try{
            return BankDALCommon.searchBankTransactions(bankCard,docNo,startDate, endDate);
            
        }
        catch(Exception ex)
        {
            throw ex;
        }
    }

}
