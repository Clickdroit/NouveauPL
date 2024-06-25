package fr.clickdroit.nouveaupl;

import fr.clickdroit.nouveaupl.Cmd.HubCommand;
import fr.clickdroit.nouveaupl.Cmd.TestCmd;
import fr.clickdroit.nouveaupl.Cmd.TlCommand;
import fr.clickdroit.nouveaupl.Event.Evenement;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;


    public HubCommand hubCommand;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();

        System.out.println("Le plugin vient de s'allumer");
        System.out.println("Bonjour !");

        //Pour les commandes
        getCommand("test").setExecutor(new TestCmd());
        getCommand("teleportation").setExecutor(new TestCmd());
        this.hubCommand = new HubCommand();
        getServer().getPluginCommand("hub").setExecutor(new HubCommand());
        getServer().getPluginCommand("tl").setExecutor(new TlCommand());

        //Pour envoyer un message au joueurs
        getServer().getPluginManager().registerEvents(new Evenement(),this);

    }

    @Override
    public void onDisable() {

        System.out.println("Le plugin vient de s'eteindre");

    }

}
