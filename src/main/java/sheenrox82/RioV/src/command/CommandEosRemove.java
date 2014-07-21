package sheenrox82.RioV.src.command;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumChatFormatting;
import sheenrox82.RioV.src.api.util.EosUtil;
import sheenrox82.RioV.src.api.util.PlayerNBT;
import sheenrox82.RioV.src.api.util.RioVAPIUtil;

public class CommandEosRemove extends CommandBase implements ICommand
{
	private List aliases;
	public CommandEosRemove()
	{
		this.aliases = new ArrayList();
		this.aliases.add("removeEos");
		this.aliases.add("remEos");
		this.aliases.add("removeeos");
		this.aliases.add("remeos");
	}

	@Override
	public String getCommandName()
	{
		return "removeEos";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return EnumChatFormatting.GOLD + "/removeEos <amount> - Removes Eos.";
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
				icommandsender.addChatMessage(RioVAPIUtil.addChatMessage(EnumChatFormatting.DARK_RED, "Invalid arguments. Use /removeEos <amount> to remove Eos."));
			}

			int amount = Integer.parseInt(astring[0]);

			if(amount > EosUtil.getCurrentEos())
			{
				icommandsender.addChatMessage(RioVAPIUtil.addChatMessage(EnumChatFormatting.RED, "The number you entered is higher than the current amount of Eos."));
			}
			else
			{
				EosUtil.consumeEos(amount);
				icommandsender.addChatMessage(RioVAPIUtil.addChatMessage(EnumChatFormatting.GREEN, "Removed " + amount + " Eos from yourself. Eos: " + EosUtil.getCurrentEos() + "/" + props.maxEos));
			}
		}
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender)
	{
		return true;
	}

	public int getRequiredPermissionLevel()
	{
		return 3;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender icommandsender, String[] astring)
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