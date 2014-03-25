package de.fatochs.ebs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Logger;

import de.fatochs.ebs.units.Escaper;
import de.fatochs.engine.core.ui.BaseGame;
import de.fatochs.engine.core.ui.BaseScreen;

public class EBGame extends BaseGame
{
	public static TextureAtlas	textureAtlas;

	/*
	 * (non-Javadoc)
	 * @see de.fatochs.engine.core.ui.BaseGame#createMe()
	 */
	@Override
	protected void createMe()
	{
		Gdx.app.setLogLevel(Logger.DEBUG);
		textureAtlas = new TextureAtlas(Gdx.files.internal("textures/tiles/packed/TilesPack.pack"));
	}

	@Override
	public void dispose()
	{
		batch.dispose();
	}

	/*
	 * (non-Javadoc)
	 * @see de.fatochs.engine.core.ui.UiApp#atlasPath()
	 */
	@Override
	protected String atlasPath()
	{
		return "textures/ui/UIPack.atlas";
	}

	/*
	 * (non-Javadoc)
	 * @see de.fatochs.engine.core.ui.UiApp#skinPath()
	 */
	@Override
	protected String skinPath()
	{
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * de.fatochs.engine.core.ui.UiApp#styleSkin(com.badlogic.gdx.scenes.scene2d
	 * .ui.Skin, com.badlogic.gdx.graphics.g2d.TextureAtlas)
	 */
	@Override
	protected void styleSkin(Skin skin, TextureAtlas atlas)
	{
		new Styles().styleSkin(skin, atlas);
	}

	/*
	 * (non-Javadoc)
	 * @see de.fatochs.engine.core.ui.UiApp#getFirstScreen()
	 */
	@Override
	protected BaseScreen getFirstScreen()
	{
		return new MainScreen(this);
	}
	
	@Override
	public void resize(final int width, final int height)
	{
		super.resize(width, height);
		currentScreen.resize(width, height);
	}

}
