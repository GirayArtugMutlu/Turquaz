package com.turquaz.current.ui;


/************************************************************************/
/* TURQUAZ: Higly Modular Accounting/ERP Program                        */
/* ============================================                         */
/* Copyright (c) 2004 by Turquaz Software Development Group			    */
/*																		*/
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or    */
/* (at your option) any later version.       							*/
/* 																		*/
/* This program is distributed in the hope that it will be useful,		*/
/* but WITHOUT ANY WARRANTY; without even the implied warranty of		*/
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the		*/
/* GNU General Public License for more details.         				*/
/************************************************************************/

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
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
import com.turquaz.engine.ui.component.CurrencyText;
import com.turquaz.engine.ui.component.SearchComposite;

import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Text;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.current.ui.comp.CurrentPicker;
public class CurUICurrentCardVoucher extends org.eclipse.swt.widgets.Composite
implements SearchComposite{
	private CLabel lvlCurrentCard;
	private CurrentPicker txtCurrentCard;
	private CLabel lvlDate;
	private DatePicker dateTransDate;
	private CLabel lvlDefinition;
	private Text txtDefinition;
	private CurrencyText txtDept;
	private CLabel lblDept;
	private CurrencyText txtCredit;
	private CLabel lblCredit;

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
		CurUICurrentCardVoucher inst = new CurUICurrentCardVoucher(shell, SWT.NULL);
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

	public CurUICurrentCardVoucher(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			this.setSize(591, 269);
			{
				lvlCurrentCard = new CLabel(this, SWT.NONE);
				lvlCurrentCard.setText("Cari Kart :");
				GridData lvlCurrentCardLData = new GridData();
				lvlCurrentCardLData.widthHint = 101;
				lvlCurrentCardLData.heightHint = 15;
				lvlCurrentCard.setLayoutData(lvlCurrentCardLData);
			}
			{
				txtCurrentCard = new CurrentPicker(this, SWT.NONE);
				GridData txtCurrentCardLData = new GridData();
				txtCurrentCardLData.widthHint = 154;
				txtCurrentCardLData.heightHint = 13;
				txtCurrentCard.setLayoutData(txtCurrentCardLData);
			}
			{
				lvlDate = new CLabel(this, SWT.NONE);
				lvlDate.setText("Tarih :");
			}
			{
				dateTransDate = new DatePicker(this, SWT.NONE);
				GridData dateTransDateLData = new GridData();
				dateTransDateLData.widthHint = 112;
				dateTransDateLData.heightHint = 23;
				dateTransDate.setLayoutData(dateTransDateLData);
			}
			{
				lvlDefinition = new CLabel(this, SWT.NONE);
				lvlDefinition.setText("Aç?klama :");
			}
			{
				txtDefinition = new Text(this, SWT.MULTI | SWT.WRAP | SWT.H_SCROLL);
				GridData txtDefinitionLData = new GridData();
				txtDefinitionLData.widthHint = 379;
				txtDefinitionLData.heightHint = 29;
				txtDefinition.setLayoutData(txtDefinitionLData);
			}
			{
				lblCredit = new CLabel(this, SWT.NONE);
				GridData lblCreditLData = new GridData();
				lblCredit.setText("Alacak :");
				lblCreditLData.widthHint = 81;
				lblCreditLData.heightHint = 18;
				lblCredit.setLayoutData(lblCreditLData);
			}
			{
				txtCredit = new CurrencyText(this, SWT.NONE);
				GridData txtCreditLData = new GridData();
				txtCredit.addModifyListener(new ModifyListener() {
					public void modifyText(ModifyEvent arg0) {
						if (!txtCredit.getText().equals(""))
							txtDept.setText("");

					}
				});
				txtCredit.setSize(209, 14);
				txtCreditLData.widthHint = 209;
				txtCreditLData.heightHint = 14;
				txtCredit.setLayoutData(txtCreditLData);
			}
			{
				lblDept = new CLabel(this, SWT.NONE);
				lblDept.setText("Borç :");
			}
			{
				txtDept = new CurrencyText(this, SWT.NONE);
				GridData txtDeptLData = new GridData();
				txtDept.addModifyListener(new ModifyListener() {
					public void modifyText(ModifyEvent arg0) {
						if (!txtDept.getText().equals(""))
							txtCredit.setText("");

					}
				});
				txtDept.setSize(209, 14);
				txtDeptLData.widthHint = 209;
				txtDeptLData.heightHint = 14;
				txtDept.setLayoutData(txtDeptLData);
			}
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void printTable()
	{
		
	}
	public void search()
	{
		
	}
	public void delete()
	{
		
	}
	public void save()
	{
		
	}
	public void exportToExcel()
	{
		
	}
}
