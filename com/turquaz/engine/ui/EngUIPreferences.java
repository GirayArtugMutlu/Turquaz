package com.turquaz.engine.ui;

import java.io.File;

import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.swt.custom.CCombo;
import com.turquaz.engine.EngConfiguration;
import com.turquaz.engine.Messages;
import com.turquaz.engine.ui.component.DatePicker;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
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
public class EngUIPreferences extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private Composite composite1;
	private CCombo cCombo;
	private CLabel lblBillFormat;
	private DatePicker datePicker;
	private CLabel lblWorkingDate;
	private ToolItem toolCancel;
	private ToolItem toolSave;
	private ToolBar toolBar1;

	public EngUIPreferences(Shell parent, int style) {
		super(parent, style);
	}

	public void open() {
		try {
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

                {
                    //Register as a resource user - SWTResourceManager will
                    //handle the obtaining and disposing of resources
                    SWTResourceManager.registerResourceUser(dialogShell);
                }


			dialogShell.setLayout(new GridLayout());
			dialogShell.setText(Messages.getString("EngUIPreferences.1")); //$NON-NLS-1$
			dialogShell.layout();
			dialogShell.pack();
			dialogShell.setSize(557, 295);
            {
                toolBar1 = new ToolBar(dialogShell, SWT.NONE);
                {
                    toolSave = new ToolItem(toolBar1, SWT.NONE);
                    toolSave.setText(Messages.getString("EngUIPreferences.0")); //$NON-NLS-1$
                    toolSave.setImage(SWTResourceManager.getImage("icons/save_edit.gif")); //$NON-NLS-1$
                    toolSave.addSelectionListener(new SelectionAdapter() {
                        public void widgetSelected(SelectionEvent evt) {
                           
                            EngConfiguration.setCurrentDate(datePicker.getDate());
                            EngConfiguration.setString("invoice_template",cCombo.getText().trim()); //$NON-NLS-1$
                            dialogShell.close();
                            
                            
                        }
                    });
                }
                {
                    toolCancel = new ToolItem(toolBar1, SWT.NONE);
                    toolCancel.setText(Messages.getString("EngUIPreferences.2")); //$NON-NLS-1$
                    toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg")); //$NON-NLS-1$
                    toolCancel.addSelectionListener(new SelectionAdapter() {
                        public void widgetSelected(SelectionEvent evt) {
                           
                        dialogShell.close();
                        }
                    });
                }
            }
            {
                composite1 = new Composite(dialogShell, SWT.BORDER);
                GridLayout composite1Layout = new GridLayout();
                GridData composite1LData = new GridData();
                composite1LData.grabExcessHorizontalSpace = true;
                composite1LData.grabExcessVerticalSpace = true;
                composite1LData.horizontalAlignment = GridData.FILL;
                composite1LData.verticalAlignment = GridData.FILL;
                composite1.setLayoutData(composite1LData);
                composite1Layout.numColumns = 2;
                composite1.setLayout(composite1Layout);
                {
                    lblWorkingDate = new CLabel(composite1, SWT.NONE);
                    lblWorkingDate.setText(Messages.getString("EngUIPreferences.4") + //$NON-NLS-1$
                    		""); //$NON-NLS-1$
                }
                {
                    datePicker = new DatePicker(composite1, SWT.NONE);
                    GridData datePickerLData = new GridData();
                    datePickerLData.widthHint = 119;
                    datePickerLData.heightHint = 19;
                    datePicker.setLayoutData(datePickerLData);
                }
                {
                    lblBillFormat = new CLabel(composite1, SWT.NONE);
                    lblBillFormat.setText(Messages.getString("EngUIPreferences.5")); //$NON-NLS-1$
                }
                {
                    cCombo = new CCombo(composite1, SWT.NONE);
                    GridData cComboLData = new GridData();
                    cCombo.setBackground(SWTResourceManager.getColor(255, 255, 255));
                    cCombo.setEditable(false);
                    cComboLData.widthHint = 98;
                    cComboLData.heightHint = 16;
                    cCombo.setLayoutData(cComboLData);
                }
            }
            fillBillTypeCombo();
            EngUICommon.centreWindow(dialogShell);
            
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
	public void fillBillTypeCombo(){
	    try{
	        
	        if(EngConfiguration.getString("invoice_template")!=null){ //$NON-NLS-1$
	         cCombo.setText(EngConfiguration.getString("invoice_template"));    //$NON-NLS-1$
	        
	        }
	        
	        File file = new File("reports/invoice"); //$NON-NLS-1$
	        
	        if(file.exists()&&file.isDirectory()){
	         
	            File templates[] = file.listFiles();
	            for(int i=0;i<templates.length;i++)
	            {
	                if(templates[i].getName().endsWith(".jasper")) //$NON-NLS-1$
	                {
	                    cCombo.add(templates[i].getName());
	                }
	            }
	        
	        }
	        
	    }
	    catch(Exception ex){
	        ex.printStackTrace();
	    }
	}
	
}
