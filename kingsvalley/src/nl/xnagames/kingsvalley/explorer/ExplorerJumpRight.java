package nl.xnagames.kingsvalley.explorer;

import com.badlogic.gdx.math.Vector2;

import nl.xnagames.kingsvalley.animatedsprite.AnimatedSprite;

public class ExplorerJumpRight extends AnimatedSprite
{
	// Fields
	private Explorer explorer;
	float startX, startY, a;
	int h, k, startH, startK;
	
	
	
	// De constructor van de ExplorerJumpRight Class
	public ExplorerJumpRight(Explorer explorer, int h, int k)
	{
		// De explorer instantie wordt meegegeven aan de parent class AnimatedSprite
		super(explorer);
		this.explorer = explorer;
		this.startH = h;
		this.startK = k;
		this.initialize();
	}
	
	public void initialize()
	{
		this.startX = this.explorer.getPosition().x;
		this.startY = this.explorer.getPosition().y;
		this.h = (int)this.startX + this.startH;
		this.k = (int)this.startY + this.startK;
		this.a = initializeA();
	}
	
	private float initializeA() 
	{
		return a = (float) ((this.startY - this.k)/ Math.pow((startX - this.h), 2d));
	}

	public void update(float delta)
	{
		float x = this.explorer.getPosition().x + this.explorer.getSpeed();
		
		float y = this.a * (float)Math.pow((x - this.h), 2d) + this.k;
				
		if ( y < this.startY )
		{
			y = startY;
			this.explorer.setState(this.explorer.getWalkRight());			
		}
		this.explorer.setPosition(new Vector2(x,y));
		this.explorer.getCam().translate(this.explorer.getSpeed(), 0f);
		//super.update(delta);
	}
	
	public void draw(float delta)
	{
		super.draw(delta);
	}
}
