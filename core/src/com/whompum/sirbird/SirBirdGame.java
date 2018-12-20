package com.whompum.sirbird;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.whompum.sirbird.Contexts.PlayContext;
import com.whompum.sirbird.GameItemLoaders.AssetLoader;

public class SirBirdGame extends Game {

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
}
