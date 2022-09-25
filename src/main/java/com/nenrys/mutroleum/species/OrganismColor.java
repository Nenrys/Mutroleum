package com.nenrys.mutroleum.species;

import com.nenrys.mutroleum.Mutroleum;
import com.nenrys.mutroleum.item.ModItems;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

public enum OrganismColor {
    WHITE(0xf9ffff), LIGHT_GRAY(0x9c9d97), GRAY(0x474f52), BLACK(0x1d1c21),
    PINK(0xffa4a4), RED(0xb02e26), MAGENTA(0xc64fbd), PURPLE(0x8932b7),
    BLUE(0x3c44a9), LIGHT_BLUE(0x3ab3da), CYAN(0x169c9d), GREEN(0x5d7c15),
    LIME(0x80c71f), YELLOW(0xffd83d), ORANGE(0xf9801d), BROWN(0x825432);

    public final int hexcol;
    OrganismColor(int hexcol) {
        this.hexcol=hexcol;
    }

    public static int gene2col(Species.GENE gene1, Species.GENE gene2) {
        return (gene1 == Species.GENE.N || gene2 == Species.GENE.N)
                ? PURPLE.hexcol : OrganismColor.values()[(gene1.ordinal()-1)*4 + (gene2.ordinal()-1)].hexcol;
    }

    @Mod.EventBusSubscriber(value = Dist.CLIENT, modid = Mutroleum.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    private static class ColorRegisterHandler
    {
        @SubscribeEvent(priority = EventPriority.HIGHEST)
        public static void registerDMBucketColors(RegisterColorHandlersEvent.Item event)
        {
            event.getItemColors().register( (stack, index) -> {
                if (index == 1) {
                    return gene2col(ISpeciesItem.getGene(stack, Species.GENES.P_COLOR1),
                            ISpeciesItem.getGene(stack, Species.GENES.P_COLOR2));
                } else if (index == 2) {
                    return gene2col(ISpeciesItem.getGene(stack, Species.GENES.S_COLOR1),
                            ISpeciesItem.getGene(stack, Species.GENES.S_COLOR2));
                } else {
                    return 0xFFFFFF;
                }
            }, ModItems.SPECIES_DEBUGGER.get());

            event.getItemColors().register( (stack, index) -> index != 1 ? 0xFFFFFF : OrganismColor.WHITE.hexcol, ModItems.DM_BUCKET_WHITE.get());
            event.getItemColors().register( (stack, index) -> index != 1 ? 0xFFFFFF : OrganismColor.LIGHT_GRAY.hexcol, ModItems.DM_BUCKET_LIGHT_GRAY.get());
            event.getItemColors().register( (stack, index) -> index != 1 ? 0xFFFFFF : OrganismColor.GRAY.hexcol, ModItems.DM_BUCKET_GRAY.get());
            event.getItemColors().register( (stack, index) -> index != 1 ? 0xFFFFFF : OrganismColor.BLACK.hexcol, ModItems.DM_BUCKET_BLACK.get());
            event.getItemColors().register( (stack, index) -> index != 1 ? 0xFFFFFF : OrganismColor.PINK.hexcol, ModItems.DM_BUCKET_PINK.get());
            event.getItemColors().register( (stack, index) -> index != 1 ? 0xFFFFFF : OrganismColor.RED.hexcol, ModItems.DM_BUCKET_RED.get());
            event.getItemColors().register( (stack, index) -> index != 1 ? 0xFFFFFF : OrganismColor.MAGENTA.hexcol, ModItems.DM_BUCKET_MAGENTA.get());
            event.getItemColors().register( (stack, index) -> index != 1 ? 0xFFFFFF : OrganismColor.PURPLE.hexcol, ModItems.DM_BUCKET_PURPLE.get());
            event.getItemColors().register( (stack, index) -> index != 1 ? 0xFFFFFF : OrganismColor.BLUE.hexcol, ModItems.DM_BUCKET_BLUE.get());
            event.getItemColors().register( (stack, index) -> index != 1 ? 0xFFFFFF : OrganismColor.LIGHT_BLUE.hexcol, ModItems.DM_BUCKET_LIGHT_BLUE.get());
            event.getItemColors().register( (stack, index) -> index != 1 ? 0xFFFFFF : OrganismColor.CYAN.hexcol, ModItems.DM_BUCKET_CYAN.get());
            event.getItemColors().register( (stack, index) -> index != 1 ? 0xFFFFFF : OrganismColor.GREEN.hexcol, ModItems.DM_BUCKET_GREEN.get());
            event.getItemColors().register( (stack, index) -> index != 1 ? 0xFFFFFF : OrganismColor.LIME.hexcol, ModItems.DM_BUCKET_LIME.get());
            event.getItemColors().register( (stack, index) -> index != 1 ? 0xFFFFFF : OrganismColor.YELLOW.hexcol, ModItems.DM_BUCKET_YELLOW.get());
            event.getItemColors().register( (stack, index) -> index != 1 ? 0xFFFFFF : OrganismColor.ORANGE.hexcol, ModItems.DM_BUCKET_ORANGE.get());
            event.getItemColors().register( (stack, index) -> index != 1 ? 0xFFFFFF : OrganismColor.BROWN.hexcol, ModItems.DM_BUCKET_BROWN.get());
        }

    }

}
