package com.turquaz.bank.ui;


import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;

import com.turquaz.engine.ui.component.SearchComposite;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* *************************************
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED
* for this machine, so Jigloo or this code cannot be used legally
* for any corporate or commercial purpose.
* *************************************
*/
public class BankUISearchMoneyTransaction extends org.eclipse.swt.widgets.Composite implements SearchComposite {

    {
        //Register as a resource user - SWTResourceManager will
        //handle the obtaining and disposing of resources
        SWTResourceManager.registerResourceUser(this);
    }

	private Composite compSearch;
	private Table tableMoneyTrans;

	public BankUISearchMoneyTransaction(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setBackground(SWTResourceManager.getColor(255, 255, 255));
			this.setSize(650, 400);
            {
                compSearch = new Composite(this, SWT.NONE);
                GridLayout compSearchLayout = new GridLayout();
                GridData compSearchLData = new GridData();
                compSearchLData.horizontalAlignment = GridData.FILL;
                compSearchLData.grabExcessHorizontalSpace = true;
                compSearchLData.heightHint = 100;
                compSearch.setLayoutData(compSearchLData);
                compSearchLayout.makeColumnsEqualWidth = true;
                compSearch.setLayout(compSearchLayout);
            }
            {
                tableMoneyTrans = new Table(this, SWT.NONE);
                GridData tableMoneyTransLData = new GridData();
                tableMoneyTrans.setHeaderVisible(true);
                tableMoneyTrans.setLinesVisible(true);
                tableMoneyTransLData.horizontalAlignment = GridData.FILL;
                tableMoneyTransLData.verticalAlignment = GridData.FILL;
                tableMoneyTransLData.grabExcessVerticalSpace = true;
                tableMoneyTrans.setLayoutData(tableMoneyTransLData);
            }
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    public void delete() {
        // TODO Auto-generated method stub

    }
    public void exportToExcel() {
        // TODO Auto-generated method stub

    }
    public void printTable() {
        // TODO Auto-generated method stub

    }
    public void search() {
        // TODO Auto-generated method stub

    }
}
