package me.Codmikeg.endhelmet;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class armourCheck {
	endHelmet plugin;
	  
	public armourCheck(endHelmet plugin) {
		this.plugin = plugin;
	}

	public static void checkArmour(Player player){
		//Add the chestplate to a variable
		ItemStack chest = player.getInventory().getChestplate();
		//Add the leggins to a variable
		ItemStack leggings = player.getInventory().getLeggings();
			
		ItemStack boots = player.getInventory().getBoots();
		
		if(chest != null && chest.getType() != Material.AIR){
			player.sendMessage("1");
			if(leggings != null && leggings.getType() != Material.AIR){
				player.sendMessage("2");
				if(boots != null && boots.getType() != Material.AIR){
					player.sendMessage("3");
					if(chest.getType() == Material.LEATHER_CHESTPLATE && leggings.getType() == Material.LEATHER_LEGGINGS && boots.getType() == Material.LEATHER_BOOTS){
						ItemMeta metaC = chest.getItemMeta();
						LeatherArmorMeta metaChest = (LeatherArmorMeta) metaC;
						ItemMeta metaL = chest.getItemMeta();
						LeatherArmorMeta metaLeggings = (LeatherArmorMeta) metaL;
						ItemMeta metaB = chest.getItemMeta();
						LeatherArmorMeta metaBoots = (LeatherArmorMeta) metaB;
						if(metaChest.getColor().equals(Color.WHITE) && metaLeggings.getColor().equals(Color.WHITE) && metaBoots.getColor().equals(Color.WHITE)){
							
						}
						else{
			                player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, Integer.MAX_VALUE, 10));
						}
					}
					else{						
		                player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, Integer.MAX_VALUE, 10));
					}
				}
				else{						
	                player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, Integer.MAX_VALUE, 10));
				}
			}
			else{						
                player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, Integer.MAX_VALUE, 10));
			}
		}
		else{
			player.sendMessage("5");
			player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, Integer.MAX_VALUE, 10));
		}
	}

}
