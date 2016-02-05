package com.weeryan17.vgs;

import org.bukkit.plugin.java.JavaPlugin;

import com.weeryan17.vgs.commands.VillageCommand;

public class Main extends JavaPlugin {
	
	Main plugin;
	
	public void onEnable(){
		plugin = this;
		VillageCommand mainCommand = new VillageCommand();
		getCommand("Villages").setExecutor(mainCommand);
		getCommand("V").setExecutor(mainCommand);
	}
}
