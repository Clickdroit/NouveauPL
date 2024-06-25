package fr.clickdroit.nouveaupl.Event;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

import static org.bukkit.Material.*;

public class Evenement implements Listener {

    @EventHandler
    public void onjoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        player.getInventory().clear();
        player.sendTitle("§cMinecraft","Bienvenue §c" + player.getName());

        ItemStack customsword = new ItemStack(Material.COMPASS, 1);
        ItemMeta customM = customsword.getItemMeta();
        customM.setDisplayName("§c Navigation");
        customM.setLore(Arrays.asList("Permet de naviguer"));
        customM.addEnchant(Enchantment.DAMAGE_ALL, 200, true);
        customM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        customsword.setItemMeta(customM);

        player.getInventory().setItem(4,customsword);

        ItemStack customwool = new ItemStack(GLASS, 1, (byte)14);
        player.getInventory().setHelmet(customwool);
        player.updateInventory();
}
    @EventHandler
    public void onInterract (PlayerInteractEvent event){

        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack it = event.getItem();

        if(it != null && it.getType() == Material.NETHER_STAR){
            if (action == Action.RIGHT_CLICK_AIR ){
                player.sendMessage("§cTu viens de faire un clic");
            }
        }
        if (it.getType() == Material.COMPASS && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§c Navigation")){
            Inventory inv = Bukkit.createInventory(null, 45,"§8 Mon coffre" );

            ItemStack glass = new ItemStack(STAINED_GLASS_PANE, 1);
            ItemMeta glassM = glass.getItemMeta();
            glassM.setDisplayName("§aPassage en gm 3");
            glass.setItemMeta(glassM);
            inv.setItem(0, glass);
            inv.setItem(1, glass);
            inv.setItem(7, glass);
            inv.setItem(8, glass);
            inv.setItem(9, glass);
            inv.setItem(17, glass);
            inv.setItem(27, glass);
            inv.setItem(35, glass);
            inv.setItem(36, glass);
            inv.setItem(37, glass);
            inv.setItem(43, glass);
            inv.setItem(44, glass);

            inv.setItem(20,getItem(EYE_OF_ENDER,"Passe en Gamemode 3"));
            inv.setItem(24,getItem(Material.TNT, "Give une TNT"));
            inv.setItem(22,getItem(Material.REDSTONE,"Mettre en Gamemode 1"));
            player.openInventory(inv);
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        Inventory inv = event.getInventory();
        Player player = (Player) event.getWhoClicked();
        ItemStack current = event.getCurrentItem();

        if (current == null) return;

        event.setCancelled(true);

        if (inv.getName().equalsIgnoreCase("§8 Mon coffre")) {

            event.setCancelled(true);
            player.closeInventory();
            switch (current.getType()) {

                case EYE_OF_ENDER:
                    player.setGameMode(GameMode.SPECTATOR);
                    break;

                case TNT:
                    player.getInventory().addItem(new ItemStack(Material.TNT, 3));
                    break;

                case REDSTONE:
                    player.setGameMode(GameMode.CREATIVE);
                    break;

                default:
                    break;
            }
        }
    }
    public ItemStack getItem(Material material, String customName){
        ItemStack it = new ItemStack(material, 1);
        ItemMeta itM = it.getItemMeta();
        if (customName != null)itM.setDisplayName(customName);
        it.setItemMeta(itM);
        return it;
    }
}