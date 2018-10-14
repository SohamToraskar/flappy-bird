package com.naga.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.naga.game.ProjectNaga;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = ProjectNaga.WIDTH;
		config.height = ProjectNaga.HEIGHT;
		config.title = ProjectNaga.TITLE;



		new LwjglApplication(new ProjectNaga(), config);
	}
}
