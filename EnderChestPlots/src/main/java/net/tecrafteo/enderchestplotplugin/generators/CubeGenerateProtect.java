package net.tecrafteo.enderchestplotplugin.generators;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import net.tecrafteo.enderchestplotplugin.main.EnderChestPlot;

public class CubeGenerateProtect {

	EnderChestPlot plugin;

	public CubeGenerateProtect(EnderChestPlot plugin) {
		this.plugin = plugin;
	}

	int blockCounter = 0;

	@SuppressWarnings("deprecation")
	public void generateCube(Player player, Location l1, Location l2) {
		int minX, maxX, minY, maxY, minZ, maxZ;

		if (l1.getBlockX() < l2.getBlockX()) {
			minX = l1.getBlockX();
			maxX = l2.getBlockX();
		} else {
			minX = l2.getBlockX();
			maxX = l1.getBlockX();
		}
		if (l1.getBlockY() < l2.getBlockY()) {
			minY = l1.getBlockY();
			maxY = l2.getBlockY();
		} else {
			minY = l2.getBlockY();
			maxY = l1.getBlockY();
		}
		if (l1.getBlockZ() < l2.getBlockZ()) {
			minZ = l1.getBlockZ();
			maxZ = l2.getBlockZ();
		} else {
			minZ = l2.getBlockZ();
			maxZ = l1.getBlockZ();
		}

		for (int x = minX; x <= maxX; x++) {
			for (int y = minY; y <= maxY; y++) {
				for (int z = minZ; z <= maxZ; z++) {
					Location location = new Location(player.getWorld(), x, y, z);
					location.getBlock().setTypeId(plugin.ID);
					blockCounter++;
				}

			}

		}

		String s = Material.getMaterial(plugin.ID).name();
		plugin.m.capitaliseFirstLetter(s);
		plugin.m.sendMessage(player, blockCounter
				+ " Bloques fueron cambiados a " + s + "!");
		blockCounter = 0;
	}
	
	@SuppressWarnings("deprecation")
	public void protectArea(Player player, Location l1, Location l2) {
		int minX, maxX, minY, maxY, minZ, maxZ;

		if (l1.getBlockX() < l2.getBlockX()) {
			minX = l1.getBlockX();
			maxX = l2.getBlockX();
		} else {
			minX = l2.getBlockX();
			maxX = l1.getBlockX();
		}
		if (l1.getBlockY() < l2.getBlockY()) {
			minY = l1.getBlockY();
			maxY = l2.getBlockY();
		} else {
			minY = l2.getBlockY();
			maxY = l1.getBlockY();
		}
		if (l1.getBlockZ() < l2.getBlockZ()) {
			minZ = l1.getBlockZ();
			maxZ = l2.getBlockZ();
		} else {
			minZ = l2.getBlockZ();
			maxZ = l1.getBlockZ();
		}

		for (int x = minX; x <= maxX; x++) {
			for (int y = minY; y <= maxY; y++) {
				for (int z = minZ; z <= maxZ; z++) {
					Location location = new Location(player.getWorld(), x, y, z);
					plugin.protectedBlocks.add(location);
					//location.getBlock().setTypeId(plugin.ID);
					blockCounter++;
				}
			}
		}
		
		String s = Material.getMaterial(plugin.ID).name();
		plugin.m.capitaliseFirstLetter(s);
		plugin.m.sendMessage(player, blockCounter
				+ " Bloques fueron protegidos!");
		blockCounter = 0;
	}

	

}
