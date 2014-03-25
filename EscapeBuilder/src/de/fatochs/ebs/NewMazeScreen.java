/**
 * 
 */
package de.fatochs.ebs;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import de.fatochs.ebs.maze.TileInformation;
import de.fatochs.ebs.maze.TileSet;
import de.fatochs.engine.core.ui.BaseGame;
import de.fatochs.engine.core.ui.BaseScreen;
import de.fatochs.engine.core.ui.UiFactory;

/**
 * @author pinkie.swirl@mailbox.org
 */
public class NewMazeScreen extends BaseScreen
{

	/**
	 * @param game
	 */
	public NewMazeScreen(BaseGame game)
	{
		super(game);
		final Label nameLabel = UiFactory.label("Maze Name: ");
		final TextField nameField = UiFactory.textField("");
		final Label tileSetLabel = UiFactory.label("Tileset: ");
		final SelectBox<TileSet> tileSetBox = UiFactory.selectBox();
		final Label sizeLabel = UiFactory.label("Size: ");
		final Label xSizeLabel = UiFactory.label("Width: ");
		final TextField xSizeField = UiFactory.textField("");
		final Label ySizeLabel = UiFactory.label("Height: ");
		final TextField ySizeField = UiFactory.textField("");
		final Label startTileLabel = UiFactory.label("Starting Tile: ");
		final SelectBox<TileInformation> startTileBox = UiFactory.selectBox();
		startTileBox.setItems(TileInformation.PATH);
		final TextButton createButton = UiFactory.textButton("Create");

		createButton.addListener(new ClickListener()
		{
			@Override
			public void clicked(final InputEvent event, final float x, final float y)
			{
				// TODO Implement method
				throw new UnsupportedOperationException();
			}
		});
		Table sizeTable = new Table();
		sizeTable.add(xSizeLabel);sizeTable.add(xSizeField);
		sizeTable.row();
		sizeTable.add(ySizeLabel);sizeTable.add(ySizeField);

		defaults().pad(6f);
		setBackground(UiFactory.drawable("bg"));
		setColor(UiFactory.color("lt-blue"));
		add(nameLabel);
		add(nameField).width(150);
		row();
		add(tileSetLabel);add(tileSetBox);
		row();
		add(sizeLabel);add(sizeTable);
		row();
		add(startTileLabel);add(startTileBox);
		row();
		add(createButton).colspan(2);
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
