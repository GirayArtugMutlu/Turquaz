package com.turquaz.current.ui;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Text;
import com.turquaz.engine.ui.component.DecimalText;
import com.turquaz.engine.ui.component.NumericText;
import com.turquaz.accounting.ui.comp.AccountPicker;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import com.turquaz.engine.ui.component.RegisterGroupComposite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;


/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class CurUICurrentCardAdd extends org.eclipse.swt.widgets.Composite {

	private Button button1;
	private RegisterGroupComposite compRegisterGroup;
	private Text txtContactWebSite;
	private CLabel cLabel2;
	private Text txtContactEmail;
	private CLabel cLabel1;
	private Text txtFaxNumber;
	private CLabel lblContactFax;
	private Text txtContactPhone2;
	private CLabel lblPhone2;
	private Text txtContactPhone;
	private CLabel lblPhone1;
	private Text txtContactAddress;
	private CLabel lblContactAddress;
	private Text txtContactName;
	private CLabel Name;
	private NumericText numTxtNumber2;
	private NumericText numTxtCityCode2;
	private NumericText numTxtCountryCode2;
	private Composite composite2;
	private Label lblTelephone2;
	private NumericText numTxtNumber;
	private NumericText numTxtCityCode;
	private NumericText numtxtCountryCode;
	private Composite composite1;
	private Label lblTelephone1;
	private CLabel lblSuplierAccCode;
private AccountPicker accPickerSupplierAccCode;
	
	private AccountPicker accPickerCustomer;
	private CLabel lblAccountingCodeCustomer;
	private DecimalText decTxtDiscountAmount;
	private CLabel lblDiscountAMount;
	private NumericText numTextDiscountRate;
	private CLabel lblDiscountRate;
	private DecimalText decTxtCreditLimit;
	private CLabel lblCreditLimit;
	private DecimalText decTxtRiskLimit;
	private CLabel lblRiskLimit;
	private Text txtTaxNumber;
	private CLabel lblTaxNumber;
	private Text txtTaxDepartmant;
	private CLabel lblTaxDepartment;
	private Text txtCardAddress;
	private CLabel lblCardAddress;
	private Text txtCardDefinition;
	private CLabel lblCardDefinition;
	private Text txtCurrentName;
	private CLabel lblCurrentName;
	private Text txtCurrentCode;
	private CLabel lblCurrentCode;
	private Composite compCurrentGroups;
	private Composite compCurrentContactInfo;
	private Composite compCurrentGeneralInfo;
	private CTabItem tabItemCurrentGroups;
	private CTabItem tabItemContactInfo;
	private CTabItem tabItemGeneralInfo;
	private CTabFolder tbfCurrentCardAdd;
	public CurUICurrentCardAdd(Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	/**
	* Initializes the GUI.
	* Auto-generated code - any changes you make will disappear.
	*/
	public void initGUI(){
		try {
			preInitGUI();
	
			tbfCurrentCardAdd = new CTabFolder(this,SWT.NULL);
			tabItemGeneralInfo = new CTabItem(tbfCurrentCardAdd,SWT.NULL);
			compCurrentGeneralInfo = new Composite(tbfCurrentCardAdd,SWT.NULL);
			lblCurrentCode = new CLabel(compCurrentGeneralInfo,SWT.NULL);
			txtCurrentCode = new Text(compCurrentGeneralInfo,SWT.NULL);
			lblCurrentName = new CLabel(compCurrentGeneralInfo,SWT.NULL);
			txtCurrentName = new Text(compCurrentGeneralInfo,SWT.NULL);
			lblCardDefinition = new CLabel(compCurrentGeneralInfo,SWT.NULL);
			txtCardDefinition = new Text(compCurrentGeneralInfo,SWT.MULTI| SWT.WRAP| SWT.V_SCROLL);
			lblCardAddress = new CLabel(compCurrentGeneralInfo,SWT.NULL);
			txtCardAddress = new Text(compCurrentGeneralInfo,SWT.MULTI| SWT.WRAP| SWT.V_SCROLL);
			lblTelephone1 = new Label(compCurrentGeneralInfo,SWT.NULL);
			composite1 = new Composite(compCurrentGeneralInfo,SWT.NULL);
			numtxtCountryCode = new NumericText(composite1,SWT.NULL);
			numTxtCityCode = new NumericText(composite1,SWT.NULL);
			numTxtNumber = new NumericText(composite1,SWT.NULL);
			lblTelephone2 = new Label(compCurrentGeneralInfo,SWT.NULL);
			composite2 = new Composite(compCurrentGeneralInfo,SWT.NULL);
			numTxtCountryCode2 = new NumericText(composite2,SWT.NULL);
			numTxtCityCode2 = new NumericText(composite2,SWT.NULL);
			numTxtNumber2 = new NumericText(composite2,SWT.NULL);
			lblTaxDepartment = new CLabel(compCurrentGeneralInfo,SWT.NULL);
			txtTaxDepartmant = new Text(compCurrentGeneralInfo,SWT.NULL);
			lblTaxNumber = new CLabel(compCurrentGeneralInfo,SWT.NULL);
			txtTaxNumber = new Text(compCurrentGeneralInfo,SWT.NULL);
			lblRiskLimit = new CLabel(compCurrentGeneralInfo,SWT.NULL);
			decTxtRiskLimit = new DecimalText(compCurrentGeneralInfo,SWT.NULL);
			lblCreditLimit = new CLabel(compCurrentGeneralInfo,SWT.NULL);
			decTxtCreditLimit = new DecimalText(compCurrentGeneralInfo,SWT.NULL);
			lblDiscountRate = new CLabel(compCurrentGeneralInfo,SWT.NULL);
			numTextDiscountRate = new NumericText(compCurrentGeneralInfo,SWT.NULL);
			lblDiscountAMount = new CLabel(compCurrentGeneralInfo,SWT.NULL);
			decTxtDiscountAmount = new DecimalText(compCurrentGeneralInfo,SWT.NULL);
			lblAccountingCodeCustomer = new CLabel(compCurrentGeneralInfo,SWT.NULL);
			accPickerCustomer = new AccountPicker(compCurrentGeneralInfo,SWT.NULL);
			lblSuplierAccCode = new CLabel(compCurrentGeneralInfo,SWT.NULL);
			accPickerSupplierAccCode = new AccountPicker(compCurrentGeneralInfo,SWT.NULL);
			tabItemContactInfo = new CTabItem(tbfCurrentCardAdd,SWT.NULL);
			compCurrentContactInfo = new Composite(tbfCurrentCardAdd,SWT.NULL);
			Name = new CLabel(compCurrentContactInfo,SWT.NULL);
			txtContactName = new Text(compCurrentContactInfo,SWT.NULL);
			lblContactAddress = new CLabel(compCurrentContactInfo,SWT.NULL);
			txtContactAddress = new Text(compCurrentContactInfo,SWT.MULTI| SWT.WRAP| SWT.H_SCROLL);
			lblPhone1 = new CLabel(compCurrentContactInfo,SWT.NULL);
			txtContactPhone = new Text(compCurrentContactInfo,SWT.NULL);
			lblPhone2 = new CLabel(compCurrentContactInfo,SWT.NULL);
			txtContactPhone2 = new Text(compCurrentContactInfo,SWT.NULL);
			lblContactFax = new CLabel(compCurrentContactInfo,SWT.NULL);
			txtFaxNumber = new Text(compCurrentContactInfo,SWT.NULL);
			cLabel1 = new CLabel(compCurrentContactInfo,SWT.NULL);
			txtContactEmail = new Text(compCurrentContactInfo,SWT.NULL);
			cLabel2 = new CLabel(compCurrentContactInfo,SWT.NULL);
			txtContactWebSite = new Text(compCurrentContactInfo,SWT.NULL);
			tabItemCurrentGroups = new CTabItem(tbfCurrentCardAdd,SWT.NULL);
			compCurrentGroups = new Composite(tbfCurrentCardAdd,SWT.NULL);
			compRegisterGroup = new RegisterGroupComposite(compCurrentGroups,SWT.NULL);
			button1 = new Button(compCurrentGroups,SWT.PUSH| SWT.CENTER);
	
			this.setSize(new org.eclipse.swt.graphics.Point(530,468));
	
			GridData tbfCurrentCardAddLData = new GridData();
			tbfCurrentCardAddLData.verticalAlignment = GridData.FILL;
			tbfCurrentCardAddLData.horizontalAlignment = GridData.FILL;
			tbfCurrentCardAddLData.widthHint = -1;
			tbfCurrentCardAddLData.heightHint = -1;
			tbfCurrentCardAddLData.horizontalIndent = 0;
			tbfCurrentCardAddLData.horizontalSpan = 1;
			tbfCurrentCardAddLData.verticalSpan = 1;
			tbfCurrentCardAddLData.grabExcessHorizontalSpace = true;
			tbfCurrentCardAddLData.grabExcessVerticalSpace = true;
			tbfCurrentCardAdd.setLayoutData(tbfCurrentCardAddLData);
			tbfCurrentCardAdd.setSize(new org.eclipse.swt.graphics.Point(516,436));
	
			tabItemGeneralInfo.setControl(compCurrentGeneralInfo);
			tabItemGeneralInfo.setText("General Info");
	
			compCurrentGeneralInfo.setSize(new org.eclipse.swt.graphics.Point(619,433));
	
			GridData lblCurrentCodeLData = new GridData();
			lblCurrentCodeLData.verticalAlignment = GridData.CENTER;
			lblCurrentCodeLData.horizontalAlignment = GridData.BEGINNING;
			lblCurrentCodeLData.widthHint = 71;
			lblCurrentCodeLData.heightHint = 19;
			lblCurrentCodeLData.horizontalIndent = 0;
			lblCurrentCodeLData.horizontalSpan = 1;
			lblCurrentCodeLData.verticalSpan = 1;
			lblCurrentCodeLData.grabExcessHorizontalSpace = false;
			lblCurrentCodeLData.grabExcessVerticalSpace = false;
			lblCurrentCode.setLayoutData(lblCurrentCodeLData);
			lblCurrentCode.setText("Current Code");
			lblCurrentCode.setSize(new org.eclipse.swt.graphics.Point(71,19));
	
			GridData txtCurrentCodeLData = new GridData();
			txtCurrentCodeLData.verticalAlignment = GridData.CENTER;
			txtCurrentCodeLData.horizontalAlignment = GridData.BEGINNING;
			txtCurrentCodeLData.widthHint = 154;
			txtCurrentCodeLData.heightHint = 14;
			txtCurrentCodeLData.horizontalIndent = 0;
			txtCurrentCodeLData.horizontalSpan = 3;
			txtCurrentCodeLData.verticalSpan = 1;
			txtCurrentCodeLData.grabExcessHorizontalSpace = false;
			txtCurrentCodeLData.grabExcessVerticalSpace = false;
			txtCurrentCode.setLayoutData(txtCurrentCodeLData);
			txtCurrentCode.setTextLimit(50);
			txtCurrentCode.setSize(new org.eclipse.swt.graphics.Point(154,14));
	
			GridData lblCurrentNameLData = new GridData();
			lblCurrentNameLData.verticalAlignment = GridData.CENTER;
			lblCurrentNameLData.horizontalAlignment = GridData.BEGINNING;
			lblCurrentNameLData.widthHint = 73;
			lblCurrentNameLData.heightHint = 19;
			lblCurrentNameLData.horizontalIndent = 0;
			lblCurrentNameLData.horizontalSpan = 1;
			lblCurrentNameLData.verticalSpan = 1;
			lblCurrentNameLData.grabExcessHorizontalSpace = false;
			lblCurrentNameLData.grabExcessVerticalSpace = false;
			lblCurrentName.setLayoutData(lblCurrentNameLData);
			lblCurrentName.setText("Current Name");
			lblCurrentName.setSize(new org.eclipse.swt.graphics.Point(73,19));
	
			GridData txtCurrentNameLData = new GridData();
			txtCurrentNameLData.verticalAlignment = GridData.CENTER;
			txtCurrentNameLData.horizontalAlignment = GridData.FILL;
			txtCurrentNameLData.widthHint = -1;
			txtCurrentNameLData.heightHint = 17;
			txtCurrentNameLData.horizontalIndent = 0;
			txtCurrentNameLData.horizontalSpan = 3;
			txtCurrentNameLData.verticalSpan = 1;
			txtCurrentNameLData.grabExcessHorizontalSpace = true;
			txtCurrentNameLData.grabExcessVerticalSpace = false;
			txtCurrentName.setLayoutData(txtCurrentNameLData);
			txtCurrentName.setTextLimit(250);
			txtCurrentName.setSize(new org.eclipse.swt.graphics.Point(480,17));
	
			GridData lblCardDefinitionLData = new GridData();
			lblCardDefinitionLData.verticalAlignment = GridData.BEGINNING;
			lblCardDefinitionLData.horizontalAlignment = GridData.BEGINNING;
			lblCardDefinitionLData.widthHint = -1;
			lblCardDefinitionLData.heightHint = -1;
			lblCardDefinitionLData.horizontalIndent = 0;
			lblCardDefinitionLData.horizontalSpan = 1;
			lblCardDefinitionLData.verticalSpan = 1;
			lblCardDefinitionLData.grabExcessHorizontalSpace = false;
			lblCardDefinitionLData.grabExcessVerticalSpace = false;
			lblCardDefinition.setLayoutData(lblCardDefinitionLData);
			lblCardDefinition.setText("Definition");
	
			GridData txtCardDefinitionLData = new GridData();
			txtCardDefinitionLData.verticalAlignment = GridData.CENTER;
			txtCardDefinitionLData.horizontalAlignment = GridData.BEGINNING;
			txtCardDefinitionLData.widthHint = 403;
			txtCardDefinitionLData.heightHint = 53;
			txtCardDefinitionLData.horizontalIndent = 0;
			txtCardDefinitionLData.horizontalSpan = 3;
			txtCardDefinitionLData.verticalSpan = 1;
			txtCardDefinitionLData.grabExcessHorizontalSpace = false;
			txtCardDefinitionLData.grabExcessVerticalSpace = false;
			txtCardDefinition.setLayoutData(txtCardDefinitionLData);
			txtCardDefinition.setTextLimit(250);
			txtCardDefinition.setSize(new org.eclipse.swt.graphics.Point(403,53));
	
			GridData lblCardAddressLData = new GridData();
			lblCardAddressLData.verticalAlignment = GridData.BEGINNING;
			lblCardAddressLData.horizontalAlignment = GridData.BEGINNING;
			lblCardAddressLData.widthHint = -1;
			lblCardAddressLData.heightHint = -1;
			lblCardAddressLData.horizontalIndent = 0;
			lblCardAddressLData.horizontalSpan = 1;
			lblCardAddressLData.verticalSpan = 1;
			lblCardAddressLData.grabExcessHorizontalSpace = false;
			lblCardAddressLData.grabExcessVerticalSpace = false;
			lblCardAddress.setLayoutData(lblCardAddressLData);
			lblCardAddress.setText("Address");
	
			GridData txtCardAddressLData = new GridData();
			txtCardAddressLData.verticalAlignment = GridData.CENTER;
			txtCardAddressLData.horizontalAlignment = GridData.BEGINNING;
			txtCardAddressLData.widthHint = 403;
			txtCardAddressLData.heightHint = 53;
			txtCardAddressLData.horizontalIndent = 0;
			txtCardAddressLData.horizontalSpan = 3;
			txtCardAddressLData.verticalSpan = 1;
			txtCardAddressLData.grabExcessHorizontalSpace = false;
			txtCardAddressLData.grabExcessVerticalSpace = false;
			txtCardAddress.setLayoutData(txtCardAddressLData);
			txtCardAddress.setTextLimit(250);
			txtCardAddress.setSize(new org.eclipse.swt.graphics.Point(403,53));
	
			GridData lblTelephone1LData = new GridData();
			lblTelephone1LData.verticalAlignment = GridData.CENTER;
			lblTelephone1LData.horizontalAlignment = GridData.BEGINNING;
			lblTelephone1LData.widthHint = 82;
			lblTelephone1LData.heightHint = 16;
			lblTelephone1LData.horizontalIndent = 0;
			lblTelephone1LData.horizontalSpan = 1;
			lblTelephone1LData.verticalSpan = 1;
			lblTelephone1LData.grabExcessHorizontalSpace = false;
			lblTelephone1LData.grabExcessVerticalSpace = false;
			lblTelephone1.setLayoutData(lblTelephone1LData);
			lblTelephone1.setText("Telephone 1");
			lblTelephone1.setSize(new org.eclipse.swt.graphics.Point(82,16));
	
			GridData composite1LData = new GridData();
			composite1LData.verticalAlignment = GridData.CENTER;
			composite1LData.horizontalAlignment = GridData.BEGINNING;
			composite1LData.widthHint = 222;
			composite1LData.heightHint = 18;
			composite1LData.horizontalIndent = 0;
			composite1LData.horizontalSpan = 3;
			composite1LData.verticalSpan = 1;
			composite1LData.grabExcessHorizontalSpace = false;
			composite1LData.grabExcessVerticalSpace = false;
			composite1.setLayoutData(composite1LData);
			composite1.setSize(new org.eclipse.swt.graphics.Point(222,18));
	
			GridData numtxtCountryCodeLData = new GridData();
			numtxtCountryCodeLData.verticalAlignment = GridData.CENTER;
			numtxtCountryCodeLData.horizontalAlignment = GridData.BEGINNING;
			numtxtCountryCodeLData.widthHint = 30;
			numtxtCountryCodeLData.heightHint = 16;
			numtxtCountryCodeLData.horizontalIndent = 0;
			numtxtCountryCodeLData.horizontalSpan = 1;
			numtxtCountryCodeLData.verticalSpan = 1;
			numtxtCountryCodeLData.grabExcessHorizontalSpace = false;
			numtxtCountryCodeLData.grabExcessVerticalSpace = false;
			numtxtCountryCode.setLayoutData(numtxtCountryCodeLData);
			numtxtCountryCode.setTextLimit(5);
			numtxtCountryCode.setSize(new org.eclipse.swt.graphics.Point(30,16));
	
			GridData numTxtCityCodeLData = new GridData();
			numTxtCityCodeLData.verticalAlignment = GridData.CENTER;
			numTxtCityCodeLData.horizontalAlignment = GridData.BEGINNING;
			numTxtCityCodeLData.widthHint = 36;
			numTxtCityCodeLData.heightHint = 16;
			numTxtCityCodeLData.horizontalIndent = 0;
			numTxtCityCodeLData.horizontalSpan = 1;
			numTxtCityCodeLData.verticalSpan = 1;
			numTxtCityCodeLData.grabExcessHorizontalSpace = false;
			numTxtCityCodeLData.grabExcessVerticalSpace = false;
			numTxtCityCode.setLayoutData(numTxtCityCodeLData);
			numTxtCityCode.setTextLimit(3);
			numTxtCityCode.setSize(new org.eclipse.swt.graphics.Point(36,16));
	
			GridData numTxtNumberLData = new GridData();
			numTxtNumberLData.verticalAlignment = GridData.CENTER;
			numTxtNumberLData.horizontalAlignment = GridData.BEGINNING;
			numTxtNumberLData.widthHint = 78;
			numTxtNumberLData.heightHint = 16;
			numTxtNumberLData.horizontalIndent = 0;
			numTxtNumberLData.horizontalSpan = 1;
			numTxtNumberLData.verticalSpan = 1;
			numTxtNumberLData.grabExcessHorizontalSpace = false;
			numTxtNumberLData.grabExcessVerticalSpace = false;
			numTxtNumber.setLayoutData(numTxtNumberLData);
			numTxtNumber.setTextLimit(10);
			numTxtNumber.setSize(new org.eclipse.swt.graphics.Point(78,16));
			GridLayout composite1Layout = new GridLayout(3, true);
			composite1.setLayout(composite1Layout);
			composite1Layout.marginWidth = 0;
			composite1Layout.marginHeight = 0;
			composite1Layout.numColumns = 3;
			composite1Layout.makeColumnsEqualWidth = false;
			composite1Layout.horizontalSpacing = 5;
			composite1Layout.verticalSpacing = 0;
			composite1.layout();
	
			GridData lblTelephone2LData = new GridData();
			lblTelephone2LData.verticalAlignment = GridData.CENTER;
			lblTelephone2LData.horizontalAlignment = GridData.BEGINNING;
			lblTelephone2LData.widthHint = 82;
			lblTelephone2LData.heightHint = 16;
			lblTelephone2LData.horizontalIndent = 0;
			lblTelephone2LData.horizontalSpan = 1;
			lblTelephone2LData.verticalSpan = 1;
			lblTelephone2LData.grabExcessHorizontalSpace = false;
			lblTelephone2LData.grabExcessVerticalSpace = false;
			lblTelephone2.setLayoutData(lblTelephone2LData);
			lblTelephone2.setText("Telephone 2");
			lblTelephone2.setSize(new org.eclipse.swt.graphics.Point(82,16));
	
			GridData composite2LData = new GridData();
			composite2LData.verticalAlignment = GridData.CENTER;
			composite2LData.horizontalAlignment = GridData.BEGINNING;
			composite2LData.widthHint = 222;
			composite2LData.heightHint = 18;
			composite2LData.horizontalIndent = 0;
			composite2LData.horizontalSpan = 3;
			composite2LData.verticalSpan = 1;
			composite2LData.grabExcessHorizontalSpace = false;
			composite2LData.grabExcessVerticalSpace = false;
			composite2.setLayoutData(composite2LData);
			composite2.setSize(new org.eclipse.swt.graphics.Point(222,18));
	
			GridData numTxtCountryCode2LData = new GridData();
			numTxtCountryCode2LData.verticalAlignment = GridData.CENTER;
			numTxtCountryCode2LData.horizontalAlignment = GridData.BEGINNING;
			numTxtCountryCode2LData.widthHint = 30;
			numTxtCountryCode2LData.heightHint = 16;
			numTxtCountryCode2LData.horizontalIndent = 0;
			numTxtCountryCode2LData.horizontalSpan = 1;
			numTxtCountryCode2LData.verticalSpan = 1;
			numTxtCountryCode2LData.grabExcessHorizontalSpace = false;
			numTxtCountryCode2LData.grabExcessVerticalSpace = false;
			numTxtCountryCode2.setLayoutData(numTxtCountryCode2LData);
			numTxtCountryCode2.setTextLimit(5);
			numTxtCountryCode2.setSize(new org.eclipse.swt.graphics.Point(30,16));
	
			GridData numTxtCityCode2LData = new GridData();
			numTxtCityCode2LData.verticalAlignment = GridData.CENTER;
			numTxtCityCode2LData.horizontalAlignment = GridData.BEGINNING;
			numTxtCityCode2LData.widthHint = 36;
			numTxtCityCode2LData.heightHint = 16;
			numTxtCityCode2LData.horizontalIndent = 0;
			numTxtCityCode2LData.horizontalSpan = 1;
			numTxtCityCode2LData.verticalSpan = 1;
			numTxtCityCode2LData.grabExcessHorizontalSpace = false;
			numTxtCityCode2LData.grabExcessVerticalSpace = false;
			numTxtCityCode2.setLayoutData(numTxtCityCode2LData);
			numTxtCityCode2.setTextLimit(3);
			numTxtCityCode2.setSize(new org.eclipse.swt.graphics.Point(36,16));
	
			GridData numTxtNumber2LData = new GridData();
			numTxtNumber2LData.verticalAlignment = GridData.CENTER;
			numTxtNumber2LData.horizontalAlignment = GridData.BEGINNING;
			numTxtNumber2LData.widthHint = 78;
			numTxtNumber2LData.heightHint = 16;
			numTxtNumber2LData.horizontalIndent = 0;
			numTxtNumber2LData.horizontalSpan = 1;
			numTxtNumber2LData.verticalSpan = 1;
			numTxtNumber2LData.grabExcessHorizontalSpace = false;
			numTxtNumber2LData.grabExcessVerticalSpace = false;
			numTxtNumber2.setLayoutData(numTxtNumber2LData);
			numTxtNumber2.setTextLimit(10);
			numTxtNumber2.setSize(new org.eclipse.swt.graphics.Point(78,16));
			GridLayout composite2Layout = new GridLayout(3, true);
			composite2.setLayout(composite2Layout);
			composite2Layout.marginWidth = 0;
			composite2Layout.marginHeight = 0;
			composite2Layout.numColumns = 3;
			composite2Layout.makeColumnsEqualWidth = false;
			composite2Layout.horizontalSpacing = 5;
			composite2Layout.verticalSpacing = 0;
			composite2.layout();
	
			GridData lblTaxDepartmentLData = new GridData();
			lblTaxDepartmentLData.verticalAlignment = GridData.CENTER;
			lblTaxDepartmentLData.horizontalAlignment = GridData.BEGINNING;
			lblTaxDepartmentLData.widthHint = 84;
			lblTaxDepartmentLData.heightHint = 19;
			lblTaxDepartmentLData.horizontalIndent = 0;
			lblTaxDepartmentLData.horizontalSpan = 1;
			lblTaxDepartmentLData.verticalSpan = 1;
			lblTaxDepartmentLData.grabExcessHorizontalSpace = false;
			lblTaxDepartmentLData.grabExcessVerticalSpace = false;
			lblTaxDepartment.setLayoutData(lblTaxDepartmentLData);
			lblTaxDepartment.setText("Tax Department");
			lblTaxDepartment.setSize(new org.eclipse.swt.graphics.Point(84,19));
	
			GridData txtTaxDepartmantLData = new GridData();
			txtTaxDepartmantLData.verticalAlignment = GridData.CENTER;
			txtTaxDepartmantLData.horizontalAlignment = GridData.BEGINNING;
			txtTaxDepartmantLData.widthHint = 147;
			txtTaxDepartmantLData.heightHint = 15;
			txtTaxDepartmantLData.horizontalIndent = 0;
			txtTaxDepartmantLData.horizontalSpan = 1;
			txtTaxDepartmantLData.verticalSpan = 1;
			txtTaxDepartmantLData.grabExcessHorizontalSpace = false;
			txtTaxDepartmantLData.grabExcessVerticalSpace = false;
			txtTaxDepartmant.setLayoutData(txtTaxDepartmantLData);
			txtTaxDepartmant.setTextLimit(50);
			txtTaxDepartmant.setSize(new org.eclipse.swt.graphics.Point(147,15));
	
			GridData lblTaxNumberLData = new GridData();
			lblTaxNumberLData.verticalAlignment = GridData.CENTER;
			lblTaxNumberLData.horizontalAlignment = GridData.BEGINNING;
			lblTaxNumberLData.widthHint = 77;
			lblTaxNumberLData.heightHint = 21;
			lblTaxNumberLData.horizontalIndent = 0;
			lblTaxNumberLData.horizontalSpan = 1;
			lblTaxNumberLData.verticalSpan = 1;
			lblTaxNumberLData.grabExcessHorizontalSpace = false;
			lblTaxNumberLData.grabExcessVerticalSpace = false;
			lblTaxNumber.setLayoutData(lblTaxNumberLData);
			lblTaxNumber.setText("Tax Number");
			lblTaxNumber.setSize(new org.eclipse.swt.graphics.Point(77,21));
	
			GridData txtTaxNumberLData = new GridData();
			txtTaxNumberLData.verticalAlignment = GridData.CENTER;
			txtTaxNumberLData.horizontalAlignment = GridData.BEGINNING;
			txtTaxNumberLData.widthHint = 174;
			txtTaxNumberLData.heightHint = 16;
			txtTaxNumberLData.horizontalIndent = 0;
			txtTaxNumberLData.horizontalSpan = 1;
			txtTaxNumberLData.verticalSpan = 1;
			txtTaxNumberLData.grabExcessHorizontalSpace = false;
			txtTaxNumberLData.grabExcessVerticalSpace = false;
			txtTaxNumber.setLayoutData(txtTaxNumberLData);
			txtTaxNumber.setTextLimit(50);
			txtTaxNumber.setSize(new org.eclipse.swt.graphics.Point(174,16));
	
			GridData lblRiskLimitLData = new GridData();
			lblRiskLimitLData.verticalAlignment = GridData.CENTER;
			lblRiskLimitLData.horizontalAlignment = GridData.BEGINNING;
			lblRiskLimitLData.widthHint = -1;
			lblRiskLimitLData.heightHint = -1;
			lblRiskLimitLData.horizontalIndent = 0;
			lblRiskLimitLData.horizontalSpan = 1;
			lblRiskLimitLData.verticalSpan = 1;
			lblRiskLimitLData.grabExcessHorizontalSpace = false;
			lblRiskLimitLData.grabExcessVerticalSpace = false;
			lblRiskLimit.setLayoutData(lblRiskLimitLData);
			lblRiskLimit.setText("Risk Limit");
	
			GridData decTxtRiskLimitLData = new GridData();
			decTxtRiskLimitLData.verticalAlignment = GridData.CENTER;
			decTxtRiskLimitLData.horizontalAlignment = GridData.BEGINNING;
			decTxtRiskLimitLData.widthHint = 145;
			decTxtRiskLimitLData.heightHint = 16;
			decTxtRiskLimitLData.horizontalIndent = 0;
			decTxtRiskLimitLData.horizontalSpan = 1;
			decTxtRiskLimitLData.verticalSpan = 1;
			decTxtRiskLimitLData.grabExcessHorizontalSpace = false;
			decTxtRiskLimitLData.grabExcessVerticalSpace = false;
			decTxtRiskLimit.setLayoutData(decTxtRiskLimitLData);
			decTxtRiskLimit.setSize(new org.eclipse.swt.graphics.Point(145,16));
	
			GridData lblCreditLimitLData = new GridData();
			lblCreditLimitLData.verticalAlignment = GridData.CENTER;
			lblCreditLimitLData.horizontalAlignment = GridData.BEGINNING;
			lblCreditLimitLData.widthHint = 74;
			lblCreditLimitLData.heightHint = 19;
			lblCreditLimitLData.horizontalIndent = 0;
			lblCreditLimitLData.horizontalSpan = 1;
			lblCreditLimitLData.verticalSpan = 1;
			lblCreditLimitLData.grabExcessHorizontalSpace = false;
			lblCreditLimitLData.grabExcessVerticalSpace = false;
			lblCreditLimit.setLayoutData(lblCreditLimitLData);
			lblCreditLimit.setText("Credit Limit");
			lblCreditLimit.setSize(new org.eclipse.swt.graphics.Point(74,19));
	
			GridData decTxtCreditLimitLData = new GridData();
			decTxtCreditLimitLData.verticalAlignment = GridData.CENTER;
			decTxtCreditLimitLData.horizontalAlignment = GridData.BEGINNING;
			decTxtCreditLimitLData.widthHint = 175;
			decTxtCreditLimitLData.heightHint = 15;
			decTxtCreditLimitLData.horizontalIndent = 0;
			decTxtCreditLimitLData.horizontalSpan = 1;
			decTxtCreditLimitLData.verticalSpan = 1;
			decTxtCreditLimitLData.grabExcessHorizontalSpace = false;
			decTxtCreditLimitLData.grabExcessVerticalSpace = false;
			decTxtCreditLimit.setLayoutData(decTxtCreditLimitLData);
			decTxtCreditLimit.setSize(new org.eclipse.swt.graphics.Point(175,15));
	
			GridData lblDiscountRateLData = new GridData();
			lblDiscountRateLData.verticalAlignment = GridData.CENTER;
			lblDiscountRateLData.horizontalAlignment = GridData.BEGINNING;
			lblDiscountRateLData.widthHint = -1;
			lblDiscountRateLData.heightHint = -1;
			lblDiscountRateLData.horizontalIndent = 0;
			lblDiscountRateLData.horizontalSpan = 1;
			lblDiscountRateLData.verticalSpan = 1;
			lblDiscountRateLData.grabExcessHorizontalSpace = false;
			lblDiscountRateLData.grabExcessVerticalSpace = false;
			lblDiscountRate.setLayoutData(lblDiscountRateLData);
			lblDiscountRate.setText("Discount Rate");
	
			GridData numTextDiscountRateLData = new GridData();
			numTextDiscountRateLData.verticalAlignment = GridData.CENTER;
			numTextDiscountRateLData.horizontalAlignment = GridData.BEGINNING;
			numTextDiscountRateLData.widthHint = 72;
			numTextDiscountRateLData.heightHint = 14;
			numTextDiscountRateLData.horizontalIndent = 0;
			numTextDiscountRateLData.horizontalSpan = 1;
			numTextDiscountRateLData.verticalSpan = 1;
			numTextDiscountRateLData.grabExcessHorizontalSpace = false;
			numTextDiscountRateLData.grabExcessVerticalSpace = false;
			numTextDiscountRate.setLayoutData(numTextDiscountRateLData);
			numTextDiscountRate.setTextLimit(2);
			numTextDiscountRate.setSize(new org.eclipse.swt.graphics.Point(72,14));
	
			GridData lblDiscountAMountLData = new GridData();
			lblDiscountAMountLData.verticalAlignment = GridData.CENTER;
			lblDiscountAMountLData.horizontalAlignment = GridData.BEGINNING;
			lblDiscountAMountLData.widthHint = 94;
			lblDiscountAMountLData.heightHint = 17;
			lblDiscountAMountLData.horizontalIndent = 0;
			lblDiscountAMountLData.horizontalSpan = 1;
			lblDiscountAMountLData.verticalSpan = 1;
			lblDiscountAMountLData.grabExcessHorizontalSpace = false;
			lblDiscountAMountLData.grabExcessVerticalSpace = false;
			lblDiscountAMount.setLayoutData(lblDiscountAMountLData);
			lblDiscountAMount.setText("Discount Amount");
			lblDiscountAMount.setSize(new org.eclipse.swt.graphics.Point(94,17));
	
			GridData decTxtDiscountAmountLData = new GridData();
			decTxtDiscountAmountLData.verticalAlignment = GridData.CENTER;
			decTxtDiscountAmountLData.horizontalAlignment = GridData.BEGINNING;
			decTxtDiscountAmountLData.widthHint = 173;
			decTxtDiscountAmountLData.heightHint = 15;
			decTxtDiscountAmountLData.horizontalIndent = 0;
			decTxtDiscountAmountLData.horizontalSpan = 1;
			decTxtDiscountAmountLData.verticalSpan = 1;
			decTxtDiscountAmountLData.grabExcessHorizontalSpace = false;
			decTxtDiscountAmountLData.grabExcessVerticalSpace = false;
			decTxtDiscountAmount.setLayoutData(decTxtDiscountAmountLData);
			decTxtDiscountAmount.setSize(new org.eclipse.swt.graphics.Point(173,15));
	
			GridData lblAccountingCodeCustomerLData = new GridData();
			lblAccountingCodeCustomerLData.verticalAlignment = GridData.CENTER;
			lblAccountingCodeCustomerLData.horizontalAlignment = GridData.BEGINNING;
			lblAccountingCodeCustomerLData.widthHint = 118;
			lblAccountingCodeCustomerLData.heightHint = 18;
			lblAccountingCodeCustomerLData.horizontalIndent = 0;
			lblAccountingCodeCustomerLData.horizontalSpan = 1;
			lblAccountingCodeCustomerLData.verticalSpan = 1;
			lblAccountingCodeCustomerLData.grabExcessHorizontalSpace = false;
			lblAccountingCodeCustomerLData.grabExcessVerticalSpace = false;
			lblAccountingCodeCustomer.setLayoutData(lblAccountingCodeCustomerLData);
			lblAccountingCodeCustomer.setText("Customer Acc. Code");
			lblAccountingCodeCustomer.setSize(new org.eclipse.swt.graphics.Point(118,18));
	
			GridData accPickerCustomerLData = new GridData();
			accPickerCustomerLData.verticalAlignment = GridData.CENTER;
			accPickerCustomerLData.horizontalAlignment = GridData.BEGINNING;
			accPickerCustomerLData.widthHint = 236;
			accPickerCustomerLData.heightHint = 21;
			accPickerCustomerLData.horizontalIndent = 0;
			accPickerCustomerLData.horizontalSpan = 3;
			accPickerCustomerLData.verticalSpan = 1;
			accPickerCustomerLData.grabExcessHorizontalSpace = false;
			accPickerCustomerLData.grabExcessVerticalSpace = false;
			accPickerCustomer.setLayoutData(accPickerCustomerLData);
			accPickerCustomer.setSize(new org.eclipse.swt.graphics.Point(236,21));
			accPickerCustomer.layout();
	
			GridData lblSuplierAccCodeLData = new GridData();
			lblSuplierAccCodeLData.verticalAlignment = GridData.CENTER;
			lblSuplierAccCodeLData.horizontalAlignment = GridData.BEGINNING;
			lblSuplierAccCodeLData.widthHint = 96;
			lblSuplierAccCodeLData.heightHint = 19;
			lblSuplierAccCodeLData.horizontalIndent = 0;
			lblSuplierAccCodeLData.horizontalSpan = 1;
			lblSuplierAccCodeLData.verticalSpan = 1;
			lblSuplierAccCodeLData.grabExcessHorizontalSpace = false;
			lblSuplierAccCodeLData.grabExcessVerticalSpace = false;
			lblSuplierAccCode.setLayoutData(lblSuplierAccCodeLData);
			lblSuplierAccCode.setText("Supplier Acc. Code");
			lblSuplierAccCode.setSize(new org.eclipse.swt.graphics.Point(96,19));
	
			GridData accPickerSupplierAccCodeLData = new GridData();
			accPickerSupplierAccCodeLData.verticalAlignment = GridData.CENTER;
			accPickerSupplierAccCodeLData.horizontalAlignment = GridData.BEGINNING;
			accPickerSupplierAccCodeLData.widthHint = 236;
			accPickerSupplierAccCodeLData.heightHint = 21;
			accPickerSupplierAccCodeLData.horizontalIndent = 0;
			accPickerSupplierAccCodeLData.horizontalSpan = 3;
			accPickerSupplierAccCodeLData.verticalSpan = 1;
			accPickerSupplierAccCodeLData.grabExcessHorizontalSpace = false;
			accPickerSupplierAccCodeLData.grabExcessVerticalSpace = false;
			accPickerSupplierAccCode.setLayoutData(accPickerSupplierAccCodeLData);
			accPickerSupplierAccCode.setSize(new org.eclipse.swt.graphics.Point(236,21));
			accPickerSupplierAccCode.layout();
			GridLayout compCurrentGeneralInfoLayout = new GridLayout(4, true);
			compCurrentGeneralInfo.setLayout(compCurrentGeneralInfoLayout);
			compCurrentGeneralInfoLayout.marginWidth = 5;
			compCurrentGeneralInfoLayout.marginHeight = 5;
			compCurrentGeneralInfoLayout.numColumns = 4;
			compCurrentGeneralInfoLayout.makeColumnsEqualWidth = false;
			compCurrentGeneralInfoLayout.horizontalSpacing = 5;
			compCurrentGeneralInfoLayout.verticalSpacing = 5;
			compCurrentGeneralInfo.layout();
	
			tabItemContactInfo.setControl(compCurrentContactInfo);
			tabItemContactInfo.setText("Contact Info");
	
			compCurrentContactInfo.setSize(new org.eclipse.swt.graphics.Point(619,433));
	
			GridData NameLData = new GridData();
			NameLData.verticalAlignment = GridData.CENTER;
			NameLData.horizontalAlignment = GridData.BEGINNING;
			NameLData.widthHint = -1;
			NameLData.heightHint = -1;
			NameLData.horizontalIndent = 0;
			NameLData.horizontalSpan = 1;
			NameLData.verticalSpan = 1;
			NameLData.grabExcessHorizontalSpace = false;
			NameLData.grabExcessVerticalSpace = false;
			Name.setLayoutData(NameLData);
			Name.setText("Name / Surname");
	
			GridData txtContactNameLData = new GridData();
			txtContactNameLData.verticalAlignment = GridData.CENTER;
			txtContactNameLData.horizontalAlignment = GridData.BEGINNING;
			txtContactNameLData.widthHint = 198;
			txtContactNameLData.heightHint = 18;
			txtContactNameLData.horizontalIndent = 0;
			txtContactNameLData.horizontalSpan = 1;
			txtContactNameLData.verticalSpan = 1;
			txtContactNameLData.grabExcessHorizontalSpace = false;
			txtContactNameLData.grabExcessVerticalSpace = false;
			txtContactName.setLayoutData(txtContactNameLData);
			txtContactName.setSize(new org.eclipse.swt.graphics.Point(198,18));
	
			GridData lblContactAddressLData = new GridData();
			lblContactAddressLData.verticalAlignment = GridData.BEGINNING;
			lblContactAddressLData.horizontalAlignment = GridData.BEGINNING;
			lblContactAddressLData.widthHint = -1;
			lblContactAddressLData.heightHint = -1;
			lblContactAddressLData.horizontalIndent = 0;
			lblContactAddressLData.horizontalSpan = 1;
			lblContactAddressLData.verticalSpan = 1;
			lblContactAddressLData.grabExcessHorizontalSpace = false;
			lblContactAddressLData.grabExcessVerticalSpace = false;
			lblContactAddress.setLayoutData(lblContactAddressLData);
			lblContactAddress.setText("Address");
	
			GridData txtContactAddressLData = new GridData();
			txtContactAddressLData.verticalAlignment = GridData.CENTER;
			txtContactAddressLData.horizontalAlignment = GridData.BEGINNING;
			txtContactAddressLData.widthHint = 369;
			txtContactAddressLData.heightHint = 50;
			txtContactAddressLData.horizontalIndent = 0;
			txtContactAddressLData.horizontalSpan = 1;
			txtContactAddressLData.verticalSpan = 1;
			txtContactAddressLData.grabExcessHorizontalSpace = false;
			txtContactAddressLData.grabExcessVerticalSpace = false;
			txtContactAddress.setLayoutData(txtContactAddressLData);
			txtContactAddress.setSize(new org.eclipse.swt.graphics.Point(369,50));
	
			GridData lblPhone1LData = new GridData();
			lblPhone1LData.verticalAlignment = GridData.CENTER;
			lblPhone1LData.horizontalAlignment = GridData.BEGINNING;
			lblPhone1LData.widthHint = -1;
			lblPhone1LData.heightHint = -1;
			lblPhone1LData.horizontalIndent = 0;
			lblPhone1LData.horizontalSpan = 1;
			lblPhone1LData.verticalSpan = 1;
			lblPhone1LData.grabExcessHorizontalSpace = false;
			lblPhone1LData.grabExcessVerticalSpace = false;
			lblPhone1.setLayoutData(lblPhone1LData);
			lblPhone1.setText("Phone 1");
	
			GridData txtContactPhoneLData = new GridData();
			txtContactPhoneLData.verticalAlignment = GridData.CENTER;
			txtContactPhoneLData.horizontalAlignment = GridData.BEGINNING;
			txtContactPhoneLData.widthHint = 191;
			txtContactPhoneLData.heightHint = 16;
			txtContactPhoneLData.horizontalIndent = 0;
			txtContactPhoneLData.horizontalSpan = 1;
			txtContactPhoneLData.verticalSpan = 1;
			txtContactPhoneLData.grabExcessHorizontalSpace = false;
			txtContactPhoneLData.grabExcessVerticalSpace = false;
			txtContactPhone.setLayoutData(txtContactPhoneLData);
			txtContactPhone.setSize(new org.eclipse.swt.graphics.Point(191,16));
	
			GridData lblPhone2LData = new GridData();
			lblPhone2LData.verticalAlignment = GridData.CENTER;
			lblPhone2LData.horizontalAlignment = GridData.BEGINNING;
			lblPhone2LData.widthHint = -1;
			lblPhone2LData.heightHint = -1;
			lblPhone2LData.horizontalIndent = 0;
			lblPhone2LData.horizontalSpan = 1;
			lblPhone2LData.verticalSpan = 1;
			lblPhone2LData.grabExcessHorizontalSpace = false;
			lblPhone2LData.grabExcessVerticalSpace = false;
			lblPhone2.setLayoutData(lblPhone2LData);
			lblPhone2.setText("Phone 2");
	
			GridData txtContactPhone2LData = new GridData();
			txtContactPhone2LData.verticalAlignment = GridData.CENTER;
			txtContactPhone2LData.horizontalAlignment = GridData.BEGINNING;
			txtContactPhone2LData.widthHint = 191;
			txtContactPhone2LData.heightHint = 16;
			txtContactPhone2LData.horizontalIndent = 0;
			txtContactPhone2LData.horizontalSpan = 1;
			txtContactPhone2LData.verticalSpan = 1;
			txtContactPhone2LData.grabExcessHorizontalSpace = false;
			txtContactPhone2LData.grabExcessVerticalSpace = false;
			txtContactPhone2.setLayoutData(txtContactPhone2LData);
			txtContactPhone2.setSize(new org.eclipse.swt.graphics.Point(191,16));
	
			GridData lblContactFaxLData = new GridData();
			lblContactFaxLData.verticalAlignment = GridData.CENTER;
			lblContactFaxLData.horizontalAlignment = GridData.BEGINNING;
			lblContactFaxLData.widthHint = -1;
			lblContactFaxLData.heightHint = -1;
			lblContactFaxLData.horizontalIndent = 0;
			lblContactFaxLData.horizontalSpan = 1;
			lblContactFaxLData.verticalSpan = 1;
			lblContactFaxLData.grabExcessHorizontalSpace = false;
			lblContactFaxLData.grabExcessVerticalSpace = false;
			lblContactFax.setLayoutData(lblContactFaxLData);
			lblContactFax.setText("Fax Number");
	
			GridData txtFaxNumberLData = new GridData();
			txtFaxNumberLData.verticalAlignment = GridData.CENTER;
			txtFaxNumberLData.horizontalAlignment = GridData.BEGINNING;
			txtFaxNumberLData.widthHint = 191;
			txtFaxNumberLData.heightHint = 16;
			txtFaxNumberLData.horizontalIndent = 0;
			txtFaxNumberLData.horizontalSpan = 1;
			txtFaxNumberLData.verticalSpan = 1;
			txtFaxNumberLData.grabExcessHorizontalSpace = false;
			txtFaxNumberLData.grabExcessVerticalSpace = false;
			txtFaxNumber.setLayoutData(txtFaxNumberLData);
			txtFaxNumber.setSize(new org.eclipse.swt.graphics.Point(191,16));
	
			GridData cLabel1LData = new GridData();
			cLabel1LData.verticalAlignment = GridData.CENTER;
			cLabel1LData.horizontalAlignment = GridData.BEGINNING;
			cLabel1LData.widthHint = -1;
			cLabel1LData.heightHint = -1;
			cLabel1LData.horizontalIndent = 0;
			cLabel1LData.horizontalSpan = 1;
			cLabel1LData.verticalSpan = 1;
			cLabel1LData.grabExcessHorizontalSpace = false;
			cLabel1LData.grabExcessVerticalSpace = false;
			cLabel1.setLayoutData(cLabel1LData);
			cLabel1.setText("E-Mail");
	
			GridData txtContactEmailLData = new GridData();
			txtContactEmailLData.verticalAlignment = GridData.CENTER;
			txtContactEmailLData.horizontalAlignment = GridData.BEGINNING;
			txtContactEmailLData.widthHint = 191;
			txtContactEmailLData.heightHint = 16;
			txtContactEmailLData.horizontalIndent = 0;
			txtContactEmailLData.horizontalSpan = 1;
			txtContactEmailLData.verticalSpan = 1;
			txtContactEmailLData.grabExcessHorizontalSpace = false;
			txtContactEmailLData.grabExcessVerticalSpace = false;
			txtContactEmail.setLayoutData(txtContactEmailLData);
			txtContactEmail.setSize(new org.eclipse.swt.graphics.Point(191,16));
	
			GridData cLabel2LData = new GridData();
			cLabel2LData.verticalAlignment = GridData.CENTER;
			cLabel2LData.horizontalAlignment = GridData.BEGINNING;
			cLabel2LData.widthHint = -1;
			cLabel2LData.heightHint = -1;
			cLabel2LData.horizontalIndent = 0;
			cLabel2LData.horizontalSpan = 1;
			cLabel2LData.verticalSpan = 1;
			cLabel2LData.grabExcessHorizontalSpace = false;
			cLabel2LData.grabExcessVerticalSpace = false;
			cLabel2.setLayoutData(cLabel2LData);
			cLabel2.setText("Web Site");
	
			GridData txtContactWebSiteLData = new GridData();
			txtContactWebSiteLData.verticalAlignment = GridData.CENTER;
			txtContactWebSiteLData.horizontalAlignment = GridData.BEGINNING;
			txtContactWebSiteLData.widthHint = 191;
			txtContactWebSiteLData.heightHint = 16;
			txtContactWebSiteLData.horizontalIndent = 0;
			txtContactWebSiteLData.horizontalSpan = 1;
			txtContactWebSiteLData.verticalSpan = 1;
			txtContactWebSiteLData.grabExcessHorizontalSpace = false;
			txtContactWebSiteLData.grabExcessVerticalSpace = false;
			txtContactWebSite.setLayoutData(txtContactWebSiteLData);
			txtContactWebSite.setSize(new org.eclipse.swt.graphics.Point(191,16));
			GridLayout compCurrentContactInfoLayout = new GridLayout(2, true);
			compCurrentContactInfo.setLayout(compCurrentContactInfoLayout);
			compCurrentContactInfoLayout.marginWidth = 5;
			compCurrentContactInfoLayout.marginHeight = 5;
			compCurrentContactInfoLayout.numColumns = 2;
			compCurrentContactInfoLayout.makeColumnsEqualWidth = false;
			compCurrentContactInfoLayout.horizontalSpacing = 5;
			compCurrentContactInfoLayout.verticalSpacing = 5;
			compCurrentContactInfo.layout();
	
			tabItemCurrentGroups.setControl(compCurrentGroups);
			tabItemCurrentGroups.setText("Current Groups");
	
			compCurrentGroups.setSize(new org.eclipse.swt.graphics.Point(516,436));
	
			GridData compRegisterGroupLData = new GridData();
			compRegisterGroupLData.verticalAlignment = GridData.BEGINNING;
			compRegisterGroupLData.horizontalAlignment = GridData.FILL;
			compRegisterGroupLData.widthHint = -1;
			compRegisterGroupLData.heightHint = 181;
			compRegisterGroupLData.horizontalIndent = 0;
			compRegisterGroupLData.horizontalSpan = 1;
			compRegisterGroupLData.verticalSpan = 1;
			compRegisterGroupLData.grabExcessHorizontalSpace = true;
			compRegisterGroupLData.grabExcessVerticalSpace = false;
			compRegisterGroup.setLayoutData(compRegisterGroupLData);
			compRegisterGroup.setSize(new org.eclipse.swt.graphics.Point(506,181));
			compRegisterGroup.layout();
	
			GridData button1LData = new GridData();
			button1LData.verticalAlignment = GridData.CENTER;
			button1LData.horizontalAlignment = GridData.CENTER;
			button1LData.widthHint = 102;
			button1LData.heightHint = 32;
			button1LData.horizontalIndent = 0;
			button1LData.horizontalSpan = 1;
			button1LData.verticalSpan = 1;
			button1LData.grabExcessHorizontalSpace = false;
			button1LData.grabExcessVerticalSpace = false;
			button1.setLayoutData(button1LData);
			button1.setText("Update Groups");
			button1.setSize(new org.eclipse.swt.graphics.Point(102,32));
			GridLayout compCurrentGroupsLayout = new GridLayout(1, true);
			compCurrentGroups.setLayout(compCurrentGroupsLayout);
			compCurrentGroupsLayout.marginWidth = 5;
			compCurrentGroupsLayout.marginHeight = 5;
			compCurrentGroupsLayout.numColumns = 1;
			compCurrentGroupsLayout.makeColumnsEqualWidth = true;
			compCurrentGroupsLayout.horizontalSpacing = 5;
			compCurrentGroupsLayout.verticalSpacing = 5;
			compCurrentGroups.layout();
			tbfCurrentCardAdd.setSelection(0);
			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = true;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 5;
			this.layout();
	
			postInitGUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
/** Add your pre-init code in here 	*/
	public void preInitGUI(){
	}

	/** Add your post-init code in here 	*/
	public void postInitGUI(){
	}
}
