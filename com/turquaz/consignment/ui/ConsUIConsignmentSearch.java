package com.turquaz.consignment.ui;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import com.turquaz.engine.ui.component.TextWithButton;
import com.turquaz.engine.ui.component.DatePicker;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;

import com.turquaz.engine.ui.component.SecureComposite;


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
public class ConsUIConsignmentSearch extends org.eclipse.swt.widgets.Composite implements
SecureComposite{
	private Composite composite1;
	private Table tableConsignments;
	private TableColumn tableColumnCurrentName;
	private TableColumn tableColumnVatAmount;
	private TextWithButton txtCurCard;
	private CLabel lblEndDate;
	private DatePicker dateEndDate;
	private DatePicker dateStartDate;
	private CLabel lblStartDate;
	private CLabel lblCurrentCard;
	private TableColumn tableColumnSpecialVatAmount;
	private TableColumn tableColumnCumulativePrice;
	private TableColumn tableColumnConsignmentDate;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void main(String[] args) {
		showGUI();
	}
		
	/**
	* Auto-generated method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void showGUI() {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		ConsUIConsignmentSearch inst = new ConsUIConsignmentSearch(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if(size.x == 0 && size.y == 0) {
			inst.pack();
			shell.pack();
		} else {
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			int MENU_HEIGHT = 22;
			if (shell.getMenuBar() != null)
				shellBounds.height -= MENU_HEIGHT;
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public ConsUIConsignmentSearch(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setSize(591, 344);
			{
				composite1 = new Composite(this, SWT.NONE);
				GridLayout composite1Layout = new GridLayout();
				composite1Layout.numColumns = 2;
				GridData composite1LData = new GridData();
				composite1LData.heightHint = 120;
				composite1LData.grabExcessHorizontalSpace = true;
				composite1LData.horizontalAlignment = GridData.FILL;
				composite1.setLayoutData(composite1LData);
				composite1.setLayout(composite1Layout);
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
			}
			{
				tableConsignments = new Table(this, SWT.FULL_SELECTION);
				GridData tableConsignmentsLData = new GridData();
				tableConsignments.setHeaderVisible(true);
				tableConsignments.setLinesVisible(true);
				tableConsignmentsLData.grabExcessHorizontalSpace = true;
				tableConsignmentsLData.horizontalAlignment = GridData.FILL;
				tableConsignmentsLData.verticalAlignment = GridData.FILL;
				tableConsignmentsLData.grabExcessVerticalSpace = true;
				tableConsignments.setLayoutData(tableConsignmentsLData);
				{
					tableColumnConsignmentDate = new TableColumn(
						tableConsignments,
						SWT.NONE);
					tableColumnConsignmentDate.setText("Date");
					tableColumnConsignmentDate.setWidth(100);
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
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void save(){
		
	}
	public void search(){
		
	}
	public void newForm(){
		
	}
	public void delete(){
		
	}

}
