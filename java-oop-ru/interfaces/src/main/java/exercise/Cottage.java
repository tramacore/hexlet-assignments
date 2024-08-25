package exercise;

public class Cottage implements Home {
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    public int getFloorCount() {
        return floorCount;
    }

    public double getArea() {
        return area;
    }

    public int compareTo(Home another) {
        if (area > another.getArea()) {
            return 1;
        } else if (area == another.getArea()) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return getFloorCount() + " этажный коттедж площадью " + getArea() + " метров";
    }
}
