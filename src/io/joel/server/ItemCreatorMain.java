package io.joel.server;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;


public class ItemCreatorMain extends JavaPlugin {

    public static ItemCreatorMain instance;
    public static ItemRegistry itemRegistry;

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
        itemRegistry = new ItemRegistry();
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("ic")) {
            if (args[0].equalsIgnoreCase("spawn")){
                String item_id = args[1];
                Player player = (Player)sender;
                Inventory playerInventory = player.getInventory();
                ItemStack toSpawnItem = itemRegistry.get(item_id);
                playerInventory.setItem(playerInventory.firstEmpty(), toSpawnItem);
                return true;
            }
        }
        return false;
    }
}
