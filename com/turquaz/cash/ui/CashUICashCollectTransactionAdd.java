package com.turquaz.cash.ui;

import org.eclipse.jface.contentassist.TextContentAssistSubjectAdapter;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.layout.GridData;

import com.turquaz.cash.bl.CashBLCashTransactionAdd;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.ui.component.CurrencyText;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SecureComposite;
import com.turquaz.engine.ui.contentassist.TurquazContentAssistant;

import org.eclipse.swt.widgets.Text;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.graphics.Rectangle;
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
public class CashUICashCollectTransactionAdd extends org.eclipse.swt.widgets.Composite implements SecureComposite {

    {
        //Register as a resource user - SWTResourceManager will
        //handle the obtaining and disposing of resources
        SWTResourceManager.registerResourceUser(this);
    }

	private CLabel lblCashTransType;
	private CLabel lblCashCard;
	private Text txtDefinition;
	private DatePicker datePicker;
	private CLabel lblDate;
	private CLabel lblDefinition;
	private Text txtDocumentNo;
	private CLabel lblDocumentNo;
	private CurrencyText curTextTotalAmount;
	private CLabel lblTotalAmount;
	private Text txtCurrentAccount;
	private CLabel lblCurrentCard;
	private Text txtCashCard;
	CashBLCashTransactionAdd blTrans = new CashBLCashTransactionAdd();

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
		CashUICashCollectTransactionAdd inst = new CashUICashCollectTransactionAdd(shell, SWT.NULL);
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

	public CashUICashCollectTransactionAdd(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			this.setSize(540, 265);
            {
                lblCashTransType = new CLabel(this, SWT.NONE);
                lblCashTransType.setText("Tahsilat Fi?i");
                GridData lblCashTransTypeLData = new GridData();
                lblCashTransType.setFont(SWTResourceManager.getFont("Tahoma", 14, 1, false, false));
                lblCashTransTypeLData.widthHint = 180;
                lblCashTransTypeLData.heightHint = 42;
                lblCashTransTypeLData.horizontalAlignment = GridData.CENTER;
                lblCashTransTypeLData.horizontalSpan = 2;
                lblCashTransTypeLData.grabExcessHorizontalSpace = true;
                lblCashTransType.setLayoutData(lblCashTransTypeLData);
            }
            {
                lblDocumentNo = new CLabel(this, SWT.NONE);
                lblDocumentNo.setText("Belge No");
            }
            {
                txtDocumentNo = new Text(this, SWT.NONE);
                GridData txtDocumentNoLData = new GridData();
                txtDocumentNo.setSize(166, 19);
                txtDocumentNoLData.widthHint = 166;
                txtDocumentNoLData.heightHint = 19;
                txtDocumentNo.setLayoutData(txtDocumentNoLData);
            }
            {
                lblDate = new CLabel(this, SWT.NONE);
                lblDate.setText("Tarih");
            }
            {
                datePicker = new DatePicker(this, SWT.NONE);
                GridData datePickerLData = new GridData();
                datePickerLData.widthHint = 128;
                datePickerLData.heightHint = 23;
                datePicker.setLayoutData(datePickerLData);
            }
            {
                lblCashCard = new CLabel(this, SWT.NONE);
                lblCashCard.setText("Kasa Kart?");
            }
            {
                txtCashCard = new Text(this, SWT.NONE);
                GridData txtCashCardLData = new GridData();
                txtCashCardLData.widthHint = 159;
                txtCashCardLData.heightHint = 19;
                txtCashCard.setLayoutData(txtCashCardLData);
            }
            {
                lblCurrentCard = new CLabel(this, SWT.NONE);
                lblCurrentCard.setText("Cari Hesap");
            }
            {
                txtCurrentAccount = new Text(this, SWT.NONE);
                txtCurrentAccount.setSize(166, 19);
            }
            {
                lblTotalAmount = new CLabel(this, SWT.NONE);
                lblTotalAmount.setText("Tutar?");
                GridData lblTotalAmountLData = new GridData();
                lblTotalAmountLData.widthHint = 42;
                lblTotalAmountLData.heightHint = 19;
                lblTotalAmount.setLayoutData(lblTotalAmountLData);
            }
            {
                curTextTotalAmount = new CurrencyText(this, SWT.NONE);
                curTextTotalAmount.setSize(166, 19);
            }
            {
                lblDefinition = new CLabel(this, SWT.NONE);
                lblDefinition.setText("Aç?klama");
            }
            {
                txtDefinition = new Text(this, SWT.NONE);
                GridData txtDefinitionLData = new GridData();
                txtDefinitionLData.widthHint = 359;
                txtDefinitionLData.heightHint = 18;
                txtDefinition.setLayoutData(txtDefinitionLData);
            }
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void postInitGUI(){
	    
//	  content assistant
		TextContentAssistSubjectAdapter adapter = new TextContentAssistSubjectAdapter(
				txtCurrentAccount);
		final TurquazContentAssistant assistant = new TurquazContentAssistant(
				adapter, 3);
		adapter.appendVerifyKeyListener(new VerifyKeyListener() {
			public void verifyKey(VerifyEvent event) {

				// Check for Ctrl+Spacebar
				if (event.stateMask == SWT.CTRL && event.character == ' ') {

					assistant.showPossibleCompletions();
					event.doit = false;

				}
			}
		});
	    
	    
	    
	}

    public void newForm() {
        // TODO Auto-generated method stub

    }
    public void save() {
       try{
           if(verifyFields()){
           
               
               blTrans.saveCurrentTransaction((TurqCashCard)txtCashCard.getData(),
                       						  (TurqCurrentCard)txtCurrentAccount.getData(),
                       						  EngBLCommon.CASH_CURRENT_COLLECT,
                       						  null,
                       						  curTextTotalAmount.getBigDecimalValue(),
                       						  datePicker.getDate(),
                       						  txtDefinition.getText(),
                       						  txtDocumentNo.getText().trim()
                       						  );
           
           
           }
       }
       catch(Exception ex){
           ex.printStackTrace();
       }

    }
    public boolean verifyFields(){
        return true;
    }
}
