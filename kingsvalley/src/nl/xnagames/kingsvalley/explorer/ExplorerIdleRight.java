package nl.xnagames.kingsvalley.explorer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

import nl.xnagames.kingsvalley.animatedsprite.AnimatedSprite;

public class ExplorerIdleRight extends AnimatedSprite
{
	//Fields
	private Explorer explorer;
	private boolean ks, oks;
	
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
		this.i = 7;
		
		if (this.explorer.getRegions().get(this.i).isFlipX())
			this.explorer.getRegions().get(this.i).flip(true, false);
		
	}
	
	//Update
	public void update(float delta)
	{
		ks = Gdx.input.isKeyPressed(Keys.SPACE);
		
		if (Gdx.input.isKeyPressed(Keys.RIGHT))
		{
			this.explorer.setState(this.explorer.getWalkRight());
		}
		if (Gdx.input.isKeyPressed(Keys.LEFT))
		{
			this.explorer.setState(this.explorer.getWalkLeft());
		}
		if (this.ks && !this.oks)
		{
			this.explorer.setState(this.explorer.getIdleJumpRight());
		}
		
		this.oks = ks;
		
	}	
	
	// Draw
	public void draw(float delta)
	{
		super.draw(delta);
	}
}
