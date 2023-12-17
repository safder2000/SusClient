package net.suspoocha.susclient.ui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.suspoocha.susclient.module.Mod;
import net.suspoocha.susclient.module.ModuleManager;

import java.util.Comparator;
import java.util.List;

public class Hud {


// use context for your custom drawing logic

    private static MinecraftClient mc = MinecraftClient.getInstance();

    public static void render(DrawContext context, float tickDelta) {
//        mc.textRenderer.drawWithShadow("test", 10 ,10,-1,1,matrices);
//        context.drawTextWithShadow(mc.textRenderer, "drawTextWithShadow test ", 10, 10, -1);
        renderArrayList(context);

    }

    public static void renderArrayList(DrawContext context) {

        int index = 0;
        int sWidth = mc.getWindow().getScaledWidth();
        int sHight = mc.getWindow().getScaledHeight();
        List<Mod> enabled = ModuleManager.INSTANCE.getEnabledModules();
        enabled.sort(Comparator.comparingInt(m -> (int) mc.textRenderer.getWidth(((Mod) m).getDisplayName())).reversed());
        for (Mod mod : enabled) {
            context.drawTextWithShadow(mc.textRenderer, mod.getDisplayName(), (sWidth - 4) - mc.textRenderer.getWidth(mod.getDisplayName()), 10 + (index * mc.textRenderer.fontHeight), -1);
            index++;
        }
    }
}
