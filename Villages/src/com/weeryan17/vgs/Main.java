package com.weeryan17.vgs;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.EulerAngle;

import com.weeryan17.vgs.commands.VillageCommand;
import com.weeryan17.vgs.turret.PlayerFinder;
import com.weeryan17.vgs.turret.TurretPlacer;

public class Main extends JavaPlugin {

	Main plugin;

	public void onEnable() {
		plugin = this;
		VillageCommand mainCommand = new VillageCommand();
		TurretPlacer turret = new TurretPlacer(plugin);
		Events events = new Events(plugin);
		Bukkit.getServer().getPluginManager().registerEvents(turret, plugin);
		Bukkit.getServer().getPluginManager().registerEvents(events, plugin);
		getCommand("Villages").setExecutor(mainCommand);
		getCommand("V").setExecutor(mainCommand);
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new PlayerFinder(plugin), 0L, 10L);
		this.getLogger().info("Plugin enabled");
	}

	public void onDisable() {

	}

	HashMap<String, FileConfiguration> datas = new HashMap<String, FileConfiguration>();
	private FileConfiguration data;
	private FileConfiguration config(String name, String subFolder) {
		final File config = new File(getDataFolder() + "\\" + subFolder, name + ".yml");
		if (datas.get(name) == null) {
			data = (FileConfiguration) YamlConfiguration.loadConfiguration(config);
			final InputStream defConfigStream = getResource(name + ".yml");
			if (defConfigStream != null) {
				@SuppressWarnings({ "deprecation" })
				final YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
				data.setDefaults((Configuration) defConfig);
			}
			datas.put(name, data);
		}
		return datas.get(name);
	}

	private void saveConfigs(String name, String subFolder) {
		final File config = new File(getDataFolder() + "\\" + subFolder, name + ".yml");
		try {
			this.getConfig().options().copyDefaults(true);
			this.config(name, subFolder).save(config);
			this.config(name, subFolder);
		} catch (IOException ex) {
			getLogger().log(Level.WARNING, "Couldn''t save {0}.yml", name);
		}
	}

	public FileConfiguration getTurretConfig(String player) {
		return this.config("turrets", player);
	}

	public void saveTurretConfig(String player) {
		this.saveConfigs("turrets", player);
	}

	public void saveVillageListConfig() {
		this.saveConfigs("village", "General");
	}

	public FileConfiguration getVillageListConfig() {
		return this.config("village", "General");
	}

	public void saveVillagePlayerData(String village) {
		this.saveConfigs("Players", village);
	}

	public FileConfiguration getVillagePlayerData(String village) {
		return this.config("Players", village);
	}

	public FileConfiguration getPlayerList() {
		return this.config("Players", "General");
	}

	public void savePlayerList() {
		this.saveConfigs("Players", "General");
	}

	public void storeArmorStand(ArmorStand stand, String village, int standNumber, int turretNumber) {
		double x = stand.getLocation().getX();
		double y = stand.getLocation().getY();
		double z = stand.getLocation().getZ();
		World world = stand.getWorld();
		ItemStack item = stand.getHelmet();
		String material = item.getType().toString();
		EulerAngle angle = stand.getHeadPose();
		double yAngle = angle.getY();
		this.getTurretConfig(village).set("Turret.turret" + turretNumber + ".stand" + standNumber + ".World", world);
		this.getTurretConfig(village).set("Turret.turret" + turretNumber + ".stand" + standNumber + ".x", x);
		this.getTurretConfig(village).set("Turret.turret" + turretNumber + ".stand" + standNumber + ".y", y);
		this.getTurretConfig(village).set("Turret.turret" + turretNumber + ".stand" + standNumber + ".z", z);
		this.getTurretConfig(village).set("Turret.turret" + turretNumber + ".stand" + standNumber + ".yAngle", yAngle);
		this.getTurretConfig(village).set("Turret.turret" + turretNumber + ".stand" + standNumber + ".Material", material);
	}

	public ArmorStand getArmorStand(String village, int standNumber, int turretNumber) {
		World world = (World) this.getTurretConfig(village).get("Turret.turret" + turretNumber + ".stand" + standNumber + ".World");
		double x = this.getTurretConfig(village).getDouble("Turret.turret" + turretNumber + ".stand" + standNumber + ".x");
		double y = this.getTurretConfig(village).getDouble("Turret.turret" + turretNumber + ".stand" + standNumber + ".y");
		double z = this.getTurretConfig(village).getDouble("Turret.turret" + turretNumber + ".stand" + standNumber + ".z");
		Location loc = new Location(world, x, y, z);
		List<Entity> standList = loc.getWorld().getEntities();
		ArmorStand stand = null;
		for (Entity e : standList) {
			if (e.getType() == EntityType.ARMOR_STAND) {
				stand = (ArmorStand) e;
			}
		}
		return stand;
	}
}
