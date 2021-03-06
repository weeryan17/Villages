package com.weeryan17.vgs.turret;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import com.weeryan17.vgs.Main;
/**
 * Used for finding a player relative to the turret.
 * 
 * @author weeryan17
 *
 */
public class PlayerFinder implements Runnable {
	
	Main instance;
	
	public PlayerFinder(Main instance){
		this.instance = instance;
	}
	/**
	 * This is constantly ran by the server.
	 */
	@Override
	public void run() {
		if(this.instance.getPlayerList().contains("Players.")){
			ConfigurationSection players = this.instance.getPlayerList().getConfigurationSection("Players.");
			for(String UUID : players.getKeys(false)){
				String player = this.instance.getPlayerList().getString("Players." + UUID + ".name");
				ArrayList<Location> locations = new ArrayList<Location>();
				if(this.instance.getTurretConfig(player).contains("Turret.")){
					ConfigurationSection turrets = this.instance.getTurretConfig(player).getConfigurationSection("Turret.");
					for(String turret : turrets.getKeys(false)){
						int x = this.instance.getTurretConfig(player).getInt("Turret." + turret + ".centerBlock.x");
						int y = this.instance.getTurretConfig(player).getInt("Turret." + turret + "." + "centerBlock" + ".y");
						int z = this.instance.getTurretConfig(player).getInt("Turret." + turret + "." + "centerBlock" + ".z");
						String worldName = this.instance.getTurretConfig(player).getString("Turret." + turret + ".centerBlock.world");
						World world = Bukkit.getWorld(worldName);
						Location loc = new Location(world, x, y, z);
						locations.add(loc);
					}
				}
				for(Location loc : locations){
					Collection<Entity> entitys = loc.getWorld().getNearbyEntities(loc, 20, 20, 20);
					for(Entity entity : entitys){
						if(entity instanceof Player){
							Player p = (Player) entity;
							p.sendMessage("You are in the set turret range");
						}
					}
				}
			}
		}
	}
}
