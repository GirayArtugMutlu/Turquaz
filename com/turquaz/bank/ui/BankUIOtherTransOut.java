package com.turquaz.bank.ui;

import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.SWT;
import com.turquaz.engine.ui.component.CurrencyText;
import com.turquaz.bank.ui.comp.BankCardPicker;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.accounting.ui.comp.AccountPicker;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import com.turquaz.engine.ui.component.SecureComposite;



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
public class BankUIOtherTransOut extends org.eclipse.swt.widgets.Composite implements SecureComposite {
	private CLabel lblDocNo;
	private CLabel lblBankCard;
	private Text txtDefinition;
	private CLabel lblDefinition;
	private CurrencyText curAmount;
	private CLabel lblAmount;
	private AccountPicker currentPicker;
	private CLabel lblCurrentCard;
	private BankCardPicker txtBankCard;
	private DatePicker datePick;
	private CLabel lblDate;
	private Text txtDocNo;

	public BankUIOtherTransOut(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			this.setSize(491, 263);
            {
                lblDocNo = new CLabel(this, SWT.NONE);
                lblDocNo.setText("Belge No");
            }
            {
                txtDocNo = new Text(this, SWT.NONE);
                GridData txtDocNoLData = new GridData();
                txtDocNoLData.widthHint = 128;
                txtDocNoLData.heightHint = 15;
                txtDocNo.setLayoutData(txtDocNoLData);
            }
            {
                lblDate = new CLabel(this, SWT.NONE);
                lblDate.setText("Tarih");
            }
            {
                datePick = new DatePicker(this, SWT.NONE);
                GridData datePickLData = new GridData();
                datePickLData.widthHint = 109;
                datePickLData.heightHint = 20;
                datePick.setLayoutData(datePickLData);
            }
            {
                lblBankCard = new CLabel(this, SWT.NONE);
                lblBankCard.setText("Banka Kart?");
            }
            {
                txtBankCard = new BankCardPicker(this, SWT.NONE);
                GridData txtBankCardLData = new GridData();
                txtBankCardLData.widthHint = 192;
                txtBankCardLData.heightHint = 18;
                txtBankCard.setLayoutData(txtBankCardLData);
            }
            {
                lblCurrentCard = new CLabel(this, SWT.NONE);
                lblCurrentCard.setText("Muhasebe Hesab?");
               
            }
            {
                currentPicker = new AccountPicker(this, SWT.NONE);
                GridData currentPickerLData = new GridData();
                currentPickerLData.widthHint = 191;
                currentPickerLData.heightHint = 18;
                currentPicker.setLayoutData(currentPickerLData);
            }
            {
                lblAmount = new CLabel(this, SWT.NONE);
                lblAmount.setText("Tutar?");
            }
            {
                curAmount = new CurrencyText(this, SWT.NONE);
                GridData curAmountLData = new GridData();
                curAmountLData.widthHint = 185;
                curAmountLData.heightHint = 18;
                curAmount.setLayoutData(curAmountLData);
            }
            {
                lblDefinition = new CLabel(this, SWT.NONE);
                lblDefinition.setText("Aç?klama");
            }
            {
                txtDefinition = new Text(this, SWT.NONE);
                GridData txtDefinitionLData = new GridData();
                txtDefinitionLData.widthHint = 361;
                txtDefinitionLData.heightHint = 18;
                txtDefinition.setLayoutData(txtDefinitionLData);
            }
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

    public void newForm() {
        // TODO Auto-generated method stub

    }
    public void save() {
        // TODO Auto-generated method stub

    }
}
