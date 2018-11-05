import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class GameLoop extends Canvas implements Runnable {
    private boolean running = false;
    private Thread thread;
    private Handler handler;
    public static int WIDTH, HEIGHT;


    public synchronized void start() {
        if (running)
            return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private void init() {
        handler = new Handler();
        WIDTH = getWidth();
        HEIGHT = getHeight();

        this.addKeyListener(new KeyInput(handler));


        handler.setupWorld();



    }

    @Override
    public void run() {
        init();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames + " TICKS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }

    private void tick() {
        handler.tick();
    }

    private void render() {

        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        ////////////////////////////////////

        g.setColor(Color.blue);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.black);
        g.drawString("hello world", this.getWidth() / 2, this.getHeight() / 2);

        handler.render(g);
        ////////////////////////////////////
        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        Window window = new Window(500, 800, "Soda Test", new GameLoop());

    }
}
