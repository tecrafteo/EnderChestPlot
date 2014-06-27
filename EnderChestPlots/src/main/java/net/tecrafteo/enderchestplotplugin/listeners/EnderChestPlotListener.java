package net.tecrafteo.enderchestplotplugin.listeners;

import net.tecrafteo.enderchestplotplugin.main.EnderChestPlot;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class EnderChestPlotListener implements Listener{
	
	EnderChestPlot plugin;
	
	public EnderChestPlotListener(EnderChestPlot instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if(event.getAction()==Action.LEFT_CLICK_BLOCK && event.getPlayer().getItemInHand().getType()==Material.BONE) {
			try {
				plugin.l1 = event.getClickedBlock().getLocation();
				plugin.m.sendMessage(player, "Posición 1: " + plugin.m.showBlockCoords(plugin.l1));
				event.setCancelled(true);
				
			} catch (Exception e) {
				plugin.m.sendMessage(player, "EnderChestPlot no pudo crear la marca");
				plugin.m.sendConsole("Se ha producido una excepcion: " + e);
			}
		}
		
		if(event.getAction()==Action.RIGHT_CLICK_BLOCK && event.getPlayer().getItemInHand().getType()==Material.BONE) {
			try {
				plugin.l2 = event.getClickedBlock().getLocation();
				plugin.m.sendMessage(player, "Posición 2: " + plugin.m.showBlockCoords(plugin.l2));
				event.setCancelled(true);
				
			} catch (Exception e) {
				plugin.m.sendMessage(player, "EnderChestPlot no pudo crear la marca");
				plugin.m.sendConsole("Se ha producido una excepcion: " + e);
			}
		}
		
		if(plugin.protectedBlocks.contains(event.getClickedBlock().getLocation())) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		if (plugin.protectedBlocks.contains(event.getBlock())) {
			event.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		if (plugin.protectedBlocks.contains(event.getBlock())) {
			event.setCancelled(true);
		}
		
	}
	
	

}
