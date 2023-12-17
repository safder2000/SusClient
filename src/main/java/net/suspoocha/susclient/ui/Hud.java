package net.suspoocha.susclient.ui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.suspoocha.susclient.module.Mod;
import net.suspoocha.susclient.module.ModuleManager;

public class Hud {


// use context for your custom drawing logic

    private static MinecraftClient mc = MinecraftClient.getInstance();

    public static void render(DrawContext context, float tickDelta) {
//        mc.textRenderer.drawWithShadow("test", 10 ,10,-1,1,matrices);
        context.drawTextWithShadow(mc.textRenderer, "drawTextWithShadow test ", 10, 10, 1);

    }

//    public void renderArrayList(MatrixStack matrices) {
//        Matrix
//        int index  = 0;
//        for (Mod mod : ModuleManager.INSTANCE.getEnabledModules()) {
//            mc.textRenderer.draw()
//
//        }
//    }
}
