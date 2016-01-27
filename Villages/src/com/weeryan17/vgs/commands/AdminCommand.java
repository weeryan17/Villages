package com.weeryan17.vgs.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class AdminCommand extends VillageCommandControler {

	@Override
	public boolean executeCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 0){
			sender.sendMessage(ChatColor.BLUE + "Villages Admin help");
			return true;
		} else if(args.length == 1){
			String arg = args[1];
			switch(arg){
			case "test":{
				sender.sendMessage("Test");
			}
			}	
		}
		sender.sendMessage("No such command or argument");
		return false;
	}
	
}
