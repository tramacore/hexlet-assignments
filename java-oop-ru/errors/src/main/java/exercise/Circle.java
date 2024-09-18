package exercise;

public class Circle {
    private Point point;
    private int radius;

    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException{
        if (radius < 0) {
            throw new NegativeRadiusException("");
        } else {
            return Math.PI * (radius * radius);
        }
    }
}
