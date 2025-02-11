package net.blazecode.greencuts;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class GreenUtils
{
    public static boolean isSaplingStack(ItemStack item)
    {
        return Block.getBlockFromItem(item.getItem()) instanceof SaplingBlock;
    }

    public static boolean tryPlanting(Block block, ServerWorld world, BlockPos pos)
    {
        BlockState state = block.getDefaultState();

        int randInt = 0;
        int checkerInt = (100 - GreenMod.getConfig().getPlantChance());
        if(checkerInt > 0)
        {
            randInt = world.random.nextInt(checkerInt);
        }

        if(randInt == 0)
        {
            world.setBlockState(pos, state);
            return true;
        }

        return false;
    }
}
