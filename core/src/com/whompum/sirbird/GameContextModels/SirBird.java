package com.whompum.sirbird.GameContextModels;

import com.badlogic.gdx.math.Vector2;

/**
 * The modeled state of the Bird the user interacts with
 */
public class SirBird {

    public static final int TERMINAL_VELOCITY = 200;

    private int width, height;

    //Vector2 objects will simply hold X,Y pairs in our situation
    private Vector2 currPos, /*How fast we're currently falling*/ descendingVelocity, acceleration;

    private float vectorAngle;

    public SirBird(final int width, final int height, final int startingXPos, final int startingYPos){

        this.width = width;
        this.height = height;

        currPos = new Vector2( startingXPos, startingYPos );
        descendingVelocity = new Vector2();
        acceleration = new Vector2( 0, 560 );

    }

    /**
     * Update the current position and velocity of this entity
     * by utilizing the `deltaFrameUpdate` parameter.
     *
     * Updating the {@link Vector2} objects like this will produce a standardizing
     * effect on our bird movement. Basically, if the deltaFrameUpdate was 2X as long as last time
     * we'll just move 2X at far, thus giving us a FPS-independent movement.
     *
     * @param deltaFrameUpdate
     */
    public void updatePos(final float deltaFrameUpdate){

        final Vector2 scaledAcceleration = scale( acceleration, deltaFrameUpdate );

        descendingVelocity.add( scaledAcceleration );

        if( descendingVelocity.y > TERMINAL_VELOCITY ) //If velocity is greater than the terminal velocity
            descendingVelocity.y = TERMINAL_VELOCITY;

        final Vector2 scaledVelocity = scale( descendingVelocity, deltaFrameUpdate );

        currPos.add( scaledVelocity );

    }

    private Vector2 scale(final Vector2 sbj, final float delta){
        //TODO fix allocations during each screen rendering, from the Vector2#cpy() method
        return sbj.cpy().scl( delta );
    }

    public void onClick() {
        descendingVelocity.y = -140;
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
        return vectorAngle;
    }

}
