package net.gigabit101.stevesaddons.init;

import net.gigabit101.stevesaddons.StevesAddons;
import net.gigabit101.stevesaddons.client.StevesAddonsCreativeTab;
import net.gigabit101.stevesaddons.items.ItemStevesAddonsModule;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final Item.Properties ITEM_GROUP = new Item.Properties().tab(StevesAddonsCreativeTab.CREATIVE_MODE_TAB);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, StevesAddons.MOD_ID);

    public static final RegistryObject<Item> MODULE_ITEM = ITEMS.register("module", () -> new ItemStevesAddonsModule(ModModules.COPPER_WOOD_CUTTER));

}
