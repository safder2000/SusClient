package net.suspoocha.susclient.ui.screens.clickgui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.world.gen.YOffset;
import net.suspoocha.susclient.module.Mod;
import net.suspoocha.susclient.module.Mod.Category;
import net.suspoocha.susclient.module.ModuleManager;
import net.suspoocha.susclient.ui.screens.clickgui.setting.ColorPallet;
import net.suspoocha.susclient.ui.screens.clickgui.setting.Component;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Frame {
    public int x, y, width, height, dragX, dragY;
    public Category category;
    public boolean dragging, extended;

    private List<ModuleButton> buttons;
    protected MinecraftClient mc = MinecraftClient.getInstance();

    public Frame(Category category, int x, int y, int width, int height) {
        this.category = category;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.dragging = false;
        this.extended = false;
        buttons = new ArrayList<>();
        int offset = height;
        for (Mod mod : ModuleManager.INSTANCE.getModulesInCategory(category)) {
            buttons.add(new ModuleButton(mod, this, offset));
            offset += height;
        }

    }
    ColorPallet colorPallet = new ColorPallet();
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        int offset =  ((height/2)-mc.textRenderer.fontHeight/2);
        //Catagory
        context.fill(x, y, x + width, y + height, colorPallet.guiTitleBackgroud);
        context.drawTextWithShadow(mc.textRenderer, category.name, x  + offset, y + ((height/2)-mc.textRenderer.fontHeight/2), Color.white.getRGB());
        context.drawTextWithShadow(mc.textRenderer, extended?"-":"+", x+width - offset-mc.textRenderer.getWidth("+"), y + ((height/2)-mc.textRenderer.fontHeight/2), Color.white.getRGB());
        if (extended) {
            for (ModuleButton button : buttons) {
                button.render(context, mouseX, mouseY, delta);
            }
        }


    }

    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (isHovered(mouseX, mouseY)) {
            if (button == 0) {
                dragging = true;
                dragX = (int) (mouseX - x);
                dragY = (int) (mouseY - y);
            } else if (button == 1) {
                extended = !extended;
            }

        }
        if (extended) {
            for (ModuleButton btn : buttons) {
                btn.mouseClicked(mouseX, mouseY, button);
            }

        }


    }

    public void mouseReleased(double mouseX, double mouseY, int button) {
        if (button == 0 && dragging == true) {
            dragging = false;
        }
        for (ModuleButton mb :buttons){
            mb.mouseReleased(mouseX,mouseY,button);
        }
    }

    public boolean isHovered(double mouseX, double mouseY) {
        return mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height;

    }

    public void updatePosition(double mouseX, double mouseY) {
        if (dragging) {
            x = (int) (mouseX - dragX);
            y = (int) (mouseY - dragY);
        }
    }

    public void updateButton() {
        int offset = height;
        for (ModuleButton button : buttons){
            button.offset = offset;
            offset +=height;
            if(button.extended ){
                for (Component component :button.components){
                    if(component.setting.isVisible())offset +=height;
                }
            }
        }
    }
}
