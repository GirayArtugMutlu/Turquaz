package com.turquaz.inventory.ui;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.GridData;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryUnit;
import com.turquaz.engine.dal.TurqInventoryWarehous;
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
public class InvUIOtherTransactionOut extends org.eclipse.swt.widgets.Composite implements SecureComposite
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

	public InvUIOtherTransactionOut(org.eclipse.swt.widgets.Composite parent, int style)
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
			fillComboWarehouses();
			inventoryPicker.setComboInvUnits(comboUnits);
		}
		catch (Exception e)
		{

            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	public void fillComboWarehouses()
	{
		try
		{
			comboWareHouse.removeAll();
			List list = (List)EngTXCommon.doSelectTX(InvBLWarehouseSearch.class.getName(),"getInventoryWarehouses",null);
			TurqInventoryWarehous warehouse;
			for (int i = 0; i < list.size(); i++)
			{
				warehouse = (TurqInventoryWarehous) list.get(i);
				comboWareHouse.add(warehouse.getWarehousesName());
				comboWareHouse.setData(warehouse.getWarehousesName(), warehouse);
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
		if (!(txtAmount.getBigDecimalValue().doubleValue() > 0))
		{
			EngUICommon.showMessageBox(getShell(), InvLangKeys.MSG_ENTER_AMOUNT);
			txtAmount.setFocus();
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
		InvUIOtherTransactionOut cardAdd = new InvUIOtherTransactionOut(this.getParent(), this.getStyle());
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
				TurqInventoryWarehous warehouse = (TurqInventoryWarehous) comboWareHouse.getData(comboWareHouse.getText());
				TurqInventoryUnit unit = (TurqInventoryUnit) comboUnits.getData(comboUnits.getText());
				
				HashMap argMap=new HashMap();
				argMap.put(InvKeys.INV_CARD,(TurqInventoryCard) inventoryPicker.getData());
				argMap.put(InvKeys.INV_UNIT,unit);
				argMap.put(InvKeys.INV_WAREHOUSE, warehouse);
				argMap.put(EngKeys.DOCUMENT_NO,txtDocNo.getText());
				argMap.put(EngKeys.TRANS_DATE,datePicker.getDate());
				argMap.put(EngKeys.DEFINITION, txtDefinition.getText().trim());
				argMap.put(EngKeys.AMOUNT_IN,new BigDecimal(0));
				argMap.put(EngKeys.AMOUNT_OUT,txtAmount.getBigDecimalValue());
				
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