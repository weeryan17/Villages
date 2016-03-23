package com.weeryan17.vgs;

import org.bukkit.event.*;
import org.bukkit.event.player.*;
/**
 * This is the where all the basic events go. aka events that don't fit anywhere else.
 * 
 * @author weeryan17
 *
 */
public class Events implements Listener {
	/**
	 * An instance representing the main class.
	 */
	Main instance;
	/**
	 * Constructor for this class.
	 * 
	 * @param instance The instance representing the main class.
	 */
	public Events(Main instance){
		this.instance = instance;
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		this.instance.getPlayerList().set("Players." + event.getPlayer().getUniqueId() + ".name", event.getPlayer().getName());
		this.instance.savePlayerList();
	}
}
