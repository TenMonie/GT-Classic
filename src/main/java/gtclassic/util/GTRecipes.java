package gtclassic.util;

import java.util.ArrayList;

import com.google.common.collect.Lists;

import ic2.api.classic.recipe.ClassicRecipes;
import ic2.api.classic.recipe.crafting.ICraftingRecipeList;
import ic2.core.block.machine.low.TileEntityCompressor;
import ic2.core.block.machine.low.TileEntityMacerator;
import ic2.core.platform.registry.Ic2Items;
import ic2.core.util.misc.StackUtil;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.ForgeRegistry;

public class GTRecipes {
	
	public static void init() {
        GTRecipes.initSmeltingRecipes();
        //GTRecipes.initReplaceRecipes(); Figure out how to remove advancement errors when doing this
        GTRecipes.initShapelessRecipes();
        GTRecipes.initShapedRecipes();
        GTRecipes.initMachineRecipes();
     }
	
	static ICraftingRecipeList recipes = ClassicRecipes.advCrafting;

	public static void initSmeltingRecipes() {
		
		GameRegistry.addSmelting(GTBlocks.rubyBlock, new ItemStack(GTItems.ruby, 9), 0.1F);
		GameRegistry.addSmelting(GTBlocks.sapphireBlock, new ItemStack(GTItems.sapphire, 9), 0.1F);
		GameRegistry.addSmelting(GTBlocks.aluminumBlock, new ItemStack(GTItems.ingotAluminum, 9), 0.1F);
		GameRegistry.addSmelting(GTItems.dustAluminum, new ItemStack(GTItems.ingotAluminum, 1), 0.3F);
		GameRegistry.addSmelting(GTBlocks.chromeBlock, new ItemStack(GTItems.ingotAluminum, 9), 0.1F);
		GameRegistry.addSmelting(GTItems.dustChrome, new ItemStack(GTItems.ingotChrome, 1), 0.3F);
		GameRegistry.addSmelting(GTBlocks.titaniumBlock, new ItemStack(GTItems.ingotTitanium, 9), 0.1F);
		GameRegistry.addSmelting(GTItems.dustTitanium, new ItemStack(GTItems.ingotTitanium, 1), 0.3F);
		
		GameRegistry.addSmelting(GTBlocks.sandIron, new ItemStack(Items.IRON_NUGGET, 3), 0.1F);
	}
	
	public static void initReplaceRecipes() {
			 ForgeRegistry<IRecipe> recipeRegistry = (ForgeRegistry<IRecipe>)ForgeRegistries.RECIPES;
		        ArrayList<IRecipe> recipesList = Lists.newArrayList(recipeRegistry.getValuesCollection());
		        
		        for (IRecipe r : recipesList){
	                ItemStack output = r.getRecipeOutput();
	             
	                if (output.getItem() == Item.getItemFromBlock(Blocks.IRON_BLOCK)){
	                	recipeRegistry.remove(r.getRegistryName());
	                	TileEntityCompressor.addRecipe("ingotIron", 9, new ItemStack(Blocks.IRON_BLOCK), 0.1F);
	                }
	                if (output.getItem() == Item.getItemFromBlock(Blocks.GOLD_BLOCK)){
	                	recipeRegistry.remove(r.getRegistryName());
	                	TileEntityCompressor.addRecipe("ingotGold", 9, new ItemStack(Blocks.GOLD_BLOCK), 0.1F);
	                }
	                if (output.getItem() == Item.getItemFromBlock(Blocks.DIAMOND_BLOCK)){
	                    recipeRegistry.remove(r.getRegistryName());
	                    TileEntityCompressor.addRecipe("gemDiamond", 9, new ItemStack(Blocks.DIAMOND_BLOCK), 0.1F);
	                }
	                if (output.getItem() == Item.getItemFromBlock(Blocks.EMERALD_BLOCK)){
	                    recipeRegistry.remove(r.getRegistryName());
	                    TileEntityCompressor.addRecipe("gemEmerald", 9, new ItemStack(Blocks.EMERALD_BLOCK), 0.1F);
	                }
	                if (output.getItem() == Item.getItemFromBlock(Blocks.LAPIS_BLOCK)){
	                    recipeRegistry.remove(r.getRegistryName());
	                    TileEntityCompressor.addRecipe("gemLapis", 9, new ItemStack(Blocks.LAPIS_BLOCK), 0.1F);
	                }
	                if (output.getItem() == Item.getItemFromBlock(Blocks.REDSTONE_BLOCK)){
	                    recipeRegistry.remove(r.getRegistryName());
	                    TileEntityCompressor.addRecipe("dustRedstone", 9, new ItemStack(Blocks.REDSTONE_BLOCK), 0.1F);
	                }
	                if (output.getItem() == Item.getItemFromBlock(Blocks.GLOWSTONE)){
	                    recipeRegistry.remove(r.getRegistryName());
	                    TileEntityCompressor.addRecipe("dustGlowstone", 4, new ItemStack(Blocks.GLOWSTONE), 0.1F);
	                }
	                if (output.getItem() == Item.getItemFromBlock(Blocks.QUARTZ_BLOCK)){
	                    recipeRegistry.remove(r.getRegistryName());
	                    TileEntityCompressor.addRecipe(new ItemStack(Items.QUARTZ, 4), new ItemStack(Blocks.QUARTZ_BLOCK), 0.1F);
	                }
	        }
	}

