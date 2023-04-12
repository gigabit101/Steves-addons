package net.gigabit101.stevesaddons.init;

import net.gigabit101.stevesaddons.StevesAddons;
import net.gigabit101.stevesaddons.modules.ModuleWoodcutterCopper;
import net.minecraft.resources.ResourceLocation;
import vswe.stevescarts.api.StevesCartsAPI;
import vswe.stevescarts.api.modules.DefaultModuleGroups;
import vswe.stevescarts.api.modules.ModuleType;
import vswe.stevescarts.api.modules.data.ModuleData;

import java.util.ArrayList;
import java.util.List;

public class ModModules
{
    public static List<ModuleData> MODULES = new ArrayList<>();
    public static ModuleData COPPER_WOOD_CUTTER;

    public static void init()
    {
        COPPER_WOOD_CUTTER = StevesCartsAPI.registerModule(new ResourceLocation(StevesAddons.MOD_ID, "copper_wood_cutter"),
                new ModuleData(new ResourceLocation(StevesAddons.MOD_ID, "copper_wood_cutter"), "Copper Wood Cutter", ModuleWoodcutterCopper.class, ModuleType.TOOL, 20).addSide(ModuleData.SIDE.FRONT));
        DefaultModuleGroups.WOODCUTTER_GROUP.add(COPPER_WOOD_CUTTER);
        MODULES.add(COPPER_WOOD_CUTTER);
    }
}
