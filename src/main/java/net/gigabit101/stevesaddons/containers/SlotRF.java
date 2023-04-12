package net.gigabit101.stevesaddons.containers;

import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import org.jetbrains.annotations.NotNull;
import vswe.stevescarts.containers.slots.SlotBase;

public class SlotRF extends SlotBase
{
    public SlotRF(Container inventory, int id, int x, int y)
    {
        super(inventory, id, x, y);
    }

    @Override
    public boolean mayPlace(@NotNull ItemStack itemStack)
    {
        return itemStack.getCapability(ForgeCapabilities.ENERGY).isPresent();
    }
}
