package net.jc.mincraft.dm;

import net.shotbow.asciistuff.AsciiStuff;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class OnDeath implements Listener{
	
    private final Main plugin;
    
    public OnDeath(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void OnPlayerDeath(PlayerDeathEvent e)
    {
    	 AsciiStuff as = new AsciiStuff();
    	 e.setDeathMessage("");
    	 plugin.getServer().broadcastMessage(as.skinLine("RED", null, null, null, null, null, null, null));
    }
}
