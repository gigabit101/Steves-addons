package net.gigabit101.stevesaddons.client;

import net.gigabit101.stevesaddons.StevesAddons;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

public class StevesAddonsCreativeTab
{
    public static final CreativeModeTab CREATIVE_MODE_TAB = (new CreativeModeTab(StevesAddons.MOD_ID)
    {
        public @NotNull ItemStack makeIcon()
        {
            return new ItemStack(Items.DIAMOND);
        }
    });
}
