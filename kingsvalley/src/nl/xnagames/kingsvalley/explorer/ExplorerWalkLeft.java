package nl.xnagames.kingsvalley.explorer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

import nl.xnagames.kingsvalley.KingsValley;
import nl.xnagames.kingsvalley.animatedsprite.AnimatedSprite;

public class ExplorerWalkLeft extends AnimatedSprite
{
	//Fields
		private Explorer explorer;
		private Vector2 velocity;
		
		
		//Properties
		
		
		//Constructor
		public ExplorerWalkLeft(Explorer explorer)
		{
			// explorer instantie wordt doorgegeven aan de parentclass AnimatedSprite
			super(explorer);
			this.explorer = explorer;
			this.velocity = new Vector2(-1f * this.explorer.getSpeed(), 0f);
			this.initialize();
		}
		
		
		// Initialize
		public void initialize()
		{
			this.i = 4;
		}
		
		//Update
		public void update(float delta)
		{
			super.update(delta);
			this.explorer.getPosition().add(this.velocity);
			if (!Gdx.input.isKeyPressed(Keys.LEFT))
			{
				if (!KingsValley.isAndroid)
				this.explorer.setState(this.explorer.getIdleLeft());
			}
		}
		
		
		// Draw
		public void draw(float delta)
		{
			super.draw(delta);
		}

}
