import java.awt.*;

public class BodyPart extends SnaykObject {

    public BodyPart(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.getColor());
        g.fill3DRect(this.getX() * getSIZE(), this.getY() * getSIZE(), getSIZE(), getSIZE(), true);
    }
}
