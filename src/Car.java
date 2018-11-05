
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.IOException;

import java.util.ArrayList;

public class Car extends GameObject {

    private int width;
    private int height;
    private float accel = 0.5f;
    private Handler handler;
    private double vel;
    private double velX, velY;
    private double maxVel;

    public Car(float x, float y, float direction, ObjectID id) {
        super(x, y, direction, id);

        vel = 0;
        velX = 0;
        velY = 0;
        maxVel = 7;
        leftPressed = false;
        rightPressed = false;
        upPressed = false;
        downPressed = false;
    }


    public boolean aboveMaxVel() {
        return Math.sqrt(Math.pow(velX, 2) + Math.pow(velY, 2)) > maxVel * 2;
    }

    @Override


    public void tick(ArrayList<GameObject> objects) {

        if (upPressed && vel < maxVel) {
            vel += accel;
        } else if (downPressed && vel > -maxVel) {
            vel -= accel;
        }
        if (leftPressed) {
            direction -= 5;
        } else if (rightPressed) {
            direction += 5;
        }
        if (!upPressed && vel > 0) {
            vel -= accel;
        } else if (!downPressed && vel < 0) {
            vel += accel;
        }
        x += vel * Math.cos(Math.toRadians(direction));
        y += vel * Math.sin(Math.toRadians(direction));
        double tlx = 50 * Math.sqrt(2) * Math.cos(Math.toRadians(direction - 135));
        double tly = 50 * Math.sqrt(2) * Math.sin(Math.toRadians(direction - 135));
        //System.out.println(x + 50 + tlx + " " + (y + 50 + tly));
        collision(objects);

    }

    private void collision(ArrayList<GameObject> objects) {

        for (int i = 0; i < objects.size(); i++) {
            GameObject thisObj = objects.get(i);
            if (thisObj.getID() == ObjectID.Wall) {
                if (getBoundsTop().intersects(thisObj.getBounds())) {
                    velY = 0;
                    y = (thisObj.getY() + height / 2) + 1;
                }

                if (getBounds().intersects(thisObj.getBounds())) {
                    velY = 0;

                    y = thisObj.getY() - height;
                }

                if (getBoundsLeft().intersects(thisObj.getBounds())) {
                    x = thisObj.getX() + 17;
                }

                if (getBoundsRight().intersects(thisObj.getBounds())) {
                    x = thisObj.getX() - 17;
                }
            }
        }

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) (x + width / 2 - width / 4), (int) (y + height / 1.2), width / 2, height / 6);
    }

    public Rectangle getBoundsTop() {
        return new Rectangle((int) (x + width / 2 - width / 4), (int) y, (width / 2), height / 6);
    }

    public Rectangle getBoundsLeft() {
        return new Rectangle((int) x, (int) (y + 2.5), 5, height - 5);
    }

    public Rectangle getBoundsRight() {
        return new Rectangle((int) (x + width - 5), (int) (y + 2.5), 5, height - 5);
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        try {
            AffineTransform at = new AffineTransform();
            at.translate(x, y);
            at.rotate(Math.toRadians(direction), 15, 7.5);
            g2d.drawImage(ImageLoader.getCar(), at, null);
        } catch (IOException e) {
            AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(direction), (int) x + 15, (int) y + 7.5);
            g2d.setColor(Color.green);
            g2d.draw(at.createTransformedShape(new Rectangle((int) x, (int) y, 30, 15)));
        }

    }
}


