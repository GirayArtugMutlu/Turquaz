package com.turquaz.current.ui;

import java.util.Iterator;
import java.util.Set;

import net.sf.hibernate.Hibernate;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;

import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;

import com.turquaz.current.bl.CurBLCurrentCardUpdate;
import com.turquaz.current.ui.CurUICurrentCardAdd;
import org.eclipse.swt.layout.GridData;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentCardsGroup;
import com.turquaz.engine.dal.TurqCurrentCardsPhone;
import com.turquaz.engine.dal.TurqCurrentGroup;

import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.turquaz.engine.dal.TurqCurrentContact;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class CurUICurrentCardUpdate extends org.eclipse.swt.widgets.Dialog {
	private ToolItem toolDelete;
	private ToolItem toolUpdate;
	private ToolBar toolBar1;
	private CoolItem coolItem1;
	private CoolBar coolBar1;
	private CurUICurrentCardAdd compCurCardAdd;
	private Shell dialogShell;
	private TurqCurrentCard currentCard;
	private CurBLCurrentCardUpdate currentUpdate=new CurBLCurrentCardUpdate();
	private TurqCurrentContact curContact=null;

	public CurUICurrentCardUpdate(Shell parent, int style, TurqCurrentCard curCard) {
		super(parent, style);
		currentCard=curCard;
	}

	/**
	* Opens the Dialog Shell.
	* Auto-generated code - any changes you make will disappear.
	*/
	public void open(){
		try {
			preInitGUI();
	
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
			dialogShell.setText(getText());
			coolBar1 = new CoolBar(dialogShell,SWT.NULL);
			coolItem1 = new CoolItem(coolBar1,SWT.NULL);
			toolBar1 = new ToolBar(coolBar1,SWT.NULL);
			toolUpdate = new ToolItem(toolBar1,SWT.NULL);
			toolDelete = new ToolItem(toolBar1,SWT.NULL);
			compCurCardAdd = new CurUICurrentCardAdd(dialogShell,SWT.NULL);
	
			dialogShell.setSize(new org.eclipse.swt.graphics.Point(600,434));
	
			GridData coolBar1LData = new GridData();
			coolBar1LData.verticalAlignment = GridData.CENTER;
			coolBar1LData.horizontalAlignment = GridData.FILL;
			coolBar1LData.widthHint = -1;
			coolBar1LData.heightHint = -1;
			coolBar1LData.horizontalIndent = 0;
			coolBar1LData.horizontalSpan = 1;
			coolBar1LData.verticalSpan = 1;
			coolBar1LData.grabExcessHorizontalSpace = false;
			coolBar1LData.grabExcessVerticalSpace = false;
			coolBar1.setLayoutData(coolBar1LData);
	
			coolItem1.setControl(toolBar1);
			coolItem1.setPreferredSize(new org.eclipse.swt.graphics.Point(88,38));
			coolItem1.setMinimumSize(new org.eclipse.swt.graphics.Point(88,38));
	
	
			toolUpdate.setText("Update");
	
			toolDelete.setText("Delete");
			final org.eclipse.swt.graphics.Image toolDeleteýmage = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass().getClassLoader().getResourceAsStream("icons/delete_edit.gif"));
			toolDelete.setImage(toolDeleteýmage);
			toolDelete.addSelectionListener( new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					toolDeleteWidgetSelected(evt);
				}
			});
	
			GridData compCurCardAddLData = new GridData();
			compCurCardAddLData.verticalAlignment = GridData.FILL;
			compCurCardAddLData.horizontalAlignment = GridData.FILL;
			compCurCardAddLData.widthHint = -1;
			compCurCardAddLData.heightHint = -1;
			compCurCardAddLData.horizontalIndent = 0;
			compCurCardAddLData.horizontalSpan = 1;
			compCurCardAddLData.verticalSpan = 1;
			compCurCardAddLData.grabExcessHorizontalSpace = true;
			compCurCardAddLData.grabExcessVerticalSpace = true;
			compCurCardAdd.setLayoutData(compCurCardAddLData);
			compCurCardAdd.setSize(new org.eclipse.swt.graphics.Point(590,381));
			compCurCardAdd.setEnabled(true);
			compCurCardAdd.layout();
			GridLayout dialogShellLayout = new GridLayout(1, true);
			dialogShell.setLayout(dialogShellLayout);
			dialogShellLayout.marginWidth = 5;
			dialogShellLayout.marginHeight = 5;
			dialogShellLayout.numColumns = 1;
			dialogShellLayout.makeColumnsEqualWidth = true;
			dialogShellLayout.horizontalSpacing = 5;
			dialogShellLayout.verticalSpacing = 5;
			dialogShell.layout();
			dialogShell.addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					toolDeleteýmage.dispose();
				}
			});
			Rectangle bounds = dialogShell.computeTrim(0, 0, 600,434);
			dialogShell.setSize(bounds.width, bounds.height);
			postInitGUI();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
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
			compCurCardAdd.getTxtCurrentCode().setText(currentCard.getCardsCurrentCode());
			compCurCardAdd.getTxtCurrentName().setText(currentCard.getCardsName());
			compCurCardAdd.getTxtCardDefinition().setText(currentCard.getCardsDefinition());
			compCurCardAdd.getTxtTaxDepartmant().setText(currentCard.getCardsTaxDepartment());
			compCurCardAdd.getNumTextDiscountRate().setText((currentCard.getCardsDiscountRate().intValue()));
			compCurCardAdd.getDecTxtRiskLimit().setText(currentCard.getCardsRiskLimit().toString());
			compCurCardAdd.getTxtTaxNumber().setText(currentCard.getCardsTaxNumber());
			compCurCardAdd.getDecTxtCreditLimit().setText(currentCard.getCardsCreditLimit().toString());
			compCurCardAdd.getDecTxtDiscountAmount().setText(currentCard.getCardsDiscountPayment().toString());
			compCurCardAdd.getTxtCardAddress().setText(currentCard.getCardsAddress());
			
			//Hibernate.initialize(currentCard.getTurqCurrentContacts());
			Iterator it=currentCard.getTurqCurrentContacts().iterator();
			Integer currentCardId=currentCard.getCurrentCardsId();
			
			while(it.hasNext()){
				TurqCurrentContact currentContact=(TurqCurrentContact)it.next();				
				if (currentContact.getTurqCurrentCard().getCurrentCardsId()==currentCardId)
				{
					compCurCardAdd.getTxtContactPhone().setText(currentContact.getContactsPhone1());
					compCurCardAdd.getTxtContactPhone2().setText(currentContact.getContactsPhone2());
					curContact=currentContact;
					break;
				}			
			}		
			if (curContact != null){
				compCurCardAdd.getTxtContactWebSite().setText(curContact.getContactsWebSite());
				compCurCardAdd.getTxtContactName().setText(curContact.getContactsName());
				compCurCardAdd.getTxtContactAddress().setText(curContact.getContactAddress());
				compCurCardAdd.getTxtContactEmail().setText(curContact.getContactsEmail());
				compCurCardAdd.getTxtFaxNumber().setText(curContact.getContactsFaxNumber());
				compCurCardAdd.getTxtContactPhone().setText(curContact.getContactsPhone1());
				compCurCardAdd.getTxtContactPhone2().setText(curContact.getContactsPhone2());
			}
			
			it=currentCard.getTurqCurrentCardsPhones().iterator();
			int phones=0;
			while(it.hasNext()){
			TurqCurrentCardsPhone currentPhone=(TurqCurrentCardsPhone)it.next();
				if (phones==0){
					phones++;
					compCurCardAdd.getNumTxtNumber().setText(currentPhone.getPhonesNumber());
					compCurCardAdd.getNumTxtCityCode().setText(currentPhone.getPhonesCityCode());
					compCurCardAdd.getNumtxtCountryCode().setText(currentPhone.getPhonesCountryCode());
					
				}
				else if (phones==1){
					compCurCardAdd.getNumTxtNumber2().setText(currentPhone.getPhonesNumber());
					compCurCardAdd.getNumTxtCityCode2().setText(currentPhone.getPhonesCityCode());
					compCurCardAdd.getNumTxtCountryCode2().setText(currentPhone.getPhonesCountryCode());
					break;
				}
			}
			
			compCurCardAdd.getAccPickerCustomer().setData(currentCard.getTurqAccountingAccountByAccountingCodeIdCustomer());
			compCurCardAdd.getAccPickerSupplierAccCode().setData(currentCard.getTurqAccountingAccountByAccountingCodeIdSupplier());
	
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			MessageBox msg=new MessageBox(this.getParent(),SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
			
		}
		
		
	}

	/** Auto-generated main method */

	/** Auto-generated event handler method */
	protected void toolDeleteWidgetSelected(SelectionEvent evt){
		//TODO add your handler code here
		try{
			if (curContact!=null){
				currentUpdate.deleteObject(curContact);
			}
			Iterator it=currentCard.getTurqCurrentCardsGroups().iterator();
			while(it.hasNext()){
				TurqCurrentCardsGroup currentGroup=(TurqCurrentCardsGroup)it.next();
				currentUpdate.deleteObject(currentGroup);
			}
			currentUpdate.deleteObject(currentCard);
			this.dialogShell.close();
			
		
		}
		catch(Exception ex){
			ex.printStackTrace();
			MessageBox msg=new MessageBox(this.getParent(),SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
		}
	}
}
