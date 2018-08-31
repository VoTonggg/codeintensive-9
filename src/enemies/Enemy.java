package enemies;

import bases.FrameCounter;
import bases.ImageUtil;
import bases.Vector2D;

import java.awt.*;
import java.util.ArrayList;

public class Enemy {
    Vector2D position;
    Image image;
    FrameCounter frameCounter = new FrameCounter(20);
    public ArrayList<EnemyBullet> enemyBullets = new ArrayList<>();
    EnemyBullet newBullet;
    public Enemy(int x, int y) {
        this.position = new Vector2D(x,y);
        this.image = ImageUtil.load("images/enemy/bacteria/bacteria1.png");
        newBullet = new EnemyBullet(x,y);
        enemyBullets.add(newBullet);
    }
    public void render(Graphics g) {
        g.drawImage(this.image,(int)this.position.x , (int)this.position.y ,null );
        for (EnemyBullet eB: enemyBullets) {
            eB.render(g);
        }
    }

    public void run() {
        this.position.y += 3;

        for (EnemyBullet eB: enemyBullets) {
            eB.run();
        }

        frameCounter.run();
        if (frameCounter.expired) {
            EnemyBullet enemyBullet = new EnemyBullet((int)this.position.x, (int)this.position.y);
            enemyBullets.add(enemyBullet);
            frameCounter.reset();
        }
    }
}
