package com.turquaz.inventory.ui;


import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CCombo;
import com.turquaz.engine.ui.component.NumericText;
import com.turquaz.engine.ui.component.DecimalTextWithButton;
import com.cloudgarden.resource.SWTResourceManager;
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
					numTxtAmountLData.widthHint = 183;
					numTxtAmountLData.heightHint = 15;
					numTxtAmount.setLayoutData(numTxtAmountLData);
				}
				{
					comboUnitType = new CCombo(composite1, SWT.NONE);
					GridData cCombo1LData = new GridData();
					cCombo1LData.widthHint = 57;
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
					comboPrices = new DecimalTextWithButton(composite1, SWT.NONE);
					GridData comboPricesLData = new GridData();
					comboPrices.setBackground(SWTResourceManager.getColor(255,255,255));
					comboPricesLData.widthHint = 187;
					comboPricesLData.heightHint = 17;
					comboPrices.setLayoutData(comboPricesLData);
				}
				{
					comboCurrency = new CCombo(composite1, SWT.NONE);
					GridData comboCurrencyLData = new GridData();
					comboCurrencyLData.widthHint = 55;
					comboCurrencyLData.heightHint = 18;
					comboCurrency.setLayoutData(comboCurrencyLData);
				}

			}
			
			dialogShell.pack();
			dialogShell.setSize(615, 494);
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
