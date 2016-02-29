package com.weeryan17.vgs.turret;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import com.weeryan17.vgs.Main;

public class PlayerFinder implements Runnable {
	
	Main instance;
	double radius; 
	
	public PlayerFinder(Main instance){
	this.instance = instance;
	this.radius = instance.getConfig().getDouble("Temp");
	}

	@Override
	public void run() {
		this.instance.getLogger().info("Running");
		ArrayList<Location> locations = new ArrayList<Location>();
		if(this.instance.getVillageListConfig().contains("Villages.")){
		ConfigurationSection villages = this.instance.getVillageListConfig().getConfigurationSection("Villages.");
			for(String village : villages.getKeys(false)){
				this.instance.getLogger().info("Villages found" + village);
				if(this.instance.getTurretConfig(village).contains("Turret.")){
					ConfigurationSection turrets = this.instance.getTurretConfig(village).getConfigurationSection("Turret.");
					for(String turret : turrets.getKeys(false)){
						int x = this.instance.getTurretConfig(village).getInt("Turret.turret" + turret + "." + "centerBlock" + ".x");
						int y = this.instance.getTurretConfig(village).getInt("Turret.turret" + turret + "." + "centerBlock" + ".y");
						int z = this.instance.getTurretConfig(village).getInt("Turret.turret" + turret + "." + "centerBlock" + ".z");
						World world = (World) this.instance.getTurretConfig(village).get("Turret.turret" + turret + "." + "centerBlock" + ".world");
						Location loc = new Location(world, x, y, z);
						locations.add(loc);
					}
				}
			}
			for(Location loc : locations){
				Collection<Entity> entitys = loc.getWorld().getNearbyEntities(loc, 20, 20, 20);
				for(Entity entity : entitys){
					if(entity instanceof Player){
						Player p = (Player) entity;
						p.sendMessage("You are in the set turret range");
					}
				}
			}
		
		} else {
			this.instance.getLogger().info("no villages found");
		}
	}
	
}
