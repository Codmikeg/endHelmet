package me.Codmikeg.endhelmet;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

public class endHelmet extends JavaPlugin {
    public final Logger log = Logger.getLogger("Minecraft");
    
    @Override
    public void onEnable(){  	  	
        getServer().getPluginManager().registerEvents(new myPlayerListener(this), this);
        PluginDescriptionFile pdfFile = this.getDescription();
        this.log.info(pdfFile.getName() + " " + " v" + pdfFile.getVersion() + " : Has been enabled - Enjoy! <3");
               
        
    }
   
    @Override
    public void onDisable(){
    	this.getLogger().info("Plugin has been disabled! ;(");
    }
	
   
    
    
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
	Player player = (Player)sender;
		if(commandLabel.equalsIgnoreCase("helmet") || commandLabel.equalsIgnoreCase("h")){
				ItemStack helmet = player.getInventory().getHelmet();
				if(player.getItemInHand().getType() == Material.GLASS){
					if(helmet != null && helmet.getType() != Material.AIR){
						player.sendMessage(ChatColor.DARK_PURPLE + "You already have your helmet on!");
					}
					else{
						player.getInventory().getItemInHand().setAmount(player.getInventory().getItemInHand().getAmount()-1);
						if(player.getInventory().getItemInHand().getAmount() == 1){
							player.getInventory().removeItem(player.getItemInHand());
						}
						player.getInventory().setHelmet(new ItemStack(Material.GLASS, 1));
						player.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.ITALIC + "Your helmet has been applied!");
					}
				}
				else{
					player.sendMessage(ChatColor.RED + "You do not have your helmet in your hand!");
				}	
		}
		if(commandLabel.equalsIgnoreCase("debug")){
			if(player.getInventory().getBoots().getType() == Material.CHAINMAIL_BOOTS){
				player.sendMessage("Fuck you");
			}
		}
		if(commandLabel.equalsIgnoreCase("debug2")){
			player.removePotionEffect(PotionEffectType.BLINDNESS);
			player.sendMessage("PotionEffect removed");
		}
		return false;
	}


}