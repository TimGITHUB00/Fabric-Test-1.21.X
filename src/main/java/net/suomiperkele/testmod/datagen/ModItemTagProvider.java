package net.suomiperkele.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.suomiperkele.testmod.item.ModItems;
import net.suomiperkele.testmod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ModTags.Items.EXPERIUM_REPAIR)
                .add(ModItems.EXPERIUM_INGOT);

        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModItems.EXPERIUM_SWORD);
        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModItems.EXPERIUM_PICKAXE);
        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModItems.EXPERIUM_SHOVEL);
        valueLookupBuilder(ItemTags.AXES)
                .add(ModItems.EXPERIUM_AXE);
        valueLookupBuilder(ItemTags.HOES)
                .add(ModItems.EXPERIUM_HOE);
    }
}
