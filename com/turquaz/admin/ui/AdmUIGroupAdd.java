package com.turquaz.admin.ui;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
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
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;

import com.turquaz.admin.bl.AdmBLGroupAdd;
import com.turquaz.engine.ui.component.SecureComposite;
public class AdmUIGroupAdd extends org.eclipse.swt.widgets.Composite implements SecureComposite{
	private CLabel lblAdmGroupName;
	private Text txtAdmGroupName;
	private Text txtAdmGroupDesc;
	private CLabel lblAdmGroupDesc;
	
	private AdmBLGroupAdd blGroupAdd = new AdmBLGroupAdd();

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
		AdmUIGroupAdd inst = new AdmUIGroupAdd(shell, SWT.NULL);
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

	public AdmUIGroupAdd(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();
			thisLayout.numColumns = 2;
			this.setLayout(thisLayout);
			this.setSize(250, 181);
			{
				lblAdmGroupName = new CLabel(this, SWT.NONE);
				lblAdmGroupName.setText("Group Name");
			}
			{
				txtAdmGroupName = new Text(this, SWT.NONE);
			}
			{
				lblAdmGroupDesc = new CLabel(this, SWT.NONE);
				lblAdmGroupDesc.setText("Group Description");
				GridData lblAdmGroupDescLData = new GridData();
				lblAdmGroupDescLData.verticalAlignment = GridData.BEGINNING;
				lblAdmGroupDesc.setLayoutData(lblAdmGroupDescLData);
			}
			{
				txtAdmGroupDesc = new Text(this, SWT.MULTI | SWT.V_SCROLL);
				GridData txtAdmGroupDescLData = new GridData();
				txtAdmGroupDescLData.widthHint = 98;
				txtAdmGroupDescLData.heightHint = 44;
				txtAdmGroupDesc.setLayoutData(txtAdmGroupDescLData);
			}
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public boolean verifyFields(){
		MessageBox msg= new MessageBox(this.getShell(),SWT.NULL);
		
		if (txtAdmGroupName.getText().trim().length()==0)
		{
			msg.setMessage("Please fill group name!..");
			msg.open();
			return false;
		}
		return true;
	}
	
	public void save() {
		
		if (verifyFields()){
			try{
				blGroupAdd.saveGroup(txtAdmGroupName.getText().trim(),txtAdmGroupDesc.getText().trim());
				newForm();
				
			}
			catch (Exception ex) {
				ex.printStackTrace();
				
			}
				
		}
	}
	public void search() {
		
	}
	public void newForm(){
		txtAdmGroupName.setText("");
		txtAdmGroupDesc.setText("");
	}
	public void delete(){
		
	}

}
