package com.turquaz.engine.ui.component;

/************************************************************************/
/* TURQUAZ: Higly Modular Accounting/ERP Program                        */
/* ============================================                         */
/* Copyright (c) 2004 by Turquaz Software Development Group			    */
/*																		*/
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or    */
/* (at your option) any later version.       							*/
/* 																		*/
/* This program is distributed in the hope that it will be useful,		*/
/* but WITHOUT ANY WARRANTY; without even the implied warranty of		*/
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the		*/
/* GNU General Public License for more details.         				*/
/************************************************************************/
/**
 * @author Onsel
 * @version $Id$
 */
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Text;

public class DateMask
{
	String mask = "";
	public String text = "";
	int maskPos = 0;
	static char spaceChar = '_';

	public DateMask()
	{
	}

	public DateMask(String mask)
	{
		setMask(mask);
	}

	public void setMask(String mask)
	{
		this.mask = mask;
	}

	public void setMaskPos(int pos)
	{
		if (pos < mask.length())
			maskPos = pos;
	}

	public int textToMaskPos(int textPos)
	{
		byte[] m = mask.getBytes();
		for (int i = 0, k = 0; i < textPos && i < m.length; i++)
		{
			while (m[k] != '#' && k < m.length)
				k++;
			if (k < m.length)
				k++;
		}
		return 0;
	}

	public int getTextPos()
	{
		int textPos = 0;
		byte[] m = mask.getBytes();
		for (int i = 0, k = 0; i < maskPos && i < m.length; i++)
		{
			if (m[i] == '#')
				textPos++;
		}
		return textPos;
	}

	public int getMaskPos()
	{
		return maskPos;
	}

	public String clear(int pos, int len)
	{
		byte[] m = mask.getBytes();
		byte[] t = text.getBytes();
		for (int i = 0, k = 0; i < m.length; i++)
		{
			if (m[i] == '#' && i >= pos && i < (pos + len))
				t[i] = (byte) (' ');
		}
		text = new String(t);
		return text;
	}

	public boolean isMaskApplied()
	{
		byte[] m = mask.getBytes();
		String localText = text + "             ";
		for (int i = 0; i < m.length; i++)
		{
			if (m[i] != '#')
			{
				if (localText.charAt(i) != (char) m[i])
					return false;
			}
			else
			{
				if (localText.charAt(i) != ' ')
					if (!Character.isDigit(localText.charAt(i)))
						return false;
			}
		}
		return true;
	}

	public String applyMask()
	{
		byte[] m = mask.getBytes();
		for (int i = 0, k = 0; i < m.length && k < text.length(); i++)
		{
			System.err.println(" m[" + i + "] = " + m[i]);
			System.err.println("text charAt(" + k + ") = " + text.charAt(k));
			if (m[i] == '#')
			{
				if (Character.isDigit(text.charAt(k)))
					m[i] = (byte) ((k < text.length()) ? text.charAt(k++) : ' ');
				else
					return mask.replaceAll("#", " ");
			}
			else if (m[i] == text.charAt(k))
				k++;
		}
		return new String(m).replaceAll("#", " ");
	}

	public String deapplyMask()
	{
		StringBuffer s1 = new StringBuffer("");
		byte[] m = mask.getBytes();
		for (int i = 0; i < m.length && i < text.length(); i++)
		{
			if (m[i] == '#')
			{
				s1.append(text.charAt(i));
			}
		}
		return s1.toString();
	}

	public void textMaskGeneric(KeyEvent e)
	{
		Text t = (Text) e.widget;
		t.setEditable(false);
		DateMask m = this;
		String mask = m.mask;
		String s = t.getText();
		m.text = s;
		int pos = t.getCaretPosition();
		int range = t.getSelectionCount();
		m.setMaskPos(pos);
		if (e.character != SWT.BS && ((Character.getNumericValue(e.character) == -1) || (e.keyCode == 0)))
		{
			return;
		}
		boolean moveBack = (e.character == SWT.BS || e.keyCode == SWT.ARROW_LEFT);
		if (range != 0)
			s = m.clear(pos, range);
		range = 0;
		if ((mask.length() <= pos && !moveBack) || range != 0)
		{
			t.setText(s);
			t.setSelection(pos);
			return;
		}
		if (!m.isMaskApplied())
		{
			System.err.println("Mask NOT APPLIED");
			m.text = s;
			s = m.applyMask();
		}
		byte[] b = s.getBytes();
		char replace = e.character;
		if (Character.isDigit(e.character))
		{
			pos++;
			/* not over read-only character */
			if (mask.charAt(pos - 1) != '#')
				pos = mask.indexOf('#', pos) + 1;
			if (pos - 1 <= mask.length())
			{
				b[pos - 1] = (byte) replace;
				/* advance past read-only characters */
				if (pos < mask.length() && mask.charAt(pos) != '#')
					pos = mask.indexOf('#', pos);
			}
		}
		else
		{
			if (moveBack)
			{
				pos--;
				if (pos < 0)
					pos = 0;
				if (mask.charAt(pos) != '#')
				{
					pos = mask.lastIndexOf('#', pos);
					if (pos < 0)
						pos = mask.indexOf('#');
				}
				if (e.character == SWT.BS)
				{
					b[pos] = (byte) '0';
				}
			}
			else if (pos < 0)
			{
				pos = 0;
			}
			else
			{
				if (pos < mask.length() && mask.charAt(pos) != '#')
					pos = mask.indexOf('#', pos);
			}
		}
		String out = new String(b);
		t.setText(out);
		t.setSelection(pos);
	}
}