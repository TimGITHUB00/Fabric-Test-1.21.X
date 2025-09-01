package net.suomiperkele.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import net.suomiperkele.testmod.block.ModBlocks;
import net.suomiperkele.testmod.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.EXPERIUM_BLOCK);
        addDrop(ModBlocks.RAW_EXPERIUM_BLOCK);

        addDrop(ModBlocks.EXPERIUM_ORE, oreDrops(ModBlocks.EXPERIUM_ORE, ModItems.RAW_EXPERIUM));
    }
}
