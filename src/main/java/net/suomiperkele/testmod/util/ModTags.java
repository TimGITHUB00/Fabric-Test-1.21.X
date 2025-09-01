package net.suomiperkele.testmod.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.suomiperkele.testmod.TestMod;

public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> NEEDS_EXPERIUM_TOOL = createTag("needs_experium_tool");
        public static final TagKey<Block> INCORRECT_FOR_EXPERIUM_TOOL = createTag("incorrect_for_experium_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(TestMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");
        public static final TagKey<Item> EXPERIUM_REPAIR = createTag("experium_repair");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(TestMod.MOD_ID, name));
        }
    }
}

