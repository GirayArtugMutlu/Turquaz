package com.turquaz.consignment.ui;


import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.NumericText;
import com.turquaz.engine.ui.component.DecimalText;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import com.turquaz.engine.ui.component.RegisterGroupComposite;
import org.eclipse.swt.widgets.TableColumn;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.current.ui.CurUICurrentCardSearchDialog;
import com.turquaz.engine.dal.TurqCurrentCard;
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
public class ConUIAddConsignment extends org.eclipse.swt.widgets.Composite
implements SecureComposite{

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	private Composite compInfoPanel;
	private Composite compbuttons;
	private Button btnAddConsignmentRow;
	private TableColumn tableColumnVatAmount;
	private TableColumn tableColumnVat;
	private TableColumn tableColumnTotalPrice;
	private TableColumn tableColumnUnitPrice;
	private TableColumn tableColumnAmount;
	private Composite compTotalsPanel;
	private NumericText txtDiscountRate;
	private CLabel lblInventoryPrice;
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
	private DatePicker dateConsignmentDate;
	private CLabel lblDate;
	private Button btnChooseCurrentCard;
	private Text txtCurrentCard;
	private CLabel lblCurrentCard;
	private TableColumn tableColumnInventoryName;
	private TableColumn tableColumnInventoryCode;
	private TableColumn TableColumnVATSpecial;
	private TableColumn tableColumnUnit;
	private Button buttonConsignmentRemove;
	private Table tableConsignmentRows;

	
	public ConUIAddConsignment(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			this.setSize(617, 549);
			{
				cTabFolder1 = new CTabFolder(this, SWT.NONE);
				cTabFolder1.setSelection(null);
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
					{
						compGeneral = new Composite(cTabFolder1, SWT.NONE);
						GridLayout compGeneralLayout = new GridLayout();
						compGeneralLayout.numColumns = 2;
						compGeneral.setLayout(compGeneralLayout);
						tabItemGeneral.setControl(compGeneral);
						{
							compInfoPanel = new Composite(compGeneral, SWT.NONE);
							GridLayout compInfoPanelLayout = new GridLayout();
							GridData compInfoPanelLData = new GridData();
							compInfoPanelLData.horizontalSpan = 2;
							compInfoPanelLData.horizontalAlignment = GridData.FILL;
							compInfoPanelLData.heightHint = 127;
							compInfoPanelLData.grabExcessHorizontalSpace = true;
							compInfoPanel.setLayoutData(compInfoPanelLData);
							compInfoPanelLayout.numColumns = 4;
							compInfoPanel.setLayout(compInfoPanelLayout);
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
								txtCurrentCardLData.widthHint = 211;
								txtCurrentCardLData.heightHint = 48;
								txtCurrentCard
									.setLayoutData(txtCurrentCardLData);
							}
							{
								btnChooseCurrentCard = new Button(
									compInfoPanel,
									SWT.PUSH | SWT.CENTER);
								btnChooseCurrentCard.setText("Choose");
								GridData button1LData = new GridData();
								btnChooseCurrentCard
									.addMouseListener(new MouseAdapter() {
										public void mouseUp(MouseEvent evt) {

											btnChooseMouseUp();

										}
									});
								button1LData.widthHint = 56;
								button1LData.heightHint = 23;
								button1LData.horizontalSpan = 2;
								button1LData.verticalAlignment = GridData.BEGINNING;
								btnChooseCurrentCard
									.setLayoutData(button1LData);
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
								txtDocumentNoLData.widthHint = 207;
								txtDocumentNoLData.heightHint = 17;
								txtDocumentNo.setLayoutData(txtDocumentNoLData);
							}
							{
								lblDate = new CLabel(compInfoPanel, SWT.RIGHT);
								lblDate.setText("Date");
								GridData lblDateLData = new GridData();
								lblDate.setSize(36, 25);
								lblDateLData.widthHint = 36;
								lblDateLData.heightHint = 25;
								lblDateLData.horizontalAlignment = GridData.END;
								lblDate.setLayoutData(lblDateLData);
							}
							{
								dateConsignmentDate = new DatePicker(
									compInfoPanel,
									SWT.EMBEDDED);
								GridData dateConsignmentDateLData = new GridData();
								dateConsignmentDate.setSize(113, 15);
								dateConsignmentDateLData.widthHint = 113;
								dateConsignmentDateLData.heightHint = 15;
								dateConsignmentDate
									.setLayoutData(dateConsignmentDateLData);
							}
							{
								lblType = new CLabel(compInfoPanel, SWT.NONE);
								lblType.setText("Type");
								GridData lblTypeLData = new GridData();
								lblTypeLData.widthHint = 40;
								lblTypeLData.heightHint = 18;
								lblType.setLayoutData(lblTypeLData);
							}
							{
								comboConsignmentType = new CCombo(
									compInfoPanel,
									SWT.NONE);
								GridData comboConsignmentTypeLData = new GridData();
								comboConsignmentTypeLData.widthHint = 85;
								comboConsignmentTypeLData.heightHint = 17;
								comboConsignmentType
									.setLayoutData(comboConsignmentTypeLData);
							}
							{
								lblDiscountRate = new CLabel(
									compInfoPanel,
									SWT.RIGHT);
								lblDiscountRate.setText("Discount Rate");
								GridData lblDiscountRateLData = new GridData();
								lblDiscountRateLData.widthHint = 79;
								lblDiscountRateLData.heightHint = 17;
								lblDiscountRate
									.setLayoutData(lblDiscountRateLData);
							}
							{
								txtDiscountRate = new NumericText(
									compInfoPanel,
									SWT.NONE);
								GridData txtDiscountRateLData = new GridData();
								txtDiscountRate.setTextLimit(2);
								txtDiscountRateLData.widthHint = 107;
								txtDiscountRateLData.heightHint = 15;
								txtDiscountRate
									.setLayoutData(txtDiscountRateLData);
							}
						}
						{
							compbuttons = new Composite(compGeneral, SWT.NONE);
							GridLayout composite1Layout = new GridLayout();
							GridData composite1LData = new GridData();
							composite1LData.widthHint = 43;
							composite1LData.heightHint = 81;
							composite1LData.verticalAlignment = GridData.BEGINNING;
							compbuttons.setLayoutData(composite1LData);
							composite1Layout.makeColumnsEqualWidth = true;
							compbuttons.setLayout(composite1Layout);
							{
								btnAddConsignmentRow = new Button(
									compbuttons,
									SWT.PUSH | SWT.CENTER);
								btnAddConsignmentRow
									.setImage(SWTResourceManager
										.getImage("icons/plus.gif"));
							}
							{
								buttonConsignmentRemove = new Button(
									compbuttons,
									SWT.PUSH | SWT.CENTER);
								buttonConsignmentRemove
									.setImage(SWTResourceManager
										.getImage("icons/minus.gif"));
							}
						}
						{
							tableConsignmentRows = new Table(
								compGeneral,
								SWT.BORDER);
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
						}
						{
							compTotalsPanel = new Composite(
								compGeneral,
								SWT.NONE);
							GridLayout composite1Layout1 = new GridLayout();
							GridData composite1LData1 = new GridData();
							composite1LData1.grabExcessHorizontalSpace = true;
							composite1LData1.horizontalSpan = 2;
							composite1LData1.horizontalAlignment = GridData.FILL;
							composite1LData1.heightHint = 118;
							compTotalsPanel.setLayoutData(composite1LData1);
							composite1Layout1.numColumns = 2;
							compTotalsPanel.setLayout(composite1Layout1);
							{
								lblDiscountAmount = new CLabel(
									compTotalsPanel,
									SWT.NONE);
								lblDiscountAmount.setText("Discount Amount");
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
								txtDiscountAmountLData.widthHint = 245;
								txtDiscountAmountLData.heightHint = 18;
								txtDiscountAmount
									.setLayoutData(txtDiscountAmountLData);
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
								txtTotalVat.setSize(251, 18);
								txtTotalVat.setBackground(SWTResourceManager
									.getColor(255, 255, 255));
								txtTotalVat.setEditable(false);
								txtTotalVatLData.widthHint = 245;
								txtTotalVatLData.heightHint = 18;
								txtTotalVat.setLayoutData(txtTotalVatLData);
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
								txtSubTotal.setSize(251, 18);
								txtSubTotal.setBackground(SWTResourceManager
									.getColor(255, 255, 255));
								txtSubTotal.setEditable(false);
								text1LData.widthHint = 245;
								text1LData.heightHint = 18;
								txtSubTotal.setLayoutData(text1LData);
							}
							{
								lblTotalAmount = new CLabel(
									compTotalsPanel,
									SWT.NONE);
								lblTotalAmount.setText("Total Amount :");
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
								txtTotalAmount.setSize(251, 18);
								txtTotalAmount.setBackground(SWTResourceManager
									.getColor(255, 255, 255));
								txtTotalAmount.setEditable(false);
								txtTotalAmountLData.widthHint = 245;
								txtTotalAmountLData.heightHint = 18;
								txtTotalAmount
									.setLayoutData(txtTotalAmountLData);
							}
						}
					}
				}
				{
					tabItemGroups = new CTabItem(cTabFolder1, SWT.NONE);
					tabItemGroups.setText("Groups");
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
							btnUpdateGroupsLData.widthHint = 99;
							btnUpdateGroupsLData.heightHint = 21;
							btnUpdateGroups.setLayoutData(btnUpdateGroupsLData);
						}
					}
				}
			}
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void btnChooseMouseUp(){
		Object data = new CurUICurrentCardSearchDialog(this.getShell(),SWT.NULL).open();
	    if(data!=null){
	    
	    System.out.println(data.getClass().getName());
		TurqCurrentCard curCard = (TurqCurrentCard)data;
	    txtCurrentCard.setText(curCard.getCardsCurrentCode()+" - "+curCard.getCardsName());
		txtCurrentCard.setData(curCard);
		txtDiscountRate.setText(curCard.getCardsDiscountRate().intValue());
	    }
	}
	public void save(){
		
	}
	public void delete(){
		
	}
	public void search(){
		
	}
	public void newForm(){
		
	}

}
