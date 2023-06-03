package pl.umcs;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Laboratory 1
        Point testPointOne = new Point(1, 2);
        Point testPointTwo = new Point(5, 3);

        Segment testSegment = new Segment(testPointOne, testPointTwo);

        System.out.println(testSegment.getSegmentLength());
        System.out.println(testSegment.toSvg());

        Point testPointThree = new Point(4, 11);

        Segment[] perpendicularSegment = Segment.getPerpendicular(testSegment, testPointThree);
        System.out.println(perpendicularSegment[0].toSvg());
        System.out.println(perpendicularSegment[1].toSvg());

        // Laboratory 2
        // Task 1
        Style testStyle = new Style("red", "pink", 4);

        System.out.println(testStyle.toSvg());

        Polygon testPolygon = new Polygon(3);
        Point[] testPoints = new Point[] {testPointOne, testPointTwo, testPointThree};
        testPolygon.setPoints(testPoints);

        System.out.println(testPolygon.toSvg());

        // Task 2
        SvgScene svgScene = new SvgScene();
        svgScene.addPolygon(testPolygon);
        svgScene.save("index.html");

        // Task 3
        Polygon square = Polygon.square(testSegment, testStyle);

        System.out.println(square.toSvg());

        // Task 4
        // a
        Ellipse testEllipse = new Ellipse(testStyle);

        testEllipse.setMiddlePoint(testPointThree);
        testEllipse.setRadiusOne(2);
        testEllipse.setRadiusTwo(4);

        System.out.println(testEllipse.toSvg());

        // b
        Shape[] shapes = {testEllipse, testPolygon};
        svgScene.setShapes(shapes);
    }
}