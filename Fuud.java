import java.awt.*;
import java.util.Random;

public class Fuud extends SnaykObject {

    public Fuud(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.getColor());
        g.fill3DRect(this.getX() * getSIZE(), this.getY() * getSIZE(), getSIZE(), getSIZE(), true);
    }

    public void changePosition() {
        Random r = new Random();
        this.setX(r.nextInt(44));
        this.setY(r.nextInt(34));
    }
}
