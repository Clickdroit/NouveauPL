package fr.clickdroit.nouveaupl;

import fr.clickdroit.nouveaupl.Cmd.CoordsCommand;
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
        System.out.println("Le plugin vient de s'allumer");
        System.out.println("Bonjour !");

        //Pour les commandes
        getCommand("test").setExecutor(new TestCmd());
        getCommand("teleportation").setExecutor(new TestCmd());
        this.hubCommand = new HubCommand();
        getServer().getPluginCommand("hub").setExecutor(new HubCommand());
        getServer().getPluginCommand("tl").setExecutor(new TlCommand());
        getServer().getPluginCommand("coords").setExecutor(new CoordsCommand());

        //Pour envoyer un message au joueurs
        getServer().getPluginManager().registerEvents(new Evenement(),this);
        getServer().getPluginManager().registerEvents(new Teams(),this);

        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    @Override
    public void onDisable() {

        System.out.println("Le plugin vient de s'eteindre");

    }

    public static Main getInstance() {

        return instance;
    }

}
