package me.Codmikeg.endhelmet;
 
 
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
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
		            helmetCheck.checkHelmet(player);
	        	}        
	        }
        }, 20);
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(player.hasPlayedBefore() == true){
        	if(player.getGameMode() == GameMode.CREATIVE){
        	}
        	else{
		        if(player.getWorld().getName().equals("world_the_end")){
		        	helmetCheck.checkHelmet(player);
		        }
        	}
        } 
        else{
        	player.getInventory().setHelmet(new ItemStack(Material.GLASS, 1));
        	
        }
    }
    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event){
        Entity e = event.getEntity();
        if(e instanceof Player){
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
	        if(event.getCause() == EntityDamageEvent.DamageCause.DROWNING){
	        	Bukkit.broadcastMessage("FUUUCK");
	        	if(helmet != null && helmet.getType() != Material.AIR){
	        		Bukkit.broadcastMessage("HELMET ON NOT GLASSS");
		            if(helmet.getType() == Material.GLASS){
		            	Bukkit.broadcastMessage("CANCELLING EVENT");
		                event.setCancelled(true);
		               
		            }
		            else{
			        	Bukkit.broadcastMessage("KILL THE FUCKER");
		            }
	        	}
	        }
	    }
    }

        
           
    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent event){
    	Player player = event.getPlayer();
    	if(player.getWorld().getName().equals("world") || player.getWorld().getName().equals("world_nether")){
    		if(player.hasPotionEffect(PotionEffectType.WITHER)){
    			player.removePotionEffect(PotionEffectType.WITHER);
    		}
    	}
    	else{
	        if(player.getWorld().getName().equals("world_the_end")){
	        	helmetCheck.checkHelmet(player);
	        }
    	}
    }
    @EventHandler
    public void onClickEvent(InventoryClickEvent event){
    	HumanEntity player = event.getWhoClicked();
    	if(event.getWhoClicked().getGameMode() == GameMode.CREATIVE){}  		
    	else{
    		helmetCheck.checkHelmetClick(player);
    	}
    }
    @EventHandler
    public void onAirClick(PlayerInteractEvent event){
    	final Player player = event.getPlayer();
    	ItemStack helmet = player.getInventory().getHelmet();
    	if(player.getItemInHand().getType() == Material.GLASS){
    		player.sendMessage("penis");
    		if(event.getAction() == Action.RIGHT_CLICK_AIR){
    			player.sendMessage("1");
    			if(helmet != null && helmet.getType() != Material.AIR){
    				player.sendMessage("Failed to apply helmet. You already have something on your head!");
    			}
    			else{
    				player.sendMessage("2");
	    			if(helmet != null && helmet.getType() != Material.AIR){
	    				player.sendMessage("Faggots");
	    			}
	    			else{
	    				player.sendMessage("MORE FAGGOTS");
	    				player.getInventory().getItemInHand().setAmount(player.getInventory().getItemInHand().getAmount()-1);
						if(player.getInventory().getItemInHand().getAmount() == 1){
							player.getInventory().removeItem(player.getItemInHand());
						}
						Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					        public void run() {
					        	player.getInventory().setHelmet(new ItemStack(Material.GLASS, 1));        
					        }
				        }, 5);
	    			}	
				}
    		}
    	}
    }
   
    
    @EventHandler
    public void onGamemodeChange(PlayerGameModeChangeEvent event){
    	Player player = event.getPlayer();
    	if(event.getNewGameMode() == GameMode.CREATIVE || event.getNewGameMode() == GameMode.ADVENTURE){
    		if(player.hasPotionEffect(PotionEffectType.WITHER)){
    			player.removePotionEffect(PotionEffectType.WITHER);
    		}
    	}
    	else{
	        if(player.getWorld().getName().equals("world_the_end")){
	        	helmetCheck.checkHelmet(player);
	        }
    	}
    }

}
