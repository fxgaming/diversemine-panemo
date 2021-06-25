package by.fxg.diverse.client;

import java.lang.reflect.Field;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

import by.fxg.diverse.Viod;
import by.fxg.diverse.client.gui.GuiButtonExtended;
import by.fxg.diverse.client.storage.ClientData;
import by.fxg.diverse.common.network.VPacketClientData;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;

public class ClientTickHandler implements ITickHandler {
	public int tick = 0;
	public final String[] getGuiLeft = new String[] {"field_74198_m", "guiLeft"};
	public final String[] getGuiTop = new String[] {"field_74197_n", "guiTop"};
	public final String[] mapFieldsGuiScreen = ObfuscationReflectionHelper.remapFieldNames(GuiScreen.class.getSimpleName(), new String[] {"buttonList", "i"});

	private int getGuiLeft(GuiInventory clazz) {
		return (Integer)ObfuscationReflectionHelper.getPrivateValue(GuiContainer.class, clazz, this.getGuiLeft);
	}

	private int getGuiTop(GuiInventory clazz) {
		return (Integer)ObfuscationReflectionHelper.getPrivateValue(GuiContainer.class, clazz, this.getGuiTop);
	}

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		try {
			Viod.clientManager.clientHelper.updateHelper();
			GuiScreen screen = Minecraft.getMinecraft().currentScreen;
			if (screen != null && screen instanceof GuiInventory) {
				Field field = ReflectionHelper.findField(GuiScreen.class, (String[]) ObfuscationReflectionHelper.remapFieldNames(GuiScreen.class.getName(), (String[]) (new String[] {"buttonList", "i", "field_73887_h"})));
				field.setAccessible(true);
				List buttonList = (List)field.get(screen);
				boolean bool = true;
				Iterator iterator = buttonList.iterator();
				while (iterator.hasNext()) {
					Object buttonIterator = iterator.next();
					if (buttonIterator instanceof GuiButtonExtended) {
						bool = false;
						break;
					}
				}
				if (bool) {
					int guiLeft = this.getGuiLeft((GuiInventory) screen);
					int guiTop = this.getGuiTop((GuiInventory) screen);
					GuiButtonExtended button = new GuiButtonExtended(100, guiLeft, guiTop - 22, 250);
					buttonList.add(button);
				}
			}
		} catch (Exception var1) {
			var1.printStackTrace();
		}
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		this.tick++;
		if (this.tick % 100 == 0) {
			this.tick = 0;
			if (Minecraft.getMinecraft().thePlayer != null) {
				PacketDispatcher.sendPacketToServer(new VPacketClientData.request(Minecraft.getMinecraft().thePlayer.entityId).makePacket());
			}
		}
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.CLIENT, TickType.PLAYER, TickType.RENDER);
	}

	@Override
	public String getLabel() {
		return "ClientTickHandlerViod";
	}

}
