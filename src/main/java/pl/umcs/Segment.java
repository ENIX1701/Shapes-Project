package pl.umcs;

public class Segment {
    private Point pointOne;
    private Point pointTwo;

    public Segment(Point pointOne, Point pointTwo) {
        this.pointOne = pointOne;
        this.pointTwo = pointTwo;
    }

    public Point getPointOne() {
        return pointOne;
    }

    public Point getPointTwo() {
        return pointTwo;
    }

    public double getSegmentLength() {
        return Math.sqrt(Math.pow(pointTwo.x - pointOne.x, 2) + Math.pow(pointTwo.y - pointOne.y, 2));
    }

    public String toSvg() {
        return String.format("<svg height=\"100\" width=\"100\">\n" +
                             "    <line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" style=\"stroke-width:2\" />\n" +
                             "</svg>", pointOne.x, pointOne.y, pointTwo.x, pointTwo.y);
    }

    public static Segment[] getPerpendicular(Segment segment, Point point) {
        int argSegmentPointOneX = segment.getPointOne().x;
        int argSegmentPointOneY = segment.getPointOne().y;

        int argSegmentPointTwoX = segment.getPointTwo().x;
        int argSegmentPointTwoY = segment.getPointTwo().y;

        // Vector from the first to the second point in segment
        int[] segmentVector = {argSegmentPointTwoX - argSegmentPointOneX, argSegmentPointTwoY - argSegmentPointOneY};
        int[] segmentVectorPerpendicular = {-1 * segmentVector[1], segmentVector[0]};

        return new Segment[] {
                new Segment(point, new Point(point.x + segmentVectorPerpendicular[0], point.y + segmentVectorPerpendicular[1])),
                new Segment(point, new Point(point.x - segmentVectorPerpendicular[0], point.y - segmentVectorPerpendicular[1]))
        };
    }
}
