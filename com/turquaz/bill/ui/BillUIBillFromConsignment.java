package com.turquaz.bill.ui;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.NumericText;
import com.turquaz.engine.ui.component.DecimalText;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Label;
import com.turquaz.engine.ui.component.TextWithButton;
import com.turquaz.engine.ui.component.RegisterGroupComposite;
import org.eclipse.swt.widgets.TableColumn;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.bill.bl.BillBLAddBill;
import com.turquaz.bill.bl.BillBLAddGroups;
import com.turquaz.consignment.ui.ConUIConsignmentSearchDialog;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqBillConsignmentCommon;
import com.turquaz.engine.dal.TurqBillGroup;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqInventoryTransaction;

import com.turquaz.engine.ui.component.SecureComposite;

import org.eclipse.swt.widgets.Button;

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
public class BillUIBillFromConsignment extends org.eclipse.swt.widgets.Composite
implements SecureComposite{

	/**
	 * @return Returns the comboConsignmentType.
	 */
	public CCombo getComboConsignmentType() {
		return comboConsignmentType;
	}
	/**
	 * @param comboConsignmentType The comboConsignmentType to set.
	 */
	public void setComboConsignmentType(CCombo comboConsignmentType) {
		this.comboConsignmentType = comboConsignmentType;
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
	/**
	 * @return Returns the dateBillDate.
	 */
	public DatePicker getDateBillDate() {
		return dateBillDate;
	}
	/**
	 * @param dateBillDate The dateBillDate to set.
	 */
	public void setDateBillDate(DatePicker dateConsignmentDate) {
		this.dateBillDate = dateConsignmentDate;
	}
	/**
	 * @return Returns the decSpecialVat.
	 */
	public DecimalText getDecSpecialVat() {
		return decSpecialVat;
	}
	/**
	 * @param decSpecialVat The decSpecialVat to set.
	 */
	public void setDecSpecialVat(DecimalText decSpecialVat) {
		this.decSpecialVat = decSpecialVat;
	}
	/**
	 * @return Returns the tableConsignmentRows.
	 */
	public Table getTableConsignmentRows() {
		return tableConsignmentRows;
	}
	/**
	 * @param tableConsignmentRows The tableConsignmentRows to set.
	 */
	public void setTableConsignmentRows(Table tableConsignmentRows) {
		this.tableConsignmentRows = tableConsignmentRows;
	}
	/**
	 * @return Returns the txtCurrentCard.
	 */
	public Text getTxtCurrentCard() {
		return txtCurrentCard;
	}
	/**
	 * @param txtCurrentCard The txtCurrentCard to set.
	 */
	public void setTxtCurrentCard(Text txtCurrentCard) {
		this.txtCurrentCard = txtCurrentCard;
	}
	/**
	 * @return Returns the txtDefinition.
	 */
	public Text getTxtDefinition() {
		return txtDefinition;
	}
	/**
	 * @param txtDefinition The txtDefinition to set.
	 */
	public void setTxtDefinition(Text txtDefinition) {
		this.txtDefinition = txtDefinition;
	}
	/**
	 * @return Returns the txtDiscountAmount.
	 */
	public DecimalText getTxtDiscountAmount() {
		return txtDiscountAmount;
	}
	/**
	 * @param txtDiscountAmount The txtDiscountAmount to set.
	 */
	public void setTxtDiscountAmount(DecimalText txtDiscountAmount) {
		this.txtDiscountAmount = txtDiscountAmount;
	}
	/**
	 * @return Returns the txtDiscountRate.
	 */
	public NumericText getTxtDiscountRate() {
		return txtDiscountRate;
	}
	/**
	 * @param txtDiscountRate The txtDiscountRate to set.
	 */
	public void setTxtDiscountRate(NumericText txtDiscountRate) {
		this.txtDiscountRate = txtDiscountRate;
	}
	/**
	 * @return Returns the txtDocumentNo.
	 */
	public Text getTxtDocumentNo() {
		return txtDocumentNo;
	}
	/**
	 * @param txtDocumentNo The txtDocumentNo to set.
	 */
	public void setTxtDocumentNo(Text txtDocumentNo) {
		this.txtDocumentNo = txtDocumentNo;
	}
	/**
	 * @return Returns the txtSubTotal.
	 */
	public DecimalText getTxtSubTotal() {
		return txtSubTotal;
	}
	/**
	 * @param txtSubTotal The txtSubTotal to set.
	 */
	public void setTxtSubTotal(DecimalText txtSubTotal) {
		this.txtSubTotal = txtSubTotal;
	}
	/**
	 * @return Returns the txtTotalAmount.
	 */
	public DecimalText getTxtTotalAmount() {
		return txtTotalAmount;
	}
	/**
	 * @param txtTotalAmount The txtTotalAmount to set.
	 */
	public void setTxtTotalAmount(DecimalText txtTotalAmount) {
		this.txtTotalAmount = txtTotalAmount;
	}
	/**
	 * @return Returns the txtTotalVat.
	 */
	public DecimalText getTxtTotalVat() {
		return txtTotalVat;
	}
	/**
	 * @param txtTotalVat The txtTotalVat to set.
	 */
	public void setTxtTotalVat(DecimalText txtTotalVat) {
		this.txtTotalVat = txtTotalVat;
	}
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	private Composite compInfoPanel;
	private TableColumn tableColumnVatAmount;
	private TableColumn tableColumnVat;
	private TableColumn tableColumnTotalPrice;
	private TableColumn tableColumnUnitPrice;
	private TableColumn tableColumnAmount;
	private Composite compTotalsPanel;
	private CLabel lblInventoryPrice;
	private Button checkClosedBill;
	private NumericText txtDiscountRate;
	private DatePicker dateConsDate;
	private CLabel lblConsignmentDate;
	private TextWithButton txtConsignment;
	private CLabel lblConsignmet;
	private Text txtDefinition;
	private CLabel lblDefinition;
	private DecimalText decSpecialVat;
	private Label lblSpecialVAT;
	private TableColumn tableColumnCumulative;
	private Button btnUpdateGroups;
	private RegisterGroupComposite compRegisterGroup;
	private Composite composite1;
	private CTabItem tabItemGroups;
	private Composite compGeneral;
	private CTabItem tabItemGeneral;
	private CTabFolder cTabFolder1;
	private CCombo comboConsignmentType;
	private CLabel lblType;
	private DecimalText txtDiscountAmount;
	private CLabel lblDiscountAmount;
	private DecimalText txtTotalAmount;
	private CLabel lblTotalAmount;
	private DecimalText txtSubTotal;
	private DecimalText txtTotalVat;
	private CLabel lblTotalVat;
	private CLabel lblDiscountRate;
	private Text txtDocumentNo;
	private CLabel lblDocumentNo;
	private DatePicker dateBillDate;
	private CLabel lblDate;
	private Text txtCurrentCard;
	private CLabel lblCurrentCard;
	private TableColumn tableColumnInventoryName;
	private TableColumn tableColumnInventoryCode;
	private TableColumn TableColumnVATSpecial;
	private TableColumn tableColumnUnit;
	private Table tableConsignmentRows;
	BillBLAddGroups blAddGroup = new BillBLAddGroups();
	BillBLAddBill blAddBill = new BillBLAddBill();

	
	public BillUIBillFromConsignment(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
	try {
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			thisLayout.horizontalSpacing = 0;
			thisLayout.marginHeight = 0;
			thisLayout.marginWidth = 0;
			thisLayout.verticalSpacing = 0;
			this.setSize(633, 527);
			{
				cTabFolder1 = new CTabFolder(this, SWT.NONE);
				cTabFolder1.setSize(56, 25);
				GridData cTabFolder1LData = new GridData();
				cTabFolder1LData.grabExcessHorizontalSpace = true;
				cTabFolder1LData.grabExcessVerticalSpace = true;
				cTabFolder1LData.horizontalAlignment = GridData.FILL;
				cTabFolder1LData.verticalAlignment = GridData.FILL;
				cTabFolder1.setLayoutData(cTabFolder1LData);
				{
					tabItemGeneral = new CTabItem(cTabFolder1, SWT.NONE);
					tabItemGeneral.setText("General");
					tabItemGeneral.setImage(SWTResourceManager.getImage("icons/Home16.gif"));
					{
						compGeneral = new Composite(cTabFolder1, SWT.NONE);
						GridLayout compGeneralLayout = new GridLayout();
						compGeneral.setLayout(compGeneralLayout);
						tabItemGeneral.setControl(compGeneral);
						{
							compInfoPanel = new Composite(compGeneral, SWT.NONE);
							GridLayout compInfoPanelLayout = new GridLayout();
							GridData compInfoPanelLData = new GridData();
							compInfoPanelLData.horizontalSpan = 2;
							compInfoPanelLData.horizontalAlignment = GridData.FILL;
							compInfoPanelLData.heightHint = 172;
							compInfoPanelLData.grabExcessHorizontalSpace = true;
							compInfoPanel.setLayoutData(compInfoPanelLData);
							compInfoPanelLayout.numColumns = 4;
							compInfoPanel.setLayout(compInfoPanelLayout);
							{
								lblConsignmet = new CLabel(
									compInfoPanel,
									SWT.NONE);
								lblConsignmet
									.setText("Consignment Document No");
								GridData lblConsignmetLData = new GridData();
								lblConsignmetLData.widthHint = 149;
								lblConsignmetLData.heightHint = 25;
								lblConsignmet.setLayoutData(lblConsignmetLData);
							}
							{
								txtConsignment = new TextWithButton(
									compInfoPanel,
									SWT.NONE);
								GridData txtConsignmentLData = new GridData();
								txtConsignment
									.addMouseListener(new MouseAdapter() {
									public void mouseUp(MouseEvent evt) {
										chooseConsignmentMouseUp();
									}
									});
								txtConsignment
									.setText("Please Choose Consignmet ");
								txtConsignmentLData.widthHint = 200;
								txtConsignmentLData.heightHint = 21;
								txtConsignment
									.setLayoutData(txtConsignmentLData);
							}
							{
								lblConsignmentDate = new CLabel(
									compInfoPanel,
									SWT.NONE);
								lblConsignmentDate.setText("Cons. Date");
								GridData lblConsignmentDateLData = new GridData();
								lblConsignmentDateLData.widthHint = 86;
								lblConsignmentDateLData.heightHint = 18;
								lblConsignmentDate
									.setLayoutData(lblConsignmentDateLData);
							}
							{
								dateConsDate = new DatePicker(
									compInfoPanel,
									SWT.NONE);
								GridData dateConsDateLData = new GridData();
								dateConsDate.setSize(113, 20);
								dateConsDate.setEnabled(false);
								dateConsDateLData.widthHint = 113;
								dateConsDateLData.heightHint = 20;
								dateConsDate.setLayoutData(dateConsDateLData);
							}
							{
								lblCurrentCard = new CLabel(
									compInfoPanel,
									SWT.NONE);
								lblCurrentCard.setText("Current Card");
								GridData lblCurrentCardLData1 = new GridData();
								lblCurrentCard.setSize(88, 19);
								lblCurrentCardLData1.widthHint = 88;
								lblCurrentCardLData1.heightHint = 19;
								lblCurrentCardLData1.verticalAlignment = GridData.BEGINNING;
								lblCurrentCard
									.setLayoutData(lblCurrentCardLData1);
							}
							{
								txtCurrentCard = new Text(
									compInfoPanel,
									SWT.MULTI);
								GridData txtCurrentCardLData = new GridData();
								txtCurrentCard.setBackground(SWTResourceManager
									.getColor(255, 255, 255));
								txtCurrentCard.setEditable(false);
								txtCurrentCardLData.widthHint = 192;
								txtCurrentCardLData.heightHint = 40;
								txtCurrentCardLData.horizontalSpan = 3;
								txtCurrentCard
									.setLayoutData(txtCurrentCardLData);
							}
							{
								lblDocumentNo = new CLabel(
									compInfoPanel,
									SWT.NONE);
								lblDocumentNo.setText("Document No");
								GridData lblDocumentNoLData = new GridData();
								lblDocumentNoLData.widthHint = 107;
								lblDocumentNoLData.heightHint = 15;
								lblDocumentNo.setLayoutData(lblDocumentNoLData);
							}
							{
								txtDocumentNo = new Text(
									compInfoPanel,
									SWT.NONE);
								GridData txtDocumentNoLData = new GridData();
								txtDocumentNo.setBackground(SWTResourceManager.getColor(255,255,255));
								txtDocumentNo.setEditable(false);
								txtDocumentNoLData.widthHint = 188;
								txtDocumentNoLData.heightHint = 18;
								txtDocumentNo.setLayoutData(txtDocumentNoLData);
							}
							{
								lblDate = new CLabel(compInfoPanel, SWT.LEFT);
								lblDate.setText("Date");
								GridData lblDateLData = new GridData();
								lblDateLData.widthHint = 70;
								lblDateLData.heightHint = 21;
								lblDate.setLayoutData(lblDateLData);
							}
							{
								dateBillDate = new DatePicker(
									compInfoPanel,
									SWT.EMBEDDED);
								GridData dateConsignmentDateLData = new GridData();
								dateConsignmentDateLData.widthHint = 113;
								dateConsignmentDateLData.heightHint = 20;
								dateBillDate
									.setLayoutData(dateConsignmentDateLData);
							}
							{
								lblType = new CLabel(compInfoPanel, SWT.LEFT);
								lblType.setText("Type");
								GridData lblTypeLData = new GridData();
								lblTypeLData.widthHint = 62;
								lblTypeLData.heightHint = 14;
								lblTypeLData.verticalAlignment = GridData.BEGINNING;
								lblType.setLayoutData(lblTypeLData);
							}
							{
								comboConsignmentType = new CCombo(
									compInfoPanel,
									SWT.NONE);
								GridData comboConsignmentTypeLData = new GridData();
								comboConsignmentType.setEnabled(false);
								comboConsignmentType
									.setBackground(SWTResourceManager.getColor(
										255,
										255,
										255));
								comboConsignmentType.setEditable(false);
								comboConsignmentType.setText("Buy");
								comboConsignmentTypeLData.widthHint = 80;
								comboConsignmentTypeLData.heightHint = 16;
								comboConsignmentType
									.setLayoutData(comboConsignmentTypeLData);
							}
							{
								lblDiscountRate = new CLabel(
									compInfoPanel,
									SWT.LEFT);
								lblDiscountRate.setText("Discount Rate");
								GridData lblDiscountRateLData = new GridData();
								lblDiscountRateLData.widthHint = 96;
								lblDiscountRateLData.heightHint = 15;
								lblDiscountRate
									.setLayoutData(lblDiscountRateLData);
							}
							{
								txtDiscountRate = new NumericText(
									compInfoPanel,
									SWT.NONE);
								txtDiscountRate.setTextLimit(2);
								GridData txtDiscountRateLData = new GridData();
								txtDiscountRate.setSize(107, 20);
								txtDiscountRate
									.addModifyListener(new ModifyListener() {
										public void modifyText(ModifyEvent evt) {
											calculateTotals();
										}
									});
								txtDiscountRateLData.widthHint = 107;
								txtDiscountRateLData.heightHint = 20;
								txtDiscountRate
									.setLayoutData(txtDiscountRateLData);
							}
							{
								lblDefinition = new CLabel(
									compInfoPanel,
									SWT.LEFT);
								lblDefinition.setText("Definition");
								GridData lblDefinitionLData = new GridData();
								lblDefinitionLData.widthHint = 108;
								lblDefinitionLData.heightHint = 20;
								lblDefinitionLData.verticalAlignment = GridData.BEGINNING;
								lblDefinition.setLayoutData(lblDefinitionLData);
							}
							{
								txtDefinition = new Text(
									compInfoPanel,
									SWT.NONE);
								GridData txtDefinitionLData = new GridData();
								txtDefinitionLData.widthHint = 191;
								txtDefinitionLData.heightHint = 34;
								txtDefinition.setLayoutData(txtDefinitionLData);
							}
							{
								checkClosedBill = new Button(
									compInfoPanel,
									SWT.CHECK | SWT.LEFT);
								checkClosedBill.setText("Closed Bill?");
								GridData checkClosedBillLData = new GridData();
								checkClosedBillLData.widthHint = 166;
								checkClosedBillLData.heightHint = 19;
								checkClosedBillLData.horizontalSpan = 2;
								checkClosedBill.setLayoutData(checkClosedBillLData);
							}
						}
						{
							tableConsignmentRows = new Table(
								compGeneral,
								SWT.SINGLE | SWT.FULL_SELECTION | SWT.BORDER);
							GridData tableConsignmentRowsLData = new GridData();
							tableConsignmentRows.setLinesVisible(true);
							tableConsignmentRows.setHeaderVisible(true);
							tableConsignmentRowsLData.grabExcessHorizontalSpace = true;
							tableConsignmentRowsLData.grabExcessVerticalSpace = true;
							tableConsignmentRowsLData.horizontalAlignment = GridData.FILL;
							tableConsignmentRowsLData.verticalAlignment = GridData.FILL;
							tableConsignmentRows
								.setLayoutData(tableConsignmentRowsLData);
							{
								tableColumnInventoryCode = new TableColumn(
									tableConsignmentRows,
									SWT.NONE);
								tableColumnInventoryCode
									.setText("Inventory Code");
								tableColumnInventoryCode.setWidth(98);
							}
							{
								tableColumnInventoryName = new TableColumn(
									tableConsignmentRows,
									SWT.NONE);
								tableColumnInventoryName
									.setText("Inventory Name");
								tableColumnInventoryName.setWidth(106);
							}
							{
								tableColumnAmount = new TableColumn(
									tableConsignmentRows,
									SWT.NONE);
								tableColumnAmount.setText("Amount");
								tableColumnAmount.setWidth(99);
							}
							{
								tableColumnUnit = new TableColumn(
									tableConsignmentRows,
									SWT.NONE);
								tableColumnUnit.setText("Unit");
								tableColumnUnit.setWidth(54);
							}
							{
								tableColumnUnitPrice = new TableColumn(
									tableConsignmentRows,
									SWT.NONE);
								tableColumnUnitPrice.setText("Unit Price");
								tableColumnUnitPrice.setWidth(70);
							}
							{
								tableColumnTotalPrice = new TableColumn(
									tableConsignmentRows,
									SWT.NONE);
								tableColumnTotalPrice.setText("Total Price");
								tableColumnTotalPrice.setWidth(77);
							}
							{
								tableColumnVat = new TableColumn(
									tableConsignmentRows,
									SWT.NONE);
								tableColumnVat.setText("VAT");
								tableColumnVat.setWidth(50);
							}
							{
								tableColumnVatAmount = new TableColumn(
									tableConsignmentRows,
									SWT.NONE);
								tableColumnVatAmount.setText("VAT Amount");
								tableColumnVatAmount.setWidth(90);
							}
							{
								TableColumnVATSpecial = new TableColumn(
									tableConsignmentRows,
									SWT.NONE);
								TableColumnVATSpecial.setText("Special VAT");
								TableColumnVATSpecial.setWidth(100);
							}
							{
								tableColumnCumulative = new TableColumn(
									tableConsignmentRows,
									SWT.NONE);
								tableColumnCumulative
									.setText("Cumulative Total");
								tableColumnCumulative.setWidth(100);
							}
						}
						{
							compTotalsPanel = new Composite(compGeneral, SWT.NONE);
							GridLayout composite1Layout1 = new GridLayout();
							GridData composite1LData1 = new GridData();
							composite1LData1.grabExcessHorizontalSpace = true;
							composite1LData1.horizontalSpan = 2;
							composite1LData1.horizontalAlignment = GridData.FILL;
							composite1LData1.heightHint = 126;
							compTotalsPanel.setLayoutData(composite1LData1);
							composite1Layout1.numColumns = 4;
							compTotalsPanel.setLayout(composite1Layout1);
							{
								lblDiscountAmount = new CLabel(
									compTotalsPanel,
									SWT.NONE);
								lblDiscountAmount.setText("Discount Amount:");
								GridData lblDiscountAmountLData = new GridData();
								lblDiscountAmountLData.widthHint = 105;
								lblDiscountAmountLData.heightHint = 19;
								lblDiscountAmount.setLayoutData(lblDiscountAmountLData);
							}
							{
								txtDiscountAmount = new DecimalText(
									compTotalsPanel,
									SWT.NONE);
								GridData txtDiscountAmountLData = new GridData();
								txtDiscountAmount
									.setBackground(SWTResourceManager.getColor(
										255,
										255,
										255));
								txtDiscountAmount.setEditable(false);
								txtDiscountAmountLData.widthHint = 191;
								txtDiscountAmountLData.heightHint = 18;
								txtDiscountAmount
									.setLayoutData(txtDiscountAmountLData);
							}
							{
								lblTotalAmount = new CLabel(
									compTotalsPanel,
									SWT.NONE);
								lblTotalAmount.setText("General Total:");
								GridData lblTotalAmountLData = new GridData();
								lblTotalAmount.setSize(87, 19);
								lblTotalAmountLData.widthHint = 87;
								lblTotalAmountLData.heightHint = 19;
								lblTotalAmount
									.setLayoutData(lblTotalAmountLData);
							}
							{
								txtTotalAmount = new DecimalText(
									compTotalsPanel,
									SWT.NONE);
								GridData txtTotalAmountLData = new GridData();
								txtTotalAmount.setBackground(SWTResourceManager
									.getColor(255, 255, 255));
								txtTotalAmount.setEditable(false);
								txtTotalAmountLData.widthHint = 197;
								txtTotalAmountLData.heightHint = 17;
								txtTotalAmount.setLayoutData(txtTotalAmountLData);
							}
							{
								lblInventoryPrice = new CLabel(
									compTotalsPanel,
									SWT.NONE);
								lblInventoryPrice.setText("Sub Total :");
								GridData lblInventoryPriceLData = new GridData();
								lblInventoryPrice.setSize(87, 19);
								lblInventoryPriceLData.widthHint = 87;
								lblInventoryPriceLData.heightHint = 19;
								lblInventoryPrice
									.setLayoutData(lblInventoryPriceLData);
							}
							{
								txtSubTotal = new DecimalText(
									compTotalsPanel,
									SWT.NONE);
								GridData text1LData = new GridData();
								txtSubTotal.setBackground(SWTResourceManager
									.getColor(255, 255, 255));
								txtSubTotal.setEditable(false);
								text1LData.widthHint = 190;
								text1LData.heightHint = 19;
								text1LData.horizontalSpan = 3;
								txtSubTotal.setLayoutData(text1LData);
							}
							{
								lblTotalVat = new CLabel(
									compTotalsPanel,
									SWT.NONE);
								lblTotalVat.setText("Total VAT :");
								GridData lblTotalVatLData = new GridData();
								lblTotalVat.setSize(87, 19);
								lblTotalVatLData.widthHint = 87;
								lblTotalVatLData.heightHint = 19;
								lblTotalVat.setLayoutData(lblTotalVatLData);
							}
							{
								txtTotalVat = new DecimalText(
									compTotalsPanel,
									SWT.NONE);
								GridData txtTotalVatLData = new GridData();
								txtTotalVat.setBackground(SWTResourceManager.getColor(255,255,255));
								txtTotalVat.setEditable(false);
								txtTotalVatLData.widthHint = 190;
								txtTotalVatLData.heightHint = 19;
								txtTotalVatLData.horizontalSpan = 3;
								txtTotalVat.setLayoutData(txtTotalVatLData);
							}
							{
								lblSpecialVAT = new Label(
									compTotalsPanel,
									SWT.NONE);
								lblSpecialVAT.setText("Special VAT:");
								GridData lblSpecialVATLData = new GridData();
								lblSpecialVATLData.widthHint = 104;
								lblSpecialVATLData.heightHint = 16;
								lblSpecialVAT.setLayoutData(lblSpecialVATLData);
							}
							{
								decSpecialVat = new DecimalText(
									compTotalsPanel,
									SWT.NONE);
								GridData decSpecialVatLData = new GridData();
								decSpecialVat.setBackground(SWTResourceManager.getColor(255,255,255));
								decSpecialVat.setEditable(false);
								decSpecialVatLData.widthHint = 191;
								decSpecialVatLData.heightHint = 19;
								decSpecialVatLData.horizontalSpan = 3;
								decSpecialVat.setLayoutData(decSpecialVatLData);
							}
						}
					}
				}
				{
					tabItemGroups = new CTabItem(cTabFolder1, SWT.NONE);
					tabItemGroups.setText("Groups");
					tabItemGroups.setImage(SWTResourceManager.getImage("icons/Multi16.gif"));
					{
						composite1 = new Composite(cTabFolder1, SWT.NONE);
						tabItemGroups.setControl(composite1);
						GridLayout composite1Layout2 = new GridLayout();
						composite1Layout2.makeColumnsEqualWidth = true;
						composite1.setLayout(composite1Layout2);
						{
							compRegisterGroup = new RegisterGroupComposite(
								composite1,
								SWT.NONE);
							GridData compRegisterGroupLData = new GridData();
							compRegisterGroupLData.widthHint = 182;
							compRegisterGroupLData.heightHint = 171;
							compRegisterGroup.setLayoutData(compRegisterGroupLData);
						}
						{
							btnUpdateGroups = new Button(composite1, SWT.PUSH
								| SWT.CENTER);
							btnUpdateGroups.setText("Update Groups");
							GridData btnUpdateGroupsLData = new GridData();
							btnUpdateGroups
								.addMouseListener(new MouseAdapter() {
								public void mouseUp(MouseEvent evt) {
                                    btnUpdateGroupsClick();
								}
								});
							btnUpdateGroupsLData.widthHint = 112;
							btnUpdateGroupsLData.heightHint = 22;
							btnUpdateGroups.setLayoutData(btnUpdateGroupsLData);
						}
					}
				}
			}
			this.layout();
			postInitGui();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void btnUpdateGroupsClick(){
		
		new BillUIBillsGroupDialog(this.getShell(),SWT.NULL).open();
		
		fillGroupsTable();
		
		
		
		
		
	}
	public void fillGroupsTable(){
	
		try{
			
		//Fill Group Table	
		List list = blAddGroup.getBillGroups();
		HashMap groupMap = new HashMap(); 
		
		
		TurqBillGroup curGroup;
		
		for(int i=0; i<list.size();i++){
		curGroup = (TurqBillGroup)list.get(i);
		groupMap.put(curGroup.getGroupsName(),curGroup);
		}
		
		compRegisterGroup.fillTableAllGroups(groupMap);	
		
		
		
		
		}
		catch(Exception ex){
		
			ex.printStackTrace();
		}
		
	}
	public void postInitGui(){
		cTabFolder1.setSelection(tabItemGeneral);
		
		fillGroupsTable();
		
		//fill combo type
		
		comboConsignmentType.add("Buy");
		comboConsignmentType.add("Sell");
		
		
	}
	
	
	
	
	
	public boolean verifyFields(){
		return true;
	}
	
	
	public void saveGroups(Integer consignmentId){
		try{
			TableItem items[] = compRegisterGroup.getTableAllGroups().getItems();
			for(int i=0;i<items.length;i++){
				if(items[i].getChecked()){
					blAddBill.registerGroup((TurqBillGroup)items[i].getData(),consignmentId);
				}
				
			}
			
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	public void save(){
		MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
	try{	
		if(verifyFields()){
			TurqBill bill = new TurqBill();
			bill.setBillsId(new Integer(-1));
	        int type =0;
		if(comboConsignmentType.getText().equals("Sell")){
			type =1;
		}
	     TurqConsignment consignment = (TurqConsignment)txtConsignment.getData();
		Integer consID =blAddBill.saveBill(txtDocumentNo.getText(),
										txtDefinition.getText(),
										false,
										dateBillDate.getDate(),
										consignment,
										type,
										!checkClosedBill.getSelection());
		
		saveGroups(consID);
		msg.setMessage("Succesfully Saved!!");
		msg.open();
		newForm();
		}
	}
	catch(Exception ex){
		ex.printStackTrace();
		msg.setMessage(ex.getMessage());
		msg.open();
	}
		
	}
	public void delete(){
		
	}
	public void search(){
		
	}
	public void newForm(){
		 BillUIBillFromConsignment cardAdd = new  BillUIBillFromConsignment(this.getParent(),this.getStyle());
		 CTabFolder tabfld = (CTabFolder)this.getParent();
		 tabfld.getSelection().setControl(cardAdd);	 
		 this.dispose();
		
		
	}
	
	public void calculateTotals(){
		
	TableItem items[] = tableConsignmentRows.getItems();
	BigDecimal subTotal = new BigDecimal(0);
	BigDecimal totalVAT = new BigDecimal(0);
	BigDecimal totalSpecVAT = new BigDecimal(0);
	BigDecimal generalTotal = new BigDecimal(0);
	BigDecimal discountTotal = new BigDecimal(0);
	
	
	for(int i =0;i<items.length;i++){
		subTotal = subTotal.add(new BigDecimal(items[i].getText(5)));
		totalVAT = totalVAT.add(new BigDecimal(items[i].getText(7)));
		totalSpecVAT = totalSpecVAT.add(new BigDecimal(items[i].getText(8)));
		
	}
	
	generalTotal = subTotal.add(totalVAT).add(totalSpecVAT);
    double discountRate = (double)txtDiscountRate.getIntValue()/100;
  
   
 
    discountTotal = generalTotal.multiply(new BigDecimal(discountRate+"")).setScale(2, BigDecimal.ROUND_DOWN);;
       
    totalSpecVAT = totalSpecVAT.subtract(totalSpecVAT.multiply(new BigDecimal(discountRate+""))).setScale(2,BigDecimal.ROUND_DOWN);
    
    subTotal = subTotal.subtract(subTotal.multiply(new BigDecimal(discountRate+""))).setScale(2, BigDecimal.ROUND_DOWN);
    
    totalVAT = totalVAT.subtract(totalVAT.multiply(new BigDecimal(discountRate+""))).setScale(2, BigDecimal.ROUND_DOWN);
    
    txtDiscountAmount.setText(discountTotal.toString());    
	txtSubTotal.setText(subTotal.toString());
	txtTotalVat.setText(totalVAT.toString());
	decSpecialVat.setText(totalSpecVAT.toString());
	txtTotalAmount.setText(generalTotal.subtract(discountTotal).toString());	
		
		
	}
	
	public void chooseConsignmentMouseUp(){
	TurqConsignment cons = new ConUIConsignmentSearchDialog(this.getShell(),SWT.NULL).open();
	
	if(cons!=null){
	txtConsignment.setData(cons);	
	
	TurqBillConsignmentCommon common = cons.getTurqBillConsignmentCommon();
		
	txtCurrentCard.setText(common.getTurqCurrentCard().getCardsCurrentCode()+" - "+common.getTurqCurrentCard().getCardsName());
	txtCurrentCard.setData(common.getTurqCurrentCard());
	txtDocumentNo.setText(common.getBillDocumentNo());
	dateConsDate.setDate(cons.getConsignmentsDate());
    txtConsignment.setText(cons.getTurqBillConsignmentCommon().getConsignmentDocumentNo());
	
	Iterator it = cons.getTurqEngineSequence().getTurqInventoryTransactions().iterator();
	
	TableItem item;
	TurqInventoryTransaction invTrans;
	
    tableConsignmentRows.removeAll(); 
    	
	while(it.hasNext()){
    	invTrans = (TurqInventoryTransaction)it.next();
    	item = new TableItem(tableConsignmentRows,SWT.NULL);
    	item.setData(invTrans);
    	item.setText(new String[]{invTrans.getTurqInventoryCard().getCardInventoryCode(),
				   invTrans.getTurqInventoryCard().getCardName(),
				   invTrans.getTransactionsAmountIn()+"",
				   invTrans.getTurqInventoryUnit().getUnitsName(),
				   invTrans.getTransactionsUnitPrice().toString(),
				   invTrans.getTransactionsTotalPrice().toString(),
				   invTrans.getTransactionsVat()+"",
				   invTrans.getTransactionsVatAmount().toString(),
				   invTrans.getTransactionsVatSpecialAmount().toString(),
				   invTrans.getTransactionsCumilativePrice().toString()});

    	
    	
    }	
	String type = "Buy";
	
	if(cons.getConsignmentsType()==1){
		type="Sell";
	}
	comboConsignmentType.setText(type);
	
	txtDiscountRate.setText(common.getDiscountRate());
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
	}

}
