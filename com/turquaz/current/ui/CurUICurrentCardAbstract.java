package com.turquaz.current.ui;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import org.eclipse.swt.layout.GridData;

import com.turquaz.current.ui.comp.CurrentPicker;
import com.turquaz.current.Messages;
import com.turquaz.current.bl.CurBLSearchTransaction;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentTransaction;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;

import org.eclipse.swt.custom.CLabel;

import com.turquaz.engine.ui.component.DatePicker;
public class CurUICurrentCardAbstract extends org.eclipse.swt.widgets.Composite implements SearchComposite{
	private Composite compSearch;
	private Table tableCurrentTransactions;
	private TableColumn tableColumnCreditBalance;
	private TableColumn tableColumnDebitBalance;
	private TableColumn tableColumnDefinition;
	private TableColumn tableColumnDocumentNo;
	private CLabel lblCurrentCard;
	private TableColumn tableColumnTransGroup;
	private CurrentPicker txtCurrentCard;
	private DatePicker datePickerEndDate;
	private CLabel lblEndDate;
	private DatePicker datePickerStartDate;
	private CLabel lblStartDate;
	private TableColumn tableColumnCredit;
	private TableColumn tableColumnDebit;
	private TableColumn tableColumnTransDate;
	private Composite compResult;
	private CurBLSearchTransaction BLsearch=new CurBLSearchTransaction();
	private TurqCurrentCard currentCard=null;
	private Calendar cal=Calendar.getInstance();

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
		CurUICurrentCardAbstract inst = new CurUICurrentCardAbstract(shell, SWT.NULL);
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

