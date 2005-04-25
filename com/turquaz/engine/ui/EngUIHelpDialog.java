package com.turquaz.engine.ui;

import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import com.turquaz.engine.Messages;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.ui.component.Hyperlink;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;

public class EngUIHelpDialog extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private Label lblMessage;
	private Hyperlink hyperGPL;
	private Label lblGPL;
	private CLabel lblVarsion;
	private Hyperlink hyperlinkTurquaz;

	

	public EngUIHelpDialog(Shell parent, int style)
	{
		super(parent, style);
	}

	public void open()
	{
		try
		{
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
			dialogShell.setLayout(new GridLayout());
			dialogShell.setText(Messages.getString("EngUIHelpDialog.0")); //$NON-NLS-1$
			dialogShell.setSize(319, 192);
			{
				lblMessage = new Label(dialogShell, SWT.CENTER | SWT.WRAP);
				lblMessage.setText(Messages.getString("EngUIHelpDialog.1")); //$NON-NLS-1$
				GridData lblMessageLData1 = new GridData();
				lblMessageLData1.horizontalAlignment = GridData.CENTER;
				lblMessageLData1.widthHint = 259;
				lblMessageLData1.heightHint = 37;
				lblMessageLData1.grabExcessHorizontalSpace = true;
				lblMessage.setLayoutData(lblMessageLData1);
				GridData lblMessageLData = new GridData();
				lblMessageLData.horizontalAlignment = GridData.CENTER;
				lblMessageLData.widthHint = 226;
				lblMessageLData.heightHint = 64;
				lblMessageLData.grabExcessHorizontalSpace = true;
			}
			{
				hyperlinkTurquaz = new Hyperlink(dialogShell, SWT.NONE);
				hyperlinkTurquaz.setText("http://www.turquaz.com"); //$NON-NLS-1$
				GridData hyperlinkTurquazLData = new GridData();
				hyperlinkTurquaz.addSelectionListener(new SelectionAdapter()
				{
					public void widgetSelected(SelectionEvent evt)
					{
						Program.launch("http://www.turquaz.com"); //$NON-NLS-1$
						//  Program.launch("mailto:onsel@turquaz.com");
					}
				});
				hyperlinkTurquazLData.widthHint = 142;
				hyperlinkTurquazLData.heightHint = 24;
				hyperlinkTurquazLData.horizontalAlignment = GridData.CENTER;
				hyperlinkTurquaz.setLayoutData(hyperlinkTurquazLData);
			}
			{
				lblVarsion = new CLabel(dialogShell, SWT.NONE);
				lblVarsion.setText(EngBLCommon.VERSION); //$NON-NLS-1$
				GridData lblVarsionLData = new GridData();
				lblVarsionLData.horizontalAlignment = GridData.CENTER;
				lblVarsionLData.widthHint = 89;
				lblVarsionLData.heightHint = 19;
				lblVarsion.setLayoutData(lblVarsionLData);
			}
			{
				lblGPL = new Label(dialogShell, SWT.NONE);
				lblGPL.setText(Messages.getString("EngUIHelpDialog.5")); //$NON-NLS-1$
				GridData lblGPLLData = new GridData();
				lblGPLLData.widthHint = 253;
				lblGPLLData.heightHint = 18;
				lblGPLLData.horizontalAlignment = GridData.CENTER;
				lblGPL.setLayoutData(lblGPLLData);
			}
			{
				hyperGPL = new Hyperlink(dialogShell, SWT.NONE);
				hyperGPL.setText(Messages.getString("EngUIHelpDialog.2")); //$NON-NLS-1$
				GridData hyperGPLLData = new GridData();
				hyperGPL.addSelectionListener(new SelectionAdapter()
				{
					public void widgetSelected(SelectionEvent evt)
					{
						Program.launch("http://www.turquaz.com/lisans.php"); //$NON-NLS-1$
					}
				});
				hyperGPLLData.horizontalAlignment = GridData.CENTER;
				hyperGPLLData.widthHint = 104;
				hyperGPLLData.heightHint = 22;
				hyperGPL.setLayoutData(hyperGPLLData);
			}
			postInitGUI();
			dialogShell.layout();
			dialogShell.pack();
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

	public void postInitGUI()
	{
		Point parentLocation = this.getParent().getLocation();
		Point parentSize = this.getParent().getSize();
		Point dialogSize = dialogShell.getSize();
		int location_X = (parentLocation.x + parentSize.x) / 2 - (dialogSize.x / 2);
		int location_Y = (parentLocation.y + parentSize.y) / 2 - (dialogSize.y / 2);
		dialogShell.setLocation(location_X, location_Y);
	}
}