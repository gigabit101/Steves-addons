package net.gigabit101.stevesaddons.modules;

import net.creeperhost.polylib.client.screenbuilder.ScreenBuilder;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import vswe.stevescarts.client.guis.GuiMinecart;
import vswe.stevescarts.entities.EntityMinecartModular;
import vswe.stevescarts.helpers.ResourceHelper;

public class ModuleRFStorage extends ModuleStevesAddons
{
    ScreenBuilder screenBuilder = new ScreenBuilder();
    private final int[] rfbox = new int[]{10, 15, 52, 8};

    public ModuleRFStorage(EntityMinecartModular cart)
    {
        super(cart);
    }

    @Override
    public boolean hasGui()
    {
        return true;
    }

    @Override
    public boolean hasSlots()
    {
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void drawBackground(GuiGraphics guiGraphics, GuiMinecart gui, int x, int y)
    {
        ResourceHelper.bindResource("/gui/tool.png");
        this.drawBox(guiGraphics, gui, 0, 0, 1.0F);
        this.drawBox(guiGraphics, gui, 0, 8,  (float)this.getCurrentStored() / (float)this.getMaxCapacity());
        this.drawBox(guiGraphics, gui, 0, 16, (float)this.getCurrentStored() / (float)this.getMaxCapacity());
        if (this.inRect(x, y, this.rfbox)) {
            this.drawBox(guiGraphics, gui, 0, 24, 1.0F);
        }
    }

    @Override
    public void drawForeground(GuiGraphics guiGraphics, GuiMinecart gui)
    {
        this.drawString(guiGraphics, gui, this.getModuleName(), 8, 6, 4210752);
    }

    @Override
    public void drawMouseOver(GuiGraphics guiGraphics, GuiMinecart gui, int x, int y)
    {
        this.drawStringOnMouseOver(guiGraphics, gui, getCurrentStored() + "RF / " + getMaxCapacity() + "RF", x, y, this.rfbox);
    }

    public int getCurrentStored()
    {
        return 5000;
    }

    public int getMaxCapacity()
    {
        return 10000;
    }

    private void drawBox(GuiGraphics guiGraphics, GuiMinecart gui, int u, int v, float mult)
    {
        int w = (int)((float)this.rfbox[2] * mult);
        if (w > 0)
        {
            this.drawImage(guiGraphics, gui, this.rfbox[0], this.rfbox[1], u, v, w, this.rfbox[3]);
        }
    }

    @Override
    public int guiWidth() {
        return 100;
    }

    @Override
    public int guiHeight() {
        return 50;
    }
}
