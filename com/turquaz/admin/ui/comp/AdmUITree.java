/*
 * Created on 29.Aðu.2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.turquaz.admin.ui.comp;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.*;

import com.turquaz.admin.ui.AdmUIPermPanel;

/**
 * @author onsel
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AdmUITree extends Tree {
	public AdmUITree(Composite comp, int style){
		super(comp,style);
		TreeItem root = new TreeItem(this,SWT.NULL);
		root.setText("Yönetici");
		TreeItem item = new TreeItem(root,SWT.NULL);
		item.setText("Kullanýcý Ýzinleri");
		item.setData(AdmUIPermPanel.class.getName());
	}
	
}
