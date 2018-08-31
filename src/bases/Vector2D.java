package bases;

public class Vector2D {
    public float x;
    public float y;

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D() {
        this(0,0);
    }

    void addUp(float x, float y) {
        this.x += x;
        this.y += y;
    }
    public Vector2D add(float x, float y) {
        return  new Vector2D(this.x + x, this.y + y);
    }

    public void print() {
        System.out.println("x = " + this.x + ", y = " + this.y);
    }

    public void addUp(Vector2D v) {
        this.addUp(v.x,v.y );
    }

    public Vector2D add(Vector2D v) {
        return this.add(this.x + v.x, this.y + v.y);
    }


    // subtraction
    public void subtractBy(float x, float y) {
        this.x -= x;
        this.y -= y;
    }

    public Vector2D substract(float x, float y) {
        return new Vector2D(this.x - x, this.y - y );
    }

    public void subtractBy(Vector2D v) {
        this.subtractBy(v.x, v.y );
    }

    public Vector2D subtract(Vector2D v) {
        return new Vector2D(this.x - v.x, this.y - v.y);
    }

    // scale vector

    public void scaleBy(float m) {
        this.x *= m;
        this.y *= m;
    }

    public Vector2D scale(float m) {
        return new Vector2D(this.x * m, this.y * m);
    }

    // length of a vector

    public float length() {
        float length = (float) Math.sqrt(this.x * this.x + this.y * this.y );
        return length;
    }

    //normalize a vector

    public Vector2D normalize() {
        float length = this.length();
        return new Vector2D(this.x / length, this.y / length);
    }
}
