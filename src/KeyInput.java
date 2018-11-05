import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(1);
        }
        for(GameObject thisObj : handler.objects) {
            if (thisObj.getID() == ObjectID.Car1) {
                switch (key) {
                    case KeyEvent.VK_D:
                        thisObj.setRightPressed(true);
                        break;

                    case KeyEvent.VK_A:
                        thisObj.setLeftPressed(true);
                        break;

                    case KeyEvent.VK_W:
                        thisObj.setUpPressed(true);
                        break;

                    case KeyEvent.VK_S:
                        thisObj.setDownPressed(true);
                        break;

                }
            }
            if (thisObj.getID() == ObjectID.Car2) {
                switch (key) {
                    case KeyEvent.VK_RIGHT:
                        thisObj.setRightPressed(true);
                        break;

                    case KeyEvent.VK_LEFT:
                        thisObj.setLeftPressed(true);
                        break;

                    case KeyEvent.VK_UP:
                        thisObj.setUpPressed(true);
                        break;

                    case KeyEvent.VK_DOWN:
                        thisObj.setDownPressed(true);
                        break;

                }
            }
        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for(GameObject thisObj : handler.objects) {
            if (thisObj.getID() == ObjectID.Car1) {
                switch (key) {
                    case KeyEvent.VK_D:
                        thisObj.setRightPressed(false);
                        break;

                    case KeyEvent.VK_A:
                        thisObj.setLeftPressed(false);
                        break;

                    case KeyEvent.VK_W:
                        thisObj.setUpPressed(false);
                        break;

                    case KeyEvent.VK_S:
                        thisObj.setDownPressed(false);
                        break;

                }
            }
            if (thisObj.getID() == ObjectID.Car2) {
                switch (key) {
                    case KeyEvent.VK_RIGHT:
                        thisObj.setRightPressed(false);
                        break;

                    case KeyEvent.VK_LEFT:
                        thisObj.setLeftPressed(false);
                        break;

                    case KeyEvent.VK_UP:
                        thisObj.setUpPressed(false);
                        break;

                    case KeyEvent.VK_DOWN:
                        thisObj.setDownPressed(false);
                        break;

                }
            }
        }

    }
}
