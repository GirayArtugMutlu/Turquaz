package com.turquaz.inventory.ui;

import java.math.BigDecimal;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.GridData;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryUnit;
import com.turquaz.engine.dal.TurqInventoryWarehous;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SecureComposite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CCombo;
import com.turquaz.inventory.bl.InvBLSaveTransaction;
import com.turquaz.inventory.bl.InvBLWarehouseSearch;
import com.turquaz.engine.ui.component.CurrencyText;
import com.turquaz.inventory.ui.comp.InventoryPicker;
import org.eclipse.swt.SWT;

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
			lblDocNo.setText("Belge No");
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
			lblInvCard.setText("Stok Kart\u0131");
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
			lblTransDate.setText("Tarih");
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
			lblAmount.setText("Giri\u015f Miktar\u0131");
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
			lblUnit.setText("Birimi");
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
			lblDefintion.setText("A�\u0131klama");
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
			lblWareHouse.setText("Depo");
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
			e.printStackTrace();
		}
	}

	public void fillComboWarehouses()
	{
		try
		{
			comboWareHouse.removeAll();
			List list = InvBLWarehouseSearch.getInventoryWarehouses();
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
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}

	public boolean verifyFields()
	{
		if (inventoryPicker.getData() == null)
		{
			EngUICommon.showMessageBox(getShell(), "L�tfen Stok Kart? Se�iniz.!");
			inventoryPicker.setFocus();
			return false;
		}
		if (!(txtAmount.getBigDecimalValue().doubleValue() > 0))
		{
			EngUICommon.showMessageBox(getShell(), "L�tfen Miktar Giriniz!");
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
				InvBLSaveTransaction.saveOtherInventoryTransaction((TurqInventoryCard) inventoryPicker.getData(), unit, warehouse,
						txtDocNo.getText(), datePicker.getDate(), txtDefinition.getText(), new BigDecimal(0), txtAmount
								.getBigDecimalValue());
				EngUICommon.showSavedSuccesfullyMessage(getShell());
				newForm();
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}
}