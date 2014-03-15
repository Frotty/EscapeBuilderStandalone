package de.frotty.ebs.entity;

import com.badlogic.gdx.math.Vector2;

public abstract class Entity 
{
	public Vector2 position;
	public Vector2 velocity;
	
	public abstract void update();
	
	
}
