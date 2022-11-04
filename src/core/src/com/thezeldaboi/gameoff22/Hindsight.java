package com.thezeldaboi.gameoff22;

//imports libraries and other classes
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
    private Box2DDebugRenderer debugRenderer;
    private Camera cameraCreator = new Camera();
    //TODO: check if this batch can be private
    private SpriteBatch batch;
    public static float PPM = 180f;
    //creates world with realistic gravity
    public static World world = new World(new Vector2(0,-10), true);
    //listens for contact between the player and a platform, used to make sure you can't jump midair
    public static Listener contactListener = new Listener();

    @Override
    public void create() {
        //initializes world
        Box2D.init();

        //creates renderer used for hitboxes, will be removed in final version
        debugRenderer = new Box2DDebugRenderer();

        //creates the camera used to display the game
        cameraCreator.createCamera();

        //creates sprite batch to draw
        batch = new SpriteBatch();

        //creates player and platform bodies
        Bodies.createSprites();

        //starts listening for contact
        world.setContactListener(contactListener);

    }



    @Override
    public void render() {
        //sets background to blue
        ScreenUtils.clear(0.1f, 0.7f, 1, 1);

        //checks for user input
        PlayerInput.movePlayer();

        //TODO: Check if I can put this in create()
        batch.setProjectionMatrix(cameraCreator.camera.combined);

        //Begins batch
        batch.begin();

        //Renders player and platforms to screen
        Bodies.render(batch);

        //ends batch
        batch.end();

        //renders hitboxes
        debugRenderer.render(world,cameraCreator.camera.combined);

        //steps world physics
        world.step(1/60f,6,2);
    }

}
