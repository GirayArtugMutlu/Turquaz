package com.turquaz.cheque.ui;

import java.util.List;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CLabel;

import com.turquaz.cheque.Messages;
import com.turquaz.cheque.bl.CheBLSearchCheques;
import com.turquaz.cheque.dal.CheDALUpdate;
import com.turquaz.current.ui.comp.CurrentPicker;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.custom.CCombo;

import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqChequeCheque;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;

import org.eclipse.swt.widgets.Text;
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
public class CheUICustomerChequeSearch extends org.eclipse.swt.widgets.Composite implements SearchComposite {
	private Composite compSearchPanle;
	private Text txtPortFoyNo;
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
	private TableColumn tableColumnChequeNo;
	private Table tableCheques;
	private CLabel lblCurrentCard;
	private CCombo comboStatus;
	private CLabel lblStaus;
	private DatePicker datePickerStartDueDate;
	private CLabel lblDueDate;
	private CLabel lblPortfoyNo;

    {
        //Register as a resource user - SWTResourceManager will
        //handle the obtaining and disposing of resources
        SWTResourceManager.registerResourceUser(this);
    }

	public CheUICustomerChequeSearch(org.eclipse.swt.widgets.Composite parent, int style) {
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
			compSearchPanleLData.heightHint = 110;
			compSearchPanleLData.grabExcessHorizontalSpace = true;
			compSearchPanleLData.horizontalAlignment = GridData.FILL;
			compSearchPanle.setLayoutData(compSearchPanleLData);
			compSearchPanleLayout.numColumns = 4;
			compSearchPanle.setLayout(compSearchPanleLayout);
			//START >>  lblPortfoyNo
			lblPortfoyNo = new CLabel(compSearchPanle, SWT.NONE);
			lblPortfoyNo.setText(Messages.getString("CheUICustomerChequeSearch.0")); //$NON-NLS-1$
			//END <<  lblPortfoyNo
			//START >>  txtPortFoyNo
			txtPortFoyNo = new Text(compSearchPanle, SWT.NONE);
			GridData txtPortFoyNoLData = new GridData();
			txtPortFoyNoLData.widthHint = 155;
			txtPortFoyNoLData.heightHint = 16;
			txtPortFoyNo.setLayoutData(txtPortFoyNoLData);
			//END <<  txtPortFoyNo
			//START >>  lblStaus
			lblStaus = new CLabel(compSearchPanle, SWT.NONE);
			lblStaus.setText(Messages.getString("CheUICustomerChequeSearch.1")); //$NON-NLS-1$
			//END <<  lblStaus
			//START >>  comboStatus
			comboStatus = new CCombo(compSearchPanle, SWT.NONE);
			GridData comboStatusLData = new GridData();
			comboStatusLData.widthHint = 96;
			comboStatusLData.heightHint = 17;
			comboStatus.setLayoutData(comboStatusLData);
			comboStatus.setText(Messages.getString("CheUICustomerChequeSearch.2")); //$NON-NLS-1$
			comboStatus.add(Messages.getString("CheUICustomerChequeSearch.3")); //$NON-NLS-1$
			comboStatus.add(EngBLCommon.CHEQUE_STATUS_PORTFOY_STRING);
			comboStatus.add(EngBLCommon.CHEQUE_STATUS_CURRENT_STRING);
			comboStatus.add(EngBLCommon.CHEQUE_STATUS_BANK_STRING);
			//END <<  comboStatus
			//START >>  lblCurrentCard
			lblCurrentCard = new CLabel(compSearchPanle, SWT.NONE);
			lblCurrentCard.setText(Messages.getString("CheUICustomerChequeSearch.4")); //$NON-NLS-1$
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
			lblDueDate.setText(Messages.getString("CheUICustomerChequeSearch.5")); //$NON-NLS-1$
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
			lblDueDateEnd.setText(Messages.getString("CheUICustomerChequeSearch.6")); //$NON-NLS-1$
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
			lblEnterDate.setText(Messages.getString("CheUICustomerChequeSearch.7")); //$NON-NLS-1$
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
			lblEnterDateEnd.setText(Messages.getString("CheUICustomerChequeSearch.8")); //$NON-NLS-1$
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
			//START >>  tableColumnChequeNo
			tableColumnChequeNo = new TableColumn(tableCheques, SWT.NONE);
			tableColumnChequeNo.setText(Messages.getString("CheUICustomerChequeSearch.9")); //$NON-NLS-1$
			tableColumnChequeNo.setWidth(76);
			//END <<  tableColumnChequeNo
			//START >>  tableColumnEntryDate
			tableColumnEntryDate = new TableColumn(tableCheques, SWT.NONE);
			tableColumnEntryDate.setText(Messages.getString("CheUICustomerChequeSearch.10")); //$NON-NLS-1$
			tableColumnEntryDate.setWidth(90);
			//END <<  tableColumnEntryDate
			//START >>  tableColumnCurrentCard
			tableColumnCurrentCard = new TableColumn(tableCheques, SWT.NONE);
			tableColumnCurrentCard.setText(Messages.getString("CheUICustomerChequeSearch.11")); //$NON-NLS-1$
			tableColumnCurrentCard.setWidth(122);
			//END <<  tableColumnCurrentCard
			//START >>  tableColumnDueDate
			tableColumnDueDate = new TableColumn(tableCheques, SWT.NONE);
			tableColumnDueDate.setText(Messages.getString("CheUICustomerChequeSearch.12")); //$NON-NLS-1$
			tableColumnDueDate.setWidth(107);
			//END <<  tableColumnDueDate
			//START >>  tableColumnStatus
			tableColumnStatus = new TableColumn(tableCheques, SWT.NONE);
			tableColumnStatus.setText(Messages.getString("CheUICustomerChequeSearch.13")); //$NON-NLS-1$
			tableColumnStatus.setWidth(105);
			//END <<  tableColumnStatus
			//START >>  tableColumnAmount
			tableColumnAmount = new TableColumn(tableCheques, SWT.NONE);
			tableColumnAmount.setText(Messages.getString("CheUICustomerChequeSearch.14")); //$NON-NLS-1$
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
			if(comboStatus.getText().equals(EngBLCommon.CHEQUE_STATUS_BANK_STRING))
			{
				cheStat = EngBLCommon.CHEQUE_STATUS_BANK;
			}
			else if(comboStatus.getText().equals(EngBLCommon.CHEQUE_STATUS_CURRENT_STRING)){
			
				cheStat = EngBLCommon.CHEQUE_STATUS_CURRENT;
			}
			else if(comboStatus.getText().equals(EngBLCommon.CHEQUE_STATUS_PORTFOY_STRING)){
			
				cheStat = EngBLCommon.CHEQUE_STATUS_PORTFOY;
			
			}		
			
			List ls = CheBLSearchCheques.searchCheque(txtPortFoyNo.getText().trim(),(TurqCurrentCard)currentPicker.getData(),cheStat,datePickerStartEnterDate.getDate(),datePickerEndEnterDate.getDate(),datePickerStartDueDate.getDate(),datePickerEndDueDate.getDate());
			TableItem item;
			String status = ""; //$NON-NLS-1$
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			for(int i=0;i<ls.size();i++){
				
				Object result[] =(Object[])ls.get(i);
				
				if(result[5].equals(EngBLCommon.CHEQUE_STATUS_PORTFOY)){
					status = EngBLCommon.CHEQUE_STATUS_PORTFOY_STRING;
				}
				else if(result[5].equals(EngBLCommon.CHEQUE_STATUS_BANK)){
					status = EngBLCommon.CHEQUE_STATUS_BANK_STRING;
				}
				else if(result[5].equals(EngBLCommon.CHEQUE_STATUS_CURRENT)){
					status = EngBLCommon.CHEQUE_STATUS_CURRENT_STRING;
				}
				
			
				item = new TableItem(tableCheques,SWT.NULL);
				item.setData(result[0]);
				
							item.setText(new String[]{
							result[1].toString(),
							DatePicker.formatter.format(result[2]),
							result[3].toString(),
							DatePicker.formatter.format(result[4]),
							status,
							cf.format(result[6])
				});
				
				
				
				
				
			}
		
		}
		catch(Exception ex){
			ex.printStackTrace();
		}

	}
	
	private void tableChequesMouseDoubleClick(MouseEvent evt) {
		try{
		TableItem[] selection = tableCheques.getSelection();
		if(selection.length>0){
			TurqChequeCheque cheque = CheDALUpdate.initializeCheque((Integer)selection[0].getData());
			boolean isUpdated = new CheUICustomerChequeUpdate(getShell(),SWT.NULL,cheque).open();
		   
			if(isUpdated)
				search();
		}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		
		
		
	}
}
