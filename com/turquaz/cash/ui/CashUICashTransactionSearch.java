package com.turquaz.cash.ui;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;

import com.turquaz.cash.bl.CashBLCashCardSearch;
import com.turquaz.cash.bl.CashBLCashTransactionSearch;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SearchComposite;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.layout.GridData;
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
public class CashUICashTransactionSearch extends org.eclipse.swt.widgets.Composite implements SearchComposite{
   
	private Composite compSearchPanel;
	private CLabel lblCashCard;
	private CLabel lblEndDate;
	private TableColumn tableColumnTotal;
	private TableColumn tableColumnType;
	private TableColumn tableColumnCashCard;
	private TableColumn tableColumnDate;
	private DatePicker datePickerEnd;
	private DatePicker datePickerStart;
	private CLabel lblStartDate;
	private Text txtCashCard;
	private Table tableCashTransactions;
	CashBLCashTransactionSearch blSearch = new CashBLCashTransactionSearch();

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
		CashUICashTransactionSearch inst = new CashUICashTransactionSearch(shell, SWT.NULL);
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

	public CashUICashTransactionSearch(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setSize(627, 377);
            {
                compSearchPanel = new Composite(this, SWT.NONE);
                GridLayout compSearchPanelLayout = new GridLayout();
                GridData compSearchPanelLData = new GridData();
                compSearchPanelLData.grabExcessHorizontalSpace = true;
                compSearchPanelLData.horizontalAlignment = GridData.FILL;
                compSearchPanelLData.heightHint = 97;
                compSearchPanel.setLayoutData(compSearchPanelLData);
                compSearchPanelLayout.numColumns = 2;
                compSearchPanel.setLayout(compSearchPanelLayout);
                {
                    lblCashCard = new CLabel(compSearchPanel, SWT.NONE);
                    lblCashCard.setText("Kasa Kart?");
                    GridData lblCashCardLData = new GridData();
                    lblCashCardLData.widthHint = 59;
                    lblCashCardLData.heightHint = 18;
                    lblCashCard.setLayoutData(lblCashCardLData);
                }
                {
                    txtCashCard = new Text(compSearchPanel, SWT.NONE);
                    GridData txtCashCardLData = new GridData();
                    txtCashCardLData.widthHint = 115;
                    txtCashCardLData.heightHint = 16;
                    txtCashCard.setLayoutData(txtCashCardLData);
                }
                {
                    lblStartDate = new CLabel(compSearchPanel, SWT.NONE);
                    lblStartDate.setText("Ba?lang?ç Tarihi");
                }
                {
                    datePickerStart = new DatePicker(compSearchPanel, SWT.NONE);
                    GridData datePickerStartLData = new GridData();
                    datePickerStartLData.widthHint = 122;
                    datePickerStartLData.heightHint = 21;
                    datePickerStart.setLayoutData(datePickerStartLData);
                }
                {
                    lblEndDate = new CLabel(compSearchPanel, SWT.NONE);
                    lblEndDate.setText("Biti? Tarihi");
                }
                {
                    datePickerEnd = new DatePicker(compSearchPanel, SWT.NONE);
                    GridData datePickerEndLData = new GridData();
                    datePickerEndLData.widthHint = 125;
                    datePickerEndLData.heightHint = 21;
                    datePickerEnd.setLayoutData(datePickerEndLData);
                }
            }
            {
                tableCashTransactions = new Table(this, SWT.FULL_SELECTION);
                GridData tableCashTransactionsLData = new GridData();
                tableCashTransactions.setHeaderVisible(true);
                tableCashTransactions.setLinesVisible(true);
                tableCashTransactionsLData.grabExcessVerticalSpace = true;
                tableCashTransactionsLData.grabExcessHorizontalSpace = true;
                tableCashTransactionsLData.horizontalAlignment = GridData.FILL;
                tableCashTransactionsLData.verticalAlignment = GridData.FILL;
                tableCashTransactions.setLayoutData(tableCashTransactionsLData);
                {
                    tableColumnDate = new TableColumn(
                        tableCashTransactions,
                        SWT.NONE);
                    tableColumnDate.setText("Tarih");
                    tableColumnDate.setWidth(95);
                }
                {
                    tableColumnCashCard = new TableColumn(
                        tableCashTransactions,
                        SWT.NONE);
                    tableColumnCashCard.setText("Kasa Kart?");
                    tableColumnCashCard.setWidth(100);
                }
                {
                    tableColumnType = new TableColumn(
                        tableCashTransactions,
                        SWT.NONE);
                    tableColumnType.setText("Tipi");
                    tableColumnType.setWidth(89);
                }
                {
                    tableColumnTotal = new TableColumn(tableCashTransactions, SWT.RIGHT);
                    tableColumnTotal.setWidth(100);
                    tableColumnTotal.setText("Tutar?");
                }
            }
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	 public void delete() {
	        // TODO Auto-generated method stub

	    }
	    public void exportToExcel() {
	        // TODO Auto-generated method stub

	    }
	    public void printTable() {
	        // TODO Auto-generated method stub

	    }
	    public void search() {
	        try{
	            
	            blSearch.searchCashTransactions(null,datePickerStart.getDate(),datePickerEnd.getDate());	
	            
	          }
	        catch(Exception ex){
	            ex.printStackTrace();
	        }
	    }
	

}
