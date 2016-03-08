package com.weeryan17.vgs;

import org.bukkit.event.*;
import org.bukkit.event.player.*;
	
public class Events implements Listener {
	Main instance;
	public Events(Main instance){
		this.instance = instance;
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		this.instance.getPlayerList().set("Players." + event.getPlayer().getUniqueId() + ".name", event.getPlayer().getName());
		this.instance.savePlayerList();
	}
}
