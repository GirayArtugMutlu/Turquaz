package com.turquaz.engine.test;

import java.util.ArrayList;
import java.util.List;


import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.PopupList;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;

import com.turquaz.engine.ui.editors.CurrencyCellEditor;
import com.turquaz.engine.ui.editors.InventoryCellEditor;
import com.turquaz.engine.ui.editors.NumericCellEditor;
import com.turquaz.engine.ui.viewers.TableRowList;
import com.turquaz.engine.ui.viewers.TurquazCellModifier;
import com.turquaz.engine.ui.viewers.TurquazContentProvider;
import com.turquaz.engine.ui.viewers.TurquazLabelProvider;
import com.turquaz.inventory.ui.InvUITransactionTableRow;



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
public class NewComposite extends org.eclipse.swt.widgets.Composite {
	private Table table;
	private TableColumn tableColumn12;
	private TableColumn tableColumn11;
	private TableColumn tableColumn10;
	private TableColumn tableColumn9;
	private TableColumn tableColumn8;
	private TableColumn tableColumn7;
	private TableColumn tableColumn6;
	private TableColumn tableColumn5;
	private TableColumn tableColumn;
	private Button button1;
	private TableColumn tableColumn4;
	private TableColumn tableColumn3;
	private TableColumn tableColumn2;
	private TableColumn tableColumn1;
	public TableViewer tableViewer;
	
	/**
     * 0 - Stok Kodu
     * 1 - Stok Cinsi      //cant modify
     * 2 - Miktar
     * 3 - Birim
     * 4 - Temel Birim Miktar? //cant modify
     * 5 - Tamel Birimi        //cant modify  
     * 6 - Birim Fiyat?
     * 7 - Toplam Tutar    //cant modify
     * 8 - Kdv %     
     * 9 - Kdv Tutari      //cantModify
     * 10 - Ötv %
     * 11 - Ötv Tutari      //cant Modify
     * 12 - Sat?r Toplam?  //cant Modify
     */

	//	 Set the table column property names
	private final String INVENTORY_CODE             = "Stok Kodu";
	private final String INVENTORY_NAME   	        = "Stok Cinsi";
	private final String TRANS_AMOUNT               = "Miktar";
	private final String UNIT						= "Birimi";
	private final String TRANS_AMOUNT_IN_BASE_UNIT 	= "Temel Birimdeki Miktar?";
	private final String BASE_UNIT 		            = "Temel Birim";
	private final String UNIT_PRICE					= "Birim Fiyat?";
	private final String TOTAL_PRICE				= "Toplam Tutar";
	private final String VAT_PERCENT				= "KDV %";
	private final String VAT_TOTAL					= "KDV Tutar?";
	private final String SPECIAL_VAT_PERCENT		= "ÖTV %";
	private final String SPECIAL_VAT_TOTAL			= "ÖTV Tutar?";
	private final String ROW_TOTAL 					= "Sat?r Toplam?";
	
	
    TableCursor cursor;
	
	// Set column names
	private String[] columnNames = new String[] { 
			INVENTORY_CODE, 
			INVENTORY_NAME,
			TRANS_AMOUNT,
			UNIT,
			TRANS_AMOUNT_IN_BASE_UNIT,
			BASE_UNIT,
			UNIT_PRICE,
			TOTAL_PRICE,
			VAT_PERCENT,
			VAT_TOTAL,
			SPECIAL_VAT_PERCENT,
			SPECIAL_VAT_TOTAL,
			ROW_TOTAL
			
			};
   private List columnList = new ArrayList();
   TableRowList rowList = new TableRowList();
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
	    
	    System.setProperty("company","0");
	    
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		NewComposite inst = new NewComposite(shell, SWT.NULL);
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

