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
                "  \"arrays\": [1,2,3,4],\n" +
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
        System.out.println(json.get("arrays").get_json_Array().get("1").get_int());

        System.out.println(json.get("scripts").get_json_Array().get("start").get_string());

    }
    static void parse(Map<String,_Any> json,JsonElement e,String s){
        if(e.isJsonPrimitive()){
            JsonPrimitive jsonPrimitive = e.getAsJsonPrimitive();
            if(jsonPrimitive.isNumber()) {
                json.put(s,new _Any(e.getAsJsonPrimitive().getAsInt()));
            }else if(jsonPrimitive.isString()){
                json.put(s,new _Any(e.getAsJsonPrimitive().getAsString()));
            }else if(jsonPrimitive.isBoolean()){
                json.put(s,new _Any(e.getAsJsonPrimitive().getAsBoolean()));
            }
        }
        if(e.isJsonObject()){
            json.put(s,new _Any(new HashMap<String, _Any>()));

            parse(json.get(s).get_json_Array(),e.getAsJsonObject());
        }
        if(e.isJsonArray()){
            json.put(s,new _Any(new HashMap<String, _Any>()));
            JsonArray j = e.getAsJsonArray();
            for (int i = 0; i < j.size(); i++) {
                parse(json, j.get(i),String.valueOf(i));
            }
        }
    }
    static void parse(Map<String,_Any> json,JsonObject j){
        j.entrySet().iterator().forEachRemaining(stringJsonElementEntry -> {parse(json,stringJsonElementEntry.getValue(),stringJsonElementEntry.getKey());});

    }
}
