package nl.xnagames.kingsvalley.screens;

import nl.xnagames.kingsvalley.KingsValley;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;

public class GameScreen implements Screen
{
	// Fields
	private KingsValley game;	
	
	// Constructor
	public GameScreen(KingsValley game)
	{
		this.game = game;
	}	
	
	@Override
	public void render(float delta) 
	{
		Gdx.gl.glClearColor(0f, 1f, 0f, 1f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		if ( Gdx.input.isKeyPressed(Keys.LEFT))
		{
			this.game.setScreen(this.game.getSplashScreen());
		}
	}

	@Override
	public void resize(int width, int height) 
	{
				
	}

	@Override
	public void show() 
	{
		
	}

	@Override
	public void hide()
	{
		
	}

	@Override
	public void pause()
	{
		
	}

	@Override
	public void resume() 
	{
		
	}

	@Override
	public void dispose() 
	{
	
	}

}
