package com.turquaz.accounting.ui;

import java.util.List;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CCombo;

import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqAccountingTransactionType;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SecureComposite;

import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.SWT;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class AccUITransactionSearch extends SecureComposite {

	private TableColumn tableColumnTotalAmount;
	private TableColumn tableColumnDate;
	private TableColumn tableColumnDocumentNo;
	private TableColumn tableColumnTransType;
	private DatePicker dateEndDate;
	private CLabel lblEndDate;
	private DatePicker dateStartDate;
	private CLabel lblStartDate;
	private CCombo comboTransType;
	private CLabel lblTransactionType;
	private Text txtDocumentNo;
	private CLabel lblDocumentNo;
	private Table tableTransactions;
	private Composite composite1;
	private AccBLTransactionSearch blTransSearch = new AccBLTransactionSearch();
	public AccUITransactionSearch(Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	/**
	* Initializes the GUI.
	* Auto-generated code - any changes you make will disappear.
	*/
	public void initGUI(){
		try {
			preInitGUI();
	
			composite1 = new Composite(this,SWT.NULL);
			lblDocumentNo = new CLabel(composite1,SWT.NULL);
			txtDocumentNo = new Text(composite1,SWT.NULL);
			lblTransactionType = new CLabel(composite1,SWT.NULL);
			comboTransType = new CCombo(composite1,SWT.READ_ONLY);
			lblStartDate = new CLabel(composite1,SWT.NULL);
			dateStartDate = new DatePicker(composite1,SWT.NULL);
			lblEndDate = new CLabel(composite1,SWT.NULL);
			dateEndDate = new DatePicker(composite1,SWT.NULL);
			tableTransactions = new Table(this,SWT.MULTI| SWT.FULL_SELECTION);
			tableColumnTransType = new TableColumn(tableTransactions,SWT.NULL);
			tableColumnDocumentNo = new TableColumn(tableTransactions,SWT.NULL);
			tableColumnDate = new TableColumn(tableTransactions,SWT.NULL);
			tableColumnTotalAmount = new TableColumn(tableTransactions,SWT.NULL);
	
			this.setSize(new org.eclipse.swt.graphics.Point(646,513));
	
			GridData composite1LData = new GridData();
			composite1LData.verticalAlignment = GridData.CENTER;
			composite1LData.horizontalAlignment = GridData.FILL;
			composite1LData.widthHint = -1;
			composite1LData.heightHint = 125;
			composite1LData.horizontalIndent = 0;
			composite1LData.horizontalSpan = 1;
			composite1LData.verticalSpan = 1;
			composite1LData.grabExcessHorizontalSpace = true;
			composite1LData.grabExcessVerticalSpace = false;
			composite1.setLayoutData(composite1LData);
			composite1.setSize(new org.eclipse.swt.graphics.Point(636,125));
	
			GridData lblDocumentNoLData = new GridData();
			lblDocumentNoLData.widthHint = 99;
			lblDocumentNoLData.heightHint = 24;
			lblDocumentNo.setLayoutData(lblDocumentNoLData);
			lblDocumentNo.setText("Document No");
			lblDocumentNo.setSize(new org.eclipse.swt.graphics.Point(99,24));
	
			GridData txtDocumentNoLData = new GridData();
			txtDocumentNoLData.widthHint = 141;
			txtDocumentNoLData.heightHint = 17;
			txtDocumentNo.setLayoutData(txtDocumentNoLData);
			txtDocumentNo.setSize(new org.eclipse.swt.graphics.Point(141,17));
	
			GridData lblTransactionTypeLData = new GridData();
			lblTransactionTypeLData.widthHint = 100;
			lblTransactionTypeLData.heightHint = 20;
			lblTransactionType.setLayoutData(lblTransactionTypeLData);
			lblTransactionType.setText("Transaction Type");
			lblTransactionType.setSize(new org.eclipse.swt.graphics.Point(100,20));
	
			GridData comboTransTypeLData = new GridData();
			comboTransTypeLData.widthHint = 121;
			comboTransTypeLData.heightHint = 19;
			comboTransType.setLayoutData(comboTransTypeLData);
			comboTransType.setText("Choose Type");
			final Color comboTransTypebackground = new Color(Display.getDefault(),255,255,255);
			comboTransType.setBackground(comboTransTypebackground);
			comboTransType.setEditable(false);
			comboTransType.setSize(new org.eclipse.swt.graphics.Point(121,19));
	
			lblStartDate.setText("Start Date");
	
			GridData dateStartDateLData = new GridData();
			dateStartDateLData.widthHint = 172;
			dateStartDateLData.heightHint = 25;
			dateStartDate.setLayoutData(dateStartDateLData);
			dateStartDate.setSize(new org.eclipse.swt.graphics.Point(172,25));
			dateStartDate.layout();
	
			lblEndDate.setText("End Date");
	
			GridData dateEndDateLData = new GridData();
			dateEndDateLData.widthHint = 171;
			dateEndDateLData.heightHint = 25;
			dateEndDate.setLayoutData(dateEndDateLData);
			dateEndDate.setSize(new org.eclipse.swt.graphics.Point(171,25));
			dateEndDate.layout();
			GridLayout composite1Layout = new GridLayout(2, true);
			composite1.setLayout(composite1Layout);
			composite1Layout.marginWidth = 5;
			composite1Layout.marginHeight = 5;
			composite1Layout.numColumns = 2;
			composite1Layout.makeColumnsEqualWidth = false;
			composite1Layout.horizontalSpacing = 5;
			composite1Layout.verticalSpacing = 5;
			composite1.layout();
	
			GridData tableTransactionsLData = new GridData();
			tableTransactionsLData.verticalAlignment = GridData.FILL;
			tableTransactionsLData.horizontalAlignment = GridData.FILL;
			tableTransactionsLData.widthHint = -1;
			tableTransactionsLData.heightHint = -1;
			tableTransactionsLData.horizontalIndent = 0;
			tableTransactionsLData.horizontalSpan = 1;
			tableTransactionsLData.verticalSpan = 1;
			tableTransactionsLData.grabExcessHorizontalSpace = true;
			tableTransactionsLData.grabExcessVerticalSpace = true;
			tableTransactions.setLayoutData(tableTransactionsLData);
			tableTransactions.setHeaderVisible(true);
			tableTransactions.setLinesVisible(true);
			tableTransactions.setSize(new org.eclipse.swt.graphics.Point(620,357));
	
			tableColumnTransType.setText("Transaction Type");
			tableColumnTransType.setWidth(115);
	
			tableColumnDocumentNo.setText("Document No");
			tableColumnDocumentNo.setWidth(114);
	
			tableColumnDate.setText("Date");
			tableColumnDate.setWidth(118);
	
			tableColumnTotalAmount.setText("Total Amount");
			tableColumnTotalAmount.setWidth(118);
			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 5;
			this.layout();
			addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					comboTransTypebackground.dispose();
				}
			});
	
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
	
	fillCombo();
	
	
	}
	public void fillCombo(){
	try{
	
	comboTransType.add(" ");
	List list = blTransSearch.getTransactionTypes();
	
	TurqAccountingTransactionType transType;
	for(int i=0;i<list.size();i++)
	{
       
       transType = (TurqAccountingTransactionType)list.get(i);
       comboTransType.add(transType.getTypesName());
       comboTransType.setData(transType.getTypesName(),transType);  	
	
	}
	
	}
	catch(Exception ex){
	ex.printStackTrace();
	}
	
	
	
	
	}
	
	
	public void save(){
	
	}
	public void delete(){
	
	}
	public void search(){
	try{
	tableTransactions.removeAll();
	
	List result = blTransSearch.searchAccTransaction(txtDocumentNo.getText().trim(),
												comboTransType.getData(comboTransType.getText()),
												dateStartDate.getData(),dateEndDate.getData());
	
	TableItem item;
	
	int listSize = result.size();
	for(int i =0; i<listSize;i++){
	TurqAccountingTransaction accTrans = (TurqAccountingTransaction)result.get(i);
	item = new TableItem(tableTransactions,SWT.NULL);
	item.setData(accTrans);
	String transDate = accTrans.getTransactionsDate().getDate()+"/"+(accTrans.getTransactionsDate().getMonth()+1)+"/"+
					   (accTrans.getTransactionsDate().getYear()+1900);
	item.setText(new String[]{accTrans.getTurqAccountingTransactionType().getTypesName(),
					accTrans.getTransactionDocumentNo(),transDate});
	
	}
	
	
	
	
	
	
	
	}
	catch(Exception ex){
	
	ex.printStackTrace();
		
	}
	
	
	
	
	
	
	}
	
	public void newForm(){
	
	}

}