	public CurUICurrentCardAbstract(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setSize(880, 283);
			{
				compSearch = new Composite(this, SWT.NONE);
				GridLayout compSearchLayout = new GridLayout();
				GridData compSearchLData = new GridData();
				compSearchLData.grabExcessHorizontalSpace = true;
				compSearchLData.horizontalAlignment = GridData.FILL;
				compSearchLData.heightHint = 72;
				compSearch.setLayoutData(compSearchLData);
				compSearchLayout.numColumns = 4;
				compSearch.setLayout(compSearchLayout);
				{
					lblCurrentCard = new CLabel(compSearch, SWT.NONE);
					lblCurrentCard.setText(Messages.getString("CurUICurrentCardAbstract.0")); //$NON-NLS-1$
					GridData lblCurrentCardLData = new GridData();
					lblCurrentCardLData.widthHint = 120;
					lblCurrentCardLData.heightHint = 18;
					lblCurrentCard.setLayoutData(lblCurrentCardLData);
				}
				{
					txtCurrentCard = new CurrentPicker(compSearch, SWT.NONE);
					GridData txtCurrentCardLData = new GridData();
					txtCurrentCardLData.widthHint = 237;
					txtCurrentCardLData.heightHint = 15;
					txtCurrentCardLData.horizontalSpan = 3;
					txtCurrentCard.setLayoutData(txtCurrentCardLData);
					
				}
				{
					lblStartDate = new CLabel(compSearch, SWT.NONE);
					lblStartDate.setText(Messages.getString("CurUICurrentCardAbstract.1")); //$NON-NLS-1$
					GridData lblStartDateLData = new GridData();
					lblStartDateLData.widthHint = 96;
					lblStartDateLData.heightHint = 18;
					lblStartDate.setLayoutData(lblStartDateLData);
				}
				{
					datePickerStartDate = new DatePicker(compSearch, SWT.NONE);
					GridData datePickerStartDateLData = new GridData();
					datePickerStartDateLData.widthHint = 103;
					datePickerStartDateLData.heightHint = 23;
					datePickerStartDate.setLayoutData(datePickerStartDateLData);
				}
				{
					lblEndDate = new CLabel(compSearch, SWT.NONE);
					lblEndDate.setText(Messages.getString("CurUICurrentCardAbstract.2")); //$NON-NLS-1$
					GridData lblEndDateLData = new GridData();
					lblEndDateLData.widthHint = 77;
					lblEndDateLData.heightHint = 20;
					lblEndDate.setLayoutData(lblEndDateLData);
				}
				{
					datePickerEndDate = new DatePicker(compSearch, SWT.NONE);
					GridData datePickerEndDateLData = new GridData();
					datePickerEndDateLData.widthHint = 103;
					datePickerEndDateLData.heightHint = 24;
					datePickerEndDate.setLayoutData(datePickerEndDateLData);
				}
				}
			
			{
				compResult = new Composite(this, SWT.NONE);
				GridLayout compResultLayout2 = new GridLayout();
				GridData compResultLData = new GridData();
				compResultLData.grabExcessVerticalSpace = true;
				compResultLData.horizontalAlignment = GridData.FILL;
				compResultLData.verticalAlignment = GridData.FILL;
				compResult.setLayoutData(compResultLData);
				compResultLayout2.makeColumnsEqualWidth = true;
				compResult.setLayout(compResultLayout2);
				{
					tableCurrentTransactions = new Table(compResult, SWT.FULL_SELECTION);
					tableCurrentTransactions.setHeaderVisible(true);
					tableCurrentTransactions.setLinesVisible(true);
					GridData tableCurrentTransactionsLData = new GridData();
					tableCurrentTransactionsLData.verticalAlignment = GridData.FILL;
					tableCurrentTransactionsLData.horizontalAlignment = GridData.FILL;
					tableCurrentTransactionsLData.grabExcessHorizontalSpace = true;
					tableCurrentTransactionsLData.grabExcessVerticalSpace = true;
					tableCurrentTransactions.setLayoutData(tableCurrentTransactionsLData);
					{
						tableColumnTransDate = new TableColumn(
							tableCurrentTransactions,
							SWT.NONE);
						tableColumnTransDate.setText(Messages
							.getString("CurUITransactionSearch.9"));//$NON-NLS-1$
						tableColumnTransDate.setWidth(100);
					}
					{
						tableColumnTransGroup = new TableColumn(
							tableCurrentTransactions,
							SWT.NONE);
						tableColumnTransGroup.setText(Messages
							.getString("CurUITransactionSearch.6"));//$NON-NLS-1$
						tableColumnTransGroup.setWidth(103);
					}
					{
						tableColumnDocumentNo = new TableColumn(
							tableCurrentTransactions,
							SWT.NONE);
						tableColumnDocumentNo.setText(Messages.getString("CurUICurrentCardAbstract.4")); //$NON-NLS-1$
						tableColumnDocumentNo.setWidth(89);
					}
                    {
                        tableColumnDefinition = new TableColumn(
                            tableCurrentTransactions,
                            SWT.NONE);
                        tableColumnDefinition.setText(Messages.getString("CurUICurrentCardAbstract.5")); //$NON-NLS-1$
                        tableColumnDefinition.setWidth(156);
                    }
					{
						tableColumnDebit = new TableColumn(
							tableCurrentTransactions,
							SWT.RIGHT);
						tableColumnDebit.setText(Messages
							.getString("CurUITransactionSearch.7"));//$NON-NLS-1$
						tableColumnDebit.setWidth(106);
					}
					{
						tableColumnCredit = new TableColumn(
							tableCurrentTransactions,
							SWT.RIGHT);
						tableColumnCredit.setText(Messages
							.getString("CurUITransactionSearch.8"));//$NON-NLS-1$
						tableColumnCredit.setWidth(101);
					}
                    {
                        tableColumnDebitBalance = new TableColumn(tableCurrentTransactions, SWT.RIGHT);
                        tableColumnDebitBalance.setText(Messages.getString("CurUICurrentCardAbstract.6")); //$NON-NLS-1$
                        tableColumnDebitBalance.setWidth(100);
                    }
                    {
                        tableColumnCreditBalance = new TableColumn(tableCurrentTransactions, SWT.RIGHT);
                        tableColumnCreditBalance.setText(Messages.getString("CurUICurrentCardAbstract.7")); //$NON-NLS-1$
                        tableColumnCreditBalance.setWidth(100);
                    }
				}
			}
			postInitGui();
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void postInitGui(){
	    
		datePickerStartDate.setDate(new Date(cal.getTime().getYear(),0,1));

	}
	
	public void exportToExcel()
	{
		EngBLUtils.Export2Excel(tableCurrentTransactions);
	}
	
	public void delete()
	{
		
	}
	
	public void search()
	{
		try
		{
			MessageBox msg=new MessageBox(this.getShell(),SWT.NULL);
			if (txtCurrentCard.getData()==null)
			{
				msg.setMessage(Messages.getString("CurUICurrentCardAbstract.3")); //$NON-NLS-1$
				msg.open();
				return;			
			}
			
			

			TurkishCurrencyFormat cf=new TurkishCurrencyFormat();
			
			currentCard=(TurqCurrentCard)txtCurrentCard.getData();
			tableCurrentTransactions.removeAll();
			Date startDate=datePickerStartDate.getDate();
			Date endDate=datePickerEndDate.getDate();
		
			
			
			List balances = BLsearch.getCurrentBalances(currentCard,startDate);
			
			TableItem item;
			
			BigDecimal balance = new BigDecimal(0);
			BigDecimal totalDept = new BigDecimal(0);
			BigDecimal totalCredit = new BigDecimal(0);
			BigDecimal balanceCredit = new BigDecimal(0);
			BigDecimal balanceDept = new BigDecimal(0);
			
			if(balances.size()>0){
			    item = new TableItem(tableCurrentTransactions,SWT.NULL);
			    
			    if(((Object[])balances.get(0))[0]!=null){
			        
			        totalDept =(BigDecimal)((Object[])balances.get(0))[0];
			        balance = balance.subtract(totalDept);
			    }
			    
			    if(((Object[])balances.get(0))[1]!=null){
			        
			        totalCredit =(BigDecimal)((Object[])balances.get(0))[1];
			        balance.add(totalCredit);
			    }
			         		
			    item.setText(new String[]{
			                    "", //$NON-NLS-1$
			                    "", //$NON-NLS-1$
			                    "", //$NON-NLS-1$
			                    Messages.getString("CurUICurrentCardAbstract.11"), //$NON-NLS-1$
			                    cf.format(totalDept),
			                    cf.format(totalCredit),
			                    (balance.compareTo(new BigDecimal(0))<0) ? cf.format(balance.multiply(new BigDecimal(-1))) : "", //$NON-NLS-1$
			                    (balance.compareTo(new BigDecimal(0))>0) ? cf.format(balance): ""  //$NON-NLS-1$
			    });
			    
			    
			    
			}
			else{
			    item = new TableItem(tableCurrentTransactions,SWT.NULL);
			    item.setText(new String[]{
	                    "", //$NON-NLS-1$
	                    "", //$NON-NLS-1$
	                    "", //$NON-NLS-1$
	                    "", //$NON-NLS-1$
	                    "0,00", //$NON-NLS-1$
	                    "0,00", //$NON-NLS-1$
	                    "0,00", //$NON-NLS-1$
	                    "0,00" //$NON-NLS-1$
	                    });
			}
			
			
			
			
			List results =BLsearch.getCurrentTransactions(currentCard, startDate, endDate);
		
			TurqCurrentTransaction transaction;
			
			for(int i=0;i<results.size();i++)
			{
			    transaction = (TurqCurrentTransaction)results.get(i);
			    
			    balance = balance.subtract(transaction.getTransactionsTotalDept());
				balance = balance.add(transaction.getTransactionsTotalCredit());
				item = new TableItem(tableCurrentTransactions,SWT.NULL);
				item.setData(transaction);
				item.setText(new String[]{DatePicker.formatter.format(transaction.getTransactionsDate()),
		        				  transaction.getTurqCurrentTransactionType().getTransactionTypeName(),
								  transaction.getTransactionsDocumentNo(),
								  transaction.getTransactionsDefinition(),
								  cf.format(transaction.getTransactionsTotalDept()),
								  cf.format(transaction.getTransactionsTotalCredit()),
								  (balance.compareTo(new BigDecimal(0))<0) ? cf.format(balance.multiply(new BigDecimal(-1))) : "", //$NON-NLS-1$
						          (balance.compareTo(new BigDecimal(0))>0) ? cf.format(balance): ""  //$NON-NLS-1$
						  
									});
			}
			
		
		}
		
		catch(Exception ex)
		{
		   
		    
			MessageBox msg=new MessageBox(this.getShell(),SWT.NULL);
			ex.printStackTrace();
			msg.setMessage(ex.getMessage());
			msg.open();
			
		}
		
		
	}
	
	public void printTable()
	{
		if (currentCard!=null)
		{
			String title=Messages.getString("CurUICurrentCardAbstract.20")+Messages.getString("CurUICurrentCardAbstract.21")+currentCard.getCardsCurrentCode()+Messages.getString("CurUICurrentCardAbstract.22")+currentCard.getCardsName(); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			EngBLUtils.printTable(tableCurrentTransactions,title);
		}
	}

}
