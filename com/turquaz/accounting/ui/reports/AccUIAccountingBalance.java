package com.turquaz.accounting.ui.reports;

import java.io.File;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
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
import com.turquaz.accounting.dal.AccDALAccountingBalanceSub;
import com.turquaz.engine.EngConfiguration;
import com.turquaz.engine.dal.EngDALConnection;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.ui.component.DatePicker;
import org.eclipse.swt.layout.GridData;
public class AccUIAccountingBalance extends org.eclipse.swt.widgets.Composite {
	private CLabel lblDateRange;
	private DatePicker datePickerBeginDate;
	private DatePicker datePickerEndDate;
	private CLabel lblLogoURL;
	private Button btnIcon;
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
			
			AccDALAccountingBalanceSub accBalanceSub=new AccDALAccountingBalanceSub();
			List transColumns=accBalanceSub.getTransactionColumns(3,datePickerBeginDate.getDate(),datePickerEndDate.getDate());
			BigDecimal totalCredit=new BigDecimal(0);
			BigDecimal totalDept=new BigDecimal(0);
			for(int k=0; k<transColumns.size(); k++)
			{
				TurqAccountingTransactionColumn column=(TurqAccountingTransactionColumn)transColumns.get(k);
				totalCredit=totalCredit.add(column.getCreditAmount());
				totalDept=totalDept.add(column.getDeptAmount());
			}
			if (!totalDept.equals(totalCredit))
			{
				MessageBox msg=new MessageBox(this.getShell(),SWT.NULL);
				msg.setMessage("Aç?l?? Fi?lerindeki Alacak/Borç Toplamlar? Tutars?z!");
				msg.open();
			}
			Map parameters = new HashMap();
			//parameters.put("ReportTitle", "GENEL GEÇÝCÝ MÝZAN"); //$NON-NLS-1$ //$NON-NLS-2$

			String sqlparam="Select mytab.deptsum,mytab.creditsum,mytab.top_account,accs.account_name,accs.account_code," +
					" accs.accounting_accounts_id from turq_accounting_accounts accs,"+
					"(Select SUM(transcolumns.dept_amount) as deptsum," +
					"SUM(transcolumns.credit_amount) as creditsum," +
					" accounts.top_account" +
					" from turq_accounting_accounts accounts," +
					" turq_accounting_transaction_columns transcolumns, " +
					" turq_accounting_transactions trans" +
					" where transcolumns.accounting_accounts_id=accounts.accounting_accounts_id" +
					" and transcolumns.accounting_transactions_id=trans.accounting_transactions_id";
			SimpleDateFormat dformat=new SimpleDateFormat("yyyy-MM-dd");
			 sqlparam +=" and trans.transactions_date >= '"+ dformat.format(datePickerBeginDate.getDate())+"'"
					+" and trans.transactions_date <= '"+dformat.format(datePickerEndDate.getDate())+"'"
					+" GROUP BY accounts.top_account)" +
					" as mytab where mytab.top_account=accs.accounting_accounts_id ORDER BY mytab.top_account";
			SimpleDateFormat dformat2=new SimpleDateFormat("dd-MM-yyyy");
			parameters.put("sqlparam",sqlparam);		
			parameters.put("beginDate",dformat2.format(datePickerBeginDate.getDate()));
			parameters.put("endDate",dformat2.format(datePickerEndDate.getDate()));
			NumberFormat formatter =NumberFormat.getNumberInstance();
            formatter.setMaximumFractionDigits(2);
            parameters.put("formatter",formatter);
			parameters.put("imageUrl", EngConfiguration.logoURL);
            parameters.put("formatter",formatter); //$NON-NLS-1$
			EngDALConnection db=new EngDALConnection();
			db.connect();
			//JasperReport jasperReport = JasperManager.loadReport("reports/accounting/AccountingBalance.jasper"); //$NON-NLS-1$
			//final JasperPrint jasperPrint = JasperManager.fillReport(jasperReport,parameters,db.getCon());
			JasperReport jasperReport =(JasperReport)JRLoader.loadObject("reports/accounting/AccountingBalance.jasper"); 
	    	final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,db.getCon());
			
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
			{
				this.setSize(400, 75);
			}
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 3;
			thisLayout.makeColumnsEqualWidth = true;
			this.setSize(543, 194);
			{
				lblDateRange = new CLabel(this, SWT.NONE);
				lblDateRange.setText(Messages.getString("AccUIAccountingBalance.0")); //$NON-NLS-1$
			}
			{
				datePickerBeginDate = new DatePicker(this, SWT.NONE);
			}
			{
				datePickerEndDate = new DatePicker(this, SWT.NONE);
			}
			{
				lblLogoURL = new CLabel(this, SWT.NONE);
				GridData lblLogoURLLData = new GridData();
				lblLogoURLLData.widthHint = 175;
				lblLogoURLLData.heightHint = 14;
				lblLogoURLLData.grabExcessHorizontalSpace = true;
				lblLogoURL.setLayoutData(lblLogoURLLData);
			}
			{
				btnIcon = new Button(this, SWT.PUSH | SWT.CENTER);
				btnIcon.setText("Choose Logo");
				GridData btnIconLData = new GridData();
				btnIconLData.horizontalAlignment = GridData.END;
				btnIconLData.horizontalSpan = 2;
				btnIcon.setText(Messages.getString("AccUIAccountingBalance.29")); //$NON-NLS-1$
				GridData btnIconLData1 = new GridData();
				btnIconLData1.widthHint = 102;
				btnIconLData1.heightHint = 30;
				btnIcon.setLayoutData(btnIconLData1);

				btnIcon.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent evt) {
						btnLogoSingleClick();
					}
				});
			}
			{
				btnShow = new Button(this, SWT.PUSH | SWT.CENTER);
				btnShow.setText(Messages.getString("AccUIAccountingBalance.30")); //$NON-NLS-1$
				GridData btnShowLData = new GridData();
				btnShowLData.widthHint = 117;
				btnShowLData.heightHint = 30;
				btnShow.setLayoutData(btnShowLData);
				btnShow.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent evt) {
						btnShowSingleClick();
					}
				});
			}
			File file = new File(EngConfiguration.logoURL);
			if(file.exists())
				this.lblLogoURL.setText("Logo:"+EngConfiguration.logoURL);
			else
			{
				this.lblLogoURL.setText("Logo:");
				EngConfiguration.logoURL="";
			}
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void btnLogoSingleClick(){
		FileDialog dialog = new FileDialog (this.getShell(), SWT.OK);
		dialog.setFilterNames (new String [] {"Image Files (*.jpg;*.jpeg;*.bmp;*.png)", "*.jpg;*.jpeg;*.bmp;*.png"});
		dialog.setFilterExtensions (new String [] {"*.jpg;*.jpeg;*.bmp;*.png"}); //Windows wild cards
		dialog.setText("Logo Seçimi");
		String filepath = dialog.open();
		
		if(filepath!=null){
			EngConfiguration.logoURL=filepath;
			lblLogoURL.setText("Logo:"+filepath);
		}

		
	}

}
