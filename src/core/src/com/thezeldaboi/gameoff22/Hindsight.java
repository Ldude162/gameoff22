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
import com.thezeldaboi.gameoff22.movement.PlayerInput;
import com.thezeldaboi.gameoff22.rendering.Camera;

public class Hindsight extends ApplicationAdapter {
    public Camera cameraCreator = new Camera();
    public SpriteBatch batch;
    public ShapeRenderer shapeRenderer;
    public Texture playerImage;
    public Texture platformImage;
    public static World world = new World(new Vector2(0,-10), true);
    public static Box2DDebugRenderer debugRenderer;


    @Override
    public void create() {
        Box2D.init();
        platformImage = new Texture(Gdx.files.internal("platform_green.png"));
        playerImage = new Texture(Gdx.files.internal("player.png"));
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);
        debugRenderer = new Box2DDebugRenderer();
        cameraCreator.createCamera();
        batch = new SpriteBatch();

        Bodies.createSprites();


    }



    @Override
    public void render() {
        ScreenUtils.clear(0.1f, 0.7f, 1, 1);

        //cameraCreator.camera.update();

        /*PlayerInput.movePlayer();
        shapeRenderer.begin();
        shapeRenderer.rect(player.x, player.y, player.getWidth(), player.getHeight());
        shapeRenderer.rect(platform.x, platform.y, platform.getWidth(), platform.getHeight());
        shapeRenderer.end();
         */
        batch.setProjectionMatrix(cameraCreator.camera.combined);
        batch.begin();
        Bodies.render(batch);
        //batch.draw(playerImage, player.x, player.y);
        //batch.draw(platformImage, platform.x, platform.y);
        batch.end();

        debugRenderer.render(world,cameraCreator.camera.combined);

        world.step(1/60f,6,2);
    }

}
