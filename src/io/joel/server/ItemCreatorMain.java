package io.joel.server;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;


public class ItemCreatorMain extends JavaPlugin {

    public static ItemCreatorMain instance;

    private void createConfig() {
        try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdirs();
            }
            File file = new File(getDataFolder(), "config.yml");
            if (!file.exists()) {
                getLogger().info("Config.yml not found, creating!");
                saveDefaultConfig();
            } else {
                getLogger().info("Config.yml found, loading!");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    @Override
    public void onEnable(){
        createConfig();
        instance = this;
        getServer().getPluginManager().registerEvents(new MyListener(), this);
    }
}
