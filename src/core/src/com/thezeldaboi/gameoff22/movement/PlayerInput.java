package com.thezeldaboi.gameoff22.movement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.thezeldaboi.gameoff22.Bodies;
import com.thezeldaboi.gameoff22.Hindsight;

//TODO: Work on jump and tweaking numbers so it is realistic
public class PlayerInput {
    public static boolean isJumping = false;
    public static boolean isFalling = false;
    public static float time = 1.0f;
    public static int startY;
    public static void movePlayer() {

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            Bodies.playerBody.applyForce(1000.0f, 0.0f, Bodies.playerBody.getPosition().x, Bodies.playerBody.getPosition().y, true);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            Bodies.playerBody.applyForce(-1000.0f, 0.0f, Bodies.playerBody.getPosition().x, Bodies.playerBody.getPosition().y, true);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            isJumping = true;
            Bodies.playerBody.applyForce(0.0f, 5000.0f, Bodies.playerBody.getPosition().x, Bodies.playerBody.getPosition().y, true);
        }

    }
}
