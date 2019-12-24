import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Snayk {
    private final List<BodyPart> body = new LinkedList<>();
    private BodyPart head;
    private BodyPart tail;
    private String direction = "right";

    public Snayk() {
        BodyPart bp1 = new BodyPart(0, 0, Color.BLACK);
        BodyPart bp2 = new BodyPart(1, 0, Color.BLACK);
        BodyPart bp3 = new BodyPart(2, 0, Color.BLACK);
        BodyPart bp4 = new BodyPart(3, 0, Color.BLACK);
        bp2.setX(1);
        bp3.setX(2);
        bp4.setX(3);
        body.add(0, bp1);
        body.add(0, bp2);
        body.add(0, bp3);
        body.add(0, bp4);

        head = body.get(0);
        tail = body.get(body.size() - 1);
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public BodyPart getHead() {
        return head;
    }

    public BodyPart getTail() {
        return tail;
    }

    public List<BodyPart> getBody() {
        return body;
    }

    public String getDirection() {
        return direction;
    }

    public void addBodyPart() throws Exception {
        BodyPart newBodyPart = new BodyPart(0, 0, Color.BLACK);
        if (direction == "right") {
            newBodyPart.setX(head.getX() + 1);
            newBodyPart.setY(head.getY());
        } else if (direction == "left") {
            newBodyPart.setX(head.getX() - 1);
            newBodyPart.setY(head.getY());
        } else if (direction == "up") {
            newBodyPart.setX(head.getX());
            newBodyPart.setY(head.getY() - 1);
        } else if (direction == "down") {
            newBodyPart.setX(head.getX());
            newBodyPart.setY(head.getY() + 1);
        } else {
            throw new Exception("invalid direction");
        }
        body.add(0, newBodyPart);
        head = body.get(0);
    }

    public void move() throws Exception {
        BodyPart temp = body.remove(body.size() - 1);
        tail = body.get(body.size() - 1);
        if (direction == "right") {
            if (head.getX() == 44) {
                temp.setX(0);
                temp.setY(head.getY());
            }
            else {
                temp.setX(head.getX() + 1);
                temp.setY(head.getY());
            }
        } else if (direction == "left") {
            if (head.getX() == 0) {
                temp.setX(44);
                temp.setY(head.getY());
            } else {
                temp.setX(head.getX() - 1);
                temp.setY(head.getY());
            }
        } else if (direction == "up") {
            if (head.getY() == 0) {
                temp.setX(head.getX());
                temp.setY(34);
            } else {
                temp.setX(head.getX());
                temp.setY(head.getY() - 1);
            }
        } else if (direction == "down") {
            if (head.getY() == 34) {
                temp.setX(head.getX());
                temp.setY(0);
            }
            else {
                temp.setX(head.getX());
                temp.setY(head.getY() + 1);
            }
        } else {
            throw new Exception("invalid direction");
        }
        body.add(0, temp);
        head = temp;
    }

    public BodyPart getBodyPart(int x, int y) {
        BodyPart ans = null;
        for (BodyPart bp: body) {
            if (x == bp.getX() && y == bp.getY()) {
                ans = bp;
                break;
            }
        }
        return ans;
    }

    public boolean intersectsBody() {
        for (BodyPart bp: body) {
            if (bp.equals(head)) {
                continue;
            } else if (head.intersects(bp)) {
                return true;
            }
        }
        return false;
    }

}
