package com.turquaz.inventory.ui;

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
import java.util.List;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CCombo;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLServer;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryPrice;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.dal.TurqInventoryUnit;
import com.turquaz.engine.dal.TurqInventoryWarehous;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.lang.InvLangKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.NumericText;
import com.turquaz.engine.ui.component.DecimalTextWithButton;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import com.turquaz.engine.ui.component.CurrencyText;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import com.turquaz.inventory.bl.InvBLWarehouseSearch;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;

public class InvUITransactionAddDialog extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private Composite composite1;
	private CLabel invAmount;
	private NumericText numTxtAmount;
	private Button btnSpecialButtonEach;
	private CurrencyText numTxtSpecialVatEach;
	private CLabel lblSpecialVatEach;
	private Button btnSpecialVat;
	private NumericText numSpecialVat;
	private NumericText txtVat;
	private CCombo comboWareHouses;
	private CLabel lblWareHouse;
	private Composite composite2;
	private Button btnOk;
	private Button btnCancel;
	private Label lblSeperator;
	private CLabel lblSpecialVAT;
	private CLabel lblVat;
	private DecimalTextWithButton decTxtPrice;
	private CCombo comboCurrency;
	private CLabel lblPrice;
	private CCombo comboUnitType;
	private Group txtInvCard;
	private CLabel lblInvVard;
	private boolean BUY;
	TurqInventoryTransaction invTrans;
	TurqInventoryUnit defaultUnit;

	/**
	 * Auto-generated main method to display this org.eclipse.swt.widgets.Dialog inside a new Shell.
	 */
	public InvUITransactionAddDialog(Shell parent, int style, boolean buy)
	{
		super(parent, style);
		BUY = buy;
	}

	public TurqInventoryTransaction open()
	{
		try
		{
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL | SWT.RESIZE | SWT.MAX);
			{
				//Register as a resource user - SWTResourceManager will
				//handle the obtaining and disposing of resources
				SWTResourceManager.registerResourceUser(dialogShell);
			}
			GridLayout dialogShellLayout = new GridLayout();
			dialogShell.setLayout(dialogShellLayout);
			dialogShellLayout.horizontalSpacing = 0;
			dialogShellLayout.marginHeight = 0;
			dialogShellLayout.marginWidth = 0;
			dialogShellLayout.verticalSpacing = 0;
			dialogShell.setSize(544, 287);
			{
				composite1 = new Composite(dialogShell, SWT.NONE);
				GridLayout composite1Layout = new GridLayout();
				GridData composite1LData = new GridData();
				composite1LData.grabExcessHorizontalSpace = true;
				composite1LData.grabExcessVerticalSpace = true;
				composite1LData.horizontalAlignment = GridData.FILL;
				composite1LData.verticalAlignment = GridData.FILL;
				composite1.setLayoutData(composite1LData);
				composite1Layout.numColumns = 3;
				composite1.setLayout(composite1Layout);
				{
					lblInvVard = new CLabel(composite1, SWT.NONE);
					lblInvVard.setText(InvLangKeys.STR_INV_CARD); //$NON-NLS-1$
					GridData lblInvVardLData = new GridData();
					lblInvVardLData.widthHint = 110;
					lblInvVardLData.heightHint = 21;
					lblInvVard.setLayoutData(lblInvVardLData);
				}
				{
					txtInvCard = new Group(composite1, SWT.NONE);
					GridData txtInvCardLData = new GridData();
					txtInvCardLData.widthHint = 334;
					txtInvCardLData.heightHint = 21;
					txtInvCardLData.horizontalSpan = 2;
					txtInvCard.setLayoutData(txtInvCardLData);
				}
				{
					invAmount = new CLabel(composite1, SWT.NONE);
					invAmount.setText(EngLangCommonKeys.STR_AMOUNT); 
					GridData invAmountLData = new GridData();
					invAmountLData.widthHint = 75;
					invAmountLData.heightHint = 20;
					invAmount.setLayoutData(invAmountLData);
				}
				{
					numTxtAmount = new NumericText(composite1, SWT.NONE);
					GridData numTxtAmountLData = new GridData();
					numTxtAmountLData.heightHint = 18;
					numTxtAmountLData.horizontalAlignment = GridData.FILL;
					numTxtAmount.setLayoutData(numTxtAmountLData);
				}
				{
					comboUnitType = new CCombo(composite1, SWT.NONE);
					GridData cCombo1LData = new GridData();
					cCombo1LData.widthHint = 49;
					cCombo1LData.heightHint = 18;
					comboUnitType.setLayoutData(cCombo1LData);
				}
				{
					lblPrice = new CLabel(composite1, SWT.NONE);
					lblPrice.setText(InvLangKeys.STR_PRICE); //$NON-NLS-1$
					GridData lblPriceLData = new GridData();
					lblPriceLData.widthHint = 67;
					lblPriceLData.heightHint = 19;
					lblPrice.setLayoutData(lblPriceLData);
				}
				{
					decTxtPrice = new DecimalTextWithButton(composite1, SWT.NONE);
					GridData comboPricesLData = new GridData();
					comboPricesLData.heightHint = 18;
					comboPricesLData.horizontalAlignment = GridData.FILL;
					decTxtPrice.setLayoutData(comboPricesLData);
					decTxtPrice.addMouseListener(new MouseAdapter()
					{
						public void mouseUp(MouseEvent evt)
						{
							chooseInventoryPrice();
						}
					});
				}
				{
					comboCurrency = new CCombo(composite1, SWT.NONE);
					GridData comboCurrencyLData = new GridData();
					comboCurrencyLData.widthHint = 49;
					comboCurrencyLData.heightHint = 18;
					comboCurrency.setLayoutData(comboCurrencyLData);
				}
				{
					lblVat = new CLabel(composite1, SWT.NONE);
					lblVat.setText(InvLangKeys.STR_VAT_PERCENTAGE); //$NON-NLS-1$
					GridData lblVatLData = new GridData();
					lblVatLData.widthHint = 43;
					lblVatLData.heightHint = 19;
					lblVat.setLayoutData(lblVatLData);
				}
				{
					txtVat = new NumericText(composite1, SWT.NONE);
					GridData txtVatLData = new GridData();
					txtVat.setTextLimit(2);
					txtVatLData.heightHint = 17;
					txtVatLData.horizontalSpan = 2;
					txtVatLData.grabExcessHorizontalSpace = true;
					txtVatLData.widthHint = 199;
					txtVat.setLayoutData(txtVatLData);
				}
				{
					lblSpecialVAT = new CLabel(composite1, SWT.NONE);
					lblSpecialVAT.setText(InvLangKeys.STR_SPEC_VAT_PERC); //$NON-NLS-1$
					GridData lblSpecialVATLData = new GridData();
					lblSpecialVATLData.widthHint = 86;
					lblSpecialVATLData.heightHint = 19;
					lblSpecialVAT.setLayoutData(lblSpecialVATLData);
				}
				{
					numSpecialVat = new NumericText(composite1, SWT.NONE);
					GridData numSpecialVatLData = new GridData();
					numSpecialVat.setTextLimit(2);
					numSpecialVatLData.widthHint = 201;
					numSpecialVatLData.heightHint = 17;
					numSpecialVat.setLayoutData(numSpecialVatLData);
				}
				{
					btnSpecialVat = new Button(composite1, SWT.RADIO | SWT.LEFT);
					btnSpecialVat.setSelection(true);
				}
				{
					lblSpecialVatEach = new CLabel(composite1, SWT.NONE);
					lblSpecialVatEach.setText(InvLangKeys.STR_SPEC_VAT_TOTAL); 
				}
				{
					numTxtSpecialVatEach = new CurrencyText(composite1, SWT.NONE);
					GridData numTxtSpecialVatEachLData = new GridData();
					numTxtSpecialVatEachLData.horizontalAlignment = GridData.FILL;
					numTxtSpecialVatEachLData.heightHint = 16;
					numTxtSpecialVatEach.setLayoutData(numTxtSpecialVatEachLData);
				}
				{
					btnSpecialButtonEach = new Button(composite1, SWT.RADIO | SWT.LEFT);
				}
				{
					lblWareHouse = new CLabel(composite1, SWT.NONE);
					lblWareHouse.setText(InvLangKeys.STR_WAREHOUSE); 
				}
				{
					comboWareHouses = new CCombo(composite1, SWT.NONE);
					GridData comboWareHousesLData = new GridData();
					comboWareHousesLData.widthHint = 181;
					comboWareHousesLData.heightHint = 16;
					comboWareHouses.setLayoutData(comboWareHousesLData);
				}
				{
					lblSeperator = new Label(composite1, SWT.SEPARATOR | SWT.HORIZONTAL);
					GridData lblSeperatorLData = new GridData();
					lblSeperatorLData.heightHint = 13;
					lblSeperatorLData.horizontalAlignment = GridData.FILL;
					lblSeperatorLData.horizontalSpan = 3;
					lblSeperator.setLayoutData(lblSeperatorLData);
				}
				{
					composite2 = new Composite(composite1, SWT.NONE);
					GridLayout composite2Layout = new GridLayout();
					GridData composite2LData1 = new GridData();
					composite2LData1.horizontalSpan = 3;
					composite2LData1.grabExcessHorizontalSpace = true;
					composite2LData1.horizontalAlignment = GridData.END;
					composite2LData1.widthHint = 185;
					composite2LData1.grabExcessVerticalSpace = true;
					composite2LData1.verticalAlignment = GridData.FILL;
					composite2.setLayoutData(composite2LData1);
					GridData composite2LData = new GridData();
					composite2LData.grabExcessHorizontalSpace = true;
					composite2Layout.makeColumnsEqualWidth = true;
					composite2Layout.numColumns = 2;
					composite2Layout.horizontalSpacing = 20;
					composite2.setLayout(composite2Layout);
					{
						btnCancel = new Button(composite2, SWT.PUSH | SWT.CENTER);
						GridData button1LData = new GridData();
						btnCancel.addMouseListener(new MouseAdapter()
						{
							public void mouseUp(MouseEvent evt)
							{
								dialogShell.close();
							}
						});
						btnCancel.setImage(SWTResourceManager.getImage("icons/Cancel24.gif")); //$NON-NLS-1$
						button1LData.widthHint = 69;
						button1LData.heightHint = 35;
						button1LData.verticalAlignment = GridData.BEGINNING;
						btnCancel.setLayoutData(button1LData);
					}
					{
						btnOk = new Button(composite2, SWT.PUSH | SWT.CENTER);
						GridData button2LData = new GridData();
						btnOk.addMouseListener(new MouseAdapter()
						{
							public void mouseUp(MouseEvent evt)
							{
								btnOkMouseUp();
							}
						});
						btnOk.setImage(SWTResourceManager.getImage("icons/Ok24.gif")); //$NON-NLS-1$
						button2LData.widthHint = 69;
						button2LData.heightHint = 34;
						button2LData.verticalAlignment = GridData.BEGINNING;
						btnOk.setLayoutData(button2LData);
					}
				}
			}
			postInitGui();
			dialogShell.layout();
			dialogShell.pack();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed())
			{
				if (!display.readAndDispatch())
					display.sleep();
			}
			return invTrans;
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getParent());
			return null;
		}
	}

	public void postInitGui()
	{
		fillComboCurrency();
		fillComboWarehouses();
	}

	public void fillComboUnits(TurqInventoryCard invCard)
	{
	}

	public void fillComboCurrency()
	{
		try
		{
			comboCurrency.removeAll();
			List currencies = (List)EngTXCommon.doSelectTX(EngBLServer.class.getName(),"getCurrencies",null);
			TurqCurrency currency;
			for (int i = 0; i < currencies.size(); i++)
			{
				currency = (TurqCurrency) currencies.get(i);
				comboCurrency.add(currency.getCurrenciesAbbreviation());
				comboCurrency.setData(currency.getCurrenciesAbbreviation(), currency);
			}
			if (comboCurrency.getItemCount() > 0)
			{
				comboCurrency.setText(comboCurrency.getItem(0));
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}

	public void fillComboWarehouses()
	{
		try
		{
			comboWareHouses.removeAll();
			List list = (List)EngTXCommon.doSelectTX(InvBLWarehouseSearch.class.getName(),"getInventoryWarehouses",null);
			TurqInventoryWarehous warehouse;
			for (int i = 0; i < list.size(); i++)
			{
				warehouse = (TurqInventoryWarehous) list.get(i);
				comboWareHouses.add(warehouse.getWarehousesName());
				comboWareHouses.setData(warehouse.getWarehousesName(), warehouse);
			}
			if (comboWareHouses.getItemCount() > 0)
			{
				comboWareHouses.setText(comboWareHouses.getItem(0));
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}

	public void chooseInventoryPrice()
	{
		if (txtInvCard.getData() != null)
		{
			TurqInventoryCard invCard = (TurqInventoryCard) txtInvCard.getData();
			TurqInventoryPrice price = new InvUIPriceChooseDialog(this.getParent(), SWT.NULL, invCard).open();
			if (price != null)
			{
				decTxtPrice.setText(price.getPricesAmount().toString());
				comboCurrency.setText(price.getTurqCurrency().getCurrenciesAbbreviation());
			}
		}
		else
		{
			MessageBox msg = new MessageBox(this.getParent(), SWT.NULL);
			msg.setMessage(InvLangKeys.MSG_ENTER_INV_CODE_FIRST); //$NON-NLS-1$
			msg.open();
		}
	}

	public void chooseInventoryCard(TurqInventoryCard invCard)
	{
		if (invCard != null)
		{
			fillComboUnits(invCard);
			txtVat.setText(invCard.getCardVat());
			numSpecialVat.setText(invCard.getCardSpecialVat());
			numTxtSpecialVatEach.setText(invCard.getCardSpecialVatEach());
		}
	}

	boolean verifyFields()
	{
		if (txtInvCard.getData() == null)
		{
			MessageBox msg = new MessageBox(this.getParent(), SWT.NULL);
			msg.setMessage(InvLangKeys.MSG_SELECT_INV_CARD); 
			msg.open();
			return false;
		}
		return true;
	}

	public void btnOkMouseUp()
	{
	}
}