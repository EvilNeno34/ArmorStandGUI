package me.kiernan.armorstandgui.commands;

import me.kiernan.armorstandgui.ArmorStandGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ArmorStandCommand implements CommandExecutor {

    ArmorStandGUI plugin;

    public ArmorStandCommand(ArmorStandGUI plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            plugin.openMenu(player);
        }


        return true;
    }
}
