package de.fatochs.ebs.maze;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class TileSet
{
	private static final Random	rand			= new Random();
	private static final int	TILESET_WIDTH	= 5;
	private static final int	TILESET_HEIGHT	= 4;
	private static final int	TILESET_SIZE	= 32;
	TextureRegion[][]			regions;

	public TileSet(TextureRegion setRegion)
	{
		regions = setRegion.split(TILESET_SIZE, TILESET_SIZE);
		if (regions[0].length != TILESET_WIDTH || regions.length != TILESET_HEIGHT)
		{
			Gdx.app.error("Fatal", "x: " + regions.length + " y: " + regions[0].length,
					new GdxRuntimeException("Invalid TileSet"));
		}
	}

	public TextureRegion getLeftTop()
	{
		return regions[0][0];
	}

	public TextureRegion getTop()
	{
		return regions[0][1];
	}

	public TextureRegion getRightTop()
	{
		return regions[0][2];
	}

	public TextureRegion getLeft()
	{
		return regions[1][0];
	}

	public TextureRegion getMid()
	{
		return regions[1][1];
	}

	public TextureRegion getRight()
	{
		return regions[1][2];
	}

	public TextureRegion getLeftBot()
	{
		return regions[2][0];
	}

	public TextureRegion getBot()
	{
		return regions[2][1];
	}

	public TextureRegion getRightBot()
	{
		return regions[2][2];
	}
	
	public TextureRegion getSolo()
	{
		return regions[0][4];
	}
	
	public TextureRegion getUTop() {
		return regions[0][3];
	}
	
	public TextureRegion getURight() {
		return regions[1][3];
	}
	
	public TextureRegion getULeft() {
		return regions[2][3];
	}
	
	public TextureRegion getUBot() {
		return regions[3][3];
	}
	
	public TextureRegion getPathVertical() {
		return regions[1][4];
	}
	
	public TextureRegion getPathHorizontal() {
		return regions[2][4];
	}

	public TextureRegion getMidRandomVariation()
	{
		switch (rand.nextInt(4))
		{
		case 0:
			return getMid();
		case 1:
			return regions[3][0];
		case 2:
			return regions[3][1];
		case 3:
			return regions[3][2];
		default:
			throw new GdxRuntimeException("Invalid Random Value");
		}

	}

	

}
