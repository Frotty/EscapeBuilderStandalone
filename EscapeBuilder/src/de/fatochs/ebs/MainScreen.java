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

		final TextButton startButton = UiFactory.textButton("Start");

		startButton.addListener(new ClickListener()
		{
			@Override
			public void clicked(final InputEvent event, final float x, final float y)
			{
				game.switchScreens(new GameScreen(game));
				startButton.setChecked(false);
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

		defaults().pad(6f);
		setBackground(UiFactory.drawable("window1"));
		setColor(UiFactory.color("lt-blue"));
		add(startButton);
		row();
		add(exitButton);
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
