import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Wall extends GameObject {





    public Wall(float x, float y, ObjectID id) {
        super(x, y, 0, id);

    }

    @Override
    public void tick(ArrayList<GameObject> objects) {
        // TODO Auto-generated method stub

    }

    @Override
    public void render(Graphics g) {
        // TODO Auto-generated method stub
        g.setColor(Color.red);
        g.fillRect((int)x, (int)y, (int)16, (int)16);

    }

    @Override
    public Rectangle getBounds() {
        // TODO Auto-generated method stub
        return new Rectangle((int)x, (int)y, 16, 16);
    }

}
