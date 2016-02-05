package com.weeryan17.vgs.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class VillageCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(args.length >= 1){
			switch(args[0]){
			case "help":{
				
			}
			}
		} else {
			
		}
		
		return false;
	}

}
