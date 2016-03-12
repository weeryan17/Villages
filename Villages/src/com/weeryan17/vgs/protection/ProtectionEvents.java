package com.weeryan17.vgs.protection;

import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.*;

import com.weeryan17.vgs.util.EntityUtil;

public class ProtectionEvents implements Listener {
	@EventHandler
	public void onInteract(PlayerInteractEvent event){
		
	}
	@EventHandler
	public void onDammange(EntityDamageByEntityEvent event){
		Entity dammage = event.getEntity();
		if(dammage.getType() == EntityType.ENDER_CRYSTAL){
			event.setCancelled(true);
		}
	}
	@EventHandler 
	public void onMobSpawn(EntitySpawnEvent event){
		EntityUtil entity = (EntityUtil) event.getEntity();
		if(entity instanceof Player){
			
		} else {
			if(entity.checkInVillage()){
				event.setCancelled(true);
			}
		}
	}
	@EventHandler
	public void onTarget(EntityTargetEvent event){
		EntityUtil entity = (EntityUtil) event.getEntity();
		if(entity.checkInVillage()){
			event.setCancelled(true);
		}
	}
	
}
