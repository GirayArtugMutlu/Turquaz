package com.turquaz.bank.ui.comp;

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
/**
 * @author  Onsel Armagan
 * @version  $Id$
 */
import org.eclipse.jface.contentassist.TextContentAssistSubjectAdapter;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import com.turquaz.accounting.ui.comp.AccountPicker;
import com.turquaz.bank.bl.BankBLBankCardSearch;
import com.turquaz.engine.bl.EngBLBankCards;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.ui.contentassist.TurquazContentAssistant;
import com.cloudgarden.resource.SWTResourceManager;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class BankCardPicker extends org.eclipse.swt.widgets.Composite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	private String filter = "";
	private Text text1;
	private AccountPicker accountPicker = null;
	private Integer pickerAccountType = null;

	public BankCardPicker(Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	/**
	 * Initializes the GUI. Auto-generated code - any changes you make will disappear.
	 */
	public void initGUI()
	{
		try
		{
			preInitGUI();
			this.setSize(new org.eclipse.swt.graphics.Point(397, 22));
			this.setEnabled(true);
			GridLayout thisLayout = new GridLayout(4, true);
			this.setLayout(thisLayout);
			{
				text1 = new Text(this, SWT.LEFT);
				text1.setEditable(true);
				text1.setSize(new org.eclipse.swt.graphics.Point(358, 22));
				GridData text1LData = new GridData();
				text1.addModifyListener(new ModifyListener()
				{
					public void modifyText(ModifyEvent evt)
					{
						try
						{
							setData2(EngBLBankCards.getCard(text1.getText().trim()));
						}
						catch (Exception ex)
						{
							ex.printStackTrace();
						}
					}
				});
				text1.setBackground(SWTResourceManager.getColor(255, 150, 150));
				text1LData.verticalAlignment = GridData.FILL;
				text1LData.horizontalAlignment = GridData.FILL;
				text1LData.grabExcessHorizontalSpace = true;
				text1LData.grabExcessVerticalSpace = true;
				text1.setLayoutData(text1LData);
			}
			thisLayout.marginWidth = 0;
			thisLayout.marginHeight = 0;
			thisLayout.numColumns = 4;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 0;
			thisLayout.verticalSpacing = 0;
			this.layout();
			addDisposeListener(new DisposeListener()
			{
				public void widgetDisposed(DisposeEvent e)
				{
				}
			});
			postInitGUI();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/** Add your pre-init code in here */
	public void preInitGUI()
	{
	}
	/** Add your post-init code in here */
	public TurquazContentAssistant asistant;

	public void postInitGUI()
	{
		TextContentAssistSubjectAdapter adapter = new TextContentAssistSubjectAdapter(text1);
		asistant = new TurquazContentAssistant(adapter, EngBLCommon.CONTENT_ASSIST_BANK);
		adapter.appendVerifyKeyListener(new VerifyKeyListener()
		{
			public void verifyKey(VerifyEvent event)
			{
				// Check for Ctrl+Spacebar
				if (event.stateMask == SWT.CTRL && event.character == ' ')
				{
					asistant.showPossibleCompletions();
					event.doit = false;
				}
			}
		});
	}

	public void setText(String arg0)
	{
		text1.setText(arg0);
	}

	public String getText()
	{
		return text1.getText();
	}

	public void setData(Object obj)
	{
		super.setData(obj);
	}

	public void setData2(Object obj)
	{
		super.setData(obj);
		if (obj == null)
		{
			text1.setBackground(SWTResourceManager.getColor(255, 150, 150));
			if (accountPicker != null)
			{
				accountPicker.setData(null);
			}
		}
		else
		{
			text1.setBackground(SWTResourceManager.getColor(198, 255, 198));
			if (accountPicker != null)
			{
				try
				{
					accountPicker.setData(BankBLBankCardSearch.getAccountingAccount((TurqBanksCard) obj, pickerAccountType));
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}
		}
	}

	public TurqBanksCard getTurqBank()
	{
		if (super.getData() == null)
		{
			return null;
		}
		else
		{
			return (TurqBanksCard) super.getData();
		}
	}

	public void setAccountPicker(AccountPicker picker, Integer Type)
	{
		accountPicker = picker;
		pickerAccountType = Type;
	}
}