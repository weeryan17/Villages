package com.weeryan17.vgs.util;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import com.weeryan17.vgs.Main;
/**
 * Class for doing special stuff with players.
 * 
 * @author weeryan17
 *
 */
public abstract class PlayerUtil extends Main implements Player {
	
	Player p;
	
	Main instance;
	
	public PlayerUtil(){
		this.p = this;
		this.instance = this;
	}
	
	/**
	 * Checks if the player is a village owner
	 * 
	 * @return A boolean  of weather or not the player owns a village.
	 */
	public boolean checkVillageOwner(){
		ArrayList<String> uuidList = new ArrayList<String>();
		UUID uuid = p.getUniqueId();
		String uuidString = uuid.toString();
		ConfigurationSection section = this.instance.getVillageListConfig().getConfigurationSection("Vilages.");
		for(String village : section.getKeys(false)){
			String uuidConfig = this.instance.getVillagePlayerData(village).getString("Owner.UUID");
			uuidList.add(uuidConfig);
		}
		if(uuidList.contains(uuidString)){
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Check if the player is part of a certain village.
	 * 
	 * @param village The specified village.
	 * @return A boolean of weather he/she is in a village or not.
	 */
	public boolean checkInVillage(String village){
		ArrayList<String> uuidList = new ArrayList<String>();
		UUID uuid = p.getUniqueId();
		String uuidString = uuid.toString();
		ConfigurationSection members = this.instance.getVillagePlayerData(village).getConfigurationSection("Members.");
		for(String member : members.getKeys(false)){
			uuidList.add(member);
		}
		if(uuidList.contains(uuidString)){
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Gets the village the player is in.
	 * 
	 * @return The village the player is in.
	 */
	public String getVillage(){
		if(this.instance.getVillageListConfig().contains("Villages.")){
			
		}
		return "";
	}
	/**
	 * Checks if the player has a sub permission defined by the plugin.
	 * 
	 * @param subPermission The specified sub permission you want to check.
	 * @return A boolean of of weather or not the player has that sub permission.
	 */
	public boolean hasSubPermission(String subPermission){
		
		return false;
	}
	/**
	 * Gets the current village rank of the player.
	 * 
	 * @return The village rank the player is.
	 */
	public String getRank(){
		
		return "";
	}
}
