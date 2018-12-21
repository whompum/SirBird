package com.whompum.sirbird;

import com.whompum.sirbird.GameContextModels.SirBird;

public class GameWorld {

    private SirBird bird;

    /**
     * Construct a new GameWorld object with a defined centerY value
     *
     * @param cY the centerY value of the screen.
     */
    public GameWorld(final int cY, final int screenHeight){
        bird = new SirBird( 17, 12, 33, cY, screenHeight );
    }

    public void update(float millisSincelastUpdate) {
        bird.updatePos( millisSincelastUpdate );
    }

    public SirBird getBird() {
        return bird;
    }
}
