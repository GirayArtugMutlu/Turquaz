package com.turquaz.accounting.ui.reports;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JasperManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
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
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;

import com.turquaz.accounting.Messages;
import com.turquaz.engine.dal.EngDALConnection;
import com.turquaz.engine.dal.TurqCompany;
import com.turquaz.engine.ui.component.DatePicker;
import org.eclipse.swt.layout.GridData;
public class AccUIAccountingGeneralLedger extends org.eclipse.swt.widgets.Composite {
	private CLabel lblDateRange;
	private DatePicker datePickerBeginDate;
	private DatePicker datePickerEndDate;
	private CLabel lblDummy;
	private Button btnShow;

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
		AccUIAccountingGeneralLedger inst = new AccUIAccountingGeneralLedger(shell, SWT.NULL);
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

	public AccUIAccountingGeneralLedger(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 3;
			thisLayout.makeColumnsEqualWidth = true;
			this.setSize(477, 200);
			{
				lblDateRange = new CLabel(this, SWT.NONE);
				lblDateRange.setText(Messages.getString("AccUIAccountingGeneralLedger.0")); //$NON-NLS-1$
			}
			{
				datePickerBeginDate = new DatePicker(this, SWT.NONE);
			}
			{
				datePickerEndDate = new DatePicker(this, SWT.NONE);
			}
			{
				lblDummy = new CLabel(this, SWT.NONE);
				GridData lblDummyLData = new GridData();
				lblDummyLData.horizontalSpan = 2;
				lblDummy.setLayoutData(lblDummyLData);
			}
			{
				btnShow = new Button(this, SWT.PUSH | SWT.CENTER);
				btnShow.setText(Messages.getString("AccUIAccountingGeneralLedger.1")); //$NON-NLS-1$
				GridData btnShowLData = new GridData();
				btnShow.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent evt) {
						btnShowSingleClick();
					}
				});
				btnShowLData.widthHint = 96;
				btnShowLData.heightHint = 23;
				btnShow.setLayoutData(btnShowLData);
			}
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void btnShowSingleClick(){
		try{
			
			Map parameters = new HashMap();
			TurqCompany company = new TurqCompany();
			company.setCompaniesId(Integer.valueOf(System.getProperty("company"))); //$NON-NLS-1$
			String sqlparam="Select accounts.top_account,accounts.account_name," + //$NON-NLS-1$
					" trans.transactions_date,trans.transaction_document_no," + //$NON-NLS-1$
					" transcolumns.dept_amount, transcolumns.credit_amount," + //$NON-NLS-1$
					" trans.accounting_journal_id, accounts.accounting_accounts_id" + //$NON-NLS-1$
					" from turq_accounting_accounts accounts, turq_accounting_transactions trans," + //$NON-NLS-1$
					" turq_accounting_transaction_columns transcolumns where" + //$NON-NLS-1$
					" accounts.accounting_accounts_id=transcolumns.accounting_accounts_id" + //$NON-NLS-1$
					" and transcolumns.accounting_transactions_id=trans.accounting_transactions_id" + //$NON-NLS-1$
					" and accounts.companies_id="+company.getCompaniesId().toString(); //$NON-NLS-1$
			SimpleDateFormat dformat=new SimpleDateFormat("yyyy-MM-dd"); //$NON-NLS-1$
			sqlparam +=" and trans.transactions_date >= '"+ dformat.format(datePickerBeginDate.getDate())+"'" //$NON-NLS-1$ //$NON-NLS-2$
					+" and trans.transactions_date <= '"+dformat.format(datePickerEndDate.getDate())+"'"; //$NON-NLS-1$ //$NON-NLS-2$
			//String sqlparam2=sqlparam;
			//String sqlparam3=sqlparam;
			//sqlparam3 +=" and transcolumns.dept_amount > 0";
			//sqlparam2 +=" and transcolumns.credit_amount >0";
			sqlparam +=" ORDER BY accounts.top_account,trans.transactions_date"; //$NON-NLS-1$
			//sqlparam3 +=" ORDER BY accounts.top_account,trans.transactions_date";
			//sqlparam2 +=" ORDER BY accounts.top_account,trans.transactions_date";
			SimpleDateFormat dformat2=new SimpleDateFormat("dd-MM-yyyy"); //$NON-NLS-1$
			//System.out.println(sqlparam);
			
			parameters.put("sqlparam",sqlparam);	 //$NON-NLS-1$
			//parameters.put("sqlparam2",sqlparam2);
			//parameters.put("sqlparam3",sqlparam3);
			parameters.put("beginDate",dformat2.format(datePickerBeginDate.getDate())); //$NON-NLS-1$
			parameters.put("endDate",dformat2.format(datePickerEndDate.getDate())); //$NON-NLS-1$
			NumberFormat formatter =NumberFormat.getNumberInstance();
            formatter.setMaximumFractionDigits(2);
            parameters.put("formatter",formatter); //$NON-NLS-1$
			EngDALConnection db=new EngDALConnection();
			db.connect();
			JasperReport jasperReport = JasperManager.loadReport("reports/accounting/AccountingGeneralLedger.jasper"); //$NON-NLS-1$
			final JasperPrint jasperPrint = JasperManager.fillReport(jasperReport,parameters,db.getCon());
			
			JasperViewer.viewReport(jasperPrint,false);
			
					
			}
			catch(Exception ex){
				ex.printStackTrace();
				MessageBox msg=new MessageBox(this.getShell(),SWT.NULL);
				//msg.setMessage(ex.getMessage());
				msg.open();
			}
		}
		
	}

