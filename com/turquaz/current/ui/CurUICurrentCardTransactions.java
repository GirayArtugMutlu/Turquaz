package com.turquaz.current.ui;

import java.util.List;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;

import com.turquaz.current.Messages;
import com.turquaz.current.bl.CurBLSearchTransaction;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentTransaction;
import com.turquaz.engine.ui.component.DatePicker;


import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.layout.GridData;
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
public class CurUICurrentCardTransactions extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private TurqCurrentCard currentCard;
	private Table tableCurrentTransactions;
	private TableColumn tableColumnTransGroup;
	private TableColumn tableColumnTransDate;
	private TableColumn tableColumnCredit;
	private TableColumn tableColumnDebit;
	private TableColumn tableColumnCurrentCode;
	private Composite composite1;
	private CurBLSearchTransaction BLSearch;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/

	public CurUICurrentCardTransactions(Shell parent, int style, TurqCurrentCard card) {
		super(parent, style);
		currentCard=card;
	}

	public void open() {
		try {
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

			dialogShell.setLayout(new GridLayout());
			{
				composite1 = new Composite(dialogShell, SWT.NONE);
				GridLayout composite1Layout1 = new GridLayout();
				GridData composite1LData = new GridData();
				composite1LData.grabExcessHorizontalSpace = true;
				composite1LData.grabExcessVerticalSpace = true;
				composite1LData.horizontalAlignment = GridData.FILL;
				composite1LData.verticalAlignment = GridData.FILL;
				composite1.setLayoutData(composite1LData);
				composite1Layout1.makeColumnsEqualWidth = true;
				composite1.setLayout(composite1Layout1);
				{
					tableCurrentTransactions = new Table(composite1, SWT.FULL_SELECTION);
					tableCurrentTransactions.setHeaderVisible(true);
					tableCurrentTransactions.setLinesVisible(true);
					GridData tableCurrentTransactionsLData = new GridData();

					tableCurrentTransactionsLData.verticalAlignment = GridData.FILL;
					tableCurrentTransactionsLData.horizontalAlignment = GridData.FILL;
					tableCurrentTransactionsLData.grabExcessHorizontalSpace = true;
					tableCurrentTransactionsLData.grabExcessVerticalSpace = true;
					tableCurrentTransactions.setLayoutData(tableCurrentTransactionsLData);
					{
						tableColumnCurrentCode = new TableColumn(
							tableCurrentTransactions,
							SWT.NONE);
						tableColumnCurrentCode.setText(Messages
							.getString("CurUITransactionSearch.5"));
						tableColumnCurrentCode.setWidth(107);
					}
					{
						tableColumnTransGroup = new TableColumn(
							tableCurrentTransactions,
							SWT.NONE);
						tableColumnTransGroup.setText(Messages.getString("CurUITransactionSearch.6"));
						tableColumnTransGroup.setWidth(114);
					}
					{
						tableColumnDebit = new TableColumn(
							tableCurrentTransactions,
							SWT.NONE);
						tableColumnDebit.setText(Messages
							.getString("CurUITransactionSearch.7"));
						tableColumnDebit.setWidth(106);
					}
					{
						tableColumnCredit = new TableColumn(
							tableCurrentTransactions,
							SWT.NONE);
						tableColumnCredit.setText(Messages
							.getString("CurUITransactionSearch.8"));
						tableColumnCredit.setWidth(101);
					}
					{
						tableColumnTransDate = new TableColumn(
							tableCurrentTransactions,
							SWT.NONE);
						tableColumnTransDate.setText(Messages
							.getString("CurUITransactionSearch.9"));
						tableColumnTransDate.setWidth(100);
					}
				}
			}
			PostInit();
			
			dialogShell.layout();
			dialogShell.pack();
			dialogShell.setSize(574, 566);
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
	
	public void PostInit()
	{
		try{
		tableCurrentTransactions.removeAll();
		
		List results =BLSearch.getCurrentTransactions(currentCard);
		
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
			/*MessageBox msg=new MessageBox(this.getParent(),SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();*/
		}
	}
}
