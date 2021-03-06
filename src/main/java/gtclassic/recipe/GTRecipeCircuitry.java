package gtclassic.recipe;

import gtclassic.GTBlocks;
import gtclassic.GTItems;
import gtclassic.material.GTMaterial;
import gtclassic.material.GTMaterialGen;
import ic2.api.classic.recipe.ClassicRecipes;
import ic2.api.classic.recipe.crafting.ICraftingRecipeList;
import ic2.api.recipe.IRecipeInput;
import ic2.core.block.machine.low.TileEntityCompressor;
import ic2.core.block.machine.low.TileEntityMacerator;
import ic2.core.block.machine.low.TileEntitySawMill;
import ic2.core.item.recipe.entry.RecipeInputCombined;
import ic2.core.item.recipe.entry.RecipeInputItemStack;
import ic2.core.item.recipe.entry.RecipeInputOreDict;
import ic2.core.platform.registry.Ic2Items;
import net.minecraft.init.Items;

public class GTRecipeCircuitry {

	static ICraftingRecipeList recipes = ClassicRecipes.advCrafting;
	static GTMaterialGen GT;
	static GTMaterial M;

	public static IRecipeInput basicCircuitPlate = new RecipeInputCombined(1,
			new IRecipeInput[] { new RecipeInputOreDict("plateSilicon"), new RecipeInputOreDict("plateGermanium") });

	public static void recipesCircutry() {

		/*
		 * Many of the recipes are subject to change as the list of machines populates.
		 * For now they allow testing and progression to happen.
		 */

		recipes.addShapelessRecipe(GT.getDust(M.MagnesiaCarbon, 4),
				new Object[] { "dustMagnesium", "dustCarbon", "dustSilicon", "dustClay" });

		TileEntityCompressor.addRecipe("dustMagnesiaCarbon", 1, GT.get(GTItems.magnesiaBrick), 0);

		recipes.addShapelessRecipe(GT.get(GTBlocks.stoneMagnesia, 1), new Object[] { GTItems.magnesiaBrick,
				GTItems.magnesiaBrick, GTItems.magnesiaBrick, GTItems.magnesiaBrick });

		TileEntitySawMill.addRecipe(GT.get(GTBlocks.driedResin), GT.get(GTItems.resinPCB), 0.0F);
		TileEntityCompressor.addRecipe("dustWood", 1, GT.get(GTItems.woodPlate));
		TileEntityMacerator.addRecipe(GT.getIc2(Ic2Items.stickyResin, 1), GT.getDust(M.DirtyResin, 2));
		TileEntityMacerator.addRecipe("plankWood", 1, GT.getDust(M.Wood, 2));
		TileEntityMacerator.addRecipe("logWood", 1, GT.getDust(M.Wood, 8));

		String knife = "craftingToolKnife";

		recipes.addShapelessRecipe(GT.getDust(M.DirtyResin, 1),
				new Object[] { "craftingToolKnife", GT.getIc2(Ic2Items.stickyResin, 1) });
		recipes.addShapelessRecipe(GT.get(GTItems.resinPCB), new Object[] { knife, GTBlocks.driedResin });

		recipes.addRecipe(GT.get(GTItems.basicTransistor, 1),
				new Object[] { "WPW", 'W', "wireFineAny", 'P', "plateSmallGermanium" });

		recipes.addRecipe(GT.get(GTItems.basicCapacitor, 1),
				new Object[] { "FPF", "L L", 'F', "foilTantalum", 'P', Items.PAPER, 'L', "wireFineAny" });

		recipes.addRecipe(GT.get(GTItems.basicCapacitor, 1),
				new Object[] { "FPF", "L L", 'F', "foilNiobium", 'P', Items.PAPER, 'L', "wireFineAny" });

		recipes.addRecipe(GT.get(GTItems.basicCapacitor, 1),
				new Object[] { "FPF", "L L", 'F', "foilAluminium", 'P', Items.PAPER, 'L', "wireFineAny" });

		// Gating basic circuits

		recipes.overrideRecipe("shaped_Electronic Circuit", GT.getIc2(Ic2Items.electricCircuit, 1), "WWW", "TSC", "WWW",
				'T', GTItems.basicTransistor, 'C', GTItems.basicCapacitor, 'W', "wireFineRedAlloy", 'S',
				GTItems.resinPCB);

		recipes.overrideRecipe("shaped_Electronic Circuit_1", GT.getIc2(Ic2Items.electricCircuit, 1), "WWW", "CST",
				"WWW", 'T', GTItems.basicTransistor, 'C', GTItems.basicCapacitor, 'W', "wireFineRedAlloy", 'S',
				GTItems.resinPCB);

		recipes.overrideRecipe("shaped_RE-Battery", GT.getIc2(Ic2Items.battery, 1), " C ", "TRT", "TRT", 'T',
				"ingotTin", 'R', "dustRedstone", 'C', Ic2Items.copperCable.copy());

		// stuff with lapotron and energium

		recipes.overrideRecipe("shaped_Energy Crystal", GT.getIc2(Ic2Items.energyCrystal, 1), "F ", " C", 'F',
				"craftingToolFile", 'C', GTBlocks.batteryEnergiumTiny);

		TileEntitySawMill.addRecipe(GT.get(GTBlocks.batteryEnergiumTiny), GT.getIc2(Ic2Items.energyCrystal, 1), 0.1F);

		IRecipeInput lowCrystal = new RecipeInputCombined(1,
				new IRecipeInput[] { new RecipeInputOreDict("gemDiamond"), new RecipeInputOreDict("gemRuby") });

		recipes.addRecipe(GT.get(GTBlocks.batteryEnergiumTiny),
				new Object[] { "RRR", "RDR", "RRR", 'D', lowCrystal, 'R', "dustRedstone" });

		IRecipeInput highCrystal = new RecipeInputCombined(1, new IRecipeInput[] {
				new RecipeInputOreDict("gemSapphire"), new RecipeInputItemStack(Ic2Items.energyCrystal.copy()) });

		IRecipeInput lapis = new RecipeInputCombined(1,
				new IRecipeInput[] { new RecipeInputOreDict("gemLapis"), new RecipeInputOreDict("dustLazurite") });

		recipes.overrideRecipe("shaped_Lapotron Crystal", GT.getIc2(Ic2Items.lapotronCrystal, 1), "F ", " C", 'F',
				"craftingToolFile", 'C', GTBlocks.batteryLapotronTiny);

		TileEntitySawMill.addRecipe(GT.get(GTBlocks.batteryLapotronTiny), GT.getIc2(Ic2Items.lapotronCrystal, 1), 0.1F);

		recipes.addRecipe(GT.get(GTBlocks.batteryLapotronTiny),
				new Object[] { "LCL", "LDL", "LCL", 'D', highCrystal, 'C', "circuitBasic", 'L', lapis });

		recipes.addRecipe(GT.get(GTBlocks.batteryLapotronSmall, 1),
				new Object[] { "LLL", "LPL", "LLL", 'L', GTBlocks.batteryLapotronTiny, 'P', "plateIridium" });

	}

}
