package nl.xnagames.kingsvalley.screens;

import nl.xnagames.kingsvalley.KingsValley;
import nl.xnagames.kingsvalley.explorer.Explorer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.math.Vector2;

public class GameScreen implements Screen
{
	// Fields
	private KingsValley game;
	private Explorer explorer;
	
	public Explorer getExplorer()
	{
		return this.explorer;
	}
	
	// Constructor
	public GameScreen(KingsValley game)
	{
		this.game = game;
		this.explorer = new Explorer(this.game, new Vector2(320f, 240f), "explorer");
	}	
	
	@Override
	public void render(float delta) 
	{
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		this.explorer.update(delta);	
		
		this.game.getBatch().begin();
		this.explorer.draw(delta);
		this.game.getBatch().end();
		
		/*
		if ( Gdx.input.isKeyPressed(Keys.LEFT))
		{
			this.game.setScreen(this.game.getSplashScreen());
		}*/
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
