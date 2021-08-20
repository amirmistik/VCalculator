package me.vcalculator.vcalculator.commands;

import me.vcalculator.vcalculator.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class over implements CommandExecutor {

    private final Main main;

    public over(Main main){
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            int x;
            int z;
            if(args.length == 2){
                x = Integer.parseInt(args[0]);
                z = Integer.parseInt(args[1]);
            }else{
                x = (int) player.getPlayer().getLocation().getX();
                z = (int) player.getPlayer().getLocation().getZ();
            }
            player.sendMessage(ChatColor.WHITE + "КООРДИНАТЫ В ОБЫЧНОМ МИРЕ\n" + "x = " + x * 8 + "\nz = " + z * 8);
            return true;
        }
        else {
            System.out.println("команда не работает в консоли");
        }
        return false;
    }
}
