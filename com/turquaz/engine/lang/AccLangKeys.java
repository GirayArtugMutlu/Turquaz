
package com.turquaz.engine.lang;

public class AccLangKeys {
	
	public final static String STR_ACCOUNT_CODE = "Hesap Kodu";
	public final static String STR_NEW_ACCOUNT  = "Yeni Hesap";
	public final static String STR_ACCOUNTING_PLAN  = "Muhasebe Plan�";
	public final static String STR_ACCOUNT_NAME  = "Hesap Ad�";
	public final static String STR_ACCOUNT_CLASS  = "Hesap S�n�f�";
	public final static String STR_ACCOUNT_GROUP  = "Hesap Grubu";
	public final static String STR_BALANCE  = "Bakiye";
	public final static String STR_BALANCES  = "Bakiyeler";
	public final static String STR_BALANCE_DEBIT  = "Bakiye Bor�";
	public final static String STR_DEBIT_RECEIVE  = "Alacak Bor�"; 
	public final static String STR_DEBIT  = "Bor�";
	public final static String STR_CREDIT  = "Alacak";
	public final static String STR_ADD_NEW_ACCOUNT  = "Yeni Hesap Ekle";
	public final static String STR_PARENT_ACCOUNT  = "Bir �st Hesap";
	public final static String STR_VOUCHER_NO  = "Fi� No";
	public final static String STR_VOUCHER_TYPE  = "Fi� Tipi";
	public final static String STR_PRICE  = "Tutar";
	public final static String STR_DOCUMENT_NO  = "Belge Numaras�";
	public final static String STR_TOTAL_AMOUNT_YTL  = "Toplam Tutar (YTL)";
	public final static String STR_JOURNAL_DATE  = "Yevmiye Tarihi";
	public final static String STR_ADD_JOURNAL_ID  = "Muhasebele�tir";
	
	public final static String MSG_NOT_DELETE_ACCOUNT_WITH_TRANSACTION  = "�zerinde hareket bulunan bir hesab� silemezsiniz!";
	public final static String MSG_NOT_DELETE_ACCOUNT_WITH_SUBSIDIARY  = "Alt hesab� olan bir hesab� silemezsiniz!";
	public final static String MSG_PLEASE_FILL_ACCOUNT_CODE  = "L�tfen hesap kodu b�l�m�n� doldurunuz!";
	public final static String MSG_NOT_ENTER_EXISTING_ACCOUNT_CODE  = "Daha �nce var olan bir hesap kodu giremezsiniz!";
	public final static String MSG_PLEASE_ENTER_PARENT_ACCOUNT  = "L�tfen Ana Hesab� Giriniz!";
	public final static String MSG_ACCOUNT_CODE_SHOULD_START_WITH_PARENT_ACCOUNT  = "Hesap kodu �st hesap kodu ile ba�lamak zorundad�r!";
	public final static String MSG_NOT_ENTER_SUBSIDIARY_ACCOUNT_PARENT_HAS_TRANSACTION  = "Daha �nce hareket g�rm�� bir hesaba alt hesap a�amazs�n�z!";
	public final static String MSG_TOTAL_CREDIT_SHOULD_EQUAL_DEBIT  = "Toplam bor� toplam alaca�a e�it olmal�!";
	public final static String MSG_ENTER_AT_LEAST_ONE_ROW  = "En az bir sat�r girmelisiniz!";
	public final static String MSG_ENTER_VOUCHER_DATE  = "L�tfen fi� tarihini giriniz!";
	public final static String MSG_NOT_DELETE_VOUCHER_WITH_JOURNAL_ID  = "Muhasebele�tirilen fi�ler de�i�tirilemez veya silinemez.\nDevam etmek istedi�inize emin misiniz?";

}
