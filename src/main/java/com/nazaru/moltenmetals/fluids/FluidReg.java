package com.nazaru.moltenmetals.fluids;

import com.tterrag.registrate.util.entry.FluidEntry;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import static com.nazaru.moltenmetals.MoltenMetals.REGISTRATE;

public class FluidReg {

    //If you see this, making fluids that do damage is an actual nightmare, but I will try making them do damage later
    public static final FluidEntry<ForgeFlowingFluid.Flowing> MOLTEN_IRON =
            REGISTRATE.standardFluid("molten_iron")
                    .lang("Molten Iron")
                    .properties(p -> p
                            .lightLevel(15)
                            .viscosity(6000)
                            .density(750))
                    .fluidProperties(f -> f.levelDecreasePerBlock(3)
                            .tickRate(24)
                            .slopeFindDistance(3)
                            .explosionResistance(100f))
                    .register();
    public static final FluidEntry<ForgeFlowingFluid.Flowing> MOLTEN_COPPER =
            REGISTRATE.standardFluid(
                            "molten_copper")
                    .lang("Molten Copper")
                    .properties(p -> p
                            .lightLevel(12)
                            .viscosity(6000)
                            .density(750))
                    .fluidProperties(f -> f.levelDecreasePerBlock(3)
                            .tickRate(18)
                            .slopeFindDistance(3)
                            .explosionResistance(100f))
                    .register();
    public static final FluidEntry<ForgeFlowingFluid.Flowing> MOLTEN_ZINC =
            REGISTRATE.standardFluid(
                            "molten_zinc")
                    .lang("Molten Zinc")
                    .properties(p -> p
                            .canSwim(false)
                            .lightLevel(5)
                            .viscosity(6000)
                            .density(750))
                    .fluidProperties(f -> f.levelDecreasePerBlock(2)
                            .tickRate(18)
                            .slopeFindDistance(3)
                            .explosionResistance(100f))
                    .register();
    public static final FluidEntry<ForgeFlowingFluid.Flowing> MOLTEN_BRASS =
            REGISTRATE.standardFluid(
                            "molten_brass")
                    .lang("Molten Brass")
                    .properties(p -> p
                            .lightLevel(10)
                            .viscosity(6000)
                            .density(750))
                    .fluidProperties(f -> f.levelDecreasePerBlock(3)
                            .tickRate(18)
                            .slopeFindDistance(3)
                            .explosionResistance(100f))
                    .register();

    public static final FluidEntry<ForgeFlowingFluid.Flowing> MOLTEN_GOLD =
            REGISTRATE.standardFluid(
                            "molten_gold")
                    .lang("Molten Gold")
                    .properties(p -> p
                            .lightLevel(12)
                            .viscosity(6000)
                            .density(750))
                    .fluidProperties(f -> f.levelDecreasePerBlock(3)
                            .tickRate(18)
                            .slopeFindDistance(3)
                            .explosionResistance(100f))
                    .register();
    public static void register() {}
    // TODO: 11/27/2023 ADD A SUPERHEATED FLUID FOR MELTING 
}


