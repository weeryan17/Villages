package com.weeryan17.vgs.protection;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;

import com.weeryan17.vgs.Main;
import com.weeryan17.vgs.util.PlayerUtil;

public class ClaimLand {
	
	Main instance;
	
	public ClaimLand(Main instance){
		this.instance = instance;
	}
	
	public void ClaimCurrentChunk(PlayerUtil p){
		boolean inVillage = false;
		String village = null;
		Location loc = p.getLocation();
		Chunk chunk = loc.getChunk();
		int x = chunk.getX();
		int z = chunk.getZ();
		if(this.instance.getVillageListConfig().contains("Villages.")){
			ConfigurationSection villages = this.instance.getVillageListConfig().getConfigurationSection("Villages.");
			for(String villageData : villages.getKeys(false)){
				if(p.checkInVillage(villageData)){
					inVillage = true;
					village = villageData;
				}
			}
			if(inVillage){
				if(p.checkVillageOwner() || p.hasSubPermission("village.claim")){
					ArrayList<String> list = new ArrayList<String>();
					if(this.instance.getVillageLandData(village).contains("Land.")){
						ConfigurationSection section = this.instance.getVillageLandData(village).getConfigurationSection("Land.");
						for(String chuck : section.getKeys(false)){
							list.add(chuck);
						}
					}
					int land = list.size() + 1;
					this.instance.getVillageLandData(village).set("Land.Chuck" + land + ".x", x);
					this.instance.getVillageLandData(village).set("Land.Chunk" + land + ".z", z);
				} else {
					p.sendMessage(ChatColor.RED + "You don't have permision to claim for your village");
				}
			} else {
				p.sendMessage(ChatColor.RED + "You arn't even in a village");
			}
		}
	}
}
