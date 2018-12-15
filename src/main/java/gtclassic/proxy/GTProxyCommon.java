package gtclassic.proxy;

import java.io.File;

import gtclassic.GTBiomes;
import gtclassic.GTConfig;
import gtclassic.GTDimensions;
import gtclassic.util.GTBlocks;
import gtclassic.util.GTItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class GTProxyCommon {

	// config instance
	public static Configuration config;

	// create config on pre load
	public void preInit(FMLPreInitializationEvent e) {
		File directory = e.getModConfigurationDirectory();
		config = new Configuration(new File(directory.getPath(), "ic2/gtclassic.cfg"));
		GTConfig.readConfig();
		config.save();
		GTDimensions.init();
		MinecraftForge.EVENT_BUS.register(GTBlocks.class);
		GTBlocks.registerTiles();
		MinecraftForge.EVENT_BUS.register(GTItems.class);
	}

	public void init(FMLInitializationEvent e) {
		GTBiomes.init();
		GTBiomes.initBiomeDict();
	}

	public void postInit(FMLPostInitializationEvent e) {
		// temporarily empty post init method
	}
}
