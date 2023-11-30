package me.keills.grenades;

import me.keills.grenades.listeners.GrenadeListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class GrenadesPlugin extends JavaPlugin {

    private static GrenadesPlugin instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        getServer().getPluginManager().registerEvents(new GrenadeListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static GrenadesPlugin getPlugin(){
        return instance;
    }
}
