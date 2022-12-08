package com.thezeldaboi.gameoff22.rendering;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.thezeldaboi.gameoff22.Hindsight;

public class Camera {
    public OrthographicCamera camera;

    public void createCamera() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800 / Hindsight.PPM, 480 / Hindsight.PPM);
    }
    public void updateCamera() {
        if (Hindsight.eventListener.gameDone) {

            camera.setToOrtho(false, 800, 480);

        }
    }

}
