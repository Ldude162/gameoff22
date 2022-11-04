package com.thezeldaboi.gameoff22.movement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.thezeldaboi.gameoff22.Bodies;
import com.thezeldaboi.gameoff22.Hindsight;


public class PlayerInput {

    public static void movePlayer() {

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            Bodies.playerBody.applyForce(5.0f, 0.0f, Bodies.playerBody.getPosition().x, Bodies.playerBody.getPosition().y, true);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            Bodies.playerBody.applyForce(-5.0f, 0.0f, Bodies.playerBody.getPosition().x, Bodies.playerBody.getPosition().y, true);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            if (Hindsight.contactListener.playerColliding && Bodies.playerBody.getPosition().y > Hindsight.contactListener.collidingWith.getPosition().y + 0.5f) {

                Bodies.playerBody.applyForce(0.0f, 130.0f, Bodies.playerBody.getPosition().x, Bodies.playerBody.getPosition().y, true);

            }
        }

        if (Bodies.playerBody.getPosition().y <= 0) {
            System.out.println("Fell!");
            Bodies.playerBody.setTransform(500/Hindsight.PPM,230/Hindsight.PPM, 0f);
            Bodies.playerBody.setLinearVelocity(0f,0f);
        }
    }
}
