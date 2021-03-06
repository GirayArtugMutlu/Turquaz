package com.turquaz.inventory.ui.comp;

/************************************************************************/
/* TURQUAZ: Higly Modular Accounting/ERP Program                        */
/* ============================================                         */
/* Copyright (c) 2004 by Turquaz Software Development Group			    */
/*																		*/
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or    */
/* (at your option) any later version.       							*/
/* 																		*/
/* This program is distributed in the hope that it will be useful,		*/
/* but WITHOUT ANY WARRANTY; without even the implied warranty of		*/
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the		*/
/* GNU General Public License for more details.         				*/
/************************************************************************/
/**
 * @author  Onsel Armagan
 * @version  $Id$
 */
import java.util.HashMap;
import org.eclipse.swt.widgets.Button;
import org.eclipse.jface.contentassist.TextContentAssistSubjectAdapter;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import com.turquaz.common.HashBag;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLInventoryCards;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.interfaces.TurquazContentAssistInterface;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.contentassist.TurquazContentAssistant;
import com.turquaz.inventory.InvKeys;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import com.turquaz.inventory.bl.InvBLCardAdd;
import com.turquaz.inventory.ui.InvUICardSearchDialog;
import com.cloudgarden.resource.SWTResourceManager;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class InventoryPicker extends org.eclipse.swt.widgets.Composite implements TurquazContentAssistInterface
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	private String filter = "";
	private Button btnSearch;
	private Text text1;
	private Text textInvName = null;
	private CCombo comboUnits = null;
	private HashMap invCardMap=new HashMap();

	public InventoryPicker(Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	/**
	 * Initializes the GUI. Auto-generated code - any changes you make will disappear.
	 */
	public void initGUI()
	{
		try
		{
			this.setSize(new org.eclipse.swt.graphics.Point(397, 22));
			this.setEnabled(true);
			GridLayout thisLayout = new GridLayout(4, true);
			this.setLayout(thisLayout);
			{
				text1 = new Text(this, SWT.LEFT);
				text1.setEditable(true);
				text1.setSize(new org.eclipse.swt.graphics.Point(358, 22));
				GridData text1LData = new GridData();
				text1.addModifyListener(new ModifyListener() {
					public void modifyText(ModifyEvent evt) {
						try {
							setDBData(EngBLInventoryCards.getInvCard(text1
								.getText().trim()));
						} catch (Exception ex) {
                            EngBLLogger.log(this.getClass(),ex);
						}
					}
				});
				text1.setBackground(SWTResourceManager.getColor(255, 150, 150));
				text1LData.verticalAlignment = GridData.FILL;
				text1LData.horizontalAlignment = GridData.FILL;
				text1LData.grabExcessHorizontalSpace = true;
				text1LData.grabExcessVerticalSpace = true;
				text1.setLayoutData(text1LData);
				text1.addFocusListener(new FocusAdapter() {
					public void focusLost(FocusEvent evt) {
						openNewObjectDialog();
					}
				});
			}
			{
				btnSearch = new Button(this, SWT.PUSH | SWT.CENTER);
				GridData btnSearchLData = new GridData();
				btnSearchLData.verticalAlignment = GridData.FILL;
				btnSearch.setLayoutData(btnSearchLData);
				btnSearch.setText("...");
				btnSearch.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent evt) {
						openSearchDialog();
					}
				});
			}
			thisLayout.marginWidth = 0;
			thisLayout.marginHeight = 0;
			thisLayout.numColumns = 4;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 0;
			thisLayout.verticalSpacing = 0;
			this.layout();
			addDisposeListener(new DisposeListener()
			{
				public void widgetDisposed(DisposeEvent e)
				{
				}
			});
			postInitGUI();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e);
		}
	}
	public TurquazContentAssistant asistant;

	/** Add your post-init code in here */
	public void postInitGUI()
	{
		TextContentAssistSubjectAdapter adapter = new TextContentAssistSubjectAdapter(text1);
		asistant = new TurquazContentAssistant(adapter, EngBLCommon.CONTENT_ASSIST_INVENTORY);
	}

	public void setText(String arg0)
	{
		text1.setText(arg0);
	}

	public String getText()
	{
		return text1.getText();
	}
	
	public Integer getId()
	{
		if(invCardMap==null)
		{
			return null;
		}
		else
		{
			return (Integer)invCardMap.get(InvKeys.INV_CARD_ID);
		}
	}

	public void setData(Object obj)
	{
		super.setData(obj);
	}

	public void setDBData(Object obj)
	{
		invCardMap=(HashMap)obj;
		if (obj == null)
		{
			text1.setBackground(SWTResourceManager.getColor(255, 150, 150));
			if (textInvName != null)
			{
				textInvName.setText("");
			}
			if (comboUnits != null)
			{
				comboUnits.setText("");
				comboUnits.removeAll();
			}
		}
		else
		{
			text1.setBackground(SWTResourceManager.getColor(198, 255, 198));
			if (textInvName != null)
			{
				textInvName.setText((String)invCardMap.get(InvKeys.INV_CARD_NAME));
			}
			if (comboUnits != null)
			{
				comboUnits.removeAll();
				comboUnits.setText("");
				try
				{
					HashMap unit = null;
					HashMap argMap=new HashMap();
					argMap.put(InvKeys.INV_CARD_ID,invCardMap.get(InvKeys.INV_CARD_ID));
					HashBag unitBag = (HashBag)EngTXCommon.doSelectTX(InvBLCardAdd.class.getName(),"getInventoryUnits",argMap);
					HashMap unitList=(HashMap)unitBag.get(InvKeys.INV_UNITS);
					for (int i = 0; i < unitList.size(); i++)
					{
						unit = (HashMap) unitList.get(new Integer(i));
						String unitName=(String)unit.get(InvKeys.INV_UNIT_NAME);
						Integer unitId=(Integer)unit.get(InvKeys.INV_UNIT_ID);
						comboUnits.add(unitName);
						comboUnits.setData(unitName, unitId);
					}
					if (comboUnits.getItemCount() > 0)
					{
						comboUnits.setText(comboUnits.getItem(0));
					}
				}
				catch (Exception ex)
				{
                    EngBLLogger.log(this.getClass(),ex);
				}
			}
		}
	}

	public void setTextInvName(Text text)
	{
		textInvName = text;
	}

	public void setComboInvUnits(CCombo combo)
	{
		comboUnits = combo;
	}

	public Object getDBData() {
		return invCardMap;
	}
	
	public Object getData()
	{
		return invCardMap;
	}

	public void openNewObjectDialog() {
		// TODO Auto-generated method stub
		
	}

	public void openSearchDialog() {
		
		String cardCode = new InvUICardSearchDialog(getShell(),SWT.NULL).open(text1.getText().trim());
		text1.setText(cardCode);
	}
}