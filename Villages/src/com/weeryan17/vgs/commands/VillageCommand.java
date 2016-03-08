package com.weeryan17.vgs.commands;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.weeryan17.vgs.util.PlayerUtil;

public class VillageCommand implements CommandExecutor {

	AdminSubCommand admin;

	public VillageCommand() {
		admin = new AdminSubCommand();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (args.length >= 1) {
			switch (args[0]) {
			case "help": {
				if (args.length == 2) {
					help(sender, args[1]);
				} else {
					help(sender, "general");
				}
			}
			case "admin": {
				if (sender.hasPermission("villages.admin")) {
					admin.executeCommand(sender, cmd, label, Arrays.copyOfRange(args, 1, args.length));
				} else {
					sender.sendMessage(ChatColor.RED + "You don't have access to any admin futures so don't try to do them");
				}
			}
			}
		} else {

		}

		return false;
	}

	public static void help(CommandSender sender, String command) {

		sender.sendMessage(ChatColor.YELLOW + "Villages help");
		sender.sendMessage(ChatColor.YELLOW + "Oo--------------------------------oO");
		switch (command) {
		case "help": {
			sender.sendMessage(ChatColor.DARK_GREEN + "/v help: " + ChatColor.BLUE + "This is the command to show you the help menu");
		}
		case "general": {
			sender.sendMessage(ChatColor.DARK_GREEN + "/v help: " + ChatColor.BLUE + "This is the command for showing this help menu (or you chould just so /v)");
			if (sender.hasPermission("villages.admin")) {
				sender.sendMessage(ChatColor.DARK_GREEN + "/v admin: " + ChatColor.BLUE + "This is the command for the admin help menu. It only shows commands you have access to.");
			}
			if (sender instanceof Player) {
				PlayerUtil p = (PlayerUtil) sender;
				sender.sendMessage(ChatColor.DARK_GREEN + "/v new [name]: " + ChatColor.BLUE + "Creates a new village with the specifyed name");
				if (p.checkVillageOwner()) {
					sender.sendMessage(ChatColor.DARK_GREEN + "/v options: " + ChatColor.BLUE + "Brings up the town options gui.");
				}

			}
		}
		case "admin": {
			if (sender.hasPermission("villages.admin")) {
				sender.sendMessage(ChatColor.DARK_GREEN + "/v admin: " + ChatColor.BLUE + "This is the command for the admin help menu. It only shows commands you have access to.");
			} else {
				sender.sendMessage(ChatColor.RED + "You don't have access to any admin futures so don't try to do them");
			}
		}
		case "admin-General": {

		}
		default: {
			sender.sendMessage(ChatColor.RED + "No such command or sub command");
		}
		}
	}

}
