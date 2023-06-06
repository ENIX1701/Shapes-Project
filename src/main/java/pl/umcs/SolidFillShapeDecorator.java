package pl.umcs;

public class SolidFillShapeDecorator extends ShapeDecorator {
    private String color;

    public SolidFillShapeDecorator(Shape decoratedShape, String fillColor) {
        super(decoratedShape);
    }

    @Override
    public String toSvg(String style) {
        String fillFieldText = String.format("fill=\"%s\" %s ", color, style);

        return decoratedShape.toSvg(fillFieldText);
    }
}
