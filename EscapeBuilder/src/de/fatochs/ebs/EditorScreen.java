/**
 * 
 */
package de.fatochs.ebs;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import de.fatochs.engine.core.ui.BaseScreen;
import de.fatochs.engine.core.ui.BaseGame;
import de.fatochs.engine.core.ui.UiFactory;

/**
 * @author pinkie.swirl@mailbox.org
 */
public class EditorScreen extends BaseScreen
{

	/**
	 * @param game
	 */
	public EditorScreen(BaseGame game)
	{
		super(game);
		final TextButton newButton = UiFactory.textButton("New");

		newButton.addListener(new ClickListener()
		{
			@Override
			public void clicked(final InputEvent event, final float x, final float y)
			{

			}
		});
		
		defaults().pad(6f);
		setBackground(UiFactory.drawable("window1"));
		setColor(UiFactory.color("lt-blue"));
		add(newButton);
		row();

	}

	/*
	 * (non-Javadoc)
	 * @see de.fatochs.engine.core.ui.BaseScreen#onBackPress()
	 */
	@Override
	public void onBackPress()
	{
		game.switchScreens(new MainScreen(game));
	}

}
