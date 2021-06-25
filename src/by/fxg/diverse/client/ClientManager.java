package by.fxg.diverse.client;

import api.player.model.ModelPlayerAPI;
import by.fxg.diverse.client.storage.ClientWikiDatabase;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraftforge.common.MinecraftForge;

public class ClientManager {
	public static boolean gameStarted = false;
	public ClientHelper clientHelper;
	public ClientWikiDatabase clientWikiDatabase;
	public ClientKeyboard clientKeyboard;
	public ClientEventHandler clientEventHandler;
	public ClientTickHandler clientTickHandler;
	
	public ClientManager init() {
		this.clientWikiDatabase = new ClientWikiDatabase().init();
		this.clientHelper = new ClientHelper().init();
		KeyBindingRegistry.registerKeyBinding(this.clientKeyboard = new ClientKeyboard());
		MinecraftForge.EVENT_BUS.register(this.clientEventHandler = new ClientEventHandler());
		ModelPlayerAPI.register("ViodModelManager", VRenderPlayerModel.class);
		TickRegistry.registerTickHandler(this.clientTickHandler = new ClientTickHandler(), Side.CLIENT);
		return this;
	}
}
