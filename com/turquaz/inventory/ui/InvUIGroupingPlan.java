package com.turquaz.inventory.ui;

import java.util.Iterator;
import java.util.List;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.custom.TableTreeItem;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;

import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.inventory.bl.InvBLCardAdd;


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
public class InvUIGroupingPlan extends org.eclipse.swt.widgets.Composite {
	private TableTree tableTreeGroups;
	private TableColumn tableColumnGroupName;
	private TableColumn tableColumnGrupDefinition;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void main(String[] args) {
		showGUI();
	}
		
	/**
	* Auto-generated method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void showGUI() {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		InvUIGroupingPlan inst = new InvUIGroupingPlan(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if(size.x == 0 && size.y == 0) {
			inst.pack();
			shell.pack();
		} else {
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			int MENU_HEIGHT = 22;
			if (shell.getMenuBar() != null)
				shellBounds.height -= MENU_HEIGHT;
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public InvUIGroupingPlan(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setSize(580, 362);
            {
                tableTreeGroups = new TableTree(this, SWT.NONE);
                GridData tableTreeGroupsLData = new GridData();
                tableTreeGroupsLData.grabExcessHorizontalSpace = true;
                tableTreeGroupsLData.horizontalAlignment = GridData.FILL;
                tableTreeGroupsLData.grabExcessVerticalSpace = true;
                tableTreeGroupsLData.verticalAlignment = GridData.FILL;
                tableTreeGroups.setLayoutData(tableTreeGroupsLData);
                tableTreeGroups.getTable().setHeaderVisible(true);
                tableTreeGroups.getTable().setLinesVisible(true);
                {
                    tableColumnGroupName = new TableColumn(tableTreeGroups
                        .getTable(), SWT.NONE);
                    tableColumnGroupName.setText("Grup Ad\u0131");
                    tableColumnGroupName.setWidth(150);
                }
                {
                    tableColumnGrupDefinition = new TableColumn(tableTreeGroups
                        .getTable(), SWT.NONE);
                    tableColumnGrupDefinition.setText("Aç\u0131klama");
                    tableColumnGrupDefinition.setWidth(150);
                }
            }
            postInitGUI();
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void postInitGUI(){
	    fillTable();
	   
	}
	public void fillTable(){
	    try{
		       List ls = InvBLCardAdd.getParentInventoryGroups();
		       TableTreeItem item;
		       TableTreeItem subItem;
		       TurqInventoryGroup invGroup;
		       for(int i=0;i<ls.size();i++)
		       {
		            invGroup = (TurqInventoryGroup)ls.get(i);
		            item = new TableTreeItem(tableTreeGroups,SWT.NULL);
		            item.setData(invGroup);
		            item.setText(0,invGroup.getGroupsName());
		            item.setText(1,invGroup.getGroupsDescription());
		            Iterator it = invGroup.getTurqInventoryGroups().iterator();
		            while(it.hasNext())
		            {
		                invGroup = (TurqInventoryGroup)it.next();
			            subItem = new TableTreeItem(item,SWT.NULL);
			            subItem.setData(invGroup);
			            subItem.setText(0,invGroup.getGroupsName());
			            subItem.setText(1,invGroup.getGroupsDescription());
			            item.setExpanded(true);
		            }
		            
		       
		       }
		        
		        
		    }
		    catch(Exception ex){
		        ex.printStackTrace();
		    }
		    
	}

}
