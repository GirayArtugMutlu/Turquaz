package com.turquaz.cheque.ui;

import java.math.BigDecimal;
import java.util.List;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CLabel;

import com.turquaz.cheque.Messages;
import com.turquaz.cheque.bl.CheBLSearchCheques;
import com.turquaz.cheque.dal.CheDALUpdate;
import com.turquaz.current.ui.comp.CurrentPicker;
import com.turquaz.bank.ui.comp.BankCardPicker;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;


import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqChequeCheque;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;

import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.layout.GridData;
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
public class CheUIOwnChequeSearch extends org.eclipse.swt.widgets.Composite implements SearchComposite {
	private Composite compSearchPanle;
	private CurrentPicker currentPicker;
	private DatePicker datePickerEndEnterDate;
	private TableColumn tableColumnChequeNo;
	private TableColumn tableColumnBankCode;
	private CLabel lblBankPicker;
	private BankCardPicker bankPicker;
	private CLabel lblEnterDateEnd;
	private DatePicker datePickerStartEnterDate;
	private CLabel lblEnterDate;
	private TableColumn tableColumnCurrentCard;
	private DatePicker datePickerEndDueDate;
	private CLabel lblDueDateEnd;
	private TableColumn tableColumnStatus;
	private TableColumn tableColumnAmount;
	private TableColumn tableColumnDueDate;
	private TableColumn tableColumnEntryDate;
	private Table tableCheques;
	private CLabel lblCurrentCard;
	private DatePicker datePickerStartDueDate;
	private CLabel lblDueDate;

    {
        //Register as a resource user - SWTResourceManager will
        //handle the obtaining and disposing of resources
        SWTResourceManager.registerResourceUser(this);
    }

