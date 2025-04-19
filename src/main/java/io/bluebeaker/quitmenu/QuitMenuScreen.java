package io.bluebeaker.quitmenu;

import io.bluebeaker.quitmenu.mixin.AccessorMinecraft;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.client.config.GuiButtonExt;

import javax.annotation.Nullable;
import java.io.IOException;

public class QuitMenuScreen extends GuiScreen {
    @Nullable
    GuiScreen previousScreen;
    public QuitMenuScreen(GuiScreen previousScreen){
        this.previousScreen=previousScreen;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        GlStateManager.pushMatrix();
        GlStateManager.scale(2.0F, 2.0F, 2.0F);
        this.drawCenteredString(this.fontRenderer, I18n.format("quitmenuScreen.title"), this.width / 2 / 2, Math.min(30, this.height/2-30), 16777215);
        GlStateManager.popMatrix();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if(button.id==0)
            Minecraft.getMinecraft().displayGuiScreen(previousScreen);
        else if(button.id==1)
            ((AccessorMinecraft)(Minecraft.getMinecraft())).setRunning(false);
        super.actionPerformed(button);
    }

    @Override
    public void initGui(){
        int x1;
        int x2;
        int buttonY = this.height - 40;
        int buttonWidth= this.width/2-40;
        if(!QuitMenuConfig.swapButtons){
            x1=this.width / 2 + 5;
            x2=this.width / 2 -buttonWidth-5;
        } else{
            x2=this.width / 2 + 5;
            x1=this.width / 2 -buttonWidth-5;
        }

        this.addButton(new GuiButtonExt(0, x1, buttonY, buttonWidth, 20, I18n.format("quitmenuScreen.cancel")));
        this.addButton(new GuiButtonExt(1, x2, buttonY, buttonWidth, 20, I18n.format("quitmenuScreen.confirm")));
    }
}
