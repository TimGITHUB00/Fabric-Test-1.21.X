package net.suomiperkele.testmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.suomiperkele.testmod.TestMod;
import net.suomiperkele.testmod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup ALUMINUM_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TestMod.MOD_ID, "aluminum_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ALUMINUM_INGOT))
                    .displayName(Text.translatable("itemgroup.testmod.aluminum_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ALUMINUM_INGOT);
                        entries.add(ModItems.RAW_ALUMINUM);
                    }).build());

    public static final ItemGroup ALUMINUM_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TestMod.MOD_ID, "aluminum_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.ALUMINUM_BLOCK))
                    .displayName(Text.translatable("itemgroup.testmod.aluminum_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.ALUMINUM_BLOCK);
                    }).build());

    public static void registerItemGroups() {
        TestMod.LOGGER.info("Registering Item Groups for " + TestMod.MOD_ID);
    }
}
