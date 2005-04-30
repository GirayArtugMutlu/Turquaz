
package com.turquaz.engine.lang;

public class AccLangKeys {
	
	public final static String STR_ACCOUNT_CODE = "Hesap Kodu";
	public final static String STR_NEW_ACCOUNT  = "Yeni Hesap";
	public final static String STR_ACCOUNTING_PLAN  = "Muhasebe Planý";
	public final static String STR_ACCOUNT_NAME  = "Hesap Adý";
	public final static String STR_ACCOUNT_CLASS  = "Hesap Sýnýfý";
	public final static String STR_ACCOUNT_GROUP  = "Hesap Grubu";
	public final static String STR_BALANCE  = "Bakiye";
	public final static String STR_BALANCES  = "Bakiyeler";
	public final static String STR_BALANCE_DEBIT  = "Bakiye Borç";
	public final static String STR_DEBIT_RECEIVE  = "Alacak Borç"; 
	public final static String STR_DEBIT  = "Borç";
	public final static String STR_CREDIT  = "Alacak";
	public final static String STR_ADD_NEW_ACCOUNT  = "Yeni Hesap Ekle";
	public final static String STR_PARENT_ACCOUNT  = "Bir Üst Hesap";
	public final static String STR_VOUCHER_NO  = "Fiþ No";
	public final static String STR_VOUCHER_TYPE  = "Fiþ Tipi";
	public final static String STR_PRICE  = "Tutar";
	public final static String STR_DOCUMENT_NO  = "Belge Numarasý";
	public final static String STR_TOTAL_AMOUNT_YTL  = "Toplam Tutar (YTL)";
	public final static String STR_JOURNAL_DATE  = "Yevmiye Tarihi";
	public final static String STR_ADD_JOURNAL_ID  = "Muhasebeleþtir";
	
	public final static String MSG_NOT_DELETE_ACCOUNT_WITH_TRANSACTION  = "Üzerinde hareket bulunan bir hesabý silemezsiniz!";
	public final static String MSG_NOT_DELETE_ACCOUNT_WITH_SUBSIDIARY  = "Alt hesabý olan bir hesabý silemezsiniz!";
	public final static String MSG_PLEASE_FILL_ACCOUNT_CODE  = "Lütfen hesap kodu bölümünü doldurunuz!";
	public final static String MSG_NOT_ENTER_EXISTING_ACCOUNT_CODE  = "Daha önce var olan bir hesap kodu giremezsiniz!";
	public final static String MSG_PLEASE_ENTER_PARENT_ACCOUNT  = "Lütfen Ana Hesabý Giriniz!";
	public final static String MSG_ACCOUNT_CODE_SHOULD_START_WITH_PARENT_ACCOUNT  = "Hesap kodu üst hesap kodu ile baþlamak zorundadýr!";
	public final static String MSG_NOT_ENTER_SUBSIDIARY_ACCOUNT_PARENT_HAS_TRANSACTION  = "Daha önce hareket görmüþ bir hesaba alt hesap açamazsýnýz!";
	public final static String MSG_TOTAL_CREDIT_SHOULD_EQUAL_DEBIT  = "Toplam borç toplam alacaða eþit olmalý!";
	public final static String MSG_ENTER_AT_LEAST_ONE_ROW  = "En az bir satýr girmelisiniz!";
	public final static String MSG_ENTER_VOUCHER_DATE  = "Lütfen fiþ tarihini giriniz!";
	public final static String MSG_NOT_DELETE_VOUCHER_WITH_JOURNAL_ID  = "Muhasebeleþtirilen fiþler deðiþtirilemez veya silinemez.\nDevam etmek istediðinize emin misiniz?";

}
