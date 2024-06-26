package fr.clickdroit.nouveaupl;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static org.bukkit.Material.WOOL;

public class Teams implements Listener {
    @EventHandler
    public void onJoin (PlayerJoinEvent event){
        Player player = event.getPlayer();

        ItemStack Team = new ItemStack(WOOL,1);
        ItemMeta Teamm = Team.getItemMeta();
        Teamm.setDisplayName("§l§8Team");
        Team.setItemMeta(Teamm);

        player.getInventory().setItem(3,Team);

    }

    @EventHandler
    public void onInterract (PlayerInteractEvent event){

        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack it = event.getItem();

        if(it != null && it.getType() == Material.WOOL){
            if (action == Action.RIGHT_CLICK_AIR){
                Inventory inv = Bukkit.createInventory(null,45, "Team");
                ItemStack wool = new ItemStack(Material.WOOL,1);
                ItemMeta woolM = wool.getItemMeta();
                woolM.setDisplayName("§lTeam Blanche");
                wool.setItemMeta(woolM);
                inv.setItem(0,getItem(Material.WOOL,"§lBlanc"));

                player.openInventory(inv);
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


