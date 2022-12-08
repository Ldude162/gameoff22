package com.thezeldaboi.gameoff22.rendering;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.thezeldaboi.gameoff22.Hindsight;

import static com.thezeldaboi.gameoff22.Hindsight.world;

public class Bodies {

    final private static BodyDef player = new BodyDef();
    final private static BodyDef platform = new BodyDef();
    final private static BodyDef ui = new BodyDef();
    public static Body playerBody;
    public static Body platformBody;
    public static Body platform2Body;
    public static Body platform3Body;
    public static Body titleBody;
    private static final Sprite titleSprite = new Sprite(new Texture("title.png"));
    final private static Sprite playerSprite = new Sprite(new Texture("player.png"));
    final private static Sprite platformSprite = new Sprite(new Texture("platform_green.png"));
    final private static Sprite platform2Sprite = new Sprite(new Texture("platform_green.png"));
    final private static Sprite platform3Sprite = new Sprite(new Texture("platform_green.png"));
    final private static Sprite blindnessSprite = new Sprite(new Texture("blindness.png"));

    final private static Texture startButtonTexture = new Texture("play_button.png");
    final private static Drawable startButtonDrawable = new TextureRegionDrawable(new TextureRegion(startButtonTexture));
    private static final BitmapFont font = new BitmapFont();
    final private static Color black = new Color();
    private static float blindnessX = -397.79f;
    private static Button startButton;
    private static int currentBlindnessLevel = 1;


        public static void createBodies() {

            playerSprite.setScale(0.0056f);
            platformSprite.setScale(0.0056f);
            platform2Sprite.setScale(0.0056f);
            platform3Sprite.setScale(0.0056f);
            titleSprite.setScale(0.0056f);
            blindnessSprite.setScale(0.0056f);


            platform.position.set(500/ Hindsight.PPM,100/Hindsight.PPM);
            player.position.set(150/Hindsight.PPM,200/Hindsight.PPM);
            ui.position.set(400/Hindsight.PPM,300/Hindsight.PPM);
            ui.type = BodyDef.BodyType.StaticBody;
            player.type = BodyDef.BodyType.DynamicBody;
            platform.type = BodyDef.BodyType.KinematicBody;


            playerBody = world.createBody(player);
            platformBody = world.createBody(platform);
            platform.position.set(200/Hindsight.PPM,150/Hindsight.PPM);
            platform2Body = world.createBody(platform);
            platform.position.set(100,100);
            platform3Body = world.createBody(platform);
            titleBody = world.createBody(ui);

            PolygonShape titleShape = new PolygonShape();
            PolygonShape playerShape = new PolygonShape();
            PolygonShape platformShape = new PolygonShape();
            playerShape.setAsBox(42/Hindsight.PPM,90/Hindsight.PPM);
            platformShape.setAsBox(73/Hindsight.PPM,13/Hindsight.PPM);
            titleShape.setAsBox(200/Hindsight.PPM,50/Hindsight.PPM);
            FixtureDef playerFDef = new FixtureDef();
            FixtureDef platformFDef = new FixtureDef();
            FixtureDef titleFDef = new FixtureDef();
            playerFDef.shape = playerShape;
            platformFDef.shape = platformShape;
            titleFDef.shape = titleShape;

            titleBody.createFixture(titleFDef);
            playerBody.createFixture(playerFDef);
            platformBody.createFixture(platformFDef);
            platform2Body.createFixture(platformFDef);
            platform3Body.createFixture(platformFDef);

            playerBody.setUserData("player");
            platformBody.setUserData("platform");
            platform2Body.setUserData("platform");
            platform3Body.setUserData("platform");
            titleBody.setUserData("title");

            startButton = new Button(startButtonDrawable);
            startButton.setTransform(true);
            startButton.setScale(0.0056f);
            startButton.setPosition(340/Hindsight.PPM,120/Hindsight.PPM);

            black.r = 0;
            black.g = 0;
            black.b = 0;
            black.a =1;

            font.setColor(black);
            font.getData().setScale(2,2);


            blindnessSprite.setPosition(blindnessX,-200);

        }


        public static void render(SpriteBatch batch) {

            float playerX = playerBody.getPosition().x-41;
            float playerY = playerBody.getPosition().y-90;
            float platformX = platformBody.getPosition().x-72.5f;
            float platformY = platformBody.getPosition().y-12.5f;
            float platform2X = platform2Body.getPosition().x-72.5f;
            float platform2Y = platform2Body.getPosition().y-12.5f;
            float platform3X = platform3Body.getPosition().x-72.5f;
            float platform3Y = platform3Body.getPosition().y-12.5f;
            float titleX = titleBody.getPosition().x-174.5f;
            float titleY = titleBody.getPosition().y-39;



            if (playerX +41.27f -397.79f >= blindnessX) {
                blindnessX = playerX + 41.27f - 397.79f;
            }

            if (Hindsight.eventListener.currentLevel != currentBlindnessLevel) {
                currentBlindnessLevel = Hindsight.eventListener.currentLevel;
                blindnessX = -397.79f;
            }

            playerSprite.setPosition(playerX,playerY);
            platformSprite.setPosition(platformX,platformY);
            platform2Sprite.setPosition(platform2X,platform2Y);
            platform3Sprite.setPosition(platform3X,platform3Y);
            blindnessSprite.setPosition(blindnessX,-238.68f);
            titleSprite.setPosition(titleX,titleY);

            if (Hindsight.inGame && !Hindsight.eventListener.gameDone) {
                playerSprite.draw(batch);
                platformSprite.draw(batch);
                platform2Sprite.draw(batch);
                platform3Sprite.draw(batch);
                blindnessSprite.draw(batch);

            } else if (Hindsight.eventListener.gameDone) {
                font.draw(batch, "You did it!", 330, 250);

            } else {
                titleSprite.draw(batch);
                startButton.draw(batch, 1);

            }

        }


}
