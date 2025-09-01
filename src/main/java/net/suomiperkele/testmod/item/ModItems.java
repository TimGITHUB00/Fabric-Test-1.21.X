package net.suomiperkele.testmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.suomiperkele.testmod.TestMod;
import java.util.function.Function;

public class ModItems {
    public static final Item RAW_ALUMINUM = registerItem("raw_aluminum", Item::new,new Item.Settings());
    public static final Item ALUMINUM_INGOT = registerItem("aluminum_ingot", Item::new,new Item.Settings());

    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("testmod", name));
        return Items.register(registryKey, factory, settings);
    }

    public static void registerModItems() {
        TestMod.LOGGER.info("Registering Mod Items for " + TestMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RAW_ALUMINUM);
            entries.add(ALUMINUM_INGOT);
        });
    }
}
