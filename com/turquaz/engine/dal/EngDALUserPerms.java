
package com.turquaz.engine.dal;


import java.util.List;

import net.sf.hibernate.Criteria;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.expression.Expression;

/**
 * @author onsel
 * @version $Id$
 * 
 * Database functions for calculating user permissions.
 * 
 */
public class EngDALUserPerms {

	/**
	 * Default Constructor
	 *
	 */
	public EngDALUserPerms() {

	}

	/**
	 * 
	 * @param username Current user of the system
	 * @return List of TurqGroupPermission objects for username
	 * @throws Exception "Hibernate Exception"
	 */
	public static List getGroupPermissions(String username)throws Exception{
	try{
	Session session = EngDALSessionFactory.openSession();
	Transaction tx = session.beginTransaction();
	String query = "select perms from TurqGroupPermission as perms,"+
				   "TurqUserGroup as ug " +
				   "where ug.turqGroup =perms.turqGroup and " +
				   "ug.turqUser.username ='"+username+"'";	
				   
	
	Query q = session.createQuery(query); 
	List list = q.list();
	tx.commit();
	session.close();
	
	return list;
	}
	 	
	/* String query ="select DISTINCT GP.modules_id, GP.module_components_id,	 GP.group_permissions_level";
	 query +=" from turq_group_permissions GP,	 turq_users U, turq_user_group UG";
	 query +=" where U.username='"+username+"'AND U.users_id = UG.users_id";
	 query +=" AND GP.groups_id = UG.groups_id order by GP.group_permissions_id";
	 
	*/ 
	 
	 
	catch(Exception e)
	{ throw e;
}
} 
	public static List getGroupPermissions()throws Exception{
		try{
		Session session = EngDALSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String query = "select perms from TurqGroupPermission as perms";		   
		
		Query q = session.createQuery(query); 
		List list = q.list();
		tx.commit();
		session.close();
		
		return list;
		}
		 	
		/* String query ="select DISTINCT GP.modules_id, GP.module_components_id,	 GP.group_permissions_level";
		 query +=" from turq_group_permissions GP,	 turq_users U, turq_user_group UG";
		 query +=" where U.username='"+username+"'AND U.users_id = UG.users_id";
		 query +=" AND GP.groups_id = UG.groups_id order by GP.group_permissions_id";
		 
		*/ 
		 
		 
		catch(Exception e)
		{ throw e;
	}
	} 
	 
/**
 * 
 * @param username Current User of the system
 * @return List of TurqUserPermission objects for the username
 * @throws Exception HiberNate Exception
 */
	
 public static List getUserPermissions(String username)throws Exception{ 
 try{
	 
 		Session session = EngDALSessionFactory.openSession();
 		Transaction tx = session.beginTransaction();
 		String query = "select perms from TurqUserPermission as perms where "+
 					   "perms.turqUser.username ='"+username+"'";	
 					   
 		
 		Query q = session.createQuery(query); 
 		List list = q.list();
 		tx.commit();
 		session.close();
 		
 		return list;
 		
 	
 	/*
 	String query ="select DISTINCT UP.modules_id, UP.components_id,UP.user_permissions_level"; query +=" from turq_user_permissions UP,
	 turq_users U where UP.users_id = U.users_id"; query +=" AND U.username
	 ='"+username+"' order by UP.user_permissions_id";
	 
	 
	 ResultSet rs = connection.getResultSet(query); return rs;
	*/ 
	 
	 
	  }
 	catch(Exception e){
 		throw e; 
 		} 
 	}
 
 public static List getUserPermissions()throws Exception{
 	try{
	 
 		Session session = EngDALSessionFactory.openSession();
 		Transaction tx = session.beginTransaction();
 		String query = "select perms from TurqUserPermission as perms"; 		
 		Query q = session.createQuery(query); 
 		List list = q.list();
 		tx.commit();
 		session.close();
 		
 		return list;	
 	
 	/*
 	String query ="select DISTINCT UP.modules_id, UP.components_id,UP.user_permissions_level"; query +=" from turq_user_permissions UP,
	 turq_users U where UP.users_id = U.users_id"; query +=" AND U.username
	 ='"+username+"' order by UP.user_permissions_id";
	 
	 
	 ResultSet rs = connection.getResultSet(query); return rs;
	*/ 
	 
	 
	  }
 	catch(Exception e){
 		throw e; 
 		} 
 	}
 
 
	/**
	 * 
	 * @param module_id --Module id
	 * @param component_id --ModuleComponent id
	 * @return -- ModuleComponent Name
	 * @throws Exception -- Hibernate Exception
	 */
	 public static String getModuleCompName(int module_id, int component_id)throws
	 Exception{ 
	 	try{
	 
	 		Session session = EngDALSessionFactory.openSession();
	 		Transaction tx = session.beginTransaction();
	 		String query = "select comp.componentsName from TurqModuleComponent as comp"+
			   " where comp.id= "+component_id+
			   " and comp.id="+module_id;	
			   

            Query q = session.createQuery(query); 
	 		List lst = q.list();
	 		String s =lst.get(0).toString();
	 		tx.commit();
	 		session.close();
	 		return s;
	 		
	 
/*	 String query ="select components_name from turq_module_components";
	 query+=" where modules_id="+module_id+" AND
	 module_components_id="+component_id;
	 
	 ResultSet rs = connection.getResultSet(query); if(rs.next()){ String name =
	 rs.getString(1); rs.close(); return name; } rs.close(); return "";
	 */
	  } catch(Exception e){ throw e; }

	 }

	 /**
	  * 
	  * @return List of all TurqModuleComponents objects   
	  * @throws Exception Hibernate Exception
	  */
	public static List getModuleComponents() throws Exception {
		try {
			Session session = EngDALSessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			//	Query q = session.createQuery("from TurqModuleComponent comp "+
			//			"where comp.moduleComponentsId > -1");
			Criteria cri = session.createCriteria(TurqModuleComponent.class)
					.add(Expression.gt("id", new Integer(-1)));
			List list = cri.list();
			tx.commit();
			session.close();
			return list;

		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 
	 * @param module_id --Module id
	 * @return List of TurqModuleComponent objects of the specified module
	 * @throws Exception
	 */
	  public static List getModuleComponents(int module_id)throws Exception{ 
	  	
	  
	  	try {
			Session session = EngDALSessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			//	Query q = session.createQuery("from TurqModuleComponent comp "+
			//			"where comp.moduleComponentsId > -1");
			Criteria cri = session.createCriteria(TurqModuleComponent.class)
					.add(Expression.gt("id", new Integer(-1)))
					.add(Expression.eq("turqModule.id",new Integer(module_id)));
			List list = cri.list();
			tx.commit();
			session.close();
			return list;
			

		} 
	  	catch (Exception e) {
			throw e;
		}
	}
	  
	  public static List getModules()throws Exception {
	  	try{
	  		
	  		Session session = EngDALSessionFactory.openSession();
	 		Transaction tx = session.beginTransaction();
	 		String query = "select module from TurqModule as module order by module.id"; 		
	 		Query q = session.createQuery(query); 
	 		List list = q.list();
	 		tx.commit();
	 		session.close();
	 		
	 		return list;	
	  		
	  	}
	  	catch(Exception ex){
	  		throw ex;
	  	}
	  }
}
	  
	 