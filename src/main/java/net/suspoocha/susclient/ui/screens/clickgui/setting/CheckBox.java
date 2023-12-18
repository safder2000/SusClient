package net.suspoocha.susclient.ui.screens.clickgui.setting;

import net.minecraft.client.gui.DrawContext;
import net.suspoocha.susclient.module.settings.BooleanSetting;
import net.suspoocha.susclient.module.settings.Setting;
import net.suspoocha.susclient.ui.screens.clickgui.Frame;
import net.suspoocha.susclient.ui.screens.clickgui.ModuleButton;

import java.awt.*;

public class CheckBox extends  Component{

    private BooleanSetting boolSet = (BooleanSetting) setting;
     public CheckBox(Setting setting, ModuleButton parant, int offset) {
        super(setting, parant, offset);
        this.boolSet = (BooleanSetting) setting;
    }
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        int textOffset = ((parant.parant.height / 2) -mc.textRenderer.fontHeight / 2);

        context.fill(parant.parant.x, parant.parant.y + parant.offset+offset, parant.parant.x + parant.parant.width, parant.parant.y + parant.offset+offset +parant. parant.height, new Color(0, 0, 0, 160).getRGB());
        context.drawTextWithShadow(mc.textRenderer,boolSet.getName()+":"+boolSet.isEnabled(),parant.parant.x+textOffset,parant.parant.y+parant.offset+offset+textOffset,-1);
         super.render(context,mouseX,mouseY,delta);

    }
    @Override
    public void mouseClicked(double mouseX, double mouseY, int button) {
if (isHovered(mouseX,mouseY)&&button ==0){
    boolSet.toggle();
}
         super.mouseClicked(mouseX, mouseY, button);
    }
}
