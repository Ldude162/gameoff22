package com.thezeldaboi.gameoff22.movement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
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
            if (Hindsight.contactListener.playerColliding) {

                Bodies.playerBody.applyForce(0.0f, 130.0f, Bodies.playerBody.getPosition().x, Bodies.playerBody.getPosition().y, true);

            }
        }
    }
}
