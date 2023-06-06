package pl.umcs;

public class Polygon implements Shape {
    private Vec2[] vec2s;

    public Polygon(Vec2[] vec2s) {
        super();

        this.vec2s = vec2s;
    }

    public void setPoints(Vec2 vec2, int index) {
        this.vec2s[index] = vec2;
    }

    public void setPoints(Vec2[] vec2s) {
        this.vec2s = vec2s;
    }

    public String toSvg(String style) {
        StringBuilder verticesText = new StringBuilder("");

        for (Vec2 vec2 : vec2s) {
            verticesText.append(String.format("%d,%d ", vec2.x, vec2.y));
        }

        return String.format("<polygon points=\"%s\" %s />", verticesText, style);
    }

    public static Polygon square(Segment line) {
        Vec2 middleVec2 = new Vec2((line.getPointOne().x + line.getPointTwo().x) / 2,
                                      (line.getPointOne().y + line.getPointTwo().y) / 2);
        Segment perpendicularLine = Segment.getPerpendicular(line, middleVec2)[0];

        Vec2[] vertices = {
                new Vec2(line.getPointOne().x, line.getPointOne().y),
                new Vec2(line.getPointTwo().x, line.getPointTwo().y),
                new Vec2(perpendicularLine.getPointOne().x, perpendicularLine.getPointOne().y),
                new Vec2(perpendicularLine.getPointTwo().x, perpendicularLine.getPointTwo().y)
        };

        return new Polygon(vertices);
    }
}
