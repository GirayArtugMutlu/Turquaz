package com.turquaz.inventory.ui;



import java.util.List;


import org.eclipse.swt.widgets.Display;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;

import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.SWT;

import com.turquaz.engine.dal.TurqInventoryWarehous;
import com.turquaz.engine.ui.component.SecureComposite;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import com.turquaz.inventory.Messages;
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
			lblWarehouseNameLData.verticalAlignment = GridData.CENTER;
			lblWarehouseNameLData.horizontalAlignment = GridData.BEGINNING;
			lblWarehouseNameLData.widthHint = 105;
			lblWarehouseNameLData.heightHint = 20;
			lblWarehouseNameLData.horizontalIndent = 0;
			lblWarehouseNameLData.horizontalSpan = 1;
			lblWarehouseNameLData.verticalSpan = 1;
			lblWarehouseNameLData.grabExcessHorizontalSpace = false;
			lblWarehouseNameLData.grabExcessVerticalSpace = false;
			lblWarehouseName.setLayoutData(lblWarehouseNameLData);
			lblWarehouseName.setText(Messages.getString("InvUIWarehouseSearch.0")); //$NON-NLS-1$
			lblWarehouseName.setSize(new org.eclipse.swt.graphics.Point(105,20));
	
			GridData txtWarehouseNameLData = new GridData();
			txtWarehouseNameLData.verticalAlignment = GridData.CENTER;
			txtWarehouseNameLData.horizontalAlignment = GridData.BEGINNING;
			txtWarehouseNameLData.widthHint = 117;
			txtWarehouseNameLData.heightHint = 15;
			txtWarehouseNameLData.horizontalIndent = 0;
			txtWarehouseNameLData.horizontalSpan = 1;
			txtWarehouseNameLData.verticalSpan = 1;
			txtWarehouseNameLData.grabExcessHorizontalSpace = false;
			txtWarehouseNameLData.grabExcessVerticalSpace = false;
			txtWarehouseName.setLayoutData(txtWarehouseNameLData);
			txtWarehouseName.setSize(new org.eclipse.swt.graphics.Point(117,15));
	
			GridData lblWarehouseCityLData = new GridData();
			lblWarehouseCityLData.verticalAlignment = GridData.CENTER;
			lblWarehouseCityLData.horizontalAlignment = GridData.BEGINNING;
			lblWarehouseCityLData.widthHint = -1;
			lblWarehouseCityLData.heightHint = -1;
			lblWarehouseCityLData.horizontalIndent = 0;
			lblWarehouseCityLData.horizontalSpan = 1;
			lblWarehouseCityLData.verticalSpan = 1;
			lblWarehouseCityLData.grabExcessHorizontalSpace = false;
			lblWarehouseCityLData.grabExcessVerticalSpace = false;
			lblWarehouseCity.setLayoutData(lblWarehouseCityLData);
			lblWarehouseCity.setText(Messages.getString("InvUIWarehouseSearch.1")); //$NON-NLS-1$
	
			GridData txtCityLData = new GridData();
			txtCityLData.verticalAlignment = GridData.CENTER;
			txtCityLData.horizontalAlignment = GridData.BEGINNING;
			txtCityLData.widthHint = 114;
			txtCityLData.heightHint = 16;
			txtCityLData.horizontalIndent = 0;
			txtCityLData.horizontalSpan = 1;
			txtCityLData.verticalSpan = 1;
			txtCityLData.grabExcessHorizontalSpace = false;
			txtCityLData.grabExcessVerticalSpace = false;
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
			tableInvUIWarehouses.addMouseListener( new MouseAdapter() {
				public void mouseDoubleClick(MouseEvent evt) {
					tableInvUIWarehousesMouseDoubleClick(evt);
				}
			});
	
			tableColumnName.setText(Messages.getString("InvUIWarehouseSearch.2")); //$NON-NLS-1$
			tableColumnName.setWidth(161);
	
			tableColumnWarehouseCity.setText(Messages.getString("InvUIWarehouseSearch.3")); //$NON-NLS-1$
			tableColumnWarehouseCity.setWidth(100);
	
			tableColumnTelephone.setText(Messages.getString("InvUIWarehouseSearch.4")); //$NON-NLS-1$
			tableColumnTelephone.setWidth(100);
	
			tableColumnDescription.setText(Messages.getString("InvUIWarehouseSearch.5")); //$NON-NLS-1$
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

	

	/** Auto-generated event handler method */
	protected void tableInvUIWarehousesMouseDoubleClick(MouseEvent evt){
		TableItem items[] = tableInvUIWarehouses.getSelection();
		if(items.length>0){
		new InvUIWarehouseUpdate(this.getShell(),SWT.NULL,(TurqInventoryWarehous)items[0].getData()).open();
		search();
		
		}
		
		
		
		
	}
}
