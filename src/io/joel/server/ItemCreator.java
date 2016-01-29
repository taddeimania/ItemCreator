package io.joel.server;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemCreator {

   private void setItemLore(Map map, ItemStack anonItem) {
      ItemMeta meta = anonItem.getItemMeta();
      meta.setDisplayName(map.get("name").toString());
      {
         List<String> lore = new ArrayList<>();
         List<String> inputLore = (List)map.get("lore");
         inputLore.forEach(loreItem->lore.add(loreItem));
         meta.setLore(lore);
      }
      anonItem.setItemMeta(meta);
   }

   private void setItemEnchantments(Map map, ItemStack anonItem) {
      if (map.containsKey("enchantments")) {
         List customEnchantments = (List)map.get("enchantments");
         customEnchantments.forEach(enchantment->{
            Map enchantmentMap = (Map)enchantment;

            Enchantment enchantmentName = Enchantment.getByName(enchantmentMap.get("name").toString());
            int enchantmentLevel;
            if (enchantmentMap.containsKey("level")) {
               enchantmentLevel = Math.abs((int)enchantmentMap.get("level"));
            } else {
               enchantmentLevel = enchantmentName.getStartLevel();
            }

            boolean canEnchant = enchantmentName.canEnchantItem(anonItem);
            if (canEnchant) {
               boolean validLevel = enchantmentLevel <= enchantmentName.getMaxLevel()
                       && enchantmentLevel >= enchantmentName.getStartLevel();
               if (!validLevel)
                  enchantmentLevel = enchantmentName.getStartLevel();
               anonItem.addEnchantment(enchantmentName, enchantmentLevel);
            }
         });
      }
   }

   private void setItemAmount(Map map, ItemStack anonItem) {
      if (map.containsKey("stack_size")) {
         int stackSize = (int) map.get("stack_size");
         anonItem.setAmount(Math.abs(stackSize));
      } else {
         anonItem.setAmount(1);
      }
   }

   public Map<String, ItemStack> createItems() {
      Map<String, ItemStack> itemRegistry = new HashMap<>();
      List customItems = ItemCreatorMain.instance.getConfig().getMapList("items");
      customItems.forEach(iterItem->{
         Map map = (Map)iterItem;
         ItemStack anonItem = new ItemStack(Material.getMaterial(map.get("material").toString()), 1);
         setItemLore(map, anonItem);
         setItemEnchantments(map, anonItem);
         setItemAmount(map, anonItem);
         itemRegistry.put(map.get("item_id").toString(), anonItem);
      });
      return itemRegistry;
   }
}
