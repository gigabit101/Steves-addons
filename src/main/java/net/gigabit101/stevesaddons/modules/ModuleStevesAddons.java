package net.gigabit101.stevesaddons.modules;

import net.gigabit101.stevesaddons.init.ModItems;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.world.item.ItemStack;
import vswe.stevescarts.api.StevesCartsAPI;
import vswe.stevescarts.api.modules.ModuleBase;
import vswe.stevescarts.entities.EntityMinecartModular;

public class ModuleStevesAddons extends ModuleBase
{
    public ModuleStevesAddons(EntityMinecartModular cart)
    {
        super(cart);
    }

    @Override
    public String getModuleName()
    {
        return I18n.get("item.stevesaddons." + StevesCartsAPI.MODULE_REGISTRY.get(this.getModuleId()).getRawName());
    }

    @Override
    public ItemStack getItemStack()
    {
        return new ItemStack(ModItems.MODULES.get(getData()).get());
    }
}
