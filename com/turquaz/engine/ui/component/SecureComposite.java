/*
 * Created on 28.Aðu.2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.turquaz.engine.ui.component;

import org.eclipse.swt.widgets.Composite;

/**
 * @author onsel
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public abstract class SecureComposite extends Composite {
	public SecureComposite(Composite parent,int style){
		super(parent, style);		
	}
	
	final public int getPermission(String compname){
	 if(compname.equals("com.turquaz.inventory.ui.InvUICardAdd"))
	 return 2;
	 
	 return 3;
	
	}

}
