package com.turquaz.cheque.ui;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.custom.CCombo;
import com.turquaz.engine.ui.component.DatePicker;
import org.eclipse.swt.widgets.Text;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.layout.GridData;
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
public class CheUIChequeRollSearch extends org.eclipse.swt.widgets.Composite {

    {
        //Register as a resource user - SWTResourceManager will
        //handle the obtaining and disposing of resources
        SWTResourceManager.registerResourceUser(this);
    }

	private Composite compSearchPanel;
	private Table tableChequeRolls;
	private TableColumn tableColumnDate;
	private CLabel lblEndDate;
	private CLabel lblType;
	private CCombo comboRollType;
	private DatePicker dateEndDate;
	private DatePicker datePicker1;
	private CLabel dateStartDate;
	private Text txtRollNo;
	private CLabel lblRollNo;
	private TableColumn tableColumnOwner;
	private TableColumn tableColumnType;
	private TableColumn tableColumnRolNo;

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
		CheUIChequeRollSearch inst = new CheUIChequeRollSearch(shell, SWT.NULL);
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

	public CheUIChequeRollSearch(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setBackground(SWTResourceManager.getColor(255, 255, 255));
			this.setSize(663, 336);
            {
                compSearchPanel = new Composite(this, SWT.NONE);
                GridLayout compSearchPanelLayout = new GridLayout();
                GridData compSearchPanelLData = new GridData();
                compSearchPanelLData.grabExcessHorizontalSpace = true;
                compSearchPanelLData.horizontalAlignment = GridData.FILL;
                compSearchPanelLData.heightHint = 121;
                compSearchPanel.setLayoutData(compSearchPanelLData);
                compSearchPanelLayout.numColumns = 2;
                compSearchPanel.setLayout(compSearchPanelLayout);
                {
                    lblRollNo = new CLabel(compSearchPanel, SWT.NONE);
                    lblRollNo.setText("Bordro No");
                }
                {
                    txtRollNo = new Text(compSearchPanel, SWT.NONE);
                    GridData txtRollNoLData = new GridData();
                    txtRollNoLData.widthHint = 110;
                    txtRollNoLData.heightHint = 15;
                    txtRollNo.setLayoutData(txtRollNoLData);
                }
                {
                    dateStartDate = new CLabel(compSearchPanel, SWT.NONE);
                    dateStartDate.setText("Ba?lang?ç Tarihi");
                }
                {
                    datePicker1 = new DatePicker(compSearchPanel, SWT.NONE);
                    GridData datePicker1LData = new GridData();
                    datePicker1LData.widthHint = 116;
                    datePicker1LData.heightHint = 22;
                    datePicker1.setLayoutData(datePicker1LData);
                }
                {
                    lblEndDate = new CLabel(compSearchPanel, SWT.NONE);
                    lblEndDate.setText("Biti? Tarihi");
                }
                {
                    dateEndDate = new DatePicker(compSearchPanel, SWT.NONE);
                    GridData dateEndDateLData = new GridData();
                    dateEndDateLData.widthHint = 115;
                    dateEndDateLData.heightHint = 20;
                    dateEndDate.setLayoutData(dateEndDateLData);
                }
                {
                    lblType = new CLabel(compSearchPanel, SWT.NONE);
                    lblType.setText("Bordro Tipi");
                }
                {
                    comboRollType = new CCombo(compSearchPanel, SWT.NONE);
                    GridData comboRollTypeLData = new GridData();
                    comboRollType.setText("Hepsi");
                    comboRollTypeLData.widthHint = 92;
                    comboRollTypeLData.heightHint = 14;
                    comboRollType.setLayoutData(comboRollTypeLData);
                }
            }
            {
                tableChequeRolls = new Table(this, SWT.NONE);
                GridData tableChequeRollsLData = new GridData();
                tableChequeRolls.setLinesVisible(true);
                tableChequeRolls.setHeaderVisible(true);
                tableChequeRollsLData.grabExcessHorizontalSpace = true;
                tableChequeRollsLData.horizontalAlignment = GridData.FILL;
                tableChequeRollsLData.grabExcessVerticalSpace = true;
                tableChequeRollsLData.verticalAlignment = GridData.FILL;
                tableChequeRolls.setLayoutData(tableChequeRollsLData);
                {
                    tableColumnDate = new TableColumn(
                        tableChequeRolls,
                        SWT.NONE);
                    tableColumnDate.setText("Tarih");
                    tableColumnDate.setWidth(76);
                }
                {
                    tableColumnRolNo = new TableColumn(
                        tableChequeRolls,
                        SWT.NONE);
                    tableColumnRolNo.setText("Bordro No");
                    tableColumnRolNo.setWidth(88);
                }
                {
                    tableColumnType = new TableColumn(tableChequeRolls, SWT.NONE);
                    tableColumnType.setText("Bordro Tipi");
                    tableColumnType.setWidth(75);
                }
                {
                    tableColumnOwner = new TableColumn(
                        tableChequeRolls,
                        SWT.NONE);
                    tableColumnOwner.setText("Bordro Sahibi");
                    tableColumnOwner.setWidth(101);
                }
            }
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
