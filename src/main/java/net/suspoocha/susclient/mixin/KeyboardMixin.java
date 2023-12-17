package net.suspoocha.susclient.mixin;


import net.minecraft.client.Keyboard;
import net.suspoocha.susclient.SusClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Keyboard.class)
public class KeyboardMixin {
    @Inject(method = "onKey", at=@At("HEAD"),cancellable = true)
    public void onKey(long window, int key, int scancode, int action, int modifiers, CallbackInfo ci){
        SusClient.INSTANCE.onKeyPress(key, action);

    }
}
