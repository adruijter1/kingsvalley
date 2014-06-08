package nl.xnagames.kingsvalley.explorer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import nl.xnagames.kingsvalley.animatedsprite.AnimatedSprite;

public class ExplorerIdleLeft extends AnimatedSprite
{
	//Fields
	private Explorer explorer;	
	
	//Properties	
	
	//Constructor
	public ExplorerIdleLeft(Explorer explorer)
	{
		super(explorer);
		this.explorer = explorer;
		this.initialize();
	}
	
	
	// Initialize
	public void initialize()
	{
		this.i = 7;
		
		if (!this.explorer.getRegions().get(this.i).isFlipX())
			this.explorer.getRegions().get(this.i).flip(true, false);
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
