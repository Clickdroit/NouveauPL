package fr.clickdroit.nouveaupl.Cmd;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HubCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;
            Location spawn = new Location(player.getWorld(), 244.511, 130, -156.448, 0f, 0f);
            player.sendMessage("Bienvenue au hub");
            player.teleport(spawn);
        }

        return false;
    }
}
