package pl.umcs;

public class StrokeShapeDecorator extends ShapeDecorator {
    private String color;
    private double width;

    public StrokeShapeDecorator(Shape decoratedShape, String color, double width) {
        super(decoratedShape);
        this.color = color;
        this.width = width;
    }

    @Override
    public String toSvg(String style) {
        String strokeFieldText = String.format("stroke=\"%s\" stroke-width=\"%f\" ", this.color, this.width);

        return decoratedShape.toSvg(strokeFieldText);
    }
}
