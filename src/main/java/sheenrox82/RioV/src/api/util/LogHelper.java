package sheenrox82.RioV.src.api.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.Level;

import sheenrox82.RioV.src.api.base.RioVAPI;
import cpw.mods.fml.common.FMLLog;

public class LogHelper {

	private static BufferedWriter writer;

	static
	{
		File dir = new File("./TheMistsOfRioV");
		dir.mkdir();
		dir = new File("./TheMistsOfRioV/debug.log");

		try 
		{
			writer = new BufferedWriter(new FileWriter(dir));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	private void log(Level level, String msg) 
	{
		FMLLog.log(RioVAPI.mod_name, level, msg);
		System.err.println(msg);
		
		if(RioVAPI.getInstance().modLoaded == false)
		{
			writeFile(msg);
			flush();
		}
		
		if(RioVAPI.getInstance().modLoaded == true)
		{
			closeFile();
		}
	}

	public void debug(String msg) 
	{
		log(Level.DEBUG, "[DEBUG] " + msg);
	}

	public void error(String msg) 
	{
		log(Level.ERROR, msg);
	}

	public void info(String msg)
	{
		log(Level.INFO, msg);
	}

	public void warn(String msg) 
	{
		log(Level.WARN, msg);
	}

	public void dev(String msg) 
	{
		log(Level.INFO, "[DEVELOPMENT] " + msg);
	}

	public void writeFile(String msg)
	{
		try 
		{
			writer.write(msg);
			writer.newLine();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public void flush() 
	{
		try
		{
			writer.flush();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public void closeFile() 
	{
		try
		{
			writer.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public void write(String msg)
	{
		System.err.println(msg);
		writeFile(msg);
		flush();
	}
}