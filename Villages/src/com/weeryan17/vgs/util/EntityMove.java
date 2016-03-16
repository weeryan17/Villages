package com.weeryan17.vgs.util;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
/**
 * This is finding when a entity moves in the world and doing stuff with that.
 * 
 * @author weeryan17
 *
 */
public class EntityMove implements Runnable {
	
	HashMap<Entity, Location> map = new HashMap<Entity, Location>();
	
	@Override
	public void run() {
		for(World w : Bukkit.getWorlds()){
			for(Entity e : w.getEntities()){
				Location loc = e.getLocation();
				if(map.containsKey(e)){
					if(map.get(e) != loc){
						EntityUtil entity = (EntityUtil) e;
						if(entity.checkInVillage()){
							entity.kill();
						}
					}
				}
			}
		}
		
	}
	
}
