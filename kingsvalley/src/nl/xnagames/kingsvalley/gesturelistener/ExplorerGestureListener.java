package nl.xnagames.kingsvalley.gesturelistener;

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

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		this.flingVector = new Vector2(velocityX, velocityY);
		float angle = this.flingVector.angle();
		if ( velocityX > 0)
		{
			//this.game.setScreen(this.game.getGameScreen());
			if (this.game.getGameScreen().getExplorer().getState().
					equals(this.game.getGameScreen().getExplorer().getIdleRight()))
			{
				this.game.getGameScreen().getExplorer().
					setState(this.game.getGameScreen().getExplorer().getWalkRight());
			}
		}
		if ( velocityX < 0 )
		{
			//this.game.setScreen(this.game.getSplashScreen());
		}
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

}
