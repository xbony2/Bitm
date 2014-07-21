package sheenrox82.RioV.src.content;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import sheenrox82.RioV.src.api.util.Sound;
import sheenrox82.RioV.src.util.Util;

public class Sounds 
{
	public static final String SOUND_PREFIX = Util.MOD_ID + ":";

	public static Sound portal = new Sound("portal");
	public static Sound bow = new Sound("bow");
	public static Sound demon = new Sound("demon");
	public static Sound hellhound = new Sound("hellhound");
	public static Sound auntun = new Sound("auntun");
	public static Sound growl = new Sound("growl");
	public static Sound darkness = new Sound("darkness");
	public static Sound exhale = new Sound("exhale");
	public static Sound hello = new Sound("hello");
	public static Sound pain = new Sound("pain");

	public static void playSound(Sound sound, World world, Entity entity, float volume, float pitch) {
		world.playSoundAtEntity(entity, sound.getPrefixedName(), volume, pitch);
	}

	public static void playSound(Entity entity, World world, Sound sound) {
		world.playSoundAtEntity(entity, sound.getPrefixedName(), 1, 1);
	}

	public static String getSoundName(Sound sound){
		return sound.getPrefixedName();
	}
}
