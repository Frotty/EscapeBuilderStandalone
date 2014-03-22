package de.fatochs.ebs.maze;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class TileSet {
	private static final int TILESET_WIDTH = 4;
	private static final int TILESET_HEIGHT = 4;
	private static final int TILESET_SIZE = 32;
	TextureRegion[][] regions;

	public TileSet(TextureRegion setRegion) {
		regions = setRegion.split(TILESET_SIZE, TILESET_SIZE);
		if( regions.length != TILESET_WIDTH || regions[0].length != TILESET_HEIGHT ) {
			Gdx.app.error("Fatal","x: " + regions.length + " y: " + regions[0].length, new GdxRuntimeException("Invalid TileSet"));
		}
	}
	
	public TextureRegion getLeftTop() {
		return regions[0][0];
	}
	
	public TextureRegion getTop() {
		return regions[1][0];
	}
	
	public TextureRegion getRightTop() {
		return regions[2][0];
	}
	
	public TextureRegion getLeft() {
		return regions[0][1];
	}
	
	public TextureRegion getMid() {
		return regions[1][1];
	}
	
	public TextureRegion getRight() {
		return regions[2][1];
	}
	
	public TextureRegion getLeftBot() {
		return regions[0][2];
	}
	
	public TextureRegion getBot() {
		return regions[1][2];
	}
	
	public TextureRegion getRightBot() {
		return regions[2][2];
	}
	
	public TextureRegion getMidRandomVariation() {
		switch( (int)(Math.random()*5) ){
		case 0 : return getMid();
		case 1 : return regions[0][3];
		case 2 : return regions[1][3];
		case 3 : return regions[2][3];
		default: throw new GdxRuntimeException("Invalid Random Value");
		}

	}
	

}
