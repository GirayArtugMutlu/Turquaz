package com.turquaz.accounting.ui;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class AccUITransactionSearch extends org.eclipse.swt.widgets.Composite {

	private Table table1;
	private Composite composite1;
	public AccUITransactionSearch(Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	/**
	* Initializes the GUI.
	* Auto-generated code - any changes you make will disappear.
	*/
	public void initGUI(){
		try {
			preInitGUI();
	
			composite1 = new Composite(this,SWT.NULL);
			table1 = new Table(this,SWT.NULL);
	
			this.setSize(new org.eclipse.swt.graphics.Point(680,513));
	
			GridData composite1LData = new GridData();
			composite1LData.verticalAlignment = GridData.CENTER;
			composite1LData.horizontalAlignment = GridData.FILL;
			composite1LData.widthHint = -1;
			composite1LData.heightHint = 129;
			composite1LData.horizontalIndent = 0;
			composite1LData.horizontalSpan = 1;
			composite1LData.verticalSpan = 1;
			composite1LData.grabExcessHorizontalSpace = true;
			composite1LData.grabExcessVerticalSpace = false;
			composite1.setLayoutData(composite1LData);
			composite1.setSize(new org.eclipse.swt.graphics.Point(670,129));
			FormLayout composite1Layout = new FormLayout();
			composite1.setLayout(composite1Layout);
			composite1Layout.marginWidth = 0;
			composite1Layout.marginHeight = 0;
			composite1Layout.spacing = 0;
			composite1.layout();
	
			GridData table1LData = new GridData();
			table1LData.verticalAlignment = GridData.FILL;
			table1LData.horizontalAlignment = GridData.FILL;
			table1LData.widthHint = -1;
			table1LData.heightHint = -1;
			table1LData.horizontalIndent = 0;
			table1LData.horizontalSpan = 1;
			table1LData.verticalSpan = 1;
			table1LData.grabExcessHorizontalSpace = true;
			table1LData.grabExcessVerticalSpace = true;
			table1.setLayoutData(table1LData);
			table1.setSize(new org.eclipse.swt.graphics.Point(654,353));
			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 5;
			this.layout();
	
			postInitGUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** Add your pre-init code in here 	*/
	public void preInitGUI(){
	}

	/** Add your post-init code in here 	*/
	public void postInitGUI(){
	}
}
