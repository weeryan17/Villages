package com.weeryan17.vgs;

import org.bukkit.event.*;
import org.bukkit.event.player.*;
/**
 * This is the where all the basic events go. aka events that don't involve server interaction.
 * 
 * @author weeryan17
 *
 */
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
