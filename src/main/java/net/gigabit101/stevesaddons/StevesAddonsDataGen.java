package net.gigabit101.stevesaddons;

import net.creeperhost.polylib.helpers.RegistryNameHelper;
import net.gigabit101.stevesaddons.init.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber(modid = StevesAddons.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class StevesAddonsDataGen
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();

        if (event.includeServer())
        {
//            generator.addProvider(true, new StevesAddonsDataGen.GeneratorRecipes(generator));
//            generator.addProvider(true, new StevesAddonsDataGen.GeneratorLoots(generator));
        }

        if (event.includeClient())
        {
//            generator.addProvider(true, new StevesAddonsDataGen.GeneratorBlockTags(generator, event.getExistingFileHelper()));
            generator.addProvider(true, new StevesAddonsDataGen.GeneratorLanguage(generator));
//            generator.addProvider(true, new StevesAddonsDataGen.GeneratorBlockStates(generator, event.getExistingFileHelper()));
            generator.addProvider(true, new StevesAddonsDataGen.GeneratorItemModels(generator, event.getExistingFileHelper()));
        }
    }

    static class GeneratorItemModels extends ItemModelProvider
    {
        public GeneratorItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper)
        {
            super(generator.getPackOutput(), StevesAddons.MOD_ID, existingFileHelper);
        }

        @Override
        protected void registerModels()
        {
            ModItems.MODULES.forEach((moduleData, itemSupplier) -> singleTexture(RegistryNameHelper.getRegistryName(itemSupplier.get()).get().getPath(),
                    mcLoc("item/generated"), "layer0", modLoc("items/" + moduleData.getRawName() + "_icon")));
        }
        @Override
        public @NotNull String getName()
        {
            return "Item Models";
        }
    }

    static class GeneratorLanguage extends LanguageProvider
    {
        public GeneratorLanguage(DataGenerator gen)
        {
            super(gen.getPackOutput(), StevesAddons.MOD_ID, "en_us");
        }

        @Override
        protected void addTranslations()
        {
            add("itemGroup.stevesaddons", "Steves Addons");
            ModItems.MODULES.forEach((moduleData, itemSupplier) ->
            {
                String name = "item.stevesaddons." + moduleData.getRawName();
                add(name, moduleData.getDisplayName());
            });
        }
    }
}
