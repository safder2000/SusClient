package net.suspoocha.susclient.ui.screens.clickgui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.suspoocha.susclient.module.Mod;
import net.suspoocha.susclient.module.settings.BooleanSetting;
import net.suspoocha.susclient.module.settings.ModSetting;
import net.suspoocha.susclient.module.settings.NumberSetting;
import net.suspoocha.susclient.module.settings.Setting;
import net.suspoocha.susclient.ui.screens.clickgui.setting.*;
import net.suspoocha.susclient.ui.screens.clickgui.setting.Component;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class ModuleButton {
    public Mod module;
    public Frame parant;
    public int offset;
    public List<Component> components;
    public boolean extended;


    //    private static MinecraftClient mc = MinecraftClient.getInstance();
    public ModuleButton(Mod module, Frame parant, int offset) {
        this.module = module;
        this.parant = parant;
        this.offset = offset;
        this.extended = false;
        this.components = new ArrayList<>();
        int setOffset = parant.height;
        for (Setting setting : module.getSettings()) {
            if (setting instanceof BooleanSetting) {
                components.add(new CheckBox(setting, this, setOffset));
            } else if (setting instanceof ModSetting) {
                components.add(new ModBox(setting, this, setOffset));
            }
           else if (setting instanceof NumberSetting) {
                components.add(new Slider(setting, this, setOffset));
            }
           setOffset+=parant.height;
        }
    }
    ColorPallet colorPallet = new ColorPallet();

    public void render(DrawContext context, int mouseX, int mouseY, float delta) {

        context.fill(parant.x, parant.y + offset, parant.x + parant.width, parant.y + offset + parant.height, new Color(0, 0, 0, 160).getRGB());
        int textOffset = ((parant.height / 2) - parant.mc.textRenderer.fontHeight / 2);
        // module highlight on hover
        if (isHovered(mouseX, mouseY)) {
            context.fill(parant.x, parant.y + offset, parant.x + parant.width, parant.y + offset + parant.height, new Color(0, 0, 0, 160).getRGB());
        }
        //module text Button
        context.drawTextWithShadow(parant.mc.textRenderer, module.getDisplayName(), parant.x + textOffset, parant.y + offset + textOffset, module.isEnabled() ?new Color(128, 0, 128, 160).getRGB() : -1);
        if (extended ){
            for (Component component : components) {
                component.render(context, mouseX, mouseY, delta);
            }
        }

    }

    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (isHovered(mouseX, mouseY)) {
            if (button == 0) {
                module.toggle();
            } else if (button == 1) {
                extended = !extended;
                parant.updateButton();
            }
        }
        for (Component component : components) {
            component.mouseClicked(mouseX, mouseY, button);
        }

    }

    public void mouseReleased(double mouseX, double mouseY, int button) {
        for (Component component : components) {
            component.mouseReleased(mouseX, mouseY, button);
        }
    }

    public boolean isHovered(double mouseX, double mouseY) {
        return mouseX > parant.x && mouseX < parant.x + parant.width && mouseY > parant.y + offset && mouseY < parant.y + offset + parant.height;

    }
}
