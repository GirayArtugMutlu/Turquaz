package com.turquaz.inventory.ui;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;

public class InvUIInitialTransacions extends org.eclipse.swt.widgets.Composite {
	private Table tableInitialTransactions;
	private TableColumn tableColumnInvCode;
	private TableColumn tableColumnInvName;
	private TableColumn tableColumnPrice;
	private TableColumn tableColumnAmount;

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
		InvUIInitialTransacions inst = new InvUIInitialTransacions(shell, SWT.NULL);
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

	public InvUIInitialTransacions(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.horizontalSpacing = 0;
			thisLayout.marginHeight = 0;
			thisLayout.marginWidth = 0;
			thisLayout.verticalSpacing = 0;
			this.setSize(534, 364);
			//START >>  tableInitialTransactions
			tableInitialTransactions = new Table(this, SWT.NONE);
			GridData tableInitialTransactionsLData = new GridData();
			tableInitialTransactions.setLinesVisible(true);
			tableInitialTransactions.setHeaderVisible(true);
			tableInitialTransactionsLData.grabExcessHorizontalSpace = true;
			tableInitialTransactionsLData.horizontalAlignment = GridData.FILL;
			tableInitialTransactionsLData.grabExcessVerticalSpace = true;
			tableInitialTransactionsLData.verticalAlignment = GridData.FILL;
			tableInitialTransactions.setLayoutData(tableInitialTransactionsLData);
			//START >>  tableColumnInvCode
			tableColumnInvCode = new TableColumn(tableInitialTransactions, SWT.NONE);
			tableColumnInvCode.setText("Stok Kodu");
			tableColumnInvCode.setWidth(106);
			//END <<  tableColumnInvCode
			//START >>  tableColumnInvName
			tableColumnInvName = new TableColumn(tableInitialTransactions, SWT.NONE);
			tableColumnInvName.setText("Stok Ad\u0131");
			tableColumnInvName.setWidth(105);
			//END <<  tableColumnInvName
			//START >>  tableColumnAmount
			tableColumnAmount = new TableColumn(tableInitialTransactions, SWT.NONE);
			tableColumnAmount.setText("Miktar");
			tableColumnAmount.setWidth(104);
			//END <<  tableColumnAmount
			//START >>  tableColumnPrice
			tableColumnPrice = new TableColumn(tableInitialTransactions, SWT.NONE);
			tableColumnPrice.setText("Tutar\u0131");
			tableColumnPrice.setWidth(106);
			//END <<  tableColumnPrice
			//END <<  tableInitialTransactions
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
