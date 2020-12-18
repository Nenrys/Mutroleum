package com.nenrys.mutroleum.blockentities.Screenhandling;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.BeaconScreen;
import net.minecraft.client.gui.widget.AbstractPressableButtonWidget;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.AbstractRecipeScreenHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class TestHandledScreen extends AbstractHandledScreen<TestBlockScreenHandler> {

    private boolean accept = false;
    private ButtonWidget button;

    private static final Identifier TEXTURE = new Identifier("mutroleum","textures/gui/container/testing_block.png");
    private static final Identifier TEXTURE2 = new Identifier("mutroleum","textures/gui/container/testing_icons.png");

    public TestHandledScreen(final TestBlockScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        super.drawBackground(matrices, delta, mouseX,mouseY,TEXTURE);
    }



    protected void init() {
        super.init();
        button = new GuiButton(this.x + 140, this.y + 58, TEXTURE, 0, 166,  (buttonWidget) -> {
            this.client.player.sendChatMessage("Uploading");
        });
        this.addButton(button);

    }

}
