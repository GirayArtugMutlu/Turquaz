package com.turquaz.bill.bl;

import java.util.Calendar;
import java.util.List;
import com.turquaz.bill.dal.BillDALAddGroups;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqBillGroup;

public class BillBLAddGroups
{
	public BillBLAddGroups()
	{
	}

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

	public static void saveGroup(String name, String description) throws Exception
	{
		try
		{
			Calendar cal = Calendar.getInstance();
			TurqBillGroup group = new TurqBillGroup();
			group.setGroupDescription(description);
			group.setGroupsName(name);
			group.setCreatedBy(System.getProperty("user"));
			group.setUpdatedBy(System.getProperty("user"));
			group.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			group.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			EngDALCommon.saveObject(group);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void updateGroup(String name, String description, TurqBillGroup group) throws Exception
	{
		try
		{
			Calendar cal = Calendar.getInstance();
			group.setGroupDescription(description);
			group.setGroupsName(name);
			group.setUpdatedBy(System.getProperty("user"));
			group.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			EngDALCommon.updateObject(group);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void deleteGroup(TurqBillGroup group) throws Exception
	{
		try
		{
			EngDALCommon.deleteObject(group);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}