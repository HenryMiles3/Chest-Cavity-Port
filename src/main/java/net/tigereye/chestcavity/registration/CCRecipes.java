package net.tigereye.chestcavity.registration;

import net.minecraft.recipe.*;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.tigereye.chestcavity.ChestCavity;
import net.tigereye.chestcavity.recipes.InfuseVenomGland;
import net.tigereye.chestcavity.recipes.SalvageRecipe;
import net.tigereye.chestcavity.recipes.json.SalvageRecipeSerializer;

public class CCRecipes {
    public static SpecialRecipeSerializer<InfuseVenomGland> INFUSE_VENOM_GLAND;
    public static Identifier SALVAGE_RECIPE_ID = Identifier.of(ChestCavity.MODID,"crafting_salvage");
    public static RecipeType<SalvageRecipe> SALVAGE_RECIPE_TYPE = new RecipeType<SalvageRecipe>() {public String toString() {return SALVAGE_RECIPE_ID.toString();}};
    public static SalvageRecipeSerializer SALVAGE_RECIPE_SERIALIZER;

    public static void register() {
        SALVAGE_RECIPE_TYPE = Registry.register(Registries.RECIPE_TYPE, SALVAGE_RECIPE_ID, SALVAGE_RECIPE_TYPE);
        SALVAGE_RECIPE_SERIALIZER = register(SALVAGE_RECIPE_ID, new SalvageRecipeSerializer());
        INFUSE_VENOM_GLAND = (SpecialRecipeSerializer<InfuseVenomGland>) Registry.register(Registries.RECIPE_SERIALIZER, "crafting_special_infuse_venom_gland", new SpecialRecipeSerializer<InfuseVenomGland>(InfuseVenomGland::new));
    }

    public static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(Identifier id, S serializer) {
        return Registry.register(Registries.RECIPE_SERIALIZER, id, serializer);
    }
}