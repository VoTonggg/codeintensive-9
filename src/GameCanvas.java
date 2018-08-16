import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GameCanvas extends JPanel {
    Image background, player;

    ArrayList<PlayerBullet> bs;
    ArrayList<Enemy> es;

    int x = 300 - 32;
    int y = 700 - 40;
    boolean rightPressed = false;
    boolean leftPressed = false;
    boolean upPressed = false;
    boolean downPressed = false;
    boolean xPressed = false;

    BufferedImage backBuffer; // null
    Graphics backBufferGraphics;

    public GameCanvas() {
        bs = new ArrayList<>();
        PlayerBullet b1 = new PlayerBullet();
        b1.x = 300;
        b1.y = 700;

        PlayerBullet b2 = new PlayerBullet();
        b2.x = 300;
        b2.y = 600;

        es = new ArrayList<>();
        Enemy e1 = new Enemy();
        e1.x = 50;
        e1.y = 0;

        Enemy e2 = new Enemy();
        e2.x = 250;
        e2.y = 0;

        Enemy e3 = new Enemy();
        e3.x = 500;
        e3.y = 0;

        try {
            background = ImageIO.read(new File("images/background/background.png"));
            player = ImageIO.read(new File("images/player/MB-69/player1.png"));
            b1.image = ImageIO.read(new File("images/bullet/player/mb69bullet1.png"));
            b2.image = ImageIO.read(new File("images/bullet/player/mb69bullet1.png"));
            e1.image = ImageIO.read(new File("images/enemy/bacteria/bacteria1.png"));
            e2.image = ImageIO.read(new File("images/enemy/bacteria/bacteria1.png"));
            e3.image = ImageIO.read(new File("images/enemy/bacteria/bacteria1.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        bs.add(b1);
        bs.add(b2);
        es.add(e1);
        es.add(e2);
        es.add(e3);

        backBuffer = new BufferedImage(600,800 ,BufferedImage.TYPE_INT_ARGB );
        backBufferGraphics = backBuffer.getGraphics();

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer,0 ,0 ,null );
    }

    void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_X) {
            xPressed = true;
        }
    }
    void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_X) {
            xPressed = false;
        }
    }

    void run() {
        if (rightPressed) {
            x += 5;
        }
        if (leftPressed) {
            x -= 5;
        }
        if (upPressed) {
            y -= 5;
        }
        if (downPressed) {
            y += 5;
        }
        for(PlayerBullet b: bs) {
            b.y -= 5;
        }
        if (xPressed && !shootLock) {
            PlayerBullet newB = new PlayerBullet();
            newB.x = x;
            newB.y = y;
            try {
                newB.image = ImageIO.read(new File("images/bullet/player/mb69bullet1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            bs.add(newB);
            shootLock = true;
        }

        if (shootLock) {
            count++;
            if (count > 20) {
                shootLock = false;
                count = 0;
            }
        }
        for(Enemy e: es) {
            e.y += 10;
            if (e.y > 800) {
                e.y = 0;
            }
        }
    }

    boolean shootLock = false;
    int count = 0 ;


    void render() {
        backBufferGraphics.drawImage(background, 0,0 ,null );
        backBufferGraphics.drawImage(player, x, y, null);

        for(PlayerBullet b: bs) {
            backBufferGraphics.drawImage(b.image,b.x ,b.y ,null );
        }

        for(Enemy e: es) {
            backBufferGraphics.drawImage(e.image,e.x ,e.y ,null );
        }
        this.repaint();
    }
}