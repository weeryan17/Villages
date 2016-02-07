package com.weeryan17.vgs.turret;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
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
		if(item.getType() == Material.RECORD_11){
			if(event.getClickedBlock().getType() == Material.STEP && event.getClickedBlock().getData() == 6){
				Location blockLocation = event.getClickedBlock().getLocation();
				int x = blockLocation.getBlockX();
				int y = blockLocation.getBlockY();
				int z = blockLocation.getBlockZ();
				//Going to be used later for checking the structure
				//int bottomLeftx = x - 1;
				//int bottomLegty = y - 1;
				//int bottomLeftz = z - 1;
				//int topRightx = x + 1;
				//int topRighty = y + 3;
				//int topRightz = z + 1;
				String turret;
				ConfigurationSection section = this.instance.getTurretConfig(name).getConfigurationSection("Turret.");
				if(!(section == null)){
					for(String key : section.getKeys(false)){
						list.add(key);
					}
					turret = "turret" + list.size() + 1;
				} else {
					turret = "turret1";
				}
				
				//Stand 1 creator
				Location stand1loc = new Location(world, x + .5, y - .8, z - 1.3);
				ArmorStand stand1 = (ArmorStand) stand1loc.getWorld().spawnEntity(stand1loc, EntityType.ARMOR_STAND);
				stand1.setHelmet(obsidian);
				stand1.setGravity(false);
				stand1.setVisible(false);
				this.instance.getTurretConfig(name).set("Turret." + turret + "." + "stand1", stand1);
				
				//Stand 2 creator
				Location stand2loc = new Location(world, x + .5, y - 1.8, z - 1);
				ArmorStand stand2 = (ArmorStand) stand2loc.getWorld().spawnEntity(stand2loc, EntityType.ARMOR_STAND);
				stand2.setHelmet(obsidian);
				EulerAngle angle2 = new EulerAngle(45, 0, 0);
				stand2.setHeadPose(angle2);
				stand2.setGravity(false);
				stand2.setVisible(false);
				this.instance.getTurretConfig(name).set("Turret." + turret + "." + "stand2", stand2);
				
				//Stand 3 creator
				Location stand3loc = new Location(world, x + .5, y - 1.2, z -1.3);
				ArmorStand stand3 = (ArmorStand) stand3loc.getWorld().spawnEntity(stand3loc, EntityType.ARMOR_STAND);
				stand3.setHelmet(obsidian);
				stand3.setGravity(false);
				stand3.setVisible(false);
				this.instance.getTurretConfig(name).set("Turret." + turret + "." + "stand3", stand3);
				
				//Stand 4 creator
				Location stand4loc = new Location(world, x + .5, y - 1.4, z - .9);
				ArmorStand stand4 = (ArmorStand) stand4loc.getWorld().spawnEntity(stand4loc, EntityType.ARMOR_STAND);
				stand4.setHelmet(obsidian);
				EulerAngle angle4 = new EulerAngle(-45, 0, 0);
				stand4.setHeadPose(angle4);
				stand4.setGravity(false);
				stand4.setVisible(false);
				this.instance.getTurretConfig(name).set("Turret." + turret + "." + "stand4", stand4);
				
				//Stand 5 creator
				Location stand5loc = new Location(world, x + .5, y + 1.3, z - 1.3);
				ArmorStand stand5 = (ArmorStand) stand5loc.getWorld().spawnEntity(stand5loc, EntityType.ARMOR_STAND);
				stand5.setHelmet(obsidian);
				EulerAngle angle5 = new EulerAngle(45, 0, 0);
				stand5.setHeadPose(angle5);
				stand5.setGravity(false);
				stand5.setVisible(false);
				this.instance.getTurretConfig(name).set("Turret." + turret + "." + "stand5", stand5);
				
				//Stand 6 creator. It has glass!
				Location stand6loc = new Location(world, x + .5, y - .2, z -1.3);
				ArmorStand stand6 = (ArmorStand) stand6loc.getWorld().spawnEntity(stand6loc, EntityType.ARMOR_STAND);
				ItemStack glass = new ItemStack(Material.GLASS);
				stand6.setHelmet(glass);
				stand6.setGravity(false);
				stand6.setVisible(false);
				this.instance.getTurretConfig(name).set("Turret." + turret + "." + "stand6", stand6);
				
				//Stand 7 creator
				Location stand7loc = new Location(world, x + .5, y + .9, z -1.3);
				ArmorStand stand7 = (ArmorStand) stand7loc.getWorld().spawnEntity(stand7loc, EntityType.ARMOR_STAND);
				stand7.setHelmet(obsidian);
				stand7.setGravity(false);
				stand7.setVisible(false);
				this.instance.getTurretConfig(name).set("Turret." + turret + "." + "stand7", stand7);
				
				//Stand 8 creator
				Location stand8loc = new Location(world, x + .5, y + 1.6, z - 1);
				ArmorStand stand8 = (ArmorStand) stand8loc.getWorld().spawnEntity(stand8loc, EntityType.ARMOR_STAND);
				stand8.setHelmet(obsidian);
				EulerAngle angle8 = new EulerAngle(315, 0, 0);
				stand8.setHeadPose(angle8);
				stand8.setGravity(false);
				stand8.setVisible(false);
				this.instance.getTurretConfig(name).set("Turret." + turret + "." + "stand8", stand8);
				
				//Stand 9 creator
				Location stand9loc = new Location(world, x + .5, y + .4, z -1.3);
				ArmorStand stand9 = (ArmorStand) stand9loc.getWorld().spawnEntity(stand9loc, EntityType.ARMOR_STAND);
				stand9.setHelmet(obsidian);
				stand9.setGravity(false);
				stand9.setVisible(false);
				this.instance.getTurretConfig(name).set("Turret." + turret + "." + "stand9", stand9);
				
				//Crystal creator
				Location crystalLoc = new Location(world, x + .5, y + .6, z + .5);
				crystalLoc.getWorld().spawnEntity(crystalLoc, EntityType.ENDER_CRYSTAL);
				
				//center cord storing
				this.instance.getTurretConfig(name).set("Turret." + turret + "." + "centerBlock" + ".x", x);
				this.instance.getTurretConfig(name).set("Turret." + turret + "." + "centerBlock" + ".z", z);
				
				//Placing barriers
				//Barrier 1
				Location locBlock1 = new Location(world, x + 1, y + 1, z + 1);
				Block block1 = locBlock1.getBlock();
				block1.setType(Material.BARRIER);
				
				//Barrier 2
				Location locBlock2 = new Location(world, x - 1, y + 1, z + 1);
				Block block2 = locBlock2.getBlock();
				block2.setType(Material.BARRIER);
				
				//Barrier 2
				Location locBlock3 = new Location(world, x + 1, y + 1, z);
				Block block3 = locBlock3.getBlock();
				block3.setType(Material.BARRIER);
				
				//Barrier 4
				Location locBlock4 = new Location(world, x - 1, y + 1, z);
				Block block4 = locBlock4.getBlock();
				block4.setType(Material.BARRIER);
				
				//Barrier 5
				Location locBlock5 = new Location(world, x, y + 1, z + 1);
				Block block5 = locBlock5.getBlock();
				block5.setType(Material.BARRIER);
				
				//Barrier 6
				Location locBlock6 = new Location(world, x, y + 1, z - 1);
				Block block6 = locBlock6.getBlock();
				block6.setType(Material.BARRIER);
				
				//Barrier 7
				Location locBlock7 = new Location(world, x - 1, y + 1, z - 1);
				Block block7 = locBlock7.getBlock();
				block7.setType(Material.BARRIER);
				
				//Barrier 8
				Location locBlock8 = new Location(world, x + 1, y + 1, z - 1);
				Block block8 = locBlock8.getBlock();
				block8.setType(Material.BARRIER);
			}
		}
	}
}
