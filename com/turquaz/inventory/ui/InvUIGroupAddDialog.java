package com.turquaz.inventory.ui;

import java.util.List;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.SWT;

import com.turquaz.engine.dal.TurqInventoryCardGroup;
import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.inventory.bl.InvBLCardAdd;
import com.turquaz.inventory.dal.InvDALCardAdd;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class InvUIGroupAddDialog extends org.eclipse.swt.widgets.Dialog {
	private Button button3;
	private Button button2;
	private Button button1;
	private Text txtDescription;
	private CLabel lblDescription;
	private Text txtGroupDesc;
	private TableColumn tableColumnDescription;
	private TableColumn tableColumnName;
	private Table tableInvGroups;
	private CLabel cLabel1;
	private Composite composite1;
	private Shell dialogShell;
    private InvBLCardAdd blCardAdd = new InvBLCardAdd();
	public InvUIGroupAddDialog(Shell parent, int style) {
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
			txtGroupDesc = new Text(composite1,SWT.BORDER);
			lblDescription = new CLabel(composite1,SWT.NULL);
			txtDescription = new Text(composite1,SWT.SINGLE| SWT.BORDER);
			button1 = new Button(composite1,SWT.PUSH| SWT.CENTER);
			button2 = new Button(composite1,SWT.PUSH| SWT.CENTER);
			button3 = new Button(composite1,SWT.PUSH| SWT.CENTER);
			tableInvGroups = new Table(dialogShell,SWT.H_SCROLL| SWT.V_SCROLL| SWT.BORDER);
			tableColumnName = new TableColumn(tableInvGroups,SWT.NULL);
			tableColumnDescription = new TableColumn(tableInvGroups,SWT.NULL);
	
			dialogShell.setSize(new org.eclipse.swt.graphics.Point(433,229));
	
			GridData composite1LData = new GridData();
			composite1LData.verticalAlignment = GridData.CENTER;
			composite1LData.horizontalAlignment = GridData.FILL;
			composite1LData.widthHint = -1;
			composite1LData.heightHint = 85;
			composite1LData.horizontalIndent = 0;
			composite1LData.horizontalSpan = 1;
			composite1LData.verticalSpan = 1;
			composite1LData.grabExcessHorizontalSpace = true;
			composite1LData.grabExcessVerticalSpace = false;
			composite1.setLayoutData(composite1LData);
			composite1.setSize(new org.eclipse.swt.graphics.Point(433,85));
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
			cLabel1.setText("Name");
			cLabel1.setSize(new org.eclipse.swt.graphics.Point(56,20));
	
			GridData txtGroupDescLData = new GridData();
			txtGroupDescLData.verticalAlignment = GridData.CENTER;
			txtGroupDescLData.horizontalAlignment = GridData.BEGINNING;
			txtGroupDescLData.widthHint = 124;
			txtGroupDescLData.heightHint = 13;
			txtGroupDescLData.horizontalIndent = 0;
			txtGroupDescLData.horizontalSpan = 2;
			txtGroupDescLData.verticalSpan = 1;
			txtGroupDescLData.grabExcessHorizontalSpace = false;
			txtGroupDescLData.grabExcessVerticalSpace = false;
			txtGroupDesc.setLayoutData(txtGroupDescLData);
			txtGroupDesc.setSize(new org.eclipse.swt.graphics.Point(124,13));
	
			GridData lblDescriptionLData = new GridData();
			lblDescriptionLData.verticalAlignment = GridData.BEGINNING;
			lblDescriptionLData.horizontalAlignment = GridData.END;
			lblDescriptionLData.widthHint = -1;
			lblDescriptionLData.heightHint = -1;
			lblDescriptionLData.horizontalIndent = 0;
			lblDescriptionLData.horizontalSpan = 1;
			lblDescriptionLData.verticalSpan = 1;
			lblDescriptionLData.grabExcessHorizontalSpace = false;
			lblDescriptionLData.grabExcessVerticalSpace = false;
			lblDescription.setLayoutData(lblDescriptionLData);
			lblDescription.setText("Description");
	
			GridData txtDescriptionLData = new GridData();
			txtDescriptionLData.verticalAlignment = GridData.CENTER;
			txtDescriptionLData.horizontalAlignment = GridData.BEGINNING;
			txtDescriptionLData.widthHint = 312;
			txtDescriptionLData.heightHint = 13;
			txtDescriptionLData.horizontalIndent = 0;
			txtDescriptionLData.horizontalSpan = 2;
			txtDescriptionLData.verticalSpan = 1;
			txtDescriptionLData.grabExcessHorizontalSpace = false;
			txtDescriptionLData.grabExcessVerticalSpace = false;
			txtDescription.setLayoutData(txtDescriptionLData);
			txtDescription.setSize(new org.eclipse.swt.graphics.Point(312,13));
	
			GridData button1LData = new GridData();
			button1LData.verticalAlignment = GridData.CENTER;
			button1LData.horizontalAlignment = GridData.END;
			button1LData.widthHint = 50;
			button1LData.heightHint = 23;
			button1LData.horizontalIndent = 0;
			button1LData.horizontalSpan = 1;
			button1LData.verticalSpan = 1;
			button1LData.grabExcessHorizontalSpace = false;
			button1LData.grabExcessVerticalSpace = false;
			button1.setLayoutData(button1LData);
			button1.setText("Delete");
			button1.setSize(new org.eclipse.swt.graphics.Point(50,23));
			button1.setEnabled(false);
	
			GridData button2LData = new GridData();
			button2LData.verticalAlignment = GridData.CENTER;
			button2LData.horizontalAlignment = GridData.END;
			button2LData.widthHint = 47;
			button2LData.heightHint = 23;
			button2LData.horizontalIndent = 0;
			button2LData.horizontalSpan = 1;
			button2LData.verticalSpan = 1;
			button2LData.grabExcessHorizontalSpace = false;
			button2LData.grabExcessVerticalSpace = false;
			button2.setLayoutData(button2LData);
			button2.setText("Update");
			button2.setSize(new org.eclipse.swt.graphics.Point(47,23));
			button2.setEnabled(false);
	
			GridData button3LData = new GridData();
			button3LData.verticalAlignment = GridData.CENTER;
			button3LData.horizontalAlignment = GridData.BEGINNING;
			button3LData.widthHint = -1;
			button3LData.heightHint = -1;
			button3LData.horizontalIndent = 0;
			button3LData.horizontalSpan = 1;
			button3LData.verticalSpan = 1;
			button3LData.grabExcessHorizontalSpace = false;
			button3LData.grabExcessVerticalSpace = false;
			button3.setLayoutData(button3LData);
			button3.setText("Add");
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
			tableInvGroups.setSize(new org.eclipse.swt.graphics.Point(417,128));
			tableInvGroups.addMouseListener( new MouseAdapter() {
				public void mouseDoubleClick(MouseEvent evt) {
					tableInvGroupsMouseDoubleClick(evt);
				}
			});
	
			tableColumnName.setText("Name");
			tableColumnName.setWidth(150);
	
			tableColumnDescription.setText("Description");
			tableColumnDescription.setWidth(270);
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
			Rectangle bounds = dialogShell.computeTrim(0, 0, 433,229);
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
    List list = blCardAdd.getInventoryGroups();
    
    TurqInventoryGroup invGroup;
    TableItem item;
    for(int i=0;i<list.size();i++){
    invGroup = (TurqInventoryGroup)list.get(i);
    item = new TableItem(tableInvGroups,SWT.NULL);
    item.setText(new String[]{invGroup.getGroupsName(),invGroup.getGroupsDescription()});
    item.setData(invGroup);   
    
    }
    
    
    }
    catch(Exception ex){
    ex.printStackTrace();
    
    }
    
    
    
    }
	/** Auto-generated event handler method */
	protected void tableInvGroupsMouseDoubleClick(MouseEvent evt){
		
	}
}
