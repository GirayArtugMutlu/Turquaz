package com.turquaz.engine.dal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.turquaz.admin.AdmKeys;
import com.turquaz.common.HashBag;
import com.turquaz.engine.EngKeys;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

/**
 * @author onsel
 * @version $Id$ Database functions for calculating user permissions.
 */
public class EngDALUserPerms
{
	/**
	 * @param username
	 *             Current user of the system
	 * @return List of TurqGroupPermission objects for username
	 * @throws Exception
	 *              "Hibernate Exception"
	 */
	public static HashBag getGroupPermissions(HashMap argMap) throws Exception
	{
		try
		{
			String username=(String)argMap.get(EngKeys.USER);
			Session session = EngDALSessionFactory.getSession();
			
			String query = "select perms from TurqGroupPermission as perms," + "TurqUserGroup as ug "
					+ "where ug.turqGroup =perms.turqGroup and " + "ug.turqUser.username ='" + username + "'";
			Query q = session.createQuery(query);
			List list = q.list();
		
			HashBag permBag = new HashBag();
			permBag.put(EngKeys.GROUP_PERMISSIONS,new HashMap());
			Iterator it = list.iterator();
			int i=0;
			while(it.hasNext())
			{
				TurqGroupPermission perm = (TurqGroupPermission)it.next();
				permBag.put(EngKeys.GROUP_PERMISSIONS,i,AdmKeys.ADM_MODULE_ID,perm.getTurqModule().getId());
				permBag.put(EngKeys.GROUP_PERMISSIONS,i,AdmKeys.ADM_MODULE_COMP_ID,perm.getTurqModuleComponent().getId());
				permBag.put(EngKeys.GROUP_PERMISSIONS,i,AdmKeys.ADM_GROUP_PERMISSION_LEVEL,new Integer(perm.getGroupPermissionsLevel()));
				permBag.put(EngKeys.GROUP_PERMISSIONS,i,AdmKeys.ADM_MODULE_COMP_NAME,perm.getTurqModuleComponent().getComponentsName());				
							
			}
			
			
			
			return permBag;
		}
		/*
		 * String query ="select DISTINCT GP.modules_id, GP.module_components_id, GP.group_permissions_level"; query +=" from
		 * turq_group_permissions GP, turq_users U, turq_user_group UG"; query +=" where U.username='"+username+"'AND U.users_id =
		 * UG.users_id"; query +=" AND GP.groups_id = UG.groups_id order by GP.group_permissions_id";
		 */
		catch (Exception e)
		{
			throw e;
		}
	}

