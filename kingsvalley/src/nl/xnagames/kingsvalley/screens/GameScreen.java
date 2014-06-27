package nl.xnagames.kingsvalley.screens;

import nl.xnagames.kingsvalley.KingsValley;
import nl.xnagames.kingsvalley.explorer.Explorer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class GameScreen implements Screen
{
	// Fields
	private KingsValley game;
	private Explorer explorer;
	private OrthographicCamera cam;
	private int canvasWidth, canvasHeight;
	private Texture background;
	private Rectangle viewport;
	private float timer = 0f;
	private boolean onceIntro = true, onceMaster = true;
	
	public Explorer getExplorer()
	{
		return this.explorer;
	}
	
	// Constructor
	public GameScreen(KingsValley game)
	{
		this.game = game;
		this.viewport = new Rectangle(10, 10f, 620f, 460f);
		this.background = new Texture(Gdx.files.internal("data/cosmos_flower_macro.jpg"));		
		this.canvasWidth = Gdx.graphics.getWidth();
		this.canvasHeight = Gdx.graphics.getHeight();
		this.cam = new OrthographicCamera(this.canvasWidth, this.canvasHeight);
		this.explorer = new Explorer(this.game, new Vector2(this.canvasWidth/2f, 0f), "explorer", this.cam);
		this.cam.position.set(this.canvasWidth/2f, this.canvasHeight/2f, 0f);
		this.cam.update();
	}	
	
	@Override
	public void render(float delta) 
	{
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glViewport((int)this.viewport.x, (int)this.viewport.y,
						  (int)this.viewport.width, (int)this.viewport.height);
		
		this.playIntro(delta);
		
		this.handleInput();		
		
		this.cam.update();
		
		this.explorer.update(delta);
		// Zonder dit werkt het niet
		this.game.getBatch().setProjectionMatrix(this.cam.combined);
		
		this.game.getBatch().begin();
		this.game.getBatch().draw(this.background,
								  -this.background.getWidth()/2f, 
								  -this.background.getHeight()/2f);
		this.explorer.draw(delta);
		this.game.getBatch().end();
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
	
	private void handleInput()
	{
		if (Gdx.input.isKeyPressed(Keys.D))
		{
			this.cam.translate(4f, 0f);
		}
		if (Gdx.input.isKeyPressed(Keys.A))
		{
			this.cam.translate(-4f, 0f);
		}
		if (Gdx.input.isKeyPressed(Keys.W))
		{
			this.cam.translate(0f, 4f);
		}
		if (Gdx.input.isKeyPressed(Keys.S))
		{
			this.cam.translate(0f, -4f);
		}
		if (Gdx.input.isKeyPressed(Keys.NUM_1))
		{
			this.cam.zoom += 0.01f;
		}
		if (Gdx.input.isKeyPressed(Keys.NUM_2))
		{
			this.cam.zoom -= 0.01f;
		}
		if (Gdx.input.isKeyPressed(Keys.NUM_0))
		{			
			this.cam.rotate(0.5f);
		}
		if (Gdx.input.isKeyPressed(Keys.NUM_9))
		{
			this.cam.rotate(-0.5f);
		}
	}
	
	private void playIntro(float delta)
	{
		Gdx.app.log("this.timer", Float.toString(this.timer));
		Gdx.app.log("isplaying:", Boolean.toString(this.game.getIntroMusic().isPlaying()));
		Gdx.app.log("once:", Boolean.toString(this.onceIntro));
		Gdx.app.log("this.timer", Float.toString(this.timer));
		
		if ( this.timer > 0.5f && this.onceIntro)
		{			
			this.game.getIntroMusic().play();
			this.game.getIntroMusic().setVolume(1f);
			this.onceIntro = false;
		}
		if ( this.timer > 8f && this.onceMaster)
		{
			this.game.getMasterMelody().play();
			this.game.getMasterMelody().setLooping(true);;
			this.onceMaster = false;
		}
		if ( this.timer < 9f)
		this.timer += delta;		
			
	}
}
