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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;

import com.turquaz.engine.dal.EngDALConnection;
import com.turquaz.engine.dal.TurqCompany;
import com.turquaz.engine.ui.component.DatePicker;
public class AccUIAccountingBalance extends org.eclipse.swt.widgets.Composite {
	private CLabel lblDateRange;
	private DatePicker datePickerBeginDate;
	private DatePicker datePickerEndDate;
	private Button btnShow;
	private Button checkSubAccounts;

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
		AccUIAccountingBalance inst = new AccUIAccountingBalance(shell, SWT.NULL);
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

	public AccUIAccountingBalance(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}
	
	private void btnShowSingleClick(){
		try{
			
			Map parameters = new HashMap();
			parameters.put("ReportTitle", "GENEL GEÇÝCÝ MÝZAN");
			TurqCompany company = new TurqCompany();
			company.setCompaniesId(Integer.valueOf(System.getProperty("company")));
			String sqlparam="Select mytab.deptsum,mytab.creditsum,mytab.top_account,accs.account_name,accs.account_code from turq_accounting_accounts accs,"+
					"(Select SUM(transcolumns.dept_amount) as deptsum," +
					"SUM(transcolumns.credit_amount) as creditsum," +
					" accounts.top_account" +
					" from turq_accounting_accounts accounts," +
					" turq_accounting_transaction_columns transcolumns, " +
					" turq_accounting_transactions trans" +
					" where transcolumns.accounting_accounts_id=accounts.accounting_accounts_id" +
					" and accounts.companies_id="+company.getCompaniesId().toString();
			SimpleDateFormat dformat=new SimpleDateFormat("yyyy-MM-dd");
			 sqlparam +=" and trans.transactions_date >= '"+ dformat.format(datePickerBeginDate.getDate())+"'"
					+" and trans.transactions_date <= '"+dformat.format(datePickerEndDate.getDate())+"'"
					+" GROUP BY accounts.top_account)" +
					" as mytab where mytab.top_account=accs.top_account";
			SimpleDateFormat dformat2=new SimpleDateFormat("dd-MM-yyyy");
			parameters.put("sqlparam",sqlparam);		
			parameters.put("beginDate",dformat2.format(datePickerBeginDate.getDate()));
			parameters.put("endDate",dformat2.format(datePickerEndDate.getDate()));
			NumberFormat formatter =NumberFormat.getNumberInstance();
            formatter.setMaximumFractionDigits(2);
            parameters.put("formatter",formatter);
			//parameters.put("imageUrl", "C:\\eclipse3\\workspace\\Turquaz\\icons\\sample.gif");
			EngDALConnection db=new EngDALConnection();
			db.connect();
			JasperReport jasperReport = JasperManager.loadReport("reports/accounting/AccountingBalance.jasper");
			final JasperPrint jasperPrint = JasperManager.fillReport(jasperReport,parameters,db.getCon());
			
			JasperViewer.viewReport(jasperPrint,false);
			
					
			}
			catch(Exception ex){
				ex.printStackTrace();
				MessageBox msg=new MessageBox(this.getShell(),SWT.NULL);
				msg.setMessage(ex.getMessage());
				msg.open();
			}
		}
	
	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 3;
			thisLayout.makeColumnsEqualWidth = true;
			this.setSize(447, 162);
			{
				lblDateRange = new CLabel(this, SWT.NONE);
				lblDateRange.setText("Select Date Range");
			}
			{
				datePickerBeginDate = new DatePicker(this, SWT.NONE);
			}
			{
				datePickerEndDate = new DatePicker(this, SWT.NONE);
			}
			{
				checkSubAccounts = new Button(this, SWT.CHECK | SWT.LEFT);
				checkSubAccounts.setText("Show SubAccounts");
			}
			{
				btnShow = new Button(this, SWT.PUSH | SWT.CENTER);
				btnShow.setText("Show Reports");
				btnShow.addMouseListener(new MouseAdapter() {
					public void mouseDown(MouseEvent evt) {
						btnShowSingleClick();
					}
				});
			}
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
