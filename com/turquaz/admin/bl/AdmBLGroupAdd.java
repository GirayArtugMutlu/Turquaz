/*
 * Created on 03.Kas.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.admin.bl;

import java.util.Calendar;
import java.util.List;

import com.turquaz.admin.dal.AdmDALGroupAdd;
import com.turquaz.admin.dal.AdmDALUserAdd;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqGroup;
import com.turquaz.engine.dal.TurqUser;
import com.turquaz.engine.dal.TurqUserGroup;

/**
 * @author huseyin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AdmBLGroupAdd {
	private EngDALCommon dalCommon = new EngDALCommon();
	private AdmDALGroupAdd dalAdmin = new AdmDALGroupAdd();
	Calendar cal = Calendar.getInstance();
	public AdmBLGroupAdd(){
		
	}
	
	
	public Integer saveGroup(String groupname, String description)
			throws Exception {
		try {

			TurqGroup group = new TurqGroup();
			group.setGroupsName(groupname);
			group.setGroupsDescription(description);

			group.setCreatedBy(System.getProperty("user"));
			group.setUpdatedBy(System.getProperty("user"));
			group.setUpdateDate(new java.sql.Date(cal.getTime().getTime()));
			group.setCreationDate(new java.sql.Date(cal.getTime().getTime()));

			dalAdmin.saveObject(group);

			return group.getGroupsId();

		} catch (Exception ex) {
			throw ex;
		}

	}
}
