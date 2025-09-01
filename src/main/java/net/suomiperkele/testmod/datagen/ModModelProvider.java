package net.suomiperkele.testmod.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.suomiperkele.testmod.block.ModBlocks;
import net.suomiperkele.testmod.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.EXPERIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_EXPERIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.EXPERIUM_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.EXPERIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_EXPERIUM, Models.GENERATED);

        itemModelGenerator.register(ModItems.EXPERIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EXPERIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EXPERIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EXPERIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.EXPERIUM_HOE, Models.HANDHELD);
    }
}
