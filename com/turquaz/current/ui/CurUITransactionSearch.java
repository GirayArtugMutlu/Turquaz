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
public class CurUITransactionSearch extends Composite implements SecureComposite {

	private CurBLSearchTransaction blSearch = new CurBLSearchTransaction();
	private CurBLCurrentTransactionAdd blTransAdd = new CurBLCurrentTransactionAdd();
	private CLabel lblCurrentCard;
	private CCombo comboCurrentCards;
	private CLabel lblTransactionGroup;
	private Table tableCurrentTransactions;
	private TableColumn tableColumnTransDate;
	private TableColumn tableColumnCredit;
	private TableColumn tableColumnDebit;
	private TableColumn tableColumnTransGroup;
	private TableColumn tableColumnCurrentCode;
	private DatePicker dateEndDate;
	private CLabel lblEndDate;
	private DatePicker dateStartDate;
	private CLabel lblStartDate;
	private Text txtDocumentNo;
	private CLabel lblDocumentNo;
	private CCombo comboTransactionGroup;
	private Composite composite1;
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

			this.setSize(569, 379);

			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			{
				composite1 = new Composite(this, SWT.NONE);
				GridLayout composite1Layout = new GridLayout();
				composite1Layout.numColumns = 4;
				composite1.setSize(new org.eclipse.swt.graphics.Point(554, 94));
				GridData composite1LData = new GridData();
				composite1.setLayout(composite1Layout);
				composite1LData.horizontalAlignment = GridData.FILL;
				composite1LData.heightHint = 94;
				composite1LData.grabExcessHorizontalSpace = true;
				composite1.setLayoutData(composite1LData);
				{
					lblCurrentCard = new CLabel(composite1, SWT.NONE);
					lblCurrentCard.setText("Current Card");
					lblCurrentCard.setSize(new org.eclipse.swt.graphics.Point(
						85,
						20));
					GridData lblCurrentCardLData = new GridData();
					lblCurrentCardLData.widthHint = 85;
					lblCurrentCardLData.heightHint = 20;
					lblCurrentCard.setLayoutData(lblCurrentCardLData);
				}
				{
					comboCurrentCards = new CCombo(composite1, SWT.NONE);
					comboCurrentCards
						.setSize(new org.eclipse.swt.graphics.Point(115, 18));
					GridData comboCurrentCardsLData = new GridData();
					comboCurrentCardsLData.widthHint = 93;
					comboCurrentCardsLData.heightHint = 18;
					comboCurrentCards.setLayoutData(comboCurrentCardsLData);
				}
				{
					lblTransactionGroup = new CLabel(composite1, SWT.NONE);
					lblTransactionGroup.setText("Transaction Group");
					lblTransactionGroup
						.setSize(new org.eclipse.swt.graphics.Point(105, 18));
					GridData lblTransactionGroupLData = new GridData();
					lblTransactionGroupLData.widthHint = 105;
					lblTransactionGroupLData.heightHint = 18;
					lblTransactionGroup.setLayoutData(lblTransactionGroupLData);
				}
				{
					comboTransactionGroup = new CCombo(composite1, SWT.NONE);
					comboTransactionGroup
						.setSize(new org.eclipse.swt.graphics.Point(117, 17));
					GridData comboTransactionGroupLData = new GridData();
					comboTransactionGroupLData.widthHint = 95;
					comboTransactionGroupLData.heightHint = 17;
					comboTransactionGroup.setLayoutData(comboTransactionGroupLData);
				}
				{
					lblDocumentNo = new CLabel(composite1, SWT.NONE);
					lblDocumentNo.setText("Document No");
					lblDocumentNo.setSize(new org.eclipse.swt.graphics.Point(
						80,
						19));
					GridData lblDocumentNoLData = new GridData();
					lblDocumentNoLData.widthHint = 80;
					lblDocumentNoLData.heightHint = 19;
					lblDocumentNo.setLayoutData(lblDocumentNoLData);
				}
				{
					txtDocumentNo = new Text(composite1, SWT.NONE);
					txtDocumentNo.setSize(new org.eclipse.swt.graphics.Point(
						132,
						17));
					GridData txtDocumentNoLData = new GridData();
					txtDocumentNoLData.widthHint = 126;
					txtDocumentNoLData.heightHint = 17;
					txtDocumentNoLData.horizontalSpan = 3;
					txtDocumentNo.setLayoutData(txtDocumentNoLData);
				}
				{
					lblStartDate = new CLabel(composite1, SWT.NONE);
					lblStartDate.setText("Start Date");
					lblStartDate.setSize(new org.eclipse.swt.graphics.Point(
						69,
						19));
					GridData lblStartDateLData = new GridData();
					lblStartDateLData.widthHint = 69;
					lblStartDateLData.heightHint = 19;
					lblStartDate.setLayoutData(lblStartDateLData);
				}
				{
					dateStartDate = new DatePicker(composite1, SWT.NONE);
					dateStartDate.setSize(new org.eclipse.swt.graphics.Point(
						145,
						22));
					GridData dateStartDateLData = new GridData();
					dateStartDateLData.widthHint = 145;
					dateStartDateLData.heightHint = 22;
					dateStartDate.setLayoutData(dateStartDateLData);
				}
				{
					lblEndDate = new CLabel(composite1, SWT.NONE);
					lblEndDate.setText("End Date");
					lblEndDate.setSize(new org.eclipse.swt.graphics.Point(
						82,
						18));
					GridData lblEndDateLData = new GridData();
					lblEndDateLData.widthHint = 82;
					lblEndDateLData.heightHint = 18;
					lblEndDate.setLayoutData(lblEndDateLData);
				}
				{
					dateEndDate = new DatePicker(composite1, SWT.NONE);
					dateEndDate.setSize(new org.eclipse.swt.graphics.Point(
						142,
						22));
					GridData dateEndDateLData = new GridData();
					dateEndDateLData.widthHint = 142;
					dateEndDateLData.heightHint = 22;
					dateEndDate.setLayoutData(dateEndDateLData);
				}
			}
			{
				tableCurrentTransactions = new Table(this, SWT.FULL_SELECTION);
				tableCurrentTransactions.setHeaderVisible(true);
				tableCurrentTransactions.setLinesVisible(true);
				GridData tableCurrentTransactionsLData = new GridData();
				tableCurrentTransactions.addMouseListener(new MouseAdapter() {
					public void mouseDoubleClick(MouseEvent evt) {
						tableCurrentTransactionsMouseDoubleClick(evt);
					}
				});
				tableCurrentTransactionsLData.verticalAlignment = GridData.FILL;
				tableCurrentTransactionsLData.horizontalAlignment = GridData.FILL;
				tableCurrentTransactionsLData.grabExcessHorizontalSpace = true;
				tableCurrentTransactionsLData.grabExcessVerticalSpace = true;
				tableCurrentTransactions.setLayoutData(tableCurrentTransactionsLData);
				{
					tableColumnCurrentCode = new TableColumn(
						tableCurrentTransactions,
						SWT.NONE);
					tableColumnCurrentCode.setText("Current Code");
					tableColumnCurrentCode.setWidth(107);
				}
				{
					tableColumnTransGroup = new TableColumn(
						tableCurrentTransactions,
						SWT.NONE);
					tableColumnTransGroup.setText("Transaction Group");
					tableColumnTransGroup.setWidth(114);
				}
				{
					tableColumnDebit = new TableColumn(
						tableCurrentTransactions,
						SWT.NONE);
					tableColumnDebit.setText("Debit");
					tableColumnDebit.setWidth(106);
				}
				{
					tableColumnCredit = new TableColumn(
						tableCurrentTransactions,
						SWT.NONE);
					tableColumnCredit.setText("Credit");
					tableColumnCredit.setWidth(101);
				}
				{
					tableColumnTransDate = new TableColumn(
						tableCurrentTransactions,
						SWT.NONE);
					tableColumnTransDate.setText("Transaction Date");
					tableColumnTransDate.setWidth(100);
				}
			}
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
		
		//nakit hareketi ise izin ver
		if(trans.getTurqCurrentTransactionType().getCurrentTransactionTypesId().intValue()==4){
		new CUrUITransactionUpdateDialog(this.getShell(),SWT.NULL,trans).open();
		search();
		}
		else{
			MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
			msg.setMessage("Only Cash Transactions can be edited!");
			msg.open();
		}
		}
	}
}
