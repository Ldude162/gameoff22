package com.thezeldaboi.gameoff22;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import static com.thezeldaboi.gameoff22.Hindsight.world;

public class Bodies {

    public static BodyDef player = new BodyDef();
    public static BodyDef platform = new BodyDef();
    public static Box2DDebugRenderer debugRenderer;
    public static Body playerBody;
    public static Body platformBody;
    public static Sprite playerSprite = new Sprite(new Texture("player.png"));
    public static Sprite platformSprite = new Sprite(new Texture("platform_green.png"));


        public static void createSprites() {

            playerSprite.setScale(0.0056f);
            platformSprite.setScale(0.0056f);

            platform.position.set(500/Hindsight.PPM,100/Hindsight.PPM);
            player.position.set(500/Hindsight.PPM,200/Hindsight.PPM);
            player.type = BodyDef.BodyType.DynamicBody;
            platform.type = BodyDef.BodyType.KinematicBody;

            playerBody = world.createBody(player);
            platformBody = world.createBody(platform);


            PolygonShape playerShape = new PolygonShape();
            PolygonShape platformShape = new PolygonShape();
            playerShape.setAsBox(42/Hindsight.PPM,90/Hindsight.PPM);
            platformShape.setAsBox(73/Hindsight.PPM,13/Hindsight.PPM);
            FixtureDef playerFDef = new FixtureDef();
            FixtureDef platformFDef = new FixtureDef();
            playerFDef.shape = playerShape;
            platformFDef.shape = platformShape;

            playerBody.createFixture(playerFDef);
            platformBody.createFixture(platformFDef);

            playerBody.setUserData("player");
            platformBody.setUserData("platform");

        }

        public static void render(SpriteBatch batch) {

            float playerX = playerBody.getPosition().x-41;
            float playerY = playerBody.getPosition().y-90;
            float platformX = platformBody.getPosition().x-72.5f;
            float platformY = platformBody.getPosition().y-12.5f;



            playerSprite.setPosition(playerX,playerY);
            platformSprite.setPosition(platformX,platformY);

            playerSprite.draw(batch);
            platformSprite.draw(batch);

        }


}
