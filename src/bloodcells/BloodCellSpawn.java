package bloodcells;

import bases.FrameCounter;
import bases.GameObject;
import bloodcells.BloodCell;

import java.util.Random;

public class BloodCellSpawn extends GameObject {
    FrameCounter frameCounter = new FrameCounter(10);
    Random random = new Random();
    public BloodCellSpawn() {
        super(0,0);
    }

    @Override
    public void run() {
        super.run();
        frameCounter.run();
        if(frameCounter.expired) {
            BloodCell bloodCell = new BloodCell(random.nextInt(600),0 );
            GameObject.add(bloodCell);
            frameCounter.reset();
        }

    }
}
