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

/**
* @author  Onsel Armagan
* @version  $Id$
*/
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import org.eclipse.jface.contentassist.TextContentAssistSubjectAdapter;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.turquaz.current.Messages;
import com.turquaz.accounting.ui.comp.AccountPicker;
import com.turquaz.current.bl.CurBLCurrentCardAdd;
import com.turquaz.engine.bl.EngBLCurrentCards;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCurrentGroup;
import com.turquaz.engine.ui.component.CurrencyText;
import com.turquaz.engine.ui.component.NumericText;
import com.turquaz.engine.ui.component.SecureComposite;
import org.eclipse.swt.widgets.Label;
import com.turquaz.engine.ui.component.RegisterGroupComposite;
import com.turquaz.engine.ui.contentassist.TurquazContentAssistant;


import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Composite;


import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.events.VerifyEvent;
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
public class CurUICurrentCardAdd extends  Composite implements SecureComposite{


	/**
	 * @return Returns the btnUpdateGroups.
	 */
	public Button getBtnUpdateGroups() {
		return btnUpdateGroups;
	}
	/**
	 * @return Returns the accPickerCustomer.
	 */
	public AccountPicker getAccPickerCustomer() {
		return accPickerCustomer;
	}
	
	

	/**
	 * @return Returns the compCurrentContactInfo.
	 */
	public Composite getCompCurrentContactInfo() {
		return compCurrentContactInfo;
	}
	/**
	 * @param compCurrentContactInfo The compCurrentContactInfo to set.
	 */
	public void setCompCurrentContactInfo(Composite compCurrentContactInfo) {
		this.compCurrentContactInfo = compCurrentContactInfo;
	}
	/**
	 * @return Returns the compCurrentGeneralInfo.
	 */
	public Composite getCompCurrentGeneralInfo() {
		return compCurrentGeneralInfo;
	}
	/**
	 * @param compCurrentGeneralInfo The compCurrentGeneralInfo to set.
	 */
	public void setCompCurrentGeneralInfo(Composite compCurrentGeneralInfo) {
		this.compCurrentGeneralInfo = compCurrentGeneralInfo;
	}
	/**
	 * @return Returns the decTxtCreditLimit.
	 */
	public CurrencyText getDecTxtCreditLimit() {
		return decTxtCreditLimit;
	}
	/**
	 * @param decTxtCreditLimit The decTxtCreditLimit to set.
	 */
	public void setDecTxtCreditLimit(CurrencyText decTxtCreditLimit) {
		this.decTxtCreditLimit = decTxtCreditLimit;
	}
	/**
	 * @return Returns the decTxtDiscountAmount.
	 */
	public CurrencyText getDecTxtDiscountAmount() {
		return decTxtDiscountAmount;
	}
	/**
	 * @param decTxtDiscountAmount The decTxtDiscountAmount to set.
	 */
	public void setDecTxtDiscountAmount(CurrencyText decTxtDiscountAmount) {
		this.decTxtDiscountAmount = decTxtDiscountAmount;
	}
	/**
	 * @return Returns the decTxtRiskLimit.
	 */
	public CurrencyText getDecTxtRiskLimit() {
		return decTxtRiskLimit;
	}
	/**
	 * @param decTxtRiskLimit The decTxtRiskLimit to set.
	 */
	public void setDecTxtRiskLimit(CurrencyText decTxtRiskLimit) {
		this.decTxtRiskLimit = decTxtRiskLimit;
	}
	/**
	 * @return Returns the name.
	 */
	public CLabel getName() {
		return Name;
	}
	/**
	 * @param name The name to set.
	 */
	public void setName(CLabel name) {
		Name = name;
	}
	/**
	 * @return Returns the numTextDiscountRate.
	 */
	public NumericText getNumTextDiscountRate() {
		return numTextDiscountRate;
	}
	/**
	 * @param numTextDiscountRate The numTextDiscountRate to set.
	 */
	public void setNumTextDiscountRate(NumericText numTextDiscountRate) {
		this.numTextDiscountRate = numTextDiscountRate;
	}
	/**
	 * @return Returns the numTxtCityCode.
	 */
	public NumericText getNumTxtCityCode() {
		return numTxtCityCode;
	}
	/**
	 * @param numTxtCityCode The numTxtCityCode to set.
	 */
	public void setNumTxtCityCode(NumericText numTxtCityCode) {
		this.numTxtCityCode = numTxtCityCode;
	}
	/**
	 * @return Returns the numTxtCityCode2.
	 */
	public NumericText getNumTxtCityCode2() {
		return numTxtCityCode2;
	}
	/**
	 * @param numTxtCityCode2 The numTxtCityCode2 to set.
	 */
	public void setNumTxtCityCode2(NumericText numTxtCityCode2) {
		this.numTxtCityCode2 = numTxtCityCode2;
	}
	/**
	 * @return Returns the numtxtCountryCode.
	 */
	public NumericText getNumtxtCountryCode() {
		return numtxtCountryCode;
	}
	/**
	 * @param numtxtCountryCode The numtxtCountryCode to set.
	 */
	public void setNumtxtCountryCode(NumericText numtxtCountryCode) {
		this.numtxtCountryCode = numtxtCountryCode;
	}
	/**
	 * @return Returns the numTxtCountryCode2.
	 */
	public NumericText getNumTxtCountryCode2() {
		return numTxtCountryCode2;
	}
	/**
	 * @param numTxtCountryCode2 The numTxtCountryCode2 to set.
	 */
	public void setNumTxtCountryCode2(NumericText numTxtCountryCode2) {
		this.numTxtCountryCode2 = numTxtCountryCode2;
	}
	/**
	 * @return Returns the numTxtNumber.
	 */
	public NumericText getNumTxtNumber() {
		return numTxtNumber;
	}
	/**
	 * @param numTxtNumber The numTxtNumber to set.
	 */
	public void setNumTxtNumber(NumericText numTxtNumber) {
		this.numTxtNumber = numTxtNumber;
	}
	/**
	 * @return Returns the numTxtNumber2.
	 */
	public NumericText getNumTxtNumber2() {
		return numTxtNumber2;
	}
	/**
	 * @param numTxtNumber2 The numTxtNumber2 to set.
	 */
	public void setNumTxtNumber2(NumericText numTxtNumber2) {
		this.numTxtNumber2 = numTxtNumber2;
	}
	/**
	 * @return Returns the txtCardAddress.
	 */
	public Text getTxtCardAddress() {
		return txtCardAddress;
	}
	/**
	 * @param txtCardAddress The txtCardAddress to set.
	 */
	public void setTxtCardAddress(Text txtCardAddress) {
		this.txtCardAddress = txtCardAddress;
	}
	/**
	 * @return Returns the txtCardDefinition.
	 */
	public Text getTxtCardDefinition() {
		return txtCardDefinition;
	}
	/**
	 * @param txtCardDefinition The txtCardDefinition to set.
	 */
	public void setTxtCardDefinition(Text txtCardDefinition) {
		this.txtCardDefinition = txtCardDefinition;
	}
	/**
	 * @return Returns the txtContactAddress.
	 */
	public Text getTxtContactAddress() {
		return txtContactAddress;
	}
	/**
	 * @param txtContactAddress The txtContactAddress to set.
	 */
	public void setTxtContactAddress(Text txtContactAddress) {
		this.txtContactAddress = txtContactAddress;
	}
	/**
	 * @return Returns the txtContactEmail.
	 */
	public Text getTxtContactEmail() {
		return txtContactEmail;
	}
	/**
	 * @param txtContactEmail The txtContactEmail to set.
	 */
	public void setTxtContactEmail(Text txtContactEmail) {
		this.txtContactEmail = txtContactEmail;
	}
	/**
	 * @return Returns the txtContactName.
	 */
	public Text getTxtContactName() {
		return txtContactName;
	}
	/**
	 * @param txtContactName The txtContactName to set.
	 */
	public void setTxtContactName(Text txtContactName) {
		this.txtContactName = txtContactName;
	}
	/**
	 * @return Returns the txtContactPhone.
	 */
	public Text getTxtContactPhone() {
		return txtContactPhone;
	}
	/**
	 * @param txtContactPhone The txtContactPhone to set.
	 */
	public void setTxtContactPhone(Text txtContactPhone) {
		this.txtContactPhone = txtContactPhone;
	}
	/**
	 * @return Returns the txtContactPhone2.
	 */
	public Text getTxtContactPhone2() {
		return txtContactPhone2;
	}
	/**
	 * @param txtContactPhone2 The txtContactPhone2 to set.
	 */
	public void setTxtContactPhone2(Text txtContactPhone2) {
		this.txtContactPhone2 = txtContactPhone2;
	}
	/**
	 * @return Returns the txtContactWebSite.
	 */
	public Text getTxtContactWebSite() {
		return txtContactWebSite;
	}
	/**
	 * @param txtContactWebSite The txtContactWebSite to set.
	 */
	public void setTxtContactWebSite(Text txtContactWebSite) {
		this.txtContactWebSite = txtContactWebSite;
	}
	/**
	 * @return Returns the txtCurrentCode.
	 */
	public Text getTxtCurrentCode() {
		return txtCurrentCode;
	}
	/**
	 * @param txtCurrentCode The txtCurrentCode to set.
	 */
	public void setTxtCurrentCode(Text txtCurrentCode) {
		this.txtCurrentCode = txtCurrentCode;
	}
	/**
	 * @return Returns the txtCurrentName.
	 */
	public Text getTxtCurrentName() {
		return txtCurrentName;
	}
	/**
	 * @param txtCurrentName The txtCurrentName to set.
	 */
	public void setTxtCurrentName(Text txtCurrentName) {
		this.txtCurrentName = txtCurrentName;
	}
	/**
	 * @return Returns the txtFaxNumber.
	 */
	public Text getTxtFaxNumber() {
		return txtFaxNumber;
	}
	/**
	 * @param txtFaxNumber The txtFaxNumber to set.
	 */
	public void setTxtFaxNumber(Text txtFaxNumber) {
		this.txtFaxNumber = txtFaxNumber;
	}
	/**
	 * @return Returns the txtTaxDepartmant.
	 */
	public Text getTxtTaxDepartmant() {
		return txtTaxDepartmant;
	}
	/**
	 * @param txtTaxDepartmant The txtTaxDepartmant to set.
	 */
	public void setTxtTaxDepartmant(Text txtTaxDepartmant) {
		this.txtTaxDepartmant = txtTaxDepartmant;
	}
	/**
	 * @return Returns the txtTaxNumber.
	 */
	public Text getTxtTaxNumber() {
		return txtTaxNumber;
	}
	/**
	 * @param txtTaxNumber The txtTaxNumber to set.
	 */
	public void setTxtTaxNumber(Text txtTaxNumber) {
		this.txtTaxNumber = txtTaxNumber;
	}
	private RegisterGroupComposite compRegisterGroup;
	private Table table1;
	private Button btnUpdateGroups;
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
	private AccountPicker accPickerCustomer;
	private CLabel lblAccountingCodeCustomer;
	private CurrencyText decTxtDiscountAmount;
	private CLabel lblDiscountAMount;
	private NumericText numTextDiscountRate;
	private CLabel lblDiscountRate;
	private CurrencyText decTxtCreditLimit;
	private CLabel lblCreditLimit;
	private CurrencyText decTxtRiskLimit;
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
	private CurBLCurrentCardAdd currentAdd= new CurBLCurrentCardAdd();
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
			btnUpdateGroups = new Button(compCurrentGroups,SWT.PUSH| SWT.CENTER);
	
