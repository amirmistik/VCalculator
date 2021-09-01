package me.vcalculator.vcalculator.commands;

import me.vcalculator.vcalculator.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class End implements CommandExecutor {

    private final Main main;

    public End(Main main){
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            try {
                Player player = (Player) sender;

                float x = Float.parseFloat(args[0]);
                float z = Float.parseFloat(args[1]);
                double f = Math.tan(Math.toRadians(Float.parseFloat(args[2]) + 90));

                float x1 = Float.parseFloat(args[3]);
                float z1 = Float.parseFloat(args[4]);
                double f1 = Math.tan(Math.toRadians(Float.parseFloat(args[5]) + 90));

                float n1 = (float) (z - (f * x));
                float n2 = (float) (z1 - (f1 * x1));

                int end_x = (int) ((n2 - n1) / (f - f1));
                int end_z = (int) (f * end_x + n1);
                player.sendMessage("КООРДИНАТЫ КРЕПОСТИ\nX: " + end_x + "\nZ: " + end_z);
                return true;
            } catch (Exception e){
                return false;
            }
        } else {
            System.out.println("Команда не работает в консоли");
        }
        return false;
    }
}
