package fr.clickdroit.nouveaupl.Cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCmd implements CommandExecutor {



    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (args.length == 1) {

                if (msg.equalsIgnoreCase("test")) {

                    if (args[0].equalsIgnoreCase(player.getName())) {

                        String test = "Salut sa fonctionne";

                        player.sendMessage(test);

                        player.setFoodLevel(10);

                        player.setHealth(1);



                    }

                }

            }

        }

        return false;
    }
}
