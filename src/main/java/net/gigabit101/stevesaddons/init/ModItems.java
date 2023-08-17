package net.gigabit101.stevesaddons.init;

import net.gigabit101.stevesaddons.StevesAddons;
import net.gigabit101.stevesaddons.items.ItemStevesAddonsModule;
import net.minecraft.Util;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import vswe.stevescarts.api.modules.data.ModuleData;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModItems
{
    public static final Item.Properties ITEM_GROUP = new Item.Properties();
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, StevesAddons.MOD_ID);

    public static final Map<ModuleData, Supplier<Item>> MODULES = Util.make(new LinkedHashMap<>(), map ->
    {
        for (ModuleData value : ModModules.MODULES)
        {
                map.put(value, ITEMS.register(value.getName(), () -> new ItemStevesAddonsModule(value)));
        }
    });
}
