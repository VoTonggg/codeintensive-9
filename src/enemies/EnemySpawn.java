package enemies;

import bases.FrameCounter;
import bases.GameObject;

import java.util.Random;

public class EnemySpawn extends GameObject {
    Random random = new Random();
    FrameCounter frameCounter = new FrameCounter(60);
    public EnemySpawn() {
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
