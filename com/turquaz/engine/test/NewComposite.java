package com.turquaz.engine.test;

import java.util.ArrayList;
import java.util.List;


import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
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

import com.turquaz.engine.ui.editors.AccountingCellEditor;
import com.turquaz.engine.ui.editors.CurrencyCellEditor;
import com.turquaz.engine.ui.viewers.TableRowList;
import com.turquaz.engine.ui.viewers.TurquazCellModifier;
import com.turquaz.engine.ui.viewers.TurquazContentProvider;
import com.turquaz.engine.ui.viewers.TurquazLabelProvider;



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
	private TableColumn tableColumn;
	private Button button1;
	private TableColumn tableColumn4;
	private TableColumn tableColumn3;
	private TableColumn tableColumn2;
	private TableColumn tableColumn1;
	public TableViewer tableViewer;

	//	 Set the table column property names
	private final String ACCOUNT_CODE 		= "Hesap Kodu";
	private final String ACCOUNT_NAME   	= "Hesap Ad?";
	private final String DEFINITION         = "Aç?klama";
	private final String DEPT     			= "Borç";
	private final String CREDIT 		    = "Alacak";
	
    TableCursor cursor;
	
	// Set column names
	private String[] columnNames = new String[] { 
			ACCOUNT_CODE, 
			ACCOUNT_NAME,
			DEFINITION,
			DEPT,
			CREDIT
			
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
          
			this.setSize(581, 275);
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
                    tableColumn1.setText(ACCOUNT_CODE);
                    tableColumn1.setWidth(100);
                    tableColumn1.addSelectionListener(new SelectionAdapter() {
                        public void widgetSelected(SelectionEvent evt) {
                            //      tableViewer.setSorter(new TurquazTableSorter(0));    
                        }
                    });
                }
                {
                    tableColumn2 = new TableColumn(table, SWT.NONE);
                    tableColumn2.setText(ACCOUNT_NAME);
                    tableColumn2.setWidth(103);
                }
                {
                    tableColumn = new TableColumn(table, SWT.NONE);
                    tableColumn.setText(DEFINITION);
                    tableColumn.setWidth(106);
                }
                {
                    tableColumn4 = new TableColumn(table, SWT.NONE);
                    tableColumn4.setText(DEPT);
                    tableColumn4.setWidth(118);
                }
                {
                    tableColumn3 = new TableColumn(table, SWT.NONE);
                    tableColumn3.setText(CREDIT);
                    tableColumn3.setWidth(126);
                }
            }
            {
                button1 = new Button(this, SWT.PUSH | SWT.CENTER);
                button1.setText("button1");
                button1.addMouseListener(new MouseAdapter() {
                    public void mouseUp(MouseEvent evt) {
                     
                        TableRowImpl row = new TableRowImpl(rowList);
                        rowList.addTask(row);
                        tableViewer.editElement(row,0);
                    
                    }
                });
            }

            createTableViewer();
//          create a TableCursor to navigate around the table
    		 cursor = new TableCursor(table, SWT.NONE);
    		 cursor.addSelectionListener(new SelectionAdapter() {
    				// when the TableEditor is over a cell, select the corresponding rowtable
    				public void widgetSelected(SelectionEvent e) {
    	              
    				}
    		
    				// when the user hits "ENTER" in the TableCursor, pop up a text/combo editor 
    				// so that they can change the text of the cell for controlType=="input" || "select1"<br>
    				// if controlType==TableViewerExample.TYPE_CHECKBOX, toogle it
    				public void widgetDefaultSelected(SelectionEvent e) {
    				tableViewer.editElement(cursor.getRow().getData(),cursor.getColumn());
    				if(table.getItemCount()>2){
    				    if(table.getItem(0).getData().equals(table.getItem(1).getData())){
    				        
    				    }
    				    
    				}
    				
    				}
    			});

    		this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
   public void createTableViewer(){
       columnList.add(ACCOUNT_CODE);
       columnList.add(ACCOUNT_NAME);
       columnList.add(DEFINITION);
       columnList.add(DEPT);
       columnList.add(CREDIT);
    
       tableViewer = new TableViewer(table);
       tableViewer.setUseHashlookup(true);
       tableViewer.setColumnProperties(columnNames);
       //     Create the cell editors
	   CellEditor[] editors = new CellEditor[columnNames.length];
       editors[0] = new AccountingCellEditor(table);
       editors[1] = new TextCellEditor(table);
       editors[2] = new TextCellEditor(table);
       editors[3] = new CurrencyCellEditor(table);
       editors[4] = new CurrencyCellEditor(table);
    
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
