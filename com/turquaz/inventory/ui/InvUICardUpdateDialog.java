package com.turquaz.inventory.ui;

import java.util.Iterator;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Session;

import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.SWT;

import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.Dialog;
import com.turquaz.inventory.ui.InvUICardAdd;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryCardUnit;
import com.turquaz.engine.dal.TurqInventoryUnit;
import com.turquaz.engine.ui.component.NumericText;
import com.turquaz.engine.ui.component.SecureDialog;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class InvUICardUpdateDialog extends Dialog{
	private InvUICardAdd compInvUICard;
	private Composite compMain;
	private ToolItem toolItem2;
	private ToolItem toolItem1;
	private ToolBar toolBar2;
	private CoolItem coolItem1;
	private CoolBar coolBar2;
	private Shell dialogShell;
    private TurqInventoryCard invCard;


	
	public InvUICardUpdateDialog(Shell parent, int style,TurqInventoryCard invCard) {
		super(parent, style);
		this.invCard = invCard;
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
			coolBar2 = new CoolBar(dialogShell,SWT.NULL);
			coolItem1 = new CoolItem(coolBar2,SWT.DROP_DOWN);
			toolBar2 = new ToolBar(coolBar2,SWT.SHADOW_OUT);
			toolItem1 = new ToolItem(toolBar2,SWT.NULL);
			toolItem2 = new ToolItem(toolBar2,SWT.NULL);
			compMain = new Composite(dialogShell,SWT.NULL);
			compInvUICard = new InvUICardAdd(compMain,SWT.NULL);
	
			dialogShell.setSize(new org.eclipse.swt.graphics.Point(613,348));
	
			GridData coolBar2LData = new GridData();
			coolBar2LData.verticalAlignment = GridData.CENTER;
			coolBar2LData.horizontalAlignment = GridData.FILL;
			coolBar2LData.widthHint = -1;
			coolBar2LData.heightHint = 42;
			coolBar2LData.horizontalIndent = 0;
			coolBar2LData.horizontalSpan = 1;
			coolBar2LData.verticalSpan = 1;
			coolBar2LData.grabExcessHorizontalSpace = true;
			coolBar2LData.grabExcessVerticalSpace = false;
			coolBar2.setLayoutData(coolBar2LData);
			coolBar2.setSize(new org.eclipse.swt.graphics.Point(603,42));
	
			coolItem1.setControl(toolBar2);
			coolItem1.setSize(new org.eclipse.swt.graphics.Point(88,42));
			coolItem1.setPreferredSize(new org.eclipse.swt.graphics.Point(88,42));
			coolItem1.setMinimumSize(new org.eclipse.swt.graphics.Point(88,42));
	
	
			toolItem1.setText("Update");
	
			toolItem2.setText("Delete");
			toolItem2.setToolTipText("Delete");
			final org.eclipse.swt.graphics.Image toolItem2image = new org.eclipse.swt.graphics.Image(Display.getDefault(), getClass().getClassLoader().getResourceAsStream("icons/delete_edit.gif"));
			toolItem2.setImage(toolItem2image);
	
			GridData compMainLData = new GridData();
			compMainLData.verticalAlignment = GridData.FILL;
			compMainLData.horizontalAlignment = GridData.FILL;
			compMainLData.widthHint = -1;
			compMainLData.heightHint = -1;
			compMainLData.horizontalIndent = 0;
			compMainLData.horizontalSpan = 1;
			compMainLData.verticalSpan = 1;
			compMainLData.grabExcessHorizontalSpace = true;
			compMainLData.grabExcessVerticalSpace = true;
			compMain.setLayoutData(compMainLData);
			compMain.setSize(new org.eclipse.swt.graphics.Point(603,291));
	
			compInvUICard.setSize(new org.eclipse.swt.graphics.Point(603,291));
			compInvUICard.layout();
			FillLayout compMainLayout = new FillLayout(256);
			compMain.setLayout(compMainLayout);
			compMainLayout.type = SWT.HORIZONTAL;
			compMainLayout.marginWidth = 0;
			compMainLayout.marginHeight = 0;
			compMainLayout.spacing = 0;
			compMain.layout();
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
					toolItem2image.dispose();
				}
			});
			Rectangle bounds = dialogShell.computeTrim(0, 0, 613,348);
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
	compInvUICard.getTxtInvCardCode().setText(invCard.getCardInventoryCode());
	compInvUICard.getTxtInvCardDefinition().setText(invCard.getCardDefinition());
	compInvUICard.getTxtInvCardDiscount().setText(invCard.getCardDiscount());
	compInvUICard.getTxtInvCardInAcc().setText(invCard.getTurqAccountingAccountByAccountingAccountsIdBuy().getAccountCode());
	compInvUICard.getTxtInvCardName().setText(invCard.getCardName());
	compInvUICard.getTxtInvCardOutAcc().setText(invCard.getCardName());
	compInvUICard.getTxtInvCardSpecialCode().setText(invCard.getCardSpecialCode());
	compInvUICard.getTxtInvCardVat().setText(invCard.getCardVat());
	compInvUICard.getTxtnumInvCardMax().setText(invCard.getCardMaximumAmount());
	compInvUICard.getTxtnumInvCardMin().setText(invCard.getCardMinimumAmount());
	fillUnits();
	
	
		
	}
    public void fillUnits(){
    try{
    
    	
    Iterator it = invCard.getTurqInventoryCardUnits().iterator();
    TurqInventoryCardUnit cardUnit; 
    TurqInventoryUnit unit;
    Table tableRegisteredUnits = compInvUICard.getTableInvCardAddRegisteredUnits();
    while(it.hasNext()){   
    
     cardUnit = (TurqInventoryCardUnit)it.next();
     if(cardUnit.getCardUnitsFactor()==1){
         
     compInvUICard.getComboInvCardUnits().setText( cardUnit.getTurqInventoryUnit().getUnitsName());
     
     }
     else {
     String unitName= cardUnit.getTurqInventoryUnit().getUnitsName();
      TableItem registeredItem = new TableItem(
							tableRegisteredUnits, SWT.NULL);
					registeredItem.setText(unitName);
					registeredItem.setData(cardUnit.getTurqInventoryUnit());
					TableEditor editor = new TableEditor(
							tableRegisteredUnits);
					editor.grabHorizontal = true;
					NumericText nText = new NumericText(
							tableRegisteredUnits, SWT.NONE);
					nText.setText(cardUnit.getCardUnitsFactor());
					editor.setEditor(nText, registeredItem, 1);
					compInvUICard.mapEditorsTableInvCardAddRegisteredUnits.put(unitName,
							editor); 
			removeRegisteredUnit(unitName);				
     	
     }
     
    }
    }
     catch(Exception ex){
     ex.printStackTrace();
     }
     
  
     
    
    }
     public void removeRegisteredUnit(String unitName){
     TableItem items[] = compInvUICard.getTableInvCardAddAllUnits().getItems();
     for(int i=0;i<items.length;i++){
     if(items[i].getText().equals(unitName)){
      compInvUICard.getTableInvCardAddAllUnits().remove(i);
      break;
     }
     }
     
     
     
    } 
     
	
	
}
