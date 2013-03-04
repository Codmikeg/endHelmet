package me.Codmikeg.endhelmet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class endHelmet extends JavaPlugin {
    public final Logger log = Logger.getLogger("Minecraft");

    String[] listOne = { "one", "two", "three", "four" };
    List<String> listTwo = new ArrayList<String>();
    
    @Override
    public void onEnable() {
        listTwo.add("one");
        listTwo.add("two");
        listTwo.add("three");
        listTwo.add("four");
 
        FileConfiguration config = getConfig();
 
        config.addDefault("Example.String", "This is a string");
        config.addDefault("Example.Int", 1);
        config.addDefault("Example.Boolean", true);
        config.addDefault("Example.List.One", Arrays.asList(listOne));
 
        config.addDefault("Example.List.Two", listTwo);
 
        config.options().copyDefaults(true);
        saveConfig();
    	
    	
    	
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
			//ItemStack amount = player.getInventory().getContents())
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
	return false;
	}
}
