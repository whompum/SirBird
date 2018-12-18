package com.whompum.sirbird;

import com.badlogic.gdx.Gdx;

public class Logger {
    public void log( final Class c, final String msg ){
        Gdx.app.log( c.getSimpleName(), msg );
    }
}
