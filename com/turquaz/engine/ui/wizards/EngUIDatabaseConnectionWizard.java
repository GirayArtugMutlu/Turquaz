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
    
	private EngUIDatabaseTypeWizardPage page1;
	private EngUIDatabaseConnectionInfoWizardPage page2;
	private EngUIDatabaseSelectionWizardPage page3;
	private ISelection selection;
	
	public EngUIDatabaseConnectionWizard(){
		super();
		setNeedsProgressMonitor(true);
	}
	public void addPages(){
		
		page1 = new EngUIDatabaseTypeWizardPage(selection);
		page2 = new  EngUIDatabaseConnectionInfoWizardPage(selection);
		//page3 = new EngUIDatabaseSelectionWizardPage(selection);
		addPage(page1);
		addPage(page2);
		
		
	}
	public boolean performFinish(){
		return true;
	}
	/**
	 * @return Returns the page1.
	 */
	public EngUIDatabaseTypeWizardPage getPage1() {
		return page1;
	}
	/**
	 * @param page1 The page1 to set.
	 */
	public void setPage1(EngUIDatabaseTypeWizardPage page1) {
		this.page1 = page1;
	}
	/**
	 * @return Returns the page2.
	 */
	public EngUIDatabaseConnectionInfoWizardPage getPage2() {
		return page2;
	}
	/**
	 * @param page2 The page2 to set.
	 */
	public void setPage2(EngUIDatabaseConnectionInfoWizardPage page2) {
		this.page2 = page2;
	}
	/**
	 * @return Returns the page3.
	 */
	public EngUIDatabaseSelectionWizardPage getPage3() {
		return page3;
	}
	/**
	 * @param page3 The page3 to set.
	 */
	public void setPage3(EngUIDatabaseSelectionWizardPage page3) {
		this.page3 = page3;
	}
	/**
	 * @return Returns the selection.
	 */
	public ISelection getSelection() {
		return selection;
	}
	/**
	 * @param selection The selection to set.
	 */
	public void setSelection(ISelection selection) {
		this.selection = selection;
	}
}
