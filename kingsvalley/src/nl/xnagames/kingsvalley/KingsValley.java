package nl.xnagames.kingsvalley;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;

public class KingsValley implements ApplicationListener 
{
	
	@Override
	public void create() 
	{		
		
	}

	@Override
	public void dispose() 
	{
		
	}

	@Override
	public void render() 
	{		
		Gdx.gl.glClearColor(0f, 1f, 1f, 1f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		Gdx.graphics.setDisplayMode(640, 480, false);
		
	}

	@Override
	public void resize(int width, int height) 
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
}
