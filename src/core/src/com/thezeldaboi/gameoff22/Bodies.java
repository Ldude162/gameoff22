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

            playerSprite.setScale(0.02f);
            platformSprite.setScale(0.02f);

            player.type = BodyDef.BodyType.DynamicBody;
            platform.type = BodyDef.BodyType.KinematicBody;



            platform.position.set(-60,-10);
            player.position.set(-30,-50);

            playerBody = world.createBody(player);
            platformBody = world.createBody(platform);





        }

        public static void render(SpriteBatch batch) {

            float playerX = playerBody.getPosition().x;
            float playerY = playerBody.getPosition().y;
            float platformX = platformBody.getPosition().x;
            float platformY = platformBody.getPosition().y;

            playerSprite.setPosition(playerX,playerY);
            platformSprite.setPosition(platformX,platformY);

            playerSprite.draw(batch);
            platformSprite.draw(batch);

        }


}
