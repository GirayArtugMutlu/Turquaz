package com.turquaz.inventory.ui;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.GridData;

import com.turquaz.engine.bl.EngBLInventoryGroups;
import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.SecureComposite;
import com.turquaz.inventory.Messages;
import com.turquaz.inventory.bl.InvBLCardAdd;
import com.turquaz.inventory.ui.comp.InvMainGroupPicker;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;


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
public class InvUIInventoryGroupAdd extends org.eclipse.swt.widgets.Composite implements SecureComposite{
	private CLabel lblMainGroup;
	private InvMainGroupPicker txtMainGroup;
	private CLabel lblDefinition;
	private Text txtDefinition;
	private Text txtGroupName;
	private CLabel lblGroupName;

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
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		InvUIInventoryGroupAdd inst = new InvUIInventoryGroupAdd(shell, SWT.NULL);
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

	public InvUIInventoryGroupAdd(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			this.setSize(493, 216);
            {
                lblMainGroup = new CLabel(this, SWT.NONE);
                lblMainGroup.setText(Messages.getString("InvUIInventoryGroupAdd.0")); //$NON-NLS-1$
                lblMainGroup.setVisible(false);
            }
            {
                txtMainGroup = new InvMainGroupPicker(this, SWT.NONE);
                GridData txtMainGroupLData = new GridData();
                txtMainGroup.setVisible(false);
                txtMainGroupLData.widthHint = 164;
                txtMainGroupLData.heightHint = 19;
                txtMainGroup.setLayoutData(txtMainGroupLData);
            }
            {
                lblGroupName = new CLabel(this, SWT.NONE);
                lblGroupName.setText(Messages.getString("InvUIInventoryGroupAdd.1")); //$NON-NLS-1$
            }
            {
                txtGroupName = new Text(this, SWT.NONE);
                GridData txtGroupNameLData = new GridData();
                txtGroupNameLData.widthHint = 161;
                txtGroupNameLData.heightHint = 19;
                txtGroupName.setLayoutData(txtGroupNameLData);
            }
            {
                lblDefinition = new CLabel(this, SWT.NONE);
                lblDefinition.setText(Messages.getString("InvUIInventoryGroupAdd.2")); //$NON-NLS-1$
            }
            {
                txtDefinition = new Text(this, SWT.NONE);
                GridData txtDefinitionLData = new GridData();
                txtDefinitionLData.widthHint = 292;
                txtDefinitionLData.heightHint = 19;
                txtDefinition.setLayoutData(txtDefinitionLData);
            }
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public boolean verifyFields(){
	    if(txtGroupName.getText().trim().equals("")){ //$NON-NLS-1$
	        
	        EngUICommon.showMessageBox(getShell(),Messages.getString("InvUIInventoryGroupAdd.4"),SWT.ICON_WARNING); //$NON-NLS-1$
	        txtGroupName.setFocus();
	        return false;
	    }
	    return true;
	}
    public void newForm() {
       

		InvUIInventoryGroupAdd cardAdd = new InvUIInventoryGroupAdd(this.getParent(), this
				.getStyle());
		CTabFolder tabfld = (CTabFolder) this.getParent();
		tabfld.getSelection().setControl(cardAdd);
		this.dispose();

    }
    public void save(){
        InvBLCardAdd blCardAdd =new InvBLCardAdd();
        try{
            if(verifyFields()){
            	InvBLCardAdd.saveInvGroup(txtGroupName.getText(),txtDefinition.getText(),(TurqInventoryGroup)txtMainGroup.getData());
                EngUICommon.showSavedSuccesfullyMessage(getShell());
                EngBLInventoryGroups.RefreshContentAsistantMap();
                  newForm();
            }
             
             
        }
        catch(Exception ex){
            ex.printStackTrace();
            EngUICommon.showMessageBox(getShell(),ex.getMessage().toString(),SWT.ICON_ERROR);
        }
    }
    
    public void update(TurqInventoryGroup group){
        
        InvBLCardAdd blCardAdd =new InvBLCardAdd();
        try{
            if(verifyFields()){ /*
                blCardAdd.updateInvGroup(txtGroupName.getText(),txtDefinition.getText(),group);
                EngUICommon.showSavedSuccesfullyMessage(getShell());
                EngBLInventoryGroups.RefreshContentAsistantMap();*/
                  
            }
             
             
        }
        catch(Exception ex){
            ex.printStackTrace();
            EngUICommon.showMessageBox(getShell(),ex.getMessage().toString(),SWT.ICON_ERROR);
        }
        

    }
    
    
    public void save(TurqInventoryGroup mainGroup) {
       InvBLCardAdd blCardAdd =new InvBLCardAdd();
        try{
            if(verifyFields()){
            	InvBLCardAdd.saveInvGroup(txtGroupName.getText(),txtDefinition.getText(),mainGroup);
                EngUICommon.showSavedSuccesfullyMessage(getShell());
                EngBLInventoryGroups.RefreshContentAsistantMap();
                  
            }
             
             
        }
        catch(Exception ex){
            ex.printStackTrace();
            EngUICommon.showMessageBox(getShell(),ex.getMessage().toString(),SWT.ICON_ERROR);
        }
        

    }
    
    public Text getTxtDefinition() {
        return txtDefinition;
    }
    public void setTxtDefinition(Text txtDefinition) {
        this.txtDefinition = txtDefinition;
    }
    public Text getTxtGroupName() {
        return txtGroupName;
    }
    public void setTxtGroupName(Text txtGroupName) {
        this.txtGroupName = txtGroupName;
    }
}
