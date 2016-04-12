package com.weeryan17.vgs;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.*;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.EulerAngle;

import com.weeryan17.vgs.commands.VillageCommand;
import com.weeryan17.vgs.protection.ProtectionEvents;
import com.weeryan17.vgs.turret.PlayerFinder;
import com.weeryan17.vgs.turret.TurretPlacer;
import com.weeryan17.vgs.util.EntityMove;
/**
 * This is the main class that is the first class called and the base for everything.
 * This should never be referenced outside this plugin.
 * 
 * @author weeryan17
 *
 */
public class Main extends JavaPlugin {
	/**
	 * Represents this class.
	 */
	Main plugin;
	/**
	 * This is the method that is called when the plugin is enabled.
	 */
	public void onEnable() {
		plugin = this;
		VillageCommand mainCommand = new VillageCommand(plugin);
		TurretPlacer turret = new TurretPlacer(plugin);
		Events events = new Events(plugin);
		ProtectionEvents protection = new ProtectionEvents(plugin);
		Bukkit.getServer().getPluginManager().registerEvents(turret, plugin);
		Bukkit.getServer().getPluginManager().registerEvents(events, plugin);
		Bukkit.getServer().getPluginManager().registerEvents(protection, plugin);
		getCommand("Villages").setExecutor(mainCommand);
		getCommand("V").setExecutor(mainCommand);
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new PlayerFinder(plugin), 0L, 10L);
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new EntityMove(), 0L, 10L);
		this.getLogger().info("Plugin enabled");
	}
	/**
	 * This is the method that is call when the plugin is disabled.
	 */
	public void onDisable() {

	}
	
	HashMap<String, FileConfiguration> datas = new HashMap<String, FileConfiguration>();
	private FileConfiguration data;
	/**
	 * Base method for using configs.
	 * 
	 * @param name Name of the config file you want to load.
	 * @param subFolder The sub folder that you want to store the file in.
	 * @return The config.
	 */
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
	/**
	 * Base method for saving configs.
	 * 
	 * @param name Name of the config you want to save.
	 * @param subFolder The sub folder you want to store the file in.
	 */
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
	/**
	 * Gets the turret configuration file for the specified player.
	 * 
	 * @param player The player that the turrets belong to.
	 * @return The turret configuration file for the specified player.
	 */
	public FileConfiguration getTurretConfig(String player) {
		return this.config("turrets", player);
	}
	/**
	 * Saves the turret configuration file for the specified player.
	 * 
	 * @param player The player that the turrets belong to.
	 */
	public void saveTurretConfig(String player) {
		this.saveConfigs("turrets", player);
	}
	/**
	 * Gets the configuration file that contains a list of all villages.
	 * 
	 * @return The village list configuration file.
	 */
	public FileConfiguration getVillageListConfig() {
		return this.config("village", "General");
	}
	/**
	 * Saves the configuration file that contains a list of all villages.
	 */
	public void saveVillageListConfig() {
		this.saveConfigs("village", "General");
	}
	/**
	 * Gets the village player data configuration file for the specified village.
	 * 
	 * @param village The specified village.
	 * @return The configuration file for the specified village.
	 */
	public FileConfiguration getVillagePlayerData(String village) {
		return this.config("Players", village);
	}
	/**
	 * Saves the player data for the specified village.
	 * 
	 * @param village The specified village.
	 */
	public void saveVillagePlayerData(String village) {
		this.saveConfigs("Players", village);
	}
	/**
	 * Gets the player list configuration file.
	 * 
	 * @return The configuration file that contains all the players.
	 */
	public FileConfiguration getPlayerList() {
		return this.config("Players", "General");
	}
	/**
	 * Save the configuration file that contains a list of all players.
	 */
	public void savePlayerList() {
		this.saveConfigs("Players", "General");
	}
	/**
	 * Gets the village protected land configuration file for the specified village.
	 * 
	 * @param village The specified village.
	 * @return The configuration file that contains the land data for specified village.
	 */
	public FileConfiguration getVillageLandData(String village){
		return this.config("Land", village);
	}
	/**
	 * Saves the land data for the specified village.
	 * 
	 * @param village The specified village.
	 */
	public void saveVillageLandData(String village){
		this.saveConfigs("Land", village);
	}
	/**
	 * Gets the Rank configuration file.
	 * 
	 * @param village The village you want to get the ranks from.
	 * @return The Player rank configuration file.
	 */
	public FileConfiguration getVillagePermissionData(String village){
		return this.config("Ranks", village);
	}
	/**
	 * Save the Rank configuration file.
	 * 
	 * @param village The village rank file you want to save.
	 */
	public void saveVillagePermissionData(String village){
		this.saveConfigs("Ranks", village);
	}
	/**
	 * Saves the specified stand in the turret config for the specified player.
	 * 
	 * @param stand The armor stand you want to store.
	 * @param player The player name of who spawned the turret.
	 * @param standNumber The number of the stand being stored.
	 * @param turretNumber The number of the turret we are storing it in.
	 */
	public void storeArmorStand(ArmorStand stand, String player, int standNumber, int turretNumber) {
		double x = stand.getLocation().getX();
		double y = stand.getLocation().getY();
		double z = stand.getLocation().getZ();
		World world = stand.getWorld();
		ItemStack item = stand.getHelmet();
		String material = item.getType().toString();
		EulerAngle angle = stand.getHeadPose();
		double yAngle = angle.getY();
		this.getTurretConfig(player).set("Turret.turret" + turretNumber + ".stand" + standNumber + ".World", world.getName());
		this.getTurretConfig(player).set("Turret.turret" + turretNumber + ".stand" + standNumber + ".x", x);
		this.getTurretConfig(player).set("Turret.turret" + turretNumber + ".stand" + standNumber + ".y", y);
		this.getTurretConfig(player).set("Turret.turret" + turretNumber + ".stand" + standNumber + ".z", z);
		this.getTurretConfig(player).set("Turret.turret" + turretNumber + ".stand" + standNumber + ".yAngle", yAngle);
		this.getTurretConfig(player).set("Turret.turret" + turretNumber + ".stand" + standNumber + ".Material", material);
	}
	/**
	 * Gets the armor stand from the turret configuration file.
	 * 
	 * @param player The name of the player who owns the turret.
	 * @param standNumber The number of the stand you want to get.
	 * @param turretNumber The turret you are getting the stand from.
	 * @return An armor stand.
	 */
	public ArmorStand getArmorStand(String player, int standNumber, int turretNumber) {
		String worldName = this.getTurretConfig(player).getString("Turret.turret" + turretNumber + ".stand" + standNumber + ".World");
		World world = Bukkit.getWorld(worldName);
		double x = this.getTurretConfig(player).getDouble("Turret.turret" + turretNumber + ".stand" + standNumber + ".x");
		double y = this.getTurretConfig(player).getDouble("Turret.turret" + turretNumber + ".stand" + standNumber + ".y");
		double z = this.getTurretConfig(player).getDouble("Turret.turret" + turretNumber + ".stand" + standNumber + ".z");
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
	public ArrayList<String> getVillageList(){
		ArrayList<String> list = new ArrayList<String>();
		if(this.getVillageListConfig().contains("Villages.")){
			ConfigurationSection villages = this.getVillageListConfig().getConfigurationSection("Villages.");
			for(String village: villages.getKeys(false)){
				list.add(village);
			}
		}
		return list;
		
	}
}
