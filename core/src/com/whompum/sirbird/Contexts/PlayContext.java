package com.whompum.sirbird.Contexts;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.whompum.sirbird.Renderer.GameRenderer;
import com.whompum.sirbird.GameWorld;
import com.whompum.sirbird.Logger;
import com.whompum.sirbird.Renderer.RendererHelper;
import com.whompum.sirbird.SirBirdGame;
import com.whompum.sirbird.UserInput.InputHelper;

/**
 * The main screen where the user plays the game in.
 * The Rendering / game-play logic is handled by
 * {@link RendererHelper} and {@link GameWorld} respectively.
 *
 */
public class PlayContext implements Screen {

    private final Logger logger = new Logger();

    private GameWorld world;
    private RendererHelper renderer;

    private float currentRuntime;

    public PlayContext(){

        final int cY = getCY();

        world = new GameWorld( cY, getHeight() );
        renderer = new GameRenderer( world, getHeight(), cY );

        Gdx.input.setInputProcessor(
                new InputHelper( world.getBird() ).getInputProcessor()
        );

    }

    private int getCY(){
        return getHeight() >> 1;
    }

    private int getHeight(){
        return (int)( SirBirdGame.getDeviceHeight() / (SirBirdGame.getDeviceWidth() / 136) );
    }

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
        currentRuntime+=delta;
        world.update( delta );
        renderer.render( currentRuntime );
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
