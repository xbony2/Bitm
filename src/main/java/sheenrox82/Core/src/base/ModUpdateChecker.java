package sheenrox82.Core.src.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import net.minecraft.util.EnumChatFormatting;
import sheenrox82.RioV.src.api.util.RioVAPIUtil;
import sheenrox82.RioV.src.util.Util;

public class ModUpdateChecker 
{
	public static String urlString;
	public static String versionString;
	public static String newVersionStr;

	public static void init(String url, String version)
	{
		urlString = url;
		versionString = version;
	}

	public static boolean isUpdateAvailable()
	{
		try
		{
			BufferedReader versionFile = new BufferedReader(new InputStreamReader(new URL(urlString).openStream()));
			String curVersion = versionFile.readLine();
			newVersionStr = curVersion;
			versionFile.close();

			if (!curVersion.equals(versionString))
			{
				return true;
			}

		}
		catch(Exception e)
		{
			return false;
		}

		return false;
	}

	public static void printChangelog(String url)
	{
		try
		{
			BufferedReader changelogFile = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
			String changelog;
			
			while ((changelog = changelogFile.readLine()) != null)
			{
				RioVAPIUtil.sendMessageToAll(EnumChatFormatting.WHITE + changelog);
			}
			
			changelogFile.close();
		}
		catch(Exception e)
		{
			
		}
	}
}