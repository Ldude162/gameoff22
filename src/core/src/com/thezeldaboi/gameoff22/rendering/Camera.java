package com.thezeldaboi.gameoff22.rendering;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class Camera {
    public OrthographicCamera camera;

    public void createCamera() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 20.0f, 12.0f);
        //camera.setToOrtho(false, 800, 480);
    }

}
