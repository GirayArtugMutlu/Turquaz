package com.turquaz.current.ui;

import java.util.List;
import java.util.Set;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;

import com.turquaz.bank.ui.BankUIBankCardUpdate;
import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentContact;
import com.turquaz.engine.dal.TurqCurrentGroup;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import com.turquaz.engine.ui.component.SecureComposite;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class CurUICurrentCardSearch extends SecureComposite {

	private CCombo comboTurqGroupName;
private TableColumn tableColumnCurrentName;

private TableColumn tableColumnContactName;

	private TableColumn tableColumnCurrentCode;
	private Table tableCurrentCardSearch;
	private CLabel lblCurrentName;
	private CLabel lblCurrentCode;
	private Text txtCurrentCode;
	private Text txtCurrentName;
	private CLabel lblTurqGroupName;
	private Composite compCurrentCardSearch;
	
	private CurBLCurrentCardSearch curBLCurrentCardSearch=new CurBLCurrentCardSearch();
	private EngBLCommon engBLCom=new EngBLCommon();
	
	public CurUICurrentCardSearch(Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	/**
	* Initializes the GUI.
	* Auto-generated code - any changes you make will disappear.
	*/
	public void initGUI(){
		try {
			preInitGUI();
	
			compCurrentCardSearch = new Composite(this,SWT.NULL);
			lblCurrentCode = new CLabel(compCurrentCardSearch,SWT.NULL);
			txtCurrentCode = new Text(compCurrentCardSearch,SWT.NULL);
			lblCurrentName = new CLabel(compCurrentCardSearch,SWT.NULL);
			txtCurrentName = new Text(compCurrentCardSearch,SWT.NULL);
			lblTurqGroupName = new CLabel(compCurrentCardSearch,SWT.NULL);
			comboTurqGroupName = new CCombo(compCurrentCardSearch,SWT.NULL);
			tableCurrentCardSearch = new Table(this,SWT.FULL_SELECTION| SWT.H_SCROLL);
			tableColumnCurrentCode = new TableColumn(tableCurrentCardSearch,SWT.NULL);
			tableColumnCurrentName = new TableColumn(tableCurrentCardSearch,SWT.NULL);
			tableColumnContactName = new TableColumn(tableCurrentCardSearch,SWT.NULL);
	
			this.setSize(new org.eclipse.swt.graphics.Point(435,318));
	
			GridData compCurrentCardSearchLData = new GridData();
			compCurrentCardSearchLData.verticalAlignment = GridData.CENTER;
			compCurrentCardSearchLData.horizontalAlignment = GridData.BEGINNING;
			compCurrentCardSearchLData.widthHint = 425;
			compCurrentCardSearchLData.heightHint = 119;
			compCurrentCardSearchLData.horizontalIndent = 0;
			compCurrentCardSearchLData.horizontalSpan = 1;
			compCurrentCardSearchLData.verticalSpan = 1;
			compCurrentCardSearchLData.grabExcessHorizontalSpace = false;
			compCurrentCardSearchLData.grabExcessVerticalSpace = false;
			compCurrentCardSearch.setLayoutData(compCurrentCardSearchLData);
			compCurrentCardSearch.setSize(new org.eclipse.swt.graphics.Point(425,119));
	
			GridData lblCurrentCodeLData = new GridData();
			lblCurrentCodeLData.verticalAlignment = GridData.CENTER;
			lblCurrentCodeLData.horizontalAlignment = GridData.BEGINNING;
			lblCurrentCodeLData.widthHint = -1;
			lblCurrentCodeLData.heightHint = -1;
			lblCurrentCodeLData.horizontalIndent = 0;
			lblCurrentCodeLData.horizontalSpan = 1;
			lblCurrentCodeLData.verticalSpan = 1;
			lblCurrentCodeLData.grabExcessHorizontalSpace = false;
			lblCurrentCodeLData.grabExcessVerticalSpace = false;
			lblCurrentCode.setLayoutData(lblCurrentCodeLData);
			lblCurrentCode.setText("Current Code");
	
			GridData txtCurrentCodeLData = new GridData();
			txtCurrentCodeLData.verticalAlignment = GridData.CENTER;
			txtCurrentCodeLData.horizontalAlignment = GridData.BEGINNING;
			txtCurrentCodeLData.widthHint = 244;
			txtCurrentCodeLData.heightHint = 13;
			txtCurrentCodeLData.horizontalIndent = 0;
			txtCurrentCodeLData.horizontalSpan = 1;
			txtCurrentCodeLData.verticalSpan = 1;
			txtCurrentCodeLData.grabExcessHorizontalSpace = false;
			txtCurrentCodeLData.grabExcessVerticalSpace = false;
			txtCurrentCode.setLayoutData(txtCurrentCodeLData);
			txtCurrentCode.setSize(new org.eclipse.swt.graphics.Point(244,13));
	
			GridData lblCurrentNameLData = new GridData();
			lblCurrentNameLData.verticalAlignment = GridData.CENTER;
			lblCurrentNameLData.horizontalAlignment = GridData.BEGINNING;
			lblCurrentNameLData.widthHint = -1;
			lblCurrentNameLData.heightHint = -1;
			lblCurrentNameLData.horizontalIndent = 0;
			lblCurrentNameLData.horizontalSpan = 1;
			lblCurrentNameLData.verticalSpan = 1;
			lblCurrentNameLData.grabExcessHorizontalSpace = false;
			lblCurrentNameLData.grabExcessVerticalSpace = false;
			lblCurrentName.setLayoutData(lblCurrentNameLData);
			lblCurrentName.setText("Current Name");
	
			GridData txtCurrentNameLData = new GridData();
			txtCurrentNameLData.verticalAlignment = GridData.CENTER;
			txtCurrentNameLData.horizontalAlignment = GridData.BEGINNING;
			txtCurrentNameLData.widthHint = 244;
			txtCurrentNameLData.heightHint = 13;
			txtCurrentNameLData.horizontalIndent = 0;
			txtCurrentNameLData.horizontalSpan = 1;
			txtCurrentNameLData.verticalSpan = 1;
			txtCurrentNameLData.grabExcessHorizontalSpace = false;
			txtCurrentNameLData.grabExcessVerticalSpace = false;
			txtCurrentName.setLayoutData(txtCurrentNameLData);
			txtCurrentName.setSize(new org.eclipse.swt.graphics.Point(244,13));
	
			GridData lblTurqGroupNameLData = new GridData();
			lblTurqGroupNameLData.verticalAlignment = GridData.CENTER;
			lblTurqGroupNameLData.horizontalAlignment = GridData.BEGINNING;
			lblTurqGroupNameLData.widthHint = 65;
			lblTurqGroupNameLData.heightHint = 19;
			lblTurqGroupNameLData.horizontalIndent = 0;
			lblTurqGroupNameLData.horizontalSpan = 1;
			lblTurqGroupNameLData.verticalSpan = 1;
			lblTurqGroupNameLData.grabExcessHorizontalSpace = false;
			lblTurqGroupNameLData.grabExcessVerticalSpace = false;
			lblTurqGroupName.setLayoutData(lblTurqGroupNameLData);
			lblTurqGroupName.setText("Group Name");
			lblTurqGroupName.setSize(new org.eclipse.swt.graphics.Point(65,19));
	
			GridData comboTurqGroupNameLData = new GridData();
			comboTurqGroupNameLData.verticalAlignment = GridData.CENTER;
			comboTurqGroupNameLData.horizontalAlignment = GridData.BEGINNING;
			comboTurqGroupNameLData.widthHint = -1;
			comboTurqGroupNameLData.heightHint = -1;
			comboTurqGroupNameLData.horizontalIndent = 0;
			comboTurqGroupNameLData.horizontalSpan = 1;
			comboTurqGroupNameLData.verticalSpan = 1;
			comboTurqGroupNameLData.grabExcessHorizontalSpace = false;
			comboTurqGroupNameLData.grabExcessVerticalSpace = false;
			comboTurqGroupName.setLayoutData(comboTurqGroupNameLData);
			GridLayout compCurrentCardSearchLayout = new GridLayout(2, true);
			compCurrentCardSearch.setLayout(compCurrentCardSearchLayout);
			compCurrentCardSearchLayout.marginWidth = 5;
			compCurrentCardSearchLayout.marginHeight = 5;
			compCurrentCardSearchLayout.numColumns = 2;
			compCurrentCardSearchLayout.makeColumnsEqualWidth = false;
			compCurrentCardSearchLayout.horizontalSpacing = 5;
			compCurrentCardSearchLayout.verticalSpacing = 5;
			compCurrentCardSearch.layout();
	
			GridData tableCurrentCardSearchLData = new GridData();
			tableCurrentCardSearchLData.verticalAlignment = GridData.FILL;
			tableCurrentCardSearchLData.horizontalAlignment = GridData.FILL;
			tableCurrentCardSearchLData.widthHint = -1;
			tableCurrentCardSearchLData.heightHint = -1;
			tableCurrentCardSearchLData.horizontalIndent = 0;
			tableCurrentCardSearchLData.horizontalSpan = 1;
			tableCurrentCardSearchLData.verticalSpan = 1;
			tableCurrentCardSearchLData.grabExcessHorizontalSpace = true;
			tableCurrentCardSearchLData.grabExcessVerticalSpace = true;
			tableCurrentCardSearch.setLayoutData(tableCurrentCardSearchLData);
			tableCurrentCardSearch.setHeaderVisible(true);
			tableCurrentCardSearch.setLinesVisible(true);
			tableCurrentCardSearch.setSize(new org.eclipse.swt.graphics.Point(409,168));
			tableCurrentCardSearch.addMouseListener( new MouseAdapter() {
				public void mouseDoubleClick(MouseEvent evt) {
					tableCurrentCardSearchMouseDoubleClick(evt);
				}
			});
	
			tableColumnCurrentCode.setText("Current Code");
			tableColumnCurrentCode.setWidth(120);
	
			tableColumnCurrentName.setText("Current Name");
			tableColumnCurrentName.setWidth(120);
	
			tableColumnContactName.setText("Contact Name");
			tableColumnContactName.setWidth(120);
			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 5;
			this.layout();
	
			postInitGUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
/** Add your pre-init code in here 	*/
	public void preInitGUI(){
	}

	/** Add your post-init code in here 	*/
	public void postInitGUI(){
		try{
			comboTurqGroupName.removeAll();
			comboTurqGroupName.setText("");
			List groups=engBLCom.getTurqCurrentGroups();
			for(int k=0; k<groups.size(); k++){
				TurqCurrentGroup group=(TurqCurrentGroup)groups.get(k);
				comboTurqGroupName.add(group.getGroupsName());
				comboTurqGroupName.setData(group.getGroupsName(),group);
			}
		}
		catch(Exception ex){
			MessageBox msg=new MessageBox(this.getShell(),SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
			ex.printStackTrace();
		}
	}

	
	public void delete(){
	}
	
	public void search(){
		try{
			tableCurrentCardSearch.removeAll();
			List listCurrentCards=curBLCurrentCardSearch.searchCurrentCard(txtCurrentCode.getText().trim(),
																		txtCurrentName.getText().trim(),(TurqCurrentGroup)comboTurqGroupName.getData());

			for(int k=0; k<listCurrentCards.size(); k++){
				TurqCurrentCard aCurrentCard=(TurqCurrentCard)listCurrentCards.get(k);
				TableItem item=new TableItem(tableCurrentCardSearch, SWT.NULL);
				item.setData(aCurrentCard);
 				
 				String contactName ="";
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
			MessageBox msg=new MessageBox(this.getShell(),SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
			
		}
	}
	
	public void newForm(){
	}
	
	public void save(){
	}

	/** Auto-generated main method */
	public static void main(String[] args){
		showGUI();
	}

	/**
	* This static method creates a new instance of this class and shows
	* it inside a new Shell.
	*
	* It is a convenience method for showing the GUI, but it can be
	* copied and used as a basis for your own code.	*
	* It is auto-generated code - the body of this method will be
	* re-generated after any changes are made to the GUI.
	* However, if you delete this method it will not be re-created.	*/
	public static void showGUI(){
		try {
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			CurUICurrentCardSearch inst = new CurUICurrentCardSearch(shell, SWT.NULL);
			shell.setLayout(new org.eclipse.swt.layout.FillLayout());
			Rectangle shellBounds = shell.computeTrim(0,0,435,318);
			shell.setSize(shellBounds.width, shellBounds.height);
			shell.open();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** Auto-generated event handler method */
	protected void tableCurrentCardSearchMouseDoubleClick(MouseEvent evt){
		//TODO add your handler code here
		TableItem [] selection= tableCurrentCardSearch.getSelection();	
	
		if(selection.length>0){
	
			TurqCurrentCard card = (TurqCurrentCard)selection[0].getData();
			new CurUICurrentCardUpdate(this.getShell(),SWT.NULL,card).open();
			search();
		}
	}
}
