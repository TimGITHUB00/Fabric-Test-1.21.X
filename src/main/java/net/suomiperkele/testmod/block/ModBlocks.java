package net.suomiperkele.testmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.suomiperkele.testmod.TestMod;

import java.util.function.Function;

public class ModBlocks {
    public static final Block RAW_EXPERIUM_BLOCK = register("raw_experium_block", Block::new, AbstractBlock.Settings.create().
            strength(3f).requiresTool().sounds(BlockSoundGroup.IRON), true);
    public static final Block EXPERIUM_BLOCK = register("experium_block", Block::new, AbstractBlock.Settings.create().
            strength(4f).requiresTool().sounds(BlockSoundGroup.IRON), true);
    public static final Block EXPERIUM_ORE = register("experium_ore", Block::new, AbstractBlock.Settings.create().
            strength(3f).requiresTool().sounds(BlockSoundGroup.STONE), true);

    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        RegistryKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.registryKey(blockKey));
        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = keyOfItem(name);
            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }
        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(TestMod.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TestMod.MOD_ID, name));
    }

    public static void registerModBlocks() {
        TestMod.LOGGER.info("Registering Mod Blocks for " + TestMod.MOD_ID);
    }
}
