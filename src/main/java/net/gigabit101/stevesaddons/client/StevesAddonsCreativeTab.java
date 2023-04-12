package net.gigabit101.stevesaddons.client;

import net.gigabit101.stevesaddons.StevesAddons;
import net.gigabit101.stevesaddons.init.ModItems;
import net.gigabit101.stevesaddons.init.ModModules;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class StevesAddonsCreativeTab
{
    public static final CreativeModeTab CREATIVE_MODE_TAB = (new CreativeModeTab(StevesAddons.MOD_ID)
    {
        public @NotNull ItemStack makeIcon()
        {
            return new ItemStack(ModItems.MODULES.get(ModModules.COPPER_WOOD_CUTTER).get());
        }
    });
}
