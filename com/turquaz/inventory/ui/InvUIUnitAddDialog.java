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
import org.eclipse.swt.graphics.Point;
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

import com.turquaz.engine.dal.TurqInventoryUnit;
import com.turquaz.inventory.Messages;
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
import com.cloudgarden.resource.SWTResourceManager;
/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/

public class InvUIUnitAddDialog extends org.eclipse.swt.widgets.Dialog {
	
	private Text txtUnitName;
	private Table tableInvUnits;
	
	private Button btnUnitAdd;

	private CLabel cLabel1;
	private TableColumn tableColumnName;

	private Button btnUpdate;
	private Button btnDelete;

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

				{
					//Register as a resource user - SWTResourceManager will
					//handle the obtaining and disposing of resources
					SWTResourceManager.registerResourceUser(dialogShell);
				}

			dialogShell.setText(getText());
		
			dialogShell.setSize(new org.eclipse.swt.graphics.Point(252,229));
	
			GridData tableInvUnitsLData = new GridData();
	
			

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
				composite1.setBackground(SWTResourceManager.getColor(255, 255, 255));
				composite1.setLayout(composite1Layout);
				{
					cLabel1 = new CLabel(composite1, SWT.NONE);
					GridData cLabel1LData = new GridData();
					cLabel1LData.horizontalAlignment = GridData.END;
					cLabel1LData.widthHint = 56;
					cLabel1LData.heightHint = 20;
					cLabel1.setLayoutData(cLabel1LData);
					cLabel1.setText(Messages.getString("InvUIUnitAddDialog.1")); //$NON-NLS-1$
					cLabel1.setSize(new org.eclipse.swt.graphics.Point(56, 20));
				}
				{
					txtUnitName = new Text(composite1, SWT.BORDER);
					GridData txtUnitNameLData = new GridData();
					txtUnitNameLData.widthHint = 110;
					txtUnitNameLData.heightHint = 16;
					txtUnitNameLData.horizontalSpan = 2;
					txtUnitName.setLayoutData(txtUnitNameLData);
				}
				{
					btnDelete = new Button(composite1, SWT.PUSH | SWT.CENTER);
					GridData btnDeleteLData = new GridData();
					btnDeleteLData.horizontalAlignment = GridData.END;
					btnDeleteLData.widthHint = 50;
					btnDeleteLData.heightHint = 30;
					btnDelete.setLayoutData(btnDeleteLData);
					btnDelete.setText(Messages
						.getString("InvUIUnitAddDialog.2")); //$NON-NLS-1$
					btnDelete
						.setSize(new org.eclipse.swt.graphics.Point(50, 30));
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
					btnUpdateLData.widthHint = 50;
					btnUpdateLData.heightHint = 30;
					btnUpdate.setLayoutData(btnUpdateLData);
					btnUpdate.setText(Messages
						.getString("InvUIUnitAddDialog.3")); //$NON-NLS-1$
					btnUpdate
						.setSize(new org.eclipse.swt.graphics.Point(50, 30));
					btnUpdate.setEnabled(false);
					btnUpdate.addMouseListener(new MouseAdapter() {
						public void mouseUp(MouseEvent evt) {
							btnUpdateMouseUp(evt);
						}
					});
				}
				{
					btnUnitAdd = new Button(composite1, SWT.PUSH | SWT.CENTER);
					GridData btnUnitAddLData = new GridData();
					btnUnitAddLData.widthHint = 42;
					btnUnitAddLData.heightHint = 27;
					btnUnitAdd.setLayoutData(btnUnitAddLData);
					btnUnitAdd.setText(Messages
						.getString("InvUIUnitAddDialog.4")); //$NON-NLS-1$
					btnUnitAdd.setSize(new org.eclipse.swt.graphics.Point(
						42,
						27));
					btnUnitAdd.addMouseListener(new MouseAdapter() {
						public void mouseUp(MouseEvent evt) {
							btnUnitAddMouseUp(evt);
						}
					});
				}
				composite1.layout();
			}
			tableInvUnits = new Table(dialogShell,SWT.FULL_SELECTION| SWT.H_SCROLL| SWT.V_SCROLL| SWT.BORDER);
			tableColumnName = new TableColumn(tableInvUnits,SWT.NULL);
			tableColumnName.setText(Messages.getString("InvUIUnitAddDialog.0")); //$NON-NLS-1$
			tableColumnName.setWidth(200);
		    tableInvUnitsLData = new GridData();
			tableInvUnitsLData.verticalAlignment = GridData.FILL;
			tableInvUnitsLData.horizontalAlignment = GridData.FILL;
			tableInvUnitsLData.widthHint = -1;
			tableInvUnitsLData.heightHint = -1;
			tableInvUnitsLData.horizontalIndent = 0;
			tableInvUnitsLData.horizontalSpan = 1;
			tableInvUnitsLData.verticalSpan = 1;
			tableInvUnitsLData.grabExcessHorizontalSpace = true;
			tableInvUnitsLData.grabExcessVerticalSpace = true;
			tableInvUnits.setLayoutData(tableInvUnitsLData);
			tableInvUnits.setHeaderVisible(true);
			tableInvUnits.setLinesVisible(true);
			tableInvUnits.setSize(new org.eclipse.swt.graphics.Point(232,117));
			tableInvUnits.addMouseListener( new MouseAdapter() {
				public void mouseDoubleClick(MouseEvent evt) {
					tableInvUnitsMouseDoubleClick(evt);
				}
			});
	     
			
			
			
			
			
			dialogShellLayout.marginWidth = 0;
			dialogShellLayout.marginHeight = 0;
			dialogShellLayout.numColumns = 1;
			dialogShellLayout.makeColumnsEqualWidth = true;
			dialogShellLayout.horizontalSpacing = 0;
			dialogShellLayout.verticalSpacing = 0;
			dialogShell.layout();
			dialogShell.addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
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
	
    Point parentLocation =this.getParent().getLocation();
	Point parentSize = this.getParent().getSize();	
    Point dialogSize = dialogShell.getSize();
     
    int location_X = (parentLocation.x + parentSize.x)/2 - (dialogSize.x/2);
    int location_Y = (parentLocation.y + parentSize.y)/2 - (dialogSize.y/2);
    
    dialogShell.setLocation(location_X,location_Y);
   
	
		
	fillTable();
	}
	
	
    public void fillTable(){
    try{
    tableInvUnits.removeAll();
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
	    msg.setMessage(Messages.getString("InvUIUnitAddDialog.5")); //$NON-NLS-1$
	    int result = msg.open();
	    if(result==SWT.OK){
	   
	    blCardAdd.deleteObject(txtUnitName.getData());
	   
	   
	    btnDelete.setEnabled(false);
	    btnUpdate.setEnabled(false);
	    btnUnitAdd.setEnabled(true);
	    txtUnitName.setText(""); //$NON-NLS-1$
	
	    msg2.setMessage(Messages.getString("InvUIUnitAddDialog.7")); //$NON-NLS-1$
		msg2.open();
		fillTable();
	    
	    }
	    
		}
		catch(Exception ex){
			 btnDelete.setEnabled(false);
			    btnUpdate.setEnabled(false);
			    btnUnitAdd.setEnabled(true);
			    txtUnitName.setText(""); //$NON-NLS-1$
			 	
		msg2.setMessage(Messages.getString("InvUIUnitAddDialog.9"));	 //$NON-NLS-1$
		msg2.open();
		ex.printStackTrace();
		}
		
	}

	/** Auto-generated event handler method */
	protected void btnUpdateMouseUp(MouseEvent evt){
		MessageBox msg = new MessageBox(this.getParent());
	try{
		 if(txtUnitName.getText().trim().equals("")){ //$NON-NLS-1$
		    
		    msg.setMessage(Messages.getString("InvUIUnitAddDialog.11")); //$NON-NLS-1$
		    msg.open();
		    }
	else{
		
	TurqInventoryUnit invUnit = (TurqInventoryUnit)txtUnitName.getData();
	invUnit.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
	invUnit.setLastModified(new java.sql.Date(cal.getTime().getTime()));
	invUnit.setUnitsName(txtUnitName.getText().trim());
	
	blCardAdd.saveOrUpdateObject(invUnit);
	
	btnDelete.setEnabled(false);
	btnUpdate.setEnabled(false);
	btnUnitAdd.setEnabled(true);
	txtUnitName.setText(""); //$NON-NLS-1$
	
	msg.setMessage(Messages.getString("InvUIUnitAddDialog.14")); //$NON-NLS-1$
	msg.open();
	fillTable();
		    }
	
	
	}
	catch(Exception ex){
	btnDelete.setEnabled(false);
	btnUpdate.setEnabled(false);
	btnUnitAdd.setEnabled(true);
	txtUnitName.setText(""); //$NON-NLS-1$
	msg.setMessage(Messages.getString("InvUIUnitAddDialog.16")); //$NON-NLS-1$
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
		
		
	    if(txtUnitName.getText().trim().equals("")){ //$NON-NLS-1$
	    
	    msg.setMessage(Messages.getString("InvUIUnitAddDialog.18")); //$NON-NLS-1$
	    msg.open();
	    }
	    else{
	    
	    blCardAdd.saveUnit(txtUnitName.getText().trim());
	    msg.setMessage(Messages.getString("InvUIUnitAddDialog.19")); //$NON-NLS-1$
	    txtUnitName.setText(""); //$NON-NLS-1$
	    fillTable();
	    msg.open();	    
	    }		
		
		}
		catch(HibernateException ex){
		ex.printStackTrace();
		msg.setText(Messages.getString("InvUIUnitAddDialog.21")); //$NON-NLS-1$
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

	/** Auto-generated event handler method */
	protected void composite1MouseUp(MouseEvent evt){
		//TODO add your handler code here
	}
}
