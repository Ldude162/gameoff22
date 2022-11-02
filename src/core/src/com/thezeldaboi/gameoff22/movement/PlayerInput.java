package com.thezeldaboi.gameoff22.movement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.thezeldaboi.gameoff22.Hindsight;

//TODO: Work on collision detection
public class PlayerInput {
    public static boolean isJumping = false;
    public static boolean isFalling = false;
    public static float time = 9.0f;
    public static int startY;
    public static void movePlayer() {




        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            Hindsight.player.x -= 200 * Gdx.graphics.getDeltaTime();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            Hindsight.player.x += 200 * Gdx.graphics.getDeltaTime();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            startY = (int) Hindsight.player.y;

            isJumping = true;

        }

        if (isJumping) {
            Hindsight.player.y += 200 * Gdx.graphics.getDeltaTime() * time;
            time -= 0.1f;
            if (Hindsight.player.y >= startY + 400) {
                isJumping = false;
                isFalling = true;
                time = 1.0f;
            }

        }

        if (isFalling) {
            Hindsight.player.y -= 200 * Gdx.graphics.getDeltaTime() * time;
            time += 0.1f;
            while (Hindsight.player.overlaps(Hindsight.platform)) {
                Hindsight.player.y += 1;

                isFalling = false;
                time = 4.0f;
            }
        }

    }
}
