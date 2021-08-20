package me.vcalculator.vcalculator.commands;

import me.vcalculator.vcalculator.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearCommands implements CommandExecutor {
    private final Main main;

    public ClearCommands(Main main){
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if(args.length != 1){
                return false;
            }
            String task = args[0];
            System.out.println(task);
            if(task.contains("+")){
                double first = Integer.parseInt(task.split("\\+")[0]);
                double second = Integer.parseInt(task.split("\\+")[1]);
                player.sendMessage(task + " = " + (first + second));
                return true;
            }
            else if(task.contains("-")){
                double first = Integer.parseInt(task.split("-")[0]);
                double second = Integer.parseInt(task.split("-")[1]);
                player.sendMessage(task + " = " + (first - second));
                return true;
            }
            else if(task.contains("*")){
                double first = Integer.parseInt(task.split("\\*")[0]);
                double second = Integer.parseInt(task.split("\\*")[1]);
                player.sendMessage(task + " = " + (first * second));
                return true;
            }
            else if(task.contains("/")){
                double first = Integer.parseInt(task.split("/")[0]);
                double second = Integer.parseInt(task.split("/")[1]);
                player.sendMessage(task + " = " + (first / second));
                return true;
            }
            else if(task.contains("^")){
                double first = Integer.parseInt(task.split("\\^")[0]);
                double second = Integer.parseInt(task.split("\\^")[1]);
                player.sendMessage(task + " = " + Math.pow(first,second));
                return true;
            }
            else if(task.contains("help")){
                player.sendMessage(ChatColor.GOLD + "Примеры команд\n| + - плюс\n| - - минус\n| * - умножение\n| / - деление\n| ^ - возведение в степень\n| help - показывает это сообщение\n| формат команды /calc <task>\n| пример команды /calc 15-5");
                return true;
            }
            else {
                return false;
            }
        }
        else {
            main.getLogger().info("Калькулятор не работает в консоли");
        }
        return false;
    }
}