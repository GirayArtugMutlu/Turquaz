/*  Copyright (C) 2004 by Friederich Kupzog Elektronik & Software
 
    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU Lesser General Public
    License as published by the Free Software Foundation; either
    version 2.1 of the License, or (at your option) any later version.

    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
    
    Author: Friederich Kupzog  
    fkmk@kupzog.de
    www.kupzog.de/fkmk
*/
 
 
package de.kupzog.ktools.kprint.gui;

import org.eclipse.swt.custom.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.*;
import org.eclipse.swt.printing.*;

import de.kupzog.ktools.kprint.boxes.*;


/**
 * A GUI dialog that layouts and displays a PDocument.
 * It also allows to print the document.
 * @author Friederich Kupzog
 */
public class PrintPreview 
extends KDialog{


	protected PDocument document;
	
	protected Label guiImageLabel;
	protected CLabel guiPageLabel;
	protected Combo guiZoom;
	protected ScrolledComposite guiScrollArea;
	
	protected boolean layoutNeccessary;
	
	protected int percent;
	
	protected int page;
	
	/**
	 * @param parent
	 * @param title
	 * @param icon
	 */
	public PrintPreview(Shell parent, String title, Image icon, PDocument doc) {
		super(parent, title, icon);
		createContents();
		document = doc;
		page = 1;
		percent = 100;
		layoutNeccessary = true;

		addToolItem("print", Messages.getString("PrintPreview.1"), IconSource.getImage("print")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		addToolItem("first", Messages.getString("PrintPreview.4"), IconSource.getImage("i2")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		addToolItem("prev", Messages.getString("PrintPreview.7"), IconSource.getImage("i3")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		addToolItem("next", Messages.getString("PrintPreview.10"), IconSource.getImage("i4")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		addToolItem("last", Messages.getString("PrintPreview.13"), IconSource.getImage("i5")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		Button close = addButtonRight(Messages.getString("PrintPreview.0"),""); //$NON-NLS-1$ //$NON-NLS-2$
		//addButtonRight("Seite &einrichten","");
		close.setFocus();
		
		guiShell.addShellListener(new ShellAdapter() {
			public void shellClosed(ShellEvent arg0) {
				onClose();
			}
		});

		Composite comp = new Composite(guiToolBarArea, SWT.BORDER);
		comp.setLayout(new FillLayout());
		guiPageLabel = new CLabel(comp, SWT.NONE);
		guiPageLabel.setText(guiPageLabel.getText()+"        "); //$NON-NLS-1$
		guiPageLabel.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		adjustToToolBar(comp);
		
		guiZoom = new Combo(guiToolBarArea, SWT.BORDER | SWT.READ_ONLY);
		guiZoom.add("500%"); //$NON-NLS-1$
		guiZoom.add("200%"); //$NON-NLS-1$
		guiZoom.add("100%"); //$NON-NLS-1$
		guiZoom.add("80%"); //$NON-NLS-1$
		guiZoom.add("50%"); //$NON-NLS-1$
		guiZoom.add("20%"); //$NON-NLS-1$
		guiZoom.add("passend"); //$NON-NLS-1$
		adjustToToolBar(guiZoom);
		guiZoom.setToolTipText("Vorschaugröße"); //$NON-NLS-1$
		guiZoom.select(2);
		guiZoom.addSelectionListener(
			new SelectionAdapter() {
				public void widgetSelected(SelectionEvent arg0) {
					onCombo(((Combo)arg0.widget).getText());
				}
			}
		);
		guiMainArea.setLayout(new FillLayout());
		guiScrollArea = new ScrolledComposite(guiMainArea,SWT.H_SCROLL | SWT.V_SCROLL);
		guiImageLabel = new Label(guiScrollArea, SWT.NONE);
		guiScrollArea.setContent(guiImageLabel);
		if (guiImageLabel.getImage()!= null) guiImageLabel.getImage().dispose();
		guiImageLabel.setImage(getPageImage(page));
		guiPageLabel.setText(Messages.getString("PrintPreview.26")+page+Messages.getString("PrintPreview.27")+ document.getNumOfPages()+ Messages.getString("PrintPreview.28")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		guiImageLabel.setSize(guiImageLabel.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
	}
	
	public int getShellStyle() {
		return super.getShellStyle() | SWT.MAX | SWT.MIN;
	}

	
	protected void doLayout() {
		int x = Display.getCurrent().getBounds().width - 100;
		int y = Display.getCurrent().getBounds().height - 10;
		guiShell.setSize(x,y);
		guiShell.setMaximized(true);
	}
	


	
	public Image getPageImage(int page)
	{
		Point dpi = Display.getCurrent().getDPI();

		try {
			int h = (int)Math.round(document.getPageHeight()/2.54*dpi.y*percent/100 + 5);
			int w = (int)Math.round(document.getPageWidth()/2.54*dpi.x*percent/100 + 5);
			Image newImage = new Image(Display.getCurrent(), w, h);
			GC gc = new GC(newImage);

			PBox.setParameters(gc, Display.getCurrent(), dpi, percent);
			if (layoutNeccessary) document.layout();
			layoutNeccessary = false;
			document.draw(page);

			// Schatten
			
			gc.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_GRAY));
			gc.fillRectangle(0, newImage.getBounds().height-5, 
							newImage.getBounds().width, newImage.getBounds().height);
			gc.fillRectangle(newImage.getBounds().width-5, 0, 
							newImage.getBounds().width-5, newImage.getBounds().height);

			gc.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			gc.fillRectangle(0, newImage.getBounds().height-5, 
							 5, newImage.getBounds().height);
			gc.fillRectangle(newImage.getBounds().width-5, 0, 
							 newImage.getBounds().width, 5);

			
			gc.dispose(); 
			return newImage;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
			
	}
	
	protected void onCombo(String text)
	{
		if (text.startsWith(Messages.getString("PrintPreview.29"))) //$NON-NLS-1$
		{
			long ypixel = Math.round(document.getPageHeight()/2.54*Display.getCurrent().getDPI().y);
			long xpixel = Math.round(document.getPageWidth()/2.54*Display.getCurrent().getDPI().x);
			
			int yscale = (int)(100*(guiScrollArea.getBounds().height)/ypixel);
			int xscale = (int)(100*(guiScrollArea.getBounds().width)/xpixel);
			
			percent = Math.min(yscale, xscale);
		}
		else
		{
			text = text.substring(0,text.length()-1);
			percent = 100;
			try {
				percent = Integer.parseInt(text);	
			} catch (Exception e1) {
				MsgBox.show("'"+text+"' ist keine gültige Zahl."); //$NON-NLS-1$ //$NON-NLS-2$
				guiZoom.select(3);
			}
		}
		layoutNeccessary = true;
		if (guiImageLabel.getImage()!= null) guiImageLabel.getImage().dispose();
		guiImageLabel.setImage(getPageImage(page));
		guiImageLabel.setSize(guiImageLabel.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
	}
	
	protected void onToolItem(ToolItem toolitem, String name) {
		if (name.equals("next")) //$NON-NLS-1$
		{
			if (page < document.getNumOfPages())
			{
				page++;
				if (guiImageLabel.getImage()!= null) guiImageLabel.getImage().dispose();
				guiImageLabel.setImage(getPageImage(page));
				guiPageLabel.setText(Messages.getString("PrintPreview.2")+page+Messages.getString("PrintPreview.34")+ document.getNumOfPages()); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		else if (name.equals("prev")) //$NON-NLS-1$
		{
			if (page > 1)
			{
				page--;
				if (guiImageLabel.getImage()!= null) guiImageLabel.getImage().dispose();
				guiImageLabel.setImage(getPageImage(page));
				guiPageLabel.setText(Messages.getString("PrintPreview.3")+page+Messages.getString("PrintPreview.37")+ document.getNumOfPages()); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
		else if (name.equals(Messages.getString("PrintPreview.38"))) //$NON-NLS-1$
		{
			page = 1;
			if (guiImageLabel.getImage()!= null) guiImageLabel.getImage().dispose();
			guiImageLabel.setImage(getPageImage(page));
			guiPageLabel.setText(Messages.getString("PrintPreview.39")+page+Messages.getString("PrintPreview.40")+ document.getNumOfPages()); //$NON-NLS-1$ //$NON-NLS-2$
		}
		else if (name.equals("last")) //$NON-NLS-1$
		{
			page = document.getNumOfPages();
			if (guiImageLabel.getImage()!= null) guiImageLabel.getImage().dispose();
			guiImageLabel.setImage(getPageImage(page));
			guiPageLabel.setText(Messages.getString("PrintPreview.42")+page+Messages.getString("PrintPreview.43")+ document.getNumOfPages()); //$NON-NLS-1$ //$NON-NLS-2$
		}
		else if (name.equals("print")) //$NON-NLS-1$
		{
			onPrint();
		}
	}
	
	protected void onButton(Button button, String buttonText) {
		if (buttonText.startsWith(Messages.getString("PrintPreview.45"))) onClose(); //$NON-NLS-1$
		else if (buttonText.startsWith(Messages.getString("PrintPreview.46"))) onPageSetup(); //$NON-NLS-1$
	}
	
	protected void onClose()
	{
		if (guiImageLabel.getImage()!= null) guiImageLabel.getImage().dispose();
		PTextStyle.disposeFonts();
		close();
	}
	
	protected void onPageSetup()
	{
		/* funktioniert nicht:
		 * - Abgeschnittene Tabellen bleiben abgeschnitten
		 * - Skalierung geht nicht
		 */
		PageSetup ps = new PageSetup(guiShell);
		ps.open();
		document.readMeasuresFromPageSetup();
		layoutNeccessary = true;
		if (guiImageLabel.getImage()!= null) guiImageLabel.getImage().dispose();
		guiImageLabel.setImage(getPageImage(page));
		guiImageLabel.setSize(guiImageLabel.computeSize(SWT.DEFAULT, SWT.DEFAULT));

	}
	
	
	protected void onPrint()
	{
		PrintDialog dialog = new PrintDialog(guiShell, SWT.BORDER);
		PrinterData data = dialog.open();
		if (data == null) return;
		if (data.printToFile) {
			FileDialog d = new FileDialog (guiShell, SWT.SAVE);
			d.setFilterNames (new String [] {"All Files (*.*)"}); //$NON-NLS-1$
			d.setFilterExtensions (new String [] {"*.*"}); //Windows wild cards //$NON-NLS-1$
			d.setFilterPath ("c:\\"); //Windows path //$NON-NLS-1$
			d.setFileName (""); //$NON-NLS-1$
			d.open ();
			data.fileName = d.getFilterPath() + "\\" + d.getFileName(); //$NON-NLS-1$
			
		}
	
		Printer printer = new Printer(data);
		GC gc = new GC(printer);

		PBox.setParameters(gc, printer, printer.getDPI(), (int)(document.getScale()*100));
		document.layout();

		if (printer.startJob(document.getTitle())) 
		{
			if (data.scope == PrinterData.ALL_PAGES)
			{
				data.startPage = 1;
				data.endPage = document.getNumOfPages();
			}
			else if (data.scope == PrinterData.SELECTION)
			{
				data.startPage = page;
				data.endPage = page;
			}
			else if (data.scope == PrinterData.PAGE_RANGE)
			{
				if (data.startPage > document.getNumOfPages()) 
					data.startPage = document.getNumOfPages();
				if (data.endPage > document.getNumOfPages()) 
					data.endPage = document.getNumOfPages();
			}

			for (int page = data.startPage; page <= data.endPage; page++)
			{
				printer.startPage();
				document.draw(page);
				printer.endPage();
			}
			printer.endJob();
		}
		gc.dispose();
		printer.dispose();
		layoutNeccessary = true;
		
	}


	
	
	

}
