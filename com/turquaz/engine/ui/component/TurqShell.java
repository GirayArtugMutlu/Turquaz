/*
 * Created on Oct 22, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.ui.component;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.turquaz.engine.ui.EngUIMainFrame;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TurqShell extends Shell {

	public TurqShell(){
		super();
	}
	public TurqShell(Display d){
		super(d);
	}
	public void dispose(){
		EngUIMainFrame.saveFavoritesTree();
		super.dispose();
	}
	
	
}
