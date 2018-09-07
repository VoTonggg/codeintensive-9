package bases;

import java.awt.*;

public class ImageRenderer {
    Image image;

    public void render(Graphics g, Vector2D position) {
        int imageWidth = this.image.getWidth(null);
        int imageHeight = this.image.getHeight(null);
        Vector2D renderPosition = position.substract(imageWidth/2,imageHeight/2 );
        g.drawImage(this.image, (int)renderPosition.x ,(int)renderPosition.y ,null );
    }

    public ImageRenderer(String url) {
        this.image = ImageUtil.load(url);
    }
}
