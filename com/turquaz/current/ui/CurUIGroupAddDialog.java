package com.turquaz.current.ui;

import java.util.Calendar;
import java.util.List;

import net.sf.hibernate.HibernateException;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;

import com.turquaz.current.Messages;
import com.turquaz.current.bl.CurBLCurrentCardAdd;
import com.turquaz.engine.dal.TurqCurrentGroup;


/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class CurUIGroupAddDialog extends org.eclipse.swt.widgets.Dialog {
	private TableColumn tableColumnDescription;
	private TableColumn tableColumnName;
	private Table tableCurGroups;
	private Button btnGroupAdd;
	private Button btnUpdate;
	private Button btnDelete;
	private Text txtDescription;
	private CLabel lblDescription;
	private Text txtGroupName;
	private CLabel lblGroupName;
	private Composite compGroupAddDialog;
	private Shell dialogShell;
	private CurBLCurrentCardAdd blCardAdd = new CurBLCurrentCardAdd();
	Calendar cal = Calendar.getInstance();

	public CurUIGroupAddDialog(Shell parent, int style) {
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
			compGroupAddDialog = new Composite(dialogShell,SWT.NULL);
			lblGroupName = new CLabel(compGroupAddDialog,SWT.NULL);
			txtGroupName = new Text(compGroupAddDialog,SWT.BORDER);
			lblDescription = new CLabel(compGroupAddDialog,SWT.NULL);
			txtDescription = new Text(compGroupAddDialog,SWT.SINGLE| SWT.BORDER);
			btnDelete = new Button(compGroupAddDialog,SWT.PUSH| SWT.CENTER);
			btnUpdate = new Button(compGroupAddDialog,SWT.PUSH| SWT.CENTER);
			btnGroupAdd = new Button(compGroupAddDialog,SWT.PUSH| SWT.CENTER);
			tableCurGroups = new Table(dialogShell,SWT.FULL_SELECTION| SWT.H_SCROLL| SWT.V_SCROLL| SWT.BORDER);
			tableColumnName = new TableColumn(tableCurGroups,SWT.NULL);
			tableColumnDescription = new TableColumn(tableCurGroups,SWT.NULL);
	
			dialogShell.setSize(new org.eclipse.swt.graphics.Point(433,229));
	
			GridData compGroupAddDialogLData = new GridData();
			compGroupAddDialogLData.verticalAlignment = GridData.CENTER;
			compGroupAddDialogLData.horizontalAlignment = GridData.FILL;
			compGroupAddDialogLData.widthHint = -1;
			compGroupAddDialogLData.heightHint = 85;
			compGroupAddDialogLData.horizontalIndent = 0;
			compGroupAddDialogLData.horizontalSpan = 1;
			compGroupAddDialogLData.verticalSpan = 1;
			compGroupAddDialogLData.grabExcessHorizontalSpace = true;
			compGroupAddDialogLData.grabExcessVerticalSpace = false;
			compGroupAddDialog.setLayoutData(compGroupAddDialogLData);
			compGroupAddDialog.setSize(new org.eclipse.swt.graphics.Point(433,85));
			final Color compGroupAddDialogbackground = new Color(Display.getDefault(),255,255,255);
			compGroupAddDialog.setBackground(compGroupAddDialogbackground);
	
			GridData lblGroupNameLData = new GridData();
			lblGroupNameLData.verticalAlignment = GridData.CENTER;
			lblGroupNameLData.horizontalAlignment = GridData.END;
			lblGroupNameLData.widthHint = 56;
			lblGroupNameLData.heightHint = 20;
			lblGroupNameLData.horizontalIndent = 0;
			lblGroupNameLData.horizontalSpan = 1;
			lblGroupNameLData.verticalSpan = 1;
			lblGroupNameLData.grabExcessHorizontalSpace = false;
			lblGroupNameLData.grabExcessVerticalSpace = false;
			lblGroupName.setLayoutData(lblGroupNameLData);
			lblGroupName.setText(Messages.getString("CurUIGroupAddDialog.0")); //$NON-NLS-1$
			lblGroupName.setSize(new org.eclipse.swt.graphics.Point(56,20));
	
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
			lblDescription.setText(Messages.getString("CurUIGroupAddDialog.1")); //$NON-NLS-1$
	
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
			btnDelete.setText(Messages.getString("CurUIGroupAddDialog.2")); //$NON-NLS-1$
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
			btnUpdate.setText(Messages.getString("CurUIGroupAddDialog.3")); //$NON-NLS-1$
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
			btnGroupAdd.setText(Messages.getString("CurUIGroupAddDialog.4")); //$NON-NLS-1$
			btnGroupAdd.addMouseListener( new MouseAdapter() {
				public void mouseDoubleClick(MouseEvent evt) {
					btnGroupAddMouseDoubleClick(evt);
				}
				public void mouseUp(MouseEvent evt) {
					btnGroupAddMouseUp(evt);
				}
			});
			GridLayout compGroupAddDialogLayout = new GridLayout(3, true);
			compGroupAddDialog.setLayout(compGroupAddDialogLayout);
			compGroupAddDialogLayout.marginWidth = 5;
			compGroupAddDialogLayout.marginHeight = 5;
			compGroupAddDialogLayout.numColumns = 3;
			compGroupAddDialogLayout.makeColumnsEqualWidth = false;
			compGroupAddDialogLayout.horizontalSpacing = 5;
			compGroupAddDialogLayout.verticalSpacing = 5;
			compGroupAddDialog.layout();
	
			GridData tableCurGroupsLData = new GridData();
			tableCurGroupsLData.verticalAlignment = GridData.FILL;
			tableCurGroupsLData.horizontalAlignment = GridData.FILL;
			tableCurGroupsLData.widthHint = -1;
			tableCurGroupsLData.heightHint = -1;
			tableCurGroupsLData.horizontalIndent = 0;
			tableCurGroupsLData.horizontalSpan = 1;
			tableCurGroupsLData.verticalSpan = 1;
			tableCurGroupsLData.grabExcessHorizontalSpace = true;
			tableCurGroupsLData.grabExcessVerticalSpace = true;
			tableCurGroups.setLayoutData(tableCurGroupsLData);
			tableCurGroups.setHeaderVisible(true);
			tableCurGroups.setLinesVisible(true);
			tableCurGroups.setSize(new org.eclipse.swt.graphics.Point(413,124));
			tableCurGroups.addMouseListener( new MouseAdapter() {
				public void mouseDoubleClick(MouseEvent evt) {
					tableCurGroupsMouseDoubleClick(evt);
				}
			});
	
			tableColumnName.setText(Messages.getString("CurUIGroupAddDialog.0")); //$NON-NLS-1$
			tableColumnName.setWidth(150);
	
			tableColumnDescription.setText(Messages.getString("CurUIGroupAddDialog.1")); //$NON-NLS-1$
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
					compGroupAddDialogbackground.dispose();
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
	public void postInitGUI(){Point parentLocation =this.getParent().getLocation();
	Point parentSize = this.getParent().getSize();	
    Point dialogSize = dialogShell.getSize();
     
    int location_X = (parentLocation.x + parentSize.x)/2 - (dialogSize.x/2);
    int location_Y = (parentLocation.y + parentSize.y)/2 - (dialogSize.y/2);
    
    dialogShell.setLocation(location_X,location_Y);
	fillTable();
	}

    public void fillTable(){
    try{
    tableCurGroups.removeAll();
    List list = blCardAdd.getCurrentGroups();
    
    TurqCurrentGroup curGroup;
    TableItem item;
    for(int i=0;i<list.size();i++){
    curGroup = (TurqCurrentGroup)list.get(i);
    item = new TableItem(tableCurGroups,SWT.NULL);
    item.setText(new String[]{curGroup.getGroupsName(),curGroup.getGroupsDescription()});
    item.setData(curGroup);     
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
	    msg.setMessage(Messages.getString("CurUIGroupAddDialog.7")); //$NON-NLS-1$
	    int result = msg.open();
	    if(result==SWT.OK){
	   
	    blCardAdd.deleteObject(txtGroupName.getData());
	   
	   
	    btnDelete.setEnabled(false);
	    btnUpdate.setEnabled(false);
	    btnGroupAdd.setEnabled(true);
	    txtGroupName.setText(""); //$NON-NLS-1$
	    txtDescription.setText("");	 //$NON-NLS-1$
	    msg2.setMessage(Messages.getString("CurUIGroupAddDialog.8")); //$NON-NLS-1$
		msg2.open();
		fillTable();
	    
	    }
	    
		}
		catch(Exception ex){
			 btnDelete.setEnabled(false);
			    btnUpdate.setEnabled(false);
			    btnGroupAdd.setEnabled(true);
			    txtGroupName.setText(Messages.getString("CurUIGroupAddDialog.9")); //$NON-NLS-1$
			    txtDescription.setText("");	 //$NON-NLS-1$
		msg2.setMessage(Messages.getString("CurUIGroupAddDialog.13"));	 //$NON-NLS-1$
		msg2.open();
		ex.printStackTrace();
		}
		
		
	}
	

	/** Auto-generated event handler method */
	protected void btnUpdateMouseUp(MouseEvent evt){
		MessageBox msg = new MessageBox(this.getParent());
	try{
		 if(txtGroupName.getText().trim().equals("")){ //$NON-NLS-1$
		    
		    msg.setMessage(Messages.getString("CurUIGroupAddDialog.15")); //$NON-NLS-1$
		    msg.open();
		    }
	else{
		
	TurqCurrentGroup invGroup = (TurqCurrentGroup)txtGroupName.getData();
	invGroup.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
	invGroup.setLastModified(new java.sql.Date(cal.getTime().getTime()));
	invGroup.setGroupsName(txtGroupName.getText().trim());
	invGroup.setGroupsDescription(txtDescription.getText().trim());
	blCardAdd.updateObject(invGroup);
	
	btnDelete.setEnabled(false);
	btnUpdate.setEnabled(false);
	btnGroupAdd.setEnabled(true);
	txtGroupName.setText(""); //$NON-NLS-1$
	txtDescription.setText("");	 //$NON-NLS-1$
	msg.setMessage(Messages.getString("CurUIGroupAddDialog.19")); //$NON-NLS-1$
	msg.open();
	fillTable();
		    }
	
	
	}
	catch(Exception ex){
	btnDelete.setEnabled(false);
	btnUpdate.setEnabled(false);
	btnGroupAdd.setEnabled(true);
	txtGroupName.setText(""); //$NON-NLS-1$
	txtDescription.setText("");	 //$NON-NLS-1$
	msg.setMessage(Messages.getString("CurUIGroupAddDialog.22")); //$NON-NLS-1$
	msg.open();
	ex.printStackTrace();
	}
	}

	/** Auto-generated event handler method */
	protected void btnGroupAddMouseDoubleClick(MouseEvent evt){
		
	}

	/** Auto-generated event handler method */
	protected void btnGroupAddMouseUp(MouseEvent evt){
		MessageBox msg = new MessageBox(this.getParent());
		try{
		
		
	    if(txtGroupName.getText().trim().equals("")){ //$NON-NLS-1$
	    
	    msg.setMessage(Messages.getString("CurUIGroupAddDialog.24")); //$NON-NLS-1$
	    msg.open();
	    }
	    else{
	    
	    blCardAdd.saveCurGroup(txtGroupName.getText().trim(),txtDescription.getText().trim());
	    msg.setMessage(Messages.getString("CurUIGroupAddDialog.25")); //$NON-NLS-1$
	    txtGroupName.setText(""); //$NON-NLS-1$
	    txtDescription.setText(""); //$NON-NLS-1$
	    fillTable();
	    msg.open();	    
	    }		
		
		}
		catch(HibernateException ex){
		ex.printStackTrace();
		msg.setText(Messages.getString("CurUIGroupAddDialog.28")); //$NON-NLS-1$
	    msg.open();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

	/** Auto-generated event handler method */
	protected void tableCurGroupsMouseDoubleClick(MouseEvent evt){
		TableItem item;
		if(tableCurGroups.getSelection().length>0){
		item = tableCurGroups.getSelection()[0];
		txtGroupName.setText(item.getText(0));
		txtDescription.setText(item.getText(1));
		txtGroupName.setData(item.getData());
		btnUpdate.setEnabled(true);
		btnDelete.setEnabled(true);
		btnGroupAdd.setEnabled(false);
		}
	}
}
