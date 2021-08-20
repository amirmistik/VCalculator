package me.vcalculator.vcalculator.commands;

import me.vcalculator.vcalculator.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.print.DocFlavor;

public class me implements CommandExecutor {

    private final Main main;

    public me(Main main){
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            int ptime = (int) player.getStatistic(Statistic.PLAY_ONE_MINUTE) / 20 / 60;
            int death = (int) player.getStatistic(Statistic.DEATHS);
            int pkills = (int) player.getStatistic(Statistic.PLAYER_KILLS);
            String nick = player.getName();
            if (player.getBedSpawnLocation() == null) {
                player.sendMessage(ChatColor.AQUA + "╔СТАТИСТИКА ИГРОКА " + nick + "\n║МЕСТО КРОВАТИ: У ВАС НЕТ КРОВАТИ\n║МИНУТ НА СЕРВЕРЕ: " + ptime + "\n║УБИТО ИГРОКОВ: " + pkills + "\n╚СМЕРТЕЙ: " + death);
            }else{
                player.sendMessage(ChatColor.AQUA + "╔СТАТИСТИКА ИГРОКА " + nick + "\n║МЕСТО КРОВАТИ: x " + player.getBedSpawnLocation().getX() + " y " + player.getBedSpawnLocation().getY() + " z " + player.getBedSpawnLocation().getZ() + "\n║МИНУТ НА СЕРВЕРЕ: " + ptime + "\n║УБИТО ИГРОКОВ: " + pkills + "\n╚СМЕРТЕЙ: " + death);
            }
            return true;
        } else {
            System.out.println("НЕЛЬЗЯ ИСПОЛЬЗОВАТЬ ЭТУ КОМАНДУ В КОНСОЛИ");
        }
        return false;
    }
}
