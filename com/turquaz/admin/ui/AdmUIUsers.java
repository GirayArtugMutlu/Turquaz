package com.turquaz.admin.ui;

import java.util.List;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableColumn;

import com.turquaz.admin.bl.AdmBLUserAdd;
import com.turquaz.admin.bl.AdmBLUsers;
import com.turquaz.engine.dal.TurqUser;
import com.turquaz.engine.ui.component.SecureComposite;
public class AdmUIUsers extends org.eclipse.swt.widgets.Composite implements SecureComposite {
	private Table tableUsers;
	private TableColumn tableColumnUsername;
	private TableColumn tableColumnDescription;
	private TableColumn tableColumnRealName;
	AdmBLUsers blUsers = new AdmBLUsers();

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
		AdmUIUsers inst = new AdmUIUsers(shell, SWT.NULL);
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

	public AdmUIUsers(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}
	public void save(){
		
	}
	public void delete(){
		
	}
	public void newForm(){
		
	}
	public void search(){
		
	}
	

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setSize(518, 319);
			{
				tableUsers = new Table(this, SWT.NONE);
				GridData tableUsersLData = new GridData();
				tableUsers.setHeaderVisible(true);
				tableUsers.setLinesVisible(true);
				tableUsersLData.grabExcessHorizontalSpace = true;
				tableUsersLData.grabExcessVerticalSpace = true;
				tableUsersLData.horizontalAlignment = GridData.FILL;
				tableUsersLData.verticalAlignment = GridData.FILL;
				tableUsers.setLayoutData(tableUsersLData);
				{
					tableColumnUsername = new TableColumn(tableUsers, SWT.NONE);
					tableColumnUsername.setText("User Name");
					tableColumnUsername.setWidth(112);
				}
				{
					tableColumnRealName = new TableColumn(tableUsers, SWT.NONE);
					tableColumnRealName.setText("Real Name");
					tableColumnRealName.setWidth(150);
				}
				{
					tableColumnDescription = new TableColumn(
						tableUsers,
						SWT.NONE);
					tableColumnDescription.setText("Description");
					tableColumnDescription.setWidth(200);
				}
			}
			this.layout();
			fillTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void fillTable(){
		try{
			tableUsers.removeAll();
			List list = blUsers.getUsers();
			TurqUser user;
			TableItem item;
			for(int i=0;i<list.size();i++){
				user = (TurqUser)list.get(i);
			   item = new TableItem(tableUsers,SWT.NULL);
			   item.setData(user);
			   item.setText(new String[]{user.getUsername(),user.getUsersRealName(),user.getUsersDescription()});
				
			}
			
			
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

}