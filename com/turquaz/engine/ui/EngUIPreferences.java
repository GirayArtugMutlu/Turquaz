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
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.ui.component.DatePicker;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class EngUIPreferences extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private Composite composite1;
	private CCombo cCombo;
	private Button btnAutomaticDispatcNote;
	private CLabel lblBillFormat;
	private DatePicker datePicker;
	private CLabel lblWorkingDate;
	private ToolItem toolCancel;
	private ToolItem toolSave;
	private Composite compGeneral;
	private Composite compBill;
	private CTabItem tabItemBill;
	private CTabItem cTabItem1;
	private CTabFolder tabFolder;
	private ToolBar toolBar1;

	public EngUIPreferences(Shell parent, int style)
	{
		super(parent, style);
	}

	public void open()
	{
		try
		{
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
					toolSave.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							EngConfiguration.setCurrentDate(datePicker.getDate());
							EngConfiguration.setString("invoice_template", cCombo.getText().trim()); //$NON-NLS-1$
							EngConfiguration.setString("automatic.dispatch.note",btnAutomaticDispatcNote.getSelection()+"");
							dialogShell.close();
						}
					});
				}
				{
					toolCancel = new ToolItem(toolBar1, SWT.NONE);
					toolCancel.setText(Messages.getString("EngUIPreferences.2")); //$NON-NLS-1$
					toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg")); //$NON-NLS-1$
					toolCancel.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
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
				//START >>  tabFolder
				tabFolder = new CTabFolder(composite1, SWT.NONE);
				//START >>  cTabItem1
				cTabItem1 = new CTabItem(tabFolder, SWT.NONE);
				cTabItem1.setText("Genel");
				//START >>  compGeneral
				compGeneral = new Composite(tabFolder, SWT.NONE);
				GridLayout compGeneralLayout = new GridLayout();
				compGeneralLayout.numColumns = 2;
				compGeneral.setLayout(compGeneralLayout);
				cTabItem1.setControl(compGeneral);
				{
					lblWorkingDate = new CLabel(compGeneral, SWT.NONE);
					lblWorkingDate.setText(Messages.getString("EngUIPreferences.4") + //$NON-NLS-1$
						""); //$NON-NLS-1$
				}
				{
					datePicker = new DatePicker(compGeneral, SWT.NONE);
					GridData datePickerLData = new GridData();
					datePickerLData.widthHint = 157;
					datePickerLData.heightHint = 23;
					datePicker.setLayoutData(datePickerLData);
				}
				//END <<  compGeneral
				GridData tabFolderLData = new GridData();
				tabFolderLData.grabExcessVerticalSpace = true;
				tabFolderLData.grabExcessHorizontalSpace = true;
				tabFolderLData.horizontalAlignment = GridData.FILL;
				tabFolderLData.verticalAlignment = GridData.FILL;
				tabFolder.setLayoutData(tabFolderLData);
				//END <<  cTabItem1
				//START >>  tabItemBill
				tabItemBill = new CTabItem(tabFolder, SWT.NONE);
				tabItemBill.setText("Fatura");
				//START >>  compBill
				compBill = new Composite(tabFolder, SWT.NONE);
				GridLayout compBillLayout = new GridLayout();
				compBillLayout.numColumns = 2;
				compBill.setLayout(compBillLayout);
				tabItemBill.setControl(compBill);
				{
					lblBillFormat = new CLabel(compBill, SWT.NONE);
					lblBillFormat.setText(Messages.getString("EngUIPreferences.5")); //$NON-NLS-1$
				}
				{
					cCombo = new CCombo(compBill, SWT.NONE);
					GridData cComboLData = new GridData();
					cCombo.setBackground(SWTResourceManager.getColor(255, 255, 255));
					cCombo.setEditable(false);
					cComboLData.widthHint = 134;
					cComboLData.heightHint = 17;
					cCombo.setLayoutData(cComboLData);
				}
				//START >>  btnAutomaticDispatcNote
				btnAutomaticDispatcNote = new Button(compBill, SWT.CHECK | SWT.LEFT);
				GridData btnAutomaticDispatcNoteLData = new GridData();
				btnAutomaticDispatcNoteLData.horizontalSpan = 2;
				btnAutomaticDispatcNote.setLayoutData(btnAutomaticDispatcNoteLData);
				btnAutomaticDispatcNote.setText("Fatura kaydedildi\u011finde otamatik irsaliye kesilsin");
				btnAutomaticDispatcNote.setSelection(true);
				//END <<  btnAutomaticDispatcNote
				//END <<  compBill
				tabFolder.setSelection(0);
				//END <<  tabItemBill
				//END <<  tabFolder
			}
		
			postInitGUI();
			EngUICommon.centreWindow(dialogShell);
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed())
			{
				if (!display.readAndDispatch())
					display.sleep();
			}
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e);
		}
	}
	public void postInitGUI(){
		fillBillTypeCombo();
		btnAutomaticDispatcNote.setSelection(EngConfiguration.automaticDispatcNote());
		
	}

	public void fillBillTypeCombo()
	{
		try
		{
			if (EngConfiguration.getString("invoice_template") != null) { //$NON-NLS-1$
	
				String invoice_template = EngConfiguration.getString("invoice_template");
				if(invoice_template.endsWith(".jasper"))
				{
				invoice_template = invoice_template.substring(0,invoice_template.length()-7)+".jrxml";
								
				}
				
				cCombo.setText(invoice_template); //$NON-NLS-1$
			
			}
			File file = new File("reports/invoice"); //$NON-NLS-1$
			if (file.exists() && file.isDirectory())
			{
				File templates[] = file.listFiles();
				for (int i = 0; i < templates.length; i++)
				{
					if (templates[i].getName().endsWith(".jrxml")) //$NON-NLS-1$
					{
						cCombo.add(templates[i].getName());
					}
				}
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex);
		}
	}
}