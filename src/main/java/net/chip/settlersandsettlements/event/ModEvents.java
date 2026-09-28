package net.chip.settlersandsettlements.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.chip.settlersandsettlements.SettlersAndSettlements;
import net.chip.settlersandsettlements.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = SettlersAndSettlements.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == ModVillagers.HUNTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 3),
                    new ItemStack(Items.LEATHER, 12),
                    2, 8, 0.02f
            ));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    new ItemStack(Items.BONE, 16),
                    2, 8, 0.02f
            ));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.CROSSBOW, 1),
                    new ItemStack(Items.EMERALD, 10),
                    2, 8, 0.02f
            ));

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.IRON_SWORD, 1),
                    new ItemStack(Items.EMERALD, 18),
                    2, 8, 0.02f
            ));

            ItemStack potion = new ItemStack(Items.POTION);
            PotionUtils.setPotion(potion, Potions.NIGHT_VISION);

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 28),
                    potion,
                    2, 8, 0.02f
            ));
        }
    }
}
