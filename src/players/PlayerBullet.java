package players;

import java.awt.*;

import bases.Vector2D;
import bases.ImageUtil;

public class PlayerBullet {
    Vector2D position;
    Image image;

    PlayerBullet(int x, int y) {
        this.position = new Vector2D(x,y);
        this.image = ImageUtil.load("images/bullet/player/mb69bullet1.png");
    }

    public void render(Graphics g) {
        g.drawImage(this.image, (int)this.position.x , (int)this.position.y ,null );
    }

    public void run() {
        this.position.y -= 10;
    }

}