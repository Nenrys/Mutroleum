package com.nenrys.mutroleum.species;

import com.nenrys.mutroleum.Mutroleum;
import com.nenrys.mutroleum.item.ModItems;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;

public class SpeciesColor implements ItemColor {

    public static final SpeciesColor INSTANCE = new SpeciesColor();

    private static final int[] colors1 = {0xf9ffff,0x9c9d97,0x474f52,0x1d1c21}; //White, light gray, gray, black
    private static final int[] colors2 = {0x38caa,0xb02e26,0xc64fbd,0x8932b7}; //Pink, red, magenta, purple
    private static final int[] colors3 = {0x3c44a9,0x3ab3da,0x169c9d,0x5d7c15}; //Blue, light blue, cyan, green
    private static final int [] colors4 = {0x80c71f,0xffd83d,0xf9801d,0x825432}; //Lime, yellow, orange, brown

    @Override
    public int getColor(ItemStack pStack, int pTintIndex) {
        return pTintIndex == 0 ? colorFromGene(pStack)[0] : colorFromGene(pStack)[1];
    }

    @Mod.EventBusSubscriber(value = Dist.CLIENT, modid = Mutroleum.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    private static class ColorRegisterHandler
    {
        @SubscribeEvent(priority = EventPriority.HIGHEST)
        public static void registerSpeciesColors(ColorHandlerEvent.Item event)
        {
           event.getItemColors().register(INSTANCE, ModItems.SPECIES_DEBUGGER.get());
        }
    }

    public int[] colorFromGene(@Nullable ItemStack stack) {
        int[] colors = new int[2];
        IHasSpecies species = (IHasSpecies) stack.getItem();

        Species.GENE prim1 = species.getGene(stack, "genesis", Species.G_GENES.P_COLOR1.toString());
        int prim2 = species.getGene(stack, "genesis", Species.G_GENES.P_COLOR2.toString()).ordinal();
        Species.GENE sec1 = species.getGene(stack, "genesis", Species.G_GENES.S_COLOR1.toString());
        int sec2 = species.getGene(stack, "genesis", Species.G_GENES.S_COLOR2.toString()).ordinal();

        colors[0] = switch(prim1) {
            case A:
                yield colors1[prim2];
            case T:
                yield colors2[prim2];
            case C:
                yield colors3[prim2];
            case G:
                yield colors4[prim2];
            default:
                yield colors2[3];

        };

        colors[1] = switch(sec1) {
            case A:
                yield colors1[sec2];
            case T:
                yield colors2[sec2];
            case C:
                yield colors3[sec2];
            case G:
                yield colors4[sec2];
            default:
                yield colors2[3];
        };

        return colors;
    }

}
