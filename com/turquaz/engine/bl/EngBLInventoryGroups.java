package com.turquaz.engine.bl;

import java.util.HashMap;
import com.turquaz.common.HashBag;
import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.contentassist.TurquazContentAssistant;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.bl.InvBLCardAdd;

public class EngBLInventoryGroups
{
	public HashMap groupsMap;
	public HashMap cardMap = new HashMap();
	static EngBLInventoryGroups _instance;

	public EngBLInventoryGroups() throws Exception
	{
		try
		{
			fillInventoryGroups();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public void fillInventoryGroups() throws Exception
	{
		try
		{
			HashBag groupBag=(HashBag)EngTXCommon.doSelectTX(InvBLCardAdd.class.getName(),"getParentInventoryGroups",null);
			groupsMap = (HashMap)groupBag.get(InvKeys.INV_GROUPS);
			cardMap.clear();
			TurqInventoryGroup invGroup;
			for (int i = 0; i < groupsMap.size(); i++)
			{
				HashMap invGroupMap=(HashMap)groupsMap.get(new Integer(i));
				cardMap.put(invGroupMap.get(InvKeys.INV_GROUP_NAME), invGroupMap);
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static HashMap getInvGroups() throws Exception
	{
		try
		{
			if (_instance == null)
			{
				_instance = new EngBLInventoryGroups();
			}
			return _instance.groupsMap;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqInventoryGroup getGroup(String cardName) throws Exception
	{
		try
		{
			if (_instance == null)
			{
				_instance = new EngBLInventoryGroups();
			}
			return (TurqInventoryGroup) _instance.cardMap.get(cardName);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void RefreshContentAsistantMap() throws Exception
	{
		try
		{
			if (_instance == null)
			{
				_instance = new EngBLInventoryGroups();
				return;
			}
			_instance.fillInventoryGroups();
			TurquazContentAssistant.refreshContentAssistant(EngBLCommon.CONTENT_ASSIST_INVENTORY_GROUPS);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}