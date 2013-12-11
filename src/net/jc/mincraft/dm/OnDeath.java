package net.jc.mincraft.dm;

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
    	
    }
}
