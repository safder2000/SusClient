package net.suspoocha.susclient.module.movement;

import net.suspoocha.susclient.SusClient;
import net.suspoocha.susclient.module.Mod;
import org.lwjgl.glfw.GLFW;

public class Flight extends Mod {
    public Flight() {
        super("Flight", "Allows you to fly", Category.MOVEMENT);
        this.setKey(GLFW.GLFW_KEY_G);
    }

    @Override
    public void onTick() {
        mc.player.getAbilities().allowFlying = true;
    SusClient.logger.info("____________Flight enabled____________");

        super.onTick();
    }
    @Override
    public void onDisable() {
        mc.player.getAbilities().allowFlying = false;
        SusClient.logger.info("____________Flight enabled____________");
        super.onDisable();
    }
}
