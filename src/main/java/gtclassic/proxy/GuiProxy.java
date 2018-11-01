package gtclassic.proxy;

import gtclassic.blocks.cabinet.ContainerCabinet;
import gtclassic.blocks.cabinet.GuiCabinet;
import gtclassic.blocks.cabinet.TileEntityCabinet;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiProxy implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileEntityCabinet) {
            return new ContainerCabinet(player.inventory, (TileEntityCabinet) te);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileEntityCabinet) {
            TileEntityCabinet containerTileEntity = (TileEntityCabinet) te;
            return new GuiCabinet(containerTileEntity, new ContainerCabinet(player.inventory, containerTileEntity));
        }
        return null;
    }
}
