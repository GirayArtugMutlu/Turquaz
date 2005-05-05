package com.turquaz.engine.bl;

import java.math.BigDecimal;

import com.turquaz.engine.lang.EngLangCommonKeys;

public class EngBLCurrencyToWords
{
	private static final String[] majorNames = {"", //$NON-NLS-1$
			EngLangCommonKeys.STR_THOUSAND, 
            EngLangCommonKeys.STR_MILLION, 
            EngLangCommonKeys.STR_BILLION, 
            EngLangCommonKeys.STR_TRILLION, 
            EngLangCommonKeys.STR_KATRILLION, 
            EngLangCommonKeys.STR_QUINTILLION 
	};
	private static final String[] tensNames = {"", //$NON-NLS-1$
        EngLangCommonKeys.STR_TEN, 
        EngLangCommonKeys.STR_TWENTY, 
        EngLangCommonKeys.STR_THIRTY, 
        EngLangCommonKeys.STR_FORTY, 
        EngLangCommonKeys.STR_FIFTY, 
        EngLangCommonKeys.STR_SIXTY, 
        EngLangCommonKeys.STR_SEVENTY, 
        EngLangCommonKeys.STR_EIGHTY, 
        EngLangCommonKeys.STR_NINTY 
	};
	private static final String[] numNames = {"", //$NON-NLS-1$
        EngLangCommonKeys.STR_ONE, 
        EngLangCommonKeys.STR_TWO, 
        EngLangCommonKeys.STR_THREE, 
        EngLangCommonKeys.STR_FOUR, 
        EngLangCommonKeys.STR_FIVE, 
        EngLangCommonKeys.STR_SIX, 
        EngLangCommonKeys.STR_SEVEN, 
        EngLangCommonKeys.STR_EIGTH, 
        EngLangCommonKeys.STR_NINE, 
        EngLangCommonKeys.STR_TEN 
	};

	private static String convertLessThanOneThousand(int number)
	{
		String soFar;
		if (number % 100 < 10)
		{
			soFar = numNames[number % 100];
			number /= 100;
		}
		else
		{
			soFar = numNames[number % 10];
			number /= 10;
			soFar = tensNames[number % 10] + soFar;
			number /= 10;
		}
		if (number == 0)
			return soFar;
		if (number == 1)
			return EngLangCommonKeys.STR_HUNDRED+ soFar; 
		return numNames[number] + EngLangCommonKeys.STR_HUNDRED + soFar; 
	}

	private static String convert(int number)
	{
		/* special case */
		if (number == 0)
		{
			return EngLangCommonKeys.STR_ZERO;} 
		String prefix = ""; //$NON-NLS-1$
		if (number < 0)
		{
			number = -number;
			prefix = EngLangCommonKeys.STR_NEGATIVE; 
		}
		String soFar = ""; //$NON-NLS-1$
		int place = 0;
		do
		{
			int n = number % 1000;
			if (n != 0)
			{
				String s = convertLessThanOneThousand(n);
				if (s.equals(EngLangCommonKeys.STR_ONE) && place == 1) { 
					soFar = majorNames[place] + soFar;
				}
				else
				{
					soFar = s + majorNames[place] + soFar;
				}
			}
			place++;
			number /= 1000;
		}
		while (number > 0);
		return (prefix + soFar).trim();
	}

	public static String getTurkishCurrencyInWords(BigDecimal bd)
	{
		bd = bd.setScale(2, EngBLCommon.ROUNDING_METHOD);
		String[] nums = bd.toString().split("\\."); //$NON-NLS-1$
		int YTL = Integer.parseInt(nums[0]);
		int YKRS = Integer.parseInt(nums[1]);
		String words = (YKRS == 0) ? convert(YTL) + " YTL" : convert(YTL) + " YTL, " + convert(YKRS) + " YKr ";
		return words;
	}
}