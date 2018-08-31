package bases;

import java.awt.*;

public class ImageRenderer {
    Image image;

    public void render(Graphics g, Vector2D position) {
        g.drawImage(this.image, (int)position.x ,(int)position.y ,null );
    }

    public ImageRenderer(String url) {
        this.image = ImageUtil.load(url);
    }
}
