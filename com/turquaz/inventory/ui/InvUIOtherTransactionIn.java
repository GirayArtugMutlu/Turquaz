package com.turquaz.inventory.ui;

import java.math.BigDecimal;
import java.util.HashMap;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.GridData;
import com.turquaz.common.HashBag;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.lang.InvLangKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.DatePicker;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CCombo;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.bl.InvBLSaveTransaction;
import com.turquaz.inventory.bl.InvBLWarehouseSearch;
import com.turquaz.engine.ui.component.CurrencyText;
import com.turquaz.inventory.ui.comp.InventoryPicker;
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
public class InvUIOtherTransactionIn extends org.eclipse.swt.widgets.Composite implements SecureComposite
{
	private CLabel lblInvCard;
	private CLabel lblTransDate;
	private CurrencyText txtAmount;
	private CCombo comboWareHouse;
	private Text txtDefinition;
	private CLabel lblWareHouse;
	private CCombo comboUnits;
	private CLabel lblUnit;
	private CLabel lblDefintion;
	private CLabel lblAmount;
	private Text txtDocNo;
	private CLabel lblDocNo;
	private DatePicker datePicker;
	private InventoryPicker inventoryPicker;

	public InvUIOtherTransactionIn(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			this.setSize(520, 231);
			//START >> lblDocNo
			lblDocNo = new CLabel(this, SWT.NONE);
			lblDocNo.setText(EngLangCommonKeys.STR_DOCUMENT_NO);
			//END << lblDocNo
			//START >> txtDocNo
			txtDocNo = new Text(this, SWT.NONE);
			GridData txtDocNoLData = new GridData();
			txtDocNoLData.widthHint = 150;
			txtDocNoLData.heightHint = 17;
			txtDocNo.setLayoutData(txtDocNoLData);
			//END << txtDocNo
			//START >> lblInvCard
			lblInvCard = new CLabel(this, SWT.NONE);
			lblInvCard.setText(InvLangKeys.STR_INV_CARD);
			GridData lblInvCardLData = new GridData();
			lblInvCardLData.widthHint = 63;
			lblInvCardLData.heightHint = 19;
			lblInvCard.setLayoutData(lblInvCardLData);
			//END << lblInvCard
			//START >> inventoryPicker
			inventoryPicker = new InventoryPicker(this, SWT.NONE);
			GridData inventoryPickerLData = new GridData();
			inventoryPickerLData.widthHint = 153;
			inventoryPickerLData.heightHint = 20;
			inventoryPicker.setLayoutData(inventoryPickerLData);
			//END << inventoryPicker
			//START >> lblTransDate
			lblTransDate = new CLabel(this, SWT.NONE);
			lblTransDate.setText(EngLangCommonKeys.STR_DATE);
			//END << lblTransDate
			//START >> datePicker
			datePicker = new DatePicker(this, SWT.NONE);
			GridData datePickerLData = new GridData();
			datePickerLData.widthHint = 150;
			datePickerLData.heightHint = 23;
			datePicker.setLayoutData(datePickerLData);
			//END << datePicker
			//START >> lblAmount
			lblAmount = new CLabel(this, SWT.NONE);
			lblAmount.setText(InvLangKeys.STR_AMOUNT_IN);
			//END << lblAmount
			//START >> txtAmount
			txtAmount = new CurrencyText(this, SWT.NONE);
			GridData txtAmountLData = new GridData();
			txtAmountLData.widthHint = 150;
			txtAmountLData.heightHint = 17;
			txtAmount.setLayoutData(txtAmountLData);
			//END << txtAmount
			//START >> lblUnit
			lblUnit = new CLabel(this, SWT.NONE);
			lblUnit.setText(EngLangCommonKeys.STR_UNIT);
			GridData lblUnitLData = new GridData();
			lblUnit.setLayoutData(lblUnitLData);
			//END << lblUnit
			//START >> comboUnits
			comboUnits = new CCombo(this, SWT.NONE);
			GridData comboUnitsLData = new GridData();
			comboUnitsLData.widthHint = 135;
			comboUnitsLData.heightHint = 17;
			comboUnits.setLayoutData(comboUnitsLData);
			//END << comboUnits
			//START >> lblDefintion
			lblDefintion = new CLabel(this, SWT.NONE);
			lblDefintion.setText(EngLangCommonKeys.STR_DESCRIPTION);
			GridData lblDefintionLData = new GridData();
			lblDefintionLData.verticalAlignment = GridData.BEGINNING;
			lblDefintion.setLayoutData(lblDefintionLData);
			//END << lblDefintion
			//START >> txtDefinition
			txtDefinition = new Text(this, SWT.MULTI | SWT.WRAP);
			GridData txtDefinitionLData = new GridData();
			txtDefinitionLData.widthHint = 300;
			txtDefinitionLData.heightHint = 34;
			txtDefinition.setLayoutData(txtDefinitionLData);
			//END << txtDefinition
			//START >> lblWareHouse
			lblWareHouse = new CLabel(this, SWT.NONE);
			lblWareHouse.setText(InvLangKeys.STR_WAREHOUSE);
			//END << lblWareHouse
			//START >> comboWareHouse
			comboWareHouse = new CCombo(this, SWT.NONE);
			GridData comboWareHouseLData = new GridData();
			comboWareHouseLData.widthHint = 135;
			comboWareHouseLData.heightHint = 17;
			comboWareHouse.setLayoutData(comboWareHouseLData);
			//END << comboWareHouse
			this.layout();
			PostInitGui();
			inventoryPicker.setComboInvUnits(comboUnits);
		}
		catch (Exception e)
		{

            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}
	
