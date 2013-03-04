package me.Codmikeg.endhelmet;
 
 
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
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
                player.sendMessage(ChatColor.GOLD + "Hello " + player.getName() + ".");
                World w = player.getWorld();
                System.out.println(w);
              
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    public void run() {
                    	if(player.getWorld().getName().equals("world_the_end")){
                        player.sendMessage("faggot");
                        ItemStack helmet = player.getInventory().getHelmet();
                        if(helmet != null && helmet.getType() != Material.AIR){
                                if(helmet.getType() == Material.GLASS){
                                        player.sendMessage("Your helmet is made of glass");
                                        //do nothing
                                }
                                else{
                                        player.sendMessage("You have a helmet, but its not glass");
                                        player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 5000, 10));
                                        //HARM THE PLAYER... MUAHAHAHHA
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
            player.sendMessage(ChatColor.GOLD + "Hello " + player.getName() + ".");
            World w = player.getWorld();
            System.out.println(w);
            if(player.getWorld().getName().equals("world_the_end")){
                    player.sendMessage("IT WORKS");
                    player.sendMessage("OnSpawnEvent login");
                    ItemStack helmet = player.getInventory().getHelmet();
                    if(helmet != null && helmet.getType() != Material.AIR){
                            if(helmet.getType() == Material.GLASS){
                                    player.sendMessage("Your helmet is made of glass");
                                    //do nothing
                            }
                            else{
                                    player.sendMessage("You have a helmet, but its not glass");
                                    player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 5000, 10));
                            //HARM THE PLAYER... MUAHAHAHHA
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
                                    player.removePotionEffect(PotionEffectType.BLINDNESS);
                            }
                    }
            }
           
    }     
    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent event){
            Player player = event.getPlayer();
            player.sendMessage("AAAHHHH");
    } 
    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent event){
        Player player = event.getPlayer();
        //World w = player.getWorld();
        if(player.getWorld().equals(World.Environment.THE_END)){
            player.sendMessage("OnWorldChange Event");
            ItemStack helmet = player.getInventory().getHelmet();
            if(helmet != null && helmet.getType() != Material.AIR){
                    player.sendMessage(ChatColor.DARK_PURPLE + "You should be taking damage because of the world change event");
            }
           
            else {
                    player.sendMessage("blah blah blah");
                    //player.sendMessage("Woo");
            }
        }
     }
  //@EventHandler
  //public void onInventoryOpen(InventoryOpenEvent event){
    	
  //}
}
