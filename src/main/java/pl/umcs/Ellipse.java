package pl.umcs;

public class Ellipse extends Shape {
    private Point middlePoint;
    private double radiusOne;
    private double radiusTwo;

    public void setMiddlePoint(Point middlePoint) {
        this.middlePoint = middlePoint;
    }

    public void setRadiusOne(double radiusOne) {
        this.radiusOne = radiusOne;
    }

    public void setRadiusTwo(double radiusTwo) {
        this.radiusTwo = radiusTwo;
    }

    public Ellipse(Style style) {
        super(style);
    }

    @Override
    public String toSvg() {
        return String.format("""
                <svg height="100" width="100">
                    <ellipse cx="%d" cy="%d" rx="%f" ry="%f" />
                </svg>""", this.middlePoint.x, this.middlePoint.y, this.radiusOne, this.radiusTwo);
    }
}
