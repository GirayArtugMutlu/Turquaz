package com.turquaz.accounting.ui.reports;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

import com.turquaz.accounting.Messages;
import com.turquaz.engine.dal.EngDALConnection;
import com.turquaz.engine.ui.component.DatePicker;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
public class AccUIAccountingJournal extends org.eclipse.swt.widgets.Composite {
	private CLabel lblDateRange;
	private DatePicker datePickerBeginDate;
	private DatePicker datePickerEndDate;
	private CLabel lblDummy;
	private Button btnReports;
	private Calendar cal=Calendar.getInstance();

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
		AccUIAccountingJournal inst = new AccUIAccountingJournal(shell, SWT.NULL);
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

	public AccUIAccountingJournal(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();
			thisLayout.numColumns = 3;
			thisLayout.makeColumnsEqualWidth = true;
			this.setLayout(thisLayout);
			this.setSize(438, 180);
			lblDateRange = new CLabel(this, SWT.NONE);
			lblDateRange.setText(Messages.getString("AccUIAccountingJournal.0"));	 //$NON-NLS-1$
			datePickerBeginDate = new DatePicker(this, SWT.NONE);	
			datePickerBeginDate.setDate(new Date(cal.getTime().getYear(),0,1));
			datePickerEndDate = new DatePicker(this, SWT.NONE);	
			{
				lblDummy = new CLabel(this, SWT.NONE);
				GridData lblDummyLData = new GridData();
				lblDummyLData.horizontalSpan = 2;
				lblDummy.setLayoutData(lblDummyLData);
			}
			{
				btnReports = new Button(this, SWT.PUSH | SWT.CENTER);
				GridData btnReportsLData = new GridData();
				btnReportsLData.widthHint = 118;
				btnReportsLData.heightHint = 28;
				btnReportsLData.verticalAlignment = GridData.BEGINNING;
				btnReports.setText(Messages
					.getString("AccUIAccountingJournal.1")); //$NON-NLS-1$
				btnReports.addMouseListener(new MouseAdapter() {
					public void mouseDown(MouseEvent evt) {
						btnReportsSingleClick();
					}
				});
				btnReports.setLayoutData(btnReportsLData);

			}
			this.layout();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	private void btnReportsSingleClick(){
	
		try{
			
			Map parameters = new HashMap();
			parameters.put(Messages.getString("AccUIAccountingJournal.2"), Messages.getString("AccUIAccountingJournal.3")); //$NON-NLS-1$ //$NON-NLS-2$
			
			String sqlparam="Select * from turq_accounting_transactions trans," + //$NON-NLS-1$
					"turq_accounting_transaction_columns transcolumns," + //$NON-NLS-1$
					"turq_accounting_accounts accounts where " + //$NON-NLS-1$
					"trans.accounting_transactions_id=transcolumns.accounting_transactions_id" + //$NON-NLS-1$
					" and transcolumns.accounting_accounts_id=accounts.accounting_accounts_id"; //$NON-NLS-1$
			SimpleDateFormat dformat=new SimpleDateFormat("yyyy-MM-dd"); //$NON-NLS-1$
			 sqlparam +=" and trans.transactions_date >= '"+ dformat.format(datePickerBeginDate.getDate())+"'" //$NON-NLS-1$ //$NON-NLS-2$
					+" and trans.transactions_date <= '"+dformat.format(datePickerEndDate.getDate())+"'" //$NON-NLS-1$ //$NON-NLS-2$
					+" and trans.accounting_journal_id > 0" //$NON-NLS-1$
					+" ORDER BY trans.accounting_journal_id"; //$NON-NLS-1$
					
			SimpleDateFormat dformat2=new SimpleDateFormat("dd-MM-yyyy"); //$NON-NLS-1$
			parameters.put("sqlparam",sqlparam);		 //$NON-NLS-1$
			parameters.put("beginDate",dformat2.format(datePickerBeginDate.getDate())); //$NON-NLS-1$
			parameters.put("endDate",dformat2.format(datePickerEndDate.getDate())); //$NON-NLS-1$
			//parameters.put("imageUrl", "C:\\eclipse3\\workspace\\Turquaz\\icons\\sample.gif");

			parameters.put("column1header",Messages.getString("AccUIAccountingJournal.22")); //$NON-NLS-1$ //$NON-NLS-2$
			parameters.put("column2header",Messages.getString("AccUIAccountingJournal.24")); //$NON-NLS-1$ //$NON-NLS-2$
			EngDALConnection db=new EngDALConnection();
			db.connect();
			JasperReport jasperReport = JasperManager.loadReport("reports/accounting/AccountingJournal.jasper"); //$NON-NLS-1$
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
			
}
