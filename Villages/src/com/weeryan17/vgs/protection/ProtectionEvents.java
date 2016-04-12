package com.weeryan17.vgs.protection;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.*;

import com.weeryan17.vgs.Main;
import com.weeryan17.vgs.util.EntityUtil;
import com.weeryan17.vgs.util.api.Land;
/**
 * This class contains the events for making sure land is protected.
 * 
 * @author weeryan17
 *
 */
public class ProtectionEvents implements Listener {
	Main instance;
	public ProtectionEvents(Main instance){
		this.instance = instance;
	}
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
	@SuppressWarnings("deprecation")
	public void onExpload(EntityExplodeEvent event){
		List<Block> blocks = event.blockList();
		final ArrayList<Block> replaceBlocks = new ArrayList<Block>();
		Land land = new Land();
		for(Block block : blocks){
			Location blockLoc = block.getLocation();
			if(land.getInVillage(blockLoc)){
				replaceBlocks.add(block);
			}
		}
		Bukkit.getScheduler().scheduleAsyncDelayedTask(instance, new Runnable(){

			@Override
			public void run() {
				for(Block block : replaceBlocks){
					
				}
			}
			
		}, 5L);
	}
}
