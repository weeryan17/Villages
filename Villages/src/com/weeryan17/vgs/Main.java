package com.weeryan17.vgs;

import org.bukkit.plugin.java.JavaPlugin;

import com.weeryan17.vgs.commands.AdminCommand;
import com.weeryan17.vgs.commands.VillageCommand;

public class Main extends JavaPlugin {
	public void onEnable(){
		VillageCommand mainCommand = new VillageCommand();
		AdminCommand admin = new AdminCommand();
		mainCommand.register("admin", admin);
		getCommand("Villages").setExecutor(mainCommand);
		getCommand("V").setExecutor(mainCommand);
	}
}
