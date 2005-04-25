/*
 * Created on Apr 18, 2005
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.bl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.xml.sax.InputSource;
import com.turquaz.engine.Messages;
import com.turquaz.engine.ui.component.TurqKeyEvent;

/**
 * @author Cem
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EngBLKeyEvents
{
	public static Map turqKeyEvents=null;
	
	public static String CONTENT_ASISTANT="ContentAssistant"; //$NON-NLS-1$
	public static String NEXT_TAB="NextTab"; //$NON-NLS-1$
	public static String PREVIOUS_TAB="PreviousTab"; //$NON-NLS-1$
	public static String DELETE="Delete"; //$NON-NLS-1$
	public static String SEARCH="Search"; //$NON-NLS-1$
	public static String SAVE="Save"; //$NON-NLS-1$
	public static String NEW="New"; //$NON-NLS-1$
	public static String EXCEL="Excel"; //$NON-NLS-1$
	public static String PRINT="Print";	 //$NON-NLS-1$
	
	
	//Some special keys
	public static String RIGHT_ARROW_STRING=Messages.getString("EngBLKeyEvents.0"); //$NON-NLS-1$
	public static String LEFT_ARROW_STRING=Messages.getString("EngBLKeyEvents.1"); //$NON-NLS-1$
	public static String UP_ARROW_STRING=Messages.getString("EngBLKeyEvents.2"); //$NON-NLS-1$
	public static String DOWN_ARROW_STRING=Messages.getString("EngBLKeyEvents.3"); //$NON-NLS-1$
	
	
	public static String[] KEY_CONTROLS=new String[]{
			CONTENT_ASISTANT,
			NEXT_TAB,
			PREVIOUS_TAB,
			DELETE,
			SEARCH,
			SAVE,
			NEW,
			EXCEL,
			PRINT
	};
		
	public static Map DeserializeKeys()
	{
		try
		{
			File prop_dir = new File(System.getProperty("user.home") + "/.turquaz"); //$NON-NLS-1$ //$NON-NLS-2$
			if (!prop_dir.exists())
			{
				return null;
			}
			File file = new File(System.getProperty("user.home") + "/.turquaz/keycontrols.xml"); //$NON-NLS-1$ //$NON-NLS-2$
			if (!file.exists())
			{
				return null;
			}
			SAXBuilder myBuilder = new SAXBuilder();
			InputSource input = new InputSource(System.getProperty("user.home") + "/.turquaz/keycontrols.xml"); //$NON-NLS-1$ //$NON-NLS-2$
			Document keyDocument = myBuilder.build(input);
			if (!keyDocument.hasRootElement())
			{
				System.err.println("keycontrols.xml is in unsupported format!"); //$NON-NLS-1$
				return null;
			}
			else
			{
				Element root = keyDocument.getRootElement();
				List children = root.getChildren();
				for (int k = 0; k < children.size(); k++)
				{
					Element child = (Element) children.get(k);
					String keyEventName = child.getName();
					int stateMask = Integer.parseInt(child.getAttributeValue("stateMask")); //$NON-NLS-1$
					int keyCode = Integer.parseInt(child.getAttributeValue("keyCode")); //$NON-NLS-1$
					boolean isActive=Boolean.valueOf(child.getAttributeValue("isActive")).booleanValue(); //$NON-NLS-1$
					TurqKeyEvent event = new TurqKeyEvent(stateMask, keyCode, isActive);
					if (isActive)
					{
						Iterator it=turqKeyEvents.keySet().iterator();
						while (it.hasNext())
						{
							String evtName=(String)it.next();
							TurqKeyEvent evt=(TurqKeyEvent)turqKeyEvents.get(evtName);
							if (evt.equals(event))
							{
								evt.isActive=false;
								turqKeyEvents.put(evtName,evt);
							}
						}	
					}
					turqKeyEvents.put(keyEventName, event);					
				}
				return turqKeyEvents;
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
	
	public static void SerializeKeys() throws Exception
	{
		if (turqKeyEvents == null)
			return;
		
		File prop_dir = new File(System.getProperty("user.home")+"/.turquaz"); //$NON-NLS-1$ //$NON-NLS-2$
		if(!prop_dir.exists())
		{
			prop_dir.mkdir();
		}
		OutputStream output =new FileOutputStream(System.getProperty("user.home")+"/.turquaz/keycontrols.xml"); //$NON-NLS-1$ //$NON-NLS-2$
		Element root = new Element("KeyValues"); //$NON-NLS-1$
		Iterator it=turqKeyEvents.keySet().iterator();
		while (it.hasNext())
		{
			String eventName=(String)it.next();
			Element child=new Element(eventName);
			TurqKeyEvent event=(TurqKeyEvent)turqKeyEvents.get(eventName);
			child.setAttribute("stateMask",String.valueOf(event.stateMask)); //$NON-NLS-1$
			child.setAttribute("keyCode",String.valueOf(event.keyCode)); //$NON-NLS-1$
			child.setAttribute("isActive",String.valueOf(event.isActive)); //$NON-NLS-1$
			root.addContent(child);
		}		
		Format format = Format.getPrettyFormat();
		XMLOutputter outputter = new XMLOutputter(format);
		outputter.output(root, output);
		output.flush();
		output.close();
	}	
	
	public static void setDefault()
	{
		turqKeyEvents=new HashMap();
		turqKeyEvents.put(CONTENT_ASISTANT,new TurqKeyEvent(SWT.CTRL,(int)' ',true));
		turqKeyEvents.put(NEXT_TAB,new TurqKeyEvent(SWT.CTRL,SWT.ARROW_RIGHT,true));
		turqKeyEvents.put(PREVIOUS_TAB,new TurqKeyEvent(SWT.CTRL,SWT.ARROW_LEFT,true));
		turqKeyEvents.put(DELETE,new TurqKeyEvent(SWT.ALT,(int)'s',true));
		turqKeyEvents.put(SEARCH,new TurqKeyEvent(SWT.ALT,(int)'a',true));
		turqKeyEvents.put(NEW,new TurqKeyEvent(SWT.ALT,(int)'y',true));
		turqKeyEvents.put(SAVE,new TurqKeyEvent(SWT.ALT,(int)'k',true));
		turqKeyEvents.put(EXCEL,new TurqKeyEvent(SWT.ALT,(int)'e',true));
		turqKeyEvents.put(PRINT,new TurqKeyEvent(SWT.ALT,(int)'z',true));
	}

	public static String keyCode (int keyCode) {
		switch (keyCode) {
			
			/* Keyboard and Mouse Masks */
			case SWT.ALT: 		return "ALT"; //$NON-NLS-1$
			case SWT.SHIFT: 	return "SHIFT"; //$NON-NLS-1$
			case SWT.CONTROL:	return "CONTROL"; //$NON-NLS-1$
			case SWT.COMMAND:	return "COMMAND"; //$NON-NLS-1$
				
			/* Non-Numeric Keypad Keys */
			/*case SWT.ARROW_UP:		return "ARROW_UP"; //$NON-NLS-1$
			case SWT.ARROW_DOWN:	return "ARROW_DOWN"; //$NON-NLS-1$
			case SWT.ARROW_LEFT:	return "ARROW_LEFT"; //$NON-NLS-1$
			case SWT.ARROW_RIGHT:	return "ARROW_RIGHT"; //$NON-NLS-1$*/
			case SWT.ARROW_UP:		return UP_ARROW_STRING;
			case SWT.ARROW_DOWN:	return DOWN_ARROW_STRING;
			case SWT.ARROW_LEFT:	return LEFT_ARROW_STRING;
			case SWT.ARROW_RIGHT:	return RIGHT_ARROW_STRING;
			
			case SWT.PAGE_UP:		return "PAGE_UP"; //$NON-NLS-1$
			case SWT.PAGE_DOWN:		return "PAGE_DOWN"; //$NON-NLS-1$
			case SWT.HOME:			return "HOME"; //$NON-NLS-1$
			case SWT.END:			return "END"; //$NON-NLS-1$
			case SWT.INSERT:		return "INSERT"; //$NON-NLS-1$
	
			/* Virtual and Ascii Keys */
			case SWT.BS:	return "BS"; //$NON-NLS-1$
			case SWT.CR:	return "CR";		 //$NON-NLS-1$
			case SWT.DEL:	return "DEL"; //$NON-NLS-1$
			case SWT.ESC:	return "ESC"; //$NON-NLS-1$
			case SWT.LF:	return "LF"; //$NON-NLS-1$
			case SWT.TAB:	return "TAB"; //$NON-NLS-1$
		
			/* Functions Keys */
			case SWT.F1:	return "F1"; //$NON-NLS-1$
			case SWT.F2:	return "F2"; //$NON-NLS-1$
			case SWT.F3:	return "F3"; //$NON-NLS-1$
			case SWT.F4:	return "F4"; //$NON-NLS-1$
			case SWT.F5:	return "F5"; //$NON-NLS-1$
			case SWT.F6:	return "F6"; //$NON-NLS-1$
			case SWT.F7:	return "F7"; //$NON-NLS-1$
			case SWT.F8:	return "F8"; //$NON-NLS-1$
			case SWT.F9:	return "F9"; //$NON-NLS-1$
			case SWT.F10:	return "F10"; //$NON-NLS-1$
			case SWT.F11:	return "F11"; //$NON-NLS-1$
			case SWT.F12:	return "F12"; //$NON-NLS-1$
			case SWT.F13:	return "F13"; //$NON-NLS-1$
			case SWT.F14:	return "F14"; //$NON-NLS-1$
			case SWT.F15:	return "F15"; //$NON-NLS-1$
			
			/* Numeric Keypad Keys */
			case SWT.KEYPAD_ADD:		return "KEYPAD_ADD"; //$NON-NLS-1$
			case SWT.KEYPAD_SUBTRACT:	return "KEYPAD_SUBTRACT"; //$NON-NLS-1$
			case SWT.KEYPAD_MULTIPLY:	return "KEYPAD_MULTIPLY"; //$NON-NLS-1$
			case SWT.KEYPAD_DIVIDE:		return "KEYPAD_DIVIDE"; //$NON-NLS-1$
			case SWT.KEYPAD_DECIMAL:	return "KEYPAD_DECIMAL"; //$NON-NLS-1$
			case SWT.KEYPAD_CR:			return "KEYPAD_CR"; //$NON-NLS-1$
			case SWT.KEYPAD_0:			return "KEYPAD_0"; //$NON-NLS-1$
			case SWT.KEYPAD_1:			return "KEYPAD_1"; //$NON-NLS-1$
			case SWT.KEYPAD_2:			return "KEYPAD_2"; //$NON-NLS-1$
			case SWT.KEYPAD_3:			return "KEYPAD_3"; //$NON-NLS-1$
			case SWT.KEYPAD_4:			return "KEYPAD_4"; //$NON-NLS-1$
			case SWT.KEYPAD_5:			return "KEYPAD_5"; //$NON-NLS-1$
			case SWT.KEYPAD_6:			return "KEYPAD_6"; //$NON-NLS-1$
			case SWT.KEYPAD_7:			return "KEYPAD_7"; //$NON-NLS-1$
			case SWT.KEYPAD_8:			return "KEYPAD_8"; //$NON-NLS-1$
			case SWT.KEYPAD_9:			return "KEYPAD_9"; //$NON-NLS-1$
			case SWT.KEYPAD_EQUAL:		return "KEYPAD_EQUAL"; //$NON-NLS-1$
	
			/* Other keys */
			case SWT.CAPS_LOCK:		return "CAPS_LOCK"; //$NON-NLS-1$
			case SWT.NUM_LOCK:		return "NUM_LOCK"; //$NON-NLS-1$
			case SWT.SCROLL_LOCK:	return "SCROLL_LOCK"; //$NON-NLS-1$
			case SWT.PAUSE:			return "PAUSE"; //$NON-NLS-1$
			case SWT.BREAK:			return "BREAK"; //$NON-NLS-1$
			case SWT.PRINT_SCREEN:	return "PRINT_SCREEN"; //$NON-NLS-1$
			case SWT.HELP:			return "HELP"; //$NON-NLS-1$
		}
		if ((char)keyCode==' ')
			return "SPACEBAR"; //$NON-NLS-1$
		return String.valueOf(((char) keyCode)).toUpperCase(Locale.getDefault());
	}

	public static String character (char character) {
		switch (character) {
			case 0: 		return "'\\0'"; //$NON-NLS-1$
			case SWT.BS:	return "'\\b'"; //$NON-NLS-1$
			case SWT.CR:	return "'\\r'"; //$NON-NLS-1$
			case SWT.DEL:	return "DEL"; //$NON-NLS-1$
			case SWT.ESC:	return "ESC"; //$NON-NLS-1$
			case SWT.LF:	return "'\\n'"; //$NON-NLS-1$
			case SWT.TAB:	return "'\\t'"; //$NON-NLS-1$
		}
		return "'" + character +"'"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	public static String stateMask(int stateMask)
	{
		String string = ""; //$NON-NLS-1$
		boolean addPlus = false;
		if ((stateMask & SWT.CTRL) != 0)
		{
			string += "CTRL"; //$NON-NLS-1$
			addPlus = true;
		}
		if ((stateMask & SWT.ALT) != 0)
		{
			if (addPlus)
				string += "+"; //$NON-NLS-1$
			string += "ALT"; //$NON-NLS-1$
			addPlus = true;
		}
		if ((stateMask & SWT.SHIFT) != 0)
		{
			if (addPlus)
				string += "+"; //$NON-NLS-1$
			string += "SHIFT"; //$NON-NLS-1$
			addPlus = true;
		}
		if ((stateMask & SWT.COMMAND) != 0)
		{
			if (addPlus)
				string += "+"; //$NON-NLS-1$
			string += "COMMAND"; //$NON-NLS-1$
			addPlus = true;
		}
		return string;
	}
	
	public static TurqKeyEvent getKeyEvent(String string)
	{
		String[] values=string.split(Messages.getString("EngBLKeyEvents.4")); //$NON-NLS-1$
		if (values.length == 1)
		{
			
		}
			
		return null;
	}
	
	public static String getStringValue(TurqKeyEvent event)
	{
		String string =stateMask (event.stateMask);
		if (string.equals("")) //$NON-NLS-1$
		{
			string +=EngBLKeyEvents.keyCode (event.keyCode);
		}
		else
		{
			string +="+"+EngBLKeyEvents.keyCode(event.keyCode); //$NON-NLS-1$
		}
		return string;		
	}
	
	public static String getStringValue(KeyEvent event)
	{
		String string =stateMask (event.stateMask);
		if (string.equals("")) //$NON-NLS-1$
		{
			string +=EngBLKeyEvents.keyCode (event.keyCode);
		}
		else
		{
			string +="+"+EngBLKeyEvents.keyCode(event.keyCode); //$NON-NLS-1$
		}
		return string;		
	}
	
	public static String getStringValue(VerifyEvent event)
	{
		String string =stateMask (event.stateMask);
		if (string.equals("")) //$NON-NLS-1$
		{
			string +=EngBLKeyEvents.keyCode (event.keyCode);
		}
		else
		{
			string +="+"+EngBLKeyEvents.keyCode(event.keyCode); //$NON-NLS-1$
		}
		return string;		
	}
	
}
