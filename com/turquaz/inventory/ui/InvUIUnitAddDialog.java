package com.turquaz.inventory.ui;

import java.util.Calendar;
import java.util.List;

import net.sf.hibernate.HibernateException;

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
import org.eclipse.swt.widgets.MessageBox;
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
public class InvUIUnitAddDialog extends org.eclipse.swt.widgets.Dialog {
	private Table tableInvUnits;
	private Button btnGroupAdd;
	private Text txtGroupName;
	private CLabel cLabel1;
	private TableColumn tableColumnName;
	private Button btnUnitAdd;
	private Button btnUpdate;
	private Button btnDelete;
	private Text txtUnitName;
	private CLabel lblUnitName;
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

			dialogShell.setSize(286, 229);

			final Color composite1background = new Color(Display.getDefault(),255,255,255);

			{
				tableInvUnits = new Table(dialogShell, SWT.FULL_SELECTION
					| SWT.H_SCROLL
					| SWT.V_SCROLL
					| SWT.BORDER);
				GridData tableInvGroupsLData = new GridData();
				tableInvGroupsLData.verticalAlignment = GridData.FILL;
				tableInvGroupsLData.horizontalAlignment = GridData.FILL;
				tableInvGroupsLData.grabExcessHorizontalSpace = true;
				tableInvGroupsLData.grabExcessVerticalSpace = true;
				tableInvUnits.setLayoutData(tableInvGroupsLData);
				tableInvUnits.setHeaderVisible(true);
				tableInvUnits.setLinesVisible(true);
				tableInvUnits.setSize(new org.eclipse.swt.graphics.Point(
					232,
					117));
				{
					tableColumnName = new TableColumn(tableInvUnits, SWT.NONE);
					tableColumnName.setText("Unit Name");
					tableColumnName.setWidth(200);
				}
				tableInvUnits.addMouseListener(new MouseAdapter() {
					public void mouseDoubleClick(MouseEvent evt) {
						tableInvGroupsMouseDoubleClick(evt);
					}
				});
			}
			GridLayout dialogShellLayout = new GridLayout(1, true);
			dialogShell.setLayout(dialogShellLayout);
			{
				composite1 = new Composite(dialogShell, SWT.NONE);
				GridLayout composite1Layout = new GridLayout(3, true);
				composite1Layout.marginWidth = 5;
				composite1Layout.marginHeight = 5;
				composite1Layout.numColumns = 3;
				composite1Layout.makeColumnsEqualWidth = false;
				composite1Layout.horizontalSpacing = 5;
				composite1Layout.verticalSpacing = 5;
				GridData composite1LData = new GridData();
				composite1LData.horizontalAlignment = GridData.FILL;
				composite1LData.heightHint = 92;
				composite1LData.grabExcessHorizontalSpace = true;
				composite1.setLayoutData(composite1LData);
				composite1.setSize(new org.eclipse.swt.graphics.Point(252, 92));
				composite1.setBackground(composite1background);
				composite1.setLayout(composite1Layout);
				{
					cLabel1 = new CLabel(composite1, SWT.NONE);
					GridData cLabel1LData = new GridData();
					cLabel1LData.horizontalAlignment = GridData.END;
					cLabel1LData.widthHint = 91;
					cLabel1LData.heightHint = 18;
					cLabel1.setLayoutData(cLabel1LData);
					cLabel1.setText("Unit Name");
				}
				{
					txtGroupName = new Text(composite1, SWT.BORDER);
					GridData txtGroupNameLData = new GridData();
					txtGroupNameLData.widthHint = 134;
					txtGroupNameLData.heightHint = 8;
					txtGroupNameLData.horizontalSpan = 2;
					txtGroupName.setLayoutData(txtGroupNameLData);
				}
				{
					btnDelete = new Button(composite1, SWT.PUSH | SWT.CENTER);
					GridData btnDeleteLData = new GridData();
					btnDeleteLData.horizontalAlignment = GridData.END;
					btnDeleteLData.widthHint = 65;
					btnDeleteLData.heightHint = 31;
					btnDelete.setLayoutData(btnDeleteLData);
					btnDelete.setText("Delete");
					btnDelete.setEnabled(false);
					btnDelete.addMouseListener(new MouseAdapter() {
						public void mouseUp(MouseEvent evt) {
							btnDeleteMouseUp(evt);
						}
					});
				}
				{
					btnUpdate = new Button(composite1, SWT.PUSH | SWT.CENTER);
					GridData btnUpdateLData = new GridData();
					btnUpdateLData.horizontalAlignment = GridData.END;
					btnUpdateLData.widthHint = 65;
					btnUpdateLData.heightHint = 31;
					btnUpdate.setLayoutData(btnUpdateLData);
					btnUpdate.setText("Update");
					btnUpdate.setEnabled(false);
					btnUpdate.addMouseListener(new MouseAdapter() {
						public void mouseUp(MouseEvent evt) {
							btnUpdateMouseUp(evt);
						}
					});
				}
				{
					btnGroupAdd = new Button(composite1, SWT.PUSH | SWT.CENTER);
					GridData btnGroupAddLData = new GridData();
					btnGroupAdd.setLayoutData(btnGroupAddLData);
					btnGroupAdd.setText("Add");
					btnGroupAdd.addMouseListener(new MouseAdapter() {
						public void mouseUp(MouseEvent evt) {
							btnGroupAddMouseUp(evt);
						}
					});
				}
				composite1.layout();

			}
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
    
