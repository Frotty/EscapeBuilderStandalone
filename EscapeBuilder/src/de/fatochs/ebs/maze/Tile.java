package de.fatochs.ebs.maze;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTile.BlendMode;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;

public class Tile implements TiledMapTile
{
	public TileInformation	info;
	
	private int id;

	private BlendMode blendMode = BlendMode.ALPHA;

	private MapProperties properties;

	private TextureRegion textureRegion;

	@Override
	public int getId () {
		return id;
	}

	@Override
	public void setId (int id) {
		this.id = id;
	}

	@Override
	public BlendMode getBlendMode () {
		return blendMode;
	}

	@Override
	public void setBlendMode (BlendMode blendMode) {
		this.blendMode = blendMode;
	}

	/** @return tile's properties set */
	@Override
	public MapProperties getProperties () {
		if (properties == null) {
			properties = new MapProperties();
		}
		return properties;
	}

	/** @return texture region used to render the tile */
	@Override
	public TextureRegion getTextureRegion () {
		return textureRegion;
	}

	/** Creates a static tile with the given region
	 * 
	 * @param textureRegion the {@link TextureRegion} to use. */
	public Tile() {
	}
	
	public Tile(final TileInformation info)
	{
		this.info = info;
		this.textureRegion = info.tileSet.getSolo();
	}
	
	public void findCorrectTile(Tile rightTile, Tile botTile, Tile leftTile, Tile topTile ) {
		TextureRegion rg = null;
		String s = "";
		if(rightTile == null || rightTile.info != info) {s += "0";}else{s += "1";}
		if(botTile == null || botTile.info != info) {s += "0";}else{s += "1";}
		if(leftTile == null || leftTile.info != info) {s += "0";}else{s += "1";}
		if(topTile == null || topTile.info != info) {s += "0";}else{s += "1";}
		switch(s) {
		case "0111": rg = info.tileSet.getRight(); break;
		case "1111": rg = info.tileSet.getMidRandomVariation(); break;
		case "0011": rg = info.tileSet.getRightBot(); break;
		case "1011": rg = info.tileSet.getBot(); break;
		case "0101": rg = info.tileSet.getPathVertical(); break;
		case "1101": rg = info.tileSet.getLeft(); break;
		case "0001": rg = info.tileSet.getUBot(); break;
		case "1001": rg = info.tileSet.getLeftBot(); break;
		case "0110": rg = info.tileSet.getRightTop(); break;
		case "1110": rg = info.tileSet.getTop(); break;
		case "0010": rg = info.tileSet.getURight(); System.out.println("LEFT"); break;
		case "1010": rg = info.tileSet.getPathHorizontal(); break;
		case "0100": rg = info.tileSet.getUTop(); break;
		case "1100": rg = info.tileSet.getLeftTop(); break;
		case "0000": rg = info.tileSet.getSolo(); break;
		case "1000": rg = info.tileSet.getULeft(); break;
		default : rg = info.tileSet.getMid(); break;
		}
		this.textureRegion = rg;
	}


}
