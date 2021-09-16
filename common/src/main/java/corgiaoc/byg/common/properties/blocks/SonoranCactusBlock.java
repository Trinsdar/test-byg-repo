package corgiaoc.byg.common.properties.blocks;



import com.google.common.jimfs.PathType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;
import java.util.Random;

@SuppressWarnings("deprecation")
public class SonoranCactusBlock extends Block {

    public static final BooleanProperty NORTH = PipeBlock.NORTH;
    public static final BooleanProperty EAST = PipeBlock.EAST;
    public static final BooleanProperty SOUTH = PipeBlock.SOUTH;
    public static final BooleanProperty WEST = PipeBlock.WEST;
    public static final BooleanProperty UP = PipeBlock.UP;
    public static final BooleanProperty DOWN = PipeBlock.DOWN;
    public static final Map<Direction, BooleanProperty> FACING_TO_PROPERTY_MAP = PipeBlock.PROPERTY_BY_DIRECTION;

    protected static final VoxelShape collisionShape = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 15.0D, 15.0D);
    protected static final VoxelShape shape = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public SonoranCactusBlock(String registryName) {
        super(BlockBehaviour.Properties.of(Material.CACTUS).randomTicks().strength(0.4F).sound(SoundType.WOOL));
        //setRegistryName(registryName);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.makeConnections(context.getLevel(), context.getClickedPos());
    }

    public BlockState makeConnections(BlockGetter reader, BlockPos pos) {
        Block blockDown = reader.getBlockState(pos.below()).getBlock();
        Block blockUp = reader.getBlockState(pos.above()).getBlock();
        Block blockNorth = reader.getBlockState(pos.north()).getBlock();
        Block blockEast = reader.getBlockState(pos.east()).getBlock();
        Block blockSouth = reader.getBlockState(pos.south()).getBlock();
        Block blockWest = reader.getBlockState(pos.west()).getBlock();
        return this.defaultBlockState().setValue(DOWN, Boolean.valueOf(blockDown == this || blockDown == Blocks.SAND)).setValue(UP, Boolean.valueOf(blockUp == this)).setValue(NORTH, Boolean.valueOf(blockNorth == this)).setValue(EAST, Boolean.valueOf(blockEast == this)).setValue(SOUTH, Boolean.valueOf(blockSouth == this)).setValue(WEST, Boolean.valueOf(blockWest == this));
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (!stateIn.canSurvive(worldIn, currentPos)) {
            worldIn.getBlockTicks().scheduleTick(currentPos, this, 1);
        }

        return super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @Override
    public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, Random rand) {
        if (!state.canSurvive(worldIn, pos)) {
            worldIn.destroyBlock(pos, true);
        }
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
        int connectionsNorth = 0;
        int connectionsSouth = 0;
        int connectionsEast = 0;
        int connectionsWest = 0;
        boolean checkStemFlag = true;
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            if (worldIn.getBlockState(pos.relative(Direction.UP)).getBlock() == this
                    && worldIn.getBlockState(pos.relative(direction)).getBlock() == this
                    && worldIn.getBlockState(pos.relative(Direction.DOWN)).getBlock() == Blocks.SAND)
                return false;


            if (worldIn.getBlockState(pos.relative(Direction.DOWN)).getBlock() == this)
                for (int idx = 0; idx < 3; idx++)
                    if (worldIn.getBlockState(pos.relative(Direction.DOWN).relative(Direction.DOWN).relative(direction, idx)).getBlock() == this)
                        checkStemFlag = false;
        }

        for (int idx = 1; idx <= 5; idx++) {
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                if (worldIn.getBlockState(pos.relative(direction, idx)).getBlock() == this) {
                    if (direction == Direction.NORTH)
                        connectionsNorth++;
                    if (direction == Direction.SOUTH)
                        connectionsSouth++;
                    if (direction == Direction.EAST)
                        connectionsEast++;
                    if (direction == Direction.WEST)
                        connectionsWest++;

                }
            }
        }

        int connectionsTotal = connectionsNorth + connectionsSouth + connectionsEast + connectionsWest;
        if (connectionsNorth > 3 || connectionsSouth > 3 || connectionsEast > 3 || connectionsWest > 3 /*&& connectionsTotal > 5*/) {
            return false;
        }

        if (!checkStemFlag)
            return false;

        return (
                worldIn.getBlockState(pos.relative(Direction.NORTH)).getBlock() == this
                        || worldIn.getBlockState(pos.relative(Direction.WEST)).getBlock() == this
                        || worldIn.getBlockState(pos.relative(Direction.SOUTH)).getBlock() == this
                        || worldIn.getBlockState(pos.relative(Direction.EAST)).getBlock() == this
                        || worldIn.getBlockState(pos.relative(Direction.DOWN)).getBlock() == this
                        || worldIn.getBlockState(pos.relative(Direction.WEST).relative(Direction.DOWN)).getBlock() == this
                        || worldIn.getBlockState(pos.relative(Direction.SOUTH).relative(Direction.DOWN)).getBlock() == this
                        || worldIn.getBlockState(pos.relative(Direction.EAST).relative(Direction.DOWN)).getBlock() == this
                        || worldIn.getBlockState(pos.relative(Direction.NORTH).relative(Direction.DOWN)).getBlock() == this
                        || worldIn.getBlockState(pos.relative(Direction.DOWN)).getBlock() == Blocks.SAND
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN);
    }

    //@Override
    public boolean isPathfindable(BlockState state, BlockGetter worldIn, BlockPos pos, PathType type) {
        return false;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return collisionShape;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return shape;
    }

    public void entityInside(BlockState state, Level worldIn, BlockPos pos, Entity entityIn) {
        entityIn.hurt(DamageSource.CACTUS, 1.0F);
    }
}
