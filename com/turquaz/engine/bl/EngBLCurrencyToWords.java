
package com.turquaz.engine.bl;

import java.math.BigDecimal;

import com.turquaz.engine.Messages;

public class EngBLCurrencyToWords {


    private static final String[] majorNames = {
            "", //$NON-NLS-1$
            Messages.getString("EngBLCurrencyToWords.1"), //$NON-NLS-1$
            Messages.getString("EngBLCurrencyToWords.2"), //$NON-NLS-1$
            Messages.getString("EngBLCurrencyToWords.3"), //$NON-NLS-1$
            Messages.getString("EngBLCurrencyToWords.4"), //$NON-NLS-1$
            Messages.getString("EngBLCurrencyToWords.5"), //$NON-NLS-1$
            Messages.getString("EngBLCurrencyToWords.6") //$NON-NLS-1$
            };

          private static final String[] tensNames = {
            "", //$NON-NLS-1$
            Messages.getString("EngBLCurrencyToWords.8"), //$NON-NLS-1$
            Messages.getString("EngBLCurrencyToWords.9"), //$NON-NLS-1$
            Messages.getString("EngBLCurrencyToWords.10"), //$NON-NLS-1$
            Messages.getString("EngBLCurrencyToWords.11"), //$NON-NLS-1$
            Messages.getString("EngBLCurrencyToWords.12"), //$NON-NLS-1$
            Messages.getString("EngBLCurrencyToWords.13"), //$NON-NLS-1$
            Messages.getString("EngBLCurrencyToWords.14"), //$NON-NLS-1$
            Messages.getString("EngBLCurrencyToWords.15"), //$NON-NLS-1$
            Messages.getString("EngBLCurrencyToWords.16") //$NON-NLS-1$
            };

          private static final String[] numNames = {
            "", //$NON-NLS-1$
            Messages.getString("EngBLCurrencyToWords.18"), //$NON-NLS-1$
            Messages.getString("EngBLCurrencyToWords.19"), //$NON-NLS-1$
            Messages.getString("EngBLCurrencyToWords.20"), //$NON-NLS-1$
            Messages.getString("EngBLCurrencyToWords.21"), //$NON-NLS-1$
            Messages.getString("EngBLCurrencyToWords.22"), //$NON-NLS-1$
            Messages.getString("EngBLCurrencyToWords.23"), //$NON-NLS-1$
            Messages.getString("EngBLCurrencyToWords.24"), //$NON-NLS-1$
            Messages.getString("EngBLCurrencyToWords.25"), //$NON-NLS-1$
            Messages.getString("EngBLCurrencyToWords.26"), //$NON-NLS-1$
            Messages.getString("EngBLCurrencyToWords.27") //$NON-NLS-1$
            };

        private static String convertLessThanOneThousand(int number) {
            String soFar;

            if (number % 100 < 10){
                soFar = numNames[number % 100];
                number /= 100;
               }
            else {
                soFar = numNames[number % 10];
                number /= 10;

                soFar = tensNames[number % 10] + soFar;
                number /= 10;
               }
            if (number == 0) return soFar;
            if(number == 1) return Messages.getString("EngBLCurrencyToWords.28")+soFar; //$NON-NLS-1$
            
            return numNames[number] + Messages.getString("EngBLCurrencyToWords.29") + soFar; //$NON-NLS-1$
        }

        private static String convert(int number) {
            /* special case */
            if (number == 0) { return Messages.getString("EngBLCurrencyToWords.30"); } //$NON-NLS-1$

            String prefix = ""; //$NON-NLS-1$

            if (number < 0) {
                number = -number;
                prefix = Messages.getString("EngBLCurrencyToWords.32"); //$NON-NLS-1$
              }

            String soFar = ""; //$NON-NLS-1$
            int place = 0;

            do {
              int n = number % 1000;
              if (n != 0){
                 String s = convertLessThanOneThousand(n);
                 if(s.equals(Messages.getString("EngBLCurrencyToWords.34"))&&place==1){ //$NON-NLS-1$
                     soFar = majorNames[place] + soFar;
                 }
                 else{
                     soFar = s + majorNames[place] + soFar; 
                 }
                
                }
              place++;
              number /= 1000;
              } while (number > 0);

            return (prefix + soFar).trim();
        }
    
    public static String getTurkishCarrencyInWords(BigDecimal bd){
        bd = bd.setScale(2,BigDecimal.ROUND_DOWN);
        String []nums = bd.toString().split("\\.");
      
        
        int YTL = Integer.parseInt(nums[0]) ;
        
        int YKRS = Integer.parseInt(nums[1]);
        
        String words = convert(YTL)+" YTL, "+convert(YKRS)+" YKr ";  
        
        return words;
        
    }

}
