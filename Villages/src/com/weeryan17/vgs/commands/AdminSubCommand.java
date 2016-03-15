package com.weeryan17.vgs.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class AdminSubCommand {
	VillageCommand command;
	public AdminSubCommand() {
		
	}

	public void executeCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0 || (args.length == 1 && args[0].equals("help"))) {
			command.help(sender, "admin-General");
		}
		if (args.length == 2 && args[0].equals("help")) {
			command.help(sender, "admin-" + args[1]);
		}
	}
}