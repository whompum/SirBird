package com.whompum.sirbird.GameItemLoaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {

    public static final String ASSET_PATH = "data/main_sheet.png"; //relative path under android/assets

    private static Texture spriteSheet;

    private static TextureRegion background, grass;

    private static TextureRegion birdUp, birdDown, birdStable;

    private static TextureRegion pipeBody, pipeHeadUp, pipeHeadDown;

    private static Animation<TextureRegion[]> birdAnimation;

    /**
     * Loads up a batch of assets and then cuts out the items like
     * TextureRegions
     */
    public static void load(){

        spriteSheet = new Texture( Gdx.files.internal( ASSET_PATH ) );
        spriteSheet.setFilter( TextureFilter.Nearest, TextureFilter.Nearest );

        background = new TextureRegion( spriteSheet, 0, 0, 136, 43 );
        flipY( background );

        grass = new TextureRegion( spriteSheet, 0, 43, 143, 11 );
        flipY( grass );

        birdDown = new TextureRegion( spriteSheet, 136, 0, 17, 12 );
        flipY( birdDown );

        birdStable = new TextureRegion( spriteSheet, 153, 0, 17, 12 );
        flipY( birdStable );

        birdUp = new TextureRegion( spriteSheet, 170, 0, 17, 12 );
        flipY( birdUp );

        pipeHeadUp = new TextureRegion( spriteSheet, 192, 0, 24, 14 );

        pipeHeadDown = new TextureRegion( pipeHeadUp ); //Cpy pipeHeadUp and flip it
        flipY( pipeHeadDown );

        pipeBody = new TextureRegion( spriteSheet, 136, 16, 22, 3 );
            //Flip?

        initBirdAnimation();

    }

    public static void dispose() {
        // We must dispose of the spriteSheet when we are finished.
        spriteSheet.dispose();
    }

    private static void flipY(final TextureRegion region){
        region.flip( false, true );
    }

    private static void initBirdAnimation(){
        birdAnimation = new Animation( 0.06F, birdDown, birdStable, birdUp );
        birdAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
    }


}
