package fr.clickdroit.nouveaupl.Event;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.swing.*;
import java.util.Arrays;

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

        player.getInventory().setItemInHand(customsword);

        ItemStack customwool = new ItemStack(Material.WOOL, 8, (byte)14);
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

    }

}