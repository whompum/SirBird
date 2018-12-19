package com.whompum.sirbird.GameItemLoaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {

    public static final String ASSET_PATH = "data/assets_group.png"; //relative path under android/assets

    private static Texture assetContainer;

    private static TextureRegion background, grass;

    private static TextureRegion birdUp, birdDown, birdStable;

    private static TextureRegion pipeBody, pipeHeadUp, pipeHeadDown;

    private static Animation<TextureRegion[]> birdAnimation;

    /**
     * Loads up a batch of assets and then cuts out the items like
     * TextureRegions
     */
    public static void load(){

        assetContainer = new Texture( Gdx.files.internal( ASSET_PATH) );
        assetContainer.setFilter( TextureFilter.Nearest, TextureFilter.Nearest );

        background = new TextureRegion( assetContainer, 0, 0, 136, 43 );
        flipY( background );

        grass = new TextureRegion( assetContainer, 0, 43, 143, 11 );
        flipY( grass );

        birdDown = new TextureRegion( assetContainer, 136, 0, 17, 12 );
        flipY( birdDown );

        birdStable = new TextureRegion( assetContainer, 153, 0, 17, 12 );
        flipY( birdStable );

        birdUp = new TextureRegion( assetContainer, 170, 0, 17, 12 );
        flipY( birdUp );

        pipeHeadUp = new TextureRegion( assetContainer, 192, 0, 24, 14 );

        pipeHeadDown = new TextureRegion( pipeHeadUp ); //Cpy pipeHeadUp and flip it
        flipY( pipeHeadDown );

        pipeBody = new TextureRegion( assetContainer, 136, 16, 22, 3 );
            //Flip?

        initBirdAnimation();

    }

    public static void dispose() {
        // We must dispose of the assetContainer when we are finished.
        assetContainer.dispose();
    }

    private static void flipY(final TextureRegion region){
        region.flip( false, true );
    }

    private static void initBirdAnimation(){
        birdAnimation = new Animation( 0.06F, birdDown, birdStable, birdUp );
        birdAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
    }


}
