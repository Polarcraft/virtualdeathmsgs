package net.jc.mincraft.dm;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerHead extends JavaPlugin{
        
        // got all this from the api but i need to change the get player face
        
        public String codeU2592(ChatColor colour){
                return colour + "\u2592";
        }
        
        public void getPlayerFace(Player p, Player k){
                String name = p.getName();
                BufferedImage PlayerFace = null;
                boolean cont = true;
                try {
                        URL url;
                        if(name.equalsIgnoreCase("steve")){
                                url = new URL("https://minecraft.net/images/char.png");
                        }else{
                                url = new URL("http://s3.amazonaws.com/MinecraftSkins/" + name + ".png");
                        }                        
                        PlayerFace = ImageIO.read(url);

                } catch (IOException e) {
                        cont = false;
                }
                String name1 = k.getName();
                BufferedImage PlayerFace1 = null;
                boolean cont1 = true;
                try {
                        URL url;
                        if(name.equalsIgnoreCase("steve")){
                                url = new URL("https://minecraft.net/images/char.png");
                        }else{
                                url = new URL("http://s3.amazonaws.com/MinecraftSkins/" + name1 + ".png");
                        }                        
                        PlayerFace1 = ImageIO.read(url);

                } catch (IOException e) {
                        cont1 = false;
                }
                if(cont && cont1){
                        int min_x = 8;
                        int max_x = 16;
                        int min_y = 8;
                        int max_y = 16;

                        int width = max_x - min_x;
                        int height = max_y - min_y;

                        p.sendMessage(" ");
                        p.sendMessage(" ");
                        for(int j = 0; j < height; j++){
                                String chatString = "    ";
                                String chatString1 = "    ";
                                for(int i = 0; i < width; i++){
                                        Color c = new Color(PlayerFace.getRGB(min_x + i, min_y + j));
                                        chatString += codeU2592(getChatColorFromColor(c));
                                        Color c1 = new Color(PlayerFace1.getRGB(min_x + i, min_y + j));
                                        chatString1 += codeU2592(getChatColorFromColor(c1));
                                }
                                p.sendMessage(chatString + "      " + chatString1);
                        }
                        p.sendMessage(" ");
                }else{
                        p.sendMessage(ChatColor.RED + "Playername not found!");
                }
        }
        
        @SuppressWarnings("static-access")
        private ChatColor getChatColorFromColor(Color c){
                ChatColor ret = ChatColor.WHITE;

                Integer r = c.getRed(); // RED
                Integer g = c.getGreen(); // GREEN
                Integer b = c.getBlue(); // BLUE

                float[] hsb = new float[3];
                c.RGBtoHSB(r, g, b, hsb);

                float h = hsb[0]; // HUE
                float s = hsb[1]; // SATURATION
                float v = hsb[2]; // BRIGHTNESS

                if(s > 0.4 && v > 0.2 && h < 0.03333333333){
                        ret = ChatColor.RED;
                }else if(s > 0.6 && v > 0.7 && h > 0.0333333333 && h < 0.1138888888){ // s > 0.4 && v > 0.5
                        ret = ChatColor.RED;
                }else if(s > 0.4 && v > 0.14 && h > 0.019 && h < 0.15){ // v < 0.5 // s < 0.801 // v > 0.2
                        ret = ChatColor.DARK_RED;
                }else if(s > 0.6 && v > 0.09 && h > 0.019 && h < 0.15){ // v < 0.5 // s < 0.801 // v > 0.2
                        ret = ChatColor.DARK_RED;
                }else if(s > 0.3 && v > 0.5 && h > 0.02 && h < 0.15){ // v < 0.5 // s < 0.801 // v > 0.2
                        ret = ChatColor.DARK_RED;
                }else if(s < 0.41 && v < 0.2 && h > 0.01 && h < 0.15){ // v < 0.5 // s < 0.801 // v > 0.2
                        ret = ChatColor.BLACK;
                }else if(s > 0.4 && v < 0.35 && v > 0.2 && h > 0.969){
                        ret = ChatColor.DARK_RED;
                }else if(s > 0.4 && v < 0.2 && v > 0.1 && h > 0.079999999 && h < 0.1222222){
                        ret = ChatColor.DARK_RED;
                }else if(s > 0.8 && v < 0.15 && v > 0.05 && h > 0.079999999 && h < 0.1222222){
                        ret = ChatColor.DARK_RED;
                }else if(s > 0.4 && v > 0.5 && h > 0.1138888888 && h < 0.1916666666){
                        ret = ChatColor.YELLOW;
                }else if(s > 0.4 && v < 0.51 && v > 0.1 && h > 0.1138888888 && h < 0.1916666666){ // new
                        ret = ChatColor.DARK_RED;
                }else if(s > 0.4 && v > 0.2 && v < 0.81 && h > 0.1916666666 && h < 0.3805555555){
                        ret = ChatColor.DARK_GREEN;
                }else if(s > 0.4 && v > 0.5 && h > 0.1916666666 && h < 0.3805555555){
                        ret = ChatColor.GREEN;
                }else if(s > 0.2 && v > 0.75 && h > 0.1916666666 && h < 0.3805555555){
                        ret = ChatColor.GREEN;
                }else if(s > 0.2 && v > 0.8 && h > 0.3805555555 && h < 0.5194444444){ // v > 0.4 adjusted 3
                        ret = ChatColor.BLUE;
                }else if(s > 0.1 && s < 0.21 && v > 0.9 && h > 0.3805555555 && h < 0.5194444444){ // new 3
                        ret = ChatColor.BLUE;
                }else if(s > 0.4 && v < 0.81 && v > 0.2 && h > 0.3805555555 && h < 0.6027777777){ // adjusted 3
                        ret = ChatColor.AQUA;
                }else if(s > 0.4 && v > 0.2 && h > 0.5194444444 && h < 0.6027777777){
                        ret = ChatColor.AQUA;
                }else if(s > 0.4 && v > 0.4 && h > 0.6027777777 && h < 0.6944444444){
                        ret = ChatColor.DARK_BLUE;
                }else if(s > 0.2 && s < 0.41 && v > 0.7 && h > 0.6027777777 && h < 0.6944444444){ // adjusted 3
                        ret = ChatColor.BLUE;
                }else if(s > 0.114 && s < 0.2 && v > 0.6 && h > 0.6027777777 && h < 0.6944444444){ // new 3
                        ret = ChatColor.DARK_BLUE;
                }else if(s > 0.1 && s < 0.2 && v > 0.6 && v < 0.91 && h > 0.6027777777 && h < 0.6944444444){ // new 3
                        ret = ChatColor.BLUE;
                }else if(s > 0.114 && s < 0.2 && v > 0.9 && h > 0.6027777777 && h < 0.6944444444){ // new 3
                        ret = ChatColor.DARK_BLUE;
                }else if(s > 0.6 && v > 0.1 && h > 0.6027777777 && h < 0.6944444444){
                        ret = ChatColor.DARK_BLUE;
                }else if(s > 0.4 && v > 0.3 && h > 0.6944444444 && h < 0.8305555555){
                        ret = ChatColor.DARK_PURPLE;
                }else if(s > 0.4 && v > 0.4 && h > 0.8305555555 && h < 0.8777777777){
                        ret = ChatColor.LIGHT_PURPLE;
                }else if(s > 0.3 && v > 0.4 && h > 0.8777777777 && h < 0.9611111111){
                        ret = ChatColor.LIGHT_PURPLE;
                }else if(s > 0.4 && v > 0.4 && h > 0.9361111111 && h < 1.0000000001){
                        ret = ChatColor.RED;
                }else if(s < 0.11 && v > 0.9){
                        ret = ChatColor.WHITE;
                }else if(s < 0.11 && v < 0.91 && v > 0.7){
                        ret = ChatColor.WHITE;
                }else if(s < 0.11 && v < 0.71 && v > 0.2){
                        ret = ChatColor.WHITE;
                }else if(s < 0.11 && v < 0.21){
                        ret = ChatColor.BLACK;
                }else if(s < 0.3 && v < 0.3 && v > 0.1){
                        ret = ChatColor.GRAY;
                }else if(s < 0.3 && v < 0.11){
                        ret = ChatColor.BLACK;
                }else if(s < 0.7 && v < 0.6){
                        ret = ChatColor.BLACK;
                }else if(v < 0.1){ // 0.05
                        ret = ChatColor.BLACK;
                }else if(s > 0.29 && s < 0.8 && v < 0.11){
                        ret = ChatColor.GRAY;
                }else if(s > 0.29 && s < 0.6 && v < 0.2){
                        ret = ChatColor.GRAY;
                        //NEW COLORS
                }else if(s > 0.6 && h > 0.5666666 && h < 0.602777 && v > 0.12 && v < 0.3){
                        ret = ChatColor.DARK_BLUE;
                }else if(h > 0.5 && h < 0.602777 && v < 0.13){
                        ret = ChatColor.BLACK;        
                }else if(h > 0.95833333 && s > 0.7 && v > 0.19 && v < 0.4){
                        ret = ChatColor.RED;
                }else if(h > 0.8 && h < 0.91666666 && s > 0.35 && v > 0.16 && v < 0.4){
                        ret = ChatColor.DARK_PURPLE;
                }else if(h > 0.3055555 && h < 0.3888888 && s < 0.35 && v > 0.6 && v < 0.8){
                        ret = ChatColor.AQUA;
                }else if(h > 0.38 && h < 0.5833333 && s < 0.35 && v > 0.7 && v < 0.95){
                        ret = ChatColor.BLUE;
                }else if(h > 0.38 && h < 0.5833333 && s < 0.35 && v > 0.5 && v < 0.71){
                        ret = ChatColor.DARK_BLUE;
                }else if(h > 0.5 && h < 0.61 && s > 0.2 && v > 0.7){
                        ret = ChatColor.BLUE;
                }else if(h > 0.5 && h < 0.61 && s > 0.2 && v < 0.71){
                        ret = ChatColor.DARK_BLUE;
                }else if(s < 0.31 && v < 0.16){
                        ret = ChatColor.BLACK;
                        //NEW COLORS 2:
                }else if(h > 0.32 && h < 0.501 && s > 0.99 && v < 0.12){
                        ret = ChatColor.BLACK;
                }else if(h > 0.53 && h < 0.7 && s > 0.5 && v < 0.3 && v > 0.15){
                        ret = ChatColor.DARK_BLUE;
                }else if(h > 0.4 && h < 0.53 && s > 0.5 && v < 0.3 && v > 0.15){
                        ret = ChatColor.AQUA;
                }else if(h < 0.4 && h > 0.2777777 && s > 0.5 && v < 0.3 && v > 0.15){
                        ret = ChatColor.DARK_GREEN;
                }else if(h < 0.25 && h > 0.2 && s > 0.6 && v < 0.25 && v > 0.15){
                        ret = ChatColor.DARK_RED;
                }else if(h > 833333 && h < 94 && s > 0.6 && v < 0.4 && v > 0.15){
                        ret = ChatColor.DARK_PURPLE;
                }else if(h > 0.47222222 && h < 0.541 && s < 0.4 && s > 0.2 && v > 0.8){
                        ret = ChatColor.BLUE;
                }else if(h > 0.541 && h < 0.64 && s < 0.4 && s > 0.2 && v > 0.3){
                        ret = ChatColor.DARK_BLUE;
                }else if(h > 0.47222222 && h < 0.541 && s < 0.4 && s > 0.2 && v < 0.5 && v > 0.2){
                        ret = ChatColor.DARK_BLUE;
                }else if(h > 0.32 && h < 0.501 && s > 0.99 && v < 0.12){
                        ret = ChatColor.GRAY;
                        // NEW COLORS 3
                }else if(h > 0.85 && s > 0.2 && s < 0.41 && v > 0.9){
                        ret = ChatColor.LIGHT_PURPLE;
                }else if(h > 0.763 && s > 0.2 && s < 0.41 && v > 0.5){
                        ret = ChatColor.DARK_PURPLE;
                }else if(h > 0.125 && h < 0.191666666 && s > 0.25 && s < 0.4 && b > 0.89){
                        ret = ChatColor.YELLOW;
                }else if(h > 0.125 && h < 0.191666666 && s > 0.25 && s < 0.4 && b < 0.81 && b > 0.3){
                        ret = ChatColor.DARK_RED;
                }else if(h > 0.222222 && h < 0.2777777777 && s > 0.2 && s > 0.4 && b > 0.85){
                        ret = ChatColor.GREEN;
                }else if(h > 0.222222 && h < 0.2777777777 && s > 0.2 && s > 0.4 && b > 0.4 && b < 0.8){
                        ret = ChatColor.DARK_GREEN;
                }else if(s < 0.114 && b < 0.71 && b > 0.15){
                        ret = ChatColor.GRAY;
                }else{
                        ret = ChatColor.WHITE; // nothing matched
                }


                return ret;
        }
}
