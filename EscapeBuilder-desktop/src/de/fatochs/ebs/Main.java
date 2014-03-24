package de.fatochs.ebs;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.tools.texturepacker.TexturePacker.Settings;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import de.fatochs.ebs.EBGame;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "EscapeBuilder";
		cfg.width = 480;
		cfg.height = 320;
		Settings settings = new Settings();
        settings.maxWidth = 512;
        settings.maxHeight = 512;
        settings.pot = false;
        TexturePacker.process(settings, "../EscapeBuilder-android/assets/textures/ui/images/done",
        		"../EscapeBuilder-android/assets/textures/ui/", "UIPack");
		new LwjglApplication(new EBGame(), cfg);
	}
}
