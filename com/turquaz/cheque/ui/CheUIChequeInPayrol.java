package com.turquaz.cheque.ui;

import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Table;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;
import com.turquaz.engine.ui.component.SecureComposite;



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
public class CheUIChequeInPayrol extends org.eclipse.swt.widgets.Composite implements SecureComposite{

    {
        //Register as a resource user - SWTResourceManager will
        //handle the obtaining and disposing of resources
        SWTResourceManager.registerResourceUser(this);
    }

	private Composite compInfoPanel;
	private ToolBar toolBarButtons;
	private ToolItem toolItemAdd;
	private Table tableCheques;
	private ToolItem toolItemUpdate;
	private ToolItem toolItemDelete;

	public CheUIChequeInPayrol(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setBackground(SWTResourceManager.getColor(255, 255, 255));
			this.setSize(663, 373);
            {
                compInfoPanel = new Composite(this, SWT.NONE);
                GridLayout compInfoPanelLayout = new GridLayout();
                GridData compInfoPanelLData = new GridData();
                compInfoPanelLData.grabExcessHorizontalSpace = true;
                compInfoPanelLData.horizontalAlignment = GridData.FILL;
                compInfoPanelLData.heightHint = 108;
                compInfoPanel.setLayoutData(compInfoPanelLData);
                compInfoPanelLayout.makeColumnsEqualWidth = true;
                compInfoPanel.setLayout(compInfoPanelLayout);
            }
            {
                toolBarButtons = new ToolBar(this, SWT.FLAT | SWT.RIGHT);
                GridData toolBarButtonsLData = new GridData();
                toolBarButtonsLData.horizontalAlignment = GridData.FILL;
                toolBarButtonsLData.grabExcessHorizontalSpace = true;
                toolBarButtons.setLayoutData(toolBarButtonsLData);
                {
                    toolItemAdd = new ToolItem(toolBarButtons, SWT.NONE);
                    toolItemAdd.setText("Ekle");
                    toolItemAdd.setImage(SWTResourceManager.getImage("icons/plus.gif"));
                    
                }
                {
                    toolItemDelete = new ToolItem(toolBarButtons, SWT.NONE);
                    toolItemDelete.setText("Ç?kar");
                    toolItemDelete.setImage(SWTResourceManager
                        .getImage("icons/minus.gif"));
                }
                {
                    toolItemUpdate = new ToolItem(toolBarButtons, SWT.NONE);
                    toolItemUpdate.setText("De?i?tir");
                    toolItemUpdate.setImage(SWTResourceManager.getImage("icons/Refresh16.gif"));
                }
            }
            {
                tableCheques = new Table(this, SWT.NONE);
                tableCheques.setLinesVisible(true);
                tableCheques.setHeaderVisible(true);
                GridData tableChequesLData = new GridData();
                tableChequesLData.grabExcessHorizontalSpace = true;
                tableChequesLData.horizontalAlignment = GridData.FILL;
                tableChequesLData.verticalAlignment = GridData.FILL;
                tableChequesLData.grabExcessVerticalSpace = true;
                tableCheques.setLayoutData(tableChequesLData);
            }
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    public void newForm() {
        // TODO Auto-generated method stub

    }
    public void save() {
        // TODO Auto-generated method stub

    }
}
