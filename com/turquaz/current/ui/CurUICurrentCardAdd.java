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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import com.turquaz.current.CurKeys;
import com.turquaz.current.Messages;
import com.turquaz.accounting.ui.AccUIAddAccountDialog;
import com.turquaz.accounting.ui.comp.AccountPicker;
import com.turquaz.current.bl.CurBLCurrentCardAdd;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLCurrentCards;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCurrentGroup;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.CurrencyText;
import com.turquaz.engine.ui.component.NumericText;
import com.turquaz.engine.ui.component.SecureComposite;
import org.eclipse.swt.widgets.Label;
import com.turquaz.engine.ui.component.CurrencyTextAdvanced;
import com.turquaz.current.ui.comp.CurrentCodePicker;
import com.turquaz.engine.ui.component.RegisterGroupComposite;
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
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class CurUICurrentCardAdd extends Composite implements SecureComposite
{
	/**
	 * @return Returns the btnUpdateGroups.
	 */
	public Button getBtnUpdateGroups()
	{
		return btnUpdateGroups;
	}

	/**
	 * @return Returns the accPickerCustomer.
	 */
	public AccountPicker getAccPickerCustomer()
	{
		return accPickerCustomer;
	}

	/**
	 * @return Returns the compCurrentContactInfo.
	 */
	public Composite getCompCurrentContactInfo()
	{
		return compCurrentContactInfo;
	}

	/**
	 * @return Returns the compCurrentGeneralInfo.
	 */
	public Composite getCompCurrentGeneralInfo()
	{
		return compCurrentGeneralInfo;
	}

	/**
	 * @return Returns the decTxtCreditLimit.
	 */
	public CurrencyText getDecTxtCreditLimit()
	{
		return decTxtCreditLimit;
	}

	/**
	 * @return Returns the decTxtDiscountAmount.
	 */
	public CurrencyText getDecTxtDiscountAmount()
	{
		return decTxtDiscountAmount;
	}

	/**
	 * @return Returns the decTxtRiskLimit.
	 */
	public CurrencyText getDecTxtRiskLimit()
	{
		return decTxtRiskLimit;
	}

	/**
	 * @return Returns the name.
	 */
	public CLabel getName()
	{
		return Name;
	}

	/**
	 * @return Returns the numTextDiscountRate.
	 */
	public CurrencyTextAdvanced getNumTextDiscountRate()
	{
		return numTextDiscountRate;
	}

	/**
	 * @return Returns the numTxtCityCode.
	 */
	public NumericText getNumTxtCityCode()
	{
		return numTxtCityCode;
	}

	/**
	 * @return Returns the numTxtCityCode2.
	 */
	public NumericText getNumTxtCityCode2()
	{
		return numTxtCityCode2;
	}

	/**
	 * @return Returns the numtxtCountryCode.
	 */
	public NumericText getNumtxtCountryCode()
	{
		return numtxtCountryCode;
	}

	/**
	 * @return Returns the numTxtCountryCode2.
	 */
	public NumericText getNumTxtCountryCode2()
	{
		return numTxtCountryCode2;
	}

	public NumericText getNumDueDays()
	{
		return numDueDays;
	}

	/**
	 * @return Returns the numTxtNumber.
	 */
	public NumericText getNumTxtNumber()
	{
		return numTxtNumber;
	}

	/**
	 * @return Returns the numTxtNumber2.
	 */
	public NumericText getNumTxtNumber2()
	{
		return numTxtNumber2;
	}

	/**
	 * @return Returns the txtCardAddress.
	 */
	public Text getTxtCardAddress()
	{
		return txtCardAddress;
	}

	/**
	 * @return Returns the txtCardDefinition.
	 */
	public Text getTxtCardDefinition()
	{
		return txtCardDefinition;
	}

	/**
	 * @return Returns the txtContactAddress.
	 */
	public Text getTxtContactAddress()
	{
		return txtContactAddress;
	}

	/**
	 * @return Returns the txtContactEmail.
	 */
	public Text getTxtContactEmail()
	{
		return txtContactEmail;
	}

	/**
	 * @return Returns the txtContactName.
	 */
	public Text getTxtContactName()
	{
		return txtContactName;
	}

	/**
	 * @return Returns the txtContactPhone.
	 */
	public Text getTxtContactPhone()
	{
		return txtContactPhone;
	}

	/**
	 * @return Returns the txtContactPhone2.
	 */
	public Text getTxtContactPhone2()
	{
		return txtContactPhone2;
	}

	/**
	 * @return Returns the txtContactWebSite.
	 */
	public Text getTxtContactWebSite()
	{
		return txtContactWebSite;
	}

	/**
	 * @return Returns the txtCurrentCode.
	 */
	public CurrentCodePicker getTxtCurrentCode()
	{
		return txtCurrentCode;
	}

	/**
	 * @return Returns the txtCurrentName.
	 */
	public Text getTxtCurrentName()
	{
		return txtCurrentName;
	}

	/**
	 * @return Returns the txtFaxNumber.
	 */
	public Text getTxtFaxNumber()
	{
		return txtFaxNumber;
	}

	/**
	 * @return Returns the txtTaxDepartmant.
	 */
	public Text getTxtTaxDepartmant()
	{
		return txtTaxDepartmant;
	}

	/**
	 * @return Returns the txtTaxNumber.
	 */
	public Text getTxtTaxNumber()
	{
		return txtTaxNumber;
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
	private CLabel cLabel4;
	private CLabel cLabel3;
	private CLabel lblChequesGiven;
	private AccountPicker accountPickerChequesTaken;
	private AccountPicker accountPickerChequesGiven;
	private CLabel lblChequeTaken;
	private AccountPicker accPickerCustomer;
	private CLabel lblAccountingCodeCustomer;
	private Composite compaccountingAccounts;
	private CTabItem tabItemAccountingAccounts;
	private NumericText numDueDays;
	private CLabel lblDueDays;
	private NumericText numTxtCityCode2;
	private NumericText numTxtCountryCode2;
	private Composite composite2;
	private Label lblTelephone2;
	private NumericText numTxtNumber;
	private NumericText numTxtCityCode;
	private NumericText numtxtCountryCode;
	private Composite composite1;
	private Label lblTelephone1;
	private CurrencyText decTxtDiscountAmount;
	private CLabel lblDiscountAMount;
	private CurrencyTextAdvanced numTextDiscountRate;
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
	private CurrentCodePicker txtCurrentCode;
	private CLabel lblCurrentCode;
	private Composite compCurrentGroups;
	private Composite compCurrentContactInfo;
	private Composite compCurrentGeneralInfo;
	private CTabItem tabItemCurrentGroups;
	private CTabItem tabItemContactInfo;
	private CTabItem tabItemGeneralInfo;
	private CTabFolder tbfCurrentCardAdd;

	public CurUICurrentCardAdd(Composite parent, int style)
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
			tbfCurrentCardAdd = new CTabFolder(this, SWT.NULL);
			tabItemGeneralInfo = new CTabItem(tbfCurrentCardAdd, SWT.NULL);
			compCurrentGroups = new Composite(tbfCurrentCardAdd, SWT.NULL);
			compRegisterGroup = new RegisterGroupComposite(compCurrentGroups, SWT.NULL);
			btnUpdateGroups = new Button(compCurrentGroups, SWT.PUSH | SWT.CENTER);
			this.setSize(new org.eclipse.swt.graphics.Point(598, 467));
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
			tbfCurrentCardAdd.setSize(new org.eclipse.swt.graphics.Point(584, 452));
			tabItemGeneralInfo.setText(Messages.getString("CurUICurrentCardAdd.0")); //$NON-NLS-1$
			{
				tabItemContactInfo = new CTabItem(tbfCurrentCardAdd, SWT.NONE);
				tabItemContactInfo.setText(Messages.getString("CurUICurrentCardAdd.15")); //$NON-NLS-1$
				{
					compCurrentContactInfo = new Composite(tbfCurrentCardAdd, SWT.NONE);
					tabItemContactInfo.setControl(compCurrentContactInfo);
					GridLayout compCurrentContactInfoLayout = new GridLayout(2, true);
					compCurrentContactInfoLayout.marginWidth = 5;
					compCurrentContactInfoLayout.marginHeight = 5;
					compCurrentContactInfoLayout.numColumns = 2;
					compCurrentContactInfoLayout.makeColumnsEqualWidth = false;
					compCurrentContactInfoLayout.horizontalSpacing = 5;
					compCurrentContactInfoLayout.verticalSpacing = 5;
					compCurrentContactInfo.setSize(new org.eclipse.swt.graphics.Point(584, 435));
					compCurrentContactInfo.setLayout(compCurrentContactInfoLayout);
					{
						Name = new CLabel(compCurrentContactInfo, SWT.NONE);
						GridData NameLData = new GridData();
						Name.setLayoutData(NameLData);
						Name.setText(Messages.getString("CurUICurrentCardAdd.16")); //$NON-NLS-1$
					}
					{
						txtContactName = new Text(compCurrentContactInfo, SWT.NONE);
						GridData txtContactNameLData = new GridData();
						txtContactNameLData.widthHint = 250;
						txtContactNameLData.heightHint = 17;
						txtContactName.setLayoutData(txtContactNameLData);
					}
					{
						lblContactAddress = new CLabel(compCurrentContactInfo, SWT.NONE);
						GridData lblContactAddressLData = new GridData();
						lblContactAddressLData.verticalAlignment = GridData.BEGINNING;
						lblContactAddress.setLayoutData(lblContactAddressLData);
						lblContactAddress.setText(Messages.getString("CurUICurrentCardAdd.17")); //$NON-NLS-1$
					}
					{
						txtContactAddress = new Text(compCurrentContactInfo, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
						GridData txtContactAddressLData = new GridData();
						txtContactAddressLData.widthHint = 360;
						txtContactAddressLData.heightHint = 40;
						txtContactAddress.addVerifyListener(new VerifyListener()
						{
							public void verifyText(VerifyEvent evt)
							{
								if (evt.keyCode == SWT.TAB)
								{
									txtContactPhone.setFocus();
									evt.doit = false;
								}
							}
						});
						txtContactAddress.addTraverseListener(new TraverseListener()
						{
							public void keyTraversed(TraverseEvent evt)
							{
								if (evt.keyCode == SWT.TAB)
								{
									txtContactPhone.setFocus();
									evt.doit = false;
								}
							}
						});
						txtContactAddress.setLayoutData(txtContactAddressLData);
					}
					{
						lblPhone1 = new CLabel(compCurrentContactInfo, SWT.NONE);
						GridData lblPhone1LData = new GridData();
						lblPhone1.setLayoutData(lblPhone1LData);
						lblPhone1.setText(Messages.getString("CurUICurrentCardAdd.18")); //$NON-NLS-1$
					}
					{
						txtContactPhone = new Text(compCurrentContactInfo, SWT.NONE);
						GridData txtContactPhoneLData = new GridData();
						txtContactPhoneLData.widthHint = 150;
						txtContactPhoneLData.heightHint = 17;
						txtContactPhone.setLayoutData(txtContactPhoneLData);
					}
					{
						lblPhone2 = new CLabel(compCurrentContactInfo, SWT.NONE);
						GridData lblPhone2LData = new GridData();
						lblPhone2.setLayoutData(lblPhone2LData);
						lblPhone2.setText(Messages.getString("CurUICurrentCardAdd.19")); //$NON-NLS-1$
					}
					{
						txtContactPhone2 = new Text(compCurrentContactInfo, SWT.NONE);
						GridData txtContactPhone2LData = new GridData();
						txtContactPhone2LData.widthHint = 150;
						txtContactPhone2LData.heightHint = 17;
						txtContactPhone2.setLayoutData(txtContactPhone2LData);
					}
					{
						lblContactFax = new CLabel(compCurrentContactInfo, SWT.NONE);
						GridData lblContactFaxLData = new GridData();
						lblContactFax.setLayoutData(lblContactFaxLData);
						lblContactFax.setText(Messages.getString("CurUICurrentCardAdd.20")); //$NON-NLS-1$
					}
					{
						txtFaxNumber = new Text(compCurrentContactInfo, SWT.NONE);
						GridData txtFaxNumberLData = new GridData();
						txtFaxNumberLData.widthHint = 150;
						txtFaxNumberLData.heightHint = 17;
						txtFaxNumber.setLayoutData(txtFaxNumberLData);
					}
					{
						cLabel1 = new CLabel(compCurrentContactInfo, SWT.NONE);
						GridData cLabel1LData = new GridData();
						cLabel1.setLayoutData(cLabel1LData);
						cLabel1.setText(Messages.getString("CurUICurrentCardAdd.21")); //$NON-NLS-1$
					}
					{
						txtContactEmail = new Text(compCurrentContactInfo, SWT.NONE);
						GridData txtContactEmailLData = new GridData();
						txtContactEmailLData.widthHint = 150;
						txtContactEmailLData.heightHint = 17;
						txtContactEmail.setLayoutData(txtContactEmailLData);
					}
					{
						cLabel2 = new CLabel(compCurrentContactInfo, SWT.NONE);
						GridData cLabel2LData = new GridData();
						cLabel2.setLayoutData(cLabel2LData);
						cLabel2.setText(Messages.getString("CurUICurrentCardAdd.22")); //$NON-NLS-1$
					}
					{
						txtContactWebSite = new Text(compCurrentContactInfo, SWT.NONE);
						GridData txtContactWebSiteLData = new GridData();
						txtContactWebSiteLData.widthHint = 150;
						txtContactWebSiteLData.heightHint = 17;
						txtContactWebSite.addKeyListener(new KeyAdapter()
						{
							public void keyReleased(KeyEvent evt)
							{
								if (evt.keyCode == SWT.TAB)
								{
									tbfCurrentCardAdd.setSelection(tabItemCurrentGroups);
								}
							}
						});
						txtContactWebSite.setLayoutData(txtContactWebSiteLData);
					}
					compCurrentContactInfo.layout();
				}
			}
			tabItemCurrentGroups = new CTabItem(tbfCurrentCardAdd, SWT.NONE);
			tabItemCurrentGroups.setText(Messages.getString("CurUICurrentCardAdd.23")); //$NON-NLS-1$
			//START >> tabItemAccountingAccounts
			tabItemAccountingAccounts = new CTabItem(tbfCurrentCardAdd, SWT.NONE);
			tabItemAccountingAccounts.setText(Messages.getString("CurUICurrentCardAdd.13")); //$NON-NLS-1$
			//START >> compaccountingAccounts
			compaccountingAccounts = new Composite(tbfCurrentCardAdd, SWT.NONE);
			tabItemAccountingAccounts.setControl(compaccountingAccounts);
			GridLayout compaccountingAccountsLayout = new GridLayout();
			compaccountingAccountsLayout.numColumns = 2;
			compaccountingAccounts.setLayout(compaccountingAccountsLayout);
			//START >> cLabel3
			cLabel3 = new CLabel(compaccountingAccounts, SWT.NONE);
			cLabel3.setText("cLabel3"); //$NON-NLS-1$
			cLabel3.setVisible(false);
			//END << cLabel3
			//START >> cLabel4
			cLabel4 = new CLabel(compaccountingAccounts, SWT.NONE);
			cLabel4.setText("cLabel4"); //$NON-NLS-1$
			cLabel4.setVisible(false);
			//END << cLabel4
			//START >> lblAccountingCodeCustomer
			lblAccountingCodeCustomer = new CLabel(compaccountingAccounts, SWT.NONE);
			lblAccountingCodeCustomer.setText(Messages.getString("CurUICurrentCardAdd.27")); //$NON-NLS-1$
			//END << lblAccountingCodeCustomer
			//START >> accPickerCustomer
			accPickerCustomer = new AccountPicker(compaccountingAccounts, SWT.NONE);
			GridData accountPickerCustomerLData = new GridData();
			accountPickerCustomerLData.widthHint = 157;
			accountPickerCustomerLData.heightHint = 17;
			accPickerCustomer.setLayoutData(accountPickerCustomerLData);
			//END << accPickerCustomer
			//START >> lblChequeTaken
			lblChequeTaken = new CLabel(compaccountingAccounts, SWT.NONE);
			lblChequeTaken.setText(Messages.getString("CurUICurrentCardAdd.29")); //$NON-NLS-1$
			GridData lblChequeTakenLData = new GridData();
			lblChequeTakenLData.widthHint = 110;
			lblChequeTakenLData.heightHint = 22;
			lblChequeTaken.setLayoutData(lblChequeTakenLData);
			//END << lblChequeTaken
			//START >> accountPickerChequesGiven
			accountPickerChequesGiven = new AccountPicker(compaccountingAccounts, SWT.NONE);
			GridData accountPickerChequesGivenLData = new GridData();
			accountPickerChequesGivenLData.widthHint = 157;
			accountPickerChequesGivenLData.heightHint = 17;
			accountPickerChequesGiven.setLayoutData(accountPickerChequesGivenLData);
			//END << accountPickerChequesGiven
			//START >> lblChequesGiven
			lblChequesGiven = new CLabel(compaccountingAccounts, SWT.NONE);
			lblChequesGiven.setText(Messages.getString("CurUICurrentCardAdd.31")); //$NON-NLS-1$
			//END << lblChequesGiven
			//START >> accountPickerChequesTaken
			accountPickerChequesTaken = new AccountPicker(compaccountingAccounts, SWT.NONE);
			GridData accountPicker1LData = new GridData();
			accountPicker1LData.widthHint = 157;
			accountPicker1LData.heightHint = 17;
			accountPickerChequesTaken.setLayoutData(accountPicker1LData);
			//END << accountPickerChequesTaken
			//END << compaccountingAccounts
			tbfCurrentCardAdd.setSelection(0);
			//END << tabItemAccountingAccounts
			{
				compCurrentGeneralInfo = new Composite(tbfCurrentCardAdd, SWT.NONE);
				tabItemGeneralInfo.setControl(compCurrentGeneralInfo);
				GridLayout compCurrentGeneralInfoLayout = new GridLayout(4, true);
				compCurrentGeneralInfoLayout.marginWidth = 5;
				compCurrentGeneralInfoLayout.marginHeight = 5;
				compCurrentGeneralInfoLayout.numColumns = 4;
				compCurrentGeneralInfoLayout.makeColumnsEqualWidth = false;
				compCurrentGeneralInfoLayout.horizontalSpacing = 5;
				compCurrentGeneralInfoLayout.verticalSpacing = 5;
				compCurrentGeneralInfo.setSize(new org.eclipse.swt.graphics.Point(584, 435));
				compCurrentGeneralInfo.setLayout(compCurrentGeneralInfoLayout);
				{
					lblCurrentCode = new CLabel(compCurrentGeneralInfo, SWT.NONE);
					GridData lblCurrentCodeLData = new GridData();
					lblCurrentCodeLData.widthHint = 93;
					lblCurrentCodeLData.heightHint = 20;
					lblCurrentCode.setLayoutData(lblCurrentCodeLData);
					lblCurrentCode.setText(Messages.getString("CurUICurrentCardAdd.1")); //$NON-NLS-1$
				}
				{
					txtCurrentCode = new CurrentCodePicker(compCurrentGeneralInfo, SWT.NONE);
					GridData txtCurrentCodeLData = new GridData();
					txtCurrentCodeLData.widthHint = 150;
					txtCurrentCodeLData.heightHint = 17;
					txtCurrentCodeLData.horizontalSpan = 3;
					txtCurrentCode.setLayoutData(txtCurrentCodeLData);
				}
				{
					lblCurrentName = new CLabel(compCurrentGeneralInfo, SWT.NONE);
					GridData lblCurrentNameLData = new GridData();
					lblCurrentNameLData.widthHint = 73;
					lblCurrentNameLData.heightHint = 19;
					lblCurrentName.setLayoutData(lblCurrentNameLData);
					lblCurrentName.setText(Messages.getString("CurUICurrentCardAdd.2")); //$NON-NLS-1$
					lblCurrentName.setSize(new org.eclipse.swt.graphics.Point(73, 19));
				}
				{
					txtCurrentName = new Text(compCurrentGeneralInfo, SWT.NONE);
					GridData txtCurrentNameLData = new GridData();
					txtCurrentNameLData.heightHint = 17;
					txtCurrentNameLData.horizontalSpan = 3;
					txtCurrentNameLData.widthHint = 395;
					txtCurrentName.setLayoutData(txtCurrentNameLData);
					txtCurrentName.setTextLimit(250);
				}
				{
					lblCardDefinition = new CLabel(compCurrentGeneralInfo, SWT.NONE);
					GridData lblCardDefinitionLData = new GridData();
					lblCardDefinitionLData.verticalAlignment = GridData.BEGINNING;
					lblCardDefinition.setLayoutData(lblCardDefinitionLData);
					lblCardDefinition.setText(Messages.getString("CurUICurrentCardAdd.3")); //$NON-NLS-1$
				}
				{
					txtCardDefinition = new Text(compCurrentGeneralInfo, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
					GridData txtCardDefinitionLData = new GridData();
					txtCardDefinitionLData.widthHint = 381;
					txtCardDefinitionLData.heightHint = 50;
					txtCardDefinitionLData.horizontalSpan = 3;
					txtCardDefinition.addVerifyListener(new VerifyListener()
					{
						public void verifyText(VerifyEvent evt)
						{
							if (evt.keyCode == SWT.TAB)
							{
								txtCardAddress.setFocus();
								evt.doit = false;
							}
						}
					});
					txtCardDefinition.addTraverseListener(new TraverseListener()
					{
						public void keyTraversed(TraverseEvent evt)
						{
							if (evt.keyCode == SWT.TAB)
							{
								txtCardAddress.setFocus();
								evt.doit = false;
							}
						}
					});
					txtCardDefinition.setLayoutData(txtCardDefinitionLData);
					txtCardDefinition.setTextLimit(250);
				}
				{
					lblCardAddress = new CLabel(compCurrentGeneralInfo, SWT.NONE);
					GridData lblCardAddressLData = new GridData();
					lblCardAddressLData.verticalAlignment = GridData.BEGINNING;
					lblCardAddress.setLayoutData(lblCardAddressLData);
					lblCardAddress.setText(Messages.getString("CurUICurrentCardAdd.4")); //$NON-NLS-1$
				}
				{
					txtCardAddress = new Text(compCurrentGeneralInfo, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
					GridData txtCardAddressLData = new GridData();
					txtCardAddressLData.widthHint = 381;
					txtCardAddressLData.heightHint = 50;
					txtCardAddressLData.horizontalSpan = 3;
					txtCardAddress.addVerifyListener(new VerifyListener()
					{
						public void verifyText(VerifyEvent evt)
						{
							if (evt.keyCode == SWT.TAB)
							{
								composite1.setFocus();
								evt.doit = false;
							}
						}
					});
					txtCardAddress.addTraverseListener(new TraverseListener()
					{
						public void keyTraversed(TraverseEvent evt)
						{
							if (evt.keyCode == SWT.TAB)
							{
								numtxtCountryCode.setFocus();
								evt.doit = false;
							}
						}
					});
					txtCardAddress.setLayoutData(txtCardAddressLData);
					txtCardAddress.setTextLimit(250);
				}
				{
					lblTelephone1 = new Label(compCurrentGeneralInfo, SWT.NONE);
					GridData lblTelephone1LData = new GridData();
					lblTelephone1LData.widthHint = 82;
					lblTelephone1LData.heightHint = 16;
					lblTelephone1.setLayoutData(lblTelephone1LData);
					lblTelephone1.setText(Messages.getString("CurUICurrentCardAdd.5")); //$NON-NLS-1$
					lblTelephone1.setSize(new org.eclipse.swt.graphics.Point(82, 16));
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
					composite1.setSize(new org.eclipse.swt.graphics.Point(222, 18));
					composite1.setLayout(composite1Layout);
					{
						numtxtCountryCode = new NumericText(composite1, SWT.NONE);
						GridData numtxtCountryCodeLData = new GridData();
						numtxtCountryCodeLData.widthHint = 25;
						numtxtCountryCodeLData.heightHint = 17;
						numtxtCountryCode.setLayoutData(numtxtCountryCodeLData);
						numtxtCountryCode.setTextLimit(5);
					}
					{
						numTxtCityCode = new NumericText(composite1, SWT.NONE);
						GridData numTxtCityCodeLData = new GridData();
						numTxtCityCodeLData.widthHint = 24;
						numTxtCityCodeLData.heightHint = 17;
						numTxtCityCode.setLayoutData(numTxtCityCodeLData);
						numTxtCityCode.setTextLimit(3);
					}
					{
						numTxtNumber = new NumericText(composite1, SWT.NONE);
						GridData numTxtNumberLData = new GridData();
						numTxtNumberLData.widthHint = 79;
						numTxtNumberLData.heightHint =17;
						numTxtNumber.setLayoutData(numTxtNumberLData);
						numTxtNumber.setTextLimit(9);
					}
					composite1.layout();
				}
				{
					lblTelephone2 = new Label(compCurrentGeneralInfo, SWT.NONE);
					GridData lblTelephone2LData = new GridData();
					lblTelephone2LData.widthHint = 82;
					lblTelephone2LData.heightHint = 16;
					lblTelephone2.setLayoutData(lblTelephone2LData);
					lblTelephone2.setText(Messages.getString("CurUICurrentCardAdd.6")); //$NON-NLS-1$
					lblTelephone2.setSize(new org.eclipse.swt.graphics.Point(82, 16));
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
					composite2.setSize(new org.eclipse.swt.graphics.Point(222, 18));
					composite2.setLayout(composite2Layout);
					{
						numTxtCountryCode2 = new NumericText(composite2, SWT.NONE);
						GridData numTxtCountryCode2LData = new GridData();
						numTxtCountryCode2LData.widthHint = 25;
						numTxtCountryCode2LData.heightHint = 17;
						numTxtCountryCode2.setLayoutData(numTxtCountryCode2LData);
						numTxtCountryCode2.setTextLimit(5);
					}
					{
						numTxtCityCode2 = new NumericText(composite2, SWT.NONE);
						GridData numTxtCityCode2LData = new GridData();
						numTxtCityCode2LData.widthHint = 24;
						numTxtCityCode2LData.heightHint = 18;
						numTxtCityCode2.setLayoutData(numTxtCityCode2LData);
						numTxtCityCode2.setTextLimit(3);
					}
					{
						numTxtNumber2 = new NumericText(composite2, SWT.NONE);
						GridData numTxtNumber2LData = new GridData();
						numTxtNumber2LData.widthHint = 79;
						numTxtNumber2LData.heightHint = 17;
						numTxtNumber2.setLayoutData(numTxtNumber2LData);
						numTxtNumber2.setTextLimit(9);
					}
					composite2.layout();
				}
				{
					lblTaxDepartment = new CLabel(compCurrentGeneralInfo, SWT.NONE);
					GridData lblTaxDepartmentLData = new GridData();
					lblTaxDepartmentLData.widthHint = 84;
					lblTaxDepartmentLData.heightHint = 19;
					lblTaxDepartment.setLayoutData(lblTaxDepartmentLData);
					lblTaxDepartment.setText(Messages.getString("CurUICurrentCardAdd.7")); //$NON-NLS-1$
					lblTaxDepartment.setSize(new org.eclipse.swt.graphics.Point(84, 19));
				}
				{
					txtTaxDepartmant = new Text(compCurrentGeneralInfo, SWT.NONE);
					GridData txtTaxDepartmantLData = new GridData();
					txtTaxDepartmantLData.widthHint = 150;
					txtTaxDepartmantLData.heightHint = 17;
					txtTaxDepartmantLData.horizontalSpan = 3;
					txtTaxDepartmant.setLayoutData(txtTaxDepartmantLData);
					txtTaxDepartmant.setTextLimit(50);
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
					txtTaxNumberLData.widthHint = 150;
					txtTaxNumberLData.heightHint = 17;
					txtTaxNumberLData.horizontalSpan = 3;
					txtTaxNumber.setLayoutData(txtTaxNumberLData);
					txtTaxNumber.setTextLimit(50);
				}
				{
					lblRiskLimit = new CLabel(compCurrentGeneralInfo, SWT.NONE);
					GridData lblRiskLimitLData = new GridData();
					lblRiskLimit.setLayoutData(lblRiskLimitLData);
					lblRiskLimit.setText(Messages.getString("CurUICurrentCardAdd.9")); //$NON-NLS-1$
				}
				{
					decTxtRiskLimit = new CurrencyText(compCurrentGeneralInfo, SWT.NONE);
					GridData decTxtRiskLimitLData = new GridData();
					decTxtRiskLimitLData.widthHint = 150;
					decTxtRiskLimitLData.heightHint = 17;
					decTxtRiskLimitLData.horizontalSpan = 3;
					decTxtRiskLimit.setLayoutData(decTxtRiskLimitLData);
				}
				{
					lblCreditLimit = new CLabel(compCurrentGeneralInfo, SWT.NONE);
					GridData lblCreditLimitLData = new GridData();
					lblCreditLimitLData.widthHint = 90;
					lblCreditLimitLData.heightHint = 20;
					lblCreditLimit.setLayoutData(lblCreditLimitLData);
					lblCreditLimit.setText(Messages.getString("CurUICurrentCardAdd.10")); //$NON-NLS-1$
				}
				{
					decTxtCreditLimit = new CurrencyText(compCurrentGeneralInfo, SWT.NONE);
					GridData decTxtCreditLimitLData = new GridData();
					decTxtCreditLimitLData.widthHint = 150;
					decTxtCreditLimitLData.heightHint = 17;
					decTxtCreditLimitLData.horizontalSpan = 3;
					decTxtCreditLimit.setLayoutData(decTxtCreditLimitLData);
				}
				{
					lblDiscountAMount = new CLabel(compCurrentGeneralInfo, SWT.NONE);
					GridData lblDiscountAMountLData = new GridData();
					lblDiscountAMountLData.widthHint = 102;
					lblDiscountAMountLData.heightHint = 16;
					lblDiscountAMount.setLayoutData(lblDiscountAMountLData);
					lblDiscountAMount.setText(Messages.getString("CurUICurrentCardAdd.12")); //$NON-NLS-1$
				}
				{
					decTxtDiscountAmount = new CurrencyText(compCurrentGeneralInfo, SWT.NONE);
					GridData decTxtDiscountAmountLData = new GridData();
					decTxtDiscountAmountLData.widthHint = 150;
					decTxtDiscountAmountLData.heightHint = 17;
					decTxtDiscountAmountLData.horizontalSpan = 3;
					decTxtDiscountAmount.setLayoutData(decTxtDiscountAmountLData);
				}
				{
					lblDiscountRate = new CLabel(compCurrentGeneralInfo, SWT.NONE);
					GridData lblDiscountRateLData = new GridData();
					lblDiscountRate.setLayoutData(lblDiscountRateLData);
					lblDiscountRate.setText(Messages.getString("CurUICurrentCardAdd.11")); //$NON-NLS-1$
				}
				{
					numTextDiscountRate = new CurrencyTextAdvanced(compCurrentGeneralInfo, SWT.NONE);
					GridData numTextDiscountRateLData = new GridData();
					numTextDiscountRateLData.widthHint = 65;
					numTextDiscountRateLData.heightHint = 17;
					numTextDiscountRateLData.horizontalSpan = 3;
					numTextDiscountRate.setLayoutData(numTextDiscountRateLData);
					numTextDiscountRate.setTextLimit(2);
				}
				{
					lblDueDays = new CLabel(compCurrentGeneralInfo, SWT.NONE);
					lblDueDays.setText(Messages.getString("CurUICurrentCardAdd.32")); //$NON-NLS-1$
					GridData lblDueDaysLData = new GridData();
					lblDueDaysLData.widthHint = 56;
					lblDueDaysLData.heightHint = 19;
					lblDueDays.setLayoutData(lblDueDaysLData);
				}
				{
					numDueDays = new NumericText(compCurrentGeneralInfo, SWT.NONE);
					GridData numDueDaysLData = new GridData();
					numDueDaysLData.widthHint = 65;
					numDueDaysLData.heightHint = 17;
					numDueDaysLData.horizontalSpan = 3;
					numDueDays.setLayoutData(numDueDaysLData);
				}
				compCurrentGeneralInfo.layout();
			}
			tabItemCurrentGroups.setControl(compCurrentGroups);
			compCurrentGroups.setSize(new org.eclipse.swt.graphics.Point(584, 435));
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
			compRegisterGroup.setSize(new org.eclipse.swt.graphics.Point(188, 182));
			compRegisterGroup.layout();
			GridData btnUpdateGroupsLData = new GridData();
			btnUpdateGroupsLData.widthHint = 142;
			btnUpdateGroupsLData.heightHint = 36;
			btnUpdateGroupsLData.horizontalIndent = 10;
			btnUpdateGroups.setLayoutData(btnUpdateGroupsLData);
			btnUpdateGroups.setText(Messages.getString("CurUICurrentCardAdd.24")); //$NON-NLS-1$
			btnUpdateGroups.addMouseListener(new MouseAdapter()
			{
				public void mouseUp(MouseEvent evt)
				{
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

	public void postInitGUI()
	{
		fillGroups();
	}

	public void fillGroups()
	{
		try
		{
			HashMap groupMap = new HashMap();
			List list = (List)EngTXCommon.doSingleTX(CurBLCurrentCardAdd.class.getName(),"getCurrentGroups",null);
			TurqCurrentGroup curGroup;
			for (int i = 0; i < list.size(); i++)
			{
				curGroup = (TurqCurrentGroup) list.get(i);
				groupMap.put(curGroup.getGroupsName(), curGroup);
			}
			compRegisterGroup.fillTableAllGroups(groupMap);
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex); //$NON-NLS-1$
			ex.printStackTrace();
		}
	}

	public Map getContactInfo()
	{
		try
		{
			Map contactMap = new HashMap();
			contactMap.put("ContactName", txtContactName.getText().trim()); //$NON-NLS-1$
			contactMap.put("ContactAddress", txtContactAddress.getText().trim()); //$NON-NLS-1$
			contactMap.put("ContactPhone", txtContactPhone.getText().trim()); //$NON-NLS-1$
			contactMap.put("ContactPhone2", txtContactPhone2.getText().trim()); //$NON-NLS-1$
			contactMap.put("ContactFaxNumber", txtFaxNumber.getText().trim()); //$NON-NLS-1$
			contactMap.put("ContactEmail", txtContactEmail.getText().trim()); //$NON-NLS-1$
			contactMap.put("ContactWebSite", txtContactWebSite.getText().trim()); //$NON-NLS-1$
			return contactMap;
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex); //$NON-NLS-1$
			ex.printStackTrace();
			return null;
		}
	}

	public List getGroupList()
	{
		try
		{
			List groupList = new ArrayList();
			TableItem items[] = compRegisterGroup.getTableAllGroups().getItems();
			for (int i = 0; i < items.length; i++)
			{
				if (items[i].getChecked())
				{
					groupList.add(items[i].getData());
				}
			}
			return groupList;
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex); //$NON-NLS-1$
			ex.printStackTrace();
			return null;
		}
	}

	public List getPhoneList()
	{
		try
		{
			List phoneList = new ArrayList();
			phoneList.add(new int[]{numtxtCountryCode.getIntValue(), numTxtCityCode.getIntValue(), numTxtNumber.getIntValue()});
			phoneList.add(new int[]{numTxtCountryCode2.getIntValue(), numTxtCityCode2.getIntValue(), numTxtNumber2.getIntValue()});
			return phoneList;
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex); //$NON-NLS-1$
			ex.printStackTrace();
			return null;
		}
	}

	public void clearFields()
	{
		CurUICurrentCardAdd curCard = new CurUICurrentCardAdd(this.getParent(), this.getStyle());
		CTabFolder tabfld = (CTabFolder) this.getParent();
		tabfld.getSelection().setControl(curCard);
		this.dispose();
	}

	public boolean verifyFields(boolean save) throws Exception
	{
		try
		{
			MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
			if (txtCurrentCode.getText().trim().equals("")) { //$NON-NLS-1$
				msg.setMessage(Messages.getString("CurUICurrentCardAdd.28")); //$NON-NLS-1$
				msg.open();
				txtCurrentCode.setFocus();
				return false;
			}
			else if (save && EngBLCurrentCards.getCards(txtCurrentCode.getText().trim()) != null)
			{
				msg.setMessage(Messages.getString("CurUICurrentCardAdd.44")); //$NON-NLS-1$
				msg.open();
				txtCurrentCode.setFocus();
				return false;
			}
			else if (txtCurrentName.getText().trim().equals("")) { //$NON-NLS-1$
				msg.setMessage(Messages.getString("CurUICurrentCardAdd.30")); //$NON-NLS-1$
				msg.open();
				txtCurrentName.setFocus();
				return false;
			}
			if (accPickerCustomer.getTurqAccountingAccount() == null)
			{
				boolean ans = EngUICommon.okToDelete(getShell(),Messages.getString("CurUICurrentCardAdd.45"));  //$NON-NLS-1$
				if (ans)
				{
					TurqAccountingAccount account = new AccUIAddAccountDialog(getShell(), SWT.NONE).open();
					accPickerCustomer.setData(account);
				}
			}
			/*
			 * WARNING !.. do not add another check after this else if add upper instead
			 */
			return true;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public Map getAccountingFields()
	{
		Map map = new Hashtable();
		map.put(EngBLCommon.CURRENT_ACC_TYPE_GENERAL, accPickerCustomer);
		map.put(EngBLCommon.CURRENT_ACC_TYPE_CHEQUES_GIVEN, accountPickerChequesGiven);
		map.put(EngBLCommon.CURRENT_ACC_TYPE_CHEQUES_TAKEN, accountPickerChequesTaken);
		return map;
	}

	public Map createAccountingMap()
	{
		Map fieldMap = getAccountingFields();
		Map map = new Hashtable();
		Iterator it = fieldMap.keySet().iterator();
		while (it.hasNext())
		{
			Integer type = (Integer) it.next();
			AccountPicker picker = (AccountPicker) fieldMap.get(type);
			if (picker.getTurqAccountingAccount() != null)
			{
				map.put(type, picker.getTurqAccountingAccount());
			}
		}
		return map;
	}

	public void save()
	{
		try
		{
			if (verifyFields(true))
			{
				HashMap argMap = new HashMap();
				argMap.put(CurKeys.CUR_CURRENT_CODE,txtCurrentCode.getText().trim());
				argMap.put(CurKeys.CUR_CURRENT_NAME,txtCurrentName.getText().trim());
				argMap.put(EngKeys.DEFINITION,txtCardDefinition.getText().trim());
				argMap.put(CurKeys.CUR_ADDRESS,txtCardAddress.getText().trim());
				argMap.put(CurKeys.CUR_DISCOUNT_RATE,numTextDiscountRate.getBigDecimalValue());
				argMap.put(CurKeys.CUR_DISCOUNT_PAYMENT,decTxtDiscountAmount.getBigDecimalValue());
				argMap.put(CurKeys.CUR_CREDIT_LIMIT, decTxtCreditLimit.getBigDecimalValue());
				argMap.put(CurKeys.CUR_RISK_LIMIT,decTxtRiskLimit.getBigDecimalValue());
				argMap.put(CurKeys.CUR_TAX_DEPARTMENT,txtTaxDepartmant.getText().trim());
				argMap.put(CurKeys.CUR_TAX_NUMBER,txtTaxNumber.getText().trim());
				argMap.put(CurKeys.CUR_DAYS_TO_VALUE,new Integer(numDueDays.getIntValue()));
				argMap.put(CurKeys.CUR_ACCOUNTING_LIST,createAccountingMap());
				argMap.put(CurKeys.CUR_PHONE_LIST,getPhoneList());
				argMap.put(CurKeys.CUR_CONTACT_INFO,getContactInfo());
				argMap.put(CurKeys.CUR_GROUP_LIST,getGroupList());
				EngTXCommon.doTransactionTX(CurBLCurrentCardAdd.class.getName(),"saveCurrentCard",argMap);	
				
				EngBLCurrentCards.RefreshContentAsistantMap();
				MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
				msg.setMessage(Messages.getString("CurUICurrentCardAdd.14")); //$NON-NLS-1$
				msg.open();
				clearFields();
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex); //$NON-NLS-1$
			ex.printStackTrace();
			
		}
	}

	public void search()
	{
	}

	public void delete()
	{
	}

	public void newForm()
	{
		clearFields();
	}

	/** Auto-generated event handler method */
	protected void btnUpdateGroupsMouseUp(MouseEvent evt)
	{
		new CurUIGroupAddDialog(this.getShell(), SWT.NULL).open();
		fillGroups();
	}

	/**
	 * @return Returns the compRegisterGroup.
	 */
	public RegisterGroupComposite getCompRegisterGroup()
	{
		return compRegisterGroup;
	}
}