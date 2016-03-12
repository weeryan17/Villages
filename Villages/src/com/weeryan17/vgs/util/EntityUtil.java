package com.weeryan17.vgs.util;

import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Entity;

import com.weeryan17.vgs.Main;

public abstract class EntityUtil extends Main implements Entity {
	
	Entity entity = this;
	Main instance = this;
	
	public boolean checkInVillage(){
		boolean inVillage = false;
		Location loc = entity.getLocation();
		if(this.instance.getVillageListConfig().contains("Villages.")){
			ConfigurationSection villages = this.instance.getVillageListConfig().getConfigurationSection("Villages.");
			for(String village : villages.getKeys(false)){
				if(this.instance.getVillageLandData(village).contains("Land.")){
					ConfigurationSection land = this.instance.getVillageLandData(village).getConfigurationSection("Land.");
					for(String chunkRaw : land.getKeys(false)){
						int x1 = loc.getChunk().getX();
						int z1 = loc.getChunk().getZ();
						int x2 = this.instance.getVillageLandData(village).getInt("Land." + chunkRaw + ".x");
						int z2 = this.instance.getVillageLandData(village).getInt("Land." + chunkRaw + ".z");
						if(x1 == x2 && z1 == z2){
							inVillage = true;
						}
					}
				}
			}
		}
		return inVillage;
		
	}
	public void kill(){
		Location location = new Location(entity.getWorld(), entity.getLocation().getX(), -1, entity.getLocation().getZ());
		entity.teleport(location);
	}
}
