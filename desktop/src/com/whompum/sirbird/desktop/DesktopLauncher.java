package com.whompum.sirbird.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.whompum.sirbird.SirBirdGame;

public class DesktopLauncher {

	public static final String APP_TITLE = "SirBird";

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = APP_TITLE;
		config.width = 360;
		config.height = 560;
		new LwjglApplication(new SirBirdGame(), config);
	}
}
