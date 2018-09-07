package players;

import java.awt.*;
import java.util.ArrayList;

import bases.GameObject;
import bases.ImageRenderer;

public class Player extends GameObject {
    PlayerMove playerMove;
    PlayerShoot playerShoot;

    public Player(int x, int y) {
        super(x,y);
        this.imageRenderer = new ImageRenderer("images/player/MB-69/player1.png");
        this.playerMove = new PlayerMove();
        this.playerShoot = new PlayerShoot();
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
    }

    void shoot() {
        playerShoot.run(this);
    }

    void move() {
        this.playerMove.run(this.position);
    }
}
