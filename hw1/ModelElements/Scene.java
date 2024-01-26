import java.util.ArrayList;
import java.util.List;

public class Scene {
    public int id;
    public List<PoligonalModel> models = new ArrayList<>();
    public List<Flash> flashes = new ArrayList<>();
    public List<Camera> cameras = new ArrayList<>();

    public Scene(List<PoligonalModel> models, List<Flash> flashes, List<Camera> cameras) throws Exception {
        if (models.isEmpty() || flashes.isEmpty() || cameras.isEmpty()) {
            throw new Exception("Объект не может быть создан");
        }
        this.models = models;
        this.flashes = flashes;
        this.cameras = cameras;
    }

    public <T> T method1(T arg) {
        return arg;
    }

    public <T, E> T method2(T arg1, E arg2) {
        return arg1;
    }
}
