package pl.umcs;

public class Main {
    public static void main(String[] args) {
        Point testPointOne = new Point(1, 2);
        Point testPointTwo = new Point(5, 3);

        Segment testSegment = new Segment(testPointOne, testPointTwo);

        System.out.println(testSegment.getSegmentLength());
        System.out.println(testSegment.toSvg());

        Point testPointThree = new Point(4, 11);

        Segment[] perpendicularSegment = Segment.getPerpendicular(testSegment, testPointThree);
        System.out.println(perpendicularSegment[0].toSvg());
        System.out.println(perpendicularSegment[1].toSvg());
    }
}