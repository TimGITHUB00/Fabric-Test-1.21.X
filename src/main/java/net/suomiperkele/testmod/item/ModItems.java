package net.suomiperkele.testmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.suomiperkele.testmod.TestMod;
import java.util.function.Function;

public class ModItems {
    public static final Item RAW_EXPERIUM = registerItem("raw_experium", Item::new);
    public static final Item EXPERIUM_INGOT = registerItem("experium_ingot", Item::new);

    public static final Item EXPERIUM_SWORD = registerItem("experium_sword",
            setting -> new Item(setting.sword(ModToolMaterials.EXPERIUM, 3, -2.4f)));

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(TestMod.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TestMod.MOD_ID, name)))));
    }
    public static void registerModItems() {
        TestMod.LOGGER.info("Registering Mod Items for " + TestMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(EXPERIUM_INGOT);
            entries.add(RAW_EXPERIUM);
    }
}
