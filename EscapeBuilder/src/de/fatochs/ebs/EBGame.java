package de.fatochs.ebs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import de.fatochs.ebs.units.Escaper;
import de.fatochs.engine.core.ui.BaseGame;
import de.fatochs.engine.core.ui.BaseScreen;

public class EBGame extends BaseGame
{
	public static TextureAtlas	textureAtlas;
	public static Escaper		escaper;

	/*
	 * (non-Javadoc)
	 * @see de.fatochs.engine.core.ui.BaseGame#createMe()
	 */
	@Override
	protected void createMe()
	{
		textureAtlas = new TextureAtlas(Gdx.files.internal("textures/tiles/packed/EBSPack.pack"));
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
		return "data/texture.atlas";
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

}
