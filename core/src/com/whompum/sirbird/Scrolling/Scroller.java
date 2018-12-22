package com.whompum.sirbird.Scrolling;


/**
 * Class responsible for shooting out delta positions values during an update
 *
 * To work it needs a Velocity
 *
 */
public class Scroller {

    public static final float DEFAULT_TERMINAL_VELOCITY = 7F;

    private boolean isLinearScroll = true;

    private float terminalVelocity = DEFAULT_TERMINAL_VELOCITY;
    private float currentScrollVelocity = 0;

    private OnScrollChangeListener client;

    public Scroller(final OnScrollChangeListener client){
        this.client = client;
    }

    public Scroller(final OnScrollChangeListener client, final boolean isLinearScroll) {
        this( client );
        this.isLinearScroll = isLinearScroll;
    }

    public Scroller(final OnScrollChangeListener client, final boolean isLinearScroll, final float terminalVelocity){
        this( client, isLinearScroll );
        this.terminalVelocity = terminalVelocity;
    }

    public void update(final float deltaFps){

        updateVelocity(
                (isLinearScroll) ? terminalVelocity : terminalVelocity * deltaFps
        );

        notifyClient( currentScrollVelocity );
    }

    private void updateVelocity(final float deltaVelocity){

        currentScrollVelocity += deltaVelocity;

        if( currentScrollVelocity >= terminalVelocity )
            currentScrollVelocity = terminalVelocity;

    }

    private void notifyClient(final float deltaPos){
        if( client != null )
            client.onNewDeltaPos( deltaPos );
    }

    public float getCurrentScrollVelocity() {
        return currentScrollVelocity;
    }

    public boolean isLinearScroll() {
        return isLinearScroll;
    }

    public float getTerminalVelocity() {
        return terminalVelocity;
    }

    public void setLinearScroll(boolean linearScroll) {
        isLinearScroll = linearScroll;
    }

    public void setTerminalVelocity(float terminalVelocity) {
        this.terminalVelocity = terminalVelocity;
    }

    public void setCurrentScrollVelocity(float currentScrollVelocity) {
        this.currentScrollVelocity = currentScrollVelocity;
    }
}





