package com.turquaz.inventory.ui;


import java.util.Iterator;
import java.util.Set;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.SWT;


import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.TableColumn;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryPrice;


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
public class InvUIPriceChooseDialog extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;

	private TurqInventoryCard invCard=null;
	private Table tableInvPrices;
	private TableColumn tableColumnPriceType;
	private TableColumn tableColumnCurrency;
	private TableColumn tableColumnAmount;
	TurqInventoryPrice price;

	public InvUIPriceChooseDialog(Shell parent, int style,TurqInventoryCard invCard) {
		super(parent, style);
		this.invCard = invCard;
	}

	public TurqInventoryPrice open() {
		try {
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

			GridLayout dialogShellLayout = new GridLayout();
			dialogShell.setLayout(dialogShellLayout);
			dialogShellLayout.horizontalSpacing = 0;
			dialogShellLayout.marginHeight = 0;
			dialogShellLayout.marginWidth = 0;
			dialogShellLayout.verticalSpacing = 0;
			
			dialogShell.setSize(296, 242);
			{
				tableInvPrices = new Table(dialogShell, SWT.NONE);
				GridData tableInvPricesLData = new GridData();
				tableInvPrices.addMouseListener(new MouseAdapter() {
					public void mouseDoubleClick(MouseEvent evt) {
						tableMouseDoubleClick();
					}
				});
				tableInvPrices.setHeaderVisible(true);
				tableInvPrices.setLinesVisible(true);
				tableInvPricesLData.grabExcessHorizontalSpace = true;
				tableInvPricesLData.grabExcessVerticalSpace = true;
				tableInvPricesLData.horizontalAlignment = GridData.FILL;
				tableInvPricesLData.verticalAlignment = GridData.FILL;
				tableInvPrices.setLayoutData(tableInvPricesLData);
				{
					tableColumnPriceType = new TableColumn(
						tableInvPrices,
						SWT.NONE);
					tableColumnPriceType.setText("Fiyat Tipi");
					tableColumnPriceType.setWidth(78);
				}
				{
					tableColumnAmount = new TableColumn(
						tableInvPrices,
						SWT.NONE);
					tableColumnAmount.setText("Miktar");
					tableColumnAmount.setWidth(100);
				}
				{
					tableColumnCurrency = new TableColumn(
						tableInvPrices,
						SWT.NONE);
					tableColumnCurrency.setText("Para Birimi");
					tableColumnCurrency.setWidth(87);
				}
			}
			
			postInitGui();
			
			dialogShell.layout();
			dialogShell.pack();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
			return this.price;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public void postInitGui(){
		Set prices = invCard.getTurqInventoryPrices();
		TurqInventoryPrice price;
		TableItem item ;
		Iterator it = prices.iterator();
		while(it.hasNext()){
		price = (TurqInventoryPrice)it.next();
		item = new TableItem(tableInvPrices,SWT.NULL);
		String type ="";
		if(price.isPricesType()){
			type = "Al??";
			
		}
		else{
			type= "Sat??";
		}
		item.setText(new String[]{type,
				price.getPricesAmount().toString(),
				price.getTurqCurrency().getCurrenciesAbbreviation()});
		item.setData(price);
		}
		
		
		
	}
	public void tableMouseDoubleClick(){
		TableItem items[] = tableInvPrices.getItems();
		if(items.length>0){
		price =(TurqInventoryPrice) items[0].getData();	
		dialogShell.close();
		}
		
	}
	
}