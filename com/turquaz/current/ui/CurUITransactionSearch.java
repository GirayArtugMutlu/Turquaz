package com.turquaz.current.ui;

import java.util.List;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;

import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.current.bl.CurBLSearchTransaction;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentTransaction;
import com.turquaz.engine.dal.TurqCurrentTransactionType;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SecureComposite;


import org.eclipse.swt.widgets.MessageBox;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.SWT;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class CurUITransactionSearch extends SecureComposite {

	private TableColumn tableColumnTransDate;
	private TableColumn tableColumnCredit;
	private TableColumn tableColumnTransGroup;
	private TableColumn tableColumnDebit;
	private TableColumn tableColumnCurrentCode;
	private Table tableCurrentTransactions;
	private DatePicker dateEndDate;
	private CLabel lblEndDate;
	private DatePicker dateStartDate;
	private CLabel lblStartDate;
	private Text txtDocumentNo;
	private CLabel lblDocumentNo;
	private CCombo comboTransactionGroup;
	private CLabel lblTransactionGroup;
	private CCombo comboCurrentCards;
	private CLabel lblCurrentCard;
	private Composite composite1;
	private CurBLSearchTransaction blSearch = new CurBLSearchTransaction();
	private CurBLCurrentTransactionAdd blTransAdd = new CurBLCurrentTransactionAdd();
	public CurUITransactionSearch(Composite parent, int style) {
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
			lblCurrentCard = new CLabel(composite1,SWT.NULL);
			comboCurrentCards = new CCombo(composite1,SWT.NULL);
			lblTransactionGroup = new CLabel(composite1,SWT.NULL);
			comboTransactionGroup = new CCombo(composite1,SWT.NULL);
			lblDocumentNo = new CLabel(composite1,SWT.NULL);
			txtDocumentNo = new Text(composite1,SWT.NULL);
			lblStartDate = new CLabel(composite1,SWT.NULL);
			dateStartDate = new DatePicker(composite1,SWT.NULL);
			lblEndDate = new CLabel(composite1,SWT.NULL);
			dateEndDate = new DatePicker(composite1,SWT.NULL);
			tableCurrentTransactions = new Table(this,SWT.FULL_SELECTION);
			tableColumnCurrentCode = new TableColumn(tableCurrentTransactions,SWT.NULL);
			tableColumnTransGroup = new TableColumn(tableCurrentTransactions,SWT.NULL);
			tableColumnDebit = new TableColumn(tableCurrentTransactions,SWT.NULL);
			tableColumnCredit = new TableColumn(tableCurrentTransactions,SWT.NULL);
			tableColumnTransDate = new TableColumn(tableCurrentTransactions,SWT.NULL);
	
			this.setSize(new org.eclipse.swt.graphics.Point(564,323));
	
			GridData composite1LData = new GridData();
			composite1LData.verticalAlignment = GridData.CENTER;
			composite1LData.horizontalAlignment = GridData.FILL;
			composite1LData.widthHint = -1;
			composite1LData.heightHint = 94;
			composite1LData.horizontalIndent = 0;
			composite1LData.horizontalSpan = 1;
			composite1LData.verticalSpan = 1;
			composite1LData.grabExcessHorizontalSpace = true;
			composite1LData.grabExcessVerticalSpace = false;
			composite1.setLayoutData(composite1LData);
			composite1.setSize(new org.eclipse.swt.graphics.Point(554,94));
	
			GridData lblCurrentCardLData = new GridData();
			lblCurrentCardLData.verticalAlignment = GridData.CENTER;
			lblCurrentCardLData.horizontalAlignment = GridData.BEGINNING;
			lblCurrentCardLData.widthHint = 85;
			lblCurrentCardLData.heightHint = 20;
			lblCurrentCardLData.horizontalIndent = 0;
			lblCurrentCardLData.horizontalSpan = 1;
			lblCurrentCardLData.verticalSpan = 1;
			lblCurrentCardLData.grabExcessHorizontalSpace = false;
			lblCurrentCardLData.grabExcessVerticalSpace = false;
			lblCurrentCard.setLayoutData(lblCurrentCardLData);
			lblCurrentCard.setText("Current Card");
			lblCurrentCard.setSize(new org.eclipse.swt.graphics.Point(85,20));
	
			GridData comboCurrentCardsLData = new GridData();
			comboCurrentCardsLData.verticalAlignment = GridData.CENTER;
			comboCurrentCardsLData.horizontalAlignment = GridData.BEGINNING;
			comboCurrentCardsLData.widthHint = 115;
			comboCurrentCardsLData.heightHint = 18;
			comboCurrentCardsLData.horizontalIndent = 0;
			comboCurrentCardsLData.horizontalSpan = 1;
			comboCurrentCardsLData.verticalSpan = 1;
			comboCurrentCardsLData.grabExcessHorizontalSpace = false;
			comboCurrentCardsLData.grabExcessVerticalSpace = false;
			comboCurrentCards.setLayoutData(comboCurrentCardsLData);
			comboCurrentCards.setSize(new org.eclipse.swt.graphics.Point(115,18));
	
			GridData lblTransactionGroupLData = new GridData();
			lblTransactionGroupLData.verticalAlignment = GridData.CENTER;
			lblTransactionGroupLData.horizontalAlignment = GridData.BEGINNING;
			lblTransactionGroupLData.widthHint = 105;
			lblTransactionGroupLData.heightHint = 18;
			lblTransactionGroupLData.horizontalIndent = 0;
			lblTransactionGroupLData.horizontalSpan = 1;
			lblTransactionGroupLData.verticalSpan = 1;
			lblTransactionGroupLData.grabExcessHorizontalSpace = false;
			lblTransactionGroupLData.grabExcessVerticalSpace = false;
			lblTransactionGroup.setLayoutData(lblTransactionGroupLData);
			lblTransactionGroup.setText("Transaction Group");
			lblTransactionGroup.setSize(new org.eclipse.swt.graphics.Point(105,18));
	
			GridData comboTransactionGroupLData = new GridData();
			comboTransactionGroupLData.verticalAlignment = GridData.CENTER;
			comboTransactionGroupLData.horizontalAlignment = GridData.BEGINNING;
			comboTransactionGroupLData.widthHint = 117;
			comboTransactionGroupLData.heightHint = 17;
			comboTransactionGroupLData.horizontalIndent = 0;
			comboTransactionGroupLData.horizontalSpan = 1;
			comboTransactionGroupLData.verticalSpan = 1;
			comboTransactionGroupLData.grabExcessHorizontalSpace = false;
			comboTransactionGroupLData.grabExcessVerticalSpace = false;
			comboTransactionGroup.setLayoutData(comboTransactionGroupLData);
			comboTransactionGroup.setSize(new org.eclipse.swt.graphics.Point(117,17));
	
			GridData lblDocumentNoLData = new GridData();
			lblDocumentNoLData.verticalAlignment = GridData.CENTER;
			lblDocumentNoLData.horizontalAlignment = GridData.BEGINNING;
			lblDocumentNoLData.widthHint = 80;
			lblDocumentNoLData.heightHint = 19;
			lblDocumentNoLData.horizontalIndent = 0;
			lblDocumentNoLData.horizontalSpan = 1;
			lblDocumentNoLData.verticalSpan = 1;
			lblDocumentNoLData.grabExcessHorizontalSpace = false;
			lblDocumentNoLData.grabExcessVerticalSpace = false;
			lblDocumentNo.setLayoutData(lblDocumentNoLData);
			lblDocumentNo.setText("Document No");
			lblDocumentNo.setSize(new org.eclipse.swt.graphics.Point(80,19));
	
			GridData txtDocumentNoLData = new GridData();
			txtDocumentNoLData.verticalAlignment = GridData.CENTER;
			txtDocumentNoLData.horizontalAlignment = GridData.BEGINNING;
			txtDocumentNoLData.widthHint = 132;
			txtDocumentNoLData.heightHint = 17;
			txtDocumentNoLData.horizontalIndent = 0;
			txtDocumentNoLData.horizontalSpan = 3;
			txtDocumentNoLData.verticalSpan = 1;
			txtDocumentNoLData.grabExcessHorizontalSpace = false;
			txtDocumentNoLData.grabExcessVerticalSpace = false;
			txtDocumentNo.setLayoutData(txtDocumentNoLData);
			txtDocumentNo.setSize(new org.eclipse.swt.graphics.Point(132,17));
	
			GridData lblStartDateLData = new GridData();
			lblStartDateLData.verticalAlignment = GridData.CENTER;
			lblStartDateLData.horizontalAlignment = GridData.BEGINNING;
			lblStartDateLData.widthHint = 69;
			lblStartDateLData.heightHint = 19;
			lblStartDateLData.horizontalIndent = 0;
			lblStartDateLData.horizontalSpan = 1;
			lblStartDateLData.verticalSpan = 1;
			lblStartDateLData.grabExcessHorizontalSpace = false;
			lblStartDateLData.grabExcessVerticalSpace = false;
			lblStartDate.setLayoutData(lblStartDateLData);
			lblStartDate.setText("Start Date");
			lblStartDate.setSize(new org.eclipse.swt.graphics.Point(69,19));
	
			GridData dateStartDateLData = new GridData();
			dateStartDateLData.verticalAlignment = GridData.CENTER;
			dateStartDateLData.horizontalAlignment = GridData.BEGINNING;
			dateStartDateLData.widthHint = 145;
			dateStartDateLData.heightHint = 22;
			dateStartDateLData.horizontalIndent = 0;
			dateStartDateLData.horizontalSpan = 1;
			dateStartDateLData.verticalSpan = 1;
			dateStartDateLData.grabExcessHorizontalSpace = false;
			dateStartDateLData.grabExcessVerticalSpace = false;
			dateStartDate.setLayoutData(dateStartDateLData);
			dateStartDate.setSize(new org.eclipse.swt.graphics.Point(145,22));
			dateStartDate.layout();
	
			GridData lblEndDateLData = new GridData();
			lblEndDateLData.verticalAlignment = GridData.CENTER;
			lblEndDateLData.horizontalAlignment = GridData.BEGINNING;
			lblEndDateLData.widthHint = 82;
			lblEndDateLData.heightHint = 18;
			lblEndDateLData.horizontalIndent = 0;
			lblEndDateLData.horizontalSpan = 1;
			lblEndDateLData.verticalSpan = 1;
			lblEndDateLData.grabExcessHorizontalSpace = false;
			lblEndDateLData.grabExcessVerticalSpace = false;
			lblEndDate.setLayoutData(lblEndDateLData);
			lblEndDate.setText("End Date");
			lblEndDate.setSize(new org.eclipse.swt.graphics.Point(82,18));
	
			GridData dateEndDateLData = new GridData();
			dateEndDateLData.verticalAlignment = GridData.CENTER;
			dateEndDateLData.horizontalAlignment = GridData.BEGINNING;
			dateEndDateLData.widthHint = 142;
			dateEndDateLData.heightHint = 22;
			dateEndDateLData.horizontalIndent = 0;
			dateEndDateLData.horizontalSpan = 1;
			dateEndDateLData.verticalSpan = 1;
			dateEndDateLData.grabExcessHorizontalSpace = false;
			dateEndDateLData.grabExcessVerticalSpace = false;
			dateEndDate.setLayoutData(dateEndDateLData);
			dateEndDate.setSize(new org.eclipse.swt.graphics.Point(142,22));
			dateEndDate.layout();
			GridLayout composite1Layout = new GridLayout(4, true);
			composite1.setLayout(composite1Layout);
			composite1Layout.marginWidth = 5;
			composite1Layout.marginHeight = 5;
			composite1Layout.numColumns = 4;
			composite1Layout.makeColumnsEqualWidth = false;
			composite1Layout.horizontalSpacing = 5;
			composite1Layout.verticalSpacing = 5;
			composite1.layout();
	
			GridData tableCurrentTransactionsLData = new GridData();
			tableCurrentTransactionsLData.verticalAlignment = GridData.FILL;
			tableCurrentTransactionsLData.horizontalAlignment = GridData.FILL;
			tableCurrentTransactionsLData.widthHint = -1;
			tableCurrentTransactionsLData.heightHint = -1;
			tableCurrentTransactionsLData.horizontalIndent = 0;
			tableCurrentTransactionsLData.horizontalSpan = 1;
			tableCurrentTransactionsLData.verticalSpan = 1;
			tableCurrentTransactionsLData.grabExcessHorizontalSpace = true;
			tableCurrentTransactionsLData.grabExcessVerticalSpace = true;
			tableCurrentTransactions.setLayoutData(tableCurrentTransactionsLData);
			tableCurrentTransactions.setHeaderVisible(true);
			tableCurrentTransactions.setLinesVisible(true);
			tableCurrentTransactions.setSize(new org.eclipse.swt.graphics.Point(538,198));
			tableCurrentTransactions.addMouseListener( new MouseAdapter() {
				public void mouseDoubleClick(MouseEvent evt) {
					tableCurrentTransactionsMouseDoubleClick(evt);
				}
			});
	
			tableColumnCurrentCode.setText("Current Code");
			tableColumnCurrentCode.setWidth(107);
	
			tableColumnTransGroup.setText("Transaction Group");
			tableColumnTransGroup.setWidth(114);
	
			tableColumnDebit.setText("Debit");
			tableColumnDebit.setWidth(106);
	
			tableColumnCredit.setText("Credit");
			tableColumnCredit.setWidth(101);
	
			tableColumnTransDate.setText("Transaction Date");
			tableColumnTransDate.setWidth(100);
			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = false;
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
	
	fillComboCurrentCard();
	fillComboTypes();
	
	}
	public void fillComboCurrentCard(){
	try{
	List list = blTransAdd.getCurrentCards();
	TurqCurrentCard curCard ;	
	for(int i =0;i<list.size();i++){

	curCard = (TurqCurrentCard)list.get(i);
	comboCurrentCards.add(curCard.getCardsCurrentCode());
	comboCurrentCards.setData(curCard.getCardsCurrentCode(),curCard);	
	
	}
		}
	catch(Exception ex){
	ex.printStackTrace();
	MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
    msg.setMessage(ex.getMessage());
	msg.open();
	}
	
	
	
	
	
	}
	public void fillComboTypes(){
	try{
	List list = blTransAdd.getCurrentTransactionTypes();
	TurqCurrentTransactionType type ;	
	for(int i =0;i<list.size();i++){

	type = (TurqCurrentTransactionType)list.get(i);
	comboTransactionGroup.add(type.getTransactionTypeName());
	comboTransactionGroup.setData(type.getTransactionTypeName(),type);	
	
	}
		}
	catch(Exception ex){
	ex.printStackTrace();
	MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
    msg.setMessage(ex.getMessage());
	msg.open();
	}
}
	
	
	public void save(){
	
	
	}
	public void search(){
	try{
	tableCurrentTransactions.removeAll();
	
	List results =blSearch.searchCurrentTransaction(comboCurrentCards.getData(comboCurrentCards.getText()),
									 comboTransactionGroup.getData(comboTransactionGroup.getText()),
									 txtDocumentNo.getText().trim(),dateStartDate.getDate(),dateEndDate.getDate());
	
	TurqCurrentTransaction transaction;
	TableItem item;
	
	for(int i=0;i<results.size();i++){
	
	transaction = (TurqCurrentTransaction)results.get(i);
	item = new TableItem(tableCurrentTransactions,SWT.NULL);
	item.setData(transaction);
	item.setText(new String[]{transaction.getTurqCurrentCard().getCardsCurrentCode(),
							  transaction.getTurqCurrentTransactionType().getTransactionTypeName(),
							  transaction.getTransactionsTotalDept().toString(),
							  transaction.getTransactionsTotalCredit().toString(),
							  DatePicker.formatter.format(transaction.getTransactionsDate())
								});
	
	} 
	
	
	
     	
	}
	catch(Exception ex){
	ex.printStackTrace();
	}
	
	
	
	}
	public void delete(){
	
	}
	public void newForm(){
	
	}

	/** Auto-generated event handler method */
	protected void tableCurrentTransactionsMouseDoubleClick(MouseEvent evt){
		TableItem items[] = tableCurrentTransactions.getSelection();
		if(items.length >0){
		
		TurqCurrentTransaction trans = (TurqCurrentTransaction)items[0].getData();
		
		if(trans.getTurqCurrentTransactionType().getCurrentTransactionTypesId().intValue()==4){
		new CUrUITransactionUpdateDialog(this.getShell(),SWT.NULL,trans).open();
		}
		}
	}
}
