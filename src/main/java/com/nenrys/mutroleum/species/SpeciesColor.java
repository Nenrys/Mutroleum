package com.nenrys.mutroleum.species;

import com.nenrys.mutroleum.Mutroleum;
import com.nenrys.mutroleum.item.ModItems;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;

public class SpeciesColor {

    private static final int[] colors1 = {0xf9ffff,0x9c9d97,0x474f52,0x1d1c21}; //White, light gray, gray, black
    private static final int[] colors2 = {0x38caa,0xb02e26,0xc64fbd,0x8932b7}; //Pink, red, magenta, purple
    private static final int[] colors3 = {0x3c44a9,0x3ab3da,0x169c9d,0x5d7c15}; //Blue, light blue, cyan, green
    private static final int [] colors4 = {0x80c71f,0xffd83d,0xf9801d,0x825432}; //Lime, yellow, orange, brown


    //@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = Mutroleum.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    private static class ColorRegisterHandler
    {

    }

}
