package enemies;

import bases.FrameCounter;
import bases.GameObject;

import java.util.Random;

public class EnemySpawner extends GameObject {
    Random random = new Random();
    FrameCounter frameCounter = new FrameCounter(100);
    public EnemySpawner() {
        super(0, 0);
    }

    @Override
    public void run() {
        super.run();
        frameCounter.run();
        if (frameCounter.expired) {
            Enemy enemy = new Enemy(random.nextInt(600), 0);
            GameObject.add(enemy);
            frameCounter.reset();
        }
    }
}
