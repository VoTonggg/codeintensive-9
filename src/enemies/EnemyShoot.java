package enemies;

import bases.FrameCounter;
import bases.GameObject;
import bases.Vector2D;

public class EnemyShoot {
    FrameCounter frameCounter = new FrameCounter(40);

    public void run(Enemy enemy) {
        frameCounter.run();
        if (frameCounter.expired) {
            Vector2D position = enemy.position;
            EnemyBullet enemyBullet = new EnemyBullet((int)position.x, (int)position.y);
            GameObject.add(enemyBullet);
            frameCounter.reset();
        }
    }
}
