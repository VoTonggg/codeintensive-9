package enemies;

import bases.*;

import java.awt.*;

public class Enemy extends GameObject {
    FrameCounter frameCounter = new FrameCounter(20);
    EnemyBullet newBullet;

    public Enemy(int x, int y) {
        super(x,y);
        this.imageRenderer = new ImageRenderer("images/enemy/bacteria/bacteria1.png");
        newBullet = new EnemyBullet(x,y);
        GameObject.add(newBullet);
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
    }

    @Override
    public void run() {
        super.run();
        this.position.y += 3;

        frameCounter.run();
        if (frameCounter.expired) {
            EnemyBullet enemyBullet = new EnemyBullet((int)this.position.x, (int)this.position.y);
            GameObject.add(enemyBullet);
            frameCounter.reset();
        }
    }
}
