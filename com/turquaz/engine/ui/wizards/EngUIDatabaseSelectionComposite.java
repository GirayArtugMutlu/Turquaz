/*
 * Created on Nov 1, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.ui.wizards;

import org.eclipse.swt.widgets.Composite;


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
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EngUIDatabaseSelectionComposite extends Composite {
	private CLabel lblDatabaseType;
	private CCombo comboDatabaseServer;
	public EngUIDatabaseSelectionComposite(Composite parent, int style){
		super(parent,style);
	}
	
	private void initGUI() {
		try {
			{
				this.setSize(411, 146);
				this.setLayout(null);
				{
					lblDatabaseType = new CLabel(this, SWT.NONE);
					lblDatabaseType.setText("Database Server ");
					lblDatabaseType.setBounds(10, 49, 129, 16);
				}
				{
					comboDatabaseServer = new CCombo(this, SWT.NONE);
					comboDatabaseServer.setText("Please Choose Your Server");
					comboDatabaseServer.setBounds(149, 47, 240, 18);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
