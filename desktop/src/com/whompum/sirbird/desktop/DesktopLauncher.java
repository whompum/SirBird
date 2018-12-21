package com.whompum.sirbird.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.whompum.sirbird.Contexts.PlayContext;
import com.whompum.sirbird.SirBirdGame;

public class DesktopLauncher {

	public static final String APP_TITLE = "SirBird";

	public static void main (String[] arg) {
		new LwjglApplication( new SirBirdGame(), configure() );
	}

	private static LwjglApplicationConfiguration configure(){
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		configureDimension( config );
		configureTitle( config );

		return config;
	}

	private static void configureDimension(final LwjglApplicationConfiguration config){
		config.width = SirBirdGame.DIMENSION_WIDTH;
		config.height = SirBirdGame.DIMENSION_HEIGHT;
	}

	private static void configureTitle(final LwjglApplicationConfiguration config){
		config.title = APP_TITLE;
	}

}
