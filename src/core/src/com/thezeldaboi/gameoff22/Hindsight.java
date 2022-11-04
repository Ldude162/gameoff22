package com.thezeldaboi.gameoff22;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.thezeldaboi.gameoff22.movement.Listener;
import com.thezeldaboi.gameoff22.movement.PlayerInput;
import com.thezeldaboi.gameoff22.rendering.Camera;

public class Hindsight extends ApplicationAdapter {
    public Camera cameraCreator = new Camera();
    public SpriteBatch batch;
    public Texture playerImage;
    public Texture platformImage;
    public static float PPM = 180f;
    public static World world = new World(new Vector2(0,-10), true);
    public static Box2DDebugRenderer debugRenderer;
    public static Listener contactListener = new Listener();

    @Override
    public void create() {
        Box2D.init();
        platformImage = new Texture(Gdx.files.internal("platform_green.png"));
        playerImage = new Texture(Gdx.files.internal("player.png"));
        debugRenderer = new Box2DDebugRenderer();
        cameraCreator.createCamera();
        batch = new SpriteBatch();


        Bodies.createSprites();

        world.setContactListener(contactListener);

    }



    @Override
    public void render() {
        ScreenUtils.clear(0.1f, 0.7f, 1, 1);
        PlayerInput.movePlayer();
        batch.setProjectionMatrix(cameraCreator.camera.combined);
        batch.begin();
        Bodies.render(batch);
        batch.end();

        debugRenderer.render(world,cameraCreator.camera.combined);

        world.step(1/60f,6,2);
    }

}