	public void PostInitGui()
	{
		fillComboWarehouses();
	}

	public void fillComboWarehouses()
	{
		try
		{
			comboWareHouse.removeAll();
			HashBag whBag = (HashBag)EngTXCommon.doSelectTX(InvBLWarehouseSearch.class.getName(),"getInventoryWarehouses",null);
			HashMap warehouses=(HashMap)whBag.get(InvKeys.INV_WAREHOUSES);
			
			for (int i = 0; i < warehouses.size(); i++)
			{
				HashMap warehouse = (HashMap) warehouses.get(new Integer(i));
				String whName=(String)warehouse.get(InvKeys.INV_WAREHOUSE_NAME);
				comboWareHouse.add(whName);
				comboWareHouse.setData(whName, warehouse.get(InvKeys.INV_WAREHOUSE_ID));
			}
			if (comboWareHouse.getItemCount() > 0)
			{
				comboWareHouse.setText(comboWareHouse.getItem(0));
			}
		}
		catch (Exception ex)
		{

            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public boolean verifyFields()
	{
		if (inventoryPicker.getData() == null)
		{
			EngUICommon.showMessageBox(getShell(), InvLangKeys.MSG_SELECT_INV_CARD);
			inventoryPicker.setFocus();
			return false;
		}
		else if (!(txtAmount.getBigDecimalValue().doubleValue() > 0))
		{
			EngUICommon.showMessageBox(getShell(), InvLangKeys.MSG_ENTER_AMOUNT);
			txtAmount.setFocus();
			return false;
		}
		else if (comboWareHouse.getData(comboWareHouse.getText()) == null)
		{
			EngUICommon.showMessageBox(getShell(), InvLangKeys.MSG_SELECT_WAREHOUSE);
			comboWareHouse.setFocus();
			return false;
		}			
				
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.turquaz.engine.ui.component.SecureComposite#newForm()
	 */
	public void newForm()
	{
		InvUIOtherTransactionIn cardAdd = new InvUIOtherTransactionIn(this.getParent(), this.getStyle());
		CTabFolder tabfld = (CTabFolder) this.getParent();
		tabfld.getSelection().setControl(cardAdd);
		this.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.turquaz.engine.ui.component.SecureComposite#save()
	 */
	public void save()
	{
		try
		{
			if (verifyFields())
			{
				Integer warehouseId = (Integer) comboWareHouse.getData(comboWareHouse.getText());
				Integer unitId = (Integer) comboUnits.getData(comboUnits.getText());
				
				HashMap argMap=new HashMap();
				argMap.put(InvKeys.INV_CARD_ID,inventoryPicker.getId());
				argMap.put(InvKeys.INV_UNIT_ID,unitId);
				argMap.put(InvKeys.INV_WAREHOUSE_ID, warehouseId);
				argMap.put(EngKeys.DOCUMENT_NO,txtDocNo.getText());
				argMap.put(EngKeys.TRANS_DATE,datePicker.getDate());
				argMap.put(EngKeys.DEFINITION, txtDefinition.getText().trim());
				argMap.put(EngKeys.AMOUNT_IN,txtAmount.getBigDecimalValue());
				argMap.put(EngKeys.AMOUNT_OUT,new BigDecimal(0));
				
				EngTXCommon.doTransactionTX(InvBLSaveTransaction.class.getName(),"saveOtherInventoryTransaction",argMap);
				EngUICommon.showSavedSuccesfullyMessage(getShell());
				newForm();
			}
		}
		catch (Exception ex)
		{

            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}
}