package by.fxg.diverse.common;

import by.fxg.diverse.Viod;
import by.fxg.diverse.common.network.VPacketGui;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import net.minecraft.entity.player.EntityPlayer;

public class ServerProxy {
	public void init() {
		
	}
	
	public void openCustomGui(int var1, EntityPlayer var2) {
		var2.openGui(Viod.instance, var1, var2.worldObj, (int)var2.posX, (int)var2.posY, (int)var2.posZ);
	}
	
	public void openExtGui(int var1, EntityPlayer var2) {
		var2.closeScreen();
		if (var1 >= 249 && var1 <= 350) {
			var2.openGui(Viod.instance, var1, var2.worldObj, (int)var2.posX, (int)var2.posY, (int)var2.posZ);
		}
		//PacketDispatcher.sendPacketToPlayer((new VPacketGui(var1)).makePacket(), (Player)var2);
	}
}
