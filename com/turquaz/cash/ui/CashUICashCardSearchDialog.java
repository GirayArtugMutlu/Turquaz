package com.turquaz.cash.ui;

import java.util.HashMap;
import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;

import com.turquaz.cash.CashKeys;
import com.turquaz.engine.ui.EngUICommon;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import com.turquaz.engine.ui.component.SearchDialogMenu;
import com.turquaz.cash.bl.CashBLCashCardSearch;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.interfaces.SearchDialogInterface;
import com.turquaz.engine.lang.CashLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;


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
public class CashUICashCardSearchDialog extends org.eclipse.swt.widgets.Dialog implements SearchDialogInterface {

	private Shell dialogShell;
	private Text txtCashName;
	private SearchDialogMenu searchMenu;
	private TableColumn colDefinition;
	private TableColumn colCashName;
	private Table tableCashSearch;
	private CLabel cashName;
	private Composite compCashSearch;
	public String cardCodeReturn = "";


	public CashUICashCardSearchDialog(Shell parent, int style) {
		super(parent, style);
	}

	public String open(String code) {
		try {
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL | SWT.RESIZE | SWT.MAX);

			GridLayout dialogShellLayout = new GridLayout();
			dialogShell.setLayout(dialogShellLayout);
			{
				GridData searchMenuLData = new GridData();
				searchMenuLData.grabExcessHorizontalSpace = true;
				searchMenuLData.horizontalAlignment = GridData.FILL;
				searchMenu = new SearchDialogMenu(dialogShell, SWT.NONE,this);
				searchMenu.setLayoutData(searchMenuLData);
			}
			{
				compCashSearch = new Composite(dialogShell, SWT.NONE);
				GridLayout compCashSearchLayout = new GridLayout();
				compCashSearchLayout.numColumns = 2;
				GridData compCashSearchLData = new GridData();
				compCashSearchLData.widthHint = 237;
				compCashSearchLData.heightHint = 27;
				compCashSearch.setLayoutData(compCashSearchLData);
				compCashSearch.setLayout(compCashSearchLayout);
				{
					cashName = new CLabel(compCashSearch, SWT.NONE);
					cashName.setText(CashLangKeys.STR_CASH_CARD);
				}
				{
					txtCashName = new Text(compCashSearch, SWT.NONE);
					GridData txtCashNameLData = new GridData();
					txtCashNameLData.widthHint = 157;
					txtCashNameLData.heightHint = 17;
					txtCashName.setLayoutData(txtCashNameLData);
					txtCashName.setText(code);

				}
			}
			{
				GridData tableCashSearchLData = new GridData();
				tableCashSearchLData.grabExcessHorizontalSpace = true;
				tableCashSearchLData.grabExcessVerticalSpace = true;
				tableCashSearchLData.verticalAlignment = GridData.FILL;
				tableCashSearchLData.horizontalAlignment = GridData.FILL;
				tableCashSearch = new Table(dialogShell, SWT.FULL_SELECTION);
				tableCashSearch.setLayoutData(tableCashSearchLData);
				tableCashSearch.setHeaderVisible(true);
				tableCashSearch.setLinesVisible(true);
                tableCashSearch.addMouseListener(new MouseAdapter() {
                    public void mouseDoubleClick(MouseEvent evt) {
                        choose();
                    }
                });
				{
					colCashName = new TableColumn(tableCashSearch, SWT.NONE);
					colCashName.setText(CashLangKeys.STR_CASH_CARD);
					colCashName.setWidth(113);
				}
				{
					colDefinition = new TableColumn(tableCashSearch, SWT.NONE);
					colDefinition.setText(EngLangCommonKeys.STR_DESCRIPTION);
					colDefinition.setWidth(279);
				}
			}
			if (!cardCodeReturn.equals(""))
			{
				search();
			}
			dialogShell.layout();
			dialogShell.pack();
			dialogShell.setSize(482, 369);
           EngUICommon.centreWindow(dialogShell);
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
			return cardCodeReturn;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cardCodeReturn;
	}
	
	public void search ()
	{
		try {
			
			tableCashSearch.removeAll();
			HashMap argMap=new HashMap();
			
			argMap.put(CashKeys.CASH_CARD_NAME,txtCashName.getText().trim());

			List listCashCards =(List) EngTXCommon.doTransactionTX(CashBLCashCardSearch.class.getName(),"searchCashCard",argMap);
			
			TableItem item;
			
			for (int i = 0; i < listCashCards.size(); i++)
			{
				
				TurqCashCard card = new TurqCashCard();
				card = (TurqCashCard) listCashCards.get(i);
				String cardName = card.getCashCardName();
				String cardDefinition = card.getCashCardDefinition();
				item = new TableItem(tableCashSearch, SWT.NULL);
				item.setData(cardName);
				
				item.setText(new String[]{cardName,cardDefinition});	}
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		
	}
	
	public void choose ()
	{
		if (tableCashSearch.getSelection().length > 0) {
			cardCodeReturn = (String)tableCashSearch.getSelection()[0].getData();
			dialogShell.close();
		}
		
	}
	
	
}
