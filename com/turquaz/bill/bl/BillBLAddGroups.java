package com.turquaz.bill.bl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import com.turquaz.bill.BillKeys;
import com.turquaz.bill.dal.BillDALAddGroups;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqBillGroup;

public class BillBLAddGroups
{
	public static List getBillGroups() throws Exception
	{
		try
		{
			return BillDALAddGroups.getBillGroups();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void saveGroup(HashMap argMap) throws Exception
	{
		try
		{
			String name=(String)argMap.get(BillKeys.BILL_GROUP_NAME);
			String description=(String)argMap.get(BillKeys.BILL_GROUP_DESCRIPTION);
			Calendar cal = Calendar.getInstance();
			TurqBillGroup group = new TurqBillGroup();
			group.setGroupDescription(description);
			group.setGroupsName(name);
			group.setCreatedBy(System.getProperty("user"));
			group.setUpdatedBy(System.getProperty("user"));
			group.setLastModified(cal.getTime());
			group.setCreationDate(cal.getTime());
			EngDALCommon.saveObject(group);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void updateGroup(HashMap argMap) throws Exception
	{
		try
		{
			String name=(String)argMap.get(BillKeys.BILL_GROUP_NAME);
			String description=(String)argMap.get(BillKeys.BILL_GROUP_DESCRIPTION);
			TurqBillGroup group=(TurqBillGroup)argMap.get(BillKeys.BILL_GROUP);
			Calendar cal = Calendar.getInstance();
			group.setGroupDescription(description);
			group.setGroupsName(name);
			group.setUpdatedBy(System.getProperty("user"));
			group.setLastModified(cal.getTime());
			EngDALCommon.updateObject(group);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}