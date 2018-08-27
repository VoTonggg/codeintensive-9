import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GameCanvas extends JPanel {
    Image background;

    ArrayList<PlayerBullet> bullets;
    ArrayList<Enemy> enemies;
    Player player;

    InputManager inputManager;

    BufferedImage backBuffer; // null
    Graphics backBufferGraphics;
    Random random;

    public GameCanvas() {
        random = new Random();
        inputManager = new InputManager();
        bullets = new ArrayList<>();
        enemies = new ArrayList<>();

        background = ImageUtil.load("images/background/background.png");
        player = new Player(268,600 );
        player.bullets = this.bullets;
        player.inputManager = this.inputManager; // reference, point to

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

        enemySpawnCount++;
        if (enemySpawnCount >= 60) {
            Enemy enemy = new Enemy(random.nextInt(600), 0);
            enemies.add(enemy);
            enemySpawnCount = 0;
        }

        for(Enemy e: enemies) {
            e.run();

        }
    }

    int enemySpawnCount = 0;


    boolean shootLock = false;
    int count = 0 ;


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
