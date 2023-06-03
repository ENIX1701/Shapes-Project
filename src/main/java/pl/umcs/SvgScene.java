package pl.umcs;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SvgScene {
    private List<Polygon> polygons;
    private Shape[] shapes;

    public Shape[] getShapes() {
        return shapes;
    }

    public void setShapes(Shape[] shapes) {
        this.shapes = shapes;
    }

    public SvgScene() {
        polygons = new ArrayList<Polygon>();
    }

    public void addPolygon(Polygon polygon) {
        this.polygons.add(polygon);
    }

    public void save(String path) {
        FileWriter fileToWrite;

        try {
            fileToWrite = new FileWriter(path);

            for (Polygon polygon : polygons) {
                fileToWrite.write(polygon.toSvg());
            }
            fileToWrite.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}