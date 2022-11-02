package com.thezeldaboi.gameoff22;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.thezeldaboi.gameoff22.movement.PlayerInput;
import com.thezeldaboi.gameoff22.rendering.Camera;

public class Hindsight extends ApplicationAdapter {
    public Camera cameraCreator = new Camera();
    public SpriteBatch batch;
    public ShapeRenderer shapeRenderer;
    public Texture playerImage;
    public Texture platformImage;
    public static Rectangle player = new Rectangle();
    public static Rectangle platform = new Rectangle();

    @Override
    public void create() {
        platformImage = new Texture(Gdx.files.internal("platform_green.png"));
        playerImage = new Texture(Gdx.files.internal("player.png"));
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);

        cameraCreator.createCamera();
        batch = new SpriteBatch();

        player.x = 400 - 100;
        platform.x = 300 - 20;
        player.y = 30;
        platform.y = 40;
        player.width = 84;
        platform.width = 146;
        player.height = 182;
        platform.height = 26;

    }



    @Override
    public void render() {
        ScreenUtils.clear(0.1f, 0.7f, 1, 1);

        cameraCreator.camera.update();

        PlayerInput.movePlayer();
        shapeRenderer.begin();
        shapeRenderer.rect(player.x, player.y, player.getWidth(), player.getHeight());
        shapeRenderer.rect(platform.x, platform.y, platform.getWidth(), platform.getHeight());
        shapeRenderer.end();
        batch.setProjectionMatrix(cameraCreator.camera.combined);
        batch.begin();

        batch.draw(playerImage, player.x, player.y);
        batch.draw(platformImage, platform.x, platform.y);


        batch.end();

    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }

}
