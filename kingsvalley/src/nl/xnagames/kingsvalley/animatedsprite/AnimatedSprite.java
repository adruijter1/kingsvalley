package nl.xnagames.kingsvalley.animatedsprite;

import nl.xnagames.kingsvalley.explorer.Explorer;

public class AnimatedSprite 
{
	//Fields
	private Explorer explorer;
	protected int i = 0;
	private float timer = 0f;
	
	
	//Properties
	
	
	//Constructor
	public AnimatedSprite(Explorer explorer)
	{
		this.explorer = explorer;
	}
	
	
	
	//Update
	public void update(float delta)
	{
		if (this.timer > 5f/60f)
		{
			this.i++;
			this.timer = 0f;
			if (this.i > 7)
			{
				this.i = 0;
			}
		}
		this.timer += delta;
	}
	
	
	//Draw
	public void draw(float delta)
	{
		this.explorer.getGame().getBatch().draw(this.explorer.getRegions().get(this.i),
				this.explorer.getPosition().x,
				this.explorer.getPosition().y,
				18f,
				32f);
	}
}
