package gtclassic.recipe;

import gtclassic.GTBlocks;
import gtclassic.material.GTMaterial;
import gtclassic.material.GTMaterialGen;
import gtclassic.tile.GTTileFusionComputer;
import ic2.core.block.machine.low.TileEntityCompressor;
import ic2.core.block.machine.low.TileEntityExtractor;
import ic2.core.block.machine.low.TileEntityMacerator;
import ic2.core.platform.registry.Ic2Items;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class GTRecipeProcessing {

	static GTMaterialGen GT;
	static GTMaterial M;

	public static void recipesProcessing() {

		/*
		 * Recipes specific to GT Classic ores
		 */
		maceratorUtil("oreBauxite", 1, GT.getDust(M.Bauxite, 4));
		maceratorUtil("oreIridium", 1, GT.getIc2(Ic2Items.iridiumOre, 2));
		maceratorUtil("orePyrite", 1, GT.getDust(M.Pyrite, 5));
		maceratorUtil("oreCinnabar", 1, GT.getDust(M.Cinnabar, 5));
		maceratorUtil("oreSphalerite", 1, GT.getDust(M.Sphalerite, 5));
		maceratorUtil("oreTungstate", 1, GT.getDust(M.Tungsten, 2));
		maceratorUtil("oreSheldonite", 1, GT.getDust(M.Platinum, 2));
		maceratorUtil("oreSodalite", 1, GT.getDust(M.Sodalite, 12));

		GameRegistry.addSmelting(GTBlocks.galenaOre, (GT.getIngot(M.Lead, 1)), 0.1F);
		GameRegistry.addSmelting(GT.getDust(M.Galena, 1), (GT.getIngot(M.Lead, 1)), 0.1F);
		GameRegistry.addSmelting(GTBlocks.iridiumOre, (GT.getIc2(Ic2Items.iridiumOre, 1)), 0.1F);
		GameRegistry.addSmelting(GT.getDust(M.Magnetite, 1), new ItemStack(Items.IRON_NUGGET, 3), 0.1F);
		GameRegistry.addSmelting(GTBlocks.pyriteOre, new ItemStack(Items.IRON_INGOT), 0.1F);

		TileEntityExtractor.addRecipe("oreRuby", 1, GT.getGem(M.Ruby, 3), 0.1F);
		TileEntityExtractor.addRecipe("oreSapphire", 1, GT.getGem(M.Sapphire, 3), 0.1F);
		TileEntityExtractor.addRecipe("oreOlivine", 1, GT.getGem(M.Olivine, 3), 0.1F);

		/*
		 * Maceration recipes not covered by Ic2c automatically or that need to be
		 * different
		 */
		TileEntityMacerator.addRecipe(new ItemStack(Items.FLINT, 1), GT.getDust(M.Flint, 1), 0.1F);
		TileEntityMacerator.addRecipe(Ic2Items.uraniumDrop, 1, GT.getDust(M.Uranium, 1), 0.1F);
		TileEntityMacerator.addRecipe("enderpearl", 1, GT.getDust(M.EnderPearl, 1), 0.2F);
		TileEntityMacerator.addRecipe(new ItemStack(Items.ENDER_EYE, 1), GT.getDust(M.EnderEye, 1), 0.2F);
		TileEntityMacerator.addRecipe("gemDiamond", 1, GT.getDust(M.Diamond, 1), 0.1F);
		TileEntityMacerator.addRecipe("gemEmerald", 1, GT.getDust(M.Emerald, 1), 0.1F);

		/*
		 * Compressor recipes
		 */
		TileEntityCompressor.addRecipe(GT.getChemical(M.Carbon, 8), GT.getIc2(Ic2Items.carbonFiber, 1), 0.1F);
		TileEntityCompressor.addRecipe("dustUranium", 1, GT.getIc2(Ic2Items.uraniumIngot, 1), 0.1F);
		TileEntityCompressor.addRecipe("dustEmerald", 1, new ItemStack(Items.EMERALD), 0.1F);
		TileEntityCompressor.addRecipe("dustDiamond", 1, new ItemStack(Items.DIAMOND), 0.1F);

		/*
		 * Just a test fusion recipe
		 */
		GTTileFusionComputer.addRecipe("dustTungsten",1, GT.getChemical(M.Lithium, 1), GT.getIc2(Ic2Items.iridiumOre, 1));
		GTTileFusionComputer.addRecipe("dustTungsten",1, GT.getChemical(M.Berilium, 1), GT.getDust(M.Platinum, 1));

	}

	/*
	 * Adds a macerator recipe while removing duplicates generated by ic2c
	 */
	public static void maceratorUtil(String input, int amount, ItemStack output) {
		TileEntityMacerator.oreBlacklist.add(input);
		TileEntityMacerator.addRecipe(input, amount, output, 0.1F);
	}

}