package bloodcells;

import bases.GameObject;
import bases.ImageRenderer;

import java.awt.*;

public class BloodCell extends GameObject {
    public BloodCell(int x, int y) {
        super(x,y);
        this.imageRenderer = new ImageRenderer("images/blood cells/blood-cell1.png");
    }

    @Override
    public void run() {
        super.run();
        this.position.y += 3;
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
    }
}
