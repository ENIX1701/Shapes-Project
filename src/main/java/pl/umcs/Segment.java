package pl.umcs;

public class Segment {
    private Vec2 vec2One;
    private Vec2 vec2Two;

    public Segment(Vec2 vec2One, Vec2 vec2Two) {
        this.vec2One = vec2One;
        this.vec2Two = vec2Two;
    }

    public Vec2 getPointOne() {
        return vec2One;
    }

    public Vec2 getPointTwo() {
        return vec2Two;
    }

    public double getSegmentLength() {
        return Math.sqrt(Math.pow(vec2Two.x - vec2One.x, 2) + Math.pow(vec2Two.y - vec2One.y, 2));
    }

    public String toSvg() {
        return String.format("""
                <svg height="100" width="100">
                    <line x1="%d" y1="%d" x2="%d" y2="%d" style="stroke-width:2" />
                </svg>""", vec2One.x, vec2One.y, vec2Two.x, vec2Two.y);
    }

    public static Segment[] getPerpendicular(Segment segment, Vec2 vec2) {
        int argSegmentPointOneX = segment.getPointOne().x;
        int argSegmentPointOneY = segment.getPointOne().y;

        int argSegmentPointTwoX = segment.getPointTwo().x;
        int argSegmentPointTwoY = segment.getPointTwo().y;

        // Vector from the first to the second point in segment
        int[] segmentVector = {argSegmentPointTwoX - argSegmentPointOneX, argSegmentPointTwoY - argSegmentPointOneY};
        int[] segmentVectorPerpendicular = {-1 * segmentVector[1], segmentVector[0]};

        return new Segment[] {
                new Segment(vec2, new Vec2(vec2.x + segmentVectorPerpendicular[0], vec2.y + segmentVectorPerpendicular[1])),
                new Segment(vec2, new Vec2(vec2.x - segmentVectorPerpendicular[0], vec2.y - segmentVectorPerpendicular[1]))
        };
    }
}
