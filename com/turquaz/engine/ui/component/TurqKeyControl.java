package com.turquaz.engine.ui.component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.engine.bl.EngBLKeyEvents;
import com.turquaz.engine.ui.EngUIKeyControls;


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
public class TurqKeyControl extends org.eclipse.swt.widgets.Composite {
	private Text txtEventKey;
	private TurqKeyEvent keyEvent;
	private String eventName;

	public String getEventName()
	{
		return eventName;
	}
	public void setEventName(String eventName)
	{
		this.eventName = eventName;
	}
	public TurqKeyEvent getKeyEvent()
	{
		return keyEvent;
	}
	public void setKeyEvent(TurqKeyEvent keyEvent)
	{
		this.keyEvent = keyEvent;
	}
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
		TurqKeyControl inst = new TurqKeyControl(shell, SWT.NULL);
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

	public TurqKeyControl(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		keyEvent=null;
		eventName="";		
		initGUI();
		setBackGroundPassive();
	}

	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.marginHeight = 0;
			thisLayout.marginWidth = 0;
			this.setSize(200, 17);
			//START >>  txtEventKey
			txtEventKey = new Text(this, SWT.NONE);
			GridData txtEventKeyLData = new GridData();
			txtEventKey.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent evt) {
					TurqKeyEvent event=new TurqKeyEvent(evt.stateMask,evt.keyCode,true,keyEvent.isAvailable);
					validateOthers(event,eventName);
					setData(event);							
				}
			});
			txtEventKeyLData.grabExcessVerticalSpace = true;
			txtEventKeyLData.grabExcessHorizontalSpace = true;
			txtEventKeyLData.horizontalAlignment = GridData.FILL;
			txtEventKeyLData.verticalAlignment = GridData.FILL;
			txtEventKey.setLayoutData(txtEventKeyLData);
			//END <<  txtEventKey
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void validateOthers(TurqKeyEvent evt, String eventName)
	{
		try
		{
			List toActive=new ArrayList();
			Map keyMap = EngUIKeyControls.tempKeyValues;
			Iterator it = keyMap.keySet().iterator();
			while (it.hasNext())
			{
				String name = (String) it.next();
				if (!name.equals(eventName))
				{
					TurqKeyEvent event = (TurqKeyEvent) keyMap.get(name);
			
					if (event.equals(evt))
					{
						event.isActive=false;
						event.getController().setData(event);
					}		
					if (event.equals(getKeyEvent()))
					{
						toActive.add(event);
					}
				}
			}
			if (toActive.size()== 1)
			{
				TurqKeyEvent tevent=(TurqKeyEvent)toActive.get(0);
				tevent.isActive=true;
				tevent.getController().setData(tevent);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void setData(TurqKeyEvent event)
	{
		keyEvent=event;
		keyEvent.setController(this);
		EngUIKeyControls.tempKeyValues.put(eventName,keyEvent);
		String string=EngBLKeyEvents.getStringValue(event);
		txtEventKey.setText(string);
		if (!keyEvent.isActive)
		{
			setBackGroundPassive();
		}
		else
		{
			setBackGroundActive();
		}
	}
	
	public void setBackGroundActive()
	{
		txtEventKey.setBackground(SWTResourceManager.getColor(255,255,255));
	}
	
	public void setBackGroundPassive()
	{
		txtEventKey.setBackground(SWTResourceManager.getColor(255,198,198));
	}

}
