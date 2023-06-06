package pl.umcs;

public class SolidFilledPolygon extends Polygon {
    private String color;
    public SolidFilledPolygon(Vec2[] vec2s, String color) {
        super(vec2s);

        this.color = color;
    }

    @Override
    public String toSvg(String style) {
        String fillFieldText = String.format("fill=\"%s\" %s ", color, style);

        return super.toSvg(fillFieldText);
    }
}
