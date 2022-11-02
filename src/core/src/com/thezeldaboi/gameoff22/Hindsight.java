package com.thezeldaboi.gameoff22;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.thezeldaboi.gameoff22.rendering.Camera;
import com.thezeldaboi.gameoff22.sprites.SpriteCreator;

public class Hindsight extends ApplicationAdapter {
    public Camera cameraCreator = new Camera();
    public SpriteBatch batch;

    public SpriteCreator spriteCreator = new SpriteCreator();

    @Override
    public void create() {
        spriteCreator.createPos();

        cameraCreator.createCamera();
        batch = new SpriteBatch();

    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0.1f, 0.2f, 1);

        cameraCreator.camera.update();

        batch.setProjectionMatrix(cameraCreator.camera.combined);
        batch.begin();

        spriteCreator.draw(batch);
        batch.end();

    }

}
