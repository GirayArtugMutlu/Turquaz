package com.turquaz.cheque.ui;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Table;
import com.turquaz.engine.ui.component.CurrencyText;
import com.turquaz.engine.ui.component.DatePicker;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.custom.CTabItem;
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
public class CheUIChequeCardDialog extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private CTabItem tabItemChequeHistory;
	private Table table;
	private CurrencyText curText;
	private CLabel lblAmount;
	private Text txtPaymentPlace;
	private CLabel lblPaymentPlace;
	private Text txtDeptor;
	private CLabel lblDeptor;
	private Text txtBankBranch;
	private CLabel lblBankBranch;
	private Text txtBankName;
	private CLabel lblBankName;
	private Text txtChequeNo;
	private CLabel lblChequeNo;
	private DatePicker datePicker;
	private CLabel lblDueDate;
	private Text txtPortfoyNo;
	private CLabel lblPortfoyNo;
	private Composite compChequeInfo;
	private TableColumn tableColumnCurrentBankCode;
	private TableColumn tableColumnRollType;
	private TableColumn tableColumnRollNo;
	private TableColumn tableColumnDate;
	private CTabItem tabItemChequeInfo;
	private CTabFolder cTabFolder1;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/
	public static void main(String[] args) {
		try {
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			CheUIChequeCardDialog inst = new CheUIChequeCardDialog(shell, SWT.NULL);
			inst.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CheUIChequeCardDialog(Shell parent, int style) {
		super(parent, style);
	}

	public void open() {
		try {
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

			dialogShell.setLayout(new GridLayout());
			dialogShell.layout();
			dialogShell.pack();
			dialogShell.setSize(602, 625);
            {
                cTabFolder1 = new CTabFolder(dialogShell, SWT.NONE);
                cTabFolder1.setSelection(null);
                cTabFolder1.setSize(56, 25);
                GridData cTabFolder1LData = new GridData();
                cTabFolder1LData.grabExcessHorizontalSpace = true;
                cTabFolder1LData.grabExcessVerticalSpace = true;
                cTabFolder1LData.horizontalAlignment = GridData.FILL;
                cTabFolder1LData.verticalAlignment = GridData.FILL;
                cTabFolder1.setLayoutData(cTabFolder1LData);
                {
                    tabItemChequeInfo = new CTabItem(cTabFolder1, SWT.NONE);
                    tabItemChequeInfo.setText("�ek Bilgileri");
                    {
                        compChequeInfo = new Composite(cTabFolder1, SWT.NONE);
                        tabItemChequeInfo.setControl(compChequeInfo);
                        GridLayout compChequeInfoLayout = new GridLayout();
                        compChequeInfoLayout.numColumns = 2;
                        compChequeInfo.setLayout(compChequeInfoLayout);
                        {
                            lblPortfoyNo = new CLabel(compChequeInfo, SWT.NONE);
                            lblPortfoyNo.setText("Portf�y No");
                        }
                        {
                            txtPortfoyNo = new Text(compChequeInfo, SWT.NONE);
                            GridData txtPortfoyNoLData = new GridData();
                            txtPortfoyNoLData.widthHint = 151;
                            txtPortfoyNoLData.heightHint = 16;
                            txtPortfoyNo.setLayoutData(txtPortfoyNoLData);
                        }
                        {
                            lblDueDate = new CLabel(compChequeInfo, SWT.NONE);
                            lblDueDate.setText("Vade Tarihi");
                        }
                        {
                            datePicker = new DatePicker(
                                compChequeInfo,
                                SWT.NONE);
                            GridData datePickerLData = new GridData();
                            datePickerLData.widthHint = 132;
                            datePickerLData.heightHint = 19;
                            datePicker.setLayoutData(datePickerLData);
                        }
                        {
                            lblChequeNo = new CLabel(compChequeInfo, SWT.NONE);
                        }
                        {
                            txtChequeNo = new Text(compChequeInfo, SWT.NONE);
                        }
                        {
                            lblBankName = new CLabel(compChequeInfo, SWT.NONE);
                        }
                        {
                            txtBankName = new Text(compChequeInfo, SWT.NONE);
                        }
                        {
                            lblBankBranch = new CLabel(compChequeInfo, SWT.NONE);
                        }
                        {
                            txtBankBranch = new Text(compChequeInfo, SWT.NONE);
                        }
                        {
                            lblDeptor = new CLabel(compChequeInfo, SWT.NONE);
                        }
                        {
                            txtDeptor = new Text(compChequeInfo, SWT.NONE);
                        }
                        {
                            lblPaymentPlace = new CLabel(compChequeInfo, SWT.NONE);
                        }
                        {
                            txtPaymentPlace = new Text(compChequeInfo, SWT.NONE);
                        }
                        {
                            lblAmount = new CLabel(compChequeInfo, SWT.NONE);
                        }
                        {
                            curText = new CurrencyText(compChequeInfo, SWT.NONE);
                        }
                    }
                }
                {
                    tabItemChequeHistory = new CTabItem(cTabFolder1, SWT.NONE);
                    tabItemChequeHistory.setText("Tarih�e");
                    {
                        table = new Table(cTabFolder1, SWT.NONE);
                        tabItemChequeHistory.setControl(table);
                        table.setHeaderVisible(true);
                        table.setLinesVisible(true);
                        {
                            tableColumnDate = new TableColumn(table, SWT.NONE);
                            tableColumnDate.setText("Tarih");
                            tableColumnDate.setWidth(100);
                        }
                        {
                            tableColumnRollNo = new TableColumn(table, SWT.NONE);
                            tableColumnRollNo.setText("Bordro NO");
                            tableColumnRollNo.setWidth(100);
                        }
                        {
                            tableColumnRollType = new TableColumn(
                                table,
                                SWT.NONE);
                            tableColumnRollType.setText("Bordro Tipi");
                            tableColumnRollType.setWidth(100);
                        }
                        {
                            tableColumnCurrentBankCode = new TableColumn(
                                table,
                                SWT.NONE);
                            tableColumnCurrentBankCode.setWidth(113);
                            tableColumnCurrentBankCode.setText("Cari/Banka Kodu");
                        }
                    }
                }
            }
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
