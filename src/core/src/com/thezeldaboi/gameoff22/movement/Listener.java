package com.thezeldaboi.gameoff22.movement;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

public class Listener implements ContactListener {

    public boolean playerColliding = false;

    @Override
    public void endContact(Contact contact) {

        playerColliding = false;



    }

    @Override
    public void beginContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold manifold) {
        //System.out.println("pre collide");
        playerColliding = true;
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }

}
