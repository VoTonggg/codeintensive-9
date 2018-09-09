package enemies;

import bases.*;

import java.awt.*;

public class Enemy extends GameObject {
    EnemyBullet newBullet;
    EnemyShoot enemyShoot;

    public Enemy(int x, int y) {
        super(x,y);
        this.imageRenderer = new ImageRenderer("images/enemy/bacteria/bacteria1.png");
        this.boxCollider = new BoxCollider(x, y, 30, 30);
        newBullet = new EnemyBullet(x,y);
        enemyShoot = new EnemyShoot();
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
        this.shoot();

    }
    void shoot() {
        this.enemyShoot.run(this);
    }

    public void getHit() {
        this.destroy();
    }

}