	public static List getGroupPermissions() throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			
			String query = "select perms from TurqGroupPermission as perms";
			Query q = session.createQuery(query);
			List list = q.list();
		
			
			return list;
		}
		/*
		 * String query ="select DISTINCT GP.modules_id, GP.module_components_id, GP.group_permissions_level"; query +=" from
		 * turq_group_permissions GP, turq_users U, turq_user_group UG"; query +=" where U.username='"+username+"'AND U.users_id =
		 * UG.users_id"; query +=" AND GP.groups_id = UG.groups_id order by GP.group_permissions_id";
		 */
		catch (Exception e)
		{
			throw e;
		}
	}

	/**
	 * @param username
	 *             Current User of the system
	 * @return List of TurqUserPermission objects for the username
	 * @throws Exception
	 *              HiberNate Exception
	 */
	public static HashBag getUserPermissions(HashMap argMap) throws Exception
	{
		try
		{
			String username=(String)argMap.get(EngKeys.USER);
			Session session = EngDALSessionFactory.getSession();
			
			String query = "select perms from TurqUserPermission as perms where " + "perms.turqUser.username ='" + username + "'";
			Query q = session.createQuery(query);
			List list = q.list();
		
			HashBag permBag = new HashBag();
			permBag.put(EngKeys.USER_PERMISSIONS,new HashMap());
			Iterator it = list.iterator();
			int i=0;
			while(it.hasNext())
			{
				TurqUserPermission perm = (TurqUserPermission)it.next();
				permBag.put(EngKeys.USER_PERMISSIONS,i,AdmKeys.ADM_MODULE_ID,perm.getTurqModule().getId());
				permBag.put(EngKeys.USER_PERMISSIONS,i,AdmKeys.ADM_MODULE_COMP_ID,perm.getTurqModuleComponent().getId());
				permBag.put(EngKeys.USER_PERMISSIONS,i,AdmKeys.ADM_USER_PERMISSION_LEVEL,new Integer(perm.getTurqUserPermissionLevel().getPermissionLevel()));
				permBag.put(EngKeys.USER_PERMISSIONS,i,AdmKeys.ADM_MODULE_COMP_NAME,perm.getTurqModuleComponent().getComponentsName());				
			}
			
			
			return permBag;		
			
			
			/*
			 * String query ="select DISTINCT UP.modules_id, UP.components_id,UP.user_permissions_level"; query +=" from
			 * turq_user_permissions UP, turq_users U where UP.users_id = U.users_id"; query +=" AND U.username ='"+username+"' order by
			 * UP.user_permissions_id"; ResultSet rs = connection.getResultSet(query); return rs;
			 */
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	public static List getUserPermissions() throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			
			String query = "select perms from TurqUserPermission as perms";
			Query q = session.createQuery(query);
			List list = q.list();
		
			return list;
			/*
			 * String query ="select DISTINCT UP.modules_id, UP.components_id,UP.user_permissions_level"; query +=" from
			 * turq_user_permissions UP, turq_users U where UP.users_id = U.users_id"; query +=" AND U.username ='"+username+"' order by
			 * UP.user_permissions_id"; ResultSet rs = connection.getResultSet(query); return rs;
			 */
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	/**
	 * @param module_id
	 *             --Module id
	 * @param component_id
	 *             --ModuleComponent id
	 * @return -- ModuleComponent Name
	 * @throws Exception --
	 *              Hibernate Exception
	 */
	public static String getModuleCompName(int module_id, int component_id) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "select comp.componentsName from TurqModuleComponent as comp" + " where comp.id= " + component_id;
			Query q = session.createQuery(query);
			List lst = q.list();
			String s = lst.get(0).toString();
						
			return s;
			/*
			 * String query ="select components_name from turq_module_components"; query+=" where modules_id="+module_id+" AND
			 * module_components_id="+component_id; ResultSet rs = connection.getResultSet(query); if(rs.next()){ String name =
			 * rs.getString(1); rs.close(); return name; } rs.close(); return "";
			 */
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	/**
	 * @return List of all TurqModuleComponents objects
	 * @throws Exception
	 *              Hibernate Exception
	 */
	public static HashBag getModuleComponents() throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			Query q = session.createQuery("select comp.id,comp.turqModule.id,comp.componentsName from TurqModuleComponent comp "+
						"where comp.id > -1");

			List list = q.list();
			Iterator it = list.iterator();
			HashMap modules = new HashMap();
			while(it.hasNext())
			{
			  
			  Object[] comp =(Object[])it.next();
			  Integer componentId =(Integer)comp[0];
			  Integer moduleId=(Integer)comp[1];
			  String compName =(String)comp[2];
			  
			  List compList =(List)modules.get(moduleId);
			  if(compList==null)
			  {
				  compList=new ArrayList();
			  }			  
			  
			  HashMap compMap = new HashMap();
			  compMap.put(AdmKeys.ADM_MODULE_COMP_ID,componentId);  
			  compMap.put(AdmKeys.ADM_MODULE_COMP_NAME,compName);
			  compList.add(compMap);	
			  
			  modules.put(moduleId,compList);
			  
			
			}
			
			HashBag compBag = new HashBag();
			compBag.put(EngKeys.MODULE_COMPONENTS,modules);
			
			
			
			return compBag;
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	/**
	 * @param module_id
	 *             --Module id
	 * @return List of TurqModuleComponent objects of the specified module
	 * @throws Exception
	 */
	public static List getModuleComponents(int module_id) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			
			String query=" Select modComp from TurqModuleComponent modComp where modComp.turqModule.id="+module_id;
			Query q = session.createQuery(query);
			List list = q.list();
		
			return list;
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	public static List getModules() throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "select module from TurqModule as module order by module.id";
			Query q = session.createQuery(query);
			List list = q.list();
		
			
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static List getUserPermissonLevels() throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
		
			String query = "select permissionlvl from TurqUserPermissionLevel permissionlvl order by permissionlvl.id";
			Query q = session.createQuery(query);
			List list = q.list();
			
		
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}