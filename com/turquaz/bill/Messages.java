package com.turquaz.bill;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
    private static final String BUNDLE_NAME = "com.turquaz.bill.messages_tr_TR";//$NON-NLS-1$

    private Messages() {
    }

    public static String getString(String key) {
        // TODO Auto-generated method stub
        try {
        	final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
            .getBundle(BUNDLE_NAME);
        	
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
}