package net.suspoocha.susclient.ui.screens.clickgui.setting;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.suspoocha.susclient.module.settings.Setting;
import net.suspoocha.susclient.ui.screens.clickgui.ModuleButton;


public class Component {
    public Setting setting;
    public ModuleButton parant;
    public int offset;
    protected MinecraftClient mc = MinecraftClient.getInstance();

    public Component(Setting setting, ModuleButton parant, int offset) {
        this.setting = setting;
        this.parant = parant;
        this.offset = offset;


    }

    public void render(DrawContext context, int mouseX, int mouseY, float delta) {

    }

    public void mouseClicked(double mouseX, double mouseY, int button) {
    }

    public void mouseReleased(double mouseX, double mouseY, int button) {
    }


    public boolean isHovered(double mouseX, double mouseY) {
        return mouseX > parant.parant.x && mouseX < parant.parant.x + parant.parant.width && mouseY > parant.parant.y + parant.offset + offset && mouseY < parant.parant.y + parant.offset + offset + parant.parant.height;

    }
}
