package net.suspoocha.susclient;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SusClient implements ModInitializer {
	public static final String MOD_ID = "susclient";
	public  static	final SusClient INSTANCE= new SusClient();
    public static final Logger LOGGER = LoggerFactory.getLogger("susclient");

	@Override
	public void onInitialize() {


		LOGGER.info("Hello Fabric world!");
	}
	public void onKeyPress(int key,int action){

	}
}