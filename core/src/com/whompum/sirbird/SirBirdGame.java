package com.whompum.sirbird;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.whompum.sirbird.Contexts.PlayContext;

public class SirBirdGame extends Game {

    @Override
    public void create() {
        Gdx.app.log( "ZBGame", "created" );
        setScreen( new PlayContext() );
    }
}
