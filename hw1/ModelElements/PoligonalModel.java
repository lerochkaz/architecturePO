import java.util.ArrayList;
import java.util.List;

public class PoligonalModel {
    public List<Poligon> poligons;
    public List<Texture> textures = new ArrayList<>();

    public PoligonalModel(List<Texture> textures) {
        this.poligons = new ArrayList<>();
        this.textures = textures;
    }
}