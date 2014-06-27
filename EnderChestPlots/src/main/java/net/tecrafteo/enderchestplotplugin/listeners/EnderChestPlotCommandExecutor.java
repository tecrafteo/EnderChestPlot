package net.tecrafteo.enderchestplotplugin.listeners;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.tecrafteo.enderchestplotplugin.main.EnderChestPlot;

public class EnderChestPlotCommandExecutor implements CommandExecutor {
	
	EnderChestPlot plugin;
	
	public EnderChestPlotCommandExecutor(EnderChestPlot plugin) {
		this.plugin = plugin;
	}

	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel,
			String[] args) {
		if (commandLabel.equals("cubo")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (args.length == 0) {
					plugin.m.sendMessage(player, "/cubo <ID de bloque>");
				} else if (args.length == 1) {
					try {
						int id = Integer.parseInt(args[0]);
						plugin.ID = id;
						if (plugin.l1 != null && plugin.l2 != null) {
							plugin.cgp.generateCube(player, plugin.l1, plugin.l2);
							plugin.l1 = null;
							plugin.l2 = null;
							
						} else {
							plugin.m.sendMessage(player, "Seleccione 2 puntos primero");
							
						}
					} catch (Exception e) {
						plugin.m.sendMessage(player, "ID inválido!");
					}
					
				} else {
					plugin.m.sendMessage(player, "/cubo <ID de bloque>");
				}
			} else {
				plugin.m.sendConsole("Debes ser un player para generar un cubo");
				
			}
		} else if (commandLabel.equalsIgnoreCase("proteger")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (args.length != 0) {
					plugin.m.sendMessage(player, "/proteger");
				} else {
					try {
						plugin.cgp.protectArea(player, plugin.l1, plugin.l2);
						plugin.m.sendMessage(player, "Area Protegida!");
						plugin.l1 = null;
						plugin.l2 = null;
					} catch (Exception e) {
						plugin.m.sendMessage(player, "EnderChestPlot falló al intentar proteger area!");
						
					}
				}
			}
		} else {
			plugin.m.sendConsole("Debes ser un player para generar un cubo");
		}
		return false;
	}
	
	

}
