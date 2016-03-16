package com.weeryan17.vgs.util.api;

import java.util.logging.Level;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;

import com.weeryan17.vgs.Main;
/**
 * Api class for everything that has to do with village protection.
 * 
 * @author weeryan17
 *
 */
public class Land extends Main {
	
	Main instance = this;
	/**
	 * Gets weather or not a location is in a village.
	 * 
	 * @param location The location that you want the check.
	 * @return A boolean of weather or not the location is in a village.
	 */
	public boolean getInVillage(Location loc){
		boolean inVillage = false;
		if(this.instance.getVillageListConfig().contains("Villages.")){
			ConfigurationSection section = this.instance.getVillageListConfig().getConfigurationSection("Villages.");
			for(String village : section.getKeys(false)){
				if(this.instance.getVillageLandData(village).contains("Land.")){
					ConfigurationSection chunks = this.instance.getVillageLandData(village).getConfigurationSection("Land.");
					for(String chunkRaw : chunks.getKeys(false)){
						Chunk chunk = loc.getChunk();
						int x1 = chunk.getX();
						int z1 = chunk.getZ();
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
	/**
	 * Gets the village a location is currently in.
	 * 
	 * @param location The location where you want to get a village from. Make sure you check that it is in a village first.
	 * @return The village that that location is in.
	 */
	public String getVillageIn(Location loc){
		if(this.getInVillage(loc)){
			String village = "";
			ConfigurationSection villages = this.instance.getVillageListConfig().getConfigurationSection("Villages.");
			for(String villageRaw : villages.getKeys(false)){
				if(this.instance.getVillageLandData(villageRaw).contains("Land.")){
					ConfigurationSection chunks = this.instance.getVillageLandData(villageRaw).getConfigurationSection("Land.");
					for(String chunkRaw : chunks.getKeys(false)){
						int x1 = loc.getChunk().getX();
						int z1 = loc.getChunk().getZ();
						int x2 = this.instance.getVillageLandData(villageRaw).getInt("Land." + chunkRaw + ".x");
						int z2 = this.instance.getVillageLandData(villageRaw).getInt("Land." + chunkRaw + ".z");
						if(x1 == x2 && z1 == z2){
							village = villageRaw;
						}
					}
				}
			}
			return village;
		} else {
			this.instance.getLogger().log(Level.WARNING, "A plugin tryed to get the village a location was in but there is no village there!");
			return null;
		}
	}
}
