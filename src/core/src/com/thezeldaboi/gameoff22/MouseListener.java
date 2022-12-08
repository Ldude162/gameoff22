package com.thezeldaboi.gameoff22;

import com.badlogic.gdx.InputProcessor;


public class MouseListener implements InputProcessor {

    public boolean keyDown (int keycode) {
        return false;
    }

    public boolean keyUp (int keycode) {
        return false;
    }

    public boolean keyTyped (char character) {
        return false;
    }

    public boolean touchDown (int x, int y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp (int x, int y, int pointer, int button) {

        //System.out.println("click!" + x + " " + y);

        if ((x >= 340/Hindsight.PPM && x <= 460) && (y >= 275/Hindsight.PPM && y <= 360)) {
            Hindsight.inGame = true;
        }

        return true;
    }

    public boolean touchDragged (int x, int y, int pointer) {
        return false;
    }

    public boolean mouseMoved (int x, int y) {
        return false;
    }

    public boolean scrolled (float amountX, float amountY) {
        return false;
    }
}
