package com.turquaz.bank.ui;

import java.util.List;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;

import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import com.turquaz.bank.bl.BankBLBankCardSearch;
import com.turquaz.engine.dal.TurqBanksCard;
import org.eclipse.swt.widgets.TableColumn;
import com.turquaz.engine.ui.component.SecureComposite;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class BankUIBankCardSearch extends SecureComposite {

	private TableColumn tableColumnAccountNo;
	private TableColumn tableColumnBankBrancName;
	private TableColumn tableColoumnBankName;
	private Text txtBankAccountNo;
	private CLabel lblBankAccountNo;
	private Text txtBankBranchName;
	private CLabel lblBankBranchName;
	private Text txtBankName;
	private CLabel lblBankName;
	private Table tableBankCards;
	private Composite composite1;
	public BankUIBankCardSearch(Composite parent, int style) {
		super(parent, style);
		initGUI();
	}
	
	private BankBLBankCardSearch bankBLBankCardSearch= new BankBLBankCardSearch();

	/**
	* Initializes the GUI.
	* Auto-generated code - any changes you make will disappear.
	*/
	public void initGUI(){
		try {
			preInitGUI();
	
			composite1 = new Composite(this,SWT.NULL);
			lblBankName = new CLabel(composite1,SWT.NULL);
			txtBankName = new Text(composite1,SWT.NULL);
			lblBankBranchName = new CLabel(composite1,SWT.NULL);
			txtBankBranchName = new Text(composite1,SWT.NULL);
			lblBankAccountNo = new CLabel(composite1,SWT.NULL);
			txtBankAccountNo = new Text(composite1,SWT.NULL);
			tableBankCards = new Table(this,SWT.NULL);
			tableColoumnBankName = new TableColumn(tableBankCards,SWT.NULL);
			tableColumnBankBrancName = new TableColumn(tableBankCards,SWT.NULL);
			tableColumnAccountNo = new TableColumn(tableBankCards,SWT.NULL);
	
			this.setSize(new org.eclipse.swt.graphics.Point(531,300));
	
			GridData composite1LData = new GridData();
			composite1LData.verticalAlignment = GridData.CENTER;
			composite1LData.horizontalAlignment = GridData.FILL;
			composite1LData.widthHint = -1;
			composite1LData.heightHint = 80;
			composite1LData.horizontalIndent = 0;
			composite1LData.horizontalSpan = 1;
			composite1LData.verticalSpan = 1;
			composite1LData.grabExcessHorizontalSpace = true;
			composite1LData.grabExcessVerticalSpace = false;
			composite1.setLayoutData(composite1LData);
			composite1.setSize(new org.eclipse.swt.graphics.Point(521,80));
	
			GridData lblBankNameLData = new GridData();
			lblBankNameLData.verticalAlignment = GridData.CENTER;
			lblBankNameLData.horizontalAlignment = GridData.BEGINNING;
			lblBankNameLData.widthHint = -1;
			lblBankNameLData.heightHint = -1;
			lblBankNameLData.horizontalIndent = 0;
			lblBankNameLData.horizontalSpan = 1;
			lblBankNameLData.verticalSpan = 1;
			lblBankNameLData.grabExcessHorizontalSpace = false;
			lblBankNameLData.grabExcessVerticalSpace = false;
			lblBankName.setLayoutData(lblBankNameLData);
			lblBankName.setText("Bank Name");
	
			GridData txtBankNameLData = new GridData();
			txtBankNameLData.verticalAlignment = GridData.CENTER;
			txtBankNameLData.horizontalAlignment = GridData.BEGINNING;
			txtBankNameLData.widthHint = 254;
			txtBankNameLData.heightHint = 13;
			txtBankNameLData.horizontalIndent = 0;
			txtBankNameLData.horizontalSpan = 1;
			txtBankNameLData.verticalSpan = 1;
			txtBankNameLData.grabExcessHorizontalSpace = false;
			txtBankNameLData.grabExcessVerticalSpace = false;
			txtBankName.setLayoutData(txtBankNameLData);
			txtBankName.setSize(new org.eclipse.swt.graphics.Point(254,13));
	
			GridData lblBankBranchNameLData = new GridData();
			lblBankBranchNameLData.verticalAlignment = GridData.CENTER;
			lblBankBranchNameLData.horizontalAlignment = GridData.BEGINNING;
			lblBankBranchNameLData.widthHint = -1;
			lblBankBranchNameLData.heightHint = -1;
			lblBankBranchNameLData.horizontalIndent = 0;
			lblBankBranchNameLData.horizontalSpan = 1;
			lblBankBranchNameLData.verticalSpan = 1;
			lblBankBranchNameLData.grabExcessHorizontalSpace = false;
			lblBankBranchNameLData.grabExcessVerticalSpace = false;
			lblBankBranchName.setLayoutData(lblBankBranchNameLData);
			lblBankBranchName.setText("Bank Branch Name");
	
			GridData txtBankBranchNameLData = new GridData();
			txtBankBranchNameLData.verticalAlignment = GridData.CENTER;
			txtBankBranchNameLData.horizontalAlignment = GridData.BEGINNING;
			txtBankBranchNameLData.widthHint = 254;
			txtBankBranchNameLData.heightHint = 13;
			txtBankBranchNameLData.horizontalIndent = 0;
			txtBankBranchNameLData.horizontalSpan = 1;
			txtBankBranchNameLData.verticalSpan = 1;
			txtBankBranchNameLData.grabExcessHorizontalSpace = false;
			txtBankBranchNameLData.grabExcessVerticalSpace = false;
			txtBankBranchName.setLayoutData(txtBankBranchNameLData);
			txtBankBranchName.setSize(new org.eclipse.swt.graphics.Point(254,13));
	
			GridData lblBankAccountNoLData = new GridData();
			lblBankAccountNoLData.verticalAlignment = GridData.CENTER;
			lblBankAccountNoLData.horizontalAlignment = GridData.BEGINNING;
			lblBankAccountNoLData.widthHint = -1;
			lblBankAccountNoLData.heightHint = -1;
			lblBankAccountNoLData.horizontalIndent = 0;
			lblBankAccountNoLData.horizontalSpan = 1;
			lblBankAccountNoLData.verticalSpan = 1;
			lblBankAccountNoLData.grabExcessHorizontalSpace = false;
			lblBankAccountNoLData.grabExcessVerticalSpace = false;
			lblBankAccountNo.setLayoutData(lblBankAccountNoLData);
			lblBankAccountNo.setText("Bank Account No");
	
			GridData txtBankAccountNoLData = new GridData();
			txtBankAccountNoLData.verticalAlignment = GridData.CENTER;
			txtBankAccountNoLData.horizontalAlignment = GridData.BEGINNING;
			txtBankAccountNoLData.widthHint = 254;
			txtBankAccountNoLData.heightHint = 13;
			txtBankAccountNoLData.horizontalIndent = 0;
			txtBankAccountNoLData.horizontalSpan = 1;
			txtBankAccountNoLData.verticalSpan = 1;
			txtBankAccountNoLData.grabExcessHorizontalSpace = false;
			txtBankAccountNoLData.grabExcessVerticalSpace = false;
			txtBankAccountNo.setLayoutData(txtBankAccountNoLData);
			txtBankAccountNo.setSize(new org.eclipse.swt.graphics.Point(254,13));
			GridLayout composite1Layout = new GridLayout(2, true);
			composite1.setLayout(composite1Layout);
			composite1Layout.marginWidth = 5;
			composite1Layout.marginHeight = 5;
			composite1Layout.numColumns = 2;
			composite1Layout.makeColumnsEqualWidth = false;
			composite1Layout.horizontalSpacing = 5;
			composite1Layout.verticalSpacing = 5;
			composite1.layout();
	
			GridData tableBankCardsLData = new GridData();
			tableBankCardsLData.verticalAlignment = GridData.FILL;
			tableBankCardsLData.horizontalAlignment = GridData.FILL;
			tableBankCardsLData.widthHint = -1;
			tableBankCardsLData.heightHint = -1;
			tableBankCardsLData.horizontalIndent = 0;
			tableBankCardsLData.horizontalSpan = 1;
			tableBankCardsLData.verticalSpan = 1;
			tableBankCardsLData.grabExcessHorizontalSpace = false;
			tableBankCardsLData.grabExcessVerticalSpace = true;
			tableBankCards.setLayoutData(tableBankCardsLData);
			tableBankCards.setHeaderVisible(true);
			tableBankCards.setLinesVisible(true);
			tableBankCards.setSize(new org.eclipse.swt.graphics.Point(505,189));
	
			tableColoumnBankName.setText("Bank Name");
			tableColoumnBankName.setWidth(150);
	
			tableColumnBankBrancName.setText("Branch Name");
			tableColumnBankBrancName.setWidth(150);
	
			tableColumnAccountNo.setText("Account No");
			tableColumnAccountNo.setWidth(150);
			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = true;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 5;
			this.layout();
	
			postInitGUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** Add your pre-init code in here 	*/
	public void preInitGUI(){
	}

	/** Add your post-init code in here 	*/
	public void postInitGUI(){
	}

	/** Auto-generated main method */
	public static void main(String[] args){
		showGUI();
	}
	
	public void delete(){
	}
	
	public void save(){
	}
	
	public void newForm(){
	}
	
	public void search(){
		try{
			List listBankCards=bankBLBankCardSearch.searchBankCards(txtBankName.getText().trim(),
																txtBankBranchName.getText().trim(),
																txtBankAccountNo.getText().trim());
			for(int k=0; k<listBankCards.size(); k++){
			TurqBanksCard aBankCard=(TurqBanksCard)listBankCards.get(k);
			TableItem item=new TableItem(tableBankCards, SWT.NULL);
			item.setData(aBankCard);
			item.setText(new String[]{aBankCard.getBankName(),aBankCard.getBankBranchName(),aBankCard.getBankAccountNo()});
			}
			System.out.println(listBankCards.size());
		}
		catch(Exception ex){
			MessageBox msg= new MessageBox(this.getShell(),SWT.NULL);
			msg.setMessage(ex.getMessage());	
			msg.open();
			ex.printStackTrace();
		}
	}

	/**
	* This static method creates a new instance of this class and shows
	* it inside a new Shell.
	*
	* It is a convenience method for showing the GUI, but it can be
	* copied and used as a basis for your own code.	*
	* It is auto-generated code - the body of this method will be
	* re-generated after any changes are made to the GUI.
	* However, if you delete this method it will not be re-created.	*/
	public static void showGUI(){
		try {
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			BankUIBankCardSearch inst = new BankUIBankCardSearch(shell, SWT.NULL);
			shell.setLayout(new org.eclipse.swt.layout.FillLayout());
			Rectangle shellBounds = shell.computeTrim(0,0,531,300);
			shell.setSize(shellBounds.width, shellBounds.height);
			shell.open();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