	public static void initShapelessRecipes () {
		
		recipes.addShapelessRecipe(new ItemStack(GTBlocks.iridiumReinforcedStoneBlock, 1),
				new Object[]{Ic2Items.reinforcedStone, "ingotIridium"});
	}
		
	public static void initShapedRecipes () {
		
		recipes.addRecipe(new ItemStack(GTItems.hammerIron, 1),
				new Object[]{"II ", "IIS", "II ", 'I', "ingotIron",'S', Items.STICK,});
		
		recipes.addRecipe(Ic2Items.energyCrystal.copy(),
				new Object[]{"RRR", "RDR", "RRR", 'D', "gemRuby", 'R', "dustRedstone"});
		
		recipes.addRecipe(Ic2Items.lapotronCrystal.copy(), 
				new Object[]{"LCL", "LDL", "LCL", 'D', "gemSapphire", 'C', Ic2Items.electricCircuit.copy(), 'L', "gemLapis"});
		
		recipes.addRecipe(new ItemStack(GTItems.lapotronicEnergyOrb, 1),
				new Object[]{"LLL", "LPL", "LLL", 'L', Ic2Items.lapotronCrystal.copy(),'P', Ic2Items.iridiumPlate.copy()});
		
		recipes.addRecipe(new ItemStack(GTItems.energyFlowCircuit, 4),
				new Object[]{"CLC", "LPL", "CLC", 'L', Ic2Items.lapotronCrystal.copy(),'C', Ic2Items.advancedCircuit.copy(), 'P', Ic2Items.iridiumPlate.copy()});
		
		recipes.addRecipe(new ItemStack(GTItems.superConductor, 4),
				new Object[]{"CCC", "PWP", "EEE", 'C', Ic2Items.reactorCoolantCellSix.copy(),'E', GTItems.energyFlowCircuit, 'W', GTItems.cellW, 'P', Ic2Items.iridiumPlate.copy()});
		
		recipes.addRecipe(new ItemStack(GTItems.lapotronPack, 1),
				new Object[]{"ELE", "SBS", "EPE", 'E', GTItems.energyFlowCircuit, 'S', GTItems.superConductor, 'L', GTItems.lapotronicEnergyOrb, 'B', Ic2Items.lapPack.copy(), 'P', Ic2Items.iridiumPlate.copy()});
		
		recipes.addRecipe(new ItemStack(GTItems.destructoPack, 1),
				new Object[]{"BIB", "ICI", "BIB", 'B', Items.LAVA_BUCKET,'C', Ic2Items.electricCircuit.copy(), 'I', Ic2Items.refinedIronIngot.copy()});
		
		recipes.addRecipe(new ItemStack(GTItems.destructoPack, 1),
				new Object[]{"BIB", "ICI", "BIB", 'B', Items.LAVA_BUCKET,'C', Ic2Items.electricCircuit.copy(), 'I', "ingotAluminum"});
		
		recipes.addRecipe(new ItemStack(GTItems.teslaStaff, 1),
				new Object[]{"LS ", "SP ", "  P", 'L', GTItems.lapotronicEnergyOrb, 'S', GTItems.superConductor, 'P', Ic2Items.iridiumPlate.copy()});

	}
	
