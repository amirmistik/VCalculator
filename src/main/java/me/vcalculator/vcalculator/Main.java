package me.vcalculator.vcalculator;

import me.vcalculator.vcalculator.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("MADE BY AMIRMISTIKPLAY");
        getServer().getPluginCommand("calc").setExecutor(new ClearCommands(this));
        getServer().getPluginCommand("nether").setExecutor(new nether(this));
        getServer().getPluginCommand("over").setExecutor(new over(this));
        getServer().getPluginCommand("me").setExecutor(new me(this));
        getServer().getPluginCommand("end").setExecutor(new End(this));
    }

    @Override
    public void onDisable() {
        System.out.println("MADE BY AMIRMISTIKPLAY");
        // Plugin shutdown logic
    }
}
