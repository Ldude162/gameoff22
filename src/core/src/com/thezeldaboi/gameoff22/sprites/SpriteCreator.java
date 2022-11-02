package com.thezeldaboi.gameoff22.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

public class SpriteCreator {

        // TODO: Fix file detection
        public Texture playerImage = new Texture(Gdx.files.internal("/assets/player.png"));
        public Texture platformImage = new Texture(Gdx.files.internal("/assets/platform_green.png"));;




        Rectangle player = new Rectangle();;
        Rectangle platform = new Rectangle();;

        public void createPos() {
            player.x = 400 - 32;
            platform.x = 300 - 20;
            player.y = 20;
            platform.y = 40;
            player.width = 64;
            platform.width = 64;
            player.height = 64;
            platform.height = 64;
        }

    public void draw(Batch batch) {
        batch.draw(playerImage, player.x, player.y);
        batch.draw(platformImage, platform.x, platform.y);
    }
}
