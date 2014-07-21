package sheenrox82.RioV.src.api.util;

public class EosUtil
{
	public final static boolean consumeEos(int amount)
	{
		int mana = PlayerNBT.player.getDataWatcher().getWatchableObjectInt(PlayerNBT.EOS_WATCHER);
		boolean sufficient = amount <= mana;
		mana -= (amount < mana ? amount : mana);
		PlayerNBT.player.getDataWatcher().updateObject(PlayerNBT.EOS_WATCHER, mana);
		return sufficient;
	}

	public final static void replenishEos()
	{
		PlayerNBT.player.getDataWatcher().updateObject(PlayerNBT.EOS_WATCHER, PlayerNBT.maxEos);
	}

	public final static int getCurrentEos()
	{
		return PlayerNBT.player.getDataWatcher().getWatchableObjectInt(PlayerNBT.EOS_WATCHER);
	}

	public final void setCurrentEos(int amount)
	{
		PlayerNBT.player.getDataWatcher().updateObject(PlayerNBT.EOS_WATCHER, (amount < PlayerNBT.maxEos ? amount : PlayerNBT.maxEos));
	}
	
	public final static void addEos(int amount)
	{
		int missingAmount = PlayerNBT.maxEos - getCurrentEos();
		
		PlayerNBT.player.getDataWatcher().updateObject(PlayerNBT.EOS_WATCHER, (amount < missingAmount ? amount : PlayerNBT.maxEos));
	}

	public static void setMaxEos(int amount)
	{
		PlayerNBT.maxEos = amount;
	}

}
