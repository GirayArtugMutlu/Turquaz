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
 * @author onsel
 * @version $Id$
 */
import org.apache.log4j.Logger;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TextCellEditor;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.CurrencyText;
import com.turquaz.inventory.ui.comp.InventoryPicker;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLInventoryCards;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqInventoryAccountingAccount;
import com.turquaz.engine.dal.TurqInventoryAccountingType;
import com.turquaz.engine.dal.TurqInventoryUnit;
import com.turquaz.engine.ui.component.SecureComposite;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import com.turquaz.engine.ui.component.NumericText;
import com.turquaz.engine.ui.editors.AccountingCellEditor;
import com.turquaz.engine.ui.editors.CurrencyCellEditor;
import com.turquaz.engine.ui.viewers.TableRowList;
import com.turquaz.engine.ui.viewers.TableSpreadsheetCursor;
import com.turquaz.engine.ui.viewers.TurquazCellModifier;
import com.turquaz.engine.ui.viewers.TurquazContentProvider;
import com.turquaz.engine.ui.viewers.TurquazLabelProvider;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import com.turquaz.inventory.Messages;
import com.turquaz.inventory.bl.InvBLCardAdd;
import com.turquaz.inventory.bl.InvBLCardSearch;
import com.turquaz.inventory.ui.comp.IPriceListViewer;
import com.turquaz.inventory.ui.comp.InvUIPrice;
import com.turquaz.inventory.ui.comp.InvUIPriceCellModifier;
import com.turquaz.inventory.ui.comp.InvUIPriceLabelProvider;
import com.turquaz.inventory.ui.comp.InvUIPriceList;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Label;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.events.TraverseEvent;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class InvUICardAdd extends Composite implements SecureComposite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	private TableViewer tableInvPricesViewer;
	private TableColumn tableColumnCurrency;
	private TableColumn tableColumnAmount;
	private TableColumn tableColumnPriceType;
	private Button btnUpdateUnits;
	private Button btnInvCardGroupsPre;
	private Button btnInvCardPricesNext;
	private Button btnInvCardPricesPre;
	private Button btnInvCardUnitsNxt;

	/**
	 * @return Returns the tableInvAccounts.
	 */
	public Table getTableInvAccounts()
	{
		return tableInvAccounts;
	}
	private Button btnInvCardUnitsPre;
	public HashMap mapEditorsTableInvCardAddRegisteredUnits;

	/**
	 * @return Returns the rowList.
	 */
	public TableRowList getRowList()
	{
		return rowList;
	}
	private TableColumn tableColumnUnitCoefficient;
	private CTabItem tabItemAccounting;
	private TableColumn tableColumnInvAccount;
	private TableColumn tableColumnAccType;
	private Table tableInvAccounts;
	private Composite compAccounting;
	private Button radioSpecialVatAmount;
	private Button radioSpecialVatPercent;
	private TableColumn tableColumn2;
	private Table tableInvCardAddRegisteredUnits;
	private Button btnRemoveRegisteredInvUnit;
	private Button btnRegisterInvUnit;
	private Composite compInvCardAddUnitsButtons;
	private TableColumn tableColumn1;
	private Table tableInvCardAddAllUnits;
	private Composite compInvCardAddSecondaryUnits;
	private InvBLCardAdd invBLCardAdd = new InvBLCardAdd();
	private TableColumn tableColumnGroups;
	private Composite compInvCardAddGroupsButtonComp;
	private InvUIInventoryGroups compInvCardGroups;
	private Composite compInvCardAddGroups;
	private Table tableInvCardAddPrices;
	private Button btnInvCardAddPricesRemovePrice;
	private Button btnInvCardAddPricesAddPrice;
	private Composite compInvCardPricesAdd;
	private Composite compInvCardPricesTable;
	private Composite compInvCardPrices;
	private CLabel lblInvCardSecondaryUnits;
	private CTabItem tabInvCardGroups;
	private CTabItem tabInvCardPrices;
	private Button btnInvCardNext;
	private Button btnInvCardDetPre;
	private CCombo comboInvCardUnits;
	private CLabel lblInvCardUnit;
	private Composite compInvCardUnit;
	private NumericText txtInvCardDiscount;
	private CLabel lblInvCardDiscount;
	private NumericText txtInvCardVat;
	private CLabel lblInvCardVat;
	private NumericText txtnumInvCardMax;
	private CLabel lblInvCardMax;
	private NumericText txtnumInvCardMin;
	private Label lblInvCardMin;
	private Composite compInvCardDetails;
	private CTabItem tabInvCardDetails;
	private Button btnInvCardGeneral;
	private CTabItem tabInvCardUnits;
	private Text txtInvCardDefinition;
	private CLabel lblInvCardDefinition;
	private InventoryPicker txtInvCardCode;
	private CLabel lblInvCardCode;
	private CurrencyText decTextSpecialVatAmount;
	private NumericText numTextSpecailVATPercent;
	private Label label5;
	private Label label4;
	private Label label3;
	private Label label2;
	private Label label1;
	private Text txtInvCardName;
	private CLabel lblInvCardName;
	private Composite compInvCardGeneral;
	private CTabItem tabInvCardGeneral;
	private CTabFolder tabfldInvCardAdd;
	private List currencyList;
	public InvUIPriceList priceList;
	private final String INV_ACC_TYPE = "Muhasebe Tipi";
	private final String ACC_CODE = "Hesap Kodu";
	private String[] columnNames = new String[]{INV_ACC_TYPE, ACC_CODE};
	int last_row_index = 0;
	TableSpreadsheetCursor cursor;
	private List columnList = new ArrayList();
	public TableRowList rowList = new TableRowList();
	public TableViewer tableViewer;

	public InvUICardAdd(Composite parent, int style)
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
			tabfldInvCardAdd = new CTabFolder(this, SWT.NULL);
			tabInvCardGeneral = new CTabItem(tabfldInvCardAdd, SWT.NONE);
			tabInvCardDetails = new CTabItem(tabfldInvCardAdd, SWT.NULL);
			tabInvCardUnits = new CTabItem(tabfldInvCardAdd, SWT.NULL);
			tabInvCardPrices = new CTabItem(tabfldInvCardAdd, SWT.NULL);
			compInvCardPrices = new Composite(tabfldInvCardAdd, SWT.NULL);
			compInvCardPricesTable = new Composite(compInvCardPrices, SWT.NULL);
			compInvCardPricesAdd = new Composite(compInvCardPricesTable, SWT.NULL);
			btnInvCardAddPricesAddPrice = new Button(compInvCardPricesAdd, SWT.PUSH | SWT.CENTER);
			btnInvCardAddPricesRemovePrice = new Button(compInvCardPricesAdd, SWT.PUSH | SWT.CENTER);
			tableInvCardAddPrices = new Table(compInvCardPricesTable, SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.BORDER);
			tableColumnPriceType = new TableColumn(tableInvCardAddPrices, SWT.NULL);
			tableColumnAmount = new TableColumn(tableInvCardAddPrices, SWT.NULL);
			tableColumnCurrency = new TableColumn(tableInvCardAddPrices, SWT.NULL);
			btnInvCardPricesPre = new Button(compInvCardPrices, SWT.PUSH | SWT.CENTER);
			btnInvCardPricesNext = new Button(compInvCardPrices, SWT.PUSH | SWT.CENTER);
			tabInvCardGroups = new CTabItem(tabfldInvCardAdd, SWT.NULL);
			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 2;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 10;
			thisLayout.verticalSpacing = 0;
			this.setSize(641, 467);
			GridData tabfldInvCardAddLData = new GridData();
			tabfldInvCardAddLData.verticalAlignment = GridData.FILL;
			tabfldInvCardAddLData.horizontalAlignment = GridData.FILL;
			tabfldInvCardAddLData.grabExcessHorizontalSpace = true;
			tabfldInvCardAddLData.grabExcessVerticalSpace = true;
			tabfldInvCardAdd.setLayoutData(tabfldInvCardAddLData);
			tabInvCardDetails.setText(Messages.getString("InvUICardAdd.6")); //$NON-NLS-1$
			{
				compInvCardDetails = new Composite(tabfldInvCardAdd, SWT.NONE);
				tabInvCardDetails.setControl(compInvCardDetails);
				GridLayout compInvCardDetailsLayout = new GridLayout(4, true);
				compInvCardDetailsLayout.marginWidth = 5;
				compInvCardDetailsLayout.marginHeight = 5;
				compInvCardDetailsLayout.numColumns = 4;
				compInvCardDetailsLayout.makeColumnsEqualWidth = false;
				compInvCardDetailsLayout.horizontalSpacing = 5;
				compInvCardDetailsLayout.verticalSpacing = 5;
				compInvCardDetails.setSize(new org.eclipse.swt.graphics.Point(641, 404));
				compInvCardDetails.setLayout(compInvCardDetailsLayout);
				{
					lblInvCardMin = new Label(compInvCardDetails, SWT.RIGHT);
					GridData lblInvCardMinLData = new GridData();
					lblInvCardMinLData.widthHint = 138;
					lblInvCardMinLData.heightHint = 16;
					lblInvCardMin.setLayoutData(lblInvCardMinLData);
					lblInvCardMin.setText(Messages.getString("InvUICardAdd.7")); //$NON-NLS-1$
				}
				{
					txtnumInvCardMin = new NumericText(compInvCardDetails, SWT.NONE);
					GridData txtnumInvCardMinLData = new GridData();
					txtnumInvCardMinLData.widthHint = 135;
					txtnumInvCardMinLData.heightHint = 17;
					txtnumInvCardMin.setLayoutData(txtnumInvCardMinLData);
				}
				{
					lblInvCardMax = new CLabel(compInvCardDetails, SWT.RIGHT);
					GridData lblInvCardMaxLData = new GridData();
					lblInvCardMaxLData.horizontalAlignment = GridData.END;
					lblInvCardMaxLData.widthHint = 114;
					lblInvCardMaxLData.heightHint = 20;
					lblInvCardMax.setLayoutData(lblInvCardMaxLData);
					lblInvCardMax.setText(Messages.getString("InvUICardAdd.8")); //$NON-NLS-1$
				}
				{
					txtnumInvCardMax = new NumericText(compInvCardDetails, SWT.NONE);
					GridData txtnumInvCardMaxLData = new GridData();
					txtnumInvCardMaxLData.widthHint = 135;
					txtnumInvCardMaxLData.heightHint = 17;
					txtnumInvCardMax.setLayoutData(txtnumInvCardMaxLData);
				}
				{
					lblInvCardVat = new CLabel(compInvCardDetails, SWT.RIGHT);
					GridData lblInvCardVatLData = new GridData();
					lblInvCardVatLData.widthHint = 140;
					lblInvCardVatLData.heightHint = 14;
					lblInvCardVat.setLayoutData(lblInvCardVatLData);
					lblInvCardVat.setText(Messages.getString("InvUICardAdd.11")); //$NON-NLS-1$
				}
				{
					txtInvCardVat = new NumericText(compInvCardDetails, SWT.NONE);
					GridData txtInvCardVatLData = new GridData();
					txtInvCardVatLData.widthHint = 135;
					txtInvCardVatLData.heightHint = 17;
					txtInvCardVat.setLayoutData(txtInvCardVatLData);
				}
				{
					lblInvCardDiscount = new CLabel(compInvCardDetails, SWT.RIGHT);
					GridData lblInvCardDiscountLData = new GridData();
					lblInvCardDiscountLData.horizontalAlignment = GridData.END;
					lblInvCardDiscountLData.widthHint = 61;
					lblInvCardDiscountLData.heightHint = 19;
					lblInvCardDiscount.setLayoutData(lblInvCardDiscountLData);
					lblInvCardDiscount.setText(Messages.getString("InvUICardAdd.1")); //$NON-NLS-1$
				}
				{
					txtInvCardDiscount = new NumericText(compInvCardDetails, SWT.NONE);
					GridData txtInvCardDiscountLData = new GridData();
					txtInvCardDiscountLData.widthHint = 135;
					txtInvCardDiscountLData.heightHint = 17;
					txtInvCardDiscount.setLayoutData(txtInvCardDiscountLData);
				}
				{
					radioSpecialVatPercent = new Button(compInvCardDetails, SWT.RADIO | SWT.LEFT);
					GridData radioOTVpercLData1 = new GridData();
					radioSpecialVatPercent.setText(Messages.getString("InvUICardAdd.22")); //$NON-NLS-1$
					radioOTVpercLData1.horizontalAlignment = GridData.END;
					radioSpecialVatPercent.setLayoutData(radioOTVpercLData1);
					GridData radioOTVpercLData = new GridData();
					radioOTVpercLData.horizontalSpan = 0;
				}
				{
					numTextSpecailVATPercent = new NumericText(compInvCardDetails, SWT.NONE);
					GridData numTextSpecailVATPercentLData = new GridData();
					numTextSpecailVATPercent.setSize(55, 17);
					numTextSpecailVATPercentLData.widthHint = 55;
					numTextSpecailVATPercentLData.heightHint = 17;
					numTextSpecailVATPercent.setLayoutData(numTextSpecailVATPercentLData);
				}
				{
					radioSpecialVatAmount = new Button(compInvCardDetails, SWT.RADIO | SWT.LEFT);
					radioSpecialVatAmount.setText(Messages.getString("InvUICardAdd.26")); //$NON-NLS-1$
					GridData radioSpecialVatAmountLData = new GridData();
					radioSpecialVatAmount.setSelection(true);
					radioSpecialVatAmountLData.horizontalAlignment = GridData.END;
					radioSpecialVatAmount.setLayoutData(radioSpecialVatAmountLData);
				}
				{
					decTextSpecialVatAmount = new CurrencyText(compInvCardDetails, SWT.NONE, 4);
					GridData decTextSpecialVatAmountLData = new GridData();
					decTextSpecialVatAmount.addTraverseListener(new TraverseListener()
					{
						public void keyTraversed(TraverseEvent evt)
						{
							if (evt.keyCode == SWT.TAB)
							{
								tabfldInvCardAdd.setSelection(tabInvCardUnits);
								evt.doit = false;
							}
						}
					});
					decTextSpecialVatAmountLData.widthHint = 135;
					decTextSpecialVatAmountLData.heightHint = 17;
					decTextSpecialVatAmount.setLayoutData(decTextSpecialVatAmountLData);
				}
				{
					label3 = new Label(compInvCardDetails, SWT.SEPARATOR | SWT.HORIZONTAL);
					label3.setText("label1"); //$NON-NLS-1$
					GridData label3LData = new GridData();
					label3LData.horizontalAlignment = GridData.FILL;
					label3LData.horizontalSpan = 4;
					label3.setLayoutData(label3LData);
				}
				{
					btnInvCardDetPre = new Button(compInvCardDetails, SWT.PUSH | SWT.CENTER);
					GridData btnInvCardDetPreLData = new GridData();
					btnInvCardDetPreLData.widthHint = 85;
					btnInvCardDetPreLData.heightHint = 31;
					btnInvCardDetPreLData.horizontalSpan = 3;
					btnInvCardDetPreLData.verticalSpan = 10;
					btnInvCardDetPre.setLayoutData(btnInvCardDetPreLData);
					btnInvCardDetPre.setText(Messages.getString("InvUICardAdd.13")); //$NON-NLS-1$
					btnInvCardDetPre.addMouseListener(new MouseAdapter()
					{
						public void mouseUp(MouseEvent evt)
						{
							btnInvCardDetPreMouseUp(evt);
						}
					});
				}
				{
					btnInvCardNext = new Button(compInvCardDetails, SWT.PUSH | SWT.CENTER);
					GridData btnInvCardNextLData = new GridData();
					btnInvCardNextLData.horizontalAlignment = GridData.END;
					btnInvCardNextLData.widthHint = 83;
					btnInvCardNextLData.heightHint = 28;
					btnInvCardNextLData.verticalSpan = 10;
					btnInvCardNextLData.grabExcessHorizontalSpace = true;
					btnInvCardNext.setLayoutData(btnInvCardNextLData);
					btnInvCardNext.setText(Messages.getString("InvUICardAdd.5")); //$NON-NLS-1$
					btnInvCardNext.addMouseListener(new MouseAdapter()
					{
						public void mouseUp(MouseEvent evt)
						{
							btnInvCardNextMouseUp(evt);
						}
					});
				}
				compInvCardDetails.layout();
			}
			tabInvCardUnits.setText(Messages.getString("InvUICardAdd.15")); //$NON-NLS-1$
			{
				compInvCardUnit = new Composite(tabfldInvCardAdd, SWT.NONE);
				tabInvCardUnits.setControl(compInvCardUnit);
				GridLayout compInvCardUnitLayout = new GridLayout();
				compInvCardUnitLayout.numColumns = 4;
				compInvCardUnit.setSize(new org.eclipse.swt.graphics.Point(641, 404));
				compInvCardUnit.setLayout(compInvCardUnitLayout);
				{
					lblInvCardUnit = new CLabel(compInvCardUnit, SWT.NONE);
					GridData lblInvCardUnitLData = new GridData();
					lblInvCardUnitLData.widthHint = 97;
					lblInvCardUnitLData.heightHint = 19;
					lblInvCardUnit.setLayoutData(lblInvCardUnitLData);
					lblInvCardUnit.setText(Messages.getString("InvUICardAdd.16")); //$NON-NLS-1$
				}
				{
					comboInvCardUnits = new CCombo(compInvCardUnit, SWT.FLAT | SWT.READ_ONLY);
					GridData comboInvCardUnitsLData = new GridData();
					comboInvCardUnitsLData.widthHint = 104;
					comboInvCardUnitsLData.heightHint = 18;
					comboInvCardUnits.setLayoutData(comboInvCardUnitsLData);
					comboInvCardUnits.setText(Messages.getString("InvUICardAdd.17")); //$NON-NLS-1$
					comboInvCardUnits.setBackground(SWTResourceManager.getColor(255, 255, 255));
				}
				{
					btnUpdateUnits = new Button(compInvCardUnit, SWT.PUSH | SWT.CENTER);
					GridData btnUpdateUnitsLData = new GridData();
					btnUpdateUnits.addMouseListener(new MouseAdapter()
					{
						public void mouseUp(MouseEvent evt)
						{
							btnUpdateUnitsMouseUp(evt);
						}
					});
					btnUpdateUnitsLData.horizontalSpan = 2;
					btnUpdateUnitsLData.widthHint = 128;
					btnUpdateUnitsLData.heightHint = 29;
					btnUpdateUnits.setLayoutData(btnUpdateUnitsLData);
					btnUpdateUnits.setText(Messages.getString("InvUICardAdd.18")); //$NON-NLS-1$
				}
				{
					lblInvCardSecondaryUnits = new CLabel(compInvCardUnit, SWT.NONE);
					GridData lblInvCardSecondaryUnitsLData = new GridData();
					lblInvCardSecondaryUnitsLData.verticalAlignment = GridData.BEGINNING;
					lblInvCardSecondaryUnitsLData.widthHint = 85;
					lblInvCardSecondaryUnitsLData.heightHint = 19;
					lblInvCardSecondaryUnits.setLayoutData(lblInvCardSecondaryUnitsLData);
					lblInvCardSecondaryUnits.setText(Messages.getString("InvUICardAdd.19")); //$NON-NLS-1$
				}
				{
					compInvCardAddSecondaryUnits = new Composite(compInvCardUnit, SWT.NONE);
					GridLayout compInvCardAddSecondaryUnitsLayout = new GridLayout(3, true);
					compInvCardAddSecondaryUnitsLayout.marginWidth = 0;
					compInvCardAddSecondaryUnitsLayout.marginHeight = 5;
					compInvCardAddSecondaryUnitsLayout.numColumns = 3;
					compInvCardAddSecondaryUnitsLayout.makeColumnsEqualWidth = false;
					compInvCardAddSecondaryUnitsLayout.horizontalSpacing = 5;
					compInvCardAddSecondaryUnitsLayout.verticalSpacing = 5;
					GridData compInvCardAddSecondaryUnitsLData = new GridData();
					compInvCardAddSecondaryUnitsLData.widthHint = 414;
					compInvCardAddSecondaryUnitsLData.heightHint = 126;
					compInvCardAddSecondaryUnitsLData.horizontalSpan = 2;
					compInvCardAddSecondaryUnits.setLayoutData(compInvCardAddSecondaryUnitsLData);
					compInvCardAddSecondaryUnits.setLayout(compInvCardAddSecondaryUnitsLayout);
					{
						tableInvCardAddAllUnits = new Table(compInvCardAddSecondaryUnits, SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER);
						GridData tableInvCardAddAllUnitsLData = new GridData();
						tableInvCardAddAllUnits.addMouseListener(new MouseAdapter()
						{
							public void mouseDoubleClick(MouseEvent evt)
							{
								btnRegisterInvUnitMouseUp();
							}
						});
						tableInvCardAddAllUnitsLData.widthHint = 128;
						tableInvCardAddAllUnitsLData.heightHint = 99;
						tableInvCardAddAllUnits.setLayoutData(tableInvCardAddAllUnitsLData);
						tableInvCardAddAllUnits.setHeaderVisible(true);
						tableInvCardAddAllUnits.setLinesVisible(true);
						{
							tableColumn1 = new TableColumn(tableInvCardAddAllUnits, SWT.NONE);
							tableColumn1.setText(Messages.getString("InvUICardAdd.15")); //$NON-NLS-1$
							tableColumn1.setWidth(112);
						}
					}
					{
						compInvCardAddUnitsButtons = new Composite(compInvCardAddSecondaryUnits, SWT.NONE);
						GridLayout compInvCardAddUnitsButtonsLayout = new GridLayout(1, true);
						compInvCardAddUnitsButtonsLayout.marginWidth = 5;
						compInvCardAddUnitsButtonsLayout.marginHeight = 5;
						compInvCardAddUnitsButtonsLayout.numColumns = 1;
						compInvCardAddUnitsButtonsLayout.makeColumnsEqualWidth = true;
						compInvCardAddUnitsButtonsLayout.horizontalSpacing = 5;
						compInvCardAddUnitsButtonsLayout.verticalSpacing = 5;
						GridData compInvCardAddUnitsButtonsLData = new GridData();
						compInvCardAddUnitsButtonsLData.widthHint = 63;
						compInvCardAddUnitsButtonsLData.heightHint = 73;
						compInvCardAddUnitsButtons.setLayoutData(compInvCardAddUnitsButtonsLData);
						compInvCardAddUnitsButtons.setLayout(compInvCardAddUnitsButtonsLayout);
						{
							btnRegisterInvUnit = new Button(compInvCardAddUnitsButtons, SWT.PUSH | SWT.CENTER);
							GridData btnRegisterInvUnitLData = new GridData();
							btnRegisterInvUnit.addMouseListener(new MouseAdapter()
							{
								public void mouseUp(MouseEvent evt)
								{
									btnRegisterInvUnitMouseUp();
								}
							});
							btnRegisterInvUnitLData.horizontalAlignment = GridData.CENTER;
							btnRegisterInvUnitLData.widthHint = 41;
							btnRegisterInvUnitLData.heightHint = 30;
							btnRegisterInvUnit.setLayoutData(btnRegisterInvUnitLData);
							btnRegisterInvUnit.setText(">>"); //$NON-NLS-1$
						}
						{
							btnRemoveRegisteredInvUnit = new Button(compInvCardAddUnitsButtons, SWT.PUSH | SWT.CENTER);
							GridData btnRemoveRegisteredInvUnitLData = new GridData();
							btnRemoveRegisteredInvUnit.addMouseListener(new MouseAdapter()
							{
								public void mouseUp(MouseEvent evt)
								{
									btnRemoveRegisteredInvUnitMouseUp();
								}
							});
							btnRemoveRegisteredInvUnitLData.horizontalAlignment = GridData.CENTER;
							btnRemoveRegisteredInvUnitLData.widthHint = 40;
							btnRemoveRegisteredInvUnitLData.heightHint = 30;
							btnRemoveRegisteredInvUnit.setLayoutData(btnRemoveRegisteredInvUnitLData);
							btnRemoveRegisteredInvUnit.setText("<<"); //$NON-NLS-1$
						}
						compInvCardAddUnitsButtons.layout();
					}
					{
						tableInvCardAddRegisteredUnits = new Table(compInvCardAddSecondaryUnits, SWT.V_SCROLL | SWT.BORDER);
						GridData tableInvCardAddRegisteredUnitsLData = new GridData();
						tableInvCardAddRegisteredUnits.addMouseListener(new MouseAdapter()
						{
							public void mouseDoubleClick(MouseEvent evt)
							{
								btnRemoveRegisteredInvUnitMouseUp();
							}
						});
						tableInvCardAddRegisteredUnitsLData.widthHint = 180;
						tableInvCardAddRegisteredUnitsLData.heightHint = 98;
						tableInvCardAddRegisteredUnits.setLayoutData(tableInvCardAddRegisteredUnitsLData);
						tableInvCardAddRegisteredUnits.setHeaderVisible(true);
						tableInvCardAddRegisteredUnits.setLinesVisible(true);
						{
							tableColumn2 = new TableColumn(tableInvCardAddRegisteredUnits, SWT.NONE);
							tableColumn2.setText(Messages.getString("InvUICardAdd.23")); //$NON-NLS-1$
							tableColumn2.setWidth(110);
						}
						{
							tableColumnUnitCoefficient = new TableColumn(tableInvCardAddRegisteredUnits, SWT.NONE);
							tableColumnUnitCoefficient.setText(Messages.getString("InvUICardAdd.24")); //$NON-NLS-1$
							tableColumnUnitCoefficient.setWidth(60);
						}
					}
					compInvCardAddSecondaryUnits.layout();
				}
				{
					label1 = new Label(compInvCardUnit, SWT.SEPARATOR | SWT.HORIZONTAL);
					label1.setText("label1"); //$NON-NLS-1$
					GridData label1LData = new GridData();
					label1LData.horizontalSpan = 4;
					label1LData.horizontalAlignment = GridData.FILL;
					label1.setLayoutData(label1LData);
				}
				{
					btnInvCardUnitsPre = new Button(compInvCardUnit, SWT.PUSH | SWT.CENTER);
					GridData btnInvCardUnitsPreLData = new GridData();
					btnInvCardUnitsPreLData.widthHint = 90;
					btnInvCardUnitsPreLData.heightHint = 32;
					btnInvCardUnitsPreLData.horizontalSpan = 3;
					btnInvCardUnitsPreLData.verticalSpan = 10;
					btnInvCardUnitsPre.setLayoutData(btnInvCardUnitsPreLData);
					btnInvCardUnitsPre.setText(Messages.getString("InvUICardAdd.25")); //$NON-NLS-1$
					btnInvCardUnitsPre.addMouseListener(new MouseAdapter()
					{
						public void mouseUp(MouseEvent evt)
						{
							btnInvCardUnitsPreMouseUp(evt);
						}
					});
				}
				{
					btnInvCardUnitsNxt = new Button(compInvCardUnit, SWT.PUSH | SWT.CENTER);
					GridData btnInvCardUnitsNxtLData = new GridData();
					btnInvCardUnitsNxtLData.horizontalAlignment = GridData.END;
					btnInvCardUnitsNxtLData.widthHint = 85;
					btnInvCardUnitsNxtLData.heightHint = 29;
					btnInvCardUnitsNxtLData.verticalSpan = 10;
					btnInvCardUnitsNxt.setLayoutData(btnInvCardUnitsNxtLData);
					btnInvCardUnitsNxt.setText(Messages.getString("InvUICardAdd.5")); //$NON-NLS-1$
					btnInvCardUnitsNxt.addMouseListener(new MouseAdapter()
					{
						public void mouseUp(MouseEvent evt)
						{
							btnInvCardUnitsNxtMouseUp(evt);
						}
					});
				}
				compInvCardUnit.layout();
			}
			tabInvCardPrices.setControl(compInvCardPrices);
			tabInvCardPrices.setText(Messages.getString("InvUICardAdd.27")); //$NON-NLS-1$
			compInvCardPrices.setSize(new org.eclipse.swt.graphics.Point(641, 404));
			GridData compInvCardPricesTableLData = new GridData();
			compInvCardPricesTableLData.widthHint = 486;
			compInvCardPricesTableLData.heightHint = 198;
			compInvCardPricesTableLData.horizontalSpan = 2;
			compInvCardPricesTable.setLayoutData(compInvCardPricesTableLData);
			GridData compInvCardPricesAddLData = new GridData();
			compInvCardPricesAddLData.verticalAlignment = GridData.CENTER;
			compInvCardPricesAddLData.horizontalAlignment = GridData.BEGINNING;
			compInvCardPricesAddLData.widthHint = 45;
			compInvCardPricesAddLData.heightHint = 67;
			compInvCardPricesAddLData.horizontalIndent = 0;
			compInvCardPricesAddLData.horizontalSpan = 1;
			compInvCardPricesAddLData.verticalSpan = 1;
			compInvCardPricesAddLData.grabExcessHorizontalSpace = false;
			compInvCardPricesAddLData.grabExcessVerticalSpace = false;
			compInvCardPricesAdd.setLayoutData(compInvCardPricesAddLData);
			compInvCardPricesAdd.setSize(new org.eclipse.swt.graphics.Point(45, 67));
			GridData btnInvCardAddPricesAddPriceLData = new GridData();
			btnInvCardAddPricesAddPrice.setImage(SWTResourceManager.getImage("icons/plus.gif")); //$NON-NLS-1$
			btnInvCardAddPricesAddPriceLData.verticalAlignment = GridData.CENTER;
			btnInvCardAddPricesAddPriceLData.horizontalAlignment = GridData.BEGINNING;
			btnInvCardAddPricesAddPriceLData.widthHint = 30;
			btnInvCardAddPricesAddPriceLData.heightHint = 24;
			btnInvCardAddPricesAddPriceLData.horizontalIndent = 0;
			btnInvCardAddPricesAddPriceLData.horizontalSpan = 1;
			btnInvCardAddPricesAddPriceLData.verticalSpan = 1;
			btnInvCardAddPricesAddPriceLData.grabExcessHorizontalSpace = false;
			btnInvCardAddPricesAddPriceLData.grabExcessVerticalSpace = false;
			btnInvCardAddPricesAddPrice.setLayoutData(btnInvCardAddPricesAddPriceLData);
			btnInvCardAddPricesAddPrice.setSize(new org.eclipse.swt.graphics.Point(30, 24));
			btnInvCardAddPricesAddPrice.addMouseListener(new MouseAdapter()
			{
				public void mouseDown(MouseEvent evt)
				{
					btnInvCardAddPricesAddPriceMouseDown(evt);
				}
			});
			GridData btnInvCardAddPricesRemovePriceLData = new GridData();
			btnInvCardAddPricesRemovePrice.setImage(SWTResourceManager.getImage("icons/minus.gif")); //$NON-NLS-1$
			btnInvCardAddPricesRemovePriceLData.verticalAlignment = GridData.CENTER;
			btnInvCardAddPricesRemovePriceLData.horizontalAlignment = GridData.BEGINNING;
			btnInvCardAddPricesRemovePriceLData.widthHint = 30;
			btnInvCardAddPricesRemovePriceLData.heightHint = 24;
			btnInvCardAddPricesRemovePriceLData.horizontalIndent = 0;
			btnInvCardAddPricesRemovePriceLData.horizontalSpan = 1;
			btnInvCardAddPricesRemovePriceLData.verticalSpan = 1;
			btnInvCardAddPricesRemovePriceLData.grabExcessHorizontalSpace = false;
			btnInvCardAddPricesRemovePriceLData.grabExcessVerticalSpace = false;
			btnInvCardAddPricesRemovePrice.setLayoutData(btnInvCardAddPricesRemovePriceLData);
			btnInvCardAddPricesRemovePrice.setSize(new org.eclipse.swt.graphics.Point(30, 24));
			btnInvCardAddPricesRemovePrice.addMouseListener(new MouseAdapter()
			{
				public void mouseDown(MouseEvent evt)
				{
					btnInvCardAddPricesRemovePriceMouseDown(evt);
				}
			});
			GridLayout compInvCardPricesAddLayout = new GridLayout(1, true);
			compInvCardPricesAdd.setLayout(compInvCardPricesAddLayout);
			compInvCardPricesAddLayout.marginWidth = 5;
			compInvCardPricesAddLayout.marginHeight = 5;
			compInvCardPricesAddLayout.numColumns = 1;
			compInvCardPricesAddLayout.makeColumnsEqualWidth = true;
			compInvCardPricesAddLayout.horizontalSpacing = 5;
			compInvCardPricesAddLayout.verticalSpacing = 5;
			compInvCardPricesAdd.layout();
			GridData tableInvCardAddPricesLData = new GridData();
			tableInvCardAddPricesLData.verticalAlignment = GridData.CENTER;
			tableInvCardAddPricesLData.horizontalAlignment = GridData.BEGINNING;
			tableInvCardAddPricesLData.widthHint = 421;
			tableInvCardAddPricesLData.heightHint = 178;
			tableInvCardAddPricesLData.horizontalIndent = 0;
			tableInvCardAddPricesLData.horizontalSpan = 1;
			tableInvCardAddPricesLData.verticalSpan = 1;
			tableInvCardAddPricesLData.grabExcessHorizontalSpace = false;
			tableInvCardAddPricesLData.grabExcessVerticalSpace = false;
			tableInvCardAddPrices.setLayoutData(tableInvCardAddPricesLData);
			tableInvCardAddPrices.setHeaderVisible(true);
			tableInvCardAddPrices.setLinesVisible(true);
			tableInvCardAddPrices.setSize(new org.eclipse.swt.graphics.Point(421, 178));
			tableColumnPriceType.setText(Messages.getString("InvUICardAdd.28")); //$NON-NLS-1$
			tableColumnPriceType.setWidth(120);
			tableColumnAmount.setText(Messages.getString("InvUICardAdd.29")); //$NON-NLS-1$
			tableColumnAmount.setWidth(150);
			tableColumnCurrency.setText(Messages.getString("InvUICardAdd.30")); //$NON-NLS-1$
			tableColumnCurrency.setWidth(162);
			GridLayout compInvCardPricesTableLayout = new GridLayout(2, true);
			compInvCardPricesTable.setLayout(compInvCardPricesTableLayout);
			{
				label4 = new Label(compInvCardPrices, SWT.SEPARATOR | SWT.HORIZONTAL);
				label4.setText("label1"); //$NON-NLS-1$
				GridData label4LData = new GridData();
				label4LData.horizontalAlignment = GridData.FILL;
				label4LData.horizontalSpan = 4;
				label4.setLayoutData(label4LData);
			}
			compInvCardPricesTableLayout.marginWidth = 5;
			compInvCardPricesTableLayout.marginHeight = 5;
			compInvCardPricesTableLayout.numColumns = 2;
			compInvCardPricesTableLayout.makeColumnsEqualWidth = false;
			compInvCardPricesTableLayout.horizontalSpacing = 5;
			compInvCardPricesTableLayout.verticalSpacing = 5;
			compInvCardPricesTable.layout();
			GridData btnInvCardPricesPreLData = new GridData();
			btnInvCardPricesPreLData.verticalAlignment = GridData.END;
			btnInvCardPricesPreLData.widthHint = 86;
			btnInvCardPricesPreLData.heightHint = 30;
			btnInvCardPricesPre.setLayoutData(btnInvCardPricesPreLData);
			btnInvCardPricesPre.setText(Messages.getString("InvUICardAdd.13")); //$NON-NLS-1$
			btnInvCardPricesPre.addMouseListener(new MouseAdapter()
			{
				public void mouseUp(MouseEvent evt)
				{
					btnInvCardPricesPreMouseUp(evt);
				}
			});
			GridData btnInvCardPricesNextLData = new GridData();
			btnInvCardPricesNextLData.verticalAlignment = GridData.END;
			btnInvCardPricesNextLData.horizontalAlignment = GridData.END;
			btnInvCardPricesNextLData.widthHint = 81;
			btnInvCardPricesNextLData.heightHint = 30;
			btnInvCardPricesNext.setLayoutData(btnInvCardPricesNextLData);
			btnInvCardPricesNext.setText(Messages.getString("InvUICardAdd.5")); //$NON-NLS-1$
			btnInvCardPricesNext.addMouseListener(new MouseAdapter()
			{
				public void mouseUp(MouseEvent evt)
				{
					btnInvCardPricesNextMouseUp(evt);
				}
			});
			GridLayout compInvCardPricesLayout = new GridLayout(2, true);
			compInvCardPrices.setLayout(compInvCardPricesLayout);
			compInvCardPricesLayout.marginWidth = 5;
			compInvCardPricesLayout.marginHeight = 5;
			compInvCardPricesLayout.numColumns = 2;
			compInvCardPricesLayout.makeColumnsEqualWidth = true;
			compInvCardPricesLayout.horizontalSpacing = 5;
			compInvCardPricesLayout.verticalSpacing = 5;
			compInvCardPrices.layout();
			tabInvCardGroups.setText(Messages.getString("InvUICardAdd.33")); //$NON-NLS-1$
			//START >> tabItemAccounting
			tabItemAccounting = new CTabItem(tabfldInvCardAdd, SWT.NONE);
			tabItemAccounting.setText("Muhasebe Kodlar\u0131");
			//START >> compAccounting
			compAccounting = new Composite(tabfldInvCardAdd, SWT.NONE);
			GridLayout compAccountingLayout = new GridLayout();
			compAccountingLayout.makeColumnsEqualWidth = true;
			compAccounting.setLayout(compAccountingLayout);
			tabItemAccounting.setControl(compAccounting);
			//START >> tableInvAccounts
			tableInvAccounts = new Table(compAccounting, SWT.HIDE_SELECTION);
			GridData tableInvAccountsLData = new GridData();
			tableInvAccounts.setLinesVisible(true);
			tableInvAccounts.setHeaderVisible(true);
			tableInvAccountsLData.grabExcessHorizontalSpace = true;
			tableInvAccountsLData.grabExcessVerticalSpace = true;
			tableInvAccountsLData.horizontalAlignment = GridData.FILL;
			tableInvAccountsLData.verticalAlignment = GridData.FILL;
			tableInvAccounts.setLayoutData(tableInvAccountsLData);
			//START >> tableColumnAccType
			tableColumnAccType = new TableColumn(tableInvAccounts, SWT.NONE);
			tableColumnAccType.setText("Muhasebe Tipi");
			tableColumnAccType.setWidth(200);
			//END << tableColumnAccType
			//START >> tableColumnInvAccount
			tableColumnInvAccount = new TableColumn(tableInvAccounts, SWT.NONE);
			tableColumnInvAccount.setText("Hesap Kodu");
			tableColumnInvAccount.setWidth(100);
			//END << tableColumnInvAccount
			//END << tableInvAccounts
			//END << compAccounting
			tabfldInvCardAdd.setSelection(0);
			//END << tabItemAccounting
			{
				compInvCardAddGroups = new Composite(tabfldInvCardAdd, SWT.NONE);
				tabInvCardGroups.setControl(compInvCardAddGroups);
				GridLayout compInvCardAddGroupsLayout = new GridLayout(1, true);
				compInvCardAddGroupsLayout.marginWidth = 5;
				compInvCardAddGroupsLayout.marginHeight = 5;
				compInvCardAddGroupsLayout.numColumns = 1;
				compInvCardAddGroupsLayout.makeColumnsEqualWidth = true;
				compInvCardAddGroupsLayout.horizontalSpacing = 5;
				compInvCardAddGroupsLayout.verticalSpacing = 5;
				compInvCardAddGroups.setSize(new org.eclipse.swt.graphics.Point(641, 404));
				compInvCardAddGroups.setLayout(compInvCardAddGroupsLayout);
				{
					compInvCardGroups = new InvUIInventoryGroups(compInvCardAddGroups, SWT.NONE);
					GridLayout compInvCardAddGroupsSelectionLayout = new GridLayout(3, true);
					compInvCardAddGroupsSelectionLayout.marginWidth = 5;
					compInvCardAddGroupsSelectionLayout.marginHeight = 5;
					compInvCardAddGroupsSelectionLayout.numColumns = 3;
					compInvCardAddGroupsSelectionLayout.makeColumnsEqualWidth = false;
					compInvCardAddGroupsSelectionLayout.horizontalSpacing = 5;
					compInvCardAddGroupsSelectionLayout.verticalSpacing = 5;
					GridData compInvCardAddGroupsSelectionLData = new GridData();
					compInvCardAddGroupsSelectionLData.widthHint = 405;
					compInvCardAddGroupsSelectionLData.heightHint = 273;
					compInvCardGroups.setLayoutData(compInvCardAddGroupsSelectionLData);
				}
				{
					btnInvCardGroupsPre = new Button(compInvCardAddGroups, SWT.PUSH | SWT.CENTER);
					GridData btnInvCardGroupsPreLData = new GridData();
					btnInvCardGroupsPreLData.widthHint = 97;
					btnInvCardGroupsPreLData.heightHint = 31;
					btnInvCardGroupsPre.setLayoutData(btnInvCardGroupsPreLData);
					btnInvCardGroupsPre.setText(Messages.getString("InvUICardAdd.13")); //$NON-NLS-1$
					btnInvCardGroupsPre.addMouseListener(new MouseAdapter()
					{
						public void mouseUp(MouseEvent evt)
						{
							btnInvCardGroupsPreMouseUp(evt);
						}
					});
				}
				{
					label5 = new Label(compInvCardAddGroups, SWT.SEPARATOR | SWT.HORIZONTAL);
					label5.setText("label1"); //$NON-NLS-1$
					GridData label5LData = new GridData();
					label5LData.horizontalAlignment = GridData.FILL;
					label5LData.horizontalSpan = 4;
					label5.setLayoutData(label5LData);
				}
				compInvCardAddGroups.layout();
			}
			{
				tabInvCardGeneral.setText(Messages.getString("InvUICardAdd.0")); //$NON-NLS-1$
				{
					compInvCardGeneral = new Composite(tabfldInvCardAdd, SWT.NONE);
					tabInvCardGeneral.setControl(compInvCardGeneral);
					GridLayout compInvCardGeneralLayout = new GridLayout(4, true);
					compInvCardGeneralLayout.marginWidth = 5;
					compInvCardGeneralLayout.marginHeight = 5;
					compInvCardGeneralLayout.numColumns = 4;
					compInvCardGeneralLayout.makeColumnsEqualWidth = false;
					compInvCardGeneralLayout.horizontalSpacing = 5;
					compInvCardGeneralLayout.verticalSpacing = 5;
					compInvCardGeneral.setLayout(compInvCardGeneralLayout);
					{
						lblInvCardCode = new CLabel(compInvCardGeneral, SWT.NONE);
						GridData lblInvCardCodeLData = new GridData();
						lblInvCardCodeLData.widthHint = 100;
						lblInvCardCodeLData.heightHint = 23;
						lblInvCardCode.setLayoutData(lblInvCardCodeLData);
						lblInvCardCode.setText(Messages.getString("InvUICardAdd.3")); //$NON-NLS-1$
						lblInvCardCode.setSize(new org.eclipse.swt.graphics.Point(100, 23));
					}
					{
						txtInvCardCode = new InventoryPicker(compInvCardGeneral, SWT.NONE);
						GridData txtInvCardCodeLData = new GridData();
						txtInvCardCodeLData.widthHint = 207;
						txtInvCardCodeLData.heightHint = 17;
						txtInvCardCodeLData.horizontalSpan = 3;
						txtInvCardCode.setLayoutData(txtInvCardCodeLData);
					}
					{
						lblInvCardName = new CLabel(compInvCardGeneral, SWT.NONE);
						GridData lblInvCardNameLData = new GridData();
						lblInvCardNameLData.widthHint = 96;
						lblInvCardNameLData.heightHint = 20;
						lblInvCardName.setLayoutData(lblInvCardNameLData);
						lblInvCardName.setText(Messages.getString("InvUICardAdd.47")); //$NON-NLS-1$
						lblInvCardName.setSize(new org.eclipse.swt.graphics.Point(96, 20));
					}
					{
						txtInvCardName = new Text(compInvCardGeneral, SWT.NONE);
						GridData txtInvCardNameLData = new GridData();
						txtInvCardNameLData.widthHint = 200;
						txtInvCardNameLData.heightHint = 17;
						txtInvCardNameLData.horizontalSpan = 3;
						txtInvCardName.setLayoutData(txtInvCardNameLData);
						txtInvCardName.setTextLimit(50);
					}
					{
						lblInvCardDefinition = new CLabel(compInvCardGeneral, SWT.NONE);
						GridData lblInvCardDefinitionLData = new GridData();
						lblInvCardDefinitionLData.widthHint = 76;
						lblInvCardDefinitionLData.heightHint = 17;
						lblInvCardDefinition.setLayoutData(lblInvCardDefinitionLData);
						lblInvCardDefinition.setText(Messages.getString("InvUICardAdd.4")); //$NON-NLS-1$
						lblInvCardDefinition.setSize(new org.eclipse.swt.graphics.Point(76, 17));
					}
					{
						txtInvCardDefinition = new Text(compInvCardGeneral, SWT.MULTI | SWT.WRAP | SWT.H_SCROLL | SWT.V_SCROLL);
						GridData txtInvCardDefinitionLData = new GridData();
						txtInvCardDefinition.addTraverseListener(new TraverseListener()
						{
							public void keyTraversed(TraverseEvent evt)
							{
								if (evt.keyCode == SWT.TAB)
								{
									evt.doit = false;
									tabfldInvCardAdd.setSelection(tabInvCardDetails);
								}
							}
						});
						txtInvCardDefinitionLData.widthHint = 183;
						txtInvCardDefinitionLData.heightHint = 46;
						txtInvCardDefinitionLData.horizontalSpan = 3;
						txtInvCardDefinition.setLayoutData(txtInvCardDefinitionLData);
						txtInvCardDefinition.setTextLimit(250);
					}
					{
						label2 = new Label(compInvCardGeneral, SWT.SEPARATOR | SWT.HORIZONTAL);
						label2.setText("label1"); //$NON-NLS-1$
						GridData label2LData = new GridData();
						label2LData.horizontalAlignment = GridData.FILL;
						label2LData.horizontalSpan = 4;
						label2.setLayoutData(label2LData);
					}
					{
						btnInvCardGeneral = new Button(compInvCardGeneral, SWT.PUSH | SWT.CENTER);
						GridData btnInvCardGeneralLData = new GridData();
						btnInvCardGeneralLData.verticalAlignment = GridData.END;
						btnInvCardGeneralLData.horizontalAlignment = GridData.END;
						btnInvCardGeneralLData.widthHint = 84;
						btnInvCardGeneralLData.heightHint = 32;
						btnInvCardGeneralLData.horizontalSpan = 4;
						btnInvCardGeneralLData.verticalSpan = 2;
						btnInvCardGeneralLData.grabExcessHorizontalSpace = true;
						btnInvCardGeneral.setLayoutData(btnInvCardGeneralLData);
						btnInvCardGeneral.setText(Messages.getString("InvUICardAdd.5")); //$NON-NLS-1$
						btnInvCardGeneral.addMouseListener(new MouseAdapter()
						{
							public void mouseUp(MouseEvent evt)
							{
								btnInvCardGeneralMouseUp(evt);
							}
						});
					}
					compInvCardGeneral.layout();
				}
			}
			this.layout();
			addDisposeListener(new DisposeListener()
			{
				public void widgetDisposed(DisposeEvent e)
				{
				}
			});
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
		try
		{
			mapEditorsTableInvCardAddRegisteredUnits = new HashMap();
			currencyList = (List)EngTXCommon.doSingleTX(EngBLCommon.class.getName(),"getCurrencies",null);
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}

	/** Add your post-init code in here */
	public void postInitGUI()
	{
		try
		{
			fillInvCardUnits();
			initTableInvPrices();
			fillDefaultValues();
			createTableViewer();
			fillInventoryAccounts();
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}

	public void fillInventoryAccounts()
	{
		try
		{
			List allTypes = (List)EngTXCommon.doSingleTX(InvBLCardSearch.class.getName(),"getAllInvAccTypes",null);
			for (int k = 0; k < allTypes.size(); k++)
			{
				TurqInventoryAccountingType type = (TurqInventoryAccountingType) allTypes.get(k);
				InvUIInvAccountingAccTableRow row = new InvUIInvAccountingAccTableRow(rowList, type);
				rowList.addTask(row);
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}

	public void createTableViewer()
	{
		columnList.add(INV_ACC_TYPE);
		columnList.add(ACC_CODE);
		tableViewer = new TableViewer(tableInvAccounts);
		tableViewer.setUseHashlookup(true);
		tableViewer.setColumnProperties(columnNames);
		//     Create the cell editors
		CellEditor[] editors = new CellEditor[columnNames.length];
		editors[0] = new TextCellEditor(tableInvAccounts);
		editors[1] = new AccountingCellEditor(tableInvAccounts);
		// Assign the cell editors to the viewer
		tableViewer.setCellEditors(editors);
		TurquazContentProvider contentProvider = new TurquazContentProvider(tableViewer, rowList);
		tableViewer.setCellModifier(new TurquazCellModifier(columnList, contentProvider));
		tableViewer.setContentProvider(contentProvider);
		tableViewer.setLabelProvider(new TurquazLabelProvider());
		tableViewer.setInput(rowList);
		cursor = new TableSpreadsheetCursor(tableInvAccounts, SWT.NONE, tableViewer, rowList, false);
		cursor.setEnabled(true);
		cursor.addSelectionListener(new SelectionAdapter()
		{
			public void widgetDefaultSelected(SelectionEvent evt)
			{
				tableViewer.editElement(cursor.getRow().getData(), cursor.getColumn());
			}

			public void widgetSelected(SelectionEvent evt)
			{
				int current_row_index = ((InvUIInvAccountingAccTableRow) cursor.getRow().getData()).getRowIndex();
				if (current_row_index != last_row_index)
				{
					last_row_index = current_row_index;
				}
				cursor.redraw();
			}
		});
		//   To refresh the cell combo cell editor
		for (int i = 0; i < editors.length; i++)
		{
			editors[i].addListener(this.cursor);
		}
	}

	public void fillDefaultValues()
	{
		/*
		 * txtInvCardInAcc.setText("153"); //Alis Muhasebe Kodu //$NON-NLS-1$ txtInvCardOutAcc.setText("600"); //Satis Muhasebe Kodu
		 * //$NON-NLS-1$ accountPickerSpecVAT.setText("193"); // Alis OTV Kodu //$NON-NLS-1$ accountPickerSpecVatSell.setText("360");
		 * //Satis OTV Kodu //$NON-NLS-1$ accountPickerVAT.setText("191"); //Alis K.D.V //$NON-NLS-1$ accountPickerVATSell.setText("391");
		 * //Satis K.D.V //$NON-NLS-1$
		 */
	}

	public void initTableInvPrices()
	{
		tableInvPricesViewer = new TableViewer(tableInvCardAddPrices);
		tableInvPricesViewer.setUseHashlookup(true);
		tableInvPricesViewer.setColumnProperties(new String[]{
				Messages.getString("InvUICardAdd.14"), Messages.getString("InvUICardAdd.20"), Messages.getString("InvUICardAdd.21")}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		// Create the cell editors
		CellEditor[] editors = new CellEditor[3];
		editors[0] = new ComboBoxCellEditor(tableInvCardAddPrices, new String[]{EngBLCommon.COMMON_BUY_STRING,
				EngBLCommon.COMMON_SELL_STRING}); //$NON-NLS-1$ //$NON-NLS-2$
		TurqCurrency currency;
		String[] currencies = new String[currencyList.size()];
		for (int i = 0; i < currencyList.size(); i++)
		{
			currency = (TurqCurrency) currencyList.get(i);
			currencies[i] = currency.getCurrenciesAbbreviation();
		}
		//Initialize Price List
		priceList = new InvUIPriceList(currencies);
		editors[2] = new ComboBoxCellEditor(tableInvCardAddPrices, currencies, SWT.READ_ONLY);
		editors[1] = new CurrencyCellEditor(tableInvCardAddPrices, 4);
		// Assign the cell editors to the viewer
		tableInvPricesViewer.setCellEditors(editors);
		// Set the cell modifier for the viewer
		tableInvPricesViewer.setCellModifier(new InvUIPriceCellModifier(priceList));
		// Set the default sorter for the viewer
		//tableViewer.setSorter(new
		// ExampleTaskSorter(ExampleTaskSorter.DESCRIPTION));
		tableInvPricesViewer.setLabelProvider(new InvUIPriceLabelProvider());
		tableInvPricesViewer.setContentProvider(new InvUIContentProvider());
		tableInvPricesViewer.setInput(priceList);
	}
	/**
	 * InnerClass that acts as a proxy for the InvUIPriceList providing content for the Table. It implements the IPriceListViewer interface
	 * since it must register changeListeners with the InvUIPriceList
	 */
	class InvUIContentProvider implements IStructuredContentProvider, IPriceListViewer
	{
		public void inputChanged(Viewer v, Object oldInput, Object newInput)
		{
			if (newInput != null)
				((InvUIPriceList) newInput).addChangeListener(this);
			if (oldInput != null)
				((InvUIPriceList) oldInput).removeChangeListener(this);
		}

		public void dispose()
		{
			priceList.removeChangeListener(this);
		}

		// Return the tasks as an array of Objects
		public Object[] getElements(Object parent)
		{
			return priceList.getPrices().toArray();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see ITaskListViewer#addTask(ExampleTask)
		 */
		public void addPrice(InvUIPrice price)
		{
			tableInvPricesViewer.add(price);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see ITaskListViewer#removeTask(ExampleTask)
		 */
		public void removePrice(InvUIPrice price)
		{
			tableInvPricesViewer.remove(price);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see ITaskListViewer#updateTask(ExampleTask)
		 */
		public void updatePrice(InvUIPrice price)
		{
			tableInvPricesViewer.update(price, null);
		}
	}

	public void fillInvCardUnits()
	{
		tableInvCardAddAllUnits.removeAll();
		tableInvCardAddRegisteredUnits.removeAll();
		comboInvCardUnits.removeAll();
		//Remove All editors
		Iterator it = mapEditorsTableInvCardAddRegisteredUnits.keySet().iterator();
		while (it.hasNext())
		{
			TableEditor editor = (TableEditor) mapEditorsTableInvCardAddRegisteredUnits.get(it.next());
			editor.getEditor().dispose();
			editor.dispose();
		}
		tableInvCardAddRegisteredUnits.getColumn(1).setWidth(50);
		try
		{
			List unitLst = (List)EngTXCommon.doSingleTX(InvBLCardAdd.class.getName(),"getInventoryUnits",null);
			TableItem item = null;
			TurqInventoryUnit trqInvUnit;
			for (int i = 0; i < unitLst.size(); i++)
			{
				trqInvUnit = (TurqInventoryUnit) unitLst.get(i);
				comboInvCardUnits.add(trqInvUnit.getUnitsName());
				comboInvCardUnits.setData(trqInvUnit.getUnitsName(), trqInvUnit);
				item = new TableItem(tableInvCardAddAllUnits, SWT.NULL);
				item.setText(trqInvUnit.getUnitsName());
				item.setData(trqInvUnit);
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}

	public void clearFields()
	{
		InvUICardAdd cardAdd = new InvUICardAdd(this.getParent(), this.getStyle());
		CTabFolder tabfld = (CTabFolder) this.getParent();
		tabfld.getSelection().setControl(cardAdd);
		this.dispose();
	}

	public boolean verifyFields(boolean save)
	{
		try
		{
			MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
			//If inventory name is not given
			if (txtInvCardCode.getText().trim().equals("")) { //$NON-NLS-1$
				msg.setMessage(Messages.getString("InvUICardAdd.43")); //$NON-NLS-1$
				msg.open();
				tabfldInvCardAdd.setSelection(tabInvCardGeneral);
				txtInvCardCode.setFocus();
				return false;
			}
			else if (save && EngBLInventoryCards.getInvCard(txtInvCardCode.getText().trim()) != null)
			{
				msg.setMessage(Messages.getString("InvUICardAdd.2")); //$NON-NLS-1$
				msg.open();
				tabfldInvCardAdd.setSelection(tabInvCardGeneral);
				txtInvCardCode.setFocus();
				return false;
			}
			else if (txtInvCardName.getText().trim().equals("")) { //$NON-NLS-1$
				msg.setMessage(Messages.getString("InvUICardAdd.41")); //$NON-NLS-1$
				msg.open();
				tabfldInvCardAdd.setSelection(tabInvCardGeneral);
				txtInvCardName.setFocus();
				return false;
			}
			else if (comboInvCardUnits.getData(comboInvCardUnits.getText()) == null)
			{
				msg.setMessage(Messages.getString("InvUICardAdd.46")); //$NON-NLS-1$
				msg.open();
				tabfldInvCardAdd.setSelection(tabInvCardUnits);
				comboInvCardUnits.setFocus();
				return false;
			}
			return true;
		}
		catch (Exception ex)
		{
			MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
			return false;
		}
	}

	public void save()
	{
		if (verifyFields(true))
		{
			try
			{
				// Save inventory card
				InvBLCardAdd.saveInventoryCard(txtInvCardCode.getText().trim(), txtInvCardName.getText().trim(),
						txtInvCardDefinition.getText().trim(), txtnumInvCardMin.getIntegerValue(), txtnumInvCardMax.getIntegerValue(), txtInvCardVat.getIntegerValue()
						, txtInvCardDiscount.getIntegerValue(), numTextSpecailVATPercent.getIntegerValue(),
						decTextSpecialVatAmount.getBigDecimalValue(), new Boolean(radioSpecialVatAmount.getSelection()), compInvCardGroups
								.getRegisteredGroups(),//invGroups
						getInvUnits(), //invUnits
						getInvPrices(), getInvAccounts());
				txtInvCardCode.asistant.refreshContentAssistant(1);
				EngTXCommon.doSingleTX(EngBLInventoryCards.class.getName(),"RefreshContentAsistantMap",null);
				MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
				msg.setMessage(Messages.getString("InvUICardAdd.36")); //$NON-NLS-1$
				msg.open();
				clearFields();
			}
			catch (Exception ex)
			{
				Logger loger = Logger.getLogger(this.getClass());
				loger.error("Exception Caught", ex);
				ex.printStackTrace();
				MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
				msg.setMessage(ex.getMessage());
				msg.open();
			}
		}
	}

	public List getInvAccounts()
	{
		List invAccounts = new ArrayList();
		try
		{
			TableItem[] items = tableInvAccounts.getItems();
			for (int k = 0; k < items.length; k++)
			{
				InvUIInvAccountingAccTableRow row = (InvUIInvAccountingAccTableRow) items[k].getData();
				TurqInventoryAccountingAccount invAcc = (TurqInventoryAccountingAccount) row.getDBObject();
				if (invAcc.getTurqAccountingAccount() != null)
				{
					//InvBLCardAdd.saveInvAccount(invAcc, card);
					invAccounts.add(invAcc);
				}
			}
			return invAccounts;
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
			return null;
		}
	}

	public List getInvUnits()
	{
		List invUnits = new ArrayList();
		try
		{
			Object invUnit = comboInvCardUnits.getData(comboInvCardUnits.getText());
			invUnits.add(new Object[]{invUnit, new BigDecimal(1)});
			//blCardAdd.registerUnits(card, invUnit, new BigDecimal(1));
			TableItem item;
			//Register Secondary Units
			int itemCount = tableInvCardAddRegisteredUnits.getItemCount();
			TableEditor editor;
			for (int i = 0; i < itemCount; i++)
			{
				item = tableInvCardAddRegisteredUnits.getItem(i);
				editor = (TableEditor) mapEditorsTableInvCardAddRegisteredUnits.get(item.getText(0));
				BigDecimal factor = ((CurrencyText) editor.getEditor()).getBigDecimalValue();
				//blCardAdd.registerUnits(card, item.getData(), factor);
				invUnits.add(new Object[]{item.getData(), factor});
			}
			return invUnits;
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
			return null;
		}
	}

	public List getInvPrices()
	{
		List invPrices = new ArrayList();
		try
		{
			int itemCount = tableInvCardAddPrices.getItemCount();
			TableItem item;
			for (int i = 0; i < itemCount; i++)
			{
				item = tableInvCardAddPrices.getItem(i);
				String type = item.getText(0);
				String amount = item.getText(1);
				String abbrev = item.getText(2);
				String formatted = amount.toString();
				formatted = formatted.replaceAll("\\.", ""); //$NON-NLS-1$ //$NON-NLS-2$
				formatted = formatted.replaceAll(",", "."); //$NON-NLS-1$ //$NON-NLS-2$
				if (formatted.equals("")) { //$NON-NLS-1$
					formatted = "0"; //$NON-NLS-1$
				}
				if (!type.equals("") && !abbrev.equals("") && !amount.equals("")) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					boolean priceType = false;
					if (type.equals(Messages.getString("InvUICardAdd.31"))) { //$NON-NLS-1$
						priceType = true;
					}
					Object[] values = new Object[]{new Boolean(priceType), abbrev, formatted};
					invPrices.add(values);
					//blCardAdd.saveInvPrices(card, priceType, abbrev, formatted);
				}
			}
			return invPrices;
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
			return null;
		}
	}

	public void delete()
	{
	}

	public void newForm()
	{
		clearFields();
	}

	public void search()
	{
	}

	/**
	 * This static method creates a new instance of this class and shows it inside a new Shell. It is a convenience method for showing the
	 * GUI, but it can be copied and used as a basis for your own code. * It is auto-generated code - the body of this method will be
	 * re-generated after any changes are made to the GUI. However, if you delete this method it will not be re-created.
	 */
	public static void showGUI()
	{
		try
		{
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			InvUICardAdd inst = new InvUICardAdd(shell, SWT.NULL);
			shell.setLayout(new org.eclipse.swt.layout.FillLayout());
			Rectangle shellBounds = shell.computeTrim(0, 0, 655, 430);
			shell.setSize(shellBounds.width, shellBounds.height);
			shell.open();
			while (!shell.isDisposed())
			{
				if (!display.readAndDispatch())
					display.sleep();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	protected void btnInvCardGeneralMouseUp(MouseEvent evt)
	{
		int next = tabfldInvCardAdd.getSelectionIndex() + 1;
		tabfldInvCardAdd.setSelection(next);
	}

	protected void btnInvCardUnitsNxtMouseUp(MouseEvent evt)
	{
		int next = tabfldInvCardAdd.getSelectionIndex() + 1;
		tabfldInvCardAdd.setSelection(next);
	}

	protected void btnInvCardAddPricesAddPriceMouseDown(MouseEvent evt)
	{
		//	tableInvPricesViewer.add(new InvUIPrice());
		priceList.addPrice();
	}

	protected void btnInvCardAddPricesRemovePriceMouseDown(MouseEvent evt)
	{
		InvUIPrice price = (InvUIPrice) ((IStructuredSelection) tableInvPricesViewer.getSelection()).getFirstElement();
		if (price != null)
		{
			priceList.removePrice(price);
		}
		/*
		 * TTableModel model = (TTableModel) tableInvCardAddPrices.getModel(); int s[] = tableInvCardAddPrices.getRowSelection(); if
		 * (s.length > 0) { model.removeRow(s[0]); tableInvCardAddPrices.redraw(); }
		 */
	}

	protected void btnRegisterInvUnitMouseUp()
	{
		//if the base unit is selected
		if (comboInvCardUnits.getSelectionIndex() > -1)
		{
			int selectedIndex = tableInvCardAddAllUnits.getSelectionIndex();
			//if there is a selection
			if (selectedIndex >= 0)
			{
				String itemText = tableInvCardAddAllUnits.getItem(selectedIndex).getText();
				//if the selection is not the base unit
				if (!itemText.equals(comboInvCardUnits.getText()))
				{
					TableItem registeredItem = new TableItem(tableInvCardAddRegisteredUnits, SWT.NULL);
					registeredItem.setText(itemText);
					registeredItem.setData(tableInvCardAddAllUnits.getItem(selectedIndex).getData());
					tableInvCardAddAllUnits.remove(selectedIndex);
					TableEditor editor = new TableEditor(tableInvCardAddRegisteredUnits);
					editor.grabHorizontal = true;
					CurrencyText nText = new CurrencyText(tableInvCardAddRegisteredUnits, SWT.NONE);
					nText.setText(new BigDecimal(1));
					editor.setEditor(nText, registeredItem, 1);
					mapEditorsTableInvCardAddRegisteredUnits.put(itemText, editor);
				}
			}
		}
		else
		{
			MessageBox box = new MessageBox(this.getShell());
			box.setMessage(Messages.getString("InvUICardAdd.32")); //$NON-NLS-1$
			box.open();
			comboInvCardUnits.setFocus();
		}
	}

	/** Auto-generated event handler method */
	protected void btnRemoveRegisteredInvUnitMouseUp()
	{
		int selectedIndex = tableInvCardAddRegisteredUnits.getSelectionIndex();
		if (selectedIndex >= 0)
		{
			TableItem registeredItem = new TableItem(tableInvCardAddAllUnits, SWT.NULL);
			String itemText = tableInvCardAddRegisteredUnits.getItem(selectedIndex).getText();
			registeredItem.setText(tableInvCardAddRegisteredUnits.getItem(selectedIndex).getText());
			registeredItem.setData(tableInvCardAddRegisteredUnits.getItem(selectedIndex).getData());
			tableInvCardAddRegisteredUnits.remove(selectedIndex);
			((TableEditor) mapEditorsTableInvCardAddRegisteredUnits.get(itemText)).getEditor().dispose();
			((TableEditor) mapEditorsTableInvCardAddRegisteredUnits.get(itemText)).dispose();
			mapEditorsTableInvCardAddRegisteredUnits.remove(itemText);
			tableInvCardAddRegisteredUnits.getColumn(1).setWidth(50);
		}
	}

	/** Auto-generated event handler method */
	protected void btnInvCardPricesNextMouseUp(MouseEvent evt)
	{
		int next = tabfldInvCardAdd.getSelectionIndex() + 1;
		tabfldInvCardAdd.setSelection(next);
	}

	/** Auto-generated event handler method */
	protected void btnInvCardNextMouseUp(MouseEvent evt)
	{
		int next = tabfldInvCardAdd.getSelectionIndex() + 1;
		tabfldInvCardAdd.setSelection(next);
	}

	/** Auto-generated event handler method */
	protected void btnInvCardDetPreMouseUp(MouseEvent evt)
	{
		int next = tabfldInvCardAdd.getSelectionIndex() - 1;
		tabfldInvCardAdd.setSelection(next);
	}

	/** Auto-generated event handler method */
	protected void btnInvCardUnitsPreMouseUp(MouseEvent evt)
	{
		int next = tabfldInvCardAdd.getSelectionIndex() - 1;
		tabfldInvCardAdd.setSelection(next);
	}

	/** Auto-generated event handler method */
	protected void btnInvCardPricesPreMouseUp(MouseEvent evt)
	{
		int next = tabfldInvCardAdd.getSelectionIndex() - 1;
		tabfldInvCardAdd.setSelection(next);
	}

	/** Auto-generated event handler method */
	protected void btnInvCardGroupsPreMouseUp(MouseEvent evt)
	{
		int next = tabfldInvCardAdd.getSelectionIndex() - 1;
		tabfldInvCardAdd.setSelection(next);
	}

	/** Auto-generated event handler method */
	protected void btnUpdateUnitsMouseUp(MouseEvent evt)
	{
		new InvUIUnitAddDialog(this.getShell(), SWT.NULL).open();
		fillInvCardUnits();
	}

	/**
	 * @return Returns the tableInvCardAddAllUnits.
	 */
	public Table getTableInvCardAddAllUnits()
	{
		return tableInvCardAddAllUnits;
	}

	/**
	 * @return Returns the tableInvCardAddPrices.
	 */
	public Table getTableInvCardAddPrices()
	{
		return tableInvCardAddPrices;
	}

	/**
	 * @return Returns the tableInvCardAddRegisteredUnits.
	 */
	public Table getTableInvCardAddRegisteredUnits()
	{
		return tableInvCardAddRegisteredUnits;
	}

	/**
	 * @return Returns the txtInvCardCode.
	 */
	public InventoryPicker getTxtInvCardCode()
	{
		return txtInvCardCode;
	}

	/**
	 * @return Returns the txtInvCardDefinition.
	 */
	public Text getTxtInvCardDefinition()
	{
		return txtInvCardDefinition;
	}

	/**
	 * @return Returns the txtInvCardDiscount.
	 */
	public NumericText getTxtInvCardDiscount()
	{
		return txtInvCardDiscount;
	}

	/**
	 * @return Returns the txtInvCardName.
	 */
	public Text getTxtInvCardName()
	{
		return txtInvCardName;
	}

	/**
	 * @return Returns the txtInvCardVat.
	 */
	public NumericText getTxtInvCardVat()
	{
		return txtInvCardVat;
	}

	/**
	 * @return Returns the txtnumInvCardMax.
	 */
	public NumericText getTxtnumInvCardMax()
	{
		return txtnumInvCardMax;
	}

	/**
	 * @return Returns the txtnumInvCardMin.
	 */
	public NumericText getTxtnumInvCardMin()
	{
		return txtnumInvCardMin;
	}

	/**
	 * @return Returns the comboInvCardUnits.
	 */
	public CCombo getComboInvCardUnits()
	{
		return comboInvCardUnits;
	}

	/**
	 * @return Returns the priceList.
	 */
	public InvUIPriceList getPriceList()
	{
		return priceList;
	}

	/**
	 * @return Returns the decTextSpecialVatAmount.
	 */
	public CurrencyText getDecTextSpecialVatAmount()
	{
		return decTextSpecialVatAmount;
	}

	/**
	 * @return Returns the numTextSpecailVATPercent.
	 */
	public NumericText getNumTextSpecailVATPercent()
	{
		return numTextSpecailVATPercent;
	}

	public Button getRadioSpecialVatAmount()
	{
		return radioSpecialVatAmount;
	}

	public void setRadioSpecialVatAmount(Button radioSpecialVatAmount)
	{
		this.radioSpecialVatAmount = radioSpecialVatAmount;
	}

	public Button getRadioSpecialVatPercent()
	{
		return radioSpecialVatPercent;
	}

	public void setRadioSpecialVatPercent(Button radioSpecialVatPercent)
	{
		this.radioSpecialVatPercent = radioSpecialVatPercent;
	}

	public InvUIInventoryGroups getCompInvCardGroups()
	{
		return compInvCardGroups;
	}

	public void setCompInvCardGroups(InvUIInventoryGroups compInvCardGroups)
	{
		this.compInvCardGroups = compInvCardGroups;
	}
}