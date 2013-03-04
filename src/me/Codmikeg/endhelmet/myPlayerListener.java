package me.Codmikeg.endhelmet;
 
 
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class myPlayerListener implements Listener {
	 endHelmet plugin;
	  
	 public myPlayerListener(endHelmet plugin) {
		 this.plugin = plugin;
	 }
	 
        @EventHandler
    public void onRespawnEvent(PlayerRespawnEvent event) {
        		final Player player = event.getPlayer();
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    public void run() {
                    	if(player.getWorld().getName().equals("world_the_end")){
                        ItemStack helmet = player.getInventory().getHelmet();
                        if(helmet != null && helmet.getType() != Material.AIR){
                            if(helmet.getType() == Material.GLASS){
                            }
                            else{
                                    player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 5000, 10));
                            }
                           
                        }
                        else{
                                player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 5000, 10));
                        }
                }        
	    }
}, 20);
                
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
            Player player = event.getPlayer();
            if(player.getWorld().getName().equals("world_the_end")){
                    ItemStack helmet = player.getInventory().getHelmet();
                    if(helmet != null && helmet.getType() != Material.AIR){
                            if(helmet.getType() == Material.GLASS){
                            }
                            else{
                                    player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 5000, 10));
                            }
                           
                    }
                    else{
                            player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 5000, 10));
                    }
            }
    }
    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event){
            Entity e = event.getEntity();
            Player player = (Player)e;
            ItemStack helmet = player.getInventory().getHelmet();
            if(helmet != null && helmet.getType() != Material.AIR){
                    if(helmet.getType() == Material.GLASS){
                            if(e instanceof Player){
                                    player.removePotionEffect(PotionEffectType.WITHER);
                            }
                            if(e instanceof Block){}
                    }
            }
    }     
    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent event){
    	Player player = event.getPlayer();
        if(player.getWorld().getName().equals("world_the_end")){
                ItemStack helmet = player.getInventory().getHelmet();
                if(helmet != null && helmet.getType() != Material.AIR){
                        if(helmet.getType() == Material.GLASS){
                        }
                        else{
                                player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 5000, 10));
                        }
                       
                }
                else{
                        player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 5000, 10));
                }
        }
     }
    @EventHandler
    public void onClickEvent(InventoryClickEvent event){
    		ItemStack helmet = event.getWhoClicked().getInventory().getHelmet();
    		System.out.println(helmet);
    		World w = event.getWhoClicked().getWorld();
    		System.out.println(w);
    		if(event.getWhoClicked().getWorld().getName().equals("world_the_end")){
	    		if(helmet != null){
	    			if(helmet.getType() == Material.GLASS){
	    			}
	    		}
	    		else{
	    			event.getWhoClicked().addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 5000, 10));
	    		}
    		}
    }
    
}