    List list = blCardAdd.getInventoryUnits();
    
    TurqInventoryUnit invUnit;
    TableItem item;
    for(int i=0;i<list.size();i++){
    invUnit = (TurqInventoryUnit)list.get(i);
    item = new TableItem(tableInvUnits,SWT.NULL);
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
		MessageBox msg = new MessageBox(this.getParent(),SWT.OK|SWT.CANCEL);
		MessageBox msg2 = new MessageBox(this.getParent());
	    try{
	    msg.setMessage("Really delete inventory group?");
	    int result = msg.open();
	    if(result==SWT.OK){
	   
	    blCardAdd.deleteObject(txtUnitName.getData());
	   
	   
	    btnDelete.setEnabled(false);
	    btnUpdate.setEnabled(false);
	    btnUnitAdd.setEnabled(true);
	    txtUnitName.setText("");
	
	    msg2.setMessage("Succesfully Deleted!");
		msg2.open();
		fillTable();
	    
	    }
	    
		}
		catch(Exception ex){
			 btnDelete.setEnabled(false);
			    btnUpdate.setEnabled(false);
			    btnUnitAdd.setEnabled(true);
			    txtUnitName.setText("");
			 	
		msg2.setMessage("Can not delete inventory group!");	
		msg2.open();
		ex.printStackTrace();
		}
		
	}

	/** Auto-generated event handler method */
	protected void btnUpdateMouseUp(MouseEvent evt){
		MessageBox msg = new MessageBox(this.getParent());
	try{
		 if(txtUnitName.getText().trim().equals("")){
		    
		    msg.setMessage("Please fill the name field!!");
		    msg.open();
		    }
	else{
		
	TurqInventoryUnit invUnit = (TurqInventoryUnit)txtUnitName.getData();
	invUnit.setUpdatedBy(System.getProperty("user"));
	invUnit.setLastModified(new java.sql.Date(cal.getTime().getTime()));
	invUnit.setUnitsName(txtUnitName.getText().trim());
	
	blCardAdd.saveOrUpdateObject(invUnit);
	
	btnDelete.setEnabled(false);
	btnUpdate.setEnabled(false);
	btnUnitAdd.setEnabled(true);
	txtUnitName.setText("");
	
	msg.setMessage("Succesfully Updated!");
	msg.open();
	fillTable();
		    }
	
	
	}
	catch(Exception ex){
	btnDelete.setEnabled(false);
	btnUpdate.setEnabled(false);
	btnUnitAdd.setEnabled(true);
	txtUnitName.setText("");
	msg.setMessage("There is an unknown error!");
	msg.open();
	ex.printStackTrace();
	}
	}

	/** Auto-generated event handler method */
	protected void btnGroupAddMouseDoubleClick(MouseEvent evt){
		//TODO add your handler code here
	}

	/** Auto-generated event handler method */
	protected void btnUnitAddMouseUp(MouseEvent evt){
		MessageBox msg = new MessageBox(this.getParent());
		try{
		
		
	    if(txtUnitName.getText().trim().equals("")){
	    
	    msg.setMessage("Please fill the name field!!");
	    msg.open();
	    }
	    else{
	    
	    blCardAdd.saveUnit(txtUnitName.getText().trim());
	    msg.setMessage("Inventory Unit succesfully added!");
	    txtUnitName.setText("");
	    fillTable();
	    msg.open();	    
	    }		
		
		}
		catch(HibernateException ex){
		ex.printStackTrace();
		msg.setText("Please specify a different name!");
	    msg.open();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	
	
	
	
	}

	/** Auto-generated event handler method */
	protected void tableInvUnitsMouseDoubleClick(MouseEvent evt){
			TableItem item;
		if(tableInvUnits.getSelection().length>0){
		item = tableInvUnits.getSelection()[0];
		txtUnitName.setText(item.getText(0));
	
		txtUnitName.setData(item.getData());
		btnUpdate.setEnabled(true);
		btnDelete.setEnabled(true);
		btnUnitAdd.setEnabled(false);
		}
		
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
