package com.nenrys.mutroleum.blockentities.Screenhandling;

import com.nenrys.mutroleum.species.Species;
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
    private Species species;

    private static final Identifier TEXTURE = new Identifier("mutroleum","textures/gui/container/testing_block.png");
    private static final Identifier TEXTURE2 = new Identifier("mutroleum","textures/gui/container/testing_icons.png");

    public TestHandledScreen(final TestBlockScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        species = new Species();
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        super.drawBackground(matrices, delta, mouseX,mouseY,TEXTURE);
    }

    protected void init() {
        super.init();
        button = new AcceptButton(this.x + 140, this.y + 58, TEXTURE, 0, 166,  (buttonWidget) -> {
            this.client.player.sendChatMessage("Uploading");
        });
        this.addButton(button);

        addArrows(0);

    }



    protected void addArrows(int chromo) {

        int i;

        for(i = 0; i < species.genes[chromo].length() ;i++ ) {
            int finalI = i;
            this.addButton(new GuiButton(this.x + 7 + 18*i, this.y +23, TEXTURE, 19, 12, 0,188, (buttonWidget) -> {
                String c = Character.toString(species.genes[chromo].charAt(finalI));
                this.client.player.sendChatMessage("Changing gene from " + c + " to " + Species.getNextDNA(c) );
                this.species.changeGene(chromo, finalI, Species.getNextDNA(c));
                this.client.player.sendChatMessage("current genome " + species.genes[chromo] );
            }));
        }

        for(i = 0; i < species.genes[chromo].length() ;i++ ) {
            int finalI = i;
            this.addButton(new GuiButton(this.x + 7 + 18*i, this.y +53, TEXTURE, 19, 12, 0,200, (buttonWidget) -> {
                String c = Character.toString(species.genes[chromo].charAt(finalI));
                this.client.player.sendChatMessage("Changing gene from " + c + " to " + Species.getPrevDNA(c) );
                this.species.changeGene(chromo, finalI, Species.getPrevDNA(c));
                this.client.player.sendChatMessage("current genome " + species.genes[chromo] );
            }));
        }
    }


    private class AcceptButton extends GuiButton{


        public AcceptButton(int i, int j, Identifier texture, int xbuttonstart, int ybuttonstart, PressAction pressaction) {
            super(i, j, texture, xbuttonstart, ybuttonstart, pressaction);
        }

        @Override
        public void onPress() {
            super.onPress();
            this.disabled = true;
        }
    }
}
