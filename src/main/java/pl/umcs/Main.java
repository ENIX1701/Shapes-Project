package pl.umcs;

public class Main {
    public static void main(String[] args) {
        // Laboratory 1
        Vec2 testVec2One = new Vec2(1, 20);
        Vec2 testVec2Two = new Vec2(50, 3);

        Segment testSegment = new Segment(testVec2One, testVec2Two);

        System.out.println(testSegment.getSegmentLength());
        System.out.println(testSegment.toSvg());

        Vec2 testVec2Three = new Vec2(17, 11);

        Segment[] perpendicularSegment = Segment.getPerpendicular(testSegment, testVec2Three);
        System.out.println(perpendicularSegment[0].toSvg());
        System.out.println(perpendicularSegment[1].toSvg());

        // Laboratory 2
        // Task 1
        Style testStyle = new Style("red", "pink", 1);

        System.out.println(testStyle.toSvg());

        Vec2[] testVec2s = new Vec2[] {testVec2One, testVec2Two, testVec2Three};
        Polygon testPolygon = new Polygon(testVec2s);

        System.out.println(testPolygon.toSvg(""));

        // Task 2
        SvgScene svgScene = new SvgScene();
        svgScene.addPolygon(testPolygon);
        svgScene.save("index.html");

        // Task 3
        Polygon square = Polygon.square(testSegment);

        System.out.println(square.toSvg(""));

        // Task 4
        // a
        Ellipse testEllipse = new Ellipse();

        testEllipse.setMiddlePoint(testVec2Three);
        testEllipse.setRadiusOne(2);
        testEllipse.setRadiusTwo(4);

        System.out.println(testEllipse.toSvg(""));

        // b
        Shape[] shapes = {testEllipse, testPolygon};
        svgScene.setShapes(shapes);

        // Laboratory 3
        // Task 1
        SolidFilledPolygon testSolidFilledPolygon = new SolidFilledPolygon(testVec2s, "red");

        System.out.println(testSolidFilledPolygon.toSvg("stroke=\"purple\" stroke-width=\"2\""));

        // Task 2
        SolidFillShapeDecorator polygonFillDecorator = new SolidFillShapeDecorator(testPolygon, "purple");
        SolidFillShapeDecorator ellipseFillDecorator = new SolidFillShapeDecorator(testEllipse, "blue");

        System.out.println(polygonFillDecorator.toSvg("stroke=\"purple\" stroke-width=\"2\""));
        System.out.println(ellipseFillDecorator.toSvg("stroke=\"purple\" stroke-width=\"2\""));

        // Task 3
        StrokeShapeDecorator polygonStrokeDecorator = new StrokeShapeDecorator(testPolygon, "orange", 1.2);
        StrokeShapeDecorator ellipseStrokeDecorator = new StrokeShapeDecorator(testEllipse, "orange", 1.2);

        System.out.println(polygonStrokeDecorator.toSvg(""));
        System.out.println(ellipseStrokeDecorator.toSvg(""));

        // Task 4
        TransformationDecorator.Builder testBuilder = new TransformationDecorator.Builder(testPolygon);
        testBuilder.setRotate(testVec2One, 45);

        TransformationDecorator testTransformationDecorator = testBuilder.build();
    }
}