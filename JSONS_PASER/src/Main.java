import com.google.gson.*;
import com.sun.xml.internal.bind.AnyTypeAdapter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // write your code here
        String _json = "{\n" +
                "  \"name\": \"Shuvi\",\n" +
                "  \"version\": \"0.0.1\",\n" +
                "  \"description\": \"Electron製のYouTubeプレイヤー「Shuvi」\",\n" +
                "  \"main\": \"src/bin/js/bin.js\",\n" +
                "  \"scripts\": {\n" +
                "    \"start\": \"electron .\",\n" +
                "    \"build\": \"gulp\",\n" +
                "    \"watch\": \"gulp watch\",\n" +
                "    \"package:mac\": \"electron-packager . Shuvi --out=__release__ --platform=darwin --arch=x64 --icon=icons/icon.icns --overwrite\",\n" +
                "    \"package:win\": \"electron-packager . Shuvi --out=__release__ --platform=win32 --arch=x64 --icon=icons/icon.ico --overwrite\",\n" +
                "    \"package:linux\": \"electron-packager . Shuvi --out=__release__ --platform=linux --arch=x64 --icon=icons/icon.icns --overwrite\"\n" +
                "  }\n"+
                "  }";
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(_json);



        Map<String, _Any> json;
        json = new HashMap<>();
        parse(json,element.getAsJsonObject());

        System.out.println(json.get("version").get_string());
        System.out.println(json.get("name").get_string());
        System.out.println(json.get("scripts").get_json_Array().get("start").get_string());

    }
    static void parse(Map<String,_Any> json,JsonElement e,String s){
        if(e.isJsonPrimitive()){
            try {
                json.put(s,new _Any(e.getAsJsonPrimitive().getAsInt()));
            }catch (NumberFormatException r){
                json.put(s,new _Any(e.getAsJsonPrimitive().getAsString()));
            }
        }
        if(e.isJsonObject()){
            json.put(s,new _Any(new HashMap<String, _Any>()));

            parse(json.get(s).get_json_Array(),e.getAsJsonObject());
        }
    }
    static void parse(Map<String,_Any> json,JsonObject j){
        j.entrySet().iterator().forEachRemaining(stringJsonElementEntry -> {parse(json,stringJsonElementEntry.getValue(),stringJsonElementEntry.getKey());});

    }
}
