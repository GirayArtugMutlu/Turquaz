package com.turquaz.bank.ui;

import org.eclipse.swt.widgets.Composite;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.bank.ui.comp.BankCardPicker;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;



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
public class BankUIBankCardAbstract extends org.eclipse.swt.widgets.Composite {

    {
        //Register as a resource user - SWTResourceManager will
        //handle the obtaining and disposing of resources
        SWTResourceManager.registerResourceUser(this);
    }

	private Composite compSearchPanel;
	private TableColumn tableColumnDate;
	private CLabel lblBankCard;
	private DatePicker dateEndDate;
	private CLabel lblEndDate;
	private DatePicker dateStartDate;
	private CLabel lblStartDate;
	private BankCardPicker bankPicker;
	private TableColumn tableColumnCredit;
	private TableColumn tableColumnDebit;
	private TableColumn tableColumnDefinition;
	private TableColumn tableColumnBankCode;
	private Table tableAbstract;

	public BankUIBankCardAbstract(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setBackground(SWTResourceManager.getColor(255, 255, 255));
			this.setSize(620, 389);
            {
                compSearchPanel = new Composite(this, SWT.NONE);
                GridLayout compSearchPanelLayout = new GridLayout();
                compSearchPanelLayout.numColumns = 2;
                GridData compSearchPanelLData = new GridData();
                compSearchPanelLData.grabExcessHorizontalSpace = true;
                compSearchPanelLData.horizontalAlignment = GridData.FILL;
                compSearchPanelLData.heightHint = 90;
                compSearchPanel.setLayoutData(compSearchPanelLData);
                compSearchPanel.setLayout(compSearchPanelLayout);
                {
                    lblBankCard = new CLabel(compSearchPanel, SWT.NONE);
                    lblBankCard.setText("Banka Kart?");
                }
                {
                    bankPicker = new BankCardPicker(compSearchPanel, SWT.NONE);
                    GridData bankPickerLData = new GridData();
                    bankPickerLData.widthHint = 178;
                    bankPickerLData.heightHint = 16;
                    bankPicker.setLayoutData(bankPickerLData);
                }
                {
                    lblStartDate = new CLabel(compSearchPanel, SWT.NONE);
                    lblStartDate.setText("Ba?lang?ç Tarihi");
                }
                {
                    dateStartDate = new DatePicker(compSearchPanel, SWT.NONE);
                    GridData dateStartDateLData = new GridData();
                    dateStartDateLData.widthHint = 112;
                    dateStartDateLData.heightHint = 20;
                    dateStartDate.setLayoutData(dateStartDateLData);
                }
                {
                    lblEndDate = new CLabel(compSearchPanel, SWT.NONE);
                    lblEndDate.setText("Biti? Tarihi");
                }
                {
                    dateEndDate = new DatePicker(compSearchPanel, SWT.NONE);
                    GridData dateEndDateLData = new GridData();
                    dateEndDateLData.widthHint = 110;
                    dateEndDateLData.heightHint = 20;
                    dateEndDate.setLayoutData(dateEndDateLData);
                }
            }
            {
                tableAbstract = new Table(this, SWT.SINGLE | SWT.FULL_SELECTION);
                GridData tableAbstractLData = new GridData();
                tableAbstract.setLinesVisible(true);
                tableAbstract.setHeaderVisible(true);
                tableAbstractLData.grabExcessHorizontalSpace = true;
                tableAbstractLData.horizontalAlignment = GridData.FILL;
                tableAbstractLData.verticalAlignment = GridData.FILL;
                tableAbstractLData.grabExcessVerticalSpace = true;
                tableAbstract.setLayoutData(tableAbstractLData);
                {
                    tableColumnDate = new TableColumn(tableAbstract, SWT.NONE);
                    tableColumnDate.setText("Tarih");
                    tableColumnDate.setWidth(83);
                }
                {
                    tableColumnBankCode = new TableColumn(
                        tableAbstract,
                        SWT.NONE);
                    tableColumnBankCode.setText("Banka Kodu");
                    tableColumnBankCode.setWidth(100);
                }
                {
                    tableColumnDefinition = new TableColumn(
                        tableAbstract,
                        SWT.NONE);
                    tableColumnDefinition.setText("Aç?klama");
                    tableColumnDefinition.setWidth(110);
                }
                {
                    tableColumnDebit = new TableColumn(tableAbstract, SWT.RIGHT);
                    tableColumnDebit.setText("Borç");
                    tableColumnDebit.setWidth(100);
                }
                {
                    tableColumnCredit = new TableColumn(tableAbstract, SWT.RIGHT);
                    tableColumnCredit.setText("Alacak");
                    tableColumnCredit.setWidth(100);
                }
            }
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
