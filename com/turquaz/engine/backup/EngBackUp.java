/*
 * Created on Apr 13, 2005
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.backup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import com.turquaz.engine.EngConfiguration;

/**
 * @author onsel
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EngBackUp
{
	public static void backUp(String directory)
	{
		if(EngConfiguration.getString("dbType").startsWith("Turquaz"))
		{
			backUpHSQLDB(directory);
		}
	}
	private static void backUpHSQLDB(String directoryName)
	{			
		
		try{
			
	
		 byte b[] = new byte[512];
		 
		Calendar cal = Calendar.getInstance();
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		String date = formatter.format(cal.getTime());
		
		
		String backUpDir = "database/backup/"+directoryName+"/"+date+"/";
		String scriptZip = backUpDir+"turquaz.zip";
		String scriptFile = "database/turquaz.script";
		String logFile = "database/turquaz.log";
	
		
		
		backUpDir.replace(File.separatorChar,'/');
		 File backupDirFile = new File(backUpDir);
		 
		 
		 if(!backupDirFile.exists())
		 {
		 	backupDirFile.mkdirs();
		 }
		 
		 
		 FileOutputStream fos_script = new FileOutputStream(scriptZip);
		 
		 ZipOutputStream zoutScript = new ZipOutputStream(fos_script);
			 
		
		 InputStream in = new FileInputStream(scriptFile);
		 
	      ZipEntry e = new ZipEntry(scriptFile.replace(File.separatorChar,'/'));
	      zoutScript.putNextEntry(e);
	      int len=0;
	      while((len=in.read(b)) != -1) {
	        zoutScript.write(b,0,len);
	        }
	      zoutScript.closeEntry();
	      
	      InputStream in_log = new FileInputStream(logFile);
			 
		      ZipEntry e_log = new ZipEntry(logFile.replace(File.separatorChar,'/'));
		      zoutScript.putNextEntry(e_log);
		      len=0;
		      while((len=in_log.read(b)) != -1) {
		        zoutScript.write(b,0,len);
		       }
		      zoutScript.closeEntry();
		 
		      zoutScript.close();
		 
		 
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	
	
}
