package com.turquaz.inventory.ui;

import java.util.Calendar;
import java.util.List;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;


import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.dal.TurqInventoryUnit;
import com.turquaz.inventory.bl.InvBLCardAdd;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class InvUIUnitAddDialog extends org.eclipse.swt.widgets.Dialog {
	private TableColumn tableColumnName;
	private Table tableInvGroups;
	private Button btnGroupAdd;
	private Button btnUpdate;
	private Button btnDelete;
	private Text txtGroupName;
	private CLabel cLabel1;
	private Composite composite1;
	private Shell dialogShell;
	private InvBLCardAdd blCardAdd = new InvBLCardAdd();
    Calendar cal = Calendar.getInstance();

	public InvUIUnitAddDialog(Shell parent, int style) {
		super(parent, style);
	}

	/**
	* Opens the Dialog Shell.
	* Auto-generated code - any changes you make will disappear.
	*/
	public void open(){
		try {
			preInitGUI();
	
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
			dialogShell.setText(getText());
			composite1 = new Composite(dialogShell,SWT.NULL);
			cLabel1 = new CLabel(composite1,SWT.NULL);
			txtGroupName = new Text(composite1,SWT.BORDER);
			btnDelete = new Button(composite1,SWT.PUSH| SWT.CENTER);
			btnUpdate = new Button(composite1,SWT.PUSH| SWT.CENTER);
			btnGroupAdd = new Button(composite1,SWT.PUSH| SWT.CENTER);
			tableInvGroups = new Table(dialogShell,SWT.FULL_SELECTION| SWT.H_SCROLL| SWT.V_SCROLL| SWT.BORDER);
			tableColumnName = new TableColumn(tableInvGroups,SWT.NULL);
	
			dialogShell.setSize(new org.eclipse.swt.graphics.Point(252,229));
	
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
			composite1.setSize(new org.eclipse.swt.graphics.Point(252,92));
			final Color composite1background = new Color(Display.getDefault(),255,255,255);
			composite1.setBackground(composite1background);
	
			GridData cLabel1LData = new GridData();
			cLabel1LData.verticalAlignment = GridData.CENTER;
			cLabel1LData.horizontalAlignment = GridData.END;
			cLabel1LData.widthHint = 56;
			cLabel1LData.heightHint = 20;
			cLabel1LData.horizontalIndent = 0;
			cLabel1LData.horizontalSpan = 1;
			cLabel1LData.verticalSpan = 1;
			cLabel1LData.grabExcessHorizontalSpace = false;
			cLabel1LData.grabExcessVerticalSpace = false;
			cLabel1.setLayoutData(cLabel1LData);
			cLabel1.setText("Unit Name");
			cLabel1.setSize(new org.eclipse.swt.graphics.Point(56,20));
	
			GridData txtGroupNameLData = new GridData();
			txtGroupNameLData.verticalAlignment = GridData.CENTER;
			txtGroupNameLData.horizontalAlignment = GridData.BEGINNING;
			txtGroupNameLData.widthHint = 124;
			txtGroupNameLData.heightHint = 13;
			txtGroupNameLData.horizontalIndent = 0;
			txtGroupNameLData.horizontalSpan = 2;
			txtGroupNameLData.verticalSpan = 1;
			txtGroupNameLData.grabExcessHorizontalSpace = false;
			txtGroupNameLData.grabExcessVerticalSpace = false;
			txtGroupName.setLayoutData(txtGroupNameLData);
			txtGroupName.setSize(new org.eclipse.swt.graphics.Point(124,13));
	
			GridData btnDeleteLData = new GridData();
			btnDeleteLData.verticalAlignment = GridData.CENTER;
			btnDeleteLData.horizontalAlignment = GridData.END;
			btnDeleteLData.widthHint = 50;
			btnDeleteLData.heightHint = 23;
			btnDeleteLData.horizontalIndent = 0;
			btnDeleteLData.horizontalSpan = 1;
			btnDeleteLData.verticalSpan = 1;
			btnDeleteLData.grabExcessHorizontalSpace = false;
			btnDeleteLData.grabExcessVerticalSpace = false;
			btnDelete.setLayoutData(btnDeleteLData);
			btnDelete.setText("Delete");
			btnDelete.setSize(new org.eclipse.swt.graphics.Point(50,23));
			btnDelete.setEnabled(false);
			btnDelete.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					btnDeleteMouseUp(evt);
				}
			});
	
			GridData btnUpdateLData = new GridData();
			btnUpdateLData.verticalAlignment = GridData.CENTER;
			btnUpdateLData.horizontalAlignment = GridData.END;
			btnUpdateLData.widthHint = 47;
			btnUpdateLData.heightHint = 23;
			btnUpdateLData.horizontalIndent = 0;
			btnUpdateLData.horizontalSpan = 1;
			btnUpdateLData.verticalSpan = 1;
			btnUpdateLData.grabExcessHorizontalSpace = false;
			btnUpdateLData.grabExcessVerticalSpace = false;
			btnUpdate.setLayoutData(btnUpdateLData);
			btnUpdate.setText("Update");
			btnUpdate.setSize(new org.eclipse.swt.graphics.Point(47,23));
			btnUpdate.setEnabled(false);
			btnUpdate.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					btnUpdateMouseUp(evt);
				}
			});
	
			GridData btnGroupAddLData = new GridData();
			btnGroupAddLData.verticalAlignment = GridData.CENTER;
			btnGroupAddLData.horizontalAlignment = GridData.BEGINNING;
			btnGroupAddLData.widthHint = -1;
			btnGroupAddLData.heightHint = -1;
			btnGroupAddLData.horizontalIndent = 0;
			btnGroupAddLData.horizontalSpan = 1;
			btnGroupAddLData.verticalSpan = 1;
			btnGroupAddLData.grabExcessHorizontalSpace = false;
			btnGroupAddLData.grabExcessVerticalSpace = false;
			btnGroupAdd.setLayoutData(btnGroupAddLData);
			btnGroupAdd.setText("Add");
			btnGroupAdd.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					btnGroupAddMouseUp(evt);
				}
			});
			GridLayout composite1Layout = new GridLayout(3, true);
			composite1.setLayout(composite1Layout);
			composite1Layout.marginWidth = 5;
			composite1Layout.marginHeight = 5;
			composite1Layout.numColumns = 3;
			composite1Layout.makeColumnsEqualWidth = false;
			composite1Layout.horizontalSpacing = 5;
			composite1Layout.verticalSpacing = 5;
			composite1.layout();
	
			GridData tableInvGroupsLData = new GridData();
			tableInvGroupsLData.verticalAlignment = GridData.FILL;
			tableInvGroupsLData.horizontalAlignment = GridData.FILL;
			tableInvGroupsLData.widthHint = -1;
			tableInvGroupsLData.heightHint = -1;
			tableInvGroupsLData.horizontalIndent = 0;
			tableInvGroupsLData.horizontalSpan = 1;
			tableInvGroupsLData.verticalSpan = 1;
			tableInvGroupsLData.grabExcessHorizontalSpace = true;
			tableInvGroupsLData.grabExcessVerticalSpace = true;
			tableInvGroups.setLayoutData(tableInvGroupsLData);
			tableInvGroups.setHeaderVisible(true);
			tableInvGroups.setLinesVisible(true);
			tableInvGroups.setSize(new org.eclipse.swt.graphics.Point(232,117));
			tableInvGroups.addMouseListener( new MouseAdapter() {
				public void mouseDoubleClick(MouseEvent evt) {
					tableInvGroupsMouseDoubleClick(evt);
				}
			});
	
			tableColumnName.setText("Unit Name");
			tableColumnName.setWidth(200);
			GridLayout dialogShellLayout = new GridLayout(1, true);
			dialogShell.setLayout(dialogShellLayout);
			dialogShellLayout.marginWidth = 0;
			dialogShellLayout.marginHeight = 0;
			dialogShellLayout.numColumns = 1;
			dialogShellLayout.makeColumnsEqualWidth = true;
			dialogShellLayout.horizontalSpacing = 0;
			dialogShellLayout.verticalSpacing = 0;
			dialogShell.layout();
			dialogShell.addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					composite1background.dispose();
				}
			});
			Rectangle bounds = dialogShell.computeTrim(0, 0, 252,229);
			dialogShell.setSize(bounds.width, bounds.height);
			postInitGUI();
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
	/** Add your pre-init code in here 	*/
	public void preInitGUI(){
	}

	/** Add your post-init code in here 	*/
	public void postInitGUI(){
	fillTable();
	}
	
	
    public void fillTable(){
    try{
    tableInvGroups.removeAll();
    List list = blCardAdd.getInventoryUnits();
    
    TurqInventoryUnit invUnit;
    TableItem item;
    for(int i=0;i<list.size();i++){
    invUnit = (TurqInventoryUnit)list.get(i);
    item = new TableItem(tableInvGroups,SWT.NULL);
    item.setText(new String[]{invUnit.getUnitsName()});
    item.setData(invUnit);   
    
    }
    
    
    }
    catch(Exception ex){
    ex.printStackTrace();
    
    }
    
    
    
    }
	

	/** Auto-generated event handler method */
	protected void btnDeleteMouseUp(MouseEvent evt){
		//TODO add your handler code here
	}

	/** Auto-generated event handler method */
	protected void btnUpdateMouseUp(MouseEvent evt){
		//TODO add your handler code here
	}

	/** Auto-generated event handler method */
	protected void btnGroupAddMouseDoubleClick(MouseEvent evt){
		//TODO add your handler code here
	}

	/** Auto-generated event handler method */
	protected void btnGroupAddMouseUp(MouseEvent evt){
		//TODO add your handler code here
	}

	/** Auto-generated event handler method */
	protected void tableInvGroupsMouseDoubleClick(MouseEvent evt){
		//TODO add your handler code here
	}
}