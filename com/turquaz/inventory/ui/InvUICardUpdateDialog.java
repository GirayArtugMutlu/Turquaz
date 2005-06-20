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
import java.math.BigDecimal;
import java.util.HashMap;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolBar;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.Dialog;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.bl.InvBLCardSearch;
import com.turquaz.inventory.bl.InvBLCardUpdate;
import com.turquaz.inventory.ui.InvUICardAdd;
import com.turquaz.inventory.ui.comp.InvUIPrice;
import com.turquaz.inventory.ui.comp.InvUIPriceList;
import com.turquaz.accounting.AccKeys;
import com.turquaz.common.HashBag;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.lang.InvLangKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.CurrencyText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class InvUICardUpdateDialog extends Dialog
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this.getParent());
	}
	private InvUICardAdd compInvUICard;
	private Composite compMain;
	private ToolItem toolCancel;
	private ToolItem toolDelete;
	private ToolItem toolUpdate;
	private ToolBar toolBarTop;
	private Shell dialogShell;
	private Integer invCardId;
	private HashBag invCard;
	private boolean updated = false;

	public InvUICardUpdateDialog(Shell parent, int style, Integer invCardId)
	{
		super(parent, style);
		this.invCardId = invCardId;
	}

	/**
	 * Opens the Dialog Shell. Auto-generated code - any changes you make will disappear.
	 */
	public boolean open()
	{
		try
		{
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL | SWT.RESIZE | SWT.MAX);
			dialogShell.setText(InvLangKeys.TITLE_INV_CARD_UPDATE);
			{
				toolBarTop = new ToolBar(dialogShell, SWT.SHADOW_OUT);
				GridData toolBarTopLData = new GridData();
				toolBarTopLData.horizontalAlignment = GridData.FILL;
				toolBarTopLData.grabExcessHorizontalSpace = true;
				toolBarTop.setLayoutData(toolBarTopLData);
			}
			toolUpdate = new ToolItem(toolBarTop, SWT.NULL);
			toolDelete = new ToolItem(toolBarTop, SWT.NULL);
			compMain = new Composite(dialogShell, SWT.NULL);
			compInvUICard = new InvUICardAdd(compMain, SWT.NULL);
			dialogShell.setSize(634, 368);
			toolUpdate.setText(EngLangCommonKeys.STR_UPDATE);
			toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif")); //$NON-NLS-1$
			toolUpdate.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent evt)
				{
					toolUpdateWidgetSelected(evt);
				}
			});
			toolDelete.setText(EngLangCommonKeys.STR_DELETE);
			toolDelete.setImage(SWTResourceManager.getImage("icons/Delete16.gif")); //$NON-NLS-1$
			{
				toolCancel = new ToolItem(toolBarTop, SWT.NONE);
				toolCancel.setText(EngLangCommonKeys.STR_CANCEL);
				toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg")); //$NON-NLS-1$
				toolCancel.addSelectionListener(new SelectionAdapter()
				{
					public void widgetSelected(SelectionEvent evt)
					{
						dialogShell.close();
					}
				});
			}
			toolDelete.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent evt)
				{
					toolDeleteWidgetSelected(evt);
				}
			});
			GridData compMainLData = new GridData();
			compMainLData.verticalAlignment = GridData.FILL;
			compMainLData.horizontalAlignment = GridData.FILL;
			compMainLData.widthHint = -1;
			compMainLData.heightHint = -1;
			compMainLData.horizontalIndent = 0;
			compMainLData.horizontalSpan = 1;
			compMainLData.verticalSpan = 1;
			compMainLData.grabExcessHorizontalSpace = true;
			compMainLData.grabExcessVerticalSpace = true;
			compMain.setLayoutData(compMainLData);
			compMain.setSize(new org.eclipse.swt.graphics.Point(603, 306));
			compInvUICard.setSize(new org.eclipse.swt.graphics.Point(603, 306));
			compInvUICard.layout();
			FillLayout compMainLayout = new FillLayout(256);
			compMain.setLayout(compMainLayout);
			compMainLayout.type = SWT.HORIZONTAL;
			compMainLayout.marginWidth = 0;
			compMainLayout.marginHeight = 0;
			compMainLayout.spacing = 0;
			compMain.layout();
			GridLayout dialogShellLayout = new GridLayout(1, true);
			dialogShell.setLayout(dialogShellLayout);
			dialogShellLayout.marginWidth = 5;
			dialogShellLayout.marginHeight = 5;
			dialogShellLayout.numColumns = 1;
			dialogShellLayout.makeColumnsEqualWidth = true;
			dialogShellLayout.horizontalSpacing = 5;
			dialogShellLayout.verticalSpacing = 5;
			dialogShell.layout();
			Rectangle bounds = dialogShell.computeTrim(0, 0, 613, 348);
			dialogShell.setSize(694, 381);
			postInitGUI();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed())
			{
				if (!display.readAndDispatch())
					display.sleep();
			}
			return updated;
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getParent());
			return true;
		}
	}

	/** Add your post-init code in here */
	public void postInitGUI()
	{
		try
		{
			toolUpdate.setEnabled(false);
			toolDelete.setEnabled(false);
			if (EngBLPermissions.getPermission(compInvUICard.getClass().getName()) == 2)
			{
				toolUpdate.setEnabled(true);
			}
			else if (EngBLPermissions.getPermission(compInvUICard.getClass().getName()) == 3)
			{
				toolDelete.setEnabled(true);
				toolUpdate.setEnabled(true);
			}
			EngUICommon.centreWindow(dialogShell);
			setButtonPermissions();
			HashMap argMap = new HashMap();
			argMap.put(InvKeys.INV_CARD_ID, invCardId);
			invCard = (HashBag) EngTXCommon.doSelectTX(InvBLCardSearch.class.getName(),
					"initializeInventoryCard", argMap);
			String invCardCode = (String) invCard.get(InvKeys.INV_CARD_CODE);
			String invCardName = (String) invCard.get(InvKeys.INV_CARD_NAME);
			String invCardDefinition = (String) invCard.get(InvKeys.INV_CARD_DEFINITION);
			Integer discountRate = (Integer) invCard.get(InvKeys.INV_DISCOUNT_RATE);
			Integer vatRate = (Integer) invCard.get(InvKeys.INV_VAT_RATE);
			Integer vatSpecialRate = (Integer) invCard.get(InvKeys.INV_VAT_SPECIAL_RATE);
			Integer maxAmount = (Integer) invCard.get(InvKeys.INV_MAX_AMOUNT);
			Integer minAmount = (Integer) invCard.get(InvKeys.INV_MIN_AMOUNT);
			BigDecimal specVatForEach = (BigDecimal) invCard.get(InvKeys.INV_SPECIAL_VAT_FOR_EACH);
			Boolean isSpecVatForEach = (Boolean) invCard.get(InvKeys.INV_IS_SPEC_VAT_FOR_EACH);
			compInvUICard.getTxtInvCardCode().setText(invCardCode);
			compInvUICard.getTxtInvCardDefinition().setText(invCardDefinition);
			compInvUICard.getTxtInvCardDiscount().setText(discountRate.intValue());
			compInvUICard.getTxtInvCardName().setText(invCardName);
			compInvUICard.getTxtInvCardVat().setText(vatRate.intValue());
			compInvUICard.getTxtnumInvCardMax().setText(maxAmount.intValue());
			compInvUICard.getTxtnumInvCardMin().setText(minAmount.intValue());
			compInvUICard.getNumTextSpecailVATPercent().setText(vatSpecialRate.intValue());
			compInvUICard.getDecTextSpecialVatAmount().setText(specVatForEach);
			compInvUICard.getRadioSpecialVatAmount().setSelection(isSpecVatForEach.booleanValue());
			compInvUICard.getRadioSpecialVatPercent().setSelection(!isSpecVatForEach.booleanValue());
			fillUnits();
			fillGroups();
			fillPrices();
			fillInvAccounts();
		}
		catch (Exception ex)
		{
			EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}

	public void setButtonPermissions()
	{
		int level = EngBLPermissions.getPermission(compInvUICard.getClass().getName());
		if (level == 3)
		{
			toolDelete.setEnabled(true);
			toolUpdate.setEnabled(true);
		}
		else
		{
			toolDelete.setEnabled(false);
			toolUpdate.setEnabled(false);
		}
	}

	public void fillInvAccounts() throws Exception
	{
		HashMap argMap = new HashMap();
		argMap.put(InvKeys.INV_CARD_ID,invCardId);
		HashBag invAccountBag = (HashBag) EngTXCommon.doSelectTX(InvBLCardSearch.class.getName(),
				"getInvAccountingAccs", argMap);
		
		HashMap invAccounts=(HashMap)invAccountBag.get(InvKeys.INV_ACCOUNTS);
		for (int k = 0; k < invAccounts.size(); k++)
		{
			HashMap invAcc = (HashMap) invAccounts.get(new Integer(k));
			TableItem[] invAccs = compInvUICard.getTableInvAccounts().getItems();
			HashMap accountMap=(HashMap)invAcc.get(AccKeys.ACC_ACCOUNT);
			HashMap typeMap=(HashMap)invAcc.get(InvKeys.INV_ACC_TYPE);
			Integer typeId=(Integer)typeMap.get(InvKeys.INV_ACC_TYPE_ID);
			for (int i = 0; i < invAccs.length; i++)
			{
				InvUIInvAccountingAccTableRow row = (InvUIInvAccountingAccTableRow) invAccs[i].getData();
				HashMap inventoryAcc = (HashMap) row.getDBObject();
				HashMap inventoryAccType=(HashMap)inventoryAcc.get(InvKeys.INV_ACC_TYPE);
				Integer accTypeId=(Integer)inventoryAccType.get(InvKeys.INV_ACC_TYPE_ID);
				
				if (typeId.intValue() == accTypeId.intValue())
				{
					inventoryAcc.put(AccKeys.ACC_ACCOUNT,accountMap);
					inventoryAcc.put(InvKeys.INV_CARD,invCard);
					compInvUICard.rowList.taskChanged(row);
				}
			}
		}
	}

	public void fillPrices() throws Exception
	{
		
		HashMap argMap = new HashMap();
		argMap.put(InvKeys.INV_CARD_ID,invCardId);
		HashBag invPriceBag = (HashBag) EngTXCommon.doSelectTX(InvBLCardSearch.class.getName(),
				"getInvCardPrices", argMap);

		HashMap invPrices=(HashMap)invPriceBag.get(InvKeys.INV_CARD_PRICES);
		InvUIPriceList priceList = compInvUICard.getPriceList();
		for(int k=0; k<invPrices.size(); k++)
		{
			HashMap invPrice = (HashMap) invPrices.get(new Integer(k));
			InvUIPrice price = new InvUIPrice();
			//XXX SATIS STRINGI
			price.priceType = EngLangCommonKeys.COMMON_SELL_STRING;
			
			Boolean isBuy=(Boolean)invPrice.get(InvKeys.INV_IS_BUY);
			if (isBuy.booleanValue())
			{
				//XXX ALISSS STRINGI
				price.priceType = EngLangCommonKeys.COMMON_BUY_STRING;
			}
			price.amount = invPrice.get(InvKeys.INV_PRICE_AMOUNT).toString();
			price.abrev = invPrice.get(EngKeys.CURRENCY_ABBR).toString();
			priceList.addPrice(price);
		}
	}

	public void fillGroups() throws Exception
	{
		HashMap argMap = new HashMap();
		argMap.put(InvKeys.INV_CARD_ID,invCardId);
		HashBag invPriceBag = (HashBag) EngTXCommon.doSelectTX(InvBLCardSearch.class.getName(),
				"getInvCardGroups", argMap);
		
		HashMap invGroups=(HashMap)invPriceBag.get(InvKeys.INV_CARD_GROUPS);
		HashMap registeredGroups = compInvUICard.getCompInvCardGroups().getRegisteredGroups();
		for(int k=0; k<invGroups.size(); k++)
		{
			HashMap cardGroup = (HashMap)invGroups.get(new Integer(k));
			HashMap invGroupMap=(HashMap)cardGroup.get(InvKeys.INV_GROUP);
			Integer parentGroupId=(Integer)invGroupMap.get(InvKeys.INV_PARENT_GROUP_ID);
			registeredGroups.put(parentGroupId, invGroupMap);
		}
		compInvUICard.getCompInvCardGroups().setRegisteredGroups(registeredGroups);
	}

	public void fillUnits() throws Exception
	{
		HashMap invCardUnits=(HashMap)invCard.get(InvKeys.INV_CARD_UNITS);
		Table tableRegisteredUnits = compInvUICard.getTableInvCardAddRegisteredUnits();
		for(int k=0; k<invCardUnits.size(); k++)
		{
			HashMap cardUnit = (HashMap)invCardUnits.get(new Integer(k));
			HashMap invUnit=(HashMap)cardUnit.get(InvKeys.INV_UNIT);
			String unitName = (String)invUnit.get(InvKeys.INV_UNIT_NAME);
			if (((BigDecimal)cardUnit.get(InvKeys.INV_CARD_UNIT_FACTOR)).compareTo(new BigDecimal(1)) == 0)
			{
				compInvUICard.getComboInvCardUnits().setText(unitName);
			}
			else
			{
				
				TableItem registeredItem = new TableItem(tableRegisteredUnits, SWT.NULL);
				registeredItem.setText(unitName);
				registeredItem.setData(invUnit.get(InvKeys.INV_UNIT_ID));
				TableEditor editor = new TableEditor(tableRegisteredUnits);
				editor.grabHorizontal = true;
				CurrencyText nText = new CurrencyText(tableRegisteredUnits, SWT.NONE);
				nText.setText((BigDecimal)cardUnit.get(InvKeys.INV_CARD_UNIT_FACTOR));
				editor.setEditor(nText, registeredItem, 1);
				compInvUICard.mapEditorsTableInvCardAddRegisteredUnits.put(unitName, editor);
				removeRegisteredUnit(unitName);
			}
		}
	}

	public void removeRegisteredUnit(String unitName)
	{
		TableItem items[] = compInvUICard.getTableInvCardAddAllUnits().getItems();
		for (int i = 0; i < items.length; i++)
		{
			if (items[i].getText().equals(unitName))
			{
				compInvUICard.getTableInvCardAddAllUnits().remove(i);
				break;
			}
		}
	}

	public void update()
	{
		try
		{
			if (compInvUICard.verifyFields(false))
			{
				updated = true;
				// Update Inventory Card Fields
				
				HashMap argMap=new HashMap();
				argMap.put(InvKeys.INV_CARD_ID,invCardId);
				argMap.put(InvKeys.INV_CARD_CODE,compInvUICard.getTxtInvCardCode().getText().trim());
				argMap.put(InvKeys.INV_CARD_NAME,compInvUICard.getTxtInvCardName().getText().trim());
				argMap.put(InvKeys.INV_CARD_DEFINITION,compInvUICard.getTxtInvCardDefinition().getText().trim());
				argMap.put(InvKeys.INV_CARD_MIN_AMOUNT,compInvUICard.getTxtnumInvCardMin().getIntegerValue());
				argMap.put(InvKeys.INV_CARD_MAX_AMOUNT,compInvUICard.getTxtnumInvCardMax().getIntegerValue());
				argMap.put(InvKeys.INV_CARD_VAT_RATE,compInvUICard.getTxtInvCardVat().getIntegerValue());
				argMap.put(InvKeys.INV_CARD_DISCOUNT_RATE,compInvUICard.getTxtInvCardDiscount().getIntegerValue());
				argMap.put(InvKeys.INV_CARD_SPECIAL_VAT_RATE,compInvUICard.getNumTextSpecailVATPercent().getIntegerValue());
				argMap.put(InvKeys.INV_CARD_SPECIAL_FOR_EACH,compInvUICard.getDecTextSpecialVatAmount().getBigDecimalValue());
				argMap.put(InvKeys.INV_CARD_IS_SPEC_AMOUNT,new Boolean(compInvUICard.getRadioSpecialVatAmount().getSelection()));
				argMap.put(InvKeys.INV_CARD_INV_GROUPS,compInvUICard.getCompInvCardGroups().getRegisteredGroups());
				argMap.put(InvKeys.INV_CARD_UNITS,compInvUICard.getInvUnits());
				argMap.put(InvKeys.INV_CARD_PRICES,compInvUICard.getInvPrices());
				argMap.put(InvKeys.INV_CARD_ACCOUNTS,compInvUICard.getInvAccounts());
				
				EngTXCommon.doTransactionTX(InvBLCardUpdate.class.getName(),"updateInventoryCard",argMap);
				
				EngUICommon.showUpdatedSuccesfullyMessage(getParent());
				this.dialogShell.close();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}

	public void delete()
	{
		try
		{
			boolean okToDelete=EngUICommon.okToDelete(getParent());
			if (!okToDelete)
				return;
			updated=true;
			HashMap argMap=new HashMap();
			argMap.put(InvKeys.INV_CARD_ID,invCardId);				
			EngTXCommon.doTransactionTX(InvBLCardUpdate.class.getName(),"deleteInventoryCard",argMap);				
			EngUICommon.showDeletedSuccesfullyMessage(getParent());
			this.dialogShell.dispose();
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
			dialogShell.close();
		}
	}

	/** Auto-generated event handler method */
	protected void toolUpdateWidgetSelected(SelectionEvent evt)
	{
		update();
	}

	/** Auto-generated event handler method */
	protected void toolDeleteWidgetSelected(SelectionEvent evt)
	{
		delete();
	}
}