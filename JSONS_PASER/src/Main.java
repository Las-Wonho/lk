import com.google.gson.*;
import com.sun.xml.internal.bind.AnyTypeAdapter;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Any json = new Any();
        json.setValue("name","Shuvi")
        .setValue("version","0.0.1")
        .setValue("description","Electron製のYouTubeプレイヤー「Shuvi」");
        System.out.println(json.json_value.get("name").string_value);
    }
}
