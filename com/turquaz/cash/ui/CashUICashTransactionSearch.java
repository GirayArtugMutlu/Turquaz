package com.turquaz.cash.ui;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.eclipse.jface.contentassist.TextContentAssistSubjectAdapter;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;

import com.turquaz.cash.Messages;
import com.turquaz.cash.bl.CashBLCashTransactionSearch;
import com.turquaz.engine.bl.EngBLCashCards;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqCashTransaction;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.contentassist.TurquazContentAssistant;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.VerifyKeyListener;
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
                    lblCashCard.setText(Messages.getString("CashUICashTransactionSearch.0")); //$NON-NLS-1$
                    GridData lblCashCardLData = new GridData();
                    lblCashCardLData.widthHint = 59;
                    lblCashCardLData.heightHint = 18;
                    lblCashCard.setLayoutData(lblCashCardLData);
                }
                {
                    txtCashCard = new Text(compSearchPanel, SWT.NONE);
                    GridData txtCashCardLData = new GridData();
                    txtCashCardLData.widthHint = 118;
                    txtCashCardLData.heightHint = 16;
                    txtCashCard.setLayoutData(txtCashCardLData);
                    txtCashCard
    				.addModifyListener(new ModifyListener() {
    				public void modifyText(ModifyEvent evt) {
    					try {
    						txtCashCard
    							.setData(EngBLCashCards
    								.getCard(txtCashCard
    									.getText().trim()));
    					} catch (Exception ex) {
    						ex.printStackTrace();
    					}

    				}
    				});
                }
                {
                    lblStartDate = new CLabel(compSearchPanel, SWT.NONE);
                    lblStartDate.setText(Messages.getString("CashUICashTransactionSearch.1")); //$NON-NLS-1$
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
                    lblEndDate.setText(Messages.getString("CashUICashTransactionSearch.2")); //$NON-NLS-1$
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
                tableCashTransactions.addMouseListener(new MouseAdapter() {
                    public void mouseDoubleClick(MouseEvent evt) {
                        
                    tableMouseDoubleClick();
                    }
                });
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
                    tableColumnDate.setText(Messages.getString("CashUICashTransactionSearch.3")); //$NON-NLS-1$
                    tableColumnDate.setWidth(95);
                }
                {
                    tableColumnCashCard = new TableColumn(
                        tableCashTransactions,
                        SWT.NONE);
                    tableColumnCashCard.setText(Messages.getString("CashUICashTransactionSearch.4")); //$NON-NLS-1$
                    tableColumnCashCard.setWidth(100);
                }
                {
                    tableColumnType = new TableColumn(
                        tableCashTransactions,
                        SWT.NONE);
                    tableColumnType.setText(Messages.getString("CashUICashTransactionSearch.5")); //$NON-NLS-1$
                    tableColumnType.setWidth(95);
                }
                {
                    tableColumnTotal = new TableColumn(tableCashTransactions, SWT.RIGHT);
                    tableColumnTotal.setWidth(103);
                    tableColumnTotal.setText(Messages.getString("CashUICashTransactionSearch.6")); //$NON-NLS-1$
                }
            }
            postInitGUI();
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void postInitGUI(){
	    
//		  content assistant
		TextContentAssistSubjectAdapter adapter = new TextContentAssistSubjectAdapter(
				txtCashCard);
		final TurquazContentAssistant assistant = new TurquazContentAssistant(
				adapter, EngBLCommon.CONTENT_ASSIST_CASH);
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
	           
	            tableCashTransactions.removeAll();
	            
	          List list = blSearch.searchCashTransactions(null,datePickerStart.getDate(),datePickerEnd.getDate());	
	          
	          Object[] row ;
	          TableItem item;
	          BigDecimal deptAmount = new BigDecimal(0);
	          BigDecimal creditAmount = new BigDecimal(0);
	          BigDecimal amount;
	          String cardName;
	          Date transDate = null;
	          String type;
	          Integer id;
	          for(int i = 0;i<list.size();i++){
	              
	              row = (Object[])list.get(i);
	              item = new TableItem(tableCashTransactions,SWT.NULL);
	              id = (Integer)row[0];
	              item.setData(id);
	              
	              
	              cardName = row[1].toString();
	              type = row[2].toString();
	              
	              if(row[3]!=null){
	                  deptAmount = (BigDecimal)row[3];
	                  
	              }
	              if(row[4]!=null){
	                  creditAmount =(BigDecimal) row[4];
	              }
	              
	              transDate = (Date)row[5];
	              
	              amount = creditAmount;
	              if(deptAmount.compareTo(new BigDecimal(0))==1){
	                  amount = deptAmount;
	                  
	              }
	              
	              TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
	              item.setText(new String[]{
	                      		
	                      DatePicker.formatter.format(transDate),
	                      cardName,
	                      type,
	                      cf.format(amount)
	                      
	                      
	              });
	              
	              
	              
	          }
	          
	          
	          
	          
	          
	          
	          
	          
	          }
	        catch(Exception ex){
	            ex.printStackTrace();
	        }
	    }
	public void tableMouseDoubleClick(){
	
	    try{
	    
	        TableItem selection[] = tableCashTransactions.getSelection();
	        
	        if(selection.length>0){
	        
	            TableItem item = selection[0];
	           
	            Integer id = (Integer)item.getData();
	            
	            TurqCashTransaction cashTrans = blSearch.initializeCashTransaction(id);
	            
	            
	            if(cashTrans.getTurqEngineSequence().getTurqModule().getModulesId().intValue()!=EngBLCommon.MODULE_CASH){
	                
	                
	                return;
	            }
	            
	            
	            if(cashTrans.getTurqCashTransactionType().getCashTransactionTypesId().intValue()==EngBLCommon.CASH_CURRENT_COLLECT)
	            {
	                new CashUICashCollectTransactionUpdate(this.getShell(),SWT.NULL,cashTrans).open();
	                
	            }
	            else if(cashTrans.getTurqCashTransactionType().getCashTransactionTypesId().intValue()==EngBLCommon.CASH_CURRENT_PAYMENT){
	                
	                new CashUICashPaymentTransactionUpdate(this.getShell(),SWT.NULL,cashTrans).open();
	                
	                
	            }
	            
	            search();
	            
	            
	            
	        }    
	        
	        
	        
	        
	        
	    }
	    catch(Exception ex){
	        
	        ex.printStackTrace();
	    
	    }
	}

}
