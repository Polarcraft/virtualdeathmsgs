package net.jc.minecraft.dm;

import net.shotbow.asciistuff.AsciiStuff;

import org.bukkit.Server;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
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
    
    String l = "GREEN";
  	String bl = "BLACK";
  	String g = "DARK_GREEN";
	  String gr = "GRAY";
	  String w = "WHITE";
	  String dr = "DARK_RED";
	  String o = "YELLOW";
	  String y = "YELLOW";

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
         		 	PlayerHead.getPlayerFace(player, (Player) killer); 
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
              		 	PlayerHead.getPlayerFace(player, (Player) killer); 
            		 }
        		 } 
        		 else if(((EntityDamageByEntityEvent) player.getLastDamageCause()).getDamager().getType().equals(EntityType.BLAZE))
        		 {
        			 String blaze1 = as.skinLine(y, y, y, y, y, y, y, y);
        			 String blaze2 = as.skinLine(y, y, y, y, y, y, y, y);
        			 String blaze3 = as.skinLine(y, y, y, y, y, y, y, y);
        			 String blaze4 = as.skinLine(y, w, bl, y, y, bl, w, y);
        			 String blaze5 = as.skinLine(o, o, o, o, o, o, o, o);
        			 String blaze6 = as.skinLine(o, o, o, o, o, o, o, w);
        			 String blaze7 = as.skinLine(o, dr, dr, dr, dr, o, dr, dr);
        		 	 String blaze8 = as.skinLine(dr, dr, dr, dr, dr, dr, dr, dr);
        		 	 server.broadcastMessage(blaze1);
        		 	 server.broadcastMessage(blaze2);
        		 	 server.broadcastMessage(blaze3);
        		 	 server.broadcastMessage(blaze4);
        		 	 server.broadcastMessage(blaze5);
	        		 server.broadcastMessage(blaze6);
	        		 server.broadcastMessage(blaze7);
	        		 server.broadcastMessage(blaze8);
        		 }
        		 /*else if(((EntityDamageByEntityEvent) player.getLastDamageCause()).getDamager().getType().equals(EntityType.ENDERMAN))
        		 {
        		 	String enderman1 = as.skinLine(bl, bl, bl, bl, bl, bl, bl, bl);
        		 	String enderman2 = as.skinLine(bl, bl, bl, bl, bl, bl, bl ,bl);
        		 }*/
        		 else if(((EntityDamageByEntityEvent) player.getLastDamageCause()).getDamager().getType().equals(EntityType.FIREBALL))
        		 {
        			 Fireball fb = (Fireball) ((EntityDamageByEntityEvent) player.getLastDamageCause()).getDamager();
        			 if(fb.getShooter().getType().equals(EntityType.BLAZE))
        			 {
        				 String blaze1 = as.skinLine(y, y, y, y, y, y, y, y);
        				 String blaze2 = as.skinLine(y, y, y, y, y, y, y, y);
            		 	 String blaze3 = as.skinLine(y, y, y, y, y, y, y, y);
            		 	 String blaze4 = as.skinLine(y, w, bl, y, y, bl, w, y);
            		 	 String blaze5 = as.skinLine(o, o, o, o, o, o, o, o);
            		 	 String blaze6 = as.skinLine(o, o, o, o, o, o, o, w);
            		 	 String blaze7 = as.skinLine(o, dr, dr, dr, dr, o, dr, dr);
            		 	 String blaze8 = as.skinLine(dr, dr, dr, dr, dr, dr, dr, dr);
            		 	 server.broadcastMessage(blaze1);
            		 	 server.broadcastMessage(blaze2);
            		 	 server.broadcastMessage(blaze3);
            		 	 server.broadcastMessage(blaze4);
            		 	 server.broadcastMessage(blaze5);
            		 	 server.broadcastMessage(blaze6);
            		 	 server.broadcastMessage(blaze7);
            		 	 server.broadcastMessage(blaze8);
        			 }
        		 }
        	 }
    	 }
    }
}
