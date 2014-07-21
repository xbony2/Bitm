package sheenrox82.RioV.src.command;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import sheenrox82.Core.src.base.ModUpdateChecker;
import sheenrox82.RioV.src.api.util.EosUtil;
import sheenrox82.RioV.src.api.util.PlayerNBT;
import sheenrox82.RioV.src.api.util.RioVAPIUtil;
import sheenrox82.RioV.src.util.MethodUtil;

public class CommandPrintChangelog extends CommandBase implements ICommand
{
	private List aliases;
	public CommandPrintChangelog()
	{
		this.aliases = new ArrayList();
		this.aliases.add("printChangelog");
		this.aliases.add("printchangelog");
		this.aliases.add("pc");
	}

	@Override
	public String getCommandName()
	{
		return "printChangelog";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return EnumChatFormatting.GOLD + "/printChangelog - Prints changelog for new update.";
	}

	@Override
	public List getCommandAliases()
	{
		return this.aliases;
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring)
	{        
		if(icommandsender instanceof EntityPlayer)
		{
			ModUpdateChecker.printChangelog("https://dl.dropboxusercontent.com/u/126631367/IngameChangelog.txt");
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