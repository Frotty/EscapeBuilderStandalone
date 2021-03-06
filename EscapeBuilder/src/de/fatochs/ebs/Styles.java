/**
 * 
 */
package de.fatochs.ebs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.List.ListStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane.ScrollPaneStyle;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox.SelectBoxStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable;

/**
 * @author pinkie.swirl@mailbox.org
 */
public class Styles
{

	public void styleSkin(final Skin skin, final TextureAtlas atlas)
	{
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("data/Trajan_Bold.ttf"));
		final BitmapFont font = generator.generateFont(36);
		font.setColor(Color.WHITE);
		skin.add("default", font);

		skin.add("lt-blue", new Color(.6f, .8f, 1f, 1f));
		skin.add("lt-green", new Color(.6f, .9f, .6f, 1f));
		skin.add("dark-blue", new Color(.1f, .3f, 1f, 1f));

		final NinePatchDrawable textButtonPatch = new NinePatchDrawable(atlas.createPatch("TextButton"));
		final NinePatchDrawable textFieldPatch = new NinePatchDrawable(atlas.createPatch("TextField"));
		final NinePatchDrawable windowClearPatch = new NinePatchDrawable(atlas.createPatch("WindowClear"));
		final NinePatchDrawable knobPatch = new NinePatchDrawable(atlas.createPatch("Knob"));
		final NinePatchDrawable blackDownPatch = new NinePatchDrawable(atlas.createPatch("BlackDown"));
		skin.add("textButton", textButtonPatch);
		skin.add("textField", textFieldPatch);
//		skin.add("white-pixel", atlas.findRegion("white-pixel"), TextureRegion.class);
		final TiledDrawable bg = new TiledDrawable(atlas.findRegion("bg"));
		skin.add("bg", bg);

		final LabelStyle lbs = new LabelStyle();
		lbs.font = font;
		lbs.fontColor = Color.WHITE;
		skin.add("default", lbs);

		final TextButtonStyle tbs = new TextButtonStyle(textButtonPatch, textButtonPatch, textButtonPatch, font);
		tbs.fontColor = Color.WHITE;
		tbs.pressedOffsetX = Math.round(1f * Gdx.graphics.getDensity());
		tbs.pressedOffsetY = tbs.pressedOffsetX * -1f;
		skin.add("default", tbs);
		;
		final TextFieldStyle tfs = new TextFieldStyle(font, Color.BLACK, blackDownPatch, textFieldPatch
				, textFieldPatch);
		skin.add("default", tfs);
		
		final ScrollPaneStyle sps = new ScrollPaneStyle(windowClearPatch, windowClearPatch, knobPatch, windowClearPatch, knobPatch);
		final ListStyle ls = new ListStyle(font, Color.BLACK, Color.GRAY, windowClearPatch);
		
		final SelectBoxStyle sbs = new SelectBoxStyle(font, Color.BLACK, textFieldPatch, sps, ls);
		skin.add("default", sbs);
	}
}
