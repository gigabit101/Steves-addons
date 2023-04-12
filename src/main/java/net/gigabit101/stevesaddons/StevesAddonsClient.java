package net.gigabit101.stevesaddons;

import net.gigabit101.stevesaddons.init.ModModules;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import vswe.stevescarts.client.models.ModelToolPlate;
import vswe.stevescarts.client.models.workers.tools.ModelWoodCutter;

public class StevesAddonsClient
{
    public static void clientInit(final FMLClientSetupEvent event)
    {
        initModels();
    }

    public static void initModels()
    {
        ModModules.COPPER_WOOD_CUTTER.addModel("WoodCutter", new ModelWoodCutter(new ResourceLocation(StevesAddons.MOD_ID, "textures/models/woodcuttermodelcopper.png"))).addModel("Plate", new ModelToolPlate());
    }
}
