import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageLoader {
    public static Image getCar() throws IOException{
        return ImageIO.read(new File("assets\\testcard.png"));
    }
}
