package sheenrox82.RioV.src.command;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import sheenrox82.RioV.src.api.util.EosUtil;
import sheenrox82.RioV.src.api.util.PlayerNBT;
import sheenrox82.RioV.src.api.util.RioVAPIUtil;

public class CommandEosReplenish extends CommandBase implements ICommand
{
	private List aliases;
	public CommandEosReplenish()
	{
		this.aliases = new ArrayList();
		this.aliases.add("resetEos");
		this.aliases.add("reseteos");
	}

	@Override
	public String getCommandName()
	{
		return "resetEos";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return EnumChatFormatting.GOLD + "/resetEos - Resets Eos to 50.";
	}

	@Override
	public List getCommandAliases()
	{
		return this.aliases;
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring)
	{
		EntityPlayer player = (EntityPlayer)icommandsender;
		PlayerNBT props = PlayerNBT.get(player);

		if(icommandsender instanceof EntityPlayer)
		{
			EosUtil.replenishEos();
			icommandsender.addChatMessage(RioVAPIUtil.addChatMessage(EnumChatFormatting.GREEN, "Replenished Eos. Eos: " + EosUtil.getCurrentEos() + "/" + props.maxEos));
		}
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender)
	{
		return true;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender icommandsender,
			String[] astring)
	{
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] astring, int i)
	{
		return false;
	}

	@Override
	public int compareTo(Object o)
	{
		return 0;
	}

	public int getRequiredPermissionLevel()
	{
		return 3;
	}
}