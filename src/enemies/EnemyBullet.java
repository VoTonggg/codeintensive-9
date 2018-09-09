package enemies;

import bases.BoxCollider;
import bases.GameObject;
import bases.ImageRenderer;

import java.awt.*;

public class EnemyBullet extends GameObject {

    public EnemyBullet(int x,int y) {
        super(x,y);
        this.imageRenderer = new ImageRenderer("images/bullet/enemy/enemy2_bullet1.png");
        this.boxCollider = new BoxCollider(x,y ,40 ,40 );
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
    }

    @Override
    public void run() {
        super.run();
        this.position.y += 10;
    }


}
