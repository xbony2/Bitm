package sheenrox82.RioV.src.handler;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import net.minecraft.client.gui.GuiMainMenu;

public class WavHandler
{
	public static URL soundURL;
	public static AudioInputStream audioIn;
	public static Clip clip;

	public static void setUpSound(String var0)
	{
		if ((clip != null) && (clip.isActive()))
	    {
	      clip.stop();
	    }
		
		try
		{
			URL var1 = GuiMainMenu.class.getClassLoader().getResource("assets/riov/" + var0);
			audioIn = AudioSystem.getAudioInputStream(var1);
			clip = AudioSystem.getClip();
		}
		catch (Exception var2)
		{
			var2.printStackTrace();
		}
	}

	public static void playSound(int var0)
	{
		try
		{
			clip.open(audioIn);
			clip.loop(var0);
		}
		catch (Exception var2)
		{
			var2.printStackTrace();
		}
	}

	public static void stopSound()
	{
		try
		{
			clip.stop();
		}
		catch (Exception var1)
		{
			var1.printStackTrace();
		}
	}

	public static Clip getSound()
	{
		return clip;
	}
}