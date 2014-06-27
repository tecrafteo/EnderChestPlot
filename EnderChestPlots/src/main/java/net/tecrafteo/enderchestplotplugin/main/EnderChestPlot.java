package net.tecrafteo.enderchestplotplugin.main;

import java.util.ArrayList;
import java.util.logging.Logger;





import net.tecrafteo.enderchestplotplugin.generators.CubeGenerateProtect;
import net.tecrafteo.enderchestplotplugin.listeners.EnderChestPlotCommandExecutor;
import net.tecrafteo.enderchestplotplugin.listeners.EnderChestPlotListener;
import org.bukkit.Location;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public final class EnderChestPlot extends JavaPlugin {
	public final Logger logger = Logger.getLogger("Minecraft");
	public final EnderChestPlotListener ecpl = new EnderChestPlotListener(this);
	public final CubeGenerateProtect cgp = new CubeGenerateProtect(this);
	public final Methods m = new Methods();
	public final EnderChestPlotCommandExecutor ce = new EnderChestPlotCommandExecutor(this);
	public ArrayList<Location> protectedBlocks = new ArrayList<Location>();
	
	
	public Location l1 = null;
	public Location l2 = null;
	
	public int ID = 0;
	
	//public final HashMap<Player, ArrayList<Block>> hashmap = new HashMap<Player, ArrayList<Block>>();
	
	@Override
	public void onEnable() {
		//cuando el plugin se activa...
		PluginManager pm = getServer().getPluginManager();
		PluginDescriptionFile pdfFile = this.getDescription();
		
		getCommand("cubo").setExecutor(ce);
		getCommand("proteger").setExecutor(ce);
		
		this.logger.info("[EnderChestPlot] " + pdfFile.getName() + " Version " + pdfFile.getVersion() + " --> Se ha habilitado." );
		this.logger.info("[EnderChestPlot]  --> Plugin creado por " + pdfFile.getAuthors());
		this.logger.info("[EnderChestPlot]  --> Servidor oficial TeCrafteo.net");
		pm.registerEvents(ecpl, this);
	}
	
	@Override
	public void onDisable() {
		//cuando el plugin se desactiva...
		getLogger().info("onDisable");
		
	}

}
