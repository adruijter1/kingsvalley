package nl.xnagames.kingsvalley.explorer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import nl.xnagames.kingsvalley.animatedsprite.AnimatedSprite;

public class ExplorerIdleRight extends AnimatedSprite
{
	//Fields
	private Explorer explorer;
	
	
	//Properties
	
	
	//Constructor
	public ExplorerIdleRight(Explorer explorer)
	{
		super(explorer);
		this.explorer = explorer;
		this.initialize();
	}
	
	
	// Initialize
	public void initialize()
	{
		this.i = 4;
		
		for ( AtlasRegion region : this.explorer.getRegions())
		{
			if ( region.isFlipX())
			{
				region.flip(true, false);
			}
		}
	}
	
	//Update
	public void update(float delta)
	{
		if (Gdx.input.isKeyPressed(Keys.RIGHT))
		{
			this.explorer.setState(this.explorer.getWalkRight());
		}
		if (Gdx.input.isKeyPressed(Keys.LEFT))
		{
			this.explorer.setState(this.explorer.getWalkLeft());
		}
	}
	
	
	// Draw
	public void draw(float delta)
	{
		super.draw(delta);
	}
}
