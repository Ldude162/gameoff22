package com.thezeldaboi.gameoff22.movement;

import com.badlogic.gdx.physics.box2d.*;

public class ContactListener implements com.badlogic.gdx.physics.box2d.ContactListener {

    public boolean playerColliding = false;
    public Body collidingWith;

    @Override
    public void endContact(Contact contact) {

        playerColliding = false;



    }

    @Override
    public void beginContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold manifold) {
        playerColliding = true;
        Fixture fixB = contact.getFixtureB();
        collidingWith = fixB.getBody();
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }

}
