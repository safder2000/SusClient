package net.suspoocha.susclient.module.movement;

import net.suspoocha.susclient.SusClient;
import net.suspoocha.susclient.module.Mod;
import net.suspoocha.susclient.module.settings.BooleanSetting;
import net.suspoocha.susclient.module.settings.ModSetting;
import net.suspoocha.susclient.module.settings.NumberSetting;
import org.lwjgl.glfw.GLFW;

public class Flight extends Mod {

    public NumberSetting speed = new NumberSetting("Speed",0,10,1,0.1);
    public BooleanSetting  testbool = new BooleanSetting("Check",true);
    public ModSetting testMode = new ModSetting("Mode","Test","Test","Test2","Test3");
    public Flight() {
        super("Flight", "Allows you to fly", Category.MOVEMENT);
        this.setKey(GLFW.GLFW_KEY_G);
        addSettings(speed,testbool,testMode);
    }



    @Override
    public void onTick() {
        mc.player.getAbilities().allowFlying = true;
//    SusClient.logger.info("____________Flight enabled____________");
        mc.player.getAbilities().setFlySpeed(speed.getValueFloat());

        super.onTick();
    }
    @Override
    public void onDisable() {
        mc.player.getAbilities().allowFlying = false;

        super.onDisable();
    }
}
