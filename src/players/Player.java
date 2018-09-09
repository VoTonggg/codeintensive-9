package players;

import java.awt.*;
import java.util.ArrayList;

import bases.BoxCollider;
import bases.GameObject;
import bases.ImageRenderer;
import enemies.Enemy;
import enemies.EnemyBullet;

public class Player extends GameObject {
    PlayerMove playerMove;
    PlayerShoot playerShoot;

    public Player(int x, int y) {
        super(x,y);
        this.imageRenderer = new ImageRenderer("images/player/MB-69/player1.png");
        this.playerMove = new PlayerMove();
        this.playerShoot = new PlayerShoot();
        this.boxCollider = new BoxCollider(x,y ,64 ,80 );
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
    }

    @Override
    public void run() {
        super.run();
        this.move();
        this.shoot();
        gotHitByEnemy();
        gotHitByEnemyBullet();
    }


    void shoot() {
        playerShoot.run(this);
    }

    void move() {
        this.playerMove.run(this.position);
    }

    public void gotHitByEnemy() {
        Enemy enemy = GameObject.checkCollision(this.boxCollider);
        if (enemy != null) {
            System.exit(0);
        }
    }

    public void gotHitByEnemyBullet() {
        EnemyBullet enemyBullet = GameObject.shootPlayer(this.boxCollider);
        if (enemyBullet != null) {
            System.exit(0);
        }
    }
}
