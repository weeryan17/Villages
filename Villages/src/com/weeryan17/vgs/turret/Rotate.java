package com.weeryan17.vgs.turret;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;

import com.weeryan17.vgs.Main;

public class Rotate {
	Main instance;
	public Rotate(Main instance){
		this.instance = instance;
	}
	public void pantoAngle(String village, int turret, double angle){
		//angle is supposed to be in radians
		int x = this.instance.getTurretConfig(village).getInt("Turret." + turret + "." + "centerBlock" + ".x");
		int z = this.instance.getTurretConfig(village).getInt("Turret." + turret + "." + "centerBlcok" + ".z");
		String worldName = this.instance.getTurretConfig(village).getString("Turret " + turret + "." + "centerBlcok" + ".world");
		World world = Bukkit.getWorld(worldName);
		Float angleF = (float) angle;
		
		//Stand 1
		double zStand1 = (Math.sin(angle) * -1.3) + z;
		double xStand1 = (Math.sin(angle) * -1.3) + x;
		ArmorStand stand1 = this.instance.getArmorStand(village, 1, turret);
		Location standLoc1 = stand1.getLocation();
		double yStand1 = standLoc1.getY();
		Location locStand1 = new Location(world, xStand1, yStand1, zStand1, angleF, 0);
		stand1.teleport(locStand1);
		
		//Stand 2
		double zStand2 = (Math.sin(angle) * -1) + z;
		double xStand2 = (Math.sin(angle) * -1) + x;
		ArmorStand stand2 = this.instance.getArmorStand(village, 2, turret);
		Location standLoc2 = stand2.getLocation();
		double yStand2 = standLoc2.getY();
		Location locStand2 = new Location(world, xStand2, yStand2, zStand2, angleF, 0);
		stand1.teleport(locStand2);
		
		//Stand 3
		double zStand3 = (Math.sin(angle) * -1.3) + z;
		double xStand3 = (Math.sin(angle) * -1.3) + x;
		ArmorStand stand3 = this.instance.getArmorStand(village, 3, turret);
		Location standLoc3 = stand3.getLocation();
		double yStand3 = standLoc3.getY();
		Location locStand3 = new Location(world, xStand3, yStand3, zStand3, angleF, 0);
		stand1.teleport(locStand3);
		
		//Stand 4
		double zStand4 = (Math.sin(angle) * -0.9) + z;
		double xStand4 = (Math.sin(angle) * -0.9) + x;
		ArmorStand stand4 = this.instance.getArmorStand(village, 4, turret);
		Location standLoc4 = stand4.getLocation();
		double yStand4 = standLoc4.getY();
		Location locStand4 = new Location(world, xStand4, yStand4, zStand4, angleF, 0);
		stand1.teleport(locStand4);
		
		//Stand 5
		double zStand5 = (Math.sin(angle) * -1.3) + z;
		double xStand5 = (Math.sin(angle) * -1.3) + x;
		ArmorStand stand5 = this.instance.getArmorStand(village, 5, turret);
		Location standLoc5 = stand5.getLocation();
		double yStand5 = standLoc5.getY();
		Location locStand5 = new Location(world, xStand5, yStand5, zStand5, angleF, 0);
		stand1.teleport(locStand5);
		
		//Stand 6
		double zStand6 = (Math.sin(angle) * -1.3) + z;
		double xStand6 = (Math.sin(angle) * -1.3) + x;
		ArmorStand stand6 = this.instance.getArmorStand(village, 6, turret);
		Location standLoc6 = stand6.getLocation();
		double yStand6 = standLoc6.getY();
		Location locStand6 = new Location(world, xStand6, yStand6, zStand6, angleF, 0);
		stand1.teleport(locStand6);
		
		//Stand 7
		double zStand7 = (Math.sin(angle) * -1.3) + z;
		double xStand7 = (Math.sin(angle) * -1.3) + x;
		ArmorStand stand7 = this.instance.getArmorStand(village, 7, turret);
		Location standLoc7 = stand7.getLocation();
		double yStand7 = standLoc7.getY();
		Location locStand7 = new Location(world, xStand7, yStand7, zStand7, angleF, 0);
		stand1.teleport(locStand7);
		
		//Stand 8
		double zStand8 = (Math.sin(angle) * -1) + z;
		double xStand8 = (Math.sin(angle) * -1) + x;
		ArmorStand stand8 = this.instance.getArmorStand(village, 8, turret);
		Location standLoc8 = stand8.getLocation();
		double yStand8 = standLoc8.getY();
		Location locStand8 = new Location(world, xStand8, yStand8, zStand8, angleF, 0);
		stand1.teleport(locStand8);
		
		//Stand 9
		double zStand9 = (Math.sin(angle) * -1.3) + z;
		double xStand9 = (Math.sin(angle) * -1.3) + x;
		ArmorStand stand9 = this.instance.getArmorStand(village, 9, turret);
		Location standLoc9 = stand9.getLocation();
		double yStand9 = standLoc9.getY();
		Location locStand9 = new Location(world, xStand9, yStand9, zStand9, angleF, 0);
		stand1.teleport(locStand9);
	}
}
