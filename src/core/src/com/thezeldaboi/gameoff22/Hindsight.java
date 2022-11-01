package com.thezeldaboi.gameoff22;

import com.badlogic.gdx.ApplicationAdapter;
import com.thezeldaboi.gameoff22.rendering.Batch;
import com.thezeldaboi.gameoff22.rendering.Camera;
import com.thezeldaboi.gameoff22.sprites.SpriteCreator;

public class Hindsight extends ApplicationAdapter {


    @Override
    public void create() {
        SpriteCreator.loadTextures();
        Camera.createCamera();
        Batch.createBatch();


    }
}
