/**
 * 
 */
package de.fatochs.ebs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import de.fatochs.engine.core.ui.BaseGame;
import de.fatochs.engine.core.ui.BaseScreen;
import de.fatochs.engine.core.ui.UiFactory;

/**
 * @author pinkie.swirl@mailbox.org
 */
public class MainScreen extends BaseScreen
{

	/**
	 * @param game
	 */
	public MainScreen(final BaseGame game)
	{
		super(game);

		final TextButton playButton = UiFactory.textButton("Play");

		playButton.addListener(new ClickListener()
		{
			@Override
			public void clicked(final InputEvent event, final float x, final float y)
			{
				game.switchScreens(new GameScreen(game));
				playButton.setChecked(false);
			}
		});

		final TextButton editButton = UiFactory.textButton("Edit");

		editButton.addListener(new ClickListener()
		{
			@Override
			public void clicked(final InputEvent event, final float x, final float y)
			{
				 game.switchScreens(new EditScreen(game));
				 editButton.setChecked(false);
			}
		});

		final TextButton exitButton = UiFactory.textButton("Exit");

		exitButton.addListener(new ClickListener()
		{
			@Override
			public void clicked(final InputEvent event, final float x, final float y)
			{
				onBackPress();
			}
		});

		defaults().pad(10);
		setBackground(UiFactory.drawable("window1"));
		setColor(UiFactory.color("lt-blue"));
		add(playButton).size(0.6f * game.width, 0.2f * game.height);
		row();
		add(editButton).size(0.6f * game.width, 0.2f * game.height);
		row();
		add(exitButton).size(0.6f * game.width, 0.2f * game.height);
	}
	
	

	/*
	 * (non-Javadoc)
	 * @see de.fatochs.engine.core.ui.BaseScreen#onBackPress()
	 */
	@Override
	public void onBackPress()
	{
		Gdx.app.exit();
	}

}
