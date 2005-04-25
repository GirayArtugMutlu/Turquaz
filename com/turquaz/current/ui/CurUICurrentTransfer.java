package com.turquaz.current.ui;

import java.math.BigDecimal;
import java.util.HashMap;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;

import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.tx.EngTXCommon;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import com.turquaz.current.CurKeys;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.current.ui.comp.CurrentPicker;
import com.turquaz.engine.ui.component.CurrencyText;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.engine.ui.component.DatePicker;
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
public class CurUICurrentTransfer extends org.eclipse.swt.widgets.Composite implements SecureComposite{

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	private CLabel lblDocumentNo;
	private CurrencyText currentAmount;
	private Text txtDefinition;
	private DatePicker datePicker;
	private CLabel lblCashTransType;
	private CLabel lblDefinition;
	private CLabel lblAmount;
	private CurrentPicker currentCreditPicker;
	private CLabel lblCreditAcc;
	private CurrentPicker currentDebitPicker;
	private CLabel lblDebitAcc;
	private CLabel lblDate;
	private Text txtDocumentNo;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void main(String[] args) {
		showGUI();
	}
		
	/**
	* Auto-generated method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void showGUI() {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		CurUICurrentTransfer inst = new CurUICurrentTransfer(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if(size.x == 0 && size.y == 0) {
			inst.pack();
			shell.pack();
		} else {
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			int MENU_HEIGHT = 22;
			if (shell.getMenuBar() != null)
				shellBounds.height -= MENU_HEIGHT;
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public CurUICurrentTransfer(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			{
				this.setSize(443, 159);
			}
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			this.setSize(490, 238);
			{
				{
				}
				lblCashTransType = new CLabel(this, SWT.NONE);
				lblCashTransType.setText("Cari Virman");
				lblCashTransType.setFont(SWTResourceManager.getFont(
					"Tahoma",
					14,
					1,
					false,
					false));
				GridData lblCashTransTypeLData = new GridData();
				lblCashTransTypeLData.horizontalAlignment = GridData.CENTER;
				lblCashTransTypeLData.widthHint = 180;
				lblCashTransTypeLData.heightHint = 42;
				lblCashTransTypeLData.horizontalSpan = 2;
				lblCashTransTypeLData.grabExcessHorizontalSpace = true;
				lblCashTransType.setLayoutData(lblCashTransTypeLData);
			}
			{
				lblDocumentNo = new CLabel(this, SWT.NONE);
				GridLayout lblDocumentNoLayout = new GridLayout();
				lblDocumentNo.setText("Doküman No");
				GridData lblDocumentNoLData = new GridData();
				lblDocumentNo.setLayout(lblDocumentNoLayout);
				lblDocumentNoLData.widthHint = 74;
				lblDocumentNoLData.heightHint = 18;
				lblDocumentNo.setLayoutData(lblDocumentNoLData);
			}
			{
				txtDocumentNo = new Text(this, SWT.NONE);
				GridData txtDocumentNoLData = new GridData();
				txtDocumentNo.setSize(151, 17);
				txtDocumentNoLData.widthHint = 151;
				txtDocumentNoLData.heightHint = 17;
				txtDocumentNo.setLayoutData(txtDocumentNoLData);
			}
			{
				lblDate = new CLabel(this, SWT.NONE);
				lblDate.setText("Tarih");
			}
			{
				datePicker = new DatePicker(this, SWT.NONE);
				GridData datePickerLData = new GridData();
				datePicker.setSize(157, 23);
				datePickerLData.widthHint = 157;
				datePickerLData.heightHint = 23;
				datePicker.setLayoutData(datePickerLData);
			}
			{
				lblDebitAcc = new CLabel(this, SWT.NONE);
				lblDebitAcc.setText("Borclu Hesap");
			}
			{
				currentDebitPicker = new CurrentPicker(this, SWT.NONE);
				GridData currentDebitPickerLData = new GridData();
				currentDebitPicker.setSize(200, 17);
				currentDebitPickerLData.widthHint = 200;
				currentDebitPickerLData.heightHint = 17;
				currentDebitPicker.setLayoutData(currentDebitPickerLData);
			}
			{
				lblCreditAcc = new CLabel(this, SWT.NONE);
				GridData lblCreditAccLData = new GridData();
				lblCreditAcc.setText("Alacakli Hesap");
				lblCreditAccLData.widthHint = 76;
				lblCreditAccLData.heightHint = 19;
				lblCreditAcc.setLayoutData(lblCreditAccLData);
			}
			{
				currentCreditPicker = new CurrentPicker(this, SWT.NONE);
				GridData currentCreditPickerLData = new GridData();
				currentCreditPicker.setSize(200, 17);
				currentCreditPickerLData.widthHint = 200;
				currentCreditPickerLData.heightHint = 17;
				currentCreditPicker.setLayoutData(currentCreditPickerLData);
			}
			{
				lblAmount = new CLabel(this, SWT.NONE);
				lblAmount.setText("Tutar");
			}
			{
				currentAmount = new CurrencyText(this, SWT.NONE);
				GridData currentAmountLData = new GridData();
				currentAmount.setSize(194, 17);
				currentAmountLData.widthHint = 194;
				currentAmountLData.heightHint = 17;
				currentAmount.setLayoutData(currentAmountLData);
			}
			{
				lblDefinition = new CLabel(this, SWT.NONE);
				lblDefinition.setText("Aciklama");
			}
			{
				txtDefinition = new Text(this, SWT.NONE);
				GridData txtDefinitionLData = new GridData();
				txtDefinition.setSize(194, 17);
				txtDefinitionLData.widthHint = 194;
				txtDefinitionLData.heightHint = 17;
				txtDefinition.setLayoutData(txtDefinitionLData);
			}
			this.layout();
		} catch(Exception e) {
            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	/* (non-Javadoc)
	 * @see com.turquaz.engine.ui.component.SecureComposite#newForm()
	 */
	public void newForm() {
		CurUICurrentTransfer curCard = new CurUICurrentTransfer(this.getParent(), this.getStyle());
		CTabFolder tabfld = (CTabFolder) this.getParent();
		tabfld.getSelection().setControl(curCard);
		this.dispose();

	}
	
