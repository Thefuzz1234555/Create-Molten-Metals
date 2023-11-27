package com.nazaru.moltenmetals;

import com.nazaru.moltenmetals.fluids.FluidReg;
import com.simibubi.create.AllTags;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.CombustibleItem;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.nazaru.moltenmetals.creative.CreativeTab.TABS;
import static com.simibubi.create.Create.REGISTRATE;

@Mod(MoltenMetals.MODID)
public final class MoltenMetals
{
    public static final String MODID = "moltenmetals";
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create("moltenmetals");

    // Unused for now
    //    public static final ItemEntry<CombustibleItem> LAVA_BROWNIE = REGISTRATE.item("lava_brownie", CombustibleItem::new)
    //        .tag(AllTags.AllItemTags.UPRIGHT_ON_BELT.tag, AllTags.AllItemTags.BLAZE_BURNER_FUEL_SPECIAL.tag)
    //        .onRegister(i -> i.setBurnTime(800))
    //        .register();

    public static final RegistryObject<Item> WAX_CAST_BALL = ITEMS.register("wax_cast_ball", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NUGGET_WAX_CAST = ITEMS.register("nugget_wax_cast", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_WAX_CAST = ITEMS.register("ingot_wax_cast", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BLOCK_WAX_CAST = ITEMS.register("block_wax_cast", () -> new Item(new Item.Properties()));

    public MoltenMetals()
    {

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        FluidReg.register();

        modEventBus.addListener(this::commonSetup);

        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        TABS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        REGISTRATE.registerEventListeners(modEventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, MoltenMetalsConfig.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartedEvent event)
    {

    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            ItemBlockRenderTypes.setRenderLayer(FluidReg.MOLTEN_IRON.get(), RenderType.translucent());
        }
    }
    public static ResourceLocation resourceLocation(String name)
    {
        return new ResourceLocation(MODID, name);
    }
}
