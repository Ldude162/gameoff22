package com.thezeldaboi.gameoff22.rendering;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.thezeldaboi.gameoff22.Hindsight;

public class Camera {
    public OrthographicCamera camera;

    public void createCamera() {
        camera = new OrthographicCamera();
        //camera.setToOrtho(false, 20, 12);
        camera.setToOrtho(false, 800 / Hindsight.PPM, 480 / Hindsight.PPM);
    }

}
