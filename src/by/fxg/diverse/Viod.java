package by.fxg.diverse;

import by.fxg.diverse.client.ClientManager;
import by.fxg.diverse.common.CommonManager;
import by.fxg.diverse.common.ServerProxy;
import by.fxg.diverse.common.UtilLoader;
import by.fxg.diverse.common.block.BlockRegistry;
import by.fxg.diverse.common.item.ItemRegistry;
import by.fxg.diverse.common.network.PacketHandler;
import by.fxg.diverse.util.FakePlayerFactory;
import by.fxg.diverse.util.Utils;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "Viod", name = "Viod", version = "0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = {"voidpak", "voidspec"}, packetHandler = PacketHandler.class)
public class Viod {
	@Instance("Viod")
	public static Viod instance;
	
	@SidedProxy(clientSide = "by.fxg.diverse.client.ClientProxy", serverSide = "by.fxg.diverse.common.ServerProxy")
	public static ServerProxy proxy;
	
	public static BlockRegistry blocks;
	public static ItemRegistry items;
	public static UtilLoader utilLoader;
	public static CommonManager commonManager;
	
	public static ClientManager clientManager;
	public static FakePlayerFactory fakePlayerFactory;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		this.items = new ItemRegistry().init();
		this.blocks = new BlockRegistry().init();
		this.utilLoader = new UtilLoader().init();
		this.commonManager = new CommonManager().init();
		
		if (Utils.isClient()) {
			this.clientManager = new ClientManager().init();
			this.fakePlayerFactory = new FakePlayerFactory();
		}
		proxy.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		this.items.post();
	}
	
	@EventHandler
	public void serverStarting(FMLServerStartingEvent e) {
		this.commonManager.commandManager.init(e);
	}
}
