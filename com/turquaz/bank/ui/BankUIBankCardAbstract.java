package com.turquaz.bank.ui;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.eclipse.swt.widgets.Composite;

import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.bank.Messages;
import com.turquaz.bank.bl.BankBLTransactionSearch;
import com.turquaz.bank.ui.comp.BankCardPicker;

import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;



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
public class BankUIBankCardAbstract extends org.eclipse.swt.widgets.Composite implements SearchComposite{

    {
        //Register as a resource user - SWTResourceManager will
        //handle the obtaining and disposing of resources
        SWTResourceManager.registerResourceUser(this);
    }

	private Composite compSearchPanel;
	private TableColumn tableColumnDate;
	private CLabel lblBankCard;
	private TableColumn tableColumnBalanceCredit;
	private TableColumn tableColumnBalanceDept;
	private TableColumn tableColumnTransType;
	private DatePicker dateEndDate;
	private CLabel lblEndDate;
	private DatePicker dateStartDate;
	private CLabel lblStartDate;
	private BankCardPicker bankPicker;
	private TableColumn tableColumnCredit;
	private TableColumn tableColumnDebit;
	private TableColumn tableColumnDefinition;
	private TableColumn tableColumnBankCode;
	private Table tableAbstract;

	public BankUIBankCardAbstract(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setBackground(SWTResourceManager.getColor(255, 255, 255));
			this.setSize(659, 387);
            {
                compSearchPanel = new Composite(this, SWT.NONE);
                GridLayout compSearchPanelLayout = new GridLayout();
                compSearchPanelLayout.numColumns = 2;
                GridData compSearchPanelLData = new GridData();
                compSearchPanelLData.grabExcessHorizontalSpace = true;
                compSearchPanelLData.horizontalAlignment = GridData.FILL;
                compSearchPanelLData.heightHint = 90;
                compSearchPanel.setLayoutData(compSearchPanelLData);
                compSearchPanel.setLayout(compSearchPanelLayout);
                {
                    lblBankCard = new CLabel(compSearchPanel, SWT.NONE);
                    lblBankCard.setText(Messages.getString("BankUIBankCardAbstract.0")); //$NON-NLS-1$
                }
                {
                    bankPicker = new BankCardPicker(compSearchPanel, SWT.NONE);
                    GridData bankPickerLData = new GridData();
                    bankPickerLData.widthHint = 178;
                    bankPickerLData.heightHint = 16;
                    bankPicker.setLayoutData(bankPickerLData);
                }
                {
                    lblStartDate = new CLabel(compSearchPanel, SWT.NONE);
                    lblStartDate.setText(Messages.getString("BankUIBankCardAbstract.1")); //$NON-NLS-1$
                }
                {
                    dateStartDate = new DatePicker(compSearchPanel, SWT.NONE);
                    GridData dateStartDateLData = new GridData();
                    dateStartDateLData.widthHint = 112;
                    dateStartDateLData.heightHint = 20;
                    dateStartDate.setLayoutData(dateStartDateLData);
                }
                {
                    lblEndDate = new CLabel(compSearchPanel, SWT.NONE);
                    lblEndDate.setText(Messages.getString("BankUIBankCardAbstract.2")); //$NON-NLS-1$
                }
                {
                    dateEndDate = new DatePicker(compSearchPanel, SWT.NONE);
                    GridData dateEndDateLData = new GridData();
                    dateEndDateLData.widthHint = 110;
                    dateEndDateLData.heightHint = 20;
                    dateEndDate.setLayoutData(dateEndDateLData);
                }
            }
            {
                tableAbstract = new Table(this, SWT.SINGLE | SWT.FULL_SELECTION);
                GridData tableAbstractLData = new GridData();
                tableAbstract.setLinesVisible(true);
                tableAbstract.setHeaderVisible(true);
                tableAbstractLData.grabExcessHorizontalSpace = true;
                tableAbstractLData.horizontalAlignment = GridData.FILL;
                tableAbstractLData.verticalAlignment = GridData.FILL;
                tableAbstractLData.grabExcessVerticalSpace = true;
                tableAbstract.setLayoutData(tableAbstractLData);
                {
                    tableColumnDate = new TableColumn(tableAbstract, SWT.NONE);
                    tableColumnDate.setText(Messages.getString("BankUIBankCardAbstract.3")); //$NON-NLS-1$
                    tableColumnDate.setWidth(83);
                }
                {
                    tableColumnBankCode = new TableColumn(
                        tableAbstract,
                        SWT.NONE);
                    tableColumnBankCode.setText(Messages.getString("BankUIBankCardAbstract.4")); //$NON-NLS-1$
                }
				//START >>  tableColumnTransType
				tableColumnTransType = new TableColumn(tableAbstract, SWT.NONE);
				tableColumnTransType.setText("HareketTipi");
				tableColumnTransType.setWidth(97);
				//END <<  tableColumnTransType
                {
                    tableColumnDefinition = new TableColumn(
                        tableAbstract,
                        SWT.NONE);
                    tableColumnDefinition.setText(Messages.getString("BankUIBankCardAbstract.5")); //$NON-NLS-1$
                    tableColumnDefinition.setWidth(110);
                }
                {
                    tableColumnDebit = new TableColumn(tableAbstract, SWT.RIGHT);
                    tableColumnDebit.setText(Messages.getString("BankUIBankCardAbstract.6")); //$NON-NLS-1$
                    tableColumnDebit.setWidth(62);
                }
                {
                    tableColumnCredit = new TableColumn(tableAbstract, SWT.RIGHT);
                    tableColumnCredit.setText(Messages.getString("BankUIBankCardAbstract.7")); //$NON-NLS-1$
                    tableColumnCredit.setWidth(67);
                }
				//START >>  tableColumnBalanceDept
				tableColumnBalanceDept = new TableColumn(tableAbstract, SWT.RIGHT);
				tableColumnBalanceDept.setText("Bakiye Borç");
				tableColumnBalanceDept.setWidth(84);
				//END <<  tableColumnBalanceDept
				//START >>  tableColumnBalanceCredit
				tableColumnBalanceCredit = new TableColumn(
					tableAbstract,
					SWT.NONE);
				tableColumnBalanceCredit.setText("Bakiye Alacak");
				tableColumnBalanceCredit.setWidth(84);
				//END <<  tableColumnBalanceCredit
            }
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

    public void delete() {
       

    }
    public void exportToExcel() {
        EngBLUtils.Export2Excel(tableAbstract);

    }
    public void printTable() {
       EngBLUtils.printTable(tableAbstract,Messages.getString("BankUIBankCardAbstract.9")); //$NON-NLS-1$

    }
    
    public boolean verifyFields(){
        if(bankPicker.getData()==null)
        {
            EngUICommon.showMessageBox(getShell(),Messages.getString("BankUIBankCardAbstract.8"),SWT.ICON_WARNING); //$NON-NLS-1$
            bankPicker.setFocus();
            return false;
        }
        
        return true;
        
    
    }
    
    public void search() {
       try
       {
           if(verifyFields()){
           
               tableAbstract.removeAll();
               
               TurkishCurrencyFormat cf = new TurkishCurrencyFormat();   
               TableItem item = new TableItem(tableAbstract,SWT.NULL);   
               
               BigDecimal total_dept=new BigDecimal(0);
               BigDecimal total_credit = new BigDecimal(0);
               BigDecimal deferred_dept = new BigDecimal(0);
               BigDecimal deferred_credit = new BigDecimal(0);
               BigDecimal balance = new BigDecimal (0);
                            
               List deferred = BankBLTransactionSearch.getDeferredTotal((TurqBanksCard)bankPicker.getData(),dateStartDate.getDate());
               
               if(deferred.size()!=0){
                   
                   Object[] amounts = (Object[])deferred.get(0);          
                  
                   deferred_dept = deferred_dept.add((BigDecimal)amounts[0]);
                   deferred_credit = deferred_credit.add((BigDecimal)amounts[1]);
                   balance = deferred_dept.subtract(deferred_credit);
                   if(balance.doubleValue()>0)
                   {
                    item.setText(new String[]{
                            "","","",Messages.getString("BankUIBankCardAbstract.11"),cf.format(amounts[0]),cf.format(amounts[1]),cf.format(balance),cf.format(new BigDecimal(0)) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                    			});                   
                   }
                  else
                   {
                    item.setText(new String[]{
                            "","","",Messages.getString("BankUIBankCardAbstract.11"),cf.format(amounts[0]),cf.format(amounts[1]),cf.format(new BigDecimal(0)),cf.format(balance.negate()) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                    			});                   
                   }
               }
               else
               {
                   item.setText(new String[]{
                           "","",Messages.getString("BankUIBankCardAbstract.14"),cf.format(0),cf.format(0),cf.format(0),cf.format(0) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                   			});
               }
               
               
               List ls = BankBLTransactionSearch.getTransactions((TurqBanksCard)bankPicker.getData(),dateStartDate.getDate(),dateEndDate.getDate());
               
             
                 BigDecimal credit;
                 BigDecimal dept;
                 for(int i =0; i<ls.size();i++)
                 {
                     credit = new BigDecimal(0);
                     dept = new BigDecimal(0);
                     

                     Object results[] = (Object[])ls.get(i);
                     if(results[3]!=null)
                     {
                        dept = (BigDecimal)results[3]; 
                     }
                     
                     if(results[4]!=null){
                         credit = (BigDecimal)results[4];
                     }
                     
                     item = new TableItem(tableAbstract,SWT.NULL);
                     item.setText(new String[]{
                             		DatePicker.formatter.format((Date)results[0]),
                             		results[1].toString(),
									results[5].toString(),
                             		results[2].toString(),
                             		cf.format(dept),
                             		cf.format(credit),
                     				});
                     
                     total_dept = total_dept.add(dept);
                     total_credit = total_credit.add(credit);
                     balance = balance.add(dept).subtract(credit);
                     if(balance.doubleValue()>0)
                     {
                     	  item.setText(new String[]{
                         		DatePicker.formatter.format((Date)results[0]),
                         		results[1].toString(),
								results[5].toString(),
                         		results[2].toString(),
                         		cf.format(dept),
                         		cf.format(credit),
								cf.format(balance),
								cf.format(0)
                 				});               
                     }
                    else
                     {
                    	 item.setText(new String[]{
                         		DatePicker.formatter.format((Date)results[0]),
                         		results[1].toString(),
								results[5].toString(),
                         		results[2].toString(),
                         		cf.format(dept),
                         		cf.format(credit),
								cf.format(0),
								cf.format(balance.negate())
                 				});                  
                     }
                     
                     
                     
                 }
                 
                 item=new TableItem(tableAbstract,SWT.NULL);
                 item=new TableItem(tableAbstract,SWT.NULL);
                 
                 String balance_dept ="";
                 String balance_credit ="";
                if(total_dept.subtract(total_credit).doubleValue()>0)
                {
                	balance_dept = cf.format(total_dept.subtract(total_credit));
                	balance_credit = cf.format(0);
                }
                else
                {
                	balance_credit = cf.format(total_dept.subtract(total_credit).negate());
                	balance_dept = cf.format(0);
                }
                 item.setText(new String[]{
                               "", //$NON-NLS-1$
                               "", //$NON-NLS-1$
							   "",
                               Messages.getString("BankUIBankCardAbstract.17"), //$NON-NLS-1$
                               cf.format(total_dept),
                               cf.format(total_credit),
							   balance_dept,
							   balance_credit
                                });
                 
                 if(balance.doubleValue()>0)
                 {
                 	balance_dept = cf.format(balance);
                 	balance_credit = cf.format(0);
                 	
                 }
                 else
                 {
                 	balance_credit = cf.format(balance.negate());
                 	balance_dept = cf.format(0);
                 	
                 }
                 item=new TableItem(tableAbstract,SWT.NULL);  
                 item.setText(new String[]{
                         "", //$NON-NLS-1$
                         "", //$NON-NLS-1$
						 "",
                         Messages.getString("BankUIBankCardAbstract.20"), //$NON-NLS-1$
                         cf.format(deferred_dept),
                         cf.format(deferred_credit),
						 balance_dept,
						 balance_credit
                          });
                 
                 
                 BigDecimal grand_total_dept = deferred_dept.add(total_dept);
                 BigDecimal grand_total_credit = deferred_credit.add(total_credit);
             
                 if(grand_total_dept.subtract(grand_total_credit).doubleValue()>0)
                 {
                 	balance_dept = cf.format(grand_total_dept.subtract(grand_total_credit));
                 	balance_credit = cf.format(0);
                 }
                 else
                 {
                 	balance_credit = cf.format(grand_total_dept.subtract(grand_total_credit).negate());
                 	balance_dept = cf.format(0);
                 }
                 
                 
                 item=new TableItem(tableAbstract,SWT.NULL);  
                 item.setText(new String[]{
                         "", //$NON-NLS-1$
                         "", //$NON-NLS-1$
						 "",
                         Messages.getString("BankUIBankCardAbstract.23"), //$NON-NLS-1$
                         cf.format(grand_total_dept),
                         cf.format(grand_total_credit),
						 balance_dept,
						 balance_credit
                          });           
           
           }
           
           
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
           EngUICommon.showMessageBox(getShell(),ex.getMessage().toString(),SWT.ICON_ERROR);
       }
        

    }
}
