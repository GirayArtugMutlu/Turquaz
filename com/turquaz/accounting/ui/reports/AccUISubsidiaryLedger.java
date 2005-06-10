package com.turquaz.accounting.ui.reports;

/************************************************************************/
/* TURQUAZ: Higly Modular Accounting/ERP Program                        */
/* ============================================                         */
/* Copyright (c) 2004 by Turquaz Software Development Group			    */
/*																		*/
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or    */
/* (at your option) any later version.       							*/
/* 																		*/
/* This program is distributed in the hope that it will be useful,		*/
/* but WITHOUT ANY WARRANTY; without even the implied warranty of		*/
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the		*/
/* GNU General Public License for more details.         				*/
/************************************************************************/
/**
 * @author  Huseyin Ergun
 * @version  $Id$
 */
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridData;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.custom.CLabel;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.interfaces.SearchComposite;
import com.turquaz.engine.lang.AccLangKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.report.HibernateQueryResultDataSource;
import org.eclipse.swt.SWT;
import com.turquaz.accounting.ui.comp.AccountPickerLeaf;
import com.turquaz.common.HashBag;
import com.jasperassistant.designer.viewer.ViewerComposite;


public class AccUISubsidiaryLedger extends Composite implements SearchComposite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	private DatePicker dateEndDate;
	private CLabel lblEndDate;
	private DatePicker dateStartDate;
	private CLabel lblStartDate;
	private AccountPickerLeaf txtAccount;
	private ViewerComposite viewer;
	private CLabel lblAccountCode2;
	private AccountPickerLeaf txtAccount2;
	private CLabel lblAccNo;
	private Composite compAccTransactionSearch;
	private AccBLTransactionSearch blTransSearch = new AccBLTransactionSearch();
	private Integer accountIdStart;
	private Integer accountIdEnd;

	public AccUISubsidiaryLedger(Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}
	/**
	 * Initializes the GUI. Auto-generated code - any changes you make will disappear.
	 */
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); //$NON-NLS-1$

	public void initGUI()
	{
		try
		{
			{
				compAccTransactionSearch = new Composite(this, SWT.NONE);
				GridLayout composite1Layout = new GridLayout();
				composite1Layout.numColumns = 4;
				GridData composite1LData = new GridData();
				composite1LData.horizontalAlignment = GridData.FILL;
				composite1LData.heightHint = 71;
				composite1LData.grabExcessHorizontalSpace = true;
				compAccTransactionSearch.setLayoutData(composite1LData);
				compAccTransactionSearch.setLayout(composite1Layout);
				{
					lblAccNo = new CLabel(compAccTransactionSearch, SWT.NONE);
					GridData lblDocumentNoLData = new GridData();
					lblDocumentNoLData.widthHint = 121;
					lblDocumentNoLData.heightHint = 21;
					lblAccNo.setLayoutData(lblDocumentNoLData);
					lblAccNo.setText(AccLangKeys.STR_ACC_CODE_START); 
				}
				{
					txtAccount = new AccountPickerLeaf(compAccTransactionSearch, SWT.NONE);
					GridData txtDocumentNoLData = new GridData();
					txtDocumentNoLData.widthHint = 157;
					txtDocumentNoLData.heightHint = 17;
					txtAccount.setLayoutData(txtDocumentNoLData);
				}
				{
					lblAccountCode2 = new CLabel(compAccTransactionSearch, SWT.NONE);
					lblAccountCode2.setText(AccLangKeys.STR_ACC_CODE_END); 
				}
				{
					txtAccount2 = new AccountPickerLeaf(compAccTransactionSearch, SWT.NONE);
					GridData txtAccount2LData = new GridData();
					txtAccount2LData.widthHint = 157;
					txtAccount2LData.heightHint = 17;
					txtAccount2.setLayoutData(txtAccount2LData);
				}
				{
					lblStartDate = new CLabel(compAccTransactionSearch, SWT.NONE);
					GridData lblStartDateLData = new GridData();
					lblStartDate.setLayoutData(lblStartDateLData);
					lblStartDate.setText(AccLangKeys.STR_START_DATE); 
				}
				{
					dateStartDate = new DatePicker(compAccTransactionSearch, SWT.NONE);
					GridData dateStartDateLData = new GridData();
					dateStartDateLData.widthHint = 157;
					dateStartDateLData.heightHint = 22;
					dateStartDate.setLayoutData(dateStartDateLData);
					dateStartDate.layout();
					//dateStartDate.setDate(new Date(cal.getTime().getYear(),0,1));
					cal.set(cal.get(Calendar.YEAR), 0, 1);
					dateStartDate.setDate(cal.getTime());
				}
				{
					lblEndDate = new CLabel(compAccTransactionSearch, SWT.NONE);
					GridData lblEndDateLData = new GridData();
					lblEndDate.setLayoutData(lblEndDateLData);
					lblEndDate.setText(AccLangKeys.STR_END_DATE); 
				}
				{
					dateEndDate = new DatePicker(compAccTransactionSearch, SWT.NONE);
					GridData dateEndDateLData = new GridData();
					dateEndDateLData.widthHint = 157;
					dateEndDateLData.heightHint = 22;
					dateEndDate.setLayoutData(dateEndDateLData);
					dateEndDate.layout();
				}
				compAccTransactionSearch.layout();
			}
			{
				viewer = new ViewerComposite(this, SWT.NONE);
				GridData viewerLData = new GridData();
				viewerLData.grabExcessHorizontalSpace = true;
				viewerLData.horizontalAlignment = GridData.FILL;
				viewerLData.grabExcessVerticalSpace = true;
				viewerLData.verticalAlignment = GridData.FILL;
				viewer.setLayoutData(viewerLData);
			}
			this.setSize(669, 511);
			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 5;
			this.layout();
			postInitGUI();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	/** Add your post-init code in here */
	public void postInitGUI()
	{
	}

	public void save()
	{
	}

	public void delete()
	{
	}

	public void search()
	{
		try
		{
			accountIdStart = null;
			accountIdEnd = null;
			if (txtAccount.getData() == null && txtAccount2.getData() == null)
			{
				EngUICommon.showMessageBox(getShell(),AccLangKeys.MSG_SELECT_AT_LEAST_ONE_ACCOUNT_FIRST); 
				txtAccount.setFocus();
				return;
			}
			else if (txtAccount.getData() == null)
			{
				accountIdStart = txtAccount2.getId();
			}
			else if (txtAccount2.getData() == null)
			{
				accountIdStart = txtAccount.getId();
			}
			else
			{
				accountIdStart =txtAccount.getId();
				accountIdEnd = txtAccount2.getId();
			}
			
			HashMap argMap = new HashMap();
			argMap.put(AccKeys.ACC_ACCOUNT_START_ID,accountIdStart);
			argMap.put(AccKeys.ACC_ACCOUNT_END_ID,accountIdEnd);
			argMap.put(EngKeys.DATE_START,dateStartDate.getDate());
			argMap.put(EngKeys.DATE_END,dateEndDate.getDate());
			

			HashBag list=(HashBag)EngTXCommon.doSelectTX(AccBLTransactionSearch.class.getName(),"getSubsidiaryLedger",argMap);
			List transList=(List)list.get(AccKeys.ACC_TRANSACTIONS);
			
			Map parameters = new HashMap();
			SimpleDateFormat dformat2 = new SimpleDateFormat("dd/MM/yyyy"); 
			parameters.put("beginDate", dformat2.format(dateStartDate.getDate())); 
			parameters.put("endDate", dformat2.format(dateEndDate.getDate())); 
			parameters.put("dformat", dformat2); //$NON-NLS-1$
			parameters.put("account1", txtAccount.getAccountCode()); 
			parameters.put("account2", (accountIdEnd == null) ? "" : txtAccount2.getAccountCode()); 
			parameters.put("currentDate", dformat2.format(Calendar.getInstance().getTime())); 
			NumberFormat formatter = NumberFormat.getNumberInstance();
			formatter.setMaximumFractionDigits(2);
			formatter.setMinimumFractionDigits(2);
			parameters.put("formatter", new TurkishCurrencyFormat()); //$NON-NLS-1$
		

			List balances = (List)EngTXCommon.doSelectTX(AccBLTransactionSearch.class.getName(),"getCurrentBalances",argMap);
			
			HashMap balanceList = new HashMap();
			for (int k = 0; k < balances.size(); k++)
			{
				Object[] balanceArr = (Object[]) balances.get(k);
				balanceList.put((String) balanceArr[0], balanceArr);
			}
			parameters.put("balanceList", balanceList); //$NON-NLS-1$
			GenerateJasper(transList,parameters);
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}
	
	public void GenerateJasper(List list, Map parameters)
	{
		try
		{
			String[] fields = new String[]{"columnId", "rows_dept_in_base_currency",
					"rows_credit_in_base_currency",	"transaction_definition",
					"accName", "accCode", "topAccName", "topAccCode",
					"transactions_date", "transaction_document_no"};
			HibernateQueryResultDataSource ds = new HibernateQueryResultDataSource(list, fields);
			JasperReport jasperReport = JasperCompileManager.compileReport("reports/accounting/AccountingSubsidiaryLedger.jrxml");
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, ds);
			viewer.getReportViewer().setDocument(jasperPrint);
		}
		catch (Exception ex)
		{

            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void newForm()
	{
	}

	public void printTable()
	{
	}

	public void exportToExcel()
	{
	}
}