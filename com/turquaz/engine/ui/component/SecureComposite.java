
/************************************************************************/
/* TURQUAZ: Higly Modular Accounting/ERP Program                        */
/* ============================================                         */
/* Copyright (c) 2004 by Turquaz Software Development Group			    */
/*																		*/
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or    */
/* (at your option) any later version.       							*/
/* 																		*/
/* This program is distributed in the hope that it will be useful,		*/
/* but WITHOUT ANY WARRANTY; without even the implied warranty of		*/
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the		*/
/* GNU General Public License for more details.         				*/
/************************************************************************/

package com.turquaz.engine.ui.component;

import org.eclipse.swt.widgets.Composite;

import com.turquaz.engine.bl.EngBLPermissions;

/**
 * @author onsel
 *
 * @version $Id$
 */
public abstract class SecureComposite extends Composite {
	public SecureComposite(Composite parent,int style){
		super(parent, style);		
	}
	
	final public int getPermission(String compname){
	return EngBLPermissions.getPermission(compname);
	}

}
