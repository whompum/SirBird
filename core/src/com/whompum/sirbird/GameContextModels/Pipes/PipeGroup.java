package com.whompum.sirbird.GameContextModels.Pipes;

import com.badlogic.gdx.math.Rectangle;
import com.whompum.sirbird.Logger;

import java.util.Random;

/**
 * Represents two vertical pipes in a column.
 *
 * There is a gap between the two pipes. Gap position / Top pipe height
 * is determined solely by the bottom pipe height
 */
public class PipeGroup {

    public static final int PIPE_GAP = 46; /*Test number*/

    private Pipe[] pipes = new Pipe[2];

    private int floorPipeHeight;
    private int cielPipeHeight;

    private int pipeGap = PIPE_GAP;
    private int totalHeight;

    private Rectangle bounds;

    private Random random = new Random();

    private final float[] btmPipeHeights = new float[5];

    public PipeGroup(final int totalHeight,
                     final int contextWidth,
                     final int minPipeHeight){

        this.totalHeight = totalHeight;
        this.floorPipeHeight = minPipeHeight;

        final Pipe btmPipe = new Pipe( getBottomPipeHeight(), contextWidth, totalHeight );

        final Pipe topPipe = new Pipe( getTopPipeHeight( btmPipe ), contextWidth, totalHeight, false ); //Make AFTER

        pipes[0] = topPipe;
        pipes[1] = btmPipe;

        bounds = new Rectangle().setWidth( Pipe.HEAD_WIDTH ).setHeight( totalHeight ).setY( totalHeight );

        cielPipeHeight = totalHeight - pipeGap - minPipeHeight; //max btm pipe height of the bottom height

        btmPipeHeights[0] = 0.0F;
        btmPipeHeights[1] = 0.2F;
        btmPipeHeights[2] = 0.4F;
        btmPipeHeights[3] = 0.7F;
        btmPipeHeights[4] = 1.0F;


    }

    private int getTopPipeHeight(final Pipe bottomPipe){
        return totalHeight - bottomPipe.getHeight() - pipeGap;
    }

    /**
     * Generates a new Height for the pipes essentialy by taking a fraction of what the largest possible size can be
     * for the new height. The fraction comes from the array `btmPipeHeights` and its indices are randomly queried.
     * Since are pipes will be positioned between A - N, not 0 - N we scale the value down before finding its fraction, then
     * scale it back up.
     *
     * @return a new height for the bottom pipe
     */
    private int getBottomPipeHeight(){
        return (int)( (cielPipeHeight - floorPipeHeight) * btmPipeHeights[random.nextInt( btmPipeHeights.length )]) + floorPipeHeight;
    }

    public Pipe[] getPipes() {
        return pipes;
    }

    public int getEnd(){
        return (int)(bounds.x+bounds.getWidth());
    }

    public void updateHeights(){
        pipes[1].setHeight( getBottomPipeHeight() );
        pipes[0].setHeight( getTopPipeHeight( pipes[1] ) );
    }

    public void setX(final int x){
        bounds.setX( x );
        pipes[0].setX( x );
        pipes[1].setX( x );
    }

    public void updateX(final float deltaPos){
        bounds.x -= deltaPos;

        pipes[0].setX( bounds.x );
        pipes[1].setX( bounds.x );
    }

}
