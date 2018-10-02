import java.io.InputStream;

public class Main {

    public static void main(String[] args) {
        // write your code here
        InputLayer layer = new InputLayer(System.in);
        Tissue map = layer.DetectInout();
        map.tern_up(layer);
        map.print();
    }
}
