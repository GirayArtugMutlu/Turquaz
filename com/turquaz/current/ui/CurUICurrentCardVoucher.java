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

import java.math.BigDecimal;

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
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.GridData;

import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.ui.component.CurrencyText;
import com.turquaz.engine.ui.component.SecureComposite;

import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Text;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.current.Messages;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.current.ui.comp.CurrentPicker;
public class CurUICurrentCardVoucher extends org.eclipse.swt.widgets.Composite
implements SecureComposite{
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
	private CurBLCurrentTransactionAdd curBLTransAdd=new CurBLCurrentTransactionAdd();

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

	
	ModifyListener listenerCredit = new ModifyListener(){
	    public void modifyText(ModifyEvent arg0) {
			txtDept.removeModifyListener(listenerDept);
			txtDept.setText(new BigDecimal(0)); //$NON-NLS-1$
			txtDept.addModifyListener(listenerDept);
		}
	    
	};
	ModifyListener listenerDept = new ModifyListener(){
	    public void modifyText(ModifyEvent arg0) {
			txtCredit.removeModifyListener(listenerCredit);
			txtCredit.setText(new BigDecimal(0)); //$NON-NLS-1$
            txtCredit.addModifyListener(listenerCredit); 
		}
	    
	};
	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			this.setSize(591, 269);
			{
				lvlCurrentCard = new CLabel(this, SWT.NONE);
				lvlCurrentCard.setText(Messages.getString("CurUICurrentCardVoucher.0")); //$NON-NLS-1$
				GridData lvlCurrentCardLData = new GridData();
				lvlCurrentCardLData.widthHint = 101;
				lvlCurrentCardLData.heightHint = 15;
				lvlCurrentCard.setLayoutData(lvlCurrentCardLData);
			}
			{
				txtCurrentCard = new CurrentPicker(this, SWT.NONE);
				GridData txtCurrentCardLData = new GridData();
				txtCurrentCard.setSize(311, 19);
				txtCurrentCardLData.widthHint = 311;
				txtCurrentCardLData.heightHint = 19;
				txtCurrentCard.setLayoutData(txtCurrentCardLData);
			}
			{
				lvlDate = new CLabel(this, SWT.NONE);
				lvlDate.setText(Messages.getString("CurUICurrentCardVoucher.1")); //$NON-NLS-1$
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
				lvlDefinition.setText(Messages.getString("CurUICurrentCardVoucher.2")); //$NON-NLS-1$
			}
			{
				txtDefinition = new Text(this, SWT.MULTI | SWT.WRAP | SWT.H_SCROLL);
				GridData txtDefinitionLData = new GridData();
				txtDefinitionLData.widthHint = 379;
				txtDefinitionLData.heightHint = 29;
				txtDefinition.setLayoutData(txtDefinitionLData);
			}
			{
				lblDept = new CLabel(this, SWT.NONE);
				lblDept.setText(Messages.getString("CurUICurrentCardVoucher.3")); //$NON-NLS-1$
			}
			{
				txtDept = new CurrencyText(this, SWT.NONE);
				GridData txtDeptLData = new GridData();
				txtDept.addModifyListener(listenerDept);
				txtDeptLData.widthHint = 203;
				txtDeptLData.heightHint = 19;
				txtDept.setLayoutData(txtDeptLData);
			}
			{
				lblCredit = new CLabel(this, SWT.NONE);
				GridData lblCreditLData = new GridData();
				lblCredit.setText(Messages.getString("CurUICurrentCardVoucher.6")); //$NON-NLS-1$
				lblCreditLData.widthHint = 81;
				lblCreditLData.heightHint = 18;
				lblCredit.setLayoutData(lblCreditLData);
			}
			{
				txtCredit = new CurrencyText(this, SWT.NONE);
				GridData txtCreditLData = new GridData();
				txtCredit.setSize(203, 19);
				txtCredit.addModifyListener(listenerCredit);
				txtCreditLData.widthHint = 203;
				txtCreditLData.heightHint = 19;
				txtCredit.setLayoutData(txtCreditLData);
			}
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void newForm()
	{
		 CurUICurrentCardVoucher  curCard = new CurUICurrentCardVoucher(this.getParent(),this.getStyle());
		 CTabFolder tabfld = (CTabFolder)this.getParent();
		 tabfld.getSelection().setControl(curCard);	 
		 this.dispose();
		
	}
	public void save()
	{
		try
		{			

			if (verifyFields())
			{
				BigDecimal credit=txtCredit.getBigDecimalValue();
				BigDecimal dept=txtDept.getBigDecimalValue();
			
				boolean isCredit = false;
				if(dept.compareTo(new BigDecimal(0))<1){
				    isCredit=true;
				}
				
				curBLTransAdd.saveCurrentTransaction((TurqCurrentCard)txtCurrentCard.getData(),
					dateTransDate.getDate(),"",isCredit,(isCredit)? credit : dept, //$NON-NLS-1$
							new BigDecimal(0),EngBLCommon.CURRENT_TRANS_OTHERS,
							new Integer(-1),txtDefinition.getText());
				newForm();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			MessageBox msg=new MessageBox(this.getShell(),SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
		}
	}
	private boolean verifyFields()
	{
		MessageBox msg=new MessageBox(this.getShell(), SWT.NULL);
		if (txtCurrentCard.getData()==null)
		{
			msg.setMessage(Messages.getString("CurUICurrentCardVoucher.10")); //$NON-NLS-1$
			msg.open();
			txtCurrentCard.setFocus();
			return false;
		}
		else if (txtCredit.getText().equals("") && txtDept.getText().equals("")) //$NON-NLS-1$ //$NON-NLS-2$
		{
			msg.setMessage(Messages.getString("CurUICurrentCardVoucher.13")); //$NON-NLS-1$
			msg.open();
			txtDept.setFocus();
			return false;
		}
		return true;
	}

}
