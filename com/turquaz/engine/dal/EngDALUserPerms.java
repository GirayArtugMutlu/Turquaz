/*
 * Created on 31.Aðu.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.dal;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EngDALUserPerms {
	EngDALConnection connection;
	public EngDALUserPerms(){
		connection = new EngDALConnection();
		try{
		   connection.connect();
		}
		catch(Exception e){
		   e.printStackTrace();
		}
	}
	public ResultSet getGroupPermissions(String username)throws Exception{		
		try{
			
			String query ="select DISTINCT GP.modules_id, GP.module_components_id, GP.group_permissions_level";
			query +=" from turq_group_permissions GP, turq_users U, turq_user_group UG";
			query +=" where U.username='"+username+"'AND U.users_id = UG.users_id";
			query +=" AND GP.groups_id = UG.groups_id order by GP.group_permissions_id"; 
			
		
			ResultSet rs = connection.getResultSet(query);
			return rs;
			
		}
		catch(Exception e){
			throw e;
					
		}		
				
	}
	public ResultSet getUserPermissions(String username)throws Exception{
	try{
			
		
		String query ="select DISTINCT UP.modules_id, UP.components_id, UP.user_permissions_level";
		query +=" from turq_user_permissions UP, turq_users U where UP.users_id = U.users_id";
		query +=" AND U.username ='"+username+"' order by UP.user_permissions_id";
	
		
		ResultSet rs = connection.getResultSet(query);
		return rs;
		
		
	}
	catch(Exception e){	
		throw e;
	}
	}
	
	public String getModuleCompName(int module_id, int component_id)throws Exception{
		try{
			
		
		String query ="select components_name from turq_module_components";
		       query+=" where modules_id="+module_id+" AND module_components_id="+component_id;
			
		ResultSet rs = connection.getResultSet(query);
		if(rs.next()){
		String name = rs.getString(1);
		rs.close();
		return name;
		}
		rs.close();
		return "";
		
		
		
	}
	catch(Exception e){	
		throw e;
	}
	
		
	}
	
	public ResultSet getModuleComponents()throws Exception{
		try{
				
			
			String query ="select components_name from turq_module_components";
			
			
			ResultSet rs = connection.getResultSet(query);
			return rs;
			
			
		}
		catch(Exception e){	
			throw e;
		}
	}


	
	public ArrayList getModuleComponents(int module_id)throws Exception{
		try{
				
			
			String query ="select components_name from turq_module_components";
			       query +=" where modules_id="+module_id;
				
			System.out.println(query);      
			ResultSet rs = connection.getResultSet(query);
			ArrayList list = new ArrayList();
			while(rs.next()){
			list.add(rs.getString(1));
			}
			rs.close();
			return list;
			
			
			
		}
		catch(Exception e){	
			throw e;
		}
		}

}
