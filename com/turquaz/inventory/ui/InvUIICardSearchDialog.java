package com.turquaz.inventory.ui;

import java.util.List;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableItem;

import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;

import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.inventory.Messages;
import com.turquaz.inventory.bl.InvBLCardSearch;


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
public class InvUIICardSearchDialog extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private Composite compInvCardSearchPanel;
	private CLabel lblInvName;
	private CCombo comboInvGroup;
	private Table tableSearcResults;
	private TableColumn tableColumnInvName;
	private Label label1;
	private Button btnSearch;
	private TableColumn tableColumnAmount;
	private TableColumn tableColumnInventoryCode;
	private CLabel lblInvGroup;
	private Text txtInvCode;
	private CLabel cLabel2;
	private Text txtInvName;
	TurqInventoryCard  invCard;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/
	public static void main(String[] args) {
		try {
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			InvUIICardSearchDialog inst = new InvUIICardSearchDialog(shell, SWT.NULL);
			inst.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public InvUIICardSearchDialog(Shell parent, int style) {
		super(parent, style);
	}

	public TurqInventoryCard open() {
		try {
		
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

				{
					//Register as a resource user - SWTResourceManager will
					//handle the obtaining and disposing of resources
					SWTResourceManager.registerResourceUser(dialogShell);
				}


			dialogShell.setLayout(new GridLayout());
			dialogShell.layout();
			dialogShell.pack();
			dialogShell.setSize(486, 418);
			{
				compInvCardSearchPanel = new Composite(dialogShell, SWT.NONE);
				GridLayout compInvCardSearchPanelLayout = new GridLayout();
				compInvCardSearchPanelLayout.numColumns = 2;
				GridData compInvCardSearchPanelLData = new GridData();
				compInvCardSearchPanel.setLayout(compInvCardSearchPanelLayout);
				compInvCardSearchPanelLData.horizontalAlignment = GridData.FILL;
				compInvCardSearchPanelLData.heightHint = 118;
				compInvCardSearchPanelLData.grabExcessHorizontalSpace = true;
				compInvCardSearchPanel.setLayoutData(compInvCardSearchPanelLData);
				{
					lblInvName = new CLabel(compInvCardSearchPanel, SWT.NONE);
					lblInvName.setText(Messages.getString("InvUICardSearch.0"));
					lblInvName.setSize(new org.eclipse.swt.graphics.Point(
						114,
						18));
					GridData lblInvNameLData = new GridData();
					lblInvNameLData.widthHint = 114;
					lblInvNameLData.heightHint = 18;
					lblInvName.setLayoutData(lblInvNameLData);
				}
				{
					txtInvName = new Text(compInvCardSearchPanel, SWT.NONE);
					txtInvName.setSize(new org.eclipse.swt.graphics.Point(
						168,
						16));
					GridData txtInvNameLData = new GridData();
					txtInvNameLData.widthHint = 162;
					txtInvNameLData.heightHint = 16;
					txtInvName.setLayoutData(txtInvNameLData);
				}
				{
					cLabel2 = new CLabel(compInvCardSearchPanel, SWT.NONE);
					cLabel2.setText(Messages.getString("InvUICardSearch.1"));
					cLabel2.setSize(new org.eclipse.swt.graphics.Point(97, 17));
					GridData cLabel2LData = new GridData();
					cLabel2LData.widthHint = 97;
					cLabel2LData.heightHint = 17;
					cLabel2.setLayoutData(cLabel2LData);
				}
				{
					txtInvCode = new Text(compInvCardSearchPanel, SWT.NONE);
					txtInvCode.setSize(new org.eclipse.swt.graphics.Point(
						147,
						17));
					GridData txtInvCodeLData = new GridData();
					txtInvCodeLData.widthHint = 141;
					txtInvCodeLData.heightHint = 17;
					txtInvCode.setLayoutData(txtInvCodeLData);
				}
				{
					lblInvGroup = new CLabel(compInvCardSearchPanel, SWT.NONE);
					lblInvGroup
						.setText(Messages.getString("InvUICardSearch.2"));
					lblInvGroup.setSize(new org.eclipse.swt.graphics.Point(
						110,
						17));
					GridData lblInvGroupLData = new GridData();
					lblInvGroupLData.widthHint = 110;
					lblInvGroupLData.heightHint = 17;
					lblInvGroup.setLayoutData(lblInvGroupLData);
				}
				{
					comboInvGroup = new CCombo(compInvCardSearchPanel, SWT.NONE);
					comboInvGroup.setSize(new org.eclipse.swt.graphics.Point(
						119,
						16));
					GridData comboInvGroupLData = new GridData();
					comboInvGroupLData.widthHint = 97;
					comboInvGroupLData.heightHint = 16;
					comboInvGroup.setLayoutData(comboInvGroupLData);
				}
				{
					label1 = new Label(compInvCardSearchPanel, SWT.SEPARATOR
						| SWT.HORIZONTAL);
					GridData label1LData = new GridData();
					label1LData.heightHint = 4;
					label1LData.horizontalAlignment = GridData.FILL;
					label1LData.horizontalSpan = 2;
					label1LData.grabExcessHorizontalSpace = true;
					label1.setLayoutData(label1LData);
				}
				{
					btnSearch = new Button(compInvCardSearchPanel, SWT.PUSH
						| SWT.CENTER);
					btnSearch.setText("button1");
					GridData btnSearchLData = new GridData();
					btnSearch.addMouseListener(new MouseAdapter() {
						public void mouseUp(MouseEvent evt) {
							search();
						}
					});
					btnSearch.setImage(SWTResourceManager.getImage("icons/Find24.gif"));
					btnSearchLData.horizontalAlignment = GridData.END;
					btnSearchLData.grabExcessHorizontalSpace = true;
					btnSearchLData.horizontalSpan = 2;
					btnSearchLData.widthHint = 62;
					btnSearchLData.heightHint = 34;
					btnSearch.setLayoutData(btnSearchLData);
				}
			}
			{
				tableSearcResults = new Table(dialogShell, SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
				tableSearcResults.setHeaderVisible(true);
				tableSearcResults.setLinesVisible(true);
				tableSearcResults.setSize(new org.eclipse.swt.graphics.Point(
					543,
					318));
				GridData tableSearcResultsLData = new GridData();
				tableSearcResults.addMouseListener(new MouseAdapter() {
					public void mouseDoubleClick(MouseEvent evt) {
						tableSearcResultsMouseDoubleClick(evt);
					}
				});
				tableSearcResultsLData.verticalAlignment = GridData.FILL;
				tableSearcResultsLData.horizontalAlignment = GridData.FILL;
				tableSearcResultsLData.grabExcessHorizontalSpace = true;
				tableSearcResultsLData.grabExcessVerticalSpace = true;
				tableSearcResults.setLayoutData(tableSearcResultsLData);
				{
					tableColumnInvName = new TableColumn(
						tableSearcResults,
						SWT.NONE);
					tableColumnInvName.setText(Messages
						.getString("InvUICardSearch.0"));
					tableColumnInvName.setWidth(115);
				}
				{
					tableColumnInventoryCode = new TableColumn(
						tableSearcResults,
						SWT.NONE);
					tableColumnInventoryCode.setText(Messages
						.getString("InvUICardSearch.1"));
					tableColumnInventoryCode.setWidth(107);
				}
				{
					tableColumnAmount = new TableColumn(
						tableSearcResults,
						SWT.NONE);
					tableColumnAmount.setText(Messages
						.getString("InvUICardSearch.5"));
					tableColumnAmount.setWidth(118);
				}
			}
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
			return invCard;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	protected void tableSearcResultsMouseDoubleClick(MouseEvent evt){
	    TableItem [] selection= tableSearcResults.getSelection();	
		
		if(selection.length>0){
		
		 invCard = (TurqInventoryCard)selection[0].getData();
	     dialogShell.close();
		
		}
		}
	public void search(){
		tableSearcResults.removeAll();
		InvBLCardSearch cardSearch = new InvBLCardSearch();
		List result;
		try{
		if(comboInvGroup.getSelectionIndex()==-1){
		result = cardSearch.searchCards(txtInvName.getText().trim(),txtInvCode.getText().trim(),null);
		
		}
		else{
		result = cardSearch.searchCards(txtInvName.getText().trim(),txtInvCode.getText().trim(),(TurqInventoryGroup)comboInvGroup.getData(comboInvGroup.getText()));
		
		}
		
		TableItem item;
		int listSize = result.size();
		for(int i =0; i<listSize;i++){
		TurqInventoryCard card = (TurqInventoryCard)result.get(i);
		item = new TableItem(tableSearcResults,SWT.NULL);
		item.setData(card);
		item.setText(new String[]{card.getCardName(),card.getCardInventoryCode()});
		
		
		}
	
		}
		catch(Exception ex){
		ex.printStackTrace();
		}
		
		
		
		
			
		}

	
}
