package fr.clickdroit.nouveaupl.Cmd;

import fr.clickdroit.nouveaupl.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CoordsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            int x = (int) player.getLocation().getX();
            int y = (int) player.getLocation().getY();
            int z = (int) player.getLocation().getZ();
            player.sendMessage(player.getName() + " §8» §b X=" + x + "§b/ Y=" + y + "§b/ Z=" + z);
            return true;
        } else {
            sender.sendMessage(Main.getInstance().getConfig().getString("messages"));

        }
        return false;
    }

}