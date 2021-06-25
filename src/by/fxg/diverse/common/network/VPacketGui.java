package by.fxg.diverse.common.network;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

import by.fxg.diverse.Viod;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;

public class VPacketGui extends VPacket {
	private int iDGui;

	public VPacketGui(int iDGui) {
		this.iDGui = iDGui;
	}

	public VPacketGui() {
	}

	public void writeData(ByteArrayDataOutput out) {
		out.writeInt(this.iDGui);
	}

	public void readData(ByteArrayDataInput in) throws VPacket.ProtocolException {
		this.iDGui = in.readInt();
	}

	public void onPacket(EntityPlayer player, Side side) throws VPacket.ProtocolException {
		if (!player.worldObj.isRemote) {
			Viod.proxy.openExtGui(this.iDGui, player);
		}
	}
}
