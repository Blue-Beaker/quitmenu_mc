package io.bluebeaker.quitmenu.mixin;

import io.bluebeaker.quitmenu.QuitMenuConfig;
import io.bluebeaker.quitmenu.QuitMenuScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;

@Mixin(Minecraft.class)
public abstract class MixinMinecraft {
    @Shadow
    public GuiScreen currentScreen;

    @Shadow public abstract void displayGuiScreen(@Nullable GuiScreen guiScreenIn);

    @Inject(method = "shutdown()V", at = @At("HEAD"), cancellable = true)
    public void showQuitMenu(CallbackInfo ci){
        if(!QuitMenuConfig.enable) return;

        if(!(this.currentScreen instanceof QuitMenuScreen))
            this.displayGuiScreen(new QuitMenuScreen(this.currentScreen));
        ci.cancel();
    }
}
