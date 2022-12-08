package com.thezeldaboi.gameoff22.movement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.thezeldaboi.gameoff22.rendering.Bodies;
import com.thezeldaboi.gameoff22.Hindsight;
import static com.thezeldaboi.gameoff22.Hindsight.inGame;


public class PlayerInput {

    public static void movePlayer() {
        if (inGame) {
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


        }
    }
}
