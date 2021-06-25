package by.fxg.diverse.common;

import by.fxg.diverse.Viod;
import by.fxg.diverse.common.command.CommandManager;
import by.fxg.diverse.common.world.OreGenerator;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.MinecraftForge;

public class CommonManager {
	public GuiHandler guiHandler;
	public CommonEventHandler commonEventHandler;
	public CommandManager commandManager;
	public OreGenerator commonOreGenerator;
	
	public CommonManager init() {
		this.commandManager = new CommandManager();
		NetworkRegistry.instance().registerGuiHandler(Viod.instance, this.guiHandler = new GuiHandler());
		MinecraftForge.EVENT_BUS.register(this.commonEventHandler = new CommonEventHandler());
		GameRegistry.registerWorldGenerator(this.commonOreGenerator = new OreGenerator());
		return this;
	}
}
