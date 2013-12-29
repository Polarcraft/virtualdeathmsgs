package net.jc.mincraft.dm;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Main plugin;
	
	@Override
	public void onDisable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Has been Disabled");
	}

	@Override
	public void onEnable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version " +  pdfFile.getVersion() + " Has been Enabled");
		PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new OnDeath(this), this);
	}
}
