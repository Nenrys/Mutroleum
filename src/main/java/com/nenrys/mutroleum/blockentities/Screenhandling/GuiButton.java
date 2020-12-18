package com.nenrys.mutroleum.blockentities.Screenhandling;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.BeaconScreen;
import net.minecraft.client.gui.widget.AbstractPressableButtonWidget;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.awt.*;

public class GuiButton extends ButtonWidget {

    private final Identifier texture;
    private final int xtexturestart;
    private final int ytexturestart;
    private boolean disabled = false;
    private final ButtonWidget.PressAction pressedAction;
    private boolean wasPressed = false;
    //private final GuiButton.releaseAction releaseAction;

    public GuiButton(int i, int j, Identifier texture, int xbuttonstart, int ybuttonstart, ButtonWidget.PressAction pressaction) {
        super(i,j,22,22, new LiteralText("Something what?"), pressaction);
        this.texture = texture;
        this.xtexturestart = xbuttonstart;
        this.ytexturestart = ybuttonstart;
        this.pressedAction = pressaction;
    }

    public void renderButton(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        MinecraftClient.getInstance().getTextureManager().bindTexture(this.texture);
        int j = xtexturestart;
        if (!this.active) {
            j += this.width * 2;
        } else if (this.disabled) {
            j += this.width * 1;
        } else if (this.isHovered()) {
            j += this.width * 3;
        }

        this.drawTexture(matrices, this.x, this.y, j, ytexturestart, this.width, this.height);
        //this.renderExtra(matrices);

    }

    @Override
    public void onPress() {
        this.disabled = true;
        super.onPress();
    }

    @Override
    public void onRelease(double mouseX, double mouseY) {
        MinecraftClient.getInstance().player.sendChatMessage("Testing");
        this.disabled = false;
        super.onRelease(mouseX, mouseY);
    }

    @Environment(EnvType.CLIENT)
    public interface releaseAction {
        void onRelease();
    }
}

