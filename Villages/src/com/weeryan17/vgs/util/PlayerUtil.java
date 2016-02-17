package com.weeryan17.vgs.util;

import java.util.UUID;

import org.bukkit.entity.Player;

import com.weeryan17.vgs.Main;

public abstract class PlayerUtil extends Main implements Player {
	
	Player p;
	
	Main instance;
	
	public PlayerUtil(){
		this.p = this;
		this.instance = this;
	}
	
	
	public boolean checkVillageOwner(String village){
		UUID uuid = p.getUniqueId();
		String uuidString = uuid.toString();
		String uuidConfig = this.instance.getVillagePlayerData(village).getString("Owner.UUID");
		if(uuidString.equals(uuidConfig)){
			return true;
		} else {
			return false;
		}
	}
	public boolean checkInVillage(String village){
		UUID uuid = p.getUniqueId();
		String uuidString = uuid.toString();
		return false;
	}
}
