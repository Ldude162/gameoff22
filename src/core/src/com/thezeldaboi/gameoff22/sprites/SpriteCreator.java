package com.thezeldaboi.gameoff22.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class SpriteCreator {

    public static void loadTextures() {
        Texture playerImage;
        Texture platformImage;
        playerImage = new Texture(Gdx.files.internal("player.png"));
        platformImage = new Texture(Gdx.files.internal("platform_green.png"));

    }
}