	public CheUIOwnChequeSearch(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setBackground(SWTResourceManager.getColor(255, 255, 255));
			this.setSize(753, 406);
			//START >>  compSearchPanle
			compSearchPanle = new Composite(this, SWT.NONE);
			GridLayout compSearchPanleLayout = new GridLayout();
			GridData compSearchPanleLData = new GridData();
			compSearchPanleLData.heightHint = 114;
			compSearchPanleLData.grabExcessHorizontalSpace = true;
			compSearchPanleLData.horizontalAlignment = GridData.FILL;
			compSearchPanle.setLayoutData(compSearchPanleLData);
			compSearchPanleLayout.numColumns = 4;
			compSearchPanle.setLayout(compSearchPanleLayout);
			//START >>  lblCurrentCard
			lblCurrentCard = new CLabel(compSearchPanle, SWT.NONE);
			lblCurrentCard.setText(Messages.getString("CheUIOwnChequeSearch.0")); //$NON-NLS-1$
			//END <<  lblCurrentCard
			//START >>  currentPicker
			currentPicker = new CurrentPicker(compSearchPanle, SWT.NONE);
			GridData currentPickerLData = new GridData();
			currentPickerLData.widthHint = 348;
			currentPickerLData.heightHint = 18;
			currentPickerLData.horizontalSpan = 3;
			currentPicker.setLayoutData(currentPickerLData);
			//END <<  currentPicker
			//START >>  lblBankPicker
			lblBankPicker = new CLabel(compSearchPanle, SWT.NONE);
			lblBankPicker.setText(Messages.getString("CheUIOwnChequeSearch.1")); //$NON-NLS-1$
			//END <<  lblBankPicker
			//START >>  bankPicker
			bankPicker = new BankCardPicker(compSearchPanle, SWT.NONE);
			GridData bankPickerLData = new GridData();
			bankPickerLData.widthHint = 238;
			bankPickerLData.heightHint = 18;
			bankPickerLData.horizontalSpan = 3;
			bankPicker.setLayoutData(bankPickerLData);
			//END <<  bankPicker
			//START >>  lblDueDate
			lblDueDate = new CLabel(compSearchPanle, SWT.NONE);
			lblDueDate.setText(Messages.getString("CheUIOwnChequeSearch.2")); //$NON-NLS-1$
			//END <<  lblDueDate
			//START >>  datePickerStartDueDate
			datePickerStartDueDate = new DatePicker(compSearchPanle, SWT.NONE);
			GridData datePickerLData = new GridData();
			datePickerLData.widthHint = 137;
			datePickerLData.heightHint = 20;
			datePickerStartDueDate.setLayoutData(datePickerLData);
			datePickerStartDueDate.setFirstDayOfYear();
			//END <<  datePickerStartDueDate
			//START >>  lblDueDateEnd
			lblDueDateEnd = new CLabel(compSearchPanle, SWT.NONE);
			lblDueDateEnd.setText(Messages.getString("CheUIOwnChequeSearch.3")); //$NON-NLS-1$
			//END <<  lblDueDateEnd
			//START >>  datePickerEndDueDate
			datePickerEndDueDate = new DatePicker(compSearchPanle, SWT.NONE);
			GridData datePickerEndLData = new GridData();
			datePickerEndLData.widthHint = 118;
			datePickerEndLData.heightHint = 20;
			datePickerEndDueDate.setLayoutData(datePickerEndLData);
			datePickerEndDueDate.setLastDayOfYear();
			//END <<  datePickerEndDueDate
			//START >>  lblEnterDate
			lblEnterDate = new CLabel(compSearchPanle, SWT.NONE);
			lblEnterDate.setText(Messages.getString("CheUIOwnChequeSearch.4")); //$NON-NLS-1$
			//END <<  lblEnterDate
			//START >>  datePickerStartEnterDate
			datePickerStartEnterDate = new DatePicker(compSearchPanle, SWT.NONE);
			GridData datePickerStartEnterDateLData = new GridData();
			datePickerStartEnterDateLData.widthHint = 137;
			datePickerStartEnterDateLData.heightHint = 20;
			datePickerStartEnterDate.setLayoutData(datePickerStartEnterDateLData);
			datePickerStartEnterDate.setFirstDayOfYear();
			//END <<  datePickerStartEnterDate
			//START >>  lblEnterDateEnd
			lblEnterDateEnd = new CLabel(compSearchPanle, SWT.NONE);
			lblEnterDateEnd.setText(Messages.getString("CheUIOwnChequeSearch.5")); //$NON-NLS-1$
			//END <<  lblEnterDateEnd
			//START >>  datePickerEndEnterDate
			datePickerEndEnterDate = new DatePicker(compSearchPanle, SWT.NONE);
			GridData datePickerEndEnterDateLData = new GridData();
			datePickerEndEnterDateLData.widthHint = 116;
			datePickerEndEnterDateLData.heightHint = 21;
			datePickerEndEnterDate.setLayoutData(datePickerEndEnterDateLData);
			datePickerEndEnterDate.setLastDayOfYear();
			//END <<  datePickerEndEnterDate
			//END <<  compSearchPanle
			//START >>  tableCheques
			tableCheques = new Table(this, SWT.SINGLE | SWT.FULL_SELECTION);
			GridData tableChequesLData = new GridData();
			tableCheques.addMouseListener(new MouseAdapter() {
				public void mouseDoubleClick(MouseEvent evt) {
					tableChequesMouseDoubleClick(evt);
				}
			});
			tableCheques.setLinesVisible(true);
			tableCheques.setHeaderVisible(true);
			tableChequesLData.horizontalAlignment = GridData.FILL;
			tableChequesLData.grabExcessHorizontalSpace = true;
			tableChequesLData.grabExcessVerticalSpace = true;
			tableChequesLData.verticalAlignment = GridData.FILL;
			tableCheques.setLayoutData(tableChequesLData);
			//START >>  tableColumnEntryDate
			tableColumnEntryDate = new TableColumn(tableCheques, SWT.NONE);
			tableColumnEntryDate.setText(Messages.getString("CheUIOwnChequeSearch.6")); //$NON-NLS-1$
			tableColumnEntryDate.setWidth(90);
			//END <<  tableColumnEntryDate
			//START >>  tableColumnBankCode
			tableColumnBankCode = new TableColumn(tableCheques, SWT.NONE);
			tableColumnBankCode.setText(Messages.getString("CheUIOwnChequeSearch.7")); //$NON-NLS-1$
			tableColumnBankCode.setWidth(97);
			//END <<  tableColumnBankCode
			//START >>  tableColumnChequeNo
			tableColumnChequeNo = new TableColumn(tableCheques, SWT.NONE);
			tableColumnChequeNo.setText(Messages.getString("CheUIOwnChequeSearch.8")); //$NON-NLS-1$
			tableColumnChequeNo.setWidth(100);
			//END <<  tableColumnChequeNo
			//START >>  tableColumnCurrentCard
			tableColumnCurrentCard = new TableColumn(tableCheques, SWT.NONE);
			tableColumnCurrentCard.setText(Messages.getString("CheUIOwnChequeSearch.9")); //$NON-NLS-1$
			tableColumnCurrentCard.setWidth(145);
			//END <<  tableColumnCurrentCard
			//START >>  tableColumnDueDate
			tableColumnDueDate = new TableColumn(tableCheques, SWT.NONE);
			tableColumnDueDate.setText(Messages.getString("CheUIOwnChequeSearch.10")); //$NON-NLS-1$
			tableColumnDueDate.setWidth(107);
			//END <<  tableColumnDueDate
			//START >>  tableColumnStatus
			tableColumnStatus = new TableColumn(tableCheques, SWT.NONE);
			tableColumnStatus.setText(Messages.getString("CheUIOwnChequeSearch.11")); //$NON-NLS-1$
			tableColumnStatus.setWidth(105);
			//END <<  tableColumnStatus
			//START >>  tableColumnAmount
			tableColumnAmount = new TableColumn(tableCheques, SWT.RIGHT);
			tableColumnAmount.setText(Messages.getString("CheUIOwnChequeSearch.12")); //$NON-NLS-1$
			tableColumnAmount.setWidth(98);
			//END <<  tableColumnAmount
			//END <<  tableCheques
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	public void delete() {
		// TODO Auto-generated method stub

	}
	
	public void exportToExcel() {
		
		EngBLUtils.Export2Excel(tableCheques);

	}
	
	public void printTable() {
		EngBLUtils.printTable(tableCheques,Messages.getString("CheUIOwnChequeSearch.13")); //$NON-NLS-1$

	}
	
	public void search() {
		tableCheques.removeAll();
		try{
			Integer cheStat = null;
		
			List ls = CheBLSearchCheques.searchOwnCheques((TurqCurrentCard)currentPicker.getData(),bankPicker.getTurqBank(),datePickerStartEnterDate.getDate(),datePickerEndEnterDate.getDate(),datePickerStartDueDate.getDate(),datePickerEndDueDate.getDate());
			
			TableItem item;
			String status = ""; //$NON-NLS-1$
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			
			BigDecimal total = new BigDecimal(0);
			
			for(int i=0;i<ls.size();i++){
				
				Object result[] =(Object[])ls.get(i);
				
				if(result[4].equals(EngBLCommon.CHEQUE_TRANS_OUT_CURRENT)){
					status = EngBLCommon.CHEQUE_TRANS_OUT_CURRENT_STRING;
				}
				
				
			
				item = new TableItem(tableCheques,SWT.NULL);
				item.setData(result[0]);
							item.setText(new String[]{
							DatePicker.formatter.format(result[1]),
							result[6].toString(),
							result[7].toString(),
							result[2].toString(),
							DatePicker.formatter.format(result[3]),
							status,
							cf.format(result[5])
				});
							
				total = total.add((BigDecimal)result[5]);
			}
			
			item = new TableItem(tableCheques,SWT.NULL);
			item = new TableItem(tableCheques,SWT.NULL);
			item.setText(new String[]{
					"",
					"",
					"",
					"",
					"",
					"Toplam",
					cf.format(total)
		});
				
			
		
		}
		catch(Exception ex){
			ex.printStackTrace();
		}

	}
	
	private void tableChequesMouseDoubleClick(MouseEvent evt) {
		try{
			TableItem[] selection = tableCheques.getSelection();
			if(selection.length>0){
				
				if(selection[0].getData()==null)
				{
					return;
				}
				
				TurqChequeCheque cheque = CheDALUpdate.initializeCheque((Integer)selection[0].getData());
				boolean isUpdated = new CheUIOwnChequeUpdate(getShell(),SWT.NULL,cheque).open();
			   
				if(isUpdated)
					search();
			}
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
			
			
			
			
	}
	
}
