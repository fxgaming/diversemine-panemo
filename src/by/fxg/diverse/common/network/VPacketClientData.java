package by.fxg.diverse.common.network;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;

import by.fxg.diverse.client.storage.ClientData;
import by.fxg.diverse.common.player.ExtendedPlayer;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;

public class VPacketClientData {
	public static class request extends VPacket {
		private int entityID;

		public request(int entityID) {
			this.entityID = entityID;
		}

		public request() {
		}

		public void writeData(ByteArrayDataOutput out) {
			out.writeInt(this.entityID);
		}

		public void readData(ByteArrayDataInput in) throws VPacket.ProtocolException {
			this.entityID = in.readInt();
		}

		public void onPacket(EntityPlayer player, Side side) throws VPacket.ProtocolException {
			if (side.isServer()) {
				if (player.worldObj.getEntityByID(this.entityID) != null && player.worldObj.getEntityByID(this.entityID) instanceof EntityPlayer) PacketDispatcher.sendPacketToPlayer(new VPacketClientData.reply((EntityPlayer)player.worldObj.getEntityByID(this.entityID)).makePacket(), (Player)player.worldObj.getEntityByID(this.entityID));
				else PacketDispatcher.sendPacketToPlayer(new VPacketClientData.reply(player).makePacket(), (Player)player);
			}
		}
	}
	
	public static class reply extends VPacket {
		private int entityID;
		private int[] intData = new int[4];
		private boolean[] boolData = new boolean[1];
		
		public reply(EntityPlayer p) {
			ExtendedPlayer pl = ExtendedPlayer.get(p);
			this.entityID = p.entityId;
			this.intData[0] = pl.extData.playerLevel;
			this.intData[1] = pl.extData.playerExperience;
			this.intData[2] = pl.extData.levelPoints;
			this.intData[3] = pl.extData.personalPlayerPoints;
			this.boolData[0] = pl.extData.hasNewLevel;
		}

		public reply() {
		}

		public void writeData(ByteArrayDataOutput out) {
			out.writeInt(this.entityID);
			for (int i = 0; i != 4; i++)
				out.writeInt(this.intData[i]);
			for (int i = 0; i != 1; i++)
				out.writeBoolean(this.boolData[i]);
		}

		public void readData(ByteArrayDataInput in) throws VPacket.ProtocolException {
			this.entityID = in.readInt();
			for (int i = 0; i != 4; i++)
				this.intData[i] =in.readInt();
			for (int i = 0; i != 1; i++)
				this.boolData[i] = in.readBoolean();
		}

		public void onPacket(EntityPlayer player, Side side) throws VPacket.ProtocolException {
			if (side.isClient()) {
				ClientData.entityid = this.entityID;
				ClientData.lvl = this.intData[0];
				ClientData.exp = this.intData[1];
				ClientData.points = this.intData[2];
				ClientData.specialPoints = this.intData[3];
				ClientData.hasNewLevel = this.boolData[0];
			}
		}
	}
}
