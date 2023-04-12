package net.gigabit101.stevesaddons.containers;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import vswe.stevescarts.api.modules.template.ModuleStorage;
import vswe.stevescarts.entities.EntityMinecartModular;

public class RFStorage extends ModuleStorage
{
    private EntityDataAccessor<Integer> ENERGY_AMOUNT;
    private int max_storage = 100000;
    private int storage = 0;

    public RFStorage(EntityMinecartModular cart)
    {
        super(cart);
    }

    @Override
    public void initDw()
    {
        this.ENERGY_AMOUNT = this.createDw(EntityDataSerializers.INT);
        this.registerDw(this.ENERGY_AMOUNT, this.storage);
    }

    protected void updateDw()
    {
        this.updateDw(this.ENERGY_AMOUNT, this.storage);
    }

    @Override
    protected void Save(CompoundTag tagCompound, int id)
    {
        tagCompound.putInt("rf_storage", this.storage);
    }

    @Override
    protected void Load(CompoundTag tagCompound, int id)
    {
        this.storage = tagCompound.getInt("rf_storage");
        this.updateDw(this.ENERGY_AMOUNT, tagCompound.getInt("rf_storage"));
        this.updateDw();
    }

    public int getStorage()
    {
        return storage;
    }

    public int getMaxStorage()
    {
        return max_storage;
    }

    public void setStorage(int storage)
    {
        this.storage = storage;
        updateDw();
    }
}
