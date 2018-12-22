package com.whompum.sirbird.GameContextModels;

import com.badlogic.gdx.math.Vector2;
import com.whompum.sirbird.Logger;
import com.whompum.sirbird.Scrolling.OnScrollChangeListener;
import com.whompum.sirbird.Scrolling.Scroller;

/**
 * The modeled state of the Bird the user interacts with
 */
public class SirBird implements OnScrollChangeListener{

    public static final int TERMINAL_VELOCITY = 7; //How many units to fall per update,
    public static final int VERTICAL_JUMP_UNITS = -4; //How many units to raise per update

    public static final int ROTATION_ANGLE = 90;

    private int width, height;

    private Scroller scroller;

    //Vector2 objects will simply hold X,Y pairs in our situation
    private Vector2 currPos;

    private float currentAngle;

    private int contextHeight;

    public SirBird(final int width, final int height, final int startingXPos, final int startingYPos, final int contextHeight){

        this.width = width;
        this.height = height;

        currPos = new Vector2( startingXPos, startingYPos );

        this.contextHeight = contextHeight;

        scroller = new Scroller( this, false, TERMINAL_VELOCITY );

    }

    @Override
    public void onNewDeltaPos(float deltaPos) {
        currPos.add( 0, deltaPos );

        if( isTouchingCiel() ){
            currPos.y = 0;
            restartVelocity(); //Avoids hangtime because without, the velocity would need to climb back up to (> 0) again
        } else if( isTouchingFloor() ){
            currPos.y = contextHeight - height;
            restartVelocity();
        }

    }

    public void updatePos(final float deltaFrameUpdate){
        scroller.update( deltaFrameUpdate );

        if( isDescending() ){

            currentAngle += (ROTATION_ANGLE * deltaFrameUpdate);

            if( currentAngle >= ROTATION_ANGLE )
                currentAngle = ROTATION_ANGLE;

        }else if( currentAngle != 0 )
            currentAngle = 0;

    }

    public void onClick() {
       scroller.setCurrentScrollVelocity( VERTICAL_JUMP_UNITS );
       currentAngle = -90;
    }

    private boolean isTouchingCiel(){
        return currPos.y <= 0;
    }

    private boolean isTouchingFloor(){
        return (currPos.y + height) >= contextHeight;
    }

    public boolean isDescending(){
        return scroller.getCurrentScrollVelocity() > 0;
    }

    private void restartVelocity(){
        scroller.setCurrentScrollVelocity( 0F );
    }

    public float getX() {
        return currPos.x;
    }

    public float getY() {
        return currPos.y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getRotation() {
        return currentAngle;
    }

}
