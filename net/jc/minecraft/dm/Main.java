package net.jc.minecraft.dm;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	@Override
	public void onDisable(){
	}

	@Override
	public void onEnable(){
		getServer().getPluginManager().registerEvents(new OnDeath(this), this);
	}
}
