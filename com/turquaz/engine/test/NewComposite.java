package com.turquaz.engine.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;
import com.turquaz.admin.bl.AdmBLCompanyInfo;
import com.turquaz.engine.dal.TurqCompany;
import com.turquaz.engine.ui.EngUITableProperties;
import com.turquaz.engine.ui.component.DateMask;
import com.turquaz.engine.ui.viewers.TableRowList;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class NewComposite extends org.eclipse.swt.widgets.Composite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	/**
	 * 0 - Stok Kodu 1 - Stok Cinsi //cant modify 2 - Miktar 3 - Birim 4 - Temel Birim Miktar? //cant modify 5 - Tamel Birimi //cant modify
	 * 6 - Birim Fiyat? 7 - Toplam Tutar //cant modify 8 - Kdv % 9 - Kdv Tutari //cantModify 10 - Ötv % 11 - Ötv Tutari //cant Modify 12 -
	 * Sat?r Toplam? //cant Modify
	 */
	//	 Set the table column property names
	private final String INVENTORY_CODE = "Stok Kodu";
	private final String INVENTORY_NAME = "Stok Cinsi";
	private final String TRANS_AMOUNT = "Miktar";
	private final String UNIT = "Birimi";
	private final String TRANS_AMOUNT_IN_BASE_UNIT = "Temel Birimdeki Miktar?";
	private final String BASE_UNIT = "Temel Birim";
	private final String UNIT_PRICE = "Birim Fiyat?";
	private final String TOTAL_PRICE = "Toplam Tutar";
	private final String VAT_PERCENT = "KDV %";
	private TableViewer tableViewer1;
	private final String VAT_TOTAL = "KDV Tutar?";
	private final String SPECIAL_VAT_PERCENT = "ÖTV %";
	private final String SPECIAL_VAT_TOTAL = "ÖTV Tutar?";
	private final String ROW_TOTAL = "Sat?r Toplam?";
	int last_row_index = 0;
	DateMask dateMask = new DateMask();
	// Set column names
	private String[] columnNames = new String[]{INVENTORY_CODE, INVENTORY_NAME, TRANS_AMOUNT, UNIT, TRANS_AMOUNT_IN_BASE_UNIT, BASE_UNIT,
			UNIT_PRICE, TOTAL_PRICE, VAT_PERCENT, VAT_TOTAL, SPECIAL_VAT_PERCENT, SPECIAL_VAT_TOTAL, ROW_TOTAL};
	private List columnList = new ArrayList();
	TableRowList rowList = new TableRowList();

	/**
	 * Auto-generated main method to display this org.eclipse.swt.widgets.Composite inside a new Shell.
	 */
	public static void main(String[] args)
	{
		showGUI();
	}

	/**
	 * Auto-generated method to display this org.eclipse.swt.widgets.Composite inside a new Shell.
	 */
	public static void showGUI()
	{
		System.setProperty("company", "0");
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		NewComposite inst = new NewComposite(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if (size.x == 0 && size.y == 0)
		{
			inst.pack();
			shell.pack();
		}
		else
		{
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			int MENU_HEIGHT = 22;
			if (shell.getMenuBar() != null)
				shellBounds.height -= MENU_HEIGHT;
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed())
		{
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public NewComposite(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
		try{
		Map map = EngUITableProperties.getTableWidthMap("tableInvTransactions"); 
		Iterator it =map.keySet().iterator();
			while(it.hasNext())
			{
			Object key = it.next();
			System.out.println(key +" : "+map.get(key));	
			}
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	private void initGUI()
	{
		try
		{
			TurqCompany comp = AdmBLCompanyInfo.getCompany();
			Calendar cal = Calendar.getInstance();
			cal.setTime(comp.getUpdateDate());
			dateMask.setMask("##/##/####");
			this.setLayout(new GridLayout());
			this.setSize(1411, 311);
			//START >>  tableViewer1
			tableViewer1 = new TableViewer(this, SWT.NONE);
			GridData tableViewer1LData = new GridData();
			((Table)tableViewer1.getControl()).setLinesVisible(true);
			((Table)tableViewer1.getControl()).setHeaderVisible(true);
			tableViewer1LData.widthHint = 453;
			tableViewer1LData.heightHint = 280;
			tableViewer1.getControl().setLayoutData(tableViewer1LData);
		    TableColumn column = new TableColumn(tableViewer1.getTable(),SWT.NONE);
			column.setWidth(100);
			
			TableItem item = new TableItem(tableViewer1.getTable(),SWT.NONE);
			item.setText("ggdgdffadfdsa");
			
			item = new TableItem(tableViewer1.getTable(),SWT.NONE);
			item.setText("cacacadcadcadc");
			
			item = new TableItem(tableViewer1.getTable(),SWT.NONE);
			item.setText("ddfdfadfadfad");
			
		    //END <<  tableViewer1
			//          create a TableCursor to navigate around the table
			this.layout();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	

	
}