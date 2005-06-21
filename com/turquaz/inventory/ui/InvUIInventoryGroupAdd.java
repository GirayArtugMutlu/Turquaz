package com.turquaz.inventory.ui;

import java.util.HashMap;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.GridData;

import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.lang.InvLangKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.bl.InvBLCardAdd;
import com.turquaz.inventory.ui.comp.InvMainGroupPicker;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class InvUIInventoryGroupAdd extends org.eclipse.swt.widgets.Composite implements SecureComposite
{
	private CLabel lblMainGroup;
	private InvMainGroupPicker txtMainGroup;
	private CLabel lblDefinition;
	private Text txtDefinition;
	private Text txtGroupName;
	private CLabel lblGroupName;

	public InvUIInventoryGroupAdd(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			this.setSize(493, 216);
			{
				lblMainGroup = new CLabel(this, SWT.NONE);
				lblMainGroup.setText(InvLangKeys.STR_MAIN_GROUP);
				lblMainGroup.setVisible(false);
			}
			{
				txtMainGroup = new InvMainGroupPicker(this, SWT.NONE);
				GridData txtMainGroupLData = new GridData();
				txtMainGroup.setVisible(false);
				txtMainGroupLData.widthHint = 164;
				txtMainGroupLData.heightHint = 19;
				txtMainGroup.setLayoutData(txtMainGroupLData);
			}
			{
				lblGroupName = new CLabel(this, SWT.NONE);
				lblGroupName.setText(EngLangCommonKeys.STR_GROUP_NAME);
			}
			{
				txtGroupName = new Text(this, SWT.NONE);
				GridData txtGroupNameLData = new GridData();
				txtGroupNameLData.widthHint = 161;
				txtGroupNameLData.heightHint = 19;
				txtGroupName.setLayoutData(txtGroupNameLData);
			}
			{
				lblDefinition = new CLabel(this, SWT.NONE);
				lblDefinition.setText(EngLangCommonKeys.STR_DESCRIPTION);
			}
			{
				txtDefinition = new Text(this, SWT.NONE);
				GridData txtDefinitionLData = new GridData();
				txtDefinitionLData.widthHint = 292;
				txtDefinitionLData.heightHint = 19;
				txtDefinition.setLayoutData(txtDefinitionLData);
			}
			this.layout();
		}
		catch (Exception e)
		{

            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	public boolean verifyFields()
	{
		if (txtGroupName.getText().trim().equals("")) 
		{ 
			EngUICommon.showMessageBox(getShell(), InvLangKeys.MSG_ENTER_GROUP_NAME, SWT.ICON_WARNING);
			txtGroupName.setFocus();
			return false;
		}
		return true;
	}

	public void newForm()
	{
		InvUIInventoryGroupAdd cardAdd = new InvUIInventoryGroupAdd(this.getParent(), this.getStyle());
		CTabFolder tabfld = (CTabFolder) this.getParent();
		tabfld.getSelection().setControl(cardAdd);
		this.dispose();
	}

	public void save()
	{
		try
		{
			if (verifyFields())
			{		
				HashMap argMap=new HashMap();
				argMap.put(InvKeys.INV_GROUP_NAME,txtGroupName.getText().trim());
				argMap.put(InvKeys.INV_GROUP_DESCRIPTION,txtDefinition.getText().trim());
				argMap.put(InvKeys.INV_PARENT_GROUP_ID,(Integer)txtMainGroup.getData());
				EngTXCommon.doTransactionTX(InvBLCardAdd.class.getName(),"saveInvGroup",argMap);
				EngUICommon.showSavedSuccesfullyMessage(getShell());
				
				newForm();
			}
		}
		catch (Exception ex)
		{

            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void update(Integer groupId)
	{
		try
		{
			if (verifyFields())
			{ 
				HashMap argMap=new HashMap();
				argMap.put(InvKeys.INV_GROUP_NAME,txtGroupName.getText().trim());
				argMap.put(InvKeys.INV_GROUP_DESCRIPTION,txtDefinition.getText().trim());
				argMap.put(InvKeys.INV_GROUP_ID,groupId);
				EngTXCommon.doTransactionTX(InvBLCardAdd.class.getName(),"updateInvGroup",argMap);
				EngUICommon.showSavedSuccesfullyMessage(getShell());			   
			}
		}
		catch (Exception ex)
		{

            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void save(Integer mainGroupId)
	{
		try
		{
			if (verifyFields())
			{
				HashMap argMap=new HashMap();
				argMap.put(InvKeys.INV_GROUP_NAME,txtGroupName.getText().trim());
				argMap.put(InvKeys.INV_GROUP_DESCRIPTION,txtDefinition.getText().trim());
				argMap.put(InvKeys.INV_PARENT_GROUP_ID,mainGroupId);
				EngTXCommon.doTransactionTX(InvBLCardAdd.class.getName(),"saveInvGroup",argMap);
				EngUICommon.showSavedSuccesfullyMessage(getShell());
			}
		}
		catch (Exception ex)
		{

            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public Text getTxtDefinition()
	{
		return txtDefinition;
	}

	public Text getTxtGroupName()
	{
		return txtGroupName;
	}
}