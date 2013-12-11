package net.jc.mincraft.dm;

import net.shotbow.asciistuff.AsciiStuff;

import org.bukkit.Server;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
 
public class OnDeath implements Listener{
	
    private final Main plugin;
    
    public OnDeath(Main plugin) {
        this.plugin = plugin;
    }
    
    public String l = "GREEN";
    public String bl = "BLACK";
    public String g = "DARK_GREEN";
    public String gr = "GRAY";
    public String w = "WHITE";

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
        	 if(player.getLastDamageCause() instanceof EntityDamageByEntityEvent)
        	 {
        		 if(((EntityDamageByEntityEvent) player.getLastDamageCause()).getDamager().getType().equals(EntityType.ZOMBIE))
        		 {
         		 	plugin.getPlayerFace(player, (Player) killer); 
        		 }
        		 else if(((EntityDamageByEntityEvent) player.getLastDamageCause()).getDamager().getType().equals(EntityType.ZOMBIE))
        		 {
            		 String zombie1 = as.skinLine(g, g, g, g, g, g, g, g);
            		 String zombie2 = as.skinLine(g, g, g, g, l, l, g, g);
            		 String zombie3 = as.skinLine(g, l, l, l, l, l, l, l);
            		 String zombie4 = as.skinLine(l, l, l, l, l, l, l, l);
            		 String zombie5 = as.skinLine(l, bl, bl, l, l, bl, bl, l);
            		 String zombie6 = as.skinLine(l, l, l, g, g, l, l, l);
            		 String zombie7 = as.skinLine(l, l, l, l, l, l, l, g);
            		 String zombie8 = as.skinLine(g, l, l, l, l, l, l, g);
            		 server.broadcastMessage(zombie1);
            		 server.broadcastMessage(zombie2);
            		 server.broadcastMessage(zombie3);
            		 server.broadcastMessage(zombie4);
            		 server.broadcastMessage(zombie5);
            		 server.broadcastMessage(zombie6);
            		 server.broadcastMessage(zombie7);
            		 server.broadcastMessage(zombie8);
        		 }
        		 else if(((EntityDamageByEntityEvent) player.getLastDamageCause()).getDamager().getType().equals(EntityType.ARROW))
        		 {
            		 Arrow a = (Arrow) ((EntityDamageByEntityEvent) player.getLastDamageCause()).getDamager();
            		 if(a.getShooter().getType().equals(EntityType.SKELETON))
            		 {
                		 String skele1 = as.skinLine(gr, gr, gr, gr, gr, gr, gr, gr);
                		 String skele2 = as.skinLine(gr, gr, gr, w, w, w, gr, gr);
                		 String skele3 = as.skinLine(gr, w, w, w, w, w, w, w);
                		 String skele4 = as.skinLine(w, w, w, w, w, w, w, w);
                		 String skele5 = as.skinLine(w, bl, bl, w, w, bl, bl, w);
                		 String skele6 = as.skinLine(w, w, w, gr, gr, w, w, w);
                		 String skele7 = as.skinLine(w, bl, bl, bl, bl, bl, bl, w);
                		 String skele8 = as.skinLine(w, w, w, w, w, w, w, w);
                		 server.broadcastMessage(skele1);
                		 server.broadcastMessage(skele2);
                		 server.broadcastMessage(skele3);
                		 server.broadcastMessage(skele4);
                		 server.broadcastMessage(skele5);
                		 server.broadcastMessage(skele6);
                		 server.broadcastMessage(skele7);
                		 server.broadcastMessage(skele8);
            		 }
            		 else if(a.getShooter().getType().equals(EntityType.PLAYER))
            		 {
            			 
            		 }
        		 }
        	 }
    	 }
    }
    
}
