package com.whompum.sirbird.UserInput;

import com.badlogic.gdx.InputProcessor;
import com.whompum.sirbird.GameContextModels.SirBird;

public class InputHelper{

    private SirBird obj;

    public InputHelper(final SirBird obj){

    }

    private boolean onTouch(){
        obj.onClick();
        return true;
    }

    public InputProcessor getInputProcessor() {
        return inputProcessor;
    }

    private InputProcessor inputProcessor = new SimpleInputProcessor(){
        @Override
        public boolean touchDown(int screenX, int screenY, int pointer, int button) {
            return onTouch();
        }
    };

}
