package com.turquaz.engine.ui;

import org.eclipse.swt.custom.CLabel;
import com.turquaz.engine.ui.component.MenuManager;
import com.turquaz.engine.ui.component.TurqKeyControl;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionAdapter;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.engine.Messages;
import com.turquaz.engine.bl.EngBLKeyEvents;
import com.turquaz.engine.ui.component.TurqKeyEvent;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
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
public class EngUIKeyControls extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private ToolItem toolCancel;
	private ToolItem toolSave;
	private CLabel lvlContentAssistant;
	private CLabel lblSave;
	private TurqKeyControl txtSave;
	private CLabel lblExcel;
	private TurqKeyControl txtPrint;
	private TurqKeyControl txtPreviousTab;
	private CLabel lblPreviousTab;
	private TurqKeyControl txtNextTab;
	private CLabel lblNextTab;
	private CLabel lblPrint;
	private TurqKeyControl txtExcel;
	private TurqKeyControl txtDelete;
	private CLabel lblDelete;
	private TurqKeyControl txtSearch;
	private CLabel lblSearch;
	private TurqKeyControl txtNew;
	private CLabel lblNew;
	private TurqKeyControl txtContentAssistant;
	private ToolBar toolBar1;
	private Composite compControls;
	public static Map tempKeyValues;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/
	public static void main(String[] args) {
		try {
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			EngUIKeyControls inst = new EngUIKeyControls(shell, SWT.NULL);
			inst.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public EngUIKeyControls(Shell parent, int style) {
		super(parent, style);
	}

	public void open() {
		try {
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

				{
					//Register as a resource user - SWTResourceManager will
					//handle the obtaining and disposing of resources
					SWTResourceManager.registerResourceUser(dialogShell);
				}


			dialogShell.setLayout(new GridLayout());
			//START >>  compControls
			compControls = new Composite(dialogShell, SWT.NONE);
			GridLayout compControlsLayout = new GridLayout();
			compControlsLayout.numColumns = 2;
			GridData compControlsLData = new GridData();
			compControlsLData.grabExcessHorizontalSpace = true;
			compControlsLData.grabExcessVerticalSpace = true;
			compControlsLData.horizontalAlignment = GridData.FILL;
			compControlsLData.verticalAlignment = GridData.FILL;
			compControls.setLayoutData(compControlsLData);
			compControls.setLayout(compControlsLayout);
			//START >>  toolBar1
			toolBar1 = new ToolBar(compControls, SWT.NONE);
			GridData toolBar1LData = new GridData();
			toolBar1LData.widthHint = 78;
			toolBar1LData.heightHint = 38;
			toolBar1LData.horizontalSpan = 2;
			toolBar1.setLayoutData(toolBar1LData);
			//START >>  toolSave
			toolSave = new ToolItem(toolBar1, SWT.NONE);
			toolSave.setText(Messages.getString("EngUIKeyControls.0")); //$NON-NLS-1$
			toolSave.setImage(SWTResourceManager.getImage("icons/save_edit.gif")); //$NON-NLS-1$
			toolSave.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					try
					{
						Iterator it=tempKeyValues.keySet().iterator();
						Map realMap=EngBLKeyEvents.turqKeyEvents;
						while (it.hasNext())
						{
							String name=(String)it.next();
							TurqKeyEvent event=(TurqKeyEvent)tempKeyValues.get(name);
							realMap.put(name,event);
						}
						EngBLKeyEvents.SerializeKeys();
						EngUIMainFrame.menuMain=new Menu(EngUIMainFrame.shell, SWT.BAR);
						MenuManager.createMainMenu(EngUIMainFrame.menuMain);
						EngUIMainFrame.shell.setMenuBar(EngUIMainFrame.menuMain);
						dialogShell.close();
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
			});
			//END <<  toolSave
			//START >>  toolCancel
			toolCancel = new ToolItem(toolBar1, SWT.NONE);
			toolCancel.setText(Messages.getString("EngUIKeyControls.2")); //$NON-NLS-1$
			toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg")); //$NON-NLS-1$
			toolCancel.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					dialogShell.close();
				}
			});
			//END <<  toolCancel
			//END <<  toolBar1
			//START >>  lvlContentAssistant
			lvlContentAssistant = new CLabel(compControls, SWT.NONE);
			lvlContentAssistant.setText("\u0130çerik Asistan\u0131");
			//END <<  lvlContentAssistant
			//START >>  txtContentAssistant
			txtContentAssistant = new TurqKeyControl(compControls, SWT.NONE);
			GridData txtContentAssistantLData = new GridData();
			txtContentAssistantLData.widthHint = 200;
			txtContentAssistantLData.heightHint = 17;
			txtContentAssistant.setLayoutData(txtContentAssistantLData);
			//END <<  txtContentAssistant
			//START >>  lblSave
			lblSave = new CLabel(compControls, SWT.NONE);
			lblSave.setText("Kaydet");
			//END <<  lblSave
			//START >>  txtSave
			txtSave = new TurqKeyControl(compControls, SWT.NONE);
			GridData txtSaveLData = new GridData();
			txtSaveLData.widthHint = 200;
			txtSaveLData.heightHint = 17;
			txtSave.setLayoutData(txtSaveLData);
			//END <<  txtSave
			//START >>  lblNew
			lblNew = new CLabel(compControls, SWT.NONE);
			lblNew.setText("Yeni");
			//END <<  lblNew
			//START >>  txtNew
			txtNew = new TurqKeyControl(compControls, SWT.NONE);
			GridData txtNewLData = new GridData();
			txtNewLData.widthHint = 200;
			txtNewLData.heightHint = 17;
			txtNew.setLayoutData(txtNewLData);
			//END <<  txtNew
			//START >>  lblSearch
			lblSearch = new CLabel(compControls, SWT.NONE);
			lblSearch.setText("Arama");
			//END <<  lblSearch
			//START >>  txtSearch
			txtSearch = new TurqKeyControl(compControls, SWT.NONE);
			GridData txtSearchLData = new GridData();
			txtSearchLData.widthHint = 200;
			txtSearchLData.heightHint = 17;
			txtSearch.setLayoutData(txtSearchLData);
			//END <<  txtSearch
			//START >>  lblDelete
			lblDelete = new CLabel(compControls, SWT.NONE);
			lblDelete.setText("Silme");
			//END <<  lblDelete
			//START >>  txtDelete
			txtDelete = new TurqKeyControl(compControls, SWT.NONE);
			GridData txtDeleteLData = new GridData();
			txtDeleteLData.widthHint = 200;
			txtDeleteLData.heightHint = 17;
			txtDelete.setLayoutData(txtDeleteLData);
			//END <<  txtDelete
			//START >>  lblExcel
			lblExcel = new CLabel(compControls, SWT.NONE);
			lblExcel.setText("Excel");
			//END <<  lblExcel
			//START >>  txtExcel
			txtExcel = new TurqKeyControl(compControls, SWT.NONE);
			GridData txtExcelLData = new GridData();
			txtExcelLData.widthHint = 200;
			txtExcelLData.heightHint = 17;
			txtExcel.setLayoutData(txtExcelLData);
			//END <<  txtExcel
			//START >>  lblPrint
			lblPrint = new CLabel(compControls, SWT.NONE);
			lblPrint.setText("Yazd\u0131rma");
			//END <<  lblPrint
			//START >>  txtPrint
			txtPrint = new TurqKeyControl(compControls, SWT.NONE);
			GridData txtPrintLData = new GridData();
			txtPrintLData.widthHint = 200;
			txtPrintLData.heightHint = 17;
			txtPrint.setLayoutData(txtPrintLData);
			//END <<  txtPrint
			//START >>  lblNextTab
			lblNextTab = new CLabel(compControls, SWT.NONE);
			lblNextTab.setText("Sonraki Sekme");
			//END <<  lblNextTab
			//START >>  txtNextTab
			txtNextTab = new TurqKeyControl(compControls, SWT.NONE);
			GridData txtNextTabLData = new GridData();
			txtNextTabLData.widthHint = 200;
			txtNextTabLData.heightHint = 17;
			txtNextTab.setLayoutData(txtNextTabLData);
			//END <<  txtNextTab
			//START >>  lblPreviousTab
			lblPreviousTab = new CLabel(compControls, SWT.NONE);
			lblPreviousTab.setText("Önceki Sekme");
			//END <<  lblPreviousTab
			//START >>  txtPreviousTab
			txtPreviousTab = new TurqKeyControl(compControls, SWT.NONE);
			GridData txtPreviousTabLData = new GridData();
			txtPreviousTabLData.widthHint = 200;
			txtPreviousTabLData.heightHint = 17;
			txtPreviousTab.setLayoutData(txtPreviousTabLData);
			//END <<  txtPreviousTab
			dialogShell.layout();
			dialogShell.pack();
			dialogShell.setSize(414, 334);
			EngUICommon.centreWindow(dialogShell);
			PostInitGui();
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
	
	public void PostInitGui()
	{		
		fillShortCuts();	
		resetTempHashMap();
	}
	
	public void resetTempHashMap()
	{		
		Iterator it=EngBLKeyEvents.turqKeyEvents.keySet().iterator();
		while (it.hasNext())
		{
			String name=(String)it.next();
			TurqKeyEvent event=(TurqKeyEvent)EngBLKeyEvents.turqKeyEvents.get(name);
			TurqKeyEvent duplicate=new TurqKeyEvent(event.stateMask,event.keyCode,event.isActive,event.isAvailable);
			duplicate.setController(event.getController());
			tempKeyValues.put(name,duplicate);
		}
	}	
	
	public void fillShortCuts()
	{
		try
		{
			tempKeyValues=new HashMap();
			Map keyMap = EngBLKeyEvents.turqKeyEvents;
			Iterator it = keyMap.keySet().iterator();
			while (it.hasNext())
			{
				String name = (String) it.next();
				TurqKeyEvent event = (TurqKeyEvent) keyMap.get(name);
				Field field=this.getClass().getDeclaredField("txt"+name);
				Object obj=field.get(this);
				TurqKeyControl control=((TurqKeyControl)obj);
				control.setEventName(name);
				control.setData(event);				
				event.setController(control);
				keyMap.put(name,event);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
