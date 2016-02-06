package com.weeryan17.vgs.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class VillageCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(args.length >= 1){
			switch(args[0]){
			case "help":{
				if(args.length == 2){
					help(sender, args[1]);
				} else {
					help(sender, "general");
				}
			}
			}
		} else {
			
		}
		
		return false;
	}
	public void help(CommandSender sender, String command){
		sender.sendMessage(ChatColor.YELLOW + "Villages help");
		sender.sendMessage(ChatColor.YELLOW + "Oo--------------------------------oO");
		switch(command){
		case "help":{
			sender.sendMessage(ChatColor.DARK_GREEN + "/help: " + ChatColor.BLUE + "This is the command to show you the help menu");
		}
		case "general":{
			
		}
		}
	}

}
