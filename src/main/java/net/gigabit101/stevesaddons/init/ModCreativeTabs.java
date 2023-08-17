package net.gigabit101.stevesaddons.init;

import net.gigabit101.stevesaddons.StevesAddons;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StevesAddons.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CREATIVE_TAB = CREATIVE_TABS.register(StevesAddons.MOD_ID + ".creativetab", () -> CreativeModeTab.builder()
            .title(Component.translatable("steveaddons.creativetab"))
            .icon(() -> new ItemStack(ModItems.MODULES.get(ModModules.COPPER_WOOD_CUTTER).get())).build());
}
