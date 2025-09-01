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
            Identifier.of(TestMod.MOD_ID, "experium_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.EXPERIUM_INGOT))
                    .displayName(Text.translatable("itemgroup.testmod.experium_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.EXPERIUM_INGOT);
                        entries.add(ModItems.RAW_EXPERIUM);

                        entries.add(ModItems.EXPERIUM_SWORD);
                        entries.add(ModItems.EXPERIUM_PICKAXE);
                        entries.add(ModItems.EXPERIUM_SHOVEL);
                        entries.add(ModItems.EXPERIUM_AXE);
                        entries.add(ModItems.EXPERIUM_HOE);

                    }).build());

    public static final ItemGroup ALUMINUM_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TestMod.MOD_ID, "experium_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.EXPERIUM_BLOCK))
                    .displayName(Text.translatable("itemgroup.testmod.experium_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.RAW_EXPERIUM_BLOCK);
                        entries.add(ModBlocks.EXPERIUM_BLOCK);
                        entries.add(ModBlocks.EXPERIUM_ORE);
                    }).build());

    public static void registerItemGroups() {
        TestMod.LOGGER.info("Registering Item Groups for " + TestMod.MOD_ID);
    }
}
