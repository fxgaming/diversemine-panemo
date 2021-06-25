package by.fxg.diverse.common.command;

import by.fxg.diverse.Switch;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class CommandManager {
	public void init(FMLServerStartingEvent e) {
		if (!Switch.isClient) e.registerServerCommand(new CommandDebug());
		e.registerServerCommand(new CommandAdmin());
		e.registerServerCommand(new CommandPortalEditor());
		e.registerServerCommand(new CommandNBT());
	}
}
