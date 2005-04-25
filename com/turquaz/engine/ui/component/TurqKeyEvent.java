/*
 * Created on Apr 18, 2005
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.ui.component;

import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.VerifyEvent;

/**
 * @author Cem
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TurqKeyEvent
{
	public int stateMask;
	public int keyCode;
	public boolean isActive;
	public boolean isAvailable;
	private TurqKeyControl controller=null;
	
	public void setAvailable(boolean isAvailable)
	{
		this.isAvailable = isAvailable;
	}
	public TurqKeyControl getController()
	{
		return controller;
	}
	public void setController(TurqKeyControl controller)
	{
		this.controller = controller;
	}
	public TurqKeyEvent()
	{
		this.stateMask=0;
		this.keyCode=0;
		this.isActive=false;
		this.isAvailable=false;
	}
		
	public TurqKeyEvent(int stateMask, int keyCode, boolean isActive, boolean isAvailable)
	{
		this.stateMask=stateMask;
		this.keyCode=keyCode;
		this.isActive=isActive;
		this.isAvailable=isAvailable;
	}
	
	public TurqKeyEvent(int stateMask, int keyCode, boolean isActive)
	{
		this.stateMask=stateMask;
		this.keyCode=keyCode;
		this.isActive=isActive;
		this.isAvailable=false;
	}
	
	public boolean equals(KeyEvent event)
	{
		if (isActive && event.stateMask==stateMask && event.keyCode==keyCode)
			return true;
		return false;
	}
	
	public boolean equals(VerifyEvent event)
	{
		if (isActive && event.stateMask==stateMask && event.keyCode==keyCode)
			return true;
		return false;
	}
	
	public boolean equals(TurqKeyEvent event)
	{
		if (event.stateMask==this.stateMask && event.keyCode==this.keyCode)
		{
			return true;
		}
		return false;
		
	}
}
