package com.weeryan17.vgs.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
/**
 * This is the admin sub command class called whenever someone does /v admin.
 * 
 * @author weeryan17
 *
 */
public class AdminSubCommand {
	/**
	 * Represents the base command.
	 */
	VillageCommand command;
	
	public void executeCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0 || (args.length == 1 && args[0].equals("help"))) {
			command.help(sender, "admin-General");
		}
		if (args.length == 2 && args[0].equals("help")) {
			command.help(sender, "admin-" + args[1]);
		}
	}
}
