package fr.clickdroit.nouveaupl;

import fr.clickdroit.nouveaupl.Cmd.TestCmd;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        System.out.println("Le plugin vient de s'allumer");
        System.out.println("Bonjour !");

        getCommand("test").setExecutor(new TestCmd());

    }

    @Override
    public void onDisable() {

        System.out.println("Le plugin vient de s'eteindre");

    }
}
