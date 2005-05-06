package com.turquaz.engine.bl;

import java.util.HashMap;
import java.util.List;
import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.ui.contentassist.TurquazContentAssistant;
import com.turquaz.inventory.bl.InvBLCardAdd;

public class EngBLInventoryGroups
{
	public List groupList;
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
			groupList = InvBLCardAdd.getParentInventoryGroups();
			cardMap.clear();
			TurqInventoryGroup invGroup;
			for (int i = 0; i < groupList.size(); i++)
			{
				invGroup = (TurqInventoryGroup) (groupList.get(i));
				cardMap.put(invGroup.getGroupsName(), invGroup);
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static synchronized List getInvGroups() throws Exception
	{
		try
		{
			if (_instance == null)
			{
				_instance = new EngBLInventoryGroups();
			}
			return _instance.groupList;
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