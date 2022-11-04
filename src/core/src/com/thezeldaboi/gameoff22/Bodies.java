package com.thezeldaboi.gameoff22;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.*;

import static com.thezeldaboi.gameoff22.Hindsight.world;

public class Bodies {

    private static BodyDef player = new BodyDef();
    private static BodyDef platform = new BodyDef();
    public static Body playerBody;
    public static Body platformBody;
    public static Body platform2Body;
    private static Sprite playerSprite = new Sprite(new Texture("player.png"));
    private static Sprite platformSprite = new Sprite(new Texture("platform_green.png"));
    private static Sprite platform2Sprite = new Sprite(new Texture("platform_green.png"));
    public static Body[] platforms;


        public static void createBodies() {

            playerSprite.setScale(0.0056f);
            platformSprite.setScale(0.0056f);
            platform2Sprite.setScale(0.0056f);

            platform.position.set(500/Hindsight.PPM,100/Hindsight.PPM);
            player.position.set(500/Hindsight.PPM,230/Hindsight.PPM);
            player.type = BodyDef.BodyType.DynamicBody;
            platform.type = BodyDef.BodyType.KinematicBody;

            playerBody = world.createBody(player);
            platformBody = world.createBody(platform);
            platform.position.set(200/Hindsight.PPM,150/Hindsight.PPM);
            platform2Body = world.createBody(platform);


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
            platform2Body.createFixture(platformFDef);

            playerBody.setUserData("player");
            platformBody.setUserData("platform");
            platform2Body.setUserData("platform");
            System.out.println();

            Body[] platforms = {platformBody, platform2Body};


        }

        public static void render(SpriteBatch batch) {

            float playerX = playerBody.getPosition().x-41;
            float playerY = playerBody.getPosition().y-90;
            float platformX = platformBody.getPosition().x-72.5f;
            float platformY = platformBody.getPosition().y-12.5f;
            float platform2X = platform2Body.getPosition().x-72.5f;
            float platform2Y = platform2Body.getPosition().y-12.5f;


            playerSprite.setPosition(playerX,playerY);
            platformSprite.setPosition(platformX,platformY);
            platform2Sprite.setPosition(platform2X,platform2Y);

            if (Hindsight.inGame) {
                playerSprite.draw(batch);
                platformSprite.draw(batch);
                platform2Sprite.draw(batch);

            }

        }


}
