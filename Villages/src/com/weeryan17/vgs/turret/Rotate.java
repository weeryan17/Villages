package com.weeryan17.vgs.turret;

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
		int x = this.instance.getTurretConfig(village).getInt("Turret " + turret + "." + "centerBlock" + ".x");
		int z = this.instance.getTurretConfig(village).getInt("Turret " + turret + "." + "centerBlcok" + ".z");
		World world = (World) this.instance.getTurretConfig(village).get("Turret " + turret + "." + "centerBlcok" + ".world");
		double zStand1 = (Math.sin(angle) * -1.3) + z;
		double xStand1 = (Math.sin(angle) * -1.3) + x;
		Float angleF = (float) angle;
		ArmorStand stand1 = (ArmorStand) this.instance.getTurretConfig(village).get("Turret " + turret + "." + "stand1");
		Location standLoc1 = stand1.getLocation();
		double yStand1 = standLoc1.getY();
		Location loc = new Location(world, xStand1, yStand1, zStand1, angleF, 0);
		stand1.teleport(loc);
		
	}
}
