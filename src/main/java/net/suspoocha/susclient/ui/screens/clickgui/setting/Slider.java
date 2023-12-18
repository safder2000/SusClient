package net.suspoocha.susclient.ui.screens.clickgui.setting;

import net.minecraft.client.gui.DrawContext;
import net.suspoocha.susclient.SusClient;
import net.suspoocha.susclient.module.settings.NumberSetting;
import net.suspoocha.susclient.module.settings.Setting;
import net.suspoocha.susclient.ui.screens.clickgui.ModuleButton;

import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Slider extends Component {
    public NumberSetting numSet = (NumberSetting) setting;
    private boolean sliding = false;

    public Slider(Setting setting, ModuleButton parant, int offset) {
        super(setting, parant, offset);

        this.numSet = (NumberSetting) setting;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {

        //render slider background
        context.fill(parant.parant.x, parant.parant.y + parant.offset + offset, parant.parant.x + parant.parant.width, parant.parant.y + parant.offset + offset + parant.parant.height, new Color(0, 0, 0, 160).getRGB());

        double diff = Math.min(parant.parant.width, Math.max(0, mouseX - parant.parant.x));
        int rederWidth = (int) (parant.parant.width * (numSet.getValue() - numSet.getMin()) / (numSet.getMax() - numSet.getMin()));

        context.fill(parant.parant.x, parant.parant.y + parant.offset + offset, parant.parant.x + rederWidth, parant.parant.y + parant.offset + offset + parant.parant.height, Color.red.getRGB());

        //render slider
        if (sliding) {
            if (diff == 0) {
                SusClient.logger.info("____________diff = 0 ____________");
                numSet.setValue(numSet.getMin());
            } else {
                SusClient.logger.info("____________diff = " +diff);
                numSet.setValue(roundToPlace(((diff / parant.parant.width) * (numSet.getMax() - numSet.getMin()) + numSet.getMin()), 2));
            }

        }

        int textOffset = ((parant.parant.height / 2) - mc.textRenderer.fontHeight / 2);
       //render slider text
        context.drawTextWithShadow(mc.textRenderer, numSet.getName() + ":" + roundToPlace(numSet.getValue(), 2), parant.parant.x + textOffset, parant.parant.y + parant.offset + offset + textOffset, -1);

        super.render(context, mouseX, mouseY, delta);

    }

    @Override
    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (isHovered(mouseX, mouseY)) sliding = true;

        super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public void mouseReleased(double mouseX, double mouseY, int button) {
        sliding = false;
        super.mouseReleased(mouseX, mouseY, button);
    }

    private double roundToPlace(double value, int place) {
        if (place < 0) {
            return value;
        }
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(place, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
