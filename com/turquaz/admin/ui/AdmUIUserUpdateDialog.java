package com.turquaz.admin.ui;

import java.util.HashMap;
import java.util.Iterator;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionAdapter;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.admin.AdmKeys;
import com.turquaz.admin.Messages;
import com.turquaz.admin.bl.AdmBLUserUpdate;
import com.turquaz.admin.bl.AdmBLUsers;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.dal.TurqUser;
import com.turquaz.engine.dal.TurqUserGroup;
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
public class AdmUIUserUpdateDialog extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private AdmUIUserAdd compUserAdd;
	private ToolItem toolCancel;
	private ToolItem toolDelete;
	private ToolItem toolUpdate;
	private ToolBar toolBarTop;
	private TurqUser user;
	private boolean updated = false;

	public AdmUIUserUpdateDialog(Shell parent, int style, TurqUser turquser)
	{
		super(parent, style);
		this.user = turquser;
	}

	public boolean open()
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
			//START >> toolBarTop
			toolBarTop = new ToolBar(dialogShell, SWT.NONE);
			GridData toolBarTopLData = new GridData();
			toolBarTopLData.horizontalAlignment = GridData.FILL;
			toolBarTopLData.grabExcessHorizontalSpace = true;
			toolBarTop.setLayoutData(toolBarTopLData);
			//START >> toolUpdate
			toolUpdate = new ToolItem(toolBarTop, SWT.NONE);
			toolUpdate.setEnabled(true);
			toolUpdate.setText(Messages.getString("AdmUIUserUpdateDialog.0")); //$NON-NLS-1$
			toolUpdate.setImage(SWTResourceManager.getImage(Messages.getString("AdmUIUserUpdateDialog.3"))); //$NON-NLS-1$
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
			toolDelete.setText(Messages.getString("AdmUIUserUpdateDialog.2")); //$NON-NLS-1$
			toolDelete.setImage(SWTResourceManager.getImage(Messages.getString("AdmUIUserUpdateDialog.1"))); //$NON-NLS-1$
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
			toolCancel.setText(Messages.getString("AdmUIUserUpdateDialog.4")); //$NON-NLS-1$
			toolCancel.setImage(SWTResourceManager.getImage(Messages.getString("AdmUIUserUpdateDialog.5"))); //$NON-NLS-1$
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
			compUserAdd = new AdmUIUserAdd(dialogShell, SWT.NONE);
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
			dialogShell.setSize(668, 511);
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
		compUserAdd.getTxtUsername().setEnabled(false);
		compUserAdd.getTxtUsername().setEditable(false);
		compUserAdd.getTxtUsername().setForeground(SWTResourceManager.getColor(255, 255, 255));
		compUserAdd.getTxtUsername().setText(user.getUsername());
		compUserAdd.getTxtDescription().setText(user.getUsersDescription());
		compUserAdd.getTxtPassword().setText(user.getUsersPassword());
		compUserAdd.getTxtRePassword().setText(user.getUsersPassword());
		compUserAdd.getTxtRealName().setText(user.getUsersRealName());
		Iterator it = user.getTurqUserGroups().iterator();
		while (it.hasNext())
		{
			TurqUserGroup userGroup = (TurqUserGroup) it.next();
			compUserAdd.getRegisteredGroups().RegisterGroup(userGroup.getTurqGroup());
		}
	}

	public void delete()
	{
		try
		{
			boolean delete = EngUICommon.okToDelete(this.getParent(), Messages.getString("AdmUIUserUpdateDialog.6")); //$NON-NLS-1$
			if (delete)
			{
				updated = true;
				HashMap argMap=new HashMap();
				argMap.put(AdmKeys.ADM_USER,user);
				EngTXCommon.doTransactionTX(AdmBLUsers.class.getName(),"deleteUser",argMap);
				EngUICommon.showMessageBox(this.getParent(),Messages.getString("AdmUIUserUpdateDialog.7")); //$NON-NLS-1$
				this.dialogShell.close();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
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
				argMap.put(AdmKeys.ADM_PASSWORD,compUserAdd.getTxtPassword().getText().trim());
				argMap.put(AdmKeys.ADM_REALNAME,compUserAdd.getTxtRealName().getText().trim());
				argMap.put(EngKeys.DESCRIPTION,compUserAdd.getTxtDescription().getText().trim());
				argMap.put(AdmKeys.ADM_USER,user);
				argMap.put(AdmKeys.ADM_USER_GROUPS,compUserAdd.getUserGroups());
				
				EngTXCommon.doTransactionTX(AdmBLUserUpdate.class.getName(),"updateUser",argMap);
				EngUICommon.showMessageBox(this.getParent(),Messages.getString("AdmUIUserUpdateDialog.8")); //$NON-NLS-1$
				dialogShell.close();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}
}