package de.fatochs.ebs.units;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class CircleKiller extends Killer
{
	float	radius;
	boolean	moving	= false;

	public CircleKiller(final Sprite sprite, final Vector2 pos)
	{
		super(sprite, pos);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkCollision(final Escaper escaper)
	{
		return Math.pow(position.x - escaper.getPos().x, 2) + Math.pow(position.y - escaper.getPos().y, 2) < radius * radius;
	}

}
