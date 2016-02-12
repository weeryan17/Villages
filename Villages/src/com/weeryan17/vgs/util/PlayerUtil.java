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
	
	
	public boolean checkVillageOwner(){
		UUID uuid = p.getUniqueId();
		return false;
	}
}
