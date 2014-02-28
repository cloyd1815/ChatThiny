package net.cencraft.main;

import net.cencraft.listeners.ChatListener;
import net.cencraft.util.PLogger;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	private static Main plugin;
	public final PLogger plo = new PLogger(this);
	public static Permission perms = null;
	
	@Override
	public void onEnable() {
		plugin = this;
		plo.enabled(true);
		registerEvents(this, new ChatListener());
		setupPermissions();
	}

	@Override
	public void onDisable() {
		plo.enabled(true);
	}

	private boolean setupPermissions() {
		RegisteredServiceProvider<Permission> rsp = getServer()
				.getServicesManager().getRegistration(Permission.class);
		perms = rsp.getProvider();
		return perms != null;
	}

	public static JavaPlugin getJavaPlugin() {
		JavaPlugin plugin = Main.plugin;
		return plugin;
	}

	public static void registerEvents(org.bukkit.plugin.Plugin plugin,
			Listener... listeners) {
		for (Listener listener : listeners) {
			Bukkit.getServer().getPluginManager()
					.registerEvents(listener, plugin);
		}
	}
}
