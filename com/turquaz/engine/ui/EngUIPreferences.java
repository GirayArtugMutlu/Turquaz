package com.turquaz.engine.ui;

import java.io.File;
import org.apache.log4j.Logger;
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
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.ui.component.DatePicker;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
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
	private Button btnCurrentCards;
	private Button btnUpdateCashTrans;
	private Button btnFillBillInEngineSeq;
	private Button btnJiraBugReport;
	private Button btnExportInvAccounts;
	private Button btnExportBankCards;
	private Button btnUpdateBills;
	private CLabel lblBillFormat;
	private DatePicker datePicker;
	private CLabel lblWorkingDate;
	private ToolItem toolCancel;
	private ToolItem toolSave;
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
				{
					lblWorkingDate = new CLabel(composite1, SWT.NONE);
					lblWorkingDate.setText(Messages.getString("EngUIPreferences.4") + //$NON-NLS-1$
							""); //$NON-NLS-1$
				}
				{
					datePicker = new DatePicker(composite1, SWT.NONE);
					GridData datePickerLData = new GridData();
					datePickerLData.widthHint = 157;
					datePickerLData.heightHint = 23;
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
					cComboLData.widthHint = 134;
					cComboLData.heightHint = 17;
					cCombo.setLayoutData(cComboLData);
				}
				//START >> btnUpdateBills
				btnUpdateBills = new Button(composite1, SWT.PUSH | SWT.CENTER);
				btnUpdateBills.setText(Messages.getString("EngUIPreferences.3")); //$NON-NLS-1$
				btnUpdateBills.setVisible(false);
				btnUpdateBills.addMouseListener(new MouseAdapter()
				{
					public void mouseUp(MouseEvent evt)
					{
						EngBLCommon.updateAllBillAccountingTransactions();
					}
				});
				//END << btnUpdateBills
				//START >> btnCurrentCards
				btnCurrentCards = new Button(composite1, SWT.PUSH | SWT.CENTER);
				btnCurrentCards.setText(Messages.getString("EngUIPreferences.6")); //$NON-NLS-1$
				btnCurrentCards.setVisible(false);
				btnCurrentCards.addMouseListener(new MouseAdapter()
				{
					public void mouseUp(MouseEvent evt)
					{
						try
						{
							if (EngUICommon.okToDelete(getParent(), Messages.getString("EngUIPreferences.7"))) //$NON-NLS-1$
							{
								EngBLCommon.exportCurrentCardAccs();
							}
						}
						catch (Exception ex)
						{
							Logger loger = Logger.getLogger(this.getClass());
							loger.error("Exception Caught", ex);
							ex.printStackTrace();
						}
					}
				});
				//END << btnCurrentCards
				//START >> btnExportBankCards
				btnExportBankCards = new Button(composite1, SWT.PUSH | SWT.CENTER);
				btnExportBankCards.setText("Banka Muhasebe Hesaplarini Aktar");
				btnExportBankCards.setVisible(false);
				btnExportBankCards.addMouseListener(new MouseAdapter()
				{
					public void mouseUp(MouseEvent evt)
					{
						try
						{
							EngBLCommon.exportBankCardAccs();
						}
						catch (Exception ex)
						{
							Logger loger = Logger.getLogger(this.getClass());
							loger.error("Exception Caught", ex);
							ex.printStackTrace();
						}
					}
				});
				//END << btnExportBankCards
				//START >> btnUpdateCashTrans
				btnUpdateCashTrans = new Button(composite1, SWT.PUSH | SWT.CENTER);
				btnUpdateCashTrans.setText("Kasa Hareketlerini Güncelle");
				btnUpdateCashTrans.setVisible(false);
				btnUpdateCashTrans.addMouseListener(new MouseAdapter()
				{
					public void mouseUp(MouseEvent evt)
					{
						EngBLCommon.updateAllCashTransactions();
					}
				});
				//END << btnUpdateCashTrans
				//START >> btnExportInvAccounts
				btnExportInvAccounts = new Button(composite1, SWT.PUSH | SWT.CENTER);
				btnExportInvAccounts.setText("ExportInvAccounts");
				btnExportInvAccounts.setVisible(false);
				btnExportInvAccounts.addMouseListener(new MouseAdapter()
				{
					public void mouseUp(MouseEvent evt)
					{
						try
						{
							EngBLCommon.exportInventoryAccounts();
						}
						catch (Exception ex)
						{
							Logger loger = Logger.getLogger(this.getClass());
							loger.error("Exception Caught", ex);
							ex.printStackTrace();
						}
					}
				});
				//END << btnExportInvAccounts
				//START >> btnJiraBugReport
				btnJiraBugReport = new Button(composite1, SWT.PUSH | SWT.CENTER);
				btnJiraBugReport.setText("Jira Bug Report");
				btnJiraBugReport.setVisible(false);
				GridData btnJiraBugReportLData = new GridData();
				btnJiraBugReportLData.widthHint = 86;
				btnJiraBugReportLData.heightHint = 23;
				btnJiraBugReport.setLayoutData(btnJiraBugReportLData);
				btnJiraBugReport.addMouseListener(new MouseAdapter()
				{
					public void mouseUp(MouseEvent evt)
					{
						btnJiraBugReportMouseUp(evt);
					}
				});
				//END << btnJiraBugReport
				//START >> btnFillBillInEngineSeq
				btnFillBillInEngineSeq = new Button(composite1, SWT.PUSH | SWT.CENTER);
				btnFillBillInEngineSeq.setText("Fill Bill In EngineSeq");
				btnFillBillInEngineSeq.setVisible(true);
				btnFillBillInEngineSeq.addMouseListener(new MouseAdapter()
				{
					public void mouseUp(MouseEvent evt)
					{
						btnFillBillInEngineSeqMouseUp(evt);
					}
				});
				//END << btnFillBillInEngineSeq
			}
			fillBillTypeCombo();
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
			e.printStackTrace();
		}
	}

	public void fillBillTypeCombo()
	{
		try
		{
			if (EngConfiguration.getString("invoice_template") != null) { //$NON-NLS-1$
				cCombo.setText(EngConfiguration.getString("invoice_template")); //$NON-NLS-1$
			}
			File file = new File("reports/invoice"); //$NON-NLS-1$
			if (file.exists() && file.isDirectory())
			{
				File templates[] = file.listFiles();
				for (int i = 0; i < templates.length; i++)
				{
					if (templates[i].getName().endsWith(".jasper")) //$NON-NLS-1$
					{
						cCombo.add(templates[i].getName());
					}
				}
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}

	private void btnJiraBugReportMouseUp(MouseEvent evt)
	{
		try
		{
			/*
			 * XmlRpcClient rpcClient = new XmlRpcClient(JIRA_URI + RPC_PATH); // Login and retrieve logon token Vector loginParams = new
			 * Vector(2); loginParams.add(USER_NAME); loginParams.add(PASSWORD); String loginToken = (String)
			 * rpcClient.execute("jira1.login", loginParams); // Retrieve projects Vector loginTokenVector = new Vector(1);
			 * loginTokenVector.add(loginToken); List projects = (List)rpcClient.execute("jira1.getProjects", loginTokenVector); // Print
			 * projects for (Iterator iterator = projects.iterator(); iterator.hasNext();) { Map project = (Map) iterator.next();
			 * System.out.println(project.get("name") + " with lead " + project.get("lead")); } // Log out Boolean bool = (Boolean)
			 * rpcClient.execute("jira1.logout", loginTokenVector); System.out.println("Logout successful: " + bool);
			 */
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}

	private void btnFillBillInEngineSeqMouseUp(MouseEvent evt)
	{
		try
		{
			EngBLCommon.insertBillInEngineSeq();
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}
}