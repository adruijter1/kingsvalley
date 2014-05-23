package nl.xnagames.kingsvalley.explorer;



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
	private AtlasRegion test;
	private ExplorerIdleRight idleRight;
	private ExplorerWalkRight walkRight;
	private AnimatedSprite state;
	private float speed;
	
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
	public ExplorerIdleRight getIdleRight()
	{
		return this.idleRight;
	}
	public void setIdleRight(ExplorerIdleRight idleRight)
	{
		this.idleRight = idleRight;
	}	
	public AtlasRegion getTest()
	{
		return this.test;
	}
	public float getSpeed()
	{
		return this.speed;
	}
	public ExplorerWalkRight getWalkRight()
	{
		return this.walkRight;
	}
	public void setState(AnimatedSprite state)
	{
		this.state = state;
	}
	
	// Constructor
	public Explorer(KingsValley game, Vector2 position, String name)
	{
		this.game = game;
		this.position =  position;
		this.name = name;
		this.speed = 2f;
		
		this.regions = new Array<AtlasRegion>();
		
		for ( int i = 1; i <= 8; i++)
		{
			this.regions.add(this.game.getAtlas().findRegion("explorer", i));
			
		}		
	
		this.idleRight = new ExplorerIdleRight(this);
		this.walkRight = new ExplorerWalkRight(this);
		this.state = this.getIdleRight();
		
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
