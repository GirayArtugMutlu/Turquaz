package com.turquaz.cheque.ui;

import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import com.turquaz.engine.ui.component.CurrencyText;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import com.turquaz.engine.ui.component.DatePicker;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
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
public class CheUICustomerChequeAddDialog extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private CLabel lblPortfolioNo;
	private CurrencyText curText;
	private ToolItem toolCancel;
	private ToolItem toolSave;
	private ToolBar toolBar1;
	private CLabel lblAmount;
	private Text txtPaymentPlace;
	private CLabel lblPaymentPlace;
	private CLabel lblBankName;
	private Text txtDeptor;
	private CLabel lblDeptor;
	private DatePicker datePickValueDate;
	private CLabel lblDueDate;
	private Text txtBankBranch;
	private CLabel lblBankBranch;
	private Text txtBankName;
	private Text txtChequeNo;
	private CLabel lblChequeNo;
	private Text txtPortfoyNo;

	public CheUICustomerChequeAddDialog(Shell parent, int style) {
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
			dialogShellLayout.numColumns = 2;
			dialogShell.layout();
			dialogShell.pack();
			dialogShell.setSize(523, 360);
            {
                toolBar1 = new ToolBar(dialogShell, SWT.NONE);
                GridData toolBar1LData = new GridData();
                toolBar1LData.horizontalAlignment = GridData.FILL;
                toolBar1LData.grabExcessHorizontalSpace = true;
                toolBar1LData.horizontalSpan = 2;
                toolBar1.setLayoutData(toolBar1LData);
                {
                    toolSave = new ToolItem(toolBar1, SWT.NONE);
                    toolSave.setText("Kaydet");
                    toolSave.setImage(SWTResourceManager.getImage("icons/save_edit.gif"));
                }
                {
                    toolCancel = new ToolItem(toolBar1, SWT.NONE);
                    toolCancel.setText("?ptal");
                    toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg"));
                }
            }
            {
                lblPortfolioNo = new CLabel(dialogShell, SWT.NONE);
                lblPortfolioNo.setText("Portföy Numaras?");
            }
            {
                txtPortfoyNo = new Text(dialogShell, SWT.NONE);
                GridData txtPortfoyNoLData = new GridData();
                txtPortfoyNoLData.widthHint = 120;
                txtPortfoyNoLData.heightHint = 18;
                txtPortfoyNo.setLayoutData(txtPortfoyNoLData);
            }
            {
                lblChequeNo = new CLabel(dialogShell, SWT.NONE);
                lblChequeNo.setText("Çek Numaras?");
            }
            {
                txtChequeNo = new Text(dialogShell, SWT.NONE);
                GridData txtChequeNoLData = new GridData();
                txtChequeNoLData.widthHint = 119;
                txtChequeNoLData.heightHint = 17;
                txtChequeNo.setLayoutData(txtChequeNoLData);
            }
            {
                lblBankName = new CLabel(dialogShell, SWT.NONE);
                lblBankName.setText("Banka Ad?");
            }
            {
                txtBankName = new Text(dialogShell, SWT.NONE);
                GridData txtBankNameLData = new GridData();
                txtBankNameLData.widthHint = 117;
                txtBankNameLData.heightHint = 18;
                txtBankName.setLayoutData(txtBankNameLData);
            }
            {
                lblBankBranch = new CLabel(dialogShell, SWT.NONE);
                lblBankBranch.setText("Banka ?ubesi");
            }
            {
                txtBankBranch = new Text(dialogShell, SWT.NONE);
                GridData txtBankBranchLData = new GridData();
                txtBankBranchLData.widthHint = 117;
                txtBankBranchLData.heightHint = 17;
                txtBankBranch.setLayoutData(txtBankBranchLData);
            }
            {
                lblDueDate = new CLabel(dialogShell, SWT.NONE);
                lblDueDate.setText("Vade Tarihi");
            }
            {
                datePickValueDate = new DatePicker(dialogShell, SWT.NONE);
                GridData datePickValueDateLData = new GridData();
                datePickValueDateLData.widthHint = 113;
                datePickValueDateLData.heightHint = 19;
                datePickValueDate.setLayoutData(datePickValueDateLData);
            }
            {
                lblDeptor = new CLabel(dialogShell, SWT.NONE);
                lblDeptor.setText("Borçlu");
                GridData lblDeptorLData = new GridData();
                lblDeptorLData.widthHint = 42;
                lblDeptorLData.heightHint = 19;
                lblDeptor.setLayoutData(lblDeptorLData);
            }
            {
                txtDeptor = new Text(dialogShell, SWT.NONE);
                GridData txtDeptorLData = new GridData();
                txtDeptorLData.widthHint = 201;
                txtDeptorLData.heightHint = 18;
                txtDeptor.setLayoutData(txtDeptorLData);
            }
            {
                lblPaymentPlace = new CLabel(dialogShell, SWT.NONE);
                lblPaymentPlace.setText("Ödeme Yeri");
            }
            {
                txtPaymentPlace = new Text(dialogShell, SWT.NONE);
                GridData txtPaymentPlaceLData = new GridData();
                txtPaymentPlaceLData.widthHint = 117;
                txtPaymentPlaceLData.heightHint = 19;
                txtPaymentPlace.setLayoutData(txtPaymentPlaceLData);
            }
            {
                lblAmount = new CLabel(dialogShell, SWT.NONE);
                lblAmount.setText("Tutar?");
            }
            {
                curText = new CurrencyText(dialogShell, SWT.NONE);
                GridData curTextLData = new GridData();
                curTextLData.widthHint = 117;
                curTextLData.heightHint = 19;
                curText.setLayoutData(curTextLData);
            }
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
