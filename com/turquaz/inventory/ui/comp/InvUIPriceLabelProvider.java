/*
 * Created on Oct 12, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.inventory.ui.comp;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.turquaz.inventory.Messages;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class InvUIPriceLabelProvider extends LabelProvider implements ITableLabelProvider { 
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}
	public String getColumnText(Object element, int columnIndex) {
		String result = ""; //$NON-NLS-1$
		InvUIPrice price = (InvUIPrice) element;
		switch (columnIndex) {
		
			case 0 :
				result = price.priceType;
				break;
			case 1 :
				result = price.amount;
				break;
			case 2 :
				result = price.abrev;
				break;
			default :
				break; 	
		}
		return result;
	}
	
}
