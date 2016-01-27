package com.weeryan17.vgs.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class VillageCommand extends VillageCommandControler {

	@Override
	public boolean executeCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 0){
			sender.sendMessage(ChatColor.BLUE + "Village command help");
			return true;
		}
		sender.sendMessage("No such command or argument");
		return false;
	}

}
