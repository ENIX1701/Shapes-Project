package pl.umcs;

public class Ellipse implements Shape {
    private Vec2 middleVec2;
    private double radiusOne;
    private double radiusTwo;

    public void setMiddlePoint(Vec2 middleVec2) {
        this.middleVec2 = middleVec2;
    }

    public void setRadiusOne(double radiusOne) {
        this.radiusOne = radiusOne;
    }

    public void setRadiusTwo(double radiusTwo) {
        this.radiusTwo = radiusTwo;
    }

    public Ellipse() {
        super();
    }

    @Override
    public String toSvg(String style) {
        return String.format("""
                <svg height="100" width="100">
                    <ellipse cx="%d" cy="%d" rx="%f" ry="%f" style="stroke-width:2"/>
                </svg>""", this.middleVec2.x, this.middleVec2.y, this.radiusOne, this.radiusTwo);
    }
}
