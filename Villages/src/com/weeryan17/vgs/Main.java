package com.weeryan17.vgs;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
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
	
	
	   private FileConfiguration data;
	   private FileConfiguration config(String name, String subFolder){
		   final File config = new File(getDataFolder() + "\\" + subFolder, name + ".yml");
		   if(data == null){
			   data = (FileConfiguration) YamlConfiguration.loadConfiguration(config);
			   final InputStream defConfigStream = getResource(name + ".yml");
			   if (defConfigStream != null) {
	                @SuppressWarnings({ "deprecation"})
	                final YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
	                data.setDefaults((Configuration) defConfig);
			   }
		   }
		   return data;
	   }
	   
	   private void saveConfigs(String name, String subFolder){
		   final File config = new File(getDataFolder() + "'\'" + subFolder, name + ".yml");
		   try {
	            this.getConfig().options().copyDefaults(true);
	            this.config(name, null).save(config);
	            this.config(name, null);
		   } catch (IOException ex) {
	            getLogger().log(Level.WARNING, "Couldn''t save {0}.yml", name);
	        }
	   }
	   public FileConfiguration getTurretConfig(String village){
		  return this.config("turrets", village); 
	   }
	   public void saveTurretConfig(String village){
		   this.saveConfigs("turrets", village);
	   }
}
