package com.thezeldaboi.gameoff22.movement;

import com.thezeldaboi.gameoff22.rendering.Bodies;

import static com.thezeldaboi.gameoff22.Hindsight.*;
import static com.thezeldaboi.gameoff22.Hindsight.PPM;
import static com.thezeldaboi.gameoff22.rendering.Bodies.*;

public class EventListener {

    private boolean inGameChecked = false;
    public int currentLevel = 1;
    public boolean gameDone = false;

    public void checkEvents() {
        if (inGame && !inGameChecked) {
            world.destroyBody(titleBody);
            inGameChecked = true;
        }

        if (Bodies.playerBody.getPosition().x >= 850/PPM) {
            currentLevel++;
            if (currentLevel == 2) {
                Bodies.playerBody.setTransform(150 / PPM,200 / PPM,0f);
                Bodies.playerBody.setLinearVelocity(0f, 0f);
                Bodies.platform2Body.setTransform(150 / PPM,100 / PPM,0f);
                Bodies.platformBody.setTransform(500 / PPM,200 / PPM,0f);
            } else if (currentLevel == 3) {
                Bodies.playerBody.setTransform(150 / PPM,200/PPM,0f);
                Bodies.playerBody.setLinearVelocity(0f,0f);
                Bodies.platformBody.setTransform(400 / PPM,150 / PPM,0f);
                Bodies.platform3Body.setTransform(650 / PPM, 80 / PPM, 0f);
            } else {
                Bodies.playerBody.setTransform(150 / PPM,200/PPM,0f);
                Bodies.playerBody.setLinearVelocity(0f,0f);
                gameDone = true;
                world.destroyBody(playerBody);
                world.destroyBody(platformBody);
                world.destroyBody(platform2Body);
                world.destroyBody(platform3Body);
            }
        }

        if (Bodies.playerBody.getPosition().y <= 0) {
            System.out.println("Fell!" + Bodies.playerBody.getPosition().x * PPM + " " + Bodies.playerBody.getPosition().y);
            Bodies.playerBody.setTransform(150 / PPM, 200 / PPM, 0f);
            Bodies.playerBody.setLinearVelocity(0f, 0f);
        }
    }

}
