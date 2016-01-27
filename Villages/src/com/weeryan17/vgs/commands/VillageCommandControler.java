package com.weeryan17.vgs.commands;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public abstract class VillageCommandControler implements CommandExecutor {
	
	private final Map<String, CommandExecutor> commandExecutors = new HashMap<>();
	
	
	public void register(String name, CommandExecutor exc){
		commandExecutors.put(name, exc);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(args.length == 0){
			return executeCommand(sender, cmd, lable, args);
		}
		CommandExecutor exc = commandExecutors.get(args[0].toLowerCase());
		return commandExecutors == null ? executeCommand(sender, cmd, lable, args) : exc.onCommand(sender, cmd, lable, Arrays.copyOfRange(args, 1, args.length));
	}
	public abstract boolean executeCommand(CommandSender sender, Command cmd, String label, String[] args);
}
