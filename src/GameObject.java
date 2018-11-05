import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public abstract class GameObject {
    protected float x, y;
    protected float velX = 0, velY = 0;
    protected float direction = 0;
    protected boolean leftPressed = false;
    protected boolean rightPressed = false;
    protected boolean upPressed = false;
    protected boolean downPressed = false;

    protected ObjectID id;


    public GameObject(float x, float y, float direction, ObjectID id) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.id = id;
    }

    public abstract void tick(ArrayList<GameObject> objects);

    public abstract void render(Graphics g);

    public abstract Rectangle getBounds();

    public float getX() {
        return x;
    }


    public void setRightPressed(boolean rightPressed) {
        this.rightPressed = rightPressed;
    }


    public void setUpPressed(boolean upPressed) {
        this.upPressed = upPressed;
    }


    public void setDownPressed(boolean downPressed) {
        this.downPressed = downPressed;
    }

    public void setLeftPressed(boolean leftPressed) {
        this.leftPressed = leftPressed;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getVelX() {
        return velX;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }

    public ObjectID getID() {
        return id;
    }
}
