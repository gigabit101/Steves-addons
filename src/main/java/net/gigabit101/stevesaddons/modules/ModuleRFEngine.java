package net.gigabit101.stevesaddons.modules;

import com.mojang.blaze3d.vertex.PoseStack;
import net.gigabit101.stevesaddons.containers.SlotRF;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.energy.IEnergyStorage;
import vswe.stevescarts.api.modules.template.ModuleEngine;
import vswe.stevescarts.client.guis.GuiMinecart;
import vswe.stevescarts.containers.slots.SlotBase;
import vswe.stevescarts.entities.EntityMinecartModular;
import vswe.stevescarts.helpers.Localization;

import java.util.concurrent.atomic.AtomicReference;

public class ModuleRFEngine extends ModuleEngine
{
    private EntityDataAccessor<Integer> PRIORITY;

    public ModuleRFEngine(EntityMinecartModular cart)
    {
        super(cart);
    }

    @Override
    public void initDw()
    {
        PRIORITY = createDw(EntityDataSerializers.INT);
        super.initDw();
    }

    @Override
    protected EntityDataAccessor<Integer> getPriorityDw()
    {
        return PRIORITY;
    }

    @Override
    protected void loadFuel() {}

    @Override
    public int getTotalFuel()
    {
        return getFuelFromBatteries();
    }

    @Override
    public boolean hasFuel(int comsumption)
    {
        return getFuelFromBatteries() > 0;
    }

    @Override
    public void consumeFuel(int comsumption)
    {
        for (int i = 0; i < getInventorySize(); ++i)
        {
            if(!getStack(i).isEmpty())
            {
                if (getStack(i).getCapability(ForgeCapabilities.ENERGY).isPresent())
                {
                    IEnergyStorage storage = getStack(i).getCapability(ForgeCapabilities.ENERGY).resolve().get();
                    int value = storage.extractEnergy(comsumption, false);
                    if(value >= comsumption) break;
                }
            }
        }
    }

    public int getFuelFromBatteries()
    {
        AtomicReference<Integer> totalfuel = new AtomicReference<>(0);

        for (int i = 0; i < getInventorySize(); ++i)
        {
            if (!getStack(i).isEmpty())
                getStack(i).getCapability(ForgeCapabilities.ENERGY).ifPresent(iEnergyStorage -> totalfuel.updateAndGet(v -> (v + iEnergyStorage.getEnergyStored())));
        }
        return totalfuel.get();
    }

    @Override
    public float[] getGuiBarColor()
    {
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    @Override
    protected SlotBase getSlot(final int slotId, final int x, final int y)
    {
        return new SlotRF(getCart(), slotId, 8 + x * 18, 23 + 18 * y);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void drawForeground(PoseStack matrixStack, GuiMinecart gui)
    {
        drawString(matrixStack, gui, "RF Engine", 8, 6, 4210752);
        String strfuel = Localization.MODULES.ENGINES.NO_FUEL.translate();
        if (getTotalFuel() > 0)
        {
            strfuel = "Fuel: " + getTotalFuel();
        }
        drawString(matrixStack, gui, strfuel, 8, 48, 4210752);
    }
}
