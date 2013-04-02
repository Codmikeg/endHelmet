package me.Codmikeg.endhelmet;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class helmetCheck {
	endHelmet plugin;
	
	public helmetCheck(endHelmet plugin){
		this.plugin = plugin;
	}
	
	public static void checkHelmet(Player player){
		ItemStack helmet = player.getInventory().getHelmet();
        if(helmet != null && helmet.getType() != Material.AIR){
            if(helmet.getType() == Material.GLASS){
            }
            else{
                    player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, Integer.MAX_VALUE, 10));
                   
            }
        }
        else{
                player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, Integer.MAX_VALUE, 10));
        }		
	}
	public static void checkHelmetClick(HumanEntity player){
		ItemStack helmet = player.getInventory().getHelmet();
        if(helmet != null && helmet.getType() != Material.AIR){
            if(helmet.getType() == Material.GLASS){
            }
            else{
                    player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, Integer.MAX_VALUE, 10));
                   
            }
        }
        else{
                player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, Integer.MAX_VALUE, 10));
        }		
	}
}
