package com.turquaz.inventory.ui;


import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CCombo;
import com.turquaz.engine.ui.component.NumericText;
import com.turquaz.engine.ui.component.DecimalTextWithButton;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import com.turquaz.engine.ui.component.TextWithButton;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;


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
public class InvUITransactionAddDialog extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private Composite composite1;
	private CLabel invAmount;
	private NumericText numTxtAmount;
	private Button btnSpecialButtonEach;
	private NumericText numTxtSpecialVatEach;
	private CLabel lblSpecialVatEach;
	private Button btnSpecialVat;
	private NumericText numSpecialVat;
	private NumericText txtVat;
	private CLabel lblSpecialVAT;
	private CLabel lblVat;
	private DecimalTextWithButton comboPrices;
	private CCombo comboCurrency;
	private CLabel lblPrice;
	private CCombo comboUnitType;
	private TextWithButton txtInvCard;
	private CLabel lblInvVard;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/
	
	public InvUITransactionAddDialog(Shell parent, int style) {
		super(parent, style);
	}

	public void open() {
		try {
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

				{
					//Register as a resource user - SWTResourceManager will
					//handle the obtaining and disposing of resources
					SWTResourceManager.registerResourceUser(dialogShell);
				}


			GridLayout dialogShellLayout = new GridLayout();
			dialogShell.setLayout(dialogShellLayout);
			dialogShellLayout.horizontalSpacing = 0;
			dialogShellLayout.marginHeight = 0;
			dialogShellLayout.marginWidth = 0;
			dialogShellLayout.verticalSpacing = 0;

			dialogShell.pack();
			dialogShell.setSize(582, 399);
			{
				composite1 = new Composite(dialogShell, SWT.NONE);
				GridLayout composite1Layout = new GridLayout();
				GridData composite1LData = new GridData();
				composite1LData.grabExcessHorizontalSpace = true;
				composite1LData.grabExcessVerticalSpace = true;
				composite1LData.horizontalAlignment = GridData.FILL;
				composite1LData.verticalAlignment = GridData.FILL;
				composite1.setLayoutData(composite1LData);
				composite1Layout.numColumns = 3;
				composite1.setLayout(composite1Layout);
				{
					lblInvVard = new CLabel(composite1, SWT.NONE);
					lblInvVard.setText("Inventory Card ");
					GridData lblInvVardLData = new GridData();
					lblInvVardLData.widthHint = 110;
					lblInvVardLData.heightHint = 21;
					lblInvVard.setLayoutData(lblInvVardLData);
				}
				{
					txtInvCard = new TextWithButton(composite1, SWT.NONE);
					GridData txtInvCardLData = new GridData();
					txtInvCardLData.widthHint = 334;
					txtInvCardLData.heightHint = 21;
					txtInvCardLData.horizontalSpan = 2;
					txtInvCard.setLayoutData(txtInvCardLData);
				}
				{
					invAmount = new CLabel(composite1, SWT.NONE);
					invAmount.setText("Amount");
					GridData invAmountLData = new GridData();
					invAmountLData.widthHint = 75;
					invAmountLData.heightHint = 20;
					invAmount.setLayoutData(invAmountLData);
				}
				{
					numTxtAmount = new NumericText(composite1, SWT.NONE);
					GridData numTxtAmountLData = new GridData();
					numTxtAmountLData.heightHint = 16;
					numTxtAmountLData.horizontalAlignment = GridData.FILL;
					numTxtAmount.setLayoutData(numTxtAmountLData);
				}
				{
					comboUnitType = new CCombo(composite1, SWT.NONE);
					GridData cCombo1LData = new GridData();
					cCombo1LData.widthHint = 49;
					cCombo1LData.heightHint = 18;
					comboUnitType.setLayoutData(cCombo1LData);
				}
				{
					lblPrice = new CLabel(composite1, SWT.NONE);
					lblPrice.setText("Price");
					GridData lblPriceLData = new GridData();
					lblPriceLData.widthHint = 67;
					lblPriceLData.heightHint = 19;
					lblPrice.setLayoutData(lblPriceLData);
				}
				{
					comboPrices = new DecimalTextWithButton(
						composite1,
						SWT.NONE);
					GridData comboPricesLData = new GridData();
					comboPrices.setBackground(SWTResourceManager.getColor(
						255,
						255,
						255));
					comboPricesLData.heightHint = 17;
					comboPricesLData.horizontalAlignment = GridData.FILL;
					comboPrices.setLayoutData(comboPricesLData);
				}
				{
					comboCurrency = new CCombo(composite1, SWT.NONE);
					GridData comboCurrencyLData = new GridData();
					comboCurrencyLData.widthHint = 49;
					comboCurrencyLData.heightHint = 18;
					comboCurrency.setLayoutData(comboCurrencyLData);
				}
				{
					lblVat = new CLabel(composite1, SWT.NONE);
					lblVat.setText("VAT");
					GridData lblVatLData = new GridData();
					lblVatLData.widthHint = 43;
					lblVatLData.heightHint = 19;
					lblVat.setLayoutData(lblVatLData);
				}
				{
					txtVat = new NumericText(composite1, SWT.NONE);
					GridData txtVatLData = new GridData();
					txtVat.setTextLimit(2);
					txtVatLData.heightHint = 17;
					txtVatLData.horizontalSpan = 2;
					txtVatLData.grabExcessHorizontalSpace = true;
					txtVatLData.widthHint = 198;
					txtVat.setLayoutData(txtVatLData);
				}
				{
					lblSpecialVAT = new CLabel(composite1, SWT.NONE);
					lblSpecialVAT.setText("Special VAT");
					GridData lblSpecialVATLData = new GridData();
					lblSpecialVATLData.widthHint = 86;
					lblSpecialVATLData.heightHint = 19;
					lblSpecialVAT.setLayoutData(lblSpecialVATLData);
				}
				{
					numSpecialVat = new NumericText(composite1, SWT.NONE);
					GridData numSpecialVatLData = new GridData();
					numSpecialVat.setTextLimit(2);
					numSpecialVatLData.widthHint = 201;
					numSpecialVatLData.heightHint = 17;
					numSpecialVat.setLayoutData(numSpecialVatLData);
				}
				{
					btnSpecialVat = new Button(composite1, SWT.RADIO | SWT.LEFT);
				}
				{
					lblSpecialVatEach = new CLabel(composite1, SWT.NONE);
					lblSpecialVatEach.setText("Special VAT Each");
				}
				{
					numTxtSpecialVatEach = new NumericText(composite1, SWT.NONE);
					GridData numTxtSpecialVatEachLData = new GridData();
					numTxtSpecialVatEachLData.horizontalAlignment = GridData.FILL;
					numTxtSpecialVatEachLData.heightHint = 16;
					numTxtSpecialVatEach.setLayoutData(numTxtSpecialVatEachLData);
				}
				{
					btnSpecialButtonEach = new Button(composite1, SWT.RADIO
						| SWT.LEFT);
				}

			}
			dialogShell.layout();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
