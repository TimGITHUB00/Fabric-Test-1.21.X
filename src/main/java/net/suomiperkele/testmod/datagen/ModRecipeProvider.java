package net.suomiperkele.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.item.Items;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.suomiperkele.testmod.block.ModBlocks;
import net.suomiperkele.testmod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                List<ItemConvertible> EXPERIUM_SMELTABLES = List.of(ModItems.RAW_EXPERIUM, ModBlocks.EXPERIUM_ORE);

                offerSmelting(EXPERIUM_SMELTABLES, RecipeCategory.MISC, ModItems.EXPERIUM_INGOT,  0.25f, 200, "experium_ingot");
                offerBlasting(EXPERIUM_SMELTABLES, RecipeCategory.MISC, ModItems.EXPERIUM_INGOT, 0.25f, 100, "experium_ingot");

                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.EXPERIUM_INGOT, RecipeCategory.DECORATIONS, ModBlocks.EXPERIUM_BLOCK);

                createShaped(RecipeCategory.MISC, ModBlocks.RAW_EXPERIUM_BLOCK)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .input('R', ModItems.RAW_EXPERIUM)
                        .criterion(hasItem(ModItems.RAW_EXPERIUM), conditionsFromItem(ModItems.RAW_EXPERIUM))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.MISC, ModItems.RAW_EXPERIUM, 9)
                        .input(ModBlocks.RAW_EXPERIUM_BLOCK)
                        .criterion(hasItem(ModBlocks.RAW_EXPERIUM_BLOCK), conditionsFromItem(ModBlocks.RAW_EXPERIUM_BLOCK))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.EXPERIUM_SWORD)
                        .pattern(" R ")
                        .pattern(" R ")
                        .pattern(" S ")
                        .input('R', ModItems.EXPERIUM_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.EXPERIUM_INGOT), conditionsFromItem(ModItems.EXPERIUM_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.EXPERIUM_PICKAXE)
                        .pattern("RRR")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('R', ModItems.EXPERIUM_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.EXPERIUM_INGOT), conditionsFromItem(ModItems.EXPERIUM_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.EXPERIUM_SHOVEL)
                        .pattern(" R ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('R', ModItems.EXPERIUM_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.EXPERIUM_INGOT), conditionsFromItem(ModItems.EXPERIUM_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.EXPERIUM_AXE)
                        .pattern("RR ")
                        .pattern("RS ")
                        .pattern(" S ")
                        .input('R', ModItems.EXPERIUM_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.EXPERIUM_INGOT), conditionsFromItem(ModItems.EXPERIUM_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.EXPERIUM_HOE)
                        .pattern("RR ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('R', ModItems.EXPERIUM_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.EXPERIUM_INGOT), conditionsFromItem(ModItems.EXPERIUM_INGOT))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "TestMod Recipes";
    }

}
