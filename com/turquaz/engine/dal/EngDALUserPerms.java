/*
 * Created on 31.Aðu.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import net.sf.hibernate.Criteria;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.expression.Expression;

/**
 * @author onsel
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class EngDALUserPerms {

	public EngDALUserPerms() {

	}

	
	public List getGroupPermissions(String username)throws Exception{
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
	 
	 
 public List getUserPermissions(String username)throws Exception{
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
	
	 public String getModuleCompName(int module_id, int component_id)throws
	 Exception{ 
	 	try{
	 
	 		Session session = EngDALSessionFactory.openSession();
	 		Transaction tx = session.beginTransaction();
	 		String query = "select comp.componentsName from TurqModuleComponent as comp"+
			   " where comp.moduleComponentsId= "+component_id+
			   " and comp.turqModule.modulesId="+module_id;	
			   

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
	
	public List getModuleComponents() throws Exception {
		try {
			Session session = EngDALSessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			//	Query q = session.createQuery("from TurqModuleComponent comp "+
			//			"where comp.moduleComponentsId > -1");
			Criteria cri = session.createCriteria(TurqModuleComponent.class)
					.add(Expression.gt("moduleComponentsId", new Integer(-1)));
			List list = cri.list();
			tx.commit();
			session.close();
			return list;

		} catch (Exception e) {
			throw e;
		}
	}

	  public List getModuleComponents(int module_id)throws Exception{ 
	  	
	  
	  	try {
			Session session = EngDALSessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			//	Query q = session.createQuery("from TurqModuleComponent comp "+
			//			"where comp.moduleComponentsId > -1");
			Criteria cri = session.createCriteria(TurqModuleComponent.class)
					.add(Expression.gt("moduleComponentsId", new Integer(-1)))
					.add(Expression.eq("modulesId",new Integer(module_id)));
			List list = cri.list();
			tx.commit();
			session.close();
			return list;
			

		} 
	  	catch (Exception e) {
			throw e;
		}
	}
}
	  
	 