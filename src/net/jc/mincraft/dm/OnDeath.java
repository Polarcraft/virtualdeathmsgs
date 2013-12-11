package net.jc.mincraft.dm;

import net.shotbow.asciistuff.AsciiStuff;

import org.bukkit.Server;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
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
    	 Server server = plugin.getServer();
    	 Player player = e.getEntity();
    	 LivingEntity killer = e.getEntity().getKiller();
    	 if(player.hasPermission("visualdeathmsg.true"))
    	 {
        	 e.setDeathMessage("");
        	 server.broadcastMessage("The awsome " + as.skinLine("BROWN", "BROWN", "BROWN", "BROWN", "BROWN", "BROWN", "BROWN", "BROWN"));
    	 }
    }
    
}
