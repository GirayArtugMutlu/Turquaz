package com.turquaz.inventory.ui;



import java.util.List;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.SWT;

import com.turquaz.engine.dal.TurqInventoryPrice;
import com.turquaz.engine.dal.TurqInventoryWarehous;
import com.turquaz.engine.ui.component.SecureComposite;
import com.turquaz.inventory.bl.InvBLWarehouseSearch;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class InvUIWarehouseSearch extends SecureComposite {

	private TableColumn tableColumnDescription;
	private TableColumn tableColumnTelephone;
	private TableColumn tableColumnWarehouseCity;
	private TableColumn tableColumnName;
	private Table tableInvUIWarehouses;
	private Text txtCity;
	private CLabel lblWarehouseCity;
	private Text txtWarehouseName;
	private CLabel lblWarehouseName;
	private Composite composite1;
	InvBLWarehouseSearch whBLsearch = new InvBLWarehouseSearch();
	
		public InvUIWarehouseSearch(Composite parent, int style) {
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
			lblWarehouseName = new CLabel(composite1,SWT.NULL);
			txtWarehouseName = new Text(composite1,SWT.BORDER);
			lblWarehouseCity = new CLabel(composite1,SWT.NULL);
			txtCity = new Text(composite1,SWT.BORDER);
			tableInvUIWarehouses = new Table(this,SWT.FULL_SELECTION);
			tableColumnName = new TableColumn(tableInvUIWarehouses,SWT.NULL);
			tableColumnWarehouseCity = new TableColumn(tableInvUIWarehouses,SWT.NULL);
			tableColumnTelephone = new TableColumn(tableInvUIWarehouses,SWT.NULL);
			tableColumnDescription = new TableColumn(tableInvUIWarehouses,SWT.NULL);
	
			this.setSize(new org.eclipse.swt.graphics.Point(618,381));
	
			GridData composite1LData = new GridData();
			composite1LData.verticalAlignment = GridData.CENTER;
			composite1LData.horizontalAlignment = GridData.FILL;
			composite1LData.widthHint = -1;
			composite1LData.heightHint = 92;
			composite1LData.horizontalIndent = 0;
			composite1LData.horizontalSpan = 1;
			composite1LData.verticalSpan = 1;
			composite1LData.grabExcessHorizontalSpace = true;
			composite1LData.grabExcessVerticalSpace = false;
			composite1.setLayoutData(composite1LData);
			composite1.setSize(new org.eclipse.swt.graphics.Point(608,92));
			final Color composite1background = new Color(Display.getDefault(),255,255,255);
			composite1.setBackground(composite1background);
	
			GridData lblWarehouseNameLData = new GridData();
			lblWarehouseNameLData.widthHint = 105;
			lblWarehouseNameLData.heightHint = 20;
			lblWarehouseName.setLayoutData(lblWarehouseNameLData);
			lblWarehouseName.setText("Warehouse Name");
			lblWarehouseName.setSize(new org.eclipse.swt.graphics.Point(105,20));
	
			GridData txtWarehouseNameLData = new GridData();
			txtWarehouseNameLData.widthHint = 117;
			txtWarehouseNameLData.heightHint = 15;
			txtWarehouseName.setLayoutData(txtWarehouseNameLData);
			txtWarehouseName.setSize(new org.eclipse.swt.graphics.Point(117,15));
	
			lblWarehouseCity.setText("City");
	
			GridData txtCityLData = new GridData();
			txtCityLData.widthHint = 114;
			txtCityLData.heightHint = 16;
			txtCity.setLayoutData(txtCityLData);
			txtCity.setSize(new org.eclipse.swt.graphics.Point(114,16));
			GridLayout composite1Layout = new GridLayout(2, true);
			composite1.setLayout(composite1Layout);
			composite1Layout.marginWidth = 5;
			composite1Layout.marginHeight = 5;
			composite1Layout.numColumns = 2;
			composite1Layout.makeColumnsEqualWidth = false;
			composite1Layout.horizontalSpacing = 5;
			composite1Layout.verticalSpacing = 5;
			composite1.layout();
	
			GridData tableInvUIWarehousesLData = new GridData();
			tableInvUIWarehousesLData.verticalAlignment = GridData.FILL;
			tableInvUIWarehousesLData.horizontalAlignment = GridData.FILL;
			tableInvUIWarehousesLData.widthHint = -1;
			tableInvUIWarehousesLData.heightHint = -1;
			tableInvUIWarehousesLData.horizontalIndent = 0;
			tableInvUIWarehousesLData.horizontalSpan = 1;
			tableInvUIWarehousesLData.verticalSpan = 1;
			tableInvUIWarehousesLData.grabExcessHorizontalSpace = true;
			tableInvUIWarehousesLData.grabExcessVerticalSpace = true;
			tableInvUIWarehouses.setLayoutData(tableInvUIWarehousesLData);
			tableInvUIWarehouses.setHeaderVisible(true);
			tableInvUIWarehouses.setLinesVisible(true);
			tableInvUIWarehouses.setSize(new org.eclipse.swt.graphics.Point(592,258));
	
			tableColumnName.setText("Warehouse Name");
			tableColumnName.setWidth(161);
	
			tableColumnWarehouseCity.setText("City");
			tableColumnWarehouseCity.setWidth(100);
	
			tableColumnTelephone.setText("Telephone");
			tableColumnTelephone.setWidth(100);
	
			tableColumnDescription.setText("Description");
			tableColumnDescription.setWidth(150);
			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = true;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 5;
			this.layout();
			addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					composite1background.dispose();
				}
			});
	
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
	 
		
	
	}
		
	public void save(){
	
	}
	public void search(){
	try{
	
	tableInvUIWarehouses.removeAll();
	TableItem item;
	TurqInventoryWarehous warehouse;
	List result = whBLsearch.searchWarehouse(txtWarehouseName.getText().trim(),txtCity.getText().trim());
	for(int i= 0; i< result.size();i++){
	item = new TableItem(tableInvUIWarehouses, SWT.NULL);
	
	warehouse = (TurqInventoryWarehous)result.get(i);
	item.setData(warehouse);
	item.setText(new String[]{warehouse.getWarehousesName(),
							  warehouse.getWarehousesCity(),
							  warehouse.getWarehousesTelephone(),
							  warehouse.getWarehousesDescription()});
		
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

	/** Auto-generated main method */
	public static void main(String[] args){
		showGUI();
	}

	/**
	* This static method creates a new instance of this class and shows
	* it inside a new Shell.
	*
	* It is a convenience method for showing the GUI, but it can be
	* copied and used as a basis for your own code.	*
	* It is auto-generated code - the body of this method will be
	* re-generated after any changes are made to the GUI.
	* However, if you delete this method it will not be re-created.	*/
	public static void showGUI(){
		try {
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			InvUIWarehouseSearch inst = new InvUIWarehouseSearch(shell, SWT.NULL);
			shell.setLayout(new org.eclipse.swt.layout.FillLayout());
			Rectangle shellBounds = shell.computeTrim(0,0,618,381);
			shell.setSize(shellBounds.width, shellBounds.height);
			shell.open();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
