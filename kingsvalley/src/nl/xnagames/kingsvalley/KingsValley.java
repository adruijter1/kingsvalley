package nl.xnagames.kingsvalley;

import gesturelistener.ExplorerGestureListener;
import nl.xnagames.kingsvalley.screens.GameScreen;
import nl.xnagames.kingsvalley.screens.SplashScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.input.GestureDetector;

public class KingsValley extends Game 
{
	// Fields
	private SplashScreen splashScreen;
	private GameScreen gameScreen;
	private InputMultiplexer multiplexer;
	private ExplorerGestureListener gestureListener;
	
	
	// Properties
	//setter
	public void setSplashScreen(SplashScreen splashScreen)
	{
		this.splashScreen = splashScreen;
	}
	//getter
	public SplashScreen getSplashScreen()
	{
		return this.splashScreen;
	}
	
	public void setGameScreen(GameScreen gameScreen)
	{
		this.gameScreen = gameScreen;
	}
	
	public GameScreen getGameScreen()
	{
		return this.gameScreen;
	}
	
	
	
	
	
	@Override
	public void create() 
	{		
		this.splashScreen = new SplashScreen(this);
		this.gameScreen = new GameScreen(this);
		this.gestureListener = new ExplorerGestureListener(this);
		this.multiplexer = new InputMultiplexer();
		this.multiplexer.addProcessor(new GestureDetector(this.gestureListener));
		Gdx.input.setInputProcessor(this.multiplexer);
		this.setScreen(this.splashScreen);		
	}

	@Override
	public void dispose() 
	{
		super.dispose();
	}

	@Override
	public void render() 
	{		
		Gdx.gl.glClearColor(0f, 1f, 1f, 1f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		Gdx.graphics.setDisplayMode(640, 480, false);
		super.render();
	}

	@Override
	public void resize(int width, int height) 
	{
		super.resize(width, height);
	}

	@Override
	public void pause() 
	{
		super.pause();
	}

	@Override
	public void resume() 
	{
		super.resume();
	}
}
