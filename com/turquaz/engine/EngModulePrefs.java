package com.turquaz.engine;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.xml.sax.InputSource;

import com.turquaz.engine.bl.EngBLLogger;

public class EngModulePrefs
{
    public Document tableDoc;
    static EngModulePrefs _instance;

    
    public EngModulePrefs() throws Exception
    {
        
        File prop_dir = new File(System.getProperty("user.home")+"/.turquaz");
        if(!prop_dir.exists())
        {
            prop_dir.mkdir();
        }
        
        
        File file = new File(System.getProperty("user.home")+"/.turquaz/module_props.xml");
        if (!file.exists())
        {
            XMLOutputter outputter = new XMLOutputter();
            OutputStream output = null;
            output = new FileOutputStream(System.getProperty("user.home")+"/.turquaz/module_props.xml"); //$NON-NLS-1$
            Element root = new Element("props");
            outputter.output(root, output);
            output.close();
        }
        SAXBuilder myBuilder = new SAXBuilder();
        InputSource input = new InputSource(System.getProperty("user.home")+"/.turquaz/module_props.xml");
        tableDoc = myBuilder.build(input);
        if (!tableDoc.hasRootElement())
        {
            Element root = new Element("props");
            tableDoc.setRootElement(root);
        }
    }
    
    public static void setProperty(String moduleName, String attribute,String value)
    {
        try{
            if (_instance == null)
            {
                _instance = new EngModulePrefs();
            }
            Element root = _instance.tableDoc.getRootElement();
            Element module = root.getChild(moduleName);
            if (module == null)
            {
                module = new Element(moduleName);
                root.addContent(module);
            }
           
            Attribute attr = module.getAttribute(attribute);
            if(attr !=null)
            {
                attr.setValue(value);
            }
            else
            {
               attr = new Attribute(attribute,value);
               module.setAttribute(attr);
            }
            
            
        }
        catch(Exception ex)
        {
            EngBLLogger.log(EngModulePrefs.class,ex);
        }
    }
    public static String getProperty(String moduleName, String attribute)
    {
        try{
        if (_instance == null)
        {
            _instance = new EngModulePrefs();
        }
        Element root = _instance.tableDoc.getRootElement();
        Element module = root.getChild(moduleName);
        
        if(module == null)
        {
            return null;
        }
        
        Attribute attr = module.getAttribute(attribute);
        if(attr == null)
        {
            return null;
        }
        else
        {
            return attr.getValue();
        }
        
        }
        catch(Exception ex)
        {
            EngBLLogger.log(EngModulePrefs.class,ex);
            return null;
        }
        
    }
    
    public static void saveToFile()
    {
        try
        {
            if (_instance == null)
            {
                _instance = new EngModulePrefs();
            }
            Format format = Format.getPrettyFormat();
            XMLOutputter outputter = new XMLOutputter(format);
            OutputStream output = null;
            output = new FileOutputStream(System.getProperty("user.home")+"/.turquaz/module_props.xml"); //$NON-NLS-1$
            outputter.output(_instance.tableDoc, output);
            output.close();
        }
        catch (Exception ex)
        {
            EngBLLogger.log(EngModulePrefs.class,ex);
        }
    }
}
