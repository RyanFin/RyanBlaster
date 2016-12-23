package me.finlayson.ryan.ryanblaster;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame extends ApplicationAdapter {

	private SpriteBatch batch;
	private TextureAtlas walkAtlas;
	private Animation animation;
	private float timePassed = 0;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		walkAtlas = new TextureAtlas(Gdx.files.internal("walk.atlas"));
		animation = new Animation(1/30f, walkAtlas.getRegions());

	}

	//memory management
	@Override
	public void dispose () {
		//free up resources when not needed
		batch.dispose();
		walkAtlas.dispose();
	}

	//game loop
	@Override
	public void render () {
		Gdx.gl.glClearColor(0,1,0,1); //(R,G,B,A) format, (1,1,1,1) = white
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		timePassed += Gdx.graphics.getDeltaTime();
		batch.draw((TextureRegion) animation.getKeyFrame(timePassed,true),300,500);
		batch.end();
	}

}
