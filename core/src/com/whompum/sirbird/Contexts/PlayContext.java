package com.whompum.sirbird.Contexts;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.whompum.sirbird.Logger;


public class PlayContext implements Screen {

    private final Logger logger = new Logger();

    @Override
    public void show() {
        logger.log( PlayContext.class, "show()");
    }

    /**
     * The game loop called during each rendering phase.
     *
     * @param delta Elapsed time since the last rendering phase was called.
     */
    @Override
    public void render(float delta) {
        logger.log( PlayContext.class, "render()");
        // Sets a Color to Fill the Screen with (RGB = 10, 15, 230), Opacity of 1 (100%)
        Gdx.gl.glClearColor( 10/74F, 10/73F, 10/71F, 1f );
        // Fills the screen with the selected color
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );

        /* Uncomment to view FPS
            logger.log( PlayContext.class, "render() FRAME_PER_SECOND: " + (1 / delta) );
        */
    }

    @Override
    public void resize(int width, int height) {
        logger.log( PlayContext.class, "resise()");
    }

    @Override
    public void pause() {
        logger.log( PlayContext.class, "pause()");
    }

    @Override
    public void resume() {
        logger.log( PlayContext.class, "resume()");
    }

    @Override
    public void hide() {
        logger.log( PlayContext.class, "hide()");
    }

    @Override
    public void dispose() {
        logger.log( PlayContext.class, "dispose()");
    }
}
