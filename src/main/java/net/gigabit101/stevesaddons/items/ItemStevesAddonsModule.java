package net.gigabit101.stevesaddons.items;

import net.gigabit101.stevesaddons.client.StevesAddonsCreativeTab;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import vswe.stevescarts.api.IModuleItem;
import vswe.stevescarts.api.modules.data.ModuleData;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class ItemStevesAddonsModule extends Item implements IModuleItem
{
    private final ModuleData moduleData;

    public ItemStevesAddonsModule(ModuleData moduleData)
    {
        super(new Properties().tab(StevesAddonsCreativeTab.CREATIVE_MODE_TAB).stacksTo(1));
        this.moduleData = moduleData;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level world, @NotNull List<Component> textComponents, @NotNull TooltipFlag flag)
    {
        if (moduleData != null)
        {
            moduleData.addInformation(textComponents, stack.getTag());
            textComponents.add(Component.literal("ID " + moduleData.getID()));
        }
        else if (!stack.isEmpty() && stack.getItem() instanceof IModuleItem)
        {
            textComponents.add(Component.literal("Module id " + moduleData.getID()));
        }
        else
        {
            textComponents.add(Component.literal("Unknown module id"));
        }
        super.appendHoverText(stack, world, textComponents, flag);
    }


    @Override
    public ModuleData getModuleData()
    {
        return this.moduleData;
    }

    @Override
    public void addExtraDataToCart(final CompoundTag save, @Nonnull ItemStack module, final int i)
    {
        if (module.getTag() != null && module.getTag().contains("Data"))
        {
            save.putByte("Data" + i, module.getTag().getByte("Data"));
        }
        else
        {
            IModuleItem itemCartModule = (IModuleItem) module.getItem();
            final ModuleData data = itemCartModule.getModuleData();
            if (data.isUsingExtraData())
            {
                save.putByte("Data" + i, data.getDefaultExtraData());
            }
        }
    }
}
