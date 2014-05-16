package gesturelistener;

import nl.xnagames.kingsvalley.KingsValley;

import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;

public class ExplorerGestureListener implements GestureListener
{
	// Fields
	private KingsValley game;
	private Vector2 flingVector;
	
	
	// Constructor
	public ExplorerGestureListener(KingsValley game)
	{
		this.game = game;
	}
	
	@Override
	public boolean touchDown(int x, int y, int pointer) 
	{
		return false;
	}

	@Override
	public boolean tap(int x, int y, int count)
	{
		if (this.game.getScreen().equals(this.game.getSplashScreen()))
		{
			this.game.setScreen(this.game.getGameScreen());
		}
		if (this.game.getScreen().equals(this.game.getGameScreen()))
		{
			this.game.setScreen(this.game.getSplashScreen());
		}
		return false;
	}

	@Override
	public boolean longPress(int x, int y) 
	{
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY) 
	{
		this.flingVector = new Vector2(velocityX, velocityY);
		float angle = this.flingVector.angle();
		if ( velocityX > 0)
		{
			this.game.setScreen(this.game.getGameScreen());
		}
		if ( velocityX < 0 )
		{
			this.game.setScreen(this.game.getSplashScreen());
		}
		return false;
	}

	@Override
	public boolean pan(int x, int y, int deltaX, int deltaY) 
	{
		return false;
	}

	@Override
	public boolean zoom(float originalDistance, float currentDistance) 
	{
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialFirstPointer,
			Vector2 initialSecondPointer, Vector2 firstPointer,
			Vector2 secondPointer) 
	{
		return false;
	}

}
