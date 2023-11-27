package com.nazaru.moltenmetals.creative;

import com.nazaru.moltenmetals.MoltenMetals;
import com.nazaru.moltenmetals.fluids.FluidReg;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.nazaru.moltenmetals.MoltenMetals.MODID;

public class CreativeTab {
    public static final DeferredRegister<CreativeModeTab>
            TABS = DeferredRegister.create
            (Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<CreativeModeTab>
            CREATIVE_TAB = TABS
            .register("mod_tab",
                    () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(MoltenMetals.INGOT_WAX_CAST.get()))
            .title(Component.translatable("itemGroup.moltenmetals"))
            .displayItems((flags, output) ->
            {
                output.accept(FluidReg.MOLTEN_IRON.getBucket().get());
                output.accept(FluidReg.MOLTEN_COPPER.getBucket().get());
                output.accept(FluidReg.MOLTEN_ZINC.getBucket().get());
                output.accept(FluidReg.MOLTEN_BRASS.getBucket().get());
                output.accept(FluidReg.MOLTEN_GOLD.getBucket().get());
                output.accept(MoltenMetals.WAX_CAST_BALL.get());
                output.accept(MoltenMetals.NUGGET_WAX_CAST.get());
                output.accept(MoltenMetals.INGOT_WAX_CAST.get());
                output.accept(MoltenMetals.BLOCK_WAX_CAST.get());
            }).build());
}

