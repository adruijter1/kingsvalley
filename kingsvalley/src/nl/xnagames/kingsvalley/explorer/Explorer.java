package nl.xnagames.kingsvalley.explorer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import nl.xnagames.kingsvalley.KingsValley;
import nl.xnagames.kingsvalley.animatedsprite.AnimatedSprite;

public class Explorer
{
	// Fields
	private KingsValley game;
	private Vector2 position;
	private String name;
	private Array<AtlasRegion> regions;
	private ExplorerIdleRight idleRight;
	private ExplorerWalkRight walkRight;
	private ExplorerWalkLeft walkLeft;
	private ExplorerIdleLeft idleLeft;
	private ExplorerJumpRight jumpRight;
	private AnimatedSprite state;
	private float speed;
	private ExplorerIdleJumpRight idleJumpRight;
	private ExplorerIdleJumpLeft idleJumpLeft;
	private OrthographicCamera cam;
	private Sound jumpSound;
	
	//Properties
	public KingsValley getGame()
	{
		return this.game;
	}
	public Array<AtlasRegion> getRegions()
	{
		return this.regions;
	}
	public Vector2 getPosition()
	{
		return this.position;
	}
	public void setPosition(Vector2 position)
	{
		this.position = position;
	}
	public ExplorerIdleRight getIdleRight()
	{
		this.idleRight.initialize();
		return this.idleRight;
	}
	public void setIdleRight(ExplorerIdleRight idleRight)
	{
		this.idleRight = idleRight;
	}	
	public float getSpeed()
	{
		return this.speed;
	}
	public ExplorerWalkRight getWalkRight()
	{
		this.walkRight.initialize();
		return this.walkRight;
	}
	
	public ExplorerWalkLeft getWalkLeft()
	{
		this.walkLeft.initialize();
		return this.walkLeft;
	}
	public ExplorerIdleLeft getIdleLeft()
	{
		this.idleLeft.initialize();
		return this.idleLeft;
	}
	
	public ExplorerJumpRight getJumpRight()
	{
		this.jumpRight.initialize();
		return this.jumpRight;
	}
	
	public ExplorerIdleJumpRight getIdleJumpRight()
	{
		this.idleJumpRight.initialize();
		return this.idleJumpRight;
	}
	
	public ExplorerIdleJumpLeft getIdleJumpLeft()
	{
		this.idleJumpLeft.initialize();
		return this.idleJumpLeft;
	}
	
	public void setState(AnimatedSprite state)
	{
		this.state = state;
	}
	public AnimatedSprite getState()
	{
		return this.state;
	}
	public OrthographicCamera getCam()
	{
		return this.cam;
	}
	public Sound getJumpSound()
	{
		return this.jumpSound;
	}
	
	
	// Constructor
	public Explorer(KingsValley game, Vector2 position, String name, OrthographicCamera cam)
	{
		this.game = game;
		this.position =  position;
		this.name = name;
		this.cam = cam;
		this.speed = 2f;
		
		this.regions = new Array<AtlasRegion>();
				
		for ( int i = 1; i <= 8; i++)
		{
			this.regions.add(this.game.getAtlas().findRegion(this.name, i));
			
		}
		
		this.jumpSound = Gdx.audio.newSound(Gdx.files.internal("data/Sound/FallOfHighFloor.mp3"));
		
	
		this.idleRight = new ExplorerIdleRight(this);
		this.walkRight = new ExplorerWalkRight(this);
		this.idleLeft = new ExplorerIdleLeft(this);
		this.walkLeft = new ExplorerWalkLeft(this);
		this.jumpRight = new ExplorerJumpRight(this, 24, 32);
		this.idleJumpRight = new ExplorerIdleJumpRight(this, 24, 32);
		this.idleJumpLeft = new ExplorerIdleJumpLeft(this, -24, 32);
		this.state = this.walkRight;
		
	}
	
	// update
	public void update(float delta)
	{
		this.state.update(delta);
	}
	
	
	// draw
	public void draw(float delta)
	{
		this.state.draw(delta);
	}
}
