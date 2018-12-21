package com.whompum.sirbird;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.whompum.sirbird.Contexts.PlayContext;
import com.whompum.sirbird.GameItemLoaders.AssetLoader;

public class SirBirdGame extends Game {

    public static final int DIMENSION_WIDTH = 544;
    public static final int DIMENSION_HEIGHT = 816;

    @Override
    public void create() {
        Gdx.app.log( "ZBGame", "created" );
        AssetLoader.load();
        setScreen( new PlayContext() );
    }

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }

    public static float getDeviceAspectRatio(){
        return Math.min( getDeviceHeight(), getDeviceHeight() ) / Math.max( getDeviceHeight(), getDeviceWidth() );
    }

    public static float getEnvironmentAspectRatio(){
        return Math.min( DIMENSION_HEIGHT, DIMENSION_WIDTH ) / Math.max( DIMENSION_HEIGHT, DIMENSION_WIDTH );
    }

    public static float getDeviceWidth(){
        return (float) Gdx.graphics.getWidth();
    }

    public static float getDeviceHeight(){
        return (float) Gdx.graphics.getHeight();
    }

}
