/*  Copyright (C) 2004 by Friederich Kupzog Elektronik & Software 	This library is free software; you can redistribute it and/or	modify it under the terms of the GNU Lesser General Public	License as published by the Free Software Foundation; either	version 2.1 of the License, or (at your option) any later version.	This library is distributed in the hope that it will be useful,	but WITHOUT ANY WARRANTY; without even the implied warranty of	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU	Lesser General Public License for more details.	You should have received a copy of the GNU Lesser General Public	License along with this library; if not, write to the Free Software	Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA    	Author: Friederich Kupzog  	fkmk@kupzog.de	www.kupzog.de/fkmk*/   package de.kupzog.ktools.kprint.gui;import org.eclipse.swt.graphics.*;import org.eclipse.swt.widgets.*;import java.io.*;/** * This Class is intended for a cebtral access to all icons  * used throughout the package.  *  * Alter the getImage() function, if you use other techniques of image access. * */public class IconSource {    /** Returns the requested Image */    public static Image getImage(String name)    {        return loadImageResource(Display.getCurrent(), "/gfx/"+name+".gif");    }	/**	 *  reads an Image as ressource (either from file system or from a jar) 	 */	public static Image loadImageResource(Display d, String name)	{		try {						Image ret = null;			Class clazz = new Object().getClass();			InputStream is = clazz.getResourceAsStream(name);			if (is != null) {				ret = new Image(d,is);				is.close();			}			if (ret == null) System.out.println("Error loading bitmap:\n"+name);			return ret;		} catch (Exception e1) {			System.out.println("Error loading bitmap:\n"+name);			return null;		}	}}