	public static void initMachineRecipes () {
		
		TileEntityCompressor.addRecipe("dustEnderPearl", 1, new ItemStack(Items.ENDER_PEARL), 0.1F);
		TileEntityCompressor.addRecipe("dustEnderEye", 2, new ItemStack(Items.ENDER_EYE), 0.1F);
		
		TileEntityCompressor.addRecipe("dustSapphire", 1, new ItemStack(GTItems.sapphire), 0.1F);
		TileEntityCompressor.addRecipe("dustRuby", 1, new ItemStack(GTItems.ruby), 0.1F);
		TileEntityCompressor.addRecipe("dustSapphire", 1, new ItemStack(GTItems.sapphire), 0.1F);
		TileEntityCompressor.addRecipe("dustEmerald", 1, new ItemStack(Items.EMERALD), 0.1F);
		TileEntityCompressor.addRecipe(Ic2Items.iridiumOre, 1, new ItemStack(GTItems.ingotIridium), 0.5F);

		TileEntityCompressor.addRecipe("gemRuby", 9, new ItemStack(GTBlocks.rubyBlock), 0.1F);
		TileEntityCompressor.addRecipe("gemSapphire", 9, new ItemStack(GTBlocks.sapphireBlock), 0.1F);
		TileEntityCompressor.addRecipe("ingotAluminum", 9, new ItemStack(GTBlocks.aluminumBlock), 0.1F);
		TileEntityCompressor.addRecipe("ingotChrome", 9, new ItemStack(GTBlocks.chromeBlock), 0.1F);
		TileEntityCompressor.addRecipe("ingotTitanium", 9, new ItemStack(GTBlocks.titaniumBlock), 0.1F);
		
		TileEntityMacerator.addRecipe(new ItemStack(Items.ENDER_PEARL, 1), StackUtil.copyWithSize(new ItemStack(GTItems.dustEnderpearl), 1), 0.3F);
		TileEntityMacerator.addRecipe(new ItemStack(Items.ENDER_EYE, 1), StackUtil.copyWithSize(new ItemStack(GTItems.dustEnderEye), 2), 0.5F);
		
		TileEntityMacerator.addRecipe("oreRuby", 1, StackUtil.copyWithSize(new ItemStack(GTItems.ruby), 2), 0.3F);
		TileEntityMacerator.addRecipe("oreSapphire", 1, StackUtil.copyWithSize(new ItemStack(GTItems.sapphire), 2), 0.3F);
		TileEntityMacerator.addRecipe("oreBauxite", 1, StackUtil.copyWithSize(new ItemStack(GTItems.dustBauxite), 4), 0.1F);
		TileEntityMacerator.addRecipe("oreIridium", 1, StackUtil.copyWithSize(Ic2Items.iridiumOre, 2), 1.0F);
		
		TileEntityMacerator.addRecipe("gemRuby", 1, StackUtil.copyWithSize(new ItemStack(GTItems.dustRuby), 1), 0.1F);
		TileEntityMacerator.addRecipe("gemSapphire", 1, StackUtil.copyWithSize(new ItemStack(GTItems.dustSapphire), 1), 0.1F);
		TileEntityMacerator.addRecipe("ingotAluminum", 1, StackUtil.copyWithSize(new ItemStack(GTItems.dustAluminum), 1), 0.1F);
		TileEntityMacerator.addRecipe("ingotChrome", 1, StackUtil.copyWithSize(new ItemStack(GTItems.dustChrome), 1), 0.1F);
		TileEntityMacerator.addRecipe("ingotTitanium", 1, StackUtil.copyWithSize(new ItemStack(GTItems.dustTitanium), 1), 0.1F);
		
		TileEntityMacerator.addRecipe("blockRuby", 1, StackUtil.copyWithSize(new ItemStack(GTItems.dustRuby), 9), 0.1F);
		TileEntityMacerator.addRecipe("blockSapphire", 1, StackUtil.copyWithSize(new ItemStack(GTItems.dustSapphire), 9), 0.1F);
		TileEntityMacerator.addRecipe("blockAluminum", 1, StackUtil.copyWithSize(new ItemStack(GTItems.dustAluminum), 9), 0.1F);
		TileEntityMacerator.addRecipe("blockChrome", 1, StackUtil.copyWithSize(new ItemStack(GTItems.dustChrome), 9), 0.1F);
		TileEntityMacerator.addRecipe("blockTitanium", 1, StackUtil.copyWithSize(new ItemStack(GTItems.dustTitanium), 9), 0.1F);
		
		
	}

}
