package players;

import bases.GameObject;
import bases.ImageRenderer;

import java.awt.*;

public class Player2 extends GameObject {
    Player2Move player2Move;
    public Player2(int x, int y) {
        super(x, y);
        this.imageRenderer = new ImageRenderer("images/player/MB-69/player1.png");
        player2Move = new Player2Move();
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
    }

    @Override
    public void run() {
        super.run();
        this.move();
    }

    private void move() {
        this.player2Move.run(this.position);
    }
}
