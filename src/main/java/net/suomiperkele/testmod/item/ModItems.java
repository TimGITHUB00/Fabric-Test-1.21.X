package net.suomiperkele.testmod.item;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.suomiperkele.testmod.TestMod;
import java.util.function.Function;

public class ModItems {
    public static final Item RAW_EXPERIUM = registerItem("raw_experium", Item::new,new Item.Settings());
    public static final Item EXPERIUM_INGOT = registerItem("experium_ingot", Item::new,new Item.Settings());

    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("testmod", name));
        return Items.register(registryKey, factory, settings);
    }

    public static void registerModItems() {
        TestMod.LOGGER.info("Registering Mod Items for " + TestMod.MOD_ID);

    }
}
