package com.turquaz.inventory.ui;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import com.turquaz.engine.ui.component.DatePicker;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
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
public class InvUIInventoryLedger extends org.eclipse.swt.widgets.Composite {
	private Composite compFilter;
	private TableColumn tableColumnInvCode;
	private TableColumn tableColumnInvName;
	private TableColumn tableColumnTotalPrice;
	private TableColumn tableColumnAvgPrice;
	private TableColumn tableColumnLastAmount;
	private DatePicker datePicker;
	private CLabel lblDate;
	private Table tableInventories;

    /**
     * Bu Class Envanter Defterinin Cikarilmasini Saglar..
     * @param parent
     * @param style
     */
	public InvUIInventoryLedger(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setSize(545, 281);
            {
                compFilter = new Composite(this, SWT.NONE);
                GridLayout compFilterLayout = new GridLayout();
                compFilterLayout.numColumns = 2;
                GridData compFilterLData = new GridData();
                compFilterLData.heightHint = 39;
                compFilterLData.grabExcessHorizontalSpace = true;
                compFilterLData.horizontalAlignment = GridData.FILL;
                compFilter.setLayoutData(compFilterLData);
                compFilter.setLayout(compFilterLayout);
                {
                    lblDate = new CLabel(compFilter, SWT.NONE);
                    lblDate.setText("Tarih");
                    GridData lblDateLData = new GridData();
                    lblDateLData.widthHint = 51;
                    lblDateLData.heightHint = 22;
                    lblDate.setLayoutData(lblDateLData);
                }
                {
                    datePicker = new DatePicker(compFilter, SWT.NONE);
                    GridData datePickerLData = new GridData();
                    datePickerLData.widthHint = 149;
                    datePickerLData.heightHint = 21;
                    datePicker.setLayoutData(datePickerLData);
                }
            }
            {
                tableInventories = new Table(this, SWT.NONE);
                GridData table1LData = new GridData();
                tableInventories.setLinesVisible(true);
                tableInventories.setHeaderVisible(true);
                table1LData.grabExcessHorizontalSpace = true;
                table1LData.grabExcessVerticalSpace = true;
                table1LData.horizontalAlignment = GridData.FILL;
                table1LData.verticalAlignment = GridData.FILL;
                tableInventories.setLayoutData(table1LData);
                {
                    tableColumnInvCode = new TableColumn(tableInventories, SWT.NONE);
                    tableColumnInvCode.setText("Stok Kodu");
                    tableColumnInvCode.setWidth(87);
                }
                {
                    tableColumnInvName = new TableColumn(tableInventories, SWT.NONE);
                    tableColumnInvName.setText("Stok Cinsi");
                    tableColumnInvName.setWidth(88);
                }
                {
                    tableColumnLastAmount = new TableColumn(tableInventories, SWT.NONE);
                    tableColumnLastAmount.setText("Son Miktar");
                    tableColumnLastAmount.setWidth(100);
                }
                {
                    tableColumnAvgPrice = new TableColumn(tableInventories, SWT.RIGHT);
                    tableColumnAvgPrice.setText("Ort. Fiyat");
                    tableColumnAvgPrice.setWidth(100);
                }
                {
                    tableColumnTotalPrice = new TableColumn(tableInventories, SWT.RIGHT);
                    tableColumnTotalPrice.setText("Toplam Tutar?");
                    tableColumnTotalPrice.setWidth(100);
                }
            }
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
