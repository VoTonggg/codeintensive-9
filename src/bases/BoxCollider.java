package bases;

import java.awt.*;

public class BoxCollider extends GameObject {
    private int width;
    private int height;

    public BoxCollider(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    private float top() {
        return this.position.y - this.height / 2;
    }

    private float bot() {
        return this.position.y + this.height / 2;
    }

    private float left() {
        return this.position.x - this.width / 2;
    }

    private float right() {
        return this.position.x + this.width / 2;
    }
    public boolean collideWith(BoxCollider other) {
        // this vs other
        boolean xOverLap = this.left() <= other.right() && other.left() <= this.right();
        boolean yOverLap = this.top() <= other.bot() && other.top() <= this.bot();
        return xOverLap && yOverLap;
    }

    @Override
    public void render(Graphics g) {
        g.drawRect((int)this.left(),(int)this.top() ,(int)this.width ,(int)this.height );
    }

}
