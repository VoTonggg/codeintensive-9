package enemies;

import bases.ImageRenderer;
import bases.ImageUtil;
import bases.Vector2D;

import java.awt.*;

public class EnemyBullet {
    Vector2D position;
    Image image;

    public EnemyBullet(int x,int y) {
        this.position = new Vector2D(x,y);
        this.image = ImageUtil.load("images/bullet/enemy/enemy2_bullet1.png");
    }

    public void render(Graphics g) {
        g.drawImage(this.image,(int)this.position.x ,(int)this.position.y , null);
    }

    public void run() {
        this.position.y += 10;
    }
}
