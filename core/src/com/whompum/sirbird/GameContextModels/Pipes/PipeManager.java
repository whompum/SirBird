package com.whompum.sirbird.GameContextModels.Pipes;

import com.whompum.sirbird.Scrolling.OnScrollChangeListener;
import com.whompum.sirbird.Scrolling.Scroller;

public class PipeManager implements OnScrollChangeListener{

    public static final int SCROLL_VELOCITY = 1;

    private int contextWidth;

    private int pipeSpacingHor = 56;

    private PipeGroup p1;
    private PipeGroup p2;
    private PipeGroup p3;

    private Scroller scroller;

    private PipeGroup[] pipes = new PipeGroup[3];

    public PipeManager(final int contextWidth, final int height){
        this.contextWidth = contextWidth;
        scroller = new Scroller( this, true, SCROLL_VELOCITY );


        p1 = new PipeGroup( height, contextWidth, 28/*Test value*/);
        p2 = new PipeGroup( height, contextWidth, 28/*Test value*/);
        p3 = new PipeGroup( height, contextWidth, 28/*Test value*/);

        p1.setX( contextWidth );
        p2.setX( p1.getEnd() + pipeSpacingHor );
        p3.setX( p2.getEnd() + pipeSpacingHor );

        pipes[0] = p1;
        pipes[1] = p2;
        pipes[2] = p3;

    }

    public void update(final float deltaFps){
        scroller.update( deltaFps );
    }

    @Override
    public void onNewDeltaPos(float deltaPos) {
        //Update pipes X pos
        for( int i = 0; i < pipes.length; i++ ){
            pipes[i].updateX( deltaPos );

            if( pipes[i].getEnd() < 0 ) { //Is now invisible
                pipes[i].setX(/*The pipe to align itself to*/ pipes[(i == 0) ? pipes.length - 1 : i - 1].getEnd() + pipeSpacingHor);
                pipes[i].updateHeights();
            }
        }

    }

    public PipeGroup[] getPipes(){
        return pipes;
    }


}
