package com.turquaz.current.ui;

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
			this.setSize(622, 282);
			{
				compSearch = new Composite(this, SWT.NONE);
				GridLayout compSearchLayout = new GridLayout();
				GridData compSearchLData = new GridData();
				compSearchLData.grabExcessHorizontalSpace = true;
				compSearchLData.horizontalAlignment = GridData.FILL;
				compSearchLData.heightHint = 72;
				compSearch.setLayoutData(compSearchLData);
				compSearchLayout.makeColumnsEqualWidth = true;
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
					txtCurrentCardLData.widthHint = 153;
					txtCurrentCardLData.heightHint = 17;
					txtCurrentCardLData.horizontalSpan = 3;
					txtCurrentCard.setLayoutData(txtCurrentCardLData);
					
				}
				{
					lblStartDate = new CLabel(compSearch, SWT.NONE);
					lblStartDate.setText(Messages.getString("CurUICurrentCardAbstract.1")); //$NON-NLS-1$
					GridData lblStartDateLData = new GridData();
					lblStartDateLData.widthHint = 142;
					lblStartDateLData.heightHint = 18;
					lblStartDate.setLayoutData(lblStartDateLData);
				}
				{
					datePickerStartDate = new DatePicker(compSearch, SWT.NONE);
				}
				{
					lblEndDate = new CLabel(compSearch, SWT.NONE);
					lblEndDate.setText(Messages.getString("CurUICurrentCardAbstract.2")); //$NON-NLS-1$
					GridData lblEndDateLData = new GridData();
					lblEndDateLData.widthHint = 144;
					lblEndDateLData.heightHint = 22;
					lblEndDate.setLayoutData(lblEndDateLData);
				}
				{
					datePickerEndDate = new DatePicker(compSearch, SWT.NONE);
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
						tableColumnTransGroup.setWidth(114);
					}
					{
						tableColumnDocumentNo = new TableColumn(
							tableCurrentTransactions,
							SWT.NONE);
						tableColumnDocumentNo.setText("Belge No");
						tableColumnDocumentNo.setWidth(120);
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
			currentCard=(TurqCurrentCard)txtCurrentCard.getData();
			tableCurrentTransactions.removeAll();
			Date startDate=datePickerStartDate.getDate();
			Date endDate=datePickerEndDate.getDate();
		
			List results =BLsearch.getCurrentTransactions(currentCard, startDate, endDate);
		
			TurqCurrentTransaction transaction;
			TableItem item;
			TurkishCurrencyFormat cf=new TurkishCurrencyFormat();
			for(int i=0;i<results.size();i++)
			{
		
				transaction = (TurqCurrentTransaction)results.get(i);
				item = new TableItem(tableCurrentTransactions,SWT.NULL);
				item.setData(transaction);
				item.setText(new String[]{DatePicker.formatter.format(transaction.getTransactionsDate()),
		        				  transaction.getTurqCurrentTransactionType().getTransactionTypeName(),
								  transaction.getTransactionsDocumentNo(),
								  cf.format(transaction.getTransactionsTotalDept()),
								  cf.format(transaction.getTransactionsTotalCredit()),
								  
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
			String title="Cari Kart Extresi:\t"+"Kod:"+currentCard.getCardsCurrentCode()+"\tAd:"+currentCard.getCardsName();
			EngBLUtils.printTable(tableCurrentTransactions,title);
		}
	}

}
