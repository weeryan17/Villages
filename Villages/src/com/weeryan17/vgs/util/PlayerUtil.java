package com.weeryan17.vgs.util;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import com.weeryan17.vgs.Main;

public abstract class PlayerUtil extends Main implements Player {
	
	Player p;
	
	Main instance;
	
	public PlayerUtil(){
		this.p = this;
		this.instance = this;
	}
	
	
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
	/*
	 * Checks if the player is in a specified village
	 * @pram village The village name
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
	/*
	 * Gets the village the player is currently in
	 */
	public String getVillage(){
		if(this.instance.getVillageListConfig().contains("Villages.")){
			
		}
		return "";
	}
	public boolean hasSubPermission(String subPermission){
		
		return false;
	}
	public String getRank(){
		
		return "";
	}
}
