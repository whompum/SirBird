package com.whompum.sirbird.Renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.whompum.sirbird.GameContextModels.SirBird;
import com.whompum.sirbird.GameItemLoaders.AssetLoader;
import com.whompum.sirbird.GameWorld;
import org.w3c.dom.Text;

/**
 * Helper class to render game objects such as SirBird or the Castles
 */
public class GameRenderer implements RendererHelper{

    private GameWorld world;
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;

    private SpriteBatch batcher;

    private int height, cY;

    private SirBird bird;

    private TextureRegion stableBird = AssetLoader.birdStable;
    private Animation<TextureRegion> birdAnim = AssetLoader.birdAnimation;
    private TextureRegion grass = AssetLoader.grass;
    private TextureRegion background = AssetLoader.background;

    public GameRenderer(final GameWorld world, final int height, final int cY){
        this.world = world;

        camera = new OrthographicCamera();
        camera.setToOrtho( true, 136, height );

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix( camera.combined );

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix( camera.combined );
        shapeRenderer.setAutoShapeType( true );

        this.height = height;
        this.cY = cY;

        bird = world.getBird();
    }

    @Override
    public void render(final float runTime){
        //Drawing black prevents view flickering
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin( ShapeRenderer.ShapeType.Filled );

        //Background color
        shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
        shapeRenderer.rect(0, 0, 136, cY + 66);

        //Dirt. REPLACE WITH SPRITES
        shapeRenderer.setColor(147 / 255.0f, 80 / 255.0f, 27 / 255.0f, 1);
        shapeRenderer.rect(0, cY + 77, 136, 52);
        shapeRenderer.end();

        batcher.begin();

        batcher.draw( grass , 0, cY+66, 136, 11 );

        // Disable transparency
        // This is good for performance when drawing images that do not require
        // transparency.
        batcher.disableBlending();
        batcher.draw(AssetLoader.background, 0, cY + 23, 136, 43);

        // The bird needs transparency, so we enable that again.
        batcher.enableBlending();

        drawSirBird( batcher, ( bird.isDescending() ) ? AssetLoader.birdStable : AssetLoader.birdAnimation.getKeyFrame( runTime ) );

        // End SpriteBatch
        batcher.end();

    }

    private void drawSirBird( final SpriteBatch batcher, final TextureRegion region){

        batcher.draw( region,
                      bird.getX(),
                      bird.getY(),
                      bird.getWidth() * 0.5F,
                      bird.getHeight() * 0.5F,
                      bird.getWidth(),
                      bird.getHeight(),
                      1, 1,
                      bird.getRotation() );

    }

}













