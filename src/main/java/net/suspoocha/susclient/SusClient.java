package net.suspoocha.susclient;

import net.fabricmc.api.ModInitializer;


import net.minecraft.client.MinecraftClient;
import net.suspoocha.susclient.module.Mod;
import net.suspoocha.susclient.module.ModuleManager;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.logging.LogManager;

public class SusClient implements ModInitializer {
    public static final String MOD_ID = "susclient";
    public static final SusClient INSTANCE = new SusClient();
    public static final Logger logger = LoggerFactory.getLogger("susclient");
    //	public Logger logger = LogManager.getLogger(SusClient.class);
    private MinecraftClient mc = MinecraftClient.getInstance();

    @Override
    public void onInitialize() {


        logger.info("Hello Fabric world!");
    }

    public void onKeyPress(int key, int action) {
        if (action == GLFW.GLFW_PRESS) {
            for (Mod module : ModuleManager.INSTANCE.getModules()) {
                if (key == module.getKey()) module.toggle();
            }
        }

    }

    public void onTick() {
        if (mc.player != null) {
            for (Mod module : ModuleManager.INSTANCE.getEnabledModules()) {
                module.onTick();
            }
        }
    }
}