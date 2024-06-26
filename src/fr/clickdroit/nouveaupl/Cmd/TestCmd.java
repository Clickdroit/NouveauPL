package fr.clickdroit.nouveaupl.Cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (msg.equalsIgnoreCase("test")) {

                if (args.length == 1) {

                    if (args[0].equalsIgnoreCase(player.getName())) {

                        String test = "Salut ça fonctionne";

                        player.sendMessage(test);

                        player.setFoodLevel(20);

                        player.setHealth(20);
                    }
                }

            } else if (msg.equalsIgnoreCase("teleportation")) {

                if (args.length == 1) {

                    Player p = Bukkit.getPlayer(args[0]);

                    if (p != null){

                        if (p != player) {

                            player.teleport(p);

                        } else {

                            player.sendMessage("§cMinecraft | Tu ne peux pas te téléporter a toi-même");
                        }
                    } else {

                        player.sendMessage("§cMinecraft | Le joueur n'existe pas ou n'est pas en ligne");
                    }
                } else if (args.length == 2) {

                    Player target1 = Bukkit.getPlayer(args[0]);
                    Player target2 = Bukkit.getPlayer(args[1]);

                    target1.teleport(target2);

                } else {

                    player.sendMessage("§cMinecraft | La commande est incorrecte ou mal écrite.");
                }
            }
        }

        return false;
    }

}