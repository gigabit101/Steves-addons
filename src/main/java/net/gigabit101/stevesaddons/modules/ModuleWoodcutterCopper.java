package net.gigabit101.stevesaddons.modules;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;
import vswe.stevescarts.entities.EntityMinecartModular;
import vswe.stevescarts.modules.workers.tools.ModuleWoodcutter;

public class ModuleWoodcutterCopper extends ModuleWoodcutter
{
    public ModuleWoodcutterCopper(EntityMinecartModular cart)
    {
        super(cart);
    }

    @Override
    public int getPercentageDropChance()
    {
        return 80;
    }

    @Override
    public int getMaxDurability()
    {
        return 2000;
    }

    @Override
    public String getRepairItemName()
    {
        return "minecraft:copper_ingot";
    }

    @Override
    public int getRepairItemUnits(@NotNull ItemStack item)
    {
        return !item.isEmpty() && item.getItem() == Items.COPPER_INGOT ? 2000 : 0;
    }

    @Override
    public int getRepairSpeed()
    {
        return 50;
    }
}
