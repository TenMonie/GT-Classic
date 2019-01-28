package gtclassic;

import static ic2.core.platform.textures.Ic2Icons.addCustomTexture;
import static ic2.core.platform.textures.Ic2Icons.addSprite;
import static ic2.core.platform.textures.Ic2Icons.addTextureEntry;

import java.util.EnumSet;

import gtclassic.block.GTBlockTileBasic;
import gtclassic.block.GTBlockTileCustom;
import ic2.core.platform.textures.Sprites;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GTIcons {
	@SideOnly(Side.CLIENT)
	public static void loadSprites() {
		addSprite(new Sprites.SpriteData(GTMod.MODID + "_blocks", GTMod.MODID + ":textures/sprites/sprites_blocks.png",
				new Sprites.SpriteInfo(16, 16)));
		addSprite(new Sprites.SpriteData(GTMod.MODID + "_items", GTMod.MODID + ":textures/sprites/sprites_items.png",
				new Sprites.SpriteInfo(16, 16)));
		 
		addSprite(new Sprites.SpriteData(GTMod.MODID + "_dusts", GTMod.MODID + ":textures/sprites/sprites_dusts.png", new Sprites.SpriteInfo(16, 16)));
	        addSprite(new Sprites.SpriteData(GTMod.MODID + "_duststiny", GTMod.MODID + ":textures/sprites/sprites_duststiny.png", new Sprites.SpriteInfo(16, 16)));
	        addSprite(new Sprites.SpriteData(GTMod.MODID + "_nuggets", GTMod.MODID + ":textures/sprites/sprites_nuggets.png", new Sprites.SpriteInfo(16, 16)));
	        addSprite(new Sprites.SpriteData(GTMod.MODID + "_materials", GTMod.MODID + ":textures/sprites/sprites_materials.png", new Sprites.SpriteInfo(16, 16)));

		addSprite(new Sprites.SpriteData(GTMod.MODID + "_builder", GTMod.MODID + ":textures/sprites/builder.png",
				new Sprites.SpriteInfo(1, 12)));

		iterateBasicTileSpriteEnum();
		iterateCustomTileSpriteEnum();

		addTextureEntry(new Sprites.TextureEntry(GTMod.MODID + "_builder", 0, 0, 1, 12));
		addTextureEntry(new Sprites.TextureEntry(GTMod.MODID + "_blocks", 0, 0, 16, 12));
		addTextureEntry(new Sprites.TextureEntry(GTMod.MODID + "_items", 0, 0, 16, 5));
		
		 addTextureEntry(new Sprites.TextureEntry(GTMod.MODID + "_dusts", 0, 0, 16, 4));
	     addTextureEntry(new Sprites.TextureEntry(GTMod.MODID + "_duststiny", 0, 0, 16, 6));
	     addTextureEntry(new Sprites.TextureEntry(GTMod.MODID + "_nuggets", 0, 0, 16, 2));
	     addTextureEntry(new Sprites.TextureEntry(GTMod.MODID + "_materials", 0, 0, 16, 4));

		addCustomTexture("tile_digitalchest_lv", 0, 1, location("digitalchestlv_top"));
		addCustomTexture("tile_digitalchest_mv", 0, 1, location("digitalchestmv_top"));
		addCustomTexture("machine_fusioncomputer_iv", 0, 7, location("fusion_top"));
		addCustomTexture("machine_industrialcentrifuge_lv", 0, 7, location("centrifuge_top"));
		addCustomTexture("machine_industrialcentrifuge_lv", 0, 8, location("centrifuge_back"));
		addCustomTexture("machine_industrialcentrifuge_lv", 0, 9, location("centrifuge_front"));

	}

	private static ResourceLocation location(String name) {
		return new ResourceLocation(GTMod.MODID, "animations/" + name);
	}

	public static void iterateBasicTileSpriteEnum() {
		EnumSet.allOf(GTBlockTileBasic.GTBlockTileBasicVariants.class)
				.forEach(variant -> addSprite(new Sprites.SpriteData("" + variant.toString().toLowerCase(),
						GTMod.MODID + ":textures/sprites/" + variant.toString().toLowerCase() + ".png",
						new Sprites.SpriteInfo(1, 12))));
		EnumSet.allOf(GTBlockTileBasic.GTBlockTileBasicVariants.class).forEach(variant -> addTextureEntry(
				new Sprites.TextureEntry("" + variant.toString().toLowerCase(), 0, 0, 1, 12)));

	}

	public static void iterateCustomTileSpriteEnum() {
		EnumSet.allOf(GTBlockTileCustom.GTBlockTileCustomVariants.class)
				.forEach(variant -> addSprite(new Sprites.SpriteData("" + variant.toString().toLowerCase(),
						GTMod.MODID + ":textures/sprites/" + variant.toString().toLowerCase() + ".png",
						new Sprites.SpriteInfo(1, 12))));
		EnumSet.allOf(GTBlockTileCustom.GTBlockTileCustomVariants.class).forEach(variant -> addTextureEntry(
				new Sprites.TextureEntry("" + variant.toString().toLowerCase(), 0, 0, 1, 12)));

	}
}
