import java.awt.*;

public class Enemy {
    Vector2D position;
    Image image;

    Enemy(int x, int y) {
        this.position = new Vector2D(x,y);
        this.image = ImageUtil.load("images/enemy/bacteria/bacteria1.png");
    }
    public void render(Graphics g) {
        g.drawImage(this.image,(int)this.position.x , (int)this.position.y ,null );
    }

    public void run() {
        this.position.y += 3;
    }
}
