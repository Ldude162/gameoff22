package com.thezeldaboi.gameoff22.rendering;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Camera {
    public OrthographicCamera camera;

    public void createCamera() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

}
