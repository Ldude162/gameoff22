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

            platform.position.set(500,100);
            player.position.set(500,200);
            player.type = BodyDef.BodyType.DynamicBody;
            platform.type = BodyDef.BodyType.KinematicBody;

            playerBody = world.createBody(player);
            platformBody = world.createBody(platform);


            PolygonShape playerShape = new PolygonShape();
            PolygonShape platformShape = new PolygonShape();
            playerShape.setAsBox(42,90);
            platformShape.setAsBox(73,13);
            FixtureDef playerFDef = new FixtureDef();
            FixtureDef platformFDef = new FixtureDef();
            playerFDef.shape = playerShape;
            platformFDef.shape = platformShape;

            playerBody.createFixture(playerFDef);
            platformBody.createFixture(platformFDef);


        }

        public static void render(SpriteBatch batch) {

            float playerX = playerBody.getPosition().x-40;
            float playerY = playerBody.getPosition().y-90;
            float platformX = platformBody.getPosition().x-73;
            float platformY = platformBody.getPosition().y-13;



            playerSprite.setPosition(playerX,playerY);
            platformSprite.setPosition(platformX,platformY);

            playerSprite.draw(batch);
            platformSprite.draw(batch);

        }


}
