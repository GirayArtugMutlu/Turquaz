package com.turquaz.cheque.ui;

import java.util.List;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CLabel;

import com.turquaz.cheque.bl.CheBLSearchCheques;
import com.turquaz.current.ui.comp.CurrentPicker;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;


import com.turquaz.engine.bl.EngBLCommon;
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
			this.setSize(667, 412);
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
			lblCurrentCard.setText("Sat\u0131c\u0131");
			//END <<  lblCurrentCard
			//START >>  currentPicker
			currentPicker = new CurrentPicker(compSearchPanle, SWT.NONE);
			GridData currentPickerLData = new GridData();
			currentPickerLData.widthHint = 348;
			currentPickerLData.heightHint = 16;
			currentPickerLData.horizontalSpan = 3;
			currentPicker.setLayoutData(currentPickerLData);
			//END <<  currentPicker
			//START >>  lblDueDate
			lblDueDate = new CLabel(compSearchPanle, SWT.NONE);
			lblDueDate.setText("Vade Tarihi (Ba\u015flang\u0131ç)");
			//END <<  lblDueDate
			//START >>  datePickerStartDueDate
			datePickerStartDueDate = new DatePicker(compSearchPanle, SWT.NONE);
			GridData datePickerLData = new GridData();
			datePickerLData.widthHint = 137;
			datePickerLData.heightHint = 20;
			datePickerStartDueDate.setLayoutData(datePickerLData);
			//END <<  datePickerStartDueDate
			//START >>  lblDueDateEnd
			lblDueDateEnd = new CLabel(compSearchPanle, SWT.NONE);
			lblDueDateEnd.setText("Vade Tarihi (Biti\u015f)");
			//END <<  lblDueDateEnd
			//START >>  datePickerEndDueDate
			datePickerEndDueDate = new DatePicker(compSearchPanle, SWT.NONE);
			GridData datePickerEndLData = new GridData();
			datePickerEndLData.widthHint = 118;
			datePickerEndLData.heightHint = 20;
			datePickerEndDueDate.setLayoutData(datePickerEndLData);
			//END <<  datePickerEndDueDate
			//START >>  lblEnterDate
			lblEnterDate = new CLabel(compSearchPanle, SWT.NONE);
			lblEnterDate.setText("Ç\u0131k\u0131\u015f Tarihi (Ba\u015flang\u0131ç)");
			//END <<  lblEnterDate
			//START >>  datePickerStartEnterDate
			datePickerStartEnterDate = new DatePicker(compSearchPanle, SWT.NONE);
			GridData datePickerStartEnterDateLData = new GridData();
			datePickerStartEnterDateLData.widthHint = 137;
			datePickerStartEnterDateLData.heightHint = 20;
			datePickerStartEnterDate.setLayoutData(datePickerStartEnterDateLData);
			//END <<  datePickerStartEnterDate
			//START >>  lblEnterDateEnd
			lblEnterDateEnd = new CLabel(compSearchPanle, SWT.NONE);
			lblEnterDateEnd.setText("Ç\u0131k\u0131\u015fTarihi (Biti\u015f)");
			//END <<  lblEnterDateEnd
			//START >>  datePickerEndEnterDate
			datePickerEndEnterDate = new DatePicker(compSearchPanle, SWT.NONE);
			GridData datePickerEndEnterDateLData = new GridData();
			datePickerEndEnterDateLData.widthHint = 116;
			datePickerEndEnterDateLData.heightHint = 21;
			datePickerEndEnterDate.setLayoutData(datePickerEndEnterDateLData);
			//END <<  datePickerEndEnterDate
			//END <<  compSearchPanle
			//START >>  tableCheques
			tableCheques = new Table(this, SWT.NONE);
			GridData tableChequesLData = new GridData();
			tableCheques.setLinesVisible(true);
			tableCheques.setHeaderVisible(true);
			tableChequesLData.horizontalAlignment = GridData.FILL;
			tableChequesLData.grabExcessHorizontalSpace = true;
			tableChequesLData.grabExcessVerticalSpace = true;
			tableChequesLData.verticalAlignment = GridData.FILL;
			tableCheques.setLayoutData(tableChequesLData);
			//START >>  tableColumnEntryDate
			tableColumnEntryDate = new TableColumn(tableCheques, SWT.NONE);
			tableColumnEntryDate.setText("Ç\u0131k\u0131\u015f Tariihi");
			tableColumnEntryDate.setWidth(90);
			//END <<  tableColumnEntryDate
			//START >>  tableColumnCurrentCard
			tableColumnCurrentCard = new TableColumn(tableCheques, SWT.NONE);
			tableColumnCurrentCard.setText("Cari Ünvan (Kime Verildi)");
			tableColumnCurrentCard.setWidth(145);
			//END <<  tableColumnCurrentCard
			//START >>  tableColumnDueDate
			tableColumnDueDate = new TableColumn(tableCheques, SWT.NONE);
			tableColumnDueDate.setText("Vade Tarihi");
			tableColumnDueDate.setWidth(107);
			//END <<  tableColumnDueDate
			//START >>  tableColumnStatus
			tableColumnStatus = new TableColumn(tableCheques, SWT.NONE);
			tableColumnStatus.setText("Durumu");
			tableColumnStatus.setWidth(105);
			//END <<  tableColumnStatus
			//START >>  tableColumnAmount
			tableColumnAmount = new TableColumn(tableCheques, SWT.NONE);
			tableColumnAmount.setText("Tutar");
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
		// TODO Auto-generated method stub

	}
	
	public void printTable() {
		// TODO Auto-generated method stub

	}
	
	public void search() {
		tableCheques.removeAll();
		try{
			Integer cheStat = null;
			/**
			 * TODO new search function
			 */
			
			List ls = CheBLSearchCheques.searchOwnCheques((TurqCurrentCard)currentPicker.getData(),datePickerStartEnterDate.getDate(),datePickerEndEnterDate.getDate(),datePickerStartDueDate.getDate(),datePickerEndDueDate.getDate());
			
			TableItem item;
			String status = "";
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			for(int i=0;i<ls.size();i++){
				
				Object result[] =(Object[])ls.get(i);
				
				if(result[4].equals(EngBLCommon.CHEQUE_STATUS_CURRENT)){
					status = EngBLCommon.CHEQUE_STATUS_CURRENT_STRING;
				}
				
				
			
				item = new TableItem(tableCheques,SWT.NULL);
				item.setData(result[0]);
							item.setText(new String[]{
							DatePicker.formatter.format(result[1]),
							result[2].toString(),
							DatePicker.formatter.format(result[3]),
							status,
							cf.format(result[5])
				});
				
				
				
				
				
			}
		
		}
		catch(Exception ex){
			ex.printStackTrace();
		}

	}
}
