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
	/**
	 * Represents the player.
	 */
	Player p;
	/**
	 * An instance representing the main class.
	 */
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
	 * Checks if that player is in any village
	 * 
	 * @return if the player is in any village
	 */
	public boolean checkInAnyVillage(){
		boolean inVillage = false;
		if(this.instance.getVillageListConfig().contains("Villages.")){
			ConfigurationSection villages = this.instance.getVillageListConfig().getConfigurationSection("Villages.");
			for(String village : villages.getKeys(false)){
				if(this.checkInVillage(village)){
					inVillage = true;
				}
			}
		}
		return inVillage;
	}
	/**
	 * Gets the village the player is in.
	 * 
	 * @return The village the player is in.
	 */
	public String getVillage(){
		String village = null;
		if(this.instance.getVillageListConfig().contains("Villages.")){
			ConfigurationSection villages = this.instance.getVillageListConfig().getConfigurationSection("Villages.");
			for(String villageRaw : villages.getKeys(false)){
				if(this.instance.getVillagePlayerData(villageRaw).contains("Members.")){
					ConfigurationSection members = this.instance.getVillagePlayerData(villageRaw).getConfigurationSection("Members.");
					if(members.contains(getName())){
						village = villageRaw;
					}
				}
			}
		}
		return village;
	}
	/**
	 * Checks if the player has a sub permission defined by the plugin.
	 * 
	 * @param subPermission The specified sub permission you want to check.
	 * @return A boolean of of weather or not the player has that sub permission.
	 */
	public boolean hasSubPermission(String subPermission){
		String rank = this.getRank();
		if(rank != null){
			@SuppressWarnings("unchecked")
			ArrayList<String> list = (ArrayList<String>) this.instance.getVillagePermissionData(this.getVillage()).get("Rank." + rank);
			if(list.contains(subPermission)){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	/**
	 * Gets the current village rank of the player.
	 * 
	 * @return The village rank the player is.
	 */
	public String getRank(){
		String rank = null;
		for(String village: this.instance.getVillageList()){
			if(this.instance.getVillagePermissionData(village).contains("Ranks.")){
				ConfigurationSection ranks = this.instance.getVillagePermissionData(village).getConfigurationSection("Ranks.");
				for(String rankRaw: ranks.getKeys(false)){
					ConfigurationSection players = this.instance.getVillagePlayerData(village).getConfigurationSection(rankRaw +".");
					for(String player: players.getKeys(false)){
						if(p.getName() == player){
							rank = player;
						}
					}
				}
			}
		}
		return rank;
	}
}
