package com.turquaz.inventory.ui;

import java.util.Iterator;
import java.util.List;


import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.TableItem;

import org.eclipse.swt.widgets.Composite;

import com.turquaz.current.ui.CurUICurrentCardSearchDialog;
import com.turquaz.engine.bl.EngBLUtils;

import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.TextWithButton;
import com.turquaz.engine.ui.component.DatePicker;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;

import org.eclipse.swt.SWT;

import com.turquaz.engine.ui.component.SecureComposite;
import com.turquaz.inventory.bl.InvBLSearchTransaction;

import org.eclipse.swt.widgets.Label;
/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder,
 * which is free for non-commercial use. If Jigloo is being used commercially
 * (ie, by a corporation, company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo. Please visit
 * www.cloudgarden.com for details. Use of Jigloo implies acceptance of these
 * licensing terms. ************************************* A COMMERCIAL LICENSE
 * HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be
 * used legally for anycorporate or commercial purpose.
 * *************************************
 */

public class InvUITransactionSearch extends org.eclipse.swt.widgets.Composite
		implements SecureComposite, SearchComposite {
	private Composite compInvTransactionSearch;

	private Table tableTransactions;

	private TableColumn tableColumnCurrentName;

	private TableColumn tableColumnVatAmount;

	private TextWithButton txtCurCard;
	private TableColumn tableColumnInventoryCode;
	private TextWithButton txtInvCard;
	private Label lblInvCard;

	private CCombo comboTransactionsType;

	private CLabel lblType;

	private CLabel lblEndDate;

	private DatePicker dateEndDate;

	private DatePicker dateStartDate;

	private CLabel lblStartDate;

	private CLabel lblCurrentCard;

	private TableColumn tableColumnSpecialVatAmount;

	private TableColumn tableColumnCumulativePrice;

	private TableColumn tableColumnTransactionDate;

	private InvBLSearchTransaction blSearch = new InvBLSearchTransaction();

	public InvUITransactionSearch(org.eclipse.swt.widgets.Composite parent,
			int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setSize(591, 344);
			{
				compInvTransactionSearch = new Composite(this, SWT.NONE);
				GridLayout composite1Layout = new GridLayout();
				composite1Layout.numColumns = 2;
				GridData composite1LData = new GridData();
				composite1LData.heightHint = 131;
				composite1LData.grabExcessHorizontalSpace = true;
				composite1LData.horizontalAlignment = GridData.FILL;
				compInvTransactionSearch.setLayoutData(composite1LData);
				compInvTransactionSearch.setLayout(composite1Layout);
				{
					lblInvCard = new Label(compInvTransactionSearch, SWT.NONE);
					lblInvCard.setText("Inventory Card");
				}
				{
					txtInvCard = new TextWithButton(compInvTransactionSearch, SWT.NONE);
					
					GridData textWithButton1LData = new GridData();
					txtInvCard.addMouseListener(new MouseAdapter() {
						public void mouseUp(MouseEvent evt) {
							inventoryCardChoose();
						}
					});
					textWithButton1LData.widthHint = 208;
					textWithButton1LData.heightHint = 20;
					txtInvCard.setLayoutData(textWithButton1LData);
				}
				{
					lblCurrentCard = new CLabel(
						compInvTransactionSearch,
						SWT.NONE);
					lblCurrentCard.setText("Current Card");
					GridData lblCurrentCardLData = new GridData();
					lblCurrentCardLData.widthHint = 109;
					lblCurrentCardLData.heightHint = 18;
					lblCurrentCard.setLayoutData(lblCurrentCardLData);
				}
				{
					txtCurCard = new TextWithButton(
						compInvTransactionSearch,
						SWT.NONE);
					GridData txtCurCardLData = new GridData();
					txtCurCard.addMouseListener(new MouseAdapter() {
						public void mouseUp(MouseEvent evt) {
							currentCardChoose();
						}
					});
					txtCurCardLData.widthHint = 208;
					txtCurCardLData.heightHint = 20;
					txtCurCard.setLayoutData(txtCurCardLData);
				}
				{
					lblStartDate = new CLabel(compInvTransactionSearch, SWT.NONE);
					lblStartDate.setText("Start Date");
					GridData lblStartDateLData = new GridData();
					lblStartDateLData.widthHint = 109;
					lblStartDateLData.heightHint = 17;
					lblStartDate.setLayoutData(lblStartDateLData);
				}
				{
					dateStartDate = new DatePicker(
						compInvTransactionSearch,
						SWT.NONE);
					GridData dateStartDateLData = new GridData();
					dateStartDateLData.widthHint = 141;
					dateStartDateLData.heightHint = 22;
					dateStartDate.setLayoutData(dateStartDateLData);
				}
				{
					lblEndDate = new CLabel(compInvTransactionSearch, SWT.NONE);
					lblEndDate.setText("End Date");
					GridData lblEndDateLData = new GridData();
					lblEndDateLData.widthHint = 105;
					lblEndDateLData.heightHint = 19;
					lblEndDate.setLayoutData(lblEndDateLData);
				}
				{
					dateEndDate = new DatePicker(
						compInvTransactionSearch,
						SWT.NONE);
					GridData dateEndDateLData = new GridData();
					dateEndDateLData.widthHint = 140;
					dateEndDateLData.heightHint = 22;
					dateEndDate.setLayoutData(dateEndDateLData);
				}
				{
					lblType = new CLabel(compInvTransactionSearch, SWT.NONE);
					lblType.setText("Type");
					GridData lblTypeLData = new GridData();
					lblTypeLData.widthHint = 74;
					lblTypeLData.heightHint = 21;
					lblType.setLayoutData(lblTypeLData);
				}
				{
					comboTransactionsType = new CCombo(compInvTransactionSearch, SWT.NONE);
					GridData comboConsignmentTypeLData = new GridData();
					comboTransactionsType.setText("Buy");
					comboConsignmentTypeLData.widthHint = 72;
					comboConsignmentTypeLData.heightHint = 14;
					comboTransactionsType
							.setLayoutData(comboConsignmentTypeLData);
				}
			}
			{
				tableTransactions = new Table(this, SWT.FULL_SELECTION);
				GridData tableConsignmentsLData = new GridData();
				
				tableTransactions.setHeaderVisible(true);
				tableTransactions.setLinesVisible(true);
				tableConsignmentsLData.grabExcessHorizontalSpace = true;
				tableConsignmentsLData.horizontalAlignment = GridData.FILL;
				tableConsignmentsLData.verticalAlignment = GridData.FILL;
				tableConsignmentsLData.grabExcessVerticalSpace = true;
				tableTransactions.setLayoutData(tableConsignmentsLData);
				{
					tableColumnTransactionDate = new TableColumn(
							tableTransactions, SWT.NONE);
					tableColumnTransactionDate.setText("Date");
					tableColumnTransactionDate.setWidth(104);
				}
				{
					tableColumnCurrentName = new TableColumn(tableTransactions,
							SWT.NONE);
					tableColumnCurrentName.setText("Current Name");
					tableColumnCurrentName.setWidth(150);
				}
				{
					tableColumnInventoryCode = new TableColumn(
						tableTransactions,
						SWT.NONE);
					tableColumnInventoryCode.setText("Inventory Card");
					tableColumnInventoryCode.setWidth(140);
				}
				{
					tableColumnCumulativePrice = new TableColumn(
							tableTransactions, SWT.NONE);
					tableColumnCumulativePrice.setText("Cumulative Price");
					tableColumnCumulativePrice.setWidth(100);
				}
				{
					tableColumnVatAmount = new TableColumn(tableTransactions,
							SWT.NONE);
					tableColumnVatAmount.setText("VAT amount");
					tableColumnVatAmount.setWidth(100);
				}
				{
					tableColumnSpecialVatAmount = new TableColumn(
							tableTransactions, SWT.NONE);
					tableColumnSpecialVatAmount.setText("Special VAT");
					tableColumnSpecialVatAmount.setWidth(100);
				}
			}
			postInitGui();
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void postInitGui() {
		comboTransactionsType.add("Buy");
		comboTransactionsType.add("Sell");
	}

	public void currentCardChoose() {
		Object data = new CurUICurrentCardSearchDialog(this.getShell(),
				SWT.NULL).open();
		if (data != null) {

			System.out.println(data.getClass().getName());
			TurqCurrentCard curCard = (TurqCurrentCard) data;
			txtCurCard.setText(curCard.getCardsCurrentCode() + " - "
					+ curCard.getCardsName());
			txtCurCard.setData(curCard);

		}

	}
	
	public void inventoryCardChoose() {
		Object data = new InvUICardSearchDialog(this.getShell(),
				SWT.NULL).open();
		if (data != null) {

			System.out.println(data.getClass().getName());
			TurqInventoryCard invCard = (TurqInventoryCard) data;
			txtInvCard.setText(invCard.getCardInventoryCode() + " - "
					+ invCard.getCardName());
			txtInvCard.setData(invCard);

		}
	}

	public void save() {

	}

	public void search() {

		try {

			tableTransactions.removeAll();
			int type = 0;
			if (comboTransactionsType.getText().equals("Sell")) {
				type = 1;
			}

			List list = blSearch.searchTransactions((TurqCurrentCard) txtCurCard
					.getData(),(TurqInventoryCard) txtInvCard.getData(), dateStartDate.getDate(), dateEndDate.getDate(),
					type);
			TurqInventoryTransaction transactions;
			TableItem item;
			for (int i = 0; i < list.size(); i++) {

				transactions = (TurqInventoryTransaction) list.get(i);
				item = new TableItem(tableTransactions, SWT.NULL);
				item.setData(transactions);
			
				Iterator it = transactions.getTurqEngineSequence().getTurqConsignments().iterator();
			
				TurqConsignment cons = null;
				
				if(it.hasNext()){
					cons = (TurqConsignment)it.next();
					
				}
				else{
					throw new Exception("Bu stok hareketi icin bir irsaliye olmasi gerekirdi.");
				}
				
				
				item.setText(new String[] {
								DatePicker.formatter.format(cons.getConsignmentsDate()),
							    cons.getTurqBillConsignmentCommon().getTurqCurrentCard().getCardsName(),
								transactions.getTurqInventoryCard().getCardName(),
								cons.getTurqBillConsignmentCommon().getTotalAmount().toString(),
								cons.getTurqBillConsignmentCommon().getVatAmount().toString(),
								cons.getTurqBillConsignmentCommon().getSpecialVatAmount()
										.toString() });

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void newForm() {

	}

	public void delete() {

	}

	public void exportToExcel() {

		EngBLUtils.Export2Excel(tableTransactions);

	}

}