package com.whompum.sirbird.GameContextModels.Pipes;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Pipe {

    public static final int HEAD_WIDTH = 24;
    public static final int HEAD_HEIGHT = 18;
    public static final int PIPE_WIDTH = 22;

    private int width;
    private int height;

    private int contextWidth;
    private int floor;

    private boolean baseFloor = true; //If its base is currently set at the floor

    private Rectangle bounds;

    public enum VISIBILITY_STATE{
        STATE_VISIBILE,
        STATE_OBSTRUCTED, //Where we spawn a new pipe
        STATE_INVISIBLE
    }

    public Pipe(final int height, final int contextWidth, final int floor){
        this.width = HEAD_WIDTH; //Max width
        this.height = height;

        this.floor = floor;
        this.contextWidth = contextWidth;

        bounds = new Rectangle();

        bounds.setWidth( width ).setHeight( height ).setY( floor );
    }

    public Pipe(final int height, final int contextWidth, final int floor, final boolean baseFloor){
        this( height, contextWidth, floor );

        this.baseFloor = baseFloor;

        setY();
    }

    private void setY(){

        if( !baseFloor )
            bounds.setY( height ); //If the pipe is inverted and faces down, its bottom bounds is its height
        else
            bounds.setY( floor );
    }

    public void setX(final float xPos){
        bounds.setX( xPos );
    }

    public void setHeight(final int height){
        this.height = height;
        setY();
        bounds.setHeight( height );
    }

    public boolean isHit(final Vector2 contactPoint){
        return bounds.contains( contactPoint );
    }

    public float getStart(){
        return bounds.x;
    }

    public float getEnd(){
        return getStart() + width;
    }

    public float getTop(){
        return getBottom() - height;
    }

    public float getBottom(){
        return bounds.y;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public int getHeadWidth(){
        return getWidth();
    }

    public int getPipeBodyWidth(){
        return PIPE_WIDTH;
    }

    public int getHeadHeight(){
        return HEAD_HEIGHT;
    }


    public boolean isBaseFloor() {
        return baseFloor;
    }

    public float getPipeBodyStart(){
        return getStart() + ((float)getHeadWidth() - (float)getPipeBodyWidth())*0.5F;
    }

    public VISIBILITY_STATE getVisibilityState(){
        if( getStart() < 0 && getEnd() > 0 || getStart() < contextWidth && getEnd() > contextWidth )
            return VISIBILITY_STATE.STATE_OBSTRUCTED;

        else if( getStart() < 0 && getEnd() <= 0 || getStart() >= contextWidth && getEnd() > contextWidth )
            return VISIBILITY_STATE.STATE_INVISIBLE;

        return VISIBILITY_STATE.STATE_VISIBILE;
    }

}
