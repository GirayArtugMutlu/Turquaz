package com.turquaz.inventory.ui;

import java.math.BigDecimal;
import java.util.List;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableItem;

import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.inventory.Messages;
import com.turquaz.inventory.bl.InvBLInventoryLedger;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Table;
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
public class InvUIInventoryLedger extends org.eclipse.swt.widgets.Composite implements SearchComposite{
	private Composite compFilter;
	private TableColumn tableColumnInvCode;
	private TableColumn tableColumnInvName;
	private Text txtInvCode;
	private CLabel lblInvCode;
	private TableColumn tableColumnTotalPrice;
	private TableColumn tableColumnAvgPrice;
	private TableColumn tableColumnLastAmount;
	private DatePicker datePicker;
	private CLabel lblDate;
	private Table tableInventories;
	InvBLInventoryLedger blLedger = new InvBLInventoryLedger();

    /**
     * Bu Class Envanter Defterinin Cikarilmasini Saglar..
     * @param parent
     * @param style
     */
	public InvUIInventoryLedger(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	
	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setSize(545, 281);
            {
                compFilter = new Composite(this, SWT.NONE);
                GridLayout compFilterLayout = new GridLayout();
                compFilterLayout.numColumns = 2;
                GridData compFilterLData = new GridData();
                compFilterLData.heightHint = 64;
                compFilterLData.grabExcessHorizontalSpace = true;
                compFilterLData.horizontalAlignment = GridData.FILL;
                compFilter.setLayoutData(compFilterLData);
                compFilter.setLayout(compFilterLayout);
                {
                    lblDate = new CLabel(compFilter, SWT.NONE);
                    lblDate.setText("Tarih"); //$NON-NLS-1$
                    GridData lblDateLData = new GridData();
                    lblDateLData.widthHint = 51;
                    lblDateLData.heightHint = 22;
                    lblDate.setLayoutData(lblDateLData);
                }
                {
                    datePicker = new DatePicker(compFilter, SWT.NONE);
                    GridData datePickerLData = new GridData();
                    datePickerLData.widthHint = 149;
                    datePickerLData.heightHint = 21;
                    datePicker.setLayoutData(datePickerLData);
                }
                {
                    lblInvCode = new CLabel(compFilter, SWT.NONE);
                    lblInvCode.setText("Stok Kodu");
                    GridData lblInvCodeLData = new GridData();
                    lblInvCodeLData.widthHint = 54;
                    lblInvCodeLData.heightHint = 19;
                    lblInvCode.setLayoutData(lblInvCodeLData);
                }
                {
                    txtInvCode = new Text(compFilter, SWT.NONE);
                    GridData txtInvCodeLData = new GridData();
                    txtInvCodeLData.widthHint = 76;
                    txtInvCodeLData.heightHint = 13;
                    txtInvCode.setLayoutData(txtInvCodeLData);
                }
            }
            {
                tableInventories = new Table(this, SWT.NONE);
                GridData table1LData = new GridData();
                tableInventories.setLinesVisible(true);
                tableInventories.setHeaderVisible(true);
                table1LData.grabExcessHorizontalSpace = true;
                table1LData.grabExcessVerticalSpace = true;
                table1LData.horizontalAlignment = GridData.FILL;
                table1LData.verticalAlignment = GridData.FILL;
                tableInventories.setLayoutData(table1LData);
                {
                    tableColumnInvCode = new TableColumn(tableInventories, SWT.NONE);
                    tableColumnInvCode.setText(Messages.getString("InvUIInventoryLedger.0"));  //$NON-NLS-1$
                    tableColumnInvCode.setWidth(87);
                }
                {
                    tableColumnInvName = new TableColumn(tableInventories, SWT.NONE);
                    tableColumnInvName.setText(Messages.getString("InvUIInventoryLedger.1"));  //$NON-NLS-1$
                    tableColumnInvName.setWidth(88);
                }
                {
                    tableColumnLastAmount = new TableColumn(tableInventories, SWT.NONE);
                    tableColumnLastAmount.setText(Messages.getString("InvUIInventoryLedger.2"));  //$NON-NLS-1$
                    tableColumnLastAmount.setWidth(100);
                }
                {
                    tableColumnAvgPrice = new TableColumn(tableInventories, SWT.RIGHT);
                    tableColumnAvgPrice.setText(Messages.getString("InvUIInventoryLedger.3"));  //$NON-NLS-1$
                    tableColumnAvgPrice.setWidth(100);
                }
                {
                    tableColumnTotalPrice = new TableColumn(tableInventories, SWT.RIGHT);
                    tableColumnTotalPrice.setText(Messages.getString("InvUIInventoryLedger.4"));  //$NON-NLS-1$
                    tableColumnTotalPrice.setWidth(100);
                }
            }
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void search(){
	    try{
	       
	        tableInventories.removeAll();
	      TurkishCurrencyFormat curFormat = new TurkishCurrencyFormat();  
	      List list = blLedger.getInventoryLedger(datePicker.getDate(),txtInvCode.getText().trim()); 
	      Object[]result;
	      String invCode = ""; //$NON-NLS-1$
	      String invName = ""; //$NON-NLS-1$
	      BigDecimal amountIn = new BigDecimal(0);
	      BigDecimal priceIn = new BigDecimal(0);
	      BigDecimal amountOut = new BigDecimal(0);
	      BigDecimal balanceAmount = new BigDecimal(0);
	      BigDecimal avgPrice;
	      BigDecimal totalPrice;
	      TableItem item;
	      for(int i=0;i<list.size();i++){
	          
	          result = (Object[])list.get(i);
	          invCode = result[0].toString();
	          invName = result[1].toString();
	          amountIn =(BigDecimal)result[2];
	          priceIn = (BigDecimal)result[3];
	          amountOut = (BigDecimal)result[4];
	          
	          if(amountIn!=null){
	              if(amountOut==null){
	                  amountOut = new BigDecimal(0);
	              }
	              avgPrice = priceIn.divide(amountIn,2,BigDecimal.ROUND_HALF_DOWN);
	             
	              
	              balanceAmount = amountIn.subtract(amountOut);
	              totalPrice = avgPrice.multiply(balanceAmount).setScale(2,BigDecimal.ROUND_HALF_DOWN);
	              item = new TableItem(tableInventories,SWT.NULL);
	              item.setText(new String[]{
	                        invCode,
	                        invName,
	                        balanceAmount.toString(),
	                        curFormat.format(avgPrice),
	                        curFormat.format(totalPrice)
	              			});     
	              
	          }
	          
	          
	          
	          
	      }
	      
	      
	    
	    
	    
	    }
	    catch(Exception ex){
	        
	        ex.printStackTrace();
	    
	    }
	    
	    
	    
	}
	public void delete(){
	    
	}
	

    public void exportToExcel() {
        EngBLUtils.Export2Excel(tableInventories);

    }
    public void printTable() {
        EngBLUtils.printTable(tableInventories,Messages.getString("InvUIInventoryLedger.5"));	     //$NON-NLS-1$

    }
}
