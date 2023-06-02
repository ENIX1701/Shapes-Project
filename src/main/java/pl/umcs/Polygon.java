package pl.umcs;

public class Polygon {
    private Point[] points;

    public Polygon(int numberOfNodes) {
        this.points = new Point[numberOfNodes];
    }

    public void setPoints(Point point, int index) {
        this.points[index] = point;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public String toSvg() {
        StringBuilder polygonSvg = new StringBuilder("<svg height=\"100\" width=\"100\">\n" + "<polygon points=\"");

        for (Point point : points) {
            polygonSvg.append(String.format("%d,%d ", point.x, point.y));
        }
        polygonSvg.append("\" style=\"fill:lime;stroke:purple;stroke-width:1\" />\n" + "</svg>");

        return polygonSvg.toString();
    }
}
