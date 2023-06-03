package pl.umcs;

public class Polygon extends Shape {
    private Point[] points;

    public Polygon(int numberOfNodes) {
        super(new Style("transparent", "black", 1));

        this.points = new Point[numberOfNodes];
    }

    public Polygon(int numberOfNodes, Style style) {
        super(style);

        this.points = new Point[numberOfNodes];
        this.style = style;
    }

    public void setPoints(Point point, int index) {
        this.points[index] = point;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public String toSvg() {
        StringBuilder polygonSvg = new StringBuilder("<svg height=\"100\" width=\"100\">\n" + "    <polygon points=\"");

        for (Point point : points) {
            polygonSvg.append(String.format("%d,%d ", point.x, point.y));
        }
        polygonSvg.append(String.format("\" %s />\n" + "</svg>", this.style.toSvg()));

        return polygonSvg.toString();
    }

    public static Polygon square(Segment line, Style style) {
        Point middlePoint = new Point((line.getPointOne().x + line.getPointTwo().x) / 2,
                                      (line.getPointOne().y + line.getPointTwo().y) / 2);
        Segment perpendicularLine = Segment.getPerpendicular(line, middlePoint)[0];

        Point[] vertices = {
                new Point(line.getPointOne().x, line.getPointOne().y),
                new Point(line.getPointTwo().x, line.getPointTwo().y),
                new Point(perpendicularLine.getPointOne().x, perpendicularLine.getPointOne().y),
                new Point(perpendicularLine.getPointTwo().x, perpendicularLine.getPointTwo().y)
        };
        Polygon square = new Polygon(4, style);
        square.setPoints(vertices);

        return square;
    }
}
