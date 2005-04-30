package com.turquaz.admin.ui;

import java.util.HashMap;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionAdapter;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.admin.AdmKeys;
import com.turquaz.admin.bl.AdmBLUserUpdate;
import com.turquaz.admin.bl.AdmBLUsers;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.dal.TurqGroup;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.layout.GridData;
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
public class AdmUIGroupUpdateDialog extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private AdmUIGroupAdd compUserAdd;
	private ToolItem toolCancel;
	private ToolItem toolDelete;
	private ToolItem toolUpdate;
	private ToolBar toolBarTop;
	private TurqGroup group;
	private boolean updated = false;

	public AdmUIGroupUpdateDialog(Shell parent, int style, TurqGroup group)
	{
		super(parent, style);
		this.group = group;
	}

	public boolean open()
	{
		try
		{
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL | SWT.RESIZE | SWT.MAX);
			{
				//Register as a resource user - SWTResourceManager will
				//handle the obtaining and disposing of resources
				SWTResourceManager.registerResourceUser(dialogShell);
			}
			dialogShell.setLayout(new GridLayout());
			//START >> toolBarTop
			toolBarTop = new ToolBar(dialogShell, SWT.NONE);
			GridData toolBarTopLData = new GridData();
			toolBarTopLData.horizontalAlignment = GridData.FILL;
			toolBarTopLData.grabExcessHorizontalSpace = true;
			toolBarTop.setLayoutData(toolBarTopLData);
			//START >> toolUpdate
			toolUpdate = new ToolItem(toolBarTop, SWT.NONE);
			toolUpdate.setEnabled(true);
			toolUpdate.setText(EngLangCommonKeys.STR_UPDATE); //$NON-NLS-1$
			toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif")); //$NON-NLS-1$
			toolUpdate.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent evt)
				{
					update();
				}
			});
			//END << toolUpdate
			//START >> toolDelete
			toolDelete = new ToolItem(toolBarTop, SWT.NONE);
			toolDelete.setText(EngLangCommonKeys.STR_DELETE); //$NON-NLS-1$
			toolDelete.setImage(SWTResourceManager.getImage("icons/delete_edit.gif")); //$NON-NLS-1$
			toolDelete.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent evt)
				{
					delete();
				}
			});
			//END << toolDelete
			//START >> toolCancel
			toolCancel = new ToolItem(toolBarTop, SWT.NONE);
			toolCancel.setText(EngLangCommonKeys.STR_CANCEL); //$NON-NLS-1$
			toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg")); //$NON-NLS-1$
			toolCancel.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent evt)
				{
					dialogShell.close();
				}
			});
			//END << toolCancel
			//END << toolBarTop
			//START >> compUserAdd
			compUserAdd = new AdmUIGroupAdd(dialogShell, SWT.NONE);
			GridLayout compAddUserLayout = new GridLayout();
			GridData compAddUserLData = new GridData();
			compAddUserLData.grabExcessHorizontalSpace = true;
			compAddUserLData.grabExcessVerticalSpace = true;
			compAddUserLData.horizontalAlignment = GridData.FILL;
			compAddUserLData.verticalAlignment = GridData.FILL;
			compUserAdd.setLayoutData(compAddUserLData);
			compAddUserLayout.makeColumnsEqualWidth = true;
			//END << compUserAdd
			dialogShell.layout();
			dialogShell.pack();
			dialogShell.setSize(484, 270);
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			PostInitGui();
			while (!dialogShell.isDisposed())
			{
				if (!display.readAndDispatch())
					display.sleep();
			}
			return updated;
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getParent());
			return true;
		}
	}

	public void PostInitGui()
	{
		EngUICommon.centreWindow(dialogShell);
		
		compUserAdd.getTxtAdmGroupName().setText(group.getGroupsName());
		compUserAdd.getTxtAdmGroupDesc().setText(group.getGroupsDescription());
	}

	public void delete()
	{
		try
		{
			boolean delete = EngUICommon.okToDelete(this.getParent());  //$NON-NLS-1$
			if (delete)
			{
				updated = true;
				HashMap argMap=new HashMap();
				argMap.put(AdmKeys.ADM_GROUP,group);
				EngTXCommon.doTransactionTX(AdmBLUsers.class.getName(),"deleteGroup",argMap); //$NON-NLS-1$
				EngUICommon.showMessageBox(this.getParent(),EngLangCommonKeys.MSG_DELETED_SUCCESS); //$NON-NLS-1$
				this.dialogShell.close();
			}
		}
		catch (Exception ex)
		{
			EngBLLogger.log(getClass(),ex,getParent());
		}
	}

	public void update()
	{
		try
		{
			if (compUserAdd.verifyFields())
			{
				updated = true;
				
				HashMap argMap=new HashMap();
				argMap.put(AdmKeys.ADM_GROUP,group);
				argMap.put(AdmKeys.ADM_GROUP_NAME,compUserAdd.getTxtAdmGroupName().getText().trim());
				argMap.put(AdmKeys.ADM_GROUP_DESCRIPTION,compUserAdd.getTxtAdmGroupDesc().getText());
								
				EngTXCommon.doTransactionTX(AdmBLUserUpdate.class.getName(),"updateGroup",argMap); //$NON-NLS-1$
				EngUICommon.showMessageBox(this.getParent(),EngLangCommonKeys.MSG_UPDATED_SUCCESS); //$NON-NLS-1$
				dialogShell.close();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}
}