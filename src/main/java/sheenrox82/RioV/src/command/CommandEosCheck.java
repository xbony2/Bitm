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

public class CommandEosCheck extends CommandBase implements ICommand
{
	private List aliases;
	public CommandEosCheck()
	{
		this.aliases = new ArrayList();
		this.aliases.add("checkEos");
		this.aliases.add("checkeos");
	}

	@Override
	public String getCommandName()
	{
		return "checkEos";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return EnumChatFormatting.GOLD + "/checkEos - Checks the amount of Eos you have.";
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
			icommandsender.addChatMessage(RioVAPIUtil.addChatMessage(EnumChatFormatting.GREEN, "Your current Eos amount is: " + EosUtil.getCurrentEos() + "/" + props.maxEos));
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
}