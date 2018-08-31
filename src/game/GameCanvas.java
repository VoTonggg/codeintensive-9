package game;

import bases.FrameCounter;
import bases.ImageUtil;
import enemies.Enemy;
import enemies.EnemyBullet;
import inputs.InputManager;
import players.Player;
import players.PlayerBullet;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class GameCanvas extends JPanel {
    Image background;

    ArrayList<PlayerBullet> bullets;
    ArrayList<Enemy> enemies;
    ArrayList<EnemyBullet> enemyBullets;
    Player player;

    InputManager inputManager;

    BufferedImage backBuffer; // null
    Graphics backBufferGraphics;
    Random random;
    FrameCounter frameCounter;

    public GameCanvas() {
        random = new Random();

//        inputManager = new inputs.InputManager();
        inputManager = InputManager.instance;

        frameCounter = new FrameCounter(60);

        bullets = new ArrayList<>();
        enemyBullets = new ArrayList<>();
        enemies = new ArrayList<>();

        background = ImageUtil.load("images/background/background.png");
        player = new Player(268,600 );
        player.bullets = this.bullets;

        backBuffer = new BufferedImage(600,800 ,BufferedImage.TYPE_INT_ARGB );
        backBufferGraphics = backBuffer.getGraphics();

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer,0 ,0 ,null );
    }


    void run() {
        player.run();
        for(PlayerBullet b: bullets) {
            b.run();
        }

        frameCounter.run();
        if (frameCounter.expired) {
            Enemy enemy = new Enemy(random.nextInt(600), 0);
            enemies.add(enemy);
            frameCounter.reset();
        }

        for(Enemy e: enemies) {
            e.run();
        }
    }

    void render() {
        backBufferGraphics.drawImage(background, 0,0 ,null );
//        backBufferGraphics.drawImage(player.image, player.x, player.y, null);
        player.render(backBufferGraphics);

        for(PlayerBullet b: bullets) {
            b.render(backBufferGraphics);
        }

        for(Enemy e: enemies) {
            e.render(backBufferGraphics);
        }

        this.repaint();
    }
}
