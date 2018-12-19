package com.whompum.sirbird.Renderer;

import android.graphics.Color;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.whompum.sirbird.GameWorld;

/**
 * Helper class to render game objects such as SirBird or the Castles
 */
public class GameRenderer implements RendererHelper{

    private GameWorld world;
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;


    public GameRenderer(final GameWorld world){
        this.world = world;

        camera = new OrthographicCamera();
        camera.setToOrtho( true, 360>>1, 560>>1 );

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix( camera.combined );
        shapeRenderer.setAutoShapeType( true );
    }

    @Override
    public void render(){

        //Drawing black prevents view flickering
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

}