	public NewComposite(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
          
			this.setSize(1407, 291);
            {
                table = new Table(this, SWT.FULL_SELECTION | SWT.HIDE_SELECTION);
                GridData tableLData = new GridData();
                table.addKeyListener(new KeyAdapter() {
                    public void keyReleased(KeyEvent evt) {
                       
                    }
                });
                table.setHeaderVisible(true);
                table.setLinesVisible(true);
                tableLData.grabExcessHorizontalSpace = true;
                tableLData.grabExcessVerticalSpace = true;
                tableLData.horizontalAlignment = GridData.FILL;
                tableLData.verticalAlignment = GridData.FILL;
                table.setLayoutData(tableLData);
                {
                    tableColumn1 = new TableColumn(table, SWT.NONE);
                    tableColumn1.setText(INVENTORY_CODE);
                    tableColumn1.setWidth(100);
                    tableColumn1.addSelectionListener(new SelectionAdapter() {
                        public void widgetSelected(SelectionEvent evt) {
                            //      tableViewer.setSorter(new TurquazTableSorter(0));    
                        }
                    });
                }
                {
                    tableColumn2 = new TableColumn(table, SWT.NONE);
                    tableColumn2.setText(INVENTORY_NAME);
                    tableColumn2.setWidth(103);
                }
                {
                    tableColumn = new TableColumn(table, SWT.NONE);
                    tableColumn.setText(TRANS_AMOUNT);
                    tableColumn.setWidth(106);
                }
                {
                    tableColumn5 = new TableColumn(table, SWT.NONE);
                    tableColumn5.setText(UNIT);
                    tableColumn5.setWidth(100);
                }
                {
                    tableColumn4 = new TableColumn(table, SWT.NONE);
                    tableColumn4.setText(TRANS_AMOUNT_IN_BASE_UNIT);
                    tableColumn4.setWidth(121);
                }
                {
                    tableColumn3 = new TableColumn(table, SWT.NONE);
                    tableColumn3.setText(BASE_UNIT);
                    tableColumn3.setWidth(126);
                }
            }
            {
                button1 = new Button(this, SWT.PUSH | SWT.CENTER);
                button1.setText("button1");
                GridData button1LData = new GridData();
                button1LData.widthHint = 62;
                button1LData.heightHint = 23;
                button1.setLayoutData(button1LData);
                button1.addMouseListener(new MouseAdapter() {
                    public void mouseUp(MouseEvent evt) {
                     
                       InvUITransactionTableRow  row = new InvUITransactionTableRow(rowList,0);
                  // ((ComboBoxCellEditor)tableViewer.getCellEditors()[3]).setItems();
                       
                      
                       rowList.addTask(row);
                       rowList.taskChanged(row);
                        tableViewer.editElement(row,0);
                        
                    
                    }
                });
            }

            createTableViewer();
//          create a TableCursor to navigate around the table
    		 cursor = new TableCursor(table, SWT.NONE);
            {
                tableColumn6 = new TableColumn(table, SWT.NONE);
                tableColumn6.setText(UNIT_PRICE);
                tableColumn6.setWidth(100);
            }
            {
                tableColumn7 = new TableColumn(table, SWT.NONE);
                tableColumn7.setText(TOTAL_PRICE);
                tableColumn7.setWidth(100);
            }
            {
                tableColumn8 = new TableColumn(table, SWT.NONE);
                tableColumn8.setText(VAT_PERCENT);
                tableColumn8.setWidth(100);
            }
            {
                tableColumn9 = new TableColumn(table, SWT.NONE);
                tableColumn9.setText(VAT_TOTAL);
                tableColumn9.setWidth(100);
            }
            {
                tableColumn10 = new TableColumn(table, SWT.NONE);
                tableColumn10.setText(SPECIAL_VAT_PERCENT);
                tableColumn10.setWidth(110);
            }
            {
                tableColumn11 = new TableColumn(table, SWT.NONE);
                tableColumn11.setText(SPECIAL_VAT_TOTAL);
                tableColumn11.setWidth(101);
            }
            {
                tableColumn12 = new TableColumn(table, SWT.NONE);
                tableColumn12.setText(ROW_TOTAL);
                tableColumn12.setWidth(114);
            }
    		 cursor.addSelectionListener(new SelectionAdapter() {
    				// when the TableEditor is over a cell, select the corresponding rowtable
    				public void widgetSelected(SelectionEvent e) {
    	              
    				}
    		
    				// when the user hits "ENTER" in the TableCursor, pop up a text/combo editor 
    				// so that they can change the text of the cell for controlType=="input" || "select1"<br>
    				// if controlType==TableViewerExample.TYPE_CHECKBOX, toogle it
    				public void widgetDefaultSelected(SelectionEvent e) {
    				tableViewer.editElement(cursor.getRow().getData(),cursor.getColumn());
    				
    				
    				}
    			});

    		this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
   public void createTableViewer(){
       columnList.add(INVENTORY_CODE);
       columnList.add(INVENTORY_NAME);
       columnList.add(TRANS_AMOUNT);
       columnList.add(UNIT);
       columnList.add(TRANS_AMOUNT_IN_BASE_UNIT);
       columnList.add(BASE_UNIT);
       columnList.add(UNIT_PRICE);
       columnList.add(TOTAL_PRICE);
       columnList.add(VAT_PERCENT);
       columnList.add(VAT_TOTAL);
       columnList.add(SPECIAL_VAT_PERCENT);
       columnList.add(SPECIAL_VAT_TOTAL);
       columnList.add(ROW_TOTAL);
         
    
       tableViewer = new TableViewer(table);
       tableViewer.setUseHashlookup(true);
       tableViewer.setColumnProperties(columnNames);
       //     Create the cell editors
	   CellEditor[] editors = new CellEditor[columnNames.length];
       editors[0] = new InventoryCellEditor(table); //Stok Kodu
       editors[1] = new TextCellEditor(table);      //Stok Adi
       editors[2] = new NumericCellEditor(table);   // mikatri     
       editors[3] = new ComboBoxCellEditor(table,new String[]{});
       editors[4] = new NumericCellEditor(table);
       editors[5] = new TextCellEditor(table);
       editors[6] = new CurrencyCellEditor(table);
       editors[7] = new CurrencyCellEditor(table);
       editors[8] = new NumericCellEditor(table);
       editors[9] = new CurrencyCellEditor(table);
       editors[10] = new NumericCellEditor(table);
       editors[11] = new CurrencyCellEditor(table);
       editors[12] = new CurrencyCellEditor(table);
    
       // Assign the cell editors to the viewer 
		tableViewer.setCellEditors(editors);
       
		TurquazContentProvider contentProvider = new TurquazContentProvider(tableViewer,rowList);
		
		tableViewer.setCellModifier(new TurquazCellModifier(columnList,contentProvider));    
		tableViewer.setContentProvider(contentProvider);
		tableViewer.setLabelProvider(new TurquazLabelProvider());
		
		tableViewer.setInput(rowList);
		
		
	//	tableViewer.setSorter(new TurquazTableSorter(0));
       
   }

}
