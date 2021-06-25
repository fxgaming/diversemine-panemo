package by.fxg.diverse.client.storage;

import java.util.HashMap;

import by.fxg.diverse.common.storage.ServerKit;

public class ClientData {
	public static int entityid = 0;
	
	public static int lvl = 0;
	public static int exp = 0;
	public static int points = 0;
	public static int specialPoints = 0;
	public static boolean hasNewLevel = false;
	
	public static HashMap<Integer, ServerKit> serverKits = new HashMap<Integer, ServerKit>();
	
	//Weather Properties\\
	public static float f1Rain = 0.0F;
	public static float f2Thunder = 0.0F;
	public static float f3Thunderbolt = 0.0F;
}
