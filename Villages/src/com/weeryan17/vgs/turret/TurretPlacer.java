package com.weeryan17.vgs.turret;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
//import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;

import com.weeryan17.vgs.Main;

public class TurretPlacer implements Listener {
	
	Main instance;
	public TurretPlacer(Main instance){
		this.instance = instance;
	}
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent event){
		ItemStack obsidian = new ItemStack(Material.OBSIDIAN);
		ArrayList<String> list = new ArrayList<String>();
		ItemStack item = event.getItem();
		Player p = event.getPlayer();
		String name = p.getName();
		World world = p.getWorld();
		if(item.getType() == Material.RECORD_9){
			if(event.getClickedBlock().getType() == Material.STONE_SPADE && event.getClickedBlock().getData() == 6){
				Location blockLocation = event.getClickedBlock().getLocation();
				int x = blockLocation.getBlockX();
				int y = blockLocation.getBlockY();
				int z = blockLocation.getBlockZ();
				//int bottomLeftx = x - 1;
				//int bottomLegty = y - 1;
				//int bottomLeftz = z - 1;
				//int topRightx = x + 1;
				//int topRighty = y + 3;
				//int topRightz = z + 1;
				
				ConfigurationSection section = this.instance.getTurretConfig(name).getConfigurationSection("Turret.");
				for(String key : section.getKeys(false)){
					list.add(key);
				}
				String turret = "turret" + list.size() + 1;
				
				//Stand 1 creator
				Location stand1loc = new Location(world, x, y - .8, z - 1.3);
				ArmorStand stand1 = (ArmorStand) stand1loc.getWorld().spawnEntity(stand1loc, EntityType.ARMOR_STAND);
				stand1.setHelmet(obsidian);
				this.instance.getTurretConfig(name).set("Turret." + turret + "." + "stand1", stand1);
				
				//Stand 2 creator
				Location stand2loc = new Location(world, x, y - 1.8, z - 1);
				ArmorStand stand2 = (ArmorStand) stand2loc.getWorld().spawnEntity(stand2loc, EntityType.ARMOR_STAND);
				stand2.setHelmet(obsidian);
				EulerAngle angle2 = new EulerAngle(315, 0, 0);
				stand2.setHeadPose(angle2);
				this.instance.getTurretConfig(name).set("Turret." + turret + "." + "stand2", stand2);
				
				//Stand 3 creator
			}
		}
	}
}
