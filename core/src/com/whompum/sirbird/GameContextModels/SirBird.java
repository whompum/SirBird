package com.whompum.sirbird.GameContextModels;

import com.badlogic.gdx.math.Vector2;
import com.whompum.sirbird.Logger;

/**
 * The modeled state of the Bird the user interacts with
 */
public class SirBird {

    public static final int TERMINAL_VELOCITY = 7; //How many units to fall per update,
    public static final int VERTICAL_JUMP_UNITS = -4; //How many units to raise per update

    public static final int ROTATION_ANGLE = 90;

    private int width, height;

    //Vector2 objects will simply hold X,Y pairs in our situation
    private Vector2 currPos;

    private float currentVelocity;

    private float currentAngle;

    private int contextHeight;

    public SirBird(final int width, final int height, final int startingXPos, final int startingYPos, final int contextHeight){

        this.width = width;
        this.height = height;

        currPos = new Vector2( startingXPos, startingYPos );

        this.contextHeight = contextHeight;
    }

    /**
     * Updates the current position of SirBird based on the current velocity
     *
     * Basically how it works is we take the deltaFrameUpdate (millis since last update)
     * and find out how much our velocity should increase / decrease by scaling the DECELERATION_CIEL by it.
     *
     * We then append that value to the currVelocity to find our new fall speed (in units)
     *
     * After we find our new velocity we then scale it by deltaFrameUpdate to find how many units the bird should move
     *
     * Then simply append that result to our current position
     *
     * @param deltaFrameUpdate
     */
    public void updatePos(final float deltaFrameUpdate){
        setCurrentVelocity( getDeltaFallSpeed( deltaFrameUpdate ) );
        currPos.add( 0, currentVelocity );

        if( isTouchingCiel() ){
            currPos.y = 0;
            restartVelocity();
        } else if( isTouchingFloor() ){
            currPos.y = contextHeight - height;
            currentVelocity = 0F;
        }

    }

    private float getDeltaFallSpeed(final float deltaFrameUpdate){
        return TERMINAL_VELOCITY * deltaFrameUpdate;
    }

    private void setCurrentVelocity(final float deltaFallSpeed){

        this.currentVelocity += deltaFallSpeed;

        if( currentVelocity > TERMINAL_VELOCITY )
            currentVelocity = TERMINAL_VELOCITY;

        if( isDescending() ){

            currentAngle += (ROTATION_ANGLE * deltaFallSpeed) * 0.5F; //Scale by half to slow down the rotation

            if( currentAngle >= ROTATION_ANGLE )
                currentAngle = ROTATION_ANGLE;

        }else if( currentAngle != 0 )
            currentAngle = 0;

    }

    public void onClick() {
       currentVelocity = VERTICAL_JUMP_UNITS;
       currentAngle = -90;
    }

    private boolean isTouchingCiel(){
        return currPos.y <= 0;
    }

    private boolean isTouchingFloor(){
        return (currPos.y + height) >= contextHeight;
    }

    public boolean isDescending(){
        return currentVelocity > 0;
    }

    private void restartVelocity(){
        currentVelocity = 0;
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
