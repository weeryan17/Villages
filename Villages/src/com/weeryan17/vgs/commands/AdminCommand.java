package com.weeryan17.vgs.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.weeryan17.vgs.Main;

import net.md_5.bungee.api.ChatColor;

public class AdminCommand extends VillageCommandControler {
	
	Main instance;
	
	public AdminCommand(Main instance){
		this.instance = instance;
	}
	
	@Override
	public boolean executeCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 0){
			sender.sendMessage(ChatColor.BLUE + "Villages Admin help");
		} else{
			switch(args[0]){
			case "toggle":{
				sender.sendMessage("Toggle test");
			}
			case "test":{
				sender.sendMessage("Test test");
			}
			
			}
		}
		return false;
	}
	
}
