/**
 * 
 */
package de.fatochs.ebs.maze;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;

/**
 * @author Pinkie
 */
public class MazeLoader extends AsynchronousAssetLoader<TiledMap, MazeLoader.Parameters>
{
	public static class Parameters extends AssetLoaderParameters<TiledMap>
	{
		/**
		 * Whether to load the map for a y-up coordinate system
		 */
		public boolean			yUp							= true;
		/**
		 * generate mipmaps?
		 */
		public boolean			generateMipMaps				= false;
		/**
		 * The TextureFilter to use for minification
		 */
		public TextureFilter	textureMinFilter			= TextureFilter.Nearest;
		/**
		 * The TextureFilter to use for magnification
		 */
		public TextureFilter	textureMagFilter			= TextureFilter.Nearest;
		/**
		 * Whether to convert the objects' pixel position and size to the
		 * equivalent in tile space.
		 */
		public boolean			convertObjectToTileSpace	= false;
	}

	protected Json	json	= new Json();

	protected Maze	map;

	public MazeLoader()
	{
		super(new InternalFileHandleResolver());
	}

	public TiledMap load(String fileName)
	{
		return load(fileName, new MazeLoader.Parameters());
	}

	public TiledMap load(String fileName, MazeLoader.Parameters parameters)
	{
		return load(resolve(fileName), parameters);
	}
	
	public TiledMap load(FileHandle file, MazeLoader.Parameters parameters)
	{
		map = json.fromJson(Maze.class, file);

		return map;
	}

	@Override
	public void loadAsync(AssetManager manager, String fileName, FileHandle file, MazeLoader.Parameters parameter)
	{
		load(file, parameter);
	}

	@Override
	public TiledMap loadSync(AssetManager manager, String fileName, FileHandle file, MazeLoader.Parameters parameter)
	{
		return map;
	}

	@Override
	public Array<AssetDescriptor> getDependencies(String fileName, FileHandle file, MazeLoader.Parameters parameter)
	{
		return null;
	}
}
