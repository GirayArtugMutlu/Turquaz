/*
 * Created on 02.03.2004
 *
 * (c) 2004 by Friederich Kupzog Elektronik & Software
 * 
 * This program is free software; you can redistribute it and/or modify it under 
 * the terms of the GNU General Public License as published by the Free Software 
 * Foundation; either version 2 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for 
 * more details. 
 * You should have received a copy of the GNU General Public License along 
 * with this program; if not, write to the fkmk@kupzog.de
 * www.kupzog.de/fkmk
 * 
 */
package de.kupzog.ktable;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;
import java.io.*;

/**
 * Wrapper for Image with text.
 * @author Friederich Kupzog
 */
public class TownExampleContent {
	public String name;
	public Image image;
	public String country;
	public String notes;
	
	public TownExampleContent(String name, String country)
	{
		this.name = name;
		this.country = country;
		image = loadImageResource(Display.getCurrent(), 
			"/gfx/"+name+".gif");
		System.out.println(image);
		notes = "Double click to edit and use \n" +			"Shift+Enter to start a new line...";
	}
	
	public Image loadImageResource(Display d, String name)
	{
		try {
			
			Image ret = null;
			Class clazz = this.getClass();
			InputStream is = clazz.getResourceAsStream(name);
			if (is != null) {
				ret = new Image(d,is);
				is.close();
			}
			return ret;
		} catch (Exception e1) {
			return null;
		}
	}
	
	/* 
	 * overridden from superclass
	 */
	public String toString() {
		return notes;
	}

}