	public boolean verifyFields()
	{
		try
		{
			MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
			if (currentCreditPicker.getData() == null)
			{
				msg.setMessage("Lutfen Borclu Hesabi Giriniz!.."); 
				msg.open();
				currentCreditPicker.setFocus();
				return false;
			}
			if (currentDebitPicker.getData() == null)
			{
				msg.setMessage("Lutfen Alacakli Hesabi Giriniz!.."); 
				msg.open();
				currentDebitPicker.setFocus();
				return false;
			}
			else if ((currentAmount.getBigDecimalValue().doubleValue() <= 0) )
			{
				msg.setMessage("Lutfen Tutar Giriniz!.."); 
				msg.open();
				currentAmount.setFocus();
				return false;
			}
			
			return true;
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
			return false;
		}
	}
	/* (non-Javadoc)
	 * @see com.turquaz.engine.ui.component.SecureComposite#save()
	 */
	
	public void saveTrans()
	{
		try
		{
			MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
			
			if (verifyFields())
			{
				BigDecimal amount = currentAmount.getBigDecimalValue();
				
				HashMap argMap = new HashMap ();
				argMap.put(CurKeys.CUR_CARD_CREDIT, currentCreditPicker.getData());
				argMap.put(CurKeys.CUR_CARD_DEPT,currentDebitPicker.getData());
				argMap.put(EngKeys.DATE,datePicker.getDate());
				argMap.put(EngKeys.DOCUMENT_NO,txtDocumentNo.getText().trim());
				argMap.put(CurKeys.CUR_TRANS_AMOUNT,currentAmount.getBigDecimalValue());
				argMap.put(EngKeys.DEFINITION,txtDefinition.getText());
                argMap.put(EngKeys.EXCHANGE_RATE,EngBLCommon.getBaseCurrencyExchangeRate());
				
				EngTXCommon.doTransactionTX(CurBLCurrentTransactionAdd.class.getName(),"saveCurrentTransferBetweenAccounts",argMap);
				
				msg.setMessage("Cari Virman Basariyla Kaydedildi!.."); 
				msg.open();
				
				
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}
	public void save() {
		saveTrans();
		newForm();
		

	}
	
	/**
	 * @return Returns the currentAmount.
	 */
	public CurrencyText getCurrentAmount() {
		return currentAmount;
	}
	/**
	 * @param currentAmount The currentAmount to set.
	 */
	public void setCurrentAmount(CurrencyText currentAmount) {
		this.currentAmount = currentAmount;
	}
	/**
	 * @return Returns the currentCreditPicker.
	 */
	public CurrentPicker getCurrentCreditPicker() {
		return currentCreditPicker;
	}
	/**
	 * @param currentCreditPicker The currentCreditPicker to set.
	 */
	public void setCurrentCreditPicker(CurrentPicker currentCreditPicker) {
		this.currentCreditPicker = currentCreditPicker;
	}
	/**
	 * @return Returns the currentDebitPicker.
	 */
	public CurrentPicker getCurrentDebitPicker() {
		return currentDebitPicker;
	}
	/**
	 * @param currentDebitPicker The currentDebitPicker to set.
	 */
	public void setCurrentDebitPicker(CurrentPicker currentDebitPicker) {
		this.currentDebitPicker = currentDebitPicker;
	}
	/**
	 * @return Returns the datePicker.
	 */
	public DatePicker getDatePicker() {
		return datePicker;
	}
	/**
	 * @param datePicker The datePicker to set.
	 */
	public void setDatePicker(DatePicker datePicker) {
		this.datePicker = datePicker;
	}
	/**
	 * @return Returns the txtDefinition.
	 */
	public Text getTxtDefinition() {
		return txtDefinition;
	}
	/**
	 * @param txtDefinition The txtDefinition to set.
	 */
	public void setTxtDefinition(Text txtDefinition) {
		this.txtDefinition = txtDefinition;
	}
	/**
	 * @return Returns the txtDocumentNo.
	 */
	public Text getTxtDocumentNo() {
		return txtDocumentNo;
	}
	/**
	 * @param txtDocumentNo The txtDocumentNo to set.
	 */
	public void setTxtDocumentNo(Text txtDocumentNo) {
		this.txtDocumentNo = txtDocumentNo;
	}
}
