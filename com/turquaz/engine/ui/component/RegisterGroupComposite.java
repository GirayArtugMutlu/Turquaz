package com.turquaz.engine.ui.component;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.SWT;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class RegisterGroupComposite extends org.eclipse.swt.widgets.Composite {

	private TableColumn tableColumn4;
	private Table tableRegisteredGroups;
	private Button button2;
	private Button button1;
	private Composite composite2;
	private TableColumn tableColumn3;
	private Table tableAllGroups;
	private Composite composite1;
	public RegisterGroupComposite(Composite parent, int style) {
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
			tableAllGroups = new Table(composite1,SWT.SINGLE| SWT.FULL_SELECTION| SWT.BORDER);
			tableColumn3 = new TableColumn(tableAllGroups,SWT.NULL);
			composite2 = new Composite(composite1,SWT.NULL);
			button1 = new Button(composite2,SWT.PUSH| SWT.CENTER);
			button2 = new Button(composite2,SWT.PUSH| SWT.CENTER);
			tableRegisteredGroups = new Table(composite1,SWT.FULL_SELECTION| SWT.BORDER);
			tableColumn4 = new TableColumn(tableRegisteredGroups,SWT.NULL);
	
			this.setSize(new org.eclipse.swt.graphics.Point(478,187));
	
			GridData composite1LData = new GridData();
			composite1LData.verticalAlignment = GridData.FILL;
			composite1LData.horizontalAlignment = GridData.FILL;
			composite1LData.widthHint = -1;
			composite1LData.heightHint = -1;
			composite1LData.horizontalIndent = 0;
			composite1LData.horizontalSpan = 1;
			composite1LData.verticalSpan = 1;
			composite1LData.grabExcessHorizontalSpace = true;
			composite1LData.grabExcessVerticalSpace = true;
			composite1.setLayoutData(composite1LData);
			composite1.setSize(new org.eclipse.swt.graphics.Point(468,177));
	
			GridData tableAllGroupsLData = new GridData();
			tableAllGroupsLData.verticalAlignment = GridData.CENTER;
			tableAllGroupsLData.horizontalAlignment = GridData.BEGINNING;
			tableAllGroupsLData.widthHint = 141;
			tableAllGroupsLData.heightHint = 141;
			tableAllGroupsLData.horizontalIndent = 0;
			tableAllGroupsLData.horizontalSpan = 1;
			tableAllGroupsLData.verticalSpan = 1;
			tableAllGroupsLData.grabExcessHorizontalSpace = false;
			tableAllGroupsLData.grabExcessVerticalSpace = false;
			tableAllGroups.setLayoutData(tableAllGroupsLData);
			tableAllGroups.setHeaderVisible(true);
			tableAllGroups.setLinesVisible(true);
			tableAllGroups.setSize(new org.eclipse.swt.graphics.Point(141,141));
	
			tableColumn3.setText("Groups");
			tableColumn3.setWidth(141);
	
			GridData composite2LData = new GridData();
			composite2LData.verticalAlignment = GridData.CENTER;
			composite2LData.horizontalAlignment = GridData.BEGINNING;
			composite2LData.widthHint = 103;
			composite2LData.heightHint = 72;
			composite2LData.horizontalIndent = 0;
			composite2LData.horizontalSpan = 1;
			composite2LData.verticalSpan = 1;
			composite2LData.grabExcessHorizontalSpace = false;
			composite2LData.grabExcessVerticalSpace = false;
			composite2.setLayoutData(composite2LData);
			composite2.setSize(new org.eclipse.swt.graphics.Point(103,72));
	
			GridData button1LData = new GridData();
			button1LData.verticalAlignment = GridData.CENTER;
			button1LData.horizontalAlignment = GridData.CENTER;
			button1LData.widthHint = 44;
			button1LData.heightHint = 29;
			button1LData.horizontalIndent = 0;
			button1LData.horizontalSpan = 1;
			button1LData.verticalSpan = 1;
			button1LData.grabExcessHorizontalSpace = false;
			button1LData.grabExcessVerticalSpace = false;
			button1.setLayoutData(button1LData);
			button1.setText(">>");
			button1.setSize(new org.eclipse.swt.graphics.Point(44,29));
			button1.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					button1MouseUp(evt);
				}
			});
	
			GridData button2LData = new GridData();
			button2LData.verticalAlignment = GridData.BEGINNING;
			button2LData.horizontalAlignment = GridData.CENTER;
			button2LData.widthHint = 48;
			button2LData.heightHint = 31;
			button2LData.horizontalIndent = 0;
			button2LData.horizontalSpan = 1;
			button2LData.verticalSpan = 1;
			button2LData.grabExcessHorizontalSpace = false;
			button2LData.grabExcessVerticalSpace = false;
			button2.setLayoutData(button2LData);
			button2.setText("<<");
			button2.setSize(new org.eclipse.swt.graphics.Point(48,31));
			button2.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					button2MouseUp(evt);
				}
			});
			GridLayout composite2Layout = new GridLayout(1, true);
			composite2.setLayout(composite2Layout);
			composite2Layout.marginWidth = 5;
			composite2Layout.marginHeight = 5;
			composite2Layout.numColumns = 1;
			composite2Layout.makeColumnsEqualWidth = true;
			composite2Layout.horizontalSpacing = 5;
			composite2Layout.verticalSpacing = 5;
			composite2.layout();
	
			GridData tableRegisteredGroupsLData = new GridData();
			tableRegisteredGroupsLData.verticalAlignment = GridData.CENTER;
			tableRegisteredGroupsLData.horizontalAlignment = GridData.BEGINNING;
			tableRegisteredGroupsLData.widthHint = 150;
			tableRegisteredGroupsLData.heightHint = 141;
			tableRegisteredGroupsLData.horizontalIndent = 0;
			tableRegisteredGroupsLData.horizontalSpan = 1;
			tableRegisteredGroupsLData.verticalSpan = 1;
			tableRegisteredGroupsLData.grabExcessHorizontalSpace = false;
			tableRegisteredGroupsLData.grabExcessVerticalSpace = false;
			tableRegisteredGroups.setLayoutData(tableRegisteredGroupsLData);
			tableRegisteredGroups.setHeaderVisible(true);
			tableRegisteredGroups.setLinesVisible(true);
			tableRegisteredGroups.setSize(new org.eclipse.swt.graphics.Point(150,141));
	
			tableColumn4.setText("Registered Groups");
			tableColumn4.setWidth(146);
			GridLayout composite1Layout = new GridLayout(3, true);
			composite1.setLayout(composite1Layout);
			composite1Layout.marginWidth = 5;
			composite1Layout.marginHeight = 5;
			composite1Layout.numColumns = 3;
			composite1Layout.makeColumnsEqualWidth = false;
			composite1Layout.horizontalSpacing = 5;
			composite1Layout.verticalSpacing = 5;
			composite1.layout();
			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = true;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 5;
			this.layout();
	
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

	/** Auto-generated event handler method */
	protected void button1MouseUp(MouseEvent evt){
		
		int selectedIndex = tableAllGroups.getSelectionIndex();
		if (selectedIndex >= 0) {
			TableItem registeredItem = new TableItem(tableRegisteredGroups,SWT.NULL);
			registeredItem.setText(tableAllGroups.getItem(
					selectedIndex).getText());
			registeredItem.setData(tableAllGroups.getItem(
					selectedIndex).getData());
			tableAllGroups.remove(selectedIndex);
		}
	}

	/** Auto-generated event handler method */
	protected void button2MouseUp(MouseEvent evt){
	 int selectedIndex = tableRegisteredGroups.getSelectionIndex();
		if (selectedIndex >= 0) {
			TableItem registeredItem = new TableItem(tableAllGroups,SWT.NULL);
			registeredItem.setText(tableRegisteredGroups.getItem(
					selectedIndex).getText());
			registeredItem.setData(tableRegisteredGroups.getItem(
					selectedIndex).getData());
			tableRegisteredGroups.remove(selectedIndex);
		}
	}

	

	
	public void fillTableAllGroups(HashMap elementMap){
	
	tableAllGroups.removeAll();	
	tableRegisteredGroups.removeAll();
	Iterator it = elementMap.keySet().iterator();
	TableItem item;
	while(it.hasNext()){
     item = new TableItem(tableAllGroups,SWT.NULL);
     String key =it.next().toString();
     item.setText(key);
     item.setData(elementMap.get(key));		
	}
		
		
	}
	
	/**
	 * @return Returns the tableAllGroups.
	 */
	public Table getTableAllGroups() {
		return tableAllGroups;
	}
	/**
	 * @return Returns the tableRegisteredGroups.
	 */
	public Table getTableRegisteredGroups() {
		return tableRegisteredGroups;
	}
}
