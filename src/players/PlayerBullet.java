package players;

import java.awt.*;

import bases.GameObject;
import bases.ImageRenderer;
import bases.Vector2D;
import bases.ImageUtil;

public class PlayerBullet extends GameObject {
//    Vector2D position;
//    Image image;

    public PlayerBullet(int x, int y) {
        super(x,y);
        this.imageRenderer = new ImageRenderer("images/bullet/player/mb69bullet1.png");
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(0,-10);
    }
}
