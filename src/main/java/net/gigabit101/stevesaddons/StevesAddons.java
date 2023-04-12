package net.gigabit101.stevesaddons;

import net.gigabit101.stevesaddons.init.ModItems;
import net.gigabit101.stevesaddons.init.ModModules;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(StevesAddons.MOD_ID)
public class StevesAddons
{
    public static final String MOD_ID = "stevesaddons";

    public StevesAddons()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::clientInit);
        ModModules.init();
        ModItems.ITEMS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void clientInit(final FMLClientSetupEvent event)
    {
        StevesAddonsClient.clientInit(event);
    }
}
