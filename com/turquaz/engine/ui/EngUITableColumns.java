package com.turquaz.engine.ui;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.engine.bl.EngBLLogger;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.SWT;

public class EngUITableColumns extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private Table tableTableColumns;
	private Button btnOk;
	private Composite composite1;
	private Button btnCancel;
	int defaultColumnWidths[] = null;
	boolean defaultChecked[] = null;

	public EngUITableColumns(Shell parent, int style)
	{
		super(parent, style);
	}

	public void open(Table table, int[] defaultWidths)
	{
		try
		{
			this.defaultColumnWidths = defaultWidths;
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
			{
				//Register as a resource user - SWTResourceManager will
				//handle the obtaining and disposing of resources
				SWTResourceManager.registerResourceUser(dialogShell);
			}
			GridLayout dialogShellLayout = new GridLayout();
			dialogShell.setLayout(dialogShellLayout);
			dialogShell.layout();
			dialogShell.pack();
			dialogShell.setSize(253, 294);
			//START >> tableTableColumns
			tableTableColumns = new Table(dialogShell, SWT.CHECK | SWT.V_SCROLL | SWT.BORDER);
			GridData table1LData = new GridData();
			tableTableColumns.setLinesVisible(true);
			table1LData.horizontalAlignment = GridData.FILL;
			table1LData.grabExcessHorizontalSpace = true;
			table1LData.verticalAlignment = GridData.FILL;
			table1LData.grabExcessVerticalSpace = true;
			table1LData.horizontalSpan = 2;
			tableTableColumns.setLayoutData(table1LData);
			//END << tableTableColumns
			//START >> composite1
			composite1 = new Composite(dialogShell, SWT.NONE);
			GridLayout composite1Layout = new GridLayout();
			GridData composite1LData = new GridData();
			composite1LData.widthHint = 124;
			composite1LData.heightHint = 37;
			composite1LData.horizontalAlignment = GridData.END;
			composite1.setLayoutData(composite1LData);
			composite1Layout.makeColumnsEqualWidth = true;
			composite1Layout.numColumns = 2;
			composite1.setLayout(composite1Layout);
			//START >> btnOk
			btnOk = new Button(composite1, SWT.PUSH | SWT.CENTER);
			btnOk.setText("Tamam");
			GridData btnOkLData = new GridData();
			btnOk.addMouseListener(new MouseAdapter()
			{
				public void mouseUp(MouseEvent evt)
				{
					btnOkMouseUp(evt);
				}
			});
			btnOk.setImage(SWTResourceManager.getImage("icons/Ok24.gif"));
			btnOkLData.widthHint = 46;
			btnOkLData.heightHint = 32;
			btnOkLData.horizontalAlignment = GridData.END;
			btnOk.setLayoutData(btnOkLData);
			//END << btnOk
			//START >> btnCancel
			btnCancel = new Button(composite1, SWT.TOGGLE | SWT.CENTER);
			btnCancel.setText("\u0130ptal");
			GridData btnCancelLData = new GridData();
			btnCancel.addMouseListener(new MouseAdapter()
			{
				public void mouseUp(MouseEvent evt)
				{
					dialogShell.close();
				}
			});
			btnCancel.setImage(SWTResourceManager.getImage("icons/Cancel24.gif"));
			btnCancelLData.horizontalAlignment = GridData.END;
			btnCancelLData.widthHint = 46;
			btnCancelLData.heightHint = 32;
			btnCancel.setLayoutData(btnCancelLData);
			//END << btnCancel
			//END << composite1
			postInitGui(table);
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

	public void postInitGui(Table table)
	{
		EngUICommon.centreWindow(dialogShell);
		TableColumn columns[] = table.getColumns();
		defaultChecked = new boolean[columns.length];
		TableItem item;
		for (int i = 0; i < columns.length; i++)
		{
			item = new TableItem(tableTableColumns, SWT.NULL);
			item.setText(columns[i].getText());
			item.setData(columns[i]);
			if (columns[i].getWidth() > 5)
			{
				item.setChecked(true);
				defaultChecked[i] = true;
			}
			else
			{
				defaultChecked[i] = false;
			}
		}
	}

	private void btnOkMouseUp(MouseEvent evt)
	{
		TableItem items[] = tableTableColumns.getItems();
		for (int i = 0; i < items.length; i++)
		{
			TableColumn column = (TableColumn) items[i].getData();
			if (!items[i].getChecked())
			{
				column.setWidth(0);
			}
			else
			{
				if (!defaultChecked[i])
				{
					column.setWidth(defaultColumnWidths[i]);
				}
			}
		}
		dialogShell.close();
	}
}