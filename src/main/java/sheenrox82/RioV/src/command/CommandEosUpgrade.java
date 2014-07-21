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

public class CommandEosUpgrade extends CommandBase implements ICommand
{
	private List aliases;
	public CommandEosUpgrade()
	{
		this.aliases = new ArrayList();
		this.aliases.add("upgradeEos");
		this.aliases.add("upgradeeos");
		this.aliases.add("uEos");
		this.aliases.add("ueos");
	}

	@Override
	public String getCommandName()
	{
		return "upgradeEos";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return EnumChatFormatting.GOLD + "/upgradeEos <newMaxEosAmmount> - Set new max Eos amount.";
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
			if (astring.length == 0)
			{
				icommandsender.addChatMessage(RioVAPIUtil.addChatMessage(EnumChatFormatting.DARK_RED, "Invalid arguments. Use /upgradeEos <newMaxEosAmmount> to upgrade max Eos."));
			}

			int amount = Integer.parseInt(astring[0]);

			if(amount < props.maxEos)
			{
				icommandsender.addChatMessage(RioVAPIUtil.addChatMessage(EnumChatFormatting.RED, "The number you entered is lower than the current max Eos amount. (" + props.maxEos + ")"));
			}
			else
			{
				EosUtil.setMaxEos(amount);
				icommandsender.addChatMessage(RioVAPIUtil.addChatMessage(EnumChatFormatting.GREEN, "Set " + amount + " as new max Eos."));
			}
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