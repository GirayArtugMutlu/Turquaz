package com.turquaz.consignment.ui;


import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CCombo;

import com.turquaz.consignment.bl.ConBLSearchConsignment;
import com.turquaz.current.ui.CurUICurrentCardSearchDialog;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.ui.component.DatePicker;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseAdapter;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import com.turquaz.engine.ui.component.TextWithButton;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
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
public class ConUIConsignmentSearchDialog extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private Composite composite1;
	private TextWithButton txtCurCard;
	private Button btnSearch;
	private Label lblSeperator;
	private TableColumn tableColumnSpecialVatAmount;
	private TableColumn tableColumnVatAmount;
	private TableColumn tableColumnCumulativePrice;
	private CLabel lblEndDate;
	private TableColumn tableColumnCurrentName;
	private TableColumn tableColumnConsignmentDate;
	private Table tableConsignments;
	private CCombo comboConsignmentType;
	private CLabel lblType;
	private DatePicker dateEndDate;
	private DatePicker dateStartDate;
	private CLabel lblStartDate;
	private CLabel lblCurrentCard;
	private TurqConsignment cons =null;
	private ConBLSearchConsignment blSearch = new ConBLSearchConsignment();

	

	public ConUIConsignmentSearchDialog(Shell parent, int style) {
		super(parent, style);
	}

	public TurqConsignment open() {
		try {
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

				{
					//Register as a resource user - SWTResourceManager will
					//handle the obtaining and disposing of resources
					SWTResourceManager.registerResourceUser(dialogShell);
				}


			dialogShell.setLayout(new GridLayout());
			dialogShell.layout();
			dialogShell.pack();
			dialogShell.setSize(587, 323);
			{
				composite1 = new Composite(dialogShell, SWT.NONE);
				GridLayout composite1Layout = new GridLayout();
				composite1Layout.numColumns = 2;
				GridData composite1LData = new GridData();
				composite1.setLayout(composite1Layout);
				composite1LData.horizontalAlignment = GridData.FILL;
				composite1LData.heightHint = 158;
				composite1LData.grabExcessHorizontalSpace = true;
				composite1.setLayoutData(composite1LData);
				{
					lblCurrentCard = new CLabel(composite1, SWT.NONE);
					lblCurrentCard.setText("CurrentCard");
					GridData lblCurrentCardLData = new GridData();
					lblCurrentCardLData.widthHint = 109;
					lblCurrentCardLData.heightHint = 18;
					lblCurrentCard.setLayoutData(lblCurrentCardLData);
				}
				{
					txtCurCard = new TextWithButton(composite1, SWT.NONE);
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
					lblStartDate = new CLabel(composite1, SWT.NONE);
					lblStartDate.setText("Start Date");
					GridData lblStartDateLData = new GridData();
					lblStartDateLData.widthHint = 109;
					lblStartDateLData.heightHint = 17;
					lblStartDate.setLayoutData(lblStartDateLData);
				}
				{
					dateStartDate = new DatePicker(composite1, SWT.NONE);
					GridData dateStartDateLData = new GridData();
					dateStartDateLData.widthHint = 141;
					dateStartDateLData.heightHint = 22;
					dateStartDate.setLayoutData(dateStartDateLData);
				}
				{
					lblEndDate = new CLabel(composite1, SWT.NONE);
					lblEndDate.setText("End Date");
					GridData lblEndDateLData = new GridData();
					lblEndDateLData.widthHint = 105;
					lblEndDateLData.heightHint = 19;
					lblEndDate.setLayoutData(lblEndDateLData);
				}
				{
					dateEndDate = new DatePicker(composite1, SWT.NONE);
					GridData dateEndDateLData = new GridData();
					dateEndDateLData.widthHint = 140;
					dateEndDateLData.heightHint = 22;
					dateEndDate.setLayoutData(dateEndDateLData);
				}
				{
					lblType = new CLabel(composite1, SWT.NONE);
					lblType.setText("Type");
					GridData lblTypeLData = new GridData();
					lblTypeLData.widthHint = 74;
					lblTypeLData.heightHint = 21;
					lblType.setLayoutData(lblTypeLData);
				}
				{
					comboConsignmentType = new CCombo(composite1, SWT.NONE);
					comboConsignmentType.setText("Buy");
					GridData comboConsignmentTypeLData = new GridData();
					comboConsignmentTypeLData.widthHint = 72;
					comboConsignmentTypeLData.heightHint = 14;
					comboConsignmentType
						.setLayoutData(comboConsignmentTypeLData);
				}
				{
					lblSeperator = new Label(composite1, SWT.SEPARATOR | SWT.HORIZONTAL);
					GridData lblSeperatorLData = new GridData();
					lblSeperatorLData.horizontalAlignment = GridData.FILL;
					lblSeperatorLData.grabExcessHorizontalSpace = true;
					lblSeperatorLData.horizontalSpan = 2;
					lblSeperator.setLayoutData(lblSeperatorLData);
				}
				{
					btnSearch = new Button(composite1, SWT.PUSH | SWT.CENTER);
					btnSearch.setImage(SWTResourceManager.getImage("icons/Find24.gif"));
					GridData btnSearchLData = new GridData();
					btnSearch.addMouseListener(new MouseAdapter() {
						public void mouseUp(MouseEvent evt) {
						search();	
						}
					});
					btnSearchLData.widthHint = 62;
					btnSearchLData.heightHint = 30;
					btnSearch.setLayoutData(btnSearchLData);
				}
			}
			{
				tableConsignments = new Table(dialogShell, SWT.FULL_SELECTION);
				tableConsignments.setHeaderVisible(true);
				tableConsignments.setLinesVisible(true);
				GridData tableConsignmentsLData = new GridData();
				tableConsignments.addMouseListener(new MouseAdapter() {
					public void mouseDoubleClick(MouseEvent evt) {
						tableDoubleMouseClick();
					}
				});
				tableConsignmentsLData.verticalAlignment = GridData.FILL;
				tableConsignmentsLData.horizontalAlignment = GridData.FILL;
				tableConsignmentsLData.grabExcessHorizontalSpace = true;
				tableConsignmentsLData.grabExcessVerticalSpace = true;
				tableConsignments.setLayoutData(tableConsignmentsLData);
				{
					tableColumnConsignmentDate = new TableColumn(
						tableConsignments,
						SWT.NONE);
					tableColumnConsignmentDate.setText("Date");
					tableColumnConsignmentDate.setWidth(104);
				}
				{
					tableColumnCurrentName = new TableColumn(
						tableConsignments,
						SWT.NONE);
					tableColumnCurrentName.setText("Current Name");
					tableColumnCurrentName.setWidth(150);
				}
				{
					tableColumnCumulativePrice = new TableColumn(
						tableConsignments,
						SWT.NONE);
					tableColumnCumulativePrice.setText("Cumulative Price");
					tableColumnCumulativePrice.setWidth(100);
				}
				{
					tableColumnVatAmount = new TableColumn(
						tableConsignments,
						SWT.NONE);
					tableColumnVatAmount.setText("VAT amount");
					tableColumnVatAmount.setWidth(100);
				}
				{
					tableColumnSpecialVatAmount = new TableColumn(
						tableConsignments,
						SWT.NONE);
					tableColumnSpecialVatAmount.setText("Special VAT");
					tableColumnSpecialVatAmount.setWidth(100);
				}
			}
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
			return cons;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void currentCardChoose(){
		Object data = new CurUICurrentCardSearchDialog(this.getParent(),SWT.NULL).open();
	    if(data!=null){
	    
	    System.out.println(data.getClass().getName());
		TurqCurrentCard curCard = (TurqCurrentCard)data;
	    txtCurCard.setText(curCard.getCardsCurrentCode()+" - "+curCard.getCardsName());
		txtCurCard.setData(curCard);
		
	    }
		
	}
	public void tableDoubleMouseClick(){
		
		TableItem items[] =tableConsignments.getSelection();
		if(items.length>0){
			cons = (TurqConsignment)items[0].getData();
			dialogShell.close();
		}
		
	}
	public void search(){
		
		try{
			
		tableConsignments.removeAll();	
		int type=0;
		if(comboConsignmentType.getText().equals("Sell"))
		{
			type =1;
		}
			
		List list = blSearch.chooseConsignment((TurqCurrentCard)txtCurCard.getData(),
												dateStartDate.getDate(),
												dateEndDate.getDate(),type);
		TurqConsignment cons;
		TableItem item;
		for(int i=0;i<list.size();i++){
			
			cons = (TurqConsignment)list.get(i);
			item = new TableItem(tableConsignments,SWT.NULL);
			item.setData(cons);
			item.setText(new String[]{DatePicker.formatter.format(cons.getConsignmentsDate()),
									cons.getTurqCurrentCard().getCardsName(),
									cons.getConsignmentsTotalAmount().toString(),
									cons.getConsignmentsVatAmount().toString(),
									cons.getConsignmentsSpecialVatAmount().toString()});
			
		}
			
			
			
			
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		
		
	}
	
}
