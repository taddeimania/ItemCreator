package io.joel.server;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;


public class MyListener implements Listener {

    private void refillInventory(Player player) {
        ItemCreator creator = new ItemCreator();
        player.getInventory().clear();
        // get items from registry rather than load by default
        creator.createItems(player.getInventory());
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        refillInventory(event.getPlayer());
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        //refillInventory(event.getPlayer());
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Bukkit.broadcastMessage("USED ITEM SOME WAY!");
    }

    @EventHandler
    public void onPlayerEntityInteract(PlayerInteractEntityEvent event) {
        Bukkit.broadcastMessage("USED ITEM SOME WAY!");
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        refillInventory(event.getPlayer());
    }
}
