package com.nenrys.mutroleum.blockentities.Screenhandling;

import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public abstract class AbstractHandledScreen<T extends ScreenHandler> extends HandledScreen<T> {

    public AbstractHandledScreen(T handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY, Identifier texture) {
        //RenderSystem.color4f(0.5f,0.5f,1.0f,1.0f);

        client.getTextureManager().bindTexture(texture);

        int x = (width-backgroundWidth)/2;
        int y = (height-backgroundHeight)/2;
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX,mouseY,delta);

        drawMouseoverTooltip(matrices, mouseX,mouseY);
    }

    @Override
    protected void init() {
        super.init();
        titleX = (backgroundWidth-textRenderer.getWidth(title))/2;
    }
}
