package com.turquaz.cheque.ui;

import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.cheque.Messages;
import com.turquaz.cheque.bl.CheBLSearchChequeRoll;
import com.turquaz.engine.dal.TurqChequeCheque;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class CheUICustomerChequeChooseDialog extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private Table tableCheques;
	private TableColumn tableColumnDebtor;
	private TableColumn tableColumnAmount;
	private TableColumn tableColumnDueDate;
	private TableColumn tableColumnCurrentCard;
	private TableColumn tableColumnNo;
	private ToolItem toolCancel;
	private ToolItem toolSave;
	private ToolBar toolBar;
	boolean isUpdated = false;
	List selectedCheques;

	public CheUICustomerChequeChooseDialog(Shell parent, int style, List selectedCheques)
	{
		super(parent, style);
		this.selectedCheques = selectedCheques;
	}

	public List open()
	{
		try
		{
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
			{
				//Register as a resource user - SWTResourceManager will
				//handle the obtaining and disposing of resources
				SWTResourceManager.registerResourceUser(dialogShell);
			}
			dialogShell.setLayout(new GridLayout());
			dialogShell.setText(Messages.getString("CheUICustomerChequeChooseDialog.0")); //$NON-NLS-1$
			dialogShell.layout();
			dialogShell.pack();
			dialogShell.setSize(647, 441);
			//START >> toolBar
			toolBar = new ToolBar(dialogShell, SWT.NONE);
			GridData toolBarLData = new GridData();
			toolBarLData.grabExcessHorizontalSpace = true;
			toolBarLData.horizontalAlignment = GridData.FILL;
			toolBar.setLayoutData(toolBarLData);
			//START >> toolSave
			toolSave = new ToolItem(toolBar, SWT.NONE);
			toolSave.setText(Messages.getString("CheUICustomerChequeChooseDialog.1")); //$NON-NLS-1$
			toolSave.setImage(SWTResourceManager.getImage("icons/save_edit.gif")); //$NON-NLS-1$
			toolSave.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent evt)
				{
					toolSaveWidgetSelected(evt);
				}
			});
			//END << toolSave
			//START >> toolCancel
			toolCancel = new ToolItem(toolBar, SWT.NONE);
			toolCancel.setText(Messages.getString("CheUICustomerChequeChooseDialog.3")); //$NON-NLS-1$
			toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg")); //$NON-NLS-1$
			toolCancel.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent evt)
				{
					dialogShell.close();
				}
			});
			//END << toolCancel
			//END << toolBar
			{
				tableCheques = new Table(dialogShell, SWT.CHECK);
				GridData tableChequesLData = new GridData();
				tableCheques.setLinesVisible(true);
				tableCheques.setHeaderVisible(true);
				tableChequesLData.horizontalAlignment = GridData.FILL;
				tableChequesLData.grabExcessHorizontalSpace = true;
				tableChequesLData.verticalAlignment = GridData.FILL;
				tableChequesLData.grabExcessVerticalSpace = true;
				tableCheques.setLayoutData(tableChequesLData);
				//START >> tableColumnNo
				tableColumnNo = new TableColumn(tableCheques, SWT.NONE);
				tableColumnNo.setText(Messages.getString("CheUICustomerChequeChooseDialog.5")); //$NON-NLS-1$
				tableColumnNo.setWidth(96);
				//END << tableColumnNo
				//START >> tableColumnCurrentCard
				tableColumnCurrentCard = new TableColumn(tableCheques, SWT.NONE);
				tableColumnCurrentCard.setText(Messages.getString("CheUICustomerChequeChooseDialog.6")); //$NON-NLS-1$
				tableColumnCurrentCard.setWidth(111);
				//END << tableColumnCurrentCard
				//START >> tableColumnDueDate
				tableColumnDueDate = new TableColumn(tableCheques, SWT.NONE);
				tableColumnDueDate.setText(Messages.getString("CheUICustomerChequeChooseDialog.7")); //$NON-NLS-1$
				tableColumnDueDate.setWidth(100);
				//END << tableColumnDueDate
				//START >> tableColumnDebtor
				tableColumnDebtor = new TableColumn(tableCheques, SWT.NONE);
				tableColumnDebtor.setText(Messages.getString("CheUICustomerChequeChooseDialog.8")); //$NON-NLS-1$
				tableColumnDebtor.setWidth(100);
				//END << tableColumnDebtor
				//START >> tableColumnAmount
				tableColumnAmount = new TableColumn(tableCheques, SWT.RIGHT);
				tableColumnAmount.setText(Messages.getString("CheUICustomerChequeChooseDialog.9")); //$NON-NLS-1$
				tableColumnAmount.setWidth(100);
				//END << tableColumnAmount
			}
			postInitGUI();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed())
			{
				if (!display.readAndDispatch())
					display.sleep();
			}
			return selectedCheques;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return selectedCheques;
		}
	}

	public void postInitGUI()
	{
		EngUICommon.centreWindow(dialogShell);
		fillTable();
		if (selectedCheques != null)
		{
			TableItem items[] = tableCheques.getItems();
			for (int i = 0; i < items.length; i++)
			{
				if (selectedCheques.contains(items[i].getData()))
				{
					items[i].setChecked(true);
				}
			}
		}
	}

	public void fillTable()
	{
		try
		{
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			List ls = CheBLSearchChequeRoll.getChequesInPortfolio();
			TurqChequeCheque cheque;
			TableItem item;
			String currentName;
			for (int i = 0; i < ls.size(); i++)
			{
				cheque = (TurqChequeCheque) ls.get(i);
				item = new TableItem(tableCheques, SWT.NULL);
				item.setData(cheque);
				item.setText(new String[]{cheque.getChequesPortfolioNo(),
						CheBLSearchChequeRoll.getCurrentCardOfCustomerCheque(cheque).getCardsName(),
						DatePicker.formatter.format(cheque.getChequesDueDate()), cheque.getChequesDebtor(),
						cf.format(cheque.getChequesAmount())});
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
			EngUICommon.showMessageBox(getParent(), ex.getMessage().toString(), SWT.ICON_ERROR);
		}
	}

	private void toolSaveWidgetSelected(SelectionEvent evt)
	{
		TableItem items[] = tableCheques.getItems();
		for (int i = 0; i < items.length; i++)
		{
			if (selectedCheques.contains(items[i].getData()))
			{
				if (!items[i].getChecked())
				{
					selectedCheques.remove(items[i].getData());
				}
			}
			else
			{
				if (items[i].getChecked())
				{
					selectedCheques.add(items[i].getData());
				}
			}
		}
		dialogShell.close();
	}
}