package com.turquaz.engine.ui;

import java.io.File;

import org.eclipse.jface.wizard.WizardDialog;
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

import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.ui.wizards.EngUIDatabaseConnectionWizard;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
public class EngUIEntryFrame extends org.eclipse.swt.widgets.Composite {
	private CLabel lblUserName;
	private Text txtUserName;
	private Button btnCancel;
	private Button btnOk;
	private Text txtPassword;
	private CLabel lblPassword;
	private Label label1;
	private EngBLCommon blCommon = new EngBLCommon();

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
		EngUIEntryFrame inst = new EngUIEntryFrame(shell, SWT.NULL);
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

	public EngUIEntryFrame(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			preInitGui();
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			this.setSize(384, 147);
			{
				lblUserName = new CLabel(this, SWT.NONE);
				lblUserName.setText("Username");
			}
			{
				txtUserName = new Text(this, SWT.NONE);
				GridData txtUserNameLData = new GridData();
				txtUserNameLData.heightHint = 16;
				txtUserNameLData.grabExcessHorizontalSpace = true;
				txtUserNameLData.horizontalAlignment = GridData.FILL;

				txtUserName.setLayoutData(txtUserNameLData);
			}
			{
				lblPassword = new CLabel(this, SWT.NONE);
				lblPassword.setText("Password");
			}
			{
				txtPassword = new Text(this, SWT.PASSWORD);
				GridData txtPasswordLData = new GridData();
				txtPassword.setSize(305, 16);
				txtPasswordLData.heightHint = 16;
				txtPasswordLData.horizontalAlignment = GridData.FILL;
				txtPassword.setLayoutData(txtPasswordLData);
			}
			{
				label1 = new Label(this, SWT.SEPARATOR | SWT.HORIZONTAL);
				label1.setText("label1");
				GridData label1LData = new GridData();
				label1LData.horizontalSpan = 2;
				label1LData.horizontalAlignment = GridData.FILL;
				label1LData.grabExcessHorizontalSpace = true;
				label1LData.heightHint = 2;
				label1.setLayoutData(label1LData);
			}
			{
				btnCancel = new Button(this, SWT.PUSH | SWT.CENTER);
				btnCancel.setText("Cancel");
				GridData btnCancelLData = new GridData();
				btnCancel.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent evt) {
						btnCancelMouseUp(evt);

					}
				});
				btnCancel.setSize(70, 24);
				btnCancelLData.horizontalAlignment = GridData.END;
				btnCancelLData.widthHint = 70;
				btnCancelLData.heightHint = 24;
				btnCancel.setLayoutData(btnCancelLData);
			}
			{
				btnOk = new Button(this, SWT.PUSH | SWT.CENTER);
				btnOk.setText("Ok");
				GridData btnOkLData = new GridData();
				btnOk.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent evt) {
						btnOkMouseUp(evt);
					}
				});
				btnOkLData.horizontalAlignment = GridData.END;
				btnOkLData.widthHint = 70;
				btnOkLData.heightHint = 24;
				btnOk.setLayoutData(btnOkLData);
			}
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void btnCancelMouseUp(MouseEvent e){
		
		this.getShell().dispose();
	}
	public void btnOkMouseUp(MouseEvent e){
		MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
		try{
		if(blCommon.checkUserPass(txtUserName.getText(),txtPassword.getText())){
			this.getShell().dispose();
			EngUIMainFrame.showGUI2();
			
			
		}
		else {
		msg.setMessage("Wrong username or password");
		msg.open();
		}
		}
		catch(Exception ex){
			
			msg.setMessage(ex.getMessage());
			msg.open();
		}
	}
	public void preInitGui(){
		
		
		
		File config = new File("config.xml");
		if(!config.exists()){
			EngUIDatabaseConnectionWizard wizard = new EngUIDatabaseConnectionWizard();
			WizardDialog dialog = new WizardDialog(this.getShell(),wizard);
			dialog.open();	
		}
		
		EngDALSessionFactory.init();
		
		
	}
}
