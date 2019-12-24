import java.awt.*;

public abstract class SnaykObject {
    /*
    X and Y coordinates of SnaykObject
     */
    private int x;
    private int y;
    private Color color;

    private static final int SIZE = 20;

    /*
    Constructor
     */
    public SnaykObject(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static int getSIZE() {
        return SIZE;
    }

    public Color getColor() {
        return color;
    }

    public void move(){
    }

    public boolean intersects(SnaykObject other) {
        return this.x == other.getX() && this.y == other.getY();
    }

    public abstract void draw(Graphics g);

}


