
package com.turquaz.inventory.ui;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.SWT;
import com.turquaz.engine.ui.component.SecureComposite;
import com.turquaz.inventory.Messages;
import com.turquaz.inventory.bl.InvBLWarehouseAdd;


/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class InvUIWarehouseAdd extends Composite implements SecureComposite{

	private Text txtWarehouseDescription;
	private CLabel lblDescription;
	private Text txtTelephone;
	private CLabel lblWarehouseTelephone;
	/**
	 * @return Returns the txtTelephone.
	 */
	public Text getTxtTelephone() {
		return txtTelephone;
	}
	/**
	 * @return Returns the txtWarehouseAdres.
	 */
	public Text getTxtWarehouseAdres() {
		return txtWarehouseAdres;
	}
	/**
	 * @return Returns the txtWarehouseCity.
	 */
	public Text getTxtWarehouseCity() {
		return txtWarehouseCity;
	}
	/**
	 * @return Returns the txtWarehouseDescription.
	 */
	public Text getTxtWarehouseDescription() {
		return txtWarehouseDescription;
	}
	/**
	 * @return Returns the txtWarehouseName.
	 */
	public Text getTxtWarehouseName() {
		return txtWarehouseName;
	}
	private Text txtWarehouseAdres;
	private CLabel lblWarehouseAdres;
	private Text txtWarehouseCity;
	private CLabel lblWareHouseCity;
	private Text txtWarehouseName;
	private CLabel lblWarehouseName;
	
	InvBLWarehouseAdd whBLAdd = new InvBLWarehouseAdd();
	
	public InvUIWarehouseAdd(Composite parent, int style) {
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
	
			lblWarehouseName = new CLabel(this,SWT.NULL);
			txtWarehouseName = new Text(this,SWT.NULL);
			lblWarehouseAdres = new CLabel(this,SWT.NULL);
			txtWarehouseAdres = new Text(this,SWT.MULTI| SWT.WRAP| SWT.H_SCROLL| SWT.V_SCROLL);
			lblWareHouseCity = new CLabel(this,SWT.NULL);
			txtWarehouseCity = new Text(this,SWT.NULL);
			lblWarehouseTelephone = new CLabel(this,SWT.NULL);
			txtTelephone = new Text(this,SWT.NULL);
			lblDescription = new CLabel(this,SWT.NULL);
			txtWarehouseDescription = new Text(this,SWT.MULTI| SWT.WRAP| SWT.H_SCROLL| SWT.V_SCROLL);
	
			this.setSize(new org.eclipse.swt.graphics.Point(593,343));
	
			GridData lblWarehouseNameLData = new GridData();
			lblWarehouseNameLData.verticalAlignment = GridData.CENTER;
			lblWarehouseNameLData.horizontalAlignment = GridData.BEGINNING;
			lblWarehouseNameLData.widthHint = -1;
			lblWarehouseNameLData.heightHint = -1;
			lblWarehouseNameLData.horizontalIndent = 0;
			lblWarehouseNameLData.horizontalSpan = 1;
			lblWarehouseNameLData.verticalSpan = 1;
			lblWarehouseNameLData.grabExcessHorizontalSpace = false;
			lblWarehouseNameLData.grabExcessVerticalSpace = false;
			lblWarehouseName.setLayoutData(lblWarehouseNameLData);
			lblWarehouseName.setText("Warehouse Name");
	
			GridData txtWarehouseNameLData = new GridData();
			txtWarehouseNameLData.verticalAlignment = GridData.CENTER;
			txtWarehouseNameLData.horizontalAlignment = GridData.BEGINNING;
			txtWarehouseNameLData.widthHint = 259;
			txtWarehouseNameLData.heightHint = 17;
			txtWarehouseNameLData.horizontalIndent = 0;
			txtWarehouseNameLData.horizontalSpan = 1;
			txtWarehouseNameLData.verticalSpan = 1;
			txtWarehouseNameLData.grabExcessHorizontalSpace = false;
			txtWarehouseNameLData.grabExcessVerticalSpace = false;
			txtWarehouseName.setLayoutData(txtWarehouseNameLData);
			txtWarehouseName.setTextLimit(50);
			txtWarehouseName.setSize(new org.eclipse.swt.graphics.Point(259,17));
	
			GridData lblWarehouseAdresLData = new GridData();
			lblWarehouseAdresLData.verticalAlignment = GridData.BEGINNING;
			lblWarehouseAdresLData.horizontalAlignment = GridData.BEGINNING;
			lblWarehouseAdresLData.widthHint = -1;
			lblWarehouseAdresLData.heightHint = -1;
			lblWarehouseAdresLData.horizontalIndent = 0;
			lblWarehouseAdresLData.horizontalSpan = 1;
			lblWarehouseAdresLData.verticalSpan = 1;
			lblWarehouseAdresLData.grabExcessHorizontalSpace = false;
			lblWarehouseAdresLData.grabExcessVerticalSpace = false;
			lblWarehouseAdres.setLayoutData(lblWarehouseAdresLData);
			lblWarehouseAdres.setText("Address");
	
			GridData txtWarehouseAdresLData = new GridData();
			txtWarehouseAdresLData.verticalAlignment = GridData.CENTER;
			txtWarehouseAdresLData.horizontalAlignment = GridData.BEGINNING;
			txtWarehouseAdresLData.widthHint = 323;
			txtWarehouseAdresLData.heightHint = 74;
			txtWarehouseAdresLData.horizontalIndent = 0;
			txtWarehouseAdresLData.horizontalSpan = 1;
			txtWarehouseAdresLData.verticalSpan = 1;
			txtWarehouseAdresLData.grabExcessHorizontalSpace = false;
			txtWarehouseAdresLData.grabExcessVerticalSpace = false;
			txtWarehouseAdres.setLayoutData(txtWarehouseAdresLData);
			txtWarehouseAdres.setTextLimit(250);
			txtWarehouseAdres.setSize(new org.eclipse.swt.graphics.Point(323,74));
	
			GridData lblWareHouseCityLData = new GridData();
			lblWareHouseCityLData.verticalAlignment = GridData.CENTER;
			lblWareHouseCityLData.horizontalAlignment = GridData.BEGINNING;
			lblWareHouseCityLData.widthHint = -1;
			lblWareHouseCityLData.heightHint = -1;
			lblWareHouseCityLData.horizontalIndent = 0;
			lblWareHouseCityLData.horizontalSpan = 1;
			lblWareHouseCityLData.verticalSpan = 1;
			lblWareHouseCityLData.grabExcessHorizontalSpace = false;
			lblWareHouseCityLData.grabExcessVerticalSpace = false;
			lblWareHouseCity.setLayoutData(lblWareHouseCityLData);
			lblWareHouseCity.setText("City");
	
			GridData txtWarehouseCityLData = new GridData();
			txtWarehouseCityLData.verticalAlignment = GridData.CENTER;
			txtWarehouseCityLData.horizontalAlignment = GridData.BEGINNING;
			txtWarehouseCityLData.widthHint = 153;
			txtWarehouseCityLData.heightHint = 17;
			txtWarehouseCityLData.horizontalIndent = 0;
			txtWarehouseCityLData.horizontalSpan = 1;
			txtWarehouseCityLData.verticalSpan = 1;
			txtWarehouseCityLData.grabExcessHorizontalSpace = false;
			txtWarehouseCityLData.grabExcessVerticalSpace = false;
			txtWarehouseCity.setLayoutData(txtWarehouseCityLData);
			txtWarehouseCity.setTextLimit(50);
			txtWarehouseCity.setSize(new org.eclipse.swt.graphics.Point(153,17));
	
			GridData lblWarehouseTelephoneLData = new GridData();
			lblWarehouseTelephoneLData.verticalAlignment = GridData.CENTER;
			lblWarehouseTelephoneLData.horizontalAlignment = GridData.BEGINNING;
			lblWarehouseTelephoneLData.widthHint = 56;
			lblWarehouseTelephoneLData.heightHint = 19;
			lblWarehouseTelephoneLData.horizontalIndent = 0;
			lblWarehouseTelephoneLData.horizontalSpan = 1;
			lblWarehouseTelephoneLData.verticalSpan = 1;
			lblWarehouseTelephoneLData.grabExcessHorizontalSpace = false;
			lblWarehouseTelephoneLData.grabExcessVerticalSpace = false;
			lblWarehouseTelephone.setLayoutData(lblWarehouseTelephoneLData);
			lblWarehouseTelephone.setText("Telephone");
			lblWarehouseTelephone.setSize(new org.eclipse.swt.graphics.Point(56,19));
	
			GridData txtTelephoneLData = new GridData();
			txtTelephoneLData.verticalAlignment = GridData.CENTER;
			txtTelephoneLData.horizontalAlignment = GridData.BEGINNING;
			txtTelephoneLData.widthHint = 153;
			txtTelephoneLData.heightHint = 17;
			txtTelephoneLData.horizontalIndent = 0;
			txtTelephoneLData.horizontalSpan = 1;
			txtTelephoneLData.verticalSpan = 1;
			txtTelephoneLData.grabExcessHorizontalSpace = false;
			txtTelephoneLData.grabExcessVerticalSpace = false;
			txtTelephone.setLayoutData(txtTelephoneLData);
			txtTelephone.setSize(new org.eclipse.swt.graphics.Point(153,17));
	
			GridData lblDescriptionLData = new GridData();
			lblDescriptionLData.verticalAlignment = GridData.BEGINNING;
			lblDescriptionLData.horizontalAlignment = GridData.BEGINNING;
			lblDescriptionLData.widthHint = -1;
			lblDescriptionLData.heightHint = -1;
			lblDescriptionLData.horizontalIndent = 0;
			lblDescriptionLData.horizontalSpan = 1;
			lblDescriptionLData.verticalSpan = 1;
			lblDescriptionLData.grabExcessHorizontalSpace = false;
			lblDescriptionLData.grabExcessVerticalSpace = false;
			lblDescription.setLayoutData(lblDescriptionLData);
			lblDescription.setText("Description");
	
			GridData txtWarehouseDescriptionLData = new GridData();
			txtWarehouseDescriptionLData.verticalAlignment = GridData.CENTER;
			txtWarehouseDescriptionLData.horizontalAlignment = GridData.BEGINNING;
			txtWarehouseDescriptionLData.widthHint = 347;
			txtWarehouseDescriptionLData.heightHint = 93;
			txtWarehouseDescriptionLData.horizontalIndent = 0;
			txtWarehouseDescriptionLData.horizontalSpan = 1;
			txtWarehouseDescriptionLData.verticalSpan = 1;
			txtWarehouseDescriptionLData.grabExcessHorizontalSpace = false;
			txtWarehouseDescriptionLData.grabExcessVerticalSpace = false;
			txtWarehouseDescription.setLayoutData(txtWarehouseDescriptionLData);
			txtWarehouseDescription.setTextLimit(50);
			txtWarehouseDescription.setSize(new org.eclipse.swt.graphics.Point(347,93));
			GridLayout thisLayout = new GridLayout(2, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 2;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 15;
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

	/** Auto-generated main method */
	public static void main(String[] args){
		showGUI();
	}

	
	boolean verifyFields(){
		
		MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
		
	  if(txtWarehouseName.getText().trim().equals("")){ //$NON-NLS-1$
	  	msg.setMessage(Messages.getString("InvUIWarehouseAdd.6")); //$NON-NLS-1$
	  	msg.open();
	  	return false;
	  }
	  return true;
	 
	}
	public void delete(){
	}
	public void clearFields(){
		txtWarehouseName.setText(""); //$NON-NLS-1$
		txtWarehouseDescription.setText(""); //$NON-NLS-1$
		txtTelephone.setText(""); //$NON-NLS-1$
		txtWarehouseAdres.setText(""); //$NON-NLS-1$
		txtWarehouseCity.setText(""); //$NON-NLS-1$
		
		
	}
	public void save(){
	try{
	
	if(verifyFields()){
	whBLAdd.saveWarehouse(txtWarehouseName.getText().trim(),
						 txtWarehouseDescription.getText().trim(),
						 txtWarehouseAdres.getText().trim(),
						 txtTelephone.getText().trim(),
						 txtWarehouseCity.getText().trim());
	MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
	msg.setMessage(Messages.getString("InvUIWarehouseAdd.12")); //$NON-NLS-1$
	msg.open();
	clearFields();
		}
	
	}
	catch(Exception ex){
	ex.printStackTrace();
	
	}
	
	
	
	
	
	
	
	}
	public void newForm(){
	}
	public void search(){
	}


	/**
	* This static method creates a new instance of this class and shows
	* it inside a new Shell.
	*
	* It is a convenience method for showing the GUI, but it can be
	* copied and used as a basis for your own code.	*
	* It is auto-generated code - the body of this method will be
	* re-generated after any changes are made to the GUI.
	* However, if you delete this method it will not be re-created.	*/
	public static void showGUI(){
		try {
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			InvUIWarehouseAdd inst = new InvUIWarehouseAdd(shell, SWT.NULL);
			shell.setLayout(new org.eclipse.swt.layout.FillLayout());
			Rectangle shellBounds = shell.computeTrim(0,0,593,343);
			shell.setSize(shellBounds.width, shellBounds.height);
			shell.open();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
