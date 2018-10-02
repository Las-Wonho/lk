import com.google.gson.*;
import com.sun.xml.internal.bind.AnyTypeAdapter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        String _json = "";

        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(_json);
        Map<String, _Any> json;
        json = new HashMap<>();
        Json_Parse.parse(json, element.getAsJsonObject());

    }


}
