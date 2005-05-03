package com.turquaz.cheque.ui;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Table;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.lang.CheLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
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

public class CheUIChequeCardDialog extends org.eclipse.swt.widgets.Dialog
{
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

	

	public CheUIChequeCardDialog(Shell parent, int style)
	{
		super(parent, style);
	}

	public void open()
	{
		try
		{
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL | SWT.RESIZE | SWT.MAX);
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
					tabItemChequeInfo.setText(CheLangKeys.STR_CHEQUE_INFO); //$NON-NLS-1$
					{
						compChequeInfo = new Composite(cTabFolder1, SWT.NONE);
						tabItemChequeInfo.setControl(compChequeInfo);
						GridLayout compChequeInfoLayout = new GridLayout();
						compChequeInfoLayout.numColumns = 2;
						compChequeInfo.setLayout(compChequeInfoLayout);
						{
							lblPortfoyNo = new CLabel(compChequeInfo, SWT.NONE);
							lblPortfoyNo.setText(CheLangKeys.STR_PORTFOLIO_NO); //$NON-NLS-1$
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
							lblDueDate.setText(CheLangKeys.STR_DUE_DATE); //$NON-NLS-1$
						}
						{
							datePicker = new DatePicker(compChequeInfo, SWT.NONE);
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
					tabItemChequeHistory.setText(CheLangKeys.STR_CHEQUE_HISTORY); //$NON-NLS-1$
					{
						table = new Table(cTabFolder1, SWT.NONE);
						tabItemChequeHistory.setControl(table);
						table.setHeaderVisible(true);
						table.setLinesVisible(true);
						{
							tableColumnDate = new TableColumn(table, SWT.NONE);
							tableColumnDate.setText(EngLangCommonKeys.STR_DATE); //$NON-NLS-1$
							tableColumnDate.setWidth(100);
						}
						{
							tableColumnRollNo = new TableColumn(table, SWT.NONE);
							tableColumnRollNo.setText(CheLangKeys.STR_ROLL_NO); //$NON-NLS-1$
							tableColumnRollNo.setWidth(100);
						}
						{
							tableColumnRollType = new TableColumn(table, SWT.NONE);
							tableColumnRollType.setText(CheLangKeys.STR_ROLL_TYPE); //$NON-NLS-1$
							tableColumnRollType.setWidth(100);
						}
						{
							tableColumnCurrentBankCode = new TableColumn(table, SWT.NONE);
							tableColumnCurrentBankCode.setWidth(113);
							tableColumnCurrentBankCode.setText(CheLangKeys.STR_BANK_CURRENT_CODE); //$NON-NLS-1$
						}
					}
				}
			}
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed())
			{
				if (!display.readAndDispatch())
					display.sleep();
			}
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getParent());
		}
	}
}