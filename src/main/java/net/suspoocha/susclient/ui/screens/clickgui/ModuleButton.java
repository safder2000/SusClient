package net.suspoocha.susclient.ui.screens.clickgui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.suspoocha.susclient.module.Mod;

import java.awt.*;


public class ModuleButton {
    public Mod module;
    public  Frame parant;
    public  int offset;

//    private static MinecraftClient mc = MinecraftClient.getInstance();
    public ModuleButton(Mod module ,Frame parant,int offset){
        this.module = module;
        this.parant = parant;
        this.offset = offset;


    }
    public void  render(DrawContext context, int mouseX, int mouseY, float delta) {

        context.fill(parant.x, parant.y +offset, parant.x+parant.width, parant.y+offset+parant.height,new Color (0,0,0,160).getRGB());
        int textOffset =  ((parant.height/2)-parant. mc.textRenderer.fontHeight/2);
        if (isHovered(mouseX,mouseY)){
            context.fill(parant.x, parant.y +offset, parant.x+parant.width, parant.y+offset+parant.height,new Color (0,0,0,160).getRGB());
        }
        context.drawTextWithShadow(parant.mc.textRenderer, module.getDisplayName(), parant.x+textOffset, parant.y+offset+ textOffset, module.isEnabled()?Color.red.getRGB():-1);
    }
    public void mouseClicked(double mouseX,double mouseY, int button) {
        if (isHovered(mouseX,mouseY)){
            if(button == 0){
                module.toggle();
            }else{

            }
        }

    }
    public  boolean isHovered(double mouseX, double mouseY){
        return  mouseX> parant.x&&mouseX< parant.x+ parant.width&&mouseY> parant.y+offset&&mouseY < parant.y+offset+ parant.height;

    }
}
