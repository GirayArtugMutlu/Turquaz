package com.turquaz.current.ui;

import java.util.List;
import java.util.Set;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;

import com.turquaz.current.Messages;
import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentContact;
import com.turquaz.engine.dal.TurqCurrentGroup;


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
public class CurUICurrentCardSearchDialog extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private Composite compCurrentCardSearch;
	private Text txtCurrentCode;
	private TableColumn tableColumnContactName;
	private TableColumn tableColumnCurrentName;
	private TableColumn tableColumnCurrentCode;
	private Table tableCurrentCardSearch;
	private CCombo comboTurqGroupName;
	private CLabel lblTurqGroupName;
	private Text txtCurrentName;
	private CLabel lblCurrentName;
	private CLabel lblCurrentCode;
	private CurBLCurrentCardSearch curBLCurrentCardSearch=new CurBLCurrentCardSearch();
	private EngBLCommon engBLCom=new EngBLCommon();
	 Object returnData=null;
	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/
	public static void main(String[] args) {
		try {
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			CurUICurrentCardSearchDialog inst = new CurUICurrentCardSearchDialog(shell, SWT.NULL);
			inst.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CurUICurrentCardSearchDialog(Shell parent, int style) {
		super(parent, style);
	}

	public Object open() {
	 
		try {
			
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

			dialogShell.setLayout(new GridLayout());
			dialogShell.layout();
			dialogShell.pack();
			dialogShell.setSize(438, 619);
			{
				compCurrentCardSearch = new Composite(dialogShell, SWT.NONE);
				GridLayout compCurrentCardSearchLayout = new GridLayout();
				compCurrentCardSearchLayout.numColumns = 2;
				GridData compCurrentCardSearchLData = new GridData();
				compCurrentCardSearch.setLayout(compCurrentCardSearchLayout);
				compCurrentCardSearchLData.heightHint = 114;
				compCurrentCardSearchLData.grabExcessHorizontalSpace = true;
				compCurrentCardSearchLData.horizontalAlignment = GridData.FILL;
				compCurrentCardSearch.setLayoutData(compCurrentCardSearchLData);
				{
					lblCurrentCode = new CLabel(compCurrentCardSearch, SWT.NONE);
					lblCurrentCode.setText(Messages.getString("CurUICurrentCardSearch.0"));
					GridData lblCurrentCodeLData = new GridData();
					lblCurrentCode.setLayoutData(lblCurrentCodeLData);
				}
				{
					txtCurrentCode = new Text(compCurrentCardSearch, SWT.NONE);
					txtCurrentCode.setSize(new org.eclipse.swt.graphics.Point(
						244,
						13));
					GridData txtCurrentCodeLData = new GridData();
					txtCurrentCodeLData.widthHint = 238;
					txtCurrentCodeLData.heightHint = 13;
					txtCurrentCode.setLayoutData(txtCurrentCodeLData);
				}
				{
					lblCurrentName = new CLabel(compCurrentCardSearch, SWT.NONE);
					lblCurrentName.setText(Messages
						.getString("CurUICurrentCardSearch.1"));
					GridData lblCurrentNameLData = new GridData();
					lblCurrentName.setLayoutData(lblCurrentNameLData);
				}
				{
					txtCurrentName = new Text(compCurrentCardSearch, SWT.NONE);
					txtCurrentName.setSize(new org.eclipse.swt.graphics.Point(
						244,
						13));
					GridData txtCurrentNameLData = new GridData();
					txtCurrentNameLData.widthHint = 238;
					txtCurrentNameLData.heightHint = 13;
					txtCurrentName.setLayoutData(txtCurrentNameLData);
				}
				{
					lblTurqGroupName = new CLabel(compCurrentCardSearch, SWT.NONE);
					lblTurqGroupName.setText(Messages
						.getString("CurUICurrentCardSearch.2"));
					lblTurqGroupName
						.setSize(new org.eclipse.swt.graphics.Point(65, 19));
					GridData lblTurqGroupNameLData = new GridData();
					lblTurqGroupNameLData.widthHint = 65;
					lblTurqGroupNameLData.heightHint = 19;
					lblTurqGroupName.setLayoutData(lblTurqGroupNameLData);
				}
				{
					comboTurqGroupName = new CCombo(compCurrentCardSearch, SWT.NONE);
					GridData comboTurqGroupNameLData = new GridData();
					comboTurqGroupName.setLayoutData(comboTurqGroupNameLData);
				}
			}
			{
				tableCurrentCardSearch = new Table(dialogShell, SWT.FULL_SELECTION | SWT.H_SCROLL);
				tableCurrentCardSearch.setHeaderVisible(true);
				tableCurrentCardSearch.setLinesVisible(true);
				tableCurrentCardSearch
					.setSize(new org.eclipse.swt.graphics.Point(409, 168));
				GridData tableCurrentCardSearchLData = new GridData();
				tableCurrentCardSearch.addMouseListener(new MouseAdapter() {
					public void mouseDoubleClick(MouseEvent evt) {
						if (tableCurrentCardSearch.getSelection().length > 0) {
							returnData = tableCurrentCardSearch.getSelection()[0];
							dialogShell.close();
							
						}

					}
				});
				tableCurrentCardSearchLData.verticalAlignment = GridData.FILL;
				tableCurrentCardSearchLData.horizontalAlignment = GridData.FILL;
				tableCurrentCardSearchLData.grabExcessHorizontalSpace = true;
				tableCurrentCardSearchLData.grabExcessVerticalSpace = true;
				tableCurrentCardSearch.setLayoutData(tableCurrentCardSearchLData);
				{
					tableColumnCurrentCode = new TableColumn(
						tableCurrentCardSearch,
						SWT.NONE);
					tableColumnCurrentCode.setText(Messages
						.getString("CurUICurrentCardSearch.0"));
					tableColumnCurrentCode.setWidth(120);
				}
				{
					tableColumnCurrentName = new TableColumn(
						tableCurrentCardSearch,
						SWT.NONE);
					tableColumnCurrentName.setText(Messages
						.getString("CurUICurrentCardSearch.1"));
					tableColumnCurrentName.setWidth(120);
				}
				{
					tableColumnContactName = new TableColumn(tableCurrentCardSearch, SWT.NONE);
					tableColumnContactName.setText(Messages
						.getString("CurUICurrentCardSearch.5"));
					tableColumnContactName.setWidth(120);
				}
			}
			dialogShell.open();
			
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
			return returnData;
		} catch (Exception e) {
			e.printStackTrace();
			return returnData;
		}
		
		
	}
	public void search(){
		try{
			tableCurrentCardSearch.removeAll();
			List listCurrentCards=curBLCurrentCardSearch.searchCurrentCard(txtCurrentCode.getText().trim(),
																		txtCurrentName.getText().trim(),(TurqCurrentGroup)comboTurqGroupName.getData(comboTurqGroupName.getText()));

			for(int k=0; k<listCurrentCards.size(); k++){
				TurqCurrentCard aCurrentCard=(TurqCurrentCard)listCurrentCards.get(k);
				TableItem item=new TableItem(tableCurrentCardSearch, SWT.NULL);
				item.setData(aCurrentCard);
 				
 				String contactName =""; //$NON-NLS-1$
 				Set contacts = aCurrentCard.getTurqCurrentContacts();
 				
 				if(contacts.size()>0){
 				Object curContact[] = contacts.toArray();
 				contactName = ((TurqCurrentContact)curContact[0]).getContactsName();
 				
 				}
 					
 				
 				item.setText(new String[]{aCurrentCard.getCardsCurrentCode(),aCurrentCard.getCardsName(),contactName});
                  			
			}
		
	
		}
		catch(Exception ex){
			ex.printStackTrace();
			MessageBox msg=new MessageBox(this.getParent(),SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
			
		}
	}
	
}