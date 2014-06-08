package nl.xnagames.kingsvalley.explorer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;

import nl.xnagames.kingsvalley.animatedsprite.AnimatedSprite;

public class ExplorerWalkLeft extends AnimatedSprite
{
	private Explorer explorer;
	private Vector2 velocity;
	
	public ExplorerWalkLeft(Explorer explorer)
	{
		super(explorer);
		this.explorer = explorer;
		this.velocity = new Vector2(-this.explorer.getSpeed(), 0f);
		this.initialize();
	}
	
	public void initialize()
	{
		this.i = 0;
		for ( AtlasRegion region : this.explorer.getRegions())
		{
			if (!region.isFlipX())
			{
				region.flip(true, false);
			}
		}
	}
	
	public void update(float delta)
	{
		super.update(delta);
		this.explorer.getPosition().add(this.velocity);
		if (!Gdx.input.isKeyPressed(Keys.LEFT))
		{
			this.explorer.setState(this.explorer.getIdleLeft());
		}
	}
	
	public void draw(float delta)
	{
		super.draw(delta);
	}
}
