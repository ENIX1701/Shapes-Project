package pl.umcs;

public class TransformationDecorator extends ShapeDecorator {
    private boolean translate;
    private Vec2 translateVector;

    private boolean rotate;
    private double rotateAngle;
    private Vec2 rotateCenter;

    private boolean scale;
    private Vec2 scaleVector;

    public TransformationDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public String toSvg(String style) {
        StringBuilder transformFieldText = new StringBuilder();

        if (this.translate) {
            transformFieldText.append(String.format("translate(%d %d) ", this.translateVector.x, this.translateVector.y));
        }

        if (this.translate) {
            transformFieldText.append(String.format("rotate(%f %d %d) ", rotateAngle, rotateCenter.x, rotateCenter.y));
        }

        if (this.translate) {
            transformFieldText.append(String.format("scale(%d %d) ", scaleVector.x, scaleVector.y));
        }

        return super.toSvg(String.format("transform=\"%s\" %s", transformFieldText, style));
    }

    public static class Builder {
        private boolean translate = false;
        private Vec2 translateVector;

        private boolean rotate = false;
        private double rotateAngle;
        private Vec2 rotateCenter;

        private boolean scale = false;
        private Vec2 scaleVector;

        private Shape shape;

        public Builder(Shape shape) {
            this.shape = shape;
        }

        public Builder setTranslateVector(Vec2 translateVector) {
            this.translateVector = translateVector;
            this.translate = true;

            return this;
        }

        public Builder setRotate(Vec2 rotateCenter, double rotateAngle) {
            this.rotateCenter = rotateCenter;
            this.rotateAngle = rotateAngle;
            this.rotate = true;

            return this;
        }

        public Builder setScaleVector(Vec2 scaleVector) {
            this.scaleVector = scaleVector;
            this.scale = true;

            return this;
        }

        public TransformationDecorator build() {
            TransformationDecorator transformationDecorator = new TransformationDecorator(shape);

            if (transformationDecorator.translate) {
                transformationDecorator.translateVector = this.translateVector;
            }

            if (transformationDecorator.rotate) {
                transformationDecorator.rotateCenter = this.rotateCenter;
                transformationDecorator.rotateAngle = this.rotateAngle;
            }

            if (transformationDecorator.scale) {
                transformationDecorator.scaleVector = this.scaleVector;
            }

            return transformationDecorator;
        }
    }
}
