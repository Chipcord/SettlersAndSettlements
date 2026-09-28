package net.chip.settlersandsettlements.villager;

import com.google.common.collect.ImmutableSet;
import net.chip.settlersandsettlements.SettlersAndSettlements;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, SettlersAndSettlements.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, SettlersAndSettlements.MOD_ID);

    public static final RegistryObject<PoiType> TARGET_POI = POI_TYPES.register("target_poi",
            () -> new PoiType(
                    ImmutableSet.copyOf(
                            Blocks.TARGET.getStateDefinition().getPossibleStates()
                    ),
                    1,
                    1
            ));

    public static final RegistryObject<VillagerProfession> HUNTER =
            VILLAGER_PROFESSIONS.register("hunter", () -> new VillagerProfession("hunter",
                    holder -> holder.get() == TARGET_POI.get(), holder -> holder.get() == TARGET_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
