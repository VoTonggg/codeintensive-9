package game;

import bases.GameObject;
import bases.ImageUtil;
import bloodcells.BloodCellSpawn;
import enemies.EnemySpawner;
import inputs.InputManager;
import players.Player;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;



public class GameCanvas extends JPanel {
    Image background;
    Player player;

    InputManager inputManager;
    BufferedImage backBuffer; // null
    Graphics backBufferGraphics;
    BloodCellSpawn bloodCellSpawn;

    Random random;

    public GameCanvas() {
        random = new Random();
        inputManager = InputManager.instance;
        bloodCellSpawn = new BloodCellSpawn();

        background = ImageUtil.load("images/background/background.png");
        player = new Player(300,700 );
        GameObject.add(player);
        GameObject.add(new EnemySpawner());

        backBuffer = new BufferedImage(600,800 ,BufferedImage.TYPE_INT_ARGB );
        backBufferGraphics = backBuffer.getGraphics();

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer,0 ,0 ,null );
    }


    void run() {
        GameObject.runAll();
    }

    void render() {
        backBufferGraphics.drawImage(background, 0,0 ,null );
        GameObject.renderAll(backBufferGraphics);
        this.repaint();
    }
}
