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

public class CommandEosAdd extends CommandBase implements ICommand
{
	private List aliases;
	public CommandEosAdd()
	{
		this.aliases = new ArrayList();
		this.aliases.add("addEos");
		this.aliases.add("addeos");
	}

	@Override
	public String getCommandName()
	{
		return "addEos";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return EnumChatFormatting.GOLD + "/addEos <amount> - Add Eos to yourself.";
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
				icommandsender.addChatMessage(RioVAPIUtil.addChatMessage(EnumChatFormatting.DARK_RED, "Invalid arguments. Use /addEos <amount> to add Eos."));
			}

			int amount = Integer.parseInt(astring[0]);
			int missingAmount = props.maxEos - EosUtil.getCurrentEos();

			if(amount > missingAmount)
			{
				icommandsender.addChatMessage(RioVAPIUtil.addChatMessage(EnumChatFormatting.RED, "The number you entered is higher than the current missing Eos amount."));
			}
			else
			{
				EosUtil.addEos(amount);
				icommandsender.addChatMessage(RioVAPIUtil.addChatMessage(EnumChatFormatting.GREEN, "Added " + amount + " Eos to yourself. Eos: " + EosUtil.getCurrentEos() + "/" + props.maxEos));
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