			this.setSize(new org.eclipse.swt.graphics.Point(598,467));
	
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
			tbfCurrentCardAdd.setSize(new org.eclipse.swt.graphics.Point(584,452));

			tabItemGeneralInfo.setText(Messages.getString("CurUICurrentCardAdd.0")); //$NON-NLS-1$
			{
				compCurrentGeneralInfo = new Composite(
					tbfCurrentCardAdd,
					SWT.NONE);
				tabItemGeneralInfo.setControl(compCurrentGeneralInfo);
				GridLayout compCurrentGeneralInfoLayout = new GridLayout(
					4,
					true);
				compCurrentGeneralInfoLayout.marginWidth = 5;
				compCurrentGeneralInfoLayout.marginHeight = 5;
				compCurrentGeneralInfoLayout.numColumns = 4;
				compCurrentGeneralInfoLayout.makeColumnsEqualWidth = false;
				compCurrentGeneralInfoLayout.horizontalSpacing = 5;
				compCurrentGeneralInfoLayout.verticalSpacing = 5;
				compCurrentGeneralInfo
					.setSize(new org.eclipse.swt.graphics.Point(584, 435));
				compCurrentGeneralInfo.setLayout(compCurrentGeneralInfoLayout);
				{
					lblCurrentCode = new CLabel(
						compCurrentGeneralInfo,
						SWT.NONE);
					GridData lblCurrentCodeLData = new GridData();
					lblCurrentCodeLData.widthHint = 93;
					lblCurrentCodeLData.heightHint = 20;
					lblCurrentCode.setLayoutData(lblCurrentCodeLData);
					lblCurrentCode.setText(Messages
						.getString("CurUICurrentCardAdd.1")); //$NON-NLS-1$
				}
				{
					txtCurrentCode = new Text(compCurrentGeneralInfo, SWT.NONE);
					GridData txtCurrentCodeLData = new GridData();
					txtCurrentCodeLData.widthHint = 148;
					txtCurrentCodeLData.heightHint = 8;
					txtCurrentCodeLData.horizontalSpan = 3;
					txtCurrentCode.setLayoutData(txtCurrentCodeLData);
					txtCurrentCode.setTextLimit(50);
					txtCurrentCode.setSize(new org.eclipse.swt.graphics.Point(
						154,
						14));
				}
				{
					lblCurrentName = new CLabel(
						compCurrentGeneralInfo,
						SWT.NONE);
					GridData lblCurrentNameLData = new GridData();
					lblCurrentNameLData.widthHint = 73;
					lblCurrentNameLData.heightHint = 19;
					lblCurrentName.setLayoutData(lblCurrentNameLData);
					lblCurrentName.setText(Messages
						.getString("CurUICurrentCardAdd.2")); //$NON-NLS-1$
					lblCurrentName.setSize(new org.eclipse.swt.graphics.Point(
						73,
						19));
				}
				{
					txtCurrentName = new Text(compCurrentGeneralInfo, SWT.NONE);
					GridData txtCurrentNameLData = new GridData();
					txtCurrentNameLData.horizontalAlignment = GridData.FILL;
					txtCurrentNameLData.heightHint = 11;
					txtCurrentNameLData.horizontalSpan = 3;
					txtCurrentNameLData.grabExcessHorizontalSpace = true;
					txtCurrentName.setLayoutData(txtCurrentNameLData);
					txtCurrentName.setTextLimit(250);
					txtCurrentName.setSize(new org.eclipse.swt.graphics.Point(
						445,
						17));
				}
				{
					lblCardDefinition = new CLabel(
						compCurrentGeneralInfo,
						SWT.NONE);
					GridData lblCardDefinitionLData = new GridData();
					lblCardDefinitionLData.verticalAlignment = GridData.BEGINNING;
					lblCardDefinition.setLayoutData(lblCardDefinitionLData);
					lblCardDefinition.setText(Messages
						.getString("CurUICurrentCardAdd.3")); //$NON-NLS-1$
				}
				{
					txtCardDefinition = new Text(
						compCurrentGeneralInfo,
						SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
					GridData txtCardDefinitionLData = new GridData();
					txtCardDefinitionLData.widthHint = 383;
					txtCardDefinitionLData.heightHint = 51;
					txtCardDefinitionLData.horizontalSpan = 3;
					txtCardDefinition.addVerifyListener(new VerifyListener() {
						public void verifyText(VerifyEvent evt) {
							if (evt.keyCode == SWT.TAB) {
								txtCardAddress.setFocus();
								evt.doit = false;

							}
						}
					});
					txtCardDefinition
						.addTraverseListener(new TraverseListener() {
							public void keyTraversed(TraverseEvent evt) {
								if (evt.keyCode == SWT.TAB) {
									txtCardAddress.setFocus();
									evt.doit = false;
								}
							}
						});
					txtCardDefinition.setLayoutData(txtCardDefinitionLData);
					txtCardDefinition.setTextLimit(250);
					txtCardDefinition
						.setSize(new org.eclipse.swt.graphics.Point(403, 53));
				}
				{
					lblCardAddress = new CLabel(
						compCurrentGeneralInfo,
						SWT.NONE);
					GridData lblCardAddressLData = new GridData();
					lblCardAddressLData.verticalAlignment = GridData.BEGINNING;
					lblCardAddress.setLayoutData(lblCardAddressLData);
					lblCardAddress.setText(Messages
						.getString("CurUICurrentCardAdd.4")); //$NON-NLS-1$
				}
				{
					txtCardAddress = new Text(compCurrentGeneralInfo, SWT.MULTI
						| SWT.WRAP
						| SWT.V_SCROLL);
					GridData txtCardAddressLData = new GridData();
					txtCardAddressLData.widthHint = 383;
					txtCardAddressLData.heightHint = 51;
					txtCardAddressLData.horizontalSpan = 3;
					txtCardAddress.addVerifyListener(new VerifyListener() {
						public void verifyText(VerifyEvent evt) {
							if (evt.keyCode == SWT.TAB) {
								composite1.setFocus();
								evt.doit = false;

							}
						}
					});
					txtCardAddress.addTraverseListener(new TraverseListener() {
						public void keyTraversed(TraverseEvent evt) {
							if (evt.keyCode == SWT.TAB) {
								numtxtCountryCode.setFocus();
								evt.doit = false;
							}
						}
					});
					txtCardAddress.setLayoutData(txtCardAddressLData);
					txtCardAddress.setTextLimit(250);
					txtCardAddress.setSize(new org.eclipse.swt.graphics.Point(
						403,
						53));
				}
				{
					lblTelephone1 = new Label(compCurrentGeneralInfo, SWT.NONE);
					GridData lblTelephone1LData = new GridData();
					lblTelephone1LData.widthHint = 82;
					lblTelephone1LData.heightHint = 16;
					lblTelephone1.setLayoutData(lblTelephone1LData);
					lblTelephone1.setText(Messages
						.getString("CurUICurrentCardAdd.5")); //$NON-NLS-1$
					lblTelephone1.setSize(new org.eclipse.swt.graphics.Point(
						82,
						16));
				}
				{
					composite1 = new Composite(compCurrentGeneralInfo, SWT.NONE);
					GridLayout composite1Layout = new GridLayout(3, true);
					composite1Layout.marginWidth = 0;
					composite1Layout.marginHeight = 0;
					composite1Layout.numColumns = 3;
					composite1Layout.makeColumnsEqualWidth = false;
					composite1Layout.horizontalSpacing = 5;
					composite1Layout.verticalSpacing = 0;
					GridData composite1LData = new GridData();
					composite1LData.widthHint = 222;
					composite1LData.heightHint = 18;
					composite1LData.horizontalSpan = 3;
					composite1.setLayoutData(composite1LData);
					composite1.setSize(new org.eclipse.swt.graphics.Point(
						222,
						18));
					composite1.setLayout(composite1Layout);
					{
						numtxtCountryCode = new NumericText(
							composite1,
							SWT.NONE);
						GridData numtxtCountryCodeLData = new GridData();
						numtxtCountryCodeLData.widthHint = 24;
						numtxtCountryCodeLData.heightHint = 10;
						numtxtCountryCode.setLayoutData(numtxtCountryCodeLData);
						numtxtCountryCode.setTextLimit(5);
						numtxtCountryCode
							.setSize(new org.eclipse.swt.graphics.Point(30, 16));
					}
					{
						numTxtCityCode = new NumericText(composite1, SWT.NONE);
						GridData numTxtCityCodeLData = new GridData();
						numTxtCityCodeLData.widthHint = 30;
						numTxtCityCodeLData.heightHint = 10;
						numTxtCityCode.setLayoutData(numTxtCityCodeLData);
						numTxtCityCode.setTextLimit(3);
						numTxtCityCode
							.setSize(new org.eclipse.swt.graphics.Point(36, 16));
					}
					{
						numTxtNumber = new NumericText(composite1, SWT.NONE);
						GridData numTxtNumberLData = new GridData();
						numTxtNumberLData.widthHint = 72;
						numTxtNumberLData.heightHint = 10;
						numTxtNumber.setLayoutData(numTxtNumberLData);
						numTxtNumber.setTextLimit(9);
						numTxtNumber
							.setSize(new org.eclipse.swt.graphics.Point(78, 16));
					}
					composite1.layout();
				}
				{
					lblTelephone2 = new Label(compCurrentGeneralInfo, SWT.NONE);
					GridData lblTelephone2LData = new GridData();
					lblTelephone2LData.widthHint = 82;
					lblTelephone2LData.heightHint = 16;
					lblTelephone2.setLayoutData(lblTelephone2LData);
					lblTelephone2.setText(Messages
						.getString("CurUICurrentCardAdd.6")); //$NON-NLS-1$
					lblTelephone2.setSize(new org.eclipse.swt.graphics.Point(
						82,
						16));
				}
				{
					composite2 = new Composite(compCurrentGeneralInfo, SWT.NONE);
					GridLayout composite2Layout = new GridLayout(3, true);
					composite2Layout.marginWidth = 0;
					composite2Layout.marginHeight = 0;
					composite2Layout.numColumns = 3;
					composite2Layout.makeColumnsEqualWidth = false;
					composite2Layout.horizontalSpacing = 5;
					composite2Layout.verticalSpacing = 0;
					GridData composite2LData = new GridData();
					composite2LData.widthHint = 222;
					composite2LData.heightHint = 18;
					composite2LData.horizontalSpan = 3;
					composite2.setLayoutData(composite2LData);
					composite2.setSize(new org.eclipse.swt.graphics.Point(
						222,
						18));
					composite2.setLayout(composite2Layout);
					{
						numTxtCountryCode2 = new NumericText(
							composite2,
							SWT.NONE);
						GridData numTxtCountryCode2LData = new GridData();
						numTxtCountryCode2LData.widthHint = 24;
						numTxtCountryCode2LData.heightHint = 10;
						numTxtCountryCode2
							.setLayoutData(numTxtCountryCode2LData);
						numTxtCountryCode2.setTextLimit(5);
						numTxtCountryCode2
							.setSize(new org.eclipse.swt.graphics.Point(30, 16));
					}
					{
						numTxtCityCode2 = new NumericText(composite2, SWT.NONE);
						GridData numTxtCityCode2LData = new GridData();
						numTxtCityCode2LData.widthHint = 30;
						numTxtCityCode2LData.heightHint = 10;
						numTxtCityCode2.setLayoutData(numTxtCityCode2LData);
						numTxtCityCode2.setTextLimit(3);
						numTxtCityCode2
							.setSize(new org.eclipse.swt.graphics.Point(36, 16));
					}
					{
						numTxtNumber2 = new NumericText(composite2, SWT.NONE);
						GridData numTxtNumber2LData = new GridData();
						numTxtNumber2LData.widthHint = 72;
						numTxtNumber2LData.heightHint = 10;
						numTxtNumber2.setLayoutData(numTxtNumber2LData);
						numTxtNumber2.setTextLimit(9);
						numTxtNumber2
							.setSize(new org.eclipse.swt.graphics.Point(78, 16));
					}
					composite2.layout();
				}
				{
					lblTaxDepartment = new CLabel(
						compCurrentGeneralInfo,
						SWT.NONE);
					GridData lblTaxDepartmentLData = new GridData();
					lblTaxDepartmentLData.widthHint = 84;
					lblTaxDepartmentLData.heightHint = 19;
					lblTaxDepartment.setLayoutData(lblTaxDepartmentLData);
					lblTaxDepartment.setText(Messages
						.getString("CurUICurrentCardAdd.7")); //$NON-NLS-1$
					lblTaxDepartment
						.setSize(new org.eclipse.swt.graphics.Point(84, 19));
				}
				{
					txtTaxDepartmant = new Text(
						compCurrentGeneralInfo,
						SWT.NONE);
					GridData txtTaxDepartmantLData = new GridData();
					txtTaxDepartmantLData.widthHint = 141;
					txtTaxDepartmantLData.heightHint = 9;
					txtTaxDepartmant.setLayoutData(txtTaxDepartmantLData);
					txtTaxDepartmant.setTextLimit(50);
					txtTaxDepartmant
						.setSize(new org.eclipse.swt.graphics.Point(147, 15));
				}
				{
					lblTaxNumber = new CLabel(compCurrentGeneralInfo, SWT.NONE);
					GridData lblTaxNumberLData = new GridData();
					lblTaxNumberLData.widthHint = 105;
					lblTaxNumberLData.heightHint = 22;
					lblTaxNumber.setLayoutData(lblTaxNumberLData);
					lblTaxNumber.setText(Messages.getString("CurUICurrentCardAdd.8")); //$NON-NLS-1$
				}
				{
					txtTaxNumber = new Text(compCurrentGeneralInfo, SWT.NONE);
					GridData txtTaxNumberLData = new GridData();
					txtTaxNumberLData.widthHint = 168;
					txtTaxNumberLData.heightHint = 10;
					txtTaxNumber.setLayoutData(txtTaxNumberLData);
					txtTaxNumber.setTextLimit(50);
					txtTaxNumber.setSize(new org.eclipse.swt.graphics.Point(
						174,
						16));
				}
				{
					lblRiskLimit = new CLabel(compCurrentGeneralInfo, SWT.NONE);
					GridData lblRiskLimitLData = new GridData();
					lblRiskLimit.setLayoutData(lblRiskLimitLData);
					lblRiskLimit.setText(Messages
						.getString("CurUICurrentCardAdd.9")); //$NON-NLS-1$
				}
				{
					decTxtRiskLimit = new CurrencyText(
						compCurrentGeneralInfo,
						SWT.NONE);
					GridData decTxtRiskLimitLData = new GridData();
					decTxtRiskLimitLData.widthHint = 139;
					decTxtRiskLimitLData.heightHint = 10;
					decTxtRiskLimit.setLayoutData(decTxtRiskLimitLData);
					decTxtRiskLimit.setSize(new org.eclipse.swt.graphics.Point(
						145,
						16));
				}
				{
					lblCreditLimit = new CLabel(
						compCurrentGeneralInfo,
						SWT.NONE);
					GridData lblCreditLimitLData = new GridData();
					lblCreditLimitLData.widthHint = 90;
					lblCreditLimitLData.heightHint = 20;
					lblCreditLimit.setLayoutData(lblCreditLimitLData);
					lblCreditLimit.setText(Messages.getString("CurUICurrentCardAdd.10")); //$NON-NLS-1$
				}
				{
					decTxtCreditLimit = new CurrencyText(
						compCurrentGeneralInfo,
						SWT.NONE);
					GridData decTxtCreditLimitLData = new GridData();
					decTxtCreditLimitLData.widthHint = 169;
					decTxtCreditLimitLData.heightHint = 9;
					decTxtCreditLimit.setLayoutData(decTxtCreditLimitLData);
					decTxtCreditLimit
						.setSize(new org.eclipse.swt.graphics.Point(175, 15));
				}
				{
					lblDiscountRate = new CLabel(
						compCurrentGeneralInfo,
						SWT.NONE);
					GridData lblDiscountRateLData = new GridData();
					lblDiscountRate.setLayoutData(lblDiscountRateLData);
					lblDiscountRate.setText(Messages
						.getString("CurUICurrentCardAdd.11")); //$NON-NLS-1$
				}
				{
					numTextDiscountRate = new NumericText(
						compCurrentGeneralInfo,
						SWT.NONE);
					GridData numTextDiscountRateLData = new GridData();
					numTextDiscountRateLData.widthHint = 69;
					numTextDiscountRateLData.heightHint = 10;
					numTextDiscountRate.setLayoutData(numTextDiscountRateLData);
					numTextDiscountRate.setTextLimit(2);
				}
				{
					lblDiscountAMount = new CLabel(
						compCurrentGeneralInfo,
						SWT.NONE);
					GridData lblDiscountAMountLData = new GridData();
					lblDiscountAMountLData.widthHint = 102;
					lblDiscountAMountLData.heightHint = 16;
					lblDiscountAMount.setLayoutData(lblDiscountAMountLData);
					lblDiscountAMount.setText(Messages.getString("CurUICurrentCardAdd.12")); //$NON-NLS-1$
				}
				{
					decTxtDiscountAmount = new CurrencyText(
						compCurrentGeneralInfo,
						SWT.NONE);
					GridData decTxtDiscountAmountLData = new GridData();
					decTxtDiscountAmountLData.widthHint = 167;
					decTxtDiscountAmountLData.heightHint = 9;
					decTxtDiscountAmount
						.setLayoutData(decTxtDiscountAmountLData);
					decTxtDiscountAmount
						.setSize(new org.eclipse.swt.graphics.Point(173, 15));
				}
				{
					lblAccountingCodeCustomer = new CLabel(
						compCurrentGeneralInfo,
						SWT.NONE);
					GridData lblAccountingCodeCustomerLData = new GridData();
					lblAccountingCodeCustomerLData.widthHint = 127;
					lblAccountingCodeCustomerLData.heightHint = 17;
					lblAccountingCodeCustomer
						.setLayoutData(lblAccountingCodeCustomerLData);
					lblAccountingCodeCustomer.setText(Messages
						.getString("CurUICurrentCardAdd.13")); //$NON-NLS-1$
				}
				{
					accPickerCustomer = new AccountPicker(
						compCurrentGeneralInfo,
						SWT.NONE);
					GridData accPickerCustomerLData = new GridData();
					accPickerCustomerLData.widthHint = 236;
					accPickerCustomerLData.heightHint = 21;
					accPickerCustomerLData.horizontalSpan = 3;
					accPickerCustomer.setLayoutData(accPickerCustomerLData);
					accPickerCustomer
						.setSize(new org.eclipse.swt.graphics.Point(236, 21));
				}
				compCurrentGeneralInfo.layout();

			}

			tabItemContactInfo.setControl(compCurrentContactInfo);
			tabItemContactInfo.setText(Messages.getString("CurUICurrentCardAdd.15")); //$NON-NLS-1$
	
			compCurrentContactInfo.setSize(new org.eclipse.swt.graphics.Point(584,435));
	
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
			Name.setText(Messages.getString("CurUICurrentCardAdd.16")); //$NON-NLS-1$
	
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
			lblContactAddress.setText(Messages.getString("CurUICurrentCardAdd.17")); //$NON-NLS-1$
	
			GridData txtContactAddressLData = new GridData();
			txtContactAddress.addVerifyListener(new VerifyListener() {
				public void verifyText(VerifyEvent evt) {
					if (evt.keyCode == SWT.TAB) {
						txtContactPhone.setFocus();
						evt.doit = false;

					}
				}
			});
			txtContactAddress.addTraverseListener(new TraverseListener() {
				public void keyTraversed(TraverseEvent evt) {
					if (evt.keyCode == SWT.TAB) {
						txtContactPhone.setFocus();
						evt.doit = false;
					}
				}
			});
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
			lblPhone1.setText(Messages.getString("CurUICurrentCardAdd.18")); //$NON-NLS-1$
	
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
			lblPhone2.setText(Messages.getString("CurUICurrentCardAdd.19")); //$NON-NLS-1$
	
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
			lblContactFax.setText(Messages.getString("CurUICurrentCardAdd.20")); //$NON-NLS-1$
	
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
			cLabel1.setText(Messages.getString("CurUICurrentCardAdd.21")); //$NON-NLS-1$
	
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
			cLabel2.setText(Messages.getString("CurUICurrentCardAdd.22")); //$NON-NLS-1$
	
			GridData txtContactWebSiteLData = new GridData();
			txtContactWebSite.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent evt) {
					if (evt.keyCode==SWT.TAB)
					{
						tbfCurrentCardAdd.setSelection(tabItemCurrentGroups);
					}
				}
			});
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
			tabItemCurrentGroups.setText(Messages.getString("CurUICurrentCardAdd.23")); //$NON-NLS-1$
	
			compCurrentGroups.setSize(new org.eclipse.swt.graphics.Point(584,435));
	
			GridData compRegisterGroupLData = new GridData();
			compRegisterGroupLData.verticalAlignment = GridData.BEGINNING;
			compRegisterGroupLData.horizontalAlignment = GridData.BEGINNING;
			compRegisterGroupLData.widthHint = 188;
			compRegisterGroupLData.heightHint = 182;
			compRegisterGroupLData.horizontalIndent = 0;
			compRegisterGroupLData.horizontalSpan = 1;
			compRegisterGroupLData.verticalSpan = 1;
			compRegisterGroupLData.grabExcessHorizontalSpace = false;
			compRegisterGroupLData.grabExcessVerticalSpace = false;
			compRegisterGroup.setLayoutData(compRegisterGroupLData);
			compRegisterGroup.setSize(new org.eclipse.swt.graphics.Point(188,182));
			compRegisterGroup.layout();
	
			GridData btnUpdateGroupsLData = new GridData();
			btnUpdateGroupsLData.widthHint = 142;
			btnUpdateGroupsLData.heightHint = 36;
			btnUpdateGroupsLData.horizontalIndent = 10;
			btnUpdateGroups.setLayoutData(btnUpdateGroupsLData);
			btnUpdateGroups.setText(Messages.getString("CurUICurrentCardAdd.24")); //$NON-NLS-1$
			btnUpdateGroups.addMouseListener( new MouseAdapter() {
				public void mouseUp(MouseEvent evt) {
					btnUpdateGroupsMouseUp(evt);
				}
			});
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
	
	TurquazContentAssistant assistant;
	/** Add your post-init code in here 	*/
	public void postInitGUI(){
	fillGroups();
	accPickerCustomer.setFilter("120"); //$NON-NLS-1$
//	content assistant
	TextContentAssistSubjectAdapter adapter = new TextContentAssistSubjectAdapter(txtCurrentCode);
	assistant= new TurquazContentAssistant(adapter,3);
	adapter.appendVerifyKeyListener( new VerifyKeyListener() {
                 public void verifyKey(VerifyEvent event) {

                 // Check for Ctrl+Spacebar
                 if (event.stateMask == SWT.CTRL && event.character == ' ') {
             
                  assistant.showPossibleCompletions();    
                   event.doit = false;

                 }
              }
	});

	
	
	}
	public void fillGroups(){
	try{
	HashMap groupMap = new HashMap(); 
	
	List list = currentAdd.getCurrentGroups();
	TurqCurrentGroup curGroup;
	
	for(int i=0; i<list.size();i++){
	curGroup = (TurqCurrentGroup)list.get(i);
	groupMap.put(curGroup.getGroupsName(),curGroup);
	}
	
	compRegisterGroup.fillTableAllGroups(groupMap);	
	
	}
	catch(Exception ex){
	ex.printStackTrace();
	}
	
	}
	
	public void saveContact(Integer cardID)throws Exception{
	try{
	currentAdd.saveContact(cardID,txtContactName.getText().trim(),txtContactAddress.getText().trim(), 
						txtContactPhone.getText().trim(),txtContactPhone2.getText().trim(), txtFaxNumber.getText().trim(),
						txtContactEmail.getText().trim(),txtContactWebSite.getText().trim());
		}
	catch(Exception ex){
	throw ex;
	}
	
	}
	
	public void saveGroups(Integer cardID)throws Exception{
	try{
	TableItem items[] = compRegisterGroup.getTableAllGroups().getItems();
	
	for(int i=0;i<items.length;i++){
		if(items[i].getChecked()){
			currentAdd.registerGroup(cardID, items[i].getData());
		}
	}
	
		
	}
	catch(Exception ex){
	throw ex;
	}
	
	}
	public void savePhones(Integer cardID)throws Exception{
	try{
		currentAdd.saveCardPhone(numtxtCountryCode.getIntValue(),numTxtCityCode.getIntValue(),
								numTxtNumber.getIntValue(),cardID);
		
		currentAdd.saveCardPhone(numTxtCountryCode2.getIntValue(),numTxtCityCode2.getIntValue(),
								numTxtNumber2.getIntValue(),cardID);
		
	}
	catch(Exception ex){
	throw ex;
	}
	
	}
	
	public void clearFields(){
		 CurUICurrentCardAdd  curCard = new CurUICurrentCardAdd(this.getParent(),this.getStyle());
		 CTabFolder tabfld = (CTabFolder)this.getParent();
		 tabfld.getSelection().setControl(curCard);	 
		 this.dispose();
	}
	
	public boolean verifyFields(boolean save)throws Exception{
	try{
		MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
	 
		if(txtCurrentCode.getText().trim().equals("")){ //$NON-NLS-1$
			msg.setMessage(Messages.getString("CurUICurrentCardAdd.28")); //$NON-NLS-1$
			msg.open();
			txtCurrentCode.setFocus();
			return false;
		} 
		else if (save && EngBLCurrentCards.getCards(txtCurrentCode.getText().trim()) != null)
		{
			msg.setMessage("Daha önce varolan bir cari kart kodu giremezsiniz!");
			msg.open();
			txtCurrentCode.setFocus();
			return false;
		}
		else if(txtCurrentName.getText().trim().equals("")){ //$NON-NLS-1$
			msg.setMessage(Messages.getString("CurUICurrentCardAdd.30")); //$NON-NLS-1$
			msg.open();
			txtCurrentName.setFocus();
			return false;
		}
		else if(accPickerCustomer.getData()==null){
			msg.setMessage(Messages.getString("CurUICurrentCardAdd.31")); //$NON-NLS-1$
			msg.open();
			accPickerCustomer.setFocus();
			return false;
		}
		 
	
	return true;
	}
	catch(Exception ex){
	throw ex;
	}
	
	
	}
	
	public void save(){
	try{
	if(verifyFields(true))
	{
	
	Integer cardId = currentAdd.saveCurrentCard(txtCurrentCode.getText().trim(),
							txtCurrentName.getText().trim(),
							txtCardDefinition.getText().trim(),
							txtCardAddress.getText().trim(),
							new BigDecimal(numTextDiscountRate.getIntValue()),
							decTxtDiscountAmount.getBigDecimalValue(),
							decTxtCreditLimit.getBigDecimalValue(),
							decTxtRiskLimit.getBigDecimalValue(),
							txtTaxDepartmant.getText().trim(),
							txtTaxNumber.getText().trim(),
							(TurqAccountingAccount)accPickerCustomer.getData());	
	savePhones(cardId);
	saveContact(cardId);
	saveGroups(cardId);
	assistant.refreshContentAssistant(3);
	EngBLCurrentCards.RefreshContentAsistantMap();
	MessageBox msg=new MessageBox(this.getShell(), SWT.NULL);
	msg.setMessage(Messages.getString("CurUICurrentCardAdd.14")); //$NON-NLS-1$
	msg.open();
	
    clearFields();
	
	}
	}
	catch(Exception ex){
		ex.printStackTrace();
		MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
		msg.setMessage(ex.getMessage());
		msg.open();
	}
	}

	
	
	
	public void search(){
	}
	public void delete(){
	}
	public void newForm(){
	    clearFields();
	}
	
	
	
	
	/** Auto-generated event handler method */
	protected void btnUpdateGroupsMouseUp(MouseEvent evt){
		new CurUIGroupAddDialog(this.getShell(),SWT.NULL).open();
		fillGroups();
	}
	/**
	 * @return Returns the compRegisterGroup.
	 */
	public RegisterGroupComposite getCompRegisterGroup() {
		return compRegisterGroup;
	}
	/**
	 * @param compRegisterGroup The compRegisterGroup to set.
	 */
	public void setCompRegisterGroup(RegisterGroupComposite compRegisterGroup) {
		this.compRegisterGroup = compRegisterGroup;
	}
}
