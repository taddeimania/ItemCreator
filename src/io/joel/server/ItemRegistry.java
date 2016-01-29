package io.joel.server;

import org.bukkit.inventory.ItemStack;

import java.util.Map;


public class ItemRegistry {
    public Map<String, ItemStack> items;

    public ItemRegistry() {
        ItemCreator creator = new ItemCreator();
        items = creator.createItems();
    }

    public ItemStack get(String item_id) {
        return items.get(item_id);
    }
}
