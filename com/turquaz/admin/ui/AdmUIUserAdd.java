package com.turquaz.admin.ui;

import java.util.HashMap;
import java.util.List;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
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

import org.eclipse.swt.layout.GridData;


import com.turquaz.admin.bl.AdmBLUserAdd;
import com.turquaz.current.ui.CurUITransactionAdd;
import com.turquaz.engine.dal.TurqCurrentGroup;
import com.turquaz.engine.dal.TurqGroup;
import com.turquaz.engine.ui.component.SecureComposite;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Text;
import com.turquaz.engine.ui.component.RegisterGroupComposite;
public class AdmUIUserAdd extends Composite implements SecureComposite {
	private CLabel lblUsername;
	private Text txtUsername;
	private Text txtPassword;
	private Text txtRePassword;
	private Text txtDescription;
	private RegisterGroupComposite registeredGroups;
	private CLabel lblGroups;
	private CLabel lblDescription;
	private Text txtRealName;
	private CLabel lblRealName;
	private CLabel lblReTypePassword;
	private CLabel lblPassWord;
    private AdmBLUserAdd blUserAdd = new AdmBLUserAdd();

	/**
	* Auto-generated method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void showGUI() {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		AdmUIUserAdd inst = new AdmUIUserAdd(shell, SWT.NULL);
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

	public AdmUIUserAdd(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			this.setSize(452, 320);
			{
				lblUsername = new CLabel(this, SWT.NONE);
				GridData lblUsernameLData = new GridData();
				lblUsername.setText("Username");
				lblUsernameLData.widthHint = 104;
				lblUsernameLData.heightHint = 20;
				lblUsername.setLayoutData(lblUsernameLData);
			}
			{
				txtUsername = new Text(this, SWT.NONE);
				GridData txtUsernameLData = new GridData();
				txtUsernameLData.heightHint = 17;
				txtUsernameLData.widthHint = 190;
				txtUsername.setLayoutData(txtUsernameLData);
			}
			{
				lblPassWord = new CLabel(this, SWT.NONE);
				lblPassWord.setText("Password");
			}
			{
				txtPassword = new Text(this, SWT.NONE);
				GridData txtPasswordLData = new GridData();
				txtPasswordLData.heightHint = 18;
				txtPasswordLData.horizontalAlignment = GridData.FILL;
				txtPassword.setLayoutData(txtPasswordLData);
			}
			{
				lblReTypePassword = new CLabel(this, SWT.NONE);
				lblReTypePassword.setText("Re-Type Password");
				GridData lblReTypePasswordLData = new GridData();
				lblReTypePasswordLData.widthHint = 114;
				lblReTypePasswordLData.heightHint = 19;
				lblReTypePassword.setLayoutData(lblReTypePasswordLData);
			}
			{
				txtRePassword = new Text(this, SWT.NONE);
				GridData txtRePasswordLData = new GridData();
				txtRePasswordLData.heightHint = 18;
				txtRePasswordLData.horizontalAlignment = GridData.FILL;
				txtRePassword.setLayoutData(txtRePasswordLData);
			}
			{
				lblRealName = new CLabel(this, SWT.NONE);
				lblRealName.setText("Real Name");
				GridData lblRealNameLData = new GridData();
				lblRealNameLData.widthHint = 90;
				lblRealNameLData.heightHint = 17;
				lblRealName.setLayoutData(lblRealNameLData);
			}
			{
				txtRealName = new Text(this, SWT.NONE);
				GridData txtRealNameLData = new GridData();
				txtRealNameLData.horizontalAlignment = GridData.FILL;
				txtRealNameLData.heightHint = 17;
				txtRealName.setLayoutData(txtRealNameLData);
			}
			{
				lblDescription = new CLabel(this, SWT.NONE);
				lblDescription.setText("Description");
				GridData lblDescriptionLData = new GridData();
				lblDescriptionLData.widthHint = 107;
				lblDescriptionLData.heightHint = 17;
				lblDescriptionLData.verticalAlignment = GridData.BEGINNING;
				lblDescription.setLayoutData(lblDescriptionLData);
			}
			{
				txtDescription = new Text(this, SWT.MULTI | SWT.V_SCROLL);
				GridData txtDescriptionLData = new GridData();
				txtDescriptionLData.horizontalAlignment = GridData.FILL;
				txtDescriptionLData.heightHint = 59;
				txtDescription.setLayoutData(txtDescriptionLData);
			}
			{
				lblGroups = new CLabel(this, SWT.NONE);
				lblGroups.setText("Groups");
				GridData lblGroupsLData = new GridData();
				lblGroupsLData.widthHint = 105;
				lblGroupsLData.heightHint = 34;
				lblGroupsLData.verticalAlignment = GridData.BEGINNING;
				lblGroups.setLayoutData(lblGroupsLData);
			}
			{
				registeredGroups = new RegisterGroupComposite(
					this,
					SWT.NONE);
				GridData tableAllGroupsLData = new GridData();
				tableAllGroupsLData.widthHint = 139;
				tableAllGroupsLData.heightHint = 92;
				GridData registerGroupComposite1LData = new GridData();
				registerGroupComposite1LData.widthHint = 191;
				registerGroupComposite1LData.heightHint = 127;
				registeredGroups.setLayoutData(registerGroupComposite1LData);
				registeredGroups.getTableAllGroups().setLayoutData(tableAllGroupsLData);
				
				postInitGUI();
				
			}
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void postInitGUI(){
	
		try{
		HashMap groupMap = new HashMap(); 
		
		List list = blUserAdd.getGroups();
		TurqGroup group;
		
		for(int i=0; i<list.size();i++){
		group = (TurqGroup)list.get(i);
		groupMap.put(group.getGroupsName(),group);
		}
		registeredGroups.fillTableAllGroups(groupMap);
		
		}
		catch(Exception ex){
			
			ex.printStackTrace();
		}
		
		
		
	}
	
	public boolean verifyFields(){
		return true;
	}
	
	public void saveUserGroups(Integer userid)throws Exception{
		try{
		TableItem items[]= registeredGroups.getTableAllGroups().getItems();
		for(int i=0; i<items.length;i++){
			if(items[i].getChecked()){
			blUserAdd.saveUserGroups(userid,items[i].getData());	
				
			}
			
		}
		
		
	
	}
		catch(Exception ex){
			throw ex;
		}
		
		
	}
	
	public void save(){
		try{
		if(verifyFields())
		{
			
		Integer userId =blUserAdd.saveUser(txtUsername.getText(),txtPassword.getText(),
						   txtRealName.getText(),txtDescription.getText());
		saveUserGroups(userId);
			
		newForm();
			
		}	
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void search(){
		
	}
	public void newForm(){
		
		 AdmUIUserAdd cardAdd = new AdmUIUserAdd(this.getParent(),this.getStyle());
		 CTabFolder tabfld = (CTabFolder)this.getParent();
		 tabfld.getSelection().setControl(cardAdd);	 
		 this.dispose();
		
		
		
	}
	public void delete(){
		
	}

}
