package de.fatochs.engine.core.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * @author pinkie.swirl@mailbox.org
 */
public class SpriteEntity extends Entity2D
{
	/**
	 * The drawable {@link com.badlogic.gdx.graphics.g2d.Sprite Sprite}.
	 */
	protected Sprite	sprite;

	/**
	 * Creates an new sprite entity with the given sprite.
	 * <p>
	 * The position and velocity are initialized to (0, 0).
	 * 
	 * @param sprite
	 *            the sprite
	 */
	public SpriteEntity(final Sprite sprite)
	{
		super();

		this.sprite = sprite;
	}

	/**
	 * Creates a new sprite entity with the given sprite and position.
	 * <p>
	 * The velocity is initialized to (0, 0).
	 * 
	 * @param sprite
	 *            the sprite
	 * @param pos
	 *            the position
	 */
	public SpriteEntity(final Sprite sprite, final Vector2 pos)
	{
		super(pos);

		this.sprite = sprite;
	}

	/**
	 * Creates a new sprite entity with the given sprite, position and velocity.
	 * 
	 * @param sprite
	 *            the sprite
	 * @param pos
	 *            the position
	 * @param vel
	 *            the velocity
	 */
	public SpriteEntity(final Sprite sprite, final Vector2 pos, final Vector2 vel)
	{
		super(pos, vel);

		this.sprite = sprite;
	}

	/**
	 * Draws the {@code sprite} with the given sprite batch.
	 * 
	 * @param batch
	 *            the sprite batch
	 */
	public void render(final SpriteBatch batch)
	{
		sprite.draw(batch);
	}

	/*
	 * (non-Javadoc)
	 * @see de.fatochs.engine.core.entities.Entity2D#update()
	 */
	@Override
	public void update()
	{
		super.update();

		sprite.setPosition(position.x, position.y);
	}

	@Override
	public void setX(float x)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setY(float x)
	{
		// TODO Auto-generated method stub
		
	}
}
