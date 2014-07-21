package sheenrox82.RioV.src.api.util;

public class BloodUtil
{
	public final static boolean consumeBlood(int amount)
	{
		int blood = PlayerNBT.player.getDataWatcher().getWatchableObjectInt(PlayerNBT.BLOOD_WATCHER);
		boolean sufficient = amount <= blood;
		blood -= (amount < blood ? amount : blood);
		PlayerNBT.player.getDataWatcher().updateObject(PlayerNBT.BLOOD_WATCHER, blood);
		return sufficient;
	}

	public final static void replenishBlood()
	{
		PlayerNBT.player.getDataWatcher().updateObject(PlayerNBT.BLOOD_WATCHER, PlayerNBT.maxBlood);
	}

	public final static int getCurrentBlood()
	{
		return PlayerNBT.player.getDataWatcher().getWatchableObjectInt(PlayerNBT.BLOOD_WATCHER);
	}

	public final static void setCurrentBlood(int amount)
	{
		PlayerNBT.player.getDataWatcher().updateObject(PlayerNBT.BLOOD_WATCHER, (amount < PlayerNBT.maxBlood ? amount : PlayerNBT.maxBlood));
	}
	
	public final static void addBlood(int amount)
	{
		int missingAmount = PlayerNBT.maxBlood - getCurrentBlood();
		
		PlayerNBT.player.getDataWatcher().updateObject(PlayerNBT.BLOOD_WATCHER, (amount < missingAmount ? amount : PlayerNBT.maxBlood));
	}

	public static void setMaxBlood(int amount)
	{
		PlayerNBT.maxBlood = amount;
	}

}
