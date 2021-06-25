package by.fxg.diverse.common.network;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

import by.fxg.diverse.Viod;
import by.fxg.diverse.common.storage.ServerKit;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;

public class VSPacketKits extends VSPacket {
	private ServerKit[] kits;

	public VSPacketKits(int iDGui) {

	}

	public VSPacketKits() {
	}

	public void writeData(ByteArrayDataOutput out) {

	}

	public void readData(ByteArrayDataInput in) throws VSPacket.ProtocolException {

	}

	public void onPacket(EntityPlayer player, Side side) throws VSPacket.ProtocolException {
		//kits
	}
}
