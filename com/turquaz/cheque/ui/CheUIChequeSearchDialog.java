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
import com.turquaz.current.ui.comp.CurrentPicker;
import org.eclipse.swt.widgets.Label;
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
public class CheUIChequeSearchDialog extends org.eclipse.swt.widgets.Composite {

    {
        //Register as a resource user - SWTResourceManager will
        //handle the obtaining and disposing of resources
        SWTResourceManager.registerResourceUser(this);
    }

	private Composite compSearchPanle;
	private Table tableCheques;
	private Text txtPortFoyNo;
	private CCombo comboStatus;
	private CLabel lblStaus;
	private TableColumn tableColumnStatus;
	private DatePicker datePicker;
	private CLabel lblDueDate;
	private CurrentPicker currentPicker;
	private Label lblCurrentCard;
	private TableColumn tableColumnAmount;
	private TableColumn tableColumnDueDate;
	private CLabel lblPortfoyNo;
	private TableColumn tableColumnEntryDate;
	private TableColumn tableColumnChequeNo;

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
		CheUIChequeSearchDialog inst = new CheUIChequeSearchDialog(shell, SWT.NULL);
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

	public CheUIChequeSearchDialog(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setBackground(SWTResourceManager.getColor(255, 255, 255));
			this.setSize(625, 411);
            {
                compSearchPanle = new Composite(this, SWT.NONE);
                GridLayout compSearchPanleLayout = new GridLayout();
                GridData compSearchPanleLData = new GridData();
                compSearchPanleLData.heightHint = 90;
                compSearchPanleLData.grabExcessHorizontalSpace = true;
                compSearchPanleLData.horizontalAlignment = GridData.FILL;
                compSearchPanle.setLayoutData(compSearchPanleLData);
                compSearchPanleLayout.numColumns = 4;
                compSearchPanle.setLayout(compSearchPanleLayout);
                {
                    lblPortfoyNo = new CLabel(compSearchPanle, SWT.NONE);
                    lblPortfoyNo.setText("PortFöy No");
                }
                {
                    txtPortFoyNo = new Text(compSearchPanle, SWT.NONE);
                    GridData txtPortFoyNoLData = new GridData();
                    txtPortFoyNoLData.widthHint = 154;
                    txtPortFoyNoLData.heightHint = 16;
                    txtPortFoyNo.setLayoutData(txtPortFoyNoLData);
                }
                {
                    lblCurrentCard = new Label(compSearchPanle, SWT.NONE);
                    lblCurrentCard.setText("Cari Kart");
                }
                {
                    currentPicker = new CurrentPicker(compSearchPanle, SWT.NONE);
                    GridData currentPickerLData = new GridData();
                    currentPickerLData.widthHint = 158;
                    currentPickerLData.heightHint = 16;
                    currentPicker.setLayoutData(currentPickerLData);
                }
                {
                    lblDueDate = new CLabel(compSearchPanle, SWT.NONE);
                    lblDueDate.setText("Vade Tarihi");
                }
                {
                    datePicker = new DatePicker(compSearchPanle, SWT.NONE);
                    GridData datePickerLData = new GridData();
                    datePickerLData.widthHint = 110;
                    datePickerLData.heightHint = 22;
                    datePicker.setLayoutData(datePickerLData);
                }
                {
                    lblStaus = new CLabel(compSearchPanle, SWT.NONE);
                    lblStaus.setText("Durumu");
                }
                {
                    comboStatus = new CCombo(compSearchPanle, SWT.NONE);
                    GridData comboStatusLData = new GridData();
                    comboStatusLData.widthHint = 89;
                    comboStatusLData.heightHint = 17;
                    comboStatus.setLayoutData(comboStatusLData);
                }
            }
            {
                tableCheques = new Table(this, SWT.NONE);
                GridData tableChequesLData = new GridData();
                tableCheques.setLinesVisible(true);
                tableCheques.setHeaderVisible(true);
                tableChequesLData.horizontalAlignment = GridData.FILL;
                tableChequesLData.grabExcessHorizontalSpace = true;
                tableChequesLData.grabExcessVerticalSpace = true;
                tableChequesLData.verticalAlignment = GridData.FILL;
                tableCheques.setLayoutData(tableChequesLData);
                {
                    tableColumnChequeNo = new TableColumn(
                        tableCheques,
                        SWT.NONE);
                    tableColumnChequeNo.setText("Portföy No");
                    tableColumnChequeNo.setWidth(70);
                }
                {
                    tableColumnEntryDate = new TableColumn(
                        tableCheques,
                        SWT.NONE);
                    tableColumnEntryDate.setText("Giri? Tarihi");
                    tableColumnEntryDate.setWidth(100);
                }
                {
                    tableColumnDueDate = new TableColumn(tableCheques, SWT.NONE);
                    tableColumnDueDate.setText("Vade Tarihi");
                    tableColumnDueDate.setWidth(89);
                }
                {
                    tableColumnAmount = new TableColumn(tableCheques, SWT.NONE);
                    tableColumnAmount.setText("Tutar");
                    tableColumnAmount.setWidth(100);
                }
                {
                    tableColumnStatus = new TableColumn(tableCheques, SWT.NONE);
                    tableColumnStatus.setText("Durumu");
                    tableColumnStatus.setWidth(100);
                }
            }
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
