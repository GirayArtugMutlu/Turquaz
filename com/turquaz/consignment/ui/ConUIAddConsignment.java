package com.turquaz.consignment.ui;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.TableColumn;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.current.ui.CurUICurrentCardSearchDialog;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.ui.component.SecureComposite;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.graphics.Rectangle;
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
			this.setSize(731, 507);
			{
				compInfoPanel = new Composite(this, SWT.NONE);
				GridLayout compInfoPanelLayout = new GridLayout();
				GridData compInfoPanelLData = new GridData();
				compInfoPanelLData.horizontalSpan = 2;
				compInfoPanelLData.grabExcessHorizontalSpace = true;
				compInfoPanelLData.horizontalAlignment = GridData.FILL;
				compInfoPanelLData.heightHint = 165;
				compInfoPanel.setLayoutData(compInfoPanelLData);
				compInfoPanelLayout.numColumns = 4;
				compInfoPanel.setLayout(compInfoPanelLayout);
				{
					lblCurrentCard = new CLabel(compInfoPanel, SWT.NONE);
					lblCurrentCard.setText("Current Card");
					GridData lblCurrentCardLData1 = new GridData();
					lblCurrentCardLData1.widthHint = 88;
					lblCurrentCardLData1.heightHint = 19;
					lblCurrentCard.setLayoutData(lblCurrentCardLData1);
				}
				{
					txtCurrentCard = new Text(compInfoPanel, SWT.NONE);
					GridData txtCurrentCardLData = new GridData();
					txtCurrentCard.setBackground(SWTResourceManager.getColor(255,255, 255));
					txtCurrentCard.setEditable(false);
					txtCurrentCardLData.widthHint = 346;
					txtCurrentCardLData.heightHint = 18;
					txtCurrentCard.setLayoutData(txtCurrentCardLData);
				}
				{
					btnChooseCurrentCard = new Button(compInfoPanel, SWT.PUSH | SWT.CENTER);
					btnChooseCurrentCard.setText("Choose");
					GridData button1LData = new GridData();
					btnChooseCurrentCard.addMouseListener(new MouseAdapter() {
						public void mouseUp(MouseEvent evt) {
							
							btnChooseMouseUp();
							
							
							
						}
					});
					button1LData.widthHint = 56;
					button1LData.heightHint = 23;
					btnChooseCurrentCard.setLayoutData(button1LData);
				}
			}
			{
				compbuttons = new Composite(this, SWT.NONE);
				GridLayout composite1Layout = new GridLayout();
				GridData composite1LData = new GridData();
				composite1LData.widthHint = 43;
				composite1LData.heightHint = 81;
				composite1LData.verticalAlignment = GridData.BEGINNING;
				compbuttons.setLayoutData(composite1LData);
				composite1Layout.makeColumnsEqualWidth = true;
				compbuttons.setLayout(composite1Layout);
				{
					btnAddConsignmentRow = new Button(compbuttons, SWT.PUSH
						| SWT.CENTER);
					btnAddConsignmentRow.setImage(SWTResourceManager.getImage("icons/plus.gif"));
				}
				{
					buttonConsignmentRemove = new Button(compbuttons, SWT.PUSH
						| SWT.CENTER);
					buttonConsignmentRemove.setImage(SWTResourceManager.getImage("icons/minus.gif"));
				}
			}
			{
				tableConsignmentRows = new Table(this, SWT.BORDER);
				GridData tableConsignmentRowsLData = new GridData();
				tableConsignmentRows.setLinesVisible(true);
				tableConsignmentRows.setHeaderVisible(true);
				tableConsignmentRowsLData.grabExcessHorizontalSpace = true;
				tableConsignmentRowsLData.grabExcessVerticalSpace = true;
				tableConsignmentRowsLData.horizontalAlignment = GridData.FILL;
				tableConsignmentRowsLData.verticalAlignment = GridData.FILL;
				tableConsignmentRows.setLayoutData(tableConsignmentRowsLData);
				{
					tableColumnInventoryCode = new TableColumn(
						tableConsignmentRows,
						SWT.NONE);
					tableColumnInventoryCode.setText("Inventory Code");
					tableColumnInventoryCode.setWidth(98);
				}
				{
					tableColumnInventoryName = new TableColumn(
						tableConsignmentRows,
						SWT.NONE);
					tableColumnInventoryName.setText("Inventory Name");
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
					TableColumnVATSpecial = new TableColumn(tableConsignmentRows, SWT.NONE);
					TableColumnVATSpecial.setText("Special VAT");
					TableColumnVATSpecial.setWidth(100);
				}
			}
			{
				compTotalsPanel = new Composite(this, SWT.NONE);
				GridLayout composite1Layout1 = new GridLayout();
				GridData composite1LData1 = new GridData();
				composite1LData1.grabExcessHorizontalSpace = true;
				composite1LData1.horizontalSpan = 2;
				composite1LData1.horizontalAlignment = GridData.FILL;
				composite1LData1.heightHint = 118;
				compTotalsPanel.setLayoutData(composite1LData1);
				composite1Layout1.makeColumnsEqualWidth = true;
				compTotalsPanel.setLayout(composite1Layout1);
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
