package me.keills.grenades.listeners;

import me.keills.grenades.GrenadesPlugin;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

// отвечает за всю логику гранат
public class GrenadeListener implements Listener {
    @EventHandler
    public void onGrenadeThrown(ProjectileLaunchEvent e){
        Entity entity = e.getEntity();

        if(!entity.getType().equals(Material.SNOWBALL))
            return;
    }

    @EventHandler
    public void onGrenadeHit(ProjectileHitEvent e){
        Entity entity = e.getEntity();

        if(!entity.getType().equals(EntityType.EGG))
            return;

        Location hitLocation = entity.getLocation();
        ItemStack itemStack = new ItemStack(Material.TNT);

        Item visual = hitLocation.getWorld().dropItem(hitLocation,itemStack);
        visual.setCanMobPickup(false);
        visual.setCanPlayerPickup(false);

        new BukkitRunnable(){
            @Override
            public void run(){
                visual.remove();
                visual.getLocation().createExplosion(3);
            }
        }.runTaskLater(GrenadesPlugin.getPlugin(),40);
    }
}
