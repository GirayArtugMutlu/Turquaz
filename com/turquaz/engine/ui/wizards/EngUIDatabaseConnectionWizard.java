/*
 * Created on Nov 1, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.ui.wizards;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.Wizard;
public class EngUIDatabaseConnectionWizard extends Wizard {
    
	private EngUIDatabaseSelectionWizardPage page1;
	private ISelection selection;
	
	public EngUIDatabaseConnectionWizard(){
		super();
		setNeedsProgressMonitor(true);
	}
	public void addPages(){
		
		page1 = new EngUIDatabaseSelectionWizardPage(selection);
		
		addPage(page1);
		
	}
	public boolean performFinish(){
		return true;
	}
}
